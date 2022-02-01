package com.tencent.mobileqq.highway.codec;

import android.os.SystemClock;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.DataHighwayHead;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.ReqDataHighwayHead;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.RspDataHighwayHead;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.SegHead;
import com.tencent.mobileqq.highway.segment.HwRequest;
import com.tencent.mobileqq.highway.segment.HwResponse;
import com.tencent.mobileqq.highway.utils.BdhLogUtil;
import com.tencent.mobileqq.highway.utils.BdhUtils;
import com.tencent.mobileqq.highway.utils.EndPoint;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.MsfSocketInputBuffer;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.HttpException;

public class TcpProtocolDataCodec
{
  private static final int ETX_C = 41;
  public static final int MAX_PKG_SIZE = 1048576;
  private static final int PROTO_COSNST_LEN = 10;
  private static final int STX_C = 40;
  private static final int VERSION_CODE = 1;
  private static final int appid = 4660;
  protected IProtocolCodecListener codecListener;
  protected byte[] revData;
  
  private int decodePackage(byte[] paramArrayOfByte, List<HwResponse> paramList)
  {
    int i = paramArrayOfByte.length;
    if ((i == 0) || (i < 10)) {
      return 0;
    }
    if (i > 1048576)
    {
      BdhLogUtil.LogEvent("N", "Decode Error : BufLen > MAX_PKG_SIZE");
      if (this.codecListener != null) {
        this.codecListener.onDecodeInvalidData(1);
      }
      return 0;
    }
    if (paramArrayOfByte[0] != 40)
    {
      BdhLogUtil.LogEvent("N", "Decode Error : revData[0] != STX_C");
      if (this.codecListener != null) {
        this.codecListener.onDecodeInvalidData(2);
      }
      return 0;
    }
    int k = (int)BdhUtils.getLongData(paramArrayOfByte, 1);
    int m = 1 + 4;
    i = (int)BdhUtils.getLongData(paramArrayOfByte, m);
    int j = k + 10 + i;
    if (paramArrayOfByte.length < j) {
      return 0;
    }
    Object localObject2 = new byte[k];
    Object localObject1 = new byte[i];
    BdhUtils.copyData((byte[])localObject2, 0, paramArrayOfByte, m + 4, k);
    k += 9;
    BdhUtils.copyData((byte[])localObject1, 0, paramArrayOfByte, k, i);
    i = k + i;
    if (paramArrayOfByte[i] != 41)
    {
      if (this.codecListener != null) {
        this.codecListener.onDecodeInvalidData(2);
      }
      return 0;
    }
    i = 1;
    CSDataHighwayHead.RspDataHighwayHead localRspDataHighwayHead = new CSDataHighwayHead.RspDataHighwayHead();
    try
    {
      localRspDataHighwayHead.mergeFrom((byte[])localObject2);
      if (i == 0)
      {
        if (this.codecListener != null) {
          this.codecListener.onDecodeInvalidData(2);
        }
        return 0;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        i = 0;
      }
      paramArrayOfByte = (CSDataHighwayHead.DataHighwayHead)localRspDataHighwayHead.msg_basehead.get();
      localObject2 = new HwResponse();
      ((HwResponse)localObject2).hwSeq = paramArrayOfByte.uint32_seq.get();
      ((HwResponse)localObject2).retCode = localRspDataHighwayHead.uint32_error_code.get();
      ((HwResponse)localObject2).mRespData = ((byte[])localObject1);
      ((HwResponse)localObject2).mBuExtendinfo = localRspDataHighwayHead.bytes_rsp_extendinfo.get().toByteArray();
      ((HwResponse)localObject2).recvTime = SystemClock.uptimeMillis();
      localObject1 = paramArrayOfByte.bytes_command.get().toByteArray();
      paramArrayOfByte = null;
    }
    try
    {
      localObject1 = new String((byte[])localObject1, "utf-8");
      paramArrayOfByte = (byte[])localObject1;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      for (;;)
      {
        localUnsupportedEncodingException.printStackTrace();
        continue;
        boolean bool = false;
        continue;
        bool = false;
      }
    }
    ((HwResponse)localObject2).cmd = paramArrayOfByte;
    if (localRspDataHighwayHead.uint32_htcost.has()) {
      ((HwResponse)localObject2).htCost = localRspDataHighwayHead.uint32_htcost.get();
    }
    if (localRspDataHighwayHead.uint32_cachecost.has()) {
      ((HwResponse)localObject2).cacheCost = localRspDataHighwayHead.uint32_cachecost.get();
    }
    if (localRspDataHighwayHead.uint32_allow_retry.has())
    {
      if (localRspDataHighwayHead.uint32_allow_retry.get() == 1)
      {
        bool = true;
        ((HwResponse)localObject2).shouldRetry = bool;
      }
    }
    else
    {
      if (localRspDataHighwayHead.msg_seghead.has())
      {
        paramArrayOfByte = (CSDataHighwayHead.SegHead)localRspDataHighwayHead.msg_seghead.get();
        ((HwResponse)localObject2).segmentResp = paramArrayOfByte;
        ((HwResponse)localObject2).buzRetCode = paramArrayOfByte.uint32_rtcode.get();
        if ((paramArrayOfByte.uint32_flag.get() & 0x1) != 1) {
          break label540;
        }
        bool = true;
        ((HwResponse)localObject2).isFinish = bool;
      }
      ((HwResponse)localObject2).respLength = j;
      paramList.add(localObject2);
      return j;
    }
  }
  
  protected boolean decodeS2CData(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length <= 0)) {}
    do
    {
      return false;
      int i;
      byte[] arrayOfByte;
      if (this.revData != null)
      {
        i = this.revData.length;
        arrayOfByte = new byte[paramArrayOfByte.length + i];
        BdhUtils.copyData(arrayOfByte, 0, this.revData, 0, i);
        BdhUtils.copyData(arrayOfByte, i, paramArrayOfByte, 0, paramArrayOfByte.length);
      }
      for (this.revData = arrayOfByte;; this.revData = paramArrayOfByte)
      {
        paramArrayOfByte = new ArrayList();
        for (;;)
        {
          i = decodePackage(this.revData, paramArrayOfByte);
          if (i <= 0) {
            break;
          }
          arrayOfByte = new byte[this.revData.length - i];
          BdhUtils.copyData(arrayOfByte, 0, this.revData, i, this.revData.length - i);
          this.revData = arrayOfByte;
        }
      }
    } while (paramArrayOfByte.size() <= 0);
    if (this.codecListener != null) {
      this.codecListener.onDecodeSucessfully(paramArrayOfByte);
    }
    return true;
  }
  
  public byte[] encodeC2SData(EndPoint paramEndPoint, HwRequest paramHwRequest, byte[] paramArrayOfByte)
  {
    paramEndPoint = null;
    Object localObject1 = null;
    int i = 0;
    if (paramArrayOfByte != null) {
      i = paramArrayOfByte.length;
    }
    try
    {
      localObject2 = paramHwRequest.account.getBytes("utf-8");
      paramEndPoint = (EndPoint)localObject2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException1)
    {
      for (;;)
      {
        Object localObject2;
        label45:
        CSDataHighwayHead.DataHighwayHead localDataHighwayHead;
        int j;
        localUnsupportedEncodingException1.printStackTrace();
      }
    }
    try
    {
      localObject2 = paramHwRequest.hwCmd.getBytes("utf-8");
      localObject1 = localObject2;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException2)
    {
      localUnsupportedEncodingException2.printStackTrace();
      break label45;
    }
    localObject2 = paramHwRequest.getSegmentHead();
    localDataHighwayHead = new CSDataHighwayHead.DataHighwayHead();
    localDataHighwayHead.uint32_appid.set(4660);
    localDataHighwayHead.uint32_seq.set(paramHwRequest.getHwSeq());
    localDataHighwayHead.uint32_version.set(1);
    localDataHighwayHead.uint32_dataflag.set(paramHwRequest.dataFlag);
    localDataHighwayHead.uint32_retry_times.set(paramHwRequest.retryCount);
    localDataHighwayHead.bytes_uin.set(ByteStringMicro.copyFrom(paramEndPoint));
    localDataHighwayHead.bytes_command.set(ByteStringMicro.copyFrom((byte[])localObject1));
    localDataHighwayHead.uint32_command_id.set(paramHwRequest.mBuCmdId);
    paramEndPoint = new CSDataHighwayHead.ReqDataHighwayHead();
    paramEndPoint.msg_basehead.set(localDataHighwayHead);
    if (localObject2 != null) {
      paramEndPoint.msg_seghead.set((MessageMicro)localObject2);
    }
    paramEndPoint = paramEndPoint.toByteArray();
    localObject1 = new byte[paramEndPoint.length + 10 + i];
    paramHwRequest.bodyLength = i;
    paramHwRequest.headLength = (paramEndPoint.length + 10);
    localObject1[0] = 40;
    j = 0 + 1;
    BdhUtils.DWord2Byte((byte[])localObject1, j, paramEndPoint.length);
    j += 4;
    BdhUtils.DWord2Byte((byte[])localObject1, j, i);
    BdhUtils.copyData((byte[])localObject1, j + 4, paramEndPoint, 0, paramEndPoint.length);
    j = paramEndPoint.length + 9;
    if (i != 0) {
      BdhUtils.copyData((byte[])localObject1, j, paramArrayOfByte, 0, i);
    }
    localObject1[(localObject1.length - 1)] = 41;
    return localObject1;
  }
  
  public void onRecvData(MsfSocketInputBuffer paramMsfSocketInputBuffer)
    throws IOException, HttpException
  {
    byte[] arrayOfByte = new byte[paramMsfSocketInputBuffer.getBufferlen()];
    System.arraycopy(paramMsfSocketInputBuffer.getBuffer(), 0, arrayOfByte, 0, arrayOfByte.length);
    decodeS2CData(arrayOfByte);
  }
  
  public void setProtocolCodecListener(IProtocolCodecListener paramIProtocolCodecListener)
  {
    this.codecListener = paramIProtocolCodecListener;
  }
  
  public static abstract interface DataFlag
  {
    public static final int FLAG_NORMAL = 4096;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.highway.codec.TcpProtocolDataCodec
 * JD-Core Version:    0.7.0.1
 */
package com.weiyun.sdk.job.af.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;
import com.weiyun.sdk.channel.ISender;
import com.weiyun.sdk.context.SdkContext;
import com.weiyun.sdk.job.af.AddressFetcher.DownloadAddress;
import com.weiyun.sdk.job.af.AddressFetcher.FetchAddressException;
import com.weiyun.sdk.job.af.AddressFetcher.OfflineFileDownloadAddress;
import com.weiyun.sdk.job.af.DownloadAddressFetcher;
import com.weiyun.sdk.log.Log;
import com.weiyun.sdk.log.LogTag;
import com.weiyun.sdk.protocol.BaseCallback;
import com.weiyun.sdk.util.UtilsMisc;
import tencent.im.cs.cmd0x31b.Cmd0X31B.ApplyOfflineFileDownloadReq;
import tencent.im.cs.cmd0x31b.Cmd0X31B.ApplyOfflineFileDownloadRsp;
import tencent.im.cs.cmd0x31b.Cmd0X31B.OFDownloadInfo;
import tencent.im.cs.cmd0x31b.Cmd0X31B.ReqBody;

public class PbOfflineFileAddressFetcher
  extends DownloadAddressFetcher
{
  public static final int REQUEST_TYPE_RECV = 2;
  public static final int REQUEST_TYPE_SEND = 1;
  protected final int mOfflineFileType;
  
  public PbOfflineFileAddressFetcher(long paramLong, String paramString, int paramInt)
  {
    super(paramLong, paramString, null, null, null);
    this.mOfflineFileType = paramInt;
  }
  
  protected AddressFetcher.DownloadAddress createDownloadAddress(String paramString1, int paramInt, String paramString2, String paramString3)
  {
    return new AddressFetcher.OfflineFileDownloadAddress(paramString1, paramInt, paramString3, paramString2);
  }
  
  void handleResponse(int paramInt, String paramString, Cmd0X31B.ApplyOfflineFileDownloadRsp paramApplyOfflineFileDownloadRsp)
  {
    if ((paramInt != 0) || (paramApplyOfflineFileDownloadRsp == null) || (paramApplyOfflineFileDownloadRsp.msg_of_download_info.get() == null))
    {
      failedGetAddress(new AddressFetcher.FetchAddressException(paramInt, paramString));
      if (LogTag.NeedSpecialLog()) {
        Log.w("FM-TransferFile", "get download address failed. error code: " + paramInt);
      }
      return;
    }
    paramString = (Cmd0X31B.OFDownloadInfo)paramApplyOfflineFileDownloadRsp.msg_of_download_info.get();
    paramApplyOfflineFileDownloadRsp = UtilsMisc.hexStringToByteArrayFromByteArray(paramString.bytes_download_key.get().toByteArray());
    successGetAddress(createDownloadAddress(paramString.str_download_domain.get(), paramString.uint32_port.get(), paramString.str_download_ip.get(), paramApplyOfflineFileDownloadRsp));
  }
  
  protected int sendRequest()
  {
    Cmd0X31B.ApplyOfflineFileDownloadReq localApplyOfflineFileDownloadReq = new Cmd0X31B.ApplyOfflineFileDownloadReq();
    localApplyOfflineFileDownloadReq.uint64_uin.set(this.mUin);
    localApplyOfflineFileDownloadReq.bytes_uuid.set(ByteStringMicro.copyFromUtf8(this.mFileId));
    localApplyOfflineFileDownloadReq.uint32_owner_type.set(this.mOfflineFileType);
    Cmd0X31B.ReqBody localReqBody = new Cmd0X31B.ReqBody();
    localReqBody.uint32_sub_cmd.set(258);
    localReqBody.str_app_id.set("30223");
    localReqBody.msg_apply_offline_file_download_req.set(localApplyOfflineFileDownloadReq);
    if (SdkContext.getInstance().getSender().sendRequest("OfflineFilleHandleSvr.pb_weiyun_CMD_REQ_OFFLINE_FILE_DOWNLOAD-258", localReqBody.toByteArray(), new OfflineFileDownloadRequestCallback(null)) == true) {
      return 0;
    }
    return -10011;
  }
  
  private class OfflineFileDownloadRequestCallback
    extends BaseCallback<Cmd0X31B.ApplyOfflineFileDownloadRsp>
  {
    private OfflineFileDownloadRequestCallback() {}
    
    protected void handleResponse(IWyFileSystem.WyErrorStatus paramWyErrorStatus, Cmd0X31B.ApplyOfflineFileDownloadRsp paramApplyOfflineFileDownloadRsp)
    {
      PbOfflineFileAddressFetcher.this.handleResponse(paramWyErrorStatus.errorCode, paramWyErrorStatus.errorMsg, paramApplyOfflineFileDownloadRsp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.af.pb.PbOfflineFileAddressFetcher
 * JD-Core Version:    0.7.0.1
 */
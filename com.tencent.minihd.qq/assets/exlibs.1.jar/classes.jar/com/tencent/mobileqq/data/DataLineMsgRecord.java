package com.tencent.mobileqq.data;

import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBFixed32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import com.tencent.mobileqq.util.Utils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import localpb.dataline.DatalineMsgData.MsgData;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="time,msgid")
public class DataLineMsgRecord
  extends MessageRecord
  implements Cloneable
{
  public static final int APP_STATUS_INSTALLED = 1;
  public static final int APP_STATUS_NONE = 0;
  public static final int DATALINE_MSG_VERSION_CODE = 104;
  public static final int FILE_MSG_STATUS_COMING = 1;
  public static final int FILE_MSG_STATUS_NONE = 0;
  public static final int FILE_MSG_STATUS_PAUSED = 2;
  public static final int MSG_TYPE_DATALINE_APP = -2335;
  public static final int MSG_TYPE_DATALINE_FILE = -2005;
  public static final int MSG_TYPE_DATALINE_GRAY = -5000;
  public static final int MSG_TYPE_DATALINE_PIC = -2000;
  public static final int MSG_TYPE_DATALINE_PROMPT = -2334;
  public static final int MSG_TYPE_DATALINE_TEXT = -1000;
  public static final int MSG_TYPE_DATALINE_VIDEO = -2009;
  @notColumn
  public boolean bIsApkFile;
  @notColumn
  public boolean bIsMoloImage;
  @notColumn
  public boolean bIsResendOrRecvFile = false;
  @notColumn
  public long entityID;
  @notColumn
  public int fileFrom = 0;
  @notColumn
  public long fileMsgStatus;
  @notColumn
  public String fileUuid;
  public String filename;
  public long filesize;
  public int groupId;
  public int groupIndex;
  public int groupSize;
  @notColumn
  public boolean isReportPause = false;
  public boolean issuc;
  public byte[] md5;
  @notColumn
  public int nAppStatus;
  @notColumn
  public int nOpType = -1;
  @notColumn
  public long nServerIp;
  @notColumn
  public long nServerPort;
  @notColumn
  public long nWeiyunSessionId = 0L;
  public String path;
  public float progress;
  public String serverPath;
  public long sessionid;
  @notColumn
  public String strMoloIconUrl;
  @notColumn
  public String strMoloKey;
  @notColumn
  public String strMoloSource;
  @notColumn
  public String strMoloSrcIconUrl;
  public String thumbPath;
  @notColumn
  public long uOwnerUin;
  @notColumn
  public byte[] vTokenKey;
  @notColumn
  public byte[] vUrlNotify;
  
  public DataLineMsgRecord()
  {
    this.selfuin = String.valueOf(AppConstants.Y);
    this.frienduin = this.selfuin;
    this.senderuin = this.selfuin;
    this.istroop = 6000;
    this.versionCode = 106;
  }
  
  public static String getSqlStatment(String paramString, int paramInt)
  {
    String str = tableName();
    paramString = new StringBuilder();
    paramString.append("select * from " + str);
    paramString.append(" order by _id desc limit 60");
    str = paramString.toString();
    paramString.delete(0, paramString.length());
    paramString.append("select * from (" + str + ") order by _id asc");
    return paramString.toString();
  }
  
  public static byte[] longToByte(long paramLong)
  {
    return new byte[] { (byte)(int)paramLong, (byte)(int)(paramLong >> 8), (byte)(int)(paramLong >> 16), (byte)(int)(paramLong >> 24), (byte)(int)(paramLong >> 32), (byte)(int)(paramLong >> 40), (byte)(int)(paramLong >> 48), (byte)(int)(paramLong >> 56) };
  }
  
  public static byte[] packMsgData(DataLineMsgRecord paramDataLineMsgRecord, int paramInt)
  {
    int i = 1;
    if ((paramDataLineMsgRecord.msg == null) || (paramInt == 106)) {}
    try
    {
      localObject1 = new DatalineMsgData.MsgData();
      ((DatalineMsgData.MsgData)localObject1).str_msg.set(paramDataLineMsgRecord.msg);
      ((DatalineMsgData.MsgData)localObject1).uint64_filemsgstatus.set(paramDataLineMsgRecord.fileMsgStatus);
      ((DatalineMsgData.MsgData)localObject1).uint64_weiyunsessionid.set(paramDataLineMsgRecord.nWeiyunSessionId);
      if (paramDataLineMsgRecord.strMoloKey != null) {
        ((DatalineMsgData.MsgData)localObject1).str_molokey.set(paramDataLineMsgRecord.strMoloKey);
      }
      if (paramDataLineMsgRecord.strMoloIconUrl != null) {
        ((DatalineMsgData.MsgData)localObject1).str_moloiconurl.set(paramDataLineMsgRecord.strMoloIconUrl);
      }
      if (paramDataLineMsgRecord.strMoloSource != null) {
        ((DatalineMsgData.MsgData)localObject1).str_molosource.set(paramDataLineMsgRecord.strMoloSource);
      }
      if (paramDataLineMsgRecord.strMoloSrcIconUrl != null) {
        ((DatalineMsgData.MsgData)localObject1).str_molosrcurl.set(paramDataLineMsgRecord.strMoloSrcIconUrl);
      }
      ((DatalineMsgData.MsgData)localObject1).fixed32_ip.set((int)paramDataLineMsgRecord.nServerIp);
      ((DatalineMsgData.MsgData)localObject1).uint32_port.set((int)paramDataLineMsgRecord.nServerPort);
      if (paramDataLineMsgRecord.vUrlNotify != null) {
        ((DatalineMsgData.MsgData)localObject1).bytes_url_notify.set(ByteStringMicro.copyFrom(paramDataLineMsgRecord.vUrlNotify));
      }
      if (paramDataLineMsgRecord.vTokenKey != null) {
        ((DatalineMsgData.MsgData)localObject1).bytes_tokenkey.set(ByteStringMicro.copyFrom(paramDataLineMsgRecord.vTokenKey));
      }
      localObject2 = ((DatalineMsgData.MsgData)localObject1).uint32_isapkfile;
      if (!paramDataLineMsgRecord.bIsApkFile) {
        break label474;
      }
      paramInt = 1;
    }
    catch (UnsupportedEncodingException paramDataLineMsgRecord)
    {
      for (;;)
      {
        try
        {
          Object localObject1;
          Object localObject2;
          ((ByteArrayOutputStream)localObject1).write(longToByte(paramDataLineMsgRecord.fileMsgStatus));
          ((ByteArrayOutputStream)localObject1).write(longToByte(paramDataLineMsgRecord.nWeiyunSessionId));
          ((ByteArrayOutputStream)localObject1).write(paramDataLineMsgRecord.msg.getBytes("UTF-8"));
          paramDataLineMsgRecord.msgData = ((byte[])((ByteArrayOutputStream)localObject1).toByteArray().clone());
          ((ByteArrayOutputStream)localObject1).close();
          return null;
          if (paramInt == 104)
          {
            localObject1 = longToByte(paramDataLineMsgRecord.fileMsgStatus);
            localObject2 = paramDataLineMsgRecord.msg.getBytes("UTF-8");
            paramDataLineMsgRecord.msgData = new byte[localObject2.length + 8];
            System.arraycopy(localObject1, 0, paramDataLineMsgRecord.msgData, 0, localObject1.length);
            System.arraycopy(localObject2, 0, paramDataLineMsgRecord.msgData, localObject1.length, localObject2.length);
            continue;
            paramDataLineMsgRecord = paramDataLineMsgRecord;
            paramDataLineMsgRecord.printStackTrace();
            continue;
          }
          if (paramInt <= 0) {
            continue;
          }
          paramDataLineMsgRecord.msgData = paramDataLineMsgRecord.msg.getBytes("UTF-8");
          continue;
        }
        catch (IOException paramDataLineMsgRecord)
        {
          continue;
        }
        paramInt = 0;
        continue;
        paramInt = 0;
      }
    }
    ((PBUInt32Field)localObject2).set(paramInt);
    localObject2 = ((DatalineMsgData.MsgData)localObject1).uint32_ismoloimage;
    if (paramDataLineMsgRecord.bIsMoloImage)
    {
      paramInt = i;
      ((PBUInt32Field)localObject2).set(paramInt);
      ((DatalineMsgData.MsgData)localObject1).uint32_fileFrom.set(paramDataLineMsgRecord.fileFrom);
      if (paramDataLineMsgRecord.fileUuid != null) {
        ((DatalineMsgData.MsgData)localObject1).str_fileUuid.set(paramDataLineMsgRecord.fileUuid);
      }
      ((DatalineMsgData.MsgData)localObject1).uint32_nOpType.set(paramDataLineMsgRecord.nOpType);
      ((DatalineMsgData.MsgData)localObject1).uint64_entityID.set(paramDataLineMsgRecord.entityID);
      ((DatalineMsgData.MsgData)localObject1).uint64_OwnerUin.set(paramDataLineMsgRecord.uOwnerUin);
      return ((DatalineMsgData.MsgData)localObject1).toByteArray();
      if (paramInt == 105) {
        localObject1 = new ByteArrayOutputStream();
      }
    }
  }
  
  public static String tableName()
  {
    return "mr_data_line";
  }
  
  public static void unpackMsgData(DataLineMsgRecord paramDataLineMsgRecord, byte[] paramArrayOfByte, int paramInt)
  {
    boolean bool2 = true;
    long l2 = 0L;
    Object localObject1 = null;
    int i = 0;
    if (paramInt == 106) {}
    for (;;)
    {
      Object localObject2;
      try
      {
        localObject2 = new DatalineMsgData.MsgData();
        try
        {
          ((DatalineMsgData.MsgData)localObject2).mergeFrom(paramArrayOfByte);
          if (((DatalineMsgData.MsgData)localObject2).str_msg.has())
          {
            paramArrayOfByte = ((DatalineMsgData.MsgData)localObject2).str_msg.get();
            paramDataLineMsgRecord.msg = paramArrayOfByte;
            if (!((DatalineMsgData.MsgData)localObject2).uint64_filemsgstatus.has()) {
              break label735;
            }
            l1 = ((DatalineMsgData.MsgData)localObject2).uint64_filemsgstatus.get();
            paramDataLineMsgRecord.fileMsgStatus = l1;
            if (!((DatalineMsgData.MsgData)localObject2).uint64_weiyunsessionid.has()) {
              break label741;
            }
            l1 = ((DatalineMsgData.MsgData)localObject2).uint64_weiyunsessionid.get();
            paramDataLineMsgRecord.nWeiyunSessionId = l1;
            if (!((DatalineMsgData.MsgData)localObject2).str_molokey.has()) {
              break label747;
            }
            paramArrayOfByte = ((DatalineMsgData.MsgData)localObject2).str_molokey.get();
            paramDataLineMsgRecord.strMoloKey = paramArrayOfByte;
            if (!((DatalineMsgData.MsgData)localObject2).str_moloiconurl.has()) {
              break label752;
            }
            paramArrayOfByte = ((DatalineMsgData.MsgData)localObject2).str_moloiconurl.get();
            paramDataLineMsgRecord.strMoloIconUrl = paramArrayOfByte;
            if (!((DatalineMsgData.MsgData)localObject2).str_molosource.has()) {
              break label757;
            }
            paramArrayOfByte = ((DatalineMsgData.MsgData)localObject2).str_molosource.get();
            paramDataLineMsgRecord.strMoloSource = paramArrayOfByte;
            if (!((DatalineMsgData.MsgData)localObject2).str_molosrcurl.has()) {
              break label762;
            }
            paramArrayOfByte = ((DatalineMsgData.MsgData)localObject2).str_molosrcurl.get();
            paramDataLineMsgRecord.strMoloSrcIconUrl = paramArrayOfByte;
            if (!((DatalineMsgData.MsgData)localObject2).uint32_isapkfile.has()) {
              break label773;
            }
            if (((DatalineMsgData.MsgData)localObject2).uint32_isapkfile.get() != 1) {
              break label767;
            }
            bool1 = true;
            paramDataLineMsgRecord.bIsApkFile = bool1;
            if (!((DatalineMsgData.MsgData)localObject2).fixed32_ip.has()) {
              break label779;
            }
            l1 = ((DatalineMsgData.MsgData)localObject2).fixed32_ip.get();
            paramDataLineMsgRecord.nServerIp = l1;
            if (!((DatalineMsgData.MsgData)localObject2).uint32_port.has()) {
              break label785;
            }
            l1 = ((DatalineMsgData.MsgData)localObject2).uint32_port.get();
            paramDataLineMsgRecord.nServerPort = l1;
            if (!((DatalineMsgData.MsgData)localObject2).bytes_url_notify.has()) {
              break label791;
            }
            paramArrayOfByte = ((DatalineMsgData.MsgData)localObject2).bytes_url_notify.get().toByteArray();
            paramDataLineMsgRecord.vUrlNotify = paramArrayOfByte;
            if (!((DatalineMsgData.MsgData)localObject2).bytes_tokenkey.has()) {
              break label796;
            }
            paramArrayOfByte = ((DatalineMsgData.MsgData)localObject2).bytes_tokenkey.get().toByteArray();
            paramDataLineMsgRecord.vTokenKey = paramArrayOfByte;
            if (!((DatalineMsgData.MsgData)localObject2).uint32_ismoloimage.has()) {
              break label807;
            }
            if (((DatalineMsgData.MsgData)localObject2).uint32_ismoloimage.get() != 1) {
              break label801;
            }
            bool1 = bool2;
            paramDataLineMsgRecord.bIsMoloImage = bool1;
            paramInt = i;
            if (((DatalineMsgData.MsgData)localObject2).uint32_fileFrom.has()) {
              paramInt = ((DatalineMsgData.MsgData)localObject2).uint32_fileFrom.get();
            }
            paramDataLineMsgRecord.fileFrom = paramInt;
            paramArrayOfByte = (byte[])localObject1;
            if (((DatalineMsgData.MsgData)localObject2).str_fileUuid.has()) {
              paramArrayOfByte = ((DatalineMsgData.MsgData)localObject2).str_fileUuid.get();
            }
            paramDataLineMsgRecord.fileUuid = paramArrayOfByte;
            if (!((DatalineMsgData.MsgData)localObject2).uint32_nOpType.has()) {
              break label813;
            }
            paramInt = ((DatalineMsgData.MsgData)localObject2).uint32_nOpType.get();
            paramDataLineMsgRecord.nOpType = paramInt;
            if (!((DatalineMsgData.MsgData)localObject2).uint64_entityID.has()) {
              break label818;
            }
            l1 = ((DatalineMsgData.MsgData)localObject2).uint64_entityID.get();
            paramDataLineMsgRecord.entityID = l1;
            l1 = l2;
            if (((DatalineMsgData.MsgData)localObject2).uint64_OwnerUin.has()) {
              l1 = ((DatalineMsgData.MsgData)localObject2).uint64_OwnerUin.get();
            }
            paramDataLineMsgRecord.uOwnerUin = l1;
            return;
          }
        }
        catch (InvalidProtocolBufferMicroException paramDataLineMsgRecord)
        {
          paramDataLineMsgRecord.printStackTrace();
          return;
        }
        paramArrayOfByte = "";
      }
      catch (UnsupportedEncodingException paramDataLineMsgRecord)
      {
        paramDataLineMsgRecord.printStackTrace();
        return;
      }
      continue;
      if (paramInt == 105)
      {
        localObject2 = new byte[8];
        localObject1 = new ByteArrayInputStream(paramArrayOfByte);
        try
        {
          ((ByteArrayInputStream)localObject1).read((byte[])localObject2);
          paramDataLineMsgRecord.fileMsgStatus = Utils.a((byte[])localObject2);
          ((ByteArrayInputStream)localObject1).read((byte[])localObject2);
          paramDataLineMsgRecord.nWeiyunSessionId = Utils.a((byte[])localObject2);
          paramArrayOfByte = new byte[paramArrayOfByte.length - 16];
          ((ByteArrayInputStream)localObject1).read(paramArrayOfByte);
          paramDataLineMsgRecord.msg = new String(paramArrayOfByte, "UTF-8");
          ((ByteArrayInputStream)localObject1).close();
          return;
        }
        catch (IOException paramDataLineMsgRecord)
        {
          return;
        }
      }
      if (paramInt == 104)
      {
        localObject1 = new byte[8];
        localObject2 = new byte[paramArrayOfByte.length - 8];
        System.arraycopy(paramArrayOfByte, 0, localObject1, 0, 8);
        System.arraycopy(paramArrayOfByte, 8, localObject2, 0, localObject2.length);
        paramDataLineMsgRecord.fileMsgStatus = Utils.a((byte[])localObject1);
        paramDataLineMsgRecord.msg = new String((byte[])localObject2, "UTF-8");
        return;
      }
      if (paramInt > 0)
      {
        paramDataLineMsgRecord.msg = new String(paramArrayOfByte, "UTF-8");
        paramDataLineMsgRecord.fileMsgStatus = 0L;
      }
      return;
      label735:
      long l1 = 0L;
      continue;
      label741:
      l1 = 0L;
      continue;
      label747:
      paramArrayOfByte = null;
      continue;
      label752:
      paramArrayOfByte = null;
      continue;
      label757:
      paramArrayOfByte = null;
      continue;
      label762:
      paramArrayOfByte = null;
      continue;
      label767:
      boolean bool1 = false;
      continue;
      label773:
      bool1 = false;
      continue;
      label779:
      l1 = 0L;
      continue;
      label785:
      l1 = 0L;
      continue;
      label791:
      paramArrayOfByte = null;
      continue;
      label796:
      paramArrayOfByte = null;
      continue;
      label801:
      bool1 = false;
      continue;
      label807:
      bool1 = false;
      continue;
      label813:
      paramInt = -1;
      continue;
      label818:
      l1 = 0L;
    }
  }
  
  public DataLineMsgRecord clone()
  {
    try
    {
      DataLineMsgRecord localDataLineMsgRecord = (DataLineMsgRecord)super.clone();
      return localDataLineMsgRecord;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      localCloneNotSupportedException.printStackTrace();
    }
    return null;
  }
  
  public void doPrewrite()
  {
    prewrite();
  }
  
  protected Class getClassForTable()
  {
    return DataLineMsgRecord.class;
  }
  
  public String getTableName()
  {
    return "mr_data_line";
  }
  
  protected void postRead()
  {
    unpackMsgData(this, this.msgData, this.versionCode);
  }
  
  protected void prewrite()
  {
    this.msgData = packMsgData(this, this.versionCode);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.DataLineMsgRecord
 * JD-Core Version:    0.7.0.1
 */
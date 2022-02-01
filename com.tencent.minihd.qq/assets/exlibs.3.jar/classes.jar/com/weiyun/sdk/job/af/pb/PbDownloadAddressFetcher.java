package com.weiyun.sdk.job.af.pb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;
import com.weiyun.sdk.channel.ISender;
import com.weiyun.sdk.context.SdkContext;
import com.weiyun.sdk.job.af.AddressFetcher.DownloadAddress;
import com.weiyun.sdk.job.af.AddressFetcher.FetchAddressException;
import com.weiyun.sdk.job.af.DownloadAddressFetcher;
import com.weiyun.sdk.log.Log;
import com.weiyun.sdk.log.LogTag;
import com.weiyun.sdk.protocol.BaseCallback;
import com.weiyun.sdk.util.UtilsMisc;
import tencent.im.cs.cmd0x31b.Cmd0X31B.DownloadFileReqBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.DownloadFileRspBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.ReqBody;

public class PbDownloadAddressFetcher
  extends DownloadAddressFetcher
{
  protected String mCloudMd5;
  protected final String mMd5;
  protected int mSource;
  
  public PbDownloadAddressFetcher(String paramString1, String paramString2)
  {
    super(0L, paramString1, null, paramString2, null);
    this.mSource = 0;
    this.mMd5 = null;
  }
  
  public PbDownloadAddressFetcher(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    super(0L, paramString1, null, paramString2, null);
    this.mSource = paramInt;
    this.mMd5 = paramString3;
  }
  
  public AddressFetcher.DownloadAddress createDownloadAddress(String paramString1, int paramInt, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    return new AddressFetcher.DownloadAddress(paramString1, paramInt, this.mFileName, paramString3, 30223, paramString4, paramString5);
  }
  
  public String getCloudMd5()
  {
    return this.mCloudMd5;
  }
  
  protected void handleResponse(int paramInt, String paramString, Cmd0X31B.DownloadFileRspBody paramDownloadFileRspBody)
  {
    if ((paramInt != 0) || (paramDownloadFileRspBody == null))
    {
      failedGetAddress(new AddressFetcher.FetchAddressException(paramInt, paramString));
      if (LogTag.NeedSpecialLog()) {
        Log.w("FM-TransferFile", "get download address failed. error code: " + paramInt);
      }
      return;
    }
    this.mCloudMd5 = paramDownloadFileRspBody.str_svr_file_md5.get();
    paramString = UtilsMisc.hexStringToByteArrayFromByteArray(paramDownloadFileRspBody.bytes_encrypt_url.get().toByteArray());
    successGetAddress(createDownloadAddress(paramDownloadFileRspBody.str_svr_host.get(), paramDownloadFileRspBody.uint32_port.get(), this.mFileName, paramString, paramDownloadFileRspBody.str_cookie_name.get(), paramDownloadFileRspBody.str_cookie_value.get()));
  }
  
  protected int sendRequest()
  {
    Cmd0X31B.DownloadFileReqBody localDownloadFileReqBody = new Cmd0X31B.DownloadFileReqBody();
    localDownloadFileReqBody.str_file_id.set(this.mFileId);
    localDownloadFileReqBody.str_file_name.set(this.mFileName);
    localDownloadFileReqBody.uint32_file_resource.set(this.mSource);
    if (this.mMd5 != null) {
      localDownloadFileReqBody.str_local_md5.set(this.mMd5);
    }
    Cmd0X31B.ReqBody localReqBody = new Cmd0X31B.ReqBody();
    localReqBody.uint32_sub_cmd.set(6);
    localReqBody.str_app_id.set("30223");
    localReqBody.msg_download_file_req_body.set(localDownloadFileReqBody);
    if (SdkContext.getInstance().getSender().sendRequest("OfflineFilleHandleSvr.pb_weiyun_CMD_REQ_DOWN_LOAD_FILE-6", localReqBody.toByteArray(), new DownloadFileRequestCallback()) == true) {
      return 0;
    }
    return -10011;
  }
  
  protected class DownloadFileRequestCallback
    extends BaseCallback<Cmd0X31B.DownloadFileRspBody>
  {
    protected DownloadFileRequestCallback() {}
    
    protected void handleResponse(IWyFileSystem.WyErrorStatus paramWyErrorStatus, Cmd0X31B.DownloadFileRspBody paramDownloadFileRspBody)
    {
      PbDownloadAddressFetcher.this.handleResponse(paramWyErrorStatus.errorCode, paramWyErrorStatus.errorMsg, paramDownloadFileRspBody);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.job.af.pb.PbDownloadAddressFetcher
 * JD-Core Version:    0.7.0.1
 */
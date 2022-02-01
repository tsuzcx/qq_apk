package com.weiyun.sdk.protocol;

import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.weiyun.sdk.IWyFileSystem.WyErrorStatus;
import com.weiyun.sdk.channel.ISender.ICallback;
import com.weiyun.sdk.context.SdkContext;
import com.weiyun.sdk.log.ILogger;
import com.weiyun.sdk.log.Log;
import com.weiyun.sdk.util.NetworkUtils;
import tencent.im.cs.cmd0x31b.Cmd0X31B.ApplyOfflineFileDownloadRsp;
import tencent.im.cs.cmd0x31b.Cmd0X31B.DeleteFileRspBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.DownloadFileRspBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.FilePreviewRspBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.GetLibListRspBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.GetLibTypeRspBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.GetOfflineFileRspBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.QCloud2FtnRspBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.QueryPwdRspBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.ResumeFileUploadRspBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.RspBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.StoreFilePreviewRspBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.Upload2QCloudRspBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.VerifyPwdRspBody;

public abstract class BaseCallback<T>
  implements ISender.ICallback
{
  private static final String TAG = "BaseCallback";
  
  protected abstract void handleResponse(IWyFileSystem.WyErrorStatus paramWyErrorStatus, T paramT);
  
  public final void onRespond(int paramInt, byte[] paramArrayOfByte)
  {
    if (paramInt != 0)
    {
      paramArrayOfByte = new IWyFileSystem.WyErrorStatus();
      paramArrayOfByte.errorCode = (paramInt + 3000);
      paramArrayOfByte.errorMsg = "数据发送失败!";
      Log.w("BaseCallback", "send command failed return:" + paramInt);
      if (!NetworkUtils.hasInternet(SdkContext.getInstance().getContext())) {
        paramArrayOfByte.errorCode = -10003;
      }
      handleResponse(paramArrayOfByte, null);
      return;
    }
    if (paramArrayOfByte == null)
    {
      paramArrayOfByte = new IWyFileSystem.WyErrorStatus();
      paramArrayOfByte.errorCode = -28002;
      paramArrayOfByte.errorMsg = "接收数据失败!";
      Log.i("BaseCallback", "commonError: return buffer is null");
      handleResponse(paramArrayOfByte, null);
      return;
    }
    for (;;)
    {
      Cmd0X31B.RspBody localRspBody;
      try
      {
        localRspBody = new Cmd0X31B.RspBody();
        localRspBody.mergeFrom(paramArrayOfByte);
        paramArrayOfByte = new IWyFileSystem.WyErrorStatus();
        paramArrayOfByte.errorCode = localRspBody.uint32_return_code.get();
        paramArrayOfByte.errorMsg = localRspBody.str_client_wording.get();
        if ((SdkContext.getInstance().isDebug()) || (paramArrayOfByte.errorCode != 0)) {
          SdkContext.getInstance().getLogger().d("BaseCallback", String.format("sub cmd:%d returnCode:%d errorMsg:%s", new Object[] { Integer.valueOf(localRspBody.uint32_sub_cmd.get()), Integer.valueOf(paramArrayOfByte.errorCode), localRspBody.str_error_msg.get() }));
        }
        SdkContext.getInstance().getLogger().d("BaseCallback", String.format("sub cmd:%d returnCode:%d errorMsg:%s", new Object[] { Integer.valueOf(localRspBody.uint32_sub_cmd.get()), Integer.valueOf(paramArrayOfByte.errorCode), localRspBody.str_error_msg.get() }));
        Log.e("lewis", String.format("sub cmd:%d returnCode:%d errorMsg:%s", new Object[] { Integer.valueOf(localRspBody.uint32_sub_cmd.get()), Integer.valueOf(paramArrayOfByte.errorCode), localRspBody.str_error_msg.get() }));
        switch (localRspBody.uint32_sub_cmd.get())
        {
        case 1: 
          if (localRspBody.uint32_return_code.get() == 0)
          {
            paramArrayOfByte.errorCode = -28001;
            paramArrayOfByte.errorMsg = "无效的协议!";
          }
          handleResponse(paramArrayOfByte, null);
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        Log.w("BaseCallback", "commonError: InvalidProtocolBufferException");
        Log.w("BaseCallback", paramArrayOfByte);
        paramArrayOfByte = new IWyFileSystem.WyErrorStatus();
        paramArrayOfByte.errorCode = -28003;
        paramArrayOfByte.errorMsg = "无效的协议!";
        handleResponse(paramArrayOfByte, null);
        return;
      }
      handleResponse(paramArrayOfByte, localRspBody.msg_get_lib_type_rsp_body.get());
      return;
      handleResponse(paramArrayOfByte, localRspBody.msg_get_lib_list_rsp_body.get());
      return;
      handleResponse(paramArrayOfByte, localRspBody.msg_upload2qcloud_rsp_body.get());
      return;
      handleResponse(paramArrayOfByte, localRspBody.msg_download_file_rsp_body.get());
      return;
      handleResponse(paramArrayOfByte, localRspBody.msg_delete_file_rsp_body.get());
      return;
      handleResponse(paramArrayOfByte, localRspBody.msg_get_offline_file_rsp_body.get());
      return;
      handleResponse(paramArrayOfByte, localRspBody.msg_resume_file_upload_rsp_body.get());
      return;
      handleResponse(paramArrayOfByte, localRspBody.msg_file_preview_rsp_body.get());
      return;
      handleResponse(paramArrayOfByte, localRspBody.msg_apply_offline_file_download_rsp.get());
      return;
      handleResponse(paramArrayOfByte, localRspBody.msg_qcloud2ftn_rsp_body.get());
      return;
      handleResponse(paramArrayOfByte, localRspBody.msg_querypwd_rsp_body.get());
      return;
      handleResponse(paramArrayOfByte, localRspBody.msg_verifypwd_rsp_body.get());
      return;
      handleResponse(paramArrayOfByte, localRspBody.msg_storefilepreview_rsp_body.get());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.protocol.BaseCallback
 * JD-Core Version:    0.7.0.1
 */
package com.weiyun.sdk.impl;

import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.weiyun.sdk.IWyBizManager;
import com.weiyun.sdk.IWyFileSystem.IWyCallback;
import com.weiyun.sdk.IWyFileSystem.WyCommand;
import com.weiyun.sdk.channel.ISender;
import com.weiyun.sdk.context.SdkContext;
import tencent.im.cs.cmd0x31b.Cmd0X31B.AlbumStatusReportReqBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.AlbumStatusReportRspBody;
import tencent.im.cs.cmd0x31b.Cmd0X31B.ReqBody;

public class DefaultBizManager
  implements IWyBizManager
{
  private Cmd0X31B.ReqBody newReqBody(int paramInt)
  {
    Cmd0X31B.ReqBody localReqBody = new Cmd0X31B.ReqBody();
    localReqBody.uint32_sub_cmd.set(paramInt);
    localReqBody.str_app_id.set("30223");
    return localReqBody;
  }
  
  public IWyFileSystem.WyCommand reportAlbumStatus(boolean paramBoolean, int paramInt1, int paramInt2, long paramLong, IWyFileSystem.IWyCallback<Boolean> paramIWyCallback)
  {
    Cmd0X31B.AlbumStatusReportReqBody localAlbumStatusReportReqBody = new Cmd0X31B.AlbumStatusReportReqBody();
    Object localObject = localAlbumStatusReportReqBody.bool_new_user;
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      ((PBBoolField)localObject).set(paramBoolean);
      localAlbumStatusReportReqBody.uint32_new_pic_number.set(paramInt1);
      localAlbumStatusReportReqBody.uint32_unbaked_pic_number.set(paramInt2);
      localAlbumStatusReportReqBody.uint32_during_time.set((int)(paramLong / 1000L / 3600L));
      localObject = newReqBody(273);
      ((Cmd0X31B.ReqBody)localObject).msg_album_status_report_req_body.set(localAlbumStatusReportReqBody);
      paramIWyCallback = new WyCommandImpl(paramIWyCallback);
      SdkContext.getInstance().getSender().sendRequest("OfflineFilleHandleSvr.pb_weiyun_CMD_REQ_ALBUM_STATUS_REPORT-273", ((Cmd0X31B.ReqBody)localObject).toByteArray(), new BaseCallbackImpl(paramIWyCallback)
      {
        protected void handleSuccess(IWyFileSystem.IWyCallback<Boolean> paramAnonymousIWyCallback, Cmd0X31B.AlbumStatusReportRspBody paramAnonymousAlbumStatusReportRspBody)
        {
          paramAnonymousIWyCallback.onSucceed(Boolean.valueOf(paramAnonymousAlbumStatusReportRspBody.bool_need_red_touch.get()));
        }
      });
      return paramIWyCallback;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.weiyun.sdk.impl.DefaultBizManager
 * JD-Core Version:    0.7.0.1
 */
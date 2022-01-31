package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.ag.h;
import com.tencent.mm.ag.i;
import com.tencent.mm.ag.o;
import com.tencent.mm.model.q;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.bk;

class JsApiChooseWeChatContact$GetUserDataTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetUserDataTask> CREATOR = new JsApiChooseWeChatContact.GetUserDataTask.1();
  String aVr;
  String aVs;
  String foS = "";
  public String gpK;
  public String userName;
  
  public JsApiChooseWeChatContact$GetUserDataTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public JsApiChooseWeChatContact$GetUserDataTask(String paramString)
  {
    this.userName = paramString;
  }
  
  public final void Zu()
  {
    this.gpK = q.Gj();
    if (!TextUtils.isEmpty(this.userName))
    {
      this.aVr = r.gU(this.userName);
      this.aVs = r.gW(this.userName);
      h localh = o.Kh().kp(this.userName);
      if (localh != null)
      {
        this.foS = localh.JX();
        if (bk.bl(this.foS)) {
          this.foS = localh.JY();
        }
      }
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    this.gpK = paramParcel.readString();
    this.userName = paramParcel.readString();
    this.aVr = paramParcel.readString();
    this.aVs = paramParcel.readString();
    this.foS = paramParcel.readString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.gpK);
    paramParcel.writeString(this.userName);
    paramParcel.writeString(this.aVr);
    paramParcel.writeString(this.aVs);
    paramParcel.writeString(this.foS);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact.GetUserDataTask
 * JD-Core Version:    0.7.0.1
 */
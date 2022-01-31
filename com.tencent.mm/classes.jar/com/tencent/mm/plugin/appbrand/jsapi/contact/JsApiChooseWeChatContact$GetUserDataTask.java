package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.h;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.model.r;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.sdk.platformtools.bo;

class JsApiChooseWeChatContact$GetUserDataTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<GetUserDataTask> CREATOR;
  String blZ;
  String bma;
  String gGm;
  public String hKt;
  public String userName;
  
  static
  {
    AppMethodBeat.i(130997);
    CREATOR = new JsApiChooseWeChatContact.GetUserDataTask.1();
    AppMethodBeat.o(130997);
  }
  
  public JsApiChooseWeChatContact$GetUserDataTask(Parcel paramParcel)
  {
    AppMethodBeat.i(130993);
    this.gGm = "";
    f(paramParcel);
    AppMethodBeat.o(130993);
  }
  
  public JsApiChooseWeChatContact$GetUserDataTask(String paramString)
  {
    this.gGm = "";
    this.userName = paramString;
  }
  
  public final void ata()
  {
    AppMethodBeat.i(130994);
    this.hKt = r.Zn();
    if (!TextUtils.isEmpty(this.userName))
    {
      this.blZ = s.nD(this.userName);
      this.bma = s.nF(this.userName);
      h localh = o.adg().rj(this.userName);
      if (localh != null)
      {
        this.gGm = localh.acX();
        if (bo.isNullOrNil(this.gGm)) {
          this.gGm = localh.acY();
        }
      }
    }
    AppMethodBeat.o(130994);
  }
  
  public final void f(Parcel paramParcel)
  {
    AppMethodBeat.i(130995);
    this.hKt = paramParcel.readString();
    this.userName = paramParcel.readString();
    this.blZ = paramParcel.readString();
    this.bma = paramParcel.readString();
    this.gGm = paramParcel.readString();
    AppMethodBeat.o(130995);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(130996);
    paramParcel.writeString(this.hKt);
    paramParcel.writeString(this.userName);
    paramParcel.writeString(this.blZ);
    paramParcel.writeString(this.bma);
    paramParcel.writeString(this.gGm);
    AppMethodBeat.o(130996);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact.GetUserDataTask
 * JD-Core Version:    0.7.0.1
 */
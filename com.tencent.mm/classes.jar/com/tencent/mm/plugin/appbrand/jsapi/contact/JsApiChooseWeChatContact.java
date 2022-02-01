package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.h.f.c;
import com.tencent.luggage.sdk.g.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class JsApiChooseWeChatContact
  extends d<s>
{
  public static final int CTRL_INDEX = 195;
  public static final String NAME = "chooseWeChatContact";
  final int lSc;
  
  public JsApiChooseWeChatContact()
  {
    AppMethodBeat.i(174781);
    this.lSc = a.aK(this);
    AppMethodBeat.o(174781);
  }
  
  static class GetUserDataTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetUserDataTask> CREATOR;
    String cgo;
    String kog;
    public String lSe;
    String nickName;
    public String userName;
    
    static
    {
      AppMethodBeat.i(46253);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(46253);
    }
    
    public GetUserDataTask(Parcel paramParcel)
    {
      AppMethodBeat.i(46249);
      this.kog = "";
      f(paramParcel);
      AppMethodBeat.o(46249);
    }
    
    public GetUserDataTask(String paramString)
    {
      this.kog = "";
      this.userName = paramString;
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(46250);
      this.lSe = z.aTY();
      if (!TextUtils.isEmpty(this.userName))
      {
        this.nickName = aa.Ir(this.userName);
        this.cgo = aa.Is(this.userName);
        i locali = com.tencent.mm.aj.p.aYB().Mx(this.userName);
        if (locali != null)
        {
          this.kog = locali.aYt();
          if (Util.isNullOrNil(this.kog)) {
            this.kog = locali.aYu();
          }
        }
      }
      AppMethodBeat.o(46250);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(46251);
      this.lSe = paramParcel.readString();
      this.userName = paramParcel.readString();
      this.nickName = paramParcel.readString();
      this.cgo = paramParcel.readString();
      this.kog = paramParcel.readString();
      AppMethodBeat.o(46251);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46252);
      paramParcel.writeString(this.lSe);
      paramParcel.writeString(this.userName);
      paramParcel.writeString(this.nickName);
      paramParcel.writeString(this.cgo);
      paramParcel.writeString(this.kog);
      AppMethodBeat.o(46252);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact
 * JD-Core Version:    0.7.0.1
 */
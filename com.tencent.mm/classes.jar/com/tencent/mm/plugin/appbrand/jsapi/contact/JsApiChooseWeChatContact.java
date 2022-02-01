package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.k.f.c;
import com.tencent.luggage.sdk.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j;
import com.tencent.mm.am.k;
import com.tencent.mm.am.q;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class JsApiChooseWeChatContact
  extends c<v>
{
  public static final int CTRL_INDEX = 195;
  public static final String NAME = "chooseWeChatContact";
  final int oOH;
  
  public JsApiChooseWeChatContact()
  {
    AppMethodBeat.i(174781);
    this.oOH = a.aI(this);
    AppMethodBeat.o(174781);
  }
  
  static class GetUserDataTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetUserDataTask> CREATOR;
    String cip;
    String nfY;
    String nickName;
    public String oOJ;
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
      this.nfY = "";
      f(paramParcel);
      AppMethodBeat.o(46249);
    }
    
    public GetUserDataTask(String paramString)
    {
      this.nfY = "";
      this.userName = paramString;
    }
    
    public final void RW()
    {
      AppMethodBeat.i(46250);
      this.oOJ = z.bcZ();
      if (!TextUtils.isEmpty(this.userName))
      {
        this.nickName = aa.PI(this.userName);
        this.cip = aa.PK(this.userName);
        j localj = q.bhP().TS(this.userName);
        if (localj != null)
        {
          this.nfY = localj.bhH();
          if (Util.isNullOrNil(this.nfY)) {
            this.nfY = localj.bhI();
          }
        }
      }
      AppMethodBeat.o(46250);
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(46251);
      this.oOJ = paramParcel.readString();
      this.userName = paramParcel.readString();
      this.nickName = paramParcel.readString();
      this.cip = paramParcel.readString();
      this.nfY = paramParcel.readString();
      AppMethodBeat.o(46251);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46252);
      paramParcel.writeString(this.oOJ);
      paramParcel.writeString(this.userName);
      paramParcel.writeString(this.nickName);
      paramParcel.writeString(this.cip);
      paramParcel.writeString(this.nfY);
      AppMethodBeat.o(46252);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact
 * JD-Core Version:    0.7.0.1
 */
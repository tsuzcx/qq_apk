package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.h.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.j;
import com.tencent.mm.ak.p;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.HashMap;
import java.util.Map;

public final class JsApiChooseWeChatContact
  extends com.tencent.mm.plugin.appbrand.jsapi.a<q>
{
  public static final int CTRL_INDEX = 195;
  public static final String NAME = "chooseWeChatContact";
  final int jOu;
  
  public JsApiChooseWeChatContact()
  {
    AppMethodBeat.i(174781);
    this.jOu = com.tencent.luggage.sdk.g.a.aD(this);
    AppMethodBeat.o(174781);
  }
  
  static class GetUserDataTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetUserDataTask> CREATOR;
    String bNK;
    String bNL;
    String itN;
    public String jOw;
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
      this.itN = "";
      e(paramParcel);
      AppMethodBeat.o(46249);
    }
    
    public GetUserDataTask(String paramString)
    {
      this.itN = "";
      this.userName = paramString;
    }
    
    public final void aEz()
    {
      AppMethodBeat.i(46250);
      this.jOw = u.aqG();
      if (!TextUtils.isEmpty(this.userName))
      {
        this.bNK = v.sg(this.userName);
        this.bNL = v.si(this.userName);
        i locali = p.auF().we(this.userName);
        if (locali != null)
        {
          this.itN = locali.aux();
          if (bt.isNullOrNil(this.itN)) {
            this.itN = locali.auy();
          }
        }
      }
      AppMethodBeat.o(46250);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(46251);
      this.jOw = paramParcel.readString();
      this.userName = paramParcel.readString();
      this.bNK = paramParcel.readString();
      this.bNL = paramParcel.readString();
      this.itN = paramParcel.readString();
      AppMethodBeat.o(46251);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46252);
      paramParcel.writeString(this.jOw);
      paramParcel.writeString(this.userName);
      paramParcel.writeString(this.bNK);
      paramParcel.writeString(this.bNL);
      paramParcel.writeString(this.itN);
      AppMethodBeat.o(46252);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact
 * JD-Core Version:    0.7.0.1
 */
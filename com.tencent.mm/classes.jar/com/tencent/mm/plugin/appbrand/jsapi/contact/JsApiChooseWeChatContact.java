package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.h.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.HashMap;
import java.util.Map;

public final class JsApiChooseWeChatContact
  extends com.tencent.mm.plugin.appbrand.jsapi.a<q>
{
  public static final int CTRL_INDEX = 195;
  public static final String NAME = "chooseWeChatContact";
  final int koV;
  
  public JsApiChooseWeChatContact()
  {
    AppMethodBeat.i(174781);
    this.koV = com.tencent.luggage.sdk.g.a.aA(this);
    AppMethodBeat.o(174781);
  }
  
  static class GetUserDataTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetUserDataTask> CREATOR;
    String bLs;
    String bLt;
    String iTS;
    public String koX;
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
      this.iTS = "";
      e(paramParcel);
      AppMethodBeat.o(46249);
    }
    
    public GetUserDataTask(String paramString)
    {
      this.iTS = "";
      this.userName = paramString;
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(46250);
      this.koX = u.axw();
      if (!TextUtils.isEmpty(this.userName))
      {
        this.bLs = v.wj(this.userName);
        this.bLt = v.wl(this.userName);
        i locali = p.aBw().Ak(this.userName);
        if (locali != null)
        {
          this.iTS = locali.aBo();
          if (bs.isNullOrNil(this.iTS)) {
            this.iTS = locali.aBp();
          }
        }
      }
      AppMethodBeat.o(46250);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(46251);
      this.koX = paramParcel.readString();
      this.userName = paramParcel.readString();
      this.bLs = paramParcel.readString();
      this.bLt = paramParcel.readString();
      this.iTS = paramParcel.readString();
      AppMethodBeat.o(46251);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46252);
      paramParcel.writeString(this.koX);
      paramParcel.writeString(this.userName);
      paramParcel.writeString(this.bLs);
      paramParcel.writeString(this.bLt);
      paramParcel.writeString(this.iTS);
      AppMethodBeat.o(46252);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact
 * JD-Core Version:    0.7.0.1
 */
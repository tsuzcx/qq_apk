package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.h.e.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.i;
import com.tencent.mm.aj.j;
import com.tencent.mm.aj.p;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.HashMap;
import java.util.Map;

public final class JsApiChooseWeChatContact
  extends com.tencent.mm.plugin.appbrand.jsapi.a<r>
{
  public static final int CTRL_INDEX = 195;
  public static final String NAME = "chooseWeChatContact";
  final int kNk;
  
  public JsApiChooseWeChatContact()
  {
    AppMethodBeat.i(174781);
    this.kNk = com.tencent.luggage.sdk.g.a.aC(this);
    AppMethodBeat.o(174781);
  }
  
  static class GetUserDataTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetUserDataTask> CREATOR;
    String bVF;
    String bVG;
    String jpU;
    public String kNm;
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
      this.jpU = "";
      e(paramParcel);
      AppMethodBeat.o(46249);
    }
    
    public GetUserDataTask(String paramString)
    {
      this.jpU = "";
      this.userName = paramString;
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(46250);
      this.kNm = v.aAC();
      if (!TextUtils.isEmpty(this.userName))
      {
        this.bVF = w.zO(this.userName);
        this.bVG = w.zQ(this.userName);
        i locali = p.aEN().DL(this.userName);
        if (locali != null)
        {
          this.jpU = locali.aEG();
          if (bu.isNullOrNil(this.jpU)) {
            this.jpU = locali.aEH();
          }
        }
      }
      AppMethodBeat.o(46250);
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(46251);
      this.kNm = paramParcel.readString();
      this.userName = paramParcel.readString();
      this.bVF = paramParcel.readString();
      this.bVG = paramParcel.readString();
      this.jpU = paramParcel.readString();
      AppMethodBeat.o(46251);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46252);
      paramParcel.writeString(this.kNm);
      paramParcel.writeString(this.userName);
      paramParcel.writeString(this.bVF);
      paramParcel.writeString(this.bVG);
      paramParcel.writeString(this.jpU);
      AppMethodBeat.o(46252);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.luggage.l.e.c;
import com.tencent.luggage.sdk.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.k;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Map;

public final class JsApiChooseWeChatContact
  extends c<y>
{
  public static final int CTRL_INDEX = 195;
  public static final String NAME = "chooseWeChatContact";
  final int rSv;
  
  public JsApiChooseWeChatContact()
  {
    AppMethodBeat.i(174781);
    this.rSv = a.ce(this);
    AppMethodBeat.o(174781);
  }
  
  static class GetUserDataTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<GetUserDataTask> CREATOR;
    String dYO;
    String nVM;
    String nickName;
    public String rSx;
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
      this.nVM = "";
      h(paramParcel);
      AppMethodBeat.o(46249);
    }
    
    public GetUserDataTask(String paramString)
    {
      this.nVM = "";
      this.userName = paramString;
    }
    
    public final void asn()
    {
      AppMethodBeat.i(46250);
      this.rSx = z.bAM();
      if (!TextUtils.isEmpty(this.userName))
      {
        this.nickName = aa.ID(this.userName);
        this.dYO = aa.IE(this.userName);
        j localj = q.bFE().LS(this.userName);
        if (localj != null)
        {
          this.nVM = localj.bFw();
          if (Util.isNullOrNil(this.nVM)) {
            this.nVM = localj.bFx();
          }
        }
      }
      AppMethodBeat.o(46250);
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(46251);
      this.rSx = paramParcel.readString();
      this.userName = paramParcel.readString();
      this.nickName = paramParcel.readString();
      this.dYO = paramParcel.readString();
      this.nVM = paramParcel.readString();
      AppMethodBeat.o(46251);
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(46252);
      paramParcel.writeString(this.rSx);
      paramParcel.writeString(this.userName);
      paramParcel.writeString(this.nickName);
      paramParcel.writeString(this.dYO);
      paramParcel.writeString(this.nVM);
      AppMethodBeat.o(46252);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.JsApiChooseWeChatContact
 * JD-Core Version:    0.7.0.1
 */
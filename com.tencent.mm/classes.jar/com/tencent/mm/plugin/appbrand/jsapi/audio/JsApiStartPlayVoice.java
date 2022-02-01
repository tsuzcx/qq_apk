package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.page.ac;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashMap;
import java.util.Map;

public final class JsApiStartPlayVoice
  extends d<s>
{
  public static final int CTRL_INDEX = 33;
  public static final String NAME = "playVoice";
  public static String lEP = null;
  private StartPlayVoice lEQ;
  
  static class StartPlayVoice
    extends MainProcessTask
  {
    public static final Parcelable.Creator<StartPlayVoice> CREATOR;
    public String dJX;
    public boolean error;
    public String filePath;
    private s kGT;
    private p lAw;
    private int lqe;
    
    static
    {
      AppMethodBeat.i(45971);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(45971);
    }
    
    public StartPlayVoice(Parcel paramParcel)
    {
      AppMethodBeat.i(45964);
      this.error = false;
      f(paramParcel);
      AppMethodBeat.o(45964);
    }
    
    public StartPlayVoice(p paramp, s params, int paramInt)
    {
      this.error = false;
      this.lAw = paramp;
      this.kGT = params;
      this.lqe = paramInt;
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(45965);
      MMHandlerThread.postToMainThread(new JsApiStartPlayVoice.StartPlayVoice.1(this));
      AppMethodBeat.o(45965);
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(45966);
      HashMap localHashMap = new HashMap();
      localHashMap.put("localId", this.dJX);
      s locals = this.kGT;
      int i = this.lqe;
      p localp = this.lAw;
      if (this.error) {}
      for (String str = "fail";; str = "ok")
      {
        locals.i(i, localp.n(str, localHashMap));
        JsApiStartPlayVoice.lEP = null;
        AppMethodBeat.o(45966);
        return;
      }
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(45967);
      this.dJX = paramParcel.readString();
      this.filePath = paramParcel.readString();
      if (paramParcel.readByte() != 0) {}
      for (boolean bool = true;; bool = false)
      {
        this.error = bool;
        AppMethodBeat.o(45967);
        return;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(45968);
      paramParcel.writeString(this.dJX);
      paramParcel.writeString(this.filePath);
      if (this.error) {}
      for (byte b = 1;; b = 0)
      {
        paramParcel.writeByte(b);
        AppMethodBeat.o(45968);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice
 * JD-Core Version:    0.7.0.1
 */
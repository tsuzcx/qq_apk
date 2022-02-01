package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.sdk.platformtools.ar;
import java.util.HashMap;
import java.util.Map;

public final class JsApiStartPlayVoice
  extends a<r>
{
  public static final int CTRL_INDEX = 33;
  public static final String NAME = "playVoice";
  public static String kAw = null;
  private StartPlayVoice kAx;
  
  static class StartPlayVoice
    extends MainProcessTask
  {
    public static final Parcelable.Creator<StartPlayVoice> CREATOR;
    public String dsN;
    public boolean error;
    public String filePath;
    private r jFj;
    private int kmu;
    private m kuO;
    
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
      e(paramParcel);
      AppMethodBeat.o(45964);
    }
    
    public StartPlayVoice(m paramm, r paramr, int paramInt)
    {
      this.error = false;
      this.kuO = paramm;
      this.jFj = paramr;
      this.kmu = paramInt;
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(45965);
      ar.f(new JsApiStartPlayVoice.StartPlayVoice.1(this));
      AppMethodBeat.o(45965);
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(45966);
      HashMap localHashMap = new HashMap();
      localHashMap.put("localId", this.dsN);
      r localr = this.jFj;
      int i = this.kmu;
      m localm = this.kuO;
      if (this.error) {}
      for (String str = "fail";; str = "ok")
      {
        localr.h(i, localm.n(str, localHashMap));
        JsApiStartPlayVoice.kAw = null;
        AppMethodBeat.o(45966);
        return;
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(45967);
      this.dsN = paramParcel.readString();
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
      paramParcel.writeString(this.dsN);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice
 * JD-Core Version:    0.7.0.1
 */
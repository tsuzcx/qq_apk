package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.h.a;
import com.tencent.mm.al.h.b;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.aq;
import java.util.HashMap;
import java.util.Map;

public final class JsApiStartPlayVoice
  extends a<q>
{
  public static final int CTRL_INDEX = 33;
  public static final String NAME = "playVoice";
  public static String kxh = null;
  private StartPlayVoice kxi;
  
  static class StartPlayVoice
    extends MainProcessTask
  {
    public static final Parcelable.Creator<StartPlayVoice> CREATOR;
    public String drH;
    public boolean error;
    public String filePath;
    private q jCl;
    private int kje;
    private m kry;
    
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
    
    public StartPlayVoice(m paramm, q paramq, int paramInt)
    {
      this.error = false;
      this.kry = paramm;
      this.jCl = paramq;
      this.kje = paramInt;
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(45965);
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(45962);
          b localb = b.jVe;
          b.a(JsApiStartPlayVoice.StartPlayVoice.this.filePath, new h.a()new h.b
          {
            public final void onCompletion()
            {
              AppMethodBeat.i(45960);
              JsApiStartPlayVoice.StartPlayVoice.this.error = false;
              JsApiStartPlayVoice.StartPlayVoice.b(JsApiStartPlayVoice.StartPlayVoice.this);
              AppMethodBeat.o(45960);
            }
          }, new h.b()
          {
            public final void onError()
            {
              AppMethodBeat.i(45961);
              JsApiStartPlayVoice.StartPlayVoice.this.error = true;
              JsApiStartPlayVoice.StartPlayVoice.c(JsApiStartPlayVoice.StartPlayVoice.this);
              AppMethodBeat.o(45961);
            }
          });
          AppMethodBeat.o(45962);
        }
      });
      AppMethodBeat.o(45965);
    }
    
    public final void aOB()
    {
      AppMethodBeat.i(45966);
      HashMap localHashMap = new HashMap();
      localHashMap.put("localId", this.drH);
      q localq = this.jCl;
      int i = this.kje;
      m localm = this.kry;
      if (this.error) {}
      for (String str = "fail";; str = "ok")
      {
        localq.h(i, localm.m(str, localHashMap));
        JsApiStartPlayVoice.kxh = null;
        AppMethodBeat.o(45966);
        return;
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(45967);
      this.drH = paramParcel.readString();
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
      paramParcel.writeString(this.drH);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice
 * JD-Core Version:    0.7.0.1
 */
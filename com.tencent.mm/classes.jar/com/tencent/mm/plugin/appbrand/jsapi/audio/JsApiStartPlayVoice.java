package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i.a;
import com.tencent.mm.ak.i.b;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.appbrand.d.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.a;
import com.tencent.mm.plugin.appbrand.jsapi.f.b;
import com.tencent.mm.plugin.appbrand.jsapi.f.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.page.aa;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.sdk.platformtools.ap;
import java.util.HashMap;
import java.util.Map;

public final class JsApiStartPlayVoice
  extends a<q>
{
  public static final int CTRL_INDEX = 33;
  public static final String NAME = "playVoice";
  public static String kcH = null;
  private StartPlayVoice kcI;
  
  static class StartPlayVoice
    extends MainProcessTask
  {
    public static final Parcelable.Creator<StartPlayVoice> CREATOR;
    public String dgl;
    public boolean error;
    public String filePath;
    private int jOT;
    private m jXc;
    private q jiP;
    
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
      this.jXc = paramm;
      this.jiP = paramq;
      this.jOT = paramInt;
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(45965);
      ap.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(45962);
          b localb = b.jBj;
          b.a(JsApiStartPlayVoice.StartPlayVoice.this.filePath, new i.a()new i.b
          {
            public final void onCompletion()
            {
              AppMethodBeat.i(45960);
              JsApiStartPlayVoice.StartPlayVoice.this.error = false;
              JsApiStartPlayVoice.StartPlayVoice.b(JsApiStartPlayVoice.StartPlayVoice.this);
              AppMethodBeat.o(45960);
            }
          }, new i.b()
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
    
    public final void aLr()
    {
      AppMethodBeat.i(45966);
      HashMap localHashMap = new HashMap();
      localHashMap.put("localId", this.dgl);
      q localq = this.jiP;
      int i = this.jOT;
      m localm = this.jXc;
      if (this.error) {}
      for (String str = "fail";; str = "ok")
      {
        localq.h(i, localm.k(str, localHashMap));
        JsApiStartPlayVoice.kcH = null;
        AppMethodBeat.o(45966);
        return;
      }
    }
    
    public final void e(Parcel paramParcel)
    {
      AppMethodBeat.i(45967);
      this.dgl = paramParcel.readString();
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
      paramParcel.writeString(this.dgl);
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
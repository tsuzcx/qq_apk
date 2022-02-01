package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.k.a;
import com.tencent.mm.an.k.b;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.c.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.h.b;
import com.tencent.mm.plugin.appbrand.jsapi.h.c;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashMap;
import java.util.Map;

public final class JsApiStartPlayVoice
  extends c<v>
{
  public static final int CTRL_INDEX = 33;
  public static final String NAME = "playVoice";
  public static String oAq = null;
  private StartPlayVoice oAr;
  
  static class StartPlayVoice
    extends MainProcessTask
  {
    public static final Parcelable.Creator<StartPlayVoice> CREATOR;
    public boolean error;
    public String fCM;
    public String filePath;
    private v nAz;
    private int okO;
    private o ovN;
    
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
    
    public StartPlayVoice(o paramo, v paramv, int paramInt)
    {
      this.error = false;
      this.ovN = paramo;
      this.nAz = paramv;
      this.okO = paramInt;
    }
    
    public final void RW()
    {
      AppMethodBeat.i(45965);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(45962);
          b localb = b.nVC;
          b.a(JsApiStartPlayVoice.StartPlayVoice.this.filePath, new k.a()new k.b
          {
            public final void onCompletion()
            {
              AppMethodBeat.i(45960);
              JsApiStartPlayVoice.StartPlayVoice.this.error = false;
              JsApiStartPlayVoice.StartPlayVoice.b(JsApiStartPlayVoice.StartPlayVoice.this);
              AppMethodBeat.o(45960);
            }
          }, new k.b()
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
    
    public final void bsK()
    {
      AppMethodBeat.i(45966);
      HashMap localHashMap = new HashMap();
      localHashMap.put("localId", this.fCM);
      v localv = this.nAz;
      int i = this.okO;
      o localo = this.ovN;
      if (this.error) {}
      for (String str = "fail";; str = "ok")
      {
        localv.j(i, localo.m(str, localHashMap));
        JsApiStartPlayVoice.oAq = null;
        AppMethodBeat.o(45966);
        return;
      }
    }
    
    public final void f(Parcel paramParcel)
    {
      AppMethodBeat.i(45967);
      this.fCM = paramParcel.readString();
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
      paramParcel.writeString(this.fCM);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiStartPlayVoice
 * JD-Core Version:    0.7.0.1
 */
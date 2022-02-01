package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.j.a;
import com.tencent.mm.am.j.b;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.d.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.i.b;
import com.tencent.mm.plugin.appbrand.jsapi.i.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import java.util.HashMap;
import java.util.Map;

public final class JsApiStartPlayVoice
  extends c<y>
{
  public static final int CTRL_INDEX = 33;
  public static final String NAME = "playVoice";
  public static String rEj = null;
  private StartPlayVoice rEk;
  
  static class StartPlayVoice
    extends MainProcessTask
  {
    public static final Parcelable.Creator<StartPlayVoice> CREATOR;
    public boolean error;
    public String filePath;
    public String hHB;
    private y qqV;
    private int ror;
    private p rzh;
    
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
      h(paramParcel);
      AppMethodBeat.o(45964);
    }
    
    public StartPlayVoice(p paramp, y paramy, int paramInt)
    {
      this.error = false;
      this.rzh = paramp;
      this.qqV = paramy;
      this.ror = paramInt;
    }
    
    public final void asn()
    {
      AppMethodBeat.i(45965);
      MMHandlerThread.postToMainThread(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(45962);
          b localb = b.qVm;
          b.a(JsApiStartPlayVoice.StartPlayVoice.this.filePath, new j.a()new j.b
          {
            public final void onCompletion()
            {
              AppMethodBeat.i(45960);
              JsApiStartPlayVoice.StartPlayVoice.this.error = false;
              JsApiStartPlayVoice.StartPlayVoice.b(JsApiStartPlayVoice.StartPlayVoice.this);
              AppMethodBeat.o(45960);
            }
          }, new j.b()
          {
            public final void atR()
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
    
    public final void bQr()
    {
      AppMethodBeat.i(45966);
      HashMap localHashMap = new HashMap();
      localHashMap.put("localId", this.hHB);
      y localy = this.qqV;
      int i = this.ror;
      p localp = this.rzh;
      if (this.error) {}
      for (String str = "fail";; str = "ok")
      {
        localy.callback(i, localp.m(str, localHashMap));
        JsApiStartPlayVoice.rEj = null;
        AppMethodBeat.o(45966);
        return;
      }
    }
    
    public final void h(Parcel paramParcel)
    {
      AppMethodBeat.i(45967);
      this.hHB = paramParcel.readString();
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
      paramParcel.writeString(this.hHB);
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
package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.b;
import com.tencent.mm.ay.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.ar;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import org.json.JSONException;
import org.json.JSONObject;

public class JsApiOperateBackgroundAudio<CONTEXT extends c>
  extends com.tencent.mm.plugin.appbrand.jsapi.a<CONTEXT>
{
  public static final int CTRL_INDEX = 161;
  public static final String NAME = "operateBackgroundAudio";
  protected JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask kbT;
  
  protected JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask a(com.tencent.mm.plugin.appbrand.jsapi.a parama, CONTEXT paramCONTEXT, int paramInt)
  {
    AppMethodBeat.i(145742);
    parama = new JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask(this, paramCONTEXT, paramInt);
    AppMethodBeat.o(145742);
    return parama;
  }
  
  public final void a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145741);
    if (paramJSONObject == null)
    {
      paramCONTEXT.h(paramInt, e("fail:data is null", null));
      ac.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio data is null");
      AppMethodBeat.o(145741);
      return;
    }
    String str = paramCONTEXT.getAppId();
    ac.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio appId:%s", new Object[] { str });
    if (this.kbT == null) {
      this.kbT = a(this, paramCONTEXT, paramInt);
    }
    this.kbT.jOT = paramInt;
    this.kbT.appId = str;
    l(paramCONTEXT);
    paramCONTEXT = new OperateBackgroundAudioTask(this, paramCONTEXT, paramInt);
    paramCONTEXT.jOT = paramInt;
    paramCONTEXT.appId = str;
    paramCONTEXT.kbW = paramJSONObject.toString();
    AppBrandMainProcessService.a(paramCONTEXT);
    AppMethodBeat.o(145741);
  }
  
  protected void l(CONTEXT paramCONTEXT) {}
  
  protected static class OperateBackgroundAudioTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<OperateBackgroundAudioTask> CREATOR;
    public String appId;
    public boolean error;
    public String imz;
    public int jOT;
    private m jXc;
    public c jYG;
    public String kbW;
    
    static
    {
      AppMethodBeat.i(145740);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(145740);
    }
    
    public OperateBackgroundAudioTask(Parcel paramParcel)
    {
      AppMethodBeat.i(145735);
      this.error = false;
      this.imz = "";
      e(paramParcel);
      AppMethodBeat.o(145735);
    }
    
    public OperateBackgroundAudioTask(com.tencent.mm.plugin.appbrand.jsapi.a parama, c paramc, int paramInt)
    {
      this.error = false;
      this.imz = "";
      this.jXc = parama;
      this.jYG = paramc;
      this.jOT = paramInt;
    }
    
    public final void aLq()
    {
      AppMethodBeat.i(145736);
      ac.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "runInMainProcess");
      Object localObject1 = a.a.boE().lrM;
      if ((!bs.isNullOrNil((String)localObject1)) && (!((String)localObject1).equals(this.appId)))
      {
        ac.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[] { localObject1, this.appId });
        this.error = true;
        this.imz = "appid not match cannot operate";
        bet();
        AppMethodBeat.o(145736);
        return;
      }
      Object localObject3;
      double d;
      try
      {
        localObject1 = new JSONObject(this.kbW);
        localObject3 = ((JSONObject)localObject1).optString("operationType");
        d = ((JSONObject)localObject1).optDouble("currentTime", -1.0D);
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          ac.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is null");
          this.error = true;
          this.imz = "operationType is null";
          bet();
          AppMethodBeat.o(145736);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        ac.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "new json exists exception, data is invalid, jsonStr:%s", new Object[] { this.kbW });
        this.error = true;
        this.imz = "parser data fail, data is invalid";
        ac.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "exception:%s" + localJSONException.getMessage());
        bet();
        AppMethodBeat.o(145736);
        return;
      }
      ac.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType;%s, currentTime:%f", new Object[] { localObject3, Double.valueOf(d) });
      this.error = false;
      Object localObject2;
      if (((String)localObject3).equalsIgnoreCase("play"))
      {
        localObject3 = a.a.boE().lrO;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = com.tencent.mm.ay.a.aGy();
        }
        if (localObject2 != null) {
          a.a.boE().lrN = ((f)localObject2).hNS;
        }
        if (b.aGA()) {
          ac.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "play music ok");
        }
      }
      for (;;)
      {
        if (this.error) {
          ac.e("MicroMsg.Music.JsApiOperateBackgroundAudio", this.imz);
        }
        bet();
        AppMethodBeat.o(145736);
        return;
        if (com.tencent.mm.ay.a.aGv())
        {
          this.error = true;
          this.imz = "music is playing, don't play again";
        }
        else if ((localObject2 != null) && (this.appId.equals(((f)localObject2).hOf)))
        {
          ac.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "startPlayMusic play music ok, appId is same!");
          com.tencent.mm.ay.a.c((f)localObject2);
        }
        else
        {
          this.error = true;
          this.imz = "play music fail";
          continue;
          if (((String)localObject3).equalsIgnoreCase("pause"))
          {
            if (b.aGB())
            {
              ac.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "pause music ok");
            }
            else
            {
              this.error = true;
              this.imz = "pause music fail";
            }
          }
          else if (((String)localObject3).equalsIgnoreCase("seek"))
          {
            if (d < 0.0D)
            {
              ac.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "currentTime is invalid!");
              this.error = true;
              this.imz = "currentTime is invalid";
            }
            else if (com.tencent.mm.ay.a.pl((int)(1000.0D * d)))
            {
              ac.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "seek music ok");
            }
            else
            {
              this.error = true;
              this.imz = "seek music fail";
            }
          }
          else if (((String)localObject3).equalsIgnoreCase("stop"))
          {
            if (b.aGC())
            {
              ac.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "stop music ok");
            }
            else
            {
              this.error = true;
              this.imz = "stop music fail";
            }
          }
          else
          {
            ac.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is invalid");
            this.error = true;
            this.imz = "operationType is invalid";
          }
        }
      }
    }
    
    public final void aLr()
    {
      AppMethodBeat.i(145737);
      if (this.jYG == null)
      {
        ac.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "service is null, don't callback");
        AppMethodBeat.o(145737);
        return;
      }
      if (!this.error)
      {
        ac.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio ok");
        this.jYG.h(this.jOT, this.jXc.e("ok", null));
        AppMethodBeat.o(145737);
        return;
      }
      ac.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio fail:%s", new Object[] { this.imz });
      this.jYG.h(this.jOT, this.jXc.e("fail:" + this.imz, null));
      AppMethodBeat.o(145737);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(145738);
      this.appId = paramParcel.readString();
      this.kbW = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.error = bool;
        this.imz = paramParcel.readString();
        AppMethodBeat.o(145738);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145739);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.kbW);
      if (this.error) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.imz);
        AppMethodBeat.o(145739);
        return;
      }
    }
  }
  
  public static final class a
    extends ar
  {
    private static final int CTRL_INDEX = 162;
    private static final String NAME = "onBackgroundAudioNext";
    private static final a kbU;
    
    static
    {
      AppMethodBeat.i(145731);
      kbU = new a();
      AppMethodBeat.o(145731);
    }
    
    static void m(c paramc)
    {
      try
      {
        AppMethodBeat.i(145730);
        ac.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "onBackgroundAudioNext");
        kbU.h(paramc).beN();
        AppMethodBeat.o(145730);
        return;
      }
      finally
      {
        paramc = finally;
        throw paramc;
      }
    }
  }
  
  public static final class b
    extends ar
  {
    private static final int CTRL_INDEX = 162;
    private static final String NAME = "onBackgroundAudioPrev";
    private static final b kbV;
    
    static
    {
      AppMethodBeat.i(145733);
      kbV = new b();
      AppMethodBeat.o(145733);
    }
    
    static void m(c paramc)
    {
      try
      {
        AppMethodBeat.i(145732);
        ac.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "onBackgroundAudioPrev");
        kbV.h(paramc).beN();
        AppMethodBeat.o(145732);
        return;
      }
      finally
      {
        paramc = finally;
        throw paramc;
      }
    }
  }
  
  public static final class c
    extends ar
  {
    private static final int CTRL_INDEX = 162;
    private static final String NAME = "onBackgroundAudioStateChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio
 * JD-Core Version:    0.7.0.1
 */
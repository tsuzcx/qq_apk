package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.b;
import com.tencent.mm.az.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import org.json.JSONException;
import org.json.JSONObject;

public class JsApiOperateBackgroundAudio<CONTEXT extends c>
  extends com.tencent.mm.plugin.appbrand.jsapi.a<CONTEXT>
{
  public static final int CTRL_INDEX = 161;
  public static final String NAME = "operateBackgroundAudio";
  protected JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask kws;
  
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
      ad.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio data is null");
      AppMethodBeat.o(145741);
      return;
    }
    String str = paramCONTEXT.getAppId();
    ad.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio appId:%s", new Object[] { str });
    if (this.kws == null) {
      this.kws = a(this, paramCONTEXT, paramInt);
    }
    this.kws.kje = paramInt;
    this.kws.appId = str;
    l(paramCONTEXT);
    paramCONTEXT = new OperateBackgroundAudioTask(this, paramCONTEXT, paramInt);
    paramCONTEXT.kje = paramInt;
    paramCONTEXT.appId = str;
    paramCONTEXT.kwv = paramJSONObject.toString();
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
    public String iFQ;
    public int kje;
    private m kry;
    public c ktc;
    public String kwv;
    
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
      this.iFQ = "";
      e(paramParcel);
      AppMethodBeat.o(145735);
    }
    
    public OperateBackgroundAudioTask(com.tencent.mm.plugin.appbrand.jsapi.a parama, c paramc, int paramInt)
    {
      this.error = false;
      this.iFQ = "";
      this.kry = parama;
      this.ktc = paramc;
      this.kje = paramInt;
    }
    
    public final void aOA()
    {
      AppMethodBeat.i(145736);
      ad.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "runInMainProcess");
      Object localObject1 = a.a.bsD().lQW;
      if ((!bt.isNullOrNil((String)localObject1)) && (!((String)localObject1).equals(this.appId)))
      {
        ad.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[] { localObject1, this.appId });
        this.error = true;
        this.iFQ = "appid not match cannot operate";
        bhX();
        AppMethodBeat.o(145736);
        return;
      }
      Object localObject3;
      double d;
      try
      {
        localObject1 = new JSONObject(this.kwv);
        localObject3 = ((JSONObject)localObject1).optString("operationType");
        d = ((JSONObject)localObject1).optDouble("currentTime", -1.0D);
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          ad.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is null");
          this.error = true;
          this.iFQ = "operationType is null";
          bhX();
          AppMethodBeat.o(145736);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        ad.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "new json exists exception, data is invalid, jsonStr:%s", new Object[] { this.kwv });
        this.error = true;
        this.iFQ = "parser data fail, data is invalid";
        ad.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "exception:%s" + localJSONException.getMessage());
        bhX();
        AppMethodBeat.o(145736);
        return;
      }
      ad.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType;%s, currentTime:%f", new Object[] { localObject3, Double.valueOf(d) });
      this.error = false;
      Object localObject2;
      if (((String)localObject3).equalsIgnoreCase("play"))
      {
        localObject3 = a.a.bsD().lQY;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = com.tencent.mm.az.a.aJJ();
        }
        if (localObject2 != null) {
          a.a.bsD().lQX = ((f)localObject2).ihg;
        }
        if (b.aJL()) {
          ad.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "play music ok");
        }
      }
      for (;;)
      {
        if (this.error) {
          ad.e("MicroMsg.Music.JsApiOperateBackgroundAudio", this.iFQ);
        }
        bhX();
        AppMethodBeat.o(145736);
        return;
        if (com.tencent.mm.az.a.aJG())
        {
          this.error = true;
          this.iFQ = "music is playing, don't play again";
        }
        else if ((localObject2 != null) && (this.appId.equals(((f)localObject2).iht)))
        {
          ad.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "startPlayMusic play music ok, appId is same!");
          com.tencent.mm.az.a.c((f)localObject2);
        }
        else
        {
          this.error = true;
          this.iFQ = "play music fail";
          continue;
          if (((String)localObject3).equalsIgnoreCase("pause"))
          {
            if (b.aJM())
            {
              ad.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "pause music ok");
            }
            else
            {
              this.error = true;
              this.iFQ = "pause music fail";
            }
          }
          else if (((String)localObject3).equalsIgnoreCase("seek"))
          {
            if (d < 0.0D)
            {
              ad.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "currentTime is invalid!");
              this.error = true;
              this.iFQ = "currentTime is invalid";
            }
            else if (com.tencent.mm.az.a.pO((int)(1000.0D * d)))
            {
              ad.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "seek music ok");
            }
            else
            {
              this.error = true;
              this.iFQ = "seek music fail";
            }
          }
          else if (((String)localObject3).equalsIgnoreCase("stop"))
          {
            if (b.aJN())
            {
              ad.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "stop music ok");
            }
            else
            {
              this.error = true;
              this.iFQ = "stop music fail";
            }
          }
          else
          {
            ad.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is invalid");
            this.error = true;
            this.iFQ = "operationType is invalid";
          }
        }
      }
    }
    
    public final void aOB()
    {
      AppMethodBeat.i(145737);
      if (this.ktc == null)
      {
        ad.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "service is null, don't callback");
        AppMethodBeat.o(145737);
        return;
      }
      if (!this.error)
      {
        ad.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio ok");
        this.ktc.h(this.kje, this.kry.e("ok", null));
        AppMethodBeat.o(145737);
        return;
      }
      ad.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio fail:%s", new Object[] { this.iFQ });
      this.ktc.h(this.kje, this.kry.e("fail:" + this.iFQ, null));
      AppMethodBeat.o(145737);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(145738);
      this.appId = paramParcel.readString();
      this.kwv = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.error = bool;
        this.iFQ = paramParcel.readString();
        AppMethodBeat.o(145738);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145739);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.kwv);
      if (this.error) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.iFQ);
        AppMethodBeat.o(145739);
        return;
      }
    }
  }
  
  public static final class a
    extends at
  {
    private static final int CTRL_INDEX = 162;
    private static final String NAME = "onBackgroundAudioNext";
    private static final a kwt;
    
    static
    {
      AppMethodBeat.i(145731);
      kwt = new a();
      AppMethodBeat.o(145731);
    }
    
    static void m(c paramc)
    {
      try
      {
        AppMethodBeat.i(145730);
        ad.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "onBackgroundAudioNext");
        kwt.h(paramc).bir();
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
    extends at
  {
    private static final int CTRL_INDEX = 162;
    private static final String NAME = "onBackgroundAudioPrev";
    private static final b kwu;
    
    static
    {
      AppMethodBeat.i(145733);
      kwu = new b();
      AppMethodBeat.o(145733);
    }
    
    static void m(c paramc)
    {
      try
      {
        AppMethodBeat.i(145732);
        ad.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "onBackgroundAudioPrev");
        kwu.h(paramc).bir();
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
    extends at
  {
    private static final int CTRL_INDEX = 162;
    private static final String NAME = "onBackgroundAudioStateChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio
 * JD-Core Version:    0.7.0.1
 */
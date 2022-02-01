package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.b;
import com.tencent.mm.ay.f;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.at;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import org.json.JSONException;
import org.json.JSONObject;

public class JsApiOperateBackgroundAudio<CONTEXT extends c>
  extends com.tencent.mm.plugin.appbrand.jsapi.a<CONTEXT>
{
  public static final int CTRL_INDEX = 161;
  public static final String NAME = "operateBackgroundAudio";
  protected JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask kzH;
  
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
      ae.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio data is null");
      AppMethodBeat.o(145741);
      return;
    }
    String str = paramCONTEXT.getAppId();
    ae.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio appId:%s", new Object[] { str });
    if (this.kzH == null) {
      this.kzH = a(this, paramCONTEXT, paramInt);
    }
    this.kzH.kmu = paramInt;
    this.kzH.appId = str;
    l(paramCONTEXT);
    paramCONTEXT = new OperateBackgroundAudioTask(this, paramCONTEXT, paramInt);
    paramCONTEXT.kmu = paramInt;
    paramCONTEXT.appId = str;
    paramCONTEXT.kzK = paramJSONObject.toString();
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
    public String iIJ;
    public int kmu;
    private m kuO;
    public c kws;
    public String kzK;
    
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
      this.iIJ = "";
      e(paramParcel);
      AppMethodBeat.o(145735);
    }
    
    public OperateBackgroundAudioTask(com.tencent.mm.plugin.appbrand.jsapi.a parama, c paramc, int paramInt)
    {
      this.error = false;
      this.iIJ = "";
      this.kuO = parama;
      this.kws = paramc;
      this.kmu = paramInt;
    }
    
    public final void aOX()
    {
      AppMethodBeat.i(145736);
      ae.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "runInMainProcess");
      Object localObject1 = a.a.bto().lVx;
      if ((!bu.isNullOrNil((String)localObject1)) && (!((String)localObject1).equals(this.appId)))
      {
        ae.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[] { localObject1, this.appId });
        this.error = true;
        this.iIJ = "appid not match cannot operate";
        biG();
        AppMethodBeat.o(145736);
        return;
      }
      Object localObject3;
      double d;
      try
      {
        localObject1 = new JSONObject(this.kzK);
        localObject3 = ((JSONObject)localObject1).optString("operationType");
        d = ((JSONObject)localObject1).optDouble("currentTime", -1.0D);
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          ae.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is null");
          this.error = true;
          this.iIJ = "operationType is null";
          biG();
          AppMethodBeat.o(145736);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        ae.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "new json exists exception, data is invalid, jsonStr:%s", new Object[] { this.kzK });
        this.error = true;
        this.iIJ = "parser data fail, data is invalid";
        ae.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "exception:%s" + localJSONException.getMessage());
        biG();
        AppMethodBeat.o(145736);
        return;
      }
      ae.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType;%s, currentTime:%f", new Object[] { localObject3, Double.valueOf(d) });
      this.error = false;
      Object localObject2;
      if (((String)localObject3).equalsIgnoreCase("play"))
      {
        localObject3 = a.a.bto().lVz;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = com.tencent.mm.ay.a.aKc();
        }
        if (localObject2 != null) {
          a.a.bto().lVy = ((f)localObject2).ijZ;
        }
        if (b.aKe()) {
          ae.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "play music ok");
        }
      }
      for (;;)
      {
        if (this.error) {
          ae.e("MicroMsg.Music.JsApiOperateBackgroundAudio", this.iIJ);
        }
        biG();
        AppMethodBeat.o(145736);
        return;
        if (com.tencent.mm.ay.a.aJZ())
        {
          this.error = true;
          this.iIJ = "music is playing, don't play again";
        }
        else if ((localObject2 != null) && (this.appId.equals(((f)localObject2).ikm)))
        {
          ae.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "startPlayMusic play music ok, appId is same!");
          com.tencent.mm.ay.a.c((f)localObject2);
        }
        else
        {
          this.error = true;
          this.iIJ = "play music fail";
          continue;
          if (((String)localObject3).equalsIgnoreCase("pause"))
          {
            if (b.aKf())
            {
              ae.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "pause music ok");
            }
            else
            {
              this.error = true;
              this.iIJ = "pause music fail";
            }
          }
          else if (((String)localObject3).equalsIgnoreCase("seek"))
          {
            if (d < 0.0D)
            {
              ae.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "currentTime is invalid!");
              this.error = true;
              this.iIJ = "currentTime is invalid";
            }
            else if (com.tencent.mm.ay.a.pR((int)(1000.0D * d)))
            {
              ae.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "seek music ok");
            }
            else
            {
              this.error = true;
              this.iIJ = "seek music fail";
            }
          }
          else if (((String)localObject3).equalsIgnoreCase("stop"))
          {
            if (b.aKg())
            {
              ae.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "stop music ok");
            }
            else
            {
              this.error = true;
              this.iIJ = "stop music fail";
            }
          }
          else
          {
            ae.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is invalid");
            this.error = true;
            this.iIJ = "operationType is invalid";
          }
        }
      }
    }
    
    public final void aOY()
    {
      AppMethodBeat.i(145737);
      if (this.kws == null)
      {
        ae.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "service is null, don't callback");
        AppMethodBeat.o(145737);
        return;
      }
      if (!this.error)
      {
        ae.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio ok");
        this.kws.h(this.kmu, this.kuO.e("ok", null));
        AppMethodBeat.o(145737);
        return;
      }
      ae.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio fail:%s", new Object[] { this.iIJ });
      this.kws.h(this.kmu, this.kuO.e("fail:" + this.iIJ, null));
      AppMethodBeat.o(145737);
    }
    
    public final void e(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(145738);
      this.appId = paramParcel.readString();
      this.kzK = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.error = bool;
        this.iIJ = paramParcel.readString();
        AppMethodBeat.o(145738);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145739);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.kzK);
      if (this.error) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.iIJ);
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
    private static final a kzI;
    
    static
    {
      AppMethodBeat.i(145731);
      kzI = new a();
      AppMethodBeat.o(145731);
    }
    
    static void m(c paramc)
    {
      try
      {
        AppMethodBeat.i(145730);
        ae.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "onBackgroundAudioNext");
        kzI.h(paramc).bja();
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
    private static final b kzJ;
    
    static
    {
      AppMethodBeat.i(145733);
      kzJ = new b();
      AppMethodBeat.o(145733);
    }
    
    static void m(c paramc)
    {
      try
      {
        AppMethodBeat.i(145732);
        ae.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "onBackgroundAudioPrev");
        kzJ.h(paramc).bja();
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
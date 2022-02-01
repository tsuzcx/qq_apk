package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ay.b;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandMainProcessService;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.d;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class JsApiOperateBackgroundAudio<CONTEXT extends com.tencent.mm.plugin.appbrand.jsapi.f>
  extends d<CONTEXT>
{
  public static final int CTRL_INDEX = 161;
  public static final String NAME = "operateBackgroundAudio";
  protected JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask lEa;
  
  protected JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask a(d paramd, CONTEXT paramCONTEXT, int paramInt)
  {
    AppMethodBeat.i(145742);
    paramd = new JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask(this, paramCONTEXT, paramInt);
    AppMethodBeat.o(145742);
    return paramd;
  }
  
  public final void a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145741);
    if (paramJSONObject == null)
    {
      paramCONTEXT.i(paramInt, h("fail:data is null", null));
      Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio data is null");
      AppMethodBeat.o(145741);
      return;
    }
    String str = paramCONTEXT.getAppId();
    Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio appId:%s", new Object[] { str });
    if (this.lEa == null) {
      this.lEa = a(this, paramCONTEXT, paramInt);
    }
    this.lEa.lqe = paramInt;
    this.lEa.appId = str;
    l(paramCONTEXT);
    paramCONTEXT = new OperateBackgroundAudioTask(this, paramCONTEXT, paramInt);
    paramCONTEXT.lqe = paramInt;
    paramCONTEXT.appId = str;
    paramCONTEXT.lEd = paramJSONObject.toString();
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
    public String jFn;
    private p lAw;
    public com.tencent.mm.plugin.appbrand.jsapi.f lAx;
    public String lEd;
    public int lqe;
    
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
      this.jFn = "";
      f(paramParcel);
      AppMethodBeat.o(145735);
    }
    
    public OperateBackgroundAudioTask(d paramd, com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt)
    {
      this.error = false;
      this.jFn = "";
      this.lAw = paramd;
      this.lAx = paramf;
      this.lqe = paramInt;
    }
    
    public final void bjj()
    {
      AppMethodBeat.i(145736);
      Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "runInMainProcess");
      Object localObject1 = a.a.bOR().ncY;
      if ((!Util.isNullOrNil((String)localObject1)) && (!((String)localObject1).equals(this.appId)))
      {
        Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[] { localObject1, this.appId });
        this.error = true;
        this.jFn = "appid not match cannot operate";
        bDU();
        AppMethodBeat.o(145736);
        return;
      }
      Object localObject3;
      double d;
      try
      {
        localObject1 = new JSONObject(this.lEd);
        localObject3 = ((JSONObject)localObject1).optString("operationType");
        d = ((JSONObject)localObject1).optDouble("currentTime", -1.0D);
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is null");
          this.error = true;
          this.jFn = "operationType is null";
          bDU();
          AppMethodBeat.o(145736);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "new json exists exception, data is invalid, jsonStr:%s", new Object[] { this.lEd });
        this.error = true;
        this.jFn = "parser data fail, data is invalid";
        Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "exception:%s" + localJSONException.getMessage());
        bDU();
        AppMethodBeat.o(145736);
        return;
      }
      Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType;%s, currentTime:%f", new Object[] { localObject3, Double.valueOf(d) });
      this.error = false;
      Object localObject2;
      if (((String)localObject3).equalsIgnoreCase("play"))
      {
        localObject3 = a.a.bOR().nda;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = com.tencent.mm.ay.a.bef();
        }
        if (localObject2 != null) {
          a.a.bOR().ncZ = ((com.tencent.mm.ay.f)localObject2).jeV;
        }
        if (b.beh()) {
          Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "play music ok");
        }
      }
      for (;;)
      {
        if (this.error) {
          Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", this.jFn);
        }
        bDU();
        AppMethodBeat.o(145736);
        return;
        if (com.tencent.mm.ay.a.bec())
        {
          this.error = true;
          this.jFn = "music is playing, don't play again";
        }
        else if ((localObject2 != null) && (this.appId.equals(((com.tencent.mm.ay.f)localObject2).jfi)))
        {
          Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "startPlayMusic play music ok, appId is same!");
          com.tencent.mm.ay.a.c((com.tencent.mm.ay.f)localObject2);
        }
        else
        {
          this.error = true;
          this.jFn = "play music fail";
          continue;
          if (((String)localObject3).equalsIgnoreCase("pause"))
          {
            if (b.bei())
            {
              Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "pause music ok");
            }
            else
            {
              this.error = true;
              this.jFn = "pause music fail";
            }
          }
          else if (((String)localObject3).equalsIgnoreCase("seek"))
          {
            if (d < 0.0D)
            {
              Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "currentTime is invalid!");
              this.error = true;
              this.jFn = "currentTime is invalid";
            }
            else if (com.tencent.mm.ay.a.tG((int)(1000.0D * d)))
            {
              Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "seek music ok");
            }
            else
            {
              this.error = true;
              this.jFn = "seek music fail";
            }
          }
          else if (((String)localObject3).equalsIgnoreCase("stop"))
          {
            if (b.bej())
            {
              Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "stop music ok");
            }
            else
            {
              this.error = true;
              this.jFn = "stop music fail";
            }
          }
          else
          {
            Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is invalid");
            this.error = true;
            this.jFn = "operationType is invalid";
          }
        }
      }
    }
    
    public final void bjk()
    {
      AppMethodBeat.i(145737);
      if (this.lAx == null)
      {
        Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "service is null, don't callback");
        AppMethodBeat.o(145737);
        return;
      }
      if (!this.error)
      {
        Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio ok");
        this.lAx.i(this.lqe, this.lAw.h("ok", null));
        AppMethodBeat.o(145737);
        return;
      }
      Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio fail:%s", new Object[] { this.jFn });
      this.lAx.i(this.lqe, this.lAw.h("fail:" + this.jFn, null));
      AppMethodBeat.o(145737);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(145738);
      this.appId = paramParcel.readString();
      this.lEd = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.error = bool;
        this.jFn = paramParcel.readString();
        AppMethodBeat.o(145738);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145739);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.lEd);
      if (this.error) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.jFn);
        AppMethodBeat.o(145739);
        return;
      }
    }
  }
  
  public static final class a
    extends bc
  {
    private static final int CTRL_INDEX = 162;
    private static final String NAME = "onBackgroundAudioNext";
    private static final a lEb;
    
    static
    {
      AppMethodBeat.i(145731);
      lEb = new a();
      AppMethodBeat.o(145731);
    }
    
    static void m(com.tencent.mm.plugin.appbrand.jsapi.f paramf)
    {
      try
      {
        AppMethodBeat.i(145730);
        Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "onBackgroundAudioNext");
        lEb.h(paramf).bEo();
        AppMethodBeat.o(145730);
        return;
      }
      finally
      {
        paramf = finally;
        throw paramf;
      }
    }
  }
  
  public static final class b
    extends bc
  {
    private static final int CTRL_INDEX = 162;
    private static final String NAME = "onBackgroundAudioPrev";
    private static final b lEc;
    
    static
    {
      AppMethodBeat.i(145733);
      lEc = new b();
      AppMethodBeat.o(145733);
    }
    
    static void m(com.tencent.mm.plugin.appbrand.jsapi.f paramf)
    {
      try
      {
        AppMethodBeat.i(145732);
        Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "onBackgroundAudioPrev");
        lEc.h(paramf).bEo();
        AppMethodBeat.o(145732);
        return;
      }
      finally
      {
        paramf = finally;
        throw paramf;
      }
    }
  }
  
  public static final class c
    extends bc
  {
    private static final int CTRL_INDEX = 162;
    private static final String NAME = "onBackgroundAudioStateChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio
 * JD-Core Version:    0.7.0.1
 */
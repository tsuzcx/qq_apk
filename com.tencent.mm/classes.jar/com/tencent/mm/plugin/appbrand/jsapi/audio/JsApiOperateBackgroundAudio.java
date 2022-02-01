package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class JsApiOperateBackgroundAudio<CONTEXT extends com.tencent.mm.plugin.appbrand.jsapi.f>
  extends c<CONTEXT>
{
  public static final int CTRL_INDEX = 161;
  public static final String NAME = "operateBackgroundAudio";
  protected JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask rDu;
  
  protected JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask a(c paramc, CONTEXT paramCONTEXT, int paramInt)
  {
    AppMethodBeat.i(145742);
    paramc = new JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask(this, paramCONTEXT, paramInt);
    AppMethodBeat.o(145742);
    return paramc;
  }
  
  public final void a(CONTEXT paramCONTEXT, JSONObject paramJSONObject, int paramInt)
  {
    AppMethodBeat.i(145741);
    if (paramJSONObject == null)
    {
      paramCONTEXT.callback(paramInt, ZP("fail:data is null"));
      Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio data is null");
      AppMethodBeat.o(145741);
      return;
    }
    String str = paramCONTEXT.getAppId();
    Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio appId:%s", new Object[] { str });
    if (this.rDu == null) {
      this.rDu = a(this, paramCONTEXT, paramInt);
    }
    this.rDu.ror = paramInt;
    this.rDu.appId = str;
    p(paramCONTEXT);
    paramCONTEXT = new OperateBackgroundAudioTask(this, paramCONTEXT, paramInt);
    paramCONTEXT.ror = paramInt;
    paramCONTEXT.appId = str;
    paramCONTEXT.rDx = paramJSONObject.toString();
    paramCONTEXT.bQt();
    AppMethodBeat.o(145741);
  }
  
  protected void p(CONTEXT paramCONTEXT) {}
  
  protected static class OperateBackgroundAudioTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<OperateBackgroundAudioTask> CREATOR;
    public String appId;
    public boolean error;
    public String ppp;
    public String rDx;
    public int ror;
    private p rzh;
    public com.tencent.mm.plugin.appbrand.jsapi.f rzi;
    
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
      this.ppp = "";
      h(paramParcel);
      AppMethodBeat.o(145735);
    }
    
    public OperateBackgroundAudioTask(c paramc, com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt)
    {
      this.error = false;
      this.ppp = "";
      this.rzh = paramc;
      this.rzi = paramf;
      this.ror = paramInt;
    }
    
    public final void asn()
    {
      AppMethodBeat.i(145736);
      Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "runInMainProcess");
      Object localObject1 = a.a.cBB().tib;
      if ((!Util.isNullOrNil((String)localObject1)) && (!((String)localObject1).equals(this.appId)))
      {
        Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[] { localObject1, this.appId });
        this.error = true;
        this.ppp = "appid not match cannot operate";
        cpA();
        AppMethodBeat.o(145736);
        return;
      }
      Object localObject3;
      double d;
      try
      {
        localObject1 = new JSONObject(this.rDx);
        localObject3 = ((JSONObject)localObject1).optString("operationType");
        d = ((JSONObject)localObject1).optDouble("currentTime", -1.0D);
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is null");
          this.error = true;
          this.ppp = "operationType is null";
          cpA();
          AppMethodBeat.o(145736);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "new json exists exception, data is invalid, jsonStr:%s", new Object[] { this.rDx });
        this.error = true;
        this.ppp = "parser data fail, data is invalid";
        Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "exception:%s" + localJSONException.getMessage());
        cpA();
        AppMethodBeat.o(145736);
        return;
      }
      Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType;%s, currentTime:%f", new Object[] { localObject3, Double.valueOf(d) });
      this.error = false;
      Object localObject2;
      if (((String)localObject3).equalsIgnoreCase("play"))
      {
        localObject3 = a.a.cBB().tie;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = com.tencent.mm.aw.a.bLn();
        }
        if (localObject2 != null) {
          a.a.cBB().tic = ((com.tencent.mm.aw.f)localObject2).oOv;
        }
        if (b.bLp()) {
          Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "play music ok");
        }
      }
      for (;;)
      {
        if (this.error) {
          Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", this.ppp);
        }
        cpA();
        AppMethodBeat.o(145736);
        return;
        if (com.tencent.mm.aw.a.bLk())
        {
          this.error = true;
          this.ppp = "music is playing, don't play again";
        }
        else if ((localObject2 != null) && (this.appId.equals(((com.tencent.mm.aw.f)localObject2).oOI)))
        {
          Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "startPlayMusic play music ok, appId is same!");
          com.tencent.mm.aw.a.c((com.tencent.mm.aw.f)localObject2);
        }
        else
        {
          this.error = true;
          this.ppp = "play music fail";
          continue;
          if (((String)localObject3).equalsIgnoreCase("pause"))
          {
            if (b.bLq())
            {
              Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "pause music ok");
            }
            else
            {
              this.error = true;
              this.ppp = "pause music fail";
            }
          }
          else if (((String)localObject3).equalsIgnoreCase("seek"))
          {
            if (d < 0.0D)
            {
              Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "currentTime is invalid!");
              this.error = true;
              this.ppp = "currentTime is invalid";
            }
            else if (com.tencent.mm.aw.a.wH((int)(1000.0D * d)))
            {
              Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "seek music ok");
            }
            else
            {
              this.error = true;
              this.ppp = "seek music fail";
            }
          }
          else if (((String)localObject3).equalsIgnoreCase("stop"))
          {
            if (b.bLr())
            {
              Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "stop music ok");
            }
            else
            {
              this.error = true;
              this.ppp = "stop music fail";
            }
          }
          else
          {
            Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is invalid");
            this.error = true;
            this.ppp = "operationType is invalid";
          }
        }
      }
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(145737);
      if (this.rzi == null)
      {
        Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "service is null, don't callback");
        AppMethodBeat.o(145737);
        return;
      }
      if (!this.error)
      {
        Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio ok");
        this.rzi.callback(this.ror, this.rzh.ZP("ok"));
      }
      for (;;)
      {
        cpx();
        AppMethodBeat.o(145737);
        return;
        Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio fail:%s", new Object[] { this.ppp });
        this.rzi.callback(this.ror, this.rzh.ZP("fail:" + this.ppp));
      }
    }
    
    public final void h(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(145738);
      this.appId = paramParcel.readString();
      this.rDx = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.error = bool;
        this.ppp = paramParcel.readString();
        AppMethodBeat.o(145738);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145739);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.rDx);
      if (this.error) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.ppp);
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
    private static final a rDv;
    
    static
    {
      AppMethodBeat.i(145731);
      rDv = new a();
      AppMethodBeat.o(145731);
    }
    
    static void q(com.tencent.mm.plugin.appbrand.jsapi.f paramf)
    {
      try
      {
        AppMethodBeat.i(145730);
        Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "onBackgroundAudioNext");
        rDv.i(paramf).cpV();
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
    private static final b rDw;
    
    static
    {
      AppMethodBeat.i(145733);
      rDw = new b();
      AppMethodBeat.o(145733);
    }
    
    static void q(com.tencent.mm.plugin.appbrand.jsapi.f paramf)
    {
      try
      {
        AppMethodBeat.i(145732);
        Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "onBackgroundAudioPrev");
        rDw.i(paramf).cpV();
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
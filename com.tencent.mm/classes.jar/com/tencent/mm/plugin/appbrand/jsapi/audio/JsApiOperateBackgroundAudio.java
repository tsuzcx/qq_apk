package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.b;
import com.tencent.mm.bb.f;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import org.json.JSONException;
import org.json.JSONObject;

public class JsApiOperateBackgroundAudio<CONTEXT extends e>
  extends c<CONTEXT>
{
  public static final int CTRL_INDEX = 161;
  public static final String NAME = "operateBackgroundAudio";
  protected JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask ozB;
  
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
      paramCONTEXT.j(paramInt, h("fail:data is null", null));
      Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio data is null");
      AppMethodBeat.o(145741);
      return;
    }
    String str = paramCONTEXT.getAppId();
    Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio appId:%s", new Object[] { str });
    if (this.ozB == null) {
      this.ozB = a(this, paramCONTEXT, paramInt);
    }
    this.ozB.okO = paramInt;
    this.ozB.appId = str;
    n(paramCONTEXT);
    paramCONTEXT = new OperateBackgroundAudioTask(this, paramCONTEXT, paramInt);
    paramCONTEXT.okO = paramInt;
    paramCONTEXT.appId = str;
    paramCONTEXT.ozE = paramJSONObject.toString();
    paramCONTEXT.bsM();
    AppMethodBeat.o(145741);
  }
  
  protected void n(CONTEXT paramCONTEXT) {}
  
  protected static class OperateBackgroundAudioTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<OperateBackgroundAudioTask> CREATOR;
    public String appId;
    public boolean error;
    public String mvQ;
    public int okO;
    private o ovN;
    public e ovO;
    public String ozE;
    
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
      this.mvQ = "";
      f(paramParcel);
      AppMethodBeat.o(145735);
    }
    
    public OperateBackgroundAudioTask(c paramc, e parame, int paramInt)
    {
      this.error = false;
      this.mvQ = "";
      this.ovN = paramc;
      this.ovO = parame;
      this.okO = paramInt;
    }
    
    public final void RW()
    {
      AppMethodBeat.i(145736);
      Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "runInMainProcess");
      Object localObject1 = a.a.cbh().qdn;
      if ((!Util.isNullOrNil((String)localObject1)) && (!((String)localObject1).equals(this.appId)))
      {
        Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[] { localObject1, this.appId });
        this.error = true;
        this.mvQ = "appid not match cannot operate";
        bPt();
        AppMethodBeat.o(145736);
        return;
      }
      Object localObject3;
      double d;
      try
      {
        localObject1 = new JSONObject(this.ozE);
        localObject3 = ((JSONObject)localObject1).optString("operationType");
        d = ((JSONObject)localObject1).optDouble("currentTime", -1.0D);
        if (TextUtils.isEmpty((CharSequence)localObject3))
        {
          Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is null");
          this.error = true;
          this.mvQ = "operationType is null";
          bPt();
          AppMethodBeat.o(145736);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "new json exists exception, data is invalid, jsonStr:%s", new Object[] { this.ozE });
        this.error = true;
        this.mvQ = "parser data fail, data is invalid";
        Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "exception:%s" + localJSONException.getMessage());
        bPt();
        AppMethodBeat.o(145736);
        return;
      }
      Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType;%s, currentTime:%f", new Object[] { localObject3, Double.valueOf(d) });
      this.error = false;
      Object localObject2;
      if (((String)localObject3).equalsIgnoreCase("play"))
      {
        localObject3 = a.a.cbh().qdp;
        localObject2 = localObject3;
        if (localObject3 == null) {
          localObject2 = com.tencent.mm.bb.a.bnA();
        }
        if (localObject2 != null) {
          a.a.cbh().qdo = ((f)localObject2).lVt;
        }
        if (b.bnC()) {
          Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "play music ok");
        }
      }
      for (;;)
      {
        if (this.error) {
          Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", this.mvQ);
        }
        bPt();
        AppMethodBeat.o(145736);
        return;
        if (com.tencent.mm.bb.a.bnx())
        {
          this.error = true;
          this.mvQ = "music is playing, don't play again";
        }
        else if ((localObject2 != null) && (this.appId.equals(((f)localObject2).lVG)))
        {
          Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "startPlayMusic play music ok, appId is same!");
          com.tencent.mm.bb.a.c((f)localObject2);
        }
        else
        {
          this.error = true;
          this.mvQ = "play music fail";
          continue;
          if (((String)localObject3).equalsIgnoreCase("pause"))
          {
            if (b.bnD())
            {
              Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "pause music ok");
            }
            else
            {
              this.error = true;
              this.mvQ = "pause music fail";
            }
          }
          else if (((String)localObject3).equalsIgnoreCase("seek"))
          {
            if (d < 0.0D)
            {
              Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "currentTime is invalid!");
              this.error = true;
              this.mvQ = "currentTime is invalid";
            }
            else if (com.tencent.mm.bb.a.wG((int)(1000.0D * d)))
            {
              Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "seek music ok");
            }
            else
            {
              this.error = true;
              this.mvQ = "seek music fail";
            }
          }
          else if (((String)localObject3).equalsIgnoreCase("stop"))
          {
            if (b.bnE())
            {
              Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "stop music ok");
            }
            else
            {
              this.error = true;
              this.mvQ = "stop music fail";
            }
          }
          else
          {
            Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operationType is invalid");
            this.error = true;
            this.mvQ = "operationType is invalid";
          }
        }
      }
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(145737);
      if (this.ovO == null)
      {
        Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "service is null, don't callback");
        AppMethodBeat.o(145737);
        return;
      }
      if (!this.error)
      {
        Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio ok");
        this.ovO.j(this.okO, this.ovN.h("ok", null));
        AppMethodBeat.o(145737);
        return;
      }
      Log.e("MicroMsg.Music.JsApiOperateBackgroundAudio", "operateBackgroundAudio fail:%s", new Object[] { this.mvQ });
      this.ovO.j(this.okO, this.ovN.h("fail:" + this.mvQ, null));
      AppMethodBeat.o(145737);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(145738);
      this.appId = paramParcel.readString();
      this.ozE = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.error = bool;
        this.mvQ = paramParcel.readString();
        AppMethodBeat.o(145738);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145739);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.ozE);
      if (this.error) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.mvQ);
        AppMethodBeat.o(145739);
        return;
      }
    }
  }
  
  public static final class a
    extends az
  {
    private static final int CTRL_INDEX = 162;
    private static final String NAME = "onBackgroundAudioNext";
    private static final a ozC;
    
    static
    {
      AppMethodBeat.i(145731);
      ozC = new a();
      AppMethodBeat.o(145731);
    }
    
    static void o(e parame)
    {
      try
      {
        AppMethodBeat.i(145730);
        Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "onBackgroundAudioNext");
        ozC.j(parame).bPO();
        AppMethodBeat.o(145730);
        return;
      }
      finally
      {
        parame = finally;
        throw parame;
      }
    }
  }
  
  public static final class b
    extends az
  {
    private static final int CTRL_INDEX = 162;
    private static final String NAME = "onBackgroundAudioPrev";
    private static final b ozD;
    
    static
    {
      AppMethodBeat.i(145733);
      ozD = new b();
      AppMethodBeat.o(145733);
    }
    
    static void o(e parame)
    {
      try
      {
        AppMethodBeat.i(145732);
        Log.i("MicroMsg.Music.JsApiOperateBackgroundAudio", "onBackgroundAudioPrev");
        ozD.j(parame).bPO();
        AppMethodBeat.o(145732);
        return;
      }
      finally
      {
        parame = finally;
        throw parame;
      }
    }
  }
  
  public static final class c
    extends az
  {
    private static final int CTRL_INDEX = 162;
    private static final String NAME = "onBackgroundAudioStateChange";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiOperateBackgroundAudio
 * JD-Core Version:    0.7.0.1
 */
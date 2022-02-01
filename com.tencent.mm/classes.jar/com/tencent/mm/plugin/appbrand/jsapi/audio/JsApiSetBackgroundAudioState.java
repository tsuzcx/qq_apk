package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Pair;
import androidx.lifecycle.q;
import com.tencent.luggage.a.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ox;
import com.tencent.mm.aw.g;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.p;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.a;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;

public class JsApiSetBackgroundAudioState
  extends com.tencent.mm.plugin.appbrand.jsapi.c
{
  public static final int CTRL_INDEX = 160;
  public static final String NAME = "setBackgroundAudioState";
  protected SetBackgroundAudioListenerTask rDu;
  
  protected SetBackgroundAudioListenerTask a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt)
  {
    AppMethodBeat.i(145773);
    paramc = new SetBackgroundAudioListenerTask(this, paramf, paramInt);
    AppMethodBeat.o(145773);
    return paramc;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.f paramf, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(145770);
    if (paramJSONObject == null)
    {
      paramf.callback(paramInt, ZP("fail:data is null"));
      Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState data is null");
      AppMethodBeat.o(145770);
      return;
    }
    Object localObject1 = paramf.getAppId();
    Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState appId:%s ,data:%s", new Object[] { localObject1, paramJSONObject.toString() });
    if (this.rDu == null) {
      this.rDu = a(this, paramf, paramInt);
    }
    this.rDu.ror = paramInt;
    this.rDu.appId = ((String)localObject1);
    SetBackgroundAudioListenerTask.a(this.rDu);
    ??? = ad.Jo("AppBrandService#" + paramf.hashCode());
    b((String)???, paramf);
    com.tencent.mm.plugin.appbrand.jsapi.y.a locala;
    for (;;)
    {
      synchronized (ad.bCb().M((String)???, true))
      {
        if ((k.c)((ad.b)???).get("AppBrandLifeCycle.Listener", null) == null)
        {
          localObject3 = new k.c()
          {
            public final void onDestroy()
            {
              AppMethodBeat.i(145750);
              String str = this.rDy.getString("appId", "");
              Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "onDestroy, appId:%s", new Object[] { str });
              JSONObject localJSONObject = new JSONObject();
              try
              {
                localJSONObject.put("operationType", "stop");
                label49:
                JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask localSetBackgroundAudioStateTask = new JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask(JsApiSetBackgroundAudioState.this, paramf, paramInt);
                localSetBackgroundAudioStateTask.rDx = localJSONObject.toString();
                localSetBackgroundAudioStateTask.appId = str;
                localSetBackgroundAudioStateTask.cpB();
                AppMethodBeat.o(145750);
                return;
              }
              catch (JSONException localJSONException)
              {
                break label49;
              }
            }
          };
          ((ad.b)???).q("AppBrandLifeCycle.Listener", localObject3);
          ((ad.b)???).q("appId", localObject1);
          this.rDu.eok = ((k.c)localObject3);
        }
        this.rDu.bQt();
        Object localObject3 = b(this, paramf, paramInt);
        ((SetBackgroundAudioStateTask)localObject3).ror = paramInt;
        ((SetBackgroundAudioStateTask)localObject3).appId = ((String)localObject1);
        ((SetBackgroundAudioStateTask)localObject3).rDx = paramJSONObject.toString();
        ??? = paramJSONObject.optString("src");
        if ((??? == null) || (((String)???).length() <= 0))
        {
          localObject1 = "";
          ((SetBackgroundAudioStateTask)localObject3).hTM = ((String)localObject1);
          locala = (com.tencent.mm.plugin.appbrand.jsapi.y.a)e.T(com.tencent.mm.plugin.appbrand.jsapi.y.a.class);
          if (locala != null) {
            break;
          }
          Log.w("MicroMsg.Music.JsApiSetBackgroundAudioState", "getReferrers, referrerHelper is null");
          paramf = new Pair(null, "invalidReferrer");
          ((SetBackgroundAudioStateTask)localObject3).oru = ((String)paramf.first);
          ((SetBackgroundAudioStateTask)localObject3).orv = ((String)paramf.second);
          ((SetBackgroundAudioStateTask)localObject3).bQt();
          AppMethodBeat.o(145770);
          return;
        }
      }
      localObject1 = ???;
      if (!((String)???).startsWith("http://"))
      {
        localObject1 = ???;
        if (!((String)???).startsWith("https://"))
        {
          localObject1 = paramf.getFileSystem().Wm((String)???);
          if ((localObject1 != null) && (((u)localObject1).jKS()))
          {
            ??? = ah.v(((u)localObject1).jKT());
            localObject1 = ???;
            if (!((String)???).startsWith("file://")) {
              localObject1 = "file://".concat(String.valueOf(???));
            }
          }
          else
          {
            localObject1 = "";
          }
        }
      }
    }
    ??? = locala.at(paramJSONObject);
    if (??? != null)
    {
      localObject1 = locala.abv((String)???);
      paramJSONObject = (JSONObject)localObject1;
      if (localObject1 == null) {
        paramJSONObject = locala.C(paramf);
      }
      if (com.tencent.mm.plugin.appbrand.jsapi.y.c.srt == paramJSONObject) {
        paramf = null;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "getReferrers, referrerPolicyStr: %s, referrer: %s", new Object[] { ???, paramf });
      paramf = new Pair(???, paramf);
      break;
      if (com.tencent.mm.plugin.appbrand.jsapi.y.c.srs == paramJSONObject) {
        paramf = locala.D(paramf);
      } else {
        paramf = "invalidReferrer";
      }
    }
  }
  
  protected SetBackgroundAudioStateTask b(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt)
  {
    AppMethodBeat.i(145772);
    paramc = new SetBackgroundAudioStateTask(this, paramf, paramInt);
    AppMethodBeat.o(145772);
    return paramc;
  }
  
  protected void b(String paramString, com.tencent.mm.plugin.appbrand.jsapi.f paramf) {}
  
  public static class SetBackgroundAudioListenerTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<SetBackgroundAudioListenerTask> CREATOR;
    public int action;
    public String appId;
    public String appUserName;
    k.c eok;
    public String hEy;
    public int hJK;
    public String rDE;
    private final IListener rDF;
    private boolean rEg;
    public int ror;
    private p rzh;
    public com.tencent.mm.plugin.appbrand.jsapi.f rzi;
    
    static
    {
      AppMethodBeat.i(145761);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(145761);
    }
    
    public SetBackgroundAudioListenerTask(Parcel paramParcel)
    {
      AppMethodBeat.i(145754);
      this.rEg = false;
      this.rDF = new IListener(com.tencent.mm.app.f.hfK) {};
      h(paramParcel);
      AppMethodBeat.o(145754);
    }
    
    public SetBackgroundAudioListenerTask(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt)
    {
      AppMethodBeat.i(145753);
      this.rEg = false;
      this.rDF = new IListener(com.tencent.mm.app.f.hfK) {};
      this.rzh = paramc;
      this.rzi = paramf;
      this.ror = paramInt;
      AppMethodBeat.o(145753);
    }
    
    protected void Ar(int paramInt) {}
    
    public final void asn()
    {
      AppMethodBeat.i(145755);
      Log.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInMainProcess");
      if (this.rEg)
      {
        Log.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "send Preempted Event");
        this.rEg = false;
        localObject = new ox();
        ((ox)localObject).hRN.action = 10;
        ((ox)localObject).hRN.state = "preempted";
        ((ox)localObject).hRN.appId = this.appId;
        ((ox)localObject).hRN.hRO = true;
        ((ox)localObject).publish();
      }
      Object localObject = a.a.cBB().tib;
      if (!Util.isNullOrNil((String)localObject))
      {
        Log.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "remove listener preAppid is %s, appid is %s", new Object[] { localObject, this.appId });
        a.a.cBB().adD((String)localObject);
      }
      a.a.cBB().a(this.rDF, this.appId);
      localObject = a.a.cBB();
      String str1 = this.appId;
      int i = this.hJK;
      String str2 = this.hEy;
      String str3 = this.appUserName;
      ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).tib = str1;
      ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).hJK = i;
      ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).hEy = str2;
      ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).appUserName = str3;
      AppMethodBeat.o(145755);
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(145756);
      if (this.rzi == null)
      {
        Log.e("MicroMsg.Music.SetBackgroundAudioListenerTask", "service is null, don't callback");
        AppMethodBeat.o(145756);
        return;
      }
      Ar(this.action);
      AppBrandMusicClientService localAppBrandMusicClientService;
      int i;
      Iterator localIterator;
      switch (this.action)
      {
      case 5: 
      case 6: 
      case 8: 
      case 9: 
      case 10: 
      case 11: 
      case 12: 
      default: 
        Log.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInClientProcess callback action:%d, retJson:%s", new Object[] { Integer.valueOf(this.action), this.rDE });
        new JsApiOperateBackgroundAudio.c().i(this.rzi).ZR(this.rDE).cpV();
        localAppBrandMusicClientService = AppBrandMusicClientService.thY;
        i = this.action;
        Log.i("MicroMsg.AppBrandMusicClientService", "notifyAction, action:%d", new Object[] { Integer.valueOf(i) });
        localIterator = localAppBrandMusicClientService.thX.entrySet().iterator();
      }
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label394;
        }
        Object localObject = (Map.Entry)localIterator.next();
        if (localObject != null)
        {
          String str = (String)((Map.Entry)localObject).getKey();
          localObject = (AppBrandMusicClientService.a)((Map.Entry)localObject).getValue();
          if ((!TextUtils.isEmpty(localAppBrandMusicClientService.thZ)) && (localAppBrandMusicClientService.thZ.equalsIgnoreCase(str)))
          {
            Log.i("MicroMsg.AppBrandMusicClientService", "current play music appId is %s", new Object[] { localAppBrandMusicClientService.thZ });
            if (localObject != null)
            {
              if (i == 10)
              {
                ((AppBrandMusicClientService.a)localObject).chO();
                continue;
                k.a(this.appId, this.eok);
                AppBrandMusicClientService.thY.thZ = this.appId;
                break;
                k.b(this.appId, this.eok);
                break;
                JsApiOperateBackgroundAudio.b.q(this.rzi);
                AppMethodBeat.o(145756);
                return;
                JsApiOperateBackgroundAudio.a.q(this.rzi);
                AppMethodBeat.o(145756);
                return;
              }
              if (i == 2) {
                ((AppBrandMusicClientService.a)localObject).onStop();
              }
            }
          }
        }
      }
      label394:
      AppMethodBeat.o(145756);
    }
    
    public final void h(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(145757);
      this.appId = paramParcel.readString();
      this.rDE = paramParcel.readString();
      this.action = paramParcel.readInt();
      this.hJK = paramParcel.readInt();
      this.hEy = paramParcel.readString();
      this.appUserName = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.rEg = bool;
        AppMethodBeat.o(145757);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145758);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.rDE);
      paramParcel.writeInt(this.action);
      paramParcel.writeInt(this.hJK);
      paramParcel.writeString(this.hEy);
      paramParcel.writeString(this.appUserName);
      if (this.rEg) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        AppMethodBeat.o(145758);
        return;
      }
    }
  }
  
  public static class SetBackgroundAudioStateTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<SetBackgroundAudioStateTask> CREATOR;
    public String appId;
    public boolean error;
    public String hTM;
    public String oru;
    public String orv;
    public String ppp;
    public String rDx;
    public int ror;
    private p rzh;
    public com.tencent.mm.plugin.appbrand.jsapi.f rzi;
    
    static
    {
      AppMethodBeat.i(145769);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(145769);
    }
    
    public SetBackgroundAudioStateTask(Parcel paramParcel)
    {
      AppMethodBeat.i(145763);
      this.error = false;
      this.ppp = "";
      this.oru = null;
      this.orv = null;
      h(paramParcel);
      AppMethodBeat.o(145763);
    }
    
    public SetBackgroundAudioStateTask(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.jsapi.f paramf, int paramInt)
    {
      this.error = false;
      this.ppp = "";
      this.oru = null;
      this.orv = null;
      this.rzh = paramc;
      this.rzi = paramf;
      this.ror = paramInt;
    }
    
    public String ZY(String paramString)
    {
      AppMethodBeat.i(145764);
      paramString = com.tencent.mm.loader.i.b.bmz() + "/image/" + paramString.hashCode();
      AppMethodBeat.o(145764);
      return paramString;
    }
    
    public final void asn()
    {
      AppMethodBeat.i(145765);
      Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess");
      String str4;
      String str5;
      String str6;
      String str7;
      String str1;
      String str8;
      String str2;
      double d2;
      String str3;
      double d1;
      double d3;
      try
      {
        Object localObject1 = new JSONObject(this.rDx);
        str4 = ((JSONObject)localObject1).optString("src");
        str5 = ((JSONObject)localObject1).optString("title");
        str6 = ((JSONObject)localObject1).optString("epname");
        str7 = ((JSONObject)localObject1).optString("singer");
        str1 = ((JSONObject)localObject1).optString("coverImgUrl");
        str8 = ((JSONObject)localObject1).optString("webUrl");
        str2 = ((JSONObject)localObject1).optString("protocol");
        d2 = ((JSONObject)localObject1).optDouble("startTime", 0.0D);
        str3 = ((JSONObject)localObject1).optString("songLyric");
        d1 = ((JSONObject)localObject1).optDouble("playbackRate", 1.0D);
        d3 = ((JSONObject)localObject1).optDouble("volume", 1.0D);
        localObject1 = ((JSONObject)localObject1).optString("operationType");
        if (TextUtils.isEmpty((CharSequence)localObject1)) {
          break label361;
        }
        Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "come from onStickyBannerChanged pause or lifeCycleListener onDestroy");
        str1 = a.a.cBB().tib;
        if ((!Util.isNullOrNil(str1)) && (!str1.equals(this.appId)))
        {
          Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "appid not match cannot operate, preAppId:%s, appId:%s", new Object[] { str1, this.appId });
          AppMethodBeat.o(145765);
          return;
        }
      }
      catch (JSONException localJSONException)
      {
        Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "new json exists exception, data is invalid");
        this.error = true;
        this.ppp = "parser data fail, data is invalid";
        Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "exception:%s" + localJSONException.getMessage());
        cpA();
        AppMethodBeat.o(145765);
        return;
      }
      this.error = false;
      if (localJSONException.equalsIgnoreCase("pause"))
      {
        if (com.tencent.mm.aw.b.bLq())
        {
          Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "pause music ok");
          AppMethodBeat.o(145765);
          return;
        }
        this.error = true;
        this.ppp = "pause music fail";
      }
      for (;;)
      {
        cpA();
        AppMethodBeat.o(145765);
        return;
        if (localJSONException.equalsIgnoreCase("stop"))
        {
          if (com.tencent.mm.aw.b.bLr())
          {
            Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "stop music ok");
            AppMethodBeat.o(145765);
            return;
          }
          this.error = true;
          this.ppp = "stop music fail";
        }
      }
      label361:
      if (TextUtils.isEmpty(str4))
      {
        Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "src is null");
        this.error = true;
        this.ppp = "src is null";
        cpA();
        AppMethodBeat.o(145765);
        return;
      }
      if ((str3 != null) && (str3.length() > 32768))
      {
        Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "songLyric is large than 32KB");
        this.error = true;
        this.ppp = "songLyric is large than 32KB";
        cpA();
        AppMethodBeat.o(145765);
        return;
      }
      Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "src;%s, title:%s, epname:%s, singer:%s, coverImgUrl:%s, protocol:%s, webUrl:%s, startTime:%f, localPath:%s, playbackRate:%f", new Object[] { str4, str5, str6, str7, str1, str2, str8, Double.valueOf(d2), this.hTM, Double.valueOf(d1) });
      if ((d1 < 0.5D) || (d1 > 2.0D)) {
        d1 = 1.0D;
      }
      for (;;)
      {
        Object localObject2 = str1;
        if (str1 == null) {
          localObject2 = "";
        }
        int i;
        if (TextUtils.isEmpty(str3))
        {
          Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "songLyric is empty");
          localObject2 = g.a(11, (String)localObject2, str5, str7, str8, str4, str4, new StringBuilder().append(this.appId).append(str4).append((String)localObject2).toString().hashCode(), com.tencent.mm.loader.i.b.bmz(), ZY((String)localObject2), str6, this.appId);
          ((com.tencent.mm.aw.f)localObject2).startTime = ((int)(1000.0D * d2));
          ((com.tencent.mm.aw.f)localObject2).protocol = str2;
          ((com.tencent.mm.aw.f)localObject2).oOE = str3;
          ((com.tencent.mm.aw.f)localObject2).orm = d1;
          if (this.hTM.startsWith("file://")) {
            ((com.tencent.mm.aw.f)localObject2).oOH = this.hTM;
          }
          ((com.tencent.mm.aw.f)localObject2).oru = this.oru;
          ((com.tencent.mm.aw.f)localObject2).orv = this.orv;
          ((com.tencent.mm.aw.f)localObject2).volume = ((float)d3);
          a.a.cBB().tic = ((com.tencent.mm.aw.f)localObject2).oOv;
          a.a.cBB().tie = ((com.tencent.mm.aw.f)localObject2);
          if ((!((com.tencent.mm.aw.f)localObject2).g(com.tencent.mm.aw.a.bLn())) || (!com.tencent.mm.aw.a.bLk())) {
            break label825;
          }
          i = 1;
          label755:
          if (i != 0) {
            break label831;
          }
          Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "play the music");
          com.tencent.mm.aw.a.c((com.tencent.mm.aw.f)localObject2);
        }
        for (;;)
        {
          Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess startPlayMusic");
          Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
          this.error = false;
          cpA();
          AppMethodBeat.o(145765);
          return;
          Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "songLyric:%s", new Object[] { str3 });
          break;
          label825:
          i = 0;
          break label755;
          label831:
          Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "The same music is playing");
          com.tencent.mm.aw.a.b((com.tencent.mm.aw.f)localObject2);
        }
      }
    }
    
    public final void bQr()
    {
      AppMethodBeat.i(145766);
      if (this.rzi == null)
      {
        Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "service is null, don't callback");
        AppMethodBeat.o(145766);
        return;
      }
      if (!this.error)
      {
        Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
        this.rzi.callback(this.ror, this.rzh.ZP("ok"));
      }
      for (;;)
      {
        cpx();
        AppMethodBeat.o(145766);
        return;
        Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState fail:%s", new Object[] { this.ppp });
        this.rzi.callback(this.ror, this.rzh.ZP("fail:" + this.ppp));
      }
    }
    
    public final void h(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(145767);
      this.appId = paramParcel.readString();
      this.rDx = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.error = bool;
        this.ppp = paramParcel.readString();
        this.hTM = paramParcel.readString();
        this.oru = paramParcel.readString();
        this.orv = paramParcel.readString();
        AppMethodBeat.o(145767);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145768);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.rDx);
      if (this.error) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.ppp);
        paramParcel.writeString(this.hTM);
        paramParcel.writeString(this.oru);
        paramParcel.writeString(this.orv);
        AppMethodBeat.o(145768);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState
 * JD-Core Version:    0.7.0.1
 */
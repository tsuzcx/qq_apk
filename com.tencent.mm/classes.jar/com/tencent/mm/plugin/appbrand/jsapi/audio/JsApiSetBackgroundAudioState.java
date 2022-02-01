package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.f;
import com.tencent.mm.bb.g;
import com.tencent.mm.f.a.np;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.az;
import com.tencent.mm.plugin.appbrand.jsapi.o;
import com.tencent.mm.plugin.appbrand.k;
import com.tencent.mm.plugin.appbrand.k.c;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.a;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.q;
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
  protected SetBackgroundAudioListenerTask ozB;
  
  protected SetBackgroundAudioListenerTask a(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt)
  {
    AppMethodBeat.i(145773);
    paramc = new SetBackgroundAudioListenerTask(this, parame, paramInt);
    AppMethodBeat.o(145773);
    return paramc;
  }
  
  public final void a(final com.tencent.mm.plugin.appbrand.jsapi.e parame, JSONObject paramJSONObject, final int paramInt)
  {
    AppMethodBeat.i(145770);
    if (paramJSONObject == null)
    {
      parame.j(paramInt, h("fail:data is null", null));
      Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState data is null");
      AppMethodBeat.o(145770);
      return;
    }
    Object localObject1 = parame.getAppId();
    Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState appId:%s ,data:%s", new Object[] { localObject1, paramJSONObject.toString() });
    if (this.ozB == null) {
      this.ozB = a(this, parame, paramInt);
    }
    this.ozB.okO = paramInt;
    this.ozB.appId = ((String)localObject1);
    SetBackgroundAudioListenerTask.a(this.ozB);
    ??? = ad.Rp("AppBrandService#" + parame.hashCode());
    a((String)???, parame);
    com.tencent.mm.plugin.appbrand.jsapi.v.a locala;
    for (;;)
    {
      synchronized (ad.beh().I((String)???, true))
      {
        if ((k.c)((ad.b)???).get("AppBrandLifeCycle.Listener", null) == null)
        {
          localObject3 = new k.c()
          {
            public final void onDestroy()
            {
              AppMethodBeat.i(145750);
              String str = this.ozF.getString("appId", "");
              Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "onDestroy, appId:%s", new Object[] { str });
              JSONObject localJSONObject = new JSONObject();
              try
              {
                localJSONObject.put("operationType", "stop");
                label49:
                JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask localSetBackgroundAudioStateTask = new JsApiSetBackgroundAudioState.SetBackgroundAudioStateTask(JsApiSetBackgroundAudioState.this, parame, paramInt);
                localSetBackgroundAudioStateTask.ozE = localJSONObject.toString();
                localSetBackgroundAudioStateTask.appId = str;
                localSetBackgroundAudioStateTask.bPu();
                AppMethodBeat.o(145750);
                return;
              }
              catch (JSONException localJSONException)
              {
                break label49;
              }
            }
          };
          ((ad.b)???).k("AppBrandLifeCycle.Listener", localObject3);
          ((ad.b)???).k("appId", localObject1);
          this.ozB.cwl = ((k.c)localObject3);
        }
        this.ozB.bsM();
        Object localObject3 = b(this, parame, paramInt);
        ((SetBackgroundAudioStateTask)localObject3).okO = paramInt;
        ((SetBackgroundAudioStateTask)localObject3).appId = ((String)localObject1);
        ((SetBackgroundAudioStateTask)localObject3).ozE = paramJSONObject.toString();
        ??? = paramJSONObject.optString("src");
        if ((??? == null) || (((String)???).length() <= 0))
        {
          localObject1 = "";
          ((SetBackgroundAudioStateTask)localObject3).fNU = ((String)localObject1);
          locala = (com.tencent.mm.plugin.appbrand.jsapi.v.a)com.tencent.luggage.a.e.K(com.tencent.mm.plugin.appbrand.jsapi.v.a.class);
          if (locala != null) {
            break;
          }
          Log.w("MicroMsg.Music.JsApiSetBackgroundAudioState", "getReferrers, referrerHelper is null");
          parame = new Pair(null, "invalidReferrer");
          ((SetBackgroundAudioStateTask)localObject3).lzT = ((String)parame.first);
          ((SetBackgroundAudioStateTask)localObject3).lzU = ((String)parame.second);
          ((SetBackgroundAudioStateTask)localObject3).bsM();
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
          localObject1 = parame.getFileSystem().adL((String)???);
          if ((localObject1 != null) && (((q)localObject1).ifE()))
          {
            ??? = ((q)localObject1).bOF();
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
    ??? = locala.aj(paramJSONObject);
    if (??? != null)
    {
      localObject1 = locala.aix((String)???);
      paramJSONObject = (JSONObject)localObject1;
      if (localObject1 == null) {
        paramJSONObject = locala.A(parame);
      }
      if (com.tencent.mm.plugin.appbrand.jsapi.v.c.pmz == paramJSONObject) {
        parame = null;
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "getReferrers, referrerPolicyStr: %s, referrer: %s", new Object[] { ???, parame });
      parame = new Pair(???, parame);
      break;
      if (com.tencent.mm.plugin.appbrand.jsapi.v.c.pmy == paramJSONObject) {
        parame = locala.B(parame);
      } else {
        parame = "invalidReferrer";
      }
    }
  }
  
  protected void a(String paramString, com.tencent.mm.plugin.appbrand.jsapi.e parame) {}
  
  protected SetBackgroundAudioStateTask b(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt)
  {
    AppMethodBeat.i(145772);
    paramc = new SetBackgroundAudioStateTask(this, parame, paramInt);
    AppMethodBeat.o(145772);
    return paramc;
  }
  
  public static class SetBackgroundAudioListenerTask
    extends MainProcessTask
  {
    public static final Parcelable.Creator<SetBackgroundAudioListenerTask> CREATOR;
    public int action;
    public String appId;
    public String appUserName;
    k.c cwl;
    public int fES;
    public String fzM;
    private boolean oAn;
    public int okO;
    private o ovN;
    public com.tencent.mm.plugin.appbrand.jsapi.e ovO;
    public String ozL;
    private final IListener ozM;
    
    static
    {
      AppMethodBeat.i(145761);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(145761);
    }
    
    public SetBackgroundAudioListenerTask(Parcel paramParcel)
    {
      AppMethodBeat.i(145754);
      this.oAn = false;
      this.ozM = new IListener() {};
      f(paramParcel);
      AppMethodBeat.o(145754);
    }
    
    public SetBackgroundAudioListenerTask(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt)
    {
      AppMethodBeat.i(145753);
      this.oAn = false;
      this.ozM = new IListener() {};
      this.ovN = paramc;
      this.ovO = parame;
      this.okO = paramInt;
      AppMethodBeat.o(145753);
    }
    
    protected void Aa(int paramInt) {}
    
    public final void RW()
    {
      AppMethodBeat.i(145755);
      Log.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInMainProcess");
      if (this.oAn)
      {
        Log.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "send Preempted Event");
        this.oAn = false;
        localObject = new np();
        ((np)localObject).fMc.action = 10;
        ((np)localObject).fMc.state = "preempted";
        ((np)localObject).fMc.appId = this.appId;
        ((np)localObject).fMc.fMe = true;
        EventCenter.instance.publish((IEvent)localObject);
      }
      Object localObject = a.a.cbh().qdn;
      if (!Util.isNullOrNil((String)localObject))
      {
        Log.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "remove listener preAppid is %s, appid is %s", new Object[] { localObject, this.appId });
        a.a.cbh().akx((String)localObject);
      }
      a.a.cbh().a(this.ozM, this.appId);
      localObject = a.a.cbh();
      String str1 = this.appId;
      int i = this.fES;
      String str2 = this.fzM;
      String str3 = this.appUserName;
      ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).qdn = str1;
      ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).fES = i;
      ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).fzM = str2;
      ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).appUserName = str3;
      AppMethodBeat.o(145755);
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(145756);
      if (this.ovO == null)
      {
        Log.e("MicroMsg.Music.SetBackgroundAudioListenerTask", "service is null, don't callback");
        AppMethodBeat.o(145756);
        return;
      }
      Aa(this.action);
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
        Log.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInClientProcess callback action:%d, retJson:%s", new Object[] { Integer.valueOf(this.action), this.ozL });
        new JsApiOperateBackgroundAudio.c().j(this.ovO).agU(this.ozL).bPO();
        localAppBrandMusicClientService = AppBrandMusicClientService.qdk;
        i = this.action;
        Log.i("MicroMsg.AppBrandMusicClientService", "notifyAction, action:%d", new Object[] { Integer.valueOf(i) });
        localIterator = localAppBrandMusicClientService.qdj.entrySet().iterator();
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
          if ((!TextUtils.isEmpty(localAppBrandMusicClientService.qdl)) && (localAppBrandMusicClientService.qdl.equalsIgnoreCase(str)))
          {
            Log.i("MicroMsg.AppBrandMusicClientService", "current play music appId is %s", new Object[] { localAppBrandMusicClientService.qdl });
            if (localObject != null)
            {
              if (i == 10)
              {
                ((AppBrandMusicClientService.a)localObject).bIo();
                continue;
                k.a(this.appId, this.cwl);
                AppBrandMusicClientService.qdk.qdl = this.appId;
                break;
                k.b(this.appId, this.cwl);
                break;
                JsApiOperateBackgroundAudio.b.o(this.ovO);
                AppMethodBeat.o(145756);
                return;
                JsApiOperateBackgroundAudio.a.o(this.ovO);
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
    
    public final void f(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(145757);
      this.appId = paramParcel.readString();
      this.ozL = paramParcel.readString();
      this.action = paramParcel.readInt();
      this.fES = paramParcel.readInt();
      this.fzM = paramParcel.readString();
      this.appUserName = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.oAn = bool;
        AppMethodBeat.o(145757);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145758);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.ozL);
      paramParcel.writeInt(this.action);
      paramParcel.writeInt(this.fES);
      paramParcel.writeString(this.fzM);
      paramParcel.writeString(this.appUserName);
      if (this.oAn) {}
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
    public String fNU;
    public String lzT;
    public String lzU;
    public String mvQ;
    public int okO;
    private o ovN;
    public com.tencent.mm.plugin.appbrand.jsapi.e ovO;
    public String ozE;
    
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
      this.mvQ = "";
      this.lzT = null;
      this.lzU = null;
      f(paramParcel);
      AppMethodBeat.o(145763);
    }
    
    public SetBackgroundAudioStateTask(com.tencent.mm.plugin.appbrand.jsapi.c paramc, com.tencent.mm.plugin.appbrand.jsapi.e parame, int paramInt)
    {
      this.error = false;
      this.mvQ = "";
      this.lzT = null;
      this.lzU = null;
      this.ovN = paramc;
      this.ovO = parame;
      this.okO = paramInt;
    }
    
    public final void RW()
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
        Object localObject1 = new JSONObject(this.ozE);
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
        str1 = a.a.cbh().qdn;
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
        this.mvQ = "parser data fail, data is invalid";
        Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "exception:%s" + localJSONException.getMessage());
        bPt();
        AppMethodBeat.o(145765);
        return;
      }
      this.error = false;
      if (localJSONException.equalsIgnoreCase("pause"))
      {
        if (com.tencent.mm.bb.b.bnD())
        {
          Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "pause music ok");
          AppMethodBeat.o(145765);
          return;
        }
        this.error = true;
        this.mvQ = "pause music fail";
      }
      for (;;)
      {
        bPt();
        AppMethodBeat.o(145765);
        return;
        if (localJSONException.equalsIgnoreCase("stop"))
        {
          if (com.tencent.mm.bb.b.bnE())
          {
            Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "stop music ok");
            AppMethodBeat.o(145765);
            return;
          }
          this.error = true;
          this.mvQ = "stop music fail";
        }
      }
      label361:
      if (TextUtils.isEmpty(str4))
      {
        Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "src is null");
        this.error = true;
        this.mvQ = "src is null";
        bPt();
        AppMethodBeat.o(145765);
        return;
      }
      if ((str3 != null) && (str3.length() > 32768))
      {
        Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "songLyric is large than 32KB");
        this.error = true;
        this.mvQ = "songLyric is large than 32KB";
        bPt();
        AppMethodBeat.o(145765);
        return;
      }
      Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "src;%s, title:%s, epname:%s, singer:%s, coverImgUrl:%s, protocol:%s, webUrl:%s, startTime:%f, localPath:%s, playbackRate:%f", new Object[] { str4, str5, str6, str7, str1, str2, str8, Double.valueOf(d2), this.fNU, Double.valueOf(d1) });
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
          localObject2 = g.a(11, (String)localObject2, str5, str7, str8, str4, str4, new StringBuilder().append(this.appId).append(str4).append((String)localObject2).toString().hashCode(), com.tencent.mm.loader.j.b.aSL(), aha((String)localObject2), str6, this.appId);
          ((f)localObject2).fod = ((int)(1000.0D * d2));
          ((f)localObject2).protocol = str2;
          ((f)localObject2).lVC = str3;
          ((f)localObject2).lzL = d1;
          if (this.fNU.startsWith("file://")) {
            ((f)localObject2).lVF = this.fNU;
          }
          ((f)localObject2).lzT = this.lzT;
          ((f)localObject2).lzU = this.lzU;
          ((f)localObject2).volume = ((float)d3);
          a.a.cbh().qdo = ((f)localObject2).lVt;
          a.a.cbh().qdp = ((f)localObject2);
          if ((!((f)localObject2).g(com.tencent.mm.bb.a.bnA())) || (!com.tencent.mm.bb.a.bnx())) {
            break label825;
          }
          i = 1;
          label755:
          if (i != 0) {
            break label831;
          }
          Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "play the music");
          com.tencent.mm.bb.a.c((f)localObject2);
        }
        for (;;)
        {
          Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "runInMainProcess startPlayMusic");
          Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
          this.error = false;
          bPt();
          AppMethodBeat.o(145765);
          return;
          Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "songLyric:%s", new Object[] { str3 });
          break;
          label825:
          i = 0;
          break label755;
          label831:
          Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "The same music is playing");
          com.tencent.mm.bb.a.b((f)localObject2);
        }
      }
    }
    
    public String aha(String paramString)
    {
      AppMethodBeat.i(145764);
      paramString = com.tencent.mm.loader.j.b.aSL() + "/image/" + paramString.hashCode();
      AppMethodBeat.o(145764);
      return paramString;
    }
    
    public final void bsK()
    {
      AppMethodBeat.i(145766);
      if (this.ovO == null)
      {
        Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "service is null, don't callback");
        AppMethodBeat.o(145766);
        return;
      }
      if (!this.error)
      {
        Log.i("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState ok");
        this.ovO.j(this.okO, this.ovN.h("ok", null));
        AppMethodBeat.o(145766);
        return;
      }
      Log.e("MicroMsg.Music.JsApiSetBackgroundAudioState", "setBackgroundAudioState fail:%s", new Object[] { this.mvQ });
      this.ovO.j(this.okO, this.ovN.h("fail:" + this.mvQ, null));
      AppMethodBeat.o(145766);
    }
    
    public final void f(Parcel paramParcel)
    {
      boolean bool = true;
      AppMethodBeat.i(145767);
      this.appId = paramParcel.readString();
      this.ozE = paramParcel.readString();
      if (paramParcel.readInt() == 1) {}
      for (;;)
      {
        this.error = bool;
        this.mvQ = paramParcel.readString();
        this.fNU = paramParcel.readString();
        this.lzT = paramParcel.readString();
        this.lzU = paramParcel.readString();
        AppMethodBeat.o(145767);
        return;
        bool = false;
      }
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(145768);
      paramParcel.writeString(this.appId);
      paramParcel.writeString(this.ozE);
      if (this.error) {}
      for (paramInt = 1;; paramInt = 0)
      {
        paramParcel.writeInt(paramInt);
        paramParcel.writeString(this.mvQ);
        paramParcel.writeString(this.fNU);
        paramParcel.writeString(this.lzT);
        paramParcel.writeString(this.lzU);
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
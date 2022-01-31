package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ki;
import com.tencent.mm.plugin.appbrand.e;
import com.tencent.mm.plugin.appbrand.e.c;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.ai;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.a;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class JsApiSetBackgroundAudioState$SetBackgroundAudioListenerTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<SetBackgroundAudioListenerTask> CREATOR;
  public int action;
  public String appId;
  e.c bCv;
  public String cqQ;
  public String cvr;
  public int cvs;
  private boolean hCE;
  public String hCd;
  private final com.tencent.mm.sdk.b.c hCe;
  public int hry;
  private m hxs;
  public com.tencent.mm.plugin.appbrand.jsapi.c hyO;
  
  static
  {
    AppMethodBeat.i(137781);
    CREATOR = new JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask.1();
    AppMethodBeat.o(137781);
  }
  
  public JsApiSetBackgroundAudioState$SetBackgroundAudioListenerTask(Parcel paramParcel)
  {
    AppMethodBeat.i(137774);
    this.hCE = false;
    this.hCe = new com.tencent.mm.sdk.b.c() {};
    f(paramParcel);
    AppMethodBeat.o(137774);
  }
  
  public JsApiSetBackgroundAudioState$SetBackgroundAudioListenerTask(com.tencent.mm.plugin.appbrand.jsapi.a parama, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
  {
    AppMethodBeat.i(137773);
    this.hCE = false;
    this.hCe = new com.tencent.mm.sdk.b.c() {};
    this.hxs = parama;
    this.hyO = paramc;
    this.hry = paramInt;
    AppMethodBeat.o(137773);
  }
  
  public final void ata()
  {
    AppMethodBeat.i(137775);
    ab.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInMainProcess");
    if (this.hCE)
    {
      ab.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "send Preempted Event");
      this.hCE = false;
      localObject = new ki();
      ((ki)localObject).cAc.action = 10;
      ((ki)localObject).cAc.state = "preempted";
      ((ki)localObject).cAc.appId = this.appId;
      ((ki)localObject).cAc.cAe = true;
      com.tencent.mm.sdk.b.a.ymk.l((b)localObject);
    }
    Object localObject = a.a.aHK().ipb;
    if (!bo.isNullOrNil((String)localObject))
    {
      ab.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "remove listener preAppid is %s, appid is %s", new Object[] { localObject, this.appId });
      a.a.aHK().Dz((String)localObject);
    }
    a.a.aHK().a(this.hCe, this.appId);
    localObject = a.a.aHK();
    String str1 = this.appId;
    int i = this.cvs;
    String str2 = this.cqQ;
    String str3 = this.cvr;
    ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).ipb = str1;
    ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).cvs = i;
    ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).cqQ = str2;
    ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).cvr = str3;
    AppMethodBeat.o(137775);
  }
  
  public final void atb()
  {
    AppMethodBeat.i(137776);
    if (this.hyO == null)
    {
      ab.e("MicroMsg.Music.SetBackgroundAudioListenerTask", "service is null, don't callback");
      AppMethodBeat.o(137776);
      return;
    }
    nQ(this.action);
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
      ab.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInClientProcess callback action:%d, retJson:%s", new Object[] { Integer.valueOf(this.action), this.hCd });
      new JsApiOperateBackgroundAudio.c().j(this.hyO).BN(this.hCd).aBz();
      localAppBrandMusicClientService = AppBrandMusicClientService.ioY;
      i = this.action;
      ab.i("MicroMsg.AppBrandMusicClientService", "notifyAction, action:%d", new Object[] { Integer.valueOf(i) });
      localIterator = localAppBrandMusicClientService.ioX.entrySet().iterator();
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
        if ((!TextUtils.isEmpty(localAppBrandMusicClientService.ioZ)) && (localAppBrandMusicClientService.ioZ.equalsIgnoreCase(str)))
        {
          ab.i("MicroMsg.AppBrandMusicClientService", "current play music appId is %s", new Object[] { localAppBrandMusicClientService.ioZ });
          if (localObject != null)
          {
            if (i == 10)
            {
              ((AppBrandMusicClientService.a)localObject).awx();
              continue;
              e.a(this.appId, this.bCv);
              AppBrandMusicClientService.ioY.ioZ = this.appId;
              break;
              e.b(this.appId, this.bCv);
              break;
              JsApiOperateBackgroundAudio.b.k(this.hyO);
              AppMethodBeat.o(137776);
              return;
              JsApiOperateBackgroundAudio.a.k(this.hyO);
              AppMethodBeat.o(137776);
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
    AppMethodBeat.o(137776);
  }
  
  public final void f(Parcel paramParcel)
  {
    boolean bool = true;
    AppMethodBeat.i(137777);
    this.appId = paramParcel.readString();
    this.hCd = paramParcel.readString();
    this.action = paramParcel.readInt();
    this.cvs = paramParcel.readInt();
    this.cqQ = paramParcel.readString();
    this.cvr = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.hCE = bool;
      AppMethodBeat.o(137777);
      return;
      bool = false;
    }
  }
  
  protected void nQ(int paramInt) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    AppMethodBeat.i(137778);
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.hCd);
    paramParcel.writeInt(this.action);
    paramParcel.writeInt(this.cvs);
    paramParcel.writeString(this.cqQ);
    paramParcel.writeString(this.cvr);
    if (this.hCE) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      AppMethodBeat.o(137778);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask
 * JD-Core Version:    0.7.0.1
 */
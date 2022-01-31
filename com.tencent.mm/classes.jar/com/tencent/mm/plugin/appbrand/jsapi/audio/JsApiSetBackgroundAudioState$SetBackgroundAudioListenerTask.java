package com.tencent.mm.plugin.appbrand.jsapi.audio;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.h.a.jy;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.g.b;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService;
import com.tencent.mm.plugin.appbrand.media.music.AppBrandMusicClientService.a;
import com.tencent.mm.plugin.appbrand.media.music.a.a;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class JsApiSetBackgroundAudioState$SetBackgroundAudioListenerTask
  extends MainProcessTask
{
  public static final Parcelable.Creator<SetBackgroundAudioListenerTask> CREATOR = new Parcelable.Creator() {};
  public int action;
  public String appId;
  public String bJw;
  public String bNZ;
  public int bOa;
  g.b gda;
  private i gfG;
  public int gfg;
  public com.tencent.mm.plugin.appbrand.jsapi.c ggu;
  public String giJ;
  private final com.tencent.mm.sdk.b.c giK = new JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask.2(this);
  private boolean gjk = false;
  
  public JsApiSetBackgroundAudioState$SetBackgroundAudioListenerTask(Parcel paramParcel)
  {
    e(paramParcel);
  }
  
  public JsApiSetBackgroundAudioState$SetBackgroundAudioListenerTask(com.tencent.mm.plugin.appbrand.jsapi.a parama, com.tencent.mm.plugin.appbrand.jsapi.c paramc, int paramInt)
  {
    this.gfG = parama;
    this.ggu = paramc;
    this.gfg = paramInt;
  }
  
  public final void Zu()
  {
    y.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInMainProcess");
    if (this.gjk)
    {
      y.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "send Preempted Event");
      this.gjk = false;
      localObject = new jy();
      ((jy)localObject).bSA.action = 10;
      ((jy)localObject).bSA.state = "preempted";
      ((jy)localObject).bSA.appId = this.appId;
      ((jy)localObject).bSA.bSC = true;
      com.tencent.mm.sdk.b.a.udP.m((b)localObject);
    }
    Object localObject = a.a.amd().gNh;
    if (!bk.bl((String)localObject))
    {
      y.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "remove listener preAppid is %s, appid is %s", new Object[] { localObject, this.appId });
      a.a.amd().tO((String)localObject);
    }
    a.a.amd().a(this.giK, this.appId);
    localObject = a.a.amd();
    String str1 = this.appId;
    int i = this.bOa;
    String str2 = this.bJw;
    String str3 = this.bNZ;
    ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).gNh = str1;
    ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).bOa = i;
    ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).bJw = str2;
    ((com.tencent.mm.plugin.appbrand.media.music.a)localObject).bNZ = str3;
  }
  
  public final void Zv()
  {
    if (this.ggu == null)
    {
      y.e("MicroMsg.Music.SetBackgroundAudioListenerTask", "service is null, don't callback");
      return;
    }
    lh(this.action);
    label100:
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
      y.i("MicroMsg.Music.SetBackgroundAudioListenerTask", "runInClientProcess callback action:%d, retJson:%s", new Object[] { Integer.valueOf(this.action), this.giJ });
      new JsApiOperateBackgroundAudio.c().e(this.ggu).tM(this.giJ).dispatch();
      localAppBrandMusicClientService = AppBrandMusicClientService.gNe;
      i = this.action;
      y.i("MicroMsg.AppBrandMusicClientService", "notifyAction, action:%d", new Object[] { Integer.valueOf(i) });
      localIterator = localAppBrandMusicClientService.gNd.entrySet().iterator();
    }
    while (localIterator.hasNext())
    {
      Object localObject = (Map.Entry)localIterator.next();
      if (localObject != null)
      {
        String str = (String)((Map.Entry)localObject).getKey();
        localObject = (AppBrandMusicClientService.a)((Map.Entry)localObject).getValue();
        if ((!TextUtils.isEmpty(localAppBrandMusicClientService.gNf)) && (localAppBrandMusicClientService.gNf.equalsIgnoreCase(str)))
        {
          y.i("MicroMsg.AppBrandMusicClientService", "current play music appId is %s", new Object[] { localAppBrandMusicClientService.gNf });
          if (localObject != null)
          {
            if (i == 10)
            {
              ((AppBrandMusicClientService.a)localObject).acF();
              continue;
              g.a(this.appId, this.gda);
              AppBrandMusicClientService.gNe.gNf = this.appId;
              break label100;
              g.b(this.appId, this.gda);
              break label100;
              JsApiOperateBackgroundAudio.b.f(this.ggu);
              return;
              JsApiOperateBackgroundAudio.a.f(this.ggu);
              return;
            }
            if (i == 2) {
              ((AppBrandMusicClientService.a)localObject).onStop();
            }
          }
        }
      }
    }
  }
  
  public final void e(Parcel paramParcel)
  {
    boolean bool = true;
    this.appId = paramParcel.readString();
    this.giJ = paramParcel.readString();
    this.action = paramParcel.readInt();
    this.bOa = paramParcel.readInt();
    this.bJw = paramParcel.readString();
    this.bNZ = paramParcel.readString();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.gjk = bool;
      return;
      bool = false;
    }
  }
  
  protected void lh(int paramInt) {}
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeString(this.appId);
    paramParcel.writeString(this.giJ);
    paramParcel.writeInt(this.action);
    paramParcel.writeInt(this.bOa);
    paramParcel.writeString(this.bJw);
    paramParcel.writeString(this.bNZ);
    if (this.gjk) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.audio.JsApiSetBackgroundAudioState.SetBackgroundAudioListenerTask
 * JD-Core Version:    0.7.0.1
 */
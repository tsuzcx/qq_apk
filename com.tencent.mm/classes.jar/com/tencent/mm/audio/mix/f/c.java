package com.tencent.mm.audio.mix.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.b.a.1;
import com.tencent.mm.audio.mix.b.a.2;
import com.tencent.mm.audio.mix.c.f.a;
import com.tencent.mm.audio.mix.decode.i;
import com.tencent.mm.audio.mix.decode.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
{
  public String appId;
  public d htV;
  public com.tencent.mm.audio.mix.decode.a htW;
  public HashMap<String, Boolean> htX;
  private com.tencent.mm.audio.mix.c.f htY;
  public com.tencent.mm.audio.mix.b.a.d htZ;
  private volatile boolean hua;
  
  public c()
  {
    AppMethodBeat.i(136888);
    this.htX = new HashMap();
    this.hua = false;
    this.htV = new d();
    this.htW = new com.tencent.mm.audio.mix.decode.a(this.htV);
    this.htV.htW = this.htW;
    this.htY = new com.tencent.mm.audio.mix.c.f();
    this.htZ = new com.tencent.mm.audio.mix.b.a.d();
    AppMethodBeat.o(136888);
  }
  
  private void i(com.tencent.mm.al.b paramb)
  {
    AppMethodBeat.i(136897);
    paramb.hqN = true;
    int i = this.htV.jx(paramb.hqQ);
    int j = this.htV.aGx();
    if (!this.hua)
    {
      if (i <= 2000) {
        paramb.hqN = false;
      }
      if ((i >= 5000) || (j > 5)) {
        break label184;
      }
    }
    label184:
    for (paramb.hqN = false;; paramb.hqN = true)
    {
      if (paramb.filePath.contains("scale_intro")) {
        paramb.hqN = false;
      }
      if (j <= 5) {
        break;
      }
      Object localObject = this.htV.aGz();
      if (((ArrayList)localObject).contains(paramb.hqQ)) {
        ((ArrayList)localObject).remove(paramb.hqQ);
      }
      if (((ArrayList)localObject).size() <= 2) {
        break;
      }
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "do stop paused audio size:%d", new Object[] { Integer.valueOf(((ArrayList)localObject).size()) });
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        js((String)((Iterator)localObject).next());
      }
    }
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "playingCount:%d, duration:%d, supportMixPlay:%b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(paramb.hqN) });
    AppMethodBeat.o(136897);
  }
  
  private com.tencent.mm.al.b jo(String paramString)
  {
    AppMethodBeat.i(136894);
    paramString = this.htV.jo(paramString);
    AppMethodBeat.o(136894);
    return paramString;
  }
  
  public final void a(b paramb)
  {
    this.htV.huk = paramb;
  }
  
  public final void a(g paramg)
  {
    this.htV.hum = paramg;
  }
  
  public final void aGn()
  {
    AppMethodBeat.i(136889);
    ??? = this.htW;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "pauseAllOnBackground");
    Object localObject2 = ((com.tencent.mm.audio.mix.decode.a)???).hrX.iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (String)((Iterator)localObject2).next();
      localObject4 = (com.tencent.mm.audio.mix.decode.b)((com.tencent.mm.audio.mix.decode.a)???).hrU.get(localObject4);
      if ((localObject4 != null) && (!((com.tencent.mm.audio.mix.decode.b)localObject4).hsa) && (!((com.tencent.mm.audio.mix.decode.b)localObject4).aFA()))
      {
        localObject4 = ((com.tencent.mm.audio.mix.decode.b)localObject4).hsb;
        if ((localObject4 != null) && (!((l)localObject4).aFF())) {
          ((l)localObject4).aFC();
        }
      }
    }
    ??? = this.htV;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "pauseAllOnBackground");
    ((d)???).huj.aFZ();
    ((d)???).aGr();
    ??? = this.htY;
    ((com.tencent.mm.audio.mix.c.f)???).appId = this.appId;
    if (com.tencent.mm.audio.mix.c.f.hrP == 0L) {
      com.tencent.mm.audio.mix.c.f.hrP = 0L;
    }
    long l = System.currentTimeMillis();
    if (l - com.tencent.mm.audio.mix.c.f.hrP <= com.tencent.mm.audio.mix.c.f.hrM.longValue()) {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioScanConvertCacheController", "startClean the last clean time is in AUDIO_MIX_NO_SCAN_TIME time");
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.audio.mix.b.f.aFr();
      synchronized (((com.tencent.mm.audio.mix.b.f)localObject2).hri)
      {
        localObject4 = ((com.tencent.mm.audio.mix.b.f)localObject2).hrh.iterator();
        Object localObject5;
        do
        {
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localObject5 = (String)((Iterator)localObject4).next();
          localObject5 = (com.tencent.mm.audio.mix.a.d)((com.tencent.mm.audio.mix.b.f)localObject2).cache.get(localObject5);
        } while ((localObject5 == null) || (!((com.tencent.mm.audio.mix.a.d)localObject5).ckB) || (!((com.tencent.mm.audio.mix.a.d)localObject5).hqO));
        ((com.tencent.mm.audio.mix.a.d)localObject5).aEY();
      }
      com.tencent.mm.audio.mix.c.f.hrP = l;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioScanConvertCacheController", "start scan audio mix convert file");
      i.a(new f.a((com.tencent.mm.audio.mix.c.f)???, "clean audio mix convert cache"));
    }
    com.tencent.mm.audio.mix.b.a.aFc().aFe();
    AppMethodBeat.o(136889);
  }
  
  public final boolean aGo()
  {
    AppMethodBeat.i(136909);
    boolean bool = this.htV.hue.get();
    AppMethodBeat.o(136909);
    return bool;
  }
  
  public final void aGp()
  {
    AppMethodBeat.i(136913);
    String str = this.appId;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmDataTrackTaskController", "recycleAllCache appId:%s", new Object[] { str });
    com.tencent.mm.audio.mix.b.a.d.a(new com.tencent.mm.audio.mix.b.a.c(str), "AudioPcmDataTrackRecycleCacheTask");
    this.htX.clear();
    AppMethodBeat.o(136913);
  }
  
  public final long aGq()
  {
    return this.htV.huj.htl;
  }
  
  public final boolean ab(String paramString, int paramInt)
  {
    AppMethodBeat.i(136902);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo audioId:%s, position:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    boolean bool2 = this.htW.aa(paramString, paramInt);
    if (!bool2)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo fail audioId:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(136902);
      return false;
    }
    r(10, paramString);
    long l = this.htV.jD(paramString);
    int i = this.htV.jE(paramString);
    boolean bool1;
    if (!jA(paramString))
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo cache is not exist");
      bool1 = true;
    }
    for (;;)
    {
      r(6, paramString);
      if ((bool1) && (bool2))
      {
        AppMethodBeat.o(136902);
        return true;
        if (jx(paramString) <= 2000)
        {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo duration is not support seek");
          if (!this.htW.ja(paramString))
          {
            bool2 = this.htW.Z(paramString, paramInt);
            bool1 = true;
          }
        }
        else
        {
          if (Math.abs(paramInt - l) <= 2000L)
          {
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo time is not support seek");
            bool1 = true;
            continue;
          }
          if ((i != 0) && (i != 1) && (i != 2))
          {
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo state is not support seek");
            bool1 = true;
            continue;
          }
          if (!this.htW.ja(paramString))
          {
            this.htV.huj.g(paramString, paramInt, false);
            bool2 = this.htW.Z(paramString, paramInt);
            bool1 = true;
            continue;
          }
          bool1 = this.htV.huj.g(paramString, paramInt, true);
        }
      }
      else
      {
        AppMethodBeat.o(136902);
        return false;
      }
      bool1 = true;
    }
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(136890);
    this.htW.clearCache();
    this.htV.clearCache();
    AppMethodBeat.o(136890);
  }
  
  public final void eh(boolean paramBoolean)
  {
    AppMethodBeat.i(236184);
    com.tencent.mm.audio.mix.decode.a locala = this.htW;
    Iterator localIterator = locala.hrX.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((com.tencent.mm.al.b)locala.hrV.get(str)).hqN = paramBoolean;
    }
    AppMethodBeat.o(236184);
  }
  
  public final void ei(boolean paramBoolean)
  {
    AppMethodBeat.i(236197);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "forceMixPlay:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.hua = paramBoolean;
    AppMethodBeat.o(236197);
  }
  
  public final void ej(boolean paramBoolean)
  {
    AppMethodBeat.i(236198);
    d locald = this.htV;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "setIsOutputMixBuffer:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    locald.huB = paramBoolean;
    AppMethodBeat.o(236198);
  }
  
  public final void f(com.tencent.mm.al.b paramb)
  {
    AppMethodBeat.i(136891);
    this.appId = paramb.appId;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "preparePlay:%s", new Object[] { paramb.hqQ });
    ??? = com.tencent.mm.audio.mix.b.a.aFc();
    Object localObject3 = this.appId;
    Object localObject1 = null;
    if ((!TextUtils.isEmpty(((com.tencent.mm.audio.mix.b.a)???).currentAppId)) && (!((String)localObject3).equals(((com.tencent.mm.audio.mix.b.a)???).currentAppId)))
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioCachePathMgr", "init");
      localObject1 = ((com.tencent.mm.audio.mix.b.a)???).currentAppId;
      ((com.tencent.mm.audio.mix.b.a)???).currentAppId = ((String)localObject3);
      localObject1 = new a.1((com.tencent.mm.audio.mix.b.a)???, (String)localObject1, (String)localObject3);
    }
    for (;;)
    {
      if (localObject1 != null) {
        com.tencent.mm.audio.mix.b.a.a((com.tencent.mm.audio.mix.b.a.f)localObject1, "init cache path");
      }
      if ((jB(paramb.filePath)) && (paramb.orj)) {
        i(paramb);
      }
      localObject1 = this.htV;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "preparePlay");
      if ((!paramb.ory) && (paramb.orj)) {
        if (((d)localObject1).huc.get())
        {
          ((d)localObject1).aGs();
          label180:
          ((d)localObject1).hrV.put(paramb.hqQ, paramb);
        }
      }
      synchronized (((d)localObject1).huh)
      {
        for (;;)
        {
          ((d)localObject1).hti.put(paramb.hqQ, Boolean.FALSE);
          ((d)localObject1).huj.jd(paramb.hqQ);
          ((d)localObject1).huj.aFY();
          localObject1 = this.htW;
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "prepareDecode");
          if (paramb == null)
          {
            com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "param is null");
            AppMethodBeat.o(136891);
            return;
            if (!TextUtils.isEmpty(((com.tencent.mm.audio.mix.b.a)???).currentAppId)) {
              break;
            }
            ((com.tencent.mm.audio.mix.b.a)???).currentAppId = ((String)localObject3);
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioCachePathMgr", "init");
            localObject1 = new a.2((com.tencent.mm.audio.mix.b.a)???, (String)localObject3);
            break;
            if (((d)localObject1).huc.get()) {
              break label180;
            }
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "initThread");
            ((d)localObject1).huc.set(true);
            ((d)localObject1).hue.set(false);
            ((d)localObject1).hud.set(false);
            ((d)localObject1).aGs();
            break label180;
            if (!paramb.ory) {
              break label180;
            }
            synchronized (((d)localObject1).huh)
            {
              if (((d)localObject1).hup.containsKey(paramb.hqQ))
              {
                localObject3 = (e)((d)localObject1).hup.get(paramb.hqQ);
                if (localObject3 != null) {
                  if (((e)localObject3).i(new Integer[] { Integer.valueOf(4) })) {
                    ((d)localObject1).hup.remove(paramb.hqQ);
                  }
                }
              }
            }
          }
        }
      }
    }
    if (TextUtils.isEmpty(paramb.hqQ))
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "audioId is empty!");
      AppMethodBeat.o(136891);
      return;
    }
    if (!((com.tencent.mm.audio.mix.decode.a)localObject1).hrX.contains(paramb.hqQ))
    {
      ((com.tencent.mm.audio.mix.decode.a)localObject1).hrX.add(paramb.hqQ);
      ((com.tencent.mm.audio.mix.decode.a)localObject1).hrV.put(paramb.hqQ, paramb);
      bool = false;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "ids:%d, id2ParamMap:%d", new Object[] { Integer.valueOf(((com.tencent.mm.audio.mix.decode.a)localObject1).hrX.size()), Integer.valueOf(((com.tencent.mm.audio.mix.decode.a)localObject1).hrV.size()) });
      if (!paramb.ory) {
        break label720;
      }
      bool = ((com.tencent.mm.audio.mix.decode.a)localObject1).c(paramb.hqQ, bool, true);
      ??? = ((com.tencent.mm.audio.mix.decode.a)localObject1).hri;
      if (!bool) {}
    }
    try
    {
      if (!((com.tencent.mm.audio.mix.decode.a)localObject1).hrW.contains(paramb.filePath)) {
        ((com.tencent.mm.audio.mix.decode.a)localObject1).hrW.add(paramb.filePath);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(136891);
    }
    if (((com.tencent.mm.al.b)((com.tencent.mm.audio.mix.decode.a)localObject1).hrV.get(paramb.hqQ)).j(paramb)) {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "is same param");
    }
    for (boolean bool = false;; bool = true)
    {
      ((com.tencent.mm.audio.mix.decode.a)localObject1).hrV.put(paramb.hqQ, paramb);
      break;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "force to decode");
    }
    label720:
    if (paramb.orj)
    {
      ((com.tencent.mm.audio.mix.decode.a)localObject1).c(paramb.hqQ, bool, false);
      AppMethodBeat.o(136891);
      return;
    }
    bool = ((com.tencent.mm.audio.mix.decode.a)localObject1).c(paramb.hqQ, bool, true);
    ??? = ((com.tencent.mm.audio.mix.decode.a)localObject1).hri;
    if (bool) {}
    try
    {
      if (!((com.tencent.mm.audio.mix.decode.a)localObject1).hrW.contains(paramb.filePath)) {
        ((com.tencent.mm.audio.mix.decode.a)localObject1).hrW.add(paramb.filePath);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(136891);
    }
  }
  
  public final void g(com.tencent.mm.al.b paramb)
  {
    AppMethodBeat.i(136892);
    d locald = this.htV;
    locald.hrV.put(paramb.hqQ, paramb);
    if ((locald.aGy() == 1) && (locald.jF(paramb.hqQ)) && (locald.jb(paramb.hqQ)))
    {
      locald.setVolume((float)paramb.orl, (float)paramb.orl);
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "setPlayParam setVolume:%f", new Object[] { Double.valueOf(paramb.orl) });
    }
    this.htW.hrV.put(paramb.hqQ, paramb);
    AppMethodBeat.o(136892);
  }
  
  public final void h(com.tencent.mm.al.b paramb)
  {
    AppMethodBeat.i(136893);
    Object localObject = this.htV;
    if (((d)localObject).hrV.containsKey(paramb.hqQ))
    {
      ((d)localObject).hrV.put(paramb.hqQ, paramb);
      if ((((d)localObject).aGy() == 1) && (((d)localObject).jF(paramb.hqQ)) && (((d)localObject).jb(paramb.hqQ)))
      {
        ((d)localObject).setVolume((float)paramb.orl, (float)paramb.orl);
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "update setVolume:%f", new Object[] { Double.valueOf(paramb.orl) });
      }
    }
    localObject = this.htW;
    if (((com.tencent.mm.audio.mix.decode.a)localObject).hrV.containsKey(paramb.hqQ))
    {
      ((com.tencent.mm.audio.mix.decode.a)localObject).hrV.put(paramb.hqQ, paramb);
      if (!((com.tencent.mm.audio.mix.decode.a)localObject).ja(paramb.hqQ))
      {
        localObject = (com.tencent.mm.audio.mix.decode.b)((com.tencent.mm.audio.mix.decode.a)localObject).hrU.get(paramb.hqQ);
        if (localObject != null)
        {
          localObject = ((com.tencent.mm.audio.mix.decode.b)localObject).hsb;
          if ((localObject != null) && (!((l)localObject).aFH())) {
            ((l)localObject).setVolume((float)paramb.orl, (float)paramb.orl);
          }
        }
      }
    }
    AppMethodBeat.o(136893);
  }
  
  public final boolean iQ(String paramString)
  {
    AppMethodBeat.i(136895);
    if (this.htV.hrV.containsKey(paramString))
    {
      AppMethodBeat.o(136895);
      return true;
    }
    AppMethodBeat.o(136895);
    return false;
  }
  
  public final boolean isPaused(String paramString)
  {
    AppMethodBeat.i(136907);
    d locald = this.htV;
    if (locald.hup.containsKey(paramString))
    {
      paramString = (e)locald.hup.get(paramString);
      if (paramString != null) {
        if (paramString.i(new Integer[] { Integer.valueOf(2) }))
        {
          AppMethodBeat.o(136907);
          return true;
        }
      }
    }
    AppMethodBeat.o(136907);
    return false;
  }
  
  public final boolean jA(String paramString)
  {
    AppMethodBeat.i(136915);
    paramString = jo(paramString);
    if (paramString != null)
    {
      if (this.htX.containsKey(paramString.filePath))
      {
        bool = ((Boolean)this.htX.get(paramString.filePath)).booleanValue();
        AppMethodBeat.o(136915);
        return bool;
      }
      boolean bool = com.tencent.mm.audio.mix.b.f.aFr().iT(paramString.filePath);
      if (bool) {
        this.htX.put(paramString.filePath, Boolean.valueOf(bool));
      }
      AppMethodBeat.o(136915);
      return bool;
    }
    AppMethodBeat.o(136915);
    return false;
  }
  
  public final boolean jB(String paramString)
  {
    AppMethodBeat.i(136916);
    if (this.htX.containsKey(paramString))
    {
      bool = ((Boolean)this.htX.get(paramString)).booleanValue();
      AppMethodBeat.o(136916);
      return bool;
    }
    boolean bool = com.tencent.mm.audio.mix.b.f.aFr().iT(paramString);
    if (bool) {
      this.htX.put(paramString, Boolean.valueOf(bool));
    }
    AppMethodBeat.o(136916);
    return bool;
  }
  
  public final boolean jC(String paramString)
  {
    AppMethodBeat.i(236195);
    boolean bool = this.htW.iX(paramString);
    AppMethodBeat.o(236195);
    return bool;
  }
  
  public final boolean jb(String paramString)
  {
    AppMethodBeat.i(136903);
    boolean bool = this.htV.jb(paramString);
    AppMethodBeat.o(136903);
    return bool;
  }
  
  public final void jp(String paramString)
  {
    AppMethodBeat.i(136896);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "play audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.htV.jE(paramString)) });
    i(this.htV.jo(paramString));
    d locald = this.htV;
    locald.hue.set(false);
    locald.hud.set(false);
    locald.aGw();
    locald.aGs();
    synchronized (locald.huh)
    {
      locald.hti.put(paramString, Boolean.FALSE);
      locald.huj.jd(paramString);
      locald.hun.remove(paramString);
      locald.huo.put(paramString, Boolean.TRUE);
      if ((locald.htW.ja(paramString)) && (locald.htW.jb(paramString))) {
        locald.r(0, paramString);
      }
      this.htW.iY(paramString);
      AppMethodBeat.o(136896);
      return;
    }
  }
  
  public final void jq(String paramString)
  {
    AppMethodBeat.i(136898);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "resume audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.htV.jE(paramString)) });
    i(this.htV.jo(paramString));
    d locald = this.htV;
    locald.hue.set(false);
    locald.hud.set(false);
    locald.aGw();
    locald.aGs();
    synchronized (locald.huh)
    {
      locald.hti.put(paramString, Boolean.FALSE);
      locald.huj.jd(paramString);
      locald.hun.remove(paramString);
      locald.huo.put(paramString, Boolean.TRUE);
      if ((locald.htW.ja(paramString)) && (locald.htW.jb(paramString))) {
        locald.r(1, paramString);
      }
      this.htW.iY(paramString);
      AppMethodBeat.o(136898);
      return;
    }
  }
  
  public final void jr(String paramString)
  {
    AppMethodBeat.i(136899);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "pause audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.htV.jE(paramString)) });
    Object localObject = this.htV;
    ((d)localObject).huj.je(paramString);
    if ((((d)localObject).htW.ja(paramString)) && (((d)localObject).htW.jb(paramString))) {
      ((d)localObject).r(2, paramString);
    }
    localObject = this.htW;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "pauseDecode audioId:%s", new Object[] { paramString });
    paramString = (com.tencent.mm.audio.mix.decode.b)((com.tencent.mm.audio.mix.decode.a)localObject).hrU.get(paramString);
    if (paramString == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
      AppMethodBeat.o(136899);
      return;
    }
    if (paramString.hsa)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
      AppMethodBeat.o(136899);
      return;
    }
    if (paramString.aFA())
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is isDetach!");
      AppMethodBeat.o(136899);
      return;
    }
    paramString = paramString.hsb;
    if (paramString != null) {
      paramString.pause();
    }
    AppMethodBeat.o(136899);
  }
  
  public final void js(String paramString)
  {
    AppMethodBeat.i(136900);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "stop audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.htV.jE(paramString)) });
    this.htV.js(paramString);
    this.htW.iZ(paramString);
    AppMethodBeat.o(136900);
  }
  
  public final boolean jt(String paramString)
  {
    AppMethodBeat.i(136904);
    d locald = this.htV;
    if (locald.huo.containsKey(paramString))
    {
      boolean bool = ((Boolean)locald.huo.get(paramString)).booleanValue();
      AppMethodBeat.o(136904);
      return bool;
    }
    AppMethodBeat.o(136904);
    return false;
  }
  
  public final boolean ju(String paramString)
  {
    AppMethodBeat.i(136905);
    d locald = this.htV;
    if (locald.hup.containsKey(paramString))
    {
      paramString = (e)locald.hup.get(paramString);
      if (paramString != null) {
        if (paramString.i(new Integer[] { Integer.valueOf(9) }))
        {
          AppMethodBeat.o(136905);
          return true;
        }
      }
    }
    AppMethodBeat.o(136905);
    return false;
  }
  
  public final boolean jv(String paramString)
  {
    AppMethodBeat.i(136906);
    d locald = this.htV;
    if (locald.hup.containsKey(paramString))
    {
      paramString = (e)locald.hup.get(paramString);
      if (paramString != null) {
        if (paramString.i(new Integer[] { Integer.valueOf(7) }))
        {
          AppMethodBeat.o(136906);
          return true;
        }
      }
    }
    AppMethodBeat.o(136906);
    return false;
  }
  
  public final boolean jw(String paramString)
  {
    AppMethodBeat.i(136908);
    d locald = this.htV;
    if (locald.hup.containsKey(paramString))
    {
      paramString = (e)locald.hup.get(paramString);
      if (paramString != null)
      {
        if (!paramString.i(new Integer[] { Integer.valueOf(3) })) {
          if (!paramString.i(new Integer[] { Integer.valueOf(4) })) {
            if (!paramString.i(new Integer[] { Integer.valueOf(5) })) {
              break label100;
            }
          }
        }
        AppMethodBeat.o(136908);
        return true;
      }
    }
    label100:
    AppMethodBeat.o(136908);
    return false;
  }
  
  public final int jx(String paramString)
  {
    AppMethodBeat.i(136910);
    int i = this.htV.jx(paramString);
    AppMethodBeat.o(136910);
    return i;
  }
  
  public final com.tencent.mm.al.d jy(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(136911);
    d locald1 = this.htV;
    com.tencent.mm.al.d locald;
    int j;
    int k;
    boolean bool1;
    int i;
    if (locald1.huq.containsKey(paramString))
    {
      locald = (com.tencent.mm.al.d)locald1.huq.get(paramString);
      j = locald1.jx(paramString);
      k = locald1.jD(paramString);
      bool1 = locald1.jb(paramString);
      if (!locald1.hrV.containsKey(paramString)) {
        break label300;
      }
      Object localObject = ((com.tencent.mm.al.b)locald1.hrV.get(paramString)).filePath;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label300;
      }
      localObject = com.tencent.mm.audio.mix.b.f.aFr().iR((String)localObject);
      if ((localObject == null) || (((com.tencent.mm.audio.mix.a.d)localObject).duration <= 0L)) {
        break label300;
      }
      i = 100;
      label129:
      if (i >= 0) {
        break label325;
      }
      i = 0;
    }
    label156:
    label300:
    label311:
    label317:
    label325:
    for (;;)
    {
      locald.currentTime = k;
      locald.duration = j;
      if (bool1)
      {
        bool1 = false;
        locald.orA = bool1;
        if ((!locald1.hun.containsKey(paramString)) || (!((Boolean)locald1.hun.get(paramString)).booleanValue())) {
          break label311;
        }
      }
      for (bool1 = bool2;; bool1 = false)
      {
        locald.orB = bool1;
        locald.orC = (i * j / 100);
        if (!locald1.hrV.containsKey(paramString)) {
          break label317;
        }
        paramString = (com.tencent.mm.al.b)locald1.hrV.get(paramString);
        locald.startTime = paramString.ori;
        locald.hqM = paramString.hsg;
        locald.oru = paramString.oru;
        AppMethodBeat.o(136911);
        return locald;
        locald = new com.tencent.mm.al.d();
        locald1.huq.put(paramString, locald);
        break;
        i = 0;
        break label129;
        bool1 = true;
        break label156;
      }
      AppMethodBeat.o(136911);
      return null;
    }
  }
  
  public final void jz(String paramString)
  {
    AppMethodBeat.i(136914);
    String str = this.appId;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmDataTrackTaskController", "cacheToFile appId:%s, filePath:%s", new Object[] { str, paramString });
    com.tencent.mm.audio.mix.b.a.d.a(new com.tencent.mm.audio.mix.b.a.a(str, paramString), "AudioPcmDataTrackCacheToFileTask");
    AppMethodBeat.o(136914);
  }
  
  public final void r(int paramInt, String paramString)
  {
    AppMethodBeat.i(136912);
    this.htV.r(paramInt, paramString);
    AppMethodBeat.o(136912);
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(136901);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "remove audioId:%s", new Object[] { paramString });
    d locald = this.htV;
    locald.hrV.remove(paramString);
    locald.hun.remove(paramString);
    locald.huo.remove(paramString);
    synchronized (locald.huh)
    {
      locald.hup.remove(paramString);
      locald.hti.remove(paramString);
      locald.huq.remove(paramString);
      ??? = this.htW;
      if ((((com.tencent.mm.audio.mix.decode.a)???).hrU.containsKey(paramString)) && (((com.tencent.mm.audio.mix.decode.a)???).hrX.contains(paramString))) {
        ((com.tencent.mm.audio.mix.decode.a)???).iZ(paramString);
      }
      ((com.tencent.mm.audio.mix.decode.a)???).hrV.remove(paramString);
      ((com.tencent.mm.audio.mix.decode.a)???).hrX.remove(paramString);
      AppMethodBeat.o(136901);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.f.c
 * JD-Core Version:    0.7.0.1
 */
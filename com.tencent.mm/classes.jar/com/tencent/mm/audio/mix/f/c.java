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
  public d fpM;
  public com.tencent.mm.audio.mix.decode.a fpN;
  public HashMap<String, Boolean> fpO;
  private com.tencent.mm.audio.mix.c.f fpP;
  public com.tencent.mm.audio.mix.b.a.d fpQ;
  private volatile boolean fpR;
  
  public c()
  {
    AppMethodBeat.i(136888);
    this.fpO = new HashMap();
    this.fpR = false;
    this.fpM = new d();
    this.fpN = new com.tencent.mm.audio.mix.decode.a(this.fpM);
    this.fpM.fpN = this.fpN;
    this.fpP = new com.tencent.mm.audio.mix.c.f();
    this.fpQ = new com.tencent.mm.audio.mix.b.a.d();
    AppMethodBeat.o(136888);
  }
  
  private com.tencent.mm.al.b hN(String paramString)
  {
    AppMethodBeat.i(136894);
    paramString = this.fpM.hN(paramString);
    AppMethodBeat.o(136894);
    return paramString;
  }
  
  private void i(com.tencent.mm.al.b paramb)
  {
    AppMethodBeat.i(136897);
    paramb.fmC = true;
    int i = this.fpM.hW(paramb.fmF);
    int j = this.fpM.aeA();
    if (!this.fpR)
    {
      if (i <= 2000) {
        paramb.fmC = false;
      }
      if ((i >= 5000) || (j > 5)) {
        break label184;
      }
    }
    label184:
    for (paramb.fmC = false;; paramb.fmC = true)
    {
      if (paramb.filePath.contains("scale_intro")) {
        paramb.fmC = false;
      }
      if (j <= 5) {
        break;
      }
      Object localObject = this.fpM.aeB();
      if (((ArrayList)localObject).contains(paramb.fmF)) {
        ((ArrayList)localObject).remove(paramb.fmF);
      }
      if (((ArrayList)localObject).size() <= 2) {
        break;
      }
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "do stop paused audio size:%d", new Object[] { Integer.valueOf(((ArrayList)localObject).size()) });
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        hR((String)((Iterator)localObject).next());
      }
    }
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "playingCount:%d, duration:%d, supportMixPlay:%b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(paramb.fmC) });
    AppMethodBeat.o(136897);
  }
  
  public final boolean S(String paramString, int paramInt)
  {
    AppMethodBeat.i(136902);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo audioId:%s, position:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    boolean bool2 = this.fpN.R(paramString, paramInt);
    if (!bool2)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo fail audioId:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(136902);
      return false;
    }
    r(10, paramString);
    long l = this.fpM.ic(paramString);
    int i = this.fpM.ie(paramString);
    boolean bool1;
    if (!hZ(paramString))
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
        if (hW(paramString) <= 2000)
        {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo duration is not support seek");
          if (!this.fpN.hz(paramString))
          {
            bool2 = this.fpN.Q(paramString, paramInt);
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
          if (!this.fpN.hz(paramString))
          {
            this.fpM.fqa.f(paramString, paramInt, false);
            bool2 = this.fpN.Q(paramString, paramInt);
            bool1 = true;
            continue;
          }
          bool1 = this.fpM.fqa.f(paramString, paramInt, true);
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
  
  public final void a(b paramb)
  {
    this.fpM.fqb = paramb;
  }
  
  public final void a(g paramg)
  {
    this.fpM.fqd = paramg;
  }
  
  public final void aeq()
  {
    AppMethodBeat.i(136889);
    ??? = this.fpN;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "pauseAllOnBackground");
    Object localObject2 = ((com.tencent.mm.audio.mix.decode.a)???).fnM.iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (String)((Iterator)localObject2).next();
      localObject4 = (com.tencent.mm.audio.mix.decode.b)((com.tencent.mm.audio.mix.decode.a)???).fnJ.get(localObject4);
      if ((localObject4 != null) && (!((com.tencent.mm.audio.mix.decode.b)localObject4).fnP) && (!((com.tencent.mm.audio.mix.decode.b)localObject4).adC()))
      {
        localObject4 = ((com.tencent.mm.audio.mix.decode.b)localObject4).fnQ;
        if ((localObject4 != null) && (!((l)localObject4).adH())) {
          ((l)localObject4).adE();
        }
      }
    }
    ??? = this.fpM;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "pauseAllOnBackground");
    ((d)???).fqa.aeb();
    ((d)???).aeu();
    ??? = this.fpP;
    ((com.tencent.mm.audio.mix.c.f)???).appId = this.appId;
    if (com.tencent.mm.audio.mix.c.f.fnE == 0L) {
      com.tencent.mm.audio.mix.c.f.fnE = 0L;
    }
    long l = System.currentTimeMillis();
    if (l - com.tencent.mm.audio.mix.c.f.fnE <= com.tencent.mm.audio.mix.c.f.fnB.longValue()) {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioScanConvertCacheController", "startClean the last clean time is in AUDIO_MIX_NO_SCAN_TIME time");
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.audio.mix.b.f.ads();
      synchronized (((com.tencent.mm.audio.mix.b.f)localObject2).fmX)
      {
        localObject4 = ((com.tencent.mm.audio.mix.b.f)localObject2).fmW.iterator();
        Object localObject5;
        do
        {
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localObject5 = (String)((Iterator)localObject4).next();
          localObject5 = (com.tencent.mm.audio.mix.a.d)((com.tencent.mm.audio.mix.b.f)localObject2).cache.get(localObject5);
        } while ((localObject5 == null) || (!((com.tencent.mm.audio.mix.a.d)localObject5).awf) || (!((com.tencent.mm.audio.mix.a.d)localObject5).fmD));
        ((com.tencent.mm.audio.mix.a.d)localObject5).acY();
      }
      com.tencent.mm.audio.mix.c.f.fnE = l;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioScanConvertCacheController", "start scan audio mix convert file");
      i.a(new f.a((com.tencent.mm.audio.mix.c.f)???, "clean audio mix convert cache"));
    }
    com.tencent.mm.audio.mix.b.a.adc().adf();
    AppMethodBeat.o(136889);
  }
  
  public final boolean aer()
  {
    AppMethodBeat.i(136909);
    boolean bool = this.fpM.fpV.get();
    AppMethodBeat.o(136909);
    return bool;
  }
  
  public final void aes()
  {
    AppMethodBeat.i(136913);
    String str = this.appId;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmDataTrackTaskController", "recycleAllCache appId:%s", new Object[] { str });
    com.tencent.mm.audio.mix.b.a.d.a(new com.tencent.mm.audio.mix.b.a.c(str), "AudioPcmDataTrackRecycleCacheTask");
    this.fpO.clear();
    AppMethodBeat.o(136913);
  }
  
  public final long aet()
  {
    return this.fpM.fqa.fpb;
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(136890);
    this.fpN.clearCache();
    this.fpM.clearCache();
    AppMethodBeat.o(136890);
  }
  
  public final void dv(boolean paramBoolean)
  {
    AppMethodBeat.i(257522);
    com.tencent.mm.audio.mix.decode.a locala = this.fpN;
    Iterator localIterator = locala.fnM.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ((com.tencent.mm.al.b)locala.fnK.get(str)).fmC = paramBoolean;
    }
    AppMethodBeat.o(257522);
  }
  
  public final void dw(boolean paramBoolean)
  {
    AppMethodBeat.i(257525);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "forceMixPlay:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    this.fpR = paramBoolean;
    AppMethodBeat.o(257525);
  }
  
  public final void dx(boolean paramBoolean)
  {
    AppMethodBeat.i(257526);
    d locald = this.fpM;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "setIsOutputMixBuffer:%b", new Object[] { Boolean.valueOf(paramBoolean) });
    locald.fqs = paramBoolean;
    AppMethodBeat.o(257526);
  }
  
  public final void f(com.tencent.mm.al.b paramb)
  {
    AppMethodBeat.i(136891);
    this.appId = paramb.appId;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "preparePlay:%s", new Object[] { paramb.fmF });
    ??? = com.tencent.mm.audio.mix.b.a.adc();
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
      if ((ia(paramb.filePath)) && (paramb.lzI)) {
        i(paramb);
      }
      localObject1 = this.fpM;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "preparePlay");
      if ((!paramb.lzX) && (paramb.lzI)) {
        if (((d)localObject1).fpT.get())
        {
          ((d)localObject1).aev();
          label181:
          ((d)localObject1).fnK.put(paramb.fmF, paramb);
        }
      }
      synchronized (((d)localObject1).fpY)
      {
        for (;;)
        {
          ((d)localObject1).foY.put(paramb.fmF, Boolean.FALSE);
          ((d)localObject1).fqa.hC(paramb.fmF);
          ((d)localObject1).fqa.aea();
          localObject1 = this.fpN;
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
            if (((d)localObject1).fpT.get()) {
              break label181;
            }
            com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "initThread");
            ((d)localObject1).fpT.set(true);
            ((d)localObject1).fpV.set(false);
            ((d)localObject1).fpU.set(false);
            ((d)localObject1).aev();
            break label181;
            if (!paramb.lzX) {
              break label181;
            }
            synchronized (((d)localObject1).fpY)
            {
              if (((d)localObject1).fqg.containsKey(paramb.fmF))
              {
                localObject3 = (e)((d)localObject1).fqg.get(paramb.fmF);
                if (localObject3 != null) {
                  if (((e)localObject3).f(new Integer[] { Integer.valueOf(4) })) {
                    ((d)localObject1).fqg.remove(paramb.fmF);
                  }
                }
              }
            }
          }
        }
      }
    }
    if (TextUtils.isEmpty(paramb.fmF))
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "audioId is empty!");
      AppMethodBeat.o(136891);
      return;
    }
    if (!((com.tencent.mm.audio.mix.decode.a)localObject1).fnM.contains(paramb.fmF))
    {
      ((com.tencent.mm.audio.mix.decode.a)localObject1).fnM.add(paramb.fmF);
      ((com.tencent.mm.audio.mix.decode.a)localObject1).fnK.put(paramb.fmF, paramb);
      bool = false;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "ids:%d, id2ParamMap:%d", new Object[] { Integer.valueOf(((com.tencent.mm.audio.mix.decode.a)localObject1).fnM.size()), Integer.valueOf(((com.tencent.mm.audio.mix.decode.a)localObject1).fnK.size()) });
      if (!paramb.lzX) {
        break label722;
      }
      bool = ((com.tencent.mm.audio.mix.decode.a)localObject1).c(paramb.fmF, bool, true);
      ??? = ((com.tencent.mm.audio.mix.decode.a)localObject1).fmX;
      if (!bool) {}
    }
    try
    {
      if (!((com.tencent.mm.audio.mix.decode.a)localObject1).fnL.contains(paramb.filePath)) {
        ((com.tencent.mm.audio.mix.decode.a)localObject1).fnL.add(paramb.filePath);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(136891);
    }
    if (((com.tencent.mm.al.b)((com.tencent.mm.audio.mix.decode.a)localObject1).fnK.get(paramb.fmF)).j(paramb)) {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "is same param");
    }
    for (boolean bool = false;; bool = true)
    {
      ((com.tencent.mm.audio.mix.decode.a)localObject1).fnK.put(paramb.fmF, paramb);
      break;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "force to decode");
    }
    label722:
    if (paramb.lzI)
    {
      ((com.tencent.mm.audio.mix.decode.a)localObject1).c(paramb.fmF, bool, false);
      AppMethodBeat.o(136891);
      return;
    }
    bool = ((com.tencent.mm.audio.mix.decode.a)localObject1).c(paramb.fmF, bool, true);
    ??? = ((com.tencent.mm.audio.mix.decode.a)localObject1).fmX;
    if (bool) {}
    try
    {
      if (!((com.tencent.mm.audio.mix.decode.a)localObject1).fnL.contains(paramb.filePath)) {
        ((com.tencent.mm.audio.mix.decode.a)localObject1).fnL.add(paramb.filePath);
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
    this.fpM.fnK.put(paramb.fmF, paramb);
    this.fpN.fnK.put(paramb.fmF, paramb);
    AppMethodBeat.o(136892);
  }
  
  public final void h(com.tencent.mm.al.b paramb)
  {
    AppMethodBeat.i(136893);
    Object localObject = this.fpM;
    if (((d)localObject).fnK.containsKey(paramb.fmF)) {
      ((d)localObject).fnK.put(paramb.fmF, paramb);
    }
    localObject = this.fpN;
    if (((com.tencent.mm.audio.mix.decode.a)localObject).fnK.containsKey(paramb.fmF)) {
      ((com.tencent.mm.audio.mix.decode.a)localObject).fnK.put(paramb.fmF, paramb);
    }
    AppMethodBeat.o(136893);
  }
  
  public final boolean hA(String paramString)
  {
    AppMethodBeat.i(136903);
    boolean bool = this.fpM.hA(paramString);
    AppMethodBeat.o(136903);
    return bool;
  }
  
  public final void hO(String paramString)
  {
    AppMethodBeat.i(136896);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "play audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.fpM.ie(paramString)) });
    i(this.fpM.hN(paramString));
    d locald = this.fpM;
    locald.fpV.set(false);
    locald.fpU.set(false);
    locald.aez();
    locald.aev();
    synchronized (locald.fpY)
    {
      locald.foY.put(paramString, Boolean.FALSE);
      locald.fqa.hC(paramString);
      locald.fqe.remove(paramString);
      locald.fqf.put(paramString, Boolean.TRUE);
      if ((locald.fpN.hz(paramString)) && (locald.fpN.hA(paramString))) {
        locald.r(0, paramString);
      }
      this.fpN.hx(paramString);
      AppMethodBeat.o(136896);
      return;
    }
  }
  
  public final void hP(String paramString)
  {
    AppMethodBeat.i(136898);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "resume audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.fpM.ie(paramString)) });
    i(this.fpM.hN(paramString));
    d locald = this.fpM;
    locald.fpV.set(false);
    locald.fpU.set(false);
    locald.aez();
    locald.aev();
    synchronized (locald.fpY)
    {
      locald.foY.put(paramString, Boolean.FALSE);
      locald.fqa.hC(paramString);
      locald.fqe.remove(paramString);
      locald.fqf.put(paramString, Boolean.TRUE);
      if ((locald.fpN.hz(paramString)) && (locald.fpN.hA(paramString))) {
        locald.r(1, paramString);
      }
      this.fpN.hx(paramString);
      AppMethodBeat.o(136898);
      return;
    }
  }
  
  public final void hQ(String paramString)
  {
    AppMethodBeat.i(136899);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "pause audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.fpM.ie(paramString)) });
    Object localObject = this.fpM;
    ((d)localObject).fqa.hD(paramString);
    if ((((d)localObject).fpN.hz(paramString)) && (((d)localObject).fpN.hA(paramString))) {
      ((d)localObject).r(2, paramString);
    }
    localObject = this.fpN;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "pauseDecode audioId:%s", new Object[] { paramString });
    paramString = (com.tencent.mm.audio.mix.decode.b)((com.tencent.mm.audio.mix.decode.a)localObject).fnJ.get(paramString);
    if (paramString == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
      AppMethodBeat.o(136899);
      return;
    }
    if (paramString.fnP)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
      AppMethodBeat.o(136899);
      return;
    }
    if (paramString.adC())
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is isDetach!");
      AppMethodBeat.o(136899);
      return;
    }
    paramString = paramString.fnQ;
    if (paramString != null) {
      paramString.pause();
    }
    AppMethodBeat.o(136899);
  }
  
  public final void hR(String paramString)
  {
    AppMethodBeat.i(136900);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "stop audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.fpM.ie(paramString)) });
    this.fpM.hR(paramString);
    this.fpN.hy(paramString);
    AppMethodBeat.o(136900);
  }
  
  public final boolean hS(String paramString)
  {
    AppMethodBeat.i(136904);
    d locald = this.fpM;
    if (locald.fqf.containsKey(paramString))
    {
      boolean bool = ((Boolean)locald.fqf.get(paramString)).booleanValue();
      AppMethodBeat.o(136904);
      return bool;
    }
    AppMethodBeat.o(136904);
    return false;
  }
  
  public final boolean hT(String paramString)
  {
    AppMethodBeat.i(136905);
    d locald = this.fpM;
    if (locald.fqg.containsKey(paramString))
    {
      paramString = (e)locald.fqg.get(paramString);
      if (paramString != null) {
        if (paramString.f(new Integer[] { Integer.valueOf(9) }))
        {
          AppMethodBeat.o(136905);
          return true;
        }
      }
    }
    AppMethodBeat.o(136905);
    return false;
  }
  
  public final boolean hU(String paramString)
  {
    AppMethodBeat.i(136906);
    d locald = this.fpM;
    if (locald.fqg.containsKey(paramString))
    {
      paramString = (e)locald.fqg.get(paramString);
      if (paramString != null) {
        if (paramString.f(new Integer[] { Integer.valueOf(7) }))
        {
          AppMethodBeat.o(136906);
          return true;
        }
      }
    }
    AppMethodBeat.o(136906);
    return false;
  }
  
  public final boolean hV(String paramString)
  {
    AppMethodBeat.i(136908);
    d locald = this.fpM;
    if (locald.fqg.containsKey(paramString))
    {
      paramString = (e)locald.fqg.get(paramString);
      if (paramString != null)
      {
        if (!paramString.f(new Integer[] { Integer.valueOf(3) })) {
          if (!paramString.f(new Integer[] { Integer.valueOf(4) })) {
            if (!paramString.f(new Integer[] { Integer.valueOf(5) })) {
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
  
  public final int hW(String paramString)
  {
    AppMethodBeat.i(136910);
    int i = this.fpM.hW(paramString);
    AppMethodBeat.o(136910);
    return i;
  }
  
  public final com.tencent.mm.al.d hX(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(136911);
    d locald1 = this.fpM;
    com.tencent.mm.al.d locald;
    int j;
    int k;
    boolean bool1;
    int i;
    if (locald1.fqh.containsKey(paramString))
    {
      locald = (com.tencent.mm.al.d)locald1.fqh.get(paramString);
      j = locald1.hW(paramString);
      k = locald1.ic(paramString);
      bool1 = locald1.hA(paramString);
      if (!locald1.fnK.containsKey(paramString)) {
        break label300;
      }
      Object localObject = ((com.tencent.mm.al.b)locald1.fnK.get(paramString)).filePath;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label300;
      }
      localObject = com.tencent.mm.audio.mix.b.f.ads().hq((String)localObject);
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
        locald.lzZ = bool1;
        if ((!locald1.fqe.containsKey(paramString)) || (!((Boolean)locald1.fqe.get(paramString)).booleanValue())) {
          break label311;
        }
      }
      for (bool1 = bool2;; bool1 = false)
      {
        locald.lAa = bool1;
        locald.lAb = (i * j / 100);
        if (!locald1.fnK.containsKey(paramString)) {
          break label317;
        }
        paramString = (com.tencent.mm.al.b)locald1.fnK.get(paramString);
        locald.fod = paramString.lzH;
        locald.fmB = paramString.fnV;
        locald.lzT = paramString.lzT;
        AppMethodBeat.o(136911);
        return locald;
        locald = new com.tencent.mm.al.d();
        locald1.fqh.put(paramString, locald);
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
  
  public final void hY(String paramString)
  {
    AppMethodBeat.i(136914);
    String str = this.appId;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmDataTrackTaskController", "cacheToFile appId:%s, filePath:%s", new Object[] { str, paramString });
    com.tencent.mm.audio.mix.b.a.d.a(new com.tencent.mm.audio.mix.b.a.a(str, paramString), "AudioPcmDataTrackCacheToFileTask");
    AppMethodBeat.o(136914);
  }
  
  public final boolean hZ(String paramString)
  {
    AppMethodBeat.i(136915);
    paramString = hN(paramString);
    if (paramString != null)
    {
      if (this.fpO.containsKey(paramString.filePath))
      {
        bool = ((Boolean)this.fpO.get(paramString.filePath)).booleanValue();
        AppMethodBeat.o(136915);
        return bool;
      }
      boolean bool = com.tencent.mm.audio.mix.b.f.ads().hs(paramString.filePath);
      if (bool) {
        this.fpO.put(paramString.filePath, Boolean.valueOf(bool));
      }
      AppMethodBeat.o(136915);
      return bool;
    }
    AppMethodBeat.o(136915);
    return false;
  }
  
  public final boolean hp(String paramString)
  {
    AppMethodBeat.i(136895);
    if (this.fpM.fnK.containsKey(paramString))
    {
      AppMethodBeat.o(136895);
      return true;
    }
    AppMethodBeat.o(136895);
    return false;
  }
  
  public final boolean ia(String paramString)
  {
    AppMethodBeat.i(136916);
    if (this.fpO.containsKey(paramString))
    {
      bool = ((Boolean)this.fpO.get(paramString)).booleanValue();
      AppMethodBeat.o(136916);
      return bool;
    }
    boolean bool = com.tencent.mm.audio.mix.b.f.ads().hs(paramString);
    if (bool) {
      this.fpO.put(paramString, Boolean.valueOf(bool));
    }
    AppMethodBeat.o(136916);
    return bool;
  }
  
  public final boolean ib(String paramString)
  {
    AppMethodBeat.i(257523);
    boolean bool = this.fpN.hw(paramString);
    AppMethodBeat.o(257523);
    return bool;
  }
  
  public final boolean isPaused(String paramString)
  {
    AppMethodBeat.i(136907);
    d locald = this.fpM;
    if (locald.fqg.containsKey(paramString))
    {
      paramString = (e)locald.fqg.get(paramString);
      if (paramString != null) {
        if (paramString.f(new Integer[] { Integer.valueOf(2) }))
        {
          AppMethodBeat.o(136907);
          return true;
        }
      }
    }
    AppMethodBeat.o(136907);
    return false;
  }
  
  public final void r(int paramInt, String paramString)
  {
    AppMethodBeat.i(136912);
    this.fpM.r(paramInt, paramString);
    AppMethodBeat.o(136912);
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(136901);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "remove audioId:%s", new Object[] { paramString });
    d locald = this.fpM;
    locald.fnK.remove(paramString);
    locald.fqe.remove(paramString);
    locald.fqf.remove(paramString);
    synchronized (locald.fpY)
    {
      locald.fqg.remove(paramString);
      locald.foY.remove(paramString);
      locald.fqh.remove(paramString);
      ??? = this.fpN;
      if ((((com.tencent.mm.audio.mix.decode.a)???).fnJ.containsKey(paramString)) && (((com.tencent.mm.audio.mix.decode.a)???).fnM.contains(paramString))) {
        ((com.tencent.mm.audio.mix.decode.a)???).hy(paramString);
      }
      ((com.tencent.mm.audio.mix.decode.a)???).fnK.remove(paramString);
      ((com.tencent.mm.audio.mix.decode.a)???).fnM.remove(paramString);
      AppMethodBeat.o(136901);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.audio.mix.f.c
 * JD-Core Version:    0.7.0.1
 */
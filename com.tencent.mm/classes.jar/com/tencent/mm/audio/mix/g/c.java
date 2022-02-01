package com.tencent.mm.audio.mix.g;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.b.a.1;
import com.tencent.mm.audio.mix.b.a.2;
import com.tencent.mm.audio.mix.c.f.a;
import com.tencent.mm.audio.mix.d.i;
import com.tencent.mm.audio.mix.d.l;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
{
  public String appId;
  public d dxa;
  public com.tencent.mm.audio.mix.d.a dxb;
  public HashMap<String, Boolean> dxc;
  private com.tencent.mm.audio.mix.c.f dxd;
  public com.tencent.mm.audio.mix.b.a.d dxe;
  private volatile boolean dxf;
  
  public c()
  {
    AppMethodBeat.i(136888);
    this.dxc = new HashMap();
    this.dxf = false;
    this.dxa = new d();
    this.dxb = new com.tencent.mm.audio.mix.d.a(this.dxa);
    this.dxa.dxb = this.dxb;
    this.dxd = new com.tencent.mm.audio.mix.c.f();
    this.dxe = new com.tencent.mm.audio.mix.b.a.d();
    AppMethodBeat.o(136888);
  }
  
  private com.tencent.mm.ai.b ha(String paramString)
  {
    AppMethodBeat.i(136894);
    paramString = this.dxa.ha(paramString);
    AppMethodBeat.o(136894);
    return paramString;
  }
  
  private void i(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(136897);
    paramb.dtU = true;
    int i = this.dxa.hj(paramb.dtX);
    int j = this.dxa.ZR();
    if (!this.dxf)
    {
      if (i <= 2000) {
        paramb.dtU = false;
      }
      if ((i >= 5000) || (j > 5)) {
        break label184;
      }
    }
    label184:
    for (paramb.dtU = false;; paramb.dtU = true)
    {
      if (paramb.filePath.contains("scale_intro")) {
        paramb.dtU = false;
      }
      if (j <= 5) {
        break;
      }
      Object localObject = this.dxa.ZS();
      if (((ArrayList)localObject).contains(paramb.dtX)) {
        ((ArrayList)localObject).remove(paramb.dtX);
      }
      if (((ArrayList)localObject).size() <= 2) {
        break;
      }
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayer", "do stop paused audio size:%d", new Object[] { Integer.valueOf(((ArrayList)localObject).size()) });
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        he((String)((Iterator)localObject).next());
      }
    }
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayer", "playingCount:%d, duration:%d, supportMixPlay:%b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(paramb.dtU) });
    AppMethodBeat.o(136897);
  }
  
  public final boolean A(String paramString, int paramInt)
  {
    AppMethodBeat.i(136902);
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo audioId:%s, position:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    boolean bool2 = this.dxb.z(paramString, paramInt);
    if (!bool2)
    {
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo fail audioId:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(136902);
      return false;
    }
    q(10, paramString);
    long l = this.dxa.hp(paramString);
    int i = this.dxa.hq(paramString);
    boolean bool1;
    if (!hm(paramString))
    {
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo cache is not exist");
      bool1 = true;
    }
    for (;;)
    {
      q(6, paramString);
      if ((bool1) && (bool2))
      {
        AppMethodBeat.o(136902);
        return true;
        if (hj(paramString) <= 2000)
        {
          com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo duration is not support seek");
          if (!this.dxb.gN(paramString))
          {
            bool2 = this.dxb.y(paramString, paramInt);
            bool1 = true;
          }
        }
        else
        {
          if (Math.abs(paramInt - l) <= 3000L)
          {
            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo time is not support seek");
            bool1 = true;
            continue;
          }
          if ((i != 0) && (i != 1) && (i != 2))
          {
            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo state is not support seek");
            bool1 = true;
            continue;
          }
          if (!this.dxb.gN(paramString))
          {
            this.dxa.dxo.c(paramString, paramInt, false);
            bool2 = this.dxb.y(paramString, paramInt);
            bool1 = true;
            continue;
          }
          bool1 = this.dxa.dxo.c(paramString, paramInt, true);
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
  
  public final void ZH()
  {
    AppMethodBeat.i(136889);
    ??? = this.dxb;
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "pauseAllOnBackground");
    Object localObject2 = ((com.tencent.mm.audio.mix.d.a)???).dve.iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (String)((Iterator)localObject2).next();
      localObject4 = (com.tencent.mm.audio.mix.d.b)((com.tencent.mm.audio.mix.d.a)???).dvb.get(localObject4);
      if ((localObject4 != null) && (!((com.tencent.mm.audio.mix.d.b)localObject4).dvh) && (!((com.tencent.mm.audio.mix.d.b)localObject4).YT()))
      {
        localObject4 = ((com.tencent.mm.audio.mix.d.b)localObject4).dvi;
        if ((localObject4 != null) && (!((l)localObject4).YY())) {
          ((l)localObject4).YV();
        }
      }
    }
    ??? = this.dxa;
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "pauseAllOnBackground");
    ((d)???).dxo.Zs();
    ((d)???).ZL();
    ??? = this.dxd;
    ((com.tencent.mm.audio.mix.c.f)???).appId = this.appId;
    if (com.tencent.mm.audio.mix.c.f.duW == 0L) {
      com.tencent.mm.audio.mix.c.f.duW = 0L;
    }
    long l = System.currentTimeMillis();
    if (l - com.tencent.mm.audio.mix.c.f.duW <= com.tencent.mm.audio.mix.c.f.duT.longValue()) {
      com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioScanConvertCacheController", "startClean the last clean time is in AUDIO_MIX_NO_SCAN_TIME time");
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.audio.mix.b.f.YL();
      synchronized (((com.tencent.mm.audio.mix.b.f)localObject2).dup)
      {
        localObject4 = ((com.tencent.mm.audio.mix.b.f)localObject2).duo.iterator();
        Object localObject5;
        do
        {
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localObject5 = (String)((Iterator)localObject4).next();
          localObject5 = (com.tencent.mm.audio.mix.a.d)((com.tencent.mm.audio.mix.b.f)localObject2).cache.get(localObject5);
        } while ((localObject5 == null) || (!((com.tencent.mm.audio.mix.a.d)localObject5).aBQ) || (!((com.tencent.mm.audio.mix.a.d)localObject5).dtV));
        ((com.tencent.mm.audio.mix.a.d)localObject5).Ys();
      }
      com.tencent.mm.audio.mix.c.f.duW = l;
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioScanConvertCacheController", "start scan audio mix convert file");
      i.a(new f.a((com.tencent.mm.audio.mix.c.f)???, "clean audio mix convert cache"));
    }
    com.tencent.mm.audio.mix.b.a.Yw().Yy();
    AppMethodBeat.o(136889);
  }
  
  public final boolean ZI()
  {
    AppMethodBeat.i(136909);
    boolean bool = this.dxa.dxj.get();
    AppMethodBeat.o(136909);
    return bool;
  }
  
  public final void ZJ()
  {
    AppMethodBeat.i(136913);
    String str = this.appId;
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioPcmDataTrackTaskController", "recycleAllCache appId:%s", new Object[] { str });
    com.tencent.mm.audio.mix.b.a.d.a(new com.tencent.mm.audio.mix.b.a.c(str), "AudioPcmDataTrackRecycleCacheTask");
    this.dxc.clear();
    AppMethodBeat.o(136913);
  }
  
  public final long ZK()
  {
    return this.dxa.dxo.dwr;
  }
  
  public final void a(b paramb)
  {
    this.dxa.dxp = paramb;
  }
  
  public final void a(g paramg)
  {
    this.dxa.dxr = paramg;
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(136890);
    this.dxb.clearCache();
    this.dxa.clearCache();
    AppMethodBeat.o(136890);
  }
  
  public final void f(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(136891);
    this.appId = paramb.appId;
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayer", "preparePlay:%s", new Object[] { paramb.dtX });
    ??? = com.tencent.mm.audio.mix.b.a.Yw();
    Object localObject3 = this.appId;
    Object localObject1 = null;
    if ((!TextUtils.isEmpty(((com.tencent.mm.audio.mix.b.a)???).currentAppId)) && (!((String)localObject3).equals(((com.tencent.mm.audio.mix.b.a)???).currentAppId)))
    {
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioCachePathMgr", "init");
      localObject1 = ((com.tencent.mm.audio.mix.b.a)???).currentAppId;
      ((com.tencent.mm.audio.mix.b.a)???).currentAppId = ((String)localObject3);
      localObject1 = new a.1((com.tencent.mm.audio.mix.b.a)???, (String)localObject1, (String)localObject3);
    }
    for (;;)
    {
      if (localObject1 != null) {
        com.tencent.mm.audio.mix.b.a.a((com.tencent.mm.audio.mix.b.a.f)localObject1, "init cache path");
      }
      if ((hn(paramb.filePath)) && (paramb.iJE)) {
        i(paramb);
      }
      localObject1 = this.dxa;
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "preparePlay");
      if ((!paramb.iJT) && (paramb.iJE)) {
        if (((d)localObject1).dxh.get())
        {
          ((d)localObject1).ZM();
          label180:
          ((d)localObject1).dvc.put(paramb.dtX, paramb);
        }
      }
      synchronized (((d)localObject1).dxm)
      {
        for (;;)
        {
          ((d)localObject1).dwo.put(paramb.dtX, Boolean.FALSE);
          ((d)localObject1).dxo.gQ(paramb.dtX);
          ((d)localObject1).dxo.Zr();
          localObject1 = this.dxb;
          com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "prepareDecode");
          if (paramb == null)
          {
            com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecodeMgr", "param is null");
            AppMethodBeat.o(136891);
            return;
            if (!TextUtils.isEmpty(((com.tencent.mm.audio.mix.b.a)???).currentAppId)) {
              break;
            }
            ((com.tencent.mm.audio.mix.b.a)???).currentAppId = ((String)localObject3);
            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioCachePathMgr", "init");
            localObject1 = new a.2((com.tencent.mm.audio.mix.b.a)???, (String)localObject3);
            break;
            if (((d)localObject1).dxh.get()) {
              break label180;
            }
            com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "initThread");
            ((d)localObject1).dxh.set(true);
            ((d)localObject1).dxj.set(false);
            ((d)localObject1).dxi.set(false);
            ((d)localObject1).ZM();
            break label180;
            if (!paramb.iJT) {
              break label180;
            }
            synchronized (((d)localObject1).dxm)
            {
              if (((d)localObject1).dxu.containsKey(paramb.dtX))
              {
                localObject3 = (e)((d)localObject1).dxu.get(paramb.dtX);
                if (localObject3 != null) {
                  if (((e)localObject3).f(new Integer[] { Integer.valueOf(4) })) {
                    ((d)localObject1).dxu.remove(paramb.dtX);
                  }
                }
              }
            }
          }
        }
      }
    }
    if (TextUtils.isEmpty(paramb.dtX))
    {
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "audioId is empty!");
      AppMethodBeat.o(136891);
      return;
    }
    if (!((com.tencent.mm.audio.mix.d.a)localObject1).dve.contains(paramb.dtX))
    {
      ((com.tencent.mm.audio.mix.d.a)localObject1).dve.add(paramb.dtX);
      ((com.tencent.mm.audio.mix.d.a)localObject1).dvc.put(paramb.dtX, paramb);
      bool = false;
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "ids:%d, id2ParamMap:%d", new Object[] { Integer.valueOf(((com.tencent.mm.audio.mix.d.a)localObject1).dve.size()), Integer.valueOf(((com.tencent.mm.audio.mix.d.a)localObject1).dvc.size()) });
      if (!paramb.iJT) {
        break label720;
      }
      bool = ((com.tencent.mm.audio.mix.d.a)localObject1).c(paramb.dtX, bool, true);
      ??? = ((com.tencent.mm.audio.mix.d.a)localObject1).dup;
      if (!bool) {}
    }
    try
    {
      if (!((com.tencent.mm.audio.mix.d.a)localObject1).dvd.contains(paramb.filePath)) {
        ((com.tencent.mm.audio.mix.d.a)localObject1).dvd.add(paramb.filePath);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(136891);
    }
    if (((com.tencent.mm.ai.b)((com.tencent.mm.audio.mix.d.a)localObject1).dvc.get(paramb.dtX)).j(paramb)) {
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "is same param");
    }
    for (boolean bool = false;; bool = true)
    {
      ((com.tencent.mm.audio.mix.d.a)localObject1).dvc.put(paramb.dtX, paramb);
      break;
      com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "force to decode");
    }
    label720:
    if (paramb.iJE)
    {
      ((com.tencent.mm.audio.mix.d.a)localObject1).c(paramb.dtX, bool, false);
      AppMethodBeat.o(136891);
      return;
    }
    bool = ((com.tencent.mm.audio.mix.d.a)localObject1).c(paramb.dtX, bool, true);
    ??? = ((com.tencent.mm.audio.mix.d.a)localObject1).dup;
    if (bool) {}
    try
    {
      if (!((com.tencent.mm.audio.mix.d.a)localObject1).dvd.contains(paramb.filePath)) {
        ((com.tencent.mm.audio.mix.d.a)localObject1).dvd.add(paramb.filePath);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(136891);
    }
  }
  
  public final void g(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(136892);
    this.dxa.dvc.put(paramb.dtX, paramb);
    this.dxb.dvc.put(paramb.dtX, paramb);
    AppMethodBeat.o(136892);
  }
  
  public final boolean gD(String paramString)
  {
    AppMethodBeat.i(136895);
    if (this.dxa.dvc.containsKey(paramString))
    {
      AppMethodBeat.o(136895);
      return true;
    }
    AppMethodBeat.o(136895);
    return false;
  }
  
  public final boolean gO(String paramString)
  {
    AppMethodBeat.i(136903);
    boolean bool = this.dxa.gO(paramString);
    AppMethodBeat.o(136903);
    return bool;
  }
  
  public final void h(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(136893);
    Object localObject = this.dxa;
    if (((d)localObject).dvc.containsKey(paramb.dtX)) {
      ((d)localObject).dvc.put(paramb.dtX, paramb);
    }
    localObject = this.dxb;
    if (((com.tencent.mm.audio.mix.d.a)localObject).dvc.containsKey(paramb.dtX)) {
      ((com.tencent.mm.audio.mix.d.a)localObject).dvc.put(paramb.dtX, paramb);
    }
    AppMethodBeat.o(136893);
  }
  
  public final void hb(String paramString)
  {
    AppMethodBeat.i(136896);
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayer", "play audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.dxa.hq(paramString)) });
    i(this.dxa.ha(paramString));
    d locald = this.dxa;
    locald.dxj.set(false);
    locald.dxi.set(false);
    locald.ZQ();
    locald.ZM();
    synchronized (locald.dxm)
    {
      locald.dwo.put(paramString, Boolean.FALSE);
      locald.dxo.gQ(paramString);
      locald.dxs.remove(paramString);
      locald.dxt.put(paramString, Boolean.TRUE);
      if ((locald.dxb.gN(paramString)) && (locald.dxb.gO(paramString))) {
        locald.q(0, paramString);
      }
      this.dxb.gL(paramString);
      AppMethodBeat.o(136896);
      return;
    }
  }
  
  public final void hc(String paramString)
  {
    AppMethodBeat.i(136898);
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayer", "resume audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.dxa.hq(paramString)) });
    i(this.dxa.ha(paramString));
    d locald = this.dxa;
    locald.dxj.set(false);
    locald.dxi.set(false);
    locald.ZQ();
    locald.ZM();
    synchronized (locald.dxm)
    {
      locald.dwo.put(paramString, Boolean.FALSE);
      locald.dxo.gQ(paramString);
      locald.dxs.remove(paramString);
      locald.dxt.put(paramString, Boolean.TRUE);
      if ((locald.dxb.gN(paramString)) && (locald.dxb.gO(paramString))) {
        locald.q(1, paramString);
      }
      this.dxb.gL(paramString);
      AppMethodBeat.o(136898);
      return;
    }
  }
  
  public final void hd(String paramString)
  {
    AppMethodBeat.i(136899);
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayer", "pause audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.dxa.hq(paramString)) });
    Object localObject = this.dxa;
    ((d)localObject).dxo.gR(paramString);
    if ((((d)localObject).dxb.gN(paramString)) && (((d)localObject).dxb.gO(paramString))) {
      ((d)localObject).q(2, paramString);
    }
    localObject = this.dxb;
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioDecodeMgr", "pauseDecode audioId:%s", new Object[] { paramString });
    paramString = (com.tencent.mm.audio.mix.d.b)((com.tencent.mm.audio.mix.d.a)localObject).dvb.get(paramString);
    if (paramString == null)
    {
      com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
      AppMethodBeat.o(136899);
      return;
    }
    if (paramString.dvh)
    {
      com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
      AppMethodBeat.o(136899);
      return;
    }
    if (paramString.YT())
    {
      com.tencent.mm.audio.mix.i.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is isDetach!");
      AppMethodBeat.o(136899);
      return;
    }
    paramString = paramString.dvi;
    if (paramString != null) {
      paramString.pause();
    }
    AppMethodBeat.o(136899);
  }
  
  public final void he(String paramString)
  {
    AppMethodBeat.i(136900);
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayer", "stop audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.dxa.hq(paramString)) });
    this.dxa.he(paramString);
    this.dxb.gM(paramString);
    AppMethodBeat.o(136900);
  }
  
  public final boolean hf(String paramString)
  {
    AppMethodBeat.i(136904);
    d locald = this.dxa;
    if (locald.dxt.containsKey(paramString))
    {
      boolean bool = ((Boolean)locald.dxt.get(paramString)).booleanValue();
      AppMethodBeat.o(136904);
      return bool;
    }
    AppMethodBeat.o(136904);
    return false;
  }
  
  public final boolean hg(String paramString)
  {
    AppMethodBeat.i(136905);
    d locald = this.dxa;
    if (locald.dxu.containsKey(paramString))
    {
      paramString = (e)locald.dxu.get(paramString);
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
  
  public final boolean hh(String paramString)
  {
    AppMethodBeat.i(136906);
    d locald = this.dxa;
    if (locald.dxu.containsKey(paramString))
    {
      paramString = (e)locald.dxu.get(paramString);
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
  
  public final boolean hi(String paramString)
  {
    AppMethodBeat.i(136908);
    d locald = this.dxa;
    if (locald.dxu.containsKey(paramString))
    {
      paramString = (e)locald.dxu.get(paramString);
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
  
  public final int hj(String paramString)
  {
    AppMethodBeat.i(136910);
    int i = this.dxa.hj(paramString);
    AppMethodBeat.o(136910);
    return i;
  }
  
  public final com.tencent.mm.ai.d hk(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(136911);
    d locald1 = this.dxa;
    com.tencent.mm.ai.d locald;
    int j;
    int k;
    boolean bool1;
    int i;
    if (locald1.dxv.containsKey(paramString))
    {
      locald = (com.tencent.mm.ai.d)locald1.dxv.get(paramString);
      j = locald1.hj(paramString);
      k = locald1.hp(paramString);
      bool1 = locald1.gO(paramString);
      if (!locald1.dvc.containsKey(paramString)) {
        break label300;
      }
      Object localObject = ((com.tencent.mm.ai.b)locald1.dvc.get(paramString)).filePath;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label300;
      }
      localObject = com.tencent.mm.audio.mix.b.f.YL().gE((String)localObject);
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
      locald.dCS = k;
      locald.duration = j;
      if (bool1)
      {
        bool1 = false;
        locald.tN = bool1;
        if ((!locald1.dxs.containsKey(paramString)) || (!((Boolean)locald1.dxs.get(paramString)).booleanValue())) {
          break label311;
        }
      }
      for (bool1 = bool2;; bool1 = false)
      {
        locald.iJV = bool1;
        locald.iJW = (i * j / 100);
        if (!locald1.dvc.containsKey(paramString)) {
          break label317;
        }
        paramString = (com.tencent.mm.ai.b)locald1.dvc.get(paramString);
        locald.dvv = paramString.iJD;
        locald.dtT = paramString.dvn;
        locald.iJP = paramString.iJP;
        AppMethodBeat.o(136911);
        return locald;
        locald = new com.tencent.mm.ai.d();
        locald1.dxv.put(paramString, locald);
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
  
  public final void hl(String paramString)
  {
    AppMethodBeat.i(136914);
    String str = this.appId;
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioPcmDataTrackTaskController", "cacheToFile appId:%s, filePath:%s", new Object[] { str, paramString });
    com.tencent.mm.audio.mix.b.a.d.a(new com.tencent.mm.audio.mix.b.a.a(str, paramString), "AudioPcmDataTrackCacheToFileTask");
    AppMethodBeat.o(136914);
  }
  
  public final boolean hm(String paramString)
  {
    AppMethodBeat.i(136915);
    paramString = ha(paramString);
    if (paramString != null)
    {
      if (this.dxc.containsKey(paramString.filePath))
      {
        bool = ((Boolean)this.dxc.get(paramString.filePath)).booleanValue();
        AppMethodBeat.o(136915);
        return bool;
      }
      boolean bool = com.tencent.mm.audio.mix.b.f.YL().gG(paramString.filePath);
      if (bool) {
        this.dxc.put(paramString.filePath, Boolean.valueOf(bool));
      }
      AppMethodBeat.o(136915);
      return bool;
    }
    AppMethodBeat.o(136915);
    return false;
  }
  
  public final boolean hn(String paramString)
  {
    AppMethodBeat.i(136916);
    if (this.dxc.containsKey(paramString))
    {
      bool = ((Boolean)this.dxc.get(paramString)).booleanValue();
      AppMethodBeat.o(136916);
      return bool;
    }
    boolean bool = com.tencent.mm.audio.mix.b.f.YL().gG(paramString);
    if (bool) {
      this.dxc.put(paramString, Boolean.valueOf(bool));
    }
    AppMethodBeat.o(136916);
    return bool;
  }
  
  public final boolean ho(String paramString)
  {
    AppMethodBeat.i(198128);
    boolean bool = this.dxb.gK(paramString);
    AppMethodBeat.o(198128);
    return bool;
  }
  
  public final boolean isPaused(String paramString)
  {
    AppMethodBeat.i(136907);
    d locald = this.dxa;
    if (locald.dxu.containsKey(paramString))
    {
      paramString = (e)locald.dxu.get(paramString);
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
  
  public final void q(int paramInt, String paramString)
  {
    AppMethodBeat.i(136912);
    this.dxa.q(paramInt, paramString);
    AppMethodBeat.o(136912);
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(136901);
    com.tencent.mm.audio.mix.i.b.i("MicroMsg.Mix.AudioMixPlayer", "remove audioId:%s", new Object[] { paramString });
    d locald = this.dxa;
    locald.dvc.remove(paramString);
    locald.dxs.remove(paramString);
    locald.dxt.remove(paramString);
    synchronized (locald.dxm)
    {
      locald.dxu.remove(paramString);
      locald.dwo.remove(paramString);
      locald.dxv.remove(paramString);
      ??? = this.dxb;
      if ((((com.tencent.mm.audio.mix.d.a)???).dvb.containsKey(paramString)) && (((com.tencent.mm.audio.mix.d.a)???).dve.contains(paramString))) {
        ((com.tencent.mm.audio.mix.d.a)???).gM(paramString);
      }
      ((com.tencent.mm.audio.mix.d.a)???).dvc.remove(paramString);
      ((com.tencent.mm.audio.mix.d.a)???).dve.remove(paramString);
      AppMethodBeat.o(136901);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.audio.mix.g.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.audio.mix.f;

import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.audio.mix.c.e.a;
import com.tencent.mm.audio.mix.d.h;
import com.tencent.mm.audio.mix.d.k;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public final class c
{
  public String appId;
  public d deO;
  public com.tencent.mm.audio.mix.d.a deP;
  public HashMap<String, Boolean> deQ;
  private com.tencent.mm.audio.mix.c.e deR;
  public com.tencent.mm.audio.mix.b.a.d deS;
  private volatile boolean deT;
  
  public c()
  {
    AppMethodBeat.i(136888);
    this.deQ = new HashMap();
    this.deT = false;
    this.deO = new d();
    this.deP = new com.tencent.mm.audio.mix.d.a(this.deO);
    this.deO.deP = this.deP;
    this.deR = new com.tencent.mm.audio.mix.c.e();
    this.deS = new com.tencent.mm.audio.mix.b.a.d();
    AppMethodBeat.o(136888);
  }
  
  private void d(com.tencent.mm.aj.b paramb)
  {
    AppMethodBeat.i(136897);
    paramb.dcb = true;
    int i = this.deO.go(paramb.dce);
    int j = this.deO.Pz();
    if (!this.deT)
    {
      if (i <= 2000) {
        paramb.dcb = false;
      }
      if ((i >= 5000) || (j > 5)) {
        break label184;
      }
    }
    label184:
    for (paramb.dcb = false;; paramb.dcb = true)
    {
      if (paramb.filePath.contains("scale_intro")) {
        paramb.dcb = false;
      }
      if (j <= 5) {
        break;
      }
      Object localObject = this.deO.PA();
      if (((ArrayList)localObject).contains(paramb.dce)) {
        ((ArrayList)localObject).remove(paramb.dce);
      }
      if (((ArrayList)localObject).size() <= 2) {
        break;
      }
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "do stop paused audio size:%d", new Object[] { Integer.valueOf(((ArrayList)localObject).size()) });
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        gj((String)((Iterator)localObject).next());
      }
    }
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "playingCount:%d, duration:%d, supportMixPlay:%b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(paramb.dcb) });
    AppMethodBeat.o(136897);
  }
  
  private com.tencent.mm.aj.b ge(String paramString)
  {
    AppMethodBeat.i(136894);
    paramString = this.deO.ge(paramString);
    AppMethodBeat.o(136894);
    return paramString;
  }
  
  public final void Pp()
  {
    AppMethodBeat.i(136889);
    ??? = this.deP;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "pauseAllOnBackground");
    Object localObject2 = ((com.tencent.mm.audio.mix.d.a)???).ddg.iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (String)((Iterator)localObject2).next();
      localObject4 = (com.tencent.mm.audio.mix.d.b)((com.tencent.mm.audio.mix.d.a)???).ddd.get(localObject4);
      if ((localObject4 != null) && (!((com.tencent.mm.audio.mix.d.b)localObject4).ddj) && (!((com.tencent.mm.audio.mix.d.b)localObject4).OD()))
      {
        localObject4 = ((com.tencent.mm.audio.mix.d.b)localObject4).ddk;
        if ((localObject4 != null) && (!((k)localObject4).OI())) {
          ((k)localObject4).OF();
        }
      }
    }
    ??? = this.deO;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "pauseAllOnBackground");
    ((d)???).dfc.Pa();
    ((d)???).Pt();
    ??? = this.deR;
    if (com.tencent.mm.audio.mix.c.e.dcY == 0L) {
      com.tencent.mm.audio.mix.c.e.dcY = 0L;
    }
    long l = System.currentTimeMillis();
    if (l - com.tencent.mm.audio.mix.c.e.dcY <= com.tencent.mm.audio.mix.c.e.dcV.longValue()) {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioScanConvertCacheController", "startClean the last clean time is in AUDIO_MIX_NO_SCAN_TIME time");
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.audio.mix.b.e.Ou();
      synchronized (((com.tencent.mm.audio.mix.b.e)localObject2).dcs)
      {
        localObject4 = ((com.tencent.mm.audio.mix.b.e)localObject2).dcr.iterator();
        Object localObject5;
        do
        {
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localObject5 = (String)((Iterator)localObject4).next();
          localObject5 = (com.tencent.mm.audio.mix.a.d)((com.tencent.mm.audio.mix.b.e)localObject2).cache.get(localObject5);
        } while ((localObject5 == null) || (!((com.tencent.mm.audio.mix.a.d)localObject5).aBS) || (!((com.tencent.mm.audio.mix.a.d)localObject5).dcc));
        ((com.tencent.mm.audio.mix.a.d)localObject5).Oi();
      }
      com.tencent.mm.audio.mix.c.e.dcY = l;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioScanConvertCacheController", "start scan audio mix convert file");
      h.a(new e.a((com.tencent.mm.audio.mix.c.e)???, "clean audio mix convert cache"));
    }
    AppMethodBeat.o(136889);
  }
  
  public final boolean Pq()
  {
    AppMethodBeat.i(136909);
    boolean bool = this.deO.deX.get();
    AppMethodBeat.o(136909);
    return bool;
  }
  
  public final void Pr()
  {
    AppMethodBeat.i(136913);
    String str = this.appId;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmDataTrackTaskController", "recycleAllCache appId:%s", new Object[] { str });
    com.tencent.mm.audio.mix.b.a.d.a(new com.tencent.mm.audio.mix.b.a.c(str), "AudioPcmDataTrackRecycleCacheTask");
    this.deQ.clear();
    AppMethodBeat.o(136913);
  }
  
  public final long Ps()
  {
    return this.deO.dfc.def;
  }
  
  public final void a(com.tencent.mm.aj.b paramb)
  {
    AppMethodBeat.i(136891);
    this.appId = paramb.appId;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "preparePlay:%s", new Object[] { paramb.dce });
    if ((gs(paramb.filePath)) && (paramb.hLF)) {
      d(paramb);
    }
    Object localObject1 = this.deO;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "preparePlay");
    if ((!paramb.hLU) && (paramb.hLF)) {
      if (((d)localObject1).deV.get()) {
        ((d)localObject1).Pu();
      }
    }
    for (;;)
    {
      ((d)localObject1).dde.put(paramb.dce, paramb);
      synchronized (((d)localObject1).dfa)
      {
        ((d)localObject1).dec.put(paramb.dce, Boolean.FALSE);
        ((d)localObject1).dfc.fU(paramb.dce);
        ((d)localObject1).dfc.OZ();
        localObject1 = this.deP;
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "prepareDecode");
        if (paramb == null)
        {
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "param is null");
          AppMethodBeat.o(136891);
          return;
          if (((d)localObject1).deV.get()) {
            continue;
          }
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "initThread");
          ((d)localObject1).deV.set(true);
          ((d)localObject1).deX.set(false);
          ((d)localObject1).deW.set(false);
          ((d)localObject1).Pu();
          continue;
          if (!paramb.hLU) {
            continue;
          }
          synchronized (((d)localObject1).dfa)
          {
            if (((d)localObject1).dfi.containsKey(paramb.dce))
            {
              e locale = (e)((d)localObject1).dfi.get(paramb.dce);
              if (locale != null) {
                if (locale.h(new Integer[] { Integer.valueOf(4) })) {
                  ((d)localObject1).dfi.remove(paramb.dce);
                }
              }
            }
          }
        }
      }
    }
    if (TextUtils.isEmpty(paramb.dce))
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "audioId is empty!");
      AppMethodBeat.o(136891);
      return;
    }
    if (!((com.tencent.mm.audio.mix.d.a)localObject1).ddg.contains(paramb.dce))
    {
      ((com.tencent.mm.audio.mix.d.a)localObject1).ddg.add(paramb.dce);
      ((com.tencent.mm.audio.mix.d.a)localObject1).dde.put(paramb.dce, paramb);
      bool = false;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "ids:%d, id2ParamMap:%d", new Object[] { Integer.valueOf(((com.tencent.mm.audio.mix.d.a)localObject1).ddg.size()), Integer.valueOf(((com.tencent.mm.audio.mix.d.a)localObject1).dde.size()) });
      if (!paramb.hLU) {
        break label595;
      }
      bool = ((com.tencent.mm.audio.mix.d.a)localObject1).b(paramb.dce, bool, true);
      ??? = ((com.tencent.mm.audio.mix.d.a)localObject1).dcs;
      if (!bool) {}
    }
    try
    {
      if (!((com.tencent.mm.audio.mix.d.a)localObject1).ddf.contains(paramb.filePath)) {
        ((com.tencent.mm.audio.mix.d.a)localObject1).ddf.add(paramb.filePath);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(136891);
    }
    if (((com.tencent.mm.aj.b)((com.tencent.mm.audio.mix.d.a)localObject1).dde.get(paramb.dce)).e(paramb)) {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "is same param");
    }
    for (boolean bool = false;; bool = true)
    {
      ((com.tencent.mm.audio.mix.d.a)localObject1).dde.put(paramb.dce, paramb);
      break;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "force to decode");
    }
    label595:
    if (paramb.hLF)
    {
      ((com.tencent.mm.audio.mix.d.a)localObject1).b(paramb.dce, bool, false);
      AppMethodBeat.o(136891);
      return;
    }
    bool = ((com.tencent.mm.audio.mix.d.a)localObject1).b(paramb.dce, bool, true);
    ??? = ((com.tencent.mm.audio.mix.d.a)localObject1).dcs;
    if (bool) {}
    try
    {
      if (!((com.tencent.mm.audio.mix.d.a)localObject1).ddf.contains(paramb.filePath)) {
        ((com.tencent.mm.audio.mix.d.a)localObject1).ddf.add(paramb.filePath);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(136891);
    }
  }
  
  public final void a(b paramb)
  {
    this.deO.dfd = paramb;
  }
  
  public final void a(g paramg)
  {
    this.deO.dff = paramg;
  }
  
  public final void b(com.tencent.mm.aj.b paramb)
  {
    AppMethodBeat.i(136892);
    this.deO.dde.put(paramb.dce, paramb);
    this.deP.dde.put(paramb.dce, paramb);
    AppMethodBeat.o(136892);
  }
  
  public final void c(com.tencent.mm.aj.b paramb)
  {
    AppMethodBeat.i(136893);
    Object localObject = this.deO;
    if (((d)localObject).dde.containsKey(paramb.dce)) {
      ((d)localObject).dde.put(paramb.dce, paramb);
    }
    localObject = this.deP;
    if (((com.tencent.mm.audio.mix.d.a)localObject).dde.containsKey(paramb.dce)) {
      ((com.tencent.mm.audio.mix.d.a)localObject).dde.put(paramb.dce, paramb);
    }
    AppMethodBeat.o(136893);
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(136890);
    this.deP.clearCache();
    this.deO.clearCache();
    AppMethodBeat.o(136890);
  }
  
  public final boolean fS(String paramString)
  {
    AppMethodBeat.i(136903);
    boolean bool = this.deO.fS(paramString);
    AppMethodBeat.o(136903);
    return bool;
  }
  
  public final boolean gf(String paramString)
  {
    AppMethodBeat.i(136895);
    if (this.deO.dde.containsKey(paramString))
    {
      AppMethodBeat.o(136895);
      return true;
    }
    AppMethodBeat.o(136895);
    return false;
  }
  
  public final void gg(String paramString)
  {
    AppMethodBeat.i(136896);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "play audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.deO.gu(paramString)) });
    d(this.deO.ge(paramString));
    d locald = this.deO;
    locald.deX.set(false);
    locald.deW.set(false);
    locald.Py();
    locald.Pu();
    synchronized (locald.dfa)
    {
      locald.dec.put(paramString, Boolean.FALSE);
      locald.dfc.fU(paramString);
      locald.dfg.remove(paramString);
      locald.dfh.put(paramString, Boolean.TRUE);
      if ((locald.deP.fR(paramString)) && (locald.deP.fS(paramString))) {
        locald.o(0, paramString);
      }
      this.deP.fP(paramString);
      AppMethodBeat.o(136896);
      return;
    }
  }
  
  public final void gh(String paramString)
  {
    AppMethodBeat.i(136898);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "resume audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.deO.gu(paramString)) });
    d(this.deO.ge(paramString));
    d locald = this.deO;
    locald.deX.set(false);
    locald.deW.set(false);
    locald.Py();
    locald.Pu();
    synchronized (locald.dfa)
    {
      locald.dec.put(paramString, Boolean.FALSE);
      locald.dfc.fU(paramString);
      locald.dfg.remove(paramString);
      locald.dfh.put(paramString, Boolean.TRUE);
      if ((locald.deP.fR(paramString)) && (locald.deP.fS(paramString))) {
        locald.o(1, paramString);
      }
      this.deP.fP(paramString);
      AppMethodBeat.o(136898);
      return;
    }
  }
  
  public final void gi(String paramString)
  {
    AppMethodBeat.i(136899);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "pause audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.deO.gu(paramString)) });
    Object localObject = this.deO;
    ((d)localObject).dfc.fV(paramString);
    if ((((d)localObject).deP.fR(paramString)) && (((d)localObject).deP.fS(paramString))) {
      ((d)localObject).o(2, paramString);
    }
    localObject = this.deP;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "pauseDecode audioId:%s", new Object[] { paramString });
    paramString = (com.tencent.mm.audio.mix.d.b)((com.tencent.mm.audio.mix.d.a)localObject).ddd.get(paramString);
    if (paramString == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
      AppMethodBeat.o(136899);
      return;
    }
    if (paramString.ddj)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
      AppMethodBeat.o(136899);
      return;
    }
    if (paramString.OD())
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is isDetach!");
      AppMethodBeat.o(136899);
      return;
    }
    paramString = paramString.ddk;
    if (paramString != null) {
      paramString.pause();
    }
    AppMethodBeat.o(136899);
  }
  
  public final void gj(String paramString)
  {
    AppMethodBeat.i(136900);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "stop audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.deO.gu(paramString)) });
    this.deO.gj(paramString);
    this.deP.fQ(paramString);
    AppMethodBeat.o(136900);
  }
  
  public final boolean gk(String paramString)
  {
    AppMethodBeat.i(136904);
    d locald = this.deO;
    if (locald.dfh.containsKey(paramString))
    {
      boolean bool = ((Boolean)locald.dfh.get(paramString)).booleanValue();
      AppMethodBeat.o(136904);
      return bool;
    }
    AppMethodBeat.o(136904);
    return false;
  }
  
  public final boolean gl(String paramString)
  {
    AppMethodBeat.i(136905);
    d locald = this.deO;
    if (locald.dfi.containsKey(paramString))
    {
      paramString = (e)locald.dfi.get(paramString);
      if (paramString != null) {
        if (paramString.h(new Integer[] { Integer.valueOf(9) }))
        {
          AppMethodBeat.o(136905);
          return true;
        }
      }
    }
    AppMethodBeat.o(136905);
    return false;
  }
  
  public final boolean gm(String paramString)
  {
    AppMethodBeat.i(136906);
    d locald = this.deO;
    if (locald.dfi.containsKey(paramString))
    {
      paramString = (e)locald.dfi.get(paramString);
      if (paramString != null) {
        if (paramString.h(new Integer[] { Integer.valueOf(7) }))
        {
          AppMethodBeat.o(136906);
          return true;
        }
      }
    }
    AppMethodBeat.o(136906);
    return false;
  }
  
  public final boolean gn(String paramString)
  {
    AppMethodBeat.i(136908);
    d locald = this.deO;
    if (locald.dfi.containsKey(paramString))
    {
      paramString = (e)locald.dfi.get(paramString);
      if (paramString != null)
      {
        if (!paramString.h(new Integer[] { Integer.valueOf(3) })) {
          if (!paramString.h(new Integer[] { Integer.valueOf(4) })) {
            if (!paramString.h(new Integer[] { Integer.valueOf(5) })) {
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
  
  public final int go(String paramString)
  {
    AppMethodBeat.i(136910);
    int i = this.deO.go(paramString);
    AppMethodBeat.o(136910);
    return i;
  }
  
  public final com.tencent.mm.aj.d gp(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(136911);
    d locald1 = this.deO;
    com.tencent.mm.aj.d locald;
    int j;
    int k;
    boolean bool1;
    int i;
    if (locald1.dfj.containsKey(paramString))
    {
      locald = (com.tencent.mm.aj.d)locald1.dfj.get(paramString);
      j = locald1.go(paramString);
      k = locald1.gt(paramString);
      bool1 = locald1.fS(paramString);
      if (!locald1.dde.containsKey(paramString)) {
        break label300;
      }
      Object localObject = ((com.tencent.mm.aj.b)locald1.dde.get(paramString)).filePath;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label300;
      }
      localObject = com.tencent.mm.audio.mix.b.e.Ou().fJ((String)localObject);
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
      locald.dkA = k;
      locald.duration = j;
      if (bool1)
      {
        bool1 = false;
        locald.tG = bool1;
        if ((!locald1.dfg.containsKey(paramString)) || (!((Boolean)locald1.dfg.get(paramString)).booleanValue())) {
          break label311;
        }
      }
      for (bool1 = bool2;; bool1 = false)
      {
        locald.hLV = bool1;
        locald.hLW = (i * j / 100);
        if (!locald1.dde.containsKey(paramString)) {
          break label317;
        }
        paramString = (com.tencent.mm.aj.b)locald1.dde.get(paramString);
        locald.ddx = paramString.hLE;
        locald.dca = paramString.ddp;
        locald.hLQ = paramString.hLQ;
        AppMethodBeat.o(136911);
        return locald;
        locald = new com.tencent.mm.aj.d();
        locald1.dfj.put(paramString, locald);
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
  
  public final void gq(String paramString)
  {
    AppMethodBeat.i(136914);
    String str = this.appId;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmDataTrackTaskController", "cacheToFile appId:%s, filePath:%s", new Object[] { str, paramString });
    com.tencent.mm.audio.mix.b.a.d.a(new com.tencent.mm.audio.mix.b.a.a(str, paramString), "AudioPcmDataTrackCacheToFileTask");
    AppMethodBeat.o(136914);
  }
  
  public final boolean gr(String paramString)
  {
    AppMethodBeat.i(136915);
    paramString = ge(paramString);
    if (paramString != null)
    {
      if (this.deQ.containsKey(paramString.filePath))
      {
        bool = ((Boolean)this.deQ.get(paramString.filePath)).booleanValue();
        AppMethodBeat.o(136915);
        return bool;
      }
      boolean bool = com.tencent.mm.audio.mix.b.e.Ou().fL(paramString.filePath);
      if (bool) {
        this.deQ.put(paramString.filePath, Boolean.valueOf(bool));
      }
      AppMethodBeat.o(136915);
      return bool;
    }
    AppMethodBeat.o(136915);
    return false;
  }
  
  public final boolean gs(String paramString)
  {
    AppMethodBeat.i(136916);
    if (this.deQ.containsKey(paramString))
    {
      bool = ((Boolean)this.deQ.get(paramString)).booleanValue();
      AppMethodBeat.o(136916);
      return bool;
    }
    boolean bool = com.tencent.mm.audio.mix.b.e.Ou().fL(paramString);
    if (bool) {
      this.deQ.put(paramString, Boolean.valueOf(bool));
    }
    AppMethodBeat.o(136916);
    return bool;
  }
  
  public final boolean isPaused(String paramString)
  {
    AppMethodBeat.i(136907);
    d locald = this.deO;
    if (locald.dfi.containsKey(paramString))
    {
      paramString = (e)locald.dfi.get(paramString);
      if (paramString != null) {
        if (paramString.h(new Integer[] { Integer.valueOf(2) }))
        {
          AppMethodBeat.o(136907);
          return true;
        }
      }
    }
    AppMethodBeat.o(136907);
    return false;
  }
  
  public final void o(int paramInt, String paramString)
  {
    AppMethodBeat.i(136912);
    this.deO.o(paramInt, paramString);
    AppMethodBeat.o(136912);
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(136901);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "remove audioId:%s", new Object[] { paramString });
    d locald = this.deO;
    locald.dde.remove(paramString);
    locald.dfg.remove(paramString);
    locald.dfh.remove(paramString);
    synchronized (locald.dfa)
    {
      locald.dfi.remove(paramString);
      locald.dec.remove(paramString);
      locald.dfj.remove(paramString);
      ??? = this.deP;
      if ((((com.tencent.mm.audio.mix.d.a)???).ddd.containsKey(paramString)) && (((com.tencent.mm.audio.mix.d.a)???).ddg.contains(paramString))) {
        ((com.tencent.mm.audio.mix.d.a)???).fQ(paramString);
      }
      ((com.tencent.mm.audio.mix.d.a)???).dde.remove(paramString);
      ((com.tencent.mm.audio.mix.d.a)???).ddg.remove(paramString);
      AppMethodBeat.o(136901);
      return;
    }
  }
  
  public final boolean y(String paramString, int paramInt)
  {
    AppMethodBeat.i(136902);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo audioId:%s, position:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    boolean bool2 = this.deP.x(paramString, paramInt);
    if (!bool2)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo fail audioId:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(136902);
      return false;
    }
    o(10, paramString);
    long l = this.deO.gt(paramString);
    int i = this.deO.gu(paramString);
    boolean bool1;
    if (!gr(paramString))
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo cache is not exist");
      bool1 = true;
    }
    for (;;)
    {
      o(6, paramString);
      if ((bool1) && (bool2))
      {
        AppMethodBeat.o(136902);
        return true;
        if (go(paramString) <= 2000)
        {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo duration is not support seek");
          if (!this.deP.fR(paramString))
          {
            bool2 = this.deP.w(paramString, paramInt);
            bool1 = true;
          }
        }
        else
        {
          if (Math.abs(paramInt - l) <= 3000L)
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
          if (!this.deP.fR(paramString))
          {
            bool2 = this.deP.w(paramString, paramInt);
            bool1 = true;
            continue;
          }
          bool1 = this.deO.dfc.y(paramString, paramInt);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.audio.mix.f.c
 * JD-Core Version:    0.7.0.1
 */
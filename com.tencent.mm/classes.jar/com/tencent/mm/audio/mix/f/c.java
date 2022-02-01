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
  public d cWc;
  public com.tencent.mm.audio.mix.d.a cWd;
  public HashMap<String, Boolean> cWe;
  private com.tencent.mm.audio.mix.c.e cWf;
  public com.tencent.mm.audio.mix.b.a.d cWg;
  private volatile boolean cWh;
  
  public c()
  {
    AppMethodBeat.i(136888);
    this.cWe = new HashMap();
    this.cWh = false;
    this.cWc = new d();
    this.cWd = new com.tencent.mm.audio.mix.d.a(this.cWc);
    this.cWc.cWd = this.cWd;
    this.cWf = new com.tencent.mm.audio.mix.c.e();
    this.cWg = new com.tencent.mm.audio.mix.b.a.d();
    AppMethodBeat.o(136888);
  }
  
  private void d(com.tencent.mm.aj.b paramb)
  {
    AppMethodBeat.i(136897);
    paramb.cTo = true;
    int i = this.cWc.fD(paramb.cTr);
    int j = this.cWc.NT();
    if (!this.cWh)
    {
      if (i <= 2000) {
        paramb.cTo = false;
      }
      if ((i >= 5000) || (j > 5)) {
        break label184;
      }
    }
    label184:
    for (paramb.cTo = false;; paramb.cTo = true)
    {
      if (paramb.filePath.contains("scale_intro")) {
        paramb.cTo = false;
      }
      if (j <= 5) {
        break;
      }
      Object localObject = this.cWc.NU();
      if (((ArrayList)localObject).contains(paramb.cTr)) {
        ((ArrayList)localObject).remove(paramb.cTr);
      }
      if (((ArrayList)localObject).size() <= 2) {
        break;
      }
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "do stop paused audio size:%d", new Object[] { Integer.valueOf(((ArrayList)localObject).size()) });
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        fy((String)((Iterator)localObject).next());
      }
    }
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "playingCount:%d, duration:%d, supportMixPlay:%b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(paramb.cTo) });
    AppMethodBeat.o(136897);
  }
  
  private com.tencent.mm.aj.b ft(String paramString)
  {
    AppMethodBeat.i(136894);
    paramString = this.cWc.ft(paramString);
    AppMethodBeat.o(136894);
    return paramString;
  }
  
  public final void NI()
  {
    AppMethodBeat.i(136889);
    ??? = this.cWd;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "pauseAllOnBackground");
    Object localObject2 = ((com.tencent.mm.audio.mix.d.a)???).cUt.iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (String)((Iterator)localObject2).next();
      localObject4 = (com.tencent.mm.audio.mix.d.b)((com.tencent.mm.audio.mix.d.a)???).cUq.get(localObject4);
      if ((localObject4 != null) && (!((com.tencent.mm.audio.mix.d.b)localObject4).cUw) && (!((com.tencent.mm.audio.mix.d.b)localObject4).MW()))
      {
        localObject4 = ((com.tencent.mm.audio.mix.d.b)localObject4).cUx;
        if ((localObject4 != null) && (!((k)localObject4).Nb())) {
          ((k)localObject4).MY();
        }
      }
    }
    ??? = this.cWc;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "pauseAllOnBackground");
    ((d)???).cWq.Nt();
    ((d)???).NM();
    ??? = this.cWf;
    if (com.tencent.mm.audio.mix.c.e.cUl == 0L) {
      com.tencent.mm.audio.mix.c.e.cUl = 0L;
    }
    long l = System.currentTimeMillis();
    if (l - com.tencent.mm.audio.mix.c.e.cUl <= com.tencent.mm.audio.mix.c.e.cUi.longValue()) {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioScanConvertCacheController", "startClean the last clean time is in AUDIO_MIX_NO_SCAN_TIME time");
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.audio.mix.b.e.MN();
      synchronized (((com.tencent.mm.audio.mix.b.e)localObject2).cTF)
      {
        localObject4 = ((com.tencent.mm.audio.mix.b.e)localObject2).cTE.iterator();
        Object localObject5;
        do
        {
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localObject5 = (String)((Iterator)localObject4).next();
          localObject5 = (com.tencent.mm.audio.mix.a.d)((com.tencent.mm.audio.mix.b.e)localObject2).cache.get(localObject5);
        } while ((localObject5 == null) || (!((com.tencent.mm.audio.mix.a.d)localObject5).azh) || (!((com.tencent.mm.audio.mix.a.d)localObject5).cTp));
        ((com.tencent.mm.audio.mix.a.d)localObject5).MB();
      }
      com.tencent.mm.audio.mix.c.e.cUl = l;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioScanConvertCacheController", "start scan audio mix convert file");
      h.a(new e.a((com.tencent.mm.audio.mix.c.e)???, "clean audio mix convert cache"));
    }
    AppMethodBeat.o(136889);
  }
  
  public final boolean NJ()
  {
    AppMethodBeat.i(136909);
    boolean bool = this.cWc.cWl.get();
    AppMethodBeat.o(136909);
    return bool;
  }
  
  public final void NK()
  {
    AppMethodBeat.i(136913);
    String str = this.appId;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmDataTrackTaskController", "recycleAllCache appId:%s", new Object[] { str });
    com.tencent.mm.audio.mix.b.a.d.a(new com.tencent.mm.audio.mix.b.a.c(str), "AudioPcmDataTrackRecycleCacheTask");
    this.cWe.clear();
    AppMethodBeat.o(136913);
  }
  
  public final long NL()
  {
    return this.cWc.cWq.cVt;
  }
  
  public final void a(com.tencent.mm.aj.b paramb)
  {
    AppMethodBeat.i(136891);
    this.appId = paramb.appId;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "preparePlay:%s", new Object[] { paramb.cTr });
    if ((fH(paramb.filePath)) && (paramb.gSN)) {
      d(paramb);
    }
    Object localObject1 = this.cWc;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "preparePlay");
    if ((!paramb.gTd) && (paramb.gSN)) {
      if (((d)localObject1).cWj.get()) {
        ((d)localObject1).NN();
      }
    }
    for (;;)
    {
      ((d)localObject1).cUr.put(paramb.cTr, paramb);
      synchronized (((d)localObject1).cWo)
      {
        ((d)localObject1).cVq.put(paramb.cTr, Boolean.FALSE);
        ((d)localObject1).cWq.fj(paramb.cTr);
        ((d)localObject1).cWq.Ns();
        localObject1 = this.cWd;
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "prepareDecode");
        if (paramb == null)
        {
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "param is null");
          AppMethodBeat.o(136891);
          return;
          if (((d)localObject1).cWj.get()) {
            continue;
          }
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "initThread");
          ((d)localObject1).cWj.set(true);
          ((d)localObject1).cWl.set(false);
          ((d)localObject1).cWk.set(false);
          ((d)localObject1).NN();
          continue;
          if (!paramb.gTd) {
            continue;
          }
          synchronized (((d)localObject1).cWo)
          {
            if (((d)localObject1).cWw.containsKey(paramb.cTr))
            {
              e locale = (e)((d)localObject1).cWw.get(paramb.cTr);
              if (locale != null) {
                if (locale.g(new Integer[] { Integer.valueOf(4) })) {
                  ((d)localObject1).cWw.remove(paramb.cTr);
                }
              }
            }
          }
        }
      }
    }
    if (TextUtils.isEmpty(paramb.cTr))
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "audioId is empty!");
      AppMethodBeat.o(136891);
      return;
    }
    if (!((com.tencent.mm.audio.mix.d.a)localObject1).cUt.contains(paramb.cTr))
    {
      ((com.tencent.mm.audio.mix.d.a)localObject1).cUt.add(paramb.cTr);
      ((com.tencent.mm.audio.mix.d.a)localObject1).cUr.put(paramb.cTr, paramb);
      bool = false;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "ids:%d, id2ParamMap:%d", new Object[] { Integer.valueOf(((com.tencent.mm.audio.mix.d.a)localObject1).cUt.size()), Integer.valueOf(((com.tencent.mm.audio.mix.d.a)localObject1).cUr.size()) });
      if (!paramb.gTd) {
        break label595;
      }
      bool = ((com.tencent.mm.audio.mix.d.a)localObject1).a(paramb.cTr, bool, true);
      ??? = ((com.tencent.mm.audio.mix.d.a)localObject1).cTF;
      if (!bool) {}
    }
    try
    {
      if (!((com.tencent.mm.audio.mix.d.a)localObject1).cUs.contains(paramb.filePath)) {
        ((com.tencent.mm.audio.mix.d.a)localObject1).cUs.add(paramb.filePath);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(136891);
    }
    if (((com.tencent.mm.aj.b)((com.tencent.mm.audio.mix.d.a)localObject1).cUr.get(paramb.cTr)).e(paramb)) {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "is same param");
    }
    for (boolean bool = false;; bool = true)
    {
      ((com.tencent.mm.audio.mix.d.a)localObject1).cUr.put(paramb.cTr, paramb);
      break;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "force to decode");
    }
    label595:
    if (paramb.gSN)
    {
      ((com.tencent.mm.audio.mix.d.a)localObject1).a(paramb.cTr, bool, false);
      AppMethodBeat.o(136891);
      return;
    }
    bool = ((com.tencent.mm.audio.mix.d.a)localObject1).a(paramb.cTr, bool, true);
    ??? = ((com.tencent.mm.audio.mix.d.a)localObject1).cTF;
    if (bool) {}
    try
    {
      if (!((com.tencent.mm.audio.mix.d.a)localObject1).cUs.contains(paramb.filePath)) {
        ((com.tencent.mm.audio.mix.d.a)localObject1).cUs.add(paramb.filePath);
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
    this.cWc.cWr = paramb;
  }
  
  public final void a(g paramg)
  {
    this.cWc.cWt = paramg;
  }
  
  public final void b(com.tencent.mm.aj.b paramb)
  {
    AppMethodBeat.i(136892);
    this.cWc.cUr.put(paramb.cTr, paramb);
    this.cWd.cUr.put(paramb.cTr, paramb);
    AppMethodBeat.o(136892);
  }
  
  public final void c(com.tencent.mm.aj.b paramb)
  {
    AppMethodBeat.i(136893);
    Object localObject = this.cWc;
    if (((d)localObject).cUr.containsKey(paramb.cTr)) {
      ((d)localObject).cUr.put(paramb.cTr, paramb);
    }
    localObject = this.cWd;
    if (((com.tencent.mm.audio.mix.d.a)localObject).cUr.containsKey(paramb.cTr)) {
      ((com.tencent.mm.audio.mix.d.a)localObject).cUr.put(paramb.cTr, paramb);
    }
    AppMethodBeat.o(136893);
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(136890);
    this.cWd.clearCache();
    this.cWc.clearCache();
    AppMethodBeat.o(136890);
  }
  
  public final boolean fA(String paramString)
  {
    AppMethodBeat.i(136905);
    d locald = this.cWc;
    if (locald.cWw.containsKey(paramString))
    {
      paramString = (e)locald.cWw.get(paramString);
      if (paramString != null) {
        if (paramString.g(new Integer[] { Integer.valueOf(9) }))
        {
          AppMethodBeat.o(136905);
          return true;
        }
      }
    }
    AppMethodBeat.o(136905);
    return false;
  }
  
  public final boolean fB(String paramString)
  {
    AppMethodBeat.i(136906);
    d locald = this.cWc;
    if (locald.cWw.containsKey(paramString))
    {
      paramString = (e)locald.cWw.get(paramString);
      if (paramString != null) {
        if (paramString.g(new Integer[] { Integer.valueOf(7) }))
        {
          AppMethodBeat.o(136906);
          return true;
        }
      }
    }
    AppMethodBeat.o(136906);
    return false;
  }
  
  public final boolean fC(String paramString)
  {
    AppMethodBeat.i(136908);
    d locald = this.cWc;
    if (locald.cWw.containsKey(paramString))
    {
      paramString = (e)locald.cWw.get(paramString);
      if (paramString != null)
      {
        if (!paramString.g(new Integer[] { Integer.valueOf(3) })) {
          if (!paramString.g(new Integer[] { Integer.valueOf(4) })) {
            if (!paramString.g(new Integer[] { Integer.valueOf(5) })) {
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
  
  public final int fD(String paramString)
  {
    AppMethodBeat.i(136910);
    int i = this.cWc.fD(paramString);
    AppMethodBeat.o(136910);
    return i;
  }
  
  public final com.tencent.mm.aj.d fE(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(136911);
    d locald1 = this.cWc;
    com.tencent.mm.aj.d locald;
    int j;
    int k;
    boolean bool1;
    int i;
    if (locald1.cWx.containsKey(paramString))
    {
      locald = (com.tencent.mm.aj.d)locald1.cWx.get(paramString);
      j = locald1.fD(paramString);
      k = locald1.fI(paramString);
      bool1 = locald1.fh(paramString);
      if (!locald1.cUr.containsKey(paramString)) {
        break label300;
      }
      Object localObject = ((com.tencent.mm.aj.b)locald1.cUr.get(paramString)).filePath;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label300;
      }
      localObject = com.tencent.mm.audio.mix.b.e.MN().eY((String)localObject);
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
      locald.dbJ = k;
      locald.duration = j;
      if (bool1)
      {
        bool1 = false;
        locald.qM = bool1;
        if ((!locald1.cWu.containsKey(paramString)) || (!((Boolean)locald1.cWu.get(paramString)).booleanValue())) {
          break label311;
        }
      }
      for (bool1 = bool2;; bool1 = false)
      {
        locald.gTe = bool1;
        locald.gTf = (i * j / 100);
        if (!locald1.cUr.containsKey(paramString)) {
          break label317;
        }
        paramString = (com.tencent.mm.aj.b)locald1.cUr.get(paramString);
        locald.cUL = paramString.gSM;
        locald.cTn = paramString.cUD;
        locald.gSZ = paramString.gSZ;
        AppMethodBeat.o(136911);
        return locald;
        locald = new com.tencent.mm.aj.d();
        locald1.cWx.put(paramString, locald);
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
  
  public final void fF(String paramString)
  {
    AppMethodBeat.i(136914);
    String str = this.appId;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmDataTrackTaskController", "cacheToFile appId:%s, filePath:%s", new Object[] { str, paramString });
    com.tencent.mm.audio.mix.b.a.d.a(new com.tencent.mm.audio.mix.b.a.a(str, paramString), "AudioPcmDataTrackCacheToFileTask");
    AppMethodBeat.o(136914);
  }
  
  public final boolean fG(String paramString)
  {
    AppMethodBeat.i(136915);
    paramString = ft(paramString);
    if (paramString != null)
    {
      if (this.cWe.containsKey(paramString.filePath))
      {
        bool = ((Boolean)this.cWe.get(paramString.filePath)).booleanValue();
        AppMethodBeat.o(136915);
        return bool;
      }
      boolean bool = com.tencent.mm.audio.mix.b.e.MN().fa(paramString.filePath);
      if (bool) {
        this.cWe.put(paramString.filePath, Boolean.valueOf(bool));
      }
      AppMethodBeat.o(136915);
      return bool;
    }
    AppMethodBeat.o(136915);
    return false;
  }
  
  public final boolean fH(String paramString)
  {
    AppMethodBeat.i(136916);
    if (this.cWe.containsKey(paramString))
    {
      bool = ((Boolean)this.cWe.get(paramString)).booleanValue();
      AppMethodBeat.o(136916);
      return bool;
    }
    boolean bool = com.tencent.mm.audio.mix.b.e.MN().fa(paramString);
    if (bool) {
      this.cWe.put(paramString, Boolean.valueOf(bool));
    }
    AppMethodBeat.o(136916);
    return bool;
  }
  
  public final boolean fh(String paramString)
  {
    AppMethodBeat.i(136903);
    boolean bool = this.cWc.fh(paramString);
    AppMethodBeat.o(136903);
    return bool;
  }
  
  public final boolean fu(String paramString)
  {
    AppMethodBeat.i(136895);
    if (this.cWc.cUr.containsKey(paramString))
    {
      AppMethodBeat.o(136895);
      return true;
    }
    AppMethodBeat.o(136895);
    return false;
  }
  
  public final void fv(String paramString)
  {
    AppMethodBeat.i(136896);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "play audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.cWc.fJ(paramString)) });
    d(this.cWc.ft(paramString));
    d locald = this.cWc;
    locald.cWl.set(false);
    locald.cWk.set(false);
    locald.NR();
    locald.NN();
    synchronized (locald.cWo)
    {
      locald.cVq.put(paramString, Boolean.FALSE);
      locald.cWq.fj(paramString);
      locald.cWu.remove(paramString);
      locald.cWv.put(paramString, Boolean.TRUE);
      if ((locald.cWd.fg(paramString)) && (locald.cWd.fh(paramString))) {
        locald.o(0, paramString);
      }
      this.cWd.fe(paramString);
      AppMethodBeat.o(136896);
      return;
    }
  }
  
  public final void fw(String paramString)
  {
    AppMethodBeat.i(136898);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "resume audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.cWc.fJ(paramString)) });
    d(this.cWc.ft(paramString));
    d locald = this.cWc;
    locald.cWl.set(false);
    locald.cWk.set(false);
    locald.NR();
    locald.NN();
    synchronized (locald.cWo)
    {
      locald.cVq.put(paramString, Boolean.FALSE);
      locald.cWq.fj(paramString);
      locald.cWu.remove(paramString);
      locald.cWv.put(paramString, Boolean.TRUE);
      if ((locald.cWd.fg(paramString)) && (locald.cWd.fh(paramString))) {
        locald.o(1, paramString);
      }
      this.cWd.fe(paramString);
      AppMethodBeat.o(136898);
      return;
    }
  }
  
  public final void fx(String paramString)
  {
    AppMethodBeat.i(136899);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "pause audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.cWc.fJ(paramString)) });
    Object localObject = this.cWc;
    ((d)localObject).cWq.fk(paramString);
    if ((((d)localObject).cWd.fg(paramString)) && (((d)localObject).cWd.fh(paramString))) {
      ((d)localObject).o(2, paramString);
    }
    localObject = this.cWd;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "pauseDecode audioId:%s", new Object[] { paramString });
    paramString = (com.tencent.mm.audio.mix.d.b)((com.tencent.mm.audio.mix.d.a)localObject).cUq.get(paramString);
    if (paramString == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
      AppMethodBeat.o(136899);
      return;
    }
    if (paramString.cUw)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
      AppMethodBeat.o(136899);
      return;
    }
    if (paramString.MW())
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is isDetach!");
      AppMethodBeat.o(136899);
      return;
    }
    paramString = paramString.cUx;
    if (paramString != null) {
      paramString.pause();
    }
    AppMethodBeat.o(136899);
  }
  
  public final void fy(String paramString)
  {
    AppMethodBeat.i(136900);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "stop audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.cWc.fJ(paramString)) });
    this.cWc.fy(paramString);
    this.cWd.ff(paramString);
    AppMethodBeat.o(136900);
  }
  
  public final boolean fz(String paramString)
  {
    AppMethodBeat.i(136904);
    d locald = this.cWc;
    if (locald.cWv.containsKey(paramString))
    {
      boolean bool = ((Boolean)locald.cWv.get(paramString)).booleanValue();
      AppMethodBeat.o(136904);
      return bool;
    }
    AppMethodBeat.o(136904);
    return false;
  }
  
  public final boolean isPaused(String paramString)
  {
    AppMethodBeat.i(136907);
    d locald = this.cWc;
    if (locald.cWw.containsKey(paramString))
    {
      paramString = (e)locald.cWw.get(paramString);
      if (paramString != null) {
        if (paramString.g(new Integer[] { Integer.valueOf(2) }))
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
    this.cWc.o(paramInt, paramString);
    AppMethodBeat.o(136912);
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(136901);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "remove audioId:%s", new Object[] { paramString });
    d locald = this.cWc;
    locald.cUr.remove(paramString);
    locald.cWu.remove(paramString);
    locald.cWv.remove(paramString);
    synchronized (locald.cWo)
    {
      locald.cWw.remove(paramString);
      locald.cVq.remove(paramString);
      locald.cWx.remove(paramString);
      ??? = this.cWd;
      if ((((com.tencent.mm.audio.mix.d.a)???).cUq.containsKey(paramString)) && (((com.tencent.mm.audio.mix.d.a)???).cUt.contains(paramString))) {
        ((com.tencent.mm.audio.mix.d.a)???).ff(paramString);
      }
      ((com.tencent.mm.audio.mix.d.a)???).cUr.remove(paramString);
      ((com.tencent.mm.audio.mix.d.a)???).cUt.remove(paramString);
      AppMethodBeat.o(136901);
      return;
    }
  }
  
  public final boolean w(String paramString, int paramInt)
  {
    AppMethodBeat.i(136902);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo audioId:%s, position:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    boolean bool2 = this.cWd.v(paramString, paramInt);
    if (!bool2)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo fail audioId:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(136902);
      return false;
    }
    o(10, paramString);
    long l = this.cWc.fI(paramString);
    int i = this.cWc.fJ(paramString);
    boolean bool1;
    if (!fG(paramString))
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
        if (fD(paramString) <= 2000)
        {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo duration is not support seek");
          if (!this.cWd.fg(paramString))
          {
            bool2 = this.cWd.u(paramString, paramInt);
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
          if (!this.cWd.fg(paramString))
          {
            bool2 = this.cWd.u(paramString, paramInt);
            bool1 = true;
            continue;
          }
          bool1 = this.cWc.cWq.w(paramString, paramInt);
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
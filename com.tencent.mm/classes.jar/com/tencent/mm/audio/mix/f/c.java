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
  public HashMap<String, Boolean> cTA;
  private com.tencent.mm.audio.mix.c.e cTB;
  public com.tencent.mm.audio.mix.b.a.d cTC;
  private volatile boolean cTD;
  public d cTy;
  public com.tencent.mm.audio.mix.d.a cTz;
  
  public c()
  {
    AppMethodBeat.i(136888);
    this.cTA = new HashMap();
    this.cTD = false;
    this.cTy = new d();
    this.cTz = new com.tencent.mm.audio.mix.d.a(this.cTy);
    this.cTy.cTz = this.cTz;
    this.cTB = new com.tencent.mm.audio.mix.c.e();
    this.cTC = new com.tencent.mm.audio.mix.b.a.d();
    AppMethodBeat.o(136888);
  }
  
  private void d(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(136897);
    paramb.cQL = true;
    int i = this.cTy.ft(paramb.cQO);
    int j = this.cTy.NQ();
    if (!this.cTD)
    {
      if (i <= 2000) {
        paramb.cQL = false;
      }
      if ((i >= 5000) || (j > 5)) {
        break label184;
      }
    }
    label184:
    for (paramb.cQL = false;; paramb.cQL = true)
    {
      if (paramb.filePath.contains("scale_intro")) {
        paramb.cQL = false;
      }
      if (j <= 5) {
        break;
      }
      Object localObject = this.cTy.NR();
      if (((ArrayList)localObject).contains(paramb.cQO)) {
        ((ArrayList)localObject).remove(paramb.cQO);
      }
      if (((ArrayList)localObject).size() <= 2) {
        break;
      }
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "do stop paused audio size:%d", new Object[] { Integer.valueOf(((ArrayList)localObject).size()) });
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        fo((String)((Iterator)localObject).next());
      }
    }
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "playingCount:%d, duration:%d, supportMixPlay:%b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(paramb.cQL) });
    AppMethodBeat.o(136897);
  }
  
  private com.tencent.mm.ai.b fj(String paramString)
  {
    AppMethodBeat.i(136894);
    paramString = this.cTy.fj(paramString);
    AppMethodBeat.o(136894);
    return paramString;
  }
  
  public final void NG()
  {
    AppMethodBeat.i(136889);
    ??? = this.cTz;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "pauseAllOnBackground");
    Object localObject2 = ((com.tencent.mm.audio.mix.d.a)???).cRQ.iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (String)((Iterator)localObject2).next();
      localObject4 = (com.tencent.mm.audio.mix.d.b)((com.tencent.mm.audio.mix.d.a)???).cRN.get(localObject4);
      if ((localObject4 != null) && (!((com.tencent.mm.audio.mix.d.b)localObject4).cRT) && (!((com.tencent.mm.audio.mix.d.b)localObject4).MU()))
      {
        localObject4 = ((com.tencent.mm.audio.mix.d.b)localObject4).cRU;
        if ((localObject4 != null) && (!((k)localObject4).MZ())) {
          ((k)localObject4).MW();
        }
      }
    }
    ??? = this.cTy;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "pauseAllOnBackground");
    ((d)???).cTM.Nr();
    ((d)???).NK();
    ??? = this.cTB;
    if (com.tencent.mm.audio.mix.c.e.cRI == 0L) {
      com.tencent.mm.audio.mix.c.e.cRI = 0L;
    }
    long l = System.currentTimeMillis();
    if (l - com.tencent.mm.audio.mix.c.e.cRI <= com.tencent.mm.audio.mix.c.e.cRF.longValue()) {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioScanConvertCacheController", "startClean the last clean time is in AUDIO_MIX_NO_SCAN_TIME time");
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.audio.mix.b.e.ML();
      synchronized (((com.tencent.mm.audio.mix.b.e)localObject2).cRc)
      {
        localObject4 = ((com.tencent.mm.audio.mix.b.e)localObject2).cRb.iterator();
        Object localObject5;
        do
        {
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localObject5 = (String)((Iterator)localObject4).next();
          localObject5 = (com.tencent.mm.audio.mix.a.d)((com.tencent.mm.audio.mix.b.e)localObject2).cache.get(localObject5);
        } while ((localObject5 == null) || (!((com.tencent.mm.audio.mix.a.d)localObject5).aAb) || (!((com.tencent.mm.audio.mix.a.d)localObject5).cQM));
        ((com.tencent.mm.audio.mix.a.d)localObject5).Mz();
      }
      com.tencent.mm.audio.mix.c.e.cRI = l;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioScanConvertCacheController", "start scan audio mix convert file");
      h.a(new e.a((com.tencent.mm.audio.mix.c.e)???, "clean audio mix convert cache"));
    }
    AppMethodBeat.o(136889);
  }
  
  public final boolean NH()
  {
    AppMethodBeat.i(136909);
    boolean bool = this.cTy.cTH.get();
    AppMethodBeat.o(136909);
    return bool;
  }
  
  public final void NI()
  {
    AppMethodBeat.i(136913);
    String str = this.appId;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmDataTrackTaskController", "recycleAllCache appId:%s", new Object[] { str });
    com.tencent.mm.audio.mix.b.a.d.a(new com.tencent.mm.audio.mix.b.a.c(str), "AudioPcmDataTrackRecycleCacheTask");
    this.cTA.clear();
    AppMethodBeat.o(136913);
  }
  
  public final long NJ()
  {
    return this.cTy.cTM.cSP;
  }
  
  public final void a(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(136891);
    this.appId = paramb.appId;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "preparePlay:%s", new Object[] { paramb.cQO });
    if ((fx(paramb.filePath)) && (paramb.htn)) {
      d(paramb);
    }
    Object localObject1 = this.cTy;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "preparePlay");
    if ((!paramb.htC) && (paramb.htn)) {
      if (((d)localObject1).cTF.get()) {
        ((d)localObject1).NL();
      }
    }
    for (;;)
    {
      ((d)localObject1).cRO.put(paramb.cQO, paramb);
      synchronized (((d)localObject1).cTK)
      {
        ((d)localObject1).cSM.put(paramb.cQO, Boolean.FALSE);
        ((d)localObject1).cTM.eZ(paramb.cQO);
        ((d)localObject1).cTM.Nq();
        localObject1 = this.cTz;
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "prepareDecode");
        if (paramb == null)
        {
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "param is null");
          AppMethodBeat.o(136891);
          return;
          if (((d)localObject1).cTF.get()) {
            continue;
          }
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "initThread");
          ((d)localObject1).cTF.set(true);
          ((d)localObject1).cTH.set(false);
          ((d)localObject1).cTG.set(false);
          ((d)localObject1).NL();
          continue;
          if (!paramb.htC) {
            continue;
          }
          synchronized (((d)localObject1).cTK)
          {
            if (((d)localObject1).cTS.containsKey(paramb.cQO))
            {
              e locale = (e)((d)localObject1).cTS.get(paramb.cQO);
              if (locale != null) {
                if (locale.h(new Integer[] { Integer.valueOf(4) })) {
                  ((d)localObject1).cTS.remove(paramb.cQO);
                }
              }
            }
          }
        }
      }
    }
    if (TextUtils.isEmpty(paramb.cQO))
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "audioId is empty!");
      AppMethodBeat.o(136891);
      return;
    }
    if (!((com.tencent.mm.audio.mix.d.a)localObject1).cRQ.contains(paramb.cQO))
    {
      ((com.tencent.mm.audio.mix.d.a)localObject1).cRQ.add(paramb.cQO);
      ((com.tencent.mm.audio.mix.d.a)localObject1).cRO.put(paramb.cQO, paramb);
      bool = false;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "ids:%d, id2ParamMap:%d", new Object[] { Integer.valueOf(((com.tencent.mm.audio.mix.d.a)localObject1).cRQ.size()), Integer.valueOf(((com.tencent.mm.audio.mix.d.a)localObject1).cRO.size()) });
      if (!paramb.htC) {
        break label595;
      }
      bool = ((com.tencent.mm.audio.mix.d.a)localObject1).a(paramb.cQO, bool, true);
      ??? = ((com.tencent.mm.audio.mix.d.a)localObject1).cRc;
      if (!bool) {}
    }
    try
    {
      if (!((com.tencent.mm.audio.mix.d.a)localObject1).cRP.contains(paramb.filePath)) {
        ((com.tencent.mm.audio.mix.d.a)localObject1).cRP.add(paramb.filePath);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(136891);
    }
    if (((com.tencent.mm.ai.b)((com.tencent.mm.audio.mix.d.a)localObject1).cRO.get(paramb.cQO)).e(paramb)) {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "is same param");
    }
    for (boolean bool = false;; bool = true)
    {
      ((com.tencent.mm.audio.mix.d.a)localObject1).cRO.put(paramb.cQO, paramb);
      break;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "force to decode");
    }
    label595:
    if (paramb.htn)
    {
      ((com.tencent.mm.audio.mix.d.a)localObject1).a(paramb.cQO, bool, false);
      AppMethodBeat.o(136891);
      return;
    }
    bool = ((com.tencent.mm.audio.mix.d.a)localObject1).a(paramb.cQO, bool, true);
    ??? = ((com.tencent.mm.audio.mix.d.a)localObject1).cRc;
    if (bool) {}
    try
    {
      if (!((com.tencent.mm.audio.mix.d.a)localObject1).cRP.contains(paramb.filePath)) {
        ((com.tencent.mm.audio.mix.d.a)localObject1).cRP.add(paramb.filePath);
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
    this.cTy.cTN = paramb;
  }
  
  public final void a(g paramg)
  {
    this.cTy.cTP = paramg;
  }
  
  public final void b(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(136892);
    this.cTy.cRO.put(paramb.cQO, paramb);
    this.cTz.cRO.put(paramb.cQO, paramb);
    AppMethodBeat.o(136892);
  }
  
  public final void c(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(136893);
    Object localObject = this.cTy;
    if (((d)localObject).cRO.containsKey(paramb.cQO)) {
      ((d)localObject).cRO.put(paramb.cQO, paramb);
    }
    localObject = this.cTz;
    if (((com.tencent.mm.audio.mix.d.a)localObject).cRO.containsKey(paramb.cQO)) {
      ((com.tencent.mm.audio.mix.d.a)localObject).cRO.put(paramb.cQO, paramb);
    }
    AppMethodBeat.o(136893);
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(136890);
    this.cTz.clearCache();
    this.cTy.clearCache();
    AppMethodBeat.o(136890);
  }
  
  public final boolean eX(String paramString)
  {
    AppMethodBeat.i(136903);
    boolean bool = this.cTy.eX(paramString);
    AppMethodBeat.o(136903);
    return bool;
  }
  
  public final boolean fk(String paramString)
  {
    AppMethodBeat.i(136895);
    if (this.cTy.cRO.containsKey(paramString))
    {
      AppMethodBeat.o(136895);
      return true;
    }
    AppMethodBeat.o(136895);
    return false;
  }
  
  public final void fl(String paramString)
  {
    AppMethodBeat.i(136896);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "play audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.cTy.fz(paramString)) });
    d(this.cTy.fj(paramString));
    d locald = this.cTy;
    locald.cTH.set(false);
    locald.cTG.set(false);
    locald.NP();
    locald.NL();
    synchronized (locald.cTK)
    {
      locald.cSM.put(paramString, Boolean.FALSE);
      locald.cTM.eZ(paramString);
      locald.cTQ.remove(paramString);
      locald.cTR.put(paramString, Boolean.TRUE);
      if ((locald.cTz.eW(paramString)) && (locald.cTz.eX(paramString))) {
        locald.o(0, paramString);
      }
      this.cTz.eU(paramString);
      AppMethodBeat.o(136896);
      return;
    }
  }
  
  public final void fm(String paramString)
  {
    AppMethodBeat.i(136898);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "resume audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.cTy.fz(paramString)) });
    d(this.cTy.fj(paramString));
    d locald = this.cTy;
    locald.cTH.set(false);
    locald.cTG.set(false);
    locald.NP();
    locald.NL();
    synchronized (locald.cTK)
    {
      locald.cSM.put(paramString, Boolean.FALSE);
      locald.cTM.eZ(paramString);
      locald.cTQ.remove(paramString);
      locald.cTR.put(paramString, Boolean.TRUE);
      if ((locald.cTz.eW(paramString)) && (locald.cTz.eX(paramString))) {
        locald.o(1, paramString);
      }
      this.cTz.eU(paramString);
      AppMethodBeat.o(136898);
      return;
    }
  }
  
  public final void fn(String paramString)
  {
    AppMethodBeat.i(136899);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "pause audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.cTy.fz(paramString)) });
    Object localObject = this.cTy;
    ((d)localObject).cTM.fa(paramString);
    if ((((d)localObject).cTz.eW(paramString)) && (((d)localObject).cTz.eX(paramString))) {
      ((d)localObject).o(2, paramString);
    }
    localObject = this.cTz;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "pauseDecode audioId:%s", new Object[] { paramString });
    paramString = (com.tencent.mm.audio.mix.d.b)((com.tencent.mm.audio.mix.d.a)localObject).cRN.get(paramString);
    if (paramString == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
      AppMethodBeat.o(136899);
      return;
    }
    if (paramString.cRT)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
      AppMethodBeat.o(136899);
      return;
    }
    if (paramString.MU())
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is isDetach!");
      AppMethodBeat.o(136899);
      return;
    }
    paramString = paramString.cRU;
    if (paramString != null) {
      paramString.pause();
    }
    AppMethodBeat.o(136899);
  }
  
  public final void fo(String paramString)
  {
    AppMethodBeat.i(136900);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "stop audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.cTy.fz(paramString)) });
    this.cTy.fo(paramString);
    this.cTz.eV(paramString);
    AppMethodBeat.o(136900);
  }
  
  public final boolean fp(String paramString)
  {
    AppMethodBeat.i(136904);
    d locald = this.cTy;
    if (locald.cTR.containsKey(paramString))
    {
      boolean bool = ((Boolean)locald.cTR.get(paramString)).booleanValue();
      AppMethodBeat.o(136904);
      return bool;
    }
    AppMethodBeat.o(136904);
    return false;
  }
  
  public final boolean fq(String paramString)
  {
    AppMethodBeat.i(136905);
    d locald = this.cTy;
    if (locald.cTS.containsKey(paramString))
    {
      paramString = (e)locald.cTS.get(paramString);
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
  
  public final boolean fr(String paramString)
  {
    AppMethodBeat.i(136906);
    d locald = this.cTy;
    if (locald.cTS.containsKey(paramString))
    {
      paramString = (e)locald.cTS.get(paramString);
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
  
  public final boolean fs(String paramString)
  {
    AppMethodBeat.i(136908);
    d locald = this.cTy;
    if (locald.cTS.containsKey(paramString))
    {
      paramString = (e)locald.cTS.get(paramString);
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
  
  public final int ft(String paramString)
  {
    AppMethodBeat.i(136910);
    int i = this.cTy.ft(paramString);
    AppMethodBeat.o(136910);
    return i;
  }
  
  public final com.tencent.mm.ai.d fu(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(136911);
    d locald1 = this.cTy;
    com.tencent.mm.ai.d locald;
    int j;
    int k;
    boolean bool1;
    int i;
    if (locald1.cTT.containsKey(paramString))
    {
      locald = (com.tencent.mm.ai.d)locald1.cTT.get(paramString);
      j = locald1.ft(paramString);
      k = locald1.fy(paramString);
      bool1 = locald1.eX(paramString);
      if (!locald1.cRO.containsKey(paramString)) {
        break label300;
      }
      Object localObject = ((com.tencent.mm.ai.b)locald1.cRO.get(paramString)).filePath;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label300;
      }
      localObject = com.tencent.mm.audio.mix.b.e.ML().eO((String)localObject);
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
      locald.cZi = k;
      locald.duration = j;
      if (bool1)
      {
        bool1 = false;
        locald.rM = bool1;
        if ((!locald1.cTQ.containsKey(paramString)) || (!((Boolean)locald1.cTQ.get(paramString)).booleanValue())) {
          break label311;
        }
      }
      for (bool1 = bool2;; bool1 = false)
      {
        locald.htD = bool1;
        locald.htE = (i * j / 100);
        if (!locald1.cRO.containsKey(paramString)) {
          break label317;
        }
        paramString = (com.tencent.mm.ai.b)locald1.cRO.get(paramString);
        locald.cSh = paramString.htm;
        locald.cQK = paramString.cRZ;
        locald.hty = paramString.hty;
        AppMethodBeat.o(136911);
        return locald;
        locald = new com.tencent.mm.ai.d();
        locald1.cTT.put(paramString, locald);
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
  
  public final void fv(String paramString)
  {
    AppMethodBeat.i(136914);
    String str = this.appId;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmDataTrackTaskController", "cacheToFile appId:%s, filePath:%s", new Object[] { str, paramString });
    com.tencent.mm.audio.mix.b.a.d.a(new com.tencent.mm.audio.mix.b.a.a(str, paramString), "AudioPcmDataTrackCacheToFileTask");
    AppMethodBeat.o(136914);
  }
  
  public final boolean fw(String paramString)
  {
    AppMethodBeat.i(136915);
    paramString = fj(paramString);
    if (paramString != null)
    {
      if (this.cTA.containsKey(paramString.filePath))
      {
        bool = ((Boolean)this.cTA.get(paramString.filePath)).booleanValue();
        AppMethodBeat.o(136915);
        return bool;
      }
      boolean bool = com.tencent.mm.audio.mix.b.e.ML().eQ(paramString.filePath);
      if (bool) {
        this.cTA.put(paramString.filePath, Boolean.valueOf(bool));
      }
      AppMethodBeat.o(136915);
      return bool;
    }
    AppMethodBeat.o(136915);
    return false;
  }
  
  public final boolean fx(String paramString)
  {
    AppMethodBeat.i(136916);
    if (this.cTA.containsKey(paramString))
    {
      bool = ((Boolean)this.cTA.get(paramString)).booleanValue();
      AppMethodBeat.o(136916);
      return bool;
    }
    boolean bool = com.tencent.mm.audio.mix.b.e.ML().eQ(paramString);
    if (bool) {
      this.cTA.put(paramString, Boolean.valueOf(bool));
    }
    AppMethodBeat.o(136916);
    return bool;
  }
  
  public final boolean isPaused(String paramString)
  {
    AppMethodBeat.i(136907);
    d locald = this.cTy;
    if (locald.cTS.containsKey(paramString))
    {
      paramString = (e)locald.cTS.get(paramString);
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
    this.cTy.o(paramInt, paramString);
    AppMethodBeat.o(136912);
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(136901);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "remove audioId:%s", new Object[] { paramString });
    d locald = this.cTy;
    locald.cRO.remove(paramString);
    locald.cTQ.remove(paramString);
    locald.cTR.remove(paramString);
    synchronized (locald.cTK)
    {
      locald.cTS.remove(paramString);
      locald.cSM.remove(paramString);
      locald.cTT.remove(paramString);
      ??? = this.cTz;
      if ((((com.tencent.mm.audio.mix.d.a)???).cRN.containsKey(paramString)) && (((com.tencent.mm.audio.mix.d.a)???).cRQ.contains(paramString))) {
        ((com.tencent.mm.audio.mix.d.a)???).eV(paramString);
      }
      ((com.tencent.mm.audio.mix.d.a)???).cRO.remove(paramString);
      ((com.tencent.mm.audio.mix.d.a)???).cRQ.remove(paramString);
      AppMethodBeat.o(136901);
      return;
    }
  }
  
  public final boolean w(String paramString, int paramInt)
  {
    AppMethodBeat.i(136902);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo audioId:%s, position:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    boolean bool2 = this.cTz.v(paramString, paramInt);
    if (!bool2)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo fail audioId:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(136902);
      return false;
    }
    o(10, paramString);
    long l = this.cTy.fy(paramString);
    int i = this.cTy.fz(paramString);
    boolean bool1;
    if (!fw(paramString))
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
        if (ft(paramString) <= 2000)
        {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo duration is not support seek");
          if (!this.cTz.eW(paramString))
          {
            bool2 = this.cTz.u(paramString, paramInt);
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
          if (!this.cTz.eW(paramString))
          {
            bool2 = this.cTz.u(paramString, paramInt);
            bool1 = true;
            continue;
          }
          bool1 = this.cTy.cTM.w(paramString, paramInt);
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
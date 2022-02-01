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
  public d dfQ;
  public com.tencent.mm.audio.mix.d.a dfR;
  public HashMap<String, Boolean> dfS;
  private com.tencent.mm.audio.mix.c.e dfT;
  public com.tencent.mm.audio.mix.b.a.d dfU;
  private volatile boolean dfV;
  
  public c()
  {
    AppMethodBeat.i(136888);
    this.dfS = new HashMap();
    this.dfV = false;
    this.dfQ = new d();
    this.dfR = new com.tencent.mm.audio.mix.d.a(this.dfQ);
    this.dfQ.dfR = this.dfR;
    this.dfT = new com.tencent.mm.audio.mix.c.e();
    this.dfU = new com.tencent.mm.audio.mix.b.a.d();
    AppMethodBeat.o(136888);
  }
  
  private void d(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(136897);
    paramb.ddd = true;
    int i = this.dfQ.gu(paramb.ddg);
    int j = this.dfQ.Px();
    if (!this.dfV)
    {
      if (i <= 2000) {
        paramb.ddd = false;
      }
      if ((i >= 5000) || (j > 5)) {
        break label184;
      }
    }
    label184:
    for (paramb.ddd = false;; paramb.ddd = true)
    {
      if (paramb.filePath.contains("scale_intro")) {
        paramb.ddd = false;
      }
      if (j <= 5) {
        break;
      }
      Object localObject = this.dfQ.Py();
      if (((ArrayList)localObject).contains(paramb.ddg)) {
        ((ArrayList)localObject).remove(paramb.ddg);
      }
      if (((ArrayList)localObject).size() <= 2) {
        break;
      }
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "do stop paused audio size:%d", new Object[] { Integer.valueOf(((ArrayList)localObject).size()) });
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        gp((String)((Iterator)localObject).next());
      }
    }
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "playingCount:%d, duration:%d, supportMixPlay:%b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(paramb.ddd) });
    AppMethodBeat.o(136897);
  }
  
  private com.tencent.mm.ai.b gk(String paramString)
  {
    AppMethodBeat.i(136894);
    paramString = this.dfQ.gk(paramString);
    AppMethodBeat.o(136894);
    return paramString;
  }
  
  public final void Pn()
  {
    AppMethodBeat.i(136889);
    ??? = this.dfR;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "pauseAllOnBackground");
    Object localObject2 = ((com.tencent.mm.audio.mix.d.a)???).dei.iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (String)((Iterator)localObject2).next();
      localObject4 = (com.tencent.mm.audio.mix.d.b)((com.tencent.mm.audio.mix.d.a)???).def.get(localObject4);
      if ((localObject4 != null) && (!((com.tencent.mm.audio.mix.d.b)localObject4).del) && (!((com.tencent.mm.audio.mix.d.b)localObject4).OB()))
      {
        localObject4 = ((com.tencent.mm.audio.mix.d.b)localObject4).dem;
        if ((localObject4 != null) && (!((k)localObject4).OG())) {
          ((k)localObject4).OD();
        }
      }
    }
    ??? = this.dfQ;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "pauseAllOnBackground");
    ((d)???).dge.OY();
    ((d)???).Pr();
    ??? = this.dfT;
    if (com.tencent.mm.audio.mix.c.e.dea == 0L) {
      com.tencent.mm.audio.mix.c.e.dea = 0L;
    }
    long l = System.currentTimeMillis();
    if (l - com.tencent.mm.audio.mix.c.e.dea <= com.tencent.mm.audio.mix.c.e.ddX.longValue()) {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioScanConvertCacheController", "startClean the last clean time is in AUDIO_MIX_NO_SCAN_TIME time");
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.audio.mix.b.e.Os();
      synchronized (((com.tencent.mm.audio.mix.b.e)localObject2).ddu)
      {
        localObject4 = ((com.tencent.mm.audio.mix.b.e)localObject2).ddt.iterator();
        Object localObject5;
        do
        {
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localObject5 = (String)((Iterator)localObject4).next();
          localObject5 = (com.tencent.mm.audio.mix.a.d)((com.tencent.mm.audio.mix.b.e)localObject2).cache.get(localObject5);
        } while ((localObject5 == null) || (!((com.tencent.mm.audio.mix.a.d)localObject5).aBS) || (!((com.tencent.mm.audio.mix.a.d)localObject5).dde));
        ((com.tencent.mm.audio.mix.a.d)localObject5).Og();
      }
      com.tencent.mm.audio.mix.c.e.dea = l;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioScanConvertCacheController", "start scan audio mix convert file");
      h.a(new e.a((com.tencent.mm.audio.mix.c.e)???, "clean audio mix convert cache"));
    }
    AppMethodBeat.o(136889);
  }
  
  public final boolean Po()
  {
    AppMethodBeat.i(136909);
    boolean bool = this.dfQ.dfZ.get();
    AppMethodBeat.o(136909);
    return bool;
  }
  
  public final void Pp()
  {
    AppMethodBeat.i(136913);
    String str = this.appId;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmDataTrackTaskController", "recycleAllCache appId:%s", new Object[] { str });
    com.tencent.mm.audio.mix.b.a.d.a(new com.tencent.mm.audio.mix.b.a.c(str), "AudioPcmDataTrackRecycleCacheTask");
    this.dfS.clear();
    AppMethodBeat.o(136913);
  }
  
  public final long Pq()
  {
    return this.dfQ.dge.dfh;
  }
  
  public final void a(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(136891);
    this.appId = paramb.appId;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "preparePlay:%s", new Object[] { paramb.ddg });
    if ((gy(paramb.filePath)) && (paramb.hOy)) {
      d(paramb);
    }
    Object localObject1 = this.dfQ;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "preparePlay");
    if ((!paramb.hON) && (paramb.hOy)) {
      if (((d)localObject1).dfX.get()) {
        ((d)localObject1).Ps();
      }
    }
    for (;;)
    {
      ((d)localObject1).deg.put(paramb.ddg, paramb);
      synchronized (((d)localObject1).dgc)
      {
        ((d)localObject1).dfe.put(paramb.ddg, Boolean.FALSE);
        ((d)localObject1).dge.ga(paramb.ddg);
        ((d)localObject1).dge.OX();
        localObject1 = this.dfR;
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "prepareDecode");
        if (paramb == null)
        {
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "param is null");
          AppMethodBeat.o(136891);
          return;
          if (((d)localObject1).dfX.get()) {
            continue;
          }
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "initThread");
          ((d)localObject1).dfX.set(true);
          ((d)localObject1).dfZ.set(false);
          ((d)localObject1).dfY.set(false);
          ((d)localObject1).Ps();
          continue;
          if (!paramb.hON) {
            continue;
          }
          synchronized (((d)localObject1).dgc)
          {
            if (((d)localObject1).dgk.containsKey(paramb.ddg))
            {
              e locale = (e)((d)localObject1).dgk.get(paramb.ddg);
              if (locale != null) {
                if (locale.g(new Integer[] { Integer.valueOf(4) })) {
                  ((d)localObject1).dgk.remove(paramb.ddg);
                }
              }
            }
          }
        }
      }
    }
    if (TextUtils.isEmpty(paramb.ddg))
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "audioId is empty!");
      AppMethodBeat.o(136891);
      return;
    }
    if (!((com.tencent.mm.audio.mix.d.a)localObject1).dei.contains(paramb.ddg))
    {
      ((com.tencent.mm.audio.mix.d.a)localObject1).dei.add(paramb.ddg);
      ((com.tencent.mm.audio.mix.d.a)localObject1).deg.put(paramb.ddg, paramb);
      bool = false;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "ids:%d, id2ParamMap:%d", new Object[] { Integer.valueOf(((com.tencent.mm.audio.mix.d.a)localObject1).dei.size()), Integer.valueOf(((com.tencent.mm.audio.mix.d.a)localObject1).deg.size()) });
      if (!paramb.hON) {
        break label595;
      }
      bool = ((com.tencent.mm.audio.mix.d.a)localObject1).b(paramb.ddg, bool, true);
      ??? = ((com.tencent.mm.audio.mix.d.a)localObject1).ddu;
      if (!bool) {}
    }
    try
    {
      if (!((com.tencent.mm.audio.mix.d.a)localObject1).deh.contains(paramb.filePath)) {
        ((com.tencent.mm.audio.mix.d.a)localObject1).deh.add(paramb.filePath);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(136891);
    }
    if (((com.tencent.mm.ai.b)((com.tencent.mm.audio.mix.d.a)localObject1).deg.get(paramb.ddg)).e(paramb)) {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "is same param");
    }
    for (boolean bool = false;; bool = true)
    {
      ((com.tencent.mm.audio.mix.d.a)localObject1).deg.put(paramb.ddg, paramb);
      break;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "force to decode");
    }
    label595:
    if (paramb.hOy)
    {
      ((com.tencent.mm.audio.mix.d.a)localObject1).b(paramb.ddg, bool, false);
      AppMethodBeat.o(136891);
      return;
    }
    bool = ((com.tencent.mm.audio.mix.d.a)localObject1).b(paramb.ddg, bool, true);
    ??? = ((com.tencent.mm.audio.mix.d.a)localObject1).ddu;
    if (bool) {}
    try
    {
      if (!((com.tencent.mm.audio.mix.d.a)localObject1).deh.contains(paramb.filePath)) {
        ((com.tencent.mm.audio.mix.d.a)localObject1).deh.add(paramb.filePath);
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
    this.dfQ.dgf = paramb;
  }
  
  public final void a(g paramg)
  {
    this.dfQ.dgh = paramg;
  }
  
  public final void b(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(136892);
    this.dfQ.deg.put(paramb.ddg, paramb);
    this.dfR.deg.put(paramb.ddg, paramb);
    AppMethodBeat.o(136892);
  }
  
  public final void c(com.tencent.mm.ai.b paramb)
  {
    AppMethodBeat.i(136893);
    Object localObject = this.dfQ;
    if (((d)localObject).deg.containsKey(paramb.ddg)) {
      ((d)localObject).deg.put(paramb.ddg, paramb);
    }
    localObject = this.dfR;
    if (((com.tencent.mm.audio.mix.d.a)localObject).deg.containsKey(paramb.ddg)) {
      ((com.tencent.mm.audio.mix.d.a)localObject).deg.put(paramb.ddg, paramb);
    }
    AppMethodBeat.o(136893);
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(136890);
    this.dfR.clearCache();
    this.dfQ.clearCache();
    AppMethodBeat.o(136890);
  }
  
  public final boolean fY(String paramString)
  {
    AppMethodBeat.i(136903);
    boolean bool = this.dfQ.fY(paramString);
    AppMethodBeat.o(136903);
    return bool;
  }
  
  public final boolean gl(String paramString)
  {
    AppMethodBeat.i(136895);
    if (this.dfQ.deg.containsKey(paramString))
    {
      AppMethodBeat.o(136895);
      return true;
    }
    AppMethodBeat.o(136895);
    return false;
  }
  
  public final void gm(String paramString)
  {
    AppMethodBeat.i(136896);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "play audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.dfQ.gA(paramString)) });
    d(this.dfQ.gk(paramString));
    d locald = this.dfQ;
    locald.dfZ.set(false);
    locald.dfY.set(false);
    locald.Pw();
    locald.Ps();
    synchronized (locald.dgc)
    {
      locald.dfe.put(paramString, Boolean.FALSE);
      locald.dge.ga(paramString);
      locald.dgi.remove(paramString);
      locald.dgj.put(paramString, Boolean.TRUE);
      if ((locald.dfR.fX(paramString)) && (locald.dfR.fY(paramString))) {
        locald.o(0, paramString);
      }
      this.dfR.fV(paramString);
      AppMethodBeat.o(136896);
      return;
    }
  }
  
  public final void gn(String paramString)
  {
    AppMethodBeat.i(136898);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "resume audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.dfQ.gA(paramString)) });
    d(this.dfQ.gk(paramString));
    d locald = this.dfQ;
    locald.dfZ.set(false);
    locald.dfY.set(false);
    locald.Pw();
    locald.Ps();
    synchronized (locald.dgc)
    {
      locald.dfe.put(paramString, Boolean.FALSE);
      locald.dge.ga(paramString);
      locald.dgi.remove(paramString);
      locald.dgj.put(paramString, Boolean.TRUE);
      if ((locald.dfR.fX(paramString)) && (locald.dfR.fY(paramString))) {
        locald.o(1, paramString);
      }
      this.dfR.fV(paramString);
      AppMethodBeat.o(136898);
      return;
    }
  }
  
  public final void go(String paramString)
  {
    AppMethodBeat.i(136899);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "pause audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.dfQ.gA(paramString)) });
    Object localObject = this.dfQ;
    ((d)localObject).dge.gb(paramString);
    if ((((d)localObject).dfR.fX(paramString)) && (((d)localObject).dfR.fY(paramString))) {
      ((d)localObject).o(2, paramString);
    }
    localObject = this.dfR;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "pauseDecode audioId:%s", new Object[] { paramString });
    paramString = (com.tencent.mm.audio.mix.d.b)((com.tencent.mm.audio.mix.d.a)localObject).def.get(paramString);
    if (paramString == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
      AppMethodBeat.o(136899);
      return;
    }
    if (paramString.del)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
      AppMethodBeat.o(136899);
      return;
    }
    if (paramString.OB())
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is isDetach!");
      AppMethodBeat.o(136899);
      return;
    }
    paramString = paramString.dem;
    if (paramString != null) {
      paramString.pause();
    }
    AppMethodBeat.o(136899);
  }
  
  public final void gp(String paramString)
  {
    AppMethodBeat.i(136900);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "stop audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.dfQ.gA(paramString)) });
    this.dfQ.gp(paramString);
    this.dfR.fW(paramString);
    AppMethodBeat.o(136900);
  }
  
  public final boolean gq(String paramString)
  {
    AppMethodBeat.i(136904);
    d locald = this.dfQ;
    if (locald.dgj.containsKey(paramString))
    {
      boolean bool = ((Boolean)locald.dgj.get(paramString)).booleanValue();
      AppMethodBeat.o(136904);
      return bool;
    }
    AppMethodBeat.o(136904);
    return false;
  }
  
  public final boolean gr(String paramString)
  {
    AppMethodBeat.i(136905);
    d locald = this.dfQ;
    if (locald.dgk.containsKey(paramString))
    {
      paramString = (e)locald.dgk.get(paramString);
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
  
  public final boolean gs(String paramString)
  {
    AppMethodBeat.i(136906);
    d locald = this.dfQ;
    if (locald.dgk.containsKey(paramString))
    {
      paramString = (e)locald.dgk.get(paramString);
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
  
  public final boolean gt(String paramString)
  {
    AppMethodBeat.i(136908);
    d locald = this.dfQ;
    if (locald.dgk.containsKey(paramString))
    {
      paramString = (e)locald.dgk.get(paramString);
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
  
  public final int gu(String paramString)
  {
    AppMethodBeat.i(136910);
    int i = this.dfQ.gu(paramString);
    AppMethodBeat.o(136910);
    return i;
  }
  
  public final com.tencent.mm.ai.d gv(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(136911);
    d locald1 = this.dfQ;
    com.tencent.mm.ai.d locald;
    int j;
    int k;
    boolean bool1;
    int i;
    if (locald1.dgl.containsKey(paramString))
    {
      locald = (com.tencent.mm.ai.d)locald1.dgl.get(paramString);
      j = locald1.gu(paramString);
      k = locald1.gz(paramString);
      bool1 = locald1.fY(paramString);
      if (!locald1.deg.containsKey(paramString)) {
        break label300;
      }
      Object localObject = ((com.tencent.mm.ai.b)locald1.deg.get(paramString)).filePath;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label300;
      }
      localObject = com.tencent.mm.audio.mix.b.e.Os().fP((String)localObject);
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
      locald.dlC = k;
      locald.duration = j;
      if (bool1)
      {
        bool1 = false;
        locald.tG = bool1;
        if ((!locald1.dgi.containsKey(paramString)) || (!((Boolean)locald1.dgi.get(paramString)).booleanValue())) {
          break label311;
        }
      }
      for (bool1 = bool2;; bool1 = false)
      {
        locald.hOO = bool1;
        locald.hOP = (i * j / 100);
        if (!locald1.deg.containsKey(paramString)) {
          break label317;
        }
        paramString = (com.tencent.mm.ai.b)locald1.deg.get(paramString);
        locald.dez = paramString.hOx;
        locald.ddc = paramString.der;
        locald.hOJ = paramString.hOJ;
        AppMethodBeat.o(136911);
        return locald;
        locald = new com.tencent.mm.ai.d();
        locald1.dgl.put(paramString, locald);
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
  
  public final void gw(String paramString)
  {
    AppMethodBeat.i(136914);
    String str = this.appId;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmDataTrackTaskController", "cacheToFile appId:%s, filePath:%s", new Object[] { str, paramString });
    com.tencent.mm.audio.mix.b.a.d.a(new com.tencent.mm.audio.mix.b.a.a(str, paramString), "AudioPcmDataTrackCacheToFileTask");
    AppMethodBeat.o(136914);
  }
  
  public final boolean gx(String paramString)
  {
    AppMethodBeat.i(136915);
    paramString = gk(paramString);
    if (paramString != null)
    {
      if (this.dfS.containsKey(paramString.filePath))
      {
        bool = ((Boolean)this.dfS.get(paramString.filePath)).booleanValue();
        AppMethodBeat.o(136915);
        return bool;
      }
      boolean bool = com.tencent.mm.audio.mix.b.e.Os().fR(paramString.filePath);
      if (bool) {
        this.dfS.put(paramString.filePath, Boolean.valueOf(bool));
      }
      AppMethodBeat.o(136915);
      return bool;
    }
    AppMethodBeat.o(136915);
    return false;
  }
  
  public final boolean gy(String paramString)
  {
    AppMethodBeat.i(136916);
    if (this.dfS.containsKey(paramString))
    {
      bool = ((Boolean)this.dfS.get(paramString)).booleanValue();
      AppMethodBeat.o(136916);
      return bool;
    }
    boolean bool = com.tencent.mm.audio.mix.b.e.Os().fR(paramString);
    if (bool) {
      this.dfS.put(paramString, Boolean.valueOf(bool));
    }
    AppMethodBeat.o(136916);
    return bool;
  }
  
  public final boolean isPaused(String paramString)
  {
    AppMethodBeat.i(136907);
    d locald = this.dfQ;
    if (locald.dgk.containsKey(paramString))
    {
      paramString = (e)locald.dgk.get(paramString);
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
    this.dfQ.o(paramInt, paramString);
    AppMethodBeat.o(136912);
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(136901);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "remove audioId:%s", new Object[] { paramString });
    d locald = this.dfQ;
    locald.deg.remove(paramString);
    locald.dgi.remove(paramString);
    locald.dgj.remove(paramString);
    synchronized (locald.dgc)
    {
      locald.dgk.remove(paramString);
      locald.dfe.remove(paramString);
      locald.dgl.remove(paramString);
      ??? = this.dfR;
      if ((((com.tencent.mm.audio.mix.d.a)???).def.containsKey(paramString)) && (((com.tencent.mm.audio.mix.d.a)???).dei.contains(paramString))) {
        ((com.tencent.mm.audio.mix.d.a)???).fW(paramString);
      }
      ((com.tencent.mm.audio.mix.d.a)???).deg.remove(paramString);
      ((com.tencent.mm.audio.mix.d.a)???).dei.remove(paramString);
      AppMethodBeat.o(136901);
      return;
    }
  }
  
  public final boolean z(String paramString, int paramInt)
  {
    AppMethodBeat.i(136902);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo audioId:%s, position:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    boolean bool2 = this.dfR.y(paramString, paramInt);
    if (!bool2)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo fail audioId:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(136902);
      return false;
    }
    o(10, paramString);
    long l = this.dfQ.gz(paramString);
    int i = this.dfQ.gA(paramString);
    boolean bool1;
    if (!gx(paramString))
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
        if (gu(paramString) <= 2000)
        {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo duration is not support seek");
          if (!this.dfR.fX(paramString))
          {
            bool2 = this.dfR.x(paramString, paramInt);
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
          if (!this.dfR.fX(paramString))
          {
            bool2 = this.dfR.x(paramString, paramInt);
            bool1 = true;
            continue;
          }
          bool1 = this.dfQ.dge.z(paramString, paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.audio.mix.f.c
 * JD-Core Version:    0.7.0.1
 */
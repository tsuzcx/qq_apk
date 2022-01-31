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
  public d chf;
  public com.tencent.mm.audio.mix.d.a chg;
  public HashMap<String, Boolean> chh;
  private com.tencent.mm.audio.mix.c.e chi;
  public com.tencent.mm.audio.mix.b.a.d chj;
  
  public c()
  {
    AppMethodBeat.i(137139);
    this.chh = new HashMap();
    this.chf = new d();
    this.chg = new com.tencent.mm.audio.mix.d.a(this.chf);
    this.chf.chg = this.chg;
    this.chi = new com.tencent.mm.audio.mix.c.e();
    this.chj = new com.tencent.mm.audio.mix.b.a.d();
    AppMethodBeat.o(137139);
  }
  
  private void d(com.tencent.mm.ag.b paramb)
  {
    AppMethodBeat.i(137148);
    paramb.cer = true;
    int i = this.chf.ew(paramb.ceu);
    int j = this.chf.Ek();
    if (i <= 2000) {
      paramb.cer = false;
    }
    if ((i < 5000) && (j <= 5)) {}
    for (paramb.cer = false;; paramb.cer = true)
    {
      if (paramb.filePath.contains("scale_intro")) {
        paramb.cer = false;
      }
      if (j <= 5) {
        break;
      }
      Object localObject = this.chf.El();
      if (((ArrayList)localObject).contains(paramb.ceu)) {
        ((ArrayList)localObject).remove(paramb.ceu);
      }
      if (((ArrayList)localObject).size() <= 2) {
        break;
      }
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "do stop paused audio size:%d", new Object[] { Integer.valueOf(((ArrayList)localObject).size()) });
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        er((String)((Iterator)localObject).next());
      }
    }
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "playingCount:%d, duration:%d, supportMixPlay:%b", new Object[] { Integer.valueOf(j), Integer.valueOf(i), Boolean.valueOf(paramb.cer) });
    AppMethodBeat.o(137148);
  }
  
  private com.tencent.mm.ag.b em(String paramString)
  {
    AppMethodBeat.i(137145);
    paramString = this.chf.em(paramString);
    AppMethodBeat.o(137145);
    return paramString;
  }
  
  public final void DZ()
  {
    AppMethodBeat.i(137140);
    ??? = this.chg;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "pauseAllOnBackground");
    Object localObject2 = ((com.tencent.mm.audio.mix.d.a)???).cfw.iterator();
    Object localObject4;
    while (((Iterator)localObject2).hasNext())
    {
      localObject4 = (String)((Iterator)localObject2).next();
      localObject4 = (com.tencent.mm.audio.mix.d.b)((com.tencent.mm.audio.mix.d.a)???).cft.get(localObject4);
      if ((localObject4 != null) && (!((com.tencent.mm.audio.mix.d.b)localObject4).cfz) && (!((com.tencent.mm.audio.mix.d.b)localObject4).Dn()))
      {
        localObject4 = ((com.tencent.mm.audio.mix.d.b)localObject4).cfA;
        if ((localObject4 != null) && (!((k)localObject4).Ds())) {
          ((k)localObject4).Dp();
        }
      }
    }
    ??? = this.chf;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "pauseAllOnBackground");
    ((d)???).chs.DK();
    ((d)???).Ed();
    ??? = this.chi;
    if (com.tencent.mm.audio.mix.c.e.cfo == 0L) {
      com.tencent.mm.audio.mix.c.e.cfo = 0L;
    }
    long l = System.currentTimeMillis();
    if (l - com.tencent.mm.audio.mix.c.e.cfo <= com.tencent.mm.audio.mix.c.e.cfl.longValue()) {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioScanConvertCacheController", "startClean the last clean time is in AUDIO_MIX_NO_SCAN_TIME time");
    }
    for (;;)
    {
      localObject2 = com.tencent.mm.audio.mix.b.d.De();
      synchronized (((com.tencent.mm.audio.mix.b.d)localObject2).ceG)
      {
        localObject4 = ((com.tencent.mm.audio.mix.b.d)localObject2).ceF.iterator();
        Object localObject5;
        do
        {
          if (!((Iterator)localObject4).hasNext()) {
            break;
          }
          localObject5 = (String)((Iterator)localObject4).next();
          localObject5 = (com.tencent.mm.audio.mix.a.c)((com.tencent.mm.audio.mix.b.d)localObject2).cache.get(localObject5);
        } while ((localObject5 == null) || (!((com.tencent.mm.audio.mix.a.c)localObject5).cep) || (!((com.tencent.mm.audio.mix.a.c)localObject5).ces));
        ((com.tencent.mm.audio.mix.a.c)localObject5).CU();
      }
      com.tencent.mm.audio.mix.c.e.cfo = l;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioScanConvertCacheController", "start scan audio mix convert file");
      h.a(new e.a((com.tencent.mm.audio.mix.c.e)???, "clean audio mix convert cache"));
    }
    AppMethodBeat.o(137140);
  }
  
  public final boolean Ea()
  {
    AppMethodBeat.i(137160);
    boolean bool = this.chf.chn.get();
    AppMethodBeat.o(137160);
    return bool;
  }
  
  public final void Eb()
  {
    AppMethodBeat.i(137164);
    String str = this.appId;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmDataTrackTaskController", "recycleAllCache appId:%s", new Object[] { str });
    com.tencent.mm.audio.mix.b.a.d.a(new com.tencent.mm.audio.mix.b.a.c(str), "AudioPcmDataTrackRecycleCacheTask");
    this.chh.clear();
    AppMethodBeat.o(137164);
  }
  
  public final long Ec()
  {
    return this.chf.chs.cgx;
  }
  
  public final void a(com.tencent.mm.ag.b paramb)
  {
    AppMethodBeat.i(137142);
    this.appId = paramb.appId;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "preparePlay:%s", new Object[] { paramb.ceu });
    if ((eA(paramb.filePath)) && (paramb.fqX)) {
      d(paramb);
    }
    Object localObject1 = this.chf;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "preparePlay");
    if ((!paramb.frk) && (paramb.fqX)) {
      if (((d)localObject1).chl.get()) {
        ((d)localObject1).Ee();
      }
    }
    for (;;)
    {
      ((d)localObject1).cfu.put(paramb.ceu, paramb);
      synchronized (((d)localObject1).chq)
      {
        ((d)localObject1).cgu.put(paramb.ceu, Boolean.FALSE);
        ((d)localObject1).chs.ec(paramb.ceu);
        ((d)localObject1).chs.DJ();
        localObject1 = this.chg;
        com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "prepareDecode");
        if (paramb == null)
        {
          com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "param is null");
          AppMethodBeat.o(137142);
          return;
          if (((d)localObject1).chl.get()) {
            continue;
          }
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayerImpl", "initThread");
          ((d)localObject1).chl.set(true);
          ((d)localObject1).chn.set(false);
          ((d)localObject1).chm.set(false);
          ((d)localObject1).Ee();
          continue;
          if (!paramb.frk) {
            continue;
          }
          synchronized (((d)localObject1).chq)
          {
            if (((d)localObject1).chy.containsKey(paramb.ceu))
            {
              e locale = (e)((d)localObject1).chy.get(paramb.ceu);
              if (locale != null) {
                if (locale.g(new Integer[] { Integer.valueOf(4) })) {
                  ((d)localObject1).chy.remove(paramb.ceu);
                }
              }
            }
          }
        }
      }
    }
    if (TextUtils.isEmpty(paramb.ceu))
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "audioId is empty!");
      AppMethodBeat.o(137142);
      return;
    }
    if (!((com.tencent.mm.audio.mix.d.a)localObject1).cfw.contains(paramb.ceu))
    {
      ((com.tencent.mm.audio.mix.d.a)localObject1).cfw.add(paramb.ceu);
      ((com.tencent.mm.audio.mix.d.a)localObject1).cfu.put(paramb.ceu, paramb);
      bool = false;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "ids:%d, id2ParamMap:%d", new Object[] { Integer.valueOf(((com.tencent.mm.audio.mix.d.a)localObject1).cfw.size()), Integer.valueOf(((com.tencent.mm.audio.mix.d.a)localObject1).cfu.size()) });
      if (!paramb.frk) {
        break label595;
      }
      bool = ((com.tencent.mm.audio.mix.d.a)localObject1).b(paramb.ceu, bool, true);
      ??? = ((com.tencent.mm.audio.mix.d.a)localObject1).ceG;
      if (!bool) {}
    }
    try
    {
      if (!((com.tencent.mm.audio.mix.d.a)localObject1).cfv.contains(paramb.filePath)) {
        ((com.tencent.mm.audio.mix.d.a)localObject1).cfv.add(paramb.filePath);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(137142);
    }
    if (((com.tencent.mm.ag.b)((com.tencent.mm.audio.mix.d.a)localObject1).cfu.get(paramb.ceu)).e(paramb)) {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "is same param");
    }
    for (boolean bool = false;; bool = true)
    {
      ((com.tencent.mm.audio.mix.d.a)localObject1).cfu.put(paramb.ceu, paramb);
      break;
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "force to decode");
    }
    label595:
    if (paramb.fqX)
    {
      ((com.tencent.mm.audio.mix.d.a)localObject1).b(paramb.ceu, bool, false);
      AppMethodBeat.o(137142);
      return;
    }
    bool = ((com.tencent.mm.audio.mix.d.a)localObject1).b(paramb.ceu, bool, true);
    ??? = ((com.tencent.mm.audio.mix.d.a)localObject1).ceG;
    if (bool) {}
    try
    {
      if (!((com.tencent.mm.audio.mix.d.a)localObject1).cfv.contains(paramb.filePath)) {
        ((com.tencent.mm.audio.mix.d.a)localObject1).cfv.add(paramb.filePath);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(137142);
    }
  }
  
  public final void a(b paramb)
  {
    this.chf.cht = paramb;
  }
  
  public final void a(g paramg)
  {
    this.chf.chv = paramg;
  }
  
  public final void b(com.tencent.mm.ag.b paramb)
  {
    AppMethodBeat.i(137143);
    this.chf.cfu.put(paramb.ceu, paramb);
    this.chg.cfu.put(paramb.ceu, paramb);
    AppMethodBeat.o(137143);
  }
  
  public final void c(com.tencent.mm.ag.b paramb)
  {
    AppMethodBeat.i(137144);
    Object localObject = this.chf;
    if (((d)localObject).cfu.containsKey(paramb.ceu)) {
      ((d)localObject).cfu.put(paramb.ceu, paramb);
    }
    localObject = this.chg;
    if (((com.tencent.mm.audio.mix.d.a)localObject).cfu.containsKey(paramb.ceu)) {
      ((com.tencent.mm.audio.mix.d.a)localObject).cfu.put(paramb.ceu, paramb);
    }
    AppMethodBeat.o(137144);
  }
  
  public final void clearCache()
  {
    AppMethodBeat.i(137141);
    this.chg.clearCache();
    this.chf.clearCache();
    AppMethodBeat.o(137141);
  }
  
  public final boolean eA(String paramString)
  {
    AppMethodBeat.i(137167);
    if (this.chh.containsKey(paramString))
    {
      bool = ((Boolean)this.chh.get(paramString)).booleanValue();
      AppMethodBeat.o(137167);
      return bool;
    }
    boolean bool = com.tencent.mm.audio.mix.b.d.De().dT(paramString);
    if (bool) {
      this.chh.put(paramString, Boolean.valueOf(bool));
    }
    AppMethodBeat.o(137167);
    return bool;
  }
  
  public final boolean eb(String paramString)
  {
    AppMethodBeat.i(137154);
    boolean bool = this.chf.eb(paramString);
    AppMethodBeat.o(137154);
    return bool;
  }
  
  public final boolean en(String paramString)
  {
    AppMethodBeat.i(137146);
    if (this.chf.cfu.containsKey(paramString))
    {
      AppMethodBeat.o(137146);
      return true;
    }
    AppMethodBeat.o(137146);
    return false;
  }
  
  public final void eo(String paramString)
  {
    AppMethodBeat.i(137147);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "play audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.chf.eC(paramString)) });
    d(this.chf.em(paramString));
    d locald = this.chf;
    locald.chn.set(false);
    locald.chm.set(false);
    locald.Ei();
    locald.Ee();
    synchronized (locald.chq)
    {
      locald.cgu.put(paramString, Boolean.FALSE);
      locald.chs.ec(paramString);
      locald.chw.remove(paramString);
      locald.chx.put(paramString, Boolean.TRUE);
      if ((locald.chg.ea(paramString)) && (locald.chg.eb(paramString))) {
        locald.m(0, paramString);
      }
      this.chg.dY(paramString);
      AppMethodBeat.o(137147);
      return;
    }
  }
  
  public final void ep(String paramString)
  {
    AppMethodBeat.i(137149);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "resume audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.chf.eC(paramString)) });
    d(this.chf.em(paramString));
    d locald = this.chf;
    locald.chn.set(false);
    locald.chm.set(false);
    locald.Ei();
    locald.Ee();
    synchronized (locald.chq)
    {
      locald.cgu.put(paramString, Boolean.FALSE);
      locald.chs.ec(paramString);
      locald.chw.remove(paramString);
      locald.chx.put(paramString, Boolean.TRUE);
      if ((locald.chg.ea(paramString)) && (locald.chg.eb(paramString))) {
        locald.m(1, paramString);
      }
      this.chg.dY(paramString);
      AppMethodBeat.o(137149);
      return;
    }
  }
  
  public final void eq(String paramString)
  {
    AppMethodBeat.i(137150);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "pause audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.chf.eC(paramString)) });
    Object localObject = this.chf;
    ((d)localObject).chs.ed(paramString);
    if ((((d)localObject).chg.ea(paramString)) && (((d)localObject).chg.eb(paramString))) {
      ((d)localObject).m(2, paramString);
    }
    localObject = this.chg;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioDecodeMgr", "pauseDecode audioId:%s", new Object[] { paramString });
    paramString = (com.tencent.mm.audio.mix.d.b)((com.tencent.mm.audio.mix.d.a)localObject).cft.get(paramString);
    if (paramString == null)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is not exist");
      AppMethodBeat.o(137150);
      return;
    }
    if (paramString.cfz)
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is execute end!");
      AppMethodBeat.o(137150);
      return;
    }
    if (paramString.Dn())
    {
      com.tencent.mm.audio.mix.h.b.e("MicroMsg.Mix.AudioDecodeMgr", "task is isDetach!");
      AppMethodBeat.o(137150);
      return;
    }
    paramString = paramString.cfA;
    if (paramString != null) {
      paramString.pause();
    }
    AppMethodBeat.o(137150);
  }
  
  public final void er(String paramString)
  {
    AppMethodBeat.i(137151);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "stop audioId:%s, audio state:%d", new Object[] { paramString, Integer.valueOf(this.chf.eC(paramString)) });
    this.chf.er(paramString);
    this.chg.dZ(paramString);
    AppMethodBeat.o(137151);
  }
  
  public final boolean es(String paramString)
  {
    AppMethodBeat.i(137155);
    d locald = this.chf;
    if (locald.chx.containsKey(paramString))
    {
      boolean bool = ((Boolean)locald.chx.get(paramString)).booleanValue();
      AppMethodBeat.o(137155);
      return bool;
    }
    AppMethodBeat.o(137155);
    return false;
  }
  
  public final boolean et(String paramString)
  {
    AppMethodBeat.i(137156);
    d locald = this.chf;
    if (locald.chy.containsKey(paramString))
    {
      paramString = (e)locald.chy.get(paramString);
      if (paramString != null) {
        if (paramString.g(new Integer[] { Integer.valueOf(9) }))
        {
          AppMethodBeat.o(137156);
          return true;
        }
      }
    }
    AppMethodBeat.o(137156);
    return false;
  }
  
  public final boolean eu(String paramString)
  {
    AppMethodBeat.i(137157);
    d locald = this.chf;
    if (locald.chy.containsKey(paramString))
    {
      paramString = (e)locald.chy.get(paramString);
      if (paramString != null) {
        if (paramString.g(new Integer[] { Integer.valueOf(7) }))
        {
          AppMethodBeat.o(137157);
          return true;
        }
      }
    }
    AppMethodBeat.o(137157);
    return false;
  }
  
  public final boolean ev(String paramString)
  {
    AppMethodBeat.i(137159);
    d locald = this.chf;
    if (locald.chy.containsKey(paramString))
    {
      paramString = (e)locald.chy.get(paramString);
      if (paramString != null)
      {
        if (!paramString.g(new Integer[] { Integer.valueOf(3) })) {
          if (!paramString.g(new Integer[] { Integer.valueOf(4) })) {
            if (!paramString.g(new Integer[] { Integer.valueOf(5) })) {
              break label100;
            }
          }
        }
        AppMethodBeat.o(137159);
        return true;
      }
    }
    label100:
    AppMethodBeat.o(137159);
    return false;
  }
  
  public final int ew(String paramString)
  {
    AppMethodBeat.i(137161);
    int i = this.chf.ew(paramString);
    AppMethodBeat.o(137161);
    return i;
  }
  
  public final com.tencent.mm.ag.d ex(String paramString)
  {
    boolean bool2 = true;
    AppMethodBeat.i(137162);
    d locald1 = this.chf;
    com.tencent.mm.ag.d locald;
    int j;
    int k;
    boolean bool1;
    int i;
    if (locald1.chz.containsKey(paramString))
    {
      locald = (com.tencent.mm.ag.d)locald1.chz.get(paramString);
      j = locald1.ew(paramString);
      k = locald1.eB(paramString);
      bool1 = locald1.eb(paramString);
      if (!locald1.cfu.containsKey(paramString)) {
        break label291;
      }
      Object localObject = ((com.tencent.mm.ag.b)locald1.cfu.get(paramString)).filePath;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        break label291;
      }
      localObject = com.tencent.mm.audio.mix.b.d.De().dR((String)localObject);
      if ((localObject == null) || (((com.tencent.mm.audio.mix.a.c)localObject).duration <= 0L)) {
        break label291;
      }
      i = 100;
      label129:
      if (i >= 0) {
        break label316;
      }
      i = 0;
    }
    label156:
    label291:
    label302:
    label308:
    label316:
    for (;;)
    {
      locald.cmU = k;
      locald.duration = j;
      if (bool1)
      {
        bool1 = false;
        locald.kH = bool1;
        if ((!locald1.chw.containsKey(paramString)) || (!((Boolean)locald1.chw.get(paramString)).booleanValue())) {
          break label302;
        }
      }
      for (bool1 = bool2;; bool1 = false)
      {
        locald.frl = bool1;
        locald.frm = (i * j / 100);
        if (!locald1.cfu.containsKey(paramString)) {
          break label308;
        }
        paramString = (com.tencent.mm.ag.b)locald1.cfu.get(paramString);
        locald.startTime = paramString.fqW;
        locald.ceq = paramString.cfG;
        AppMethodBeat.o(137162);
        return locald;
        locald = new com.tencent.mm.ag.d();
        locald1.chz.put(paramString, locald);
        break;
        i = 0;
        break label129;
        bool1 = true;
        break label156;
      }
      AppMethodBeat.o(137162);
      return null;
    }
  }
  
  public final void ey(String paramString)
  {
    AppMethodBeat.i(137165);
    String str = this.appId;
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioPcmDataTrackTaskController", "cacheToFile appId:%s, filePath:%s", new Object[] { str, paramString });
    com.tencent.mm.audio.mix.b.a.d.a(new com.tencent.mm.audio.mix.b.a.a(str, paramString), "AudioPcmDataTrackCacheToFileTask");
    AppMethodBeat.o(137165);
  }
  
  public final boolean ez(String paramString)
  {
    AppMethodBeat.i(137166);
    paramString = em(paramString);
    if (paramString != null)
    {
      if (this.chh.containsKey(paramString.filePath))
      {
        bool = ((Boolean)this.chh.get(paramString.filePath)).booleanValue();
        AppMethodBeat.o(137166);
        return bool;
      }
      boolean bool = com.tencent.mm.audio.mix.b.d.De().dT(paramString.filePath);
      if (bool) {
        this.chh.put(paramString.filePath, Boolean.valueOf(bool));
      }
      AppMethodBeat.o(137166);
      return bool;
    }
    AppMethodBeat.o(137166);
    return false;
  }
  
  public final boolean isPaused(String paramString)
  {
    AppMethodBeat.i(137158);
    d locald = this.chf;
    if (locald.chy.containsKey(paramString))
    {
      paramString = (e)locald.chy.get(paramString);
      if (paramString != null) {
        if (paramString.g(new Integer[] { Integer.valueOf(2) }))
        {
          AppMethodBeat.o(137158);
          return true;
        }
      }
    }
    AppMethodBeat.o(137158);
    return false;
  }
  
  public final void m(int paramInt, String paramString)
  {
    AppMethodBeat.i(137163);
    this.chf.m(paramInt, paramString);
    AppMethodBeat.o(137163);
  }
  
  public final void remove(String paramString)
  {
    AppMethodBeat.i(137152);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "remove audioId:%s", new Object[] { paramString });
    d locald = this.chf;
    locald.cfu.remove(paramString);
    locald.chw.remove(paramString);
    locald.chx.remove(paramString);
    synchronized (locald.chq)
    {
      locald.chy.remove(paramString);
      locald.cgu.remove(paramString);
      locald.chz.remove(paramString);
      ??? = this.chg;
      if ((((com.tencent.mm.audio.mix.d.a)???).cft.containsKey(paramString)) && (((com.tencent.mm.audio.mix.d.a)???).cfw.contains(paramString))) {
        ((com.tencent.mm.audio.mix.d.a)???).dZ(paramString);
      }
      ((com.tencent.mm.audio.mix.d.a)???).cfu.remove(paramString);
      ((com.tencent.mm.audio.mix.d.a)???).cfw.remove(paramString);
      AppMethodBeat.o(137152);
      return;
    }
  }
  
  public final boolean w(String paramString, int paramInt)
  {
    AppMethodBeat.i(137153);
    com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo audioId:%s, position:%d", new Object[] { paramString, Integer.valueOf(paramInt) });
    boolean bool2 = this.chg.v(paramString, paramInt);
    if (!bool2)
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo fail audioId:%s", new Object[] { Integer.valueOf(paramInt) });
      AppMethodBeat.o(137153);
      return false;
    }
    m(10, paramString);
    long l = this.chf.eB(paramString);
    int i = this.chf.eC(paramString);
    boolean bool1;
    if (!ez(paramString))
    {
      com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo cache is not exist");
      bool1 = true;
    }
    for (;;)
    {
      m(6, paramString);
      if ((bool1) && (bool2))
      {
        AppMethodBeat.o(137153);
        return true;
        if (ew(paramString) <= 2000)
        {
          com.tencent.mm.audio.mix.h.b.i("MicroMsg.Mix.AudioMixPlayer", "seekTo duration is not support seek");
          if (!this.chg.ea(paramString))
          {
            bool2 = this.chg.u(paramString, paramInt);
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
          if (!this.chg.ea(paramString))
          {
            bool2 = this.chg.u(paramString, paramInt);
            bool1 = true;
            continue;
          }
          bool1 = this.chf.chs.w(paramString, paramInt);
        }
      }
      else
      {
        AppMethodBeat.o(137153);
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
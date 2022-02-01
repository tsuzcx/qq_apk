package com.tencent.mm.plugin.finder.preload.worker;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.d;
import com.tencent.mm.i.g.a;
import com.tencent.mm.plugin.finder.storage.m;
import com.tencent.mm.sdk.platformtools.ac;
import d.g.b.k;
import java.io.ByteArrayOutputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker$VideoTaskCallTask;", "Lcom/tencent/mm/cdn/keep_TaskInfo$TaskCallback;", "expect", "", "preloadMinSize", "", "loadingMap", "Ljava/util/HashMap;", "", "Lcom/tencent/mm/plugin/finder/preload/PreloadCDNTask;", "Lkotlin/collections/HashMap;", "preLoadCallbacks", "Ljava/util/concurrent/ConcurrentLinkedQueue;", "Lcom/tencent/mm/plugin/finder/preload/IVideoPreloadCallback;", "video", "Lcom/tencent/mm/plugin/finder/loader/FinderVideo;", "(Lcom/tencent/mm/plugin/finder/preload/worker/VideoPreloadWorker;IJLjava/util/HashMap;Ljava/util/concurrent/ConcurrentLinkedQueue;Lcom/tencent/mm/plugin/finder/loader/FinderVideo;)V", "getExpect", "()I", "getPreloadMinSize", "()J", "callback", "mediaId", "startRet", "progressInfo", "Lcom/tencent/mm/cdn/keep_ProgressInfo;", "sceneResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "onlyCheckExist", "", "decodePrepareResponse", "", "inbuf", "getCdnAuthInfo", "", "buff", "Ljava/io/ByteArrayOutputStream;", "plugin-finder_release"})
final class b$c
  implements g.a
{
  private final long preloadMinSize;
  private final com.tencent.mm.plugin.finder.loader.l rcZ;
  final HashMap<String, com.tencent.mm.plugin.finder.preload.c> rwb;
  private final ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> rwe;
  private final int rwj;
  
  public b$c(int paramInt, long paramLong, HashMap<String, com.tencent.mm.plugin.finder.preload.c> paramHashMap, ConcurrentLinkedQueue<com.tencent.mm.plugin.finder.preload.b> paramConcurrentLinkedQueue, com.tencent.mm.plugin.finder.loader.l paraml)
  {
    AppMethodBeat.i(202650);
    this.rwj = paramLong;
    this.preloadMinSize = ???;
    this.rwb = paramConcurrentLinkedQueue;
    this.rwe = paraml;
    this.rcZ = localObject;
    AppMethodBeat.o(202650);
  }
  
  public final int a(String paramString, int paramInt, com.tencent.mm.i.c paramc, d paramd, boolean paramBoolean)
  {
    AppMethodBeat.i(202649);
    k.h(paramString, "mediaId");
    if ((paramd != null) && (paramd.field_retCode == -21112))
    {
      b.a(this.rwi, (d.g.a.a)new b.c.a(this, paramString));
      paramc = ((Iterable)this.rwe).iterator();
      while (paramc.hasNext()) {
        ((com.tencent.mm.plugin.finder.preload.b)paramc.next()).adG(paramString);
      }
      AppMethodBeat.o(202649);
      return -1;
    }
    long l1;
    long l2;
    if ((paramc != null) && (paramc.field_toltalLength > 0L))
    {
      l1 = paramc.field_finishedLength;
      l2 = paramc.field_toltalLength;
      if (((int)((float)l1 / (float)l2 * 100.0F) >= this.rwj) && (l1 < l2) && (this.preloadMinSize <= l1))
      {
        paramInt = 2;
        paramc = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
        if (paramd != null)
        {
          paramc = paramd.field_videoFlag;
          if (paramc != null) {
            break label419;
          }
        }
        paramc = ((c)this).rcZ.rtm.detail;
      }
    }
    label419:
    for (;;)
    {
      com.tencent.mm.plugin.finder.storage.logic.c.gf(paramString, paramc);
      paramc = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
      com.tencent.mm.plugin.finder.storage.logic.c.a(paramString, l1, l2, paramInt);
      paramc = ((Iterable)this.rwe).iterator();
      for (;;)
      {
        if (paramc.hasNext())
        {
          ((com.tencent.mm.plugin.finder.preload.b)paramc.next()).cZ(paramString, d.h.a.cj((float)l1 * 100.0F / (float)l2));
          continue;
          if (l1 >= l2)
          {
            paramInt = 3;
            break;
          }
          paramInt = 1;
          break;
          if (paramInt != 0)
          {
            ac.e(b.b(this.rwi), "[VideoTaskCallTask] error! startRet=" + paramInt + " mediaId=" + paramString);
            if (-21006 != paramInt)
            {
              paramc = (com.tencent.mm.plugin.finder.preload.c)b.a(this.rwi, (d.g.a.a)new b.c.b(this, paramString));
              paramd = com.tencent.mm.plugin.finder.storage.logic.c.rFo;
              com.tencent.mm.plugin.finder.storage.logic.c.a(paramString, 0L, 0L, -1);
              if (paramc != null)
              {
                paramd = ((Iterable)this.rwe).iterator();
                while (paramd.hasNext()) {
                  ((com.tencent.mm.plugin.finder.preload.b)paramd.next()).a(paramString, "UPDATE ERROR", paramc);
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(202649);
      return 0;
    }
  }
  
  public final void a(String paramString, ByteArrayOutputStream paramByteArrayOutputStream)
  {
    AppMethodBeat.i(202648);
    k.h(paramString, "mediaId");
    AppMethodBeat.o(202648);
  }
  
  public final byte[] f(String paramString, byte[] paramArrayOfByte)
  {
    return new byte[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.preload.worker.b.c
 * JD-Core Version:    0.7.0.1
 */
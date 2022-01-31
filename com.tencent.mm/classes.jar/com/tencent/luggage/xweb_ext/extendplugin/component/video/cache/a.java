package com.tencent.luggage.xweb_ext.extendplugin.component.video.cache;

import android.net.Uri;
import android.os.HandlerThread;
import com.google.android.exoplayer2.h.a.c.a;
import com.google.android.exoplayer2.h.a.d;
import com.google.android.exoplayer2.h.a.i;
import com.google.android.exoplayer2.h.g.a;
import com.google.android.exoplayer2.h.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.al;
import java.io.File;

public class a
  implements b, com.tencent.mm.kernel.c.b
{
  private static a bHV;
  private com.google.android.exoplayer2.h.a.a aZF;
  private com.google.android.exoplayer2.h.a.c bHT;
  private c.a bHU;
  private al bHW;
  
  private a()
  {
    AppMethodBeat.i(139885);
    this.bHU = new a.1(this);
    Object localObject3 = com.tencent.mm.compatible.util.e.eQz;
    Object localObject1 = localObject3;
    if (!((String)localObject3).endsWith("/")) {
      localObject1 = (String)localObject3 + "/";
    }
    localObject1 = (String)localObject1 + "wxavideocache/";
    try
    {
      if (!com.tencent.mm.vfs.e.um((String)localObject1))
      {
        ab.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs fail 1, maybe file exist");
        if (!new com.tencent.mm.vfs.b((String)localObject1).isDirectory())
        {
          ab.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs fail, not dir");
          com.tencent.mm.vfs.e.deleteFile((String)localObject1);
          if (!com.tencent.mm.vfs.e.um((String)localObject1))
          {
            ab.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs fail 2, no space?");
            AppMethodBeat.o(139885);
            return;
          }
        }
      }
    }
    catch (Throwable localThrowable)
    {
      ab.e("MicroMsg.SameLayer.ExoVideoCacheHandler", "mkdirs exception:%s", new Object[] { localThrowable });
      AppMethodBeat.o(139885);
      return;
    }
    Object localObject2 = new com.tencent.mm.vfs.b(localThrowable);
    localObject3 = new i();
    this.aZF = new com.google.android.exoplayer2.h.a.j(new File(com.tencent.mm.vfs.j.p(((com.tencent.mm.vfs.b)localObject2).dQJ())), (d)localObject3);
    ab.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "initVideoCacheDataSource, cacheFolder:%s", new Object[] { com.tencent.mm.vfs.j.p(((com.tencent.mm.vfs.b)localObject2).dQJ()) });
    localObject2 = com.tencent.luggage.xweb_ext.extendplugin.component.video.b.a.c.ax(ah.getContext());
    this.bHT = new com.google.android.exoplayer2.h.a.c(this.aZF, ((g.a)localObject2).qn(), new q(), new com.google.android.exoplayer2.h.a.b(this.aZF), this.bHU);
    ab.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "initVideoCacheDataSource, cache:%s", new Object[] { this.aZF });
    AppMethodBeat.o(139885);
  }
  
  public static a xO()
  {
    AppMethodBeat.i(139884);
    if (bHV == null) {}
    try
    {
      if (bHV == null) {
        bHV = new a();
      }
      a locala = bHV;
      AppMethodBeat.o(139884);
      return locala;
    }
    finally
    {
      AppMethodBeat.o(139884);
    }
  }
  
  public final void j(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(139886);
    if (this.aZF == null)
    {
      ab.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "cache, cache is null");
      AppMethodBeat.o(139886);
      return;
    }
    if (this.bHW == null) {
      this.bHW = new al("VideoCacheThread");
    }
    this.bHW.ac(new a.3(this, paramString, paramLong1, paramLong2));
    AppMethodBeat.o(139886);
  }
  
  public final boolean k(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(139887);
    if (this.aZF == null)
    {
      ab.w("MicroMsg.SameLayer.ExoVideoCacheHandler", "checkCached, cache is null");
      AppMethodBeat.o(139887);
      return false;
    }
    String str = Uri.parse(paramString).toString();
    boolean bool = this.aZF.f(str, paramLong1, paramLong2);
    ab.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "checkCached, cached:%s, position:%s, length:%s, url:%s", new Object[] { Boolean.valueOf(bool), Long.valueOf(paramLong1), Long.valueOf(paramLong2), paramString });
    AppMethodBeat.o(139887);
    return bool;
  }
  
  public final void xM()
  {
    AppMethodBeat.i(139882);
    ab.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "register VideoCacheService#ExoVideoCacheHandler");
    AppMethodBeat.o(139882);
  }
  
  public final void xN()
  {
    AppMethodBeat.i(139883);
    ab.i("MicroMsg.SameLayer.ExoVideoCacheHandler", "unregister VideoCacheService#ExoVideoCacheHandler");
    if (this.bHW != null) {
      this.bHW.oNc.quitSafely();
    }
    AppMethodBeat.o(139883);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.video.cache.a
 * JD-Core Version:    0.7.0.1
 */
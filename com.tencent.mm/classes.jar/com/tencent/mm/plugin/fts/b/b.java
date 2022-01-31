package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.h.a.be;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.vfs.j;

public final class b
  extends com.tencent.mm.plugin.fts.a.b
{
  m dBO;
  private c<be> ekJ = new b.2(this);
  com.tencent.mm.plugin.fts.c.b kyT;
  private c kyp = new b.1(this);
  
  public static com.tencent.mm.vfs.b aVI()
  {
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(new com.tencent.mm.vfs.b(com.tencent.mm.compatible.util.e.dOQ, "fts"), "feature");
    if (!localb.exists()) {
      localb.mkdirs();
    }
    return localb;
  }
  
  public static com.tencent.mm.vfs.b aVJ()
  {
    com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(aVI(), "fts_feature");
    if (!localb.exists()) {
      localb.mkdirs();
    }
    return localb;
  }
  
  static int i(com.tencent.mm.vfs.b paramb)
  {
    paramb = new com.tencent.mm.vfs.b(paramb, "version.info");
    try
    {
      if (paramb.exists()) {
        return Integer.parseInt(com.tencent.mm.vfs.e.bP(j.n(paramb.cLr())), 10);
      }
      y.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "version file %s not exist", new Object[] { j.n(paramb.cLr()) });
      return -1;
    }
    catch (Exception paramb)
    {
      y.printErrStackTrace("MicroMsg.FTS.FTS5SearchFeatureLogic", paramb, "getFeatureVersion", new Object[0]);
    }
    return -1;
  }
  
  protected final boolean BB()
  {
    this.kyp.dead();
    this.ekJ.dead();
    this.kyT = null;
    this.dBO = null;
    return true;
  }
  
  public final a a(i parami)
  {
    parami = new b.c(this, parami, (byte)0);
    return this.dBO.a(-65536, parami);
  }
  
  public final String getName()
  {
    return "FTS5SearchFeatureLogic";
  }
  
  protected final boolean onCreate()
  {
    if (!((n)g.t(n.class)).isFTSContextReady())
    {
      y.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "Create Fail!");
      return false;
    }
    y.i("MicroMsg.FTS.FTS5SearchFeatureLogic", "Create Success!");
    this.dBO = ((n)g.t(n.class)).getFTSTaskDaemon();
    this.kyT = ((com.tencent.mm.plugin.fts.c.b)((n)g.t(n.class)).getFTSIndexStorage(17));
    this.kyp.cqo();
    this.ekJ.cqo();
    this.dBO.a(131132, new b.b(this, (byte)0));
    this.dBO.a(131133, new b.a(this, (byte)0));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.b
 * JD-Core Version:    0.7.0.1
 */
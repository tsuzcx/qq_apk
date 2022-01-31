package com.tencent.mm.plugin.fts.b;

import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.a;
import com.tencent.mm.plugin.fts.a.a.i;
import com.tencent.mm.plugin.fts.a.b;
import com.tencent.mm.plugin.fts.a.m;
import com.tencent.mm.plugin.fts.a.n;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.y;
import java.util.List;

public final class f
  extends b
{
  m dBO;
  private com.tencent.mm.ah.f eeo = new f.2(this);
  c kzB = new f.1(this);
  String[] kzC;
  List<String> kzD;
  
  protected final boolean BB()
  {
    g.Dk().b(30, this.eeo);
    return false;
  }
  
  public final a a(i parami)
  {
    switch (parami.kwX)
    {
    case 65522: 
    default: 
      parami = new f.a(this, (byte)0);
    }
    for (;;)
    {
      return this.dBO.a(-65536, parami);
      parami = new f.f(this, parami.kxc);
      continue;
      parami = new f.e(this, parami);
      continue;
      parami = new f.d(this, (byte)0);
    }
  }
  
  public final String getName()
  {
    return "SearchTestLogic";
  }
  
  protected final boolean onCreate()
  {
    if (!((n)g.t(n.class)).isFTSContextReady())
    {
      y.i("MicroMsg.FTS.FTSSearchTestLogic", "Create Fail!");
      return false;
    }
    y.i("MicroMsg.FTS.FTSSearchTestLogic", "Create Success!");
    this.dBO = ((n)g.t(n.class)).getFTSTaskDaemon();
    this.kzB.cqo();
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.b.f
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.g;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.f;

public final class d
  extends a
{
  public CharSequence dtD;
  d.a fYA = new d.a(this);
  public l fYx;
  public AppBrandRecentTaskInfo fYy;
  private d.b fYz = new d.b(this);
  
  public d(int paramInt)
  {
    super(16, paramInt);
  }
  
  public final a.b BD()
  {
    return this.fYz;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    boolean bool3 = true;
    boolean bool1 = false;
    this.fYy = i.tm(this.fYx.kwg);
    if (this.fYy == null) {
      return;
    }
    boolean bool2;
    switch (this.fYx.kwf)
    {
    default: 
      bool1 = false;
      bool2 = false;
    }
    for (;;)
    {
      this.dtD = f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.fYy.appName, this.kwi, bool1, bool2)).kwz;
      this.info = this.fYy.bFn;
      return;
      bool1 = true;
      bool2 = bool1;
      bool1 = bool3;
    }
  }
  
  protected final a.a afK()
  {
    return this.fYA;
  }
  
  public final String afL()
  {
    return this.fYy.appName;
  }
  
  public final int afM()
  {
    return this.fYx.kxt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.d
 * JD-Core Version:    0.7.0.1
 */
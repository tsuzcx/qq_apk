package com.tencent.mm.plugin.appbrand.game.a;

import android.content.Context;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.game.a.a.b;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.f;

public final class c
  extends a
{
  public CharSequence dtD;
  public l fYx;
  public AppBrandRecentTaskInfo gaE;
  public b gaF;
  private c.b gaG = new c.b(this);
  c.a gaH = new c.a(this);
  
  public c(int paramInt)
  {
    super(20, paramInt);
  }
  
  public final a.b BD()
  {
    return this.gaG;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    boolean bool3 = true;
    boolean bool1 = false;
    this.gaE = i.ts(this.fYx.kwg);
    this.gaF = i.tr(this.fYx.kwg);
    if (this.gaF == null) {
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
      this.dtD = f.a(d.a(this.gaF.field_AppName, this.kwi, bool1, bool2)).kwz;
      this.info = this.gaF.field_AppId;
      return;
      bool1 = true;
      bool2 = bool1;
      bool1 = bool3;
    }
  }
  
  protected final a.a afK()
  {
    return this.gaH;
  }
  
  public final String afL()
  {
    if (this.gaF != null) {
      return String.format("%s:%s", new Object[] { this.gaF.field_AppId, this.gaF.field_AppName });
    }
    return ":";
  }
  
  public final int afM()
  {
    return this.fYx.kxt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.a.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.game.b;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appusage.AppBrandRecentTaskInfo;
import com.tencent.mm.plugin.appbrand.game.b.a.b;
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
  public CharSequence elh;
  public l hrL;
  public AppBrandRecentTaskInfo hsE;
  public b hsF;
  private c.b hsG;
  c.a hsH;
  
  public c(int paramInt)
  {
    super(20, paramInt);
    AppMethodBeat.i(130080);
    this.hsG = new c.b(this);
    this.hsH = new c.a(this);
    AppMethodBeat.o(130080);
  }
  
  public final a.b Pr()
  {
    return this.hsG;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    boolean bool3 = true;
    boolean bool1 = false;
    AppMethodBeat.i(130081);
    this.hsE = i.Bw(this.hrL.mRV);
    this.hsF = i.Bv(this.hrL.mRV);
    if (this.hsF == null)
    {
      AppMethodBeat.o(130081);
      return;
    }
    boolean bool2;
    switch (this.hrL.mRU)
    {
    default: 
      bool1 = false;
      bool2 = false;
    }
    for (;;)
    {
      this.elh = f.a(d.a(this.hsF.field_AppName, this.mRX, bool1, bool2)).mSp;
      this.info = this.hsF.field_AppId;
      AppMethodBeat.o(130081);
      return;
      bool1 = true;
      bool2 = bool1;
      bool1 = bool3;
    }
  }
  
  public final String aAo()
  {
    AppMethodBeat.i(130082);
    if (this.hsF != null)
    {
      String str = String.format("%s:%s", new Object[] { this.hsF.field_AppId, this.hsF.field_AppName });
      AppMethodBeat.o(130082);
      return str;
    }
    AppMethodBeat.o(130082);
    return ":";
  }
  
  public final int aAp()
  {
    return this.hrL.mTi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.b.c
 * JD-Core Version:    0.7.0.1
 */
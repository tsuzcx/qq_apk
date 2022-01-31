package com.tencent.mm.plugin.appbrand.g;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
  public CharSequence elh;
  public l hrL;
  public AppBrandRecentTaskInfo hrM;
  private d.b hrN;
  d.a hrO;
  
  public d(int paramInt)
  {
    super(16, paramInt);
    AppMethodBeat.i(129973);
    this.hrN = new d.b(this);
    this.hrO = new d.a(this);
    AppMethodBeat.o(129973);
  }
  
  public final a.b Pr()
  {
    return this.hrN;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    boolean bool3 = true;
    boolean bool1 = false;
    AppMethodBeat.i(129974);
    super.a(paramContext, parama, paramVarArgs);
    this.hrM = i.Bq(this.hrL.mRV);
    if (this.hrM == null)
    {
      AppMethodBeat.o(129974);
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
      this.elh = f.a(com.tencent.mm.plugin.fts.a.a.d.a(this.hrM.appName, this.mRX, bool1, bool2)).mSp;
      this.info = this.hrM.cmx;
      AppMethodBeat.o(129974);
      return;
      bool1 = true;
      bool2 = bool1;
      bool1 = bool3;
    }
  }
  
  public final String aAo()
  {
    return this.hrM.appName;
  }
  
  public final int aAp()
  {
    return this.hrL.mTi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.g.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.c;
import com.tencent.mm.plugin.fts.a.a.d;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.a.f;

public final class j
  extends a
{
  public int actionType;
  public l hrL;
  public CharSequence mBF;
  public String mBI;
  public CharSequence mZk;
  public String mZl;
  public c mZm;
  private j.b mZn;
  j.a mZo;
  
  public j(int paramInt)
  {
    super(3, paramInt);
    AppMethodBeat.i(62003);
    this.actionType = -1;
    this.mZn = new j.b(this);
    this.mZo = new j.a(this);
    AppMethodBeat.o(62003);
  }
  
  public final a.b Pr()
  {
    return this.mZn;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    boolean bool2 = true;
    AppMethodBeat.i(62004);
    super.a(paramContext, parama, paramVarArgs);
    this.mZm = ((c)this.hrL.userData);
    if (this.mZm == null)
    {
      AppMethodBeat.o(62004);
      return;
    }
    this.mBF = this.mZm.field_title;
    this.mZk = this.mZm.field_tag;
    this.mBI = this.mZm.field_iconPath;
    this.mZl = this.mZm.field_androidUrl;
    this.actionType = this.mZm.field_actionType;
    boolean bool1;
    switch (this.hrL.mRU)
    {
    default: 
      AppMethodBeat.o(62004);
      return;
    case 3: 
      bool1 = true;
    }
    for (;;)
    {
      this.mBF = f.a(d.a(this.mBF, this.mRX, bool2, bool1)).mSp;
      AppMethodBeat.o(62004);
      return;
      this.mZk = f.a(d.a(this.mZk, this.mRX)).mSp;
      break;
      bool1 = false;
      continue;
      bool2 = false;
      bool1 = false;
    }
  }
  
  public final String aAo()
  {
    return this.mZm.field_title;
  }
  
  public final int aAp()
  {
    return this.hrL.mTi;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.j
 * JD-Core Version:    0.7.0.1
 */
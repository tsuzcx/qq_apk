package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.l;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;

public final class o
  extends f
{
  private o.a mZH;
  
  public o(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(62024);
    this.mZH = new o.a(this);
    AppMethodBeat.o(62024);
  }
  
  public final a.b Pr()
  {
    return this.mZH;
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(62025);
    String str = this.mYP.mRV;
    boolean bool2;
    boolean bool1;
    switch (this.mYP.mRU)
    {
    case 4: 
    default: 
      paramVarArgs = null;
      parama = null;
      bool2 = false;
      bool1 = false;
    case 3: 
      for (;;)
      {
        this.mYM = str;
        if (bo.isNullOrNil(paramVarArgs)) {
          break;
        }
        this.mYL = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(parama, this.mYP.mRX, bool2, bool1, b.c.mVU, paramVarArgs + "(", ")")).mSp;
        this.mYL = TextUtils.concat(new CharSequence[] { "\"", this.mYL, paramContext.getString(2131303026) });
        AppMethodBeat.o(62025);
        return;
        bool1 = true;
        bool2 = true;
        parama = com.tencent.mm.plugin.fts.a.d.NA(str);
        paramVarArgs = null;
      }
    case 7: 
      label136:
      label177:
      label180:
      bool1 = true;
      label194:
      bool2 = true;
    }
    for (;;)
    {
      parama = ((j)g.E(j.class)).YA().arw(str).field_nickname;
      paramVarArgs = com.tencent.mm.plugin.fts.a.d.NA(str);
      break;
      this.mYL = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(parama, this.mYP.mRX, bool2, bool1, 400.0F, b.c.mVU)).mSp;
      break label136;
      bool1 = false;
      break label177;
      bool2 = false;
      bool1 = false;
      break label180;
      bool1 = false;
      break label194;
      bool2 = false;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.o
 * JD-Core Version:    0.7.0.1
 */
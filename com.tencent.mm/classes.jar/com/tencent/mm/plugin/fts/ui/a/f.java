package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
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

public class f
  extends k
{
  public String mSN;
  protected CharSequence mYL;
  protected String mYM;
  protected CharSequence mYN;
  protected String mYO;
  public l mYP;
  private f.a mYQ;
  f.b mYR;
  public int showType;
  
  public f(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(61984);
    this.mYQ = new f.a(this);
    this.mYR = new f.b(this);
    AppMethodBeat.o(61984);
  }
  
  public a.b Pr()
  {
    return this.mYQ;
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(61985);
    String str = this.mYP.mRV;
    boolean bool2 = false;
    boolean bool1 = false;
    boolean bool5 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    parama = null;
    switch (this.mYP.mRU)
    {
    case 4: 
    default: 
      paramVarArgs = null;
      bool1 = false;
      bool3 = bool4;
      if (this.showType == 2)
      {
        this.mYM = str;
        if (!bo.isNullOrNil(paramVarArgs))
        {
          this.mYL = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(parama, this.mYP.mRX, bool3, bool1, b.c.mVU, paramVarArgs + "(", ")")).mSp;
          this.mYL = TextUtils.concat(new CharSequence[] { "\"", this.mYL, "\"" });
          this.mYN = TextUtils.concat(new CharSequence[] { "\"", TextUtils.ellipsize(com.tencent.mm.plugin.fts.a.d.NA(this.mSN), b.c.mVW, 300.0F, TextUtils.TruncateAt.END), paramContext.getString(2131303026) });
          this.mYO = this.mSN;
          AppMethodBeat.o(61985);
          return;
        }
      }
      break;
    case 3: 
      label159:
      bool1 = true;
    }
    label250:
    for (bool3 = true;; bool3 = bool5)
    {
      parama = com.tencent.mm.plugin.fts.a.d.NA(str);
      paramVarArgs = null;
      break;
      bool1 = true;
      bool3 = true;
      bool2 = bool1;
      parama = ((j)g.E(j.class)).YA().arw(str).field_nickname;
      paramVarArgs = com.tencent.mm.plugin.fts.a.d.NA(str);
      bool1 = bool2;
      break;
      this.mYL = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(parama, this.mYP.mRX, bool3, bool1, 400.0F, b.c.mVU)).mSp;
      break label159;
      this.mYL = TextUtils.concat(new CharSequence[] { "\"", TextUtils.ellipsize(com.tencent.mm.plugin.fts.a.d.NA(this.mSN), b.c.mVW, 300.0F, TextUtils.TruncateAt.END), "\"" });
      this.mYM = this.mSN;
      this.mYO = str;
      if (!bo.isNullOrNil(paramVarArgs)) {}
      for (this.mYN = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(parama, this.mYP.mRX, bool3, bool1, b.c.mVU, paramVarArgs + "(", ")")).mSp;; this.mYN = com.tencent.mm.plugin.fts.a.f.a(com.tencent.mm.plugin.fts.a.a.d.a(parama, this.mYP.mRX, bool3, bool1, 400.0F, b.c.mVU)).mSp)
      {
        this.mYN = TextUtils.concat(new CharSequence[] { "\"", this.mYN, paramContext.getString(2131303026) });
        AppMethodBeat.o(61985);
        return;
      }
      bool1 = false;
      break label250;
      bool1 = false;
    }
  }
  
  public final a.a bCW()
  {
    return this.mYR;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.f
 * JD-Core Version:    0.7.0.1
 */
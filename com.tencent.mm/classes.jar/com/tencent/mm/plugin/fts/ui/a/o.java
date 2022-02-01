package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;

public final class o
  extends f
{
  private a rwd;
  
  public o(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112108);
    this.rwd = new a();
    AppMethodBeat.o(112108);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112109);
    String str = this.rvo.roN;
    boolean bool2;
    boolean bool1;
    switch (this.rvo.roM)
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
        this.rvl = str;
        if (bt.isNullOrNil(paramVarArgs)) {
          break;
        }
        this.rvk = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.rvo.roS, bool2, bool1, b.c.rsJ, paramVarArgs + "(", ")")).rpj;
        this.rvk = TextUtils.concat(new CharSequence[] { "\"", this.rvk, paramContext.getString(2131762968) });
        AppMethodBeat.o(112109);
        return;
        bool1 = true;
        bool2 = true;
        parama = d.XV(str);
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
      parama = ((k)g.ab(k.class)).apM().aHY(str).field_nickname;
      paramVarArgs = d.XV(str);
      break;
      this.rvk = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.rvo.roS, bool2, bool1, 400.0F, b.c.rsJ)).rpj;
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
  
  public final a.b acQ()
  {
    return this.rwd;
  }
  
  public final class a
    extends f.a
  {
    public a()
    {
      super();
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112107);
      super.a(paramContext, parama, parama1, paramVarArgs);
      ((f.b)parama).rvw.setVisibility(8);
      AppMethodBeat.o(112107);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.o
 * JD-Core Version:    0.7.0.1
 */
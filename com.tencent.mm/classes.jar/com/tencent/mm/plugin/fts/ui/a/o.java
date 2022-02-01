package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.o.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;

public final class o
  extends f
{
  private a BPC;
  
  public o(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112108);
    this.BPC = new a();
    AppMethodBeat.o(112108);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112109);
    String str = this.BON.BHS;
    boolean bool2;
    boolean bool1;
    switch (this.BON.BHR)
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
        this.BOK = str;
        if (Util.isNullOrNil(paramVarArgs)) {
          break;
        }
        this.BOJ = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.BON.BHY, bool2, bool1, b.c.BLT, paramVarArgs + "(", ")")).BIp;
        this.BOJ = TextUtils.concat(new CharSequence[] { "\"", this.BOJ, paramContext.getString(o.g.search_talker_message_info_3) });
        AppMethodBeat.o(112109);
        return;
        bool1 = true;
        bool2 = true;
        parama = d.azM(str);
        paramVarArgs = null;
      }
    case 7: 
      label136:
      label178:
      label181:
      bool1 = true;
      label195:
      bool2 = true;
    }
    for (;;)
    {
      parama = ((n)h.ae(n.class)).bbL().RG(str).field_nickname;
      paramVarArgs = d.azM(str);
      break;
      this.BOJ = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.BON.BHY, bool2, bool1, 400.0F, b.c.BLT)).BIp;
      break label136;
      bool1 = false;
      break label178;
      bool2 = false;
      bool1 = false;
      break label181;
      bool1 = false;
      break label195;
      bool2 = false;
      bool1 = false;
    }
  }
  
  public final a.b aEw()
  {
    return this.BPC;
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
      ((f.b)parama).BOV.setVisibility(8);
      AppMethodBeat.o(112107);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.o
 * JD-Core Version:    0.7.0.1
 */
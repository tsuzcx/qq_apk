package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.plugin.fts.a.a.g;
import com.tencent.mm.plugin.fts.a.a.o;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.p.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;

public final class r
  extends f
{
  private a HBK;
  
  public r(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112108);
    this.HBK = new a();
    AppMethodBeat.o(112108);
  }
  
  public final void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112109);
    String str = this.HAD.Hsz;
    boolean bool2;
    boolean bool1;
    switch (this.HAD.subtype)
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
        this.HAA = str;
        if (Util.isNullOrNil(paramVarArgs)) {
          break;
        }
        this.HAz = com.tencent.mm.plugin.fts.a.f.a(g.a(parama, this.HAD.FWt, bool2, bool1, b.c.HwP, paramVarArgs + "(", ")")).HsX;
        this.HAz = TextUtils.concat(new CharSequence[] { "\"", this.HAz, paramContext.getString(p.g.search_talker_message_info_3) });
        AppMethodBeat.o(112109);
        return;
        bool1 = true;
        bool2 = true;
        parama = d.atS(str);
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
      parama = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(str).field_nickname;
      paramVarArgs = d.atS(str);
      break;
      this.HAz = com.tencent.mm.plugin.fts.a.f.a(g.a(parama, this.HAD.FWt, bool2, bool1, 400.0F, b.c.HwP)).HsX;
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
  
  public final a.b aXA()
  {
    return this.HBK;
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
      ((f.b)parama).HAL.setVisibility(8);
      AppMethodBeat.o(112107);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.r
 * JD-Core Version:    0.7.0.1
 */
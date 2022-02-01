package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.av;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;

public class f
  extends k
{
  public int cZX;
  protected CharSequence sEc;
  protected String sEd;
  protected CharSequence sEe;
  protected String sEf;
  public com.tencent.mm.plugin.fts.a.a.m sEg;
  private a sEh;
  b sEi;
  public String syB;
  
  public f(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112068);
    this.sEh = new a();
    this.sEi = new b();
    AppMethodBeat.o(112068);
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112069);
    String str = this.sEg.sxG;
    boolean bool2 = false;
    boolean bool1 = false;
    boolean bool5 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    parama = null;
    switch (this.sEg.sxF)
    {
    case 4: 
    default: 
      paramVarArgs = null;
      bool1 = false;
      bool3 = bool4;
      if (this.cZX == 2)
      {
        this.sEd = str;
        if (!bs.isNullOrNil(paramVarArgs))
        {
          this.sEc = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.sEg.sxM, bool3, bool1, b.c.sBD, paramVarArgs + "(", ")")).syd;
          this.sEc = TextUtils.concat(new CharSequence[] { "\"", this.sEc, "\"" });
          this.sEe = TextUtils.concat(new CharSequence[] { "\"", TextUtils.ellipsize(d.acr(this.syB), b.c.sBF, 300.0F, TextUtils.TruncateAt.END), paramContext.getString(2131762968) });
          this.sEf = this.syB;
          AppMethodBeat.o(112069);
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
      parama = d.acr(str);
      paramVarArgs = null;
      break;
      bool1 = true;
      bool3 = true;
      bool2 = bool1;
      parama = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(str).field_nickname;
      paramVarArgs = d.acr(str);
      bool1 = bool2;
      break;
      this.sEc = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.sEg.sxM, bool3, bool1, 400.0F, b.c.sBD)).syd;
      break label159;
      this.sEc = TextUtils.concat(new CharSequence[] { "\"", TextUtils.ellipsize(d.acr(this.syB), b.c.sBF, 300.0F, TextUtils.TruncateAt.END), "\"" });
      this.sEd = this.syB;
      this.sEf = str;
      if (!bs.isNullOrNil(paramVarArgs)) {}
      for (this.sEe = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.sEg.sxM, bool3, bool1, b.c.sBD, paramVarArgs + "(", ")")).syd;; this.sEe = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.sEg.sxM, bool3, bool1, 400.0F, b.c.sBD)).syd)
      {
        this.sEe = TextUtils.concat(new CharSequence[] { "\"", this.sEe, paramContext.getString(2131762968) });
        AppMethodBeat.o(112069);
        return;
      }
      bool1 = false;
      break label250;
      bool1 = false;
    }
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.a.b adW()
  {
    return this.sEh;
  }
  
  public final a.a cLq()
  {
    return this.sEi;
  }
  
  public class a
    extends com.tencent.mm.plugin.fts.a.d.a.a.b
  {
    public a()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(112066);
      paramContext = LayoutInflater.from(paramContext).inflate(2131494194, paramViewGroup, false);
      paramViewGroup = (f.b)f.this.sEi;
      paramViewGroup.sEk = ((TextView)paramContext.findViewById(2131300703));
      paramViewGroup.sEl = ((ImageView)paramContext.findViewById(2131296999));
      paramViewGroup.sEm = ((TextView)paramContext.findViewById(2131300704));
      paramViewGroup.sEn = ((ImageView)paramContext.findViewById(2131297000));
      paramViewGroup.sEo = ((TextView)paramContext.findViewById(2131301013));
      paramViewGroup.contentView = paramContext.findViewById(2131304428);
      paramViewGroup.sEb = paramContext.findViewById(2131303131);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112066);
      return paramContext;
    }
    
    public void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112067);
      paramContext = (f.b)parama;
      com.tencent.mm.plugin.fts.ui.m.a(f.this.sEc, paramContext.sEk);
      com.tencent.mm.pluginsdk.ui.a.b.c(paramContext.sEl, f.this.sEd);
      com.tencent.mm.plugin.fts.ui.m.a(f.this.sEe, paramContext.sEm);
      if (!bs.isNullOrNil(f.this.sEf))
      {
        paramContext.sEn.setVisibility(0);
        com.tencent.mm.pluginsdk.ui.a.b.c(paramContext.sEn, f.this.sEf);
        com.tencent.mm.plugin.fts.ui.m.r(paramContext.contentView, f.this.szt);
        if (f.this.position != 0) {
          break label148;
        }
        paramContext.sEb.setVisibility(8);
      }
      for (;;)
      {
        paramContext.sEo.setVisibility(0);
        AppMethodBeat.o(112067);
        return;
        paramContext.sEn.setVisibility(8);
        break;
        label148:
        paramContext.sEb.setVisibility(0);
      }
    }
    
    public final boolean a(Context paramContext, a paramVarArgs)
    {
      return false;
    }
  }
  
  public final class b
    extends a.a
  {
    public View contentView;
    public View sEb;
    public TextView sEk;
    public ImageView sEl;
    public TextView sEm;
    public ImageView sEn;
    public TextView sEo;
    
    public b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.f
 * JD-Core Version:    0.7.0.1
 */
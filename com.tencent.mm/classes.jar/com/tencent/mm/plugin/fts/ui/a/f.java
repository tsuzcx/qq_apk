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
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;

public class f
  extends k
{
  public int dcz;
  public String rpH;
  protected CharSequence rvk;
  protected String rvl;
  protected CharSequence rvm;
  protected String rvn;
  public com.tencent.mm.plugin.fts.a.a.m rvo;
  private a rvp;
  b rvq;
  
  public f(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112068);
    this.rvp = new a();
    this.rvq = new b();
    AppMethodBeat.o(112068);
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112069);
    String str = this.rvo.roN;
    boolean bool2 = false;
    boolean bool1 = false;
    boolean bool5 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    parama = null;
    switch (this.rvo.roM)
    {
    case 4: 
    default: 
      paramVarArgs = null;
      bool1 = false;
      bool3 = bool4;
      if (this.dcz == 2)
      {
        this.rvl = str;
        if (!bt.isNullOrNil(paramVarArgs))
        {
          this.rvk = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.rvo.roS, bool3, bool1, b.c.rsJ, paramVarArgs + "(", ")")).rpj;
          this.rvk = TextUtils.concat(new CharSequence[] { "\"", this.rvk, "\"" });
          this.rvm = TextUtils.concat(new CharSequence[] { "\"", TextUtils.ellipsize(d.XV(this.rpH), b.c.rsL, 300.0F, TextUtils.TruncateAt.END), paramContext.getString(2131762968) });
          this.rvn = this.rpH;
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
      parama = d.XV(str);
      paramVarArgs = null;
      break;
      bool1 = true;
      bool3 = true;
      bool2 = bool1;
      parama = ((com.tencent.mm.plugin.messenger.foundation.a.k)g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(str).field_nickname;
      paramVarArgs = d.XV(str);
      bool1 = bool2;
      break;
      this.rvk = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.rvo.roS, bool3, bool1, 400.0F, b.c.rsJ)).rpj;
      break label159;
      this.rvk = TextUtils.concat(new CharSequence[] { "\"", TextUtils.ellipsize(d.XV(this.rpH), b.c.rsL, 300.0F, TextUtils.TruncateAt.END), "\"" });
      this.rvl = this.rpH;
      this.rvn = str;
      if (!bt.isNullOrNil(paramVarArgs)) {}
      for (this.rvm = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.rvo.roS, bool3, bool1, b.c.rsJ, paramVarArgs + "(", ")")).rpj;; this.rvm = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.rvo.roS, bool3, bool1, 400.0F, b.c.rsJ)).rpj)
      {
        this.rvm = TextUtils.concat(new CharSequence[] { "\"", this.rvm, paramContext.getString(2131762968) });
        AppMethodBeat.o(112069);
        return;
      }
      bool1 = false;
      break label250;
      bool1 = false;
    }
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.a.b acQ()
  {
    return this.rvp;
  }
  
  public final a.a cye()
  {
    return this.rvq;
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
      paramViewGroup = (f.b)f.this.rvq;
      paramViewGroup.rvs = ((TextView)paramContext.findViewById(2131300703));
      paramViewGroup.rvt = ((ImageView)paramContext.findViewById(2131296999));
      paramViewGroup.rvu = ((TextView)paramContext.findViewById(2131300704));
      paramViewGroup.rvv = ((ImageView)paramContext.findViewById(2131297000));
      paramViewGroup.rvw = ((TextView)paramContext.findViewById(2131301013));
      paramViewGroup.contentView = paramContext.findViewById(2131304428);
      paramViewGroup.rvj = paramContext.findViewById(2131303131);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112066);
      return paramContext;
    }
    
    public void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112067);
      paramContext = (f.b)parama;
      com.tencent.mm.plugin.fts.ui.m.a(f.this.rvk, paramContext.rvs);
      com.tencent.mm.pluginsdk.ui.a.b.c(paramContext.rvt, f.this.rvl);
      com.tencent.mm.plugin.fts.ui.m.a(f.this.rvm, paramContext.rvu);
      if (!bt.isNullOrNil(f.this.rvn))
      {
        paramContext.rvv.setVisibility(0);
        com.tencent.mm.pluginsdk.ui.a.b.c(paramContext.rvv, f.this.rvn);
        com.tencent.mm.plugin.fts.ui.m.r(paramContext.contentView, f.this.rqz);
        if (f.this.position != 0) {
          break label148;
        }
        paramContext.rvj.setVisibility(8);
      }
      for (;;)
      {
        paramContext.rvw.setVisibility(0);
        AppMethodBeat.o(112067);
        return;
        paramContext.rvv.setVisibility(8);
        break;
        label148:
        paramContext.rvj.setVisibility(0);
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
    public View rvj;
    public TextView rvs;
    public ImageView rvt;
    public TextView rvu;
    public ImageView rvv;
    public TextView rvw;
    
    public b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.f
 * JD-Core Version:    0.7.0.1
 */
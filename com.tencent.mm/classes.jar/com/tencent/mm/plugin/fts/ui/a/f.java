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
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;

public class f
  extends k
{
  public int dDG;
  public String wWS;
  protected CharSequence xcL;
  protected String xcM;
  protected CharSequence xcN;
  protected String xcO;
  public m xcP;
  private a xcQ;
  b xcR;
  
  public f(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112068);
    this.xcQ = new a();
    this.xcR = new b();
    AppMethodBeat.o(112068);
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112069);
    String str = this.xcP.wVX;
    boolean bool2 = false;
    boolean bool1 = false;
    boolean bool5 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    parama = null;
    switch (this.xcP.wVW)
    {
    case 4: 
    default: 
      paramVarArgs = null;
      bool1 = false;
      bool3 = bool4;
      if (this.dDG == 2)
      {
        this.xcM = str;
        if (!Util.isNullOrNil(paramVarArgs))
        {
          this.xcL = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.xcP.wWd, bool3, bool1, b.c.wZU, paramVarArgs + "(", ")")).wWu;
          this.xcL = TextUtils.concat(new CharSequence[] { "\"", this.xcL, "\"" });
          this.xcN = TextUtils.concat(new CharSequence[] { "\"", TextUtils.ellipsize(d.arL(this.wWS), b.c.wZW, 300.0F, TextUtils.TruncateAt.END), paramContext.getString(2131765105) });
          this.xcO = this.wWS;
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
      parama = d.arL(str);
      paramVarArgs = null;
      break;
      bool1 = true;
      bool3 = true;
      bool2 = bool1;
      parama = ((l)g.af(l.class)).aSN().Kn(str).field_nickname;
      paramVarArgs = d.arL(str);
      bool1 = bool2;
      break;
      this.xcL = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.xcP.wWd, bool3, bool1, 400.0F, b.c.wZU)).wWu;
      break label159;
      this.xcL = TextUtils.concat(new CharSequence[] { "\"", TextUtils.ellipsize(d.arL(this.wWS), b.c.wZW, 300.0F, TextUtils.TruncateAt.END), "\"" });
      this.xcM = this.wWS;
      this.xcO = str;
      if (!Util.isNullOrNil(paramVarArgs)) {}
      for (this.xcN = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.xcP.wWd, bool3, bool1, b.c.wZU, paramVarArgs + "(", ")")).wWu;; this.xcN = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.xcP.wWd, bool3, bool1, 400.0F, b.c.wZU)).wWu)
      {
        this.xcN = TextUtils.concat(new CharSequence[] { "\"", this.xcN, paramContext.getString(2131765105) });
        AppMethodBeat.o(112069);
        return;
      }
      bool1 = false;
      break label250;
      bool1 = false;
    }
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.a.b axc()
  {
    return this.xcQ;
  }
  
  public final a.a dPz()
  {
    return this.xcR;
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131494747, paramViewGroup, false);
      paramViewGroup = (f.b)f.this.xcR;
      paramViewGroup.xcT = ((TextView)paramContext.findViewById(2131302275));
      paramViewGroup.xcU = ((ImageView)paramContext.findViewById(2131297122));
      paramViewGroup.xcV = ((TextView)paramContext.findViewById(2131302276));
      paramViewGroup.xcW = ((ImageView)paramContext.findViewById(2131297124));
      paramViewGroup.xcX = ((TextView)paramContext.findViewById(2131302657));
      paramViewGroup.contentView = paramContext.findViewById(2131307399);
      paramViewGroup.xcK = paramContext.findViewById(2131305768);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112066);
      return paramContext;
    }
    
    public void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112067);
      paramContext = (f.b)parama;
      n.a(f.this.xcL, paramContext.xcT);
      com.tencent.mm.pluginsdk.ui.a.b.c(paramContext.xcU, f.this.xcM);
      n.a(f.this.xcN, paramContext.xcV);
      if (!Util.isNullOrNil(f.this.xcO))
      {
        paramContext.xcW.setVisibility(0);
        com.tencent.mm.pluginsdk.ui.a.b.c(paramContext.xcW, f.this.xcO);
        n.s(paramContext.contentView, f.this.wXK);
        if (f.this.position != 0) {
          break label148;
        }
        paramContext.xcK.setVisibility(8);
      }
      for (;;)
      {
        paramContext.xcX.setVisibility(0);
        AppMethodBeat.o(112067);
        return;
        paramContext.xcW.setVisibility(8);
        break;
        label148:
        paramContext.xcK.setVisibility(0);
      }
    }
    
    public final boolean a(Context paramContext, View paramView, a paramVarArgs)
    {
      return false;
    }
  }
  
  public final class b
    extends a.a
  {
    public View contentView;
    public View xcK;
    public TextView xcT;
    public ImageView xcU;
    public TextView xcV;
    public ImageView xcW;
    public TextView xcX;
    
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
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
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.fts.a.a.e;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.b.c;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;

public class f
  extends k
{
  public int dlp;
  protected CharSequence tAT;
  protected String tAU;
  protected CharSequence tAV;
  protected String tAW;
  public m tAX;
  private a tAY;
  b tAZ;
  public String tvc;
  
  public f(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112068);
    this.tAY = new a();
    this.tAZ = new b();
    AppMethodBeat.o(112068);
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112069);
    String str = this.tAX.tuh;
    boolean bool2 = false;
    boolean bool1 = false;
    boolean bool5 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    parama = null;
    switch (this.tAX.tug)
    {
    case 4: 
    default: 
      paramVarArgs = null;
      bool1 = false;
      bool3 = bool4;
      if (this.dlp == 2)
      {
        this.tAU = str;
        if (!bt.isNullOrNil(paramVarArgs))
        {
          this.tAT = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.tAX.tun, bool3, bool1, b.c.tye, paramVarArgs + "(", ")")).tuE;
          this.tAT = TextUtils.concat(new CharSequence[] { "\"", this.tAT, "\"" });
          this.tAV = TextUtils.concat(new CharSequence[] { "\"", TextUtils.ellipsize(d.agg(this.tvc), b.c.tyg, 300.0F, TextUtils.TruncateAt.END), paramContext.getString(2131762968) });
          this.tAW = this.tvc;
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
      parama = d.agg(str);
      paramVarArgs = null;
      break;
      bool1 = true;
      bool3 = true;
      bool2 = bool1;
      parama = ((l)g.ab(l.class)).azp().Bf(str).field_nickname;
      paramVarArgs = d.agg(str);
      bool1 = bool2;
      break;
      this.tAT = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.tAX.tun, bool3, bool1, 400.0F, b.c.tye)).tuE;
      break label159;
      this.tAT = TextUtils.concat(new CharSequence[] { "\"", TextUtils.ellipsize(d.agg(this.tvc), b.c.tyg, 300.0F, TextUtils.TruncateAt.END), "\"" });
      this.tAU = this.tvc;
      this.tAW = str;
      if (!bt.isNullOrNil(paramVarArgs)) {}
      for (this.tAV = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.tAX.tun, bool3, bool1, b.c.tye, paramVarArgs + "(", ")")).tuE;; this.tAV = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.tAX.tun, bool3, bool1, 400.0F, b.c.tye)).tuE)
      {
        this.tAV = TextUtils.concat(new CharSequence[] { "\"", this.tAV, paramContext.getString(2131762968) });
        AppMethodBeat.o(112069);
        return;
      }
      bool1 = false;
      break label250;
      bool1 = false;
    }
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.a.b agC()
  {
    return this.tAY;
  }
  
  public final a.a cTJ()
  {
    return this.tAZ;
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
      paramViewGroup = (f.b)f.this.tAZ;
      paramViewGroup.tBb = ((TextView)paramContext.findViewById(2131300703));
      paramViewGroup.tBc = ((ImageView)paramContext.findViewById(2131296999));
      paramViewGroup.tBd = ((TextView)paramContext.findViewById(2131300704));
      paramViewGroup.tBe = ((ImageView)paramContext.findViewById(2131297000));
      paramViewGroup.tBf = ((TextView)paramContext.findViewById(2131301013));
      paramViewGroup.contentView = paramContext.findViewById(2131304428);
      paramViewGroup.tAS = paramContext.findViewById(2131303131);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112066);
      return paramContext;
    }
    
    public void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112067);
      paramContext = (f.b)parama;
      n.a(f.this.tAT, paramContext.tBb);
      com.tencent.mm.pluginsdk.ui.a.b.c(paramContext.tBc, f.this.tAU);
      n.a(f.this.tAV, paramContext.tBd);
      if (!bt.isNullOrNil(f.this.tAW))
      {
        paramContext.tBe.setVisibility(0);
        com.tencent.mm.pluginsdk.ui.a.b.c(paramContext.tBe, f.this.tAW);
        n.r(paramContext.contentView, f.this.tvU);
        if (f.this.position != 0) {
          break label148;
        }
        paramContext.tAS.setVisibility(8);
      }
      for (;;)
      {
        paramContext.tBf.setVisibility(0);
        AppMethodBeat.o(112067);
        return;
        paramContext.tBe.setVisibility(8);
        break;
        label148:
        paramContext.tAS.setVisibility(0);
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
    public View tAS;
    public TextView tBb;
    public ImageView tBc;
    public TextView tBd;
    public ImageView tBe;
    public TextView tBf;
    
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
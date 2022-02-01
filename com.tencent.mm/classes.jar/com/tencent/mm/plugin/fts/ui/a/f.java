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
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;

public class f
  extends k
{
  public int dmr;
  public String tFT;
  protected CharSequence tLK;
  protected String tLL;
  protected CharSequence tLM;
  protected String tLN;
  public m tLO;
  private a tLP;
  b tLQ;
  
  public f(int paramInt)
  {
    super(paramInt);
    AppMethodBeat.i(112068);
    this.tLP = new a();
    this.tLQ = new b();
    AppMethodBeat.o(112068);
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    AppMethodBeat.i(112069);
    String str = this.tLO.tEY;
    boolean bool2 = false;
    boolean bool1 = false;
    boolean bool5 = false;
    boolean bool3 = false;
    boolean bool4 = false;
    parama = null;
    switch (this.tLO.tEX)
    {
    case 4: 
    default: 
      paramVarArgs = null;
      bool1 = false;
      bool3 = bool4;
      if (this.dmr == 2)
      {
        this.tLL = str;
        if (!bu.isNullOrNil(paramVarArgs))
        {
          this.tLK = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.tLO.tFe, bool3, bool1, b.c.tIV, paramVarArgs + "(", ")")).tFv;
          this.tLK = TextUtils.concat(new CharSequence[] { "\"", this.tLK, "\"" });
          this.tLM = TextUtils.concat(new CharSequence[] { "\"", TextUtils.ellipsize(d.ahd(this.tFT), b.c.tIX, 300.0F, TextUtils.TruncateAt.END), paramContext.getString(2131762968) });
          this.tLN = this.tFT;
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
      parama = d.ahd(str);
      paramVarArgs = null;
      break;
      bool1 = true;
      bool3 = true;
      bool2 = bool1;
      parama = ((l)g.ab(l.class)).azF().BH(str).field_nickname;
      paramVarArgs = d.ahd(str);
      bool1 = bool2;
      break;
      this.tLK = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.tLO.tFe, bool3, bool1, 400.0F, b.c.tIV)).tFv;
      break label159;
      this.tLK = TextUtils.concat(new CharSequence[] { "\"", TextUtils.ellipsize(d.ahd(this.tFT), b.c.tIX, 300.0F, TextUtils.TruncateAt.END), "\"" });
      this.tLL = this.tFT;
      this.tLN = str;
      if (!bu.isNullOrNil(paramVarArgs)) {}
      for (this.tLM = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.tLO.tFe, bool3, bool1, b.c.tIV, paramVarArgs + "(", ")")).tFv;; this.tLM = com.tencent.mm.plugin.fts.a.f.a(e.a(parama, this.tLO.tFe, bool3, bool1, 400.0F, b.c.tIV)).tFv)
      {
        this.tLM = TextUtils.concat(new CharSequence[] { "\"", this.tLM, paramContext.getString(2131762968) });
        AppMethodBeat.o(112069);
        return;
      }
      bool1 = false;
      break label250;
      bool1 = false;
    }
  }
  
  public com.tencent.mm.plugin.fts.a.d.a.a.b agQ()
  {
    return this.tLP;
  }
  
  public final a.a cWo()
  {
    return this.tLQ;
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
      paramViewGroup = (f.b)f.this.tLQ;
      paramViewGroup.tLS = ((TextView)paramContext.findViewById(2131300703));
      paramViewGroup.tLT = ((ImageView)paramContext.findViewById(2131296999));
      paramViewGroup.tLU = ((TextView)paramContext.findViewById(2131300704));
      paramViewGroup.tLV = ((ImageView)paramContext.findViewById(2131297000));
      paramViewGroup.tLW = ((TextView)paramContext.findViewById(2131301013));
      paramViewGroup.contentView = paramContext.findViewById(2131304428);
      paramViewGroup.tLJ = paramContext.findViewById(2131303131);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112066);
      return paramContext;
    }
    
    public void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112067);
      paramContext = (f.b)parama;
      n.a(f.this.tLK, paramContext.tLS);
      com.tencent.mm.pluginsdk.ui.a.b.c(paramContext.tLT, f.this.tLL);
      n.a(f.this.tLM, paramContext.tLU);
      if (!bu.isNullOrNil(f.this.tLN))
      {
        paramContext.tLV.setVisibility(0);
        com.tencent.mm.pluginsdk.ui.a.b.c(paramContext.tLV, f.this.tLN);
        n.r(paramContext.contentView, f.this.tGL);
        if (f.this.position != 0) {
          break label148;
        }
        paramContext.tLJ.setVisibility(8);
      }
      for (;;)
      {
        paramContext.tLW.setVisibility(0);
        AppMethodBeat.o(112067);
        return;
        paramContext.tLV.setVisibility(8);
        break;
        label148:
        paramContext.tLJ.setVisibility(0);
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
    public View tLJ;
    public TextView tLS;
    public ImageView tLT;
    public TextView tLU;
    public ImageView tLV;
    public TextView tLW;
    
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
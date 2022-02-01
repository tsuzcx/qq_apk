package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fts.a.a.j;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.b;
import com.tencent.mm.plugin.fts.ui.l;
import com.tencent.mm.plugin.fts.ui.o;
import com.tencent.mm.plugin.fts.ui.o.1;
import com.tencent.mm.plugin.fts.ui.p.d;
import com.tencent.mm.plugin.fts.ui.p.e;
import com.tencent.mm.plugin.fts.ui.p.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;

public class k
  extends a
{
  public String HBc;
  public View.OnClickListener HBd;
  private b HBe;
  private a HBf;
  public String header;
  
  public k(int paramInt)
  {
    super(0, paramInt);
    AppMethodBeat.i(112091);
    this.HBe = new b();
    this.HBf = new a();
    AppMethodBeat.o(112091);
  }
  
  public void a(Context paramContext, a.a parama, Object... paramVarArgs)
  {
    parama = null;
    AppMethodBeat.i(112092);
    this.header = Util.nullAs(o.Wp(this.xVf), "");
    int i;
    if (this.pageType == 2) {
      switch (this.xVf)
      {
      default: 
        i = 0;
        if (i == 0)
        {
          paramContext = null;
          label62:
          this.HBc = Util.nullAs(paramContext, "");
          i = this.xVf;
          paramContext = this.FWt.Hte;
          switch (i)
          {
          }
        }
        break;
      }
    }
    for (paramContext = parama;; paramContext = new o.1(paramContext))
    {
      this.HBd = paramContext;
      Log.i("MicroMsg.FTS.FTSHeaderDataItem", "fillingDataItem: header=%s", new Object[] { this.header });
      AppMethodBeat.o(112092);
      return;
      i = p.g.app_manage;
      break;
      paramContext = MMApplicationContext.getContext().getString(i);
      break label62;
    }
  }
  
  public a.b aXA()
  {
    return this.HBe;
  }
  
  public a.a fyW()
  {
    return this.HBf;
  }
  
  public final class a
    extends a.a
  {
    public View HAy;
    public TextView HBg;
    public View contentView;
    public TextView wSo;
    
    public a()
    {
      super();
    }
  }
  
  public final class b
    extends a.b
  {
    public b()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(112089);
      paramContext = LayoutInflater.from(paramContext).inflate(p.e.fts_header_item, paramViewGroup, false);
      paramViewGroup = (k.a)k.this.fyW();
      paramViewGroup.wSo = ((TextView)paramContext.findViewById(p.d.header_tv));
      paramViewGroup.HBg = ((TextView)paramContext.findViewById(p.d.header_manager));
      paramViewGroup.HAy = paramContext.findViewById(p.d.padding_view);
      paramViewGroup.contentView = paramContext.findViewById(p.d.search_item_content_layout);
      paramContext.setTag(paramViewGroup);
      AppMethodBeat.o(112089);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      AppMethodBeat.i(112090);
      paramContext = (k.a)parama;
      o.b(k.this.header, paramContext.wSo);
      o.b(k.this.HBc, paramContext.HBg);
      if ((paramContext.HBg != null) && (k.this.HBd != null))
      {
        paramContext.HBg.setOnClickListener(k.this.HBd);
        l.bY(1, k.this.FWt.Hte);
      }
      if (k.this.position == 0) {
        paramContext.HAy.setVisibility(8);
      }
      for (;;)
      {
        o.y(paramContext.contentView, k.this.Hup);
        AppMethodBeat.o(112090);
        return;
        paramContext.HAy.setVisibility(0);
      }
    }
    
    public final boolean a(Context paramContext, View paramView, a paramVarArgs)
    {
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.k
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.fts.ui.b;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.p.d;
import com.tencent.mm.plugin.fts.ui.p.e;
import com.tencent.mm.storage.au;

public abstract class b
  extends a
{
  public String Buk;
  a HAk = new a();
  public au contact;
  public com.tencent.mm.plugin.fts.a.a.o rpp;
  public String username;
  public CharSequence vFf;
  public CharSequence vFg;
  
  public b(int paramInt)
  {
    super(1, paramInt);
  }
  
  public final int coC()
  {
    return this.rpp.HtS;
  }
  
  public final class a
    extends a.a
  {
    public TextView Bun;
    public ImageView lBC;
    public TextView pJJ;
    public TextView plr;
    public View rpv;
    
    public a()
    {
      super();
    }
  }
  
  public abstract class b
    extends com.tencent.mm.plugin.fts.a.d.a.a.b
  {
    public b()
    {
      super();
    }
    
    public final View a(Context paramContext, ViewGroup paramViewGroup)
    {
      paramContext = LayoutInflater.from(paramContext).inflate(p.e.fts_contact_item, paramViewGroup, false);
      paramViewGroup = (b.a)b.this.HAk;
      paramViewGroup.lBC = ((ImageView)paramContext.findViewById(p.d.avatar_iv));
      paramViewGroup.pJJ = ((TextView)paramContext.findViewById(p.d.title_tv));
      paramViewGroup.plr = ((TextView)paramContext.findViewById(p.d.desc_tv));
      paramViewGroup.Bun = ((TextView)paramContext.findViewById(p.d.item_desc_tv));
      paramViewGroup.rpv = paramContext.findViewById(p.d.divider);
      paramContext.setTag(paramViewGroup);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      paramContext = (b.a)parama;
      parama = (b)parama1;
      com.tencent.mm.plugin.fts.ui.o.w(paramContext.rpv, b.this.Hup);
      com.tencent.mm.pluginsdk.ui.a.b.g(paramContext.lBC, parama.username);
      com.tencent.mm.plugin.fts.ui.o.a(parama.vFf, paramContext.pJJ);
      com.tencent.mm.plugin.fts.ui.o.a(parama.vFg, paramContext.plr);
      com.tencent.mm.plugin.fts.ui.o.b(parama.Buk, paramContext.Bun);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.b.b
 * JD-Core Version:    0.7.0.1
 */
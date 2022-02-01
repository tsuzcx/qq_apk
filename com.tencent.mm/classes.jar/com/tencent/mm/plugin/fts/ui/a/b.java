package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.a.m;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.plugin.fts.ui.n;
import com.tencent.mm.plugin.fts.ui.o.d;
import com.tencent.mm.plugin.fts.ui.o.e;
import com.tencent.mm.storage.as;

public abstract class b
  extends a
{
  public String BOs;
  a BOt = new a();
  public as contact;
  public m olG;
  public CharSequence szA;
  public CharSequence szB;
  public String username;
  
  public b(int paramInt)
  {
    super(1, paramInt);
  }
  
  public final int bOn()
  {
    return this.olG.BJj;
  }
  
  public final class a
    extends a.a
  {
    TextView BOu;
    public ImageView iZG;
    public TextView mNb;
    public TextView mrM;
    public View olM;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(o.e.fts_contact_item, paramViewGroup, false);
      paramViewGroup = (b.a)b.this.BOt;
      paramViewGroup.iZG = ((ImageView)paramContext.findViewById(o.d.avatar_iv));
      paramViewGroup.mNb = ((TextView)paramContext.findViewById(o.d.title_tv));
      paramViewGroup.mrM = ((TextView)paramContext.findViewById(o.d.desc_tv));
      paramViewGroup.BOu = ((TextView)paramContext.findViewById(o.d.item_desc_tv));
      paramViewGroup.olM = paramContext.findViewById(o.d.divider);
      paramContext.setTag(paramViewGroup);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      paramContext = (b.a)parama;
      parama = (b)parama1;
      n.q(paramContext.olM, b.this.BJG);
      com.tencent.mm.pluginsdk.ui.a.b.c(paramContext.iZG, parama.username);
      n.a(parama.szA, paramContext.mNb);
      n.a(parama.szB, paramContext.mrM);
      n.a(parama.BOs, paramContext.BOu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.b
 * JD-Core Version:    0.7.0.1
 */
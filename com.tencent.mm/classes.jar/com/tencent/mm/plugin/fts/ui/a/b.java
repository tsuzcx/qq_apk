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
import com.tencent.mm.storage.an;

public abstract class b
  extends a
{
  public an contact;
  public m kno;
  public CharSequence ofE;
  public CharSequence ofF;
  public String tLt;
  a tLu = new a();
  public String username;
  
  public b(int paramInt)
  {
    super(1, paramInt);
  }
  
  public final int bhE()
  {
    return this.kno.tGo;
  }
  
  public final class a
    extends a.a
  {
    public ImageView fQl;
    public TextView iFO;
    public TextView iYj;
    public View knu;
    TextView tLv;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131494192, paramViewGroup, false);
      paramViewGroup = (b.a)b.this.tLu;
      paramViewGroup.fQl = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.iYj = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.iFO = ((TextView)paramContext.findViewById(2131299008));
      paramViewGroup.tLv = ((TextView)paramContext.findViewById(2131301150));
      paramViewGroup.knu = paramContext.findViewById(2131299154);
      paramContext.setTag(paramViewGroup);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      paramContext = (b.a)parama;
      parama = (b)parama1;
      n.p(paramContext.knu, b.this.tGL);
      com.tencent.mm.pluginsdk.ui.a.b.c(paramContext.fQl, parama.username);
      n.a(parama.ofE, paramContext.iYj);
      n.a(parama.ofF, paramContext.iFO);
      n.a(parama.tLt, paramContext.tLv);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.b
 * JD-Core Version:    0.7.0.1
 */
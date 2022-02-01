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
import com.tencent.mm.storage.am;

public abstract class b
  extends a
{
  public am contact;
  public m kjY;
  public CharSequence nZU;
  public CharSequence nZV;
  public String tAC;
  a tAD = new a();
  public String username;
  
  public b(int paramInt)
  {
    super(1, paramInt);
  }
  
  public final int bgW()
  {
    return this.kjY.tvx;
  }
  
  public final class a
    extends a.a
  {
    public ImageView fOf;
    public TextView iCV;
    public TextView iVq;
    public View kke;
    TextView tAE;
    
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
      paramViewGroup = (b.a)b.this.tAD;
      paramViewGroup.fOf = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.iVq = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.iCV = ((TextView)paramContext.findViewById(2131299008));
      paramViewGroup.tAE = ((TextView)paramContext.findViewById(2131301150));
      paramViewGroup.kke = paramContext.findViewById(2131299154);
      paramContext.setTag(paramViewGroup);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      paramContext = (b.a)parama;
      parama = (b)parama1;
      n.p(paramContext.kke, b.this.tvU);
      com.tencent.mm.pluginsdk.ui.a.b.c(paramContext.fOf, parama.username);
      n.a(parama.nZU, paramContext.iVq);
      n.a(parama.nZV, paramContext.iCV);
      n.a(parama.tAC, paramContext.tAE);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.b
 * JD-Core Version:    0.7.0.1
 */
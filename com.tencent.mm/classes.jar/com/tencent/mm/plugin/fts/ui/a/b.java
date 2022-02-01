package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.storage.af;

public abstract class b
  extends a
{
  public af contact;
  public com.tencent.mm.plugin.fts.a.a.m jpy;
  public CharSequence mVX;
  public CharSequence mVY;
  public String ruV;
  a ruW = new a();
  public String username;
  
  public b(int paramInt)
  {
    super(1, paramInt);
  }
  
  public final int aWu()
  {
    return this.jpy.rqc;
  }
  
  public final class a
    extends a.a
  {
    public ImageView frr;
    public TextView hJe;
    public TextView ica;
    public View jpE;
    TextView ruX;
    
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
      paramViewGroup = (b.a)b.this.ruW;
      paramViewGroup.frr = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.ica = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.hJe = ((TextView)paramContext.findViewById(2131299008));
      paramViewGroup.ruX = ((TextView)paramContext.findViewById(2131301150));
      paramViewGroup.jpE = paramContext.findViewById(2131299154);
      paramContext.setTag(paramViewGroup);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      paramContext = (b.a)parama;
      parama = (b)parama1;
      com.tencent.mm.plugin.fts.ui.m.p(paramContext.jpE, b.this.rqz);
      com.tencent.mm.pluginsdk.ui.a.b.c(paramContext.frr, parama.username);
      com.tencent.mm.plugin.fts.ui.m.a(parama.mVX, paramContext.ica);
      com.tencent.mm.plugin.fts.ui.m.a(parama.mVY, paramContext.hJe);
      com.tencent.mm.plugin.fts.ui.m.a(parama.ruV, paramContext.ruX);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.b
 * JD-Core Version:    0.7.0.1
 */
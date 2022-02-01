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
import com.tencent.mm.storage.as;

public abstract class b
  extends a
{
  public as contact;
  public m lqW;
  public CharSequence pqB;
  public CharSequence pqC;
  public String username;
  public String xcu;
  a xcv = new a();
  
  public b(int paramInt)
  {
    super(1, paramInt);
  }
  
  public final int bCS()
  {
    return this.lqW.wXn;
  }
  
  public final class a
    extends a.a
  {
    public ImageView gvv;
    public TextView jBR;
    public TextView jVO;
    public View lrc;
    TextView xcw;
    
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
      paramContext = LayoutInflater.from(paramContext).inflate(2131494744, paramViewGroup, false);
      paramViewGroup = (b.a)b.this.xcv;
      paramViewGroup.gvv = ((ImageView)paramContext.findViewById(2131297134));
      paramViewGroup.jVO = ((TextView)paramContext.findViewById(2131309249));
      paramViewGroup.jBR = ((TextView)paramContext.findViewById(2131299510));
      paramViewGroup.xcw = ((TextView)paramContext.findViewById(2131302806));
      paramViewGroup.lrc = paramContext.findViewById(2131299682);
      paramContext.setTag(paramViewGroup);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      paramContext = (b.a)parama;
      parama = (b)parama1;
      n.q(paramContext.lrc, b.this.wXK);
      com.tencent.mm.pluginsdk.ui.a.b.c(paramContext.gvv, parama.username);
      n.a(parama.pqB, paramContext.jVO);
      n.a(parama.pqC, paramContext.jBR);
      n.b(parama.xcu, paramContext.xcw);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.b
 * JD-Core Version:    0.7.0.1
 */
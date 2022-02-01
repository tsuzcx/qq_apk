package com.tencent.mm.plugin.fts.ui.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.fts.a.d.a.a;
import com.tencent.mm.plugin.fts.a.d.a.a.a;
import com.tencent.mm.storage.ai;

public abstract class b
  extends a
{
  public ai contact;
  public com.tencent.mm.plugin.fts.a.a.m jPN;
  public CharSequence nyw;
  public CharSequence nyx;
  public String sDN;
  a sDO = new a();
  public String username;
  
  public b(int paramInt)
  {
    super(1, paramInt);
  }
  
  public final int bds()
  {
    return this.jPN.syW;
  }
  
  public final class a
    extends a.a
  {
    public ImageView fuY;
    public TextView iCg;
    public TextView ijE;
    public View jPT;
    TextView sDP;
    
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
      paramViewGroup = (b.a)b.this.sDO;
      paramViewGroup.fuY = ((ImageView)paramContext.findViewById(2131297008));
      paramViewGroup.iCg = ((TextView)paramContext.findViewById(2131305948));
      paramViewGroup.ijE = ((TextView)paramContext.findViewById(2131299008));
      paramViewGroup.sDP = ((TextView)paramContext.findViewById(2131301150));
      paramViewGroup.jPT = paramContext.findViewById(2131299154);
      paramContext.setTag(paramViewGroup);
      return paramContext;
    }
    
    public final void a(Context paramContext, a.a parama, a parama1, Object... paramVarArgs)
    {
      paramContext = (b.a)parama;
      parama = (b)parama1;
      com.tencent.mm.plugin.fts.ui.m.p(paramContext.jPT, b.this.szt);
      com.tencent.mm.pluginsdk.ui.a.b.c(paramContext.fuY, parama.username);
      com.tencent.mm.plugin.fts.ui.m.a(parama.nyw, paramContext.iCg);
      com.tencent.mm.plugin.fts.ui.m.a(parama.nyx, paramContext.ijE);
      com.tencent.mm.plugin.fts.ui.m.a(parama.sDN, paramContext.sDP);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fts.ui.a.b
 * JD-Core Version:    0.7.0.1
 */
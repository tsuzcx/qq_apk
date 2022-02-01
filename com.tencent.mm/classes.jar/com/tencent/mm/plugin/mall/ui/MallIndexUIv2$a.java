package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.newtips.a.a;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.protocal.protobuf.dnc;

abstract class MallIndexUIv2$a
  implements a
{
  private Context context;
  protected ImageView vGj;
  protected TextView vGk;
  
  public MallIndexUIv2$a(MallIndexUIv2 paramMallIndexUIv2, Context paramContext, View paramView)
  {
    this.context = paramContext;
    es(paramView);
  }
  
  public final void a(k paramk, boolean paramBoolean)
  {
    g.a(this, paramk, paramBoolean);
  }
  
  public final boolean a(boolean paramBoolean, dnc paramdnc)
  {
    return false;
  }
  
  public final boolean b(boolean paramBoolean, dnc paramdnc)
  {
    return false;
  }
  
  public final boolean c(boolean paramBoolean, dnc paramdnc)
  {
    return false;
  }
  
  public final boolean d(boolean paramBoolean, dnc paramdnc)
  {
    if (paramBoolean)
    {
      this.vGk.setVisibility(0);
      String str = paramdnc.hgh;
      if (paramdnc.hgh > 99) {
        str = this.context.getString(2131764343);
      }
      this.vGk.setText(str);
    }
    for (;;)
    {
      return true;
      this.vGk.setVisibility(8);
    }
  }
  
  public final boolean dkD()
  {
    return false;
  }
  
  public abstract void es(View paramView);
  
  public final boolean ol(boolean paramBoolean)
  {
    return g.a(paramBoolean, this);
  }
  
  public final boolean om(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.vGj.setVisibility(0);
    }
    for (;;)
    {
      return true;
      this.vGj.setVisibility(8);
    }
  }
  
  public final boolean on(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.vGk.setVisibility(0);
      this.vGk.setText(this.context.getString(2131755829));
    }
    for (;;)
    {
      return true;
      this.vGk.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUIv2.a
 * JD-Core Version:    0.7.0.1
 */
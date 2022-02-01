package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.newtips.a.a;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.protocal.protobuf.dnz;

abstract class MallIndexUIv2$a
  implements a
{
  private Context context;
  protected ImageView vSn;
  protected TextView vSo;
  
  public MallIndexUIv2$a(MallIndexUIv2 paramMallIndexUIv2, Context paramContext, View paramView)
  {
    this.context = paramContext;
    es(paramView);
  }
  
  public final void a(k paramk, boolean paramBoolean)
  {
    g.a(this, paramk, paramBoolean);
  }
  
  public final boolean a(boolean paramBoolean, dnz paramdnz)
  {
    return false;
  }
  
  public final boolean b(boolean paramBoolean, dnz paramdnz)
  {
    return false;
  }
  
  public final boolean c(boolean paramBoolean, dnz paramdnz)
  {
    return false;
  }
  
  public final boolean d(boolean paramBoolean, dnz paramdnz)
  {
    if (paramBoolean)
    {
      this.vSo.setVisibility(0);
      String str = paramdnz.hiV;
      if (paramdnz.hiV > 99) {
        str = this.context.getString(2131764343);
      }
      this.vSo.setText(str);
    }
    for (;;)
    {
      return true;
      this.vSo.setVisibility(8);
    }
  }
  
  public final boolean dnD()
  {
    return false;
  }
  
  public abstract void es(View paramView);
  
  public final boolean oq(boolean paramBoolean)
  {
    return g.a(paramBoolean, this);
  }
  
  public final boolean or(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.vSn.setVisibility(0);
    }
    for (;;)
    {
      return true;
      this.vSn.setVisibility(8);
    }
  }
  
  public final boolean os(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.vSo.setVisibility(0);
      this.vSo.setText(this.context.getString(2131755829));
    }
    for (;;)
    {
      return true;
      this.vSo.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUIv2.a
 * JD-Core Version:    0.7.0.1
 */
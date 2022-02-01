package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.newtips.a.a;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.protocal.protobuf.dhn;

abstract class MallIndexUI$a
  implements a
{
  private Context context;
  protected ImageView uDr;
  protected TextView uDs;
  
  public MallIndexUI$a(MallIndexUI paramMallIndexUI, Context paramContext, View paramView)
  {
    this.context = paramContext;
    ek(paramView);
  }
  
  public final void a(k paramk, boolean paramBoolean)
  {
    g.a(this, paramk, paramBoolean);
  }
  
  public final boolean a(boolean paramBoolean, dhn paramdhn)
  {
    return false;
  }
  
  public final boolean b(boolean paramBoolean, dhn paramdhn)
  {
    return false;
  }
  
  public final boolean c(boolean paramBoolean, dhn paramdhn)
  {
    return false;
  }
  
  public final boolean d(boolean paramBoolean, dhn paramdhn)
  {
    if (paramBoolean)
    {
      this.uDs.setVisibility(0);
      String str = paramdhn.gMk;
      if (paramdhn.gMk > 99) {
        str = this.context.getString(2131764343);
      }
      this.uDs.setText(str);
    }
    for (;;)
    {
      return true;
      this.uDs.setVisibility(8);
    }
  }
  
  public final boolean dbk()
  {
    return false;
  }
  
  public abstract void ek(View paramView);
  
  public final boolean nR(boolean paramBoolean)
  {
    return g.a(paramBoolean, this);
  }
  
  public final boolean nS(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.uDr.setVisibility(0);
    }
    for (;;)
    {
      return true;
      this.uDr.setVisibility(8);
    }
  }
  
  public final boolean nT(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.uDs.setVisibility(0);
      this.uDs.setText(this.context.getString(2131755829));
    }
    for (;;)
    {
      return true;
      this.uDs.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI.a
 * JD-Core Version:    0.7.0.1
 */
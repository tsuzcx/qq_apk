package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.newtips.a.a;
import com.tencent.mm.plugin.newtips.a.g;
import com.tencent.mm.plugin.newtips.a.k;
import com.tencent.mm.protocal.protobuf.dcb;

abstract class MallIndexUI$a
  implements a
{
  private Context context;
  protected ImageView tuY;
  protected TextView tuZ;
  
  public MallIndexUI$a(MallIndexUI paramMallIndexUI, Context paramContext, View paramView)
  {
    this.context = paramContext;
    eb(paramView);
  }
  
  public final void a(k paramk, boolean paramBoolean)
  {
    g.a(this, paramk, paramBoolean);
  }
  
  public final boolean a(boolean paramBoolean, dcb paramdcb)
  {
    return false;
  }
  
  public final boolean b(boolean paramBoolean, dcb paramdcb)
  {
    return false;
  }
  
  public final boolean c(boolean paramBoolean, dcb paramdcb)
  {
    return false;
  }
  
  public final boolean cND()
  {
    return false;
  }
  
  public final boolean d(boolean paramBoolean, dcb paramdcb)
  {
    if (paramBoolean)
    {
      this.tuZ.setVisibility(0);
      String str = paramdcb.glx;
      if (paramdcb.glx > 99) {
        str = this.context.getString(2131764343);
      }
      this.tuZ.setText(str);
    }
    for (;;)
    {
      return true;
      this.tuZ.setVisibility(8);
    }
  }
  
  public abstract void eb(View paramView);
  
  public final boolean mY(boolean paramBoolean)
  {
    return g.a(paramBoolean, this);
  }
  
  public final boolean mZ(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.tuY.setVisibility(0);
    }
    for (;;)
    {
      return true;
      this.tuY.setVisibility(8);
    }
  }
  
  public final boolean na(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.tuZ.setVisibility(0);
      this.tuZ.setText(this.context.getString(2131755829));
    }
    for (;;)
    {
      return true;
      this.tuZ.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallIndexUI.a
 * JD-Core Version:    0.7.0.1
 */
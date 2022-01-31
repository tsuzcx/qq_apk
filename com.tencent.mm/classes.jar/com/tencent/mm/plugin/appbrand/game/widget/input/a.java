package com.tencent.mm.plugin.appbrand.game.widget.input;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.plugin.appbrand.widget.input.m;
import com.tencent.mm.plugin.appbrand.widget.input.t;
import com.tencent.mm.plugin.appbrand.widget.input.v;
import com.tencent.mm.plugin.appbrand.y.g;

public final class a
  extends v
{
  private static final int gdr = y.g.app_brand_game_input_panel;
  public a.a gds;
  private WAGamePanelInputEditText gdt;
  private View.OnClickListener gdu;
  
  private a(Context paramContext)
  {
    super(paramContext);
    mR(gdr);
  }
  
  public static a bQ(View paramView)
  {
    return (a)paramView.getRootView().findViewById(gdr);
  }
  
  public static a bR(View paramView)
  {
    m localm = m.ch(paramView);
    if ((localm.getOnLayoutListener() == null) || (!(localm.getOnLayoutListener() instanceof t))) {
      localm.setOnLayoutListener(new t());
    }
    a locala2 = bQ(paramView);
    a locala1 = locala2;
    if (locala2 == null)
    {
      locala1 = new a(paramView.getContext());
      localm.ci(locala1);
    }
    return locala1;
  }
  
  protected final void ahq()
  {
    this.gds.setIsHide(false);
  }
  
  protected final void ahr()
  {
    int j = 0;
    View localView;
    if ((this.gdt.getInputType() & 0x20000) > 0)
    {
      i = 1;
      localView = this.gds.getConfirmButton();
      if (i == 0) {
        break label42;
      }
    }
    label42:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      return;
      i = 0;
      break;
    }
  }
  
  public final WAGamePanelInputEditText getAttachedEditText()
  {
    return (WAGamePanelInputEditText)super.getAttachedEditText();
  }
  
  public final void setOnConfirmClickListener(View.OnClickListener paramOnClickListener)
  {
    this.gdu = paramOnClickListener;
  }
  
  public final void show()
  {
    this.hvc = this.gdt;
    this.gdt.requestFocus();
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.widget.input.a
 * JD-Core Version:    0.7.0.1
 */
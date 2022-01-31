package com.tencent.mm.plugin.location.ui;

import android.view.View;
import android.view.View.OnClickListener;

final class m$3
  implements View.OnClickListener
{
  m$3(m paramm) {}
  
  public final void onClick(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationInWindow(arrayOfInt);
    m.a(this.lHu, arrayOfInt[0], arrayOfInt[1]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.m.3
 * JD-Core Version:    0.7.0.1
 */
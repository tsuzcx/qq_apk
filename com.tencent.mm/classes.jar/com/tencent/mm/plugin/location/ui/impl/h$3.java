package com.tencent.mm.plugin.location.ui.impl;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.y;

final class h$3
  implements View.OnClickListener
{
  h$3(h paramh) {}
  
  public final void onClick(View paramView)
  {
    y.d("MicroMsg.TrackMapUI", "newpoi old go back onclick");
    this.lKp.bMJ = 0;
    this.lKp.beX();
    this.lKp.bff();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.h.3
 * JD-Core Version:    0.7.0.1
 */
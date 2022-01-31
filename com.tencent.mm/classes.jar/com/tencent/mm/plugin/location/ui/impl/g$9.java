package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.plugin.location.model.o;
import com.tencent.mm.plugin.location.ui.k;
import com.tencent.mm.plugin.location.ui.m;

final class g$9
  implements DialogInterface.OnClickListener
{
  g$9(g paramg) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.lKi.lJV.hk(false);
    this.lKi.lJW.stop();
    this.lKi.lJW.sY(2);
    k.beA();
    this.lKi.activity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.g.9
 * JD-Core Version:    0.7.0.1
 */
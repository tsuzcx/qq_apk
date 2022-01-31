package com.tencent.mm.plugin.base.stub;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.game.a.a;
import com.tencent.mm.plugin.game.a.a.a;

final class d$2
  implements DialogInterface.OnClickListener
{
  d$2(d paramd) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = a.a.aYi();
    if (paramDialogInterface != null) {
      paramDialogInterface.k(this.hRV.openId, q.Gm(), this.hRV.appId);
    }
    this.hRV.hRU.em(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.d.2
 * JD-Core Version:    0.7.0.1
 */
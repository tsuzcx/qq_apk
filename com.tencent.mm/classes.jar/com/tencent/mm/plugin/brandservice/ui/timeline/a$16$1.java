package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mm.model.bd;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.storage.q;

final class a$16$1
  implements DialogInterface.OnClickListener
{
  a$16$1(a.16 param16) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    bd.bC(a.m(this.ifr.ifl).field_msgId);
    a.d(this.ifr.ifl).c(a.m(this.ifr.ifl), 3);
    a.l(this.ifr.ifl).d(a.m(this.ifr.ifl));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.16.1
 * JD-Core Version:    0.7.0.1
 */
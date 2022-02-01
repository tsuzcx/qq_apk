package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.b;

public abstract class c
  extends SecurityImage.b
{
  SecurityImage mUP = null;
  q nbK = null;
  
  public abstract q a(q paramq, String paramString);
  
  public final void bxQ()
  {
    com.tencent.mm.kernel.h.aGY().a(a(this.nbK, ""), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.c
 * JD-Core Version:    0.7.0.1
 */
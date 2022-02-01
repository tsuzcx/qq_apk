package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.ui.applet.SecurityImage;
import com.tencent.mm.ui.applet.SecurityImage.b;
import com.tencent.mm.ui.base.h;

public abstract class b
  extends SecurityImage.b
{
  SecurityImage jct = null;
  n jiS = null;
  
  public abstract n a(n paramn, String paramString);
  
  public final void aSv()
  {
    g.aiU().a(a(this.jiS, ""), 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.b
 * JD-Core Version:    0.7.0.1
 */
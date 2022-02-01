package com.tencent.mm.plugin.findersdk.b;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.c.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.s;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/findersdk/cgi/LoadingDialog;", "Lcom/tencent/mm/plugin/findersdk/cgi/LoadingWidget;", "()V", "loadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getLoadingDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setLoadingDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "getOnCancelListener", "()Landroid/content/DialogInterface$OnCancelListener;", "setOnCancelListener", "(Landroid/content/DialogInterface$OnCancelListener;)V", "wording", "", "getWording", "()Ljava/lang/String;", "setWording", "(Ljava/lang/String;)V", "dismiss", "", "show", "finder-sdk_release"})
public final class d
  extends f
{
  private s loadingDialog;
  public DialogInterface.OnCancelListener nbU;
  private String wording;
  
  public d()
  {
    AppMethodBeat.i(209690);
    String str = MMApplicationContext.getContext().getString(c.a.app_waiting);
    p.j(str, "MMApplicationContext.get…ing(R.string.app_waiting)");
    this.wording = str;
    AppMethodBeat.o(209690);
  }
  
  public final void aDu(String paramString)
  {
    AppMethodBeat.i(209685);
    p.k(paramString, "<set-?>");
    this.wording = paramString;
    AppMethodBeat.o(209685);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(209689);
    s locals = this.loadingDialog;
    if (locals != null)
    {
      locals.dismiss();
      AppMethodBeat.o(209689);
      return;
    }
    AppMethodBeat.o(209689);
  }
  
  public final void show()
  {
    AppMethodBeat.i(209687);
    Object localObject = this.context;
    if (localObject != null)
    {
      localObject = (Context)((WeakReference)localObject).get();
      if (localObject != null) {}
    }
    else
    {
      localObject = MMApplicationContext.getContext();
    }
    for (;;)
    {
      CharSequence localCharSequence = (CharSequence)this.wording;
      if (this.nbU != null) {}
      for (boolean bool = true;; bool = false)
      {
        this.loadingDialog = s.a((Context)localObject, localCharSequence, bool, 0, this.nbU);
        AppMethodBeat.o(209687);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.b.d
 * JD-Core Version:    0.7.0.1
 */
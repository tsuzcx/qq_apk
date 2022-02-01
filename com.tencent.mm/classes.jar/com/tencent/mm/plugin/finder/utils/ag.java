package com.tencent.mm.plugin.finder.utils;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.q;
import java.lang.ref.WeakReference;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/utils/LoadingDialog;", "Lcom/tencent/mm/plugin/finder/utils/LoadingWidget;", "()V", "loadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getLoadingDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setLoadingDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "getOnCancelListener", "()Landroid/content/DialogInterface$OnCancelListener;", "setOnCancelListener", "(Landroid/content/DialogInterface$OnCancelListener;)V", "wording", "", "getWording", "()Ljava/lang/String;", "setWording", "(Ljava/lang/String;)V", "dismiss", "", "show", "plugin-finder_release"})
public final class ag
  extends ai
{
  private String dQx;
  public DialogInterface.OnCancelListener kke;
  private q loadingDialog;
  
  public ag()
  {
    AppMethodBeat.i(253791);
    String str = MMApplicationContext.getContext().getString(2131756029);
    p.g(str, "MMApplicationContext.get…ing(R.string.app_waiting)");
    this.dQx = str;
    AppMethodBeat.o(253791);
  }
  
  public final void awz(String paramString)
  {
    AppMethodBeat.i(253788);
    p.h(paramString, "<set-?>");
    this.dQx = paramString;
    AppMethodBeat.o(253788);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(253790);
    q localq = this.loadingDialog;
    if (localq != null)
    {
      localq.dismiss();
      AppMethodBeat.o(253790);
      return;
    }
    AppMethodBeat.o(253790);
  }
  
  public final void show()
  {
    AppMethodBeat.i(253789);
    Object localObject = this.lAM;
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
      CharSequence localCharSequence = (CharSequence)this.dQx;
      if (this.kke != null) {}
      for (boolean bool = true;; bool = false)
      {
        this.loadingDialog = q.a((Context)localObject, localCharSequence, bool, 0, this.kke);
        AppMethodBeat.o(253789);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.utils.ag
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.findersdk.b;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.findersdk.c.a;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.base.w;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/findersdk/cgi/LoadingDialog;", "Lcom/tencent/mm/plugin/findersdk/cgi/LoadingWidget;", "()V", "loadingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getLoadingDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setLoadingDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "onCancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "getOnCancelListener", "()Landroid/content/DialogInterface$OnCancelListener;", "setOnCancelListener", "(Landroid/content/DialogInterface$OnCancelListener;)V", "wording", "", "getWording", "()Ljava/lang/String;", "setWording", "(Ljava/lang/String;)V", "dismiss", "", "show", "finder-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends g
{
  private w loadingDialog;
  public DialogInterface.OnCancelListener qbI;
  private String wording;
  
  public e()
  {
    AppMethodBeat.i(273884);
    String str = MMApplicationContext.getContext().getString(c.a.app_waiting);
    s.s(str, "getContext().getString(R.string.app_waiting)");
    this.wording = str;
    AppMethodBeat.o(273884);
  }
  
  public final void ayQ(String paramString)
  {
    AppMethodBeat.i(273891);
    s.u(paramString, "<set-?>");
    this.wording = paramString;
    AppMethodBeat.o(273891);
  }
  
  public final void dismiss()
  {
    AppMethodBeat.i(273911);
    w localw = this.loadingDialog;
    if (localw != null) {
      localw.dismiss();
    }
    AppMethodBeat.o(273911);
  }
  
  public final void show()
  {
    AppMethodBeat.i(273902);
    Object localObject = this.context;
    label24:
    CharSequence localCharSequence;
    if (localObject == null)
    {
      localObject = null;
      if (localObject != null) {
        break label73;
      }
      localObject = MMApplicationContext.getContext();
      localCharSequence = (CharSequence)this.wording;
      if (this.qbI == null) {
        break label76;
      }
    }
    label73:
    label76:
    for (boolean bool = true;; bool = false)
    {
      this.loadingDialog = w.a((Context)localObject, localCharSequence, bool, 0, this.qbI);
      AppMethodBeat.o(273902);
      return;
      localObject = (Context)((WeakReference)localObject).get();
      break;
      break label24;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.findersdk.b.e
 * JD-Core Version:    0.7.0.1
 */
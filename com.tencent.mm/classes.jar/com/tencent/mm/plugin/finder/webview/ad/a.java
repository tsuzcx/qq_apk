package com.tencent.mm.plugin.finder.webview.ad;

import android.content.Context;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.webview.j;
import com.tencent.mm.plugin.finder.webview.l;
import com.tencent.mm.protocal.protobuf.rx;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/webview/ad/FinderDialogWrapperFactory;", "", "()V", "webViewDialogWrapper", "Lcom/tencent/mm/plugin/finder/webview/FinderWebViewDialogWrapper;", "context", "Landroid/content/Context;", "homeContext", "Lcom/tencent/mm/protocal/protobuf/BoxHomeContext;", "style", "", "dismissListener", "Landroid/content/DialogInterface$OnDismissListener;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a GYD;
  
  static
  {
    AppMethodBeat.i(334616);
    GYD = new a();
    AppMethodBeat.o(334616);
  }
  
  public static com.tencent.mm.plugin.finder.webview.i a(Context paramContext, rx paramrx, DialogInterface.OnDismissListener paramOnDismissListener)
  {
    AppMethodBeat.i(334613);
    s.u(paramContext, "context");
    s.u(paramrx, "homeContext");
    b localb = new b(paramContext);
    d locald = new d((com.tencent.mm.ui.widget.a.i)localb, localb.fqr());
    j localj = new j(paramContext, paramrx, (byte)0);
    localj.GXU = localb.getWindow();
    paramrx = locald.GXV;
    if (paramrx != null) {}
    for (;;)
    {
      localj.GXV = paramrx;
      paramContext = new com.tencent.mm.plugin.finder.webview.i(paramContext, (l)localj, localb, locald, paramOnDismissListener);
      AppMethodBeat.o(334613);
      return paramContext;
      s.bIx("codeMaskView");
      paramrx = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.ad.a
 * JD-Core Version:    0.7.0.1
 */
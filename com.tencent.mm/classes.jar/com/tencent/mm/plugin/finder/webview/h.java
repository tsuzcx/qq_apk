package com.tencent.mm.plugin.finder.webview;

import android.content.Context;
import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.feed.jumper.e;
import com.tencent.mm.plugin.finder.feed.jumper.k;
import com.tencent.mm.plugin.finder.webview.ad.BottomScrollFrameLayout;
import com.tencent.mm.plugin.finder.webview.ad.a;
import com.tencent.mm.plugin.finder.webview.ad.c;
import com.tencent.mm.plugin.finder.webview.ad.d;
import com.tencent.mm.protocal.protobuf.rx;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/webview/FinderWebViewDialogManager;", "", "()V", "TAG", "", "showAdDialog", "", "context", "Landroid/content/Context;", "url", "infoEx", "Lcom/tencent/mm/plugin/finder/feed/jumper/FinderJumpInfoEx;", "showAdHalfDialog", "Lcom/tencent/mm/plugin/finder/webview/FinderWebViewHalfDialog;", "boxDialogOnShowListener", "Lcom/tencent/mm/plugin/finder/webview/ScanBoxDialogViewListener;", "showCenterAdDialog", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
{
  public static final h GXH;
  
  static
  {
    AppMethodBeat.i(334470);
    GXH = new h();
    AppMethodBeat.o(334470);
  }
  
  private static final void a(Context paramContext, k paramk, DialogInterface paramDialogInterface)
  {
    AppMethodBeat.i(334462);
    s.u(paramContext, "$context");
    s.u(paramk, "$infoEx");
    paramDialogInterface = e.BdD;
    s.u(paramContext, "context");
    s.u(paramk, "infoEx");
    e.a(paramContext, "feed_jumpicon_halfscreenleave", 1, paramk, 0, 1, 16);
    AppMethodBeat.o(334462);
  }
  
  public static final void a(Context paramContext, String paramString, final k paramk)
  {
    AppMethodBeat.i(334453);
    s.u(paramContext, "context");
    s.u(paramString, "url");
    s.u(paramk, "infoEx");
    rx localrx = new rx();
    localrx.YWL = UUID.randomUUID().toString();
    localrx.Url = paramString;
    paramString = i.GXI;
    if (!i.fpO())
    {
      paramString = a.GYD;
      paramString = a.a(paramContext, localrx, new h..ExternalSyntheticLambda0(paramContext, paramk));
      paramString.GXO = false;
      paramk = (c)new a(paramContext, paramk);
      paramContext = paramString.GXL.GYZ;
      if (!(paramContext instanceof BottomScrollFrameLayout)) {
        break label132;
      }
    }
    label132:
    for (paramContext = (BottomScrollFrameLayout)paramContext;; paramContext = null)
    {
      if (paramContext != null) {
        paramContext.setScrollToTopListener(paramk);
      }
      paramString.fpM();
      AppMethodBeat.o(334453);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/webview/FinderWebViewDialogManager$showAdDialog$1", "Lcom/tencent/mm/plugin/finder/webview/ad/IScrollToTopListener;", "onScrollToTop", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements c
  {
    a(Context paramContext, k paramk) {}
    
    public final void dSq()
    {
      AppMethodBeat.i(334504);
      Object localObject = e.BdD;
      localObject = this.$context;
      k localk = paramk;
      s.u(localObject, "context");
      s.u(localk, "infoEx");
      e.a((Context)localObject, "feed_jumpicon_halfscreenslideup", 1, localk, 0, 0, 48);
      AppMethodBeat.o(334504);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.webview.h
 * JD-Core Version:    0.7.0.1
 */
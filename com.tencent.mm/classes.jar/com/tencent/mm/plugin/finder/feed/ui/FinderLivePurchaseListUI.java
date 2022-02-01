package com.tencent.mm.plugin.finder.feed.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.ak;
import com.tencent.mm.ui.component.UIComponent;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLivePurchaseListUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLivePurchaseListUI
  extends MMFinderUI
{
  public static final a BpC;
  
  static
  {
    AppMethodBeat.i(364974);
    BpC = new a((byte)0);
    AppMethodBeat.o(364974);
  }
  
  private static final boolean a(FinderLivePurchaseListUI paramFinderLivePurchaseListUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(364953);
    s.u(paramFinderLivePurchaseListUI, "this$0");
    paramFinderLivePurchaseListUI.onBackPressed();
    AppMethodBeat.o(364953);
    return true;
  }
  
  private static final boolean b(FinderLivePurchaseListUI paramFinderLivePurchaseListUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(364967);
    s.u(paramFinderLivePurchaseListUI, "this$0");
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("rawUrl", "https://support.weixin.qq.com/cgi-bin/mmsupportacctnodeweb-bin/pages/vuIelfSGnul4ZGDt");
    c.b((Context)paramFinderLivePurchaseListUI.getContext(), "webview", ".ui.tools.WebViewUI", paramMenuItem);
    AppMethodBeat.o(364967);
    return true;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(364993);
    super.onCreate(paramBundle);
    setMMTitle(e.h.finder_live_purchase_content1);
    setBackBtn(new FinderLivePurchaseListUI..ExternalSyntheticLambda0(this));
    addTextOptionMenu(1001, getString(e.h.finder_live_purchase_help), new FinderLivePurchaseListUI..ExternalSyntheticLambda1(this));
    AppMethodBeat.o(364993);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(364998);
    s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(ak.class);
    AppMethodBeat.o(364998);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLivePurchaseListUI$Companion;", "", "()V", "URL", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLivePurchaseListUI
 * JD-Core Version:    0.7.0.1
 */
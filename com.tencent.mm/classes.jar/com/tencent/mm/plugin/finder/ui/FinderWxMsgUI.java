package com.tencent.mm.plugin.finder.ui;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract.NotifyPresenter;
import com.tencent.mm.plugin.finder.storage.d;
import com.tencent.mm.plugin.finder.viewmodel.component.bg;
import com.tencent.mm.plugin.finder.viewmodel.m;
import com.tencent.mm.plugin.finder.wxmessage.FinderWxNotifyTabUIC;
import com.tencent.mm.plugin.findersdk.a.bh;
import com.tencent.mm.plugin.findersdk.a.bl;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderWxMsgUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyPresenter;", "getCommentScene", "", "getPresenter", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initView", "", "isSplitTabs", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "onStop", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderWxMsgUI
  extends MMFinderUI
{
  private static final int[] EZE;
  private static final ArrayList<int[]> EZF;
  public static final a FVF;
  public final FinderNotifyContract.NotifyPresenter EZQ;
  private final String TAG;
  
  static
  {
    AppMethodBeat.i(347438);
    FVF = new a((byte)0);
    int[] arrayOfInt = { 3, 5 };
    EZF = p.al((Object[])new int[][] { { 7, 2, 8 }, arrayOfInt });
    EZE = new int[] { 7, 8 };
    AppMethodBeat.o(347438);
  }
  
  public FinderWxMsgUI()
  {
    AppMethodBeat.i(167688);
    this.TAG = "Finder.FinderWxMsgUI";
    this.EZQ = new FinderNotifyContract.NotifyPresenter(2, EZE, EZF);
    AppMethodBeat.o(167688);
  }
  
  private static final boolean a(FinderWxMsgUI paramFinderWxMsgUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(347435);
    s.u(paramFinderWxMsgUI, "this$0");
    paramFinderWxMsgUI.finish();
    AppMethodBeat.o(347435);
    return true;
  }
  
  private static boolean fci()
  {
    AppMethodBeat.i(347429);
    d locald = d.FAy;
    if (((Number)d.eXk().bmg()).intValue() == 1)
    {
      AppMethodBeat.o(347429);
      return true;
    }
    AppMethodBeat.o(347429);
    return false;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getCommentScene()
  {
    return 117;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(347453);
    if (!fci())
    {
      localSet = ar.setOf(new Class[] { bg.class, com.tencent.mm.plugin.finder.viewmodel.teenmode.b.class });
      AppMethodBeat.o(347453);
      return localSet;
    }
    Set localSet = ar.setOf(new Class[] { com.tencent.mm.plugin.finder.viewmodel.teenmode.b.class, FinderWxNotifyTabUIC.class });
    AppMethodBeat.o(347453);
    return localSet;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167685);
    if (fci()) {
      setBackBtn(new FinderWxMsgUI..ExternalSyntheticLambda0(this));
    }
    AppMethodBeat.o(167685);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167684);
    super.onCreate(paramBundle);
    if (fci())
    {
      paramBundle = k.aeZF;
      ((bh)k.d((AppCompatActivity)this).cq(bh.class)).foj();
      initView();
      h.baE().ban().set(at.a.adcq, Integer.valueOf(0));
      h.baE().ban().set(at.a.adcs, Integer.valueOf(0));
      h.baE().ban().set(at.a.adct, Integer.valueOf(0));
      h.baE().ban().set(at.a.adcu, Integer.valueOf(0));
      h.baE().ban().set(at.a.adcv, Integer.valueOf(0));
      h.baE().ban().set(at.a.adcw, Integer.valueOf(0));
      ((cn)h.az(cn.class)).getRedDotManager().TL("TLWxBubble");
      this.EZQ.eIo();
    }
    AppMethodBeat.o(167684);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167686);
    super.onDestroy();
    if (fci()) {
      this.EZQ.onActivityDestroy();
    }
    AppMethodBeat.o(167686);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(347473);
    super.onPause();
    AppMethodBeat.o(347473);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(347466);
    super.onResume();
    if (fci()) {
      this.EZQ.EZn = System.currentTimeMillis();
    }
    AppMethodBeat.o(347466);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(347478);
    super.onStop();
    if (fci())
    {
      this.EZQ.onStop();
      k localk = k.aeZF;
      int i = ((FinderWxNotifyTabUIC)k.d((AppCompatActivity)this).q(FinderWxNotifyTabUIC.class)).fpi();
      localk = k.aeZF;
      ((m)k.cn(PluginFinder.class).q(m.class)).UZ(i);
    }
    AppMethodBeat.o(347478);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderWxMsgUI$Companion;", "", "()V", "msgTypes", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getMsgTypes", "()Ljava/util/ArrayList;", "requestScenes", "getRequestScenes", "()[I", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderWxMsgUI
 * JD-Core Version:    0.7.0.1
 */
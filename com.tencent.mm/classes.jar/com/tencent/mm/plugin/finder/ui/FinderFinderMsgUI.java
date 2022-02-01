package com.tencent.mm.plugin.finder.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract.NotifyPresenter;
import com.tencent.mm.plugin.finder.viewmodel.component.am;
import com.tencent.mm.plugin.finder.viewmodel.g;
import com.tencent.mm.plugin.findersdk.a.bh;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.a.ar;
import kotlin.a.p;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderFinderMsgUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyPresenter;", "dealContentView", "", "v", "Landroid/view/View;", "getActivityContentView", "getCommentScene", "", "getPresenter", "importUIComponents", "", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onNewIntent", "intent", "Landroid/content/Intent;", "onPause", "onResume", "onStop", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFinderMsgUI
  extends MMFinderUI
{
  private static final ArrayList<int[]> EZF;
  public static final a FQB;
  private static final String TAG;
  public final FinderNotifyContract.NotifyPresenter EZQ;
  
  static
  {
    AppMethodBeat.i(346458);
    FQB = new a((byte)0);
    TAG = "FinderMsgNotifyUI";
    EZF = p.al((Object[])new int[][] { { 2 }, { 3, 5 }, { 1, 10 } });
    AppMethodBeat.o(346458);
  }
  
  public FinderFinderMsgUI()
  {
    AppMethodBeat.i(346447);
    ArrayList localArrayList = EZF;
    this.EZQ = new FinderNotifyContract.NotifyPresenter(new int[] { 3, 4, 5 }, localArrayList);
    AppMethodBeat.o(346447);
  }
  
  private static final boolean a(FinderFinderMsgUI paramFinderFinderMsgUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(346455);
    s.u(paramFinderFinderMsgUI, "this$0");
    paramFinderFinderMsgUI.finish();
    AppMethodBeat.o(346455);
    return true;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void dealContentView(View paramView)
  {
    AppMethodBeat.i(346510);
    super.dealContentView(paramView);
    AppMethodBeat.o(346510);
  }
  
  public final int getCommentScene()
  {
    return 7;
  }
  
  public final Set<Class<? extends UIComponent>> importUIComponents()
  {
    AppMethodBeat.i(346466);
    Set localSet = ar.setOf(am.class);
    AppMethodBeat.o(346466);
    return localSet;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(346500);
    setMMTitle(e.h.finder_conversation_finder_team);
    setBackBtn(new FinderFinderMsgUI..ExternalSyntheticLambda0(this));
    AppMethodBeat.o(346500);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(346470);
    super.onCreate(paramBundle);
    paramBundle = k.aeZF;
    ((bh)k.d((AppCompatActivity)this).cq(bh.class)).foj();
    initView();
    this.EZQ.eIo();
    AppMethodBeat.o(346470);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(346494);
    k localk = k.aeZF;
    s.X("onDestroy lastTabIndex :", Integer.valueOf(((am)k.d((AppCompatActivity)this).q(am.class)).fpi()));
    h.jXD();
    super.onDestroy();
    this.EZQ.onActivityDestroy();
    AppMethodBeat.o(346494);
  }
  
  public final void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(346476);
    super.onNewIntent(paramIntent);
    AppMethodBeat.o(346476);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(346483);
    super.onPause();
    h.jXD();
    AppMethodBeat.o(346483);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(346479);
    super.onResume();
    this.EZQ.EZn = System.currentTimeMillis();
    h.jXD();
    AppMethodBeat.o(346479);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(346488);
    super.onStop();
    this.EZQ.onStop();
    k localk = k.aeZF;
    int i = ((am)k.d((AppCompatActivity)this).q(am.class)).fpi();
    s.X("onStop lastTabIndex :", Integer.valueOf(i));
    h.jXD();
    localk = k.aeZF;
    ((g)k.cn(PluginFinder.class).q(g.class)).UZ(i);
    AppMethodBeat.o(346488);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderFinderMsgUI$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "msgTypes", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "getMsgTypes", "()Ljava/util/ArrayList;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderFinderMsgUI
 * JD-Core Version:    0.7.0.1
 */
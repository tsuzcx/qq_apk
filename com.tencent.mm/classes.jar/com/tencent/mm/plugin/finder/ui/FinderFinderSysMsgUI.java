package com.tencent.mm.plugin.finder.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.extension.reddot.b;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgPresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback.UICallbackListener;
import com.tencent.mm.plugin.finder.search.a;
import com.tencent.mm.plugin.finder.storage.av;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderFinderSysMsgUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$UICallbackListener;", "()V", "TAG", "", "exposeMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/plugin/finder/search/FinderExposeItem;", "msgPresenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter;", "getCommentScene", "", "getLayoutId", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onItemClick", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "onResume", "onStop", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderFinderSysMsgUI
  extends MMFinderUI
  implements FinderMsgContract.MsgViewCallback.UICallbackListener
{
  private final FinderMsgContract.MsgPresenter FQC;
  private HashMap<String, a> FvE;
  private final String TAG;
  
  public FinderFinderSysMsgUI()
  {
    AppMethodBeat.i(346336);
    this.TAG = "Finder.FinderFinderSysMsgUI";
    this.FQC = new FinderMsgContract.MsgPresenter(new int[] { 4 });
    this.FvE = new HashMap();
    AppMethodBeat.o(346336);
  }
  
  private static final boolean a(FinderFinderSysMsgUI paramFinderFinderSysMsgUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(346343);
    s.u(paramFinderFinderSysMsgUI, "this$0");
    paramFinderFinderSysMsgUI.finish();
    AppMethodBeat.o(346343);
    return true;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void a(av paramav)
  {
    AppMethodBeat.i(346389);
    s.u(paramav, "mention");
    AppMethodBeat.o(346389);
  }
  
  public final int getCommentScene()
  {
    return 118;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_msg_list_layout;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(346372);
    setMMTitle(getString(e.h.finder_conversation_finder_team));
    setBackBtn(new FinderFinderSysMsgUI..ExternalSyntheticLambda0(this));
    Object localObject = (MMActivity)this;
    View localView = getContentView();
    s.s(localView, "contentView");
    localObject = new FinderMsgContract.MsgViewCallback((MMActivity)localObject, localView, this.FQC, (FinderMsgContract.MsgViewCallback.UICallbackListener)this);
    this.FQC.a((FinderMsgContract.MsgViewCallback)localObject);
    ((FinderMsgContract.MsgViewCallback)localObject).initView();
    h.baE().ban().set(at.a.addL, Integer.valueOf(0));
    ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().AQv.dZb();
    AppMethodBeat.o(346372);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(346358);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(346358);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(346385);
    super.onDestroy();
    this.FQC.onDetach();
    AppMethodBeat.o(346385);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(346363);
    super.onResume();
    this.FQC.EZn = System.currentTimeMillis();
    AppMethodBeat.o(346363);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(346366);
    super.onStop();
    this.FQC.onStop();
    AppMethodBeat.o(346366);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderFinderSysMsgUI
 * JD-Core Version:    0.7.0.1
 */
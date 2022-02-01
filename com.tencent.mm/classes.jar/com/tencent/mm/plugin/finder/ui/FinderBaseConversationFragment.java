package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatting.BasePrivateMsgConvListFragment;
import com.tencent.mm.chatting.BasePrivateMsgConvListFragment.a;
import com.tencent.mm.chatting.BasePrivateMsgConvListFragment.c;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.conv.a.a;
import com.tencent.mm.plugin.finder.conv.a.b;
import com.tencent.mm.plugin.finder.conv.c;
import com.tencent.mm.plugin.finder.conv.c.a;
import com.tencent.mm.plugin.finder.conv.c.b;
import com.tencent.mm.plugin.finder.conv.e;
import com.tencent.mm.plugin.finder.conv.g;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.report.f;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.sdk.storage.MStorage;
import com.tencent.mm.view.RefreshLoadMoreLayout;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderBaseConversationFragment;", "Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "()V", "animRunnable", "Lcom/tencent/mm/ui/anim/conv/ConvItemUnselectedAnim;", "getAnimRunnable", "()Lcom/tencent/mm/ui/anim/conv/ConvItemUnselectedAnim;", "setAnimRunnable", "(Lcom/tencent/mm/ui/anim/conv/ConvItemUnselectedAnim;)V", "convScene", "", "convType", "getAdapter", "Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment$BasePrivateMsgConvAdapter;", "getContactStorageList", "", "Lcom/tencent/mm/sdk/storage/MStorage;", "getConversationDataSource", "Lcom/tencent/mm/chatting/BasePrivateMsgConvListFragment$IConversationDataSource;", "getEmptyView", "Landroid/view/View;", "getFirstPageCount", "getLayoutId", "getLoadingView", "getRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRefreshLoadMoreLayout", "Lcom/tencent/mm/view/RefreshLoadMoreLayout;", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onDestroy", "onExitChattingUI", "onResume", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "reportChatExpose", "reportEnterDuration", "duration", "", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class FinderBaseConversationFragment
  extends BasePrivateMsgConvListFragment<com.tencent.mm.plugin.finder.conv.b>
{
  public static final a FOx;
  com.tencent.mm.ui.anim.c.a FOA;
  private int FOy = -1;
  private int FOz = -1;
  
  static
  {
    AppMethodBeat.i(346704);
    FOx = new a((byte)0);
    AppMethodBeat.o(346704);
  }
  
  public final int aNI()
  {
    return 15;
  }
  
  public final RefreshLoadMoreLayout aNL()
  {
    AppMethodBeat.i(346720);
    Object localObject = getView();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((View)localObject).findViewById(e.e.rl_layout))
    {
      s.s(localObject, "rl_layout");
      localObject = (RefreshLoadMoreLayout)localObject;
      AppMethodBeat.o(346720);
      return localObject;
    }
  }
  
  public final BasePrivateMsgConvListFragment.c<com.tencent.mm.plugin.finder.conv.b> aNM()
  {
    int j = -1;
    AppMethodBeat.i(346752);
    Object localObject = getArguments();
    if (localObject == null)
    {
      i = -1;
      this.FOy = i;
      localObject = getArguments();
      if (localObject != null) {
        break label77;
      }
    }
    label77:
    for (int i = j;; i = ((Bundle)localObject).getInt("KEY_TALKER_SCENE", -1))
    {
      this.FOz = i;
      localObject = (BasePrivateMsgConvListFragment.c)new e(this.FOy, this.FOz);
      AppMethodBeat.o(346752);
      return localObject;
      i = ((Bundle)localObject).getInt("KEY_TALKER_TYPE", -1);
      break;
    }
  }
  
  public final List<MStorage> aNN()
  {
    AppMethodBeat.i(346759);
    List localList = p.listOf(new MAutoStorage[] { (MAutoStorage)((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getContactStorage(), (MAutoStorage)((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getMsgStrangerContactStorage(), (MAutoStorage)((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getMsgAliasContactStorage() });
    AppMethodBeat.o(346759);
    return localList;
  }
  
  public BasePrivateMsgConvListFragment.a<com.tencent.mm.plugin.finder.conv.b> aNO()
  {
    int j = -1;
    AppMethodBeat.i(346765);
    Object localObject = getArguments();
    if (localObject == null)
    {
      i = -1;
      this.FOy = i;
      localObject = getArguments();
      if (localObject != null) {
        break label135;
      }
    }
    label135:
    for (int i = j;; i = ((Bundle)localObject).getInt("KEY_TALKER_SCENE", -1))
    {
      this.FOz = i;
      localObject = new c();
      ((c)localObject).a((c.b)new g((kotlin.g.a.a)b.FOB));
      ((c)localObject).a((c.a)new com.tencent.mm.plugin.finder.conv.d(this, (kotlin.g.a.b)new c(this)));
      ((c)localObject).scene = this.FOz;
      ((c)localObject).pageType = this.FOy;
      localObject = (BasePrivateMsgConvListFragment.a)localObject;
      AppMethodBeat.o(346765);
      return localObject;
      i = ((Bundle)localObject).getInt("KEY_TALKER_TYPE", -1);
      break;
    }
  }
  
  public void faI() {}
  
  public final View getEmptyView()
  {
    AppMethodBeat.i(346732);
    View localView = getView();
    if (localView == null) {}
    for (localView = null;; localView = localView.findViewById(e.e.empty_tip))
    {
      s.s(localView, "empty_tip");
      AppMethodBeat.o(346732);
      return localView;
    }
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_conversation_ui;
  }
  
  public final View getLoadingView()
  {
    AppMethodBeat.i(346729);
    View localView = getView();
    if (localView == null) {}
    for (localView = null;; localView = localView.findViewById(e.e.loadingIcon))
    {
      s.s(localView, "loadingIcon");
      AppMethodBeat.o(346729);
      return localView;
    }
  }
  
  public final RecyclerView getRecyclerView()
  {
    AppMethodBeat.i(346716);
    Object localObject = getView();
    if (localObject == null) {}
    for (localObject = null;; localObject = ((View)localObject).findViewById(e.e.conversationRecyclerView))
    {
      ((RecyclerView)localObject).a((RecyclerView.l)new d(this));
      s.s(localObject, "conversationRecyclerView…   }\n        })\n        }");
      localObject = (RecyclerView)localObject;
      AppMethodBeat.o(346716);
      return localObject;
    }
  }
  
  public final void hn(long paramLong)
  {
    AppMethodBeat.i(346778);
    a.a locala = new a.a().avf("enterFinderConversationPage").avg(this.FOy + '-' + this.FOz);
    locala.duration = paramLong;
    locala.dWL().report();
    AppMethodBeat.o(346778);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onDestroy()
  {
    bui localbui = null;
    AppMethodBeat.i(346748);
    super.onDestroy();
    Object localObject = f.FnM;
    localObject = getContext();
    if (localObject == null) {}
    for (;;)
    {
      f.e(localbui);
      AppMethodBeat.o(346748);
      return;
      as.a locala = as.GSQ;
      localObject = as.a.hu((Context)localObject);
      if (localObject != null) {
        localbui = ((as)localObject).fou();
      }
    }
  }
  
  public void onResume()
  {
    AppMethodBeat.i(346743);
    super.onResume();
    com.tencent.mm.ui.anim.c.a locala = this.FOA;
    if (locala != null)
    {
      com.tencent.mm.ae.d.a(200L, (Runnable)locala);
      this.FOA = null;
    }
    AppMethodBeat.o(346743);
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(346738);
    s.u(paramView, "view");
    super.onViewCreated(paramView, paramBundle);
    if (this.FOz == 1)
    {
      com.tencent.mm.plugin.report.service.h.OAn.p(1473L, 11L, 1L);
      AppMethodBeat.o(346738);
      return;
    }
    if (this.FOz == 2)
    {
      if (this.FOy == 1)
      {
        com.tencent.mm.plugin.report.service.h.OAn.p(1473L, 12L, 1L);
        AppMethodBeat.o(346738);
        return;
      }
      if (this.FOy == 2) {
        com.tencent.mm.plugin.report.service.h.OAn.p(1473L, 13L, 1L);
      }
    }
    AppMethodBeat.o(346738);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderBaseConversationFragment$Companion;", "", "()V", "KEY_CONV_SCENE", "", "KEY_CONV_TYPE", "PAGE_COUNT", "", "PAGE_INITIAL_COUNT", "TAG", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    public static final b FOB;
    
    static
    {
      AppMethodBeat.i(346653);
      FOB = new b();
      AppMethodBeat.o(346653);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mm/ui/anim/conv/ConvItemUnselectedAnim;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.b<com.tencent.mm.ui.anim.c.a, ah>
  {
    c(FinderBaseConversationFragment paramFinderBaseConversationFragment)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderBaseConversationFragment$getRecyclerView$1$1", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "onScrollStateChanged", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "newState", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class d
    extends RecyclerView.l
  {
    d(FinderBaseConversationFragment paramFinderBaseConversationFragment) {}
    
    public final void onScrollStateChanged(RecyclerView paramRecyclerView, int paramInt)
    {
      AppMethodBeat.i(346660);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderBaseConversationFragment$getRecyclerView$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
      s.u(paramRecyclerView, "recyclerView");
      super.onScrollStateChanged(paramRecyclerView, paramInt);
      if (paramInt == 0) {
        FinderBaseConversationFragment.a(this.FOC);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderBaseConversationFragment$getRecyclerView$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
      AppMethodBeat.o(346660);
    }
    
    public final void onScrolled(RecyclerView paramRecyclerView, int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(346669);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.cH(paramRecyclerView);
      localb.sc(paramInt1);
      localb.sc(paramInt2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderBaseConversationFragment$getRecyclerView$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
      super.onScrolled(paramRecyclerView, paramInt1, paramInt2);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderBaseConversationFragment$getRecyclerView$1$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
      AppMethodBeat.o(346669);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderBaseConversationFragment
 * JD-Core Version:    0.7.0.1
 */
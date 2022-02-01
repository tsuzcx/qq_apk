package com.tencent.mm.plugin.finder.viewmodel.component;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract.NotifyPresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract.NotifyViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract.NotifyViewCallback.UICallbackListener;
import com.tencent.mm.plugin.finder.report.w;
import com.tencent.mm.plugin.finder.ui.FinderFinderMsgUI;
import com.tencent.mm.plugin.finder.utils.aw;
import com.tencent.mm.plugin.finder.viewmodel.g;
import com.tencent.mm.plugin.finder.viewmodel.notifytab.a;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.protocal.protobuf.bxq;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.recyclerview.WxRecyclerAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderNotifyUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback$UICallbackListener;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "isRefreshed", "", "lastTabIndex", "getLastTabIndex", "setLastTabIndex", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyPresenter;", "redDotCount", "getRedDotCount", "setRedDotCount", "viewCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback;", "getActiveIndex", "getLastIndex", "getLayoutId", "getPresenter", "onCreateAfter", "", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "onPause", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onUserVisibleFocused", "onUserVisibleUnFocused", "refreshSelf", "reportExpose", "setRedDot", "unsetRedDotCount", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class an
  extends UIComponent
  implements com.tencent.mm.am.h, FinderNotifyContract.NotifyViewCallback.UICallbackListener
{
  public static final a GSs;
  private static final String[] GSx;
  private FinderNotifyContract.NotifyPresenter EZQ;
  private int GSt;
  private int GSu;
  private boolean GSv;
  private FinderNotifyContract.NotifyViewCallback GSw;
  public int index;
  
  static
  {
    AppMethodBeat.i(338207);
    GSs = new a((byte)0);
    GSx = new String[] { "NotificationCenterLike", "NotificationCenterComment", "NotificationCenterFollow" };
    AppMethodBeat.o(338207);
  }
  
  public an(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(338158);
    this.index = -1;
    AppMethodBeat.o(338158);
  }
  
  private final void def()
  {
    AppMethodBeat.i(338174);
    Object localObject = a.Vk(this.index);
    com.tencent.mm.plugin.finder.extension.reddot.p localp = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().Su((String)localObject);
    bxq localbxq = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp((String)localObject);
    localObject = com.tencent.mm.plugin.finder.utils.av.GiL;
    Fragment localFragment = getFragment();
    localObject = aw.Gjk;
    w localw;
    if ((localp != null) && (localbxq != null) && (localFragment != null))
    {
      localw = w.FrV;
      localObject = as.GSQ;
      localObject = localFragment.getActivity();
      if (localObject == null)
      {
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(338174);
        throw ((Throwable)localObject);
      }
      localObject = as.a.hu((Context)localObject);
      if (localObject == null) {}
      for (localObject = null;; localObject = ((as)localObject).fou())
      {
        w.a(localw, "5", localp, localbxq, 1, (bui)localObject, 0, null, 0, 480);
        if (this.GSt != this.index) {
          break label231;
        }
        localw = w.FrV;
        localObject = as.GSQ;
        localObject = localFragment.getActivity();
        if (localObject != null) {
          break;
        }
        localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(338174);
        throw ((Throwable)localObject);
      }
      localObject = as.a.hu((Context)localObject);
      if (localObject != null) {
        break label237;
      }
    }
    label231:
    label237:
    for (localObject = null;; localObject = ((as)localObject).fou())
    {
      w.a(localw, "5", localp, localbxq, 3, (bui)localObject, 1, null, 0, 448);
      AppMethodBeat.o(338174);
      return;
    }
  }
  
  private FinderNotifyContract.NotifyPresenter fof()
  {
    AppMethodBeat.i(338185);
    Object localObject = getFragment();
    if (localObject == null)
    {
      localObject = null;
      if (!(localObject instanceof FinderFinderMsgUI)) {
        break label86;
      }
      localObject = getFragment();
      if (localObject != null) {
        break label63;
      }
    }
    label63:
    for (localObject = null;; localObject = ((Fragment)localObject).getActivity())
    {
      if (localObject != null) {
        break label71;
      }
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderFinderMsgUI");
      AppMethodBeat.o(338185);
      throw ((Throwable)localObject);
      localObject = ((Fragment)localObject).getActivity();
      break;
    }
    label71:
    localObject = ((FinderFinderMsgUI)localObject).EZQ;
    AppMethodBeat.o(338185);
    return localObject;
    label86:
    AppMethodBeat.o(338185);
    return null;
  }
  
  public final void a(com.tencent.mm.plugin.finder.storage.av paramav)
  {
    AppMethodBeat.i(338278);
    s.u(paramav, "mention");
    AppMethodBeat.o(338278);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_msg_notify_content_ui;
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(338229);
    super.onCreateAfter(paramBundle);
    paramBundle = k.aeZF;
    this.GSt = ((g)k.cn(PluginFinder.class).q(g.class)).Va(1);
    this.EZQ = fof();
    paramBundle = getFragment();
    if (paramBundle == null) {}
    for (paramBundle = null; paramBundle == null; paramBundle = paramBundle.getActivity())
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(338229);
      throw paramBundle;
    }
    paramBundle = (MMActivity)paramBundle;
    Object localObject1 = getRootView();
    Object localObject2 = fof();
    s.checkNotNull(localObject2);
    localObject1 = new FinderNotifyContract.NotifyViewCallback(paramBundle, (View)localObject1, (FinderNotifyContract.NotifyPresenter)localObject2, (FinderNotifyContract.NotifyViewCallback.UICallbackListener)this, this.index);
    paramBundle = this.EZQ;
    if (paramBundle != null) {
      paramBundle.a((FinderNotifyContract.NotifyViewCallback)localObject1);
    }
    ((FinderNotifyContract.NotifyViewCallback)localObject1).initView();
    paramBundle = ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().avp(GSx[this.index]);
    if (paramBundle == null) {}
    for (int i = 0;; i = paramBundle.count)
    {
      this.GSu = i;
      paramBundle = k.aeZF;
      paramBundle = getFragment();
      s.checkNotNull(paramBundle);
      paramBundle = paramBundle.getActivity();
      if (paramBundle != null) {
        break;
      }
      paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(338229);
      throw paramBundle;
    }
    localObject2 = ((am)k.d((AppCompatActivity)paramBundle).q(am.class)).Vu(this.index);
    if (((localObject2 instanceof a)) && (this.GSu > 0))
    {
      if (this.GSu > 9999)
      {
        paramBundle = "+" + this.GSu / 10000 + '万';
        Log.i("SimpleUIComponent", "setRedDot " + this.index + ':' + paramBundle);
        ((a)localObject2).aCK(paramBundle);
      }
    }
    else
    {
      if (this.GSt != this.index) {
        break label468;
      }
      paramBundle = this.EZQ;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.EZG;
        if (paramBundle != null) {
          paramBundle.set(this.index, Boolean.TRUE);
        }
      }
      ((FinderNotifyContract.NotifyViewCallback)localObject1).eIp();
      def();
      this.GSv = true;
    }
    for (;;)
    {
      if (this.GSu > 0) {
        ((PluginFinder)com.tencent.mm.kernel.h.az(PluginFinder.class)).getRedDotManager().TL(GSx[this.index]);
      }
      paramBundle = ah.aiuX;
      this.GSw = ((FinderNotifyContract.NotifyViewCallback)localObject1);
      AppMethodBeat.o(338229);
      return;
      paramBundle = s.X("+", Integer.valueOf(this.GSu));
      break;
      label468:
      def();
      if (!this.GSv)
      {
        Log.i("SimpleUIComponent", s.X("refresh index: ", Integer.valueOf(this.index)));
        ((FinderNotifyContract.NotifyViewCallback)localObject1).bDL();
        this.GSv = true;
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(338257);
    super.onPause();
    Object localObject = this.GSw;
    if (localObject != null)
    {
      localObject = ((FinderNotifyContract.NotifyViewCallback)localObject).ALE;
      if (localObject != null) {
        ((WxRecyclerAdapter)localObject).onPause();
      }
    }
    AppMethodBeat.o(338257);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(338250);
    super.onResume();
    Object localObject = this.GSw;
    if (localObject != null)
    {
      localObject = ((FinderNotifyContract.NotifyViewCallback)localObject).ALE;
      if (localObject != null) {
        ((WxRecyclerAdapter)localObject).onResume();
      }
    }
    AppMethodBeat.o(338250);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp) {}
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(338235);
    Log.i("SimpleUIComponent", "onUserVisibleFocused:" + this.GSv + "  " + this.index);
    Object localObject = this.EZQ;
    if (localObject != null)
    {
      localObject = ((FinderNotifyContract.NotifyPresenter)localObject).EZG;
      if (localObject != null) {
        ((List)localObject).set(this.index, Boolean.TRUE);
      }
    }
    AppMethodBeat.o(338235);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(338242);
    Log.i("SimpleUIComponent", "onUserVisibleUnFocused:" + this.GSv + "  " + this.index);
    AppMethodBeat.o(338242);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderNotifyUIC$Companion;", "", "()V", "pathTypes", "", "", "getPathTypes", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getCtrlPath", "index", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static String Vk(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return "";
      case 0: 
        return "NotificationCenterLike";
      case 1: 
        return "NotificationCenterComment";
      }
      return "NotificationCenterFollow";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.an
 * JD-Core Version:    0.7.0.1
 */
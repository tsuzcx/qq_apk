package com.tencent.mm.plugin.finder.wxmessage;

import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.extension.reddot.i;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract.NotifyPresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract.NotifyViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderNotifyContract.NotifyViewCallback.UICallbackListener;
import com.tencent.mm.plugin.finder.storage.av;
import com.tencent.mm.plugin.finder.ui.FinderWxMsgUI;
import com.tencent.mm.plugin.finder.viewmodel.m;
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

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/wxmessage/FinderWxMessageUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback$UICallbackListener;", "fragment", "Landroidx/fragment/app/Fragment;", "(Landroidx/fragment/app/Fragment;)V", "index", "", "getIndex", "()I", "setIndex", "(I)V", "isRefreshed", "", "lastTabIndex", "getLastTabIndex", "setLastTabIndex", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyPresenter;", "redDotCount", "getRedDotCount", "setRedDotCount", "viewCallback", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderNotifyContract$NotifyViewCallback;", "getLayoutId", "getPresenter", "onCreateAfter", "", "savedInstanceState", "Landroid/os/Bundle;", "onItemClick", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "onPause", "onResume", "onUserVisibleFocused", "onUserVisibleUnFocused", "refreshSelf", "reportExpose", "setRedDot", "unsetRedDotCount", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends UIComponent
  implements FinderNotifyContract.NotifyViewCallback.UICallbackListener
{
  private static final String[] GSx;
  public static final a Hbp;
  private FinderNotifyContract.NotifyPresenter EZQ;
  private int GSt;
  private int GSu;
  private boolean GSv;
  private FinderNotifyContract.NotifyViewCallback GSw;
  int index;
  
  static
  {
    AppMethodBeat.i(332463);
    Hbp = new a((byte)0);
    GSx = new String[] { "WxMessageLike", "WxMessageComment" };
    AppMethodBeat.o(332463);
  }
  
  public a(Fragment paramFragment)
  {
    super(paramFragment);
    AppMethodBeat.i(332447);
    this.index = -1;
    AppMethodBeat.o(332447);
  }
  
  private final FinderNotifyContract.NotifyPresenter fof()
  {
    AppMethodBeat.i(332454);
    Object localObject = getFragment();
    if (localObject == null)
    {
      localObject = null;
      if (!(localObject instanceof FinderWxMsgUI)) {
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
      localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.ui.FinderWxMsgUI");
      AppMethodBeat.o(332454);
      throw ((Throwable)localObject);
      localObject = ((Fragment)localObject).getActivity();
      break;
    }
    label71:
    localObject = ((FinderWxMsgUI)localObject).EZQ;
    AppMethodBeat.o(332454);
    return localObject;
    label86:
    AppMethodBeat.o(332454);
    return null;
  }
  
  public final void a(av paramav)
  {
    AppMethodBeat.i(332502);
    s.u(paramav, "mention");
    AppMethodBeat.o(332502);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_msg_notify_content_ui;
  }
  
  public final void onCreateAfter(Bundle paramBundle)
  {
    AppMethodBeat.i(332473);
    super.onCreateAfter(paramBundle);
    paramBundle = k.aeZF;
    this.GSt = ((m)k.cn(PluginFinder.class).q(m.class)).Va(1);
    this.EZQ = fof();
    paramBundle = getFragment();
    if (paramBundle == null) {}
    for (paramBundle = null; paramBundle == null; paramBundle = paramBundle.getActivity())
    {
      paramBundle = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(332473);
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
    paramBundle = ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().avp(GSx[this.index]);
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
      AppMethodBeat.o(332473);
      throw paramBundle;
    }
    localObject2 = ((FinderWxNotifyTabUIC)k.d((AppCompatActivity)paramBundle).q(FinderWxNotifyTabUIC.class)).Vu(this.index);
    if (((localObject2 instanceof com.tencent.mm.plugin.finder.viewmodel.notifytab.a)) && (this.GSu > 0))
    {
      if (this.GSu > 9999)
      {
        paramBundle = "+" + this.GSu / 10000 + '万';
        Log.i("SimpleUIComponent", "setRedDot " + this.index + ':' + paramBundle);
        ((com.tencent.mm.plugin.finder.viewmodel.notifytab.a)localObject2).aCK(paramBundle);
      }
    }
    else
    {
      if (this.GSt != this.index) {
        break label461;
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
      this.GSv = true;
    }
    for (;;)
    {
      if (this.GSu > 0) {
        ((PluginFinder)h.az(PluginFinder.class)).getRedDotManager().TL(GSx[this.index]);
      }
      paramBundle = ah.aiuX;
      this.GSw = ((FinderNotifyContract.NotifyViewCallback)localObject1);
      AppMethodBeat.o(332473);
      return;
      paramBundle = s.X("+", Integer.valueOf(this.GSu));
      break;
      label461:
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
    AppMethodBeat.i(332492);
    super.onPause();
    Object localObject = this.GSw;
    if (localObject != null)
    {
      localObject = ((FinderNotifyContract.NotifyViewCallback)localObject).ALE;
      if (localObject != null) {
        ((WxRecyclerAdapter)localObject).onPause();
      }
    }
    AppMethodBeat.o(332492);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(332484);
    super.onResume();
    Object localObject = this.GSw;
    if (localObject != null)
    {
      localObject = ((FinderNotifyContract.NotifyViewCallback)localObject).ALE;
      if (localObject != null) {
        ((WxRecyclerAdapter)localObject).onResume();
      }
    }
    AppMethodBeat.o(332484);
  }
  
  public final void onUserVisibleFocused()
  {
    AppMethodBeat.i(332476);
    Log.i("SimpleUIComponent", "onUserVisibleFocused:" + this.GSv + "  " + this.index);
    Object localObject = this.EZQ;
    if (localObject != null)
    {
      localObject = ((FinderNotifyContract.NotifyPresenter)localObject).EZG;
      if (localObject != null) {
        ((List)localObject).set(this.index, Boolean.TRUE);
      }
    }
    AppMethodBeat.o(332476);
  }
  
  public final void onUserVisibleUnFocused()
  {
    AppMethodBeat.i(332479);
    Log.i("SimpleUIComponent", "onUserVisibleUnFocused:" + this.GSv + "  " + this.index);
    AppMethodBeat.o(332479);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/wxmessage/FinderWxMessageUIC$Companion;", "", "()V", "pathTypes", "", "", "getPathTypes", "()[Ljava/lang/String;", "[Ljava/lang/String;", "getCtrlPath", "index", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.wxmessage.a
 * JD-Core Version:    0.7.0.1
 */
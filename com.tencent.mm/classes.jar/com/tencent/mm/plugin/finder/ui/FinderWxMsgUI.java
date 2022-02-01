package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgPresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback.UICallbackListener;
import com.tencent.mm.plugin.i.a.h;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderWxMsgUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$UICallbackListener;", "()V", "TAG", "", "commentCnt", "", "likeCnt", "msgPresenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter;", "objectLikeLikeCnt", "objectRecommendLikeCnt", "wxContact", "Lcom/tencent/mm/storage/Contact;", "getCommentScene", "getLayoutId", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onItemClick", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "plugin-finder_release"})
public final class FinderWxMsgUI
  extends MMFinderUI
  implements FinderMsgContract.MsgViewCallback.UICallbackListener
{
  private int Laa;
  private int Lab;
  private final String TAG;
  private HashMap _$_findViewCache;
  private final FinderMsgContract.MsgPresenter qQp;
  private af qQq;
  private int qQr;
  private int qQs;
  
  public FinderWxMsgUI()
  {
    AppMethodBeat.i(167688);
    this.TAG = "Finder.FinderWxMsgUI";
    this.qQp = new FinderMsgContract.MsgPresenter(2, 1, new int[] { 3, 2, 7, 8 });
    AppMethodBeat.o(167688);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(199474);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(199474);
    return localView1;
  }
  
  public final void a(com.tencent.mm.plugin.finder.storage.l paraml)
  {
    AppMethodBeat.i(167687);
    d.g.b.k.h(paraml, "mention");
    AppMethodBeat.o(167687);
  }
  
  public final int getCommentScene()
  {
    return 5;
  }
  
  public final int getLayoutId()
  {
    return 2131494128;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167685);
    Object localObject = g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class);
    d.g.b.k.g(localObject, "MMKernel.service(IMessengerStorage::class.java)");
    this.qQq = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).apM().aHY(u.aqG());
    localObject = this.qQq;
    if (localObject != null) {
      setMMTitle(getString(2131759266, new Object[] { ((af)localObject).ZW() }));
    }
    setBackBtn((MenuItem.OnMenuItemClickListener)new FinderWxMsgUI.b(this));
    localObject = (MMActivity)this;
    View localView = getContentView();
    d.g.b.k.g(localView, "contentView");
    localObject = new FinderMsgContract.MsgViewCallback((MMActivity)localObject, localView, this.qQp, (FinderMsgContract.MsgViewCallback.UICallbackListener)this);
    this.qQp.a((FinderMsgContract.MsgViewCallback)localObject);
    ((FinderMsgContract.MsgViewCallback)localObject).initView();
    localObject = g.afB();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    this.qQr = ((e)localObject).afk().getInt(ae.a.FwJ, 0);
    localObject = g.afB();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    this.qQs = ((e)localObject).afk().getInt(ae.a.FwK, 0);
    localObject = g.afB();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    this.Laa = ((e)localObject).afk().getInt(ae.a.FwK, 0);
    localObject = g.afB();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    this.Lab = ((e)localObject).afk().getInt(ae.a.FwK, 0);
    localObject = g.afB();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    ((e)localObject).afk().set(ae.a.FwJ, Integer.valueOf(0));
    localObject = g.afB();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    ((e)localObject).afk().set(ae.a.FwK, Integer.valueOf(0));
    localObject = g.afB();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    ((e)localObject).afk().set(ae.a.LBe, Integer.valueOf(0));
    localObject = g.afB();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    ((e)localObject).afk().set(ae.a.LBf, Integer.valueOf(0));
    localObject = g.ad(j.class);
    d.g.b.k.g(localObject, "MMKernel.plugin(IPluginFinder::class.java)");
    ((j)localObject).getRedDotManager().YU("TLWxBubble");
    AppMethodBeat.o(167685);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167684);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(167684);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167686);
    super.onDestroy();
    this.qQp.onDetach();
    AppMethodBeat.o(167686);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderWxMsgUI
 * JD-Core Version:    0.7.0.1
 */
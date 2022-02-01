package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgPresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback.UICallbackListener;
import com.tencent.mm.plugin.i.a.j;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/ui/FinderWxMsgUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$UICallbackListener;", "()V", "TAG", "", "commentCnt", "", "likeCnt", "msgPresenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter;", "objectLikeLikeCnt", "objectRecommendLikeCnt", "wxContact", "Lcom/tencent/mm/storage/Contact;", "getCommentScene", "getLayoutId", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onItemClick", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "plugin-finder_release"})
public final class FinderWxMsgUI
  extends MMFinderUI
  implements FinderMsgContract.MsgViewCallback.UICallbackListener
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private final FinderMsgContract.MsgPresenter rHu;
  private ai rMj;
  private int rMk;
  private int rMl;
  private int rMm;
  private int rMn;
  
  public FinderWxMsgUI()
  {
    AppMethodBeat.i(167688);
    this.TAG = "Finder.FinderWxMsgUI";
    this.rHu = new FinderMsgContract.MsgPresenter(2, 1, new int[] { 3, 2, 7, 8 });
    AppMethodBeat.o(167688);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203450);
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
    AppMethodBeat.o(203450);
    return localView1;
  }
  
  public final void a(com.tencent.mm.plugin.finder.storage.u paramu)
  {
    AppMethodBeat.i(167687);
    d.g.b.k.h(paramu, "mention");
    AppMethodBeat.o(167687);
  }
  
  public final int cuI()
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
    this.rMj = ((com.tencent.mm.plugin.messenger.foundation.a.k)localObject).awB().aNt(com.tencent.mm.model.u.axw());
    localObject = this.rMj;
    if (localObject != null) {
      setMMTitle(getString(2131759266, new Object[] { ((ai)localObject).aaR() }));
    }
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    localObject = (MMActivity)this;
    View localView = getContentView();
    d.g.b.k.g(localView, "contentView");
    localObject = new FinderMsgContract.MsgViewCallback((MMActivity)localObject, localView, this.rHu, (FinderMsgContract.MsgViewCallback.UICallbackListener)this);
    this.rHu.a((FinderMsgContract.MsgViewCallback)localObject);
    ((FinderMsgContract.MsgViewCallback)localObject).initView();
    localObject = g.agR();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    this.rMk = ((e)localObject).agA().getInt(ah.a.GUV, 0);
    localObject = g.agR();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    this.rMl = ((e)localObject).agA().getInt(ah.a.GUW, 0);
    localObject = g.agR();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    this.rMm = ((e)localObject).agA().getInt(ah.a.GUW, 0);
    localObject = g.agR();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    this.rMn = ((e)localObject).agA().getInt(ah.a.GUW, 0);
    localObject = g.agR();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    ((e)localObject).agA().set(ah.a.GUV, Integer.valueOf(0));
    localObject = g.agR();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    ((e)localObject).agA().set(ah.a.GUW, Integer.valueOf(0));
    localObject = g.agR();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    ((e)localObject).agA().set(ah.a.GUX, Integer.valueOf(0));
    localObject = g.agR();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    ((e)localObject).agA().set(ah.a.GUY, Integer.valueOf(0));
    localObject = g.ad(com.tencent.mm.plugin.i.a.l.class);
    d.g.b.k.g(localObject, "MMKernel.plugin(IPluginFinder::class.java)");
    ((com.tencent.mm.plugin.i.a.l)localObject).getRedDotManager().adv("TLWxBubble");
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
    this.rHu.onDetach();
    AppMethodBeat.o(167686);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderWxMsgUI paramFinderWxMsgUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167683);
      this.rMo.finish();
      AppMethodBeat.o(167683);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderWxMsgUI
 * JD-Core Version:    0.7.0.1
 */
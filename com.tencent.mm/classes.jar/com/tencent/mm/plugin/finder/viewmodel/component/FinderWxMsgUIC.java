package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgPresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback.UICallbackListener;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.i.a.o;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import d.g.b.p;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderWxMsgUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$UICallbackListener;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "commentCnt", "", "likeCnt", "msgPresenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter;", "objectLikeLikeCnt", "objectRecommendLikeCnt", "wxContact", "Lcom/tencent/mm/storage/Contact;", "getLayoutId", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onItemClick", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "onResume", "onStop", "plugin-finder_release"})
public final class FinderWxMsgUIC
  extends UIComponent
  implements FinderMsgContract.MsgViewCallback.UICallbackListener
{
  private final FinderMsgContract.MsgPresenter sNx;
  private an toS;
  private int toT;
  private int toU;
  private int toV;
  private int toW;
  
  public FinderWxMsgUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(206415);
    this.sNx = new FinderMsgContract.MsgPresenter(2, 1, new int[] { 3, 2, 7, 8, 11 });
    AppMethodBeat.o(206415);
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(206414);
    p.h(paramac, "mention");
    AppMethodBeat.o(206414);
  }
  
  public final int getLayoutId()
  {
    return 2131494128;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(206410);
    super.onCreate(paramBundle);
    paramBundle = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(paramBundle, "MMKernel.service(IMessengerStorage::class.java)");
    this.toS = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramBundle).azF().BH(v.aAC());
    paramBundle = this.toS;
    if (paramBundle != null) {
      getActivity().setMMTitle(getActivity().getString(2131759266, new Object[] { paramBundle.adF() }));
    }
    getActivity().setBackBtn((MenuItem.OnMenuItemClickListener)new FinderWxMsgUIC.a(this));
    paramBundle = new FinderMsgContract.MsgViewCallback(getActivity(), getRootView(), this.sNx, (FinderMsgContract.MsgViewCallback.UICallbackListener)this);
    this.sNx.a(paramBundle);
    paramBundle.initView();
    paramBundle = g.ajR();
    p.g(paramBundle, "MMKernel.storage()");
    this.toT = paramBundle.ajA().getInt(am.a.Jcf, 0);
    paramBundle = g.ajR();
    p.g(paramBundle, "MMKernel.storage()");
    this.toU = paramBundle.ajA().getInt(am.a.Jcg, 0);
    paramBundle = g.ajR();
    p.g(paramBundle, "MMKernel.storage()");
    this.toV = paramBundle.ajA().getInt(am.a.Jcg, 0);
    paramBundle = g.ajR();
    p.g(paramBundle, "MMKernel.storage()");
    this.toW = paramBundle.ajA().getInt(am.a.Jcg, 0);
    paramBundle = g.ajR();
    p.g(paramBundle, "MMKernel.storage()");
    paramBundle.ajA().set(am.a.Jcf, Integer.valueOf(0));
    paramBundle = g.ajR();
    p.g(paramBundle, "MMKernel.storage()");
    paramBundle.ajA().set(am.a.Jcg, Integer.valueOf(0));
    paramBundle = g.ajR();
    p.g(paramBundle, "MMKernel.storage()");
    paramBundle.ajA().set(am.a.Jch, Integer.valueOf(0));
    paramBundle = g.ajR();
    p.g(paramBundle, "MMKernel.storage()");
    paramBundle.ajA().set(am.a.Jci, Integer.valueOf(0));
    paramBundle = g.ajR();
    p.g(paramBundle, "MMKernel.storage()");
    paramBundle.ajA().set(am.a.Jcj, Integer.valueOf(0));
    paramBundle = g.ad(t.class);
    p.g(paramBundle, "MMKernel.plugin(IPluginFinder::class.java)");
    ((t)paramBundle).getRedDotManager().aih("TLWxBubble");
    AppMethodBeat.o(206410);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(206413);
    super.onDestroy();
    this.sNx.onDetach();
    AppMethodBeat.o(206413);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(206411);
    super.onResume();
    this.sNx.swv = System.currentTimeMillis();
    AppMethodBeat.o(206411);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(206412);
    super.onStop();
    this.sNx.onStop();
    AppMethodBeat.o(206412);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderWxMsgUIC
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgPresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback.UICallbackListener;
import com.tencent.mm.plugin.finder.storage.ac;
import com.tencent.mm.plugin.i.a.o;
import com.tencent.mm.plugin.i.a.t;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import d.g.b.p;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderWxMsgUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$UICallbackListener;", "activity", "Lcom/tencent/mm/ui/MMActivity;", "(Lcom/tencent/mm/ui/MMActivity;)V", "commentCnt", "", "likeCnt", "msgPresenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter;", "objectLikeLikeCnt", "objectRecommendLikeCnt", "wxContact", "Lcom/tencent/mm/storage/Contact;", "getLayoutId", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onItemClick", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "onResume", "onStop", "plugin-finder_release"})
public final class FinderWxMsgUIC
  extends UIComponent
  implements FinderMsgContract.MsgViewCallback.UICallbackListener
{
  private final FinderMsgContract.MsgPresenter sCy;
  private am tdZ;
  private int tea;
  private int teb;
  private int tec;
  private int ted;
  
  public FinderWxMsgUIC(MMActivity paramMMActivity)
  {
    super(paramMMActivity);
    AppMethodBeat.i(205801);
    this.sCy = new FinderMsgContract.MsgPresenter(2, 1, new int[] { 3, 2, 7, 8, 11 });
    AppMethodBeat.o(205801);
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(205800);
    p.h(paramac, "mention");
    AppMethodBeat.o(205800);
  }
  
  public final int getLayoutId()
  {
    return 2131494128;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(205796);
    super.onCreate(paramBundle);
    paramBundle = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(paramBundle, "MMKernel.service(IMessengerStorage::class.java)");
    this.tdZ = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramBundle).azp().Bf(u.aAm());
    paramBundle = this.tdZ;
    if (paramBundle != null) {
      getActivity().setMMTitle(getActivity().getString(2131759266, new Object[] { paramBundle.adu() }));
    }
    getActivity().setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    paramBundle = new FinderMsgContract.MsgViewCallback(getActivity(), getRootView(), this.sCy, (FinderMsgContract.MsgViewCallback.UICallbackListener)this);
    this.sCy.a(paramBundle);
    paramBundle.initView();
    paramBundle = g.ajC();
    p.g(paramBundle, "MMKernel.storage()");
    this.tea = paramBundle.ajl().getInt(al.a.IHC, 0);
    paramBundle = g.ajC();
    p.g(paramBundle, "MMKernel.storage()");
    this.teb = paramBundle.ajl().getInt(al.a.IHD, 0);
    paramBundle = g.ajC();
    p.g(paramBundle, "MMKernel.storage()");
    this.tec = paramBundle.ajl().getInt(al.a.IHD, 0);
    paramBundle = g.ajC();
    p.g(paramBundle, "MMKernel.storage()");
    this.ted = paramBundle.ajl().getInt(al.a.IHD, 0);
    paramBundle = g.ajC();
    p.g(paramBundle, "MMKernel.storage()");
    paramBundle.ajl().set(al.a.IHC, Integer.valueOf(0));
    paramBundle = g.ajC();
    p.g(paramBundle, "MMKernel.storage()");
    paramBundle.ajl().set(al.a.IHD, Integer.valueOf(0));
    paramBundle = g.ajC();
    p.g(paramBundle, "MMKernel.storage()");
    paramBundle.ajl().set(al.a.IHE, Integer.valueOf(0));
    paramBundle = g.ajC();
    p.g(paramBundle, "MMKernel.storage()");
    paramBundle.ajl().set(al.a.IHF, Integer.valueOf(0));
    paramBundle = g.ajC();
    p.g(paramBundle, "MMKernel.storage()");
    paramBundle.ajl().set(al.a.IHG, Integer.valueOf(0));
    paramBundle = g.ad(t.class);
    p.g(paramBundle, "MMKernel.plugin(IPluginFinder::class.java)");
    ((t)paramBundle).getRedDotManager().ahl("TLWxBubble");
    AppMethodBeat.o(205796);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(205799);
    super.onDestroy();
    this.sCy.onDetach();
    AppMethodBeat.o(205799);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(205797);
    super.onResume();
    this.sCy.smE = System.currentTimeMillis();
    AppMethodBeat.o(205797);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(205798);
    super.onStop();
    this.sCy.onStop();
    AppMethodBeat.o(205798);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderWxMsgUIC paramFinderWxMsgUIC) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(205795);
      this.tee.getActivity().finish();
      AppMethodBeat.o(205795);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderWxMsgUIC
 * JD-Core Version:    0.7.0.1
 */
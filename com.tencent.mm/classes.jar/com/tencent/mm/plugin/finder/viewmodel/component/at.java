package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.view.MenuItem.OnMenuItemClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgPresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback.UICallbackListener;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderWxMsgUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$UICallbackListener;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "commentCnt", "", "likeCnt", "msgPresenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter;", "objectLikeLikeCnt", "objectRecommendLikeCnt", "wxContact", "Lcom/tencent/mm/storage/Contact;", "getLayoutId", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onItemClick", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "onResume", "onStop", "plugin-finder_release"})
public final class at
  extends UIComponent
  implements FinderMsgContract.MsgViewCallback.UICallbackListener
{
  private final FinderMsgContract.MsgPresenter AqP;
  private as BpJ;
  private int BpK;
  private int BpL;
  private int BpM;
  private int BpN;
  
  public at(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(281769);
    this.AqP = new FinderMsgContract.MsgPresenter(2, 1, new int[] { 3, 2, 7, 8, 11 });
    AppMethodBeat.o(281769);
  }
  
  public final void a(an paraman)
  {
    AppMethodBeat.i(281768);
    p.k(paraman, "mention");
    AppMethodBeat.o(281768);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_wx_msg_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(281763);
    super.onCreate(paramBundle);
    paramBundle = h.ae(n.class);
    p.j(paramBundle, "MMKernel.service(IMessengerStorage::class.java)");
    this.BpJ = ((n)paramBundle).bbL().RG(com.tencent.mm.model.z.bcZ());
    paramBundle = this.BpJ;
    if (paramBundle != null)
    {
      AppCompatActivity localAppCompatActivity = getActivity();
      if (localAppCompatActivity == null)
      {
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(281763);
        throw paramBundle;
      }
      ((MMActivity)localAppCompatActivity).setMMTitle(getActivity().getString(b.j.finder_msg_of_wx_title, new Object[] { paramBundle.ayr() }));
    }
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(281763);
      throw paramBundle;
    }
    ((MMActivity)paramBundle).setBackBtn((MenuItem.OnMenuItemClickListener)new at.a(this));
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(281763);
      throw paramBundle;
    }
    paramBundle = new FinderMsgContract.MsgViewCallback((MMActivity)paramBundle, getRootView(), this.AqP, (FinderMsgContract.MsgViewCallback.UICallbackListener)this);
    this.AqP.a(paramBundle);
    paramBundle.initView();
    paramBundle = h.aHG();
    p.j(paramBundle, "MMKernel.storage()");
    this.BpK = paramBundle.aHp().getInt(ar.a.VAb, 0);
    paramBundle = h.aHG();
    p.j(paramBundle, "MMKernel.storage()");
    this.BpL = paramBundle.aHp().getInt(ar.a.VAc, 0);
    paramBundle = h.aHG();
    p.j(paramBundle, "MMKernel.storage()");
    this.BpM = paramBundle.aHp().getInt(ar.a.VAc, 0);
    paramBundle = h.aHG();
    p.j(paramBundle, "MMKernel.storage()");
    this.BpN = paramBundle.aHp().getInt(ar.a.VAc, 0);
    paramBundle = h.aHG();
    p.j(paramBundle, "MMKernel.storage()");
    paramBundle.aHp().set(ar.a.VAb, Integer.valueOf(0));
    paramBundle = h.aHG();
    p.j(paramBundle, "MMKernel.storage()");
    paramBundle.aHp().set(ar.a.VAc, Integer.valueOf(0));
    paramBundle = h.aHG();
    p.j(paramBundle, "MMKernel.storage()");
    paramBundle.aHp().set(ar.a.VAd, Integer.valueOf(0));
    paramBundle = h.aHG();
    p.j(paramBundle, "MMKernel.storage()");
    paramBundle.aHp().set(ar.a.VAe, Integer.valueOf(0));
    paramBundle = h.aHG();
    p.j(paramBundle, "MMKernel.storage()");
    paramBundle.aHp().set(ar.a.VAf, Integer.valueOf(0));
    paramBundle = h.ag(ak.class);
    p.j(paramBundle, "MMKernel.plugin(IPluginFinder::class.java)");
    ((ak)paramBundle).getRedDotManager().aBd("TLWxBubble");
    AppMethodBeat.o(281763);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(281767);
    super.onDestroy();
    this.AqP.onDetach();
    AppMethodBeat.o(281767);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(281765);
    super.onResume();
    this.AqP.zOE = System.currentTimeMillis();
    AppMethodBeat.o(281765);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(281766);
    super.onStop();
    this.AqP.onStop();
    AppMethodBeat.o(281766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.at
 * JD-Core Version:    0.7.0.1
 */
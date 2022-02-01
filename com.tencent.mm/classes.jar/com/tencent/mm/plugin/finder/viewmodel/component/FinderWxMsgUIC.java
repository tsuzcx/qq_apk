package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgPresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback.UICallbackListener;
import com.tencent.mm.plugin.i.a.aj;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.g.b.p;
import kotlin.t;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderWxMsgUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$UICallbackListener;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "commentCnt", "", "likeCnt", "msgPresenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter;", "objectLikeLikeCnt", "objectRecommendLikeCnt", "wxContact", "Lcom/tencent/mm/storage/Contact;", "getLayoutId", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onItemClick", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "onResume", "onStop", "plugin-finder_release"})
public final class FinderWxMsgUIC
  extends UIComponent
  implements FinderMsgContract.MsgViewCallback.UICallbackListener
{
  private final FinderMsgContract.MsgPresenter vJX;
  private as wBE;
  private int wBF;
  private int wBG;
  private int wBH;
  private int wBI;
  
  public FinderWxMsgUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(256097);
    this.vJX = new FinderMsgContract.MsgPresenter(2, 1, new int[] { 3, 2, 7, 8, 11 });
    AppMethodBeat.o(256097);
  }
  
  public final void a(com.tencent.mm.plugin.finder.storage.ao paramao)
  {
    AppMethodBeat.i(256096);
    p.h(paramao, "mention");
    AppMethodBeat.o(256096);
  }
  
  public final int getLayoutId()
  {
    return 2131494679;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(256092);
    super.onCreate(paramBundle);
    paramBundle = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(paramBundle, "MMKernel.service(IMessengerStorage::class.java)");
    this.wBE = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramBundle).aSN().Kn(com.tencent.mm.model.z.aTY());
    paramBundle = this.wBE;
    if (paramBundle != null)
    {
      AppCompatActivity localAppCompatActivity = getActivity();
      if (localAppCompatActivity == null)
      {
        paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
        AppMethodBeat.o(256092);
        throw paramBundle;
      }
      ((MMActivity)localAppCompatActivity).setMMTitle(getActivity().getString(2131760303, new Object[] { paramBundle.arI() }));
    }
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(256092);
      throw paramBundle;
    }
    ((MMActivity)paramBundle).setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(256092);
      throw paramBundle;
    }
    paramBundle = new FinderMsgContract.MsgViewCallback((MMActivity)paramBundle, getRootView(), this.vJX, (FinderMsgContract.MsgViewCallback.UICallbackListener)this);
    this.vJX.a(paramBundle);
    paramBundle.initView();
    paramBundle = g.aAh();
    p.g(paramBundle, "MMKernel.storage()");
    this.wBF = paramBundle.azQ().getInt(ar.a.Olg, 0);
    paramBundle = g.aAh();
    p.g(paramBundle, "MMKernel.storage()");
    this.wBG = paramBundle.azQ().getInt(ar.a.Olh, 0);
    paramBundle = g.aAh();
    p.g(paramBundle, "MMKernel.storage()");
    this.wBH = paramBundle.azQ().getInt(ar.a.Olh, 0);
    paramBundle = g.aAh();
    p.g(paramBundle, "MMKernel.storage()");
    this.wBI = paramBundle.azQ().getInt(ar.a.Olh, 0);
    paramBundle = g.aAh();
    p.g(paramBundle, "MMKernel.storage()");
    paramBundle.azQ().set(ar.a.Olg, Integer.valueOf(0));
    paramBundle = g.aAh();
    p.g(paramBundle, "MMKernel.storage()");
    paramBundle.azQ().set(ar.a.Olh, Integer.valueOf(0));
    paramBundle = g.aAh();
    p.g(paramBundle, "MMKernel.storage()");
    paramBundle.azQ().set(ar.a.Oli, Integer.valueOf(0));
    paramBundle = g.aAh();
    p.g(paramBundle, "MMKernel.storage()");
    paramBundle.azQ().set(ar.a.Olj, Integer.valueOf(0));
    paramBundle = g.aAh();
    p.g(paramBundle, "MMKernel.storage()");
    paramBundle.azQ().set(ar.a.Olk, Integer.valueOf(0));
    paramBundle = g.ah(aj.class);
    p.g(paramBundle, "MMKernel.plugin(IPluginFinder::class.java)");
    ((aj)paramBundle).getRedDotManager().asV("TLWxBubble");
    AppMethodBeat.o(256092);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(256095);
    super.onDestroy();
    this.vJX.onDetach();
    AppMethodBeat.o(256095);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(256093);
    super.onResume();
    this.vJX.uYq = System.currentTimeMillis();
    AppMethodBeat.o(256093);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(256094);
    super.onStop();
    this.vJX.onStop();
    AppMethodBeat.o(256094);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(FinderWxMsgUIC paramFinderWxMsgUIC) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(256091);
      this.wBJ.getActivity().finish();
      AppMethodBeat.o(256091);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.FinderWxMsgUIC
 * JD-Core Version:    0.7.0.1
 */
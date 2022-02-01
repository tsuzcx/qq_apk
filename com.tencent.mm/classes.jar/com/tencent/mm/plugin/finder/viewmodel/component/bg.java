package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgPresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback;
import com.tencent.mm.plugin.finder.presenter.contract.FinderMsgContract.MsgViewCallback.UICallbackListener;
import com.tencent.mm.plugin.finder.storage.av;
import com.tencent.mm.plugin.findersdk.a.bl;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderWxMsgUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgViewCallback$UICallbackListener;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "commentCnt", "", "likeCnt", "msgPresenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderMsgContract$MsgPresenter;", "objectLikeLikeCnt", "objectRecommendLikeCnt", "wxContact", "Lcom/tencent/mm/storage/Contact;", "getLayoutId", "initView", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onItemClick", "mention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "onResume", "onStop", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class bg
  extends UIComponent
  implements FinderMsgContract.MsgViewCallback.UICallbackListener
{
  private final FinderMsgContract.MsgPresenter FQC;
  private au GWq;
  private int GWr;
  private int GWs;
  private int GWt;
  private int GWu;
  
  public bg(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338298);
    this.FQC = new FinderMsgContract.MsgPresenter(2, 1, new int[] { 3, 2, 7, 8 });
    AppMethodBeat.o(338298);
  }
  
  private static final boolean a(bg parambg, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(338304);
    s.u(parambg, "this$0");
    parambg.getActivity().finish();
    AppMethodBeat.o(338304);
    return true;
  }
  
  public final void a(av paramav)
  {
    AppMethodBeat.i(338360);
    s.u(paramav, "mention");
    AppMethodBeat.o(338360);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_msg_list_layout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(338324);
    super.onCreate(paramBundle);
    this.GWq = ((n)h.ax(n.class)).bzA().JE(z.bAM());
    paramBundle = this.GWq;
    if (paramBundle != null) {
      ((MMActivity)getActivity()).setMMTitle(getActivity().getString(e.h.finder_msg_of_wx_title, new Object[] { paramBundle.aSU() }));
    }
    ((MMActivity)getActivity()).setBackBtn(new bg..ExternalSyntheticLambda0(this));
    paramBundle = new FinderMsgContract.MsgViewCallback((MMActivity)getActivity(), getRootView(), this.FQC, (FinderMsgContract.MsgViewCallback.UICallbackListener)this);
    this.FQC.a(paramBundle);
    paramBundle.initView();
    this.GWr = h.baE().ban().getInt(at.a.adcq, 0);
    this.GWs = h.baE().ban().getInt(at.a.adcs, 0);
    this.GWt = h.baE().ban().getInt(at.a.adcs, 0);
    this.GWu = h.baE().ban().getInt(at.a.adcs, 0);
    h.baE().ban().set(at.a.adcq, Integer.valueOf(0));
    h.baE().ban().set(at.a.adcs, Integer.valueOf(0));
    h.baE().ban().set(at.a.adct, Integer.valueOf(0));
    h.baE().ban().set(at.a.adcu, Integer.valueOf(0));
    h.baE().ban().set(at.a.adcv, Integer.valueOf(0));
    h.baE().ban().set(at.a.adcw, Integer.valueOf(0));
    ((cn)h.az(cn.class)).getRedDotManager().TL("TLWxBubble");
    AppMethodBeat.o(338324);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(338352);
    super.onDestroy();
    this.FQC.onDetach();
    AppMethodBeat.o(338352);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(338331);
    super.onResume();
    this.FQC.EZn = System.currentTimeMillis();
    AppMethodBeat.o(338331);
  }
  
  public final void onStop()
  {
    AppMethodBeat.i(338336);
    super.onStop();
    this.FQC.onStop();
    AppMethodBeat.o(338336);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.bg
 * JD-Core Version:    0.7.0.1
 */
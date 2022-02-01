package com.tencent.mm.plugin.finder.viewmodel.component;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.feed.model.internal.BaseFeedLoader;
import com.tencent.mm.plugin.finder.live.loader.FinderLivePurchaseListLoader;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLivePurchaseListContract.PurchaseListPresenter;
import com.tencent.mm.plugin.finder.presenter.contract.FinderLivePurchaseListContract.PurchaseListViewCallback;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/viewmodel/component/FinderLivePurchaseListUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "presenter", "Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLivePurchaseListContract$PurchaseListPresenter;", "getPresenter", "()Lcom/tencent/mm/plugin/finder/presenter/contract/FinderLivePurchaseListContract$PurchaseListPresenter;", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ak
  extends UIComponent
{
  private final FinderLivePurchaseListContract.PurchaseListPresenter EYw;
  
  public ak(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(338737);
    this.EYw = new FinderLivePurchaseListContract.PurchaseListPresenter((BaseFeedLoader)new FinderLivePurchaseListLoader());
    AppMethodBeat.o(338737);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_live_purchase_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(338749);
    super.onCreate(paramBundle);
    paramBundle = new FinderLivePurchaseListContract.PurchaseListViewCallback((MMActivity)getActivity(), this.EYw, getRootView());
    this.EYw.a(paramBundle);
    AppMethodBeat.o(338749);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(338753);
    super.onDestroy();
    this.EYw.onDetach();
    AppMethodBeat.o(338753);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.viewmodel.component.ak
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.card.ui.v4;

import androidx.lifecycle.af;
import androidx.lifecycle.x;
import com.tencent.mm.protocal.protobuf.vx;
import com.tencent.mm.vending.e.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/card/ui/v4/CardsViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "cardListState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/card/ui/v4/FetchCardListState;", "getCardListState", "()Landroidx/lifecycle/MutableLiveData;", "setCardListState", "(Landroidx/lifecycle/MutableLiveData;)V", "cardListViewData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "Lkotlin/collections/ArrayList;", "getCardListViewData", "setCardListViewData", "isShowProgressDialog", "", "setShowProgressDialog", "jumpUrlOption", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "getJumpUrlOption", "setJumpUrlOption", "rightTopOptionMenuData", "", "getRightTopOptionMenuData", "setRightTopOptionMenuData", "forceRefreshCardList", "", "keeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Landroidx/lifecycle/LiveData;", "loadSnapshot", "performDeleteCard", "cardDataModel", "performMenuItemClicked", "index", "", "refreshCardListIncrementally", "saveSnapshot", "plugin-card_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class d
  extends af
{
  x<List<vx>> wIm = new x();
  x<vx> wIn = new x();
  x<ArrayList<a>> wIo = new x();
  x<g> wIp = new x();
  x<Boolean> wIq = new x();
  
  public final void IK(int paramInt)
  {
    x localx = this.wIn;
    Object localObject = (List)this.wIm.getValue();
    if (localObject == null) {}
    for (localObject = null;; localObject = (vx)((List)localObject).get(paramInt))
    {
      localx.t(localObject);
      return;
    }
  }
  
  public abstract void a(a parama);
  
  public abstract void c(b<?> paramb);
  
  public abstract void d(b<?> paramb);
  
  public abstract void doC();
  
  public abstract void doD();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.d
 * JD-Core Version:    0.7.0.1
 */
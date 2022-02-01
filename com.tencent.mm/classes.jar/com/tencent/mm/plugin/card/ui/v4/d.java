package com.tencent.mm.plugin.card.ui.v4;

import androidx.lifecycle.r;
import androidx.lifecycle.x;
import com.tencent.mm.protocal.protobuf.ug;
import com.tencent.mm.vending.e.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/card/ui/v4/CardsViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "cardListState", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/card/ui/v4/FetchCardListState;", "getCardListState", "()Landroidx/lifecycle/MutableLiveData;", "setCardListState", "(Landroidx/lifecycle/MutableLiveData;)V", "cardListViewData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "Lkotlin/collections/ArrayList;", "getCardListViewData", "setCardListViewData", "isShowProgressDialog", "", "setShowProgressDialog", "jumpUrlOption", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "getJumpUrlOption", "setJumpUrlOption", "rightTopOptionMenuData", "", "getRightTopOptionMenuData", "setRightTopOptionMenuData", "forceRefreshCardList", "", "keeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Landroidx/lifecycle/LiveData;", "loadSnapshot", "performDeleteCard", "cardDataModel", "performMenuItemClicked", "index", "", "refreshCardListIncrementally", "saveSnapshot", "plugin-card_release"})
public abstract class d
  extends x
{
  r<List<ug>> tEJ = new r();
  r<ug> tEK = new r();
  r<ArrayList<a>> tEL = new r();
  r<h> tEM = new r();
  r<Boolean> tEN = new r();
  
  public final void Ih(int paramInt)
  {
    r localr = this.tEK;
    Object localObject = (List)this.tEJ.getValue();
    if (localObject != null) {}
    for (localObject = (ug)((List)localObject).get(paramInt);; localObject = null)
    {
      localr.L(localObject);
      return;
    }
  }
  
  public abstract void a(a parama);
  
  public abstract void c(b<?> paramb);
  
  public abstract void cKW();
  
  public abstract void cKX();
  
  public abstract void d(b<?> paramb);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.d
 * JD-Core Version:    0.7.0.1
 */
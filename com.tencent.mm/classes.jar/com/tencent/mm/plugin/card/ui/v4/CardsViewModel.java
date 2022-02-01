package com.tencent.mm.plugin.card.ui.v4;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.vending.e.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/card/ui/v4/CardsViewModel;", "Landroid/arch/lifecycle/ViewModel;", "()V", "cardListState", "Landroid/arch/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/card/ui/v4/FetchCardListState;", "getCardListState", "()Landroid/arch/lifecycle/MutableLiveData;", "setCardListState", "(Landroid/arch/lifecycle/MutableLiveData;)V", "cardListViewData", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/card/ui/v4/CardDataModel;", "Lkotlin/collections/ArrayList;", "getCardListViewData", "setCardListViewData", "isShowProgressDialog", "", "setShowProgressDialog", "jumpUrlOption", "Lcom/tencent/mm/protocal/protobuf/CardHomePageFAQItem;", "getJumpUrlOption", "setJumpUrlOption", "rightTopOptionMenuData", "", "getRightTopOptionMenuData", "setRightTopOptionMenuData", "forceRefreshCardList", "", "keeper", "Lcom/tencent/mm/vending/lifecycle/ILifeCycleKeeper;", "Landroid/arch/lifecycle/LiveData;", "loadSnapshot", "performDeleteCard", "cardDataModel", "performMenuItemClicked", "index", "", "refreshCardListIncrementally", "saveSnapshot", "plugin-card_release"})
public abstract class CardsViewModel
  extends ViewModel
{
  MutableLiveData<List<ue>> qiN = new MutableLiveData();
  MutableLiveData<ue> qiO = new MutableLiveData();
  MutableLiveData<ArrayList<a>> qiP = new MutableLiveData();
  MutableLiveData<e> qiQ = new MutableLiveData();
  MutableLiveData<Boolean> qiR = new MutableLiveData();
  
  public final void EG(int paramInt)
  {
    MutableLiveData localMutableLiveData = this.qiO;
    Object localObject = (List)this.qiN.getValue();
    if (localObject != null) {}
    for (localObject = (ue)((List)localObject).get(paramInt);; localObject = null)
    {
      localMutableLiveData.postValue(localObject);
      return;
    }
  }
  
  public abstract void a(a parama);
  
  public abstract void c(b<?> paramb);
  
  public abstract void cxu();
  
  public abstract void cxv();
  
  public abstract void d(b<?> paramb);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.ui.v4.CardsViewModel
 * JD-Core Version:    0.7.0.1
 */
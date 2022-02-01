package com.tencent.mm.plugin.appbrand.phonenumber;

import android.view.View;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManagerView;", "", "getView", "Landroid/view/View;", "updateView", "", "showDelete", "", "phoneItems", "", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface p
{
  public abstract void d(boolean paramBoolean, List<PhoneItem> paramList);
  
  public abstract View getView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.p
 * JD-Core Version:    0.7.0.1
 */
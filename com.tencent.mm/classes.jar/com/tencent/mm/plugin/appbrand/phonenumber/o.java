package com.tencent.mm.plugin.appbrand.phonenumber;

import android.text.SpannableString;
import android.view.View;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;", "", "addPhone", "", "editPhoneNumber", "enableEdit", "", "finishEdit", "getSpanString", "Landroid/text/SpannableString;", "getView", "Landroid/view/View;", "init", "removePhone", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "uninit", "updateView", "showDelete", "luggage-wechat-full-sdk_release"})
public abstract interface o
{
  public abstract void a(PhoneItem paramPhoneItem);
  
  public abstract void bsp();
  
  public abstract SpannableString bsq();
  
  public abstract void bsr();
  
  public abstract View getView();
  
  public abstract void hj(boolean paramBoolean);
  
  public abstract void hk(boolean paramBoolean);
  
  public abstract void init();
  
  public abstract void uninit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.o
 * JD-Core Version:    0.7.0.1
 */
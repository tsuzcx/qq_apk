package com.tencent.mm.plugin.appbrand.phonenumber;

import android.text.SpannableString;
import android.view.View;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;", "", "addPhone", "", "editPhoneNumber", "enableEdit", "", "finishEdit", "getSpanString", "Landroid/text/SpannableString;", "getView", "Landroid/view/View;", "init", "removePhone", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "uninit", "updateView", "showDelete", "luggage-wechat-full-sdk_release"})
public abstract interface o
{
  public abstract void a(PhoneItem paramPhoneItem);
  
  public abstract void bxl();
  
  public abstract SpannableString bxm();
  
  public abstract void bxn();
  
  public abstract View getView();
  
  public abstract void hr(boolean paramBoolean);
  
  public abstract void hs(boolean paramBoolean);
  
  public abstract void init();
  
  public abstract void uninit();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.o
 * JD-Core Version:    0.7.0.1
 */
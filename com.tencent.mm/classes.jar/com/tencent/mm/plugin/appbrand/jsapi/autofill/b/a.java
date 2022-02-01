package com.tencent.mm.plugin.appbrand.jsapi.autofill.b;

import com.tencent.mm.plugin.appbrand.permission.h;
import com.tencent.mm.plugin.appbrand.phonenumber.PhoneItem;
import java.util.ArrayList;
import kotlin.g.a.b;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/appbrand/jsapi/autofill/ui/IPhoneNumberManagerPresenterView;", "Lcom/tencent/mm/plugin/appbrand/permission/IAuthorizePromptPresenterView;", "appBrandName", "", "getAppBrandName", "()Ljava/lang/String;", "setAppBrandName", "(Ljava/lang/String;)V", "iconUrl", "getIconUrl", "setIconUrl", "onAccept", "Lkotlin/Function0;", "", "getOnAccept", "()Lkotlin/jvm/functions/Function0;", "setOnAccept", "(Lkotlin/jvm/functions/Function0;)V", "onAddPhoneNumber", "getOnAddPhoneNumber", "setOnAddPhoneNumber", "onCancel", "getOnCancel", "setOnCancel", "onDeny", "getOnDeny", "setOnDeny", "onExplain", "getOnExplain", "setOnExplain", "onManagePhoneNumber", "getOnManagePhoneNumber", "setOnManagePhoneNumber", "onPhoneItemSelect", "Lkotlin/Function1;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "getOnPhoneItemSelect", "()Lkotlin/jvm/functions/Function1;", "setOnPhoneItemSelect", "(Lkotlin/jvm/functions/Function1;)V", "phoneItems", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getPhoneItems", "()Ljava/util/ArrayList;", "setPhoneItems", "(Ljava/util/ArrayList;)V", "showPrivacyExplainEntry", "show", "", "Factory", "FactoryInterface", "luggage-wechat-full-sdk_release"})
public abstract interface a
  extends h
{
  public abstract void hm(boolean paramBoolean);
  
  public abstract void setAppBrandName(String paramString);
  
  public abstract void setIconUrl(String paramString);
  
  public abstract void setOnAddPhoneNumber(kotlin.g.a.a<x> parama);
  
  public abstract void setOnCancel(kotlin.g.a.a<x> parama);
  
  public abstract void setOnDeny(kotlin.g.a.a<x> parama);
  
  public abstract void setOnExplain(kotlin.g.a.a<x> parama);
  
  public abstract void setOnManagePhoneNumber(kotlin.g.a.a<x> parama);
  
  public abstract void setOnPhoneItemSelect(b<? super PhoneItem, x> paramb);
  
  public abstract void setPhoneItems(ArrayList<PhoneItem> paramArrayList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.autofill.b.a
 * JD-Core Version:    0.7.0.1
 */
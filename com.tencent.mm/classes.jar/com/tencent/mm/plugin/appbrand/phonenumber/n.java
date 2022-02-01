package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import d.g.a.a;
import d.g.a.b;
import d.g.a.m;
import java.util.Map;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberLogic;", "", "addPhoneNumber", "", "context", "Landroid/content/Context;", "appId", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "resultCode", "Landroid/content/Intent;", "data", "bindWxPhone", "Lkotlin/Function1;", "createPhoneNumberAddLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "onDone", "Lkotlin/Function0;", "createPhoneNumberManageLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;", "pagePath", "getExposeSpan", "Landroid/text/SpannableString;", "hideVKB", "managePhoneNumber", "report", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "showEditEntry", "", "showVKB", "verifyPhoneNumber", "extDesc", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "isSuccess", "", "result", "luggage-wechat-full-sdk_release"})
public abstract interface n
{
  public abstract l a(Context paramContext, String paramString, a<d.y> parama);
  
  public abstract void a(Context paramContext, b<? super Integer, d.y> paramb);
  
  public abstract void a(Context paramContext, String paramString, m<? super Integer, ? super Intent, d.y> paramm);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, y paramy, PhoneItem paramPhoneItem, m<? super Boolean, ? super Map<String, String>, d.y> paramm);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, m<? super Integer, ? super Intent, d.y> paramm);
  
  public abstract void a(y paramy);
  
  public abstract void dh(Context paramContext);
  
  public abstract void di(Context paramContext);
  
  public abstract SpannableString n(Context paramContext, String paramString1, String paramString2);
  
  public abstract o s(Context paramContext, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.n
 * JD-Core Version:    0.7.0.1
 */
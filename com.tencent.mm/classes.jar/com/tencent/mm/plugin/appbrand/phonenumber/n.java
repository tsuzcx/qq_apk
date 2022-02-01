package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberLogic;", "", "addPhoneNumber", "", "context", "Landroid/content/Context;", "appId", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "resultCode", "Landroid/content/Intent;", "data", "bindWxPhone", "Lkotlin/Function1;", "createPhoneNumberAddLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "onDone", "Lkotlin/Function0;", "createPhoneNumberManageLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;", "pagePath", "getExposeSpan", "Landroid/text/SpannableString;", "hideVKB", "managePhoneNumber", "report", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "showEditEntry", "", "showVKB", "verifyPhoneNumber", "extDesc", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "isSuccess", "", "result", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface n
{
  public abstract l a(Context paramContext, String paramString, a<ah> parama);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, y paramy, PhoneItem paramPhoneItem, m<? super Boolean, ? super Map<String, String>, ah> paramm);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, m<? super Integer, ? super Intent, ah> paramm);
  
  public abstract void a(Context paramContext, String paramString, m<? super Integer, ? super Intent, ah> paramm);
  
  public abstract void a(Context paramContext, b<? super Integer, ah> paramb);
  
  public abstract void a(y paramy);
  
  public abstract boolean cHs();
  
  public abstract void eE(Context paramContext);
  
  public abstract void eF(Context paramContext);
  
  public abstract SpannableString s(Context paramContext, String paramString1, String paramString2);
  
  public abstract o w(Context paramContext, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.n
 * JD-Core Version:    0.7.0.1
 */
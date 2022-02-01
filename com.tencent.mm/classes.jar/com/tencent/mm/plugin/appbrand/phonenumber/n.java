package com.tencent.mm.plugin.appbrand.phonenumber;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import d.g.a.a;
import d.g.a.b;
import d.g.a.m;
import d.z;
import java.util.Map;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberLogic;", "", "addPhoneNumber", "", "context", "Landroid/content/Context;", "appId", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "resultCode", "Landroid/content/Intent;", "data", "bindWxPhone", "Lkotlin/Function1;", "createPhoneNumberAddLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "onDone", "Lkotlin/Function0;", "createPhoneNumberManageLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;", "pagePath", "getExposeSpan", "Landroid/text/SpannableString;", "hideVKB", "managePhoneNumber", "report", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "showEditEntry", "", "showVKB", "verifyPhoneNumber", "extDesc", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "isSuccess", "", "result", "luggage-wechat-full-sdk_release"})
public abstract interface n
{
  public abstract l a(Context paramContext, String paramString, a<z> parama);
  
  public abstract void a(Context paramContext, b<? super Integer, z> paramb);
  
  public abstract void a(Context paramContext, String paramString, m<? super Integer, ? super Intent, z> paramm);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, y paramy, PhoneItem paramPhoneItem, m<? super Boolean, ? super Map<String, String>, z> paramm);
  
  public abstract void a(Context paramContext, String paramString1, String paramString2, m<? super Integer, ? super Intent, z> paramm);
  
  public abstract void a(y paramy);
  
  public abstract void jdMethod_do(Context paramContext);
  
  public abstract void dp(Context paramContext);
  
  public abstract SpannableString o(Context paramContext, String paramString1, String paramString2);
  
  public abstract o t(Context paramContext, String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.n
 * JD-Core Version:    0.7.0.1
 */
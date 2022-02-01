package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.BaseActivity;
import d.g.a.a;
import d.g.a.b;
import d.g.a.m;
import d.g.b.ad;
import d.g.b.p;
import d.z;
import java.util.Arrays;
import java.util.Map;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/appbrand/phonenumber/DefaultPhoneNumberLogic;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberLogic;", "()V", "addPhoneNumber", "", "context", "Landroid/content/Context;", "appId", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "resultCode", "Landroid/content/Intent;", "data", "bindWxPhone", "Lkotlin/Function1;", "createPhoneNumberAddLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "onDone", "Lkotlin/Function0;", "createPhoneNumberManageLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;", "pagePath", "getExposeSpan", "Landroid/text/SpannableString;", "hideVKB", "managePhoneNumber", "report", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "showEditEntry", "", "showVKB", "verifyPhoneNumber", "extDesc", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "isSuccess", "", "result", "Companion", "luggage-wechat-full-sdk_release"})
public class i
  implements n
{
  @Deprecated
  public static final i.a moq;
  
  static
  {
    AppMethodBeat.i(183076);
    moq = new i.a((byte)0);
    AppMethodBeat.o(183076);
  }
  
  public final l a(Context paramContext, String paramString, a<z> parama)
  {
    AppMethodBeat.i(148049);
    p.h(paramContext, "context");
    p.h(paramString, "appId");
    p.h(parama, "onDone");
    paramContext = (l)new s(paramContext, paramString, parama);
    AppMethodBeat.o(148049);
    return paramContext;
  }
  
  public void a(Context paramContext, b<? super Integer, z> paramb)
  {
    AppMethodBeat.i(148053);
    p.h(paramContext, "context");
    p.h(paramb, "callback");
    paramb.invoke(Integer.valueOf(0));
    AppMethodBeat.o(148053);
  }
  
  public final void a(Context paramContext, String paramString, m<? super Integer, ? super Intent, z> paramm)
  {
    AppMethodBeat.i(148051);
    p.h(paramContext, "context");
    p.h(paramString, "appId");
    p.h(paramm, "callback");
    e locale = e.aB(paramContext);
    paramContext = new Intent(paramContext, PhoneNumberAddUI.class);
    paramContext.putExtra("APPID", paramString);
    locale.a(paramContext, (e.b)new i.b(paramm));
    AppMethodBeat.o(148051);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, y paramy, PhoneItem paramPhoneItem, m<? super Boolean, ? super Map<String, String>, z> paramm)
  {
    AppMethodBeat.i(220997);
    p.h(paramContext, "context");
    p.h(paramString1, "appId");
    p.h(paramString2, "extDesc");
    p.h(paramPhoneItem, "phoneItem");
    p.h(paramm, "callback");
    new aa(paramContext, paramString1, paramy, paramString2, paramPhoneItem, (aa.b)new i.d(paramm)).hu(true);
    AppMethodBeat.o(220997);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, m<? super Integer, ? super Intent, z> paramm)
  {
    AppMethodBeat.i(148052);
    p.h(paramContext, "context");
    p.h(paramString1, "appId");
    p.h(paramString2, "pagePath");
    p.h(paramm, "callback");
    e locale = e.aB(paramContext);
    paramContext = new Intent(paramContext, PhoneNumberManagerUI.class);
    paramContext.putExtra("APPID", paramString1);
    paramContext.putExtra("PAGEPATH", paramString2);
    locale.a(paramContext, (e.b)new i.c(paramm));
    AppMethodBeat.o(148052);
  }
  
  public void a(y paramy)
  {
    AppMethodBeat.i(169644);
    p.h(paramy, "report");
    ae.i("Luggage.FULL.DefaultPhoneNumberLogic", "report:".concat(String.valueOf(paramy)));
    AppMethodBeat.o(169644);
  }
  
  public void dq(Context paramContext)
  {
    AppMethodBeat.i(148047);
    p.h(paramContext, "context");
    if ((paramContext instanceof BaseActivity))
    {
      AppMethodBeat.o(148047);
      return;
    }
    AppMethodBeat.o(148047);
  }
  
  public void dr(Context paramContext)
  {
    AppMethodBeat.i(148048);
    p.h(paramContext, "context");
    if ((paramContext instanceof BaseActivity))
    {
      BaseActivity.showVKB((Activity)paramContext);
      AppMethodBeat.o(148048);
      return;
    }
    AppMethodBeat.o(148048);
  }
  
  public SpannableString o(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(148045);
    p.h(paramContext, "context");
    p.h(paramString1, "appId");
    p.h(paramString2, "pagePath");
    paramString1 = paramContext.getString(2131756017);
    paramString2 = ad.Njc;
    paramContext = paramContext.getString(2131756018);
    p.g(paramContext, "context.getString(R.stri…mber_expose_slogan_start)");
    paramContext = String.format(paramContext, Arrays.copyOf(new Object[] { paramString1 }, 1));
    p.g(paramContext, "java.lang.String.format(format, *args)");
    paramContext = new SpannableString((CharSequence)paramContext);
    AppMethodBeat.o(148045);
    return paramContext;
  }
  
  public final o t(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(148050);
    p.h(paramContext, "context");
    p.h(paramString1, "appId");
    p.h(paramString2, "pagePath");
    paramContext = (o)new w(paramContext, paramString1, paramString2);
    AppMethodBeat.o(148050);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.i
 * JD-Core Version:    0.7.0.1
 */
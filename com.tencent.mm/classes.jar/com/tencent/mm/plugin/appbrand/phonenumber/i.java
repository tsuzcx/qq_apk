package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import com.tencent.luggage.k.f;
import com.tencent.luggage.k.f.b;
import com.tencent.luggage.l.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.BaseActivity;
import java.util.Arrays;
import java.util.Map;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.af;
import kotlin.g.b.p;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/appbrand/phonenumber/DefaultPhoneNumberLogic;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberLogic;", "()V", "addPhoneNumber", "", "context", "Landroid/content/Context;", "appId", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "resultCode", "Landroid/content/Intent;", "data", "bindWxPhone", "Lkotlin/Function1;", "createPhoneNumberAddLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "onDone", "Lkotlin/Function0;", "createPhoneNumberManageLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;", "pagePath", "getExposeSpan", "Landroid/text/SpannableString;", "hideVKB", "managePhoneNumber", "report", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "showEditEntry", "", "showVKB", "verifyPhoneNumber", "extDesc", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "isSuccess", "", "result", "Companion", "luggage-wechat-full-sdk_release"})
public class i
  implements n
{
  @Deprecated
  public static final i.a qBn;
  
  static
  {
    AppMethodBeat.i(183076);
    qBn = new i.a((byte)0);
    AppMethodBeat.o(183076);
  }
  
  public final l a(Context paramContext, String paramString, a<x> parama)
  {
    AppMethodBeat.i(148049);
    p.k(paramContext, "context");
    p.k(paramString, "appId");
    p.k(parama, "onDone");
    paramContext = (l)new s(paramContext, paramString, parama);
    AppMethodBeat.o(148049);
    return paramContext;
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, y paramy, PhoneItem paramPhoneItem, m<? super Boolean, ? super Map<String, String>, x> paramm)
  {
    AppMethodBeat.i(238001);
    p.k(paramContext, "context");
    p.k(paramString1, "appId");
    p.k(paramString2, "extDesc");
    p.k(paramPhoneItem, "phoneItem");
    p.k(paramm, "callback");
    new aa(paramContext, paramString1, paramy, paramString2, paramPhoneItem, (aa.b)new i.d(paramm)).jt(true);
    AppMethodBeat.o(238001);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, m<? super Integer, ? super Intent, x> paramm)
  {
    AppMethodBeat.i(148052);
    p.k(paramContext, "context");
    p.k(paramString1, "appId");
    p.k(paramString2, "pagePath");
    p.k(paramm, "callback");
    f localf = f.aI(paramContext);
    paramContext = new Intent(paramContext, PhoneNumberManagerUI.class);
    paramContext.putExtra("APPID", paramString1);
    paramContext.putExtra("PAGEPATH", paramString2);
    localf.a(paramContext, (f.b)new i.c(paramm));
    AppMethodBeat.o(148052);
  }
  
  public final void a(Context paramContext, String paramString, m<? super Integer, ? super Intent, x> paramm)
  {
    AppMethodBeat.i(148051);
    p.k(paramContext, "context");
    p.k(paramString, "appId");
    p.k(paramm, "callback");
    f localf = f.aI(paramContext);
    paramContext = new Intent(paramContext, PhoneNumberAddUI.class);
    paramContext.putExtra("APPID", paramString);
    localf.a(paramContext, (f.b)new i.b(paramm));
    AppMethodBeat.o(148051);
  }
  
  public void a(Context paramContext, b<? super Integer, x> paramb)
  {
    AppMethodBeat.i(148053);
    p.k(paramContext, "context");
    p.k(paramb, "callback");
    paramb.invoke(Integer.valueOf(0));
    AppMethodBeat.o(148053);
  }
  
  public void a(y paramy)
  {
    AppMethodBeat.i(169644);
    p.k(paramy, "report");
    Log.i("Luggage.FULL.DefaultPhoneNumberLogic", "report:".concat(String.valueOf(paramy)));
    AppMethodBeat.o(169644);
  }
  
  public void dK(Context paramContext)
  {
    AppMethodBeat.i(148047);
    p.k(paramContext, "context");
    if ((paramContext instanceof BaseActivity))
    {
      AppMethodBeat.o(148047);
      return;
    }
    AppMethodBeat.o(148047);
  }
  
  public void dL(Context paramContext)
  {
    AppMethodBeat.i(148048);
    p.k(paramContext, "context");
    if ((paramContext instanceof BaseActivity))
    {
      BaseActivity.showVKB((Activity)paramContext);
      AppMethodBeat.o(148048);
      return;
    }
    AppMethodBeat.o(148048);
  }
  
  public SpannableString q(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(148045);
    p.k(paramContext, "context");
    p.k(paramString1, "appId");
    p.k(paramString2, "pagePath");
    paramString1 = paramContext.getString(a.g.appbrand_phone_number_expose_slogan_end);
    p.j(paramString1, "context.getString(R.stri…number_expose_slogan_end)");
    paramString2 = af.aaBG;
    paramContext = paramContext.getString(a.g.appbrand_phone_number_expose_slogan_start);
    p.j(paramContext, "context.getString(R.stri…mber_expose_slogan_start)");
    paramContext = String.format(paramContext, Arrays.copyOf(new Object[] { paramString1 }, 1));
    p.j(paramContext, "java.lang.String.format(format, *args)");
    paramContext = new SpannableString((CharSequence)paramContext);
    AppMethodBeat.o(148045);
    return paramContext;
  }
  
  public final o v(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(148050);
    p.k(paramContext, "context");
    p.k(paramString1, "appId");
    p.k(paramString2, "pagePath");
    paramContext = (o)new w(paramContext, paramString1, paramString2);
    AppMethodBeat.o(148050);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.i
 * JD-Core Version:    0.7.0.1
 */
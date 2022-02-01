package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.BaseActivity;
import d.g.a.a;
import d.g.a.b;
import d.g.a.m;
import d.g.b.k;
import d.g.b.z;
import java.util.Arrays;
import java.util.Map;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/phonenumber/DefaultPhoneNumberLogic;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberLogic;", "()V", "addPhoneNumber", "", "context", "Landroid/content/Context;", "appId", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "resultCode", "Landroid/content/Intent;", "data", "bindWxPhone", "Lkotlin/Function1;", "createPhoneNumberAddLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "onDone", "Lkotlin/Function0;", "createPhoneNumberManageLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;", "pagePath", "getExposeSpan", "Landroid/text/SpannableString;", "hideVKB", "managePhoneNumber", "report", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "showEditEntry", "", "showVKB", "verifyPhoneNumber", "extDesc", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "isSuccess", "", "result", "Companion", "luggage-wechat-full-sdk_release"})
public class i
  implements n
{
  @Deprecated
  public static final a lJG;
  
  static
  {
    AppMethodBeat.i(183076);
    lJG = new a((byte)0);
    AppMethodBeat.o(183076);
  }
  
  public final l a(Context paramContext, String paramString, a<d.y> parama)
  {
    AppMethodBeat.i(148049);
    k.h(paramContext, "context");
    k.h(paramString, "appId");
    k.h(parama, "onDone");
    paramContext = (l)new s(paramContext, paramString, parama);
    AppMethodBeat.o(148049);
    return paramContext;
  }
  
  public void a(Context paramContext, b<? super Integer, d.y> paramb)
  {
    AppMethodBeat.i(148053);
    k.h(paramContext, "context");
    k.h(paramb, "callback");
    paramb.ay(Integer.valueOf(0));
    AppMethodBeat.o(148053);
  }
  
  public final void a(Context paramContext, String paramString, m<? super Integer, ? super Intent, d.y> paramm)
  {
    AppMethodBeat.i(148051);
    k.h(paramContext, "context");
    k.h(paramString, "appId");
    k.h(paramm, "callback");
    e locale = e.aA(paramContext);
    paramContext = new Intent(paramContext, PhoneNumberAddUI.class);
    paramContext.putExtra("APPID", paramString);
    locale.a(paramContext, (e.a)new i.b(paramm));
    AppMethodBeat.o(148051);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, y paramy, PhoneItem paramPhoneItem, m<? super Boolean, ? super Map<String, String>, d.y> paramm)
  {
    AppMethodBeat.i(206226);
    k.h(paramContext, "context");
    k.h(paramString1, "appId");
    k.h(paramString2, "extDesc");
    k.h(paramPhoneItem, "phoneItem");
    k.h(paramm, "callback");
    new aa(paramContext, paramString1, paramy, paramString2, paramPhoneItem, (aa.b)new d(paramm)).hm(true);
    AppMethodBeat.o(206226);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, m<? super Integer, ? super Intent, d.y> paramm)
  {
    AppMethodBeat.i(148052);
    k.h(paramContext, "context");
    k.h(paramString1, "appId");
    k.h(paramString2, "pagePath");
    k.h(paramm, "callback");
    e locale = e.aA(paramContext);
    paramContext = new Intent(paramContext, PhoneNumberManagerUI.class);
    paramContext.putExtra("APPID", paramString1);
    paramContext.putExtra("PAGEPATH", paramString2);
    locale.a(paramContext, (e.a)new i.c(paramm));
    AppMethodBeat.o(148052);
  }
  
  public void a(y paramy)
  {
    AppMethodBeat.i(169644);
    k.h(paramy, "report");
    ac.i("Luggage.FULL.DefaultPhoneNumberLogic", "report:".concat(String.valueOf(paramy)));
    AppMethodBeat.o(169644);
  }
  
  public void dq(Context paramContext)
  {
    AppMethodBeat.i(148047);
    k.h(paramContext, "context");
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
    k.h(paramContext, "context");
    if ((paramContext instanceof BaseActivity))
    {
      BaseActivity.showVKB((Activity)paramContext);
      AppMethodBeat.o(148048);
      return;
    }
    AppMethodBeat.o(148048);
  }
  
  public SpannableString n(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(148045);
    k.h(paramContext, "context");
    k.h(paramString1, "appId");
    k.h(paramString2, "pagePath");
    paramString1 = paramContext.getString(2131756017);
    paramString2 = z.KUT;
    paramContext = paramContext.getString(2131756018);
    k.g(paramContext, "context.getString(R.stri…mber_expose_slogan_start)");
    paramContext = String.format(paramContext, Arrays.copyOf(new Object[] { paramString1 }, 1));
    k.g(paramContext, "java.lang.String.format(format, *args)");
    paramContext = new SpannableString((CharSequence)paramContext);
    AppMethodBeat.o(148045);
    return paramContext;
  }
  
  public final o s(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(148050);
    k.h(paramContext, "context");
    k.h(paramString1, "appId");
    k.h(paramString2, "pagePath");
    paramContext = (o)new w(paramContext, paramString1, paramString2);
    AppMethodBeat.o(148050);
    return paramContext;
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/appbrand/phonenumber/DefaultPhoneNumberLogic$Companion;", "", "()V", "TAG", "", "luggage-wechat-full-sdk_release"})
  static final class a {}
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/plugin/appbrand/phonenumber/DefaultPhoneNumberLogic$verifyPhoneNumber$1", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberVerifyCodeDialog$OnVerifyCallback;", "onVerifyCallback", "", "isSuccess", "", "result", "", "", "luggage-wechat-full-sdk_release"})
  public static final class d
    implements aa.b
  {
    d(m paramm) {}
    
    public final void a(boolean paramBoolean, Map<String, String> paramMap)
    {
      AppMethodBeat.i(206225);
      k.h(paramMap, "result");
      this.lJH.n(Boolean.valueOf(paramBoolean), paramMap);
      AppMethodBeat.o(206225);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.i
 * JD-Core Version:    0.7.0.1
 */
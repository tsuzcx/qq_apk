package com.tencent.mm.plugin.appbrand.phonenumber;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import com.tencent.luggage.l.e;
import com.tencent.luggage.m.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.BaseActivity;
import java.util.Arrays;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.am;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/phonenumber/DefaultPhoneNumberLogic;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberLogic;", "()V", "addPhoneNumber", "", "context", "Landroid/content/Context;", "appId", "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "resultCode", "Landroid/content/Intent;", "data", "bindWxPhone", "Lkotlin/Function1;", "createPhoneNumberAddLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberAddLogic;", "onDone", "Lkotlin/Function0;", "createPhoneNumberManageLogic", "Lcom/tencent/mm/plugin/appbrand/phonenumber/IPhoneNumberManageLogic;", "pagePath", "getExposeSpan", "Landroid/text/SpannableString;", "hideVKB", "managePhoneNumber", "report", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberReportAction;", "showEditEntry", "", "showVKB", "verifyPhoneNumber", "extDesc", "phoneItem", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "isSuccess", "", "result", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class i
  implements n
{
  private static final i.a tGv;
  
  static
  {
    AppMethodBeat.i(183076);
    tGv = new i.a((byte)0);
    AppMethodBeat.o(183076);
  }
  
  private static final void a(m paramm, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(318917);
    kotlin.g.b.s.u(paramm, "$callback");
    paramm.invoke(Integer.valueOf(paramInt), paramIntent);
    AppMethodBeat.o(318917);
  }
  
  private static final void b(m paramm, int paramInt, Intent paramIntent)
  {
    AppMethodBeat.i(318922);
    kotlin.g.b.s.u(paramm, "$callback");
    paramm.invoke(Integer.valueOf(paramInt), paramIntent);
    AppMethodBeat.o(318922);
  }
  
  public final l a(Context paramContext, String paramString, a<ah> parama)
  {
    AppMethodBeat.i(148049);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "appId");
    kotlin.g.b.s.u(parama, "onDone");
    paramContext = (l)new s(paramContext, paramString, parama);
    AppMethodBeat.o(148049);
    return paramContext;
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, y paramy, PhoneItem paramPhoneItem, m<? super Boolean, ? super Map<String, String>, ah> paramm)
  {
    AppMethodBeat.i(318970);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString1, "appId");
    kotlin.g.b.s.u(paramString2, "extDesc");
    kotlin.g.b.s.u(paramPhoneItem, "phoneItem");
    kotlin.g.b.s.u(paramm, "callback");
    new aa(paramContext, paramString1, paramy, paramString2, paramPhoneItem, (aa.b)new i.b(paramm)).kG(true);
    AppMethodBeat.o(318970);
  }
  
  public final void a(Context paramContext, String paramString1, String paramString2, m<? super Integer, ? super Intent, ah> paramm)
  {
    AppMethodBeat.i(148052);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString1, "appId");
    kotlin.g.b.s.u(paramString2, "pagePath");
    kotlin.g.b.s.u(paramm, "callback");
    e locale = e.bt(paramContext);
    paramContext = new Intent(paramContext, PhoneNumberManagerUI.class);
    paramContext.putExtra("APPID", paramString1);
    paramContext.putExtra("PAGEPATH", paramString2);
    paramString1 = ah.aiuX;
    locale.a(paramContext, new i..ExternalSyntheticLambda1(paramm));
    AppMethodBeat.o(148052);
  }
  
  public final void a(Context paramContext, String paramString, m<? super Integer, ? super Intent, ah> paramm)
  {
    AppMethodBeat.i(148051);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString, "appId");
    kotlin.g.b.s.u(paramm, "callback");
    e locale = e.bt(paramContext);
    paramContext = new Intent(paramContext, PhoneNumberAddUI.class);
    paramContext.putExtra("APPID", paramString);
    paramString = ah.aiuX;
    locale.a(paramContext, new i..ExternalSyntheticLambda0(paramm));
    AppMethodBeat.o(148051);
  }
  
  public void a(Context paramContext, b<? super Integer, ah> paramb)
  {
    AppMethodBeat.i(148053);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramb, "callback");
    paramb.invoke(Integer.valueOf(0));
    AppMethodBeat.o(148053);
  }
  
  public void a(y paramy)
  {
    AppMethodBeat.i(169644);
    kotlin.g.b.s.u(paramy, "report");
    Log.i("Luggage.FULL.DefaultPhoneNumberLogic", kotlin.g.b.s.X("report:", paramy));
    AppMethodBeat.o(169644);
  }
  
  public final boolean cHs()
  {
    return true;
  }
  
  public void eE(Context paramContext)
  {
    AppMethodBeat.i(148047);
    kotlin.g.b.s.u(paramContext, "context");
    if ((paramContext instanceof BaseActivity))
    {
      AppMethodBeat.o(148047);
      return;
    }
    AppMethodBeat.o(148047);
  }
  
  public void eF(Context paramContext)
  {
    AppMethodBeat.i(148048);
    kotlin.g.b.s.u(paramContext, "context");
    if ((paramContext instanceof BaseActivity))
    {
      BaseActivity.showVKB((Activity)paramContext);
      AppMethodBeat.o(148048);
      return;
    }
    AppMethodBeat.o(148048);
  }
  
  public SpannableString s(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(148045);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString1, "appId");
    kotlin.g.b.s.u(paramString2, "pagePath");
    paramString1 = paramContext.getString(a.g.appbrand_phone_number_expose_slogan_end);
    kotlin.g.b.s.s(paramString1, "context.getString(R.stri…number_expose_slogan_end)");
    paramString2 = am.aixg;
    paramContext = paramContext.getString(a.g.appbrand_phone_number_expose_slogan_start);
    kotlin.g.b.s.s(paramContext, "context.getString(R.stri…mber_expose_slogan_start)");
    paramContext = String.format(paramContext, Arrays.copyOf(new Object[] { paramString1 }, 1));
    kotlin.g.b.s.s(paramContext, "java.lang.String.format(format, *args)");
    paramContext = new SpannableString((CharSequence)paramContext);
    AppMethodBeat.o(148045);
    return paramContext;
  }
  
  public final o w(Context paramContext, String paramString1, String paramString2)
  {
    AppMethodBeat.i(148050);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(paramString1, "appId");
    kotlin.g.b.s.u(paramString2, "pagePath");
    paramContext = (o)new w(paramContext, paramString1, paramString2);
    AppMethodBeat.o(148050);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.i
 * JD-Core Version:    0.7.0.1
 */
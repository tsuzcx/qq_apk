package com.tencent.mm.plugin.car_license_plate.b;

import android.app.Activity;
import android.app.Instrumentation.ActivityResult;
import android.content.Context;
import android.content.Intent;
import android.text.InputFilter;
import android.widget.TextView;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.luggage.k.f;
import com.tencent.luggage.k.f.b;
import com.tencent.luggage.k.f.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.car_license_plate.a.g;
import com.tencent.mm.plugin.car_license_plate.a.c;
import com.tencent.mm.plugin.car_license_plate.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMFragmentActivity.b;
import com.tencent.mm.ui.base.w;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;
import kotlin.x;
import kotlinx.coroutines.m;
import kotlinx.coroutines.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"withMainContext", "", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addInputFilter", "Landroid/widget/TextView;", "filter", "Landroid/text/InputFilter;", "addInputFilterForLimitedCharRange", "range", "", "component1", "", "Landroid/app/Instrumentation$ActivityResult;", "component2", "Landroid/content/Intent;", "isChinese", "", "", "showDefaultErrorToast", "Lcom/tencent/mm/plugin/car_license_plate/cgi/CgiException;", "startForResultSuspended", "Landroid/app/Activity;", "intent", "(Landroid/app/Activity;Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-car-license-plate_release"})
public final class a
{
  public static final int a(Instrumentation.ActivityResult paramActivityResult)
  {
    AppMethodBeat.i(187307);
    p.k(paramActivityResult, "$this$component1");
    int i = paramActivityResult.getResultCode();
    AppMethodBeat.o(187307);
    return i;
  }
  
  public static final Object a(final Activity paramActivity, final Intent paramIntent, kotlin.d.d<? super Instrumentation.ActivityResult> paramd)
  {
    AppMethodBeat.i(187312);
    final int i = com.tencent.luggage.sdk.h.a.aI(paramActivity);
    n localn = new n(kotlin.d.a.b.k(paramd), 1);
    localn.iQM();
    m localm = (m)localn;
    h.ZvG.bc((Runnable)new b(localm, paramActivity, paramIntent, i));
    paramActivity = localn.getResult();
    if (paramActivity == kotlin.d.a.a.aaAA) {
      p.k(paramd, "frame");
    }
    AppMethodBeat.o(187312);
    return paramActivity;
  }
  
  public static final Object a(final kotlin.g.a.a<x> parama, kotlin.d.d<? super x> paramd)
  {
    AppMethodBeat.i(187318);
    n localn = new n(kotlin.d.a.b.k(paramd), 1);
    localn.iQM();
    m localm = (m)localn;
    h.ZvG.bc((Runnable)new c(localm, parama));
    parama = localn.getResult();
    if (parama == kotlin.d.a.a.aaAA) {
      p.k(paramd, "frame");
    }
    AppMethodBeat.o(187318);
    return parama;
  }
  
  public static final void a(TextView paramTextView, InputFilter paramInputFilter)
  {
    AppMethodBeat.i(187310);
    p.k(paramTextView, "$this$addInputFilter");
    p.k(paramInputFilter, "filter");
    InputFilter[] arrayOfInputFilter1 = paramTextView.getFilters();
    InputFilter[] arrayOfInputFilter2 = paramTextView.getFilters();
    if (arrayOfInputFilter2 != null) {}
    for (int i = arrayOfInputFilter2.length;; i = 0)
    {
      paramInputFilter = org.apache.commons.b.a.a(arrayOfInputFilter1, i, paramInputFilter);
      if (paramInputFilter != null) {
        break;
      }
      paramTextView = new t("null cannot be cast to non-null type kotlin.Array<out android.text.InputFilter>");
      AppMethodBeat.o(187310);
      throw paramTextView;
    }
    paramTextView.setFilters((InputFilter[])paramInputFilter);
    AppMethodBeat.o(187310);
  }
  
  public static final Intent b(Instrumentation.ActivityResult paramActivityResult)
  {
    AppMethodBeat.i(187309);
    p.k(paramActivityResult, "$this$component2");
    paramActivityResult = paramActivityResult.getResultData();
    AppMethodBeat.o(187309);
    return paramActivityResult;
  }
  
  public static final void b(com.tencent.mm.plugin.car_license_plate.a.d paramd)
  {
    AppMethodBeat.i(187316);
    p.k(paramd, "$this$showDefaultErrorToast");
    if (-17502 == paramd.errCode)
    {
      w.cS(MMApplicationContext.getContext(), MMApplicationContext.getString(a.g.car_license_plate_submit_invalid_plate_number));
      AppMethodBeat.o(187316);
      return;
    }
    Object localObject = paramd.sXC;
    Context localContext;
    StringBuilder localStringBuilder;
    int i;
    int j;
    CharSequence localCharSequence;
    if ((localObject instanceof c))
    {
      localContext = MMApplicationContext.getContext();
      localStringBuilder = new StringBuilder().append(MMApplicationContext.getString(a.g.car_license_plate_cgi_delete_failed_wording));
      i = paramd.errType;
      j = paramd.errCode;
      localObject = paramd.errMsg;
      paramd = (com.tencent.mm.plugin.car_license_plate.a.d)localObject;
      if (localObject == null) {
        paramd = "";
      }
      localObject = (CharSequence)" ";
      localCharSequence = (CharSequence)"\n";
      w.cS(localContext, kotlin.a.e.a(new String[] { String.valueOf(i), String.valueOf(j), paramd }, (CharSequence)localObject, localCharSequence, null, 0, null, null, 60));
      AppMethodBeat.o(187316);
      return;
    }
    if ((localObject instanceof g))
    {
      localContext = MMApplicationContext.getContext();
      localStringBuilder = new StringBuilder().append(MMApplicationContext.getString(a.g.car_license_plate_cgi_update_failed_wording));
      i = paramd.errType;
      j = paramd.errCode;
      localObject = paramd.errMsg;
      paramd = (com.tencent.mm.plugin.car_license_plate.a.d)localObject;
      if (localObject == null) {
        paramd = "";
      }
      localObject = (CharSequence)" ";
      localCharSequence = (CharSequence)"\n";
      w.cS(localContext, kotlin.a.e.a(new String[] { String.valueOf(i), String.valueOf(j), paramd }, (CharSequence)localObject, localCharSequence, null, 0, null, null, 60));
      AppMethodBeat.o(187316);
      return;
    }
    if ((localObject instanceof com.tencent.mm.plugin.car_license_plate.a.b))
    {
      localContext = MMApplicationContext.getContext();
      localStringBuilder = new StringBuilder().append(MMApplicationContext.getString(a.g.car_license_plate_cgi_create_failed_wording));
      i = paramd.errType;
      j = paramd.errCode;
      localObject = paramd.errMsg;
      paramd = (com.tencent.mm.plugin.car_license_plate.a.d)localObject;
      if (localObject == null) {
        paramd = "";
      }
      localObject = (CharSequence)" ";
      localCharSequence = (CharSequence)"\n";
      w.cS(localContext, kotlin.a.e.a(new String[] { String.valueOf(i), String.valueOf(j), paramd }, (CharSequence)localObject, localCharSequence, null, 0, null, null, 60));
      AppMethodBeat.o(187316);
      return;
    }
    if ((localObject instanceof com.tencent.mm.plugin.car_license_plate.a.e))
    {
      localContext = MMApplicationContext.getContext();
      localStringBuilder = new StringBuilder().append(MMApplicationContext.getString(a.g.car_license_plate_cgi_get_failed_wording));
      i = paramd.errType;
      j = paramd.errCode;
      localObject = paramd.errMsg;
      paramd = (com.tencent.mm.plugin.car_license_plate.a.d)localObject;
      if (localObject == null) {
        paramd = "";
      }
      localObject = (CharSequence)" ";
      localCharSequence = (CharSequence)"\n";
      w.cS(localContext, kotlin.a.e.a(new String[] { String.valueOf(i), String.valueOf(j), paramd }, (CharSequence)localObject, localCharSequence, null, 0, null, null, 60));
    }
    AppMethodBeat.o(187316);
  }
  
  public static final boolean isChinese(char paramChar)
  {
    if ('一' > paramChar) {}
    while (40891 < paramChar) {
      return false;
    }
    return true;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/car_license_plate/utils/CarLicensePlateUtilsKt$startForResultSuspended$2$1"})
  static final class b
    implements Runnable
  {
    b(m paramm, Activity paramActivity, Intent paramIntent, int paramInt) {}
    
    public final void run()
    {
      AppMethodBeat.i(186198);
      Object localObject = paramActivity;
      if ((localObject instanceof MMActivity))
      {
        ((MMActivity)paramActivity).mmStartActivityForResult((MMActivity.a)new MMActivity.a()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(187726);
            kotlin.d.d locald = (kotlin.d.d)this.sZp.khs;
            paramAnonymousIntent = new Instrumentation.ActivityResult(paramAnonymousInt2, paramAnonymousIntent);
            Result.Companion localCompanion = Result.Companion;
            locald.resumeWith(Result.constructor-impl(paramAnonymousIntent));
            AppMethodBeat.o(187726);
          }
        }, paramIntent, i);
        AppMethodBeat.o(186198);
        return;
      }
      if ((localObject instanceof MMFragmentActivity))
      {
        ((MMFragmentActivity)paramActivity).mmStartActivityForResult((MMFragmentActivity.b)new MMFragmentActivity.b()
        {
          public final void d(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(187009);
            kotlin.d.d locald = (kotlin.d.d)this.sZp.khs;
            paramAnonymousIntent = new Instrumentation.ActivityResult(paramAnonymousInt2, paramAnonymousIntent);
            Result.Companion localCompanion = Result.Companion;
            locald.resumeWith(Result.constructor-impl(paramAnonymousIntent));
            AppMethodBeat.o(187009);
          }
        }, paramIntent, i);
        AppMethodBeat.o(186198);
        return;
      }
      if ((localObject instanceof f.e))
      {
        f.aI((Context)paramActivity).a(paramIntent, (f.b)new f.b()
        {
          public final void a(int paramAnonymousInt, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(186659);
            kotlin.d.d locald = (kotlin.d.d)this.sZp.khs;
            paramAnonymousIntent = new Instrumentation.ActivityResult(paramAnonymousInt, paramAnonymousIntent);
            Result.Companion localCompanion = Result.Companion;
            locald.resumeWith(Result.constructor-impl(paramAnonymousIntent));
            AppMethodBeat.o(186659);
          }
        });
        AppMethodBeat.o(186198);
        return;
      }
      Log.e("CarLicensePlateViewUtils", "startForResultSuspended with invalid activity(" + paramActivity + "), return CANCELED");
      localObject = (kotlin.d.d)this.khs;
      Instrumentation.ActivityResult localActivityResult = new Instrumentation.ActivityResult(0, null);
      Result.Companion localCompanion = Result.Companion;
      ((kotlin.d.d)localObject).resumeWith(Result.constructor-impl(localActivityResult));
      AppMethodBeat.o(186198);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run", "com/tencent/mm/plugin/car_license_plate/utils/CarLicensePlateUtilsKt$withMainContext$2$1"})
  static final class c
    implements Runnable
  {
    c(m paramm, kotlin.g.a.a parama) {}
    
    public final void run()
    {
      AppMethodBeat.i(187412);
      parama.invoke();
      kotlin.d.d locald = (kotlin.d.d)this.khs;
      x localx = x.aazN;
      Result.Companion localCompanion = Result.Companion;
      locald.resumeWith(Result.constructor-impl(localx));
      AppMethodBeat.o(187412);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.b.a
 * JD-Core Version:    0.7.0.1
 */
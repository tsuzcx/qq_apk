package com.tencent.mm.plugin.car_license_plate.b;

import android.app.Activity;
import android.app.Instrumentation.ActivityResult;
import android.content.Context;
import android.content.Intent;
import android.text.InputFilter;
import android.widget.TextView;
import com.tencent.luggage.l.e.b;
import com.tencent.luggage.l.e.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.car_license_plate.a.g;
import com.tencent.mm.plugin.car_license_plate.a.c;
import com.tencent.mm.plugin.car_license_plate.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.MMFragmentActivity.c;
import com.tencent.mm.ui.base.aa;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.a.k;
import kotlin.ah;
import kotlin.g.b.s;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;

@Metadata(d1={""}, d2={"withMainContext", "", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addInputFilter", "Landroid/widget/TextView;", "filter", "Landroid/text/InputFilter;", "addInputFilterForLimitedCharRange", "range", "", "component1", "", "Landroid/app/Instrumentation$ActivityResult;", "component2", "Landroid/content/Intent;", "isChinese", "", "", "showDefaultErrorToast", "Lcom/tencent/mm/plugin/car_license_plate/cgi/CgiException;", "startForResultSuspended", "Landroid/app/Activity;", "intent", "(Landroid/app/Activity;Landroid/content/Intent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-car-license-plate_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final int a(Instrumentation.ActivityResult paramActivityResult)
  {
    AppMethodBeat.i(277546);
    s.u(paramActivityResult, "<this>");
    int i = paramActivityResult.getResultCode();
    AppMethodBeat.o(277546);
    return i;
  }
  
  public static final Object a(Activity paramActivity, final Intent paramIntent, kotlin.d.d<? super Instrumentation.ActivityResult> paramd)
  {
    AppMethodBeat.i(277568);
    final int i = com.tencent.luggage.sdk.h.a.ce(paramActivity);
    q localq = new q(kotlin.d.a.b.au(paramd), 1);
    localq.kBA();
    final p localp = (p)localq;
    h.ahAA.bk((Runnable)new b(paramActivity, paramIntent, i, localp));
    paramActivity = localq.getResult();
    if (paramActivity == kotlin.d.a.a.aiwj) {
      s.u(paramd, "frame");
    }
    AppMethodBeat.o(277568);
    return paramActivity;
  }
  
  public static final Object a(kotlin.g.a.a<ah> parama, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(277578);
    q localq = new q(kotlin.d.a.b.au(paramd), 1);
    localq.kBA();
    p localp = (p)localq;
    h.ahAA.bk((Runnable)new a.c(parama, localp));
    parama = localq.getResult();
    if (parama == kotlin.d.a.a.aiwj) {
      s.u(paramd, "frame");
    }
    if (parama == kotlin.d.a.a.aiwj)
    {
      AppMethodBeat.o(277578);
      return parama;
    }
    parama = ah.aiuX;
    AppMethodBeat.o(277578);
    return parama;
  }
  
  public static final void a(TextView paramTextView, InputFilter paramInputFilter)
  {
    AppMethodBeat.i(277557);
    s.u(paramTextView, "<this>");
    s.u(paramInputFilter, "filter");
    InputFilter[] arrayOfInputFilter1 = paramTextView.getFilters();
    InputFilter[] arrayOfInputFilter2 = paramTextView.getFilters();
    if (arrayOfInputFilter2 == null) {}
    for (int i = 0;; i = arrayOfInputFilter2.length)
    {
      paramInputFilter = org.apache.commons.c.a.c(arrayOfInputFilter1, i, paramInputFilter);
      if (paramInputFilter != null) {
        break;
      }
      paramTextView = new NullPointerException("null cannot be cast to non-null type kotlin.Array<out android.text.InputFilter>");
      AppMethodBeat.o(277557);
      throw paramTextView;
    }
    paramTextView.setFilters((InputFilter[])paramInputFilter);
    AppMethodBeat.o(277557);
  }
  
  public static final Intent b(Instrumentation.ActivityResult paramActivityResult)
  {
    AppMethodBeat.i(277551);
    s.u(paramActivityResult, "<this>");
    paramActivityResult = paramActivityResult.getResultData();
    AppMethodBeat.o(277551);
    return paramActivityResult;
  }
  
  public static final void b(com.tencent.mm.plugin.car_license_plate.a.d paramd)
  {
    AppMethodBeat.i(277575);
    s.u(paramd, "<this>");
    if (-17502 == paramd.errCode)
    {
      aa.dc(MMApplicationContext.getContext(), MMApplicationContext.getString(a.g.car_license_plate_submit_invalid_plate_number));
      AppMethodBeat.o(277575);
      return;
    }
    Object localObject = paramd.wbX;
    Context localContext;
    String str;
    int i;
    int j;
    CharSequence localCharSequence;
    if ((localObject instanceof c))
    {
      localContext = MMApplicationContext.getContext();
      str = MMApplicationContext.getString(a.g.car_license_plate_cgi_delete_failed_wording);
      i = paramd.errType;
      j = paramd.errCode;
      localObject = paramd.errMsg;
      paramd = (com.tencent.mm.plugin.car_license_plate.a.d)localObject;
      if (localObject == null) {
        paramd = "";
      }
      localObject = (CharSequence)" ";
      localCharSequence = (CharSequence)"\n";
      aa.dc(localContext, s.X(str, k.a(new String[] { String.valueOf(i), String.valueOf(j), paramd }, (CharSequence)localObject, localCharSequence, null, 0, null, null, 60)));
      AppMethodBeat.o(277575);
      return;
    }
    if ((localObject instanceof g))
    {
      localContext = MMApplicationContext.getContext();
      str = MMApplicationContext.getString(a.g.car_license_plate_cgi_update_failed_wording);
      i = paramd.errType;
      j = paramd.errCode;
      localObject = paramd.errMsg;
      paramd = (com.tencent.mm.plugin.car_license_plate.a.d)localObject;
      if (localObject == null) {
        paramd = "";
      }
      localObject = (CharSequence)" ";
      localCharSequence = (CharSequence)"\n";
      aa.dc(localContext, s.X(str, k.a(new String[] { String.valueOf(i), String.valueOf(j), paramd }, (CharSequence)localObject, localCharSequence, null, 0, null, null, 60)));
      AppMethodBeat.o(277575);
      return;
    }
    if ((localObject instanceof com.tencent.mm.plugin.car_license_plate.a.b))
    {
      localContext = MMApplicationContext.getContext();
      str = MMApplicationContext.getString(a.g.car_license_plate_cgi_create_failed_wording);
      i = paramd.errType;
      j = paramd.errCode;
      localObject = paramd.errMsg;
      paramd = (com.tencent.mm.plugin.car_license_plate.a.d)localObject;
      if (localObject == null) {
        paramd = "";
      }
      localObject = (CharSequence)" ";
      localCharSequence = (CharSequence)"\n";
      aa.dc(localContext, s.X(str, k.a(new String[] { String.valueOf(i), String.valueOf(j), paramd }, (CharSequence)localObject, localCharSequence, null, 0, null, null, 60)));
      AppMethodBeat.o(277575);
      return;
    }
    if ((localObject instanceof com.tencent.mm.plugin.car_license_plate.a.e))
    {
      localContext = MMApplicationContext.getContext();
      str = MMApplicationContext.getString(a.g.car_license_plate_cgi_get_failed_wording);
      i = paramd.errType;
      j = paramd.errCode;
      localObject = paramd.errMsg;
      paramd = (com.tencent.mm.plugin.car_license_plate.a.d)localObject;
      if (localObject == null) {
        paramd = "";
      }
      localObject = (CharSequence)" ";
      localCharSequence = (CharSequence)"\n";
      aa.dc(localContext, s.X(str, k.a(new String[] { String.valueOf(i), String.valueOf(j), paramd }, (CharSequence)localObject, localCharSequence, null, 0, null, null, 60)));
    }
    AppMethodBeat.o(277575);
  }
  
  public static final boolean isChinese(char paramChar)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ('一' <= paramChar)
    {
      bool1 = bool2;
      if (paramChar <= 40891) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    implements Runnable
  {
    b(Activity paramActivity, Intent paramIntent, int paramInt, p<? super Instrumentation.ActivityResult> paramp) {}
    
    public final void run()
    {
      AppMethodBeat.i(277555);
      Object localObject = this.rxb;
      if ((localObject instanceof MMActivity))
      {
        ((MMActivity)this.rxb).mmStartActivityForResult((MMActivity.a)new MMActivity.a()
        {
          public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(277552);
            kotlin.d.d locald = (kotlin.d.d)this.bPy;
            paramAnonymousIntent = new Instrumentation.ActivityResult(paramAnonymousInt2, paramAnonymousIntent);
            Result.Companion localCompanion = Result.Companion;
            locald.resumeWith(Result.constructor-impl(paramAnonymousIntent));
            AppMethodBeat.o(277552);
          }
        }, paramIntent, i);
        AppMethodBeat.o(277555);
        return;
      }
      if ((localObject instanceof MMFragmentActivity))
      {
        ((MMFragmentActivity)this.rxb).mmStartActivityForResult((MMFragmentActivity.c)new MMFragmentActivity.c()
        {
          public final void mmOnActivityResult(int paramAnonymousInt1, int paramAnonymousInt2, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(277553);
            kotlin.d.d locald = (kotlin.d.d)this.bPy;
            paramAnonymousIntent = new Instrumentation.ActivityResult(paramAnonymousInt2, paramAnonymousIntent);
            Result.Companion localCompanion = Result.Companion;
            locald.resumeWith(Result.constructor-impl(paramAnonymousIntent));
            AppMethodBeat.o(277553);
          }
        }, paramIntent, i);
        AppMethodBeat.o(277555);
        return;
      }
      if ((localObject instanceof e.e))
      {
        com.tencent.luggage.l.e.bt((Context)this.rxb).a(paramIntent, (e.b)new e.b()
        {
          public final void onResult(int paramAnonymousInt, Intent paramAnonymousIntent)
          {
            AppMethodBeat.i(277549);
            kotlin.d.d locald = (kotlin.d.d)this.bPy;
            paramAnonymousIntent = new Instrumentation.ActivityResult(paramAnonymousInt, paramAnonymousIntent);
            Result.Companion localCompanion = Result.Companion;
            locald.resumeWith(Result.constructor-impl(paramAnonymousIntent));
            AppMethodBeat.o(277549);
          }
        });
        AppMethodBeat.o(277555);
        return;
      }
      Log.e("CarLicensePlateViewUtils", "startForResultSuspended with invalid activity(" + this.rxb + "), return CANCELED");
      localObject = (kotlin.d.d)localp;
      Instrumentation.ActivityResult localActivityResult = new Instrumentation.ActivityResult(0, null);
      Result.Companion localCompanion = Result.Companion;
      ((kotlin.d.d)localObject).resumeWith(Result.constructor-impl(localActivityResult));
      AppMethodBeat.o(277555);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.b.a
 * JD-Core Version:    0.7.0.1
 */
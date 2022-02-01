package com.tencent.kinda.framework.module.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.j;
import androidx.lifecycle.j.a;
import androidx.lifecycle.p;
import androidx.lifecycle.z;
import com.tencent.kinda.framework.widget.tools.KindaContext;
import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KThirdPayService;
import com.tencent.kinda.gen.VoidITransmitKvDataCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.framework.app.UIPageFragmentActivity;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.util.b.a;
import com.tencent.mm.util.i;
import com.unionpay.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/kinda/framework/module/impl/KindaThirdPayService;", "Lcom/tencent/kinda/gen/KThirdPayService;", "()V", "hasCallbacked", "", "isYunShanFuAppInstalled", "startYunShanFuPayImpl", "", "tn", "", "resultCallback", "Lcom/tencent/kinda/gen/VoidITransmitKvDataCallback;", "Companion", "kinda-framework-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class KindaThirdPayService
  implements KThirdPayService
{
  public static final Companion Companion;
  private static final int REQUEST_YUNSHANFU = 10;
  private static final String TAG = "MicroMsg.KindaThirdPayService";
  private boolean hasCallbacked;
  
  static
  {
    AppMethodBeat.i(226669);
    Companion = new Companion(null);
    AppMethodBeat.o(226669);
  }
  
  private static final void startYunShanFuPayImpl$lambda-0(Activity paramActivity, startYunShanFuPayImpl.observer.1 param1, KindaThirdPayService paramKindaThirdPayService, VoidITransmitKvDataCallback paramVoidITransmitKvDataCallback, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(226665);
    s.u(param1, "$observer");
    s.u(paramKindaThirdPayService, "this$0");
    Log.i("MicroMsg.KindaThirdPayService", "onActivityResult: " + paramInt1 + ", " + paramInt2);
    if (paramInt1 == 10)
    {
      ((MMActivity)paramActivity).mmSetOnActivityResultCallback(null);
      ((MMActivity)paramActivity).getLifecycle().removeObserver((p)param1);
      param1 = ITransmitKvData.create();
      param1.putInt("ret_scene", 0);
      paramKindaThirdPayService.hasCallbacked = true;
      if (paramIntent == null)
      {
        param1.putInt("ret", 2);
        if (paramVoidITransmitKvDataCallback != null) {
          paramVoidITransmitKvDataCallback.call(param1);
        }
        AppMethodBeat.o(226665);
        return;
      }
      paramActivity = paramIntent.getExtras();
      s.checkNotNull(paramActivity);
      paramActivity = paramActivity.getString("pay_result");
      if (paramActivity != null) {
        break label218;
      }
      paramActivity = null;
      Log.i("MicroMsg.KindaThirdPayService", s.X("pay result: ", paramActivity));
      if (paramActivity != null) {}
      switch (paramActivity.hashCode())
      {
      default: 
        label196:
        param1.putInt("ret", 2);
      }
    }
    for (;;)
    {
      if (paramVoidITransmitKvDataCallback != null) {
        paramVoidITransmitKvDataCallback.call(param1);
      }
      AppMethodBeat.o(226665);
      return;
      label218:
      paramActivity = paramActivity.toLowerCase();
      s.s(paramActivity, "(this as java.lang.String).toLowerCase()");
      break;
      if (!paramActivity.equals("cancel")) {
        break label196;
      }
      param1.putInt("ret", 2);
      continue;
      if (!paramActivity.equals("fail")) {
        break label196;
      }
      param1.putInt("ret", 1);
      continue;
      if (!paramActivity.equals("success")) {
        break label196;
      }
      param1.putInt("ret", 0);
    }
  }
  
  public final boolean isYunShanFuAppInstalled()
  {
    AppMethodBeat.i(226674);
    boolean bool = a.pk(MMApplicationContext.getContext());
    AppMethodBeat.o(226674);
    return bool;
  }
  
  public final void startYunShanFuPayImpl(String paramString, final VoidITransmitKvDataCallback paramVoidITransmitKvDataCallback)
  {
    AppMethodBeat.i(226672);
    Log.i("MicroMsg.KindaThirdPayService", s.X("start yunshanfu ", paramString));
    Activity localActivity = KindaContext.getTopOrUIPageFragmentActivity();
    if (!(localActivity instanceof UIPageFragmentActivity)) {
      Log.w("MicroMsg.KindaThirdPayService", "current activity is not kinda activity");
    }
    p local1 = new p()
    {
      private boolean firstResume = true;
      
      public final boolean getFirstResume()
      {
        return this.firstResume;
      }
      
      @z(Ho=j.a.ON_DESTROY)
      public final void onActivityDestroy()
      {
        AppMethodBeat.i(226675);
        if (!KindaThirdPayService.access$getHasCallbacked$p(jdField_this))
        {
          localObject = ITransmitKvData.create();
          ((ITransmitKvData)localObject).putInt("ret", 2);
          ((ITransmitKvData)localObject).putInt("ret_scene", 2);
          VoidITransmitKvDataCallback localVoidITransmitKvDataCallback = paramVoidITransmitKvDataCallback;
          if (localVoidITransmitKvDataCallback != null) {
            localVoidITransmitKvDataCallback.call((ITransmitKvData)localObject);
          }
          KindaThirdPayService.access$setHasCallbacked$p(jdField_this, true);
        }
        Object localObject = this.$topActivity;
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(226675);
          throw ((Throwable)localObject);
        }
        ((MMActivity)localObject).getLifecycle().removeObserver((p)this);
        AppMethodBeat.o(226675);
      }
      
      @z(Ho=j.a.ON_RESUME)
      public final void onActivityResume()
      {
        AppMethodBeat.i(226673);
        Log.i("MicroMsg.KindaThirdPayService", s.X("on resume ", Boolean.valueOf(this.firstResume)));
        if (this.$topActivity.isFinishing())
        {
          AppMethodBeat.o(226673);
          return;
        }
        if (this.firstResume)
        {
          this.firstResume = false;
          AppMethodBeat.o(226673);
          return;
        }
        if (!KindaThirdPayService.access$getHasCallbacked$p(jdField_this))
        {
          localObject = ITransmitKvData.create();
          ((ITransmitKvData)localObject).putInt("ret", 2);
          ((ITransmitKvData)localObject).putInt("ret_scene", 1);
          VoidITransmitKvDataCallback localVoidITransmitKvDataCallback = paramVoidITransmitKvDataCallback;
          if (localVoidITransmitKvDataCallback != null) {
            localVoidITransmitKvDataCallback.call((ITransmitKvData)localObject);
          }
          KindaThirdPayService.access$setHasCallbacked$p(jdField_this, true);
        }
        Object localObject = this.$topActivity;
        if (localObject == null)
        {
          localObject = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(226673);
          throw ((Throwable)localObject);
        }
        ((MMActivity)localObject).getLifecycle().removeObserver((p)this);
        AppMethodBeat.o(226673);
      }
      
      public final void setFirstResume(boolean paramAnonymousBoolean)
      {
        this.firstResume = paramAnonymousBoolean;
      }
    };
    if (localActivity == null)
    {
      paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
      AppMethodBeat.o(226672);
      throw paramString;
    }
    ((MMActivity)localActivity).getLifecycle().addObserver((p)local1);
    ((MMActivity)localActivity).mmSetOnActivityResultCallback(new KindaThirdPayService..ExternalSyntheticLambda0(localActivity, local1, this, paramVoidITransmitKvDataCallback));
    paramVoidITransmitKvDataCallback = i.agtt;
    if (i.a(b.a.agsA, 0) == 1) {}
    for (paramVoidITransmitKvDataCallback = "01";; paramVoidITransmitKvDataCallback = "00")
    {
      if ((localActivity instanceof UIPageFragmentActivity)) {
        ((UIPageFragmentActivity)localActivity).msO = true;
      }
      a.ap((Context)localActivity, paramString, paramVoidITransmitKvDataCallback);
      if ((localActivity instanceof UIPageFragmentActivity)) {
        ((UIPageFragmentActivity)localActivity).msO = false;
      }
      AppMethodBeat.o(226672);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/kinda/framework/module/impl/KindaThirdPayService$Companion;", "", "()V", "REQUEST_YUNSHANFU", "", "TAG", "", "kinda-framework-lib_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class Companion {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaThirdPayService
 * JD-Core Version:    0.7.0.1
 */
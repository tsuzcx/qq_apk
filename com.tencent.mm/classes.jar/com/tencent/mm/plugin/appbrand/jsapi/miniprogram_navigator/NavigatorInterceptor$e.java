package com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator;

import android.content.DialogInterface;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.AppBrandRuntimeWCAccessible;
import com.tencent.mm.plugin.appbrand.ba.i;
import com.tencent.mm.plugin.appbrand.g;
import com.tencent.mm.plugin.appbrand.game.a.o;
import com.tencent.mm.plugin.appbrand.ipc.AppBrandProxyUIProcessTask.ProcessRequest;
import com.tencent.mm.plugin.appbrand.launching.params.LaunchParcel;
import com.tencent.mm.plugin.appbrand.widget.dialog.b;
import com.tencent.mm.plugin.appbrand.widget.dialog.n;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.d.f;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
final class NavigatorInterceptor$e
  extends k
  implements m<aq, d<? super ah>, Object>
{
  int label;
  
  NavigatorInterceptor$e(g paramg, LaunchParcel paramLaunchParcel, c.b paramb, d<? super e> paramd)
  {
    super(2, paramd);
  }
  
  public final d<ah> create(Object paramObject, d<?> paramd)
  {
    AppMethodBeat.i(326281);
    paramObject = (d)new e(this.rFR, this.siK, this.siL, paramd);
    AppMethodBeat.o(326281);
    return paramObject;
  }
  
  public final Object invokeSuspend(Object paramObject)
  {
    AppMethodBeat.i(326275);
    kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
    Object localObject;
    d locald;
    switch (this.label)
    {
    default: 
      paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
      AppMethodBeat.o(326275);
      throw paramObject;
    case 0: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = NavigatorInterceptor.siH;
      paramObject = this.rFR.getContext();
      localObject = this.siK.appId;
      s.s(localObject, "args.appId");
      locald = (d)this;
      this.label = 1;
      localObject = NavigatorInterceptor.a(paramObject, (String)localObject, locald);
      paramObject = localObject;
      if (localObject == locala)
      {
        AppMethodBeat.o(326275);
        return locala;
      }
    case 1: 
      ResultKt.throwOnFailure(paramObject);
      if (((Number)paramObject).intValue() != 0)
      {
        paramObject = (f)bg.kCh();
        localObject = (m)new k(this.rFR, null)
        {
          int label;
          
          private static final void a(b paramAnonymousb, DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(326245);
            paramAnonymousb.dismiss();
            AppMethodBeat.o(326245);
          }
          
          public final d<ah> create(Object paramAnonymousObject, d<?> paramAnonymousd)
          {
            AppMethodBeat.i(326263);
            paramAnonymousObject = (d)new 1(this.rFR, paramAnonymousd);
            AppMethodBeat.o(326263);
            return paramAnonymousObject;
          }
          
          public final Object invokeSuspend(Object paramAnonymousObject)
          {
            AppMethodBeat.i(326258);
            Object localObject = kotlin.d.a.a.aiwj;
            switch (this.label)
            {
            default: 
              paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
              AppMethodBeat.o(326258);
              throw paramAnonymousObject;
            }
            ResultKt.throwOnFailure(paramAnonymousObject);
            localObject = this.rFR.getContext();
            paramAnonymousObject = localObject;
            if (localObject == null) {
              paramAnonymousObject = MMApplicationContext.getContext();
            }
            paramAnonymousObject = new b(paramAnonymousObject);
            localObject = this.rFR;
            paramAnonymousObject.setTitle(ba.i.appbrand_gdpr_deny_alert_title);
            paramAnonymousObject.aEH(ba.i.appbrand_gdpr_deny_alert_message);
            paramAnonymousObject.setCanceledOnTouchOutside(false);
            paramAnonymousObject.a(ba.i.app_ok, new NavigatorInterceptor.e.1..ExternalSyntheticLambda0(paramAnonymousObject));
            localObject = ((g)localObject).getRuntime().pmu;
            if (localObject != null) {
              ((com.tencent.mm.plugin.appbrand.widget.dialog.r)localObject).b((n)paramAnonymousObject);
            }
            AppMethodBeat.o(326258);
            return paramAnonymousObject;
          }
        };
        locald = (d)this;
        this.label = 2;
        if (l.a(paramObject, (m)localObject, locald) == locala)
        {
          AppMethodBeat.o(326275);
          return locala;
        }
      }
    case 2: 
      ResultKt.throwOnFailure(paramObject);
      this.siL.a(c.b.a.shZ);
      paramObject = ah.aiuX;
      AppMethodBeat.o(326275);
      return paramObject;
      if ((!AppBrandRuntimeWCAccessible.isGame(this.rFR.getRuntime())) || (o.coO())) {
        break label444;
      }
      paramObject = NavigatorInterceptor.siH;
      paramObject = this.siK.appId;
      s.s(paramObject, "args.appId");
      int i = this.siK.euz;
      localObject = (d)this;
      this.label = 3;
      localObject = NavigatorInterceptor.d(paramObject, i, (d)localObject);
      paramObject = localObject;
      if (localObject == locala)
      {
        AppMethodBeat.o(326275);
        return locala;
      }
    case 3: 
      ResultKt.throwOnFailure(paramObject);
      paramObject = (kotlin.r)paramObject;
      boolean bool1 = ((Boolean)paramObject.bsC).booleanValue();
      boolean bool2 = ((Boolean)paramObject.bsD).booleanValue();
      if ((!bool1) || (!bool2)) {
        break label444;
      }
      paramObject = (f)bg.kCh();
      localObject = (m)new k(this.rFR, this.siK)
      {
        int label;
        
        public final d<ah> create(Object paramAnonymousObject, d<?> paramAnonymousd)
        {
          AppMethodBeat.i(326252);
          paramAnonymousObject = (d)new 2(this.rFR, this.siK, paramAnonymousd);
          AppMethodBeat.o(326252);
          return paramAnonymousObject;
        }
        
        public final Object invokeSuspend(Object paramAnonymousObject)
        {
          AppMethodBeat.i(326246);
          kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
          switch (this.label)
          {
          default: 
            paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            AppMethodBeat.o(326246);
            throw paramAnonymousObject;
          }
          ResultKt.throwOnFailure(paramAnonymousObject);
          com.tencent.mm.plugin.appbrand.ipc.a.a(this.rFR.getContext(), (AppBrandProxyUIProcessTask.ProcessRequest)new NavigatorInterceptor.MMLaunchEntryProxyRequest(this.siK), null);
          paramAnonymousObject = ah.aiuX;
          AppMethodBeat.o(326246);
          return paramAnonymousObject;
        }
      };
      locald = (d)this;
      this.label = 4;
      if (l.a(paramObject, (m)localObject, locald) != locala) {
        break label421;
      }
      AppMethodBeat.o(326275);
      return locala;
    }
    ResultKt.throwOnFailure(paramObject);
    label421:
    this.siL.a(c.b.a.shY);
    paramObject = ah.aiuX;
    AppMethodBeat.o(326275);
    return paramObject;
    label444:
    this.siL.a(c.b.a.shX);
    paramObject = ah.aiuX;
    AppMethodBeat.o(326275);
    return paramObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.miniprogram_navigator.NavigatorInterceptor.e
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.ui.privacy.revoke;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.af;
import androidx.lifecycle.q;
import androidx.lifecycle.r;
import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eum;
import com.tencent.mm.protocal.protobuf.gnd;
import com.tencent.mm.protocal.protobuf.gne;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/UserInfoRevokeViewModel;", "Landroidx/lifecycle/ViewModel;", "host", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/AppBrandUserInfoRevokePage;", "appId", "", "(Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/AppBrandUserInfoRevokePage;Ljava/lang/String;)V", "_pageModeObservable", "Landroidx/lifecycle/MutableLiveData;", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/UserInfoRevokePageMode;", "kotlin.jvm.PlatformType", "_revokeStateObservable", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/UserInfoRevokeState;", "_usageInfoObservable", "Lcom/tencent/mm/protocal/protobuf/WxaUseUserInfo;", "pageModeObservable", "Landroidx/lifecycle/LiveData;", "getPageModeObservable", "()Landroidx/lifecycle/LiveData;", "revokeStateObservable", "getRevokeStateObservable", "usageInfoObservable", "getUsageInfoObservable", "onManageBtnClick", "", "onRevokeBtnClick", "usageInfoItem", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/UserInfoUsageInfoItem;", "Providers", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  extends af
{
  public static final a uky;
  final AppBrandUserInfoRevokePage ujU;
  final LiveData<gnd> ukA;
  final x<i> ukB;
  final LiveData<i> ukC;
  private final x<k> ukD;
  final LiveData<k> ukE;
  private final x<gnd> ukz;
  
  static
  {
    AppMethodBeat.i(322928);
    uky = new a((byte)0);
    AppMethodBeat.o(322928);
  }
  
  private l(AppBrandUserInfoRevokePage paramAppBrandUserInfoRevokePage, final String paramString)
  {
    AppMethodBeat.i(322895);
    this.ujU = paramAppBrandUserInfoRevokePage;
    this.ukz = new x(null);
    this.ukA = ((LiveData)this.ukz);
    this.ukB = new x(i.uko);
    this.ukC = ((LiveData)this.ukB);
    this.ukD = new x(null);
    this.ukE = ((LiveData)this.ukD);
    Log.i("MicroMsg.AppBrand.UserInfoRevokeViewModel", s.X("<init>, appId: ", paramString));
    kotlinx.coroutines.j.a((aq)r.g((q)this.ujU), null, null, (kotlin.g.a.m)new kotlin.d.b.a.k(paramString, null)
    {
      Object L$0;
      int label;
      
      public final d<ah> create(Object paramAnonymousObject, d<?> paramAnonymousd)
      {
        AppMethodBeat.i(322801);
        paramAnonymousObject = (d)new 1(this.ukF, paramString, paramAnonymousd);
        AppMethodBeat.o(322801);
        return paramAnonymousObject;
      }
      
      public final Object invokeSuspend(Object paramAnonymousObject)
      {
        AppMethodBeat.i(322794);
        a locala = a.aiwj;
        switch (this.label)
        {
        default: 
          paramAnonymousObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
          AppMethodBeat.o(322794);
          throw paramAnonymousObject;
        case 0: 
          ResultKt.throwOnFailure(paramAnonymousObject);
        }
        try
        {
          localx = l.b(this.ukF);
          paramAnonymousObject = j.ukr;
          String str = paramString;
          d locald = (d)this;
          this.L$0 = localx;
          this.label = 1;
          paramAnonymousObject = paramAnonymousObject.i(str, locald);
          if (paramAnonymousObject != locala) {
            break label165;
          }
          AppMethodBeat.o(322794);
          return locala;
        }
        catch (Exception paramAnonymousObject)
        {
          for (;;)
          {
            x localx;
            Log.w("MicroMsg.AppBrand.UserInfoRevokeViewModel", s.X("<init>, getUsageInfo fail since ", paramAnonymousObject));
            l.c(this.ukF).finish();
          }
        }
        localx = (x)this.L$0;
        ResultKt.throwOnFailure(paramAnonymousObject);
        localx.setValue(paramAnonymousObject);
        paramAnonymousObject = ah.aiuX;
        AppMethodBeat.o(322794);
        return paramAnonymousObject;
      }
    }, 3);
    AppMethodBeat.o(322895);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/UserInfoRevokeViewModel$Providers;", "", "()V", "TAG", "", "of", "Landroidx/lifecycle/ViewModelProvider;", "host", "Lcom/tencent/mm/plugin/appbrand/ui/privacy/revoke/AppBrandUserInfoRevokePage;", "appId", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.k
    implements kotlin.g.a.m<aq, d<? super ah>, Object>
  {
    int label;
    
    b(l paraml, m paramm, d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(322941);
      paramObject = (d)new b(this.ukF, this.ukH, paramd);
      AppMethodBeat.o(322941);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(322936);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(322936);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        l.a(this.ukF).setValue(k.uku);
      }
      for (;;)
      {
        try
        {
          if (this.ukH.ukJ == null) {
            continue;
          }
          paramObject = j.ukr;
          paramObject = this.ukH.ukI.appid;
          str = this.ukH.ukJ.appid;
          localObject = this.ukH.ukK.scope;
          d locald = (d)this;
          this.label = 1;
          paramObject = j.c(paramObject, str, (String)localObject, locald);
          if (paramObject == locala)
          {
            AppMethodBeat.o(322936);
            return locala;
            ResultKt.throwOnFailure(paramObject);
          }
          this.ukH.ukK.state = 7;
          l.b(this.ukF).setValue(l.b(this.ukF).getValue());
          l.a(this.ukF).setValue(k.ukv);
        }
        catch (Exception paramObject)
        {
          String str;
          Object localObject;
          Log.w("MicroMsg.AppBrand.UserInfoRevokeViewModel", s.X("onRevokeBtnClick, revoke fail since ", paramObject));
          l.a(this.ukF).setValue(k.ukw);
          continue;
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(322936);
        return paramObject;
        paramObject = j.ukr;
        paramObject = this.ukH.ukI.appid;
        str = this.ukH.ukK.scope;
        localObject = (d)this;
        this.label = 2;
        paramObject = j.a(paramObject, str, (d)localObject);
        if (paramObject == locala)
        {
          AppMethodBeat.o(322936);
          return locala;
          ResultKt.throwOnFailure(paramObject);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ui.privacy.revoke.l
 * JD-Core Version:    0.7.0.1
 */
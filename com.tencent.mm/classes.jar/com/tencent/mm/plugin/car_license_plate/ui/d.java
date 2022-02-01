package com.tencent.mm.plugin.car_license_plate.ui;

import android.app.Activity;
import android.app.Instrumentation.ActivityResult;
import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.car_license_plate.a.c;
import com.tencent.mm.plugin.car_license_plate.a.e;
import com.tencent.mm.plugin.car_license_plate.a.e.a;
import com.tencent.mm.plugin.car_license_plate.api.entity.MMCarLicensePlateInfo;
import com.tencent.mm.protocal.protobuf.cux;
import com.tencent.mm.protocal.protobuf.fvh;
import com.tencent.mm.protocal.protobuf.fvi;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewPresenter;", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract$Presenter;", "scene", "Lcom/tencent/mm/plugin/car_license_plate/cgi/CgiGetAllPlateNo$ReqScene;", "(Lcom/tencent/mm/plugin/car_license_plate/cgi/CgiGetAllPlateNo$ReqScene;)V", "_viewModel", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract$ViewModel;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScope", "()Lkotlinx/coroutines/CoroutineScope;", "<set-?>", "Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract$ViewCallback;", "viewCallback", "getViewCallback", "()Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract$ViewCallback;", "viewModel", "getViewModel", "()Lcom/tencent/mm/plugin/car_license_plate/ui/CarLicensePlateListViewContract$ViewModel;", "deletePlateNo", "", "plateNo", "", "initForDefault", "initForModel", "model", "setViewCallback", "callback", "startEditUIForCreate", "startEditUIForUpdate", "syncDataFromServer", "Companion", "plugin-car-license-plate_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  implements CarLicensePlateListViewContract.a
{
  private static final d.a wdp;
  private final e.a wbY;
  CarLicensePlateListViewContract.b wdq;
  private CarLicensePlateListViewContract.ViewModel wdr;
  
  static
  {
    AppMethodBeat.i(277726);
    wdp = new d.a((byte)0);
    AppMethodBeat.o(277726);
  }
  
  public d(e.a parama)
  {
    AppMethodBeat.i(277695);
    this.wbY = parama;
    AppMethodBeat.o(277695);
  }
  
  private final void dja()
  {
    AppMethodBeat.i(277708);
    CarLicensePlateListViewContract.ViewModel.a locala = CarLicensePlateListViewContract.ViewModel.wdl;
    if (!s.p(CarLicensePlateListViewContract.ViewModel.diZ(), cqq().wdm)) {}
    for (final boolean bool = true;; bool = false)
    {
      j.a(wd(), null, null, (m)new e(this, bool, null), 3);
      AppMethodBeat.o(277708);
      return;
    }
  }
  
  private final aq wd()
  {
    AppMethodBeat.i(277701);
    Object localObject = this.wdq;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((CarLicensePlateListViewContract.b)localObject).wd())
    {
      localObject = ar.kBZ();
      AppMethodBeat.o(277701);
      return localObject;
    }
    AppMethodBeat.o(277701);
    return localObject;
  }
  
  public final void a(CarLicensePlateListViewContract.ViewModel paramViewModel)
  {
    AppMethodBeat.i(277749);
    s.u(paramViewModel, "model");
    this.wdr = paramViewModel;
    paramViewModel = CarLicensePlateListViewContract.ViewModel.wdl;
    if (!s.p(CarLicensePlateListViewContract.ViewModel.diZ(), cqq().wdm))
    {
      paramViewModel = this.wdq;
      if (paramViewModel != null)
      {
        paramViewModel.a(cqq().wdm);
        AppMethodBeat.o(277749);
      }
    }
    else
    {
      dja();
    }
    AppMethodBeat.o(277749);
  }
  
  public final void a(CarLicensePlateListViewContract.b paramb)
  {
    this.wdq = paramb;
  }
  
  public final void ako(final String paramString)
  {
    AppMethodBeat.i(277765);
    s.u(paramString, "plateNo");
    Object localObject = this.wdq;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((CarLicensePlateListViewContract.b)localObject).cqr())
    {
      Log.e("MicroMsg.CarLicensePlateListViewPresenter", "startEditUIForUpdate(plate:" + paramString + ") get NULL activity");
      AppMethodBeat.o(277765);
      return;
    }
    j.a(wd(), null, null, (m)new d((Activity)localObject, paramString, this, null), 3);
    AppMethodBeat.o(277765);
  }
  
  public final void akp(String paramString)
  {
    AppMethodBeat.i(277770);
    s.u(paramString, "plateNo");
    j.a(wd(), null, null, (m)new b(paramString, this, null), 3);
    AppMethodBeat.o(277770);
  }
  
  public final CarLicensePlateListViewContract.ViewModel cqq()
  {
    AppMethodBeat.i(277730);
    CarLicensePlateListViewContract.ViewModel localViewModel = this.wdr;
    if (localViewModel == null)
    {
      s.bIx("_viewModel");
      AppMethodBeat.o(277730);
      return null;
    }
    AppMethodBeat.o(277730);
    return localViewModel;
  }
  
  public final void diX()
  {
    AppMethodBeat.i(277740);
    a(new CarLicensePlateListViewContract.ViewModel());
    AppMethodBeat.o(277740);
  }
  
  public final void diY()
  {
    AppMethodBeat.i(277755);
    Object localObject = this.wdq;
    if (localObject == null) {}
    for (localObject = null; localObject == null; localObject = ((CarLicensePlateListViewContract.b)localObject).cqr())
    {
      Log.e("MicroMsg.CarLicensePlateListViewPresenter", "startEditUIForCreate get NULL activity");
      AppMethodBeat.o(277755);
      return;
    }
    j.a(wd(), null, null, (m)new c((Activity)localObject, this, null), 3);
    AppMethodBeat.o(277755);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    b(String paramString, d paramd, kotlin.d.d<? super b> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(277668);
      paramObject = (kotlin.d.d)new b(this.rGM, jdField_this, paramd);
      AppMethodBeat.o(277668);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(277662);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      kotlin.d.d locald;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(277662);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlin.g.a.a)new u(jdField_this) {};
        locald = (kotlin.d.d)this;
        this.label = 1;
        if (com.tencent.mm.plugin.car_license_plate.b.a.a(paramObject, locald) == locala)
        {
          AppMethodBeat.o(277662);
          return locala;
        }
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      case 2: 
      case 3: 
        try
        {
          paramObject = new c(this.rGM);
          locald = (kotlin.d.d)this;
          this.label = 2;
          paramObject = paramObject.U(locald);
          if (paramObject != locala) {
            break label158;
          }
          AppMethodBeat.o(277662);
          return locala;
        }
        catch (com.tencent.mm.plugin.car_license_plate.a.d paramObject)
        {
          label158:
          while (paramObject.errCode == -17501) {}
          paramObject = (kotlin.g.a.a)new u(jdField_this) {};
          locald = (kotlin.d.d)this;
          this.label = 3;
          if (com.tencent.mm.plugin.car_license_plate.b.a.a(paramObject, locald) != locala) {
            break label260;
          }
          AppMethodBeat.o(277662);
          return locala;
          ResultKt.throwOnFailure(paramObject);
          paramObject = ah.aiuX;
          AppMethodBeat.o(277662);
          return paramObject;
        }
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlin.g.a.a)new u(jdField_this) {};
        locald = (kotlin.d.d)this;
        this.label = 4;
        if (com.tencent.mm.plugin.car_license_plate.b.a.a(paramObject, locald) != locala) {
          break label275;
        }
        AppMethodBeat.o(277662);
        return locala;
      }
      label260:
      ResultKt.throwOnFailure(paramObject);
      label275:
      paramObject = ah.aiuX;
      AppMethodBeat.o(277662);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    c(Activity paramActivity, d paramd, kotlin.d.d<? super c> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(277676);
      paramObject = (kotlin.d.d)new c(this.rxb, jdField_this, paramd);
      AppMethodBeat.o(277676);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(277667);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject;
      int i;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(277667);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.rxb;
        localObject = new Intent((Context)this.rxb, CarLicensePlateEditUI.class);
        kotlin.d.d locald = (kotlin.d.d)this;
        this.label = 1;
        localObject = com.tencent.mm.plugin.car_license_plate.b.a.a(paramObject, (Intent)localObject, locald);
        paramObject = localObject;
        if (localObject == locala)
        {
          AppMethodBeat.o(277667);
          return locala;
        }
      case 1: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (Instrumentation.ActivityResult)paramObject;
        i = com.tencent.mm.plugin.car_license_plate.b.a.a(paramObject);
        paramObject = com.tencent.mm.plugin.car_license_plate.b.a.b(paramObject);
        Log.i("MicroMsg.CarLicensePlateListViewPresenter", "startEditUIForCreate, get code:" + i + ", data:" + paramObject);
        if ((-1 == i) && (paramObject != null))
        {
          paramObject = paramObject.getStringExtra("RESULT_KEY_SUBMITTED_PLATE_TEXT");
          localObject = (CharSequence)paramObject;
          if ((localObject != null) && (((CharSequence)localObject).length() != 0)) {
            break label256;
          }
          i = 1;
        }
        break;
      }
      for (;;)
      {
        if (i == 0)
        {
          paramObject = (kotlin.g.a.a)new u(jdField_this) {};
          localObject = (kotlin.d.d)this;
          this.label = 2;
          if (com.tencent.mm.plugin.car_license_plate.b.a.a(paramObject, (kotlin.d.d)localObject) == locala)
          {
            AppMethodBeat.o(277667);
            return locala;
            paramObject = null;
            break;
            label256:
            i = 0;
            continue;
            ResultKt.throwOnFailure(paramObject);
          }
        }
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(277667);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    d(Activity paramActivity, String paramString, d paramd, kotlin.d.d<? super d> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(277679);
      paramObject = (kotlin.d.d)new d(this.rxb, paramString, jdField_this, paramd);
      AppMethodBeat.o(277679);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(277669);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject1;
      int i;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(277669);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.rxb;
        localObject1 = new Intent((Context)this.rxb, CarLicensePlateEditUI.class);
        ((Intent)localObject1).putExtra("INTENT_KEY_DEFAULT_PLATE_TEXT", paramString);
        Object localObject2 = ah.aiuX;
        localObject2 = (kotlin.d.d)this;
        this.label = 1;
        localObject1 = com.tencent.mm.plugin.car_license_plate.b.a.a(paramObject, (Intent)localObject1, (kotlin.d.d)localObject2);
        paramObject = localObject1;
        if (localObject1 == locala)
        {
          AppMethodBeat.o(277669);
          return locala;
        }
      case 1: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (Instrumentation.ActivityResult)paramObject;
        i = com.tencent.mm.plugin.car_license_plate.b.a.a(paramObject);
        paramObject = com.tencent.mm.plugin.car_license_plate.b.a.b(paramObject);
        Log.i("MicroMsg.CarLicensePlateListViewPresenter", "startEditUIForUpdate(plateNo:" + paramString + "), get code:" + i + ", data:" + paramObject);
        if (-2 == i)
        {
          d.b(jdField_this);
          paramObject = ah.aiuX;
          AppMethodBeat.o(277669);
          return paramObject;
        }
        if ((-1 == i) && (paramObject != null))
        {
          paramObject = paramObject.getStringExtra("RESULT_KEY_SUBMITTED_PLATE_TEXT");
          localObject1 = (CharSequence)paramObject;
          if ((localObject1 != null) && (((CharSequence)localObject1).length() != 0)) {
            break label323;
          }
          i = 1;
        }
        break;
      }
      for (;;)
      {
        if ((i == 0) && (!s.p(paramObject, paramString)))
        {
          paramObject = (kotlin.g.a.a)new u(jdField_this) {};
          localObject1 = (kotlin.d.d)this;
          this.label = 2;
          if (com.tencent.mm.plugin.car_license_plate.b.a.a(paramObject, (kotlin.d.d)localObject1) == locala)
          {
            AppMethodBeat.o(277669);
            return locala;
            paramObject = null;
            break;
            label323:
            i = 0;
            continue;
            ResultKt.throwOnFailure(paramObject);
          }
        }
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(277669);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    e(d paramd, boolean paramBoolean, kotlin.d.d<? super e> paramd1)
    {
      super(paramd1);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(277689);
      paramObject = (kotlin.d.d)new e(this.wds, bool, paramd);
      AppMethodBeat.o(277689);
      return paramObject;
    }
    
    public final Object invokeSuspend(final Object paramObject)
    {
      AppMethodBeat.i(277682);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject1;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(277682);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlin.g.a.a)new u(this.wds) {};
        localObject1 = (kotlin.d.d)this;
        this.label = 1;
        if (com.tencent.mm.plugin.car_license_plate.b.a.a(paramObject, (kotlin.d.d)localObject1) == locala)
        {
          AppMethodBeat.o(277682);
          return locala;
        }
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      case 2: 
      case 3: 
        CarLicensePlateListViewContract.ViewModel localViewModel;
        MMCarLicensePlateInfo localMMCarLicensePlateInfo;
        for (;;)
        {
          try
          {
            paramObject = new e(this.wds.cqq().qIf, d.a(this.wds));
            localObject1 = (kotlin.d.d)this;
            this.label = 2;
            paramObject = paramObject.U((kotlin.d.d)localObject1);
            localObject1 = paramObject;
            if (paramObject == locala)
            {
              AppMethodBeat.o(277682);
              return locala;
              ResultKt.throwOnFailure(paramObject);
              localObject1 = paramObject;
            }
            paramObject = (cux)localObject1;
            localObject1 = paramObject.aaAo;
            if (localObject1 == null) {
              break label439;
            }
            localObject1 = ((fvh)localObject1).abTE;
            if (localObject1 == null) {
              break label439;
            }
            if (!((Collection)localObject1).isEmpty())
            {
              i = 1;
              if (i != 1) {
                break label439;
              }
              i = 1;
              if (i == 0) {
                break label539;
              }
              localViewModel = this.wds.cqq();
              localObject1 = MMCarLicensePlateInfo.wbJ;
              paramObject = paramObject.aaAo;
              s.checkNotNull(paramObject);
              s.s(paramObject, "resp.plate_info!!");
              s.u(paramObject, "pb");
              localMMCarLicensePlateInfo = new MMCarLicensePlateInfo();
              localObject1 = paramObject.abTE;
              if (localObject1 == null) {
                break;
              }
              localObject1 = ((Iterable)localObject1).iterator();
              if (!((Iterator)localObject1).hasNext()) {
                break;
              }
              Object localObject2 = (fvi)((Iterator)localObject1).next();
              Object localObject3 = (CharSequence)((fvi)localObject2).Zqo;
              if ((localObject3 != null) && (((CharSequence)localObject3).length() != 0)) {
                break label444;
              }
              i = 1;
              if (i != 0) {
                continue;
              }
              localObject3 = localMMCarLicensePlateInfo.wbK;
              localObject2 = ((fvi)localObject2).Zqo;
              s.checkNotNull(localObject2);
              ((ArrayList)localObject3).add(localObject2);
              continue;
            }
            i = 0;
          }
          catch (com.tencent.mm.plugin.car_license_plate.a.d paramObject)
          {
            paramObject = (kotlin.g.a.a)new a(this.wds, paramObject);
            localObject1 = (kotlin.d.d)this;
            this.label = 3;
            if (com.tencent.mm.plugin.car_license_plate.b.a.a(paramObject, (kotlin.d.d)localObject1) == locala)
            {
              AppMethodBeat.o(277682);
              return locala;
              ResultKt.throwOnFailure(paramObject);
            }
            paramObject = ah.aiuX;
            AppMethodBeat.o(277682);
            return paramObject;
          }
          continue;
          label439:
          int i = 0;
          continue;
          label444:
          i = 0;
        }
        paramObject = paramObject.abTF;
        if (paramObject == null)
        {
          paramObject = null;
          localObject1 = paramObject;
          if (paramObject == null) {
            localObject1 = "";
          }
          s.u(localObject1, "<set-?>");
          localMMCarLicensePlateInfo.wbL = ((String)localObject1);
        }
        label539:
        for (localViewModel.wdm = localMMCarLicensePlateInfo;; this.wds.cqq().wdm = new MMCarLicensePlateInfo())
        {
          paramObject = (kotlin.g.a.a)new u(this.wds) {};
          localObject1 = (kotlin.d.d)this;
          this.label = 4;
          if (com.tencent.mm.plugin.car_license_plate.b.a.a(paramObject, (kotlin.d.d)localObject1) != locala) {
            break label563;
          }
          AppMethodBeat.o(277682);
          return locala;
          paramObject = paramObject.Zqo;
          break;
        }
      }
      ResultKt.throwOnFailure(paramObject);
      label563:
      paramObject = ah.aiuX;
      AppMethodBeat.o(277682);
      return paramObject;
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(d paramd, com.tencent.mm.plugin.car_license_plate.a.d paramd1)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.car_license_plate.ui.d
 * JD-Core Version:    0.7.0.1
 */
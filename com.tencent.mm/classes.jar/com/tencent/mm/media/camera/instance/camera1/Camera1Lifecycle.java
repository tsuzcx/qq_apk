package com.tencent.mm.media.camera.instance.camera1;

import androidx.lifecycle.j.a;
import androidx.lifecycle.o;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.camera.f;
import com.tencent.mm.media.camera.instance.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.b.a.k;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/media/camera/instance/camera1/Camera1Lifecycle;", "Landroidx/lifecycle/LifecycleEventObserver;", "camera", "Lcom/tencent/mm/media/camera/instance/camera1/Camera1Impl;", "(Lcom/tencent/mm/media/camera/instance/camera1/Camera1Impl;)V", "getCamera", "()Lcom/tencent/mm/media/camera/instance/camera1/Camera1Impl;", "setCamera", "cameraCoroutines", "Lcom/tencent/mm/media/camera/ICameraCoroutines;", "lifeCycleHash", "", "attachLifeCycleOwner", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onStateChanged", "source", "event", "Landroidx/lifecycle/Lifecycle$Event;", "Companion", "plugin-camera_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class Camera1Lifecycle
  implements o
{
  public static final Camera1Lifecycle.a nuX;
  c nuY;
  int nuZ;
  f nuw;
  
  static
  {
    AppMethodBeat.i(237401);
    nuX = new Camera1Lifecycle.a((byte)0);
    AppMethodBeat.o(237401);
  }
  
  public Camera1Lifecycle(c paramc)
  {
    AppMethodBeat.i(237399);
    this.nuY = paramc;
    AppMethodBeat.o(237399);
  }
  
  public final void onStateChanged(q paramq, j.a parama)
  {
    AppMethodBeat.i(237411);
    s.u(paramq, "source");
    s.u(parama, "event");
    Log.i("MicroMsg.Camera.Camera1Lifecycle", s.X("onStateChanged ", parama));
    paramq = this.nuw;
    if (paramq != null) {
      paramq.f((m)new c(parama, this, null));
    }
    AppMethodBeat.o(237411);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    b(Camera1Lifecycle paramCamera1Lifecycle, d<? super b> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(237386);
      paramObject = (d)new b(this.nva, paramd);
      AppMethodBeat.o(237386);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237379);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237379);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (com.tencent.mm.media.camera.instance.c)this.nva.nuY;
        d locald = (d)this;
        this.label = 1;
        if (c.a.a(paramObject, locald) == locala)
        {
          AppMethodBeat.o(237379);
          return locala;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(237379);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    c(j.a parama, Camera1Lifecycle paramCamera1Lifecycle, d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(237381);
      paramObject = (d)new c(this.nvb, jdField_this, paramd);
      AppMethodBeat.o(237381);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237377);
      a locala = a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237377);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = this.nvb;
        switch (Camera1Lifecycle.c.a.$EnumSwitchMapping$0[paramObject.ordinal()])
        {
        }
        break;
      }
      for (;;)
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(237377);
        return paramObject;
        paramObject = jdField_this.nuY;
        d locald = (d)this;
        this.label = 1;
        if (paramObject.s(locald) == locala)
        {
          AppMethodBeat.o(237377);
          return locala;
          ResultKt.throwOnFailure(paramObject);
          continue;
          paramObject = (com.tencent.mm.media.camera.instance.c)jdField_this.nuY;
          locald = (d)this;
          this.label = 2;
          if (c.a.a(paramObject, locald) == locala)
          {
            AppMethodBeat.o(237377);
            return locala;
            ResultKt.throwOnFailure(paramObject);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.camera.instance.camera1.Camera1Lifecycle
 * JD-Core Version:    0.7.0.1
 */
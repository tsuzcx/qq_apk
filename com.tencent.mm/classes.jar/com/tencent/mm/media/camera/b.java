package com.tencent.mm.media.camera;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.media.camera.d.c;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.r;
import kotlinx.coroutines.b.x;

@Metadata(d1={""}, d2={"emitSwitchState", "", "Lcom/tencent/mm/media/camera/CameraKit;", "(Lcom/tencent/mm/media/camera/CameraKit;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "plugin-camera_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final Object a(a parama, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(237075);
    Object localObject1;
    if ((paramd instanceof a))
    {
      localObject1 = (a)paramd;
      if ((((a)localObject1).label & 0x80000000) != 0) {
        ((a)localObject1).label += -2147483648;
      }
    }
    Object localObject2;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new a(paramd))
    {
      localObject2 = paramd.result;
      localObject1 = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        parama = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(237075);
        throw parama;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    c localc = parama.bnL();
    if (localc != null)
    {
      localObject2 = new Bundle();
      if (!localc.nvA) {}
      for (boolean bool = true;; bool = false)
      {
        ((Bundle)localObject2).putBoolean("camera_boolean", bool);
        parama = parama.ntn;
        localObject2 = new r(com.tencent.mm.media.camera.view.a.nwQ, localObject2);
        paramd.label = 1;
        if (parama.a(localObject2, paramd) != localObject1) {
          break;
        }
        AppMethodBeat.o(237075);
        return localObject1;
      }
      ResultKt.throwOnFailure(localObject2);
    }
    parama = ah.aiuX;
    AppMethodBeat.o(237075);
    return parama;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    int label;
    
    a(kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(237137);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = b.a(null, (kotlin.d.d)this);
      AppMethodBeat.o(237137);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.media.camera.b
 * JD-Core Version:    0.7.0.1
 */
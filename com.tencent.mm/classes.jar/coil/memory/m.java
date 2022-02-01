package coil.memory;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.b.g;
import coil.j.h;
import coil.j.i;
import coil.target.b;
import coil.util.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d<-Lkotlin.ah;>;

@Metadata(d1={""}, d2={"Lcoil/memory/PoolableTargetDelegate;", "Lcoil/memory/TargetDelegate;", "target", "Lcoil/target/PoolableViewTarget;", "referenceCounter", "Lcoil/bitmap/BitmapReferenceCounter;", "eventListener", "Lcoil/EventListener;", "logger", "Lcoil/util/Logger;", "(Lcoil/target/PoolableViewTarget;Lcoil/bitmap/BitmapReferenceCounter;Lcoil/EventListener;Lcoil/util/Logger;)V", "getTarget", "()Lcoil/target/PoolableViewTarget;", "clear", "", "decrement", "bitmap", "Landroid/graphics/Bitmap;", "error", "result", "Lcoil/request/ErrorResult;", "(Lcoil/request/ErrorResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "increment", "replace", "update", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "start", "placeholder", "Landroid/graphics/drawable/Drawable;", "cached", "success", "Lcoil/request/SuccessResult;", "(Lcoil/request/SuccessResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class m
  extends s
{
  private final k cli;
  private final coil.b.d cnQ;
  private final coil.c cod;
  private final coil.target.a<?> cov;
  
  public m(coil.target.a<?> parama, coil.b.d paramd, coil.c paramc, k paramk)
  {
    super((byte)0);
    AppMethodBeat.i(188291);
    this.cov = parama;
    this.cnQ = paramd;
    this.cod = paramc;
    this.cli = paramk;
    AppMethodBeat.o(188291);
  }
  
  private final void p(Bitmap paramBitmap)
  {
    AppMethodBeat.i(188303);
    if (paramBitmap != null) {
      this.cnQ.p(paramBitmap);
    }
    AppMethodBeat.o(188303);
  }
  
  private final void s(Bitmap paramBitmap)
  {
    AppMethodBeat.i(188312);
    t localt = coil.util.d.cm(this.cov.getView());
    kotlin.g.b.s.u(this, "tag");
    if (paramBitmap != null) {}
    for (paramBitmap = (Bitmap)localt.coQ.put(this, paramBitmap);; paramBitmap = (Bitmap)localt.coQ.remove(this))
    {
      if (paramBitmap != null) {
        this.cnQ.q(paramBitmap);
      }
      AppMethodBeat.o(188312);
      return;
    }
  }
  
  public final Object a(coil.j.f paramf, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(188343);
    Object localObject1;
    if ((paramd instanceof a))
    {
      localObject1 = (a)paramd;
      if ((((a)localObject1).label & 0x80000000) != 0) {
        ((a)localObject1).label += -2147483648;
      }
    }
    Object localObject3;
    Object localObject2;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new a(this, paramd))
    {
      localObject3 = paramd.result;
      localObject2 = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramf = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(188343);
        throw paramf;
      }
    }
    ResultKt.throwOnFailure(localObject3);
    Object localObject4;
    Object localObject5;
    if ((this.cnQ instanceof coil.b.f))
    {
      localObject4 = (b)this.cov;
      localObject1 = this.cod;
      localObject5 = this.cli;
      localObject3 = paramf.cmE.cpj;
      if (localObject3 == coil.l.c.cqo) {
        ((b)localObject4).A(paramf.drawable);
      }
      for (;;)
      {
        paramf = ah.aiuX;
        AppMethodBeat.o(188343);
        return paramf;
        if ((localObject4 instanceof coil.l.d)) {
          break;
        }
        if ((paramf.cmE.cpG.cpj != null) && (localObject5 != null) && (((k)localObject5).getLevel() <= 3)) {
          new StringBuilder("Ignoring '").append(localObject3).append("' as '").append(localObject4).append("' does not implement coil.transition.TransitionTarget.");
        }
        ((b)localObject4).A(paramf.drawable);
      }
      ((coil.c)localObject1).c(paramf.cmE);
      localObject4 = (coil.l.d)localObject4;
      localObject5 = (i)paramf;
      paramd.L$0 = paramf;
      paramd.Uf = localObject1;
      paramd.label = 1;
      if (((coil.l.c)localObject3).a((coil.l.d)localObject4, (i)localObject5, paramd) != localObject2) {
        break label631;
      }
      AppMethodBeat.o(188343);
      return localObject2;
      localObject1 = (coil.c)paramd.Uf;
      paramf = (coil.j.f)paramd.L$0;
      ResultKt.throwOnFailure(localObject3);
    }
    label631:
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = (kotlin.d.d<? super ah>)localObject1)
    {
      paramd.d(paramf.cmE);
      break;
      p(null);
      localObject4 = (b)this.cov;
      localObject1 = this.cod;
      localObject5 = this.cli;
      localObject3 = paramf.cmE.cpj;
      if (localObject3 == coil.l.c.cqo) {
        ((b)localObject4).A(paramf.drawable);
      }
      for (paramd = this;; paramd = this)
      {
        paramd.s(null);
        break;
        if ((localObject4 instanceof coil.l.d)) {
          break label510;
        }
        if ((paramf.cmE.cpG.cpj != null) && (localObject5 != null) && (((k)localObject5).getLevel() <= 3)) {
          new StringBuilder("Ignoring '").append(localObject3).append("' as '").append(localObject4).append("' does not implement coil.transition.TransitionTarget.");
        }
        ((b)localObject4).A(paramf.drawable);
      }
      label510:
      ((coil.c)localObject1).c(paramf.cmE);
      localObject4 = (coil.l.d)localObject4;
      localObject5 = (i)paramf;
      paramd.L$0 = paramf;
      paramd.Uf = this;
      paramd.VC = localObject1;
      paramd.label = 2;
      if (((coil.l.c)localObject3).a((coil.l.d)localObject4, (i)localObject5, paramd) == localObject2)
      {
        AppMethodBeat.o(188343);
        return localObject2;
        localObject1 = (coil.c)paramd.VC;
        paramf = (m)paramd.Uf;
        localObject2 = (coil.j.f)paramd.L$0;
        ResultKt.throwOnFailure(localObject3);
        paramd = paramf;
        paramf = (coil.j.f)localObject2;
      }
      for (;;)
      {
        ((coil.c)localObject1).d(paramf.cmE);
        break;
        paramd = this;
      }
    }
  }
  
  public final Object a(coil.j.m paramm, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(188331);
    Object localObject1;
    if ((paramd instanceof b))
    {
      localObject1 = (b)paramd;
      if ((((b)localObject1).label & 0x80000000) != 0) {
        ((b)localObject1).label += -2147483648;
      }
    }
    Object localObject3;
    for (;;)
    {
      localObject4 = ((b)localObject1).result;
      localObject3 = kotlin.d.a.a.aiwj;
      switch (((b)localObject1).label)
      {
      default: 
        paramm = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(188331);
        throw paramm;
        localObject1 = new b(this, paramd);
      }
    }
    ResultKt.throwOnFailure(localObject4);
    paramd = ((i)paramm).getDrawable();
    label142:
    Object localObject2;
    if ((paramd instanceof BitmapDrawable))
    {
      paramd = (BitmapDrawable)paramd;
      if (paramd != null) {
        break label217;
      }
      paramd = null;
      if (!(this.cnQ instanceof coil.b.f)) {
        break label404;
      }
      localObject4 = (b)this.cov;
      paramd = this.cod;
      localObject5 = this.cli;
      localObject2 = paramm.cmE.cpj;
      if (localObject2 != coil.l.c.cqo) {
        break label225;
      }
      ((b)localObject4).B(paramm.drawable);
    }
    for (;;)
    {
      paramm = ah.aiuX;
      AppMethodBeat.o(188331);
      return paramm;
      paramd = null;
      break;
      label217:
      paramd = paramd.getBitmap();
      break label142;
      label225:
      if ((localObject4 instanceof coil.l.d)) {
        break label306;
      }
      if ((paramm.cmE.cpG.cpj != null) && (localObject5 != null) && (((k)localObject5).getLevel() <= 3)) {
        new StringBuilder("Ignoring '").append(localObject2).append("' as '").append(localObject4).append("' does not implement coil.transition.TransitionTarget.");
      }
      ((b)localObject4).B(paramm.drawable);
    }
    label306:
    paramd.c(paramm.cmE);
    Object localObject4 = (coil.l.d)localObject4;
    Object localObject5 = (i)paramm;
    ((b)localObject1).L$0 = paramm;
    ((b)localObject1).Uf = paramd;
    ((b)localObject1).label = 1;
    if (((coil.l.c)localObject2).a((coil.l.d)localObject4, (i)localObject5, (kotlin.d.d)localObject1) == localObject3)
    {
      AppMethodBeat.o(188331);
      return localObject3;
      paramd = (coil.c)((b)localObject1).Uf;
      paramm = (coil.j.m)((b)localObject1).L$0;
      ResultKt.throwOnFailure(localObject4);
    }
    for (;;)
    {
      paramd.d(paramm.cmE);
      break;
      label404:
      p(paramd);
      localObject5 = (b)this.cov;
      localObject2 = this.cod;
      Object localObject6 = this.cli;
      localObject4 = paramm.cmE.cpj;
      if (localObject4 == coil.l.c.cqo)
      {
        ((b)localObject5).B(paramm.drawable);
        localObject1 = this;
        paramm = paramd;
      }
      for (;;)
      {
        ((m)localObject1).s(paramm);
        break;
        if ((localObject5 instanceof coil.l.d)) {
          break label555;
        }
        if ((paramm.cmE.cpG.cpj != null) && (localObject6 != null) && (((k)localObject6).getLevel() <= 3)) {
          new StringBuilder("Ignoring '").append(localObject4).append("' as '").append(localObject5).append("' does not implement coil.transition.TransitionTarget.");
        }
        ((b)localObject5).B(paramm.drawable);
        paramm = paramd;
        localObject1 = this;
      }
      label555:
      ((coil.c)localObject2).c(paramm.cmE);
      localObject5 = (coil.l.d)localObject5;
      localObject6 = (i)paramm;
      ((b)localObject1).L$0 = paramm;
      ((b)localObject1).Uf = this;
      ((b)localObject1).VC = paramd;
      ((b)localObject1).VD = localObject2;
      ((b)localObject1).label = 2;
      if (((coil.l.c)localObject4).a((coil.l.d)localObject5, (i)localObject6, (kotlin.d.d)localObject1) == localObject3)
      {
        AppMethodBeat.o(188331);
        return localObject3;
        localObject2 = (coil.c)((b)localObject1).VD;
        localObject3 = (Bitmap)((b)localObject1).VC;
        paramd = (m)((b)localObject1).Uf;
        paramm = (coil.j.m)((b)localObject1).L$0;
        ResultKt.throwOnFailure(localObject4);
        localObject1 = localObject3;
      }
      for (;;)
      {
        ((coil.c)localObject2).d(paramm.cmE);
        paramm = (coil.j.m)localObject1;
        localObject1 = paramd;
        break;
        localObject1 = paramd;
        paramd = this;
      }
    }
  }
  
  public final void a(Drawable paramDrawable, Bitmap paramBitmap)
  {
    AppMethodBeat.i(188320);
    if ((this.cnQ instanceof coil.b.f))
    {
      this.cov.z(paramDrawable);
      AppMethodBeat.o(188320);
      return;
    }
    p(paramBitmap);
    this.cov.z(paramDrawable);
    s(paramBitmap);
    AppMethodBeat.o(188320);
  }
  
  public final void clear()
  {
    AppMethodBeat.i(188357);
    if ((this.cnQ instanceof coil.b.f))
    {
      this.cov.nP();
      AppMethodBeat.o(188357);
      return;
    }
    p(null);
    this.cov.nP();
    s(null);
    AppMethodBeat.o(188357);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    int label;
    
    a(m paramm, kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(188326);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.cow.a(null, (kotlin.d.d)this);
      AppMethodBeat.o(188326);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    Object VD;
    int label;
    
    b(m paramm, kotlin.d.d<? super b> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(188325);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.cow.a(null, (kotlin.d.d)this);
      AppMethodBeat.o(188325);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     coil.memory.m
 * JD-Core Version:    0.7.0.1
 */
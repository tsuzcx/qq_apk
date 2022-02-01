package coil.memory;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import coil.j.f;
import coil.j.h;
import coil.j.i;
import coil.j.m;
import coil.target.b;
import coil.util.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.a.a;
import kotlin.d.d<-Lkotlin.ah;>;

@Metadata(d1={""}, d2={"Lcoil/memory/InvalidatableTargetDelegate;", "Lcoil/memory/TargetDelegate;", "target", "Lcoil/target/Target;", "referenceCounter", "Lcoil/bitmap/BitmapReferenceCounter;", "eventListener", "Lcoil/EventListener;", "logger", "Lcoil/util/Logger;", "(Lcoil/target/Target;Lcoil/bitmap/BitmapReferenceCounter;Lcoil/EventListener;Lcoil/util/Logger;)V", "getTarget", "()Lcoil/target/Target;", "error", "", "result", "Lcoil/request/ErrorResult;", "(Lcoil/request/ErrorResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "start", "placeholder", "Landroid/graphics/drawable/Drawable;", "cached", "Landroid/graphics/Bitmap;", "success", "Lcoil/request/SuccessResult;", "(Lcoil/request/SuccessResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends s
{
  private final k cli;
  private final coil.b.d cnQ;
  private final coil.c cod;
  private final b com;
  
  public j(b paramb, coil.b.d paramd, coil.c paramc, k paramk)
  {
    super((byte)0);
    AppMethodBeat.i(188289);
    this.com = paramb;
    this.cnQ = paramd;
    this.cod = paramc;
    this.cli = paramk;
    AppMethodBeat.o(188289);
  }
  
  public final b MT()
  {
    return this.com;
  }
  
  public final Object a(f paramf, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(188335);
    if ((paramd instanceof a))
    {
      localObject1 = (a)paramd;
      if ((((a)localObject1).label & 0x80000000) != 0) {
        ((a)localObject1).label += -2147483648;
      }
    }
    a locala;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new a(this, paramd))
    {
      localObject2 = paramd.result;
      locala = a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramf = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(188335);
        throw paramf;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    Object localObject3 = this.com;
    Object localObject1 = this.cod;
    Object localObject4 = this.cli;
    Object localObject2 = paramf.cmE.cpj;
    if (localObject2 == coil.l.c.cqo) {
      ((b)localObject3).A(paramf.drawable);
    }
    for (;;)
    {
      paramf = ah.aiuX;
      AppMethodBeat.o(188335);
      return paramf;
      if ((localObject3 instanceof coil.l.d)) {
        break;
      }
      if ((paramf.cmE.cpG.cpj != null) && (localObject4 != null) && (((k)localObject4).getLevel() <= 3)) {
        new StringBuilder("Ignoring '").append(localObject2).append("' as '").append(localObject3).append("' does not implement coil.transition.TransitionTarget.");
      }
      ((b)localObject3).A(paramf.drawable);
    }
    ((coil.c)localObject1).c(paramf.cmE);
    localObject3 = (coil.l.d)localObject3;
    localObject4 = (i)paramf;
    paramd.L$0 = paramf;
    paramd.Uf = localObject1;
    paramd.label = 1;
    if (((coil.l.c)localObject2).a((coil.l.d)localObject3, (i)localObject4, paramd) == locala)
    {
      AppMethodBeat.o(188335);
      return locala;
      localObject1 = (coil.c)paramd.Uf;
      paramf = (f)paramd.L$0;
      ResultKt.throwOnFailure(localObject2);
    }
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = (kotlin.d.d<? super ah>)localObject1)
    {
      paramd.d(paramf.cmE);
      break;
    }
  }
  
  public final Object a(m paramm, kotlin.d.d<? super ah> paramd)
  {
    AppMethodBeat.i(188321);
    if ((paramd instanceof b))
    {
      localObject1 = (b)paramd;
      if ((((b)localObject1).label & 0x80000000) != 0) {
        ((b)localObject1).label += -2147483648;
      }
    }
    a locala;
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = new b(this, paramd))
    {
      localObject2 = paramd.result;
      locala = a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramm = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(188321);
        throw paramm;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    Object localObject2 = this.cnQ;
    Object localObject1 = ((i)paramm).getDrawable();
    if ((localObject1 instanceof BitmapDrawable))
    {
      localObject1 = (BitmapDrawable)localObject1;
      if (localObject1 != null) {
        break label217;
      }
      localObject1 = null;
      label143:
      if (localObject1 != null) {
        ((coil.b.d)localObject2).a((Bitmap)localObject1, false);
      }
      localObject3 = this.com;
      localObject1 = this.cod;
      localObject4 = this.cli;
      localObject2 = paramm.cmE.cpj;
      if (localObject2 != coil.l.c.cqo) {
        break label225;
      }
      ((b)localObject3).B(paramm.drawable);
    }
    for (;;)
    {
      paramm = ah.aiuX;
      AppMethodBeat.o(188321);
      return paramm;
      localObject1 = null;
      break;
      label217:
      localObject1 = ((BitmapDrawable)localObject1).getBitmap();
      break label143;
      label225:
      if ((localObject3 instanceof coil.l.d)) {
        break label306;
      }
      if ((paramm.cmE.cpG.cpj != null) && (localObject4 != null) && (((k)localObject4).getLevel() <= 3)) {
        new StringBuilder("Ignoring '").append(localObject2).append("' as '").append(localObject3).append("' does not implement coil.transition.TransitionTarget.");
      }
      ((b)localObject3).B(paramm.drawable);
    }
    label306:
    ((coil.c)localObject1).c(paramm.cmE);
    Object localObject3 = (coil.l.d)localObject3;
    Object localObject4 = (i)paramm;
    paramd.L$0 = paramm;
    paramd.Uf = localObject1;
    paramd.label = 1;
    if (((coil.l.c)localObject2).a((coil.l.d)localObject3, (i)localObject4, paramd) == locala)
    {
      AppMethodBeat.o(188321);
      return locala;
      localObject1 = (coil.c)paramd.Uf;
      paramm = (m)paramd.L$0;
      ResultKt.throwOnFailure(localObject2);
    }
    for (paramd = (kotlin.d.d<? super ah>)localObject1;; paramd = (kotlin.d.d<? super ah>)localObject1)
    {
      paramd.d(paramm.cmE);
      break;
    }
  }
  
  public final void a(Drawable paramDrawable, Bitmap paramBitmap)
  {
    AppMethodBeat.i(188311);
    coil.b.d locald = this.cnQ;
    if (paramBitmap != null) {
      locald.a(paramBitmap, false);
    }
    this.com.z(paramDrawable);
    AppMethodBeat.o(188311);
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    a(j paramj, kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(188267);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.con.a(null, (kotlin.d.d)this);
      AppMethodBeat.o(188267);
      return paramObject;
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    int label;
    
    b(j paramj, kotlin.d.d<? super b> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(188262);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.con.a(null, (kotlin.d.d)this);
      AppMethodBeat.o(188262);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     coil.memory.j
 * JD-Core Version:    0.7.0.1
 */
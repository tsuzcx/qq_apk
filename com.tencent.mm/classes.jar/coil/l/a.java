package coil.l;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import androidx.l.a.a.b.a;
import coil.j.f;
import coil.j.i;
import coil.j.i.a;
import coil.j.m;
import coil.size.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Result.Companion;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlinx.coroutines.p;
import kotlinx.coroutines.q;

@Metadata(d1={""}, d2={"Lcoil/transition/CrossfadeTransition;", "Lcoil/transition/Transition;", "()V", "durationMillis", "", "(I)V", "preferExactIntrinsicSize", "", "(IZ)V", "getDurationMillis", "()I", "getPreferExactIntrinsicSize", "()Z", "equals", "other", "", "hashCode", "toString", "", "transition", "", "target", "Lcoil/transition/TransitionTarget;", "result", "Lcoil/request/ImageResult;", "(Lcoil/transition/TransitionTarget;Lcoil/request/ImageResult;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements c
{
  public final int WN;
  private final boolean cnA;
  
  public a()
  {
    this(0, 3);
  }
  
  private a(int paramInt)
  {
    AppMethodBeat.i(187814);
    this.WN = paramInt;
    this.cnA = false;
    paramInt = i;
    if (this.WN > 0) {
      paramInt = 1;
    }
    if (paramInt == 0)
    {
      Throwable localThrowable = (Throwable)new IllegalArgumentException("durationMillis must be > 0.".toString());
      AppMethodBeat.o(187814);
      throw localThrowable;
    }
    AppMethodBeat.o(187814);
  }
  
  public final Object a(d paramd, i parami, kotlin.d.d<? super ah> paramd1)
  {
    AppMethodBeat.i(187850);
    a locala;
    if ((paramd1 instanceof a))
    {
      locala = (a)paramd1;
      if ((locala.label & 0x80000000) != 0) {
        locala.label += -2147483648;
      }
    }
    kotlin.d.a.a locala1;
    for (;;)
    {
      paramd1 = locala.result;
      locala1 = kotlin.d.a.a.aiwj;
      switch (locala.label)
      {
      default: 
        paramd = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(187850);
        throw paramd;
        locala = new a(this, paramd1);
      }
    }
    ResultKt.throwOnFailure(paramd1);
    if (((parami instanceof m)) && (((m)parami).coM.cnH == coil.e.b.cmU))
    {
      paramd.B(((m)parami).drawable);
      paramd = ah.aiuX;
      AppMethodBeat.o(187850);
      return paramd;
    }
    if (!paramd.getView().isShown())
    {
      if ((parami instanceof m)) {
        paramd.B(((m)parami).drawable);
      }
      for (;;)
      {
        paramd = ah.aiuX;
        AppMethodBeat.o(187850);
        return paramd;
        if ((parami instanceof f)) {
          paramd.A(parami.getDrawable());
        }
      }
    }
    ah.f localf = new ah.f();
    for (;;)
    {
      boolean bool;
      try
      {
        locala.L$0 = this;
        locala.Uf = paramd;
        locala.VC = parami;
        locala.VD = localf;
        locala.label = 1;
        q localq = new q(kotlin.d.a.b.au(locala), 1);
        localq.kBA();
        final p localp = (p)localq;
        Drawable localDrawable1 = paramd.getDrawable();
        Drawable localDrawable2 = parami.getDrawable();
        paramd1 = paramd.getView();
        if ((paramd1 instanceof ImageView))
        {
          paramd1 = (ImageView)paramd1;
          break label570;
          Object localObject = paramd1;
          if (paramd1 == null) {
            localObject = e.cpY;
          }
          int i = this.WN;
          if (!(parami instanceof m)) {
            break label579;
          }
          if (((m)parami).coM.cpM) {
            break label585;
          }
          break label579;
          paramd1 = new coil.f.a(localDrawable1, localDrawable2, (e)localObject, i, bool, this.cnA);
          localf.aqH = paramd1;
          localObject = (b.a)new b(paramd1, localp);
          s.u(localObject, "callback");
          paramd1.bPE.add(localObject);
          if ((parami instanceof m))
          {
            paramd.B((Drawable)paramd1);
            paramd = localq.getResult();
            if (paramd == kotlin.d.a.a.aiwj) {
              s.u(locala, "frame");
            }
            if (paramd != locala1) {
              break label555;
            }
            AppMethodBeat.o(187850);
            return locala1;
          }
        }
        else
        {
          paramd1 = null;
          break label570;
          paramd1 = coil.util.d.c(paramd1);
          continue;
        }
        if (!(parami instanceof f)) {
          continue;
        }
        paramd.A((Drawable)paramd1);
        continue;
        parami = (ah.f)locala.VD;
      }
      finally
      {
        parami = localf;
        parami = (coil.f.a)parami.aqH;
        if (parami != null) {
          parami.stop();
        }
        AppMethodBeat.o(187850);
      }
      try
      {
        ResultKt.throwOnFailure(paramd1);
        label555:
        paramd = ah.aiuX;
        AppMethodBeat.o(187850);
        return paramd;
      }
      finally {}
      continue;
      label570:
      if (paramd1 == null)
      {
        paramd1 = null;
        continue;
        label579:
        bool = true;
        continue;
        label585:
        bool = false;
      }
    }
  }
  
  public final boolean equals(Object paramObject)
  {
    return (this == paramObject) || (((paramObject instanceof a)) && (this.WN == ((a)paramObject).WN));
  }
  
  public final int hashCode()
  {
    return this.WN;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(187873);
    String str = "CrossfadeTransition(durationMillis=" + this.WN + ')';
    AppMethodBeat.o(187873);
    return str;
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends kotlin.d.b.a.d
  {
    Object L$0;
    Object Uf;
    Object VC;
    Object VD;
    int label;
    
    a(a parama, kotlin.d.d<? super a> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(187808);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = this.cqk.a(null, null, (kotlin.d.d)this);
      AppMethodBeat.o(187808);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"coil/transition/CrossfadeTransition$transition$2$1", "Landroidx/vectordrawable/graphics/drawable/Animatable2Compat$AnimationCallback;", "onAnimationEnd", "", "drawable", "Landroid/graphics/drawable/Drawable;", "coil-base_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends b.a
  {
    b(coil.f.a parama, p<? super ah> paramp) {}
    
    public final void Me()
    {
      AppMethodBeat.i(187811);
      Object localObject1 = this.cql;
      Object localObject2 = (b.a)this;
      s.u(localObject2, "callback");
      ((coil.f.a)localObject1).bPE.remove(localObject2);
      localObject1 = (kotlin.d.d)localp;
      localObject2 = ah.aiuX;
      Result.Companion localCompanion = Result.Companion;
      ((kotlin.d.d)localObject1).resumeWith(Result.constructor-impl(localObject2));
      AppMethodBeat.o(187811);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     coil.l.a
 * JD-Core Version:    0.7.0.1
 */
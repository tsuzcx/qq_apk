package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/VectorizedFloatAnimationSpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedFiniteAnimationSpec;", "anim", "Landroidx/compose/animation/core/FloatAnimationSpec;", "(Landroidx/compose/animation/core/FloatAnimationSpec;)V", "anims", "Landroidx/compose/animation/core/Animations;", "(Landroidx/compose/animation/core/Animations;)V", "endVelocityVector", "Landroidx/compose/animation/core/AnimationVector;", "valueVector", "velocityVector", "getDurationNanos", "", "initialValue", "targetValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getEndVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getValueFromNanos", "playTimeNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class be<V extends k>
  implements bd<V>
{
  public static final int Ue = 8;
  private V Uw;
  private final p Xw;
  private V Xx;
  private V Xy;
  
  public be(ab paramab)
  {
    this((p)new p()
    {
      public final ab br(int paramAnonymousInt)
      {
        return this.Xz;
      }
    });
    AppMethodBeat.i(203303);
    AppMethodBeat.o(203303);
  }
  
  public be(p paramp)
  {
    AppMethodBeat.i(203297);
    this.Xw = paramp;
    AppMethodBeat.o(203297);
  }
  
  public final long a(V paramV1, V paramV2, V paramV3)
  {
    AppMethodBeat.i(203330);
    s.u(paramV1, "initialValue");
    s.u(paramV2, "targetValue");
    s.u(paramV3, "initialVelocity");
    long l = 0L;
    Iterator localIterator = ((Iterable)kotlin.k.k.qt(0, paramV1.lK())).iterator();
    while (localIterator.hasNext())
    {
      int i = ((ah)localIterator).Zo();
      l = Math.max(l, this.Xw.br(i).e(paramV1.bq(i), paramV2.bq(i), paramV3.bq(i)));
    }
    AppMethodBeat.o(203330);
    return l;
  }
  
  public final V a(long paramLong, V paramV1, V paramV2, V paramV3)
  {
    AppMethodBeat.i(203314);
    s.u(paramV1, "initialValue");
    s.u(paramV2, "targetValue");
    s.u(paramV3, "initialVelocity");
    if (this.Xx == null) {
      this.Xx = o.b(paramV1);
    }
    k localk2 = this.Xx;
    k localk1 = localk2;
    if (localk2 == null)
    {
      s.bIx("valueVector");
      localk1 = null;
    }
    int k = localk1.lK();
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      localk2 = this.Xx;
      localk1 = localk2;
      if (localk2 == null)
      {
        s.bIx("valueVector");
        localk1 = null;
      }
      localk1.e(i, this.Xw.br(i).a(paramLong, paramV1.bq(i), paramV2.bq(i), paramV3.bq(i)));
      if (j >= k)
      {
        paramV1 = this.Xx;
        if (paramV1 == null)
        {
          s.bIx("valueVector");
          AppMethodBeat.o(203314);
          return null;
        }
        AppMethodBeat.o(203314);
        return paramV1;
      }
    }
  }
  
  public final V b(long paramLong, V paramV1, V paramV2, V paramV3)
  {
    AppMethodBeat.i(203320);
    s.u(paramV1, "initialValue");
    s.u(paramV2, "targetValue");
    s.u(paramV3, "initialVelocity");
    if (this.Uw == null) {
      this.Uw = o.b(paramV3);
    }
    k localk2 = this.Uw;
    k localk1 = localk2;
    if (localk2 == null)
    {
      s.bIx("velocityVector");
      localk1 = null;
    }
    int k = localk1.lK();
    if (k > 0) {}
    int j;
    for (int i = 0;; i = j)
    {
      j = i + 1;
      localk2 = this.Uw;
      localk1 = localk2;
      if (localk2 == null)
      {
        s.bIx("velocityVector");
        localk1 = null;
      }
      localk1.e(i, this.Xw.br(i).b(paramLong, paramV1.bq(i), paramV2.bq(i), paramV3.bq(i)));
      if (j >= k)
      {
        paramV1 = this.Uw;
        if (paramV1 == null)
        {
          s.bIx("velocityVector");
          AppMethodBeat.o(203320);
          return null;
        }
        AppMethodBeat.o(203320);
        return paramV1;
      }
    }
  }
  
  public final V b(V paramV1, V paramV2, V paramV3)
  {
    AppMethodBeat.i(203323);
    s.u(paramV1, "initialValue");
    s.u(paramV2, "targetValue");
    s.u(paramV3, "initialVelocity");
    if (this.Xy == null) {
      this.Xy = o.b(paramV3);
    }
    int i = 0;
    k localk2 = this.Xy;
    k localk1 = localk2;
    if (localk2 == null)
    {
      s.bIx("endVelocityVector");
      localk1 = null;
    }
    int k = localk1.lK();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      localk2 = this.Xy;
      localk1 = localk2;
      if (localk2 == null)
      {
        s.bIx("endVelocityVector");
        localk1 = null;
      }
      localk1.e(i, this.Xw.br(i).d(paramV1.bq(i), paramV2.bq(i), paramV3.bq(i)));
      if (j >= k)
      {
        paramV1 = this.Xy;
        if (paramV1 == null)
        {
          s.bIx("endVelocityVector");
          AppMethodBeat.o(203323);
          return null;
        }
        AppMethodBeat.o(203323);
        return paramV1;
      }
      i = j;
    }
  }
  
  public final boolean lF()
  {
    AppMethodBeat.i(203336);
    s.u(this, "this");
    AppMethodBeat.o(203336);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.be
 * JD-Core Version:    0.7.0.1
 */
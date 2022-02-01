package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/VectorizedFloatDecaySpec;", "V", "Landroidx/compose/animation/core/AnimationVector;", "Landroidx/compose/animation/core/VectorizedDecayAnimationSpec;", "floatDecaySpec", "Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "(Landroidx/compose/animation/core/FloatDecayAnimationSpec;)V", "absVelocityThreshold", "", "getAbsVelocityThreshold", "()F", "getFloatDecaySpec", "()Landroidx/compose/animation/core/FloatDecayAnimationSpec;", "targetVector", "Landroidx/compose/animation/core/AnimationVector;", "valueVector", "velocityVector", "getDurationNanos", "", "initialValue", "initialVelocity", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)J", "getTargetValue", "(Landroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getValueFromNanos", "playTimeNanos", "(JLandroidx/compose/animation/core/AnimationVector;Landroidx/compose/animation/core/AnimationVector;)Landroidx/compose/animation/core/AnimationVector;", "getVelocityFromNanos", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
final class bf<V extends k>
  implements bb<V>
{
  private final ac UO;
  private V Uw;
  private V XA;
  private final float XB;
  private V Xx;
  
  public bf(ac paramac)
  {
    AppMethodBeat.i(203299);
    this.UO = paramac;
    this.XB = this.UO.lz();
    AppMethodBeat.o(203299);
  }
  
  public final V a(long paramLong, V paramV1, V paramV2)
  {
    AppMethodBeat.i(203310);
    s.u(paramV1, "initialValue");
    s.u(paramV2, "initialVelocity");
    if (this.Xx == null) {
      this.Xx = o.b(paramV1);
    }
    int i = 0;
    k localk2 = this.Xx;
    k localk1 = localk2;
    if (localk2 == null)
    {
      s.bIx("valueVector");
      localk1 = null;
    }
    int k = localk1.lK();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      localk2 = this.Xx;
      localk1 = localk2;
      if (localk2 == null)
      {
        s.bIx("valueVector");
        localk1 = null;
      }
      localk1.e(i, this.UO.a(paramLong, paramV1.bq(i), paramV2.bq(i)));
      if (j >= k)
      {
        paramV1 = this.Xx;
        if (paramV1 == null)
        {
          s.bIx("valueVector");
          AppMethodBeat.o(203310);
          return null;
        }
        AppMethodBeat.o(203310);
        return paramV1;
      }
      i = j;
    }
  }
  
  public final long b(V paramV1, V paramV2)
  {
    AppMethodBeat.i(203316);
    s.u(paramV1, "initialValue");
    s.u(paramV2, "initialVelocity");
    long l1 = 0L;
    if (this.Uw == null) {
      this.Uw = o.b(paramV1);
    }
    int i = 0;
    k localk = this.Uw;
    Object localObject = localk;
    if (localk == null)
    {
      s.bIx("velocityVector");
      localObject = null;
    }
    int k = ((k)localObject).lK();
    long l2 = l1;
    if (k > 0)
    {
      int j;
      do
      {
        j = i + 1;
        localObject = this.UO;
        paramV1.bq(i);
        l2 = Math.max(l1, ((ac)localObject).p(paramV2.bq(i)));
        i = j;
        l1 = l2;
      } while (j < k);
    }
    AppMethodBeat.o(203316);
    return l2;
  }
  
  public final V b(long paramLong, V paramV1, V paramV2)
  {
    AppMethodBeat.i(203321);
    s.u(paramV1, "initialValue");
    s.u(paramV2, "initialVelocity");
    if (this.Uw == null) {
      this.Uw = o.b(paramV1);
    }
    int i = 0;
    Object localObject2 = this.Uw;
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      s.bIx("velocityVector");
      localObject1 = null;
    }
    int k = localObject1.lK();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      localObject2 = this.Uw;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        s.bIx("velocityVector");
        localObject1 = null;
      }
      localObject2 = this.UO;
      paramV1.bq(i);
      localObject1.e(i, ((ac)localObject2).b(paramLong, paramV2.bq(i)));
      if (j >= k)
      {
        paramV1 = this.Uw;
        if (paramV1 == null)
        {
          s.bIx("velocityVector");
          AppMethodBeat.o(203321);
          return null;
        }
        AppMethodBeat.o(203321);
        return paramV1;
      }
      i = j;
    }
  }
  
  public final V c(V paramV1, V paramV2)
  {
    AppMethodBeat.i(203327);
    s.u(paramV1, "initialValue");
    s.u(paramV2, "initialVelocity");
    if (this.XA == null) {
      this.XA = o.b(paramV1);
    }
    int i = 0;
    k localk2 = this.XA;
    k localk1 = localk2;
    if (localk2 == null)
    {
      s.bIx("targetVector");
      localk1 = null;
    }
    int k = localk1.lK();
    if (k > 0) {}
    for (;;)
    {
      int j = i + 1;
      localk2 = this.XA;
      localk1 = localk2;
      if (localk2 == null)
      {
        s.bIx("targetVector");
        localk1 = null;
      }
      localk1.e(i, this.UO.r(paramV1.bq(i), paramV2.bq(i)));
      if (j >= k)
      {
        paramV1 = this.XA;
        if (paramV1 == null)
        {
          s.bIx("targetVector");
          AppMethodBeat.o(203327);
          return null;
        }
        AppMethodBeat.o(203327);
        return paramV1;
      }
      i = j;
    }
  }
  
  public final float lz()
  {
    return this.XB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.bf
 * JD-Core Version:    0.7.0.1
 */
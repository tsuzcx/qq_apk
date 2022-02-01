package androidx.compose.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/core/Animation;", "T", "V", "Landroidx/compose/animation/core/AnimationVector;", "", "durationNanos", "", "getDurationNanos", "()J", "isInfinite", "", "()Z", "targetValue", "getTargetValue", "()Ljava/lang/Object;", "typeConverter", "Landroidx/compose/animation/core/TwoWayConverter;", "getTypeConverter", "()Landroidx/compose/animation/core/TwoWayConverter;", "getValueFromNanos", "playTimeNanos", "(J)Ljava/lang/Object;", "getVelocityVectorFromNanos", "(J)Landroidx/compose/animation/core/AnimationVector;", "isFinishedFromNanos", "animation-core_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface c<T, V extends k>
{
  public abstract T k(long paramLong);
  
  public abstract V l(long paramLong);
  
  public abstract long lC();
  
  public abstract aw<T, V> lD();
  
  public abstract T lE();
  
  public abstract boolean lF();
  
  public abstract boolean m(long paramLong);
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static <T, V extends k> boolean a(c<T, V> paramc, long paramLong)
    {
      AppMethodBeat.i(203340);
      s.u(paramc, "this");
      if (paramLong >= paramc.lC())
      {
        AppMethodBeat.o(203340);
        return true;
      }
      AppMethodBeat.o(203340);
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.a.c
 * JD-Core Version:    0.7.0.1
 */
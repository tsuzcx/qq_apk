package androidx.compose.ui.g.c.a;

import androidx.compose.ui.n.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/input/pointer/util/VelocityTracker;", "", "()V", "index", "", "samples", "", "Landroidx/compose/ui/input/pointer/util/PointAtTime;", "[Landroidx/compose/ui/input/pointer/util/PointAtTime;", "addPosition", "", "timeMillis", "", "position", "Landroidx/compose/ui/geometry/Offset;", "addPosition-Uv8p0NA", "(JJ)V", "calculateVelocity", "Landroidx/compose/ui/unit/Velocity;", "calculateVelocity-9UxMQ8M", "()J", "getVelocityEstimate", "Landroidx/compose/ui/input/pointer/util/VelocityEstimate;", "resetTracking", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final int Ue = 8;
  private final b[] aMw;
  private int index;
  
  public f()
  {
    AppMethodBeat.i(205881);
    int i = 0;
    b[] arrayOfb = new b[20];
    while (i < 20)
    {
      arrayOfb[i] = null;
      i += 1;
    }
    this.aMw = arrayOfb;
    AppMethodBeat.o(205881);
  }
  
  private final e wB()
  {
    AppMethodBeat.i(205894);
    List localList3 = (List)new ArrayList();
    List localList1 = (List)new ArrayList();
    List localList2 = (List)new ArrayList();
    int i = 0;
    int j = this.index;
    b localb = this.aMw[j];
    if (localb == null)
    {
      localObject1 = e.aMs;
      localObject1 = e.wz();
      AppMethodBeat.o(205894);
      return localObject1;
    }
    Object localObject1 = localb;
    Object localObject4 = localb;
    Object localObject3 = this.aMw[j];
    float f1;
    if (localObject3 != null)
    {
      f1 = (float)(localb.time - ((b)localObject3).time);
      float f2 = (float)Math.abs(((b)localObject3).time - ((b)localObject4).time);
      if ((f1 <= 100.0F) && (f2 <= 40.0F)) {}
    }
    for (;;)
    {
      if (i >= 3)
      {
        try
        {
          localObject3 = g.e(localList2, localList3);
          localObject4 = g.e(localList2, localList1);
          localObject1 = new e(androidx.compose.ui.d.f.x(((Number)((c)localObject3).aMp.get(1)).floatValue() * 1000.0F, ((Number)((c)localObject4).aMp.get(1)).floatValue() * 1000.0F), ((c)localObject3).aMq * ((c)localObject4).aMq, localb.time - ((b)localObject1).time, androidx.compose.ui.d.e.f(localb.aMo, ((b)localObject1).aMo), (byte)0);
          AppMethodBeat.o(205894);
          return localObject1;
        }
        catch (IllegalArgumentException localIllegalArgumentException)
        {
          localObject2 = e.aMs;
          localObject2 = e.wz();
          AppMethodBeat.o(205894);
          return localObject2;
        }
        long l = ((b)localObject3).aMo;
        localList3.add(Float.valueOf(androidx.compose.ui.d.e.F(l)));
        localList1.add(Float.valueOf(androidx.compose.ui.d.e.G(l)));
        localList2.add(Float.valueOf(-f1));
        int k = j;
        if (j == 0) {
          k = 20;
        }
        j = k - 1;
        i += 1;
        if (i >= 20) {
          localObject2 = localObject3;
        }
      }
      else
      {
        localObject3 = androidx.compose.ui.d.e.avo;
        localObject2 = new e(androidx.compose.ui.d.e.su(), 1.0F, localb.time - ((b)localObject2).time, androidx.compose.ui.d.e.f(localb.aMo, ((b)localObject2).aMo), (byte)0);
        AppMethodBeat.o(205894);
        return localObject2;
      }
      Object localObject2 = localObject3;
      localObject4 = localObject3;
      break;
    }
  }
  
  public final void k(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(205903);
    this.index = ((this.index + 1) % 20);
    this.aMw[this.index] = new b(paramLong2, paramLong1, 0);
    AppMethodBeat.o(205903);
  }
  
  public final long wA()
  {
    AppMethodBeat.i(205908);
    long l = wB().aMt;
    l = s.K(androidx.compose.ui.d.e.F(l), androidx.compose.ui.d.e.G(l));
    AppMethodBeat.o(205908);
    return l;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.g.c.a.f
 * JD-Core Version:    0.7.0.1
 */
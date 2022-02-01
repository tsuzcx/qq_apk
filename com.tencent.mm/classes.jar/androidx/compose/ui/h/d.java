package androidx.compose.ui.h;

import androidx.compose.ui.d.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/layout/ContentScale;", "", "computeScaleFactor", "Landroidx/compose/ui/layout/ScaleFactor;", "srcSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "computeScaleFactor-H7hwNQA", "(JJ)J", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface d
{
  public static final a aMF = a.aMG;
  
  public abstract long l(long paramLong1, long paramLong2);
  
  @Metadata(d1={""}, d2={"Landroidx/compose/ui/layout/ContentScale$Companion;", "", "()V", "Crop", "Landroidx/compose/ui/layout/ContentScale;", "getCrop$annotations", "getCrop", "()Landroidx/compose/ui/layout/ContentScale;", "FillBounds", "getFillBounds$annotations", "getFillBounds", "FillHeight", "getFillHeight$annotations", "getFillHeight", "FillWidth", "getFillWidth$annotations", "getFillWidth", "Fit", "getFit$annotations", "getFit", "Inside", "getInside$annotations", "getInside", "None", "Landroidx/compose/ui/layout/FixedScale;", "getNone$annotations", "getNone", "()Landroidx/compose/ui/layout/FixedScale;", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static final d aMH;
    private static final d aMI;
    private static final d aMJ;
    private static final d aMK;
    private static final d aML;
    private static final f aMM;
    private static final d aMN;
    
    static
    {
      AppMethodBeat.i(205615);
      aMG = new a();
      aMH = (d)new a();
      aMI = (d)new e();
      aMJ = (d)new c();
      aMK = (d)new d();
      aML = (d)new f();
      aMM = new f();
      aMN = (d)new b();
      AppMethodBeat.o(205615);
    }
    
    public static d wF()
    {
      return aMH;
    }
    
    public static d wG()
    {
      return aMI;
    }
    
    public static d wH()
    {
      return aML;
    }
    
    @Metadata(d1={""}, d2={"androidx/compose/ui/layout/ContentScale$Companion$Crop$1", "Landroidx/compose/ui/layout/ContentScale;", "computeScaleFactor", "Landroidx/compose/ui/layout/ScaleFactor;", "srcSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "computeScaleFactor-H7hwNQA", "(JJ)J", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class a
      implements d
    {
      public final long l(long paramLong1, long paramLong2)
      {
        AppMethodBeat.i(205691);
        float f = Math.max(e.n(paramLong1, paramLong2), e.o(paramLong1, paramLong2));
        paramLong1 = ad.F(f, f);
        AppMethodBeat.o(205691);
        return paramLong1;
      }
    }
    
    @Metadata(d1={""}, d2={"androidx/compose/ui/layout/ContentScale$Companion$FillBounds$1", "Landroidx/compose/ui/layout/ContentScale;", "computeScaleFactor", "Landroidx/compose/ui/layout/ScaleFactor;", "srcSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "computeScaleFactor-H7hwNQA", "(JJ)J", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class b
      implements d
    {
      public final long l(long paramLong1, long paramLong2)
      {
        AppMethodBeat.i(205692);
        paramLong1 = ad.F(e.n(paramLong1, paramLong2), e.o(paramLong1, paramLong2));
        AppMethodBeat.o(205692);
        return paramLong1;
      }
    }
    
    @Metadata(d1={""}, d2={"androidx/compose/ui/layout/ContentScale$Companion$FillHeight$1", "Landroidx/compose/ui/layout/ContentScale;", "computeScaleFactor", "Landroidx/compose/ui/layout/ScaleFactor;", "srcSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "computeScaleFactor-H7hwNQA", "(JJ)J", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class c
      implements d
    {
      public final long l(long paramLong1, long paramLong2)
      {
        AppMethodBeat.i(205683);
        float f = e.o(paramLong1, paramLong2);
        paramLong1 = ad.F(f, f);
        AppMethodBeat.o(205683);
        return paramLong1;
      }
    }
    
    @Metadata(d1={""}, d2={"androidx/compose/ui/layout/ContentScale$Companion$FillWidth$1", "Landroidx/compose/ui/layout/ContentScale;", "computeScaleFactor", "Landroidx/compose/ui/layout/ScaleFactor;", "srcSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "computeScaleFactor-H7hwNQA", "(JJ)J", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class d
      implements d
    {
      public final long l(long paramLong1, long paramLong2)
      {
        AppMethodBeat.i(205689);
        float f = e.n(paramLong1, paramLong2);
        paramLong1 = ad.F(f, f);
        AppMethodBeat.o(205689);
        return paramLong1;
      }
    }
    
    @Metadata(d1={""}, d2={"androidx/compose/ui/layout/ContentScale$Companion$Fit$1", "Landroidx/compose/ui/layout/ContentScale;", "computeScaleFactor", "Landroidx/compose/ui/layout/ScaleFactor;", "srcSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "computeScaleFactor-H7hwNQA", "(JJ)J", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class e
      implements d
    {
      public final long l(long paramLong1, long paramLong2)
      {
        AppMethodBeat.i(205680);
        float f = e.m(paramLong1, paramLong2);
        paramLong1 = ad.F(f, f);
        AppMethodBeat.o(205680);
        return paramLong1;
      }
    }
    
    @Metadata(d1={""}, d2={"androidx/compose/ui/layout/ContentScale$Companion$Inside$1", "Landroidx/compose/ui/layout/ContentScale;", "computeScaleFactor", "Landroidx/compose/ui/layout/ScaleFactor;", "srcSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "computeScaleFactor-H7hwNQA", "(JJ)J", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
    public static final class f
      implements d
    {
      public final long l(long paramLong1, long paramLong2)
      {
        AppMethodBeat.i(205677);
        if ((k.Q(paramLong1) <= k.Q(paramLong2)) && (k.R(paramLong1) <= k.R(paramLong2)))
        {
          paramLong1 = ad.F(1.0F, 1.0F);
          AppMethodBeat.o(205677);
          return paramLong1;
        }
        float f = e.m(paramLong1, paramLong2);
        paramLong1 = ad.F(f, f);
        AppMethodBeat.o(205677);
        return paramLong1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.h.d
 * JD-Core Version:    0.7.0.1
 */
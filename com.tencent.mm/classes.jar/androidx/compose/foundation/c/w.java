package androidx.compose.foundation.c;

import androidx.compose.ui.h.h;
import androidx.compose.ui.h.o;
import androidx.compose.ui.h.p;
import androidx.compose.ui.h.r;
import androidx.compose.ui.h.r.a;
import androidx.compose.ui.h.x.a;
import androidx.compose.ui.n.d;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.b;
import kotlin.g.b.ah.d;
import kotlin.g.b.u;
import kotlin.h.a;
import kotlin.k.k;

@Metadata(d1={""}, d2={"crossAxisAlignment", "Landroidx/compose/foundation/layout/CrossAxisAlignment;", "Landroidx/compose/foundation/layout/RowColumnParentData;", "getCrossAxisAlignment", "(Landroidx/compose/foundation/layout/RowColumnParentData;)Landroidx/compose/foundation/layout/CrossAxisAlignment;", "data", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getData", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Landroidx/compose/foundation/layout/RowColumnParentData;", "fill", "", "getFill", "(Landroidx/compose/foundation/layout/RowColumnParentData;)Z", "isRelative", "weight", "", "getWeight", "(Landroidx/compose/foundation/layout/RowColumnParentData;)F", "MaxIntrinsicHeightMeasureBlock", "Lkotlin/Function3;", "", "", "orientation", "Landroidx/compose/foundation/layout/LayoutOrientation;", "MaxIntrinsicWidthMeasureBlock", "MinIntrinsicHeightMeasureBlock", "MinIntrinsicWidthMeasureBlock", "intrinsicCrossAxisSize", "children", "mainAxisSize", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "crossAxisSize", "mainAxisAvailable", "intrinsicMainAxisSize", "crossAxisAvailable", "mainAxisSpacing", "intrinsicSize", "intrinsicMainSize", "intrinsicCrossSize", "layoutOrientation", "intrinsicOrientation", "rowColumnMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "arrangement", "Lkotlin/Function5;", "", "Landroidx/compose/ui/unit/LayoutDirection;", "Landroidx/compose/ui/unit/Density;", "", "arrangementSpacing", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/foundation/layout/SizeMode;", "rowColumnMeasurePolicy-TDGSqEk", "(Landroidx/compose/foundation/layout/LayoutOrientation;Lkotlin/jvm/functions/Function5;FLandroidx/compose/foundation/layout/SizeMode;Landroidx/compose/foundation/layout/CrossAxisAlignment;)Landroidx/compose/ui/layout/MeasurePolicy;", "foundation-layout_release"}, k=2, mv={1, 5, 1}, xi=48)
public final class w
{
  static final i a(x paramx)
  {
    if (paramx == null) {
      return null;
    }
    return paramx.adA;
  }
  
  public static final p a(m paramm, final kotlin.g.a.s<? super Integer, ? super int[], ? super n, ? super d, ? super int[], ah> params, final float paramFloat, final ac paramac, final i parami)
  {
    AppMethodBeat.i(203900);
    kotlin.g.b.s.u(paramm, "orientation");
    kotlin.g.b.s.u(params, "arrangement");
    kotlin.g.b.s.u(paramac, "crossAxisSize");
    kotlin.g.b.s.u(parami, "crossAxisAlignment");
    paramm = (p)new a(paramm, paramFloat, paramac, params, parami);
    AppMethodBeat.o(203900);
    return paramm;
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/foundation/layout/RowColumnImplKt$rowColumnMeasurePolicy$1", "Landroidx/compose/ui/layout/MeasurePolicy;", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Ljava/util/List;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements p
  {
    a(m paramm, float paramFloat, ac paramac, kotlin.g.a.s<? super Integer, ? super int[], ? super n, ? super d, ? super int[], ah> params, i parami) {}
    
    public final androidx.compose.ui.h.q a(final r paramr, List<? extends o> paramList, long paramLong)
    {
      AppMethodBeat.i(203802);
      kotlin.g.b.s.u(paramr, "$receiver");
      kotlin.g.b.s.u(paramList, "measurables");
      q localq = new q(paramLong, this.adq, (byte)0);
      int i6 = paramr.v(paramFloat);
      float f2 = 0.0F;
      float f1 = 0.0F;
      final int k = 0;
      int j = 0;
      int m = 0;
      int n = 0;
      final androidx.compose.ui.h.x[] arrayOfx = new androidx.compose.ui.h.x[paramList.size()];
      int i1 = paramList.size();
      final x[] arrayOfx1 = new x[i1];
      final int i = 0;
      Object localObject1;
      if (i < i1)
      {
        localObject1 = ((h)paramList.get(i)).wI();
        if ((localObject1 instanceof x)) {}
        for (localObject1 = (x)localObject1;; localObject1 = null)
        {
          arrayOfx1[i] = localObject1;
          i += 1;
          break;
        }
      }
      int i4 = paramList.size() - 1;
      int i2;
      Object localObject2;
      if (i4 >= 0)
      {
        i1 = 0;
        i2 = 0;
        i = k;
        k = i2;
        i2 = i1 + 1;
        localObject2 = (o)paramList.get(i1);
        localObject1 = arrayOfx1[i1];
        f2 = w.b((x)localObject1);
        if (f2 > 0.0F)
        {
          f1 += f2;
          m += 1;
          if (i2 <= i4) {
            break label1341;
          }
          i1 = n;
          n = m;
          m = i;
          i = j;
          j = i1;
        }
      }
      for (;;)
      {
        i2 = 0;
        i1 = 0;
        int i3;
        label343:
        androidx.compose.ui.h.x localx;
        label375:
        m localm;
        label404:
        label450:
        label462:
        label600:
        label731:
        label893:
        boolean bool;
        if (n == 0)
        {
          n = j;
          k = m - k;
          j = i;
          m = i1;
          i = n;
          localObject2 = new ah.d();
          i2 = 0;
          n = i2;
          if (i != 0)
          {
            i1 = 0;
            i3 = arrayOfx.length - 1;
            n = i2;
            if (i3 >= 0)
            {
              i = 0;
              n = i1;
              i1 = n + 1;
              localx = arrayOfx[n];
              kotlin.g.b.s.checkNotNull(localx);
              if (w.a(arrayOfx1[n]) != null) {
                break label1186;
              }
              localObject1 = null;
              if (localObject1 == null) {
                break label1313;
              }
              i2 = ((ah.d)localObject2).aixb;
              n = ((Number)localObject1).intValue();
              if (n == -2147483648) {
                break label1196;
              }
              ((ah.d)localObject2).aixb = Math.max(i2, n);
              i2 = w.b(localx, this.adq);
              localm = this.adq;
              n = ((Number)localObject1).intValue();
              if (n == -2147483648) {
                break label1202;
              }
              i = Math.max(i, i2 - n);
              if (i1 <= i3) {
                break label1306;
              }
              n = i;
            }
          }
          k = Math.max(k + m, localq.acY);
          if ((localq.adb == 2147483647) || (paramac != ac.adZ)) {
            break label1214;
          }
          i = localq.adb;
          label515:
          if (this.adq != m.acP) {
            break label1240;
          }
          j = k;
          label529:
          if (this.adq != m.acP) {
            break label1247;
          }
          m = i;
          label543:
          n = 0;
          i1 = paramList.size();
          localObject1 = new int[i1];
          while (n < i1)
          {
            localObject1[n] = 0;
            n += 1;
          }
          i3 = localq.acZ;
          if (i3 == 2147483647)
          {
            k = 2147483647;
            localObject2 = ((o)localObject2).aw(new q(0, k, 0, localq.adb).a(this.adq));
            k = Math.min(i6, i3 - i - w.a((androidx.compose.ui.h.x)localObject2, this.adq));
            i3 = i + (w.a((androidx.compose.ui.h.x)localObject2, this.adq) + k);
            j = Math.max(j, w.b((androidx.compose.ui.h.x)localObject2, this.adq));
            if ((n == 0) && (!w.c((x)localObject1))) {
              break label731;
            }
          }
          for (i = 1;; i = 0)
          {
            arrayOfx[i1] = localObject2;
            n = i;
            i = i3;
            break;
            k = i3 - i;
            break label600;
          }
        }
        else
        {
          if ((f1 > 0.0F) && (localq.acZ != 2147483647))
          {
            k = localq.acZ;
            i3 = k - m - (n - 1) * i6;
            if (f1 <= 0.0F) {
              break label847;
            }
          }
          label847:
          for (f1 = i3 / f1;; f1 = 0.0F)
          {
            i1 = 0;
            i4 = arrayOfx1.length;
            k = 0;
            while (k < i4)
            {
              i1 += a.eH(w.b(arrayOfx1[k]) * f1);
              k += 1;
            }
            k = localq.acY;
            break;
          }
          i1 = i3 - i1;
          int i7 = paramList.size() - 1;
          if (i7 < 0) {
            break label1326;
          }
          i2 = 0;
          i3 = 0;
          k = i;
          i = j;
          j = i3;
          i4 = i2 + 1;
          if (arrayOfx[i2] != null) {
            break label1316;
          }
          localObject2 = (o)paramList.get(i2);
          localObject1 = arrayOfx1[i2];
          f2 = w.b((x)localObject1);
          if (f2 > 0.0F) {}
          for (i3 = 1; i3 == 0; i3 = 0)
          {
            paramr = (Throwable)new IllegalStateException("All weights <= 0 should have placeables".toString());
            AppMethodBeat.o(203802);
            throw paramr;
          }
          int i8 = a.aKq(i1);
          int i5 = Math.max(0, a.eH(f1 * f2) + i8);
          if (localObject1 == null)
          {
            bool = true;
            label1010:
            if ((!bool) || (i5 == 2147483647)) {
              break label1174;
            }
            i3 = i5;
            label1026:
            localObject2 = ((o)localObject2).aw(new q(i3, i5, 0, localq.adb).a(this.adq));
            j += w.a((androidx.compose.ui.h.x)localObject2, this.adq);
            k = Math.max(k, w.b((androidx.compose.ui.h.x)localObject2, this.adq));
            if ((i == 0) && (!w.c((x)localObject1))) {
              break label1180;
            }
            i = 1;
            label1105:
            arrayOfx[i2] = localObject2;
            i1 -= i8;
            label1119:
            if (i4 <= i7) {
              break label1319;
            }
          }
        }
        for (;;)
        {
          n = k.qv((n - 1) * i6 + j, localq.acZ - m);
          j = k;
          k = m;
          m = n;
          break;
          bool = ((x)localObject1).acS;
          break label1010;
          label1174:
          i3 = 0;
          break label1026;
          label1180:
          i = 0;
          break label1105;
          label1186:
          localObject1 = i.a(localx);
          break label375;
          label1196:
          n = 0;
          break label404;
          label1202:
          n = w.b(localx, localm);
          break label450;
          label1214:
          i = Math.max(j, Math.max(localq.ada, n + ((ah.d)localObject2).aixb));
          break label515;
          label1240:
          j = i;
          break label529;
          label1247:
          m = k;
          break label543;
          paramr = r.a.a(paramr, j, m, (b)new a(paramList, arrayOfx, params, k, paramr, (int[])localObject1, this.adq, arrayOfx1, parami, i, (ah.d)localObject2));
          AppMethodBeat.o(203802);
          return paramr;
          label1306:
          n = i1;
          break label343;
          label1313:
          break label462;
          label1316:
          break label1119;
          label1319:
          i2 = i4;
          break label893;
          label1326:
          k = i;
          i = j;
          j = i2;
        }
        label1341:
        i1 = i2;
        break;
        k = 0;
        j = 0;
        n = 0;
        i = 0;
        m = 0;
        f1 = f2;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;"}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements b<x.a, ah>
    {
      a(List<? extends o> paramList, androidx.compose.ui.h.x[] paramArrayOfx, kotlin.g.a.s<? super Integer, ? super int[], ? super n, ? super d, ? super int[], ah> params, int paramInt1, r paramr, int[] paramArrayOfInt, m paramm, x[] paramArrayOfx1, i parami, int paramInt2, ah.d paramd)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.c.w
 * JD-Core Version:    0.7.0.1
 */
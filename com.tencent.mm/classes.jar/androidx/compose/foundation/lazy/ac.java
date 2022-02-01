package androidx.compose.foundation.lazy;

import androidx.compose.ui.a.b;
import androidx.compose.ui.a.c;
import androidx.compose.ui.h.x;
import androidx.compose.ui.h.x.a;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/lazy/LazyMeasuredItem;", "Landroidx/compose/foundation/lazy/LazyListItemInfo;", "index", "", "placeables", "", "Landroidx/compose/ui/layout/Placeable;", "isVertical", "", "horizontalAlignment", "Landroidx/compose/ui/Alignment$Horizontal;", "verticalAlignment", "Landroidx/compose/ui/Alignment$Vertical;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "reverseLayout", "startContentPadding", "endContentPadding", "spacing", "key", "", "(I[Landroidx/compose/ui/layout/Placeable;ZLandroidx/compose/ui/Alignment$Horizontal;Landroidx/compose/ui/Alignment$Vertical;Landroidx/compose/ui/unit/LayoutDirection;ZIIILjava/lang/Object;)V", "crossAxisSize", "getCrossAxisSize", "()I", "getIndex", "getKey", "()Ljava/lang/Object;", "offset", "getOffset", "setOffset", "(I)V", "[Landroidx/compose/ui/layout/Placeable;", "size", "getSize", "sizeWithSpacings", "getSizeWithSpacings", "place", "", "scope", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "layoutWidth", "layoutHeight", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ac
  implements m
{
  private final x[] agj;
  private final a.b agk;
  private final a.c agl;
  private final n agm;
  private final boolean agn;
  private final int ago;
  private final int agp;
  private final int agq;
  final int agr;
  final int ags;
  final int index;
  private final boolean isVertical;
  final Object key;
  int offset;
  final int size;
  
  public ac(int paramInt1, x[] paramArrayOfx, boolean paramBoolean1, a.b paramb, a.c paramc, n paramn, boolean paramBoolean2, int paramInt2, int paramInt3, int paramInt4, Object paramObject)
  {
    AppMethodBeat.i(204279);
    this.index = paramInt1;
    this.agj = paramArrayOfx;
    this.isVertical = paramBoolean1;
    this.agk = paramb;
    this.agl = paramc;
    this.agm = paramn;
    this.agn = paramBoolean2;
    this.ago = paramInt2;
    this.agp = paramInt3;
    this.agq = paramInt4;
    this.key = paramObject;
    paramInt3 = 0;
    paramInt2 = 0;
    paramArrayOfx = this.agj;
    int i = paramArrayOfx.length;
    paramInt1 = 0;
    if (paramInt1 < i)
    {
      paramb = paramArrayOfx[paramInt1];
      if (this.isVertical)
      {
        paramInt4 = paramb.height;
        label134:
        paramInt4 = paramInt3 + paramInt4;
        if (this.isVertical) {
          break label185;
        }
      }
      label185:
      for (paramInt3 = paramb.height;; paramInt3 = paramb.width)
      {
        paramInt2 = Math.max(paramInt2, paramInt3);
        paramInt1 += 1;
        paramInt3 = paramInt4;
        break;
        paramInt4 = paramb.width;
        break label134;
      }
    }
    this.size = paramInt3;
    this.agr = (this.size + this.agq);
    this.ags = paramInt2;
    AppMethodBeat.o(204279);
  }
  
  public final void a(x.a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(204300);
    s.u(parama, "scope");
    int i;
    int j;
    label42:
    int k;
    if (this.isVertical)
    {
      i = paramInt2;
      if (!this.agn) {
        break label147;
      }
      j = i - this.offset - this.size;
      if (!this.agn) {
        break label156;
      }
      k = k.ad(this.agj);
    }
    for (;;)
    {
      label58:
      label73:
      x localx;
      if (this.agn) {
        if (k >= 0)
        {
          i = 1;
          if (i == 0) {
            break label369;
          }
          localx = this.agj[k];
          if (!this.agn) {
            break label190;
          }
          k -= 1;
        }
      }
      for (;;)
      {
        if (this.isVertical)
        {
          localObject = this.agk;
          if (localObject == null)
          {
            parama = (Throwable)new IllegalArgumentException("Required value was null.".toString());
            AppMethodBeat.o(204300);
            throw parama;
            i = paramInt1;
            break;
            label147:
            j = this.offset;
            break label42;
            label156:
            k = 0;
            break label58;
            i = 0;
            break label73;
            if (k < this.agj.length)
            {
              i = 1;
              break label73;
            }
            i = 0;
            break label73;
            label190:
            k += 1;
            continue;
          }
          i = ((a.b)localObject).a(localx.width, paramInt1, this.agm);
          if ((localx.height + j > -this.ago) && (j < this.agp + paramInt2)) {
            x.a.a(localx, i, j, null, 12);
          }
          j += localx.height;
          break label58;
        }
      }
      Object localObject = this.agl;
      if (localObject == null)
      {
        parama = (Throwable)new IllegalArgumentException("Required value was null.".toString());
        AppMethodBeat.o(204300);
        throw parama;
      }
      i = ((a.c)localObject).Y(localx.height, paramInt2);
      if ((localx.width + j > -this.ago) && (j < this.agp + paramInt1)) {
        x.a.b(parama, localx, j, i);
      }
      j += localx.width;
    }
    label369:
    AppMethodBeat.o(204300);
  }
  
  public final int getIndex()
  {
    return this.index;
  }
  
  public final int getOffset()
  {
    return this.offset;
  }
  
  public final int getSize()
  {
    return this.size;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.lazy.ac
 * JD-Core Version:    0.7.0.1
 */
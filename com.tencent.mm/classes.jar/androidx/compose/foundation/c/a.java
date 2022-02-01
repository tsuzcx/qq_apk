package androidx.compose.foundation.c;

import androidx.compose.ui.n.d;
import androidx.compose.ui.n.g;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/layout/Arrangement;", "", "()V", "Bottom", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "getBottom$annotations", "getBottom", "()Landroidx/compose/foundation/layout/Arrangement$Vertical;", "Center", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "getCenter$annotations", "getCenter", "()Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "End", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "getEnd$annotations", "getEnd", "()Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "SpaceAround", "getSpaceAround$annotations", "getSpaceAround", "SpaceBetween", "getSpaceBetween$annotations", "getSpaceBetween", "SpaceEvenly", "getSpaceEvenly$annotations", "getSpaceEvenly", "Start", "getStart$annotations", "getStart", "Top", "getTop$annotations", "getTop", "aligned", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "Landroidx/compose/ui/Alignment$Vertical;", "placeCenter", "", "totalSize", "", "size", "", "outPosition", "reverseInput", "", "placeCenter$foundation_layout_release", "placeLeftOrTop", "placeLeftOrTop$foundation_layout_release", "placeRightOrBottom", "placeRightOrBottom$foundation_layout_release", "placeSpaceAround", "placeSpaceAround$foundation_layout_release", "placeSpaceBetween", "placeSpaceBetween$foundation_layout_release", "placeSpaceEvenly", "placeSpaceEvenly$foundation_layout_release", "spacedBy", "space", "Landroidx/compose/ui/unit/Dp;", "spacedBy-0680j_4", "(F)Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "spacedBy-D5KLDUw", "(FLandroidx/compose/ui/Alignment$Horizontal;)Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "(FLandroidx/compose/ui/Alignment$Vertical;)Landroidx/compose/foundation/layout/Arrangement$Vertical;", "forEachIndexed", "reversed", "action", "Lkotlin/Function2;", "Absolute", "Horizontal", "HorizontalOrVertical", "SpacedAligned", "Vertical", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a abN;
  private static final d abO;
  private static final d abP;
  private static final l abQ;
  private static final l abR;
  private static final e abS;
  private static final e abT;
  private static final e abU;
  private static final e abV;
  
  static
  {
    AppMethodBeat.i(204133);
    abN = new a();
    abO = (d)new j();
    abP = (d)new c();
    abQ = (l)new k();
    abR = (l)new a();
    abS = (e)new b();
    abT = (e)new h();
    abU = (e)new g();
    abV = (e)new f();
    AppMethodBeat.o(204133);
  }
  
  public static e B(float paramFloat)
  {
    AppMethodBeat.i(204054);
    e locale = (e)new i(paramFloat, true, null, (byte)0);
    AppMethodBeat.o(204054);
    return locale;
  }
  
  public static d a(float paramFloat, androidx.compose.ui.a.b paramb)
  {
    AppMethodBeat.i(204064);
    s.u(paramb, "alignment");
    paramb = (d)new i(paramFloat, true, (m)new m(paramb), (byte)0);
    AppMethodBeat.o(204064);
    return paramb;
  }
  
  public static l a(float paramFloat, androidx.compose.ui.a.c paramc)
  {
    AppMethodBeat.i(204073);
    s.u(paramc, "alignment");
    paramc = (l)new i(paramFloat, false, (m)new n(paramc), (byte)0);
    AppMethodBeat.o(204073);
    return paramc;
  }
  
  public static void a(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(204080);
    s.u(paramArrayOfInt1, "size");
    s.u(paramArrayOfInt2, "outPosition");
    int k = paramArrayOfInt1.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += paramArrayOfInt1[i];
      i += 1;
    }
    paramInt -= j;
    if (!paramBoolean)
    {
      int m = paramArrayOfInt1.length;
      i = 0;
      k = 0;
      j = paramInt;
      paramInt = k;
      while (paramInt < m)
      {
        k = paramArrayOfInt1[paramInt];
        paramArrayOfInt2[i] = j;
        j += k;
        i += 1;
        paramInt += 1;
      }
      AppMethodBeat.o(204080);
      return;
    }
    j = paramArrayOfInt1.length - 1;
    if (j >= 0) {
      i = paramInt;
    }
    for (paramInt = j;; paramInt = j)
    {
      j = paramInt - 1;
      k = paramArrayOfInt1[paramInt];
      paramArrayOfInt2[paramInt] = i;
      i += k;
      if (j < 0)
      {
        AppMethodBeat.o(204080);
        return;
      }
    }
  }
  
  public static void a(int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
  {
    int i = 0;
    AppMethodBeat.i(204091);
    s.u(paramArrayOfInt1, "size");
    s.u(paramArrayOfInt2, "outPosition");
    int m;
    int k;
    if (!paramBoolean)
    {
      m = paramArrayOfInt1.length;
      j = 0;
      k = 0;
      i = 0;
      while (j < m)
      {
        int n = paramArrayOfInt1[j];
        paramArrayOfInt2[i] = k;
        k += n;
        j += 1;
        i += 1;
      }
      AppMethodBeat.o(204091);
      return;
    }
    int j = paramArrayOfInt1.length - 1;
    if (j >= 0) {}
    for (;;)
    {
      k = j - 1;
      m = paramArrayOfInt1[j];
      paramArrayOfInt2[j] = i;
      i += m;
      if (k < 0)
      {
        AppMethodBeat.o(204091);
        return;
      }
      j = k;
    }
  }
  
  public static void b(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(204105);
    s.u(paramArrayOfInt1, "size");
    s.u(paramArrayOfInt2, "outPosition");
    int k = paramArrayOfInt1.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += paramArrayOfInt1[i];
      i += 1;
    }
    float f = (paramInt - j) / 2.0F;
    if (!paramBoolean)
    {
      j = paramArrayOfInt1.length;
      i = 0;
      paramInt = 0;
      while (paramInt < j)
      {
        k = paramArrayOfInt1[paramInt];
        paramArrayOfInt2[i] = kotlin.h.a.eH(f);
        f += k;
        i += 1;
        paramInt += 1;
      }
      AppMethodBeat.o(204105);
      return;
    }
    paramInt = paramArrayOfInt1.length - 1;
    if (paramInt >= 0) {}
    for (;;)
    {
      i = paramInt - 1;
      j = paramArrayOfInt1[paramInt];
      paramArrayOfInt2[paramInt] = kotlin.h.a.eH(f);
      f += j;
      if (i < 0)
      {
        AppMethodBeat.o(204105);
        return;
      }
      paramInt = i;
    }
  }
  
  public static void c(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(204113);
    s.u(paramArrayOfInt1, "size");
    s.u(paramArrayOfInt2, "outPosition");
    int k = paramArrayOfInt1.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += paramArrayOfInt1[i];
      i += 1;
    }
    float f1 = (paramInt - j) / (paramArrayOfInt1.length + 1);
    float f2;
    if (!paramBoolean)
    {
      j = paramArrayOfInt1.length;
      paramInt = 0;
      i = 0;
      f2 = f1;
      while (i < j)
      {
        k = paramArrayOfInt1[i];
        paramArrayOfInt2[paramInt] = kotlin.h.a.eH(f2);
        f2 += k + f1;
        i += 1;
        paramInt += 1;
      }
      AppMethodBeat.o(204113);
      return;
    }
    paramInt = paramArrayOfInt1.length - 1;
    if (paramInt >= 0) {
      f2 = f1;
    }
    for (;;)
    {
      i = paramInt - 1;
      j = paramArrayOfInt1[paramInt];
      paramArrayOfInt2[paramInt] = kotlin.h.a.eH(f2);
      f2 += j + f1;
      if (i < 0)
      {
        AppMethodBeat.o(204113);
        return;
      }
      paramInt = i;
    }
  }
  
  public static void d(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(204119);
    s.u(paramArrayOfInt1, "size");
    s.u(paramArrayOfInt2, "outPosition");
    int k = paramArrayOfInt1.length;
    int i = 0;
    int j = 0;
    while (i < k)
    {
      j += paramArrayOfInt1[i];
      i += 1;
    }
    float f1;
    if (paramArrayOfInt1.length > 1) {
      f1 = (paramInt - j) / (paramArrayOfInt1.length - 1);
    }
    float f2;
    while (!paramBoolean)
    {
      j = paramArrayOfInt1.length;
      i = 0;
      paramInt = 0;
      f2 = 0.0F;
      for (;;)
      {
        if (paramInt < j)
        {
          k = paramArrayOfInt1[paramInt];
          paramArrayOfInt2[i] = kotlin.h.a.eH(f2);
          f2 += k + f1;
          i += 1;
          paramInt += 1;
          continue;
          f1 = 0.0F;
          break;
        }
      }
      AppMethodBeat.o(204119);
      return;
    }
    paramInt = paramArrayOfInt1.length - 1;
    if (paramInt >= 0) {
      f2 = 0.0F;
    }
    for (;;)
    {
      i = paramInt - 1;
      j = paramArrayOfInt1[paramInt];
      paramArrayOfInt2[paramInt] = kotlin.h.a.eH(f2);
      f2 += j + f1;
      if (i < 0)
      {
        AppMethodBeat.o(204119);
        return;
      }
      paramInt = i;
    }
  }
  
  public static void e(int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2, boolean paramBoolean)
  {
    int k = 1;
    AppMethodBeat.i(204125);
    s.u(paramArrayOfInt1, "size");
    s.u(paramArrayOfInt2, "outPosition");
    int m = paramArrayOfInt1.length;
    int j = 0;
    int i = 0;
    while (j < m)
    {
      i += paramArrayOfInt1[j];
      j += 1;
    }
    if (paramArrayOfInt1.length == 0)
    {
      j = 1;
      if (j != 0) {
        break label158;
      }
      j = k;
      label72:
      if (j == 0) {
        break label164;
      }
    }
    float f2;
    label158:
    label164:
    for (float f1 = (paramInt - i) / paramArrayOfInt1.length;; f1 = 0.0F)
    {
      f2 = f1 / 2.0F;
      if (paramBoolean) {
        break label176;
      }
      j = paramArrayOfInt1.length;
      paramInt = 0;
      i = 0;
      while (i < j)
      {
        k = paramArrayOfInt1[i];
        paramArrayOfInt2[paramInt] = kotlin.h.a.eH(f2);
        f2 += k + f1;
        i += 1;
        paramInt += 1;
      }
      j = 0;
      break;
      j = 0;
      break label72;
    }
    AppMethodBeat.o(204125);
    return;
    label176:
    paramInt = paramArrayOfInt1.length - 1;
    if (paramInt >= 0) {}
    for (;;)
    {
      i = paramInt - 1;
      j = paramArrayOfInt1[paramInt];
      paramArrayOfInt2[paramInt] = kotlin.h.a.eH(f2);
      f2 += j + f1;
      if (i < 0)
      {
        AppMethodBeat.o(204125);
        return;
      }
      paramInt = i;
    }
  }
  
  public static d mt()
  {
    return abO;
  }
  
  public static d mu()
  {
    return abP;
  }
  
  public static l mw()
  {
    return abQ;
  }
  
  public static l mx()
  {
    return abR;
  }
  
  public static e my()
  {
    return abS;
  }
  
  public static e mz()
  {
    return abU;
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/foundation/layout/Arrangement$Bottom$1", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "toString", "", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "outPositions", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements a.l
  {
    public final void a(d paramd, int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      AppMethodBeat.i(203878);
      s.u(paramd, "<this>");
      s.u(paramArrayOfInt1, "sizes");
      s.u(paramArrayOfInt2, "outPositions");
      paramd = a.abN;
      a.a(paramInt, paramArrayOfInt1, paramArrayOfInt2, false);
      AppMethodBeat.o(203878);
    }
    
    public final float mA()
    {
      AppMethodBeat.i(203884);
      float f = a.l.a.a(this);
      AppMethodBeat.o(203884);
      return f;
    }
    
    public final String toString()
    {
      return "Arrangement#Bottom";
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/foundation/layout/Arrangement$Center$1", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "F", "toString", "", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outPositions", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements a.e
  {
    private final float abW;
    
    b()
    {
      AppMethodBeat.i(203881);
      this.abW = g.ai(0.0F);
      AppMethodBeat.o(203881);
    }
    
    public final void a(d paramd, int paramInt, int[] paramArrayOfInt1, n paramn, int[] paramArrayOfInt2)
    {
      AppMethodBeat.i(203888);
      s.u(paramd, "<this>");
      s.u(paramArrayOfInt1, "sizes");
      s.u(paramn, "layoutDirection");
      s.u(paramArrayOfInt2, "outPositions");
      if (paramn == n.beP)
      {
        paramd = a.abN;
        a.b(paramInt, paramArrayOfInt1, paramArrayOfInt2, false);
        AppMethodBeat.o(203888);
        return;
      }
      paramd = a.abN;
      a.b(paramInt, paramArrayOfInt1, paramArrayOfInt2, true);
      AppMethodBeat.o(203888);
    }
    
    public final void a(d paramd, int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      AppMethodBeat.i(203896);
      s.u(paramd, "<this>");
      s.u(paramArrayOfInt1, "sizes");
      s.u(paramArrayOfInt2, "outPositions");
      paramd = a.abN;
      a.b(paramInt, paramArrayOfInt1, paramArrayOfInt2, false);
      AppMethodBeat.o(203896);
    }
    
    public final float mA()
    {
      return this.abW;
    }
    
    public final String toString()
    {
      return "Arrangement#Center";
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/foundation/layout/Arrangement$End$1", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "toString", "", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outPositions", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements a.d
  {
    public final void a(d paramd, int paramInt, int[] paramArrayOfInt1, n paramn, int[] paramArrayOfInt2)
    {
      AppMethodBeat.i(203890);
      s.u(paramd, "<this>");
      s.u(paramArrayOfInt1, "sizes");
      s.u(paramn, "layoutDirection");
      s.u(paramArrayOfInt2, "outPositions");
      if (paramn == n.beP)
      {
        paramd = a.abN;
        a.a(paramInt, paramArrayOfInt1, paramArrayOfInt2, false);
        AppMethodBeat.o(203890);
        return;
      }
      paramd = a.abN;
      a.a(paramArrayOfInt1, paramArrayOfInt2, true);
      AppMethodBeat.o(203890);
    }
    
    public final float mA()
    {
      AppMethodBeat.i(203901);
      float f = a.d.a.a(this);
      AppMethodBeat.o(203901);
      return f;
    }
    
    public final String toString()
    {
      return "Arrangement#End";
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outPositions", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface d
  {
    public abstract void a(d paramd, int paramInt, int[] paramArrayOfInt1, n paramn, int[] paramArrayOfInt2);
    
    public abstract float mA();
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      public static float a(a.d paramd)
      {
        AppMethodBeat.i(203831);
        s.u(paramd, "this");
        float f = g.ai(0.0F);
        AppMethodBeat.o(203831);
        return f;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface e
    extends a.d, a.l
  {}
  
  @Metadata(d1={""}, d2={"androidx/compose/foundation/layout/Arrangement$SpaceAround$1", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "F", "toString", "", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outPositions", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class f
    implements a.e
  {
    private final float abW;
    
    f()
    {
      AppMethodBeat.i(203886);
      this.abW = g.ai(0.0F);
      AppMethodBeat.o(203886);
    }
    
    public final void a(d paramd, int paramInt, int[] paramArrayOfInt1, n paramn, int[] paramArrayOfInt2)
    {
      AppMethodBeat.i(203897);
      s.u(paramd, "<this>");
      s.u(paramArrayOfInt1, "sizes");
      s.u(paramn, "layoutDirection");
      s.u(paramArrayOfInt2, "outPositions");
      if (paramn == n.beP)
      {
        paramd = a.abN;
        a.e(paramInt, paramArrayOfInt1, paramArrayOfInt2, false);
        AppMethodBeat.o(203897);
        return;
      }
      paramd = a.abN;
      a.e(paramInt, paramArrayOfInt1, paramArrayOfInt2, true);
      AppMethodBeat.o(203897);
    }
    
    public final void a(d paramd, int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      AppMethodBeat.i(203902);
      s.u(paramd, "<this>");
      s.u(paramArrayOfInt1, "sizes");
      s.u(paramArrayOfInt2, "outPositions");
      paramd = a.abN;
      a.e(paramInt, paramArrayOfInt1, paramArrayOfInt2, false);
      AppMethodBeat.o(203902);
    }
    
    public final float mA()
    {
      return this.abW;
    }
    
    public final String toString()
    {
      return "Arrangement#SpaceAround";
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/foundation/layout/Arrangement$SpaceBetween$1", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "F", "toString", "", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outPositions", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class g
    implements a.e
  {
    private final float abW;
    
    g()
    {
      AppMethodBeat.i(203871);
      this.abW = g.ai(0.0F);
      AppMethodBeat.o(203871);
    }
    
    public final void a(d paramd, int paramInt, int[] paramArrayOfInt1, n paramn, int[] paramArrayOfInt2)
    {
      AppMethodBeat.i(203883);
      s.u(paramd, "<this>");
      s.u(paramArrayOfInt1, "sizes");
      s.u(paramn, "layoutDirection");
      s.u(paramArrayOfInt2, "outPositions");
      if (paramn == n.beP)
      {
        paramd = a.abN;
        a.d(paramInt, paramArrayOfInt1, paramArrayOfInt2, false);
        AppMethodBeat.o(203883);
        return;
      }
      paramd = a.abN;
      a.d(paramInt, paramArrayOfInt1, paramArrayOfInt2, true);
      AppMethodBeat.o(203883);
    }
    
    public final void a(d paramd, int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      AppMethodBeat.i(203895);
      s.u(paramd, "<this>");
      s.u(paramArrayOfInt1, "sizes");
      s.u(paramArrayOfInt2, "outPositions");
      paramd = a.abN;
      a.d(paramInt, paramArrayOfInt1, paramArrayOfInt2, false);
      AppMethodBeat.o(203895);
    }
    
    public final float mA()
    {
      return this.abW;
    }
    
    public final String toString()
    {
      return "Arrangement#SpaceBetween";
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/foundation/layout/Arrangement$SpaceEvenly$1", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "F", "toString", "", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outPositions", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class h
    implements a.e
  {
    private final float abW;
    
    h()
    {
      AppMethodBeat.i(203859);
      this.abW = g.ai(0.0F);
      AppMethodBeat.o(203859);
    }
    
    public final void a(d paramd, int paramInt, int[] paramArrayOfInt1, n paramn, int[] paramArrayOfInt2)
    {
      AppMethodBeat.i(203872);
      s.u(paramd, "<this>");
      s.u(paramArrayOfInt1, "sizes");
      s.u(paramn, "layoutDirection");
      s.u(paramArrayOfInt2, "outPositions");
      if (paramn == n.beP)
      {
        paramd = a.abN;
        a.c(paramInt, paramArrayOfInt1, paramArrayOfInt2, false);
        AppMethodBeat.o(203872);
        return;
      }
      paramd = a.abN;
      a.c(paramInt, paramArrayOfInt1, paramArrayOfInt2, true);
      AppMethodBeat.o(203872);
    }
    
    public final void a(d paramd, int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      AppMethodBeat.i(203875);
      s.u(paramd, "<this>");
      s.u(paramArrayOfInt1, "sizes");
      s.u(paramArrayOfInt2, "outPositions");
      paramd = a.abN;
      a.c(paramInt, paramArrayOfInt1, paramArrayOfInt2, false);
      AppMethodBeat.o(203875);
    }
    
    public final float mA()
    {
      return this.abW;
    }
    
    public final String toString()
    {
      return "Arrangement#SpaceEvenly";
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/foundation/layout/Arrangement$SpacedAligned;", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "space", "Landroidx/compose/ui/unit/Dp;", "rtlMirror", "", "alignment", "Lkotlin/Function2;", "", "Landroidx/compose/ui/unit/LayoutDirection;", "(FZLkotlin/jvm/functions/Function2;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "getAlignment", "()Lkotlin/jvm/functions/Function2;", "getRtlMirror", "()Z", "getSpace-D9Ej5fM", "()F", "F", "spacing", "getSpacing-D9Ej5fM", "component1", "component1-D9Ej5fM", "component2", "component3", "copy", "copy-8Feqmps", "(FZLkotlin/jvm/functions/Function2;)Landroidx/compose/foundation/layout/Arrangement$SpacedAligned;", "equals", "other", "", "hashCode", "toString", "", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "sizes", "", "layoutDirection", "outPositions", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class i
    implements a.e
  {
    private final float abW;
    private final float abX;
    private final boolean abY;
    private final m<Integer, n, Integer> abZ;
    
    private i(float paramFloat, boolean paramBoolean, m<? super Integer, ? super n, Integer> paramm)
    {
      AppMethodBeat.i(203862);
      this.abX = paramFloat;
      this.abY = paramBoolean;
      this.abZ = paramm;
      this.abW = this.abX;
      AppMethodBeat.o(203862);
    }
    
    public final void a(d paramd, int paramInt, int[] paramArrayOfInt1, n paramn, int[] paramArrayOfInt2)
    {
      int j = 1;
      int i1 = 0;
      AppMethodBeat.i(203889);
      s.u(paramd, "<this>");
      s.u(paramArrayOfInt1, "sizes");
      s.u(paramn, "layoutDirection");
      s.u(paramArrayOfInt2, "outPositions");
      if (paramArrayOfInt1.length == 0) {}
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(203889);
        return;
      }
      int i2 = paramd.v(this.abX);
      if ((this.abY) && (paramn == n.beQ)) {}
      int n;
      int m;
      int k;
      for (i = j;; i = 0)
      {
        paramd = a.abN;
        if (i != 0) {
          break;
        }
        int i3 = paramArrayOfInt1.length;
        n = 0;
        m = 0;
        j = 0;
        i = 0;
        for (;;)
        {
          k = i;
          if (n >= i3) {
            break;
          }
          k = paramArrayOfInt1[n];
          paramArrayOfInt2[m] = Math.min(i, paramInt - k);
          j = Math.min(i2, paramInt - paramArrayOfInt2[m] - k);
          i = paramArrayOfInt2[m] + k + j;
          n += 1;
          m += 1;
        }
      }
      i = paramArrayOfInt1.length - 1;
      if (i >= 0)
      {
        k = 0;
        j = i - 1;
        n = paramArrayOfInt1[i];
        paramArrayOfInt2[i] = Math.min(k, paramInt - n);
        m = Math.min(i2, paramInt - paramArrayOfInt2[i] - n);
        k = paramArrayOfInt2[i] + n + m;
        if (j < 0) {
          j = m;
        }
      }
      for (;;)
      {
        i = k - j;
        if ((this.abZ != null) && (i < paramInt))
        {
          j = ((Number)this.abZ.invoke(Integer.valueOf(paramInt - i), paramn)).intValue();
          k = paramArrayOfInt2.length - 1;
          if (k < 0) {}
        }
        for (paramInt = i1;; paramInt = i)
        {
          i = paramInt + 1;
          paramArrayOfInt2[paramInt] += j;
          if (i > k)
          {
            AppMethodBeat.o(203889);
            return;
          }
        }
        i = j;
        break;
        j = 0;
        k = 0;
      }
    }
    
    public final void a(d paramd, int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      AppMethodBeat.i(203898);
      s.u(paramd, "<this>");
      s.u(paramArrayOfInt1, "sizes");
      s.u(paramArrayOfInt2, "outPositions");
      a(paramd, paramInt, paramArrayOfInt1, n.beP, paramArrayOfInt2);
      AppMethodBeat.o(203898);
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(203918);
      if (this == paramObject)
      {
        AppMethodBeat.o(203918);
        return true;
      }
      if (!(paramObject instanceof i))
      {
        AppMethodBeat.o(203918);
        return false;
      }
      paramObject = (i)paramObject;
      if (!g.G(this.abX, paramObject.abX))
      {
        AppMethodBeat.o(203918);
        return false;
      }
      if (this.abY != paramObject.abY)
      {
        AppMethodBeat.o(203918);
        return false;
      }
      if (!s.p(this.abZ, paramObject.abZ))
      {
        AppMethodBeat.o(203918);
        return false;
      }
      AppMethodBeat.o(203918);
      return true;
    }
    
    public final int hashCode()
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public final float mA()
    {
      return this.abW;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(203906);
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.abY) {}
      for (String str = "";; str = "Absolute")
      {
        str = str + "Arrangement#spacedAligned(" + g.ak(this.abX) + ", " + this.abZ + ')';
        AppMethodBeat.o(203906);
        return str;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/foundation/layout/Arrangement$Start$1", "Landroidx/compose/foundation/layout/Arrangement$Horizontal;", "toString", "", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outPositions", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class j
    implements a.d
  {
    public final void a(d paramd, int paramInt, int[] paramArrayOfInt1, n paramn, int[] paramArrayOfInt2)
    {
      AppMethodBeat.i(203879);
      s.u(paramd, "<this>");
      s.u(paramArrayOfInt1, "sizes");
      s.u(paramn, "layoutDirection");
      s.u(paramArrayOfInt2, "outPositions");
      if (paramn == n.beP)
      {
        paramd = a.abN;
        a.a(paramArrayOfInt1, paramArrayOfInt2, false);
        AppMethodBeat.o(203879);
        return;
      }
      paramd = a.abN;
      a.a(paramInt, paramArrayOfInt1, paramArrayOfInt2, true);
      AppMethodBeat.o(203879);
    }
    
    public final float mA()
    {
      AppMethodBeat.i(203894);
      float f = a.d.a.a(this);
      AppMethodBeat.o(203894);
      return f;
    }
    
    public final String toString()
    {
      return "Arrangement#Start";
    }
  }
  
  @Metadata(d1={""}, d2={"androidx/compose/foundation/layout/Arrangement$Top$1", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "toString", "", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "outPositions", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class k
    implements a.l
  {
    public final void a(d paramd, int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2)
    {
      AppMethodBeat.i(203870);
      s.u(paramd, "<this>");
      s.u(paramArrayOfInt1, "sizes");
      s.u(paramArrayOfInt2, "outPositions");
      paramd = a.abN;
      a.a(paramArrayOfInt1, paramArrayOfInt2, false);
      AppMethodBeat.o(203870);
    }
    
    public final float mA()
    {
      AppMethodBeat.i(203880);
      float f = a.l.a.a(this);
      AppMethodBeat.o(203880);
      return f;
    }
    
    public final String toString()
    {
      return "Arrangement#Top";
    }
  }
  
  @Metadata(d1={""}, d2={"Landroidx/compose/foundation/layout/Arrangement$Vertical;", "", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "outPositions", "foundation-layout_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface l
  {
    public abstract void a(d paramd, int paramInt, int[] paramArrayOfInt1, int[] paramArrayOfInt2);
    
    public abstract float mA();
    
    @Metadata(k=3, mv={1, 5, 1}, xi=48)
    public static final class a
    {
      public static float a(a.l paraml)
      {
        AppMethodBeat.i(203793);
        s.u(paraml, "this");
        float f = g.ai(0.0F);
        AppMethodBeat.o(203793);
        return f;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "size", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class m
    extends u
    implements m<Integer, n, Integer>
  {
    m(androidx.compose.ui.a.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "size", "<anonymous parameter 1>", "Landroidx/compose/ui/unit/LayoutDirection;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class n
    extends u
    implements m<Integer, n, Integer>
  {
    n(androidx.compose.ui.a.c paramc)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.c.a
 * JD-Core Version:    0.7.0.1
 */
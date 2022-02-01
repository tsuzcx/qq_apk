package androidx.compose.ui.platform;

import android.graphics.Outline;
import android.os.Build.VERSION;
import androidx.compose.ui.d.e;
import androidx.compose.ui.d.g;
import androidx.compose.ui.d.i;
import androidx.compose.ui.d.k;
import androidx.compose.ui.e.ak;
import androidx.compose.ui.e.ak.a;
import androidx.compose.ui.e.ak.b;
import androidx.compose.ui.e.ak.c;
import androidx.compose.ui.e.ao;
import androidx.compose.ui.e.as;
import androidx.compose.ui.e.au;
import androidx.compose.ui.e.ay;
import androidx.compose.ui.e.m;
import androidx.compose.ui.n.d;
import androidx.compose.ui.n.n;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.p;

@Metadata(d1={""}, d2={"Landroidx/compose/ui/platform/OutlineResolver;", "", "density", "Landroidx/compose/ui/unit/Density;", "(Landroidx/compose/ui/unit/Density;)V", "cacheIsDirty", "", "cachedOutline", "Landroid/graphics/Outline;", "cachedRrectPath", "Landroidx/compose/ui/graphics/Path;", "calculatedOutline", "Landroidx/compose/ui/graphics/Outline;", "clipPath", "getClipPath", "()Landroidx/compose/ui/graphics/Path;", "isSupportedOutline", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outline", "getOutline", "()Landroid/graphics/Outline;", "outlineNeeded", "outlinePath", "shape", "Landroidx/compose/ui/graphics/Shape;", "size", "Landroidx/compose/ui/geometry/Size;", "J", "tmpOpPath", "tmpOpPath$1", "tmpTouchPointPath", "tmpTouchPointPath$1", "usePathForClip", "isInOutline", "position", "Landroidx/compose/ui/geometry/Offset;", "isInOutline-k-4lQ0M", "(J)Z", "update", "", "update-uvyYCjk", "(J)V", "alpha", "", "clipToOutline", "elevation", "updateCache", "updateCacheWithPath", "composePath", "updateCacheWithRect", "rect", "Landroidx/compose/ui/geometry/Rect;", "updateCacheWithRoundRect", "roundRect", "Landroidx/compose/ui/geometry/RoundRect;", "Companion", "ui_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ag
{
  private static final ao aUE;
  private static final ao aUF;
  public static final ag.a aUt;
  private d TD;
  private ay XK;
  private boolean aUA;
  private ao aUB;
  private ao aUC;
  private ak aUD;
  private boolean aUu;
  private final Outline aUv;
  private ao aUw;
  private ao aUx;
  private boolean aUy;
  private boolean aUz;
  private n agm;
  private long size;
  
  static
  {
    AppMethodBeat.i(206795);
    aUt = new ag.a((byte)0);
    aUE = m.sQ();
    aUF = m.sQ();
    AppMethodBeat.o(206795);
  }
  
  public ag(d paramd)
  {
    AppMethodBeat.i(206758);
    this.TD = paramd;
    this.aUu = true;
    paramd = new Outline();
    paramd.setAlpha(1.0F);
    ah localah = ah.aiuX;
    this.aUv = paramd;
    paramd = k.avA;
    this.size = k.su();
    this.XK = au.tM();
    this.agm = n.beP;
    AppMethodBeat.o(206758);
  }
  
  private final void d(ao paramao)
  {
    AppMethodBeat.i(206787);
    boolean bool;
    if ((Build.VERSION.SDK_INT > 28) || (paramao.sO()))
    {
      Outline localOutline = this.aUv;
      if ((paramao instanceof androidx.compose.ui.e.j))
      {
        localOutline.setConvexPath(((androidx.compose.ui.e.j)paramao).avN);
        if (this.aUv.canClip()) {
          break label90;
        }
        bool = true;
      }
    }
    for (this.aUz = bool;; this.aUz = true)
    {
      this.aUx = paramao;
      AppMethodBeat.o(206787);
      return;
      paramao = new UnsupportedOperationException("Unable to obtain android.graphics.Path");
      AppMethodBeat.o(206787);
      throw paramao;
      label90:
      bool = false;
      break;
      this.aUu = false;
      this.aUv.setEmpty();
    }
  }
  
  private final void e(i parami)
  {
    AppMethodBeat.i(206777);
    float f = androidx.compose.ui.d.a.F(parami.avv);
    if (androidx.compose.ui.d.j.a(parami))
    {
      this.aUv.setRoundRect(kotlin.h.a.eH(parami.left), kotlin.h.a.eH(parami.top), kotlin.h.a.eH(parami.right), kotlin.h.a.eH(parami.bottom), f);
      AppMethodBeat.o(206777);
      return;
    }
    ao localao2 = this.aUw;
    ao localao1 = localao2;
    if (localao2 == null)
    {
      localao1 = m.sQ();
      this.aUw = localao1;
    }
    localao1.reset();
    localao1.b(parami);
    d(localao1);
    AppMethodBeat.o(206777);
  }
  
  private final void g(g paramg)
  {
    AppMethodBeat.i(206770);
    this.aUv.setRect(kotlin.h.a.eH(paramg.left), kotlin.h.a.eH(paramg.top), kotlin.h.a.eH(paramg.right), kotlin.h.a.eH(paramg.bottom));
    AppMethodBeat.o(206770);
  }
  
  private final void zm()
  {
    AppMethodBeat.i(206764);
    if (this.aUy)
    {
      this.aUy = false;
      this.aUz = false;
      if ((this.aUA) && (k.Q(this.size) > 0.0F) && (k.R(this.size) > 0.0F))
      {
        this.aUu = true;
        ak localak = this.XK.a(this.size, this.agm, this.TD);
        this.aUD = localak;
        if ((localak instanceof ak.b))
        {
          g(((ak.b)localak).axL);
          AppMethodBeat.o(206764);
          return;
        }
        if ((localak instanceof ak.c))
        {
          e(((ak.c)localak).axM);
          AppMethodBeat.o(206764);
          return;
        }
        if ((localak instanceof ak.a))
        {
          AppMethodBeat.o(206764);
          throw null;
        }
      }
      else
      {
        this.aUv.setEmpty();
      }
    }
    AppMethodBeat.o(206764);
  }
  
  public final boolean a(ay paramay, float paramFloat1, boolean paramBoolean, float paramFloat2, n paramn, d paramd)
  {
    boolean bool2 = false;
    AppMethodBeat.i(206819);
    s.u(paramay, "shape");
    s.u(paramn, "layoutDirection");
    s.u(paramd, "density");
    this.aUv.setAlpha(paramFloat1);
    if (!s.p(this.XK, paramay)) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      if (bool1)
      {
        this.XK = paramay;
        this.aUy = true;
      }
      if (!paramBoolean)
      {
        paramBoolean = bool2;
        if (paramFloat2 <= 0.0F) {}
      }
      else
      {
        paramBoolean = true;
      }
      if (this.aUA != paramBoolean)
      {
        this.aUA = paramBoolean;
        this.aUy = true;
      }
      if (this.agm != paramn)
      {
        this.agm = paramn;
        this.aUy = true;
      }
      if (!s.p(this.TD, paramd))
      {
        this.TD = paramd;
        this.aUy = true;
      }
      AppMethodBeat.o(206819);
      return bool1;
    }
  }
  
  public final boolean aK(long paramLong)
  {
    AppMethodBeat.i(206837);
    if (!this.aUA)
    {
      AppMethodBeat.o(206837);
      return true;
    }
    Object localObject2 = this.aUD;
    if (localObject2 == null)
    {
      AppMethodBeat.o(206837);
      return true;
    }
    float f1 = e.F(paramLong);
    float f2 = e.G(paramLong);
    ao localao = this.aUB;
    Object localObject1 = this.aUC;
    s.u(localObject2, "outline");
    if ((localObject2 instanceof ak.b))
    {
      localObject1 = ((ak.b)localObject2).axL;
      if ((((g)localObject1).left <= f1) && (f1 < ((g)localObject1).right) && (((g)localObject1).top <= f2) && (f2 < ((g)localObject1).bottom))
      {
        AppMethodBeat.o(206837);
        return true;
      }
      AppMethodBeat.o(206837);
      return false;
    }
    if ((localObject2 instanceof ak.c))
    {
      Object localObject3 = ((ak.c)localObject2).axM;
      if ((f1 < ((i)localObject3).left) || (f1 >= ((i)localObject3).right) || (f2 < ((i)localObject3).top) || (f2 >= ((i)localObject3).bottom))
      {
        AppMethodBeat.o(206837);
        return false;
      }
      int i;
      if ((androidx.compose.ui.d.a.F(((i)localObject3).avv) + androidx.compose.ui.d.a.F(((i)localObject3).avw) <= ((i)localObject3).getWidth()) && (androidx.compose.ui.d.a.F(((i)localObject3).avy) + androidx.compose.ui.d.a.F(((i)localObject3).avx) <= ((i)localObject3).getWidth()) && (androidx.compose.ui.d.a.G(((i)localObject3).avv) + androidx.compose.ui.d.a.G(((i)localObject3).avy) <= ((i)localObject3).getHeight()) && (androidx.compose.ui.d.a.G(((i)localObject3).avw) + androidx.compose.ui.d.a.G(((i)localObject3).avx) <= ((i)localObject3).getHeight()))
      {
        i = 1;
        if (i != 0) {
          break label490;
        }
        if (localObject1 != null) {
          break label472;
        }
        localObject2 = m.sQ();
        label337:
        ((ao)localObject2).b((i)localObject3);
        localObject3 = new g(f1 - 0.005F, f2 - 0.005F, f1 + 0.005F, f2 + 0.005F);
        if (localao != null) {
          break label479;
        }
        localao = m.sQ();
      }
      boolean bool;
      label472:
      label479:
      for (;;)
      {
        localao.c((g)localObject3);
        localObject3 = localObject1;
        if (localObject1 == null) {
          localObject3 = m.sQ();
        }
        localObject1 = as.axY;
        ((ao)localObject3).a((ao)localObject2, localao, as.tu());
        bool = ((ao)localObject3).isEmpty();
        ((ao)localObject3).reset();
        localao.reset();
        if (bool) {
          break label482;
        }
        AppMethodBeat.o(206837);
        return true;
        i = 0;
        break;
        localObject2 = localObject1;
        break label337;
      }
      label482:
      AppMethodBeat.o(206837);
      return false;
      label490:
      float f3 = ((i)localObject3).left + androidx.compose.ui.d.a.F(((i)localObject3).avv);
      float f4 = ((i)localObject3).top + androidx.compose.ui.d.a.G(((i)localObject3).avv);
      float f5 = ((i)localObject3).right - androidx.compose.ui.d.a.F(((i)localObject3).avw);
      float f6 = ((i)localObject3).top + androidx.compose.ui.d.a.G(((i)localObject3).avw);
      float f7 = ((i)localObject3).right - androidx.compose.ui.d.a.F(((i)localObject3).avx);
      float f8 = ((i)localObject3).bottom - androidx.compose.ui.d.a.G(((i)localObject3).avx);
      float f9 = ((i)localObject3).bottom - androidx.compose.ui.d.a.G(((i)localObject3).avy);
      float f10 = ((i)localObject3).left + androidx.compose.ui.d.a.F(((i)localObject3).avy);
      if ((f1 < f3) && (f2 < f4))
      {
        bool = an.a(f1, f2, ((i)localObject3).avv, f3, f4);
        AppMethodBeat.o(206837);
        return bool;
      }
      if ((f1 < f10) && (f2 > f9))
      {
        bool = an.a(f1, f2, ((i)localObject3).avy, f10, f9);
        AppMethodBeat.o(206837);
        return bool;
      }
      if ((f1 > f5) && (f2 < f6))
      {
        bool = an.a(f1, f2, ((i)localObject3).avw, f5, f6);
        AppMethodBeat.o(206837);
        return bool;
      }
      if ((f1 > f7) && (f2 > f8))
      {
        bool = an.a(f1, f2, ((i)localObject3).avx, f7, f8);
        AppMethodBeat.o(206837);
        return bool;
      }
      AppMethodBeat.o(206837);
      return true;
    }
    if ((localObject2 instanceof ak.a))
    {
      AppMethodBeat.o(206837);
      throw null;
    }
    localObject1 = new p();
    AppMethodBeat.o(206837);
    throw ((Throwable)localObject1);
  }
  
  public final void aL(long paramLong)
  {
    AppMethodBeat.i(206845);
    if (!k.e(this.size, paramLong))
    {
      this.size = paramLong;
      this.aUy = true;
    }
    AppMethodBeat.o(206845);
  }
  
  public final Outline zk()
  {
    AppMethodBeat.i(206800);
    zm();
    if ((!this.aUA) || (!this.aUu))
    {
      AppMethodBeat.o(206800);
      return null;
    }
    Outline localOutline = this.aUv;
    AppMethodBeat.o(206800);
    return localOutline;
  }
  
  public final ao zl()
  {
    AppMethodBeat.i(206810);
    zm();
    if (this.aUz)
    {
      ao localao = this.aUx;
      AppMethodBeat.o(206810);
      return localao;
    }
    AppMethodBeat.o(206810);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.ui.platform.ag
 * JD-Core Version:    0.7.0.1
 */
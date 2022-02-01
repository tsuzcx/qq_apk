package androidx.core.g;

import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.DisplayCutout;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsets.Builder;
import android.view.WindowInsets.Type;
import androidx.core.f.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Objects;

public class ah
{
  public static final ah bug = g.bug;
  final g buh;
  
  static
  {
    if (Build.VERSION.SDK_INT >= 30)
    {
      bug = l.bug;
      return;
    }
  }
  
  public ah()
  {
    AppMethodBeat.i(195698);
    this.buh = new g(this);
    AppMethodBeat.o(195698);
  }
  
  private ah(WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(195693);
    if (Build.VERSION.SDK_INT >= 30)
    {
      this.buh = new l(this, paramWindowInsets);
      AppMethodBeat.o(195693);
      return;
    }
    if (Build.VERSION.SDK_INT >= 29)
    {
      this.buh = new k(this, paramWindowInsets);
      AppMethodBeat.o(195693);
      return;
    }
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.buh = new j(this, paramWindowInsets);
      AppMethodBeat.o(195693);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.buh = new i(this, paramWindowInsets);
      AppMethodBeat.o(195693);
      return;
    }
    if (Build.VERSION.SDK_INT >= 20)
    {
      this.buh = new h(this, paramWindowInsets);
      AppMethodBeat.o(195693);
      return;
    }
    this.buh = new g(this);
    AppMethodBeat.o(195693);
  }
  
  public static ah a(WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(195705);
    paramWindowInsets = b(paramWindowInsets, null);
    AppMethodBeat.o(195705);
    return paramWindowInsets;
  }
  
  public static ah b(WindowInsets paramWindowInsets, View paramView)
  {
    AppMethodBeat.i(195716);
    paramWindowInsets = new ah((WindowInsets)f.checkNotNull(paramWindowInsets));
    if ((paramView != null) && (paramView.isAttachedToWindow()))
    {
      paramWindowInsets.b(z.am(paramView));
      paramWindowInsets.aI(paramView.getRootView());
    }
    AppMethodBeat.o(195716);
    return paramWindowInsets;
  }
  
  @Deprecated
  public final int Em()
  {
    AppMethodBeat.i(195735);
    int i = this.buh.EB().left;
    AppMethodBeat.o(195735);
    return i;
  }
  
  @Deprecated
  public final int En()
  {
    AppMethodBeat.i(195745);
    int i = this.buh.EB().top;
    AppMethodBeat.o(195745);
    return i;
  }
  
  @Deprecated
  public final int Eo()
  {
    AppMethodBeat.i(195757);
    int i = this.buh.EB().right;
    AppMethodBeat.o(195757);
    return i;
  }
  
  @Deprecated
  public final int Ep()
  {
    AppMethodBeat.i(195766);
    int i = this.buh.EB().bottom;
    AppMethodBeat.o(195766);
    return i;
  }
  
  @Deprecated
  public final boolean Eq()
  {
    AppMethodBeat.i(195780);
    if (!this.buh.EB().equals(androidx.core.graphics.c.bqu))
    {
      AppMethodBeat.o(195780);
      return true;
    }
    AppMethodBeat.o(195780);
    return false;
  }
  
  public final boolean Er()
  {
    AppMethodBeat.i(195791);
    boolean bool = this.buh.Er();
    AppMethodBeat.o(195791);
    return bool;
  }
  
  @Deprecated
  public final ah Es()
  {
    AppMethodBeat.i(195802);
    ah localah = this.buh.Es();
    AppMethodBeat.o(195802);
    return localah;
  }
  
  public final WindowInsets Et()
  {
    if ((this.buh instanceof h)) {
      return ((h)this.buh).but;
    }
    return null;
  }
  
  final void a(androidx.core.graphics.c[] paramArrayOfc)
  {
    AppMethodBeat.i(195869);
    this.buh.a(paramArrayOfc);
    AppMethodBeat.o(195869);
  }
  
  final void aI(View paramView)
  {
    AppMethodBeat.i(195886);
    this.buh.aI(paramView);
    AppMethodBeat.o(195886);
  }
  
  final void b(ah paramah)
  {
    AppMethodBeat.i(195879);
    this.buh.b(paramah);
    AppMethodBeat.o(195879);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(195838);
    if (this == paramObject)
    {
      AppMethodBeat.o(195838);
      return true;
    }
    if (!(paramObject instanceof ah))
    {
      AppMethodBeat.o(195838);
      return false;
    }
    paramObject = (ah)paramObject;
    boolean bool = androidx.core.f.c.equals(this.buh, paramObject.buh);
    AppMethodBeat.o(195838);
    return bool;
  }
  
  public final androidx.core.graphics.c er(int paramInt)
  {
    AppMethodBeat.i(195826);
    androidx.core.graphics.c localc = this.buh.er(paramInt);
    AppMethodBeat.o(195826);
    return localc;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(195850);
    if (this.buh == null)
    {
      AppMethodBeat.o(195850);
      return 0;
    }
    int i = this.buh.hashCode();
    AppMethodBeat.o(195850);
    return i;
  }
  
  @Deprecated
  public final ah n(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(195813);
    ah localah = new b(this).a(androidx.core.graphics.c.m(paramInt1, paramInt2, paramInt3, paramInt4)).bum.Ev();
    AppMethodBeat.o(195813);
    return localah;
  }
  
  static final class a
  {
    private static Field bui;
    private static Field buj;
    private static Field buk;
    private static boolean bul;
    
    static
    {
      AppMethodBeat.i(195893);
      try
      {
        Object localObject = View.class.getDeclaredField("mAttachInfo");
        bui = (Field)localObject;
        ((Field)localObject).setAccessible(true);
        localObject = Class.forName("android.view.View$AttachInfo");
        Field localField = ((Class)localObject).getDeclaredField("mStableInsets");
        buj = localField;
        localField.setAccessible(true);
        localObject = ((Class)localObject).getDeclaredField("mContentInsets");
        buk = (Field)localObject;
        ((Field)localObject).setAccessible(true);
        bul = true;
        AppMethodBeat.o(195893);
        return;
      }
      catch (ReflectiveOperationException localReflectiveOperationException)
      {
        new StringBuilder("Failed to get visible insets from AttachInfo ").append(localReflectiveOperationException.getMessage());
        AppMethodBeat.o(195893);
      }
    }
    
    public static ah am(View paramView)
    {
      AppMethodBeat.i(195885);
      if ((!bul) || (!paramView.isAttachedToWindow()))
      {
        AppMethodBeat.o(195885);
        return null;
      }
      Object localObject1 = paramView.getRootView();
      try
      {
        Object localObject2 = bui.get(localObject1);
        if (localObject2 != null)
        {
          localObject1 = (Rect)buj.get(localObject2);
          localObject2 = (Rect)buk.get(localObject2);
          if ((localObject1 != null) && (localObject2 != null))
          {
            ah.b localb = new ah.b();
            localObject1 = androidx.core.graphics.c.i((Rect)localObject1);
            localb.bum.f((androidx.core.graphics.c)localObject1);
            localObject1 = localb.a(androidx.core.graphics.c.i((Rect)localObject2)).bum.Ev();
            ((ah)localObject1).b((ah)localObject1);
            ((ah)localObject1).aI(paramView.getRootView());
            AppMethodBeat.o(195885);
            return localObject1;
          }
        }
      }
      catch (IllegalAccessException paramView)
      {
        new StringBuilder("Failed to get insets from AttachInfo. ").append(paramView.getMessage());
        AppMethodBeat.o(195885);
      }
      return null;
    }
  }
  
  public static final class b
  {
    final ah.c bum;
    
    public b()
    {
      AppMethodBeat.i(195875);
      if (Build.VERSION.SDK_INT >= 30)
      {
        this.bum = new ah.f();
        AppMethodBeat.o(195875);
        return;
      }
      if (Build.VERSION.SDK_INT >= 29)
      {
        this.bum = new ah.e();
        AppMethodBeat.o(195875);
        return;
      }
      if (Build.VERSION.SDK_INT >= 20)
      {
        this.bum = new ah.d();
        AppMethodBeat.o(195875);
        return;
      }
      this.bum = new ah.c();
      AppMethodBeat.o(195875);
    }
    
    public b(ah paramah)
    {
      AppMethodBeat.i(195883);
      if (Build.VERSION.SDK_INT >= 30)
      {
        this.bum = new ah.f(paramah);
        AppMethodBeat.o(195883);
        return;
      }
      if (Build.VERSION.SDK_INT >= 29)
      {
        this.bum = new ah.e(paramah);
        AppMethodBeat.o(195883);
        return;
      }
      if (Build.VERSION.SDK_INT >= 20)
      {
        this.bum = new ah.d(paramah);
        AppMethodBeat.o(195883);
        return;
      }
      this.bum = new ah.c(paramah);
      AppMethodBeat.o(195883);
    }
    
    @Deprecated
    public final b a(androidx.core.graphics.c paramc)
    {
      AppMethodBeat.i(195892);
      this.bum.b(paramc);
      AppMethodBeat.o(195892);
      return this;
    }
  }
  
  static class c
  {
    private final ah bun;
    androidx.core.graphics.c[] buo;
    
    c()
    {
      this(new ah());
      AppMethodBeat.i(195861);
      AppMethodBeat.o(195861);
    }
    
    c(ah paramah)
    {
      this.bun = paramah;
    }
    
    protected final void Eu()
    {
      AppMethodBeat.i(195915);
      if (this.buo != null)
      {
        androidx.core.graphics.c localc3 = this.buo[ah.m.es(1)];
        androidx.core.graphics.c localc2 = this.buo[ah.m.es(2)];
        androidx.core.graphics.c localc1 = localc2;
        if (localc2 == null) {
          localc1 = this.bun.er(2);
        }
        localc2 = localc3;
        if (localc3 == null) {
          localc2 = this.bun.er(1);
        }
        b(androidx.core.graphics.c.a(localc2, localc1));
        localc1 = this.buo[ah.m.es(16)];
        if (localc1 != null) {
          c(localc1);
        }
        localc1 = this.buo[ah.m.es(32)];
        if (localc1 != null) {
          d(localc1);
        }
        localc1 = this.buo[ah.m.es(64)];
        if (localc1 != null) {
          e(localc1);
        }
      }
      AppMethodBeat.o(195915);
    }
    
    ah Ev()
    {
      AppMethodBeat.i(195924);
      Eu();
      ah localah = this.bun;
      AppMethodBeat.o(195924);
      return localah;
    }
    
    void b(androidx.core.graphics.c paramc) {}
    
    void c(androidx.core.graphics.c paramc) {}
    
    void d(androidx.core.graphics.c paramc) {}
    
    void e(androidx.core.graphics.c paramc) {}
    
    void f(androidx.core.graphics.c paramc) {}
  }
  
  static final class d
    extends ah.c
  {
    private static Field bup;
    private static boolean buq = false;
    private static Constructor<WindowInsets> bur;
    private static boolean bus = false;
    private WindowInsets but;
    private androidx.core.graphics.c buu;
    
    d()
    {
      AppMethodBeat.i(195864);
      this.but = Ew();
      AppMethodBeat.o(195864);
    }
    
    d(ah paramah)
    {
      super();
      AppMethodBeat.i(195880);
      this.but = paramah.Et();
      AppMethodBeat.o(195880);
    }
    
    private static WindowInsets Ew()
    {
      AppMethodBeat.i(195896);
      if (!buq) {}
      try
      {
        bup = WindowInsets.class.getDeclaredField("CONSUMED");
        label21:
        buq = true;
        if (bup != null) {
          try
          {
            WindowInsets localWindowInsets1 = (WindowInsets)bup.get(null);
            if (localWindowInsets1 != null)
            {
              localWindowInsets1 = new WindowInsets(localWindowInsets1);
              AppMethodBeat.o(195896);
              return localWindowInsets1;
            }
          }
          catch (ReflectiveOperationException localReflectiveOperationException1) {}
        }
        if (!bus) {}
        try
        {
          bur = WindowInsets.class.getConstructor(new Class[] { Rect.class });
          label86:
          bus = true;
          if (bur != null) {
            try
            {
              WindowInsets localWindowInsets2 = (WindowInsets)bur.newInstance(new Object[] { new Rect() });
              AppMethodBeat.o(195896);
              return localWindowInsets2;
            }
            catch (ReflectiveOperationException localReflectiveOperationException2) {}
          }
          AppMethodBeat.o(195896);
          return null;
        }
        catch (ReflectiveOperationException localReflectiveOperationException3)
        {
          break label86;
        }
      }
      catch (ReflectiveOperationException localReflectiveOperationException4)
      {
        break label21;
      }
    }
    
    final ah Ev()
    {
      AppMethodBeat.i(195945);
      Eu();
      ah localah = ah.a(this.but);
      localah.a(this.buo);
      androidx.core.graphics.c localc = this.buu;
      localah.buh.f(localc);
      AppMethodBeat.o(195945);
      return localah;
    }
    
    final void b(androidx.core.graphics.c paramc)
    {
      AppMethodBeat.i(195923);
      if (this.but != null) {
        this.but = this.but.replaceSystemWindowInsets(paramc.left, paramc.top, paramc.right, paramc.bottom);
      }
      AppMethodBeat.o(195923);
    }
    
    final void f(androidx.core.graphics.c paramc)
    {
      this.buu = paramc;
    }
  }
  
  static class e
    extends ah.c
  {
    final WindowInsets.Builder buv;
    
    e()
    {
      AppMethodBeat.i(195936);
      this.buv = new WindowInsets.Builder();
      AppMethodBeat.o(195936);
    }
    
    e(ah paramah)
    {
      super();
      AppMethodBeat.i(195947);
      paramah = paramah.Et();
      if (paramah != null) {}
      for (paramah = new WindowInsets.Builder(paramah);; paramah = new WindowInsets.Builder())
      {
        this.buv = paramah;
        AppMethodBeat.o(195947);
        return;
      }
    }
    
    ah Ev()
    {
      AppMethodBeat.i(196005);
      Eu();
      ah localah = ah.a(this.buv.build());
      localah.a(this.buo);
      AppMethodBeat.o(196005);
      return localah;
    }
    
    void b(androidx.core.graphics.c paramc)
    {
      AppMethodBeat.i(195956);
      this.buv.setSystemWindowInsets(paramc.DG());
      AppMethodBeat.o(195956);
    }
    
    void c(androidx.core.graphics.c paramc)
    {
      AppMethodBeat.i(195960);
      this.buv.setSystemGestureInsets(paramc.DG());
      AppMethodBeat.o(195960);
    }
    
    void d(androidx.core.graphics.c paramc)
    {
      AppMethodBeat.i(195972);
      this.buv.setMandatorySystemGestureInsets(paramc.DG());
      AppMethodBeat.o(195972);
    }
    
    void e(androidx.core.graphics.c paramc)
    {
      AppMethodBeat.i(195982);
      this.buv.setTappableElementInsets(paramc.DG());
      AppMethodBeat.o(195982);
    }
    
    void f(androidx.core.graphics.c paramc)
    {
      AppMethodBeat.i(195992);
      this.buv.setStableInsets(paramc.DG());
      AppMethodBeat.o(195992);
    }
  }
  
  static final class f
    extends ah.e
  {
    f() {}
    
    f(ah paramah)
    {
      super();
    }
  }
  
  static class g
  {
    static final ah bug;
    final ah buw;
    
    static
    {
      AppMethodBeat.i(195922);
      bug = new ah.b().bum.Ev().buh.EA().buh.Ey().buh.Es();
      AppMethodBeat.o(195922);
    }
    
    g(ah paramah)
    {
      this.buw = paramah;
    }
    
    ah EA()
    {
      return this.buw;
    }
    
    androidx.core.graphics.c EB()
    {
      return androidx.core.graphics.c.bqu;
    }
    
    androidx.core.graphics.c EC()
    {
      return androidx.core.graphics.c.bqu;
    }
    
    androidx.core.graphics.c ED()
    {
      AppMethodBeat.i(195984);
      androidx.core.graphics.c localc = EB();
      AppMethodBeat.o(195984);
      return localc;
    }
    
    androidx.core.graphics.c EE()
    {
      AppMethodBeat.i(195988);
      androidx.core.graphics.c localc = EB();
      AppMethodBeat.o(195988);
      return localc;
    }
    
    androidx.core.graphics.c EF()
    {
      AppMethodBeat.i(195993);
      androidx.core.graphics.c localc = EB();
      AppMethodBeat.o(195993);
      return localc;
    }
    
    boolean Er()
    {
      return false;
    }
    
    ah Es()
    {
      return this.buw;
    }
    
    boolean Ex()
    {
      return false;
    }
    
    ah Ey()
    {
      return this.buw;
    }
    
    c Ez()
    {
      return null;
    }
    
    public void a(androidx.core.graphics.c[] paramArrayOfc) {}
    
    void aI(View paramView) {}
    
    void b(ah paramah) {}
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(196012);
      if (this == paramObject)
      {
        AppMethodBeat.o(196012);
        return true;
      }
      if (!(paramObject instanceof g))
      {
        AppMethodBeat.o(196012);
        return false;
      }
      paramObject = (g)paramObject;
      if ((Ex() == paramObject.Ex()) && (Er() == paramObject.Er()) && (androidx.core.f.c.equals(EB(), paramObject.EB())) && (androidx.core.f.c.equals(EC(), paramObject.EC())) && (androidx.core.f.c.equals(Ez(), paramObject.Ez())))
      {
        AppMethodBeat.o(196012);
        return true;
      }
      AppMethodBeat.o(196012);
      return false;
    }
    
    androidx.core.graphics.c er(int paramInt)
    {
      return androidx.core.graphics.c.bqu;
    }
    
    public void f(androidx.core.graphics.c paramc) {}
    
    void g(androidx.core.graphics.c paramc) {}
    
    public int hashCode()
    {
      AppMethodBeat.i(196017);
      int i = androidx.core.f.c.hash(new Object[] { Boolean.valueOf(Ex()), Boolean.valueOf(Er()), EB(), EC(), Ez() });
      AppMethodBeat.o(196017);
      return i;
    }
  }
  
  static class h
    extends ah.g
  {
    private static Class<?> buA;
    private static Field buB;
    private static Field buC;
    private static boolean bux = false;
    private static Method buy;
    private static Class<?> buz;
    private androidx.core.graphics.c[] buD;
    private androidx.core.graphics.c buE = null;
    private ah buF;
    androidx.core.graphics.c buG;
    final WindowInsets but;
    
    h(ah paramah, WindowInsets paramWindowInsets)
    {
      super();
      this.but = paramWindowInsets;
    }
    
    private androidx.core.graphics.c EG()
    {
      AppMethodBeat.i(195935);
      if (this.buF != null)
      {
        localc = this.buF.buh.EC();
        AppMethodBeat.o(195935);
        return localc;
      }
      androidx.core.graphics.c localc = androidx.core.graphics.c.bqu;
      AppMethodBeat.o(195935);
      return localc;
    }
    
    private static void EH()
    {
      AppMethodBeat.i(195953);
      try
      {
        buy = View.class.getDeclaredMethod("getViewRootImpl", new Class[0]);
        buz = Class.forName("android.view.ViewRootImpl");
        Class localClass = Class.forName("android.view.View$AttachInfo");
        buA = localClass;
        buB = localClass.getDeclaredField("mVisibleInsets");
        buC = buz.getDeclaredField("mAttachInfo");
        buB.setAccessible(true);
        buC.setAccessible(true);
        bux = true;
        AppMethodBeat.o(195953);
        return;
      }
      catch (ReflectiveOperationException localReflectiveOperationException)
      {
        for (;;)
        {
          new StringBuilder("Failed to get visible insets. (Reflection error). ").append(localReflectiveOperationException.getMessage());
        }
      }
    }
    
    private androidx.core.graphics.c aJ(View paramView)
    {
      AppMethodBeat.i(195944);
      if (Build.VERSION.SDK_INT >= 30)
      {
        paramView = new UnsupportedOperationException("getVisibleInsets() should not be called on API >= 30. Use WindowInsets.isVisible() instead.");
        AppMethodBeat.o(195944);
        throw paramView;
      }
      if (!bux) {
        EH();
      }
      if ((buy == null) || (buA == null) || (buB == null))
      {
        AppMethodBeat.o(195944);
        return null;
      }
      try
      {
        paramView = buy.invoke(paramView, new Object[0]);
        if (paramView == null)
        {
          new NullPointerException();
          AppMethodBeat.o(195944);
          return null;
        }
        paramView = buC.get(paramView);
        paramView = (Rect)buB.get(paramView);
        if (paramView != null)
        {
          paramView = androidx.core.graphics.c.i(paramView);
          AppMethodBeat.o(195944);
          return paramView;
        }
      }
      catch (ReflectiveOperationException paramView)
      {
        new StringBuilder("Failed to get visible insets. (Reflection error). ").append(paramView.getMessage());
        AppMethodBeat.o(195944);
        return null;
      }
      AppMethodBeat.o(195944);
      return null;
    }
    
    private androidx.core.graphics.c r(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(195928);
      Object localObject1 = androidx.core.graphics.c.bqu;
      int i = 1;
      while (i <= 256)
      {
        Object localObject2 = localObject1;
        if ((paramInt & i) != 0) {
          localObject2 = androidx.core.graphics.c.a((androidx.core.graphics.c)localObject1, s(i, paramBoolean));
        }
        i <<= 1;
        localObject1 = localObject2;
      }
      AppMethodBeat.o(195928);
      return localObject1;
    }
    
    final androidx.core.graphics.c EB()
    {
      AppMethodBeat.i(195996);
      if (this.buE == null) {
        this.buE = androidx.core.graphics.c.m(this.but.getSystemWindowInsetLeft(), this.but.getSystemWindowInsetTop(), this.but.getSystemWindowInsetRight(), this.but.getSystemWindowInsetBottom());
      }
      androidx.core.graphics.c localc = this.buE;
      AppMethodBeat.o(195996);
      return localc;
    }
    
    boolean Ex()
    {
      AppMethodBeat.i(195964);
      boolean bool = this.but.isRound();
      AppMethodBeat.o(195964);
      return bool;
    }
    
    public void a(androidx.core.graphics.c[] paramArrayOfc)
    {
      this.buD = paramArrayOfc;
    }
    
    void aI(View paramView)
    {
      AppMethodBeat.i(196023);
      androidx.core.graphics.c localc = aJ(paramView);
      paramView = localc;
      if (localc == null) {
        paramView = androidx.core.graphics.c.bqu;
      }
      g(paramView);
      AppMethodBeat.o(196023);
    }
    
    void b(ah paramah)
    {
      this.buF = paramah;
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(196036);
      if (!super.equals(paramObject))
      {
        AppMethodBeat.o(196036);
        return false;
      }
      paramObject = (h)paramObject;
      boolean bool = Objects.equals(this.buG, paramObject.buG);
      AppMethodBeat.o(196036);
      return bool;
    }
    
    public androidx.core.graphics.c er(int paramInt)
    {
      AppMethodBeat.i(195970);
      androidx.core.graphics.c localc = r(paramInt, false);
      AppMethodBeat.o(195970);
      return localc;
    }
    
    void g(androidx.core.graphics.c paramc)
    {
      this.buG = paramc;
    }
    
    protected androidx.core.graphics.c s(int paramInt, boolean paramBoolean)
    {
      androidx.core.graphics.c localc = null;
      Object localObject = null;
      int k = 0;
      AppMethodBeat.i(195990);
      switch (paramInt)
      {
      default: 
        localObject = androidx.core.graphics.c.bqu;
        AppMethodBeat.o(195990);
        return localObject;
      case 1: 
        if (paramBoolean)
        {
          localObject = androidx.core.graphics.c.m(0, Math.max(EG().top, EB().top), 0, 0);
          AppMethodBeat.o(195990);
          return localObject;
        }
        localObject = androidx.core.graphics.c.m(0, EB().top, 0, 0);
        AppMethodBeat.o(195990);
        return localObject;
      case 2: 
        if (paramBoolean)
        {
          localObject = EG();
          localc = EC();
          localObject = androidx.core.graphics.c.m(Math.max(((androidx.core.graphics.c)localObject).left, localc.left), 0, Math.max(((androidx.core.graphics.c)localObject).right, localc.right), Math.max(((androidx.core.graphics.c)localObject).bottom, localc.bottom));
          AppMethodBeat.o(195990);
          return localObject;
        }
        localc = EB();
        if (this.buF != null) {
          localObject = this.buF.buh.EC();
        }
        paramInt = localc.bottom;
        if (localObject != null) {
          paramInt = Math.min(paramInt, ((androidx.core.graphics.c)localObject).bottom);
        }
        break;
      }
      for (;;)
      {
        localObject = androidx.core.graphics.c.m(localc.left, 0, localc.right, paramInt);
        AppMethodBeat.o(195990);
        return localObject;
        localObject = localc;
        if (this.buD != null) {
          localObject = this.buD[ah.m.es(8)];
        }
        if (localObject != null)
        {
          AppMethodBeat.o(195990);
          return localObject;
        }
        localObject = EB();
        localc = EG();
        if (((androidx.core.graphics.c)localObject).bottom > localc.bottom)
        {
          localObject = androidx.core.graphics.c.m(0, 0, 0, ((androidx.core.graphics.c)localObject).bottom);
          AppMethodBeat.o(195990);
          return localObject;
        }
        if ((this.buG != null) && (!this.buG.equals(androidx.core.graphics.c.bqu)) && (this.buG.bottom > localc.bottom))
        {
          localObject = androidx.core.graphics.c.m(0, 0, 0, this.buG.bottom);
          AppMethodBeat.o(195990);
          return localObject;
        }
        localObject = androidx.core.graphics.c.bqu;
        AppMethodBeat.o(195990);
        return localObject;
        localObject = ED();
        AppMethodBeat.o(195990);
        return localObject;
        localObject = EE();
        AppMethodBeat.o(195990);
        return localObject;
        localObject = EF();
        AppMethodBeat.o(195990);
        return localObject;
        label532:
        int i;
        if (this.buF != null)
        {
          localObject = this.buF.buh.Ez();
          if (localObject == null) {
            break label638;
          }
          if (Build.VERSION.SDK_INT < 28) {
            break label622;
          }
          paramInt = ((DisplayCutout)((c)localObject).bsJ).getSafeInsetLeft();
          if (Build.VERSION.SDK_INT < 28) {
            break label627;
          }
          i = ((DisplayCutout)((c)localObject).bsJ).getSafeInsetTop();
          label552:
          if (Build.VERSION.SDK_INT < 28) {
            break label632;
          }
        }
        label622:
        label627:
        label632:
        for (int j = ((DisplayCutout)((c)localObject).bsJ).getSafeInsetRight();; j = 0)
        {
          if (Build.VERSION.SDK_INT >= 28) {
            k = ((DisplayCutout)((c)localObject).bsJ).getSafeInsetBottom();
          }
          localObject = androidx.core.graphics.c.m(paramInt, i, j, k);
          AppMethodBeat.o(195990);
          return localObject;
          localObject = Ez();
          break;
          paramInt = 0;
          break label532;
          i = 0;
          break label552;
        }
        label638:
        localObject = androidx.core.graphics.c.bqu;
        AppMethodBeat.o(195990);
        return localObject;
      }
    }
  }
  
  static class i
    extends ah.h
  {
    private androidx.core.graphics.c buu = null;
    
    i(ah paramah, WindowInsets paramWindowInsets)
    {
      super(paramWindowInsets);
    }
    
    final androidx.core.graphics.c EC()
    {
      AppMethodBeat.i(195941);
      if (this.buu == null) {
        this.buu = androidx.core.graphics.c.m(this.but.getStableInsetLeft(), this.but.getStableInsetTop(), this.but.getStableInsetRight(), this.but.getStableInsetBottom());
      }
      androidx.core.graphics.c localc = this.buu;
      AppMethodBeat.o(195941);
      return localc;
    }
    
    boolean Er()
    {
      AppMethodBeat.i(195918);
      boolean bool = this.but.isConsumed();
      AppMethodBeat.o(195918);
      return bool;
    }
    
    ah Es()
    {
      AppMethodBeat.i(195934);
      ah localah = ah.a(this.but.consumeSystemWindowInsets());
      AppMethodBeat.o(195934);
      return localah;
    }
    
    ah Ey()
    {
      AppMethodBeat.i(195927);
      ah localah = ah.a(this.but.consumeStableInsets());
      AppMethodBeat.o(195927);
      return localah;
    }
    
    public void f(androidx.core.graphics.c paramc)
    {
      this.buu = paramc;
    }
  }
  
  static class j
    extends ah.i
  {
    j(ah paramah, WindowInsets paramWindowInsets)
    {
      super(paramWindowInsets);
    }
    
    ah EA()
    {
      AppMethodBeat.i(195919);
      ah localah = ah.a(this.but.consumeDisplayCutout());
      AppMethodBeat.o(195919);
      return localah;
    }
    
    c Ez()
    {
      AppMethodBeat.i(195912);
      Object localObject = this.but.getDisplayCutout();
      if (localObject == null)
      {
        AppMethodBeat.o(195912);
        return null;
      }
      localObject = new c(localObject);
      AppMethodBeat.o(195912);
      return localObject;
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(195931);
      if (this == paramObject)
      {
        AppMethodBeat.o(195931);
        return true;
      }
      if (!(paramObject instanceof j))
      {
        AppMethodBeat.o(195931);
        return false;
      }
      paramObject = (j)paramObject;
      if ((Objects.equals(this.but, paramObject.but)) && (Objects.equals(this.buG, paramObject.buG)))
      {
        AppMethodBeat.o(195931);
        return true;
      }
      AppMethodBeat.o(195931);
      return false;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(195940);
      int i = this.but.hashCode();
      AppMethodBeat.o(195940);
      return i;
    }
  }
  
  static class k
    extends ah.j
  {
    private androidx.core.graphics.c buH = null;
    private androidx.core.graphics.c buI = null;
    private androidx.core.graphics.c buJ = null;
    
    k(ah paramah, WindowInsets paramWindowInsets)
    {
      super(paramWindowInsets);
    }
    
    androidx.core.graphics.c ED()
    {
      AppMethodBeat.i(195906);
      if (this.buH == null) {
        this.buH = androidx.core.graphics.c.a(this.but.getSystemGestureInsets());
      }
      androidx.core.graphics.c localc = this.buH;
      AppMethodBeat.o(195906);
      return localc;
    }
    
    androidx.core.graphics.c EE()
    {
      AppMethodBeat.i(195916);
      if (this.buI == null) {
        this.buI = androidx.core.graphics.c.a(this.but.getMandatorySystemGestureInsets());
      }
      androidx.core.graphics.c localc = this.buI;
      AppMethodBeat.o(195916);
      return localc;
    }
    
    androidx.core.graphics.c EF()
    {
      AppMethodBeat.i(195926);
      if (this.buJ == null) {
        this.buJ = androidx.core.graphics.c.a(this.but.getTappableElementInsets());
      }
      androidx.core.graphics.c localc = this.buJ;
      AppMethodBeat.o(195926);
      return localc;
    }
    
    public void f(androidx.core.graphics.c paramc) {}
  }
  
  static final class l
    extends ah.k
  {
    static final ah bug;
    
    static
    {
      AppMethodBeat.i(195901);
      bug = ah.a(WindowInsets.CONSUMED);
      AppMethodBeat.o(195901);
    }
    
    l(ah paramah, WindowInsets paramWindowInsets)
    {
      super(paramWindowInsets);
    }
    
    final void aI(View paramView) {}
    
    public final androidx.core.graphics.c er(int paramInt)
    {
      AppMethodBeat.i(195909);
      androidx.core.graphics.c localc = androidx.core.graphics.c.a(this.but.getInsets(ah.n.et(paramInt)));
      AppMethodBeat.o(195909);
      return localc;
    }
  }
  
  static final class n
  {
    static int et(int paramInt)
    {
      AppMethodBeat.i(195844);
      int k = 0;
      int j = 1;
      if (j <= 256)
      {
        int i = k;
        if ((paramInt & j) != 0) {
          switch (j)
          {
          default: 
            i = k;
          }
        }
        for (;;)
        {
          j <<= 1;
          k = i;
          break;
          i = k | WindowInsets.Type.statusBars();
          continue;
          i = k | WindowInsets.Type.navigationBars();
          continue;
          i = k | WindowInsets.Type.captionBar();
          continue;
          i = k | WindowInsets.Type.ime();
          continue;
          i = k | WindowInsets.Type.systemGestures();
          continue;
          i = k | WindowInsets.Type.mandatorySystemGestures();
          continue;
          i = k | WindowInsets.Type.tappableElement();
          continue;
          i = k | WindowInsets.Type.displayCutout();
        }
      }
      AppMethodBeat.o(195844);
      return k;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.core.g.ah
 * JD-Core Version:    0.7.0.1
 */
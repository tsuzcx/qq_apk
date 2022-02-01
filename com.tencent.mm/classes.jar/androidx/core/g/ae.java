package androidx.core.g;

import android.graphics.Insets;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.view.WindowInsets;
import android.view.WindowInsets.Builder;
import androidx.core.f.d;
import androidx.core.f.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Objects;

public class ae
{
  public static final ae NZ;
  public final e Oa;
  
  static
  {
    AppMethodBeat.i(252002);
    NZ = new a().Ob.hh().Oa.ho().Oa.hm().Oa.hl();
    AppMethodBeat.o(252002);
  }
  
  public ae()
  {
    AppMethodBeat.i(251989);
    this.Oa = new e(this);
    AppMethodBeat.o(251989);
  }
  
  private ae(WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(251987);
    if (Build.VERSION.SDK_INT >= 29)
    {
      this.Oa = new i(this, paramWindowInsets);
      AppMethodBeat.o(251987);
      return;
    }
    if (Build.VERSION.SDK_INT >= 28)
    {
      this.Oa = new h(this, paramWindowInsets);
      AppMethodBeat.o(251987);
      return;
    }
    if (Build.VERSION.SDK_INT >= 21)
    {
      this.Oa = new g(this, paramWindowInsets);
      AppMethodBeat.o(251987);
      return;
    }
    if (Build.VERSION.SDK_INT >= 20)
    {
      this.Oa = new f(this, paramWindowInsets);
      AppMethodBeat.o(251987);
      return;
    }
    this.Oa = new e(this);
    AppMethodBeat.o(251987);
  }
  
  public static ae a(WindowInsets paramWindowInsets)
  {
    AppMethodBeat.i(251992);
    paramWindowInsets = new ae((WindowInsets)g.checkNotNull(paramWindowInsets));
    AppMethodBeat.o(251992);
    return paramWindowInsets;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(252000);
    if (this == paramObject)
    {
      AppMethodBeat.o(252000);
      return true;
    }
    if (!(paramObject instanceof ae))
    {
      AppMethodBeat.o(252000);
      return false;
    }
    paramObject = (ae)paramObject;
    boolean bool = d.equals(this.Oa, paramObject.Oa);
    AppMethodBeat.o(252000);
    return bool;
  }
  
  @Deprecated
  public final ae f(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(251999);
    ae localae = new a(this).a(androidx.core.graphics.c.e(paramInt1, paramInt2, paramInt3, paramInt4)).Ob.hh();
    AppMethodBeat.o(251999);
    return localae;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(252001);
    if (this.Oa == null)
    {
      AppMethodBeat.o(252001);
      return 0;
    }
    int i = this.Oa.hashCode();
    AppMethodBeat.o(252001);
    return i;
  }
  
  public final int hc()
  {
    AppMethodBeat.i(293059);
    int i = this.Oa.hp().left;
    AppMethodBeat.o(293059);
    return i;
  }
  
  public final int hd()
  {
    AppMethodBeat.i(293060);
    int i = this.Oa.hp().top;
    AppMethodBeat.o(293060);
    return i;
  }
  
  public final int he()
  {
    AppMethodBeat.i(293061);
    int i = this.Oa.hp().right;
    AppMethodBeat.o(293061);
    return i;
  }
  
  public final int hf()
  {
    AppMethodBeat.i(293062);
    int i = this.Oa.hp().bottom;
    AppMethodBeat.o(293062);
    return i;
  }
  
  public final WindowInsets hg()
  {
    if ((this.Oa instanceof f)) {
      return ((f)this.Oa).Ok;
    }
    return null;
  }
  
  public static final class a
  {
    final ae.b Ob;
    
    public a()
    {
      AppMethodBeat.i(251896);
      if (Build.VERSION.SDK_INT >= 29)
      {
        this.Ob = new ae.d();
        AppMethodBeat.o(251896);
        return;
      }
      if (Build.VERSION.SDK_INT >= 20)
      {
        this.Ob = new ae.c();
        AppMethodBeat.o(251896);
        return;
      }
      this.Ob = new ae.b();
      AppMethodBeat.o(251896);
    }
    
    public a(ae paramae)
    {
      AppMethodBeat.i(251897);
      if (Build.VERSION.SDK_INT >= 29)
      {
        this.Ob = new ae.d(paramae);
        AppMethodBeat.o(251897);
        return;
      }
      if (Build.VERSION.SDK_INT >= 20)
      {
        this.Ob = new ae.c(paramae);
        AppMethodBeat.o(251897);
        return;
      }
      this.Ob = new ae.b(paramae);
      AppMethodBeat.o(251897);
    }
    
    public final a a(androidx.core.graphics.c paramc)
    {
      AppMethodBeat.i(251899);
      this.Ob.b(paramc);
      AppMethodBeat.o(251899);
      return this;
    }
  }
  
  static class b
  {
    private final ae Oc;
    
    b()
    {
      this(new ae());
      AppMethodBeat.i(251903);
      AppMethodBeat.o(251903);
    }
    
    b(ae paramae)
    {
      this.Oc = paramae;
    }
    
    void b(androidx.core.graphics.c paramc) {}
    
    ae hh()
    {
      return this.Oc;
    }
  }
  
  static final class c
    extends ae.b
  {
    private static Field Od;
    private static boolean Oe = false;
    private static Constructor<WindowInsets> Of;
    private static boolean Og = false;
    private WindowInsets Oh;
    
    c()
    {
      AppMethodBeat.i(251914);
      this.Oh = hi();
      AppMethodBeat.o(251914);
    }
    
    c(ae paramae)
    {
      AppMethodBeat.i(251915);
      this.Oh = paramae.hg();
      AppMethodBeat.o(251915);
    }
    
    private static WindowInsets hi()
    {
      AppMethodBeat.i(251922);
      if (!Oe) {}
      try
      {
        Od = WindowInsets.class.getDeclaredField("CONSUMED");
        label21:
        Oe = true;
        if (Od != null) {
          try
          {
            WindowInsets localWindowInsets1 = (WindowInsets)Od.get(null);
            if (localWindowInsets1 != null)
            {
              localWindowInsets1 = new WindowInsets(localWindowInsets1);
              AppMethodBeat.o(251922);
              return localWindowInsets1;
            }
          }
          catch (ReflectiveOperationException localReflectiveOperationException1) {}
        }
        if (!Og) {}
        try
        {
          Of = WindowInsets.class.getConstructor(new Class[] { Rect.class });
          label86:
          Og = true;
          if (Of != null) {
            try
            {
              WindowInsets localWindowInsets2 = (WindowInsets)Of.newInstance(new Object[] { new Rect() });
              AppMethodBeat.o(251922);
              return localWindowInsets2;
            }
            catch (ReflectiveOperationException localReflectiveOperationException2) {}
          }
          AppMethodBeat.o(251922);
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
    
    final void b(androidx.core.graphics.c paramc)
    {
      AppMethodBeat.i(251918);
      if (this.Oh != null) {
        this.Oh = this.Oh.replaceSystemWindowInsets(paramc.left, paramc.top, paramc.right, paramc.bottom);
      }
      AppMethodBeat.o(251918);
    }
    
    final ae hh()
    {
      AppMethodBeat.i(251921);
      ae localae = ae.a(this.Oh);
      AppMethodBeat.o(251921);
      return localae;
    }
  }
  
  static final class d
    extends ae.b
  {
    final WindowInsets.Builder Oi;
    
    d()
    {
      AppMethodBeat.i(251931);
      this.Oi = new WindowInsets.Builder();
      AppMethodBeat.o(251931);
    }
    
    d(ae paramae)
    {
      AppMethodBeat.i(251932);
      paramae = paramae.hg();
      if (paramae != null) {}
      for (paramae = new WindowInsets.Builder(paramae);; paramae = new WindowInsets.Builder())
      {
        this.Oi = paramae;
        AppMethodBeat.o(251932);
        return;
      }
    }
    
    final void b(androidx.core.graphics.c paramc)
    {
      AppMethodBeat.i(251934);
      this.Oi.setSystemWindowInsets(Insets.of(paramc.left, paramc.top, paramc.right, paramc.bottom));
      AppMethodBeat.o(251934);
    }
    
    final ae hh()
    {
      AppMethodBeat.i(251936);
      ae localae = ae.a(this.Oi.build());
      AppMethodBeat.o(251936);
      return localae;
    }
  }
  
  public static class e
  {
    final ae Oj;
    
    e(ae paramae)
    {
      this.Oj = paramae;
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(251942);
      if (this == paramObject)
      {
        AppMethodBeat.o(251942);
        return true;
      }
      if (!(paramObject instanceof e))
      {
        AppMethodBeat.o(251942);
        return false;
      }
      paramObject = (e)paramObject;
      if ((hj() == paramObject.hj()) && (hk() == paramObject.hk()) && (d.equals(hp(), paramObject.hp())) && (d.equals(hq(), paramObject.hq())) && (d.equals(hn(), paramObject.hn())))
      {
        AppMethodBeat.o(251942);
        return true;
      }
      AppMethodBeat.o(251942);
      return false;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(251944);
      int i = d.hash(new Object[] { Boolean.valueOf(hj()), Boolean.valueOf(hk()), hp(), hq(), hn() });
      AppMethodBeat.o(251944);
      return i;
    }
    
    boolean hj()
    {
      return false;
    }
    
    public boolean hk()
    {
      return false;
    }
    
    public ae hl()
    {
      return this.Oj;
    }
    
    ae hm()
    {
      return this.Oj;
    }
    
    c hn()
    {
      return null;
    }
    
    ae ho()
    {
      return this.Oj;
    }
    
    public androidx.core.graphics.c hp()
    {
      return androidx.core.graphics.c.Kn;
    }
    
    androidx.core.graphics.c hq()
    {
      return androidx.core.graphics.c.Kn;
    }
  }
  
  static class f
    extends ae.e
  {
    final WindowInsets Ok;
    private androidx.core.graphics.c Ol = null;
    
    f(ae paramae, WindowInsets paramWindowInsets)
    {
      super();
      this.Ok = paramWindowInsets;
    }
    
    boolean hj()
    {
      AppMethodBeat.i(251947);
      boolean bool = this.Ok.isRound();
      AppMethodBeat.o(251947);
      return bool;
    }
    
    final androidx.core.graphics.c hp()
    {
      AppMethodBeat.i(251948);
      if (this.Ol == null) {
        this.Ol = androidx.core.graphics.c.e(this.Ok.getSystemWindowInsetLeft(), this.Ok.getSystemWindowInsetTop(), this.Ok.getSystemWindowInsetRight(), this.Ok.getSystemWindowInsetBottom());
      }
      androidx.core.graphics.c localc = this.Ol;
      AppMethodBeat.o(251948);
      return localc;
    }
  }
  
  static class g
    extends ae.f
  {
    private androidx.core.graphics.c Om = null;
    
    g(ae paramae, WindowInsets paramWindowInsets)
    {
      super(paramWindowInsets);
    }
    
    boolean hk()
    {
      AppMethodBeat.i(251958);
      boolean bool = this.Ok.isConsumed();
      AppMethodBeat.o(251958);
      return bool;
    }
    
    ae hl()
    {
      AppMethodBeat.i(251961);
      ae localae = ae.a(this.Ok.consumeSystemWindowInsets());
      AppMethodBeat.o(251961);
      return localae;
    }
    
    ae hm()
    {
      AppMethodBeat.i(251960);
      ae localae = ae.a(this.Ok.consumeStableInsets());
      AppMethodBeat.o(251960);
      return localae;
    }
    
    final androidx.core.graphics.c hq()
    {
      AppMethodBeat.i(251963);
      if (this.Om == null) {
        this.Om = androidx.core.graphics.c.e(this.Ok.getStableInsetLeft(), this.Ok.getStableInsetTop(), this.Ok.getStableInsetRight(), this.Ok.getStableInsetBottom());
      }
      androidx.core.graphics.c localc = this.Om;
      AppMethodBeat.o(251963);
      return localc;
    }
  }
  
  static class h
    extends ae.g
  {
    h(ae paramae, WindowInsets paramWindowInsets)
    {
      super(paramWindowInsets);
    }
    
    public boolean equals(Object paramObject)
    {
      AppMethodBeat.i(251976);
      if (this == paramObject)
      {
        AppMethodBeat.o(251976);
        return true;
      }
      if (!(paramObject instanceof h))
      {
        AppMethodBeat.o(251976);
        return false;
      }
      paramObject = (h)paramObject;
      boolean bool = Objects.equals(this.Ok, paramObject.Ok);
      AppMethodBeat.o(251976);
      return bool;
    }
    
    public int hashCode()
    {
      AppMethodBeat.i(251977);
      int i = this.Ok.hashCode();
      AppMethodBeat.o(251977);
      return i;
    }
    
    c hn()
    {
      AppMethodBeat.i(251973);
      Object localObject = this.Ok.getDisplayCutout();
      if (localObject == null)
      {
        AppMethodBeat.o(251973);
        return null;
      }
      localObject = new c(localObject);
      AppMethodBeat.o(251973);
      return localObject;
    }
    
    ae ho()
    {
      AppMethodBeat.i(251974);
      ae localae = ae.a(this.Ok.consumeDisplayCutout());
      AppMethodBeat.o(251974);
      return localae;
    }
  }
  
  static final class i
    extends ae.h
  {
    private androidx.core.graphics.c On = null;
    private androidx.core.graphics.c Oo = null;
    private androidx.core.graphics.c Op = null;
    
    i(ae paramae, WindowInsets paramWindowInsets)
    {
      super(paramWindowInsets);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.core.g.ae
 * JD-Core Version:    0.7.0.1
 */
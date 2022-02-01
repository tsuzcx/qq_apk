package androidx.camera.camera2.b.a.a;

import android.os.Build.VERSION;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.al;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

class f
  implements b.a
{
  final Object mObject;
  
  f(Surface paramSurface)
  {
    AppMethodBeat.i(198157);
    this.mObject = new a(paramSurface);
    AppMethodBeat.o(198157);
  }
  
  f(Object paramObject)
  {
    this.mObject = paramObject;
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(198174);
    if (!(paramObject instanceof f))
    {
      AppMethodBeat.o(198174);
      return false;
    }
    boolean bool = Objects.equals(this.mObject, ((f)paramObject).mObject);
    AppMethodBeat.o(198174);
    return bool;
  }
  
  public Surface getSurface()
  {
    AppMethodBeat.i(198169);
    Object localObject = ((a)this.mObject).Fs;
    if (((List)localObject).size() == 0)
    {
      AppMethodBeat.o(198169);
      return null;
    }
    localObject = (Surface)((List)localObject).get(0);
    AppMethodBeat.o(198169);
    return localObject;
  }
  
  public String hX()
  {
    return ((a)this.mObject).Fq;
  }
  
  public Object hY()
  {
    return null;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(198177);
    int i = this.mObject.hashCode();
    AppMethodBeat.o(198177);
    return i;
  }
  
  static final class a
  {
    String Fq;
    boolean Fr;
    final List<Surface> Fs;
    final Size Ft;
    final int Fu;
    final int Fv;
    
    a(Surface paramSurface)
    {
      AppMethodBeat.i(198164);
      this.Fr = false;
      androidx.core.f.f.checkNotNull(paramSurface, "Surface must not be null");
      this.Fs = Collections.singletonList(paramSurface);
      this.Ft = c(paramSurface);
      this.Fu = d(paramSurface);
      this.Fv = e(paramSurface);
      AppMethodBeat.o(198164);
    }
    
    private static Size c(Surface paramSurface)
    {
      AppMethodBeat.i(198172);
      try
      {
        Method localMethod = Class.forName("android.hardware.camera2.legacy.LegacyCameraDevice").getDeclaredMethod("getSurfaceSize", new Class[] { Surface.class });
        localMethod.setAccessible(true);
        paramSurface = (Size)localMethod.invoke(null, new Object[] { paramSurface });
        AppMethodBeat.o(198172);
        return paramSurface;
      }
      catch (ClassNotFoundException paramSurface)
      {
        al.U("OutputConfigCompat");
        AppMethodBeat.o(198172);
        return null;
      }
      catch (IllegalAccessException paramSurface)
      {
        break label55;
      }
      catch (NoSuchMethodException paramSurface)
      {
        break label55;
      }
      catch (InvocationTargetException paramSurface)
      {
        label55:
        break label55;
      }
    }
    
    private static int d(Surface paramSurface)
    {
      AppMethodBeat.i(198178);
      try
      {
        Method localMethod = Class.forName("android.hardware.camera2.legacy.LegacyCameraDevice").getDeclaredMethod("detectSurfaceType", new Class[] { Surface.class });
        if (Build.VERSION.SDK_INT < 22) {
          localMethod.setAccessible(true);
        }
        int i = ((Integer)localMethod.invoke(null, new Object[] { paramSurface })).intValue();
        AppMethodBeat.o(198178);
        return i;
      }
      catch (ClassNotFoundException paramSurface)
      {
        al.U("OutputConfigCompat");
        AppMethodBeat.o(198178);
        return 0;
      }
      catch (IllegalAccessException paramSurface)
      {
        break label66;
      }
      catch (NoSuchMethodException paramSurface)
      {
        break label66;
      }
      catch (InvocationTargetException paramSurface)
      {
        label66:
        break label66;
      }
    }
    
    private static int e(Surface paramSurface)
    {
      AppMethodBeat.i(198185);
      try
      {
        int i = ((Integer)Surface.class.getDeclaredMethod("getGenerationId", new Class[0]).invoke(paramSurface, new Object[0])).intValue();
        AppMethodBeat.o(198185);
        return i;
      }
      catch (IllegalAccessException paramSurface)
      {
        al.U("OutputConfigCompat");
        AppMethodBeat.o(198185);
        return -1;
      }
      catch (NoSuchMethodException paramSurface)
      {
        break label39;
      }
      catch (InvocationTargetException paramSurface)
      {
        label39:
        break label39;
      }
    }
    
    public final boolean equals(Object paramObject)
    {
      AppMethodBeat.i(198190);
      if (!(paramObject instanceof a))
      {
        AppMethodBeat.o(198190);
        return false;
      }
      paramObject = (a)paramObject;
      if ((!this.Ft.equals(paramObject.Ft)) || (this.Fu != paramObject.Fu) || (this.Fv != paramObject.Fv) || (this.Fr != paramObject.Fr) || (!Objects.equals(this.Fq, paramObject.Fq)))
      {
        AppMethodBeat.o(198190);
        return false;
      }
      int j = Math.min(this.Fs.size(), paramObject.Fs.size());
      int i = 0;
      while (i < j)
      {
        if (this.Fs.get(i) != paramObject.Fs.get(i))
        {
          AppMethodBeat.o(198190);
          return false;
        }
        i += 1;
      }
      AppMethodBeat.o(198190);
      return true;
    }
    
    public final int hashCode()
    {
      int j = 0;
      AppMethodBeat.i(198197);
      int i = this.Fs.hashCode() ^ 0x1F;
      i = (i << 5) - i ^ this.Fv;
      i = (i << 5) - i ^ this.Ft.hashCode();
      int k = (i << 5) - i ^ this.Fu;
      if (this.Fr)
      {
        i = 1;
        k = i ^ (k << 5) - k;
        if (this.Fq != null) {
          break label100;
        }
      }
      label100:
      for (i = j;; i = this.Fq.hashCode())
      {
        AppMethodBeat.o(198197);
        return (k << 5) - k ^ i;
        i = 0;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.camera.camera2.b.a.a.f
 * JD-Core Version:    0.7.0.1
 */
package androidx.lifecycle;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class y
{
  private final b aaN;
  private final aa mViewModelStore;
  
  public y(aa paramaa, b paramb)
  {
    this.aaN = paramb;
    this.mViewModelStore = paramaa;
  }
  
  public y(ab paramab, b paramb)
  {
    this(paramab.getViewModelStore(), paramb);
    AppMethodBeat.i(192173);
    AppMethodBeat.o(192173);
  }
  
  public final <T extends x> T i(Class<T> paramClass)
  {
    AppMethodBeat.i(192183);
    String str = paramClass.getCanonicalName();
    if (str == null)
    {
      paramClass = new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
      AppMethodBeat.o(192183);
      throw paramClass;
    }
    str = "androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(String.valueOf(str));
    x localx = (x)this.mViewModelStore.aaP.get(str);
    if (paramClass.isInstance(localx))
    {
      AppMethodBeat.o(192183);
      return localx;
    }
    paramClass = this.aaN.create(paramClass);
    this.mViewModelStore.a(str, paramClass);
    AppMethodBeat.o(192183);
    return paramClass;
  }
  
  public static final class a
    extends y.c
  {
    private static a aaO;
    private Application Zw;
    
    private a(Application paramApplication)
    {
      this.Zw = paramApplication;
    }
    
    public static a a(Application paramApplication)
    {
      AppMethodBeat.i(192147);
      if (aaO == null) {
        aaO = new a(paramApplication);
      }
      paramApplication = aaO;
      AppMethodBeat.o(192147);
      return paramApplication;
    }
    
    public final <T extends x> T create(Class<T> paramClass)
    {
      AppMethodBeat.i(192159);
      if (a.class.isAssignableFrom(paramClass)) {
        try
        {
          x localx = (x)paramClass.getConstructor(new Class[] { Application.class }).newInstance(new Object[] { this.Zw });
          AppMethodBeat.o(192159);
          return localx;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          paramClass = new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), localNoSuchMethodException);
          AppMethodBeat.o(192159);
          throw paramClass;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          paramClass = new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), localIllegalAccessException);
          AppMethodBeat.o(192159);
          throw paramClass;
        }
        catch (InstantiationException localInstantiationException)
        {
          paramClass = new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), localInstantiationException);
          AppMethodBeat.o(192159);
          throw paramClass;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          paramClass = new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), localInvocationTargetException);
          AppMethodBeat.o(192159);
          throw paramClass;
        }
      }
      paramClass = super.create(paramClass);
      AppMethodBeat.o(192159);
      return paramClass;
    }
  }
  
  public static abstract interface b
  {
    public abstract <T extends x> T create(Class<T> paramClass);
  }
  
  public static class c
    implements y.b
  {
    public <T extends x> T create(Class<T> paramClass)
    {
      AppMethodBeat.i(192169);
      try
      {
        x localx = (x)paramClass.newInstance();
        AppMethodBeat.o(192169);
        return localx;
      }
      catch (InstantiationException localInstantiationException)
      {
        paramClass = new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), localInstantiationException);
        AppMethodBeat.o(192169);
        throw paramClass;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        paramClass = new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), localIllegalAccessException);
        AppMethodBeat.o(192169);
        throw paramClass;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.lifecycle.y
 * JD-Core Version:    0.7.0.1
 */
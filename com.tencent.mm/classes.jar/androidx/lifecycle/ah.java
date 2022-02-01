package androidx.lifecycle;

import android.app.Application;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ah
{
  private final b bIm;
  private final aj mViewModelStore;
  
  public ah(aj paramaj, b paramb)
  {
    this.bIm = paramb;
    this.mViewModelStore = paramaj;
  }
  
  public ah(ak paramak, b paramb)
  {
    this(paramak.getViewModelStore(), paramb);
    AppMethodBeat.i(194427);
    AppMethodBeat.o(194427);
  }
  
  private <T extends af> T d(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(194441);
    af localaf = this.mViewModelStore.aN(paramString);
    if (paramClass.isInstance(localaf))
    {
      if ((this.bIm instanceof e)) {
        ((e)this.bIm).a(localaf);
      }
      AppMethodBeat.o(194441);
      return localaf;
    }
    if ((this.bIm instanceof c)) {}
    for (paramClass = ((c)this.bIm).c(paramString, paramClass);; paramClass = this.bIm.create(paramClass))
    {
      this.mViewModelStore.a(paramString, paramClass);
      AppMethodBeat.o(194441);
      return paramClass;
    }
  }
  
  public final <T extends af> T q(Class<T> paramClass)
  {
    AppMethodBeat.i(194450);
    String str = paramClass.getCanonicalName();
    if (str == null)
    {
      paramClass = new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
      AppMethodBeat.o(194450);
      throw paramClass;
    }
    paramClass = d("androidx.lifecycle.ViewModelProvider.DefaultKey:".concat(String.valueOf(str)), paramClass);
    AppMethodBeat.o(194450);
    return paramClass;
  }
  
  public static final class a
    extends ah.d
  {
    private static a bIv;
    private Application bGP;
    
    private a(Application paramApplication)
    {
      this.bGP = paramApplication;
    }
    
    public static a a(Application paramApplication)
    {
      AppMethodBeat.i(194504);
      if (bIv == null) {
        bIv = new a(paramApplication);
      }
      paramApplication = bIv;
      AppMethodBeat.o(194504);
      return paramApplication;
    }
    
    public final <T extends af> T create(Class<T> paramClass)
    {
      AppMethodBeat.i(194529);
      if (a.class.isAssignableFrom(paramClass)) {
        try
        {
          af localaf = (af)paramClass.getConstructor(new Class[] { Application.class }).newInstance(new Object[] { this.bGP });
          AppMethodBeat.o(194529);
          return localaf;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          paramClass = new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), localNoSuchMethodException);
          AppMethodBeat.o(194529);
          throw paramClass;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          paramClass = new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), localIllegalAccessException);
          AppMethodBeat.o(194529);
          throw paramClass;
        }
        catch (InstantiationException localInstantiationException)
        {
          paramClass = new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), localInstantiationException);
          AppMethodBeat.o(194529);
          throw paramClass;
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          paramClass = new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), localInvocationTargetException);
          AppMethodBeat.o(194529);
          throw paramClass;
        }
      }
      paramClass = super.create(paramClass);
      AppMethodBeat.o(194529);
      return paramClass;
    }
  }
  
  public static abstract interface b
  {
    public abstract <T extends af> T create(Class<T> paramClass);
  }
  
  static abstract class c
    extends ah.e
    implements ah.b
  {
    public abstract <T extends af> T c(String paramString, Class<T> paramClass);
    
    public <T extends af> T create(Class<T> paramClass)
    {
      throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
    }
  }
  
  public static class d
    implements ah.b
  {
    static d bIw;
    
    public <T extends af> T create(Class<T> paramClass)
    {
      AppMethodBeat.i(194506);
      try
      {
        af localaf = (af)paramClass.newInstance();
        AppMethodBeat.o(194506);
        return localaf;
      }
      catch (InstantiationException localInstantiationException)
      {
        paramClass = new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), localInstantiationException);
        AppMethodBeat.o(194506);
        throw paramClass;
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        paramClass = new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), localIllegalAccessException);
        AppMethodBeat.o(194506);
        throw paramClass;
      }
    }
  }
  
  static class e
  {
    void a(af paramaf) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.lifecycle.ah
 * JD-Core Version:    0.7.0.1
 */
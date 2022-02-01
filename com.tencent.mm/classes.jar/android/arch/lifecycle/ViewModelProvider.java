package android.arch.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class ViewModelProvider
{
  private final Factory dx;
  private final ViewModelStore mViewModelStore;
  
  public ViewModelProvider(ViewModelStore paramViewModelStore, Factory paramFactory)
  {
    this.dx = paramFactory;
    this.mViewModelStore = paramViewModelStore;
  }
  
  public ViewModelProvider(ViewModelStoreOwner paramViewModelStoreOwner, Factory paramFactory)
  {
    this(paramViewModelStoreOwner.getViewModelStore(), paramFactory);
  }
  
  public <T extends ViewModel> T get(Class<T> paramClass)
  {
    String str = paramClass.getCanonicalName();
    if (str == null) {
      throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }
    return get("android.arch.lifecycle.ViewModelProvider.DefaultKey:".concat(String.valueOf(str)), paramClass);
  }
  
  public <T extends ViewModel> T get(String paramString, Class<T> paramClass)
  {
    ViewModel localViewModel = (ViewModel)this.mViewModelStore.mMap.get(paramString);
    if (paramClass.isInstance(localViewModel)) {
      return localViewModel;
    }
    paramClass = this.dx.create(paramClass);
    this.mViewModelStore.a(paramString, paramClass);
    return paramClass;
  }
  
  public static class AndroidViewModelFactory
    extends ViewModelProvider.NewInstanceFactory
  {
    private static AndroidViewModelFactory dy;
    private Application ca;
    
    public AndroidViewModelFactory(Application paramApplication)
    {
      this.ca = paramApplication;
    }
    
    public static AndroidViewModelFactory getInstance(Application paramApplication)
    {
      if (dy == null) {
        dy = new AndroidViewModelFactory(paramApplication);
      }
      return dy;
    }
    
    public <T extends ViewModel> T create(Class<T> paramClass)
    {
      if (AndroidViewModel.class.isAssignableFrom(paramClass)) {
        try
        {
          ViewModel localViewModel = (ViewModel)paramClass.getConstructor(new Class[] { Application.class }).newInstance(new Object[] { this.ca });
          return localViewModel;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), localNoSuchMethodException);
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), localIllegalAccessException);
        }
        catch (InstantiationException localInstantiationException)
        {
          throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), localInstantiationException);
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), localInvocationTargetException);
        }
      }
      return super.create(paramClass);
    }
  }
  
  public static abstract interface Factory
  {
    public abstract <T extends ViewModel> T create(Class<T> paramClass);
  }
  
  public static class NewInstanceFactory
    implements ViewModelProvider.Factory
  {
    public <T extends ViewModel> T create(Class<T> paramClass)
    {
      try
      {
        ViewModel localViewModel = (ViewModel)paramClass.newInstance();
        return localViewModel;
      }
      catch (InstantiationException localInstantiationException)
      {
        throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), localInstantiationException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException("Cannot create an instance of ".concat(String.valueOf(paramClass)), localIllegalAccessException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.ViewModelProvider
 * JD-Core Version:    0.7.0.1
 */
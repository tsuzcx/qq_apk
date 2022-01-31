package android.arch.lifecycle;

import android.app.Application;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

public class ViewModelProvider
{
  private final Factory cH;
  private final ViewModelStore mViewModelStore;
  
  public ViewModelProvider(ViewModelStore paramViewModelStore, Factory paramFactory)
  {
    this.cH = paramFactory;
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
    return get("android.arch.lifecycle.ViewModelProvider.DefaultKey:" + str, paramClass);
  }
  
  public <T extends ViewModel> T get(String paramString, Class<T> paramClass)
  {
    Object localObject = (ViewModel)this.mViewModelStore.cJ.get(paramString);
    if (paramClass.isInstance(localObject)) {
      return localObject;
    }
    paramClass = this.cH.create(paramClass);
    localObject = this.mViewModelStore;
    ViewModel localViewModel = (ViewModel)((ViewModelStore)localObject).cJ.get(paramString);
    if (localViewModel != null) {
      localViewModel.onCleared();
    }
    ((ViewModelStore)localObject).cJ.put(paramString, paramClass);
    return paramClass;
  }
  
  public static class AndroidViewModelFactory
    extends ViewModelProvider.NewInstanceFactory
  {
    private static AndroidViewModelFactory cI;
    private Application bT;
    
    public AndroidViewModelFactory(Application paramApplication)
    {
      this.bT = paramApplication;
    }
    
    public static AndroidViewModelFactory getInstance(Application paramApplication)
    {
      if (cI == null) {
        cI = new AndroidViewModelFactory(paramApplication);
      }
      return cI;
    }
    
    public <T extends ViewModel> T create(Class<T> paramClass)
    {
      if (AndroidViewModel.class.isAssignableFrom(paramClass)) {
        try
        {
          ViewModel localViewModel = (ViewModel)paramClass.getConstructor(new Class[] { Application.class }).newInstance(new Object[] { this.bT });
          return localViewModel;
        }
        catch (NoSuchMethodException localNoSuchMethodException)
        {
          throw new RuntimeException("Cannot create an instance of " + paramClass, localNoSuchMethodException);
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          throw new RuntimeException("Cannot create an instance of " + paramClass, localIllegalAccessException);
        }
        catch (InstantiationException localInstantiationException)
        {
          throw new RuntimeException("Cannot create an instance of " + paramClass, localInstantiationException);
        }
        catch (InvocationTargetException localInvocationTargetException)
        {
          throw new RuntimeException("Cannot create an instance of " + paramClass, localInvocationTargetException);
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
        throw new RuntimeException("Cannot create an instance of " + paramClass, localInstantiationException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        throw new RuntimeException("Cannot create an instance of " + paramClass, localIllegalAccessException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.arch.lifecycle.ViewModelProvider
 * JD-Core Version:    0.7.0.1
 */
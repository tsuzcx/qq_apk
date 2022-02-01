package com.tencent.mm.obb.loader;

import android.app.Application;
import android.content.pm.ApplicationInfo;
import com.tencent.tinker.loader.shareutil.ShareReflectUtil;
import dalvik.system.BaseDexClassLoader;
import dalvik.system.DexFile;
import dalvik.system.PathClassLoader;
import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ObbClassLoader
  extends PathClassLoader
{
  private static final String TAG = "MicroMsg.ObbClassLoader";
  private final ClassLoader mAppClassLoader;
  private final String mAppClassName;
  
  private ObbClassLoader(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader)
  {
    super(paramString2, paramString3, paramClassLoader.getParent());
    this.mAppClassName = paramString1;
    this.mAppClassLoader = paramClassLoader;
  }
  
  private static final Field findField(Class<?> paramClass, String paramString)
  {
    Object localObject1 = paramClass;
    try
    {
      Field localField = ((Class)localObject1).getDeclaredField(paramString);
      localField.setAccessible(true);
      return localField;
    }
    finally
    {
      Class localClass;
      do
      {
        if (localObject1 == Object.class) {
          break;
        }
        localClass = ((Class)localObject1).getSuperclass();
        localObject1 = localClass;
      } while (localClass != null);
    }
  }
  
  public static ClassLoader injectOnDemand(Application paramApplication)
  {
    return paramApplication.getClass().getClassLoader();
  }
  
  private static ObbClassLoader newInstance(Application paramApplication)
  {
    ClassLoader localClassLoader = paramApplication.getClass().getClassLoader();
    Object localObject1 = findField(BaseDexClassLoader.class, "pathList").get(localClassLoader);
    Object localObject2 = paramApplication.getApplicationInfo();
    Object localObject3 = "/" + ((ApplicationInfo)localObject2).packageName + "/";
    Object[] arrayOfObject = (Object[])findField(localObject1.getClass(), "dexElements").get(localObject1);
    Field localField = findField(arrayOfObject.getClass().getComponentType(), "dexFile");
    StringBuilder localStringBuilder = new StringBuilder();
    int k = arrayOfObject.length;
    int j = 0;
    int i = 1;
    if (j < k)
    {
      Object localObject4 = arrayOfObject[j];
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        localObject4 = ((DexFile)localField.get(localObject4)).getName();
        if ((((String)localObject4).equals(((ApplicationInfo)localObject2).sourceDir)) || (((String)localObject4).contains((CharSequence)localObject3))) {
          localStringBuilder.append((String)localObject4);
        }
        j += 1;
        break;
        localStringBuilder.append(File.pathSeparator);
      }
    }
    localObject2 = (List)ShareReflectUtil.findField(localObject1, "nativeLibraryDirectories").get(localObject1);
    localObject1 = new StringBuilder();
    localObject2 = ((List)localObject2).iterator();
    i = 1;
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (File)((Iterator)localObject2).next();
      if (i != 0) {
        i = 0;
      }
      for (;;)
      {
        ((StringBuilder)localObject1).append(((File)localObject3).getAbsolutePath());
        break;
        ((StringBuilder)localObject1).append(File.pathSeparator);
      }
    }
    return new ObbClassLoader(paramApplication.getClass().getName(), localStringBuilder.toString(), ((StringBuilder)localObject1).toString(), localClassLoader);
  }
  
  protected Class<?> findClass(String paramString)
  {
    Object localObject2;
    if (paramString.equals(this.mAppClassName)) {
      localObject2 = this.mAppClassLoader.loadClass(paramString);
    }
    for (;;)
    {
      return localObject2;
      if ((paramString.startsWith("com.tencent.tinker.loader.")) && (!paramString.startsWith("com.tencent.tinker.loader.shareutil."))) {
        return this.mAppClassLoader.loadClass(paramString);
      }
      try
      {
        Class localClass = super.findClass(paramString);
        localObject2 = localClass;
        if (localClass != null) {
          continue;
        }
        return this.mAppClassLoader.loadClass(paramString);
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        for (;;)
        {
          Object localObject1 = null;
        }
      }
    }
  }
  
  public URL getResource(String paramString)
  {
    Object localObject = Object.class.getClassLoader().getResource(paramString);
    if (localObject != null) {}
    URL localURL;
    do
    {
      return localObject;
      localURL = findResource(paramString);
      localObject = localURL;
    } while (localURL != null);
    return this.mAppClassLoader.getResource(paramString);
  }
  
  public Enumeration<URL> getResources(String paramString)
  {
    return new CompoundEnumeration(new Enumeration[] { Object.class.getClassLoader().getResources(paramString), findResources(paramString), this.mAppClassLoader.getResources(paramString) });
  }
  
  class CompoundEnumeration<E>
    implements Enumeration<E>
  {
    private Enumeration<E>[] enums;
    private int index = 0;
    
    public CompoundEnumeration()
    {
      Object localObject;
      this.enums = localObject;
    }
    
    public boolean hasMoreElements()
    {
      while (this.index < this.enums.length)
      {
        if ((this.enums[this.index] != null) && (this.enums[this.index].hasMoreElements())) {
          return true;
        }
        this.index += 1;
      }
      return false;
    }
    
    public E nextElement()
    {
      if (!hasMoreElements()) {
        throw new NoSuchElementException();
      }
      return this.enums[this.index].nextElement();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.obb.loader.ObbClassLoader
 * JD-Core Version:    0.7.0.1
 */
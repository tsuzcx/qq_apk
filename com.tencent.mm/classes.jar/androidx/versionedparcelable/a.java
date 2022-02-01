package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class a
{
  protected final androidx.b.a<String, Method> ava;
  protected final androidx.b.a<String, Method> avb;
  protected final androidx.b.a<String, Class> avc;
  
  public a(androidx.b.a<String, Method> parama1, androidx.b.a<String, Method> parama2, androidx.b.a<String, Class> parama)
  {
    this.ava = parama1;
    this.avb = parama2;
    this.avc = parama;
  }
  
  private <T extends c> T a(String paramString, a parama)
  {
    try
    {
      Method localMethod2 = (Method)this.ava.get(paramString);
      Method localMethod1 = localMethod2;
      if (localMethod2 == null)
      {
        System.currentTimeMillis();
        localMethod1 = Class.forName(paramString, true, a.class.getClassLoader()).getDeclaredMethod("read", new Class[] { a.class });
        this.ava.put(paramString, localMethod1);
      }
      paramString = (c)localMethod1.invoke(null, new Object[] { parama });
      return paramString;
    }
    catch (IllegalAccessException paramString)
    {
      throw new RuntimeException("VersionedParcel encountered IllegalAccessException", paramString);
    }
    catch (InvocationTargetException paramString)
    {
      if ((paramString.getCause() instanceof RuntimeException)) {
        throw ((RuntimeException)paramString.getCause());
      }
      throw new RuntimeException("VersionedParcel encountered InvocationTargetException", paramString);
    }
    catch (NoSuchMethodException paramString)
    {
      throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", paramString);
    }
    catch (ClassNotFoundException paramString)
    {
      throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", paramString);
    }
  }
  
  private <T extends c> void a(T paramT, a parama)
  {
    try
    {
      k(paramT.getClass()).invoke(null, new Object[] { paramT, parama });
      return;
    }
    catch (IllegalAccessException paramT)
    {
      throw new RuntimeException("VersionedParcel encountered IllegalAccessException", paramT);
    }
    catch (InvocationTargetException paramT)
    {
      if ((paramT.getCause() instanceof RuntimeException)) {
        throw ((RuntimeException)paramT.getCause());
      }
      throw new RuntimeException("VersionedParcel encountered InvocationTargetException", paramT);
    }
    catch (NoSuchMethodException paramT)
    {
      throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", paramT);
    }
    catch (ClassNotFoundException paramT)
    {
      throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", paramT);
    }
  }
  
  private void c(c paramc)
  {
    try
    {
      Class localClass = l(paramc.getClass());
      T(localClass.getName());
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new RuntimeException(paramc.getClass().getSimpleName() + " does not have a Parcelizer", localClassNotFoundException);
    }
  }
  
  private Method k(Class paramClass)
  {
    Method localMethod = (Method)this.avb.get(paramClass.getName());
    Object localObject = localMethod;
    if (localMethod == null)
    {
      localObject = l(paramClass);
      System.currentTimeMillis();
      localObject = ((Class)localObject).getDeclaredMethod("write", new Class[] { paramClass, a.class });
      this.avb.put(paramClass.getName(), localObject);
    }
    return localObject;
  }
  
  private Class l(Class<? extends c> paramClass)
  {
    Class localClass2 = (Class)this.avc.get(paramClass.getName());
    Class localClass1 = localClass2;
    if (localClass2 == null)
    {
      localClass1 = Class.forName(String.format("%s.%sParcelizer", new Object[] { paramClass.getPackage().getName(), paramClass.getSimpleName() }), false, paramClass.getClassLoader());
      this.avc.put(paramClass.getName(), localClass1);
    }
    return localClass1;
  }
  
  protected abstract void T(String paramString);
  
  public final void U(String paramString)
  {
    dD(7);
    T(paramString);
  }
  
  public final String V(String paramString)
  {
    if (!dC(7)) {
      return paramString;
    }
    return readString();
  }
  
  protected abstract void a(Parcelable paramParcelable);
  
  public final void a(Parcelable paramParcelable, int paramInt)
  {
    dD(paramInt);
    a(paramParcelable);
  }
  
  public final void a(c paramc)
  {
    dD(1);
    b(paramc);
  }
  
  protected abstract void aF(boolean paramBoolean);
  
  public final void aY(int paramInt1, int paramInt2)
  {
    dD(paramInt2);
    bV(paramInt1);
  }
  
  public final int aZ(int paramInt1, int paramInt2)
  {
    if (!dC(paramInt2)) {
      return paramInt1;
    }
    return readInt();
  }
  
  public final <T extends Parcelable> T b(T paramT, int paramInt)
  {
    if (!dC(paramInt)) {
      return paramT;
    }
    return nI();
  }
  
  protected final void b(c paramc)
  {
    if (paramc == null)
    {
      T(null);
      return;
    }
    c(paramc);
    a locala = nF();
    a(paramc, locala);
    locala.nE();
  }
  
  protected abstract void bV(int paramInt);
  
  public final void c(CharSequence paramCharSequence, int paramInt)
  {
    dD(paramInt);
    v(paramCharSequence);
  }
  
  public final void c(boolean paramBoolean, int paramInt)
  {
    dD(paramInt);
    aF(paramBoolean);
  }
  
  public final <T extends c> T d(T paramT)
  {
    if (!dC(1)) {
      return paramT;
    }
    return nJ();
  }
  
  public final CharSequence d(CharSequence paramCharSequence, int paramInt)
  {
    if (!dC(paramInt)) {
      return paramCharSequence;
    }
    return nH();
  }
  
  public final boolean d(boolean paramBoolean, int paramInt)
  {
    if (!dC(paramInt)) {
      return paramBoolean;
    }
    return readBoolean();
  }
  
  protected abstract boolean dC(int paramInt);
  
  protected abstract void dD(int paramInt);
  
  protected abstract void i(byte[] paramArrayOfByte);
  
  public final void j(byte[] paramArrayOfByte)
  {
    dD(2);
    i(paramArrayOfByte);
  }
  
  public final byte[] k(byte[] paramArrayOfByte)
  {
    if (!dC(2)) {
      return paramArrayOfByte;
    }
    return nG();
  }
  
  protected abstract void nE();
  
  protected abstract a nF();
  
  protected abstract byte[] nG();
  
  protected abstract CharSequence nH();
  
  protected abstract <T extends Parcelable> T nI();
  
  protected final <T extends c> T nJ()
  {
    String str = readString();
    if (str == null) {
      return null;
    }
    return a(str, nF());
  }
  
  protected abstract boolean readBoolean();
  
  protected abstract int readInt();
  
  protected abstract String readString();
  
  protected abstract void v(CharSequence paramCharSequence);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.versionedparcelable.a
 * JD-Core Version:    0.7.0.1
 */
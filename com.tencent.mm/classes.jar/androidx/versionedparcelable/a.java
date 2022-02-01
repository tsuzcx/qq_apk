package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class a
{
  protected final androidx.b.a<String, Method> cjx;
  protected final androidx.b.a<String, Method> cjy;
  protected final androidx.b.a<String, Class> cjz;
  
  public a(androidx.b.a<String, Method> parama1, androidx.b.a<String, Method> parama2, androidx.b.a<String, Class> parama)
  {
    this.cjx = parama1;
    this.cjy = parama2;
    this.cjz = parama;
  }
  
  public static boolean Mi()
  {
    return false;
  }
  
  private <T extends c> T a(String paramString, a parama)
  {
    try
    {
      Method localMethod2 = (Method)this.cjx.get(paramString);
      Method localMethod1 = localMethod2;
      if (localMethod2 == null)
      {
        System.currentTimeMillis();
        localMethod1 = Class.forName(paramString, true, a.class.getClassLoader()).getDeclaredMethod("read", new Class[] { a.class });
        this.cjx.put(paramString, localMethod1);
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
      t(paramT.getClass()).invoke(null, new Object[] { paramT, parama });
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
      Class localClass = u(paramc.getClass());
      aU(localClass.getName());
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new RuntimeException(paramc.getClass().getSimpleName() + " does not have a Parcelizer", localClassNotFoundException);
    }
  }
  
  private Method t(Class paramClass)
  {
    Method localMethod = (Method)this.cjy.get(paramClass.getName());
    Object localObject = localMethod;
    if (localMethod == null)
    {
      localObject = u(paramClass);
      System.currentTimeMillis();
      localObject = ((Class)localObject).getDeclaredMethod("write", new Class[] { paramClass, a.class });
      this.cjy.put(paramClass.getName(), localObject);
    }
    return localObject;
  }
  
  private Class u(Class<? extends c> paramClass)
  {
    Class localClass2 = (Class)this.cjz.get(paramClass.getName());
    Class localClass1 = localClass2;
    if (localClass2 == null)
    {
      localClass1 = Class.forName(String.format("%s.%sParcelizer", new Object[] { paramClass.getPackage().getName(), paramClass.getSimpleName() }), false, paramClass.getClassLoader());
      this.cjz.put(paramClass.getName(), localClass1);
    }
    return localClass1;
  }
  
  protected abstract void A(CharSequence paramCharSequence);
  
  protected abstract void Mj();
  
  protected abstract a Mk();
  
  protected abstract byte[] Ml();
  
  protected abstract CharSequence Mm();
  
  protected abstract <T extends Parcelable> T Mn();
  
  protected final <T extends c> T Mo()
  {
    String str = readString();
    if (str == null) {
      return null;
    }
    return a(str, Mk());
  }
  
  public final void a(Parcelable paramParcelable, int paramInt)
  {
    gN(paramInt);
    b(paramParcelable);
  }
  
  public final void a(c paramc)
  {
    gN(1);
    b(paramc);
  }
  
  protected abstract void aU(String paramString);
  
  protected abstract void aX(int paramInt);
  
  public final <T extends Parcelable> T b(T paramT, int paramInt)
  {
    if (!gM(paramInt)) {
      return paramT;
    }
    return Mn();
  }
  
  protected abstract void b(Parcelable paramParcelable);
  
  protected final void b(c paramc)
  {
    if (paramc == null)
    {
      aU(null);
      return;
    }
    c(paramc);
    a locala = Mk();
    a(paramc, locala);
    locala.Mj();
  }
  
  public final void bS(int paramInt1, int paramInt2)
  {
    gN(paramInt2);
    aX(paramInt1);
  }
  
  public final int bT(int paramInt1, int paramInt2)
  {
    if (!gM(paramInt2)) {
      return paramInt1;
    }
    return readInt();
  }
  
  protected abstract void bn(boolean paramBoolean);
  
  public final void c(CharSequence paramCharSequence, int paramInt)
  {
    gN(paramInt);
    A(paramCharSequence);
  }
  
  public final void c(boolean paramBoolean, int paramInt)
  {
    gN(paramInt);
    bn(paramBoolean);
  }
  
  public final <T extends c> T d(T paramT)
  {
    if (!gM(1)) {
      return paramT;
    }
    return Mo();
  }
  
  public final CharSequence d(CharSequence paramCharSequence, int paramInt)
  {
    if (!gM(paramInt)) {
      return paramCharSequence;
    }
    return Mm();
  }
  
  public final boolean d(boolean paramBoolean, int paramInt)
  {
    if (!gM(paramInt)) {
      return paramBoolean;
    }
    return readBoolean();
  }
  
  protected abstract boolean gM(int paramInt);
  
  protected abstract void gN(int paramInt);
  
  public final void l(String paramString, int paramInt)
  {
    gN(paramInt);
    aU(paramString);
  }
  
  public final String m(String paramString, int paramInt)
  {
    if (!gM(paramInt)) {
      return paramString;
    }
    return readString();
  }
  
  protected abstract void o(byte[] paramArrayOfByte);
  
  public final void p(byte[] paramArrayOfByte)
  {
    gN(2);
    o(paramArrayOfByte);
  }
  
  public final byte[] q(byte[] paramArrayOfByte)
  {
    if (!gM(2)) {
      return paramArrayOfByte;
    }
    return Ml();
  }
  
  protected abstract boolean readBoolean();
  
  protected abstract int readInt();
  
  protected abstract String readString();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.versionedparcelable.a
 * JD-Core Version:    0.7.0.1
 */
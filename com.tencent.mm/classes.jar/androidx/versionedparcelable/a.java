package androidx.versionedparcelable;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public abstract class a
{
  private static <T extends c> T a(String paramString, a parama)
  {
    try
    {
      paramString = (c)Class.forName(paramString, true, a.class.getClassLoader()).getDeclaredMethod("read", new Class[] { a.class }).invoke(null, new Object[] { parama });
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
  
  private static <T extends c> void a(T paramT, a parama)
  {
    try
    {
      i(paramT.getClass()).getDeclaredMethod("write", new Class[] { paramT.getClass(), a.class }).invoke(null, new Object[] { paramT, parama });
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
      Class localClass = i(paramc.getClass());
      writeString(localClass.getName());
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      throw new RuntimeException(paramc.getClass().getSimpleName() + " does not have a Parcelizer", localClassNotFoundException);
    }
  }
  
  private static Class i(Class<? extends c> paramClass)
  {
    return Class.forName(String.format("%s.%sParcelizer", new Object[] { paramClass.getPackage().getName(), paramClass.getSimpleName() }), false, paramClass.getClassLoader());
  }
  
  public final void L(String paramString)
  {
    dj(7);
    writeString(paramString);
  }
  
  public final String M(String paramString)
  {
    if (!di(7)) {
      return paramString;
    }
    return readString();
  }
  
  public final <T extends Parcelable> T a(T paramT, int paramInt)
  {
    if (!di(paramInt)) {
      return paramT;
    }
    return nx();
  }
  
  protected abstract void a(Parcelable paramParcelable);
  
  public final void a(c paramc)
  {
    dj(1);
    b(paramc);
  }
  
  public final void aS(int paramInt1, int paramInt2)
  {
    dj(paramInt2);
    writeInt(paramInt1);
  }
  
  public final int aT(int paramInt1, int paramInt2)
  {
    if (!di(paramInt2)) {
      return paramInt1;
    }
    return readInt();
  }
  
  protected final void b(c paramc)
  {
    if (paramc == null)
    {
      writeString(null);
      return;
    }
    c(paramc);
    a locala = nv();
    a(paramc, locala);
    locala.nu();
  }
  
  public final <T extends c> T d(T paramT)
  {
    if (!di(1)) {
      return paramT;
    }
    return ny();
  }
  
  protected abstract boolean di(int paramInt);
  
  protected abstract void dj(int paramInt);
  
  public final void i(byte[] paramArrayOfByte)
  {
    dj(2);
    writeByteArray(paramArrayOfByte);
  }
  
  public final byte[] j(byte[] paramArrayOfByte)
  {
    if (!di(2)) {
      return paramArrayOfByte;
    }
    return nw();
  }
  
  protected abstract void nu();
  
  protected abstract a nv();
  
  protected abstract byte[] nw();
  
  protected abstract <T extends Parcelable> T nx();
  
  protected final <T extends c> T ny()
  {
    String str = readString();
    if (str == null) {
      return null;
    }
    return a(str, nv());
  }
  
  protected abstract int readInt();
  
  protected abstract String readString();
  
  protected abstract void writeByteArray(byte[] paramArrayOfByte);
  
  protected abstract void writeInt(int paramInt);
  
  public final void writeParcelable(Parcelable paramParcelable, int paramInt)
  {
    dj(paramInt);
    a(paramParcelable);
  }
  
  protected abstract void writeString(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.versionedparcelable.a
 * JD-Core Version:    0.7.0.1
 */
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
  
  public final void K(String paramString)
  {
    dk(7);
    writeString(paramString);
  }
  
  public final String L(String paramString)
  {
    if (!dj(7)) {
      return paramString;
    }
    return readString();
  }
  
  public final <T extends Parcelable> T a(T paramT, int paramInt)
  {
    if (!dj(paramInt)) {
      return paramT;
    }
    return mV();
  }
  
  protected abstract void a(Parcelable paramParcelable);
  
  public final void a(c paramc)
  {
    dk(1);
    b(paramc);
  }
  
  public final void aR(int paramInt1, int paramInt2)
  {
    dk(paramInt2);
    writeInt(paramInt1);
  }
  
  public final int aS(int paramInt1, int paramInt2)
  {
    if (!dj(paramInt2)) {
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
    a locala = mT();
    a(paramc, locala);
    locala.mS();
  }
  
  public final <T extends c> T d(T paramT)
  {
    if (!dj(1)) {
      return paramT;
    }
    return mW();
  }
  
  protected abstract boolean dj(int paramInt);
  
  protected abstract void dk(int paramInt);
  
  public final void i(byte[] paramArrayOfByte)
  {
    dk(2);
    writeByteArray(paramArrayOfByte);
  }
  
  public final byte[] j(byte[] paramArrayOfByte)
  {
    if (!dj(2)) {
      return paramArrayOfByte;
    }
    return mU();
  }
  
  protected abstract void mS();
  
  protected abstract a mT();
  
  protected abstract byte[] mU();
  
  protected abstract <T extends Parcelable> T mV();
  
  protected final <T extends c> T mW()
  {
    String str = readString();
    if (str == null) {
      return null;
    }
    return a(str, mT());
  }
  
  protected abstract int readInt();
  
  protected abstract String readString();
  
  protected abstract void writeByteArray(byte[] paramArrayOfByte);
  
  protected abstract void writeInt(int paramInt);
  
  public final void writeParcelable(Parcelable paramParcelable, int paramInt)
  {
    dk(paramInt);
    a(paramParcelable);
  }
  
  protected abstract void writeString(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     androidx.versionedparcelable.a
 * JD-Core Version:    0.7.0.1
 */
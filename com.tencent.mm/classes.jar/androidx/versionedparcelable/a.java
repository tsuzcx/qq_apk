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
  
  private static Class l(Class<? extends c> paramClass)
  {
    return Class.forName(String.format("%s.%sParcelizer", new Object[] { paramClass.getPackage().getName(), paramClass.getSimpleName() }), false, paramClass.getClassLoader());
  }
  
  public final void W(String paramString)
  {
    cN(7);
    writeString(paramString);
  }
  
  public final String X(String paramString)
  {
    if (!cM(7)) {
      return paramString;
    }
    return readString();
  }
  
  public final <T extends Parcelable> T a(T paramT, int paramInt)
  {
    if (!cM(paramInt)) {
      return paramT;
    }
    return lj();
  }
  
  protected abstract void a(Parcelable paramParcelable);
  
  /* Error */
  protected final void a(c paramc)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +9 -> 10
    //   4: aload_0
    //   5: aconst_null
    //   6: invokevirtual 95	androidx/versionedparcelable/a:writeString	(Ljava/lang/String;)V
    //   9: return
    //   10: aload_1
    //   11: invokevirtual 116	java/lang/Object:getClass	()Ljava/lang/Class;
    //   14: invokestatic 118	androidx/versionedparcelable/a:l	(Ljava/lang/Class;)Ljava/lang/Class;
    //   17: astore_2
    //   18: aload_0
    //   19: aload_2
    //   20: invokevirtual 119	java/lang/Class:getName	()Ljava/lang/String;
    //   23: invokevirtual 95	androidx/versionedparcelable/a:writeString	(Ljava/lang/String;)V
    //   26: aload_0
    //   27: invokevirtual 123	androidx/versionedparcelable/a:lh	()Landroidx/versionedparcelable/a;
    //   30: astore_2
    //   31: aload_1
    //   32: invokevirtual 116	java/lang/Object:getClass	()Ljava/lang/Class;
    //   35: invokestatic 118	androidx/versionedparcelable/a:l	(Ljava/lang/Class;)Ljava/lang/Class;
    //   38: ldc 125
    //   40: iconst_2
    //   41: anewarray 21	java/lang/Class
    //   44: dup
    //   45: iconst_0
    //   46: aload_1
    //   47: invokevirtual 116	java/lang/Object:getClass	()Ljava/lang/Class;
    //   50: aastore
    //   51: dup
    //   52: iconst_1
    //   53: ldc 2
    //   55: aastore
    //   56: invokevirtual 35	java/lang/Class:getDeclaredMethod	(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    //   59: aconst_null
    //   60: iconst_2
    //   61: anewarray 4	java/lang/Object
    //   64: dup
    //   65: iconst_0
    //   66: aload_1
    //   67: aastore
    //   68: dup
    //   69: iconst_1
    //   70: aload_2
    //   71: aastore
    //   72: invokevirtual 41	java/lang/reflect/Method:invoke	(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    //   75: pop
    //   76: aload_2
    //   77: invokevirtual 128	androidx/versionedparcelable/a:lg	()V
    //   80: return
    //   81: astore_2
    //   82: new 45	java/lang/RuntimeException
    //   85: dup
    //   86: new 130	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 131	java/lang/StringBuilder:<init>	()V
    //   93: aload_1
    //   94: invokevirtual 116	java/lang/Object:getClass	()Ljava/lang/Class;
    //   97: invokevirtual 79	java/lang/Class:getSimpleName	()Ljava/lang/String;
    //   100: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc 137
    //   105: invokevirtual 135	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 140	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: aload_2
    //   112: invokespecial 50	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   115: athrow
    //   116: astore_1
    //   117: new 45	java/lang/RuntimeException
    //   120: dup
    //   121: ldc 47
    //   123: aload_1
    //   124: invokespecial 50	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   127: athrow
    //   128: astore_1
    //   129: aload_1
    //   130: invokevirtual 54	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   133: instanceof 45
    //   136: ifeq +11 -> 147
    //   139: aload_1
    //   140: invokevirtual 54	java/lang/reflect/InvocationTargetException:getCause	()Ljava/lang/Throwable;
    //   143: checkcast 45	java/lang/RuntimeException
    //   146: athrow
    //   147: new 45	java/lang/RuntimeException
    //   150: dup
    //   151: ldc 56
    //   153: aload_1
    //   154: invokespecial 50	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   157: athrow
    //   158: astore_1
    //   159: new 45	java/lang/RuntimeException
    //   162: dup
    //   163: ldc 58
    //   165: aload_1
    //   166: invokespecial 50	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   169: athrow
    //   170: astore_1
    //   171: new 45	java/lang/RuntimeException
    //   174: dup
    //   175: ldc 60
    //   177: aload_1
    //   178: invokespecial 50	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   181: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	182	0	this	a
    //   0	182	1	paramc	c
    //   17	60	2	localObject	Object
    //   81	31	2	localClassNotFoundException	ClassNotFoundException
    // Exception table:
    //   from	to	target	type
    //   10	18	81	java/lang/ClassNotFoundException
    //   31	76	116	java/lang/IllegalAccessException
    //   31	76	128	java/lang/reflect/InvocationTargetException
    //   31	76	158	java/lang/NoSuchMethodException
    //   31	76	170	java/lang/ClassNotFoundException
  }
  
  public final void aO(int paramInt1, int paramInt2)
  {
    cN(paramInt2);
    writeInt(paramInt1);
  }
  
  public final int aP(int paramInt1, int paramInt2)
  {
    if (!cM(paramInt2)) {
      return paramInt1;
    }
    return readInt();
  }
  
  protected abstract boolean cM(int paramInt);
  
  protected abstract void cN(int paramInt);
  
  public final void g(byte[] paramArrayOfByte)
  {
    cN(2);
    writeByteArray(paramArrayOfByte);
  }
  
  public final byte[] h(byte[] paramArrayOfByte)
  {
    if (!cM(2)) {
      return paramArrayOfByte;
    }
    return li();
  }
  
  protected abstract void lg();
  
  protected abstract a lh();
  
  protected abstract byte[] li();
  
  protected abstract <T extends Parcelable> T lj();
  
  protected final <T extends c> T lk()
  {
    String str = readString();
    if (str == null) {
      return null;
    }
    return a(str, lh());
  }
  
  protected abstract int readInt();
  
  protected abstract String readString();
  
  protected abstract void writeByteArray(byte[] paramArrayOfByte);
  
  protected abstract void writeInt(int paramInt);
  
  public final void writeParcelable(Parcelable paramParcelable, int paramInt)
  {
    cN(paramInt);
    a(paramParcelable);
  }
  
  protected abstract void writeString(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.versionedparcelable.a
 * JD-Core Version:    0.7.0.1
 */
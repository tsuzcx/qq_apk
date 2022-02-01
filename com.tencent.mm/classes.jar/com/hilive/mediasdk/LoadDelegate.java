package com.hilive.mediasdk;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class LoadDelegate
{
  private static final String TAG = "[hilive][java]";
  private static ILoadLibrary sInstance;
  private static boolean sLibraryLoaded;
  
  static
  {
    AppMethodBeat.i(73591);
    sLibraryLoaded = false;
    sInstance = new ILoadLibrary()
    {
      private byte _hellAccFlag_;
      
      /* Error */
      private boolean loadSo(String paramAnonymousString)
      {
        // Byte code:
        //   0: ldc 24
        //   2: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
        //   5: iconst_0
        //   6: istore_2
        //   7: iload_2
        //   8: iconst_3
        //   9: if_icmpge +298 -> 307
        //   12: new 32	com/tencent/mm/hellhoundlib/b/a
        //   15: dup
        //   16: invokespecial 33	com/tencent/mm/hellhoundlib/b/a:<init>	()V
        //   19: aload_1
        //   20: invokevirtual 37	com/tencent/mm/hellhoundlib/b/a:cG	(Ljava/lang/Object;)Lcom/tencent/mm/hellhoundlib/b/a;
        //   23: astore_3
        //   24: new 4	java/lang/Object
        //   27: dup
        //   28: invokespecial 14	java/lang/Object:<init>	()V
        //   31: astore 4
        //   33: aload 4
        //   35: aload_3
        //   36: invokevirtual 41	com/tencent/mm/hellhoundlib/b/a:aYi	()[Ljava/lang/Object;
        //   39: ldc 42
        //   41: ldc 43
        //   43: ldc 44
        //   45: ldc 46
        //   47: ldc 48
        //   49: ldc 50
        //   51: invokestatic 56	com/tencent/mm/hellhoundlib/a/a:b	(Ljava/lang/Object;[Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   54: aload_3
        //   55: iconst_0
        //   56: invokevirtual 60	com/tencent/mm/hellhoundlib/b/a:sb	(I)Ljava/lang/Object;
        //   59: checkcast 62	java/lang/String
        //   62: invokestatic 66	java/lang/System:loadLibrary	(Ljava/lang/String;)V
        //   65: aload 4
        //   67: ldc 42
        //   69: ldc 43
        //   71: ldc 44
        //   73: ldc 46
        //   75: ldc 48
        //   77: ldc 50
        //   79: invokestatic 70	com/tencent/mm/hellhoundlib/a/a:c	(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
        //   82: ldc 72
        //   84: new 74	java/lang/StringBuilder
        //   87: dup
        //   88: ldc 76
        //   90: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   93: aload_1
        //   94: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   97: ldc 84
        //   99: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   102: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   105: iconst_0
        //   106: anewarray 4	java/lang/Object
        //   109: invokestatic 93	com/hilive/mediasdk/LogDelegate:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   112: ldc 24
        //   114: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   117: iconst_1
        //   118: ireturn
        //   119: astore_3
        //   120: aload_3
        //   121: invokevirtual 99	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
        //   124: ifnonnull +47 -> 171
        //   127: ldc 101
        //   129: astore_3
        //   130: ldc 72
        //   132: new 74	java/lang/StringBuilder
        //   135: dup
        //   136: ldc 76
        //   138: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   141: aload_1
        //   142: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   145: ldc 103
        //   147: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   150: aload_3
        //   151: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   154: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   157: iconst_0
        //   158: anewarray 4	java/lang/Object
        //   161: invokestatic 106	com/hilive/mediasdk/LogDelegate:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   164: iload_2
        //   165: iconst_1
        //   166: iadd
        //   167: istore_2
        //   168: goto -161 -> 7
        //   171: aload_3
        //   172: invokevirtual 99	java/lang/UnsatisfiedLinkError:getMessage	()Ljava/lang/String;
        //   175: astore_3
        //   176: goto -46 -> 130
        //   179: astore_3
        //   180: aload_3
        //   181: invokevirtual 107	java/lang/SecurityException:getMessage	()Ljava/lang/String;
        //   184: ifnonnull +43 -> 227
        //   187: ldc 101
        //   189: astore_3
        //   190: ldc 72
        //   192: new 74	java/lang/StringBuilder
        //   195: dup
        //   196: ldc 76
        //   198: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   201: aload_1
        //   202: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   205: ldc 109
        //   207: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   210: aload_3
        //   211: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   214: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   217: iconst_0
        //   218: anewarray 4	java/lang/Object
        //   221: invokestatic 106	com/hilive/mediasdk/LogDelegate:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   224: goto -60 -> 164
        //   227: aload_3
        //   228: invokevirtual 107	java/lang/SecurityException:getMessage	()Ljava/lang/String;
        //   231: astore_3
        //   232: goto -42 -> 190
        //   235: astore_3
        //   236: aload_3
        //   237: invokevirtual 110	java/lang/NullPointerException:getMessage	()Ljava/lang/String;
        //   240: ifnonnull +43 -> 283
        //   243: ldc 101
        //   245: astore_3
        //   246: ldc 72
        //   248: new 74	java/lang/StringBuilder
        //   251: dup
        //   252: ldc 76
        //   254: invokespecial 78	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
        //   257: aload_1
        //   258: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   261: ldc 112
        //   263: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   266: aload_3
        //   267: invokevirtual 82	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   270: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   273: iconst_0
        //   274: anewarray 4	java/lang/Object
        //   277: invokestatic 106	com/hilive/mediasdk/LogDelegate:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
        //   280: goto -116 -> 164
        //   283: aload_3
        //   284: invokevirtual 110	java/lang/NullPointerException:getMessage	()Ljava/lang/String;
        //   287: astore_3
        //   288: goto -42 -> 246
        //   291: astore_3
        //   292: ldc 72
        //   294: aload_3
        //   295: ldc 43
        //   297: iconst_0
        //   298: anewarray 4	java/lang/Object
        //   301: invokestatic 116	com/hilive/mediasdk/LogDelegate:printStackTrace	(Ljava/lang/String;Ljava/lang/Throwable;Ljava/lang/String;[Ljava/lang/Object;)V
        //   304: goto -140 -> 164
        //   307: ldc 24
        //   309: invokestatic 96	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
        //   312: iconst_0
        //   313: ireturn
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	314	0	this	1
        //   0	314	1	paramAnonymousString	String
        //   6	162	2	i	int
        //   23	32	3	locala	com.tencent.mm.hellhoundlib.b.a
        //   119	2	3	localUnsatisfiedLinkError	java.lang.UnsatisfiedLinkError
        //   129	47	3	str1	String
        //   179	2	3	localSecurityException	java.lang.SecurityException
        //   189	43	3	str2	String
        //   235	2	3	localNullPointerException	java.lang.NullPointerException
        //   245	43	3	str3	String
        //   291	4	3	localThrowable	java.lang.Throwable
        //   31	35	4	localObject	Object
        // Exception table:
        //   from	to	target	type
        //   12	112	119	java/lang/UnsatisfiedLinkError
        //   12	112	179	java/lang/SecurityException
        //   12	112	235	java/lang/NullPointerException
        //   12	112	291	finally
      }
      
      public void loadLibrary(String paramAnonymousString)
      {
        AppMethodBeat.i(73586);
        loadSo(paramAnonymousString);
        AppMethodBeat.o(73586);
      }
      
      public void loadLibrary(String paramAnonymousString, ClassLoader paramAnonymousClassLoader) {}
    };
    AppMethodBeat.o(73591);
  }
  
  public static void loadLibraries()
  {
    AppMethodBeat.i(73590);
    if (sLibraryLoaded)
    {
      AppMethodBeat.o(73590);
      return;
    }
    sInstance.loadLibrary("c++_shared");
    sInstance.loadLibrary("mmavmedia");
    sInstance.loadLibrary("mmmediasdk");
    sInstance.loadLibrary("mmmediasdkjni");
    AppMethodBeat.o(73590);
  }
  
  public static void loadLibrary(String paramString)
  {
    AppMethodBeat.i(73588);
    sInstance.loadLibrary(paramString);
    AppMethodBeat.o(73588);
  }
  
  public static void loadLibrary(String paramString, ClassLoader paramClassLoader)
  {
    AppMethodBeat.i(73589);
    sInstance.loadLibrary(paramString, paramClassLoader);
    AppMethodBeat.o(73589);
  }
  
  public static void setInstance(ILoadLibrary paramILoadLibrary)
  {
    if (paramILoadLibrary != null) {
      sInstance = paramILoadLibrary;
    }
  }
  
  public static abstract interface ILoadLibrary
  {
    public abstract void loadLibrary(String paramString);
    
    public abstract void loadLibrary(String paramString, ClassLoader paramClassLoader);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.hilive.mediasdk.LoadDelegate
 * JD-Core Version:    0.7.0.1
 */
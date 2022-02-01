package androidx.startup;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class InitializationProvider
  extends ContentProvider
{
  public final int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(192409);
    paramUri = new IllegalStateException("Not allowed.");
    AppMethodBeat.o(192409);
    throw paramUri;
  }
  
  public final String getType(Uri paramUri)
  {
    AppMethodBeat.i(192389);
    paramUri = new IllegalStateException("Not allowed.");
    AppMethodBeat.o(192389);
    throw paramUri;
  }
  
  public final Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    AppMethodBeat.i(192401);
    paramUri = new IllegalStateException("Not allowed.");
    AppMethodBeat.o(192401);
    throw paramUri;
  }
  
  /* Error */
  public final boolean onCreate()
  {
    // Byte code:
    //   0: ldc 41
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: invokevirtual 45	androidx/startup/InitializationProvider:getContext	()Landroid/content/Context;
    //   9: astore_1
    //   10: aload_1
    //   11: ifnull +201 -> 212
    //   14: aload_1
    //   15: invokestatic 51	androidx/startup/a:au	(Landroid/content/Context;)Landroidx/startup/a;
    //   18: astore_1
    //   19: ldc 53
    //   21: invokestatic 58	androidx/k/a:ax	(Ljava/lang/String;)V
    //   24: new 60	android/content/ComponentName
    //   27: dup
    //   28: aload_1
    //   29: getfield 64	androidx/startup/a:mContext	Landroid/content/Context;
    //   32: invokevirtual 70	android/content/Context:getPackageName	()Ljava/lang/String;
    //   35: ldc 2
    //   37: invokevirtual 75	java/lang/Class:getName	()Ljava/lang/String;
    //   40: invokespecial 78	android/content/ComponentName:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   43: astore_2
    //   44: aload_1
    //   45: getfield 64	androidx/startup/a:mContext	Landroid/content/Context;
    //   48: invokevirtual 82	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
    //   51: aload_2
    //   52: sipush 128
    //   55: invokevirtual 88	android/content/pm/PackageManager:getProviderInfo	(Landroid/content/ComponentName;I)Landroid/content/pm/ProviderInfo;
    //   58: getfield 94	android/content/pm/ProviderInfo:metaData	Landroid/os/Bundle;
    //   61: astore_2
    //   62: aload_1
    //   63: getfield 64	androidx/startup/a:mContext	Landroid/content/Context;
    //   66: getstatic 100	androidx/startup/c$a:ccJ	I
    //   69: invokevirtual 104	android/content/Context:getString	(I)Ljava/lang/String;
    //   72: astore_3
    //   73: aload_2
    //   74: ifnull +128 -> 202
    //   77: new 106	java/util/HashSet
    //   80: dup
    //   81: invokespecial 107	java/util/HashSet:<init>	()V
    //   84: astore 4
    //   86: aload_2
    //   87: invokevirtual 113	android/os/Bundle:keySet	()Ljava/util/Set;
    //   90: invokeinterface 119 1 0
    //   95: astore 5
    //   97: aload 5
    //   99: invokeinterface 124 1 0
    //   104: ifeq +98 -> 202
    //   107: aload 5
    //   109: invokeinterface 128 1 0
    //   114: checkcast 130	java/lang/String
    //   117: astore 6
    //   119: aload_3
    //   120: aload_2
    //   121: aload 6
    //   123: aconst_null
    //   124: invokevirtual 133	android/os/Bundle:getString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   127: invokevirtual 137	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   130: ifeq -33 -> 97
    //   133: aload 6
    //   135: invokestatic 141	java/lang/Class:forName	(Ljava/lang/String;)Ljava/lang/Class;
    //   138: astore 6
    //   140: ldc 143
    //   142: aload 6
    //   144: invokevirtual 147	java/lang/Class:isAssignableFrom	(Ljava/lang/Class;)Z
    //   147: ifeq -50 -> 97
    //   150: aload_1
    //   151: getfield 151	androidx/startup/a:ccI	Ljava/util/Set;
    //   154: aload 6
    //   156: invokeinterface 154 2 0
    //   161: pop
    //   162: aload_1
    //   163: aload 6
    //   165: aload 4
    //   167: invokevirtual 158	androidx/startup/a:a	(Ljava/lang/Class;Ljava/util/Set;)Ljava/lang/Object;
    //   170: pop
    //   171: goto -74 -> 97
    //   174: astore_1
    //   175: new 160	androidx/startup/d
    //   178: dup
    //   179: aload_1
    //   180: invokespecial 163	androidx/startup/d:<init>	(Ljava/lang/Throwable;)V
    //   183: astore_1
    //   184: ldc 41
    //   186: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   189: aload_1
    //   190: athrow
    //   191: astore_1
    //   192: invokestatic 166	androidx/k/a:DS	()V
    //   195: ldc 41
    //   197: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   200: aload_1
    //   201: athrow
    //   202: invokestatic 166	androidx/k/a:DS	()V
    //   205: ldc 41
    //   207: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   210: iconst_1
    //   211: ireturn
    //   212: new 160	androidx/startup/d
    //   215: dup
    //   216: ldc 168
    //   218: invokespecial 169	androidx/startup/d:<init>	(Ljava/lang/String;)V
    //   221: astore_1
    //   222: ldc 41
    //   224: invokestatic 28	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   227: aload_1
    //   228: athrow
    //   229: astore_1
    //   230: goto -55 -> 175
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	233	0	this	InitializationProvider
    //   9	154	1	localObject1	java.lang.Object
    //   174	6	1	localNameNotFoundException	android.content.pm.PackageManager.NameNotFoundException
    //   183	7	1	locald1	d
    //   191	10	1	localObject2	java.lang.Object
    //   221	7	1	locald2	d
    //   229	1	1	localClassNotFoundException	java.lang.ClassNotFoundException
    //   43	78	2	localObject3	java.lang.Object
    //   72	48	3	str	String
    //   84	82	4	localHashSet	java.util.HashSet
    //   95	13	5	localIterator	java.util.Iterator
    //   117	47	6	localObject4	java.lang.Object
    // Exception table:
    //   from	to	target	type
    //   19	73	174	android/content/pm/PackageManager$NameNotFoundException
    //   77	97	174	android/content/pm/PackageManager$NameNotFoundException
    //   97	171	174	android/content/pm/PackageManager$NameNotFoundException
    //   19	73	191	finally
    //   77	97	191	finally
    //   97	171	191	finally
    //   175	191	191	finally
    //   19	73	229	java/lang/ClassNotFoundException
    //   77	97	229	java/lang/ClassNotFoundException
    //   97	171	229	java/lang/ClassNotFoundException
  }
  
  public final Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(192382);
    paramUri = new IllegalStateException("Not allowed.");
    AppMethodBeat.o(192382);
    throw paramUri;
  }
  
  public final int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    AppMethodBeat.i(192417);
    paramUri = new IllegalStateException("Not allowed.");
    AppMethodBeat.o(192417);
    throw paramUri;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.startup.InitializationProvider
 * JD-Core Version:    0.7.0.1
 */
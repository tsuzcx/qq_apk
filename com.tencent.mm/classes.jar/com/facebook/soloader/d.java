package com.facebook.soloader;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.StrictMode.ThreadPolicy;
import android.os.Trace;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public final class d
  extends o
{
  private static final Set<String> cCu;
  private final String cCv;
  private final File cCw;
  
  static
  {
    AppMethodBeat.i(208103);
    cCu = Collections.synchronizedSet(new HashSet());
    AppMethodBeat.o(208103);
  }
  
  public d(Context paramContext)
  {
    AppMethodBeat.i(208073);
    String str;
    int i;
    if (Build.VERSION.SDK_INT >= 14)
    {
      str = n.a.Qe();
      if (str == null) {
        break label106;
      }
      String[] arrayOfString = str.split(":");
      int j = arrayOfString.length;
      i = 0;
      label42:
      if (i >= j) {
        break label106;
      }
      str = arrayOfString[i];
      if (!str.contains(".apk!/")) {
        break label99;
      }
    }
    for (;;)
    {
      this.cCv = str;
      this.cCw = new File(paramContext.getApplicationInfo().sourceDir);
      AppMethodBeat.o(208073);
      return;
      str = null;
      break;
      label99:
      i += 1;
      break label42;
      label106:
      str = null;
    }
  }
  
  private static String[] a(String paramString, f paramf)
  {
    AppMethodBeat.i(208082);
    if (n.cCY) {
      a.e("SoLoader.getElfDependencies[", paramString, "]");
    }
    try
    {
      paramString = k.a(paramf);
      return paramString;
    }
    finally
    {
      if (n.cCY) {
        Trace.endSection();
      }
      AppMethodBeat.o(208082);
    }
  }
  
  /* Error */
  private void b(String paramString, int paramInt, StrictMode.ThreadPolicy paramThreadPolicy)
  {
    // Byte code:
    //   0: ldc 118
    //   2: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: new 120	java/util/zip/ZipFile
    //   8: dup
    //   9: aload_0
    //   10: getfield 86	com/facebook/soloader/d:cCw	Ljava/io/File;
    //   13: invokespecial 123	java/util/zip/ZipFile:<init>	(Ljava/io/File;)V
    //   16: astore 6
    //   18: aload 6
    //   20: invokevirtual 127	java/util/zip/ZipFile:entries	()Ljava/util/Enumeration;
    //   23: astore 7
    //   25: aload 7
    //   27: invokeinterface 133 1 0
    //   32: ifeq +128 -> 160
    //   35: aload 7
    //   37: invokeinterface 137 1 0
    //   42: checkcast 139	java/util/zip/ZipEntry
    //   45: astore 8
    //   47: aload 8
    //   49: ifnull -24 -> 25
    //   52: aload 8
    //   54: invokevirtual 142	java/util/zip/ZipEntry:getName	()Ljava/lang/String;
    //   57: ldc 144
    //   59: aload_1
    //   60: invokestatic 148	java/lang/String:valueOf	(Ljava/lang/Object;)Ljava/lang/String;
    //   63: invokevirtual 152	java/lang/String:concat	(Ljava/lang/String;)Ljava/lang/String;
    //   66: invokevirtual 156	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   69: ifeq -44 -> 25
    //   72: new 158	com/facebook/soloader/h
    //   75: dup
    //   76: aload 6
    //   78: aload 8
    //   80: invokespecial 161	com/facebook/soloader/h:<init>	(Ljava/util/zip/ZipFile;Ljava/util/zip/ZipEntry;)V
    //   83: astore 7
    //   85: aload_1
    //   86: aload 7
    //   88: invokestatic 163	com/facebook/soloader/d:a	(Ljava/lang/String;Lcom/facebook/soloader/f;)[Ljava/lang/String;
    //   91: astore_1
    //   92: aload_1
    //   93: arraylength
    //   94: istore 5
    //   96: iconst_0
    //   97: istore 4
    //   99: iload 4
    //   101: iload 5
    //   103: if_icmpge +50 -> 153
    //   106: aload_1
    //   107: iload 4
    //   109: aaload
    //   110: astore 8
    //   112: getstatic 33	com/facebook/soloader/d:cCu	Ljava/util/Set;
    //   115: aload 8
    //   117: invokeinterface 168 2 0
    //   122: ifne +22 -> 144
    //   125: aload 8
    //   127: ldc 144
    //   129: invokevirtual 171	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   132: ifne +12 -> 144
    //   135: aload 8
    //   137: iload_2
    //   138: iconst_1
    //   139: ior
    //   140: aload_3
    //   141: invokestatic 174	com/facebook/soloader/n:c	(Ljava/lang/String;ILandroid/os/StrictMode$ThreadPolicy;)V
    //   144: iload 4
    //   146: iconst_1
    //   147: iadd
    //   148: istore 4
    //   150: goto -51 -> 99
    //   153: aload 7
    //   155: invokeinterface 179 1 0
    //   160: aload 6
    //   162: invokevirtual 180	java/util/zip/ZipFile:close	()V
    //   165: ldc 118
    //   167: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   170: return
    //   171: astore_1
    //   172: ldc 118
    //   174: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   177: aload_1
    //   178: athrow
    //   179: astore_3
    //   180: aload_1
    //   181: ifnull +53 -> 234
    //   184: aload 7
    //   186: invokeinterface 179 1 0
    //   191: ldc 118
    //   193: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   196: aload_3
    //   197: athrow
    //   198: astore_1
    //   199: ldc 118
    //   201: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   204: aload_1
    //   205: athrow
    //   206: astore_3
    //   207: aload_1
    //   208: ifnull +47 -> 255
    //   211: aload 6
    //   213: invokevirtual 180	java/util/zip/ZipFile:close	()V
    //   216: ldc 118
    //   218: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   221: aload_3
    //   222: athrow
    //   223: astore 7
    //   225: aload_1
    //   226: aload 7
    //   228: invokevirtual 186	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   231: goto -40 -> 191
    //   234: aload 7
    //   236: invokeinterface 179 1 0
    //   241: goto -50 -> 191
    //   244: astore 6
    //   246: aload_1
    //   247: aload 6
    //   249: invokevirtual 186	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   252: goto -36 -> 216
    //   255: aload 6
    //   257: invokevirtual 180	java/util/zip/ZipFile:close	()V
    //   260: goto -44 -> 216
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	263	0	this	d
    //   0	263	1	paramString	String
    //   0	263	2	paramInt	int
    //   0	263	3	paramThreadPolicy	StrictMode.ThreadPolicy
    //   97	52	4	i	int
    //   94	10	5	j	int
    //   16	196	6	localZipFile	ZipFile
    //   244	12	6	localThrowable1	Throwable
    //   23	162	7	localObject	Object
    //   223	12	7	localThrowable2	Throwable
    //   45	91	8	localZipEntry	ZipEntry
    // Exception table:
    //   from	to	target	type
    //   85	96	171	finally
    //   112	144	171	finally
    //   172	179	179	finally
    //   18	25	198	finally
    //   25	47	198	finally
    //   52	85	198	finally
    //   153	160	198	finally
    //   191	198	198	finally
    //   225	231	198	finally
    //   234	241	198	finally
    //   199	206	206	finally
    //   184	191	223	finally
    //   211	216	244	finally
  }
  
  public final int a(String paramString, int paramInt, StrictMode.ThreadPolicy paramThreadPolicy)
  {
    AppMethodBeat.i(208119);
    if (n.cCZ == null)
    {
      paramString = new IllegalStateException("SoLoader.init() not yet called");
      AppMethodBeat.o(208119);
      throw paramString;
    }
    if ((!cCu.contains(paramString)) || (TextUtils.isEmpty(this.cCv)))
    {
      new StringBuilder().append(paramString).append(" not found on ").append(this.cCv);
      AppMethodBeat.o(208119);
      return 0;
    }
    b(paramString, paramInt, paramThreadPolicy);
    paramInt |= 0x4;
    try
    {
      n.cCZ.v(this.cCv + File.separator + paramString, paramInt);
      new StringBuilder().append(paramString).append(" found on DirectAPKSoSource: ").append(paramInt);
      AppMethodBeat.o(208119);
      return 1;
    }
    catch (UnsatisfiedLinkError paramThreadPolicy)
    {
      new StringBuilder().append(paramString).append(" not found on DirectAPKSoSource: ").append(paramInt);
      AppMethodBeat.o(208119);
    }
    return 0;
  }
  
  protected final void hi(int paramInt)
  {
    AppMethodBeat.i(208130);
    if (!TextUtils.isEmpty(this.cCv))
    {
      paramInt = this.cCv.indexOf('!');
      if ((paramInt < 0) || (paramInt + 2 >= this.cCv.length())) {}
    }
    Object localObject2;
    for (String str = this.cCv.substring(paramInt + 2);; localObject2 = null)
    {
      if (str == null)
      {
        AppMethodBeat.o(208130);
        return;
      }
      ZipFile localZipFile = new ZipFile(this.cCw);
      try
      {
        Enumeration localEnumeration = localZipFile.entries();
        while (localEnumeration.hasMoreElements())
        {
          Object localObject4 = (ZipEntry)localEnumeration.nextElement();
          if ((localObject4 != null) && (((ZipEntry)localObject4).getName().startsWith(str)) && (((ZipEntry)localObject4).getName().endsWith(".so")) && (((ZipEntry)localObject4).getMethod() == 0))
          {
            localObject4 = ((ZipEntry)localObject4).getName().substring(str.length() + 1);
            cCu.add(localObject4);
          }
        }
        try
        {
          localZipFile.close();
          AppMethodBeat.o(208130);
          throw localObject3;
          localZipFile.close();
          AppMethodBeat.o(208130);
          return;
        }
        finally
        {
          for (;;)
          {
            localObject1.addSuppressed(localThrowable);
          }
        }
      }
      finally
      {
        try
        {
          AppMethodBeat.o(208130);
          throw localObject1;
        }
        finally {}
      }
      for (;;)
      {
        localThrowable.close();
      }
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(208135);
    String str = getClass().getName() + "[root = " + this.cCv + ']';
    AppMethodBeat.o(208135);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.soloader.d
 * JD-Core Version:    0.7.0.1
 */
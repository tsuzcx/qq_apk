package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import java.io.File;
import java.io.FileFilter;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class kj
  implements ki
{
  static Set<String> a;
  private static final int[] f;
  private boolean b;
  private long c;
  private int d;
  private final Map<String, int[]> e;
  private final File g;
  private final Context h;
  private boolean i;
  
  static
  {
    AppMethodBeat.i(224621);
    HashSet localHashSet = new HashSet();
    a = localHashSet;
    localHashSet.add("TO");
    a.add("NetManager");
    a.add("asset");
    f = new int[] { 2, 3, 4, 5, 6 };
    AppMethodBeat.o(224621);
  }
  
  public kj(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    AppMethodBeat.i(224499);
    this.e = new HashMap();
    this.h = paramContext;
    paramContext = new File(mf.a(paramContext, paramTencentMapOptions).c().getAbsolutePath());
    this.g = ka.a(paramContext, "logs");
    if (js.a("4.4.7", "4.3.4", 3) < 0) {
      ka.a(paramContext, new FileFilter()
      {
        public final boolean accept(File paramAnonymousFile)
        {
          AppMethodBeat.i(222491);
          boolean bool = Pattern.compile("log-.*.log").matcher(paramAnonymousFile.getName()).matches();
          AppMethodBeat.o(222491);
          return bool;
        }
      });
    }
    if (paramTencentMapOptions != null)
    {
      paramContext = paramTencentMapOptions.getDebugTags();
      if (paramContext != null) {
        a(true, paramContext);
      }
    }
    jw.a(new jw.g()
    {
      private Void a()
      {
        int k = 0;
        AppMethodBeat.i(222556);
        Object localObject1 = Calendar.getInstance();
        Object localObject2 = new Date();
        ((Calendar)localObject1).setTime((Date)localObject2);
        StringBuilder localStringBuilder1 = new StringBuilder();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder1.append("(");
        localStringBuilder2.append("(");
        int i = 2;
        int j;
        while (i != 0)
        {
          ((Calendar)localObject1).add(2, -1);
          Object localObject3 = ((Calendar)localObject1).get(1);
          String str = String.format(Locale.CHINA, "%02d", new Object[] { Integer.valueOf(((Calendar)localObject1).get(2) + 1) });
          localStringBuilder1.append((String)localObject3).append("|");
          localStringBuilder2.append(str).append("|");
          str = (String)localObject3 + "_" + str;
          localObject3 = ka.e(kj.a(kj.this), ".*" + str + ".*.log.*");
          if ((localObject3 != null) && (localObject3.length > 0))
          {
            str = "archive-".concat(String.valueOf(str));
            if (kd.a((File[])localObject3, kj.a(kj.this), str))
            {
              int m = localObject3.length;
              j = 0;
              while (j < m)
              {
                ka.b(localObject3[j]);
                j += 1;
              }
            }
          }
          i -= 1;
        }
        ((Calendar)localObject1).setTime((Date)localObject2);
        localStringBuilder1.deleteCharAt(localStringBuilder1.lastIndexOf("|")).append(")");
        localStringBuilder2.deleteCharAt(localStringBuilder2.lastIndexOf("|")).append(")");
        localObject1 = "archive-" + localStringBuilder1.toString() + "_" + localStringBuilder2.toString() + ".zip";
        localObject2 = ka.e(kj.a(kj.this), "archive-.*.zip");
        if (localObject2 != null)
        {
          j = localObject2.length;
          i = k;
          while (i < j)
          {
            localStringBuilder1 = localObject2[i];
            if (!localStringBuilder1.getName().matches((String)localObject1)) {
              ka.b(localStringBuilder1);
            }
            i += 1;
          }
        }
        AppMethodBeat.o(222556);
        return null;
      }
    }).a(null);
    if (ry.d) {
      Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler()
      {
        public final void uncaughtException(Thread paramAnonymousThread, Throwable paramAnonymousThrowable)
        {
          AppMethodBeat.i(222476);
          kj.a(kj.this, "TMS", "UncaughtException: t[" + paramAnonymousThread + "]", paramAnonymousThrowable);
          paramAnonymousThread = new RuntimeException(paramAnonymousThrowable);
          AppMethodBeat.o(222476);
          throw paramAnonymousThread;
        }
      });
    }
    AppMethodBeat.o(224499);
  }
  
  private void a(int paramInt, String paramString1, String paramString2)
  {
    AppMethodBeat.i(224561);
    a(paramInt, paramString1, paramString2, null);
    AppMethodBeat.o(224561);
  }
  
  private void a(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(224574);
    String str = paramString1;
    if (!"TMS".equals(paramString1))
    {
      if (TextUtils.isEmpty(paramString1)) {
        str = "TMS";
      }
    }
    else
    {
      if (paramThrowable == null) {
        break label178;
      }
      switch (paramInt)
      {
      }
    }
    for (;;)
    {
      if (this.i)
      {
        paramString1 = paramString2;
        if (paramThrowable != null) {
          paramString1 = paramString2 + " [error]:" + paramThrowable.getMessage();
        }
        System.out.println("[" + str + "]:" + paramString1);
      }
      AppMethodBeat.o(224574);
      return;
      str = "TMS-".concat(String.valueOf(paramString1));
      break;
      Log.wtf(str, paramString2, paramThrowable);
      continue;
      label178:
      Log.println(paramInt, str, paramString2);
    }
  }
  
  public static String d()
  {
    AppMethodBeat.i(224539);
    String str = new SimpleDateFormat("yyyy_MM_dd", Locale.CHINA).format(new Date());
    AppMethodBeat.o(224539);
    return str;
  }
  
  private void f()
  {
    AppMethodBeat.i(224509);
    jw.a(new jw.g()
    {
      private Void a()
      {
        int k = 0;
        AppMethodBeat.i(222556);
        Object localObject1 = Calendar.getInstance();
        Object localObject2 = new Date();
        ((Calendar)localObject1).setTime((Date)localObject2);
        StringBuilder localStringBuilder1 = new StringBuilder();
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder1.append("(");
        localStringBuilder2.append("(");
        int i = 2;
        int j;
        while (i != 0)
        {
          ((Calendar)localObject1).add(2, -1);
          Object localObject3 = ((Calendar)localObject1).get(1);
          String str = String.format(Locale.CHINA, "%02d", new Object[] { Integer.valueOf(((Calendar)localObject1).get(2) + 1) });
          localStringBuilder1.append((String)localObject3).append("|");
          localStringBuilder2.append(str).append("|");
          str = (String)localObject3 + "_" + str;
          localObject3 = ka.e(kj.a(kj.this), ".*" + str + ".*.log.*");
          if ((localObject3 != null) && (localObject3.length > 0))
          {
            str = "archive-".concat(String.valueOf(str));
            if (kd.a((File[])localObject3, kj.a(kj.this), str))
            {
              int m = localObject3.length;
              j = 0;
              while (j < m)
              {
                ka.b(localObject3[j]);
                j += 1;
              }
            }
          }
          i -= 1;
        }
        ((Calendar)localObject1).setTime((Date)localObject2);
        localStringBuilder1.deleteCharAt(localStringBuilder1.lastIndexOf("|")).append(")");
        localStringBuilder2.deleteCharAt(localStringBuilder2.lastIndexOf("|")).append(")");
        localObject1 = "archive-" + localStringBuilder1.toString() + "_" + localStringBuilder2.toString() + ".zip";
        localObject2 = ka.e(kj.a(kj.this), "archive-.*.zip");
        if (localObject2 != null)
        {
          j = localObject2.length;
          i = k;
          while (i < j)
          {
            localStringBuilder1 = localObject2[i];
            if (!localStringBuilder1.getName().matches((String)localObject1)) {
              ka.b(localStringBuilder1);
            }
            i += 1;
          }
        }
        AppMethodBeat.o(222556);
        return null;
      }
    }).a(null);
    AppMethodBeat.o(224509);
  }
  
  private static String g()
  {
    AppMethodBeat.i(224517);
    String str = "###########\n" + kl.a(gw.a("", "")) + "\n###########\n";
    AppMethodBeat.o(224517);
    return str;
  }
  
  private static String h()
  {
    AppMethodBeat.i(224528);
    String str = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.CHINA).format(new Date());
    AppMethodBeat.o(224528);
    return str;
  }
  
  private static String i()
  {
    AppMethodBeat.i(224550);
    String str = new SimpleDateFormat("yyyy_MM", Locale.CHINA).format(new Date());
    AppMethodBeat.o(224550);
    return str;
  }
  
  public final void a(Context paramContext, jx.a parama)
  {
    AppMethodBeat.i(224882);
    if (paramContext != null)
    {
      long l = SystemClock.uptimeMillis();
      if ((this.c == 0L) || (l - this.c < 400L))
      {
        this.c = l;
        this.d += 1;
        paramContext = "触发调试模式" + this.d + "次";
        String str;
        if ((this.d >= 5) && (this.d < 10))
        {
          str = "开发者调试在" + (10 - this.d) + "次后开启";
          paramContext = str;
          if (parama != null)
          {
            parama.a(str, 1).b();
            paramContext = str;
          }
        }
        for (;;)
        {
          a(5, "TMS", paramContext);
          AppMethodBeat.o(224882);
          return;
          if (this.d == 10)
          {
            this.b = true;
            str = "开发者调试已开启";
            paramContext = str;
            if (parama != null)
            {
              parama.a("开发者调试已开启", 1).b();
              paramContext = str;
            }
          }
        }
      }
      this.d = 0;
      this.c = 0L;
      this.b = false;
    }
    AppMethodBeat.o(224882);
  }
  
  public final void a(final File paramFile, final String paramString1, final String paramString2)
  {
    AppMethodBeat.i(224860);
    if ((!a("TMS")) || (TextUtils.isEmpty(paramString2)))
    {
      AppMethodBeat.o(224860);
      return;
    }
    new Thread(new Runnable()
    {
      public final void run()
      {
        int j = 1;
        AppMethodBeat.i(222524);
        File localFile2 = new File(paramFile, paramString1 + "-" + kj.d() + ".log");
        String str;
        File localFile1;
        if (!localFile2.exists())
        {
          ka.a(localFile2);
          str = kj.e() + paramString2;
          if (localFile2.length() >= 2097152L)
          {
            localFile1 = null;
            i = 1;
            label108:
            if (i > 500) {
              break label228;
            }
            localFile1 = new File(localFile2.getParent(), localFile2.getName() + ".part" + i);
            if (localFile1.exists()) {
              break label221;
            }
          }
        }
        label221:
        label228:
        for (int i = j;; i = 0)
        {
          if (i != 0)
          {
            ka.a(localFile2, localFile1);
            ka.a(localFile2);
          }
          ka.c(localFile2, str);
          AppMethodBeat.o(222524);
          return;
          str = paramString2 + "\n";
          break;
          i += 1;
          break label108;
        }
      }
    }).start();
    AppMethodBeat.o(224860);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224682);
    if (a(2, paramString1)) {
      a(2, paramString1, paramString2);
    }
    AppMethodBeat.o(224682);
  }
  
  public final void a(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(224692);
    if (a(2, paramString1)) {
      a(2, paramString1, paramString2, paramThrowable);
    }
    AppMethodBeat.o(224692);
  }
  
  public final void a(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(224675);
    if (a("TMS")) {
      a(2, "TMS", paramString, paramThrowable);
    }
    AppMethodBeat.o(224675);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.i = paramBoolean;
  }
  
  public final void a(boolean paramBoolean, int paramInt, String... paramVarArgs)
  {
    AppMethodBeat.i(224899);
    if (paramVarArgs != null)
    {
      int k = paramVarArgs.length;
      int j = 0;
      while (j < k)
      {
        String str = paramVarArgs[j];
        this.e.remove(str);
        if (paramBoolean) {
          this.e.put(str, new int[] { paramInt });
        }
        j += 1;
      }
    }
    AppMethodBeat.o(224899);
  }
  
  public final void a(boolean paramBoolean, String... paramVarArgs)
  {
    AppMethodBeat.i(224891);
    if (paramVarArgs != null)
    {
      int k = paramVarArgs.length;
      int j = 0;
      while (j < k)
      {
        String str = paramVarArgs[j];
        this.e.remove(str);
        if (paramBoolean) {
          this.e.put(str, f);
        }
        j += 1;
      }
    }
    AppMethodBeat.o(224891);
  }
  
  public final boolean a()
  {
    AppMethodBeat.i(224631);
    boolean bool = a("TMS");
    AppMethodBeat.o(224631);
    return bool;
  }
  
  public final boolean a(int paramInt, String paramString)
  {
    AppMethodBeat.i(224658);
    int j;
    if (this.e.containsKey(paramString))
    {
      paramString = (int[])this.e.get(paramString);
      if (paramString == null) {
        break label116;
      }
      int k = paramString.length;
      j = 0;
      if (j >= k) {
        break label116;
      }
      if (paramString[j] != paramInt) {}
    }
    label116:
    for (boolean bool = true;; bool = false)
    {
      AppMethodBeat.o(224658);
      return bool;
      j += 1;
      break;
      if ((this.b) || ((ry.d) && (!a.contains(paramString))))
      {
        AppMethodBeat.o(224658);
        return true;
      }
      AppMethodBeat.o(224658);
      return false;
    }
  }
  
  public final boolean a(String paramString)
  {
    AppMethodBeat.i(224643);
    if (this.e.containsKey(paramString))
    {
      AppMethodBeat.o(224643);
      return true;
    }
    if ((this.b) || ((ry.d) && (!a.contains(paramString))))
    {
      AppMethodBeat.o(224643);
      return true;
    }
    AppMethodBeat.o(224643);
    return false;
  }
  
  public final String b()
  {
    AppMethodBeat.i(224871);
    String str = this.g.getAbsolutePath();
    AppMethodBeat.o(224871);
    return str;
  }
  
  public final void b(String paramString)
  {
    AppMethodBeat.i(224667);
    if (a("TMS")) {
      a(2, "TMS", paramString);
    }
    AppMethodBeat.o(224667);
  }
  
  public final void b(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224718);
    if (a(3, paramString1)) {
      a(3, paramString1, paramString2);
    }
    AppMethodBeat.o(224718);
  }
  
  public final void b(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(224725);
    if (a(3, paramString1)) {
      a(3, paramString1, paramString2, paramThrowable);
    }
    AppMethodBeat.o(224725);
  }
  
  public final void b(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(224711);
    if (a("TMS")) {
      a(3, "TMS", paramString, paramThrowable);
    }
    AppMethodBeat.o(224711);
  }
  
  public final void c() {}
  
  public final void c(String paramString)
  {
    AppMethodBeat.i(224701);
    if (a("TMS")) {
      a(3, "TMS", paramString);
    }
    AppMethodBeat.o(224701);
  }
  
  public final void c(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224754);
    if (a(4, paramString1)) {
      a(4, paramString1, paramString2);
    }
    AppMethodBeat.o(224754);
  }
  
  public final void c(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(224764);
    if (a(4, paramString1)) {
      a(4, paramString1, paramString2, paramThrowable);
    }
    AppMethodBeat.o(224764);
  }
  
  public final void c(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(224742);
    if (a("TMS")) {
      a(4, "TMS", paramString, paramThrowable);
    }
    AppMethodBeat.o(224742);
  }
  
  public final void d(String paramString)
  {
    AppMethodBeat.i(224734);
    if (a("TMS")) {
      a(4, "TMS", paramString);
    }
    AppMethodBeat.o(224734);
  }
  
  public final void d(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224789);
    if (a(5, paramString1)) {
      a(5, paramString1, paramString2);
    }
    AppMethodBeat.o(224789);
  }
  
  public final void d(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(224798);
    if (a(5, paramString1)) {
      a(5, paramString1, paramString2, paramThrowable);
    }
    AppMethodBeat.o(224798);
  }
  
  public final void d(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(224780);
    if (a("TMS")) {
      a(5, "TMS", paramString, paramThrowable);
    }
    AppMethodBeat.o(224780);
  }
  
  public final void e(String paramString)
  {
    AppMethodBeat.i(224769);
    if (a("TMS")) {
      a(5, "TMS", paramString);
    }
    AppMethodBeat.o(224769);
  }
  
  public final void e(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224821);
    if (a(6, paramString1)) {
      a(6, paramString1, paramString2);
    }
    AppMethodBeat.o(224821);
  }
  
  public final void e(String paramString1, String paramString2, Throwable paramThrowable)
  {
    AppMethodBeat.i(224831);
    if (a(6, paramString1)) {
      a(6, paramString1, paramString2, paramThrowable);
    }
    AppMethodBeat.o(224831);
  }
  
  public final void e(String paramString, Throwable paramThrowable)
  {
    AppMethodBeat.i(224814);
    if (a("TMS")) {
      a(6, "TMS", paramString, paramThrowable);
    }
    AppMethodBeat.o(224814);
  }
  
  public final void f(String paramString)
  {
    AppMethodBeat.i(224807);
    if (a("TMS")) {
      a(6, "TMS", paramString);
    }
    AppMethodBeat.o(224807);
  }
  
  public final void f(String paramString1, String paramString2)
  {
    AppMethodBeat.i(224848);
    a(this.g, paramString1, paramString2);
    AppMethodBeat.o(224848);
  }
  
  public final void g(String paramString)
  {
    AppMethodBeat.i(224840);
    a(this.g, "tms", paramString);
    AppMethodBeat.o(224840);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mapsdk.internal.kj
 * JD-Core Version:    0.7.0.1
 */
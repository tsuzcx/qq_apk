package androidx.core.d;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Typeface;
import android.os.Handler;
import android.os.Looper;
import androidx.b.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class d
{
  static final Object Mp;
  static final androidx.b.e<String, Typeface> bqA;
  private static final ExecutorService brH;
  static final g<String, ArrayList<androidx.core.f.a<a>>> brI;
  
  static
  {
    AppMethodBeat.i(196336);
    bqA = new androidx.b.e(16);
    Object localObject = new f.a("fonts-androidx");
    localObject = new ThreadPoolExecutor(0, 1, 10000L, TimeUnit.MILLISECONDS, new LinkedBlockingDeque(), (ThreadFactory)localObject);
    ((ThreadPoolExecutor)localObject).allowCoreThreadTimeOut(true);
    brH = (ExecutorService)localObject;
    Mp = new Object();
    brI = new g();
    AppMethodBeat.o(196336);
  }
  
  public static Typeface a(final Context paramContext, final c paramc, final int paramInt, a arg3)
  {
    AppMethodBeat.i(196303);
    Object localObject1 = a(paramc, paramInt);
    Object localObject2 = (Typeface)bqA.get(localObject1);
    if (localObject2 != null)
    {
      ???.a(new a((Typeface)localObject2));
      AppMethodBeat.o(196303);
      return localObject2;
    }
    localObject2 = new androidx.core.f.a() {};
    for (;;)
    {
      synchronized (Mp)
      {
        ArrayList localArrayList = (ArrayList)brI.get(localObject1);
        if (localArrayList != null)
        {
          localArrayList.add(localObject2);
          AppMethodBeat.o(196303);
          return null;
        }
        localArrayList = new ArrayList();
        localArrayList.add(localObject2);
        brI.put(localObject1, localArrayList);
        paramc = new Callable() {};
        ??? = brH;
        localObject1 = new androidx.core.f.a() {};
        if (Looper.myLooper() == null)
        {
          paramContext = new Handler(Looper.getMainLooper());
          ???.execute(new f.b(paramContext, paramc, (androidx.core.f.a)localObject1));
          AppMethodBeat.o(196303);
          return null;
        }
      }
      paramContext = new Handler();
    }
  }
  
  public static Typeface a(final Context paramContext, final c paramc, a parama, final int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(196290);
    String str = a(paramc, paramInt1);
    Typeface localTypeface = (Typeface)bqA.get(str);
    if (localTypeface != null)
    {
      parama.a(new a(localTypeface));
      AppMethodBeat.o(196290);
      return localTypeface;
    }
    if (paramInt2 == -1)
    {
      paramContext = a(str, paramContext, paramc, paramInt1);
      parama.a(paramContext);
      paramContext = paramContext.brL;
      AppMethodBeat.o(196290);
      return paramContext;
    }
    paramContext = new Callable() {};
    try
    {
      paramContext = (a)f.a(brH, paramContext, paramInt2);
      parama.a(paramContext);
      paramContext = paramContext.brL;
      AppMethodBeat.o(196290);
      return paramContext;
    }
    catch (InterruptedException paramContext)
    {
      parama.a(new a(-3));
      AppMethodBeat.o(196290);
    }
    return null;
  }
  
  static a a(String paramString, Context paramContext, c paramc, int paramInt)
  {
    int k = 0;
    AppMethodBeat.i(196324);
    Object localObject = (Typeface)bqA.get(paramString);
    if (localObject != null)
    {
      paramString = new a((Typeface)localObject);
      AppMethodBeat.o(196324);
      return paramString;
    }
    int i;
    for (;;)
    {
      try
      {
        paramc = b.a(paramContext, paramc);
        if (paramc.mStatusCode == 0) {
          break label126;
        }
        switch (paramc.mStatusCode)
        {
        default: 
          i = -3;
          if (i == 0) {
            break label207;
          }
          paramString = new a(i);
          AppMethodBeat.o(196324);
          return paramString;
        }
      }
      catch (PackageManager.NameNotFoundException paramString)
      {
        paramString = new a(-1);
        AppMethodBeat.o(196324);
        return paramString;
      }
      i = -2;
      continue;
      label126:
      localObject = paramc.brN;
      if ((localObject != null) && (localObject.length != 0)) {
        break;
      }
      i = 1;
    }
    int m = localObject.length;
    int j = 0;
    for (;;)
    {
      i = k;
      if (j >= m) {
        break;
      }
      i = localObject[j].mResultCode;
      if (i != 0)
      {
        if (i < 0)
        {
          i = -3;
          break;
        }
        break;
      }
      j += 1;
    }
    label207:
    paramContext = androidx.core.graphics.e.a(paramContext, paramc.brN, paramInt);
    if (paramContext != null)
    {
      bqA.put(paramString, paramContext);
      paramString = new a(paramContext);
      AppMethodBeat.o(196324);
      return paramString;
    }
    paramString = new a(-3);
    AppMethodBeat.o(196324);
    return paramString;
  }
  
  private static String a(c paramc, int paramInt)
  {
    AppMethodBeat.i(196308);
    paramc = paramc.brG + "-" + paramInt;
    AppMethodBeat.o(196308);
    return paramc;
  }
  
  static final class a
  {
    final Typeface brL;
    final int brM;
    
    a(int paramInt)
    {
      this.brL = null;
      this.brM = paramInt;
    }
    
    a(Typeface paramTypeface)
    {
      this.brL = paramTypeface;
      this.brM = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     androidx.core.d.d
 * JD-Core Version:    0.7.0.1
 */
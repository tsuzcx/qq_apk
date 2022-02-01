package c.t.m.sapp.c;

import android.annotation.TargetApi;
import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class b
{
  public static b a;
  public Context b;
  public List<a> c;
  public String d;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(210687);
    this.c = null;
    this.d = "";
    this.b = paramContext;
    this.c = new ArrayList();
    AppMethodBeat.o(210687);
  }
  
  public static b a(Context paramContext)
  {
    AppMethodBeat.i(210688);
    if (a == null) {
      a = new b(paramContext);
    }
    paramContext = a;
    AppMethodBeat.o(210688);
    return paramContext;
  }
  
  @TargetApi(3)
  public final DexClassLoader a()
  {
    try
    {
      AppMethodBeat.i(210690);
      l.a(this.b);
      Object localObject1 = this.c;
      Object localObject6;
      Object localObject7;
      StringBuilder localStringBuilder1;
      Object localObject5;
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        q.d = q.a(this.c);
        localObject6 = this.b.getFilesDir().getAbsolutePath() + File.separator + this.d;
        localObject7 = this.b.getFilesDir().getAbsolutePath() + File.separator + q.c;
        localStringBuilder1 = new StringBuilder();
        localObject1 = this.c.iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject5 = (a)((Iterator)localObject1).next();
          if (localObject5 != null)
          {
            localStringBuilder1.append((String)localObject6);
            localStringBuilder1.append(File.separator);
            localStringBuilder1.append(((a)localObject5).c);
            localStringBuilder1.append(File.pathSeparator);
          }
        }
      }
      try
      {
        System.currentTimeMillis();
        localObject5 = new DexClassLoader(localStringBuilder1.toString(), (String)localObject7, null, getClass().getClassLoader());
        localObject3 = "";
        try
        {
          localObject8 = new File((String)localObject6);
          localObject6 = localObject3;
          if (((File)localObject8).exists())
          {
            localObject6 = localObject3;
            if (((File)localObject8).isDirectory())
            {
              localObject8 = ((File)localObject8).listFiles();
              localObject6 = localObject3;
              if (localObject8 != null)
              {
                localObject6 = localObject3;
                if (localObject8.length > 0)
                {
                  j = localObject8.length;
                  i = 0;
                  for (;;)
                  {
                    localObject6 = localObject3;
                    if (i >= j) {
                      break;
                    }
                    localObject6 = localObject8[i];
                    localStringBuilder2 = new StringBuilder().append(((File)localObject6).getName());
                    localStringBuilder2 = localStringBuilder2.append(",").append(((File)localObject6).length());
                    localObject6 = "," + q.a((File)localObject6);
                    localObject3 = new StringBuilder().append((String)localObject3).append((String)localObject6);
                    localObject3 = ";";
                    i += 1;
                  }
                }
              }
            }
          }
          localObject3 = new StringBuilder();
          j.a("before load ,private dir files:" + (String)localObject6);
          localObject3 = e.a(this.b);
          localObject6 = new StringBuilder();
          ((e)localObject3).a("CPL", "suc:" + q.d);
          AppMethodBeat.o(210690);
          localObject3 = localObject5;
          return localObject3;
        }
        catch (Exception localException2)
        {
          localObject3 = localObject5;
          localObject5 = localException2;
        }
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localObject4 = null;
        }
      }
    }
    finally {}
    for (;;)
    {
      Object localObject8;
      int j;
      int i;
      StringBuilder localStringBuilder2;
      j.a("try once", (Throwable)localObject5);
      e.a(this.b).a("CPL", "fail:" + q.d + ",exc:" + ((Exception)localObject5).toString());
      l.a(this.b);
      try
      {
        System.currentTimeMillis();
        localDexClassLoader = new DexClassLoader(localStringBuilder1.toString(), (String)localObject7, null, getClass().getClassLoader());
      }
      catch (Throwable localThrowable2)
      {
        DexClassLoader localDexClassLoader;
        label622:
        Object localObject4;
        break label622;
      }
      try
      {
        localObject3 = e.a(this.b);
        localObject7 = new StringBuilder();
        ((e)localObject3).a("CPL", "suc:c" + q.d);
        AppMethodBeat.o(210690);
        localObject3 = localDexClassLoader;
      }
      catch (Throwable localThrowable1)
      {
        localObject4 = localDexClassLoader;
        break label622;
      }
      j.a("try once failed", (Throwable)localObject5);
      AppMethodBeat.o(210690);
      continue;
      AppMethodBeat.o(210690);
      Object localObject3 = null;
    }
  }
  
  public DexClassLoader a(List<a> paramList, String paramString)
  {
    AppMethodBeat.i(210689);
    this.c = paramList;
    this.d = paramString;
    int i = 0;
    paramList = null;
    for (;;)
    {
      int j = i + 1;
      paramString = paramList;
      if (i >= 3) {
        break label126;
      }
      try
      {
        paramString = a();
        paramList = paramString;
      }
      catch (Throwable paramString)
      {
        try
        {
          paramString = e.b();
          StringBuilder localStringBuilder = new StringBuilder();
          paramString.a("CPL", "lcn:" + j);
          if (paramList != null)
          {
            l.f(this.b);
            AppMethodBeat.o(210689);
            return paramList;
          }
          i = j;
        }
        catch (Throwable paramString)
        {
          break;
        }
        paramString = paramString;
      }
    }
    e.b().a("CPL", "fail:" + paramString.toString());
    paramString = paramList;
    label126:
    l.f(this.b);
    AppMethodBeat.o(210689);
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     c.t.m.sapp.c.b
 * JD-Core Version:    0.7.0.1
 */
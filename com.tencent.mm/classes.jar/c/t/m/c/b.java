package c.t.m.c;

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
  private static b c = null;
  private Context a;
  private List<a> b;
  
  private b(Context paramContext)
  {
    AppMethodBeat.i(136326);
    this.b = null;
    this.a = paramContext;
    this.b = new ArrayList();
    AppMethodBeat.o(136326);
  }
  
  public static b a(Context paramContext, List<a> paramList)
  {
    AppMethodBeat.i(136327);
    if (c == null) {
      c = new b(paramContext);
    }
    c.a(paramList);
    paramContext = c;
    AppMethodBeat.o(136327);
    return paramContext;
  }
  
  private b a(List<a> paramList)
  {
    try
    {
      AppMethodBeat.i(136328);
      this.b.clear();
      this.b.addAll(paramList);
      AppMethodBeat.o(136328);
      return this;
    }
    finally
    {
      paramList = finally;
      throw paramList;
    }
  }
  
  @TargetApi(3)
  private DexClassLoader b()
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(136329);
        l.a(this.a);
        if ((this.b == null) || (this.b.size() <= 0))
        {
          AppMethodBeat.o(136329);
          localObject1 = null;
          return localObject1;
        }
        q.b = q.a(this.b);
        String str1 = this.a.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation/comp";
        String str2 = this.a.getFilesDir().getAbsolutePath() + File.separator + "TencentLocation/odex";
        StringBuilder localStringBuilder = new StringBuilder();
        Object localObject1 = this.b.iterator();
        if (((Iterator)localObject1).hasNext())
        {
          a locala = (a)((Iterator)localObject1).next();
          if (locala != null)
          {
            localStringBuilder.append(str1);
            localStringBuilder.append(File.separator);
            localStringBuilder.append(locala.c);
            localStringBuilder.append(File.pathSeparator);
          }
        }
        else
        {
          try
          {
            System.currentTimeMillis();
            DexClassLoader localDexClassLoader1 = new DexClassLoader(localStringBuilder.toString(), str2, str1, getClass().getClassLoader());
            e.a(this.a).a("CPL", "suc:" + q.b);
            AppMethodBeat.o(136329);
          }
          catch (Exception localException)
          {
            e.a(this.a).a("CPL", "fail:" + q.b + ",exc:" + localException.toString());
            l.a(this.a);
            try
            {
              System.currentTimeMillis();
              DexClassLoader localDexClassLoader2 = new DexClassLoader(localStringBuilder.toString(), str2, str1, getClass().getClassLoader());
              e.a(this.a).a("CPL", "suc:c" + q.b);
              AppMethodBeat.o(136329);
            }
            catch (Throwable localThrowable)
            {
              AppMethodBeat.o(136329);
              Object localObject3 = null;
            }
          }
        }
      }
      finally {}
    }
  }
  
  public DexClassLoader a()
  {
    AppMethodBeat.i(136330);
    int i = 0;
    Object localObject3;
    for (Object localObject1 = null;; localObject1 = localObject3)
    {
      int j = i + 1;
      Object localObject2 = localObject1;
      if (i < 3)
      {
        try
        {
          localObject2 = b();
          localObject1 = localObject2;
          e.a().a("CPL", "lcn:".concat(String.valueOf(j)));
          if (localObject2 == null) {
            break label101;
          }
          AppMethodBeat.o(136330);
          return localObject2;
        }
        catch (Throwable localThrowable)
        {
          e.a().a("CPL", "fail:" + localThrowable.toString());
          localObject3 = localObject1;
        }
      }
      else
      {
        AppMethodBeat.o(136330);
        return localObject3;
      }
      label101:
      i = j;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     c.t.m.c.b
 * JD-Core Version:    0.7.0.1
 */
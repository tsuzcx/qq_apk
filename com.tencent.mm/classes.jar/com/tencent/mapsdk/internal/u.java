package com.tencent.mapsdk.internal;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.tencent.map.tools.Callback;
import com.tencent.map.tools.Util;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public final class u
  implements ru, rv, rx
{
  private static final u c;
  public rv a;
  s b;
  private ru d;
  private rx e;
  
  static
  {
    AppMethodBeat.i(224580);
    c = new u();
    AppMethodBeat.o(224580);
  }
  
  private u()
  {
    AppMethodBeat.i(224538);
    this.a = new u.1(this);
    this.d = new ru()
    {
      public final void a(Context paramAnonymousContext, String paramAnonymousString) {}
      
      public final void h() {}
      
      public final void i() {}
    };
    this.e = new rx()
    {
      public final void a(Context paramAnonymousContext, String paramAnonymousString) {}
      
      public final void e() {}
      
      public final void f() {}
      
      public final void g() {}
      
      public final void i() {}
    };
    AppMethodBeat.o(224538);
  }
  
  public static u a()
  {
    return c;
  }
  
  private void a(final Context paramContext, final String paramString, final Callback<Void> paramCallback)
  {
    AppMethodBeat.i(224552);
    new Thread(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(223698);
        u.this.a(paramContext, paramString);
        this.c.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(224138);
            if (u.4.this.d != null) {
              u.4.this.d.callback(null);
            }
            AppMethodBeat.o(224138);
          }
        });
        AppMethodBeat.o(223698);
      }
    }, "tms-plugin").start();
    AppMethodBeat.o(224552);
  }
  
  private s j()
  {
    return this.b;
  }
  
  private File k()
  {
    AppMethodBeat.i(224571);
    File localFile = this.a.d();
    AppMethodBeat.o(224571);
    return localFile;
  }
  
  public final Class a(String paramString)
  {
    AppMethodBeat.i(224603);
    paramString = this.a.a(paramString);
    AppMethodBeat.o(224603);
    return paramString;
  }
  
  public final <T> Class<? extends T> a(String paramString, Class<T> paramClass)
  {
    AppMethodBeat.i(224615);
    paramString = this.a.a(paramString, paramClass);
    AppMethodBeat.o(224615);
    return paramString;
  }
  
  public final Object a(Class paramClass, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(224674);
    paramClass = this.a.a(paramClass, paramString, paramArrayOfClass, paramArrayOfObject);
    AppMethodBeat.o(224674);
    return paramClass;
  }
  
  public final <T> T a(Class<T> paramClass, Object... paramVarArgs)
  {
    AppMethodBeat.i(224636);
    paramClass = this.a.a(paramClass, paramVarArgs);
    AppMethodBeat.o(224636);
    return paramClass;
  }
  
  public final Object a(Object paramObject, String paramString, Class[] paramArrayOfClass, Object[] paramArrayOfObject)
  {
    AppMethodBeat.i(224664);
    paramObject = this.a.a(paramObject, paramString, paramArrayOfClass, paramArrayOfObject);
    AppMethodBeat.o(224664);
    return paramObject;
  }
  
  public final Object a(Object paramObject, String paramString, Object... paramVarArgs)
  {
    AppMethodBeat.i(224654);
    paramObject = this.a.a(paramObject, paramString, paramVarArgs);
    AppMethodBeat.o(224654);
    return paramObject;
  }
  
  public final void a(Context paramContext, String paramString)
  {
    AppMethodBeat.i(224594);
    ry.a(paramContext);
    if (!ry.p.isEmpty())
    {
      Iterator localIterator = ry.p.iterator();
      while (localIterator.hasNext())
      {
        Object localObject = (ry.b)localIterator.next();
        String str = "com.tencent.mapsdk." + ((ry.b)localObject).d;
        Class localClass = Util.findClass(str, getClass().getClassLoader());
        localObject = null;
        if (localClass != null) {
          localObject = this.a.b(str);
        }
        if ((localObject instanceof ry.a)) {
          ((ry.a)localObject).a(paramContext, paramString);
        }
        if ((localObject instanceof rv)) {
          this.a = ((rv)localObject);
        } else if ((localObject instanceof rx)) {
          this.e = ((rx)localObject);
        } else if ((localObject instanceof ru)) {
          this.d = ((ru)localObject);
        }
      }
    }
    this.b = ((s)this.a.b("com.tencent.mapsdk.core.MapDelegateFactoryImpl"));
    AppMethodBeat.o(224594);
  }
  
  public final ClassLoader b()
  {
    AppMethodBeat.i(224646);
    ClassLoader localClassLoader = this.a.b();
    AppMethodBeat.o(224646);
    return localClassLoader;
  }
  
  public final Object b(String paramString)
  {
    AppMethodBeat.i(224625);
    paramString = this.a.b(paramString);
    AppMethodBeat.o(224625);
    return paramString;
  }
  
  public final int c()
  {
    AppMethodBeat.i(224680);
    int i = this.a.c();
    AppMethodBeat.o(224680);
    return i;
  }
  
  public final File d()
  {
    AppMethodBeat.i(224689);
    File localFile = this.a.d();
    AppMethodBeat.o(224689);
    return localFile;
  }
  
  public final void e() {}
  
  public final void f() {}
  
  public final void g() {}
  
  public final void h() {}
  
  public final void i() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.u
 * JD-Core Version:    0.7.0.1
 */
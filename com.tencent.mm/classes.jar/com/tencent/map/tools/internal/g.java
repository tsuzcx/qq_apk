package com.tencent.map.tools.internal;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.map.tools.sheet.listener.ModuleEncryptListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;

public class g
{
  private static g f;
  private final String a;
  private HandlerThread b;
  private a c;
  private boolean d;
  private Context e;
  private k g;
  private ModuleEncryptListener h;
  private File i;
  private Looper j;
  
  private g(Context paramContext)
  {
    AppMethodBeat.i(180792);
    this.a = g.class.getSimpleName();
    this.e = paramContext.getApplicationContext();
    this.b = new HandlerThread("d_thread");
    this.b.start();
    this.j = this.b.getLooper();
    this.c = new a(this.j);
    AppMethodBeat.o(180792);
  }
  
  public static g a()
  {
    return f;
  }
  
  public static g a(Context paramContext)
  {
    AppMethodBeat.i(180793);
    if (f == null) {}
    try
    {
      if (f == null) {
        f = new g(paramContext);
      }
      paramContext = f;
      AppMethodBeat.o(180793);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(180793);
    }
  }
  
  public final void a(ModuleEncryptListener paramModuleEncryptListener)
  {
    this.h = paramModuleEncryptListener;
  }
  
  public final void a(File paramFile)
  {
    this.i = paramFile;
  }
  
  public final void a(String paramString)
  {
    AppMethodBeat.i(224076);
    if ((a.i) && (this.g != null)) {
      this.g.a(paramString.getBytes());
    }
    AppMethodBeat.o(224076);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(180794);
    if ((a.i) && (this.g != null)) {
      this.g.a(paramString1, paramString2);
    }
    AppMethodBeat.o(180794);
  }
  
  public final void b()
  {
    AppMethodBeat.i(224075);
    if (this.d)
    {
      AppMethodBeat.o(224075);
      return;
    }
    if (a.i) {
      this.g = new k(this.e, this.b.getLooper(), this.i, this.h);
    }
    this.d = true;
    AppMethodBeat.o(224075);
  }
  
  public final Looper c()
  {
    return this.j;
  }
  
  public final void d()
  {
    AppMethodBeat.i(224077);
    q.a(this.c, 10005, 0L);
    AppMethodBeat.o(224077);
  }
  
  public final File e()
  {
    AppMethodBeat.i(224078);
    if (this.g != null)
    {
      File localFile = this.g.c();
      AppMethodBeat.o(224078);
      return localFile;
    }
    AppMethodBeat.o(224078);
    return null;
  }
  
  final class a
    extends Handler
  {
    private StringBuilder b;
    
    public a(Looper paramLooper)
    {
      super();
      AppMethodBeat.i(180790);
      this.b = new StringBuilder(1024);
      AppMethodBeat.o(180790);
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(180791);
      super.handleMessage(paramMessage);
      for (;;)
      {
        try
        {
          int i = paramMessage.what;
          switch (i)
          {
          case 10003: 
          case 10004: 
          default: 
            AppMethodBeat.o(180791);
            return;
          }
        }
        catch (Throwable paramMessage)
        {
          AppMethodBeat.o(180791);
          return;
        }
        AppMethodBeat.o(180791);
        return;
        if ((a.i) && (g.a(g.this) != null)) {
          g.a(g.this).b();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.map.tools.internal.g
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.map.tools.internal;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.map.tools.sheet.listener.ModuleEncryptListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class g
{
  private static g j;
  public HandlerThread a;
  a b;
  public boolean c;
  public Context d;
  public k e;
  public ModuleEncryptListener f;
  public File g;
  Looper h;
  private final String i;
  
  private g(Context paramContext)
  {
    AppMethodBeat.i(180792);
    this.i = g.class.getSimpleName();
    this.d = paramContext.getApplicationContext();
    this.a = new HandlerThread("d_thread");
    this.a.start();
    this.h = this.a.getLooper();
    this.b = new a(this.h);
    AppMethodBeat.o(180792);
  }
  
  public static g a()
  {
    return j;
  }
  
  public static g a(Context paramContext)
  {
    AppMethodBeat.i(180793);
    try
    {
      if (j == null) {
        j = new g(paramContext);
      }
      paramContext = j;
      AppMethodBeat.o(180793);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(180793);
    }
  }
  
  public final void a(String paramString1, String paramString2)
  {
    AppMethodBeat.i(180794);
    if ((a.i) && (this.e != null))
    {
      k localk = this.e;
      if (a.i)
      {
        paramString1 = localk.a.format(new Date()) + "," + paramString1 + "," + paramString2;
        q.a(localk.b, 10001, paramString1);
      }
    }
    AppMethodBeat.o(180794);
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
        if ((a.i) && (g.a(g.this) != null))
        {
          paramMessage = g.a(g.this);
          if (a.i) {
            q.a(paramMessage.b, 10004, 0L);
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.map.tools.internal.g
 * JD-Core Version:    0.7.0.1
 */
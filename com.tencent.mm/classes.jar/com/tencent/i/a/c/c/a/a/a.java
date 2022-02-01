package com.tencent.i.a.c.c.a.a;

import android.app.Activity;
import android.app.Application;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.h.c.h;
import com.tencent.i.a.c.c.a.a.a.c;
import com.tencent.i.a.f;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static MMHandler PvY;
  private static final com.tencent.h.c.g<a> SpT;
  private static boolean sInit;
  public final Map<String, b> SsZ;
  public com.tencent.i.a.c.c.a.a.a.a Sta;
  public final c Stb;
  public final f Stc;
  public com.tencent.h.b.b Std;
  
  static
  {
    AppMethodBeat.i(214808);
    sInit = false;
    SpT = new com.tencent.h.c.g() {};
    AppMethodBeat.o(214808);
  }
  
  private a()
  {
    AppMethodBeat.i(214802);
    this.SsZ = new HashMap();
    this.Sta = null;
    this.Stb = new c()
    {
      public final void b(String paramAnonymousString, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(214797);
        if ((TextUtils.isEmpty(paramAnonymousString)) || (paramAnonymousMotionEvent == null))
        {
          AppMethodBeat.o(214797);
          return;
        }
        h.i("TuringTouch", "[method: onTouch sMyTouchCallback] " + paramAnonymousMotionEvent.getActionMasked());
        a.a(a.this, paramAnonymousString, paramAnonymousMotionEvent);
        AppMethodBeat.o(214797);
      }
    };
    this.Stc = new f()
    {
      public final boolean a(com.tencent.i.a.g paramAnonymousg, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(214798);
        if ((paramAnonymousg == null) || (paramAnonymousMotionEvent == null))
        {
          AppMethodBeat.o(214798);
          return false;
        }
        paramAnonymousg = a.eH(paramAnonymousg);
        if (!a.a(a.this).containsKey(paramAnonymousg))
        {
          AppMethodBeat.o(214798);
          return false;
        }
        h.i("TuringTouch", "[method: onTouch ] " + paramAnonymousMotionEvent.getAction());
        a.a(a.this, paramAnonymousg, paramAnonymousMotionEvent);
        AppMethodBeat.o(214798);
        return false;
      }
    };
    this.Std = new com.tencent.h.b.b()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(214799);
        if ((paramAnonymousView == null) || (paramAnonymousMotionEvent == null))
        {
          AppMethodBeat.o(214799);
          return false;
        }
        h.i("TuringTouch", "[method: onTouch ] " + paramAnonymousMotionEvent.getAction());
        a.a(a.this, a.eH(paramAnonymousView), paramAnonymousMotionEvent);
        AppMethodBeat.o(214799);
        return false;
      }
    };
    if (!sInit)
    {
      sInit = true;
      hqG();
    }
    AppMethodBeat.o(214802);
  }
  
  public static void a(Activity paramActivity, com.tencent.i.a.c.c.a.a.a.a parama)
  {
    AppMethodBeat.i(214804);
    if ((paramActivity == null) || (parama == null))
    {
      AppMethodBeat.o(214804);
      return;
    }
    paramActivity = paramActivity.getApplication();
    if (paramActivity != null) {
      paramActivity.unregisterActivityLifecycleCallbacks(parama);
    }
    AppMethodBeat.o(214804);
  }
  
  public static String eG(Object paramObject)
  {
    AppMethodBeat.i(214805);
    int i = paramObject.hashCode();
    AppMethodBeat.o(214805);
    return String.valueOf(i);
  }
  
  public static a hqF()
  {
    AppMethodBeat.i(214801);
    a locala = (a)SpT.get();
    AppMethodBeat.o(214801);
    return locala;
  }
  
  private void hqG()
  {
    try
    {
      AppMethodBeat.i(214803);
      h.i("TuringTouch", "doInitDispatch");
      PvY = new a("TuringDispatch");
      AppMethodBeat.o(214803);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final class a
    extends MMHandler
    implements com.tencent.i.a.c.c.a.b
  {
    public a(String paramString)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(214800);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(214800);
        return;
        try
        {
          Object localObject = paramMessage.obj;
          if (localObject == null)
          {
            AppMethodBeat.o(214800);
            return;
          }
          boolean bool = paramMessage.obj instanceof a.b;
          if (!bool)
          {
            AppMethodBeat.o(214800);
            return;
          }
          paramMessage = (a.b)paramMessage.obj;
          if (a.a(a.this) != null)
          {
            bool = a.a(a.this).containsKey(paramMessage.key);
            if (bool) {}
          }
          else
          {
            AppMethodBeat.o(214800);
            return;
          }
          localObject = (b)a.a(a.this).get(paramMessage.key);
          if (localObject != null) {
            ((b)localObject).a(paramMessage.Sth, this);
          }
          AppMethodBeat.o(214800);
          return;
        }
        catch (Throwable paramMessage)
        {
          paramMessage = paramMessage;
          AppMethodBeat.o(214800);
          return;
        }
        finally {}
      }
    }
    
    public final MMHandler hqz()
    {
      return this;
    }
  }
  
  final class b
  {
    MotionEvent Sth;
    String key;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.i.a.c.c.a.a.a
 * JD-Core Version:    0.7.0.1
 */
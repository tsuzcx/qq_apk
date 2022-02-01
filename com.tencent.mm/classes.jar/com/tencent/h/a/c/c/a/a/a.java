package com.tencent.h.a.c.c.a.a;

import android.app.Activity;
import android.app.Application;
import android.os.Message;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.g.c.h;
import com.tencent.g.c.i;
import com.tencent.h.a.c.c.a.a.a.c;
import com.tencent.h.a.f;
import com.tencent.h.a.g;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.MMHandler;
import java.util.HashMap;
import java.util.Map;

public final class a
{
  private static MMHandler WQr;
  private static final h<a> ZRy;
  private static boolean sInit;
  public final Map<String, b> ZUC;
  public com.tencent.h.a.c.c.a.a.a.a ZUD;
  public final c ZUE;
  public final f ZUF;
  public com.tencent.g.b.b ZUG;
  
  static
  {
    AppMethodBeat.i(207578);
    sInit = false;
    ZRy = new h() {};
    AppMethodBeat.o(207578);
  }
  
  private a()
  {
    AppMethodBeat.i(207568);
    this.ZUC = new HashMap();
    this.ZUD = null;
    this.ZUE = new c()
    {
      public final void b(String paramAnonymousString, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(208494);
        if ((TextUtils.isEmpty(paramAnonymousString)) || (paramAnonymousMotionEvent == null))
        {
          AppMethodBeat.o(208494);
          return;
        }
        i.i("TuringTouch", "[method: onTouch sMyTouchCallback] " + paramAnonymousMotionEvent.getActionMasked());
        a.a(a.this, paramAnonymousString, paramAnonymousMotionEvent);
        AppMethodBeat.o(208494);
      }
    };
    this.ZUF = new f()
    {
      public final boolean a(g paramAnonymousg, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(208786);
        if ((paramAnonymousg == null) || (paramAnonymousMotionEvent == null))
        {
          AppMethodBeat.o(208786);
          return false;
        }
        paramAnonymousg = a.eN(paramAnonymousg);
        if (!a.a(a.this).containsKey(paramAnonymousg))
        {
          AppMethodBeat.o(208786);
          return false;
        }
        i.i("TuringTouch", "[method: onTouch ] " + paramAnonymousMotionEvent.getAction());
        a.a(a.this, paramAnonymousg, paramAnonymousMotionEvent);
        AppMethodBeat.o(208786);
        return false;
      }
    };
    this.ZUG = new com.tencent.g.b.b()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(207422);
        if ((paramAnonymousView == null) || (paramAnonymousMotionEvent == null))
        {
          AppMethodBeat.o(207422);
          return false;
        }
        i.i("TuringTouch", "[method: onTouch ] " + paramAnonymousMotionEvent.getAction());
        a.a(a.this, a.eN(paramAnonymousView), paramAnonymousMotionEvent);
        AppMethodBeat.o(207422);
        return false;
      }
    };
    if (!sInit)
    {
      sInit = true;
      iup();
    }
    AppMethodBeat.o(207568);
  }
  
  public static void a(Activity paramActivity, com.tencent.h.a.c.c.a.a.a.a parama)
  {
    AppMethodBeat.i(207570);
    if ((paramActivity == null) || (parama == null))
    {
      AppMethodBeat.o(207570);
      return;
    }
    paramActivity = paramActivity.getApplication();
    if (paramActivity != null) {
      paramActivity.unregisterActivityLifecycleCallbacks(parama);
    }
    AppMethodBeat.o(207570);
  }
  
  public static String eM(Object paramObject)
  {
    AppMethodBeat.i(207572);
    int i = paramObject.hashCode();
    AppMethodBeat.o(207572);
    return String.valueOf(i);
  }
  
  public static a iuo()
  {
    AppMethodBeat.i(207567);
    a locala = (a)ZRy.get();
    AppMethodBeat.o(207567);
    return locala;
  }
  
  private void iup()
  {
    try
    {
      AppMethodBeat.i(207569);
      i.i("TuringTouch", "doInitDispatch");
      WQr = new a("TuringDispatch");
      AppMethodBeat.o(207569);
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
    implements com.tencent.h.a.c.c.a.b
  {
    public a(String paramString)
    {
      super();
    }
    
    public final void handleMessage(Message paramMessage)
    {
      AppMethodBeat.i(208474);
      switch (paramMessage.what)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(208474);
        return;
        try
        {
          Object localObject = paramMessage.obj;
          if (localObject == null)
          {
            AppMethodBeat.o(208474);
            return;
          }
          boolean bool = paramMessage.obj instanceof a.b;
          if (!bool)
          {
            AppMethodBeat.o(208474);
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
            AppMethodBeat.o(208474);
            return;
          }
          localObject = (b)a.a(a.this).get(paramMessage.key);
          if (localObject != null) {
            ((b)localObject).a(paramMessage.ZUK, this);
          }
          AppMethodBeat.o(208474);
          return;
        }
        catch (Throwable paramMessage)
        {
          paramMessage = paramMessage;
          AppMethodBeat.o(208474);
          return;
        }
        finally {}
      }
    }
    
    public final MMHandler iui()
    {
      return this;
    }
  }
  
  final class b
  {
    MotionEvent ZUK;
    String key;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.h.a.c.c.a.a.a
 * JD-Core Version:    0.7.0.1
 */
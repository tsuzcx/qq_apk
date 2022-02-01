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
  private static MMHandler aezK;
  private static final h<a> ahVU;
  private static boolean sInit;
  public final Map<String, b> ahZc;
  public com.tencent.h.a.c.c.a.a.a.a ahZd;
  public final c ahZe;
  public final f ahZf;
  public com.tencent.g.b.b ahZg;
  
  static
  {
    AppMethodBeat.i(212278);
    sInit = false;
    ahVU = new h() {};
    AppMethodBeat.o(212278);
  }
  
  private a()
  {
    AppMethodBeat.i(212250);
    this.ahZc = new HashMap();
    this.ahZd = null;
    this.ahZe = new c()
    {
      public final void b(String paramAnonymousString, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(212246);
        if ((TextUtils.isEmpty(paramAnonymousString)) || (paramAnonymousMotionEvent == null))
        {
          AppMethodBeat.o(212246);
          return;
        }
        i.i("TuringTouch", "[method: onTouch sMyTouchCallback] " + paramAnonymousMotionEvent.getActionMasked());
        a.a(a.this, paramAnonymousString, paramAnonymousMotionEvent);
        AppMethodBeat.o(212246);
      }
    };
    this.ahZf = new f()
    {
      public final boolean a(g paramAnonymousg, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(212249);
        if ((paramAnonymousg == null) || (paramAnonymousMotionEvent == null))
        {
          AppMethodBeat.o(212249);
          return false;
        }
        paramAnonymousg = a.hk(paramAnonymousg);
        if (!a.a(a.this).containsKey(paramAnonymousg))
        {
          AppMethodBeat.o(212249);
          return false;
        }
        i.i("TuringTouch", "[method: onTouch ] " + paramAnonymousMotionEvent.getAction());
        a.a(a.this, paramAnonymousg, paramAnonymousMotionEvent);
        AppMethodBeat.o(212249);
        return false;
      }
    };
    this.ahZg = new com.tencent.g.b.b()
    {
      public final boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(212252);
        if ((paramAnonymousView == null) || (paramAnonymousMotionEvent == null))
        {
          AppMethodBeat.o(212252);
          return false;
        }
        i.i("TuringTouch", "[method: onTouch ] " + paramAnonymousMotionEvent.getAction());
        a.a(a.this, a.hk(paramAnonymousView), paramAnonymousMotionEvent);
        AppMethodBeat.o(212252);
        return false;
      }
    };
    if (!sInit)
    {
      sInit = true;
      kdL();
    }
    AppMethodBeat.o(212250);
  }
  
  public static void a(Activity paramActivity, com.tencent.h.a.c.c.a.a.a.a parama)
  {
    AppMethodBeat.i(212267);
    if ((paramActivity == null) || (parama == null))
    {
      AppMethodBeat.o(212267);
      return;
    }
    paramActivity = paramActivity.getApplication();
    if (paramActivity != null) {
      paramActivity.unregisterActivityLifecycleCallbacks(parama);
    }
    AppMethodBeat.o(212267);
  }
  
  public static String hj(Object paramObject)
  {
    AppMethodBeat.i(212273);
    int i = paramObject.hashCode();
    AppMethodBeat.o(212273);
    return String.valueOf(i);
  }
  
  public static a kdK()
  {
    AppMethodBeat.i(212239);
    a locala = (a)ahVU.get();
    AppMethodBeat.o(212239);
    return locala;
  }
  
  private void kdL()
  {
    try
    {
      AppMethodBeat.i(212258);
      i.i("TuringTouch", "doInitDispatch");
      aezK = new a("TuringDispatch");
      AppMethodBeat.o(212258);
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
      AppMethodBeat.i(212262);
      switch (paramMessage.what)
      {
      default: 
        AppMethodBeat.o(212262);
        return;
      }
      try
      {
        Object localObject = paramMessage.obj;
        if (localObject == null) {
          return;
        }
        boolean bool = paramMessage.obj instanceof a.b;
        if (!bool) {
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
          return;
        }
        localObject = (b)a.a(a.this).get(paramMessage.key);
        if (localObject != null) {
          ((b)localObject).a(paramMessage.aKX, this);
        }
        return;
      }
      finally
      {
        AppMethodBeat.o(212262);
      }
    }
    
    public final MMHandler kdE()
    {
      return this;
    }
  }
  
  final class b
  {
    MotionEvent aKX;
    String key;
    
    private b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.h.a.c.c.a.a.a
 * JD-Core Version:    0.7.0.1
 */
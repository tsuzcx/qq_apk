package com.tencent.liteav.screencapture;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.VirtualDisplay;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjection.Callback;
import android.os.Handler;
import android.os.Looper;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.util.e;
import com.tencent.liteav.basic.util.h;
import com.tencent.liteav.basic.util.h.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.rtmp.video.TXScreenCapture.TXScreenCaptureAssistantActivity;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@TargetApi(21)
public class c
{
  private static volatile c a = null;
  private byte _hellAccFlag_;
  private final Context b;
  private final Handler c;
  private final Map<Surface, a> d;
  private boolean e;
  private MediaProjection f;
  private h g;
  private boolean h;
  private MediaProjection.Callback i;
  private h.a j;
  
  public c(Context paramContext)
  {
    AppMethodBeat.i(187032);
    this.d = new HashMap();
    this.e = false;
    this.i = new MediaProjection.Callback()
    {
      public void onStop()
      {
        AppMethodBeat.i(187029);
        TXCLog.e("VirtualDisplayManager", "MediaProjection session is no longer valid");
        Object localObject = new HashMap(c.a(c.this));
        c.a(c.this).clear();
        localObject = ((Map)localObject).values().iterator();
        while (((Iterator)localObject).hasNext())
        {
          c.a locala = (c.a)((Iterator)localObject).next();
          if (locala.d != null) {
            if (locala.e != null) {
              locala.d.a();
            } else {
              locala.d.a(false, false);
            }
          }
        }
        c.a(c.this, false);
        AppMethodBeat.o(187029);
      }
    };
    this.j = new h.a()
    {
      public void a()
      {
        AppMethodBeat.i(187051);
        boolean bool = c.a(c.this, c.b(c.this));
        if (c.c(c.this) == bool)
        {
          AppMethodBeat.o(187051);
          return;
        }
        c.b(c.this, bool);
        Iterator localIterator = c.a(c.this).values().iterator();
        while (localIterator.hasNext())
        {
          c.a locala = (c.a)localIterator.next();
          if (locala.d != null) {
            locala.d.a(bool);
          }
        }
        AppMethodBeat.o(187051);
      }
    };
    this.b = paramContext.getApplicationContext();
    this.c = new e(Looper.getMainLooper());
    this.h = b(paramContext);
    AppMethodBeat.o(187032);
  }
  
  public static c a(Context paramContext)
  {
    AppMethodBeat.i(187031);
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new c(paramContext);
      }
      paramContext = a;
      AppMethodBeat.o(187031);
      return paramContext;
    }
    finally
    {
      AppMethodBeat.o(187031);
    }
  }
  
  private void a()
  {
    AppMethodBeat.i(187035);
    Iterator localIterator = this.d.values().iterator();
    while (localIterator.hasNext())
    {
      a locala = (a)localIterator.next();
      if (locala.e == null)
      {
        locala.e = this.f.createVirtualDisplay("TXCScreenCapture", locala.b, locala.c, 1, 1, locala.a, null, null);
        TXCLog.i("VirtualDisplayManager", "create VirtualDisplay " + locala.e);
        if (locala.d != null) {
          locala.d.a(true, false);
        }
      }
    }
    AppMethodBeat.o(187035);
  }
  
  private void a(boolean paramBoolean)
  {
    AppMethodBeat.i(187036);
    if (!this.d.isEmpty())
    {
      AppMethodBeat.o(187036);
      return;
    }
    if (paramBoolean)
    {
      this.c.postDelayed(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(187030);
          c.a(c.this, false);
          AppMethodBeat.o(187030);
        }
      }, TimeUnit.SECONDS.toMillis(1L));
      AppMethodBeat.o(187036);
      return;
    }
    TXCLog.i("VirtualDisplayManager", "stop media projection session " + this.f);
    if (this.f != null)
    {
      this.f.unregisterCallback(this.i);
      this.f.stop();
      this.f = null;
    }
    if (this.g != null)
    {
      this.g.a();
      this.g = null;
    }
    AppMethodBeat.o(187036);
  }
  
  private boolean b(Context paramContext)
  {
    AppMethodBeat.i(187038);
    paramContext = (WindowManager)paramContext.getSystemService("window");
    if (paramContext == null)
    {
      AppMethodBeat.o(187038);
      return true;
    }
    int k = paramContext.getDefaultDisplay().getRotation();
    if ((k == 0) || (k == 2))
    {
      AppMethodBeat.o(187038);
      return true;
    }
    AppMethodBeat.o(187038);
    return false;
  }
  
  public void a(MediaProjection paramMediaProjection)
  {
    AppMethodBeat.i(187037);
    this.e = false;
    if (paramMediaProjection == null)
    {
      paramMediaProjection = new HashMap(this.d);
      this.d.clear();
      paramMediaProjection = paramMediaProjection.values().iterator();
      while (paramMediaProjection.hasNext())
      {
        a locala = (a)paramMediaProjection.next();
        if (locala.d != null) {
          locala.d.a(false, true);
        }
      }
      AppMethodBeat.o(187037);
      return;
    }
    TXCLog.i("VirtualDisplayManager", "Got session ".concat(String.valueOf(paramMediaProjection)));
    this.f = paramMediaProjection;
    this.f.registerCallback(this.i, this.c);
    a();
    this.g = new h(Looper.getMainLooper(), this.j);
    this.g.a(50, 50);
    a(true);
    AppMethodBeat.o(187037);
  }
  
  public void a(Surface paramSurface)
  {
    AppMethodBeat.i(187034);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      paramSurface = new IllegalStateException("Must call this at main thread!");
      AppMethodBeat.o(187034);
      throw paramSurface;
    }
    if (paramSurface == null)
    {
      AppMethodBeat.o(187034);
      return;
    }
    paramSurface = (a)this.d.remove(paramSurface);
    if ((paramSurface != null) && (paramSurface.e != null))
    {
      paramSurface.e.release();
      TXCLog.i("VirtualDisplayManager", "VirtualDisplay released, " + paramSurface.e);
    }
    a(true);
    AppMethodBeat.o(187034);
  }
  
  public void a(Surface paramSurface, int paramInt1, int paramInt2, b paramb)
  {
    AppMethodBeat.i(187033);
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      paramSurface = new IllegalStateException("Must call this method in main thread!");
      AppMethodBeat.o(187033);
      throw paramSurface;
    }
    if (paramSurface == null)
    {
      TXCLog.e("VirtualDisplayManager", "surface is null!");
      paramb.a(false, false);
      AppMethodBeat.o(187033);
      return;
    }
    a locala = new a(null);
    locala.a = paramSurface;
    locala.b = paramInt1;
    locala.c = paramInt2;
    locala.d = paramb;
    locala.e = null;
    this.d.put(paramSurface, locala);
    if (this.f == null)
    {
      if (!this.e)
      {
        this.e = true;
        paramb = new Intent(this.b, TXScreenCapture.TXScreenCaptureAssistantActivity.class);
        paramb.addFlags(268435456);
        paramSurface = this.b;
        paramb = new com.tencent.mm.hellhoundlib.b.a().bc(paramb);
        com.tencent.mm.hellhoundlib.a.a.a(paramSurface, paramb.ahp(), "com/tencent/liteav/screencapture/c", "a", "(Landroid/view/Surface;IILcom/tencent/liteav/screencapture/c$b;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramSurface.startActivity((Intent)paramb.mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramSurface, "com/tencent/liteav/screencapture/c", "a", "(Landroid/view/Surface;IILcom/tencent/liteav/screencapture/c$b;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(187033);
      }
    }
    else {
      a();
    }
    AppMethodBeat.o(187033);
  }
  
  static class a
  {
    public Surface a;
    public int b;
    public int c;
    public c.b d;
    public VirtualDisplay e;
  }
  
  public static abstract interface b
  {
    public abstract void a();
    
    public abstract void a(boolean paramBoolean);
    
    public abstract void a(boolean paramBoolean1, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.liteav.screencapture.c
 * JD-Core Version:    0.7.0.1
 */
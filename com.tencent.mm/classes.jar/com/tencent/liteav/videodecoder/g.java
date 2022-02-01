package com.tencent.liteav.videodecoder;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Surface;
import com.tencent.liteav.basic.c.b;
import com.tencent.liteav.basic.log.TXCLog;
import com.tencent.liteav.basic.structs.TXSNALPacket;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;
import org.json.JSONArray;

public class g
  extends f
{
  private final Object a;
  private Handler b;
  private h c;
  private WeakReference<b> d;
  private Surface e;
  private JSONArray f;
  private boolean g;
  private int h;
  private int i;
  private boolean j;
  
  public g()
  {
    AppMethodBeat.i(229906);
    this.a = new Object();
    AppMethodBeat.o(229906);
  }
  
  private void a()
  {
    AppMethodBeat.i(229913);
    synchronized (this.a)
    {
      if (this.b != null)
      {
        a("start decoder thread failed. already start.");
        AppMethodBeat.o(229913);
        return;
      }
      HandlerThread localHandlerThread = new HandlerThread("video_hw_decoder");
      localHandlerThread.start();
      this.b = new Handler(localHandlerThread.getLooper());
      a("start decoder thread success. id:" + localHandlerThread.getId());
      AppMethodBeat.o(229913);
      return;
    }
  }
  
  private void a(Runnable paramRunnable)
  {
    AppMethodBeat.i(229928);
    synchronized (this.a)
    {
      if (this.b == null)
      {
        AppMethodBeat.o(229928);
        return;
      }
      this.b.post(paramRunnable);
      AppMethodBeat.o(229928);
      return;
    }
  }
  
  private void a(String paramString)
  {
    AppMethodBeat.i(229935);
    TXCLog.i("TXCVideoMediaCodecWrapper", "decoder(" + hashCode() + ") " + paramString);
    AppMethodBeat.o(229935);
  }
  
  private void b()
  {
    AppMethodBeat.i(229920);
    synchronized (this.a)
    {
      if (this.b == null)
      {
        a("stop decoder thread failed. already stop.");
        AppMethodBeat.o(229920);
        return;
      }
      final Handler localHandler = this.b;
      this.b = null;
      localHandler.post(new Runnable()
      {
        public void run()
        {
          AppMethodBeat.i(229884);
          localHandler.getLooper().quit();
          AppMethodBeat.o(229884);
        }
      });
      a("stop decoder thread success.");
      AppMethodBeat.o(229920);
      return;
    }
  }
  
  public int GetDecodeCost()
  {
    AppMethodBeat.i(230080);
    int k = super.GetDecodeCost();
    AppMethodBeat.o(230080);
    return k;
  }
  
  public void a(final int paramInt1, final int paramInt2)
  {
    AppMethodBeat.i(230066);
    this.h = paramInt1;
    this.i = paramInt2;
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(229869);
        g.a(g.this, paramInt1, paramInt2);
        AppMethodBeat.o(229869);
      }
    });
    AppMethodBeat.o(230066);
  }
  
  public void a(final JSONArray paramJSONArray)
  {
    AppMethodBeat.i(230061);
    this.f = paramJSONArray;
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(229880);
        g.a(g.this, paramJSONArray);
        AppMethodBeat.o(229880);
      }
    });
    AppMethodBeat.o(230061);
  }
  
  public int config(final Surface paramSurface)
  {
    AppMethodBeat.i(230055);
    this.e = paramSurface;
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(229886);
        g.a(g.this, paramSurface);
        AppMethodBeat.o(229886);
      }
    });
    AppMethodBeat.o(230055);
    return 0;
  }
  
  public void decode(final TXSNALPacket paramTXSNALPacket)
  {
    AppMethodBeat.i(230075);
    this.j = a(paramTXSNALPacket);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(229893);
        g.a(g.this, paramTXSNALPacket);
        AppMethodBeat.o(229893);
      }
    });
    AppMethodBeat.o(230075);
  }
  
  public void enableLimitDecCache(final boolean paramBoolean)
  {
    AppMethodBeat.i(230065);
    this.g = paramBoolean;
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(229881);
        g.a(g.this, paramBoolean);
        AppMethodBeat.o(229881);
      }
    });
    AppMethodBeat.o(230065);
  }
  
  public void setListener(final h paramh)
  {
    AppMethodBeat.i(230048);
    this.c = paramh;
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(229891);
        g.a(g.this, paramh);
        AppMethodBeat.o(229891);
      }
    });
    AppMethodBeat.o(230048);
  }
  
  public void setNotifyListener(final WeakReference<b> paramWeakReference)
  {
    AppMethodBeat.i(230050);
    this.d = paramWeakReference;
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(229882);
        g.a(g.this, paramWeakReference);
        AppMethodBeat.o(229882);
      }
    });
    AppMethodBeat.o(230050);
  }
  
  public int start(final ByteBuffer paramByteBuffer1, final ByteBuffer paramByteBuffer2, final boolean paramBoolean1, final boolean paramBoolean2)
  {
    AppMethodBeat.i(230068);
    this.j = paramBoolean2;
    a();
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(229879);
        g.a(g.this, "start decoder.");
        g.b(g.this, g.a(g.this));
        g.b(g.this, g.b(g.this));
        g.b(g.this, g.c(g.this));
        g.b(g.this, g.d(g.this));
        g.b(g.this, g.e(g.this));
        g.b(g.this, g.f(g.this), g.g(g.this));
        g.a(g.this, paramByteBuffer1, paramByteBuffer2, paramBoolean1, paramBoolean2);
        g.a(g.this, "start decoder finish.");
        AppMethodBeat.o(229879);
      }
    });
    AppMethodBeat.o(230068);
    return 0;
  }
  
  public void stop()
  {
    AppMethodBeat.i(230072);
    a(new Runnable()
    {
      public void run()
      {
        AppMethodBeat.i(229870);
        g.a(g.this, "stop decoder.");
        g.h(g.this);
        g.a(g.this, "stop decoder finish.");
        AppMethodBeat.o(229870);
      }
    });
    b();
    AppMethodBeat.o(230072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.liteav.videodecoder.g
 * JD-Core Version:    0.7.0.1
 */
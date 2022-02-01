package com.tencent.e.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;
import com.tencent.e.i.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class f
  extends a
{
  public a Kbo;
  
  public f()
  {
    AppMethodBeat.i(183372);
    this.Kbo = new a((byte)0);
    AppMethodBeat.o(183372);
  }
  
  protected final a.a fEu()
  {
    return this.Kbo;
  }
  
  public final String getName()
  {
    return "UIPool";
  }
  
  public final void j(k<?> paramk)
  {
    AppMethodBeat.i(183374);
    this.Kbo.aAO.removeCallbacks(paramk);
    AppMethodBeat.o(183374);
  }
  
  protected final void onShutdown()
  {
    AppMethodBeat.i(183373);
    this.Kbo.aAO.removeCallbacksAndMessages(null);
    AppMethodBeat.o(183373);
  }
  
  public static final class a
    implements a.a
  {
    public Handler aAO;
    
    private a()
    {
      AppMethodBeat.i(183370);
      this.aAO = new Handler(Looper.getMainLooper())
      {
        public final void dispatchMessage(Message paramAnonymousMessage)
        {
          AppMethodBeat.i(183368);
          if ((paramAnonymousMessage.getCallback() != null) && ((paramAnonymousMessage.getCallback() instanceof k)) && (((k)paramAnonymousMessage.getCallback()).isCancelled()))
          {
            AppMethodBeat.o(183368);
            return;
          }
          super.dispatchMessage(paramAnonymousMessage);
          AppMethodBeat.o(183368);
        }
      };
      AppMethodBeat.o(183370);
    }
    
    public final void i(k<?> paramk)
    {
      AppMethodBeat.i(183371);
      this.aAO.postDelayed(paramk, paramk.getDelay(TimeUnit.MILLISECONDS));
      AppMethodBeat.o(183371);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.e.h.f
 * JD-Core Version:    0.7.0.1
 */
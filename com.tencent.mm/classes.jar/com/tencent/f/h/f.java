package com.tencent.f.h;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Printer;
import com.tencent.f.i.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class f
  extends a
{
  public a RUC;
  
  public f()
  {
    AppMethodBeat.i(183372);
    this.RUC = new a((byte)0);
    AppMethodBeat.o(183372);
  }
  
  public final String getName()
  {
    return "UIPool";
  }
  
  protected final a.a hmw()
  {
    return this.RUC;
  }
  
  public final void i(k<?> paramk)
  {
    AppMethodBeat.i(183374);
    this.RUC.aDv.removeCallbacks(paramk);
    AppMethodBeat.o(183374);
  }
  
  protected final void onShutdown()
  {
    AppMethodBeat.i(183373);
    this.RUC.aDv.removeCallbacksAndMessages(null);
    AppMethodBeat.o(183373);
  }
  
  public static final class a
    implements a.a
  {
    public Handler aDv;
    
    private a()
    {
      AppMethodBeat.i(183370);
      this.aDv = new Handler(Looper.getMainLooper())
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
    
    public final void h(k<?> paramk)
    {
      AppMethodBeat.i(183371);
      this.aDv.postDelayed(paramk, paramk.getDelay(TimeUnit.MILLISECONDS));
      AppMethodBeat.o(183371);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.f.h.f
 * JD-Core Version:    0.7.0.1
 */
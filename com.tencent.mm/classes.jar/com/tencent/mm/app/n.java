package com.tencent.mm.app;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface n
{
  public abstract void onAppBackground(String paramString);
  
  public abstract void onAppForeground(String paramString);
  
  public static abstract class a
    implements n
  {
    n wrapper = new n()
    {
      public final void onAppBackground(final String paramAnonymousString)
      {
        AppMethodBeat.i(131786);
        if (n.a.this.getHandler() != null)
        {
          n.a.this.getHandler().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(131784);
              n.a.this.onAppBackground(paramAnonymousString);
              AppMethodBeat.o(131784);
            }
          });
          AppMethodBeat.o(131786);
          return;
        }
        n.a.this.onAppBackground(paramAnonymousString);
        AppMethodBeat.o(131786);
      }
      
      public final void onAppForeground(final String paramAnonymousString)
      {
        AppMethodBeat.i(131785);
        if (n.a.this.getHandler() != null)
        {
          n.a.this.getHandler().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(131783);
              n.a.this.onAppForeground(paramAnonymousString);
              AppMethodBeat.o(131783);
            }
          });
          AppMethodBeat.o(131785);
          return;
        }
        n.a.this.onAppForeground(paramAnonymousString);
        AppMethodBeat.o(131785);
      }
    };
    
    public void alive()
    {
      AppForegroundDelegate.cSQ.a(this.wrapper);
    }
    
    public void dead()
    {
      AppForegroundDelegate.cSQ.b(this.wrapper);
    }
    
    Handler getHandler()
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.n
 * JD-Core Version:    0.7.0.1
 */
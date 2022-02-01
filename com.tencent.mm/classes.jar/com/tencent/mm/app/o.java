package com.tencent.mm.app;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface o
{
  public abstract void onAppBackground(String paramString);
  
  public abstract void onAppForeground(String paramString);
  
  public static abstract class a
    implements o
  {
    o wrapper = new o()
    {
      public final void onAppBackground(final String paramAnonymousString)
      {
        AppMethodBeat.i(131786);
        if (o.a.this.getHandler() != null)
        {
          o.a.this.getHandler().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(131784);
              o.a.this.onAppBackground(paramAnonymousString);
              AppMethodBeat.o(131784);
            }
          });
          AppMethodBeat.o(131786);
          return;
        }
        o.a.this.onAppBackground(paramAnonymousString);
        AppMethodBeat.o(131786);
      }
      
      public final void onAppForeground(final String paramAnonymousString)
      {
        AppMethodBeat.i(131785);
        if (o.a.this.getHandler() != null)
        {
          o.a.this.getHandler().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(131783);
              o.a.this.onAppForeground(paramAnonymousString);
              AppMethodBeat.o(131783);
            }
          });
          AppMethodBeat.o(131785);
          return;
        }
        o.a.this.onAppForeground(paramAnonymousString);
        AppMethodBeat.o(131785);
      }
    };
    
    public void alive()
    {
      AppForegroundDelegate.djR.a(this.wrapper);
    }
    
    public void dead()
    {
      AppForegroundDelegate.djR.b(this.wrapper);
    }
    
    Handler getHandler()
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.o
 * JD-Core Version:    0.7.0.1
 */
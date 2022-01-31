package com.tencent.mm.app;

import android.os.Handler;
import com.tencent.matrix.trace.core.AppMethodBeat;

public abstract interface j
{
  public abstract void onAppBackground(String paramString);
  
  public abstract void onAppForeground(String paramString);
  
  public static abstract class a
    implements j
  {
    j wrapper = new j()
    {
      public final void onAppBackground(final String paramAnonymousString)
      {
        AppMethodBeat.i(146098);
        if (j.a.this.getHandler() != null)
        {
          j.a.this.getHandler().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(146096);
              j.a.this.onAppBackground(paramAnonymousString);
              AppMethodBeat.o(146096);
            }
          });
          AppMethodBeat.o(146098);
          return;
        }
        j.a.this.onAppBackground(paramAnonymousString);
        AppMethodBeat.o(146098);
      }
      
      public final void onAppForeground(final String paramAnonymousString)
      {
        AppMethodBeat.i(146097);
        if (j.a.this.getHandler() != null)
        {
          j.a.this.getHandler().post(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(146095);
              j.a.this.onAppForeground(paramAnonymousString);
              AppMethodBeat.o(146095);
            }
          });
          AppMethodBeat.o(146097);
          return;
        }
        j.a.this.onAppForeground(paramAnonymousString);
        AppMethodBeat.o(146097);
      }
    };
    
    public void alive()
    {
      AppForegroundDelegate.bXk.a(this.wrapper);
    }
    
    public void dead()
    {
      AppForegroundDelegate.bXk.b(this.wrapper);
    }
    
    Handler getHandler()
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.app.j
 * JD-Core Version:    0.7.0.1
 */
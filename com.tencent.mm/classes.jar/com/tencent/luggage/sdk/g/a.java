package com.tencent.luggage.sdk.g;

import android.graphics.Bitmap;
import com.tencent.luggage.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public abstract interface a
  extends b
{
  public abstract String Sy();
  
  public abstract void a(b paramb);
  
  public static final class a
  {
    private static final a cDg;
    
    static
    {
      AppMethodBeat.i(169461);
      cDg = new a()
      {
        public final String Sy()
        {
          return null;
        }
        
        public final void a(final a.b paramAnonymousb)
        {
          AppMethodBeat.i(169459);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(169458);
              paramAnonymousb.j(null);
              AppMethodBeat.o(169458);
            }
          });
          AppMethodBeat.o(169459);
        }
      };
      AppMethodBeat.o(169461);
    }
    
    public static a d(e parame)
    {
      AppMethodBeat.i(169460);
      a locala = (a)parame.K(a.class);
      parame = locala;
      if (locala == null) {
        parame = cDg;
      }
      AppMethodBeat.o(169460);
      return parame;
    }
  }
  
  public static abstract interface b
  {
    public abstract void j(Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.g.a
 * JD-Core Version:    0.7.0.1
 */
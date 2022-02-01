package com.tencent.luggage.sdk.f;

import android.graphics.Bitmap;
import com.tencent.luggage.a.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.f;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;

public abstract interface a
  extends b
{
  public abstract String Pa();
  
  public abstract void a(b paramb);
  
  public static final class a
  {
    private static final a cCD;
    
    static
    {
      AppMethodBeat.i(169461);
      cCD = new a()
      {
        public final String Pa()
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
              paramAnonymousb.o(null);
              AppMethodBeat.o(169458);
            }
          });
          AppMethodBeat.o(169459);
        }
      };
      AppMethodBeat.o(169461);
    }
    
    public static a b(f paramf)
    {
      AppMethodBeat.i(169460);
      a locala = (a)paramf.M(a.class);
      paramf = locala;
      if (locala == null) {
        paramf = cCD;
      }
      AppMethodBeat.o(169460);
      return paramf;
    }
  }
  
  public static abstract interface b
  {
    public abstract void o(Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.luggage.sdk.f.a
 * JD-Core Version:    0.7.0.1
 */
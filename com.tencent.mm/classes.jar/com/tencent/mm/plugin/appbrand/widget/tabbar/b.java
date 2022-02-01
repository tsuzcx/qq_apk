package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends d
{
  public b(String paramString, c paramc)
  {
    super(paramString, paramc);
  }
  
  public final void bFL()
  {
    AppMethodBeat.i(135541);
    if (this.npQ != null)
    {
      com.tencent.e.h.LTJ.aR(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "Base64IconLoader";
        }
        
        public final void run()
        {
          AppMethodBeat.i(135540);
          try
          {
            b localb = b.this;
            Object localObject = Base64.decode(b.this.npQ, 0);
            localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
            if (localObject == null) {
              localb.npR.a("Failed to load icon via base64 icon", localb);
            }
            b.this.R((Bitmap)localObject);
            AppMethodBeat.o(135540);
            return;
          }
          catch (Exception localException)
          {
            b.this.npR.a("Failed to load icon via base64 icon", b.this);
            AppMethodBeat.o(135540);
          }
        }
      });
      AppMethodBeat.o(135541);
      return;
    }
    this.npR.a("Failed to load icon via base64 icon", this);
    AppMethodBeat.o(135541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.b
 * JD-Core Version:    0.7.0.1
 */
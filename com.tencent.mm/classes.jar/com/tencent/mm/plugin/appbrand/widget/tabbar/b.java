package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class b
  extends d
{
  public b(String paramString, c paramc)
  {
    super(paramString, paramc);
  }
  
  public final void cdf()
  {
    AppMethodBeat.i(135541);
    if (this.oFe != null)
    {
      com.tencent.f.h.RTc.aX(new com.tencent.f.i.h()
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
            Object localObject = Base64.decode(b.this.oFe, 0);
            localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
            if (localObject == null) {
              localb.oFf.a("Failed to load icon via base64 icon", localb);
            }
            b.this.X((Bitmap)localObject);
            AppMethodBeat.o(135540);
            return;
          }
          catch (Exception localException)
          {
            b.this.oFf.a("Failed to load icon via base64 icon", b.this);
            AppMethodBeat.o(135540);
          }
        }
      });
      AppMethodBeat.o(135541);
      return;
    }
    this.oFf.a("Failed to load icon via base64 icon", this);
    AppMethodBeat.o(135541);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.b
 * JD-Core Version:    0.7.0.1
 */
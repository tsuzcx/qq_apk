package com.tencent.mm.plugin.appbrand.widget.i;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class b$1
  implements Runnable
{
  b$1(b paramb) {}
  
  public final void run()
  {
    AppMethodBeat.i(87561);
    try
    {
      b localb = this.jxb;
      Object localObject = Base64.decode(this.jxb.jxc, 0);
      localObject = BitmapFactory.decodeByteArray((byte[])localObject, 0, localObject.length);
      if (localObject == null) {
        localb.jxd.a("Failed to load icon via base64 icon", localb);
      }
      this.jxb.G((Bitmap)localObject);
      AppMethodBeat.o(87561);
      return;
    }
    catch (Exception localException)
    {
      this.jxb.jxd.a("Failed to load icon via base64 icon", this.jxb);
      AppMethodBeat.o(87561);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.i.b.1
 * JD-Core Version:    0.7.0.1
 */
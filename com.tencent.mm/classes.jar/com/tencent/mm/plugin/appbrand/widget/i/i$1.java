package com.tencent.mm.plugin.appbrand.widget.i;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.o;
import com.tencent.mm.plugin.appbrand.r;
import java.io.File;

final class i$1
  implements Runnable
{
  i$1(i parami) {}
  
  public final void run()
  {
    AppMethodBeat.i(87570);
    Object localObject = this.jxk.hxb.wX().zg(this.jxk.jxc);
    if (localObject == null)
    {
      this.jxk.jxd.a("Failed to load icon via temp file", this.jxk);
      AppMethodBeat.o(87570);
      return;
    }
    localObject = BitmapFactory.decodeFile(((File)localObject).getPath());
    if (localObject != null)
    {
      this.jxk.G((Bitmap)localObject);
      AppMethodBeat.o(87570);
      return;
    }
    this.jxk.jxd.a("Failed to load icon via temp file", this.jxk);
    AppMethodBeat.o(87570);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.i.i.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.w;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.vfs.ah;
import com.tencent.mm.vfs.u;

public final class i
  extends d
{
  public i(String paramString, c paramc, y paramy)
  {
    super(paramString, paramc, paramy);
  }
  
  public final void cSY()
  {
    AppMethodBeat.i(135550);
    if ((this.qqV.getFileSystem() != null) && (this.uSe != null))
    {
      com.tencent.threadpool.h.ahAA.bm(new com.tencent.threadpool.i.h()
      {
        public final String getKey()
        {
          return "TempFileIconLoader";
        }
        
        public final void run()
        {
          AppMethodBeat.i(135549);
          Object localObject = i.this.qqV.getFileSystem().Wm(i.this.uSe);
          if (localObject == null)
          {
            i.this.uSf.a("Failed to load icon via temp file", i.this);
            AppMethodBeat.o(135549);
            return;
          }
          localObject = BitmapFactory.decodeFile(ah.v(((u)localObject).mUri));
          if (localObject != null)
          {
            i.this.ae((Bitmap)localObject);
            AppMethodBeat.o(135549);
            return;
          }
          i.this.uSf.a("Failed to load icon via temp file", i.this);
          AppMethodBeat.o(135549);
        }
      });
      AppMethodBeat.o(135550);
      return;
    }
    this.uSf.a("Failed to load icon via temp file", this);
    AppMethodBeat.o(135550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.i
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.r;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.vfs.q;

public final class i
  extends d
{
  public i(String paramString, c paramc, v paramv)
  {
    super(paramString, paramc, paramv);
  }
  
  public final void cqr()
  {
    AppMethodBeat.i(135550);
    if ((this.nAz.getFileSystem() != null) && (this.rGO != null))
    {
      com.tencent.e.h.ZvG.be(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "TempFileIconLoader";
        }
        
        public final void run()
        {
          AppMethodBeat.i(135549);
          Object localObject = i.this.nAz.getFileSystem().adL(i.this.rGO);
          if (localObject == null)
          {
            i.this.rGP.a("Failed to load icon via temp file", i.this);
            AppMethodBeat.o(135549);
            return;
          }
          localObject = BitmapFactory.decodeFile(((q)localObject).getPath());
          if (localObject != null)
          {
            i.this.V((Bitmap)localObject);
            AppMethodBeat.o(135549);
            return;
          }
          i.this.rGP.a("Failed to load icon via temp file", i.this);
          AppMethodBeat.o(135549);
        }
      });
      AppMethodBeat.o(135550);
      return;
    }
    this.rGP.a("Failed to load icon via temp file", this);
    AppMethodBeat.o(135550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.i
 * JD-Core Version:    0.7.0.1
 */
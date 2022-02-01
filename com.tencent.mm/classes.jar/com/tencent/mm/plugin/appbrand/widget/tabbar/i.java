package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.s;
import com.tencent.mm.vfs.aa;
import com.tencent.mm.vfs.o;

public final class i
  extends d
{
  public i(String paramString, c paramc, s params)
  {
    super(paramString, paramc, params);
  }
  
  public final void cdf()
  {
    AppMethodBeat.i(135550);
    if ((this.kGT.getFileSystem() != null) && (this.oFe != null))
    {
      com.tencent.f.h.RTc.aX(new com.tencent.f.i.h()
      {
        public final String getKey()
        {
          return "TempFileIconLoader";
        }
        
        public final void run()
        {
          AppMethodBeat.i(135549);
          Object localObject = i.this.kGT.getFileSystem().VY(i.this.oFe);
          if (localObject == null)
          {
            i.this.oFf.a("Failed to load icon via temp file", i.this);
            AppMethodBeat.o(135549);
            return;
          }
          localObject = BitmapFactory.decodeFile(aa.z(((o)localObject).mUri));
          if (localObject != null)
          {
            i.this.X((Bitmap)localObject);
            AppMethodBeat.o(135549);
            return;
          }
          i.this.oFf.a("Failed to load icon via temp file", i.this);
          AppMethodBeat.o(135549);
        }
      });
      AppMethodBeat.o(135550);
      return;
    }
    this.oFf.a("Failed to load icon via temp file", this);
    AppMethodBeat.o(135550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.i
 * JD-Core Version:    0.7.0.1
 */
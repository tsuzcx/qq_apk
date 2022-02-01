package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.p;
import com.tencent.mm.vfs.e;

public final class i
  extends d
{
  public i(String paramString, c paramc, com.tencent.mm.plugin.appbrand.q paramq)
  {
    super(paramString, paramc, paramq);
  }
  
  public final void bBJ()
  {
    AppMethodBeat.i(135550);
    if ((this.jiP.DH() != null) && (this.mPt != null))
    {
      com.tencent.e.h.JZN.aS(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "TempFileIconLoader";
        }
        
        public final void run()
        {
          AppMethodBeat.i(135549);
          Object localObject = i.this.jiP.DH().IS(i.this.mPt);
          if (localObject == null)
          {
            i.this.mPu.a("Failed to load icon via temp file", i.this);
            AppMethodBeat.o(135549);
            return;
          }
          localObject = BitmapFactory.decodeFile(com.tencent.mm.vfs.q.B(((e)localObject).mUri));
          if (localObject != null)
          {
            i.this.R((Bitmap)localObject);
            AppMethodBeat.o(135549);
            return;
          }
          i.this.mPu.a("Failed to load icon via temp file", i.this);
          AppMethodBeat.o(135549);
        }
      });
      AppMethodBeat.o(135550);
      return;
    }
    this.mPu.a("Failed to load icon via temp file", this);
    AppMethodBeat.o(135550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.i
 * JD-Core Version:    0.7.0.1
 */
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
  
  public final void buM()
  {
    AppMethodBeat.i(135550);
    if ((this.iIL.Ee() != null) && (this.mns != null))
    {
      com.tencent.e.h.Iye.aP(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "TempFileIconLoader";
        }
        
        public final void run()
        {
          AppMethodBeat.i(135549);
          Object localObject = i.this.iIL.Ee().EP(i.this.mns);
          if (localObject == null)
          {
            i.this.mnt.a("Failed to load icon via temp file", i.this);
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
          i.this.mnt.a("Failed to load icon via temp file", i.this);
          AppMethodBeat.o(135549);
        }
      });
      AppMethodBeat.o(135550);
      return;
    }
    this.mnt.a("Failed to load icon via temp file", this);
    AppMethodBeat.o(135550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.i
 * JD-Core Version:    0.7.0.1
 */
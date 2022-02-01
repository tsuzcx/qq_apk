package com.tencent.mm.plugin.appbrand.widget.tabbar;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.appstorage.q;
import com.tencent.mm.plugin.appbrand.r;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.w;

public final class i
  extends d
{
  public i(String paramString, c paramc, r paramr)
  {
    super(paramString, paramc, paramr);
  }
  
  public final void bGG()
  {
    AppMethodBeat.i(135550);
    if ((this.jFj.Fl() != null) && (this.nva != null))
    {
      com.tencent.e.h.MqF.aO(new com.tencent.e.i.h()
      {
        public final String getKey()
        {
          return "TempFileIconLoader";
        }
        
        public final void run()
        {
          AppMethodBeat.i(135549);
          Object localObject = i.this.jFj.Fl().MP(i.this.nva);
          if (localObject == null)
          {
            i.this.nvb.a("Failed to load icon via temp file", i.this);
            AppMethodBeat.o(135549);
            return;
          }
          localObject = BitmapFactory.decodeFile(w.B(((k)localObject).mUri));
          if (localObject != null)
          {
            i.this.S((Bitmap)localObject);
            AppMethodBeat.o(135549);
            return;
          }
          i.this.nvb.a("Failed to load icon via temp file", i.this);
          AppMethodBeat.o(135549);
        }
      });
      AppMethodBeat.o(135550);
      return;
    }
    this.nvb.a("Failed to load icon via temp file", this);
    AppMethodBeat.o(135550);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.tabbar.i
 * JD-Core Version:    0.7.0.1
 */
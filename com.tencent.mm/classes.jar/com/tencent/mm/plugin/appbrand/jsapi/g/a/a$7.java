package com.tencent.mm.plugin.appbrand.jsapi.g.a;

import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class a$7
  implements Runnable
{
  a$7(a parama, ImageView paramImageView, FrameLayout.LayoutParams paramLayoutParams) {}
  
  public final void run()
  {
    AppMethodBeat.i(138417);
    ((ViewGroup)this.hOM.hOh).addView(this.hOP, this.hOR);
    synchronized (this.hOM.hOA)
    {
      this.hOM.hOA.add(new a.b(this.hOM, this.hOP));
      AppMethodBeat.o(138417);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.g.a.a.7
 * JD-Core Version:    0.7.0.1
 */
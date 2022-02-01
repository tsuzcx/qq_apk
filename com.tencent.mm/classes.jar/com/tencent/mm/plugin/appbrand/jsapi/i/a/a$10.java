package com.tencent.mm.plugin.appbrand.jsapi.i.a;

import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

final class a$10
  implements Runnable
{
  a$10(a parama, ImageView paramImageView, FrameLayout.LayoutParams paramLayoutParams) {}
  
  public final void run()
  {
    AppMethodBeat.i(146469);
    ((ViewGroup)this.kQN.container).addView(this.kQS, this.kQU);
    synchronized (this.kQN.kQq)
    {
      this.kQN.kQq.add(new a.b(this.kQN, this.kQS));
      AppMethodBeat.o(146469);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.i.a.a.10
 * JD-Core Version:    0.7.0.1
 */
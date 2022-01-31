package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.memory.o;
import com.tencent.mm.memory.o.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import java.lang.ref.WeakReference;

final class RecyclerThumbSeekBar$b
  implements Runnable
{
  private WeakReference<ImageView> aqT;
  boolean fIp;
  private ak handler;
  private int oLs;
  private Bitmap oLt;
  
  RecyclerThumbSeekBar$b(RecyclerThumbSeekBar paramRecyclerThumbSeekBar, int paramInt, ImageView paramImageView, Bitmap paramBitmap, ak paramak)
  {
    AppMethodBeat.i(54986);
    this.fIp = false;
    this.oLs = paramInt;
    this.aqT = new WeakReference(paramImageView);
    this.handler = paramak;
    this.oLt = paramBitmap;
    AppMethodBeat.o(54986);
  }
  
  public final void run()
  {
    AppMethodBeat.i(54987);
    if (this.fIp)
    {
      o.fdX.t(this.oLt);
      AppMethodBeat.o(54987);
      return;
    }
    if ((ImageView)this.aqT.get() == null)
    {
      o.fdX.t(this.oLt);
      AppMethodBeat.o(54987);
      return;
    }
    try
    {
      d locald = RecyclerThumbSeekBar.g(this.oLp).bRA();
      if (this.oLt == null) {
        this.oLt = o.fdX.a(new o.b(locald.getScaledWidth(), locald.getScaledHeight()));
      }
      locald.reuseBitmap(this.oLt);
      if (!this.fIp) {
        this.oLt = locald.getFrameAtTime(this.oLs);
      }
      RecyclerThumbSeekBar.g(this.oLp).a(locald);
      if ((this.oLt != null) && (!this.fIp) && (this.aqT.get() != null))
      {
        this.handler.post(new RecyclerThumbSeekBar.a(this.oLp, this.oLt, (ImageView)this.aqT.get(), this));
        AppMethodBeat.o(54987);
        return;
      }
    }
    catch (Exception localException)
    {
      ab.e("RecyclerThumbSeekBar", "get bitmap error " + localException.getMessage());
      o.fdX.t(this.oLt);
      AppMethodBeat.o(54987);
      return;
    }
    o.fdX.t(this.oLt);
    AppMethodBeat.o(54987);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.b
 * JD-Core Version:    0.7.0.1
 */
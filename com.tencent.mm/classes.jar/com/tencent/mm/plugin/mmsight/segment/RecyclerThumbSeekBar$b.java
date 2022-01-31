package com.tencent.mm.plugin.mmsight.segment;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mm.memory.o;
import com.tencent.mm.memory.o.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

final class RecyclerThumbSeekBar$b
  implements Runnable
{
  private WeakReference<ImageView> aoA;
  boolean esC = false;
  private ah handler;
  private Bitmap mml;
  private int time;
  
  RecyclerThumbSeekBar$b(RecyclerThumbSeekBar paramRecyclerThumbSeekBar, int paramInt, ImageView paramImageView, Bitmap paramBitmap, ah paramah)
  {
    this.time = paramInt;
    this.aoA = new WeakReference(paramImageView);
    this.handler = paramah;
    this.mml = paramBitmap;
  }
  
  public final void run()
  {
    if (this.esC)
    {
      o.dPr.m(this.mml);
      return;
    }
    if ((ImageView)this.aoA.get() == null)
    {
      o.dPr.m(this.mml);
      return;
    }
    try
    {
      d locald = RecyclerThumbSeekBar.g(this.mmi).bjN();
      if (this.mml == null) {
        this.mml = o.dPr.a(new o.b(locald.getScaledWidth(), locald.getScaledHeight()));
      }
      locald.reuseBitmap(this.mml);
      if (!this.esC) {
        this.mml = locald.getFrameAtTime(this.time);
      }
      RecyclerThumbSeekBar.g(this.mmi).a(locald);
      if ((this.mml != null) && (!this.esC) && (this.aoA.get() != null))
      {
        this.handler.post(new RecyclerThumbSeekBar.a(this.mmi, this.mml, (ImageView)this.aoA.get(), this));
        return;
      }
    }
    catch (Exception localException)
    {
      y.e("RecyclerThumbSeekBar", "get bitmap error " + localException.getMessage());
      o.dPr.m(this.mml);
      return;
    }
    o.dPr.m(this.mml);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mmsight.segment.RecyclerThumbSeekBar.b
 * JD-Core Version:    0.7.0.1
 */
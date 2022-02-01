package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "Landroid/graphics/Bitmap;", "frameCount", "", "frameHeight", "frameTime", "frameWidth", "getFrame", "seekTo", "timeMs", "", "plugin-emojisdk_release"})
public abstract interface d
{
  public abstract void aBh();
  
  public abstract int aBi();
  
  public abstract int aBj();
  
  public abstract int aBk();
  
  public abstract int aBl();
  
  public abstract void destroy();
  
  public abstract Bitmap getFrame();
  
  public abstract void seekTo(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.d
 * JD-Core Version:    0.7.0.1
 */
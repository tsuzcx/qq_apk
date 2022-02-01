package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "Landroid/graphics/Bitmap;", "frameCount", "", "frameHeight", "frameTime", "frameWidth", "getFrame", "seekTo", "timeMs", "", "plugin-emojisdk_release"})
public abstract interface d
{
  public abstract void auo();
  
  public abstract int aup();
  
  public abstract int auq();
  
  public abstract int aur();
  
  public abstract int aus();
  
  public abstract void destroy();
  
  public abstract Bitmap getFrame();
  
  public abstract void seekTo(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.d
 * JD-Core Version:    0.7.0.1
 */
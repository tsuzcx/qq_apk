package com.tencent.mm.emoji.decode;

import android.graphics.Bitmap;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/decode/IGIFDecoder;", "", "decodeNextFrame", "", "destroy", "drawFrameBitmap", "", "bitmap", "Landroid/graphics/Bitmap;", "frameCount", "", "frameHeight", "frameTime", "frameWidth", "getFrame", "seekTo", "timeMs", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface d
{
  public abstract void aUe();
  
  public abstract int aUf();
  
  public abstract int aUg();
  
  public abstract int aUh();
  
  public abstract int aUi();
  
  public abstract void destroy();
  
  public abstract Bitmap getFrame();
  
  public abstract void seekTo(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.decode.d
 * JD-Core Version:    0.7.0.1
 */
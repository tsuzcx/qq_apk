package com.tencent.mm.gogcv;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class Api
{
  public static Bitmap[] a(String paramString, float[] paramArrayOfFloat)
  {
    AppMethodBeat.i(250041);
    MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
    localMediaMetadataRetriever.setDataSource(paramString);
    long l = Long.parseLong(localMediaMetadataRetriever.extractMetadata(9));
    paramString = new Bitmap[paramArrayOfFloat.length];
    int i = 0;
    while (i < paramArrayOfFloat.length)
    {
      paramString[i] = localMediaMetadataRetriever.getFrameAtTime(((float)((l - 1L) * 1000L) * paramArrayOfFloat[i]), 2);
      i += 1;
    }
    localMediaMetadataRetriever.release();
    AppMethodBeat.o(250041);
    return paramString;
  }
  
  public native byte[] checkImage(Bitmap paramBitmap);
  
  public native byte[] checkVideo(Bitmap[] paramArrayOfBitmap);
  
  public native boolean init(String paramString);
  
  public native void release();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.gogcv.Api
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.av.a;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class c
{
  public WeakReference<ImageView> gLf;
  public final int gLh;
  public int height;
  private String url;
  public int width;
  
  public c(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(130375);
    this.width = 0;
    this.height = 0;
    this.url = "";
    this.gLf = new WeakReference(paramImageView);
    this.url = paramString;
    if (paramImageView != null)
    {
      this.gLh = paramImageView.hashCode();
      AppMethodBeat.o(130375);
      return;
    }
    this.gLh = hashCode();
    AppMethodBeat.o(130375);
  }
  
  public final ImageView getImageView()
  {
    AppMethodBeat.i(130376);
    if (this.gLf != null)
    {
      ImageView localImageView = (ImageView)this.gLf.get();
      if (localImageView != null)
      {
        AppMethodBeat.o(130376);
        return localImageView;
      }
    }
    AppMethodBeat.o(130376);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.av.a.c
 * JD-Core Version:    0.7.0.1
 */
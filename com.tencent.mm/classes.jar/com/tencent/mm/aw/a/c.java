package com.tencent.mm.aw.a;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class c
{
  public WeakReference<ImageView> gks;
  public final int gku;
  public int height;
  private String url;
  public int width;
  
  public c(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(130375);
    this.width = 0;
    this.height = 0;
    this.url = "";
    this.gks = new WeakReference(paramImageView);
    this.url = paramString;
    if (paramImageView != null)
    {
      this.gku = paramImageView.hashCode();
      AppMethodBeat.o(130375);
      return;
    }
    this.gku = hashCode();
    AppMethodBeat.o(130375);
  }
  
  public final ImageView getImageView()
  {
    AppMethodBeat.i(130376);
    if (this.gks != null)
    {
      ImageView localImageView = (ImageView)this.gks.get();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.aw.a.c
 * JD-Core Version:    0.7.0.1
 */
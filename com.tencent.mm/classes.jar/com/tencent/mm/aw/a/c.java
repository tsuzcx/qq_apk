package com.tencent.mm.aw.a;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class c
{
  public WeakReference<ImageView> heU;
  public final int heW;
  public int height;
  private String url;
  public int width;
  
  public c(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(130375);
    this.width = 0;
    this.height = 0;
    this.url = "";
    this.heU = new WeakReference(paramImageView);
    this.url = paramString;
    if (paramImageView != null)
    {
      this.heW = paramImageView.hashCode();
      AppMethodBeat.o(130375);
      return;
    }
    this.heW = hashCode();
    AppMethodBeat.o(130375);
  }
  
  public final ImageView getImageView()
  {
    AppMethodBeat.i(130376);
    if (this.heU != null)
    {
      ImageView localImageView = (ImageView)this.heU.get();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.aw.a.c
 * JD-Core Version:    0.7.0.1
 */
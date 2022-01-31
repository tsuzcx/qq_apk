package com.tencent.mm.at.a;

import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;

public final class c
{
  public WeakReference<ImageView> eOP;
  public final int eOR;
  public int height;
  private String url;
  public int width;
  
  public c(ImageView paramImageView, String paramString)
  {
    AppMethodBeat.i(116046);
    this.width = 0;
    this.height = 0;
    this.url = "";
    this.eOP = new WeakReference(paramImageView);
    this.url = paramString;
    if (paramImageView != null)
    {
      this.eOR = paramImageView.hashCode();
      AppMethodBeat.o(116046);
      return;
    }
    this.eOR = hashCode();
    AppMethodBeat.o(116046);
  }
  
  public final ImageView getImageView()
  {
    AppMethodBeat.i(116047);
    if (this.eOP != null)
    {
      ImageView localImageView = (ImageView)this.eOP.get();
      if (localImageView != null)
      {
        AppMethodBeat.o(116047);
        return localImageView;
      }
    }
    AppMethodBeat.o(116047);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.at.a.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.as.a;

import android.widget.ImageView;
import java.lang.ref.WeakReference;

public final class c
{
  public WeakReference<ImageView> eqD;
  public final int eqE;
  public int height = 0;
  private String url = "";
  public int width = 0;
  
  public c(ImageView paramImageView, String paramString)
  {
    this.eqD = new WeakReference(paramImageView);
    this.url = paramString;
    if (paramImageView != null)
    {
      this.eqE = paramImageView.hashCode();
      return;
    }
    this.eqE = hashCode();
  }
  
  public final ImageView getImageView()
  {
    if (this.eqD != null)
    {
      ImageView localImageView = (ImageView)this.eqD.get();
      if (localImageView != null) {
        return localImageView;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.as.a.c
 * JD-Core Version:    0.7.0.1
 */
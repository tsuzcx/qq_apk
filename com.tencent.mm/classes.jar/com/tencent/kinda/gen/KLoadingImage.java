package com.tencent.kinda.gen;

public abstract interface KLoadingImage
  extends KView
{
  public abstract LoadingImageStyle getStyle();
  
  public abstract void setStyle(LoadingImageStyle paramLoadingImageStyle);
  
  public abstract void startAnimating();
  
  public abstract void stopAnimating();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.gen.KLoadingImage
 * JD-Core Version:    0.7.0.1
 */
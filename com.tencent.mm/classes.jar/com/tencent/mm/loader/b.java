package com.tencent.mm.loader;

import android.widget.ImageView;
import com.tencent.mm.loader.f.d;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/loader/IRequestBuilder;", "T", "R", "", "download", "", "fromCache", "()Ljava/lang/Object;", "into", "imageView", "Landroid/widget/ImageView;", "needDefault", "", "load", "setDefaultBackgroundDrawable", "_drawable", "Landroid/graphics/drawable/Drawable;", "setDefaultBackgroundResId", "_resId", "", "setDefaultDrawable", "setDefaultResId", "setImageDownloadListener", "imageDownloadListener", "Lcom/tencent/mm/loader/listener/IImageDownloadListener;", "setImageFileBrokenCallback", "imageFileBrokenCallback", "Lcom/tencent/mm/loader/listener/IImageFileBrokenCallback;", "setImageLoadListener", "imageLoadListener", "Lcom/tencent/mm/loader/listener/IImageLoadListener;", "setImageLoaderAnimation", "animation", "Lcom/tencent/mm/loader/listener/IImageLoaderAnimation;", "setImageLoaderListener", "imageLoaderListener", "Lcom/tencent/mm/loader/listener/IImageLoaderListener;", "setImageLoaderReportListener", "imageloaderReportListener", "Lcom/tencent/mm/loader/listener/IImageLoaderReportListener;", "setOptions", "options", "Lcom/tencent/mm/loader/cfg/ImageLoaderOptions;", "withStruct", "V", "(Ljava/lang/Object;)Lcom/tencent/mm/loader/IRequestBuilder;", "libimageloader_release"})
public abstract interface b<T, R>
{
  public abstract b<T, R> a(com.tencent.mm.loader.c.e parame);
  
  public abstract b<T, R> a(d paramd);
  
  public abstract b<T, R> a(com.tencent.mm.loader.f.e<T, R> parame);
  
  public abstract void a(ImageView paramImageView, boolean paramBoolean);
  
  public abstract void c(ImageView paramImageView);
  
  public abstract void vC();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.loader.b
 * JD-Core Version:    0.7.0.1
 */
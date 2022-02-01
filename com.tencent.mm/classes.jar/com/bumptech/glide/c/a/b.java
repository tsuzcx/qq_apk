package com.bumptech.glide.c.a;

import android.content.res.AssetManager;
import android.util.Log;
import com.bumptech.glide.c.a;
import com.bumptech.glide.g;
import java.io.IOException;

public abstract class b<T>
  implements d<T>
{
  private final AssetManager aFl;
  private final String assetPath;
  private T data;
  
  public b(AssetManager paramAssetManager, String paramString)
  {
    this.aFl = paramAssetManager;
    this.assetPath = paramString;
  }
  
  protected abstract void R(T paramT);
  
  protected abstract T a(AssetManager paramAssetManager, String paramString);
  
  public final void a(g paramg, d.a<? super T> parama)
  {
    try
    {
      this.data = a(this.aFl, this.assetPath);
      parama.S(this.data);
      return;
    }
    catch (IOException paramg)
    {
      Log.isLoggable("AssetPathFetcher", 3);
      parama.e(paramg);
    }
  }
  
  public final void cancel() {}
  
  public final void cleanup()
  {
    if (this.data == null) {
      return;
    }
    try
    {
      R(this.data);
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public final a on()
  {
    return a.aEG;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.a.b
 * JD-Core Version:    0.7.0.1
 */
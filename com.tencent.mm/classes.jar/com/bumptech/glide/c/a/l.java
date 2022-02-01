package com.bumptech.glide.c.a;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import com.bumptech.glide.c.a;
import com.bumptech.glide.g;
import java.io.FileNotFoundException;
import java.io.IOException;

public abstract class l<T>
  implements d<T>
{
  private final ContentResolver aFz;
  private T data;
  private final Uri uri;
  
  public l(ContentResolver paramContentResolver, Uri paramUri)
  {
    this.aFz = paramContentResolver;
    this.uri = paramUri;
  }
  
  protected abstract void R(T paramT);
  
  protected abstract T a(Uri paramUri, ContentResolver paramContentResolver);
  
  public final void a(g paramg, d.a<? super T> parama)
  {
    try
    {
      this.data = a(this.uri, this.aFz);
      parama.S(this.data);
      return;
    }
    catch (FileNotFoundException paramg)
    {
      Log.isLoggable("LocalUriFetcher", 3);
      parama.e(paramg);
    }
  }
  
  public final void cancel() {}
  
  public final void cleanup()
  {
    if (this.data != null) {}
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
 * Qualified Name:     com.bumptech.glide.c.a.l
 * JD-Core Version:    0.7.0.1
 */
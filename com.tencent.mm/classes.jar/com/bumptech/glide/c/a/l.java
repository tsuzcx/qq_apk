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
  private final ContentResolver aDI;
  private T data;
  private final Uri uri;
  
  public l(ContentResolver paramContentResolver, Uri paramUri)
  {
    this.aDI = paramContentResolver;
    this.uri = paramUri;
  }
  
  protected abstract void Q(T paramT);
  
  protected abstract T a(Uri paramUri, ContentResolver paramContentResolver);
  
  public final void a(g paramg, d.a<? super T> parama)
  {
    try
    {
      this.data = a(this.uri, this.aDI);
      parama.R(this.data);
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
      Q(this.data);
      return;
    }
    catch (IOException localIOException) {}
  }
  
  public final a nV()
  {
    return a.aCP;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.a.l
 * JD-Core Version:    0.7.0.1
 */
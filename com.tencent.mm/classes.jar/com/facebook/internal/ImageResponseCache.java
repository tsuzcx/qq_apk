package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

class ImageResponseCache
{
  static final String TAG;
  private static FileLruCache imageCache;
  
  static
  {
    AppMethodBeat.i(17834);
    TAG = ImageResponseCache.class.getSimpleName();
    AppMethodBeat.o(17834);
  }
  
  static void clearCache(Context paramContext)
  {
    AppMethodBeat.i(17833);
    try
    {
      getCache(paramContext).clearCache();
      AppMethodBeat.o(17833);
      return;
    }
    catch (IOException paramContext)
    {
      Logger.log(LoggingBehavior.CACHE, 5, TAG, "clearCache failed " + paramContext.getMessage());
      AppMethodBeat.o(17833);
    }
  }
  
  static FileLruCache getCache(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(17829);
      if (imageCache == null) {
        imageCache = new FileLruCache(TAG, new FileLruCache.Limits());
      }
      paramContext = imageCache;
      AppMethodBeat.o(17829);
      return paramContext;
    }
    finally {}
  }
  
  static InputStream getCachedImageStream(Uri paramUri, Context paramContext)
  {
    AppMethodBeat.i(17830);
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramUri != null)
    {
      localObject1 = localObject2;
      if (!isCDNURL(paramUri)) {}
    }
    try
    {
      localObject1 = getCache(paramContext).get(paramUri.toString());
      AppMethodBeat.o(17830);
      return localObject1;
    }
    catch (IOException paramUri)
    {
      for (;;)
      {
        Logger.log(LoggingBehavior.CACHE, 5, TAG, paramUri.toString());
        localObject1 = localObject2;
      }
    }
  }
  
  static InputStream interceptAndCacheImageStream(Context paramContext, HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(17831);
    Object localObject = null;
    Uri localUri;
    InputStream localInputStream;
    if (paramHttpURLConnection.getResponseCode() == 200)
    {
      localUri = Uri.parse(paramHttpURLConnection.getURL().toString());
      localInputStream = paramHttpURLConnection.getInputStream();
      localObject = localInputStream;
    }
    try
    {
      if (isCDNURL(localUri)) {
        localObject = getCache(paramContext).interceptAndPut(localUri.toString(), new BufferedHttpInputStream(localInputStream, paramHttpURLConnection));
      }
      AppMethodBeat.o(17831);
      return localObject;
    }
    catch (IOException paramContext)
    {
      for (;;)
      {
        localObject = localInputStream;
      }
    }
  }
  
  private static boolean isCDNURL(Uri paramUri)
  {
    AppMethodBeat.i(17832);
    if (paramUri != null)
    {
      paramUri = paramUri.getHost();
      if (paramUri.endsWith("fbcdn.net"))
      {
        AppMethodBeat.o(17832);
        return true;
      }
      if ((paramUri.startsWith("fbcdn")) && (paramUri.endsWith("akamaihd.net")))
      {
        AppMethodBeat.o(17832);
        return true;
      }
    }
    AppMethodBeat.o(17832);
    return false;
  }
  
  static class BufferedHttpInputStream
    extends BufferedInputStream
  {
    HttpURLConnection connection;
    
    BufferedHttpInputStream(InputStream paramInputStream, HttpURLConnection paramHttpURLConnection)
    {
      super(8192);
      this.connection = paramHttpURLConnection;
    }
    
    public void close()
    {
      AppMethodBeat.i(17828);
      super.close();
      Utility.disconnectQuietly(this.connection);
      AppMethodBeat.o(17828);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.internal.ImageResponseCache
 * JD-Core Version:    0.7.0.1
 */
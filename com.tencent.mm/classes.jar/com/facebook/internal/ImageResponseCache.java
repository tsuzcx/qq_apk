package com.facebook.internal;

import android.content.Context;
import android.net.Uri;
import com.facebook.LoggingBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
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
    AppMethodBeat.i(72398);
    TAG = ImageResponseCache.class.getSimpleName();
    AppMethodBeat.o(72398);
  }
  
  static void clearCache(Context paramContext)
  {
    AppMethodBeat.i(72397);
    try
    {
      getCache(paramContext).clearCache();
      AppMethodBeat.o(72397);
      return;
    }
    catch (IOException paramContext)
    {
      Logger.log(LoggingBehavior.CACHE, 5, TAG, "clearCache failed " + paramContext.getMessage());
      AppMethodBeat.o(72397);
    }
  }
  
  static FileLruCache getCache(Context paramContext)
  {
    try
    {
      AppMethodBeat.i(72393);
      if (imageCache == null) {
        imageCache = new FileLruCache(TAG, new FileLruCache.Limits());
      }
      paramContext = imageCache;
      AppMethodBeat.o(72393);
      return paramContext;
    }
    finally {}
  }
  
  static InputStream getCachedImageStream(Uri paramUri, Context paramContext)
  {
    AppMethodBeat.i(72394);
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
      AppMethodBeat.o(72394);
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
    AppMethodBeat.i(72395);
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
        localObject = getCache(paramContext).interceptAndPut(localUri.toString(), new ImageResponseCache.BufferedHttpInputStream(localInputStream, paramHttpURLConnection));
      }
      AppMethodBeat.o(72395);
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
    AppMethodBeat.i(72396);
    if (paramUri != null)
    {
      paramUri = paramUri.getHost();
      if (paramUri.endsWith("fbcdn.net"))
      {
        AppMethodBeat.o(72396);
        return true;
      }
      if ((paramUri.startsWith("fbcdn")) && (paramUri.endsWith("akamaihd.net")))
      {
        AppMethodBeat.o(72396);
        return true;
      }
    }
    AppMethodBeat.o(72396);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.facebook.internal.ImageResponseCache
 * JD-Core Version:    0.7.0.1
 */
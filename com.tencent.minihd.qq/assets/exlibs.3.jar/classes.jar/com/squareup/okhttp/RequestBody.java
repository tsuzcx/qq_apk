package com.squareup.okhttp;

import com.squareup.okhttp.internal.Util;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import okio.Source;

public abstract class RequestBody
{
  public static RequestBody create(MediaType paramMediaType, final File paramFile)
  {
    if (paramFile == null) {
      throw new NullPointerException("content == null");
    }
    new RequestBody()
    {
      public long contentLength()
      {
        return paramFile.length();
      }
      
      public MediaType contentType()
      {
        return this.val$contentType;
      }
      
      public void writeTo(BufferedSink paramAnonymousBufferedSink)
        throws IOException
      {
        Object localObject = null;
        try
        {
          Source localSource = Okio.source(paramFile);
          localObject = localSource;
          paramAnonymousBufferedSink.writeAll(localSource);
          return;
        }
        finally
        {
          Util.closeQuietly(localObject);
        }
      }
    };
  }
  
  public static RequestBody create(MediaType paramMediaType, String paramString)
  {
    Object localObject = Util.UTF_8;
    MediaType localMediaType = paramMediaType;
    if (paramMediaType != null)
    {
      Charset localCharset = paramMediaType.charset();
      localObject = localCharset;
      localMediaType = paramMediaType;
      if (localCharset == null)
      {
        localObject = Util.UTF_8;
        localMediaType = MediaType.parse(paramMediaType + "; charset=utf-8");
      }
    }
    return create(localMediaType, paramString.getBytes((Charset)localObject));
  }
  
  public static RequestBody create(MediaType paramMediaType, final ByteString paramByteString)
  {
    new RequestBody()
    {
      public long contentLength()
        throws IOException
      {
        return paramByteString.size();
      }
      
      public MediaType contentType()
      {
        return this.val$contentType;
      }
      
      public void writeTo(BufferedSink paramAnonymousBufferedSink)
        throws IOException
      {
        paramAnonymousBufferedSink.write(paramByteString);
      }
    };
  }
  
  public static RequestBody create(MediaType paramMediaType, byte[] paramArrayOfByte)
  {
    return create(paramMediaType, paramArrayOfByte, 0, paramArrayOfByte.length);
  }
  
  public static RequestBody create(MediaType paramMediaType, final byte[] paramArrayOfByte, final int paramInt1, final int paramInt2)
  {
    if (paramArrayOfByte == null) {
      throw new NullPointerException("content == null");
    }
    Util.checkOffsetAndCount(paramArrayOfByte.length, paramInt1, paramInt2);
    new RequestBody()
    {
      public long contentLength()
      {
        return paramInt2;
      }
      
      public MediaType contentType()
      {
        return this.val$contentType;
      }
      
      public void writeTo(BufferedSink paramAnonymousBufferedSink)
        throws IOException
      {
        paramAnonymousBufferedSink.write(paramArrayOfByte, paramInt1, paramInt2);
      }
    };
  }
  
  public long contentLength()
    throws IOException
  {
    return -1L;
  }
  
  public abstract MediaType contentType();
  
  public abstract void writeTo(BufferedSink paramBufferedSink)
    throws IOException;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.squareup.okhttp.RequestBody
 * JD-Core Version:    0.7.0.1
 */
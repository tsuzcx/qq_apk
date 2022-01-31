package com.facebook.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;

class ImageResponseCache$BufferedHttpInputStream
  extends BufferedInputStream
{
  HttpURLConnection connection;
  
  ImageResponseCache$BufferedHttpInputStream(InputStream paramInputStream, HttpURLConnection paramHttpURLConnection)
  {
    super(paramInputStream, 8192);
    this.connection = paramHttpURLConnection;
  }
  
  public void close()
  {
    AppMethodBeat.i(72392);
    super.close();
    Utility.disconnectQuietly(this.connection);
    AppMethodBeat.o(72392);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.facebook.internal.ImageResponseCache.BufferedHttpInputStream
 * JD-Core Version:    0.7.0.1
 */
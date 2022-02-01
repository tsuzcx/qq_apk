package com.tencent.map.tools.net.http;

import com.tencent.mapsdk.internal.kb;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.net.HttpURLConnection;

public class HttpConnectionInputStream
  extends InputStream
{
  private final HttpURLConnection mConnection;
  private final InputStream mProxyInputStream;
  
  public HttpConnectionInputStream(HttpURLConnection paramHttpURLConnection)
  {
    AppMethodBeat.i(210993);
    this.mConnection = paramHttpURLConnection;
    this.mProxyInputStream = paramHttpURLConnection.getInputStream();
    AppMethodBeat.o(210993);
  }
  
  public void close()
  {
    AppMethodBeat.i(211000);
    super.close();
    kb.a(this.mProxyInputStream);
    this.mConnection.disconnect();
    AppMethodBeat.o(211000);
  }
  
  public int read()
  {
    AppMethodBeat.i(210996);
    int i = this.mProxyInputStream.read();
    AppMethodBeat.o(210996);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.map.tools.net.http.HttpConnectionInputStream
 * JD-Core Version:    0.7.0.1
 */
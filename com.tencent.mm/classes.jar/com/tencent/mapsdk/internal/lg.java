package com.tencent.mapsdk.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

public class lg
  extends lk
{
  protected String b;
  
  private String c()
  {
    return this.b;
  }
  
  public final InputStream e(String paramString)
  {
    AppMethodBeat.i(222654);
    try
    {
      String str = new URL(paramString).getFile();
      if (!gz.a(str)) {
        this.b = str.substring(str.lastIndexOf("/") + 1).replace("%20", " ");
      }
      label47:
      paramString = super.e(paramString);
      AppMethodBeat.o(222654);
      return paramString;
    }
    catch (MalformedURLException localMalformedURLException)
    {
      break label47;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mapsdk.internal.lg
 * JD-Core Version:    0.7.0.1
 */
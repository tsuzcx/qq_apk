package com.bumptech.glide.load.c;

import com.bumptech.glide.g.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.URL;
import java.security.MessageDigest;

public class g
  implements com.bumptech.glide.load.g
{
  private int aHK;
  public final h aJR;
  public final String aJS;
  public String aJT;
  public URL aJU;
  private volatile byte[] aJV;
  public final URL url;
  
  public g(String paramString)
  {
    this(paramString, h.aJX);
  }
  
  private g(String paramString, h paramh)
  {
    AppMethodBeat.i(77238);
    this.url = null;
    this.aJS = j.checkNotEmpty(paramString);
    this.aJR = ((h)j.checkNotNull(paramh, "Argument must not be null"));
    AppMethodBeat.o(77238);
  }
  
  public g(URL paramURL)
  {
    this(paramURL, h.aJX);
  }
  
  private g(URL paramURL, h paramh)
  {
    AppMethodBeat.i(77237);
    this.url = ((URL)j.checkNotNull(paramURL, "Argument must not be null"));
    this.aJS = null;
    this.aJR = ((h)j.checkNotNull(paramh, "Argument must not be null"));
    AppMethodBeat.o(77237);
  }
  
  private String getCacheKey()
  {
    AppMethodBeat.i(77239);
    if (this.aJS != null)
    {
      str = this.aJS;
      AppMethodBeat.o(77239);
      return str;
    }
    String str = ((URL)j.checkNotNull(this.url, "Argument must not be null")).toString();
    AppMethodBeat.o(77239);
    return str;
  }
  
  public final void a(MessageDigest paramMessageDigest)
  {
    AppMethodBeat.i(77241);
    if (this.aJV == null) {
      this.aJV = getCacheKey().getBytes(aEV);
    }
    paramMessageDigest.update(this.aJV);
    AppMethodBeat.o(77241);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(77242);
    if ((paramObject instanceof g))
    {
      paramObject = (g)paramObject;
      if ((getCacheKey().equals(paramObject.getCacheKey())) && (this.aJR.equals(paramObject.aJR)))
      {
        AppMethodBeat.o(77242);
        return true;
      }
      AppMethodBeat.o(77242);
      return false;
    }
    AppMethodBeat.o(77242);
    return false;
  }
  
  public int hashCode()
  {
    AppMethodBeat.i(77243);
    if (this.aHK == 0)
    {
      this.aHK = getCacheKey().hashCode();
      this.aHK = (this.aHK * 31 + this.aJR.hashCode());
    }
    int i = this.aHK;
    AppMethodBeat.o(77243);
    return i;
  }
  
  public String toString()
  {
    AppMethodBeat.i(77240);
    String str = getCacheKey();
    AppMethodBeat.o(77240);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.c.g
 * JD-Core Version:    0.7.0.1
 */
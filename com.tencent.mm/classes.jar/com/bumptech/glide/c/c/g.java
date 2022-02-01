package com.bumptech.glide.c.c;

import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.URL;
import java.security.MessageDigest;

public class g
  implements com.bumptech.glide.c.h
{
  private int aFj;
  public final h aHr;
  public final String aHs;
  public String aHt;
  public URL aHu;
  private volatile byte[] aHv;
  public final URL url;
  
  public g(String paramString)
  {
    this(paramString, h.aHx);
  }
  
  private g(String paramString, h paramh)
  {
    AppMethodBeat.i(77238);
    this.url = null;
    this.aHs = i.checkNotEmpty(paramString);
    this.aHr = ((h)i.checkNotNull(paramh, "Argument must not be null"));
    AppMethodBeat.o(77238);
  }
  
  public g(URL paramURL)
  {
    this(paramURL, h.aHx);
  }
  
  private g(URL paramURL, h paramh)
  {
    AppMethodBeat.i(77237);
    this.url = ((URL)i.checkNotNull(paramURL, "Argument must not be null"));
    this.aHs = null;
    this.aHr = ((h)i.checkNotNull(paramh, "Argument must not be null"));
    AppMethodBeat.o(77237);
  }
  
  private String getCacheKey()
  {
    AppMethodBeat.i(77239);
    if (this.aHs != null)
    {
      str = this.aHs;
      AppMethodBeat.o(77239);
      return str;
    }
    String str = ((URL)i.checkNotNull(this.url, "Argument must not be null")).toString();
    AppMethodBeat.o(77239);
    return str;
  }
  
  public final void a(MessageDigest paramMessageDigest)
  {
    AppMethodBeat.i(77241);
    if (this.aHv == null) {
      this.aHv = getCacheKey().getBytes(aCw);
    }
    paramMessageDigest.update(this.aHv);
    AppMethodBeat.o(77241);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(77242);
    if ((paramObject instanceof g))
    {
      paramObject = (g)paramObject;
      if ((getCacheKey().equals(paramObject.getCacheKey())) && (this.aHr.equals(paramObject.aHr)))
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
    if (this.aFj == 0)
    {
      this.aFj = getCacheKey().hashCode();
      this.aFj = (this.aFj * 31 + this.aHr.hashCode());
    }
    int i = this.aFj;
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
 * Qualified Name:     com.bumptech.glide.c.c.g
 * JD-Core Version:    0.7.0.1
 */
package com.bumptech.glide.c.c;

import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.net.URL;
import java.security.MessageDigest;

public class g
  implements com.bumptech.glide.c.h
{
  private int aFZ;
  public final h aIh;
  public final String aIi;
  public String aIj;
  public URL aIk;
  private volatile byte[] aIl;
  public final URL url;
  
  public g(String paramString)
  {
    this(paramString, h.aIn);
  }
  
  private g(String paramString, h paramh)
  {
    AppMethodBeat.i(77238);
    this.url = null;
    this.aIi = i.checkNotEmpty(paramString);
    this.aIh = ((h)i.checkNotNull(paramh, "Argument must not be null"));
    AppMethodBeat.o(77238);
  }
  
  public g(URL paramURL)
  {
    this(paramURL, h.aIn);
  }
  
  private g(URL paramURL, h paramh)
  {
    AppMethodBeat.i(77237);
    this.url = ((URL)i.checkNotNull(paramURL, "Argument must not be null"));
    this.aIi = null;
    this.aIh = ((h)i.checkNotNull(paramh, "Argument must not be null"));
    AppMethodBeat.o(77237);
  }
  
  private String getCacheKey()
  {
    AppMethodBeat.i(77239);
    if (this.aIi != null)
    {
      str = this.aIi;
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
    if (this.aIl == null) {
      this.aIl = getCacheKey().getBytes(aDo);
    }
    paramMessageDigest.update(this.aIl);
    AppMethodBeat.o(77241);
  }
  
  public boolean equals(Object paramObject)
  {
    AppMethodBeat.i(77242);
    if ((paramObject instanceof g))
    {
      paramObject = (g)paramObject;
      if ((getCacheKey().equals(paramObject.getCacheKey())) && (this.aIh.equals(paramObject.aIh)))
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
    if (this.aFZ == 0)
    {
      this.aFZ = getCacheKey().hashCode();
      this.aFZ = (this.aFZ * 31 + this.aIh.hashCode());
    }
    int i = this.aFZ;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.c.g
 * JD-Core Version:    0.7.0.1
 */
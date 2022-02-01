package com.bumptech.glide.c.b.b;

import android.support.v4.e.l.a;
import com.bumptech.glide.c.h;
import com.bumptech.glide.h.a.a;
import com.bumptech.glide.h.a.a.a;
import com.bumptech.glide.h.a.a.c;
import com.bumptech.glide.h.a.b;
import com.bumptech.glide.h.a.b.a;
import com.bumptech.glide.h.f;
import com.bumptech.glide.h.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class j
{
  private final f<h, String> aGN;
  private final l.a<a> aGO;
  
  public j()
  {
    AppMethodBeat.i(77168);
    this.aGN = new f(1000L);
    this.aGO = a.a(10, new a.a()
    {
      private static j.a oE()
      {
        AppMethodBeat.i(77165);
        try
        {
          j.a locala = new j.a(MessageDigest.getInstance("SHA-256"));
          AppMethodBeat.o(77165);
          return locala;
        }
        catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
        {
          RuntimeException localRuntimeException = new RuntimeException(localNoSuchAlgorithmException);
          AppMethodBeat.o(77165);
          throw localRuntimeException;
        }
      }
    });
    AppMethodBeat.o(77168);
  }
  
  private String d(h paramh)
  {
    AppMethodBeat.i(77170);
    a locala = (a)i.checkNotNull(this.aGO.acquire(), "Argument must not be null");
    try
    {
      paramh.a(locala.aGQ);
      paramh = com.bumptech.glide.h.j.m(locala.aGQ.digest());
      return paramh;
    }
    finally
    {
      this.aGO.release(locala);
      AppMethodBeat.o(77170);
    }
  }
  
  public final String c(h paramh)
  {
    AppMethodBeat.i(77169);
    synchronized (this.aGN)
    {
      ??? = (String)this.aGN.get(paramh);
      ??? = ???;
      if (??? == null) {
        ??? = d(paramh);
      }
    }
    synchronized (this.aGN)
    {
      this.aGN.put(paramh, ???);
      AppMethodBeat.o(77169);
      return ???;
      paramh = finally;
      AppMethodBeat.o(77169);
      throw paramh;
    }
  }
  
  static final class a
    implements a.c
  {
    private final b aDI;
    final MessageDigest aGQ;
    
    a(MessageDigest paramMessageDigest)
    {
      AppMethodBeat.i(77167);
      this.aDI = new b.a();
      this.aGQ = paramMessageDigest;
      AppMethodBeat.o(77167);
    }
    
    public final b oc()
    {
      return this.aDI;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.b.b.j
 * JD-Core Version:    0.7.0.1
 */
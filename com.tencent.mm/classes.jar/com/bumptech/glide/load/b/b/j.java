package com.bumptech.glide.load.b.b;

import android.support.v4.e.l.a;
import com.bumptech.glide.g.a.a;
import com.bumptech.glide.g.a.a.a;
import com.bumptech.glide.g.a.a.c;
import com.bumptech.glide.g.a.b;
import com.bumptech.glide.g.a.b.a;
import com.bumptech.glide.g.k;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public final class j
{
  private final com.bumptech.glide.g.g<com.bumptech.glide.load.g, String> aJn;
  private final l.a<a> aJo;
  
  public j()
  {
    AppMethodBeat.i(77168);
    this.aJn = new com.bumptech.glide.g.g(1000L);
    this.aJo = a.a(10, new a.a()
    {
      private static j.a pl()
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
  
  private String f(com.bumptech.glide.load.g paramg)
  {
    AppMethodBeat.i(77170);
    a locala = (a)com.bumptech.glide.g.j.checkNotNull(this.aJo.acquire(), "Argument must not be null");
    try
    {
      paramg.a(locala.aJq);
      paramg = k.m(locala.aJq.digest());
      return paramg;
    }
    finally
    {
      this.aJo.release(locala);
      AppMethodBeat.o(77170);
    }
  }
  
  public final String e(com.bumptech.glide.load.g paramg)
  {
    AppMethodBeat.i(77169);
    synchronized (this.aJn)
    {
      ??? = (String)this.aJn.get(paramg);
      ??? = ???;
      if (??? == null) {
        ??? = f(paramg);
      }
    }
    synchronized (this.aJn)
    {
      this.aJn.put(paramg, ???);
      AppMethodBeat.o(77169);
      return ???;
      paramg = finally;
      AppMethodBeat.o(77169);
      throw paramg;
    }
  }
  
  static final class a
    implements a.c
  {
    private final b aGi;
    final MessageDigest aJq;
    
    a(MessageDigest paramMessageDigest)
    {
      AppMethodBeat.i(77167);
      this.aGi = new b.a();
      this.aJq = paramMessageDigest;
      AppMethodBeat.o(77167);
    }
    
    public final b oK()
    {
      return this.aGi;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.load.b.b.j
 * JD-Core Version:    0.7.0.1
 */
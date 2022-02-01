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
  private final f<h, String> aJu;
  private final l.a<a> aJv;
  
  public j()
  {
    AppMethodBeat.i(77168);
    this.aJu = new f(1000L);
    this.aJv = a.a(10, new a.a()
    {
      private static j.a pg()
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
    a locala = (a)i.checkNotNull(this.aJv.acquire(), "Argument must not be null");
    try
    {
      paramh.a(locala.aJx);
      paramh = com.bumptech.glide.h.j.m(locala.aJx.digest());
      return paramh;
    }
    finally
    {
      this.aJv.release(locala);
      AppMethodBeat.o(77170);
    }
  }
  
  public final String c(h paramh)
  {
    AppMethodBeat.i(77169);
    synchronized (this.aJu)
    {
      ??? = (String)this.aJu.get(paramh);
      ??? = ???;
      if (??? == null) {
        ??? = d(paramh);
      }
    }
    synchronized (this.aJu)
    {
      this.aJu.put(paramh, ???);
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
    private final b aGq;
    final MessageDigest aJx;
    
    a(MessageDigest paramMessageDigest)
    {
      AppMethodBeat.i(77167);
      this.aGq = new b.a();
      this.aJx = paramMessageDigest;
      AppMethodBeat.o(77167);
    }
    
    public final b oE()
    {
      return this.aGq;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.bumptech.glide.c.b.b.j
 * JD-Core Version:    0.7.0.1
 */
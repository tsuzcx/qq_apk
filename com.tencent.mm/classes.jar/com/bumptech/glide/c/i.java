package com.bumptech.glide.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.MessageDigest;

public final class i<T>
{
  private static final a<Object> aCx;
  volatile byte[] aCA;
  final T aCy;
  final a<T> aCz;
  final String key;
  
  static
  {
    AppMethodBeat.i(76855);
    aCx = new a()
    {
      public final void a(byte[] paramAnonymousArrayOfByte, Object paramAnonymousObject, MessageDigest paramAnonymousMessageDigest) {}
    };
    AppMethodBeat.o(76855);
  }
  
  private i(String paramString, T paramT, a<T> parama)
  {
    AppMethodBeat.i(76851);
    this.key = com.bumptech.glide.h.i.checkNotEmpty(paramString);
    this.aCy = paramT;
    this.aCz = ((a)com.bumptech.glide.h.i.checkNotNull(parama, "Argument must not be null"));
    AppMethodBeat.o(76851);
  }
  
  public static <T> i<T> O(String paramString)
  {
    AppMethodBeat.i(76848);
    paramString = new i(paramString, null, aCx);
    AppMethodBeat.o(76848);
    return paramString;
  }
  
  public static <T> i<T> a(String paramString, T paramT, a<T> parama)
  {
    AppMethodBeat.i(76850);
    paramString = new i(paramString, paramT, parama);
    AppMethodBeat.o(76850);
    return paramString;
  }
  
  public static <T> i<T> b(String paramString, T paramT)
  {
    AppMethodBeat.i(76849);
    paramString = new i(paramString, paramT, aCx);
    AppMethodBeat.o(76849);
    return paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(76852);
    if ((paramObject instanceof i))
    {
      paramObject = (i)paramObject;
      boolean bool = this.key.equals(paramObject.key);
      AppMethodBeat.o(76852);
      return bool;
    }
    AppMethodBeat.o(76852);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(76853);
    int i = this.key.hashCode();
    AppMethodBeat.o(76853);
    return i;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(76854);
    String str = "Option{key='" + this.key + '\'' + '}';
    AppMethodBeat.o(76854);
    return str;
  }
  
  public static abstract interface a<T>
  {
    public abstract void a(byte[] paramArrayOfByte, T paramT, MessageDigest paramMessageDigest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.bumptech.glide.c.i
 * JD-Core Version:    0.7.0.1
 */
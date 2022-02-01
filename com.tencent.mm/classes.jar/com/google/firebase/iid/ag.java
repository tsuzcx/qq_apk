package com.google.firebase.iid;

import android.util.Base64;
import com.google.android.gms.common.internal.Objects;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

final class ag
{
  final KeyPair dDP;
  final long dDQ;
  
  ag(KeyPair paramKeyPair, long paramLong)
  {
    this.dDP = paramKeyPair;
    this.dDQ = paramLong;
  }
  
  final String YA()
  {
    AppMethodBeat.i(4252);
    String str = Base64.encodeToString(this.dDP.getPrivate().getEncoded(), 11);
    AppMethodBeat.o(4252);
    return str;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(4249);
    if (!(paramObject instanceof ag))
    {
      AppMethodBeat.o(4249);
      return false;
    }
    paramObject = (ag)paramObject;
    if ((this.dDQ == paramObject.dDQ) && (this.dDP.getPublic().equals(paramObject.dDP.getPublic())) && (this.dDP.getPrivate().equals(paramObject.dDP.getPrivate())))
    {
      AppMethodBeat.o(4249);
      return true;
    }
    AppMethodBeat.o(4249);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(4250);
    int i = Objects.hashCode(new Object[] { this.dDP.getPublic(), this.dDP.getPrivate(), Long.valueOf(this.dDQ) });
    AppMethodBeat.o(4250);
    return i;
  }
  
  final String zzq()
  {
    AppMethodBeat.i(4251);
    String str = Base64.encodeToString(this.dDP.getPublic().getEncoded(), 11);
    AppMethodBeat.o(4251);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.firebase.iid.ag
 * JD-Core Version:    0.7.0.1
 */
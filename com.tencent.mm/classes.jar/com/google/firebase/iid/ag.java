package com.google.firebase.iid;

import android.util.Base64;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.util.VisibleForTesting;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.KeyPair;
import java.security.PrivateKey;
import java.security.PublicKey;

final class ag
{
  final KeyPair bgr;
  final long bgs;
  
  @VisibleForTesting
  ag(KeyPair paramKeyPair, long paramLong)
  {
    this.bgr = paramKeyPair;
    this.bgs = paramLong;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(108813);
    if (!(paramObject instanceof ag))
    {
      AppMethodBeat.o(108813);
      return false;
    }
    paramObject = (ag)paramObject;
    if ((this.bgs == paramObject.bgs) && (this.bgr.getPublic().equals(paramObject.bgr.getPublic())) && (this.bgr.getPrivate().equals(paramObject.bgr.getPrivate())))
    {
      AppMethodBeat.o(108813);
      return true;
    }
    AppMethodBeat.o(108813);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(108814);
    int i = Objects.hashCode(new Object[] { this.bgr.getPublic(), this.bgr.getPrivate(), Long.valueOf(this.bgs) });
    AppMethodBeat.o(108814);
    return i;
  }
  
  final String se()
  {
    AppMethodBeat.i(108816);
    String str = Base64.encodeToString(this.bgr.getPrivate().getEncoded(), 11);
    AppMethodBeat.o(108816);
    return str;
  }
  
  final String zzq()
  {
    AppMethodBeat.i(108815);
    String str = Base64.encodeToString(this.bgr.getPublic().getEncoded(), 11);
    AppMethodBeat.o(108815);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.firebase.iid.ag
 * JD-Core Version:    0.7.0.1
 */
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
  final KeyPair bBY;
  final long bBZ;
  
  @VisibleForTesting
  ag(KeyPair paramKeyPair, long paramLong)
  {
    this.bBY = paramKeyPair;
    this.bBZ = paramLong;
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
    if ((this.bBZ == paramObject.bBZ) && (this.bBY.getPublic().equals(paramObject.bBY.getPublic())) && (this.bBY.getPrivate().equals(paramObject.bBY.getPrivate())))
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
    int i = Objects.hashCode(new Object[] { this.bBY.getPublic(), this.bBY.getPrivate(), Long.valueOf(this.bBZ) });
    AppMethodBeat.o(4250);
    return i;
  }
  
  final String wQ()
  {
    AppMethodBeat.i(4252);
    String str = Base64.encodeToString(this.bBY.getPrivate().getEncoded(), 11);
    AppMethodBeat.o(4252);
    return str;
  }
  
  final String zzq()
  {
    AppMethodBeat.i(4251);
    String str = Base64.encodeToString(this.bBY.getPublic().getEncoded(), 11);
    AppMethodBeat.o(4251);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.firebase.iid.ag
 * JD-Core Version:    0.7.0.1
 */
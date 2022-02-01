package com.google.android.gms.common;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Arrays;

final class zzb
  extends GoogleCertificates.CertData
{
  private final byte[] zzbd;
  
  zzb(byte[] paramArrayOfByte)
  {
    super(Arrays.copyOfRange(paramArrayOfByte, 0, 25));
    AppMethodBeat.i(5352);
    this.zzbd = paramArrayOfByte;
    AppMethodBeat.o(5352);
  }
  
  final byte[] getBytes()
  {
    return this.zzbd;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.gms.common.zzb
 * JD-Core Version:    0.7.0.1
 */
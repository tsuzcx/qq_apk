package com.google.android.gms.iid;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public final class zzd
{
  public static KeyPair zzk()
  {
    AppMethodBeat.i(57562);
    try
    {
      Object localObject = KeyPairGenerator.getInstance("RSA");
      ((KeyPairGenerator)localObject).initialize(2048);
      localObject = ((KeyPairGenerator)localObject).generateKeyPair();
      AppMethodBeat.o(57562);
      return localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      AssertionError localAssertionError = new AssertionError(localNoSuchAlgorithmException);
      AppMethodBeat.o(57562);
      throw localAssertionError;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.gms.iid.zzd
 * JD-Core Version:    0.7.0.1
 */
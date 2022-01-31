package com.google.firebase.iid;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public final class a
{
  public static KeyPair rV()
  {
    AppMethodBeat.i(108713);
    try
    {
      Object localObject = KeyPairGenerator.getInstance("RSA");
      ((KeyPairGenerator)localObject).initialize(2048);
      localObject = ((KeyPairGenerator)localObject).generateKeyPair();
      AppMethodBeat.o(108713);
      return localObject;
    }
    catch (NoSuchAlgorithmException localNoSuchAlgorithmException)
    {
      AssertionError localAssertionError = new AssertionError(localNoSuchAlgorithmException);
      AppMethodBeat.o(108713);
      throw localAssertionError;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.firebase.iid.a
 * JD-Core Version:    0.7.0.1
 */
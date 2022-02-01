package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum PwdEncryptMode
{
  static
  {
    AppMethodBeat.i(226759);
    RSA = new PwdEncryptMode("RSA", 0);
    SM2WITHMD5 = new PwdEncryptMode("SM2WITHMD5", 1);
    SM2WITHPBKDF2 = new PwdEncryptMode("SM2WITHPBKDF2", 2);
    $VALUES = new PwdEncryptMode[] { RSA, SM2WITHMD5, SM2WITHPBKDF2 };
    AppMethodBeat.o(226759);
  }
  
  private PwdEncryptMode() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.gen.PwdEncryptMode
 * JD-Core Version:    0.7.0.1
 */
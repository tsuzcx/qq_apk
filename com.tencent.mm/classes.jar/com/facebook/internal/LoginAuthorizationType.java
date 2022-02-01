package com.facebook.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum LoginAuthorizationType
{
  static
  {
    AppMethodBeat.i(7677);
    READ = new LoginAuthorizationType("READ", 0);
    PUBLISH = new LoginAuthorizationType("PUBLISH", 1);
    $VALUES = new LoginAuthorizationType[] { READ, PUBLISH };
    AppMethodBeat.o(7677);
  }
  
  private LoginAuthorizationType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.internal.LoginAuthorizationType
 * JD-Core Version:    0.7.0.1
 */
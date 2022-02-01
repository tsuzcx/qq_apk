package com.facebook;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum FacebookRequestError$Category
{
  static
  {
    AppMethodBeat.i(17023);
    LOGIN_RECOVERABLE = new Category("LOGIN_RECOVERABLE", 0);
    OTHER = new Category("OTHER", 1);
    TRANSIENT = new Category("TRANSIENT", 2);
    $VALUES = new Category[] { LOGIN_RECOVERABLE, OTHER, TRANSIENT };
    AppMethodBeat.o(17023);
  }
  
  private FacebookRequestError$Category() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.FacebookRequestError.Category
 * JD-Core Version:    0.7.0.1
 */
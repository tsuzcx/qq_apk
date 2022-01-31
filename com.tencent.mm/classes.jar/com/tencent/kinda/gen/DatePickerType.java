package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum DatePickerType
{
  static
  {
    AppMethodBeat.i(141171);
    BIRTH_DAY = new DatePickerType("BIRTH_DAY", 0);
    IDENTITY_VALID_DATE = new DatePickerType("IDENTITY_VALID_DATE", 1);
    $VALUES = new DatePickerType[] { BIRTH_DAY, IDENTITY_VALID_DATE };
    AppMethodBeat.o(141171);
  }
  
  private DatePickerType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.gen.DatePickerType
 * JD-Core Version:    0.7.0.1
 */
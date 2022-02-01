package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum DatePickerType
{
  static
  {
    AppMethodBeat.i(135665);
    BIRTH_DAY = new DatePickerType("BIRTH_DAY", 0);
    IDENTITY_VALID_DATE = new DatePickerType("IDENTITY_VALID_DATE", 1);
    IDENTITY_EFFECT_DATE = new DatePickerType("IDENTITY_EFFECT_DATE", 2);
    $VALUES = new DatePickerType[] { BIRTH_DAY, IDENTITY_VALID_DATE, IDENTITY_EFFECT_DATE };
    AppMethodBeat.o(135665);
  }
  
  private DatePickerType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.gen.DatePickerType
 * JD-Core Version:    0.7.0.1
 */
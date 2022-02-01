package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum KeyboardType
{
  static
  {
    AppMethodBeat.i(135944);
    NORMAL = new KeyboardType("NORMAL", 0);
    NUMBER = new KeyboardType("NUMBER", 1);
    PASSWORD = new KeyboardType("PASSWORD", 2);
    PHONE = new KeyboardType("PHONE", 3);
    EMAIL = new KeyboardType("EMAIL", 4);
    DIGIT = new KeyboardType("DIGIT", 5);
    ID = new KeyboardType("ID", 6);
    CRETAIL = new KeyboardType("CRETAIL", 7);
    $VALUES = new KeyboardType[] { NORMAL, NUMBER, PASSWORD, PHONE, EMAIL, DIGIT, ID, CRETAIL };
    AppMethodBeat.o(135944);
  }
  
  private KeyboardType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.gen.KeyboardType
 * JD-Core Version:    0.7.0.1
 */
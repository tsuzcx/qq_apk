package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum IOSDevice
{
  static
  {
    AppMethodBeat.i(135708);
    IPHONE4 = new IOSDevice("IPHONE4", 0);
    IPHONE6 = new IOSDevice("IPHONE6", 1);
    IPHONE6P = new IOSDevice("IPHONE6P", 2);
    IPHONEX = new IOSDevice("IPHONEX", 3);
    IPAD = new IOSDevice("IPAD", 4);
    UNKNOWN = new IOSDevice("UNKNOWN", 5);
    $VALUES = new IOSDevice[] { IPHONE4, IPHONE6, IPHONE6P, IPHONEX, IPAD, UNKNOWN };
    AppMethodBeat.o(135708);
  }
  
  private IOSDevice() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.IOSDevice
 * JD-Core Version:    0.7.0.1
 */
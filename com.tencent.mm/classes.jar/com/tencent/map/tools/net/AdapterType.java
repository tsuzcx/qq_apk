package com.tencent.map.tools.net;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum AdapterType
{
  static
  {
    AppMethodBeat.i(172908);
    DEFAULT = new AdapterType("DEFAULT", 0);
    URL = new AdapterType("URL", 1);
    Halley = new AdapterType("Halley", 2);
    $VALUES = new AdapterType[] { DEFAULT, URL, Halley };
    AppMethodBeat.o(172908);
  }
  
  private AdapterType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.map.tools.net.AdapterType
 * JD-Core Version:    0.7.0.1
 */
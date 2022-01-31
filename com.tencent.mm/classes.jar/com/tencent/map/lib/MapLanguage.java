package com.tencent.map.lib;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum MapLanguage
{
  static
  {
    AppMethodBeat.i(97840);
    LAN_CHINESE = new MapLanguage("LAN_CHINESE", 0);
    LAN_ENGLISH = new MapLanguage("LAN_ENGLISH", 1);
    $VALUES = new MapLanguage[] { LAN_CHINESE, LAN_ENGLISH };
    AppMethodBeat.o(97840);
  }
  
  private MapLanguage() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.map.lib.MapLanguage
 * JD-Core Version:    0.7.0.1
 */
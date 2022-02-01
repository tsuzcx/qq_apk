package com.tencent.map.lib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.tencentmap.mapsdk.maps.model.ILanguage;

public enum MapLanguage
  implements ILanguage
{
  static
  {
    AppMethodBeat.i(83343);
    LAN_CHINESE = new MapLanguage("LAN_CHINESE", 0);
    LAN_ENGLISH = new MapLanguage("LAN_ENGLISH", 1);
    $VALUES = new MapLanguage[] { LAN_CHINESE, LAN_ENGLISH };
    AppMethodBeat.o(83343);
  }
  
  private MapLanguage() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.map.lib.MapLanguage
 * JD-Core Version:    0.7.0.1
 */
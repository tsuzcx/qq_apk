package com.tencent.map.sdk.comps.offlinemap;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum OfflineStatus
{
  static
  {
    AppMethodBeat.i(236129);
    ERROR = new OfflineStatus("ERROR", 0);
    READY = new OfflineStatus("READY", 1);
    START = new OfflineStatus("START", 2);
    DOWNLOADING = new OfflineStatus("DOWNLOADING", 3);
    CANCEL = new OfflineStatus("CANCEL", 4);
    COMPLETED = new OfflineStatus("COMPLETED", 5);
    OPEN = new OfflineStatus("OPEN", 6);
    CLOSE = new OfflineStatus("CLOSE", 7);
    $VALUES = new OfflineStatus[] { ERROR, READY, START, DOWNLOADING, CANCEL, COMPLETED, OPEN, CLOSE };
    AppMethodBeat.o(236129);
  }
  
  private OfflineStatus() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.map.sdk.comps.offlinemap.OfflineStatus
 * JD-Core Version:    0.7.0.1
 */
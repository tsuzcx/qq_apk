package com.danikula.videocache.sourcestorage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SourceInfoStorageFactory
{
  public static SourceInfoStorage newEmptySourceInfoStorage()
  {
    AppMethodBeat.i(192562);
    NoSourceInfoStorage localNoSourceInfoStorage = new NoSourceInfoStorage();
    AppMethodBeat.o(192562);
    return localNoSourceInfoStorage;
  }
  
  public static SourceInfoStorage newSourceInfoStorage(Context paramContext)
  {
    AppMethodBeat.i(192561);
    paramContext = new DatabaseSourceInfoStorage(paramContext);
    AppMethodBeat.o(192561);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.danikula.videocache.sourcestorage.SourceInfoStorageFactory
 * JD-Core Version:    0.7.0.1
 */
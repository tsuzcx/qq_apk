package com.danikula.videocache.sourcestorage;

import android.content.Context;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class SourceInfoStorageFactory
{
  public static SourceInfoStorage newEmptySourceInfoStorage()
  {
    AppMethodBeat.i(190362);
    NoSourceInfoStorage localNoSourceInfoStorage = new NoSourceInfoStorage();
    AppMethodBeat.o(190362);
    return localNoSourceInfoStorage;
  }
  
  public static SourceInfoStorage newSourceInfoStorage(Context paramContext)
  {
    AppMethodBeat.i(190361);
    paramContext = new DatabaseSourceInfoStorage(paramContext);
    AppMethodBeat.o(190361);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.danikula.videocache.sourcestorage.SourceInfoStorageFactory
 * JD-Core Version:    0.7.0.1
 */
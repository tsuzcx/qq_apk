package com.tencent.maas.instamovie;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum MJMovieSessionState
{
  private final int value;
  
  static
  {
    AppMethodBeat.i(216914);
    Error = new MJMovieSessionState("Error", 0, -1);
    Initial = new MJMovieSessionState("Initial", 1, 0);
    InitialCreating = new MJMovieSessionState("InitialCreating", 2, 1);
    Ready = new MJMovieSessionState("Ready", 3, 2);
    Recreating = new MJMovieSessionState("Recreating", 4, 3);
    Exporting = new MJMovieSessionState("Exporting", 5, 4);
    Playing = new MJMovieSessionState("Playing", 6, 5);
    Teardowning = new MJMovieSessionState("Teardowning", 7, 6);
    $VALUES = new MJMovieSessionState[] { Error, Initial, InitialCreating, Ready, Recreating, Exporting, Playing, Teardowning };
    AppMethodBeat.o(216914);
  }
  
  private MJMovieSessionState(int paramInt)
  {
    this.value = paramInt;
  }
  
  public static MJMovieSessionState fromInt(int paramInt)
  {
    AppMethodBeat.i(216912);
    Object localObject = values();
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      MJMovieSessionState localMJMovieSessionState = localObject[i];
      if (localMJMovieSessionState.getValue() == paramInt)
      {
        AppMethodBeat.o(216912);
        return localMJMovieSessionState;
      }
      i += 1;
    }
    localObject = Error;
    AppMethodBeat.o(216912);
    return localObject;
  }
  
  public final int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.instamovie.MJMovieSessionState
 * JD-Core Version:    0.7.0.1
 */
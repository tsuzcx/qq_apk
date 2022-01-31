package com.facebook.appevents.codeless.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum PathComponent$MatchBitmaskType
{
  private final int value;
  
  static
  {
    AppMethodBeat.i(72104);
    ID = new MatchBitmaskType("ID", 0, 1);
    TEXT = new MatchBitmaskType("TEXT", 1, 2);
    TAG = new MatchBitmaskType("TAG", 2, 4);
    DESCRIPTION = new MatchBitmaskType("DESCRIPTION", 3, 8);
    HINT = new MatchBitmaskType("HINT", 4, 16);
    $VALUES = new MatchBitmaskType[] { ID, TEXT, TAG, DESCRIPTION, HINT };
    AppMethodBeat.o(72104);
  }
  
  private PathComponent$MatchBitmaskType(int paramInt)
  {
    this.value = paramInt;
  }
  
  public final int getValue()
  {
    return this.value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.facebook.appevents.codeless.internal.PathComponent.MatchBitmaskType
 * JD-Core Version:    0.7.0.1
 */
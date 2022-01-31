package com.facebook.appevents.codeless.internal;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum EventBinding$ActionType
{
  static
  {
    AppMethodBeat.i(72093);
    CLICK = new ActionType("CLICK", 0);
    SELECTED = new ActionType("SELECTED", 1);
    TEXT_CHANGED = new ActionType("TEXT_CHANGED", 2);
    $VALUES = new ActionType[] { CLICK, SELECTED, TEXT_CHANGED };
    AppMethodBeat.o(72093);
  }
  
  private EventBinding$ActionType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.facebook.appevents.codeless.internal.EventBinding.ActionType
 * JD-Core Version:    0.7.0.1
 */
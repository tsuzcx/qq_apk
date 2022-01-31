package com.facebook.share.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum GameRequestContent$ActionType
{
  static
  {
    AppMethodBeat.i(97379);
    SEND = new ActionType("SEND", 0);
    ASKFOR = new ActionType("ASKFOR", 1);
    TURN = new ActionType("TURN", 2);
    $VALUES = new ActionType[] { SEND, ASKFOR, TURN };
    AppMethodBeat.o(97379);
  }
  
  private GameRequestContent$ActionType() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.facebook.share.model.GameRequestContent.ActionType
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.expt.roomexpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c
  implements Comparable<c>
{
  String dec;
  String nickname;
  float score;
  
  public final String toString()
  {
    AppMethodBeat.i(122426);
    String str = String.format("chatroom[%s %s] score[%f]", new Object[] { this.dec, this.nickname, Float.valueOf(this.score) });
    AppMethodBeat.o(122426);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.c
 * JD-Core Version:    0.7.0.1
 */
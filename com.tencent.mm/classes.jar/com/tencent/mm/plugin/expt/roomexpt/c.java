package com.tencent.mm.plugin.expt.roomexpt;

import com.tencent.matrix.trace.core.AppMethodBeat;

final class c
  implements Comparable<c>
{
  String cpf;
  float mcQ;
  String nickname;
  
  public final String toString()
  {
    AppMethodBeat.i(73588);
    String str = String.format("chatroom[%s %s] score[%f]", new Object[] { this.cpf, this.nickname, Float.valueOf(this.mcQ) });
    AppMethodBeat.o(73588);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.c
 * JD-Core Version:    0.7.0.1
 */
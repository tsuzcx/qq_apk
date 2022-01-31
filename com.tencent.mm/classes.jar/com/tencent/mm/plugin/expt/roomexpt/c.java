package com.tencent.mm.plugin.expt.roomexpt;

final class c
  implements Comparable<c>
{
  String bHQ;
  float jIO;
  String nickname;
  
  public final String toString()
  {
    return String.format("chatroom[%s %s] score[%f]", new Object[] { this.bHQ, this.nickname, Float.valueOf(this.jIO) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.roomexpt.c
 * JD-Core Version:    0.7.0.1
 */
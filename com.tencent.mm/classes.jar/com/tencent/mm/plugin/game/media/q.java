package com.tencent.mm.plugin.game.media;

public final class q
{
  public static int c(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    int j = 0;
    if (paramBoolean1) {
      j = 1;
    }
    int i = j;
    if (paramBoolean2) {
      i = j | 0x2;
    }
    j = i;
    if (paramBoolean3) {
      j = i | 0x4;
    }
    i = j;
    if (paramBoolean4) {
      i = j | 0x8;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.q
 * JD-Core Version:    0.7.0.1
 */
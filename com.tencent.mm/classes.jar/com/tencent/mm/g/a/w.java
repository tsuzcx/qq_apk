package com.tencent.mm.g.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.b.b;

public final class w
  extends b
{
  public w.a cZm;
  
  public w()
  {
    this((byte)0);
  }
  
  private w(byte paramByte)
  {
    AppMethodBeat.i(136973);
    this.cZm = new w.a();
    this.Gqe = false;
    this.callback = null;
    AppMethodBeat.o(136973);
  }
  
  public static String hX(int paramInt)
  {
    if (paramInt == 0) {
      return "play";
    }
    if (paramInt == 1) {
      return "play";
    }
    if (paramInt == 2) {
      return "pause";
    }
    if (paramInt == 3) {
      return "stop";
    }
    if (paramInt == 4) {
      return "error";
    }
    if (paramInt == 5) {
      return "ended";
    }
    if (paramInt == 6) {
      return "seeked";
    }
    if (paramInt == 7) {
      return "canplay";
    }
    if (paramInt == 9) {
      return "waiting";
    }
    if (paramInt == 10) {
      return "seeking";
    }
    if (paramInt == 11) {
      return "real_play";
    }
    if (paramInt == 12) {
      return "mix_play_ready";
    }
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.g.a.w
 * JD-Core Version:    0.7.0.1
 */
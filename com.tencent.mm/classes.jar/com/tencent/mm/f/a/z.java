package com.tencent.mm.f.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;

public final class z
  extends IEvent
{
  public a fvC;
  
  public z()
  {
    this((byte)0);
  }
  
  private z(byte paramByte)
  {
    AppMethodBeat.i(136973);
    this.fvC = new a();
    this.order = false;
    this.callback = null;
    AppMethodBeat.o(136973);
  }
  
  public static String kU(int paramInt)
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
    if (paramInt == 13) {
      return "preload_end";
    }
    return "";
  }
  
  public static final class a
  {
    public int action;
    public String appId;
    public long duration;
    public int errCode;
    public String errMsg;
    public String fmF;
    public String fnV;
    public String state;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.f.a.z
 * JD-Core Version:    0.7.0.1
 */
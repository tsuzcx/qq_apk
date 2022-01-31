package com.tencent.mm.plugin.appbrand.b;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum d$a
{
  private final boolean gYH;
  final int intValue;
  
  static
  {
    AppMethodBeat.i(141648);
    gYz = new a("NONE", 0, 0);
    gYA = new a("TO_BACKGROUND", 1, 1);
    gYB = new a("TO_FOREGROUND", 2, 3);
    gYC = new a("TO_SUSPEND_FROM_BACKGROUND", 3, 4, true);
    gYD = new a("ON_SYSTEM_SCREEN_OFF", 4, 10);
    gYE = new a("ON_SUSPEND_TIMEOUT", 5, 11, true);
    gYF = new a("ON_DETACH_FROM_STACK", 6, 12);
    gYG = new a("AWAKE_MSG_QUEUE", 7, 1000);
    gYI = new a[] { gYz, gYA, gYB, gYC, gYD, gYE, gYF, gYG };
    AppMethodBeat.o(141648);
  }
  
  private d$a(int paramInt)
  {
    this(paramInt, false);
  }
  
  private d$a(int paramInt, boolean paramBoolean)
  {
    this.intValue = paramInt;
    this.gYH = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.b.d.a
 * JD-Core Version:    0.7.0.1
 */
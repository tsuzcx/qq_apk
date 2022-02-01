package com.jg;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum EType
{
  static
  {
    AppMethodBeat.i(61442);
    ALL = new EType("ALL", 0);
    ACTIVITYCHECK = new EType("ACTIVITYCHECK", 1);
    PROVIDERCHECK = new EType("PROVIDERCHECK", 2);
    RECEIVERCHECK = new EType("RECEIVERCHECK", 3);
    SERVICESCHECK = new EType("SERVICESCHECK", 4);
    PERMISSIONCHECK = new EType("PERMISSIONCHECK", 5);
    INTENTCHECK = new EType("INTENTCHECK", 6);
    SECURERANDOMCHECK = new EType("SECURERANDOMCHECK", 7);
    JSEXECUTECHECK = new EType("JSEXECUTECHECK", 8);
    HTTPSCHECK = new EType("HTTPSCHECK", 9);
    ENUM$VALUES = new EType[] { ALL, ACTIVITYCHECK, PROVIDERCHECK, RECEIVERCHECK, SERVICESCHECK, PERMISSIONCHECK, INTENTCHECK, SECURERANDOMCHECK, JSEXECUTECHECK, HTTPSCHECK };
    AppMethodBeat.o(61442);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.jg.EType
 * JD-Core Version:    0.7.0.1
 */
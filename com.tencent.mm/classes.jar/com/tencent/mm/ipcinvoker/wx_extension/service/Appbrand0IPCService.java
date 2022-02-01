package com.tencent.mm.ipcinvoker.wx_extension.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class Appbrand0IPCService
  extends BaseIPCService
{
  public static final String dkO;
  
  static
  {
    AppMethodBeat.i(225231);
    dkO = MMApplicationContext.getPackageName() + ":appbrand0";
    AppMethodBeat.o(225231);
  }
  
  public final String getProcessName()
  {
    return dkO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand0IPCService
 * JD-Core Version:    0.7.0.1
 */
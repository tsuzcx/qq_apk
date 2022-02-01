package com.tencent.mm.ipcinvoker.wx_extension.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class Appbrand4IPCService
  extends BaseIPCService
{
  public static final String PROCESS_NAME;
  
  static
  {
    AppMethodBeat.i(235718);
    PROCESS_NAME = MMApplicationContext.getPackageName() + ":appbrand4";
    AppMethodBeat.o(235718);
  }
  
  public final String getProcessName()
  {
    return PROCESS_NAME;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.service.Appbrand4IPCService
 * JD-Core Version:    0.7.0.1
 */
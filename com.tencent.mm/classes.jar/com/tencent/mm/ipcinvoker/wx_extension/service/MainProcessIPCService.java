package com.tencent.mm.ipcinvoker.wx_extension.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class MainProcessIPCService
  extends BaseIPCService
{
  public static final String PROCESS_NAME;
  
  static
  {
    AppMethodBeat.i(235712);
    PROCESS_NAME = MMApplicationContext.getPackageName();
    AppMethodBeat.o(235712);
  }
  
  public final String getProcessName()
  {
    return PROCESS_NAME;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.service.MainProcessIPCService
 * JD-Core Version:    0.7.0.1
 */
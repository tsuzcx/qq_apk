package com.tencent.mm.ipcinvoker.wx_extension.service;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.BaseIPCService;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;

public class ToolsMpProcessIPCService
  extends BaseIPCService
{
  public static final String dkO;
  
  static
  {
    AppMethodBeat.i(225239);
    dkO = MMApplicationContext.getPackageName() + ":toolsmp";
    AppMethodBeat.o(225239);
  }
  
  public final String getProcessName()
  {
    return dkO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.service.ToolsMpProcessIPCService
 * JD-Core Version:    0.7.0.1
 */
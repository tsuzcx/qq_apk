package com.tencent.mm.plugin.appbrand.debugger.console;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/debugger/console/ConsoleDebugLogImpl$LogInfoBuffer;", "", "()V", "bufferedIndex", "", "bufferedSize", "realBuffer", "", "Lcom/tencent/mm/plugin/appbrand/debugger/console/ConsoleDebugLogImpl$LogInfo;", "[Lcom/tencent/mm/plugin/appbrand/debugger/console/ConsoleDebugLogImpl$LogInfo;", "read", "()[Lcom/tencent/mm/plugin/appbrand/debugger/console/ConsoleDebugLogImpl$LogInfo;", "write", "logInfo", "Companion", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
final class ConsoleDebugLogImpl$b
{
  public static final a rfd;
  final ConsoleDebugLogImpl.LogInfo[] rfe;
  int rff;
  int rfg;
  
  static
  {
    AppMethodBeat.i(319717);
    rfd = new a((byte)0);
    AppMethodBeat.o(319717);
  }
  
  public ConsoleDebugLogImpl$b()
  {
    AppMethodBeat.i(319711);
    this.rfe = new ConsoleDebugLogImpl.LogInfo[100];
    this.rff = -1;
    AppMethodBeat.o(319711);
  }
  
  public final ConsoleDebugLogImpl.LogInfo[] cmc()
  {
    AppMethodBeat.i(319724);
    int j = this.rff + 1;
    ConsoleDebugLogImpl.LogInfo[] arrayOfLogInfo = new ConsoleDebugLogImpl.LogInfo[j];
    int i = 0;
    while (i < j)
    {
      ConsoleDebugLogImpl.LogInfo localLogInfo = this.rfe[i];
      s.checkNotNull(localLogInfo);
      arrayOfLogInfo[i] = localLogInfo;
      i += 1;
    }
    this.rff = -1;
    this.rfg = 0;
    AppMethodBeat.o(319724);
    return arrayOfLogInfo;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/appbrand/debugger/console/ConsoleDebugLogImpl$LogInfoBuffer$Companion;", "", "()V", "MAX_BUFFER_LOG_INFO_COUNT", "", "MAX_BUFFER_SIZE_IN_BYTE", "WRITE_SUCCESS", "WRITE_SUCCESS_NEED_FLUSH", "WriteResult", "plugin-appbrand-integration_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.debugger.console.ConsoleDebugLogImpl.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.bw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/processor/FunctionMsgItemProcessorFactory;", "", "()V", "CMDID_FINDER_LIVE_NOTICE", "", "getCMDID_FINDER_LIVE_NOTICE", "()I", "baseProcessor", "Lcom/tencent/mm/processor/BaseFunctionMsgItemProcessor;", "processorMap", "Ljava/util/HashMap;", "Lcom/tencent/mm/processor/IFunctionMsgItemProcessor;", "Lkotlin/collections/HashMap;", "getProcessor", "cmdId", "registProcessor", "", "processor", "plugin-functionmsg_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public static final c YwQ;
  private static final a YwR;
  private static final int YwS;
  private static final HashMap<Integer, d> oNY;
  
  static
  {
    AppMethodBeat.i(236134);
    YwQ = new c();
    oNY = new HashMap();
    YwR = new a();
    YwS = 6407;
    d locald = (d)new b();
    s.u(locald, "processor");
    for (;;)
    {
      int i;
      synchronized (oNY)
      {
        Object localObject1 = oNY;
        if (!((HashMap)localObject1).containsKey(Integer.valueOf(6407)))
        {
          i = 1;
          break label141;
          if (localObject1 != null)
          {
            ((Map)oNY).put(Integer.valueOf(6407), locald);
            localObject1 = ah.aiuX;
          }
          AppMethodBeat.o(236134);
        }
        else
        {
          i = 0;
          break label141;
          localObject1 = null;
        }
      }
      label141:
      if (i == 0) {}
    }
  }
  
  public static d axm(int paramInt)
  {
    AppMethodBeat.i(236129);
    synchronized (oNY)
    {
      Object localObject3 = (d)oNY.get(Integer.valueOf(paramInt));
      Object localObject1 = localObject3;
      if (localObject3 == null) {
        localObject1 = null;
      }
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = (d)YwR;
      }
      AppMethodBeat.o(236129);
      return localObject3;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bw.c
 * JD-Core Version:    0.7.0.1
 */
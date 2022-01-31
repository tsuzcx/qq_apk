package com.tencent.mm;

import a.f.b.j;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;
import com.tencent.mm.u.a;
import com.tencent.mm.u.c;

final class PluginFunctionMsg$1
  implements t
{
  PluginFunctionMsg$1(PluginFunctionMsg paramPluginFunctionMsg) {}
  
  public final void W(Object paramObject)
  {
    AppMethodBeat.i(141038);
    this.bVc.getReceiver();
    if (a.bRB)
    {
      a.Pl();
      a.bRB = false;
    }
    ab.i("FunctionMsg.FunctionMsgEngine", "[beforeSyncDoCmd] isInit:" + a.bRB);
    AppMethodBeat.o(141038);
  }
  
  public final void X(Object paramObject)
  {
    AppMethodBeat.i(141039);
    this.bVc.getReceiver();
    paramObject = g.RL();
    j.p(paramObject, "MMKernel.storage()");
    long l = paramObject.Ru().Ns(8196);
    boolean bool1;
    boolean bool2;
    if ((0x7 & l) != 0L)
    {
      bool1 = true;
      if ((!a.eyG) && (System.currentTimeMillis() - a.bUI < 15000L)) {
        break label222;
      }
      bool2 = true;
      label70:
      ab.i("FunctionMsg.FunctionMsgEngine", "[isNeedCheckTimer] continueFlag:" + l + ", isContinueSync:" + bool1 + ", isNeedCheck:" + bool2 + ", isNeedCheckSoon:" + a.eyG);
      a.cq(bool1);
      if ((bool1) || (!bool2)) {
        break label228;
      }
    }
    label222:
    label228:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        paramObject = a.eyF;
        l = System.currentTimeMillis();
        paramObject.eyS.loop();
        ab.i("FunctionMsg.FunctionMsgTimer", "[check] Cost:%s", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
        a.bUI = System.currentTimeMillis();
        a.eyG = false;
        ab.i("FunctionMsg.FunctionMsgEngine", "[afterSyncDoCmd] check time:%s", new Object[] { Long.valueOf(System.currentTimeMillis()) });
      }
      AppMethodBeat.o(141039);
      return;
      bool1 = false;
      break;
      bool2 = false;
      break label70;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.PluginFunctionMsg.1
 * JD-Core Version:    0.7.0.1
 */
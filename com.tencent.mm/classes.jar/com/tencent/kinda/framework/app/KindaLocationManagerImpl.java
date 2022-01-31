package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.KindaLocationManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.m;
import com.tencent.mm.protocal.protobuf.aw;

public class KindaLocationManagerImpl
  implements KindaLocationManager
{
  public String getEncryptInfo(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(144370);
    Object localObject = m.cTC();
    if (localObject != null)
    {
      localObject = ((aw)localObject).wmS;
      AppMethodBeat.o(144370);
      return localObject;
    }
    AppMethodBeat.o(144370);
    return "";
  }
  
  public String getEncryptKey()
  {
    AppMethodBeat.i(144371);
    Object localObject = m.cTC();
    if (localObject != null)
    {
      localObject = ((aw)localObject).wmT;
      AppMethodBeat.o(144371);
      return localObject;
    }
    AppMethodBeat.o(144371);
    return "";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaLocationManagerImpl
 * JD-Core Version:    0.7.0.1
 */
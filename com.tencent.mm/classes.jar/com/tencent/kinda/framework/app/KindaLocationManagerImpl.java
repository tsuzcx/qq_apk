package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.KindaLocationManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.bd;
import com.tencent.mm.sdk.platformtools.Log;

public class KindaLocationManagerImpl
  implements KindaLocationManager
{
  private static final String TAG = "KindaLocationManagerImpl";
  
  public String getCellInfo()
  {
    AppMethodBeat.i(18454);
    String str = "";
    bd localbd = k.gJe();
    if (localbd != null) {
      str = localbd.RFZ;
    }
    Log.i("KindaLocationManagerImpl", "getCellInfo return: ".concat(String.valueOf(str)));
    AppMethodBeat.o(18454);
    return str;
  }
  
  public String getEncryptInfo(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(18453);
    String str = "";
    bd localbd = k.gJe();
    if (localbd != null) {
      str = localbd.RFX;
    }
    Log.i("KindaLocationManagerImpl", "getEncryptInfo return: ".concat(String.valueOf(str)));
    AppMethodBeat.o(18453);
    return str;
  }
  
  public String getEncryptKey()
  {
    AppMethodBeat.i(18455);
    String str = "";
    bd localbd = k.gJe();
    if (localbd != null) {
      str = localbd.RFY;
    }
    Log.i("KindaLocationManagerImpl", "getEncryptKey return: ".concat(String.valueOf(str)));
    AppMethodBeat.o(18455);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaLocationManagerImpl
 * JD-Core Version:    0.7.0.1
 */
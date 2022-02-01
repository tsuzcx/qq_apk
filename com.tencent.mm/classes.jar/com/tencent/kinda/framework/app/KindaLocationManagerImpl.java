package com.tencent.kinda.framework.app;

import com.tencent.kinda.gen.KindaLocationManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.protocal.protobuf.az;
import com.tencent.mm.sdk.platformtools.ad;

public class KindaLocationManagerImpl
  implements KindaLocationManager
{
  private static final String TAG = "KindaLocationManagerImpl";
  
  public String getCellInfo()
  {
    AppMethodBeat.i(18454);
    String str = "";
    az localaz = k.ebS();
    if (localaz != null) {
      str = localaz.Cvj;
    }
    ad.i("KindaLocationManagerImpl", "getCellInfo return: ".concat(String.valueOf(str)));
    AppMethodBeat.o(18454);
    return str;
  }
  
  public String getEncryptInfo(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(18453);
    String str = "";
    az localaz = k.ebS();
    if (localaz != null) {
      str = localaz.Cvh;
    }
    ad.i("KindaLocationManagerImpl", "getEncryptInfo return: ".concat(String.valueOf(str)));
    AppMethodBeat.o(18453);
    return str;
  }
  
  public String getEncryptKey()
  {
    AppMethodBeat.i(18455);
    String str = "";
    az localaz = k.ebS();
    if (localaz != null) {
      str = localaz.Cvi;
    }
    ad.i("KindaLocationManagerImpl", "getEncryptKey return: ".concat(String.valueOf(str)));
    AppMethodBeat.o(18455);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaLocationManagerImpl
 * JD-Core Version:    0.7.0.1
 */
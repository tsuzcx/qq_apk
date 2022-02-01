package com.tencent.mm.plugin.luckymoney.ui;

import com.tencent.kinda.gen.ITransmitKvData;
import com.tencent.kinda.gen.KUserService;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class b
  implements KUserService
{
  public void updateUserInfo(ITransmitKvData paramITransmitKvData)
  {
    AppMethodBeat.i(284227);
    Log.i("KindaUserInfoService", "updateUserInfo");
    AppMethodBeat.o(284227);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.b
 * JD-Core Version:    0.7.0.1
 */
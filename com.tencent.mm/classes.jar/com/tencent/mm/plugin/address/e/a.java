package com.tencent.mm.plugin.address.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.sdk.platformtools.Log;

public final class a
{
  public static Intent b(b paramb)
  {
    AppMethodBeat.i(21053);
    if (paramb == null)
    {
      Log.e("MicroMsg.AddrUtil", "addressObj == null");
      AppMethodBeat.o(21053);
      return null;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("nationalCode", paramb.kto);
    localIntent.putExtra("userName", paramb.ktm);
    localIntent.putExtra("telNumber", paramb.ktn);
    localIntent.putExtra("addressPostalCode", paramb.ktk);
    localIntent.putExtra("proviceFirstStageName", paramb.kth);
    localIntent.putExtra("addressCitySecondStageName", paramb.kti);
    localIntent.putExtra("addressCountiesThirdStageName", paramb.ktj);
    localIntent.putExtra("addressDetailInfo", paramb.ktl);
    AppMethodBeat.o(21053);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.e.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.address.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.sdk.platformtools.ad;

public final class a
{
  public static Intent b(b paramb)
  {
    AppMethodBeat.i(21053);
    if (paramb == null)
    {
      ad.e("MicroMsg.AddrUtil", "addressObj == null");
      AppMethodBeat.o(21053);
      return null;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("nationalCode", paramb.iyV);
    localIntent.putExtra("userName", paramb.iyT);
    localIntent.putExtra("telNumber", paramb.iyU);
    localIntent.putExtra("addressPostalCode", paramb.iyR);
    localIntent.putExtra("proviceFirstStageName", paramb.iyO);
    localIntent.putExtra("addressCitySecondStageName", paramb.iyP);
    localIntent.putExtra("addressCountiesThirdStageName", paramb.iyQ);
    localIntent.putExtra("addressDetailInfo", paramb.iyS);
    AppMethodBeat.o(21053);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.e.a
 * JD-Core Version:    0.7.0.1
 */
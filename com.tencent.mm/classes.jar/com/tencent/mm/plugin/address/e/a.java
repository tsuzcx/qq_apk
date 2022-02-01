package com.tencent.mm.plugin.address.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.sdk.platformtools.ae;

public final class a
{
  public static Intent b(b paramb)
  {
    AppMethodBeat.i(21053);
    if (paramb == null)
    {
      ae.e("MicroMsg.AddrUtil", "addressObj == null");
      AppMethodBeat.o(21053);
      return null;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("nationalCode", paramb.jva);
    localIntent.putExtra("userName", paramb.juY);
    localIntent.putExtra("telNumber", paramb.juZ);
    localIntent.putExtra("addressPostalCode", paramb.juW);
    localIntent.putExtra("proviceFirstStageName", paramb.juT);
    localIntent.putExtra("addressCitySecondStageName", paramb.juU);
    localIntent.putExtra("addressCountiesThirdStageName", paramb.juV);
    localIntent.putExtra("addressDetailInfo", paramb.juX);
    AppMethodBeat.o(21053);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.address.e.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.address.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.sdk.platformtools.ac;

public final class a
{
  public static Intent b(b paramb)
  {
    AppMethodBeat.i(21053);
    if (paramb == null)
    {
      ac.e("MicroMsg.AddrUtil", "addressObj == null");
      AppMethodBeat.o(21053);
      return null;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("nationalCode", paramb.iYY);
    localIntent.putExtra("userName", paramb.iYW);
    localIntent.putExtra("telNumber", paramb.iYX);
    localIntent.putExtra("addressPostalCode", paramb.iYU);
    localIntent.putExtra("proviceFirstStageName", paramb.iYR);
    localIntent.putExtra("addressCitySecondStageName", paramb.iYS);
    localIntent.putExtra("addressCountiesThirdStageName", paramb.iYT);
    localIntent.putExtra("addressDetailInfo", paramb.iYV);
    AppMethodBeat.o(21053);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.address.e.a
 * JD-Core Version:    0.7.0.1
 */
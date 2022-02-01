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
    localIntent.putExtra("nationalCode", paramb.nlb);
    localIntent.putExtra("userName", paramb.nkZ);
    localIntent.putExtra("telNumber", paramb.nla);
    localIntent.putExtra("addressPostalCode", paramb.nkX);
    localIntent.putExtra("proviceFirstStageName", paramb.nkU);
    localIntent.putExtra("addressCitySecondStageName", paramb.nkV);
    localIntent.putExtra("addressCountiesThirdStageName", paramb.nkW);
    localIntent.putExtra("addressCountiesFourStageName", paramb.nlc);
    localIntent.putExtra("addressDetailInfo", paramb.nkY);
    AppMethodBeat.o(21053);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.address.e.a
 * JD-Core Version:    0.7.0.1
 */
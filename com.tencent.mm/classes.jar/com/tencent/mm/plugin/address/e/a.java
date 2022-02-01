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
    localIntent.putExtra("nationalCode", paramb.jsh);
    localIntent.putExtra("userName", paramb.jsf);
    localIntent.putExtra("telNumber", paramb.jsg);
    localIntent.putExtra("addressPostalCode", paramb.jsd);
    localIntent.putExtra("proviceFirstStageName", paramb.jsa);
    localIntent.putExtra("addressCitySecondStageName", paramb.jsb);
    localIntent.putExtra("addressCountiesThirdStageName", paramb.jsc);
    localIntent.putExtra("addressDetailInfo", paramb.jse);
    AppMethodBeat.o(21053);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.address.e.a
 * JD-Core Version:    0.7.0.1
 */
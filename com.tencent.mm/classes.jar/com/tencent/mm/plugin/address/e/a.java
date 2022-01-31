package com.tencent.mm.plugin.address.e;

import android.content.Intent;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.sdk.platformtools.y;

public final class a
{
  public static Intent b(b paramb)
  {
    if (paramb == null)
    {
      y.e("MicroMsg.AddrUtil", "addressObj == null");
      return null;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("nationalCode", paramb.ftJ);
    localIntent.putExtra("userName", paramb.ftH);
    localIntent.putExtra("telNumber", paramb.ftI);
    localIntent.putExtra("addressPostalCode", paramb.ftF);
    localIntent.putExtra("proviceFirstStageName", paramb.ftC);
    localIntent.putExtra("addressCitySecondStageName", paramb.ftD);
    localIntent.putExtra("addressCountiesThirdStageName", paramb.ftE);
    localIntent.putExtra("addressDetailInfo", paramb.ftG);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.address.e.a
 * JD-Core Version:    0.7.0.1
 */
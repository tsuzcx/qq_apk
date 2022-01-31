package com.tencent.mm.plugin.address.e;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.address.d.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class a
{
  public static Intent b(b paramb)
  {
    AppMethodBeat.i(17010);
    if (paramb == null)
    {
      ab.e("MicroMsg.AddrUtil", "addressObj == null");
      AppMethodBeat.o(17010);
      return null;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("nationalCode", paramb.gLl);
    localIntent.putExtra("userName", paramb.gLj);
    localIntent.putExtra("telNumber", paramb.gLk);
    localIntent.putExtra("addressPostalCode", paramb.gLh);
    localIntent.putExtra("proviceFirstStageName", paramb.gLe);
    localIntent.putExtra("addressCitySecondStageName", paramb.gLf);
    localIntent.putExtra("addressCountiesThirdStageName", paramb.gLg);
    localIntent.putExtra("addressDetailInfo", paramb.gLi);
    AppMethodBeat.o(17010);
    return localIntent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.address.e.a
 * JD-Core Version:    0.7.0.1
 */
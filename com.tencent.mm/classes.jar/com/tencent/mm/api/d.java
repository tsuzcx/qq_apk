package com.tencent.mm.api;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cew;
import com.tencent.mm.protocal.protobuf.cya;
import com.tencent.mm.protocal.protobuf.cyc;
import com.tencent.mm.protocal.protobuf.cyp;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.e.c;

public final class d
{
  public static void a(Intent paramIntent, cya paramcya)
  {
    AppMethodBeat.i(123931);
    ((m)g.ab(m.class)).a(paramIntent, paramcya, 15);
    AppMethodBeat.o(123931);
  }
  
  public static void a(Intent paramIntent, cyc paramcyc, int paramInt)
  {
    AppMethodBeat.i(123930);
    ((m)g.ab(m.class)).a(paramIntent, paramcyc, paramInt);
    AppMethodBeat.o(123930);
  }
  
  public static void a(Intent paramIntent, cyp paramcyp, int paramInt)
  {
    AppMethodBeat.i(123932);
    paramIntent.putExtra("Contact_User", paramcyp.nDo);
    paramIntent.putExtra("Contact_Nick", paramcyp.nEt);
    paramIntent.putExtra("Contact_PyInitial", paramcyp.Gaz);
    paramIntent.putExtra("Contact_QuanPin", paramcyp.GaA);
    paramIntent.putExtra("Contact_Sex", paramcyp.jdc);
    paramIntent.putExtra("Contact_Scene", paramInt);
    paramIntent.putExtra("Contact_KHideExpose", true);
    paramIntent.putExtra(e.c.IUp, paramcyp.Guj);
    paramIntent.putExtra("key_add_contact_openim_appid", paramcyp.iht);
    paramIntent.putExtra("key_add_contact_match_type", paramcyp.Hpn);
    paramIntent.putExtra("key_add_contact_custom_detail_visible", paramcyp.HpC.GYY);
    paramIntent.putExtra("key_add_contact_custom_detail", paramcyp.HpC.ugo);
    ad.i("MicroMsg.BuildContactInfoIntent", "[tomys] anti, content: %s", new Object[] { paramcyp.Guj });
    AppMethodBeat.o(123932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.api.d
 * JD-Core Version:    0.7.0.1
 */
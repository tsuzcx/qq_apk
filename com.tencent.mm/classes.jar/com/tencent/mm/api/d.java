package com.tencent.mm.api;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.dxj;
import com.tencent.mm.protocal.protobuf.eve;
import com.tencent.mm.protocal.protobuf.evg;
import com.tencent.mm.protocal.protobuf.evx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.f.e;

public final class d
{
  public static void a(Intent paramIntent, eve parameve)
  {
    AppMethodBeat.i(123931);
    ((o)h.ax(o.class)).a(paramIntent, parameve, 15);
    AppMethodBeat.o(123931);
  }
  
  public static void a(Intent paramIntent, evg paramevg, int paramInt)
  {
    AppMethodBeat.i(123930);
    ((o)h.ax(o.class)).a(paramIntent, paramevg, paramInt);
    AppMethodBeat.o(123930);
  }
  
  public static void a(Intent paramIntent, evx paramevx, int paramInt)
  {
    AppMethodBeat.i(123932);
    if (Util.isNullOrNil(paramevx.abyz)) {
      Log.i("MicroMsg.BuildContactInfoIntent", "FinderUsername is empty");
    }
    for (;;)
    {
      paramIntent.putExtra("Contact_User", paramevx.UserName);
      paramIntent.putExtra("Contact_Nick", paramevx.vhX);
      paramIntent.putExtra("Contact_PyInitial", paramevx.ZoW);
      paramIntent.putExtra("Contact_QuanPin", paramevx.ZoX);
      paramIntent.putExtra("Contact_Sex", paramevx.pSf);
      paramIntent.putExtra("Contact_Scene", paramInt);
      paramIntent.putExtra("Contact_KHideExpose", true);
      paramIntent.putExtra(f.e.adwe, paramevx.aant);
      paramIntent.putExtra("key_add_contact_openim_appid", paramevx.oOI);
      paramIntent.putExtra("key_add_contact_openim_finder_username", paramevx.abyz);
      paramIntent.putExtra("key_add_contact_match_type", paramevx.abxU);
      paramIntent.putExtra("key_add_contact_custom_detail_visible", paramevx.abyy.abdu);
      paramIntent.putExtra("key_add_contact_custom_detail", paramevx.abyy.IIu);
      Log.i("MicroMsg.BuildContactInfoIntent", "[tomys] anti, content: %s", new Object[] { paramevx.aant });
      AppMethodBeat.o(123932);
      return;
      Log.i("MicroMsg.BuildContactInfoIntent", "FinderUsername is " + paramevx.abyz);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.api.d
 * JD-Core Version:    0.7.0.1
 */
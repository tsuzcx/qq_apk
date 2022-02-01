package com.tencent.mm.api;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cvx;
import com.tencent.mm.protocal.protobuf.drr;
import com.tencent.mm.protocal.protobuf.drt;
import com.tencent.mm.protocal.protobuf.dsk;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.e.d;

public final class d
{
  public static void a(Intent paramIntent, drr paramdrr)
  {
    AppMethodBeat.i(123931);
    ((n)g.af(n.class)).a(paramIntent, paramdrr, 15);
    AppMethodBeat.o(123931);
  }
  
  public static void a(Intent paramIntent, drt paramdrt, int paramInt)
  {
    AppMethodBeat.i(123930);
    ((n)g.af(n.class)).a(paramIntent, paramdrt, paramInt);
    AppMethodBeat.o(123930);
  }
  
  public static void a(Intent paramIntent, dsk paramdsk, int paramInt)
  {
    AppMethodBeat.i(123932);
    paramIntent.putExtra("Contact_User", paramdsk.UserName);
    paramIntent.putExtra("Contact_Nick", paramdsk.oUJ);
    paramIntent.putExtra("Contact_PyInitial", paramdsk.LoE);
    paramIntent.putExtra("Contact_QuanPin", paramdsk.LoF);
    paramIntent.putExtra("Contact_Sex", paramdsk.kdY);
    paramIntent.putExtra("Contact_Scene", paramInt);
    paramIntent.putExtra("Contact_KHideExpose", true);
    paramIntent.putExtra(e.d.OyT, paramdsk.LRO);
    paramIntent.putExtra("key_add_contact_openim_appid", paramdsk.jfi);
    paramIntent.putExtra("key_add_contact_match_type", paramdsk.MUk);
    paramIntent.putExtra("key_add_contact_custom_detail_visible", paramdsk.MUN.MBw);
    paramIntent.putExtra("key_add_contact_custom_detail", paramdsk.MUN.xKd);
    Log.i("MicroMsg.BuildContactInfoIntent", "[tomys] anti, content: %s", new Object[] { paramdsk.LRO });
    AppMethodBeat.o(123932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.api.d
 * JD-Core Version:    0.7.0.1
 */
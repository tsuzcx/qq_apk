package com.tencent.mm.api;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bvn;
import com.tencent.mm.protocal.protobuf.cnj;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cny;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.e.c;

public final class d
{
  public static void a(Intent paramIntent, cnj paramcnj)
  {
    AppMethodBeat.i(123931);
    ((m)g.ab(m.class)).a(paramIntent, paramcnj, 15);
    AppMethodBeat.o(123931);
  }
  
  public static void a(Intent paramIntent, cnl paramcnl, int paramInt)
  {
    AppMethodBeat.i(123930);
    ((m)g.ab(m.class)).a(paramIntent, paramcnl, paramInt);
    AppMethodBeat.o(123930);
  }
  
  public static void a(Intent paramIntent, cny paramcny, int paramInt)
  {
    AppMethodBeat.i(123932);
    paramIntent.putExtra("Contact_User", paramcny.mAQ);
    paramIntent.putExtra("Contact_Nick", paramcny.mBV);
    paramIntent.putExtra("Contact_PyInitial", paramcny.Dal);
    paramIntent.putExtra("Contact_QuanPin", paramcny.Dam);
    paramIntent.putExtra("Contact_Sex", paramcny.ijM);
    paramIntent.putExtra("Contact_Scene", paramInt);
    paramIntent.putExtra("Contact_KHideExpose", true);
    paramIntent.putExtra(e.c.FHR, paramcny.Dqd);
    paramIntent.putExtra("key_add_contact_openim_appid", paramcny.hnC);
    paramIntent.putExtra("key_add_contact_match_type", paramcny.EhQ);
    paramIntent.putExtra("key_add_contact_custom_detail_visible", paramcny.Eif.DSR);
    paramIntent.putExtra("key_add_contact_custom_detail", paramcny.Eif.saB);
    ad.i("MicroMsg.BuildContactInfoIntent", "[tomys] anti, content: %s", new Object[] { paramcny.Dqd });
    AppMethodBeat.o(123932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.api.d
 * JD-Core Version:    0.7.0.1
 */
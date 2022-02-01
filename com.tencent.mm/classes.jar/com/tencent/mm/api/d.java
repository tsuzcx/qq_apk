package com.tencent.mm.api;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.cfq;
import com.tencent.mm.protocal.protobuf.cyu;
import com.tencent.mm.protocal.protobuf.cyw;
import com.tencent.mm.protocal.protobuf.czj;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.e.c;

public final class d
{
  public static void a(Intent paramIntent, cyu paramcyu)
  {
    AppMethodBeat.i(123931);
    ((m)g.ab(m.class)).a(paramIntent, paramcyu, 15);
    AppMethodBeat.o(123931);
  }
  
  public static void a(Intent paramIntent, cyw paramcyw, int paramInt)
  {
    AppMethodBeat.i(123930);
    ((m)g.ab(m.class)).a(paramIntent, paramcyw, paramInt);
    AppMethodBeat.o(123930);
  }
  
  public static void a(Intent paramIntent, czj paramczj, int paramInt)
  {
    AppMethodBeat.i(123932);
    paramIntent.putExtra("Contact_User", paramczj.nIJ);
    paramIntent.putExtra("Contact_Nick", paramczj.nJO);
    paramIntent.putExtra("Contact_PyInitial", paramczj.Gtg);
    paramIntent.putExtra("Contact_QuanPin", paramczj.Gth);
    paramIntent.putExtra("Contact_Sex", paramczj.jfV);
    paramIntent.putExtra("Contact_Scene", paramInt);
    paramIntent.putExtra("Contact_KHideExpose", true);
    paramIntent.putExtra(e.c.JoX, paramczj.GNI);
    paramIntent.putExtra("key_add_contact_openim_appid", paramczj.ikm);
    paramIntent.putExtra("key_add_contact_match_type", paramczj.HIP);
    paramIntent.putExtra("key_add_contact_custom_detail_visible", paramczj.HJe.Hsz);
    paramIntent.putExtra("key_add_contact_custom_detail", paramczj.HJe.urL);
    ae.i("MicroMsg.BuildContactInfoIntent", "[tomys] anti, content: %s", new Object[] { paramczj.GNI });
    AppMethodBeat.o(123932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.api.d
 * JD-Core Version:    0.7.0.1
 */
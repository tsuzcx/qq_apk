package com.tencent.mm.api;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.caf;
import com.tencent.mm.protocal.protobuf.csq;
import com.tencent.mm.protocal.protobuf.css;
import com.tencent.mm.protocal.protobuf.ctf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.ui.e.c;

public final class d
{
  public static void a(Intent paramIntent, csq paramcsq)
  {
    AppMethodBeat.i(123931);
    ((m)g.ab(m.class)).a(paramIntent, paramcsq, 15);
    AppMethodBeat.o(123931);
  }
  
  public static void a(Intent paramIntent, css paramcss, int paramInt)
  {
    AppMethodBeat.i(123930);
    ((m)g.ab(m.class)).a(paramIntent, paramcss, paramInt);
    AppMethodBeat.o(123930);
  }
  
  public static void a(Intent paramIntent, ctf paramctf, int paramInt)
  {
    AppMethodBeat.i(123932);
    paramIntent.putExtra("Contact_User", paramctf.ncR);
    paramIntent.putExtra("Contact_Nick", paramctf.ndW);
    paramIntent.putExtra("Contact_PyInitial", paramctf.Eti);
    paramIntent.putExtra("Contact_QuanPin", paramctf.Etj);
    paramIntent.putExtra("Contact_Sex", paramctf.iJT);
    paramIntent.putExtra("Contact_Scene", paramInt);
    paramIntent.putExtra("Contact_KHideExpose", true);
    paramIntent.putExtra(e.c.HgZ, paramctf.ELg);
    paramIntent.putExtra("key_add_contact_openim_appid", paramctf.hOf);
    paramIntent.putExtra("key_add_contact_match_type", paramctf.FEO);
    paramIntent.putExtra("key_add_contact_custom_detail_visible", paramctf.FFd.Fpn);
    paramIntent.putExtra("key_add_contact_custom_detail", paramctf.FFd.tiv);
    ac.i("MicroMsg.BuildContactInfoIntent", "[tomys] anti, content: %s", new Object[] { paramctf.ELg });
    AppMethodBeat.o(123932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.api.d
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.api;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.protocal.protobuf.bie;
import com.tencent.mm.protocal.protobuf.bxf;
import com.tencent.mm.protocal.protobuf.bxh;
import com.tencent.mm.protocal.protobuf.bxw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.e.b;

public final class b
{
  public static void a(Intent paramIntent, bxf parambxf)
  {
    AppMethodBeat.i(11204);
    ((j)g.E(j.class)).a(paramIntent, parambxf, 15);
    AppMethodBeat.o(11204);
  }
  
  public static void a(Intent paramIntent, bxh parambxh, int paramInt)
  {
    AppMethodBeat.i(11203);
    ((j)g.E(j.class)).a(paramIntent, parambxh, paramInt);
    AppMethodBeat.o(11203);
  }
  
  public static void a(Intent paramIntent, bxw parambxw, int paramInt)
  {
    AppMethodBeat.i(11205);
    paramIntent.putExtra("Contact_User", parambxw.jJA);
    paramIntent.putExtra("Contact_Nick", parambxw.jKG);
    paramIntent.putExtra("Contact_PyInitial", parambxw.wNI);
    paramIntent.putExtra("Contact_QuanPin", parambxw.wNJ);
    paramIntent.putExtra("Contact_Sex", parambxw.gwP);
    paramIntent.putExtra("Contact_Scene", paramInt);
    paramIntent.putExtra("Contact_KHideExpose", true);
    paramIntent.putExtra(e.b.yUZ, parambxw.wYu);
    paramIntent.putExtra("key_add_contact_openim_appid", parambxw.fKw);
    paramIntent.putExtra("key_add_contact_match_type", parambxw.xKf);
    paramIntent.putExtra("key_add_contact_custom_detail_visible", parambxw.xKv.xxt);
    paramIntent.putExtra("key_add_contact_custom_detail", parambxw.xKv.nqY);
    ab.i("MicroMsg.BuildContactInfoIntent", "[tomys] anti, content: %s", new Object[] { parambxw.wYu });
    AppMethodBeat.o(11205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.api.b
 * JD-Core Version:    0.7.0.1
 */
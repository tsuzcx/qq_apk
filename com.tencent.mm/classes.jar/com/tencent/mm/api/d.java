package com.tencent.mm.api;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.dfh;
import com.tencent.mm.protocal.protobuf.ebn;
import com.tencent.mm.protocal.protobuf.ebp;
import com.tencent.mm.protocal.protobuf.ecg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.f.d;

public final class d
{
  public static void a(Intent paramIntent, ebn paramebn)
  {
    AppMethodBeat.i(123931);
    ((n)h.ae(n.class)).a(paramIntent, paramebn, 15);
    AppMethodBeat.o(123931);
  }
  
  public static void a(Intent paramIntent, ebp paramebp, int paramInt)
  {
    AppMethodBeat.i(123930);
    ((n)h.ae(n.class)).a(paramIntent, paramebp, paramInt);
    AppMethodBeat.o(123930);
  }
  
  public static void a(Intent paramIntent, ecg paramecg, int paramInt)
  {
    AppMethodBeat.i(123932);
    paramIntent.putExtra("Contact_User", paramecg.UserName);
    paramIntent.putExtra("Contact_Nick", paramecg.rWI);
    paramIntent.putExtra("Contact_PyInitial", paramecg.Sqa);
    paramIntent.putExtra("Contact_QuanPin", paramecg.Sqb);
    paramIntent.putExtra("Contact_Sex", paramecg.mVy);
    paramIntent.putExtra("Contact_Scene", paramInt);
    paramIntent.putExtra("Contact_KHideExpose", true);
    paramIntent.putExtra(f.d.VRW, paramecg.Tav);
    paramIntent.putExtra("key_add_contact_openim_appid", paramecg.lVG);
    paramIntent.putExtra("key_add_contact_match_type", paramecg.Ugt);
    paramIntent.putExtra("key_add_contact_custom_detail_visible", paramecg.UgX.TNd);
    paramIntent.putExtra("key_add_contact_custom_detail", paramecg.UgX.COk);
    Log.i("MicroMsg.BuildContactInfoIntent", "[tomys] anti, content: %s", new Object[] { paramecg.Tav });
    AppMethodBeat.o(123932);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.api.d
 * JD-Core Version:    0.7.0.1
 */
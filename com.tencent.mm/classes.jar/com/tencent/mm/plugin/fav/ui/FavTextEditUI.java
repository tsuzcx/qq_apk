package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.dpo;
import com.tencent.mm.protocal.protobuf.dpr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.MMTextInputUI;
import java.util.LinkedList;

public class FavTextEditUI
  extends MMTextInputUI
{
  public final void ac(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(106934);
    if ((paramCharSequence == null) || (Util.isNullOrNil(paramCharSequence.toString())))
    {
      Log.w("MicroMsg.FavTextEditUI", "text is null");
      AppMethodBeat.o(106934);
      return;
    }
    int i = getIntent().getIntExtra("key_fav_item_id", -1);
    paramCharSequence = paramCharSequence.toString();
    if (i <= 0)
    {
      Log.w("MicroMsg.FavTextEditUI", "modEditText favid:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(106934);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = new dpo();
    ((dpo)localObject1).aaWn = 4;
    ((dpo)localObject1).aaWo = 0;
    localLinkedList.add(localObject1);
    localObject1 = new LinkedList();
    Object localObject2 = new dpr();
    ((dpr)localObject2).IKH = "favitem.desc";
    ((dpr)localObject2).OzQ = Util.nullAs(paramCharSequence, "");
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = new dpr();
    ((dpr)localObject2).IKH = "favitem.edittime";
    ((dpr)localObject2).OzQ = String.valueOf(Util.nowSecond());
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mL(i);
    if (localObject2 != null)
    {
      ((g)localObject2).field_edittime = Util.nowSecond();
      ((g)localObject2).field_favProto.yt(((g)localObject2).field_edittime);
      ((g)localObject2).field_favProto.btn(Util.nullAs(paramCharSequence, ""));
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().a((g)localObject2, new String[] { "localId" });
    }
    paramCharSequence = new ao(i, localLinkedList, (LinkedList)localObject1);
    com.tencent.mm.kernel.h.aZW().a(paramCharSequence, 0);
    com.tencent.mm.plugin.report.service.h.OAn.b(10874, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(106934);
  }
  
  public int getLayoutId()
  {
    return q.f.fav_edit_input_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(106933);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    setMMTitle(q.i.favorite_edit_title);
    AppMethodBeat.o(106933);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavTextEditUI
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.bdy;
import com.tencent.mm.protocal.protobuf.beb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.MMTextInputUI;
import java.util.LinkedList;

public class FavTextEditUI
  extends MMTextInputUI
{
  public final void G(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(74162);
    if ((paramCharSequence == null) || (bo.isNullOrNil(paramCharSequence.toString())))
    {
      ab.w("MicroMsg.FavTextEditUI", "text is null");
      AppMethodBeat.o(74162);
      return;
    }
    int i = getIntent().getIntExtra("key_fav_item_id", -1);
    paramCharSequence = paramCharSequence.toString();
    if (i <= 0)
    {
      ab.w("MicroMsg.FavTextEditUI", "modEditText favid:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(74162);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = new bdy();
    ((bdy)localObject1).xtK = 4;
    ((bdy)localObject1).xtL = 0;
    localLinkedList.add(localObject1);
    localObject1 = new LinkedList();
    Object localObject2 = new beb();
    ((beb)localObject2).ntn = "favitem.desc";
    ((beb)localObject2).qsu = bo.bf(paramCharSequence, "");
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = new beb();
    ((beb)localObject2).ntn = "favitem.edittime";
    ((beb)localObject2).qsu = String.valueOf(bo.aox());
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kc(i);
    if (localObject2 != null)
    {
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_edittime = bo.aox();
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.nH(((com.tencent.mm.plugin.fav.a.g)localObject2).field_edittime);
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.aom(bo.bf(paramCharSequence, ""));
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
    }
    paramCharSequence = new al(i, localLinkedList, (LinkedList)localObject1);
    com.tencent.mm.kernel.g.Rc().a(paramCharSequence, 0);
    h.qsU.e(10874, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(74162);
  }
  
  public int getLayoutId()
  {
    return 2130969532;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74161);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    setMMTitle(2131299705);
    AppMethodBeat.o(74161);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavTextEditUI
 * JD-Core Version:    0.7.0.1
 */
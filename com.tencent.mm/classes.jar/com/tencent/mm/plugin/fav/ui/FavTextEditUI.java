package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.bqq;
import com.tencent.mm.protocal.protobuf.bqt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.tools.MMTextInputUI;
import java.util.LinkedList;

public class FavTextEditUI
  extends MMTextInputUI
{
  public final void L(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(106934);
    if ((paramCharSequence == null) || (bt.isNullOrNil(paramCharSequence.toString())))
    {
      ad.w("MicroMsg.FavTextEditUI", "text is null");
      AppMethodBeat.o(106934);
      return;
    }
    int i = getIntent().getIntExtra("key_fav_item_id", -1);
    paramCharSequence = paramCharSequence.toString();
    if (i <= 0)
    {
      ad.w("MicroMsg.FavTextEditUI", "modEditText favid:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(106934);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = new bqq();
    ((bqq)localObject1).DON = 4;
    ((bqq)localObject1).DOO = 0;
    localLinkedList.add(localObject1);
    localObject1 = new LinkedList();
    Object localObject2 = new bqt();
    ((bqt)localObject2).scP = "favitem.desc";
    ((bqt)localObject2).vJI = bt.by(paramCharSequence, "");
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = new bqt();
    ((bqt)localObject2).scP = "favitem.edittime";
    ((bqt)localObject2).vJI = String.valueOf(bt.aGK());
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pT(i);
    if (localObject2 != null)
    {
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_edittime = bt.aGK();
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.vu(((com.tencent.mm.plugin.fav.a.g)localObject2).field_edittime);
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.aEk(bt.by(paramCharSequence, ""));
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
    }
    paramCharSequence = new am(i, localLinkedList, (LinkedList)localObject1);
    com.tencent.mm.kernel.g.aeS().a(paramCharSequence, 0);
    h.vKh.f(10874, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(106934);
  }
  
  public int getLayoutId()
  {
    return 2131493947;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(106933);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    setMMTitle(2131758877);
    AppMethodBeat.o(106933);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavTextEditUI
 * JD-Core Version:    0.7.0.1
 */
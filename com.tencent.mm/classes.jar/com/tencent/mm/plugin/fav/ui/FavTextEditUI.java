package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.caq;
import com.tencent.mm.protocal.protobuf.cat;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.tools.MMTextInputUI;
import java.util.LinkedList;

public class FavTextEditUI
  extends MMTextInputUI
{
  public final void K(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(106934);
    if ((paramCharSequence == null) || (bu.isNullOrNil(paramCharSequence.toString())))
    {
      ae.w("MicroMsg.FavTextEditUI", "text is null");
      AppMethodBeat.o(106934);
      return;
    }
    int i = getIntent().getIntExtra("key_fav_item_id", -1);
    paramCharSequence = paramCharSequence.toString();
    if (i <= 0)
    {
      ae.w("MicroMsg.FavTextEditUI", "modEditText favid:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(106934);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = new caq();
    ((caq)localObject1).Hon = 4;
    ((caq)localObject1).Hoo = 0;
    localLinkedList.add(localObject1);
    localObject1 = new LinkedList();
    Object localObject2 = new cat();
    ((cat)localObject2).uum = "favitem.desc";
    ((cat)localObject2).yxn = bu.bI(paramCharSequence, "");
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = new cat();
    ((cat)localObject2).uum = "favitem.edittime";
    ((cat)localObject2).yxn = String.valueOf(bu.aRi());
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vV(i);
    if (localObject2 != null)
    {
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_edittime = bu.aRi();
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.Dj(((com.tencent.mm.plugin.fav.a.g)localObject2).field_edittime);
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.aQB(bu.bI(paramCharSequence, ""));
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
    }
    paramCharSequence = new am(i, localLinkedList, (LinkedList)localObject1);
    com.tencent.mm.kernel.g.ajj().a(paramCharSequence, 0);
    com.tencent.mm.plugin.report.service.g.yxI.f(10874, new Object[] { Integer.valueOf(1) });
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
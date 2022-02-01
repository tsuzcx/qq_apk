package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.bvh;
import com.tencent.mm.protocal.protobuf.bvk;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.tools.MMTextInputUI;
import java.util.LinkedList;

public class FavTextEditUI
  extends MMTextInputUI
{
  public final void L(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(106934);
    if ((paramCharSequence == null) || (bs.isNullOrNil(paramCharSequence.toString())))
    {
      ac.w("MicroMsg.FavTextEditUI", "text is null");
      AppMethodBeat.o(106934);
      return;
    }
    int i = getIntent().getIntExtra("key_fav_item_id", -1);
    paramCharSequence = paramCharSequence.toString();
    if (i <= 0)
    {
      ac.w("MicroMsg.FavTextEditUI", "modEditText favid:%d", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(106934);
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = new bvh();
    ((bvh)localObject1).Fle = 4;
    ((bvh)localObject1).Flf = 0;
    localLinkedList.add(localObject1);
    localObject1 = new LinkedList();
    Object localObject2 = new bvk();
    ((bvk)localObject2).tkJ = "favitem.desc";
    ((bvk)localObject2).wTM = bs.bG(paramCharSequence, "");
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = new bvk();
    ((bvk)localObject2).tkJ = "favitem.edittime";
    ((bvk)localObject2).wTM = String.valueOf(bs.aNx());
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tI(i);
    if (localObject2 != null)
    {
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_edittime = bs.aNx();
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.zX(((com.tencent.mm.plugin.fav.a.g)localObject2).field_edittime);
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.aJB(bs.bG(paramCharSequence, ""));
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
    }
    paramCharSequence = new am(i, localLinkedList, (LinkedList)localObject1);
    com.tencent.mm.kernel.g.agi().a(paramCharSequence, 0);
    h.wUl.f(10874, new Object[] { Integer.valueOf(1) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavTextEditUI
 * JD-Core Version:    0.7.0.1
 */
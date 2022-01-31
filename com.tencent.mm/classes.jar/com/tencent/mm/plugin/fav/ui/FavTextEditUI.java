package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ah.p;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.al;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.axi;
import com.tencent.mm.protocal.c.axl;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.MMTextInputUI;
import java.util.LinkedList;

public class FavTextEditUI
  extends MMTextInputUI
{
  protected final int getLayoutId()
  {
    return n.f.fav_edit_input_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(n.i.favorite_edit_title);
  }
  
  protected final void x(CharSequence paramCharSequence)
  {
    if ((paramCharSequence == null) || (bk.bl(paramCharSequence.toString())))
    {
      y.w("MicroMsg.FavTextEditUI", "text is null");
      return;
    }
    int i = getIntent().getIntExtra("key_fav_item_id", -1);
    paramCharSequence = paramCharSequence.toString();
    if (i <= 0)
    {
      y.w("MicroMsg.FavTextEditUI", "modEditText favid:%d", new Object[] { Integer.valueOf(i) });
      return;
    }
    LinkedList localLinkedList = new LinkedList();
    Object localObject1 = new axi();
    ((axi)localObject1).ttL = 4;
    ((axi)localObject1).ttM = 0;
    localLinkedList.add(localObject1);
    localObject1 = new LinkedList();
    Object localObject2 = new axl();
    ((axl)localObject2).kVl = "favitem.desc";
    ((axl)localObject2).nFs = bk.aM(paramCharSequence, "");
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = new axl();
    ((axl)localObject2).kVl = "favitem.edittime";
    ((axl)localObject2).nFs = String.valueOf(bk.UX());
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eF(i);
    if (localObject2 != null)
    {
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_edittime = bk.UX();
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.hk(((com.tencent.mm.plugin.fav.a.g)localObject2).field_edittime);
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.Yp(bk.aM(paramCharSequence, ""));
      ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
    }
    paramCharSequence = new al(i, localLinkedList, (LinkedList)localObject1);
    com.tencent.mm.kernel.g.Dk().a(paramCharSequence, 0);
    h.nFQ.f(10874, new Object[] { Integer.valueOf(1) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavTextEditUI
 * JD-Core Version:    0.7.0.1
 */
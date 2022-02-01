package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.t;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.am;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.cps;
import com.tencent.mm.protocal.protobuf.cpv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.MMTextInputUI;
import java.util.LinkedList;

public class FavTextEditUI
  extends MMTextInputUI
{
  public final void O(CharSequence paramCharSequence)
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
    Object localObject1 = new cps();
    ((cps)localObject1).MvI = 4;
    ((cps)localObject1).MvJ = 0;
    localLinkedList.add(localObject1);
    localObject1 = new LinkedList();
    Object localObject2 = new cpv();
    ((cpv)localObject2).xMo = "favitem.desc";
    ((cpv)localObject2).Cyk = Util.nullAs(paramCharSequence, "");
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = new cpv();
    ((cpv)localObject2).xMo = "favitem.edittime";
    ((cpv)localObject2).Cyk = String.valueOf(Util.nowSecond());
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DZ(i);
    if (localObject2 != null)
    {
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_edittime = Util.nowSecond();
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.Mz(((com.tencent.mm.plugin.fav.a.g)localObject2).field_edittime);
      ((com.tencent.mm.plugin.fav.a.g)localObject2).field_favProto.bhe(Util.nullAs(paramCharSequence, ""));
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().a((com.tencent.mm.plugin.fav.a.g)localObject2, new String[] { "localId" });
    }
    paramCharSequence = new am(i, localLinkedList, (LinkedList)localObject1);
    com.tencent.mm.kernel.g.azz().a(paramCharSequence, 0);
    h.CyF.a(10874, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(106934);
  }
  
  public int getLayoutId()
  {
    return 2131494115;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(106933);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    setMMTitle(2131759201);
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
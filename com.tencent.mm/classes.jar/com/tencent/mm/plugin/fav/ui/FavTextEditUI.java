package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.an;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.cyi;
import com.tencent.mm.protocal.protobuf.cyl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.MMTextInputUI;
import java.util.LinkedList;

public class FavTextEditUI
  extends MMTextInputUI
{
  public final void X(CharSequence paramCharSequence)
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
    Object localObject1 = new cyi();
    ((cyi)localObject1).TGG = 4;
    ((cyi)localObject1).TGH = 0;
    localLinkedList.add(localObject1);
    localObject1 = new LinkedList();
    Object localObject2 = new cyl();
    ((cyl)localObject2).CQx = "favitem.desc";
    ((cyl)localObject2).Izj = Util.nullAs(paramCharSequence, "");
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = new cyl();
    ((cyl)localObject2).CQx = "favitem.edittime";
    ((cyl)localObject2).Izj = String.valueOf(Util.nowSecond());
    ((LinkedList)localObject1).add(localObject2);
    localObject2 = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Kn(i);
    if (localObject2 != null)
    {
      ((g)localObject2).field_edittime = Util.nowSecond();
      ((g)localObject2).field_favProto.Ud(((g)localObject2).field_edittime);
      ((g)localObject2).field_favProto.btw(Util.nullAs(paramCharSequence, ""));
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().a((g)localObject2, new String[] { "localId" });
    }
    paramCharSequence = new an(i, localLinkedList, (LinkedList)localObject1);
    com.tencent.mm.kernel.h.aGY().a(paramCharSequence, 0);
    com.tencent.mm.plugin.report.service.h.IzE.a(10874, new Object[] { Integer.valueOf(1) });
    AppMethodBeat.o(106934);
  }
  
  public int getLayoutId()
  {
    return s.f.fav_edit_input_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(106933);
    customfixStatusbar(true);
    super.onCreate(paramBundle);
    setMMTitle(s.i.favorite_edit_title);
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
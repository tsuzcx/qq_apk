package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.az.f;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bf;
import com.tencent.mm.plugin.bottle.a;
import com.tencent.mm.plugin.bottle.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.storage.be;

final class BottleConversationUI$2
  implements DialogInterface.OnClickListener
{
  BottleConversationUI$2(BottleConversationUI paramBottleConversationUI, String paramString) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(18557);
    aw.aaz();
    paramDialogInterface = com.tencent.mm.model.c.YC().Tl(this.euc);
    aw.aaz();
    com.tencent.mm.model.c.Yz().c(new com.tencent.mm.az.d(this.euc, paramDialogInterface.field_msgSvrId));
    aw.aaz();
    com.tencent.mm.model.c.Yz().c(new f(this.euc));
    a.gmP.BO();
    BottleConversationUI.a(this.jSo, false);
    paramDialogInterface = this.jSo;
    Object localObject = this.jSo;
    this.jSo.getString(2131297087);
    BottleConversationUI.a(paramDialogInterface, com.tencent.mm.ui.base.h.b((Context)localObject, this.jSo.getString(2131297112), true, new BottleConversationUI.2.1(this)));
    bf.a(this.euc, new BottleConversationUI.2.2(this));
    aw.aaz();
    com.tencent.mm.model.c.YF().arF(this.euc);
    paramDialogInterface = com.tencent.mm.plugin.bottle.a.d.aWj();
    localObject = com.tencent.mm.plugin.bottle.a.c.GF(this.euc);
    paramDialogInterface.fnw.delete("bottleinfo1", "bottleid= ?", new String[] { String.valueOf(localObject) });
    a.gmP.BO();
    AppMethodBeat.o(18557);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BottleConversationUI.2
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.editor.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.plugin.editor.model.c.1;
import com.tencent.mm.plugin.editor.model.c.2;
import com.tencent.mm.plugin.editor.model.nativenote.spans.u;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.protocal.protobuf.afy;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.imageview.WeImageButton;

public final class a
  implements com.tencent.mm.plugin.editor.model.b.a, com.tencent.mm.plugin.editor.model.nativenote.b.b
{
  public View mXu;
  String omm;
  public WeImageButton oqI;
  public WeImageButton oqJ;
  public WeImageButton oqK;
  public WeImageButton oqL;
  public LinearLayout oqM;
  public LinearLayout oqN;
  public LinearLayout oqO;
  public LinearLayout oqP;
  public LinearLayout oqQ;
  public LinearLayout oqR;
  public boolean oqS;
  a oqT;
  boolean oqU;
  boolean oqV;
  boolean oqW;
  boolean oqX;
  public boolean oqY;
  
  public a()
  {
    AppMethodBeat.i(181982);
    this.oqS = false;
    this.omm = "";
    this.oqU = false;
    this.oqV = false;
    this.oqW = false;
    this.oqX = false;
    this.oqT = this;
    AppMethodBeat.o(181982);
  }
  
  public final void a(com.tencent.mm.plugin.editor.model.nativenote.b.a parama)
  {
    AppMethodBeat.i(181985);
    this.oqL.setImageResource(2131231993);
    if (!this.oqS)
    {
      AppMethodBeat.o(181985);
      return;
    }
    this.oqS = false;
    com.tencent.mm.plugin.editor.model.c.bSb().bSc();
    String str = com.tencent.mm.plugin.editor.model.c.bSb().bSd();
    int i = (int)com.tencent.mm.plugin.editor.model.c.bSb().duration;
    int j = (int)com.tencent.mm.plugin.editor.b.mI(i);
    int k = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().bSv();
    com.tencent.mm.plugin.editor.model.a.a locala = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().Aa(k);
    if (!com.tencent.mm.vfs.i.eK(str))
    {
      ad.e("MicroMsg.EditorFooterPanel", "voicePath not exist, remove data from data list and ui.");
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().W(k, false);
      if (parama != null) {
        parama.zX(k);
      }
      parama = new com.tencent.mm.plugin.editor.model.a.j();
      parama.content = "";
      parama.omv = true;
      parama.omB = false;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().a(k, parama);
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().eZ(k - 1, k + 1);
      AppMethodBeat.o(181985);
      return;
    }
    if ((k != -1) && (locala != null) && (locala.getType() == 4))
    {
      ((com.tencent.mm.plugin.editor.model.a.m)locala).omS = Boolean.FALSE;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).type = 4;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).omJ = true;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).omN = "";
      ((com.tencent.mm.plugin.editor.model.a.m)locala).length = j;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).omM = com.tencent.mm.plugin.editor.b.C(aj.getContext(), j).toString();
      ((com.tencent.mm.plugin.editor.model.a.m)locala).jUR = (ao.cip() + "/fav_fileicon_recording.png");
      ((com.tencent.mm.plugin.editor.model.a.m)locala).drZ = str;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).dkk = i;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bSq().Ac(k);
    }
    AppMethodBeat.o(181985);
  }
  
  public final void bSj()
  {
    AppMethodBeat.i(181984);
    a(null);
    AppMethodBeat.o(181984);
  }
  
  public final void bSk()
  {
    AppMethodBeat.i(181983);
    h.a(this.oqL.getContext(), this.oqL.getContext().getString(2131762249), "", true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(181972);
        a.this.a(null);
        AppMethodBeat.o(181972);
      }
    }, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
    });
    AppMethodBeat.o(181983);
  }
  
  public final void jr(boolean paramBoolean)
  {
    AppMethodBeat.i(181986);
    this.oqX = paramBoolean;
    this.oqR.setPressed(paramBoolean);
    AppMethodBeat.o(181986);
  }
  
  public final void js(boolean paramBoolean)
  {
    AppMethodBeat.i(181987);
    this.oqU = paramBoolean;
    this.oqN.setPressed(paramBoolean);
    AppMethodBeat.o(181987);
  }
  
  public final void jt(boolean paramBoolean)
  {
    AppMethodBeat.i(181988);
    this.oqV = paramBoolean;
    this.oqO.setPressed(paramBoolean);
    AppMethodBeat.o(181988);
  }
  
  public final void ju(boolean paramBoolean)
  {
    AppMethodBeat.i(181989);
    this.oqW = paramBoolean;
    this.oqQ.setPressed(paramBoolean);
    AppMethodBeat.o(181989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.widget.a
 * JD-Core Version:    0.7.0.1
 */
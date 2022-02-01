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
import com.tencent.mm.br.d;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.plugin.editor.model.c.1;
import com.tencent.mm.plugin.editor.model.c.2;
import com.tencent.mm.plugin.editor.model.nativenote.spans.u;
import com.tencent.mm.protocal.protobuf.agx;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.au;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.imageview.WeImageButton;

public final class a
  implements com.tencent.mm.plugin.editor.model.b.a, com.tencent.mm.plugin.editor.model.nativenote.b.b
{
  public View nzT;
  String oPM;
  public WeImageButton oUi;
  public WeImageButton oUj;
  public WeImageButton oUk;
  public WeImageButton oUl;
  public LinearLayout oUm;
  public LinearLayout oUn;
  public LinearLayout oUo;
  public LinearLayout oUp;
  public LinearLayout oUq;
  public LinearLayout oUr;
  public boolean oUs;
  a oUt;
  boolean oUu;
  boolean oUv;
  boolean oUw;
  boolean oUx;
  public boolean oUy;
  
  public a()
  {
    AppMethodBeat.i(181982);
    this.oUs = false;
    this.oPM = "";
    this.oUu = false;
    this.oUv = false;
    this.oUw = false;
    this.oUx = false;
    this.oUt = this;
    AppMethodBeat.o(181982);
  }
  
  public final void a(com.tencent.mm.plugin.editor.model.nativenote.b.a parama)
  {
    AppMethodBeat.i(181985);
    this.oUl.setImageResource(2131231993);
    if (!this.oUs)
    {
      AppMethodBeat.o(181985);
      return;
    }
    this.oUs = false;
    com.tencent.mm.plugin.editor.model.c.bZq().bZr();
    String str = com.tencent.mm.plugin.editor.model.c.bZq().bZs();
    int i = (int)com.tencent.mm.plugin.editor.model.c.bZq().duration;
    int j = (int)com.tencent.mm.plugin.editor.b.qw(i);
    int k = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().bZK();
    com.tencent.mm.plugin.editor.model.a.a locala = com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().AS(k);
    if (!com.tencent.mm.vfs.i.eA(str))
    {
      ac.e("MicroMsg.EditorFooterPanel", "voicePath not exist, remove data from data list and ui.");
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().W(k, false);
      if (parama != null) {
        parama.AP(k);
      }
      parama = new com.tencent.mm.plugin.editor.model.a.j();
      parama.content = "";
      parama.oPV = true;
      parama.oQb = false;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().a(k, parama);
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().fc(k - 1, k + 1);
      AppMethodBeat.o(181985);
      return;
    }
    if ((k != -1) && (locala != null) && (locala.getType() == 4))
    {
      ((com.tencent.mm.plugin.editor.model.a.m)locala).oQs = Boolean.FALSE;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).type = 4;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).oQj = true;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).oQn = "";
      ((com.tencent.mm.plugin.editor.model.a.m)locala).length = j;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).oQm = com.tencent.mm.plugin.editor.b.F(ai.getContext(), j).toString();
      ((com.tencent.mm.plugin.editor.model.a.m)locala).kvC = (com.tencent.mm.plugin.fav.a.ao.cpW() + "/fav_fileicon_recording.png");
      ((com.tencent.mm.plugin.editor.model.a.m)locala).dpK = str;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).dhF = i;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.bZF().AU(k);
    }
    AppMethodBeat.o(181985);
  }
  
  public final void bZy()
  {
    AppMethodBeat.i(181984);
    a(null);
    AppMethodBeat.o(181984);
  }
  
  public final void bZz()
  {
    AppMethodBeat.i(181983);
    h.a(this.oUl.getContext(), this.oUl.getContext().getString(2131762249), "", true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
  
  public final void jU(boolean paramBoolean)
  {
    AppMethodBeat.i(181986);
    this.oUx = paramBoolean;
    this.oUr.setPressed(paramBoolean);
    AppMethodBeat.o(181986);
  }
  
  public final void jV(boolean paramBoolean)
  {
    AppMethodBeat.i(181987);
    this.oUu = paramBoolean;
    this.oUn.setPressed(paramBoolean);
    AppMethodBeat.o(181987);
  }
  
  public final void jW(boolean paramBoolean)
  {
    AppMethodBeat.i(181988);
    this.oUv = paramBoolean;
    this.oUo.setPressed(paramBoolean);
    AppMethodBeat.o(181988);
  }
  
  public final void jX(boolean paramBoolean)
  {
    AppMethodBeat.i(181989);
    this.oUw = paramBoolean;
    this.oUq.setPressed(paramBoolean);
    AppMethodBeat.o(181989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.widget.a
 * JD-Core Version:    0.7.0.1
 */
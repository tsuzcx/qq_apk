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
import com.tencent.mm.protocal.protobuf.ajn;
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
  public View oaY;
  String ptw;
  public WeImageButton pxS;
  public WeImageButton pxT;
  public WeImageButton pxU;
  public WeImageButton pxV;
  public LinearLayout pxW;
  public LinearLayout pxX;
  public LinearLayout pxY;
  public LinearLayout pxZ;
  public LinearLayout pya;
  public LinearLayout pyb;
  public boolean pyc;
  a pyd;
  boolean pye;
  boolean pyf;
  boolean pyg;
  boolean pyh;
  public boolean pyi;
  
  public a()
  {
    AppMethodBeat.i(181982);
    this.pyc = false;
    this.ptw = "";
    this.pye = false;
    this.pyf = false;
    this.pyg = false;
    this.pyh = false;
    this.pyd = this;
    AppMethodBeat.o(181982);
  }
  
  public final void a(com.tencent.mm.plugin.editor.model.nativenote.b.a parama)
  {
    AppMethodBeat.i(181985);
    this.pxV.setImageResource(2131231993);
    if (!this.pyc)
    {
      AppMethodBeat.o(181985);
      return;
    }
    this.pyc = false;
    com.tencent.mm.plugin.editor.model.c.cdU().cdV();
    String str = com.tencent.mm.plugin.editor.model.c.cdU().cdW();
    int i = (int)com.tencent.mm.plugin.editor.model.c.cdU().duration;
    int j = (int)com.tencent.mm.plugin.editor.b.sv(i);
    int k = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cej().ceo();
    com.tencent.mm.plugin.editor.model.a.a locala = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cej().BA(k);
    if (!com.tencent.mm.vfs.i.fv(str))
    {
      ad.e("MicroMsg.EditorFooterPanel", "voicePath not exist, remove data from data list and ui.");
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cej().W(k, false);
      if (parama != null) {
        parama.Bx(k);
      }
      parama = new com.tencent.mm.plugin.editor.model.a.j();
      parama.content = "";
      parama.ptF = true;
      parama.ptL = false;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cej().a(k, parama);
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cej().fg(k - 1, k + 1);
      AppMethodBeat.o(181985);
      return;
    }
    if ((k != -1) && (locala != null) && (locala.getType() == 4))
    {
      ((com.tencent.mm.plugin.editor.model.a.m)locala).puc = Boolean.FALSE;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).type = 4;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).ptT = true;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).ptX = "";
      ((com.tencent.mm.plugin.editor.model.a.m)locala).length = j;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).ptW = com.tencent.mm.plugin.editor.b.G(aj.getContext(), j).toString();
      ((com.tencent.mm.plugin.editor.model.a.m)locala).kRE = (ao.cvB() + "/fav_fileicon_recording.png");
      ((com.tencent.mm.plugin.editor.model.a.m)locala).dBx = str;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).dtd = i;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cej().BC(k);
    }
    AppMethodBeat.o(181985);
  }
  
  public final void cec()
  {
    AppMethodBeat.i(181984);
    a(null);
    AppMethodBeat.o(181984);
  }
  
  public final void ced()
  {
    AppMethodBeat.i(181983);
    h.a(this.pxV.getContext(), this.pxV.getContext().getString(2131762249), "", true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
  
  public final void kf(boolean paramBoolean)
  {
    AppMethodBeat.i(181986);
    this.pyh = paramBoolean;
    this.pyb.setPressed(paramBoolean);
    AppMethodBeat.o(181986);
  }
  
  public final void kg(boolean paramBoolean)
  {
    AppMethodBeat.i(181987);
    this.pye = paramBoolean;
    this.pxX.setPressed(paramBoolean);
    AppMethodBeat.o(181987);
  }
  
  public final void kh(boolean paramBoolean)
  {
    AppMethodBeat.i(181988);
    this.pyf = paramBoolean;
    this.pxY.setPressed(paramBoolean);
    AppMethodBeat.o(181988);
  }
  
  public final void ki(boolean paramBoolean)
  {
    AppMethodBeat.i(181989);
    this.pyg = paramBoolean;
    this.pya.setPressed(paramBoolean);
    AppMethodBeat.o(181989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.widget.a
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.editor.model.a.i;
import com.tencent.mm.plugin.editor.model.c.1;
import com.tencent.mm.plugin.editor.model.c.2;
import com.tencent.mm.plugin.editor.model.nativenote.spans.u;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.aw;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.imageview.WeImageButton;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;

public final class a
  implements com.tencent.mm.plugin.editor.model.b.a, com.tencent.mm.plugin.editor.model.nativenote.b.b
{
  public View ogP;
  String pAa;
  public LinearLayout pEA;
  public LinearLayout pEB;
  public LinearLayout pEC;
  public LinearLayout pED;
  public LinearLayout pEE;
  public LinearLayout pEF;
  public boolean pEG;
  a pEH;
  boolean pEI;
  boolean pEJ;
  boolean pEK;
  boolean pEL;
  public boolean pEM;
  public WeImageButton pEw;
  public WeImageButton pEx;
  public WeImageButton pEy;
  public WeImageButton pEz;
  
  public a()
  {
    AppMethodBeat.i(181982);
    this.pEG = false;
    this.pAa = "";
    this.pEI = false;
    this.pEJ = false;
    this.pEK = false;
    this.pEL = false;
    this.pEH = this;
    AppMethodBeat.o(181982);
  }
  
  public final void a(com.tencent.mm.plugin.editor.model.nativenote.b.a parama)
  {
    AppMethodBeat.i(181985);
    this.pEz.setImageResource(2131231993);
    if (!this.pEG)
    {
      AppMethodBeat.o(181985);
      return;
    }
    this.pEG = false;
    com.tencent.mm.plugin.editor.model.c.cfj().cfk();
    String str = com.tencent.mm.plugin.editor.model.c.cfj().cfl();
    int i = (int)com.tencent.mm.plugin.editor.model.c.cfj().duration;
    int j = (int)com.tencent.mm.plugin.editor.b.sI(i);
    int k = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cfy().cfD();
    com.tencent.mm.plugin.editor.model.a.a locala = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cfy().BM(k);
    if (!o.fB(str))
    {
      ae.e("MicroMsg.EditorFooterPanel", "voicePath not exist, remove data from data list and ui.");
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cfy().Y(k, false);
      if (parama != null) {
        parama.BJ(k);
      }
      parama = new com.tencent.mm.plugin.editor.model.a.j();
      parama.content = "";
      parama.pAj = true;
      parama.pAp = false;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cfy().a(k, parama);
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cfy().fh(k - 1, k + 1);
      AppMethodBeat.o(181985);
      return;
    }
    if ((k != -1) && (locala != null) && (locala.getType() == 4))
    {
      ((com.tencent.mm.plugin.editor.model.a.m)locala).pAG = Boolean.FALSE;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).type = 4;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).pAx = true;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).pAB = "";
      ((com.tencent.mm.plugin.editor.model.a.m)locala).length = j;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).pAA = com.tencent.mm.plugin.editor.b.G(ak.getContext(), j).toString();
      ((com.tencent.mm.plugin.editor.model.a.m)locala).kVn = (ao.cxc() + "/fav_fileicon_recording.png");
      ((com.tencent.mm.plugin.editor.model.a.m)locala).dCC = str;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).duj = i;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cfy().BO(k);
    }
    AppMethodBeat.o(181985);
  }
  
  public final void cfr()
  {
    AppMethodBeat.i(181984);
    a(null);
    AppMethodBeat.o(181984);
  }
  
  public final void cfs()
  {
    AppMethodBeat.i(181983);
    h.a(this.pEz.getContext(), this.pEz.getContext().getString(2131762249), "", true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
  
  public final void ke(boolean paramBoolean)
  {
    AppMethodBeat.i(181986);
    this.pEL = paramBoolean;
    this.pEF.setPressed(paramBoolean);
    AppMethodBeat.o(181986);
  }
  
  public final void kf(boolean paramBoolean)
  {
    AppMethodBeat.i(181987);
    this.pEI = paramBoolean;
    this.pEB.setPressed(paramBoolean);
    AppMethodBeat.o(181987);
  }
  
  public final void kg(boolean paramBoolean)
  {
    AppMethodBeat.i(181988);
    this.pEJ = paramBoolean;
    this.pEC.setPressed(paramBoolean);
    AppMethodBeat.o(181988);
  }
  
  public final void kh(boolean paramBoolean)
  {
    AppMethodBeat.i(181989);
    this.pEK = paramBoolean;
    this.pEE.setPressed(paramBoolean);
    AppMethodBeat.o(181989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.widget.a
 * JD-Core Version:    0.7.0.1
 */
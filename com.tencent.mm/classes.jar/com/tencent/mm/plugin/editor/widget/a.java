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
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.editor.model.a.i;
import com.tencent.mm.plugin.editor.model.c.1;
import com.tencent.mm.plugin.editor.model.c.2;
import com.tencent.mm.plugin.editor.model.nativenote.spans.t;
import com.tencent.mm.plugin.fav.a.ao;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.widget.imageview.WeImageButton;
import com.tencent.mm.vfs.o;
import com.tencent.mm.vfs.s;

public final class a
  implements com.tencent.mm.plugin.editor.model.b.a, com.tencent.mm.plugin.editor.model.nativenote.b.b
{
  public View psf;
  String qPr;
  public WeImageButton qTN;
  public WeImageButton qTO;
  public WeImageButton qTP;
  public WeImageButton qTQ;
  public LinearLayout qTR;
  public LinearLayout qTS;
  public LinearLayout qTT;
  public LinearLayout qTU;
  public LinearLayout qTV;
  public LinearLayout qTW;
  public boolean qTX;
  a qTY;
  boolean qTZ;
  boolean qUa;
  boolean qUb;
  boolean qUc;
  public boolean qUd;
  
  public a()
  {
    AppMethodBeat.i(181982);
    this.qTX = false;
    this.qPr = "";
    this.qTZ = false;
    this.qUa = false;
    this.qUb = false;
    this.qUc = false;
    this.qTY = this;
    AppMethodBeat.o(181982);
  }
  
  public final void a(com.tencent.mm.plugin.editor.model.nativenote.b.a parama)
  {
    AppMethodBeat.i(181985);
    this.qTQ.setImageResource(2131232084);
    if (!this.qTX)
    {
      AppMethodBeat.o(181985);
      return;
    }
    this.qTX = false;
    com.tencent.mm.plugin.editor.model.c.cCZ().cDa();
    String str = com.tencent.mm.plugin.editor.model.c.cCZ().cDb();
    int i = (int)com.tencent.mm.plugin.editor.model.c.cCZ().duration;
    int j = (int)com.tencent.mm.plugin.editor.b.AO(i);
    int k = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().cDt();
    com.tencent.mm.plugin.editor.model.a.a locala = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().Fw(k);
    if (!s.YS(str))
    {
      Log.e("MicroMsg.EditorFooterPanel", "voicePath not exist, remove data from data list and ui.");
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().ae(k, false);
      if (parama != null) {
        parama.Ft(k);
      }
      parama = new com.tencent.mm.plugin.editor.model.a.j();
      parama.content = "";
      parama.qPA = true;
      parama.qPG = false;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().a(k, parama);
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().fx(k - 1, k + 1);
      AppMethodBeat.o(181985);
      return;
    }
    if ((k != -1) && (locala != null) && (locala.getType() == 4))
    {
      ((com.tencent.mm.plugin.editor.model.a.m)locala).qPX = Boolean.FALSE;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).type = 4;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).qPO = true;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).qPS = "";
      ((com.tencent.mm.plugin.editor.model.a.m)locala).length = j;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).qPR = com.tencent.mm.plugin.editor.b.J(MMApplicationContext.getContext(), j).toString();
      ((com.tencent.mm.plugin.editor.model.a.m)locala).mav = (ao.cVg() + "/fav_fileicon_recording.png");
      ((com.tencent.mm.plugin.editor.model.a.m)locala).dUs = str;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).dLu = i;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cDo().Fy(k);
    }
    AppMethodBeat.o(181985);
  }
  
  public final void cDh()
  {
    AppMethodBeat.i(181984);
    a(null);
    AppMethodBeat.o(181984);
  }
  
  public final void cDi()
  {
    AppMethodBeat.i(181983);
    h.a(this.qTQ.getContext(), this.qTQ.getContext().getString(2131764308), "", true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
  
  public final void lh(boolean paramBoolean)
  {
    AppMethodBeat.i(181986);
    this.qUc = paramBoolean;
    this.qTW.setPressed(paramBoolean);
    AppMethodBeat.o(181986);
  }
  
  public final void li(boolean paramBoolean)
  {
    AppMethodBeat.i(181987);
    this.qTZ = paramBoolean;
    this.qTS.setPressed(paramBoolean);
    AppMethodBeat.o(181987);
  }
  
  public final void lj(boolean paramBoolean)
  {
    AppMethodBeat.i(181988);
    this.qUa = paramBoolean;
    this.qTT.setPressed(paramBoolean);
    AppMethodBeat.o(181988);
  }
  
  public final void lk(boolean paramBoolean)
  {
    AppMethodBeat.i(181989);
    this.qUb = paramBoolean;
    this.qTV.setPressed(paramBoolean);
    AppMethodBeat.o(181989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.widget.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.editor.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.b.c.a;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.plugin.editor.d.d;
import com.tencent.mm.plugin.editor.d.g;
import com.tencent.mm.plugin.editor.d.h;
import com.tencent.mm.plugin.editor.model.a.i;
import com.tencent.mm.plugin.editor.model.c.1;
import com.tencent.mm.plugin.editor.model.c.2;
import com.tencent.mm.plugin.editor.model.nativenote.spans.t;
import com.tencent.mm.plugin.fav.a.ap;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.imageview.WeImageButton;
import com.tencent.mm.vfs.q;

public final class a
  implements com.tencent.mm.plugin.editor.model.b.a, com.tencent.mm.plugin.editor.model.nativenote.b.b
{
  public View sBm;
  String urx;
  public WeImageButton uvT;
  public WeImageButton uvU;
  public WeImageButton uvV;
  public WeImageButton uvW;
  public LinearLayout uvX;
  public LinearLayout uvY;
  public LinearLayout uvZ;
  public LinearLayout uwa;
  public LinearLayout uwb;
  public LinearLayout uwc;
  public boolean uwd;
  a uwe;
  boolean uwf;
  boolean uwg;
  boolean uwh;
  boolean uwi;
  public boolean uwj;
  
  public a()
  {
    AppMethodBeat.i(181982);
    this.uwd = false;
    this.urx = "";
    this.uwf = false;
    this.uwg = false;
    this.uwh = false;
    this.uwi = false;
    this.uwe = this;
    AppMethodBeat.o(181982);
  }
  
  public final void a(com.tencent.mm.plugin.editor.model.nativenote.b.a parama)
  {
    AppMethodBeat.i(181985);
    this.uvW.setImageResource(d.d.upB);
    if (!this.uwd)
    {
      AppMethodBeat.o(181985);
      return;
    }
    this.uwd = false;
    com.tencent.mm.plugin.editor.model.c.cRE().cRF();
    String str = com.tencent.mm.plugin.editor.model.c.cRE().cRG();
    int i = (int)com.tencent.mm.plugin.editor.model.c.cRE().duration;
    int j = (int)com.tencent.mm.plugin.editor.b.GW(i);
    int k = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().cRY();
    com.tencent.mm.plugin.editor.model.a.a locala = com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().Jd(k);
    if (!com.tencent.mm.vfs.u.agG(str))
    {
      Log.e("MicroMsg.EditorFooterPanel", "voicePath not exist, remove data from data list and ui.");
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().ae(k, false);
      if (parama != null) {
        parama.Ja(k);
      }
      parama = new com.tencent.mm.plugin.editor.model.a.j();
      parama.content = "";
      parama.urG = true;
      parama.urM = false;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().a(k, parama);
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().fU(k - 1, k + 1);
      AppMethodBeat.o(181985);
      return;
    }
    if ((k != -1) && (locala != null) && (locala.getType() == 4))
    {
      ((com.tencent.mm.plugin.editor.model.a.m)locala).usd = Boolean.FALSE;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).type = 4;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).urU = true;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).urY = "";
      ((com.tencent.mm.plugin.editor.model.a.m)locala).length = j;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).urX = com.tencent.mm.plugin.editor.b.N(MMApplicationContext.getContext(), j).toString();
      ((com.tencent.mm.plugin.editor.model.a.m)locala).oYm = (ap.dkm() + "/fav_fileicon_recording.png");
      ((com.tencent.mm.plugin.editor.model.a.m)locala).fNU = str;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).fEj = i;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.cRT().Jf(k);
    }
    AppMethodBeat.o(181985);
  }
  
  public final void cRM()
  {
    AppMethodBeat.i(181984);
    a(null);
    AppMethodBeat.o(181984);
  }
  
  public final void cRN()
  {
    AppMethodBeat.i(181983);
    h.a(this.uvW.getContext(), this.uvW.getContext().getString(d.h.uqg), "", true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
  
  public final void mt(boolean paramBoolean)
  {
    AppMethodBeat.i(181986);
    this.uwi = paramBoolean;
    this.uwc.setPressed(paramBoolean);
    AppMethodBeat.o(181986);
  }
  
  public final void mu(boolean paramBoolean)
  {
    AppMethodBeat.i(181987);
    this.uwf = paramBoolean;
    this.uvY.setPressed(paramBoolean);
    AppMethodBeat.o(181987);
  }
  
  public final void mv(boolean paramBoolean)
  {
    AppMethodBeat.i(181988);
    this.uwg = paramBoolean;
    this.uvZ.setPressed(paramBoolean);
    AppMethodBeat.o(181988);
  }
  
  public final void mw(boolean paramBoolean)
  {
    AppMethodBeat.i(181989);
    this.uwh = paramBoolean;
    this.uwb.setPressed(paramBoolean);
    AppMethodBeat.o(181989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.widget.a
 * JD-Core Version:    0.7.0.1
 */
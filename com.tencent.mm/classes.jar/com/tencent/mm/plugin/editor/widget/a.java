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
import com.tencent.mm.component.api.jumper.UICustomParam.a;
import com.tencent.mm.modelcontrol.VideoTransPara;
import com.tencent.mm.plugin.editor.d.a;
import com.tencent.mm.plugin.editor.d.d;
import com.tencent.mm.plugin.editor.d.g;
import com.tencent.mm.plugin.editor.d.h;
import com.tencent.mm.plugin.editor.model.a.i;
import com.tencent.mm.plugin.editor.model.c.1;
import com.tencent.mm.plugin.editor.model.c.2;
import com.tencent.mm.plugin.fav.a.aq;
import com.tencent.mm.plugin.mmsight.SightParams;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MTimerHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.imageview.WeImageButton;
import com.tencent.mm.vfs.y;

public final class a
  implements com.tencent.mm.plugin.editor.model.b.a, com.tencent.mm.plugin.editor.model.nativenote.b.b
{
  public View uiE;
  public LinearLayout xCA;
  public LinearLayout xCB;
  public boolean xCC;
  a xCD;
  boolean xCE;
  boolean xCF;
  boolean xCG;
  boolean xCH;
  public boolean xCI;
  public WeImageButton xCs;
  public WeImageButton xCt;
  public WeImageButton xCu;
  public WeImageButton xCv;
  public LinearLayout xCw;
  public LinearLayout xCx;
  public LinearLayout xCy;
  public LinearLayout xCz;
  String xxS;
  
  public a()
  {
    AppMethodBeat.i(181982);
    this.xCC = false;
    this.xxS = "";
    this.xCE = false;
    this.xCF = false;
    this.xCG = false;
    this.xCH = false;
    this.xCD = this;
    AppMethodBeat.o(181982);
  }
  
  public final void a(com.tencent.mm.plugin.editor.model.nativenote.b.a parama)
  {
    AppMethodBeat.i(181985);
    this.xCv.setImageResource(d.d.xvY);
    if (!this.xCC)
    {
      AppMethodBeat.o(181985);
      return;
    }
    this.xCC = false;
    com.tencent.mm.plugin.editor.model.c.dvX().dvY();
    String str = com.tencent.mm.plugin.editor.model.c.dvX().dvZ();
    int i = (int)com.tencent.mm.plugin.editor.model.c.dvX().duration;
    int j = (int)com.tencent.mm.plugin.editor.b.jh(i);
    int k = com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().dwr();
    com.tencent.mm.plugin.editor.model.a.a locala = com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().JL(k);
    if (!y.ZC(str))
    {
      Log.e("MicroMsg.EditorFooterPanel", "voicePath not exist, remove data from data list and ui.");
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().av(k, false);
      if (parama != null) {
        parama.JI(k);
      }
      parama = new com.tencent.mm.plugin.editor.model.a.j();
      parama.content = "";
      parama.xyb = true;
      parama.xyh = false;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().a(k, parama);
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().gL(k - 1, k + 1);
      AppMethodBeat.o(181985);
      return;
    }
    if ((k != -1) && (locala != null) && (locala.getType() == 4))
    {
      ((com.tencent.mm.plugin.editor.model.a.m)locala).xyz = Boolean.FALSE;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).type = 4;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).xyp = true;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).xyu = "";
      ((com.tencent.mm.plugin.editor.model.a.m)locala).length = j;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).xyt = com.tencent.mm.plugin.editor.b.Q(MMApplicationContext.getContext(), j).toString();
      ((com.tencent.mm.plugin.editor.model.a.m)locala).sdM = (aq.dQY() + "/fav_fileicon_recording.png");
      ((com.tencent.mm.plugin.editor.model.a.m)locala).hTM = str;
      ((com.tencent.mm.plugin.editor.model.a.m)locala).hIZ = i;
      com.tencent.mm.plugin.editor.model.nativenote.manager.c.dwm().JN(k);
    }
    AppMethodBeat.o(181985);
  }
  
  public final void dwf()
  {
    AppMethodBeat.i(181984);
    a(null);
    AppMethodBeat.o(181984);
  }
  
  public final void dwg()
  {
    AppMethodBeat.i(181983);
    k.a(this.xCv.getContext(), this.xCv.getContext().getString(d.h.xwD), "", true, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
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
  
  public final void nP(boolean paramBoolean)
  {
    AppMethodBeat.i(181986);
    this.xCH = paramBoolean;
    this.xCB.setPressed(paramBoolean);
    AppMethodBeat.o(181986);
  }
  
  public final void nQ(boolean paramBoolean)
  {
    AppMethodBeat.i(181987);
    this.xCE = paramBoolean;
    this.xCx.setPressed(paramBoolean);
    AppMethodBeat.o(181987);
  }
  
  public final void nR(boolean paramBoolean)
  {
    AppMethodBeat.i(181988);
    this.xCF = paramBoolean;
    this.xCy.setPressed(paramBoolean);
    AppMethodBeat.o(181988);
  }
  
  public final void nS(boolean paramBoolean)
  {
    AppMethodBeat.i(181989);
    this.xCG = paramBoolean;
    this.xCA.setPressed(paramBoolean);
    AppMethodBeat.o(181989);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.widget.a
 * JD-Core Version:    0.7.0.1
 */
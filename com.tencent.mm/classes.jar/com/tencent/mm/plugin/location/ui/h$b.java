package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

final class h$b
{
  private LinearLayout.LayoutParams nvD;
  boolean odg;
  h.b.a odh;
  String username;
  
  public h$b(h paramh, String paramString)
  {
    AppMethodBeat.i(113501);
    this.odg = false;
    this.username = paramString;
    if (bo.isNullOrNil(paramString))
    {
      ab.e("MicroMsg.ShareHeaderAvatarViewMgr", "init HeaderAvatar, username can't not be null");
      AppMethodBeat.o(113501);
      return;
    }
    this.odh = new h.b.a(this);
    paramh = (LayoutInflater)this.odd.context.getSystemService("layout_inflater");
    this.odh.odi = ((RelativeLayout)paramh.inflate(2130969994, null));
    this.odh.gqF = ((ImageView)this.odh.odi.findViewById(2131823820));
    a.b.s(this.odh.gqF, this.username);
    this.odh.odi.setTag(this.username);
    this.nvD = new LinearLayout.LayoutParams(-2, -2);
    this.nvD.leftMargin = BackwardSupportUtil.b.b(this.odd.context, 5.0F);
    this.nvD.rightMargin = BackwardSupportUtil.b.b(this.odd.context, 5.0F);
    this.nvD.gravity = 17;
    AppMethodBeat.o(113501);
  }
  
  public final void bLM()
  {
    AppMethodBeat.i(113502);
    ab.i("MicroMsg.ShareHeaderAvatarViewMgr", "setTalking, username=%s", new Object[] { this.username });
    this.odh.odi.setBackgroundResource(2130839305);
    this.odh.odi.invalidate();
    this.odg = true;
    AppMethodBeat.o(113502);
  }
  
  public final void bLN()
  {
    AppMethodBeat.i(113503);
    ab.i("MicroMsg.ShareHeaderAvatarViewMgr", "exitTalking, username=%s", new Object[] { this.username });
    this.odh.odi.setBackgroundResource(2130839304);
    this.odh.odi.invalidate();
    this.odg = false;
    AppMethodBeat.o(113503);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.h.b
 * JD-Core Version:    0.7.0.1
 */
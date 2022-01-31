package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.preference.IconPreference;
import com.tencent.mm.ui.base.preference.NormalIconPreference;

final class SeeRoomOwnerManagerUI$3
  extends NormalIconPreference
{
  SeeRoomOwnerManagerUI$3(SeeRoomOwnerManagerUI paramSeeRoomOwnerManagerUI, Context paramContext, ad paramad)
  {
    super(paramContext);
  }
  
  public final void onBindView(View paramView)
  {
    AppMethodBeat.i(104367);
    super.onBindView(paramView);
    a.b.a(this.zrd, this.ejm.field_username, 0.15F, false);
    this.zrd.setVisibility(0);
    AppMethodBeat.o(104367);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomOwnerManagerUI.3
 * JD-Core Version:    0.7.0.1
 */
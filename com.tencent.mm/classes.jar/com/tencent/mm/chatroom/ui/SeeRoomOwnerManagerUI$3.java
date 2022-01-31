package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.h.c.ao;
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
  
  protected final void onBindView(View paramView)
  {
    super.onBindView(paramView);
    a.b.a(this.vcD, this.drE.field_username, 0.15F, false);
    this.vcD.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeRoomOwnerManagerUI.3
 * JD-Core Version:    0.7.0.1
 */
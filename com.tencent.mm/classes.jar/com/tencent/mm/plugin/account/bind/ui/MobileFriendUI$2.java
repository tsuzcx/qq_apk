package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.MMWizardActivity;

final class MobileFriendUI$2
  implements View.OnClickListener
{
  MobileFriendUI$2(MobileFriendUI paramMobileFriendUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(13720);
    paramView = new Intent(this.gwb.getContext(), BindMContactIntroUI.class);
    paramView.putExtra("key_upload_scene", 6);
    MMWizardActivity.J(this.gwb, paramView);
    AppMethodBeat.o(13720);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.MobileFriendUI.2
 * JD-Core Version:    0.7.0.1
 */
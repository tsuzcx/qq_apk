package com.tencent.mm.chatroom.ui;

import android.content.res.Resources;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class SeeAccessVerifyInfoUI$4
  implements Runnable
{
  SeeAccessVerifyInfoUI$4(SeeAccessVerifyInfoUI paramSeeAccessVerifyInfoUI) {}
  
  public final void run()
  {
    AppMethodBeat.i(104263);
    int i = 0;
    if (SeeAccessVerifyInfoUI.c(this.eiF) != null) {
      if (!SeeAccessVerifyInfoUI.d(this.eiF)) {
        break label136;
      }
    }
    label136:
    for (i = (int)(SeeAccessVerifyInfoUI.c(this.eiF).getHeight() * 2 + this.eiF.getResources().getDimension(2131427500) + this.eiF.getResources().getDimension(2131427800));; i = (int)(SeeAccessVerifyInfoUI.c(this.eiF).getHeight() + this.eiF.getResources().getDimension(2131427500) + this.eiF.getResources().getDimension(2131427800)))
    {
      int j = i;
      if (SeeAccessVerifyInfoUI.e(this.eiF).getCount() / 4 > 0) {
        j = i * (SeeAccessVerifyInfoUI.e(this.eiF).getCount() / 4 + 1);
      }
      SeeAccessVerifyInfoUI.f(this.eiF).setLayoutParams(new LinearLayout.LayoutParams(SeeAccessVerifyInfoUI.f(this.eiF).getWidth(), j));
      AppMethodBeat.o(104263);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI.4
 * JD-Core Version:    0.7.0.1
 */
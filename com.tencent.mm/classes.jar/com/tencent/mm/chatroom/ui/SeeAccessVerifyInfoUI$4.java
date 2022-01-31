package com.tencent.mm.chatroom.ui;

import android.content.res.Resources;
import android.widget.GridView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

final class SeeAccessVerifyInfoUI$4
  implements Runnable
{
  SeeAccessVerifyInfoUI$4(SeeAccessVerifyInfoUI paramSeeAccessVerifyInfoUI) {}
  
  public final void run()
  {
    int i = 0;
    if (SeeAccessVerifyInfoUI.c(this.dqZ) != null) {
      i = (int)(SeeAccessVerifyInfoUI.c(this.dqZ).getHeight() + this.dqZ.getResources().getDimension(a.c.BigPadding) + this.dqZ.getResources().getDimension(a.c.NormalAvatarSize));
    }
    int j = i;
    if (SeeAccessVerifyInfoUI.d(this.dqZ).getCount() / 4 > 0) {
      j = i * (SeeAccessVerifyInfoUI.d(this.dqZ).getCount() / 4 + 1);
    }
    SeeAccessVerifyInfoUI.e(this.dqZ).setLayoutParams(new LinearLayout.LayoutParams(SeeAccessVerifyInfoUI.e(this.dqZ).getWidth(), j));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI.4
 * JD-Core Version:    0.7.0.1
 */
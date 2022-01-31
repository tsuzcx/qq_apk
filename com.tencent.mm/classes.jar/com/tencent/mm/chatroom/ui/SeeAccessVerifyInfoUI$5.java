package com.tencent.mm.chatroom.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.chatroom.c.c;
import com.tencent.mm.ck.f;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.util.LinkedList;

final class SeeAccessVerifyInfoUI$5
  implements View.OnClickListener
{
  SeeAccessVerifyInfoUI$5(SeeAccessVerifyInfoUI paramSeeAccessVerifyInfoUI) {}
  
  public final void onClick(View paramView)
  {
    paramView = this.dqZ;
    AppCompatActivity localAppCompatActivity = this.dqZ.mController.uMN;
    this.dqZ.getString(a.i.app_tip);
    SeeAccessVerifyInfoUI.a(paramView, h.b(localAppCompatActivity, this.dqZ.getString(a.i.accessing_invite), false, null));
    new c(SeeAccessVerifyInfoUI.i(this.dqZ), SeeAccessVerifyInfoUI.a(this.dqZ), SeeAccessVerifyInfoUI.j(this.dqZ), SeeAccessVerifyInfoUI.k(this.dqZ), new LinkedList(bk.G(SeeAccessVerifyInfoUI.l(this.dqZ).split(",")))).Km().b(this.dqZ).b(new SeeAccessVerifyInfoUI.5.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI.5
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.chatroom.ui;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.c.c;
import com.tencent.mm.cm.f;
import com.tencent.mm.model.t;
import com.tencent.mm.openim.c.a.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import java.util.LinkedList;

final class SeeAccessVerifyInfoUI$5
  implements View.OnClickListener
{
  SeeAccessVerifyInfoUI$5(SeeAccessVerifyInfoUI paramSeeAccessVerifyInfoUI) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(104266);
    paramView = this.eiF;
    AppCompatActivity localAppCompatActivity = this.eiF.getContext();
    this.eiF.getString(2131297087);
    SeeAccessVerifyInfoUI.a(paramView, h.b(localAppCompatActivity, this.eiF.getString(2131296396), false, null));
    if (t.nK(SeeAccessVerifyInfoUI.g(this.eiF)))
    {
      new a(SeeAccessVerifyInfoUI.a(this.eiF), SeeAccessVerifyInfoUI.g(this.eiF), SeeAccessVerifyInfoUI.k(this.eiF), new LinkedList(bo.ih(SeeAccessVerifyInfoUI.l(this.eiF), ","))).adl().b(this.eiF).b(new SeeAccessVerifyInfoUI.5.1(this));
      AppMethodBeat.o(104266);
      return;
    }
    new c(SeeAccessVerifyInfoUI.m(this.eiF), SeeAccessVerifyInfoUI.a(this.eiF), SeeAccessVerifyInfoUI.g(this.eiF), SeeAccessVerifyInfoUI.k(this.eiF), new LinkedList(bo.P(SeeAccessVerifyInfoUI.l(this.eiF).split(",")))).adl().b(this.eiF).b(new SeeAccessVerifyInfoUI.5.2(this));
    AppMethodBeat.o(104266);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI.5
 * JD-Core Version:    0.7.0.1
 */
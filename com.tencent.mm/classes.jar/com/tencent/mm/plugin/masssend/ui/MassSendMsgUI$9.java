package com.tencent.mm.plugin.masssend.ui;

import android.content.Intent;
import android.widget.Toast;
import com.tencent.mm.R.l;
import com.tencent.mm.br.d;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.ui.chat.AppPanel.a;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;
import com.tencent.mm.vfs.b;

final class MassSendMsgUI$9
  implements AppPanel.a
{
  MassSendMsgUI$9(MassSendMsgUI paramMassSendMsgUI) {}
  
  public final void b(f paramf) {}
  
  public final void bhm()
  {
    Toast.makeText(this.mbI, this.mbI.getString(R.l.mass_send_voip_not_support), 0).show();
  }
  
  public final void bhn()
  {
    Toast.makeText(this.mbI, this.mbI.getString(R.l.mass_send_card_not_support), 0).show();
  }
  
  public final void bho()
  {
    Toast.makeText(this.mbI, this.mbI.getString(R.l.mass_send_talkroom_not_support), 0).show();
  }
  
  public final void bhp()
  {
    Toast.makeText(this.mbI, this.mbI.getString(R.l.mass_send_location_not_support), 0).show();
  }
  
  public final void bhq()
  {
    Toast.makeText(this.mbI, this.mbI.getString(R.l.mass_send_card_not_support), 0).show();
  }
  
  public final void bhr()
  {
    com.tencent.mm.plugin.masssend.a.eUR.aP(this.mbI);
  }
  
  public final void bhs()
  {
    Toast.makeText(this.mbI, this.mbI.getString(R.l.mass_send_card_not_support), 0).show();
  }
  
  public final void bht() {}
  
  public final void bhu()
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("preceding_scence", 13);
    d.b(this.mbI, "emoji", ".ui.v2.EmojiStoreV2UI", localIntent);
  }
  
  public final void bhv()
  {
    Toast.makeText(this.mbI, this.mbI.getString(R.l.mass_send_lucky_money_not_support), 0).show();
  }
  
  public final void bhw() {}
  
  public final void bhx() {}
  
  public final void bhy() {}
  
  public final void bhz() {}
  
  public final void tA(int paramInt)
  {
    switch (paramInt)
    {
    }
    boolean bool;
    do
    {
      return;
      l.a(this.mbI, 1, 1, 0, 3, false, null);
      return;
      b localb = new b(e.dzD);
      if ((!localb.exists()) && (!localb.mkdirs()))
      {
        Toast.makeText(this.mbI, this.mbI.getString(R.l.chatting_toast_sdk_fail), 1).show();
        return;
      }
      bool = com.tencent.mm.pluginsdk.permission.a.a(this.mbI.mController.uMN, "android.permission.CAMERA", 16, "", "");
      y.i("MicroMsg.MassSendMsgUI", "summerper checkPermission checkCamera[%b], stack[%s], activity[%s]", new Object[] { Boolean.valueOf(bool), bk.csb(), this.mbI.mController.uMN });
    } while (!bool);
    MassSendMsgUI.c(this.mbI);
  }
  
  public final void tB(int paramInt)
  {
    MassSendMsgUI.d(this.mbI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.masssend.ui.MassSendMsgUI.9
 * JD-Core Version:    0.7.0.1
 */
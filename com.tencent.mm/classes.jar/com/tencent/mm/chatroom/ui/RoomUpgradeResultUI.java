package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;

@Deprecated
public class RoomUpgradeResultUI
  extends MMActivity
{
  private String chatroomName;
  private u dnL;
  private Button dqq;
  private View dqr;
  private ImageView dqs;
  private TextView dqt;
  private TextView dqu;
  private TextView dqv;
  
  private void eQ(String paramString)
  {
    Object localObject = ((j)g.r(j.class)).Fw().abl(paramString);
    if ((localObject != null) && ((int)((a)localObject).dBe > 0))
    {
      localObject = ((ad)localObject).Bp();
      a.b.a(this.dqs, paramString);
      this.dqt.setVisibility(0);
      this.dqt.setText((CharSequence)localObject);
    }
  }
  
  private void goBack()
  {
    Intent localIntent = new Intent(this, RoomUpgradeUI.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("finish_self", true);
    startActivity(localIntent);
  }
  
  protected final int getLayoutId()
  {
    return a.f.chatroom_upgrade;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.room_upgrade_entry_maxcount);
    setBackBtn(new RoomUpgradeResultUI.1(this));
    this.dqr = findViewById(a.e.upgrader_info_container);
    this.dqs = ((ImageView)findViewById(a.e.upgrader_avatar));
    this.dqt = ((TextView)findViewById(a.e.upgrader_nickname));
    this.dqu = ((TextView)findViewById(a.e.upgrade_intro));
    this.dqv = ((TextView)findViewById(a.e.upgrade_quota_left));
    this.dqq = ((Button)findViewById(a.e.how_to_upgrade_maxcount));
    this.dqq.setOnClickListener(new RoomUpgradeResultUI.2(this));
    this.dqq.setVisibility(0);
    String str = this.dnL.field_roomowner;
    ad localad = ((j)g.r(j.class)).Fw().abl(str);
    if ((localad != null) && ((int)localad.dBe <= 0)) {
      am.a.dVy.a(str, this.chatroomName, new RoomUpgradeResultUI.3(this, str));
    }
    for (;;)
    {
      int i = this.dnL.ctR();
      this.dqu.setVisibility(0);
      this.dqu.setText(getString(a.i.room_upgrade_intro_maxcount, new Object[] { Integer.valueOf(i) }));
      this.dqq.setText(a.i.room_upgrade_how_to_upgrade_maxcount_member_view);
      this.dqv.setVisibility(8);
      return;
      eQ(str);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.chatroomName = getIntent().getStringExtra("chatroom");
    y.i("MicroMsg.RoomUpgradeResultUI", "the roomName is %s", new Object[] { this.chatroomName });
    this.dnL = ((c)g.r(c.class)).FF().in(this.chatroomName);
    if (this.dnL == null) {
      goBack();
    }
    initView();
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 4)
    {
      goBack();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomUpgradeResultUI
 * JD-Core Version:    0.7.0.1
 */
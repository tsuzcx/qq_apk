package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;

@Deprecated
public class RoomUpgradeResultUI
  extends MMActivity
{
  private String chatroomName;
  private u efi;
  private Button ehO;
  private View ehP;
  private ImageView ehQ;
  private TextView ehR;
  private TextView ehS;
  private TextView ehT;
  
  private void goBack()
  {
    AppMethodBeat.i(104232);
    Intent localIntent = new Intent(this, RoomUpgradeUI.class);
    localIntent.addFlags(67108864);
    localIntent.putExtra("finish_self", true);
    startActivity(localIntent);
    AppMethodBeat.o(104232);
  }
  
  private void la(String paramString)
  {
    AppMethodBeat.i(104230);
    Object localObject = ((j)g.E(j.class)).YA().arw(paramString);
    if ((localObject != null) && ((int)((a)localObject).euF > 0))
    {
      localObject = ((ad)localObject).Oe();
      a.b.c(this.ehQ, paramString);
      this.ehR.setVisibility(0);
      this.ehR.setText((CharSequence)localObject);
      AppMethodBeat.o(104230);
      return;
    }
    AppMethodBeat.o(104230);
  }
  
  public int getLayoutId()
  {
    return 2130969027;
  }
  
  public void initView()
  {
    AppMethodBeat.i(104227);
    setMMTitle(2131302802);
    setBackBtn(new RoomUpgradeResultUI.1(this));
    this.ehP = findViewById(2131822429);
    this.ehQ = ((ImageView)findViewById(2131822430));
    this.ehR = ((TextView)findViewById(2131822431));
    this.ehS = ((TextView)findViewById(2131822433));
    this.ehT = ((TextView)findViewById(2131822435));
    this.ehO = ((Button)findViewById(2131822436));
    this.ehO.setOnClickListener(new RoomUpgradeResultUI.2(this));
    this.ehO.setVisibility(0);
    String str = this.efi.field_roomowner;
    ad localad = ((j)g.E(j.class)).YA().arw(str);
    if ((localad != null) && ((int)localad.euF <= 0)) {
      ao.a.flI.a(str, this.chatroomName, new RoomUpgradeResultUI.3(this, str));
    }
    for (;;)
    {
      int i = this.efi.dwr();
      this.ehS.setVisibility(0);
      this.ehS.setText(getString(2131302810, new Object[] { Integer.valueOf(i) }));
      this.ehO.setText(2131302805);
      this.ehT.setVisibility(8);
      AppMethodBeat.o(104227);
      return;
      la(str);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104224);
    super.onCreate(paramBundle);
    this.chatroomName = getIntent().getStringExtra("chatroom");
    ab.i("MicroMsg.RoomUpgradeResultUI", "the roomName is %s", new Object[] { this.chatroomName });
    this.efi = ((c)g.E(c.class)).YJ().oU(this.chatroomName);
    if (this.efi == null) {
      goBack();
    }
    initView();
    AppMethodBeat.o(104224);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104225);
    super.onDestroy();
    AppMethodBeat.o(104225);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(104231);
    if (paramInt == 4)
    {
      goBack();
      AppMethodBeat.o(104231);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(104231);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomUpgradeResultUI
 * JD-Core Version:    0.7.0.1
 */
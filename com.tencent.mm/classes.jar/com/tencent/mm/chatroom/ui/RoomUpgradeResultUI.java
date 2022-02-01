package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.plugin.chatroom.a.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;

@Deprecated
public class RoomUpgradeResultUI
  extends MMActivity
{
  private String chatroomName;
  private Button lLr;
  private View lLs;
  private ImageView lLt;
  private TextView lLu;
  private TextView lLv;
  private TextView lLw;
  private aj lzy;
  
  private void Dh(String paramString)
  {
    AppMethodBeat.i(12775);
    Object localObject = ((n)h.ax(n.class)).bzA().JE(paramString);
    if ((localObject != null) && ((int)((d)localObject).maN > 0))
    {
      localObject = ((au)localObject).aSU();
      a.b.g(this.lLt, paramString);
      this.lLu.setVisibility(0);
      this.lLu.setText((CharSequence)localObject);
      AppMethodBeat.o(12775);
      return;
    }
    AppMethodBeat.o(12775);
  }
  
  private void goBack()
  {
    AppMethodBeat.i(12777);
    Object localObject = new Intent(this, RoomUpgradeUI.class);
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).putExtra("finish_self", true);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/chatroom/ui/RoomUpgradeResultUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/chatroom/ui/RoomUpgradeResultUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(12777);
  }
  
  public int getLayoutId()
  {
    return a.f.lGj;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12774);
    setMMTitle(a.i.lJb);
    setBackBtn(new RoomUpgradeResultUI.1(this));
    this.lLs = findViewById(a.e.lFU);
    this.lLt = ((ImageView)findViewById(a.e.lFT));
    this.lLu = ((TextView)findViewById(a.e.lFV));
    this.lLv = ((TextView)findViewById(a.e.lFR));
    this.lLw = ((TextView)findViewById(a.e.lFS));
    this.lLr = ((Button)findViewById(a.e.lEP));
    this.lLr.setOnClickListener(new RoomUpgradeResultUI.2(this));
    this.lLr.setVisibility(0);
    final String str = this.lzy.field_roomowner;
    au localau = ((n)h.ax(n.class)).bzA().JE(str);
    if ((localau != null) && ((int)localau.maN <= 0)) {
      az.a.okP.a(str, this.chatroomName, new az.b.a()
      {
        public final void getContactCallBack(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(12771);
          if (paramAnonymousBoolean) {
            RoomUpgradeResultUI.b(RoomUpgradeResultUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(12770);
                RoomUpgradeResultUI.a(RoomUpgradeResultUI.this, RoomUpgradeResultUI.3.this.lLy);
                AppMethodBeat.o(12770);
              }
            });
          }
          AppMethodBeat.o(12771);
        }
      });
    }
    for (;;)
    {
      int i = this.lzy.iZm();
      this.lLv.setVisibility(0);
      this.lLv.setText(getString(a.i.lJj, new Object[] { Integer.valueOf(i) }));
      this.lLr.setText(a.i.lJe);
      this.lLw.setVisibility(8);
      AppMethodBeat.o(12774);
      return;
      Dh(str);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12772);
    super.onCreate(paramBundle);
    this.chatroomName = getIntent().getStringExtra("chatroom");
    Log.i("MicroMsg.RoomUpgradeResultUI", "the roomName is %s", new Object[] { this.chatroomName });
    this.lzy = ((b)h.ax(b.class)).bzK().Ju(this.chatroomName);
    if (this.lzy == null) {
      goBack();
    }
    initView();
    AppMethodBeat.o(12772);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12773);
    super.onDestroy();
    AppMethodBeat.o(12773);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(12776);
    if (paramInt == 4)
    {
      goBack();
      AppMethodBeat.o(12776);
      return true;
    }
    boolean bool = super.onKeyDown(paramInt, paramKeyEvent);
    AppMethodBeat.o(12776);
    return bool;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomUpgradeResultUI
 * JD-Core Version:    0.7.0.1
 */
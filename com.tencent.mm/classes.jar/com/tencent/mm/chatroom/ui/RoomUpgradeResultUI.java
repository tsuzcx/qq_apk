package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;

@Deprecated
public class RoomUpgradeResultUI
  extends MMActivity
{
  private String chatroomName;
  private ab fLO;
  private TextView fRA;
  private TextView fRB;
  private Button fRw;
  private View fRx;
  private ImageView fRy;
  private TextView fRz;
  
  private void goBack()
  {
    AppMethodBeat.i(12777);
    Object localObject = new Intent(this, RoomUpgradeUI.class);
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).putExtra("finish_self", true);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/chatroom/ui/RoomUpgradeResultUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/RoomUpgradeResultUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(12777);
  }
  
  private void uX(String paramString)
  {
    AppMethodBeat.i(12775);
    Object localObject = ((l)g.ab(l.class)).azp().Bf(paramString);
    if ((localObject != null) && ((int)((com.tencent.mm.o.b)localObject).gfj > 0))
    {
      localObject = ((am)localObject).adu();
      a.b.c(this.fRy, paramString);
      this.fRz.setVisibility(0);
      this.fRz.setText((CharSequence)localObject);
      AppMethodBeat.o(12775);
      return;
    }
    AppMethodBeat.o(12775);
  }
  
  public int getLayoutId()
  {
    return 2131493381;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12774);
    setMMTitle(2131762714);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(12768);
        RoomUpgradeResultUI.a(RoomUpgradeResultUI.this);
        AppMethodBeat.o(12768);
        return true;
      }
    });
    this.fRx = findViewById(2131306214);
    this.fRy = ((ImageView)findViewById(2131306213));
    this.fRz = ((TextView)findViewById(2131306215));
    this.fRA = ((TextView)findViewById(2131306210));
    this.fRB = ((TextView)findViewById(2131306211));
    this.fRw = ((Button)findViewById(2131300766));
    this.fRw.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(12769);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/RoomUpgradeResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("rawUrl", RoomUpgradeResultUI.this.getString(2131757097, new Object[] { ac.fks() }));
        paramAnonymousView.putExtra("geta8key_username", u.aAm());
        d.c(RoomUpgradeResultUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/RoomUpgradeResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(12769);
      }
    });
    this.fRw.setVisibility(0);
    final String str = this.fLO.field_roomowner;
    am localam = ((l)g.ab(l.class)).azp().Bf(str);
    if ((localam != null) && ((int)localam.gfj <= 0)) {
      as.a.hFO.a(str, this.chatroomName, new as.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(12771);
          if (paramAnonymousBoolean) {
            RoomUpgradeResultUI.b(RoomUpgradeResultUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(12770);
                RoomUpgradeResultUI.a(RoomUpgradeResultUI.this, RoomUpgradeResultUI.3.this.fRD);
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
      int i = this.fLO.fpQ();
      this.fRA.setVisibility(0);
      this.fRA.setText(getString(2131762722, new Object[] { Integer.valueOf(i) }));
      this.fRw.setText(2131762717);
      this.fRB.setVisibility(8);
      AppMethodBeat.o(12774);
      return;
      uX(str);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12772);
    super.onCreate(paramBundle);
    this.chatroomName = getIntent().getStringExtra("chatroom");
    ad.i("MicroMsg.RoomUpgradeResultUI", "the roomName is %s", new Object[] { this.chatroomName });
    this.fLO = ((c)g.ab(c.class)).azz().AN(this.chatroomName);
    if (this.fLO == null) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomUpgradeResultUI
 * JD-Core Version:    0.7.0.1
 */
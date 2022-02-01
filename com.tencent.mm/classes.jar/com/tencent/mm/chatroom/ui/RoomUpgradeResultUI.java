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
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;

@Deprecated
public class RoomUpgradeResultUI
  extends MMActivity
{
  private String chatroomName;
  private ah gtd;
  private Button gyJ;
  private View gyK;
  private ImageView gyL;
  private TextView gyM;
  private TextView gyN;
  private TextView gyO;
  
  private void DK(String paramString)
  {
    AppMethodBeat.i(12775);
    Object localObject = ((l)g.af(l.class)).aSN().Kn(paramString);
    if ((localObject != null) && ((int)((com.tencent.mm.contact.c)localObject).gMZ > 0))
    {
      localObject = ((as)localObject).arI();
      a.b.c(this.gyL, paramString);
      this.gyM.setVisibility(0);
      this.gyM.setText((CharSequence)localObject);
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
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/chatroom/ui/RoomUpgradeResultUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/RoomUpgradeResultUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(12777);
  }
  
  public int getLayoutId()
  {
    return 2131493475;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12774);
    setMMTitle(2131764797);
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
    this.gyK = findViewById(2131309613);
    this.gyL = ((ImageView)findViewById(2131309612));
    this.gyM = ((TextView)findViewById(2131309614));
    this.gyN = ((TextView)findViewById(2131309609));
    this.gyO = ((TextView)findViewById(2131309610));
    this.gyJ = ((Button)findViewById(2131302360));
    this.gyJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(12769);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/RoomUpgradeResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("rawUrl", RoomUpgradeResultUI.this.getString(2131757298, new Object[] { LocaleUtil.getApplicationLanguage() }));
        paramAnonymousView.putExtra("geta8key_username", z.aTY());
        com.tencent.mm.br.c.d(RoomUpgradeResultUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/RoomUpgradeResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(12769);
      }
    });
    this.gyJ.setVisibility(0);
    final String str = this.gtd.field_roomowner;
    as localas = ((l)g.af(l.class)).aSN().Kn(str);
    if ((localas != null) && ((int)localas.gMZ <= 0)) {
      ay.a.iDq.a(str, this.chatroomName, new ay.b.a()
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
                RoomUpgradeResultUI.a(RoomUpgradeResultUI.this, RoomUpgradeResultUI.3.this.gyQ);
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
      int i = this.gtd.gBw();
      this.gyN.setVisibility(0);
      this.gyN.setText(getString(2131764805, new Object[] { Integer.valueOf(i) }));
      this.gyJ.setText(2131764800);
      this.gyO.setVisibility(8);
      AppMethodBeat.o(12774);
      return;
      DK(str);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12772);
    super.onCreate(paramBundle);
    this.chatroomName = getIntent().getStringExtra("chatroom");
    Log.i("MicroMsg.RoomUpgradeResultUI", "the roomName is %s", new Object[] { this.chatroomName });
    this.gtd = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.chatroomName);
    if (this.gtd == null) {
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
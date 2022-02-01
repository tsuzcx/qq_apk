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
import com.tencent.mm.model.aj;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.u;
import com.tencent.mm.n.b;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;

@Deprecated
public class RoomUpgradeResultUI
  extends MMActivity
{
  private String chatroomName;
  private w fql;
  private Button fuC;
  private View fuD;
  private ImageView fuE;
  private TextView fuF;
  private TextView fuG;
  private TextView fuH;
  
  private void goBack()
  {
    AppMethodBeat.i(12777);
    Object localObject = new Intent(this, RoomUpgradeUI.class);
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).putExtra("finish_self", true);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/chatroom/ui/RoomUpgradeResultUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/RoomUpgradeResultUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(12777);
  }
  
  private void oW(String paramString)
  {
    AppMethodBeat.i(12775);
    Object localObject = ((k)g.ab(k.class)).apM().aHY(paramString);
    if ((localObject != null) && ((int)((b)localObject).fId > 0))
    {
      localObject = ((af)localObject).ZW();
      a.b.c(this.fuE, paramString);
      this.fuF.setVisibility(0);
      this.fuF.setText((CharSequence)localObject);
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
    this.fuD = findViewById(2131306214);
    this.fuE = ((ImageView)findViewById(2131306213));
    this.fuF = ((TextView)findViewById(2131306215));
    this.fuG = ((TextView)findViewById(2131306210));
    this.fuH = ((TextView)findViewById(2131306211));
    this.fuC = ((Button)findViewById(2131300766));
    this.fuC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(12769);
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("rawUrl", RoomUpgradeResultUI.this.getString(2131757097, new Object[] { ac.eFu() }));
        paramAnonymousView.putExtra("geta8key_username", u.aqG());
        d.b(RoomUpgradeResultUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", 0);
        AppMethodBeat.o(12769);
      }
    });
    this.fuC.setVisibility(0);
    final String str = this.fql.field_roomowner;
    af localaf = ((k)g.ab(k.class)).apM().aHY(str);
    if ((localaf != null) && ((int)localaf.fId <= 0)) {
      ar.a.gMW.a(str, this.chatroomName, new ar.b.a()
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
                RoomUpgradeResultUI.a(RoomUpgradeResultUI.this, RoomUpgradeResultUI.3.this.fuJ);
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
      int i = this.fql.eKr();
      this.fuG.setVisibility(0);
      this.fuG.setText(getString(2131762722, new Object[] { Integer.valueOf(i) }));
      this.fuC.setText(2131762717);
      this.fuH.setVisibility(8);
      AppMethodBeat.o(12774);
      return;
      oW(str);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12772);
    super.onCreate(paramBundle);
    this.chatroomName = getIntent().getStringExtra("chatroom");
    ad.i("MicroMsg.RoomUpgradeResultUI", "the roomName is %s", new Object[] { this.chatroomName });
    this.fql = ((c)g.ab(c.class)).apV().tH(this.chatroomName);
    if (this.fql == null) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomUpgradeResultUI
 * JD-Core Version:    0.7.0.1
 */
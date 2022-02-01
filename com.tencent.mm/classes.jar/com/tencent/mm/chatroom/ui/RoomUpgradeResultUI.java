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
import com.tencent.mm.by.c;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
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
  private ah iXp;
  private Button jiM;
  private View jiN;
  private ImageView jiO;
  private TextView jiP;
  private TextView jiQ;
  private TextView jiR;
  
  private void KB(String paramString)
  {
    AppMethodBeat.i(12775);
    Object localObject = ((n)h.ae(n.class)).bbL().RG(paramString);
    if ((localObject != null) && ((int)((d)localObject).jxt > 0))
    {
      localObject = ((as)localObject).ayr();
      a.b.c(this.jiO, paramString);
      this.jiP.setVisibility(0);
      this.jiP.setText((CharSequence)localObject);
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
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/chatroom/ui/RoomUpgradeResultUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/chatroom/ui/RoomUpgradeResultUI", "goBack", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(12777);
  }
  
  public int getLayoutId()
  {
    return a.f.jea;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12774);
    setMMTitle(a.i.jgL);
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
    this.jiN = findViewById(a.e.jdM);
    this.jiO = ((ImageView)findViewById(a.e.jdL));
    this.jiP = ((TextView)findViewById(a.e.jdN));
    this.jiQ = ((TextView)findViewById(a.e.jdJ));
    this.jiR = ((TextView)findViewById(a.e.jdK));
    this.jiM = ((Button)findViewById(a.e.jcJ));
    this.jiM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(12769);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/RoomUpgradeResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("rawUrl", RoomUpgradeResultUI.this.getString(a.i.chatroom_how_to_upgrade, new Object[] { LocaleUtil.getApplicationLanguage() }));
        paramAnonymousView.putExtra("geta8key_username", z.bcZ());
        c.f(RoomUpgradeResultUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/RoomUpgradeResultUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(12769);
      }
    });
    this.jiM.setVisibility(0);
    final String str = this.iXp.field_roomowner;
    as localas = ((n)h.ae(n.class)).bbL().RG(str);
    if ((localas != null) && ((int)localas.jxt <= 0)) {
      az.a.ltq.a(str, this.chatroomName, new az.b.a()
      {
        public final void s(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(12771);
          if (paramAnonymousBoolean) {
            RoomUpgradeResultUI.b(RoomUpgradeResultUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(12770);
                RoomUpgradeResultUI.a(RoomUpgradeResultUI.this, RoomUpgradeResultUI.3.this.jiT);
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
      int i = this.iXp.hxH();
      this.jiQ.setVisibility(0);
      this.jiQ.setText(getString(a.i.jgT, new Object[] { Integer.valueOf(i) }));
      this.jiM.setText(a.i.jgO);
      this.jiR.setVisibility(8);
      AppMethodBeat.o(12774);
      return;
      KB(str);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12772);
    super.onCreate(paramBundle);
    this.chatroomName = getIntent().getStringExtra("chatroom");
    Log.i("MicroMsg.RoomUpgradeResultUI", "the roomName is %s", new Object[] { this.chatroomName });
    this.iXp = ((com.tencent.mm.plugin.chatroom.a.b)h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(this.chatroomName);
    if (this.iXp == null) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomUpgradeResultUI
 * JD-Core Version:    0.7.0.1
 */
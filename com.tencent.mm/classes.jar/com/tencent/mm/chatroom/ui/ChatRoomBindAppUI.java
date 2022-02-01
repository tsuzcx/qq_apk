package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.f.h;
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.messenger.foundation.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.c.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/chatroom/ui/ChatRoomBindAppUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "bindButton", "Landroid/widget/Button;", "openParam", "Lcom/tencent/mm/plugin/messenger/foundation/api/IChatRoomOpenService$ChatRoomOpenParam;", "getLayoutId", "", "initViews", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "ui-chatroom_release"})
public final class ChatRoomBindAppUI
  extends MMActivity
{
  public static final ChatRoomBindAppUI.a gtD;
  private Button gtB;
  private c.b gtC;
  
  static
  {
    AppMethodBeat.i(193992);
    gtD = new ChatRoomBindAppUI.a((byte)0);
    AppMethodBeat.o(193992);
  }
  
  public final int getLayoutId()
  {
    return 2131493465;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    TextView localTextView = null;
    AppMethodBeat.i(193991);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131101424));
    paramBundle = getIntent();
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getSerializableExtra("key_bind_param");; paramBundle = null)
    {
      localObject1 = paramBundle;
      if (!(paramBundle instanceof c.b)) {
        localObject1 = null;
      }
      this.gtC = ((c.b)localObject1);
      if (this.gtC != null) {
        break;
      }
      Log.e("MicroMsg.ChatRoomBindAppUI", "openParam is null");
      finish();
      AppMethodBeat.o(193991);
      return;
    }
    setMMTitle("");
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this), 2131689494);
    paramBundle = findViewById(2131297825);
    p.g(paramBundle, "findViewById(R.id.btn_bind)");
    this.gtB = ((Button)paramBundle);
    paramBundle = this.gtB;
    if (paramBundle == null) {
      p.btv("bindButton");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new c(this));
    paramBundle = findViewById(2131309454);
    p.g(paramBundle, "findViewById(R.id.tv_bind_app_title)");
    Object localObject2 = (TextView)paramBundle;
    Object localObject3 = MMApplicationContext.getContext();
    paramBundle = this.gtC;
    if (paramBundle != null)
    {
      localObject1 = paramBundle.appName;
      paramBundle = (Bundle)localObject1;
      if (localObject1 != null) {}
    }
    else
    {
      paramBundle = "";
    }
    ((TextView)localObject2).setText((CharSequence)((Context)localObject3).getString(2131757227, new Object[] { paramBundle }));
    paramBundle = g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(paramBundle, "MMKernel.service(IMessengerStorage::class.java)");
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramBundle).aSN();
    paramBundle = this.gtC;
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.zqa;; paramBundle = null)
    {
      localObject1 = ((bv)localObject1).Kn(paramBundle);
      if (localObject1 != null) {
        break;
      }
      Log.e("MicroMsg.ChatRoomBindAppUI", "contact is null");
      finish();
      AppMethodBeat.o(193991);
      return;
    }
    paramBundle = findViewById(2131302877);
    p.g(paramBundle, "findViewById(R.id.iv_avatar)");
    localObject2 = (ImageView)paramBundle;
    localObject3 = this.gtC;
    paramBundle = localTextView;
    if (localObject3 != null) {
      paramBundle = ((c.b)localObject3).zqa;
    }
    a.b.c((ImageView)localObject2, paramBundle);
    paramBundle = findViewById(2131309491);
    p.g(paramBundle, "findViewById(R.id.tv_group_nickname)");
    ((TextView)paramBundle).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.e((Context)getContext(), (CharSequence)aa.getDisplayName(((as)localObject1).getUsername()), com.tencent.mm.cb.a.aG((Context)getContext(), 2131165535)));
    paramBundle = findViewById(2131309455);
    p.g(paramBundle, "findViewById(R.id.tv_bind_desc)");
    localTextView = (TextView)paramBundle;
    localObject2 = MMApplicationContext.getContext();
    paramBundle = this.gtC;
    if (paramBundle != null)
    {
      localObject1 = paramBundle.appName;
      paramBundle = (Bundle)localObject1;
      if (localObject1 != null) {}
    }
    else
    {
      paramBundle = "";
    }
    localTextView.setText((CharSequence)((Context)localObject2).getString(2131757228, new Object[] { paramBundle }));
    AppMethodBeat.o(193991);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(ChatRoomBindAppUI paramChatRoomBindAppUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(193987);
      this.gtE.finish();
      AppMethodBeat.o(193987);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(ChatRoomBindAppUI paramChatRoomBindAppUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(193990);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/ChatRoomBindAppUI$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      paramView = (c)g.af(c.class);
      localObject = (Context)this.gtE;
      c.b localb = ChatRoomBindAppUI.a(this.gtE);
      if (localb == null) {
        p.hyc();
      }
      paramView.b((Context)localObject, localb, (c.a)new c.a()
      {
        public final void a(boolean paramAnonymousBoolean, final String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(193989);
          if (paramAnonymousBoolean)
          {
            u.cG((Context)this.gtF.gtE.getContext(), this.gtF.gtE.getContext().getString(2131757231));
            paramAnonymousString1 = new Intent();
            paramAnonymousString1.putExtra("key_chat_room_open_id", paramAnonymousString2);
            h.RTc.n((Runnable)new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(193988);
                this.gtG.gtF.gtE.setResult(-1, paramAnonymousString1);
                this.gtG.gtF.gtE.finish();
                AppMethodBeat.o(193988);
              }
            }, 500L);
          }
          AppMethodBeat.o(193989);
        }
      });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ChatRoomBindAppUI$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(193990);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatRoomBindAppUI
 * JD-Core Version:    0.7.0.1
 */
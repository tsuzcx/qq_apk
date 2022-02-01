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
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.c.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import d.g.b.p;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/chatroom/ui/ChatRoomBindAppUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "bindButton", "Landroid/widget/Button;", "openParam", "Lcom/tencent/mm/plugin/messenger/foundation/api/IChatRoomOpenService$ChatRoomOpenParam;", "getLayoutId", "", "initViews", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "ui-chatroom_release"})
public final class ChatRoomBindAppUI
  extends MMActivity
{
  public static final a fMl;
  private Button fMj;
  private c.b fMk;
  
  static
  {
    AppMethodBeat.i(213625);
    fMl = new a((byte)0);
    AppMethodBeat.o(213625);
  }
  
  public final int getLayoutId()
  {
    return 2131496437;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    TextView localTextView = null;
    AppMethodBeat.i(213624);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131101179));
    paramBundle = getIntent();
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getSerializableExtra("key_bind_param");; paramBundle = null)
    {
      localObject1 = paramBundle;
      if (!(paramBundle instanceof c.b)) {
        localObject1 = null;
      }
      this.fMk = ((c.b)localObject1);
      if (this.fMk != null) {
        break;
      }
      ad.e("MicroMsg.ChatRoomBindAppUI", "openParam is null");
      finish();
      AppMethodBeat.o(213624);
      return;
    }
    setMMTitle("");
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this), 2131689492);
    paramBundle = findViewById(2131308233);
    p.g(paramBundle, "findViewById(R.id.btn_bind)");
    this.fMj = ((Button)paramBundle);
    paramBundle = this.fMj;
    if (paramBundle == null) {
      p.bcb("bindButton");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new c(this));
    paramBundle = findViewById(2131308456);
    p.g(paramBundle, "findViewById(R.id.tv_bind_app_title)");
    Object localObject2 = (TextView)paramBundle;
    Object localObject3 = aj.getContext();
    paramBundle = this.fMk;
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
    ((TextView)localObject2).setText((CharSequence)((Context)localObject3).getString(2131764274, new Object[] { paramBundle }));
    paramBundle = g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class);
    p.g(paramBundle, "MMKernel.service(IMessengerStorage::class.java)");
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramBundle).azp();
    paramBundle = this.fMk;
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.vJR;; paramBundle = null)
    {
      localObject1 = ((bp)localObject1).Bf(paramBundle);
      if (localObject1 != null) {
        break;
      }
      ad.e("MicroMsg.ChatRoomBindAppUI", "contact is null");
      finish();
      AppMethodBeat.o(213624);
      return;
    }
    paramBundle = findViewById(2131301204);
    p.g(paramBundle, "findViewById(R.id.iv_avatar)");
    localObject2 = (ImageView)paramBundle;
    localObject3 = this.fMk;
    paramBundle = localTextView;
    if (localObject3 != null) {
      paramBundle = ((c.b)localObject3).vJR;
    }
    a.b.c((ImageView)localObject2, paramBundle);
    paramBundle = findViewById(2131308460);
    p.g(paramBundle, "findViewById(R.id.tv_group_nickname)");
    ((TextView)paramBundle).setText((CharSequence)k.b((Context)getContext(), (CharSequence)v.zf(((am)localObject1).getUsername()), com.tencent.mm.cc.a.ax((Context)getContext(), 2131165517)));
    paramBundle = findViewById(2131308457);
    p.g(paramBundle, "findViewById(R.id.tv_bind_desc)");
    localTextView = (TextView)paramBundle;
    localObject2 = aj.getContext();
    paramBundle = this.fMk;
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
    localTextView.setText((CharSequence)((Context)localObject2).getString(2131766515, new Object[] { paramBundle }));
    AppMethodBeat.o(213624);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/chatroom/ui/ChatRoomBindAppUI$Companion;", "", "()V", "KEY_BIND_PARAM", "", "TAG", "ui-chatroom_release"})
  public static final class a {}
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(ChatRoomBindAppUI paramChatRoomBindAppUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(213620);
      this.fMm.finish();
      AppMethodBeat.o(213620);
      return true;
    }
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(ChatRoomBindAppUI paramChatRoomBindAppUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(213623);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/ChatRoomBindAppUI$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
      paramView = (c)g.ab(c.class);
      localObject = (Context)this.fMm;
      c.b localb = ChatRoomBindAppUI.a(this.fMm);
      if (localb == null) {
        p.gfZ();
      }
      paramView.b((Context)localObject, localb, (c.a)new c.a()
      {
        public final void a(boolean paramAnonymousBoolean, final String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(213622);
          if (paramAnonymousBoolean)
          {
            t.cm((Context)this.fMn.fMm.getContext(), this.fMn.fMm.getContext().getString(2131766518));
            paramAnonymousString1 = new Intent();
            paramAnonymousString1.putExtra("key_chat_room_open_id", paramAnonymousString2);
            h.LTJ.q((Runnable)new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(213621);
                this.fMo.fMn.fMm.setResult(-1, paramAnonymousString1);
                this.fMo.fMn.fMm.finish();
                AppMethodBeat.o(213621);
              }
            }, 500L);
          }
          AppMethodBeat.o(213622);
        }
      });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ChatRoomBindAppUI$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(213623);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatRoomBindAppUI
 * JD-Core Version:    0.7.0.1
 */
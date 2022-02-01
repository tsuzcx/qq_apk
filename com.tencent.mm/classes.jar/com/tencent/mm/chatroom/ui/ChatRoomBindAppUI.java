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
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.messenger.foundation.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.c.a;
import com.tencent.mm.plugin.messenger.foundation.a.c.b;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import d.g.b.p;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/chatroom/ui/ChatRoomBindAppUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "bindButton", "Landroid/widget/Button;", "openParam", "Lcom/tencent/mm/plugin/messenger/foundation/api/IChatRoomOpenService$ChatRoomOpenParam;", "getLayoutId", "", "initViews", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "ui-chatroom_release"})
public final class ChatRoomBindAppUI
  extends MMActivity
{
  public static final a fOt;
  private Button fOr;
  private c.b fOs;
  
  static
  {
    AppMethodBeat.i(217343);
    fOt = new a((byte)0);
    AppMethodBeat.o(217343);
  }
  
  public final int getLayoutId()
  {
    return 2131496437;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    TextView localTextView = null;
    AppMethodBeat.i(217342);
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
      this.fOs = ((c.b)localObject1);
      if (this.fOs != null) {
        break;
      }
      ae.e("MicroMsg.ChatRoomBindAppUI", "openParam is null");
      finish();
      AppMethodBeat.o(217342);
      return;
    }
    setMMTitle("");
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this), 2131689492);
    paramBundle = findViewById(2131308233);
    p.g(paramBundle, "findViewById(R.id.btn_bind)");
    this.fOr = ((Button)paramBundle);
    paramBundle = this.fOr;
    if (paramBundle == null) {
      p.bdF("bindButton");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new c(this));
    paramBundle = findViewById(2131308456);
    p.g(paramBundle, "findViewById(R.id.tv_bind_app_title)");
    Object localObject2 = (TextView)paramBundle;
    Object localObject3 = ak.getContext();
    paramBundle = this.fOs;
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
    Object localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)paramBundle).azF();
    paramBundle = this.fOs;
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.vVV;; paramBundle = null)
    {
      localObject1 = ((bq)localObject1).BH(paramBundle);
      if (localObject1 != null) {
        break;
      }
      ae.e("MicroMsg.ChatRoomBindAppUI", "contact is null");
      finish();
      AppMethodBeat.o(217342);
      return;
    }
    paramBundle = findViewById(2131301204);
    p.g(paramBundle, "findViewById(R.id.iv_avatar)");
    localObject2 = (ImageView)paramBundle;
    localObject3 = this.fOs;
    paramBundle = localTextView;
    if (localObject3 != null) {
      paramBundle = ((c.b)localObject3).vVV;
    }
    a.b.c((ImageView)localObject2, paramBundle);
    paramBundle = findViewById(2131308460);
    p.g(paramBundle, "findViewById(R.id.tv_group_nickname)");
    ((TextView)paramBundle).setText((CharSequence)k.b((Context)getContext(), (CharSequence)w.zP(((an)localObject1).getUsername()), com.tencent.mm.cb.a.ax((Context)getContext(), 2131165517)));
    paramBundle = findViewById(2131308457);
    p.g(paramBundle, "findViewById(R.id.tv_bind_desc)");
    localTextView = (TextView)paramBundle;
    localObject2 = ak.getContext();
    paramBundle = this.fOs;
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
    AppMethodBeat.o(217342);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/chatroom/ui/ChatRoomBindAppUI$Companion;", "", "()V", "KEY_BIND_PARAM", "", "TAG", "ui-chatroom_release"})
  public static final class a {}
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(ChatRoomBindAppUI paramChatRoomBindAppUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(217338);
      this.fOu.finish();
      AppMethodBeat.o(217338);
      return true;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(ChatRoomBindAppUI paramChatRoomBindAppUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(217341);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/ChatRoomBindAppUI$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
      paramView = (c)g.ab(c.class);
      localObject = (Context)this.fOu;
      c.b localb = ChatRoomBindAppUI.a(this.fOu);
      if (localb == null) {
        p.gkB();
      }
      paramView.b((Context)localObject, localb, (c.a)new c.a()
      {
        public final void a(boolean paramAnonymousBoolean, final String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(217340);
          if (paramAnonymousBoolean)
          {
            t.cn((Context)this.fOv.fOu.getContext(), this.fOv.fOu.getContext().getString(2131766518));
            paramAnonymousString1 = new Intent();
            paramAnonymousString1.putExtra("key_chat_room_open_id", paramAnonymousString2);
            h.MqF.q((Runnable)new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(217339);
                this.fOw.fOv.fOu.setResult(-1, paramAnonymousString1);
                this.fOw.fOv.fOu.finish();
                AppMethodBeat.o(217339);
              }
            }, 500L);
          }
          AppMethodBeat.o(217340);
        }
      });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ChatRoomBindAppUI$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(217341);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatRoomBindAppUI
 * JD-Core Version:    0.7.0.1
 */
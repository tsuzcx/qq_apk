package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.aa;
import com.tencent.mm.plugin.messenger.foundation.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.e.a;
import com.tencent.mm.plugin.messenger.foundation.a.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.w;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/chatroom/ui/ChatRoomBindAppUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "bindButton", "Landroid/widget/Button;", "openParam", "Lcom/tencent/mm/plugin/messenger/foundation/api/IChatRoomOpenService$ChatRoomOpenParam;", "getLayoutId", "", "initViews", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "ui-chatroom_release"})
public final class ChatRoomBindAppUI
  extends MMActivity
{
  public static final a iXP;
  private Button iXN;
  private e.b iXO;
  
  static
  {
    AppMethodBeat.i(193839);
    iXP = new a((byte)0);
    AppMethodBeat.o(193839);
  }
  
  public final int getLayoutId()
  {
    return a.f.jdR;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    TextView localTextView = null;
    AppMethodBeat.i(193838);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(a.b.white));
    paramBundle = getIntent();
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.getSerializableExtra("key_bind_param");; paramBundle = null)
    {
      localObject1 = paramBundle;
      if (!(paramBundle instanceof e.b)) {
        localObject1 = null;
      }
      this.iXO = ((e.b)localObject1);
      if (this.iXO != null) {
        break;
      }
      Log.e("MicroMsg.ChatRoomBindAppUI", "openParam is null");
      finish();
      AppMethodBeat.o(193838);
      return;
    }
    setMMTitle("");
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this), a.h.actionbar_icon_dark_close);
    paramBundle = findViewById(a.e.jcm);
    p.j(paramBundle, "findViewById(R.id.btn_bind)");
    this.iXN = ((Button)paramBundle);
    paramBundle = this.iXN;
    if (paramBundle == null) {
      p.bGy("bindButton");
    }
    paramBundle.setOnClickListener((View.OnClickListener)new c(this));
    paramBundle = findViewById(a.e.jdB);
    p.j(paramBundle, "findViewById(R.id.tv_bind_app_title)");
    Object localObject2 = (TextView)paramBundle;
    Object localObject3 = MMApplicationContext.getContext();
    int i = a.i.jeJ;
    paramBundle = this.iXO;
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
    ((TextView)localObject2).setText((CharSequence)((Context)localObject3).getString(i, new Object[] { paramBundle }));
    paramBundle = com.tencent.mm.kernel.h.ae(n.class);
    p.j(paramBundle, "MMKernel.service(IMessengerStorage::class.java)");
    Object localObject1 = ((n)paramBundle).bbL();
    paramBundle = this.iXO;
    if (paramBundle != null) {}
    for (paramBundle = paramBundle.EVz;; paramBundle = null)
    {
      localObject1 = ((bv)localObject1).RG(paramBundle);
      if (localObject1 != null) {
        break;
      }
      Log.e("MicroMsg.ChatRoomBindAppUI", "contact is null");
      finish();
      AppMethodBeat.o(193838);
      return;
    }
    paramBundle = findViewById(a.e.dKq);
    p.j(paramBundle, "findViewById(R.id.iv_avatar)");
    localObject2 = (ImageView)paramBundle;
    localObject3 = this.iXO;
    paramBundle = localTextView;
    if (localObject3 != null) {
      paramBundle = ((e.b)localObject3).EVz;
    }
    com.tencent.mm.pluginsdk.ui.a.b.c((ImageView)localObject2, paramBundle);
    paramBundle = findViewById(a.e.jdF);
    p.j(paramBundle, "findViewById(R.id.tv_group_nickname)");
    ((TextView)paramBundle).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.d((Context)getContext(), (CharSequence)aa.PJ(((as)localObject1).getUsername()), com.tencent.mm.ci.a.aY((Context)getContext(), a.c.NormalTextSize)));
    paramBundle = findViewById(a.e.jdC);
    p.j(paramBundle, "findViewById(R.id.tv_bind_desc)");
    localTextView = (TextView)paramBundle;
    localObject2 = MMApplicationContext.getContext();
    i = a.i.jeK;
    paramBundle = this.iXO;
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
    localTextView.setText((CharSequence)((Context)localObject2).getString(i, new Object[] { paramBundle }));
    AppMethodBeat.o(193838);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/chatroom/ui/ChatRoomBindAppUI$Companion;", "", "()V", "KEY_BIND_PARAM", "", "TAG", "ui-chatroom_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(ChatRoomBindAppUI paramChatRoomBindAppUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(187396);
      this.iXQ.finish();
      AppMethodBeat.o(187396);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(ChatRoomBindAppUI paramChatRoomBindAppUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(190768);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/ChatRoomBindAppUI$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      paramView = (e)com.tencent.mm.kernel.h.ae(e.class);
      localObject = (Context)this.iXQ;
      e.b localb = ChatRoomBindAppUI.a(this.iXQ);
      if (localb == null) {
        p.iCn();
      }
      paramView.b((Context)localObject, localb, (e.a)new e.a()
      {
        public final void a(boolean paramAnonymousBoolean, final String paramAnonymousString1, String paramAnonymousString2)
        {
          AppMethodBeat.i(186270);
          if (paramAnonymousBoolean)
          {
            w.cR((Context)this.iXR.iXQ.getContext(), this.iXR.iXQ.getContext().getString(a.i.jeM));
            paramAnonymousString1 = new Intent();
            paramAnonymousString1.putExtra("key_chat_room_open_id", paramAnonymousString2);
            com.tencent.e.h.ZvG.n((Runnable)new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(187120);
                this.iXS.iXR.iXQ.setResult(-1, paramAnonymousString1);
                this.iXS.iXR.iXQ.finish();
                AppMethodBeat.o(187120);
              }
            }, 500L);
          }
          AppMethodBeat.o(186270);
        }
      });
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/ChatRoomBindAppUI$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(190768);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatRoomBindAppUI
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.messenger.foundation.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/chatroom/ui/ChatRoomBindAppUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "bindButton", "Landroid/widget/Button;", "openParam", "Lcom/tencent/mm/plugin/messenger/foundation/api/IChatRoomOpenService$ChatRoomOpenParam;", "getLayoutId", "", "initViews", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "ui-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ChatRoomBindAppUI
  extends MMActivity
{
  public static final ChatRoomBindAppUI.a lzJ;
  private Button lzK;
  private e.b lzL;
  
  static
  {
    AppMethodBeat.i(241710);
    lzJ = new ChatRoomBindAppUI.a((byte)0);
    AppMethodBeat.o(241710);
  }
  
  private static final void a(ChatRoomBindAppUI paramChatRoomBindAppUI, Intent paramIntent)
  {
    AppMethodBeat.i(241695);
    s.u(paramChatRoomBindAppUI, "this$0");
    s.u(paramIntent, "$intent");
    paramChatRoomBindAppUI.setResult(-1, paramIntent);
    paramChatRoomBindAppUI.finish();
    AppMethodBeat.o(241695);
  }
  
  private static final void a(ChatRoomBindAppUI paramChatRoomBindAppUI, View paramView)
  {
    AppMethodBeat.i(241705);
    Object localObject1 = new Object();
    Object localObject2 = new b();
    ((b)localObject2).cH(paramChatRoomBindAppUI);
    ((b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/ChatRoomBindAppUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((b)localObject2).aYj());
    s.u(paramChatRoomBindAppUI, "this$0");
    paramView = (e)com.tencent.mm.kernel.h.ax(e.class);
    localObject1 = (Context)paramChatRoomBindAppUI;
    localObject2 = paramChatRoomBindAppUI.lzL;
    s.checkNotNull(localObject2);
    paramView.b((Context)localObject1, (e.b)localObject2, new ChatRoomBindAppUI..ExternalSyntheticLambda2(paramChatRoomBindAppUI));
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/chatroom/ui/ChatRoomBindAppUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(241705);
  }
  
  private static final void a(ChatRoomBindAppUI paramChatRoomBindAppUI, boolean paramBoolean, String paramString1, String paramString2)
  {
    AppMethodBeat.i(241701);
    s.u(paramChatRoomBindAppUI, "this$0");
    if (paramBoolean)
    {
      com.tencent.mm.ui.base.aa.db((Context)paramChatRoomBindAppUI.getContext(), paramChatRoomBindAppUI.getContext().getString(a.i.lGX));
      paramString1 = new Intent();
      paramString1.putExtra("key_chat_room_open_id", paramString2);
      com.tencent.threadpool.h.ahAA.o(new ChatRoomBindAppUI..ExternalSyntheticLambda3(paramChatRoomBindAppUI, paramString1), 500L);
    }
    AppMethodBeat.o(241701);
  }
  
  private static final boolean a(ChatRoomBindAppUI paramChatRoomBindAppUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(241691);
    s.u(paramChatRoomBindAppUI, "this$0");
    paramChatRoomBindAppUI.finish();
    AppMethodBeat.o(241691);
    return true;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return a.f.lFZ;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    String str = null;
    AppMethodBeat.i(241722);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(a.b.white));
    paramBundle = getIntent();
    if (paramBundle == null)
    {
      paramBundle = null;
      if (!(paramBundle instanceof e.b)) {
        break label88;
      }
    }
    label88:
    for (paramBundle = (e.b)paramBundle;; paramBundle = null)
    {
      this.lzL = paramBundle;
      if (this.lzL != null) {
        break label93;
      }
      Log.e("MicroMsg.ChatRoomBindAppUI", "openParam is null");
      finish();
      AppMethodBeat.o(241722);
      return;
      paramBundle = paramBundle.getSerializableExtra("key_bind_param");
      break;
    }
    label93:
    setMMTitle("");
    setBackBtn(new ChatRoomBindAppUI..ExternalSyntheticLambda0(this), a.h.actionbar_icon_dark_close);
    paramBundle = findViewById(a.e.lEm);
    s.s(paramBundle, "findViewById(R.id.btn_bind)");
    this.lzK = ((Button)paramBundle);
    Object localObject1 = this.lzK;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null)
    {
      s.bIx("bindButton");
      paramBundle = null;
    }
    paramBundle.setOnClickListener(new ChatRoomBindAppUI..ExternalSyntheticLambda1(this));
    paramBundle = findViewById(a.e.lFJ);
    s.s(paramBundle, "findViewById(R.id.tv_bind_app_title)");
    Object localObject2 = (TextView)paramBundle;
    Context localContext = MMApplicationContext.getContext();
    int i = a.i.lGU;
    paramBundle = this.lzL;
    if (paramBundle == null)
    {
      paramBundle = "";
      ((TextView)localObject2).setText((CharSequence)localContext.getString(i, new Object[] { paramBundle }));
      localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA();
      paramBundle = this.lzL;
      if (paramBundle != null) {
        break label315;
      }
    }
    label315:
    for (paramBundle = null;; paramBundle = paramBundle.KRa)
    {
      localObject1 = ((bx)localObject1).JE(paramBundle);
      if (localObject1 != null) {
        break label323;
      }
      Log.e("MicroMsg.ChatRoomBindAppUI", "contact is null");
      finish();
      AppMethodBeat.o(241722);
      return;
      localObject1 = paramBundle.appName;
      paramBundle = (Bundle)localObject1;
      if (localObject1 != null) {
        break;
      }
      paramBundle = "";
      break;
    }
    label323:
    paramBundle = findViewById(a.e.fLL);
    s.s(paramBundle, "findViewById(R.id.iv_avatar)");
    localObject2 = (ImageView)paramBundle;
    paramBundle = this.lzL;
    if (paramBundle == null)
    {
      paramBundle = str;
      com.tencent.mm.pluginsdk.ui.a.b.g((ImageView)localObject2, paramBundle);
      paramBundle = findViewById(a.e.lFN);
      s.s(paramBundle, "findViewById(R.id.tv_group_nickname)");
      ((TextView)paramBundle).setText((CharSequence)p.d((Context)getContext(), (CharSequence)com.tencent.mm.model.aa.getDisplayName(((az)localObject1).field_username), com.tencent.mm.cd.a.br((Context)getContext(), a.c.NormalTextSize)));
      paramBundle = findViewById(a.e.lFK);
      s.s(paramBundle, "findViewById(R.id.tv_bind_desc)");
      localObject1 = (TextView)paramBundle;
      localObject2 = MMApplicationContext.getContext();
      i = a.i.lGV;
      paramBundle = this.lzL;
      if (paramBundle != null) {
        break label498;
      }
      paramBundle = "";
    }
    for (;;)
    {
      ((TextView)localObject1).setText((CharSequence)((Context)localObject2).getString(i, new Object[] { paramBundle }));
      AppMethodBeat.o(241722);
      return;
      paramBundle = paramBundle.KRa;
      break;
      label498:
      str = paramBundle.appName;
      paramBundle = str;
      if (str == null) {
        paramBundle = "";
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatRoomBindAppUI
 * JD-Core Version:    0.7.0.1
 */
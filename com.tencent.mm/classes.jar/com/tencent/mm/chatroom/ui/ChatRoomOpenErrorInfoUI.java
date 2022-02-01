package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.MMActivity;
import d.g.b.p;
import d.l;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/chatroom/ui/ChatRoomOpenErrorInfoUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "contentTextView", "Landroid/widget/TextView;", "titleTextView", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupView", "Companion", "ui-chatroom_release"})
public final class ChatRoomOpenErrorInfoUI
  extends MMActivity
{
  public static final a fMs;
  private TextView fMq;
  private TextView fMr;
  
  static
  {
    AppMethodBeat.i(213629);
    fMs = new a((byte)0);
    AppMethodBeat.o(213629);
  }
  
  public final int getLayoutId()
  {
    return 2131496438;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(213628);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131101179));
    setMMTitle("");
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    paramBundle = findViewById(2131308459);
    p.g(paramBundle, "findViewById(R.id.tv_error_title)");
    this.fMq = ((TextView)paramBundle);
    paramBundle = findViewById(2131308458);
    p.g(paramBundle, "findViewById(R.id.tv_error_content)");
    this.fMr = ((TextView)paramBundle);
    findViewById(2131308234).setOnClickListener((View.OnClickListener)new c(this));
    Object localObject1 = getIntent().getStringExtra("key_error_title");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    Object localObject2 = getIntent().getStringExtra("key_error_content");
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject2 = this.fMq;
    if (localObject2 == null) {
      p.bcb("titleTextView");
    }
    ((TextView)localObject2).setText((CharSequence)paramBundle);
    paramBundle = this.fMr;
    if (paramBundle == null) {
      p.bcb("contentTextView");
    }
    paramBundle.setText((CharSequence)localObject1);
    AppMethodBeat.o(213628);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/chatroom/ui/ChatRoomOpenErrorInfoUI$Companion;", "", "()V", "KEY_ERROR_CONTENT", "", "KEY_ERROR_TITLE", "TAG", "ui-chatroom_release"})
  public static final class a {}
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(ChatRoomOpenErrorInfoUI paramChatRoomOpenErrorInfoUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(213626);
      this.fMt.finish();
      AppMethodBeat.o(213626);
      return false;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(ChatRoomOpenErrorInfoUI paramChatRoomOpenErrorInfoUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(213627);
      b localb = new b();
      localb.bd(paramView);
      a.b("com/tencent/mm/chatroom/ui/ChatRoomOpenErrorInfoUI$setupView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.fMt.finish();
      a.a(this, "com/tencent/mm/chatroom/ui/ChatRoomOpenErrorInfoUI$setupView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(213627);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatRoomOpenErrorInfoUI
 * JD-Core Version:    0.7.0.1
 */
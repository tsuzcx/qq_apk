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

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/chatroom/ui/ChatRoomOpenErrorInfoUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "contentTextView", "Landroid/widget/TextView;", "titleTextView", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupView", "Companion", "ui-chatroom_release"})
public final class ChatRoomOpenErrorInfoUI
  extends MMActivity
{
  public static final a fOA;
  private TextView fOy;
  private TextView fOz;
  
  static
  {
    AppMethodBeat.i(217347);
    fOA = new a((byte)0);
    AppMethodBeat.o(217347);
  }
  
  public final int getLayoutId()
  {
    return 2131496438;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(217346);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131101179));
    setMMTitle("");
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    paramBundle = findViewById(2131308459);
    p.g(paramBundle, "findViewById(R.id.tv_error_title)");
    this.fOy = ((TextView)paramBundle);
    paramBundle = findViewById(2131308458);
    p.g(paramBundle, "findViewById(R.id.tv_error_content)");
    this.fOz = ((TextView)paramBundle);
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
    localObject2 = this.fOy;
    if (localObject2 == null) {
      p.bdF("titleTextView");
    }
    ((TextView)localObject2).setText((CharSequence)paramBundle);
    paramBundle = this.fOz;
    if (paramBundle == null) {
      p.bdF("contentTextView");
    }
    paramBundle.setText((CharSequence)localObject1);
    AppMethodBeat.o(217346);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/chatroom/ui/ChatRoomOpenErrorInfoUI$Companion;", "", "()V", "KEY_ERROR_CONTENT", "", "KEY_ERROR_TITLE", "TAG", "ui-chatroom_release"})
  public static final class a {}
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(ChatRoomOpenErrorInfoUI paramChatRoomOpenErrorInfoUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(217344);
      this.fOB.finish();
      AppMethodBeat.o(217344);
      return false;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(ChatRoomOpenErrorInfoUI paramChatRoomOpenErrorInfoUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(217345);
      b localb = new b();
      localb.bd(paramView);
      a.b("com/tencent/mm/chatroom/ui/ChatRoomOpenErrorInfoUI$setupView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.fOB.finish();
      a.a(this, "com/tencent/mm/chatroom/ui/ChatRoomOpenErrorInfoUI$setupView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(217345);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatRoomOpenErrorInfoUI
 * JD-Core Version:    0.7.0.1
 */
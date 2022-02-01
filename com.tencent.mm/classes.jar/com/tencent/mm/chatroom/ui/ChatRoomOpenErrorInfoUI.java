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
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/chatroom/ui/ChatRoomOpenErrorInfoUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "contentTextView", "Landroid/widget/TextView;", "titleTextView", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupView", "Companion", "ui-chatroom_release"})
public final class ChatRoomOpenErrorInfoUI
  extends MMActivity
{
  public static final a iXV;
  private TextView iXT;
  private TextView iXU;
  
  static
  {
    AppMethodBeat.i(189334);
    iXV = new a((byte)0);
    AppMethodBeat.o(189334);
  }
  
  public final int getLayoutId()
  {
    return a.f.jdX;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(189331);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(a.b.white));
    setMMTitle("");
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    paramBundle = findViewById(a.e.jdE);
    p.j(paramBundle, "findViewById(R.id.tv_error_title)");
    this.iXT = ((TextView)paramBundle);
    paramBundle = findViewById(a.e.jdD);
    p.j(paramBundle, "findViewById(R.id.tv_error_content)");
    this.iXU = ((TextView)paramBundle);
    findViewById(a.e.btn_ok).setOnClickListener((View.OnClickListener)new c(this));
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
    localObject2 = this.iXT;
    if (localObject2 == null) {
      p.bGy("titleTextView");
    }
    ((TextView)localObject2).setText((CharSequence)paramBundle);
    paramBundle = this.iXU;
    if (paramBundle == null) {
      p.bGy("contentTextView");
    }
    paramBundle.setText((CharSequence)localObject1);
    AppMethodBeat.o(189331);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/chatroom/ui/ChatRoomOpenErrorInfoUI$Companion;", "", "()V", "KEY_ERROR_CONTENT", "", "KEY_ERROR_TITLE", "TAG", "ui-chatroom_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(ChatRoomOpenErrorInfoUI paramChatRoomOpenErrorInfoUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(186952);
      this.iXW.finish();
      AppMethodBeat.o(186952);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(ChatRoomOpenErrorInfoUI paramChatRoomOpenErrorInfoUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(187798);
      b localb = new b();
      localb.bn(paramView);
      a.c("com/tencent/mm/chatroom/ui/ChatRoomOpenErrorInfoUI$setupView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.iXW.finish();
      a.a(this, "com/tencent/mm/chatroom/ui/ChatRoomOpenErrorInfoUI$setupView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(187798);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatRoomOpenErrorInfoUI
 * JD-Core Version:    0.7.0.1
 */
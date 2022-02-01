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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/chatroom/ui/ChatRoomOpenErrorInfoUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "contentTextView", "Landroid/widget/TextView;", "titleTextView", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupView", "Companion", "ui-chatroom_release"})
public final class ChatRoomOpenErrorInfoUI
  extends MMActivity
{
  public static final a gtK;
  private TextView gtI;
  private TextView gtJ;
  
  static
  {
    AppMethodBeat.i(193996);
    gtK = new a((byte)0);
    AppMethodBeat.o(193996);
  }
  
  public final int getLayoutId()
  {
    return 2131493471;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(193995);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131101424));
    setMMTitle("");
    setBackBtn((MenuItem.OnMenuItemClickListener)new b(this));
    paramBundle = findViewById(2131309481);
    p.g(paramBundle, "findViewById(R.id.tv_error_title)");
    this.gtI = ((TextView)paramBundle);
    paramBundle = findViewById(2131309480);
    p.g(paramBundle, "findViewById(R.id.tv_error_content)");
    this.gtJ = ((TextView)paramBundle);
    findViewById(2131297842).setOnClickListener((View.OnClickListener)new c(this));
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
    localObject2 = this.gtI;
    if (localObject2 == null) {
      p.btv("titleTextView");
    }
    ((TextView)localObject2).setText((CharSequence)paramBundle);
    paramBundle = this.gtJ;
    if (paramBundle == null) {
      p.btv("contentTextView");
    }
    paramBundle.setText((CharSequence)localObject1);
    AppMethodBeat.o(193995);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/chatroom/ui/ChatRoomOpenErrorInfoUI$Companion;", "", "()V", "KEY_ERROR_CONTENT", "", "KEY_ERROR_TITLE", "TAG", "ui-chatroom_release"})
  public static final class a {}
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class b
    implements MenuItem.OnMenuItemClickListener
  {
    b(ChatRoomOpenErrorInfoUI paramChatRoomOpenErrorInfoUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(193993);
      this.gtL.finish();
      AppMethodBeat.o(193993);
      return false;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(ChatRoomOpenErrorInfoUI paramChatRoomOpenErrorInfoUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(193994);
      b localb = new b();
      localb.bm(paramView);
      a.b("com/tencent/mm/chatroom/ui/ChatRoomOpenErrorInfoUI$setupView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.gtL.finish();
      a.a(this, "com/tencent/mm/chatroom/ui/ChatRoomOpenErrorInfoUI$setupView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(193994);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatRoomOpenErrorInfoUI
 * JD-Core Version:    0.7.0.1
 */
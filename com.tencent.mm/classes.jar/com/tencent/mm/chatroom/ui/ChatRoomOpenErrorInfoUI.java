package com.tencent.mm.chatroom.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/chatroom/ui/ChatRoomOpenErrorInfoUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "contentTextView", "Landroid/widget/TextView;", "titleTextView", "getLayoutId", "", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupView", "Companion", "ui-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ChatRoomOpenErrorInfoUI
  extends MMActivity
{
  public static final ChatRoomOpenErrorInfoUI.a lzM;
  private TextView lzN;
  private TextView lzO;
  
  static
  {
    AppMethodBeat.i(241702);
    lzM = new ChatRoomOpenErrorInfoUI.a((byte)0);
    AppMethodBeat.o(241702);
  }
  
  private static final void a(ChatRoomOpenErrorInfoUI paramChatRoomOpenErrorInfoUI, View paramView)
  {
    AppMethodBeat.i(241698);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramChatRoomOpenErrorInfoUI);
    localb.cH(paramView);
    a.c("com/tencent/mm/chatroom/ui/ChatRoomOpenErrorInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramChatRoomOpenErrorInfoUI, "this$0");
    paramChatRoomOpenErrorInfoUI.finish();
    a.a(new Object(), "com/tencent/mm/chatroom/ui/ChatRoomOpenErrorInfoUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(241698);
  }
  
  private static final boolean a(ChatRoomOpenErrorInfoUI paramChatRoomOpenErrorInfoUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(241694);
    s.u(paramChatRoomOpenErrorInfoUI, "this$0");
    paramChatRoomOpenErrorInfoUI.finish();
    AppMethodBeat.o(241694);
    return false;
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return a.f.lGg;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    Object localObject3 = null;
    AppMethodBeat.i(241709);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(a.b.white));
    setMMTitle("");
    setBackBtn(new ChatRoomOpenErrorInfoUI..ExternalSyntheticLambda0(this));
    paramBundle = findViewById(a.e.lFM);
    s.s(paramBundle, "findViewById(R.id.tv_error_title)");
    this.lzN = ((TextView)paramBundle);
    paramBundle = findViewById(a.e.lFL);
    s.s(paramBundle, "findViewById(R.id.tv_error_content)");
    this.lzO = ((TextView)paramBundle);
    findViewById(a.e.btn_ok).setOnClickListener(new ChatRoomOpenErrorInfoUI..ExternalSyntheticLambda1(this));
    paramBundle = getIntent().getStringExtra("key_error_title");
    Object localObject1 = paramBundle;
    if (paramBundle == null) {
      localObject1 = "";
    }
    Object localObject2 = getIntent().getStringExtra("key_error_content");
    paramBundle = (Bundle)localObject2;
    if (localObject2 == null) {
      paramBundle = "";
    }
    TextView localTextView = this.lzN;
    localObject2 = localTextView;
    if (localTextView == null)
    {
      s.bIx("titleTextView");
      localObject2 = null;
    }
    ((TextView)localObject2).setText((CharSequence)localObject1);
    localObject1 = this.lzO;
    if (localObject1 == null)
    {
      s.bIx("contentTextView");
      localObject1 = localObject3;
    }
    for (;;)
    {
      ((TextView)localObject1).setText((CharSequence)paramBundle);
      AppMethodBeat.o(241709);
      return;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ChatRoomOpenErrorInfoUI
 * JD-Core Version:    0.7.0.1
 */
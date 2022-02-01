package com.tencent.mm.chatroom.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.protocal.protobuf.dzn;
import com.tencent.mm.ui.widget.a.g;

final class ManageChatroomUI$4
  implements View.OnClickListener
{
  ManageChatroomUI$4(ManageChatroomUI paramManageChatroomUI, dzn paramdzn) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(191049);
    b localb = new b();
    localb.bn(paramView);
    a.c("com/tencent/mm/chatroom/ui/ManageChatroomUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    ManageChatroomUI.b(this.jaN).bYF();
    ManageChatroomUI.a(this.jaN, this.jaO);
    a.a(this, "com/tencent/mm/chatroom/ui/ManageChatroomUI$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(191049);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.ManageChatroomUI.4
 * JD-Core Version:    0.7.0.1
 */
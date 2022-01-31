package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.br.d;
import com.tencent.mm.storage.q;

final class a$11
  implements View.OnClickListener
{
  a$11(a parama) {}
  
  public final void onClick(View paramView)
  {
    paramView = (q)paramView.getTag();
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramView.field_talker);
    localIntent.putExtra("finish_direct", true);
    localIntent.putExtra("KOpenArticleSceneFromScene", 90);
    localIntent.putExtra("specific_chat_from_scene", 2);
    d.e(a.a(this.ifl), ".ui.chatting.ChattingUI", localIntent);
    a.d(this.ifl).c(paramView, 9);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.11
 * JD-Core Version:    0.7.0.1
 */
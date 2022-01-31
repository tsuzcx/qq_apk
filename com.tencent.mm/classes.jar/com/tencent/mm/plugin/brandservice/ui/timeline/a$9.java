package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.storage.q;

final class a$9
  implements View.OnClickListener
{
  a$9(a parama) {}
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(14106);
    paramView = (q)paramView.getTag();
    Intent localIntent = new Intent();
    localIntent.putExtra("Chat_User", paramView.field_talker);
    localIntent.putExtra("finish_direct", true);
    localIntent.putExtra("KOpenArticleSceneFromScene", 90);
    localIntent.putExtra("specific_chat_from_scene", 2);
    localIntent.putExtra("preChatTYPE", 11);
    d.f(a.a(this.jVZ), ".ui.chatting.ChattingUI", localIntent);
    this.jVZ.jVS.d(paramView, 9);
    AppMethodBeat.o(14106);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.9
 * JD-Core Version:    0.7.0.1
 */
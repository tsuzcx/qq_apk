package com.tencent.mm.plugin.game.chatroom.ui;

import android.text.Editable;
import android.text.TextWatcher;
import androidx.lifecycle.af;
import androidx.lifecycle.ag;
import androidx.lifecycle.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.chatroom.l.b.i;
import kotlin.Metadata;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.n.n;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"com/tencent/mm/plugin/game/chatroom/ui/MentionSomeoneDialogUtil$initMentionSomeoneDialog$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a$a
  implements TextWatcher
{
  a$a(com.tencent.mm.plugin.game.chatroom.l.b paramb, b paramb1) {}
  
  public final void afterTextChanged(Editable paramEditable)
  {
    AppMethodBeat.i(276068);
    paramEditable = String.valueOf(paramEditable);
    if (paramEditable == null)
    {
      paramEditable = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(276068);
      throw paramEditable;
    }
    paramEditable = n.bq((CharSequence)paramEditable).toString();
    if (((CharSequence)paramEditable).length() == 0)
    {
      i = 1;
      if (i != 0) {
        break label146;
      }
      if (n.bp((CharSequence)paramEditable)) {
        break label141;
      }
    }
    Object localObject1;
    Object localObject2;
    label141:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label146;
      }
      localObject1 = this.InW;
      s.u(paramEditable, "keyword");
      localObject2 = ((com.tencent.mm.plugin.game.chatroom.l.b)localObject1).chatroomName;
      if (localObject2 != null) {
        j.a(ag.b((af)localObject1), ((com.tencent.mm.plugin.game.chatroom.l.b)localObject1).getCoroutineContext(), null, (m)new b.i((com.tencent.mm.plugin.game.chatroom.l.b)localObject1, paramEditable, (String)localObject2, null), 2);
      }
      AppMethodBeat.o(276068);
      return;
      i = 0;
      break;
    }
    label146:
    paramEditable = (com.tencent.mm.plugin.game.chatroom.d.b)this.InW.Isz.getValue();
    if (paramEditable != null)
    {
      localObject1 = this.InX;
      localObject2 = a.InV;
      a.a(paramEditable, (b)localObject1);
    }
    AppMethodBeat.o(276068);
  }
  
  public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.ui.a.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.game.ui.chat_tab;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.gamelife.ui.GameLifeConversationUI;

public class ChatTabTopArea
  extends LinearLayout
{
  GameHotMsgView IVA;
  
  public ChatTabTopArea(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(276662);
    init();
    AppMethodBeat.o(276662);
  }
  
  public ChatTabTopArea(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(276671);
    init();
    AppMethodBeat.o(276671);
  }
  
  public ChatTabTopArea(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(276681);
    init();
    AppMethodBeat.o(276681);
  }
  
  private void init()
  {
    AppMethodBeat.i(276689);
    LayoutInflater.from(getContext()).inflate(h.f.HYS, this);
    findViewById(h.e.HWZ).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(276656);
        Object localObject = new b();
        ((b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/chat_tab/ChatTabTopArea$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aYj());
        localObject = new Intent(ChatTabTopArea.this.getContext(), GameLifeConversationUI.class);
        paramAnonymousView = ChatTabTopArea.this.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/game/ui/chat_tab/ChatTabTopArea$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/game/ui/chat_tab/ChatTabTopArea$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/chat_tab/ChatTabTopArea$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(276656);
      }
    });
    this.IVA = ((GameHotMsgView)findViewById(h.e.HVz));
    AppMethodBeat.o(276689);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.ChatTabTopArea
 * JD-Core Version:    0.7.0.1
 */
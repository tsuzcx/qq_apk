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
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.plugin.game.g.f;
import com.tencent.mm.plugin.gamelife.ui.GameLifeConversationUI;

public class ChatTabTopArea
  extends LinearLayout
{
  GameHotMsgView Dbm;
  
  public ChatTabTopArea(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(189671);
    init();
    AppMethodBeat.o(189671);
  }
  
  public ChatTabTopArea(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(189673);
    init();
    AppMethodBeat.o(189673);
  }
  
  public ChatTabTopArea(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(189678);
    init();
    AppMethodBeat.o(189678);
  }
  
  private void init()
  {
    AppMethodBeat.i(189679);
    LayoutInflater.from(getContext()).inflate(g.f.CmK, this);
    findViewById(g.e.CkR).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(194146);
        Object localObject = new b();
        ((b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/chat_tab/ChatTabTopArea$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
        localObject = new Intent(ChatTabTopArea.this.getContext(), GameLifeConversationUI.class);
        paramAnonymousView = ChatTabTopArea.this.getContext();
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramAnonymousView, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/game/ui/chat_tab/ChatTabTopArea$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramAnonymousView.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramAnonymousView, "com/tencent/mm/plugin/game/ui/chat_tab/ChatTabTopArea$1", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/chat_tab/ChatTabTopArea$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(194146);
      }
    });
    this.Dbm = ((GameHotMsgView)findViewById(g.e.Cjr));
    AppMethodBeat.o(189679);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.chat_tab.ChatTabTopArea
 * JD-Core Version:    0.7.0.1
 */
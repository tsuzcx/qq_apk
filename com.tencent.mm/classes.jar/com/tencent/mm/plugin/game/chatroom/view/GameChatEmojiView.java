package com.tencent.mm.plugin.game.chatroom.view;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.emoji.RTChattingEmojiView;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/view/GameChatEmojiView;", "Lcom/tencent/mm/pluginsdk/ui/emoji/RTChattingEmojiView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class GameChatEmojiView
  extends RTChattingEmojiView
{
  public GameChatEmojiView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public GameChatEmojiView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(276335);
    initView();
    iNs();
    AppMethodBeat.o(276335);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.GameChatEmojiView
 * JD-Core Version:    0.7.0.1
 */
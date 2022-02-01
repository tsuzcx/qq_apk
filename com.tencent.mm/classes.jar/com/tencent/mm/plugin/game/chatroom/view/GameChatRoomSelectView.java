package com.tencent.mm.plugin.game.chatroom.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.autogen.chatroom.MyChatroomInfo;
import com.tencent.mm.plugin.game.chatroom.h.e;
import com.tencent.mm.plugin.game.chatroom.h.f;
import java.util.List;

public class GameChatRoomSelectView
  extends LinearLayout
{
  private ImageView IrO;
  private ChatRoomListCard IrP;
  private a IrQ;
  
  public GameChatRoomSelectView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(276192);
    initView();
    AppMethodBeat.o(276192);
  }
  
  public GameChatRoomSelectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(276201);
    initView();
    AppMethodBeat.o(276201);
  }
  
  public GameChatRoomSelectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(276206);
    initView();
    AppMethodBeat.o(276206);
  }
  
  private void initView()
  {
    AppMethodBeat.i(276215);
    LayoutInflater.from(getContext()).inflate(h.f.IhG, this);
    this.IrO = ((ImageView)findViewById(h.e.Igu));
    this.IrO.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(276166);
        b localb = new b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/game/chatroom/view/GameChatRoomSelectView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (GameChatRoomSelectView.a(GameChatRoomSelectView.this) != null) {
          GameChatRoomSelectView.a(GameChatRoomSelectView.this).bfj();
        }
        a.a(this, "com/tencent/mm/plugin/game/chatroom/view/GameChatRoomSelectView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(276166);
      }
    });
    this.IrP = ((ChatRoomListCard)findViewById(h.e.Ifd));
    AppMethodBeat.o(276215);
  }
  
  public void setData(List<MyChatroomInfo> paramList)
  {
    AppMethodBeat.i(276233);
    if (this.IrP != null) {
      this.IrP.setData(paramList);
    }
    AppMethodBeat.o(276233);
  }
  
  public void setOnCloseListener(a parama)
  {
    this.IrQ = parama;
  }
  
  public static abstract interface a
  {
    public abstract void bfj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.GameChatRoomSelectView
 * JD-Core Version:    0.7.0.1
 */
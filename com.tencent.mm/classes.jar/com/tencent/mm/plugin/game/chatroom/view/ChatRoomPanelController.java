package com.tencent.mm.plugin.game.chatroom.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.chatroom.h.e;
import com.tencent.mm.plugin.game.chatroom.h.f;
import com.tencent.mm.ui.base.MMDotView;
import com.tencent.mm.ui.base.MMFlipper;
import com.tencent.mm.ui.widget.a.j;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/view/ChatRoomPanelController;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mHalfDialog", "Lcom/tencent/mm/ui/widget/dialog/MMHalfBottomDialog;", "setDotView", "", "pageCount", "showPanelDialog", "panelInfo", "Lcom/tencent/mm/plugin/game/autogen/chatroom/ChatroomPanel;", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ChatRoomPanelController
  extends LinearLayout
{
  public j IjW;
  
  public ChatRoomPanelController(Context paramContext)
  {
    super(paramContext, null);
    AppMethodBeat.i(276302);
    LayoutInflater.from(getContext()).inflate(h.f.IhF, (ViewGroup)this);
    ((ImageView)findViewById(h.e.Ihw)).setOnClickListener(new ChatRoomPanelController..ExternalSyntheticLambda0(this));
    ((MMFlipper)findViewById(h.e.Ifp)).setOnScreenChangedListener(new ChatRoomPanelController..ExternalSyntheticLambda1(this));
    ((MMDotView)findViewById(h.e.Ifo)).setDarkStyle(true);
    AppMethodBeat.o(276302);
  }
  
  public ChatRoomPanelController(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(276310);
    LayoutInflater.from(getContext()).inflate(h.f.IhF, (ViewGroup)this);
    ((ImageView)findViewById(h.e.Ihw)).setOnClickListener(new ChatRoomPanelController..ExternalSyntheticLambda0(this));
    ((MMFlipper)findViewById(h.e.Ifp)).setOnScreenChangedListener(new ChatRoomPanelController..ExternalSyntheticLambda1(this));
    ((MMDotView)findViewById(h.e.Ifo)).setDarkStyle(true);
    AppMethodBeat.o(276310);
  }
  
  public ChatRoomPanelController(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(276317);
    LayoutInflater.from(getContext()).inflate(h.f.IhF, (ViewGroup)this);
    ((ImageView)findViewById(h.e.Ihw)).setOnClickListener(new ChatRoomPanelController..ExternalSyntheticLambda0(this));
    ((MMFlipper)findViewById(h.e.Ifp)).setOnScreenChangedListener(new ChatRoomPanelController..ExternalSyntheticLambda1(this));
    ((MMDotView)findViewById(h.e.Ifo)).setDarkStyle(true);
    AppMethodBeat.o(276317);
  }
  
  private static final void a(ChatRoomPanelController paramChatRoomPanelController, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    AppMethodBeat.i(276327);
    s.u(paramChatRoomPanelController, "this$0");
    ((MMDotView)paramChatRoomPanelController.findViewById(h.e.Ifo)).setSelectedDot(paramInt2);
    AppMethodBeat.o(276327);
  }
  
  private static final void a(ChatRoomPanelController paramChatRoomPanelController, View paramView)
  {
    AppMethodBeat.i(276323);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramChatRoomPanelController);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/game/chatroom/view/ChatRoomPanelController", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramChatRoomPanelController, "this$0");
    paramView = paramChatRoomPanelController.IjW;
    if (paramView != null) {
      paramView.cyW();
    }
    paramChatRoomPanelController.IjW = null;
    a.a(new Object(), "com/tencent/mm/plugin/game/chatroom/view/ChatRoomPanelController", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(276323);
  }
  
  public final void setDotView(int paramInt)
  {
    AppMethodBeat.i(276349);
    if (paramInt < 2)
    {
      ((MMDotView)findViewById(h.e.Ifo)).setVisibility(8);
      AppMethodBeat.o(276349);
      return;
    }
    ((MMDotView)findViewById(h.e.Ifo)).setVisibility(0);
    ((MMDotView)findViewById(h.e.Ifo)).setDotCount(paramInt);
    AppMethodBeat.o(276349);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.view.ChatRoomPanelController
 * JD-Core Version:    0.7.0.1
 */
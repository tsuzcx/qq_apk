package com.tencent.mm.live.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.live.b.e;
import com.tencent.mm.live.b.f;
import com.tencent.mm.live.core.mini.AbsLiveMiniView;
import com.tencent.mm.live.model.u;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/view/RoomLiveMiniView;", "Lcom/tencent/mm/live/core/mini/AbsLiveMiniView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "style", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "applyState", "", "state", "enableCloseBtn", "closeClickListener", "Lkotlin/Function0;", "floatScene", "releaseState", "setState", "updateCloseBtnVisible", "show", "", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class RoomLiveMiniView
  extends AbsLiveMiniView
{
  public RoomLiveMiniView(Context paramContext)
  {
    this(paramContext, null, 0);
    AppMethodBeat.i(246217);
    AppMethodBeat.o(246217);
  }
  
  public RoomLiveMiniView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(246224);
    AppMethodBeat.o(246224);
  }
  
  public RoomLiveMiniView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(246210);
    View.inflate(MMApplicationContext.getContext(), b.f.live_mini_view_ui, (ViewGroup)this);
    paramContext = u.mZl;
    setOnClickListener(u.biP());
    AppMethodBeat.o(246210);
  }
  
  private static final void a(kotlin.g.a.a parama, View paramView)
  {
    AppMethodBeat.i(246234);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parama);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/view/RoomLiveMiniView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    if (parama != null) {
      parama.invoke();
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/live/view/RoomLiveMiniView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(246234);
  }
  
  public final void R(kotlin.g.a.a<ah> parama)
  {
    AppMethodBeat.i(246266);
    findViewById(b.e.chatroom_live_mini_view_close_group).setVisibility(0);
    findViewById(b.e.chatroom_live_mini_view_close_btn).setOnClickListener(new RoomLiveMiniView..ExternalSyntheticLambda0(parama));
    AppMethodBeat.o(246266);
  }
  
  public final int bfN()
  {
    return 16;
  }
  
  public final void gf(boolean paramBoolean)
  {
    AppMethodBeat.i(246273);
    View localView = findViewById(b.e.chatroom_live_mini_view_close_group);
    if (paramBoolean) {}
    for (int i = 0;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(246273);
      return;
    }
  }
  
  public final void setState(int paramInt) {}
  
  public final void te(int paramInt) {}
  
  public final void tf(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.live.view.RoomLiveMiniView
 * JD-Core Version:    0.7.0.1
 */
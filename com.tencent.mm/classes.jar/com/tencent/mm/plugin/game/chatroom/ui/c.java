package com.tencent.mm.plugin.game.chatroom.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.d.a;
import com.tencent.mm.plugin.game.chatroom.h.g;
import com.tencent.mm.ui.widget.MMRoundCornerImageView;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/game/chatroom/ui/MentionUserViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/tencent/mm/plugin/game/chatroom/databinding/GameMentionUserItemBinding;", "chatroomName", "", "ssid", "", "sourceId", "(Lcom/tencent/mm/plugin/game/chatroom/databinding/GameMentionUserItemBinding;Ljava/lang/String;JJ)V", "atAllInfo", "Lkotlin/Pair;", "", "getBinding", "()Lcom/tencent/mm/plugin/game/chatroom/databinding/GameMentionUserItemBinding;", "getAtAllInfo", "setData", "", "userInfo", "Lcom/tencent/mm/plugin/game/chatroom/data/MentionUserWrapper;", "listener", "Lcom/tencent/mm/plugin/game/chatroom/ui/MentionUserAdapter$OnItemClickListener;", "game-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends RecyclerView.v
{
  private final long InY;
  private final com.tencent.mm.plugin.game.chatroom.e.b Iob;
  private r<Boolean, String> Ioc;
  private final String chatroomName;
  private final long ssid;
  
  public c(com.tencent.mm.plugin.game.chatroom.e.b paramb, String paramString, long paramLong1, long paramLong2)
  {
    super((View)paramb.Ikt);
    AppMethodBeat.i(276007);
    this.Iob = paramb;
    this.chatroomName = paramString;
    this.ssid = paramLong1;
    this.InY = paramLong2;
    AppMethodBeat.o(276007);
  }
  
  private static final void a(com.tencent.mm.plugin.game.chatroom.d.c paramc, c paramc1, b.b paramb, View paramView)
  {
    AppMethodBeat.i(276016);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramc);
    localb.cH(paramc1);
    localb.cH(paramb);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/chatroom/ui/MentionUserViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramc, "$userInfo");
    s.u(paramc1, "this$0");
    paramView = com.tencent.mm.game.report.d.mty;
    d.a.b(paramc.mkb, 2L, paramc1.ssid, paramc1.InY, paramc.Ikl.id);
    if (paramb != null) {
      paramb.iS(paramc.Ikl.id, paramc.Ikl.nickName);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/game/chatroom/ui/MentionUserViewHolder", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(276016);
  }
  
  public final void a(com.tencent.mm.plugin.game.chatroom.d.c paramc, b.b paramb)
  {
    AppMethodBeat.i(276034);
    s.u(paramc, "userInfo");
    int i;
    if (((Boolean)paramc.Ikk.bsC).booleanValue())
    {
      this.Iob.Ikz.setVisibility(0);
      Object localObject = (String)paramc.Ikk.bsD;
      if (localObject != null) {
        this.Iob.Ikz.setText((CharSequence)localObject);
      }
      this.Iob.Iky.setText((CharSequence)paramc.Ikl.nickName);
      if (s.p(paramc.Ikl.id, "all"))
      {
        if (!s.p(paramc.Ikl.id, "all")) {
          break label282;
        }
        localObject = com.tencent.mm.plugin.game.chatroom.k.a.Iod;
        this.Ioc = com.tencent.mm.plugin.game.chatroom.k.a.aFG(this.chatroomName);
        localObject = this.Ioc;
        if ((localObject == null) || (((Boolean)((r)localObject).bsC).booleanValue() != true)) {
          break label277;
        }
        i = 1;
        label164:
        if (i == 0) {
          break label282;
        }
      }
      this.Iob.Ikw.setAlpha(1.0F);
      this.Iob.Ikw.setOnClickListener(new c..ExternalSyntheticLambda0(paramc, this, paramb));
      label199:
      if (!s.p(paramc.Ikl.id, "all")) {
        break label344;
      }
      this.Iob.Ikx.setVisibility(0);
      this.Iob.Ikv.setImageResource(h.g.icons_all_member);
    }
    for (;;)
    {
      if (!paramc.FYI) {
        break label379;
      }
      this.Iob.Iku.setVisibility(0);
      AppMethodBeat.o(276034);
      return;
      this.Iob.Ikz.setVisibility(8);
      break;
      label277:
      i = 0;
      break label164;
      label282:
      this.Iob.Ikw.setClickable(false);
      this.Iob.Ikw.setAlpha(0.6F);
      paramb = this.Ioc;
      if (paramb == null) {
        break label199;
      }
      paramb = (String)paramb.bsD;
      if (paramb == null) {
        break label199;
      }
      this.Iob.Ikx.setText((CharSequence)paramb);
      break label199;
      label344:
      this.Iob.Ikx.setVisibility(8);
      com.tencent.mm.ui.i.a.a.g((ImageView)this.Iob.Ikv, paramc.Ikl.id);
    }
    label379:
    this.Iob.Iku.setVisibility(8);
    AppMethodBeat.o(276034);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.chatroom.ui.c
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.emoji.panel.a;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.emoji.b.e;
import com.tencent.mm.emoji.c.b.ae;
import com.tencent.mm.emoji.c.b.h;
import com.tencent.mm.emoji.view.EmojiStatusView;
import com.tencent.mm.emoji.view.EmojiStatusView.b;
import com.tencent.mm.plugin.gif.MMAnimateView;
import com.tencent.mm.plugin.gif.b;
import com.tencent.mm.plugin.m.a.d;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.plugin.m.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/panel/adapter/SimilarEmojiNormalViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "gifAutoPlay", "", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;ZLcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "getGifAutoPlay", "()Z", "setGifAutoPlay", "(Z)V", "icon", "Lcom/tencent/mm/emoji/view/EmojiStatusView;", "getIcon", "()Lcom/tencent/mm/emoji/view/EmojiStatusView;", "loadingView", "Landroid/widget/ProgressBar;", "getLoadingView", "()Landroid/widget/ProgressBar;", "payTip", "Landroid/widget/TextView;", "title", "getTitle", "()Landroid/widget/TextView;", "loadGif", "", "onBind", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "pauseGif", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class z
  extends q<h>
{
  public final EmojiStatusView mlD;
  public boolean mlE;
  final ProgressBar mlF;
  private final TextView mlG;
  private final TextView mll;
  
  public z(View paramView, boolean paramBoolean, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105688);
    this.mlE = paramBoolean;
    paramn = paramView.findViewById(a.g.art_emoji_icon_iv);
    s.s(paramn, "itemView.findViewById(R.id.art_emoji_icon_iv)");
    this.mlD = ((EmojiStatusView)paramn);
    this.mlF = ((ProgressBar)paramView.findViewById(a.g.dialog_loading));
    paramn = paramView.findViewById(a.g.art_emoji_icon_text);
    s.s(paramn, "itemView.findViewById(R.id.art_emoji_icon_text)");
    this.mll = ((TextView)paramn);
    paramView = paramView.findViewById(a.g.pay_tip);
    s.s(paramView, "itemView.findViewById(R.id.pay_tip)");
    this.mlG = ((TextView)paramView);
    this.mlD.setDefaultImageResource(0);
    AppMethodBeat.o(105688);
  }
  
  public final void a(ae paramae)
  {
    AppMethodBeat.i(105687);
    s.u(paramae, "item");
    super.a(paramae);
    h localh = (h)aVT();
    if (localh != null)
    {
      if (this.mlF != null)
      {
        this.mlD.setStatusListener((EmojiStatusView.b)new a(this));
        this.mlD.setImageDrawable(null);
        paramae = this.mlD.getStatusListener();
        if (paramae != null) {
          paramae.rJ(0);
        }
      }
      if (localh.mgK.pay == 1)
      {
        this.mlG.setVisibility(0);
        this.mlD.setContentDescription((CharSequence)s.X(this.caK.getContext().getString(a.j.emoji_pay_description), localh.mgK.abrL));
        this.mlD.stop();
        if (this.mlF == null)
        {
          paramae = this.mlD.getEmojiInfo();
          if (paramae != null) {
            break label277;
          }
        }
      }
      label277:
      for (paramae = null;; paramae = paramae.field_md5)
      {
        if (!s.p(paramae, localh.mgK.field_md5)) {
          this.mlD.setImageDrawable((Drawable)new ColorDrawable(this.mlD.getContext().getResources().getColor(a.d.BG_3)));
        }
        if (!this.mlE) {
          break label285;
        }
        this.mlD.setEmojiInfo(localh.mgK);
        this.mlD.setContentDescription((CharSequence)localh.mgK.abrL);
        AppMethodBeat.o(105687);
        return;
        this.mlG.setVisibility(8);
        this.mlD.setContentDescription((CharSequence)localh.mgK.abrL);
        break;
      }
      label285:
      paramae = e.mgl;
      e.a(localh.mgK, (ImageView)this.mlD, (Drawable)new ColorDrawable(this.mlD.getContext().getResources().getColor(a.d.BG_3)));
    }
    AppMethodBeat.o(105687);
  }
  
  public final void aVU()
  {
    int i = 1;
    AppMethodBeat.i(242454);
    Log.i("MicroMsg.SimilarEmoji", "loadGif");
    Object localObject1 = (h)aVT();
    if (localObject1 != null)
    {
      Object localObject2 = this.mlD.getEmojiInfo();
      if (localObject2 != null)
      {
        localObject2 = ((EmojiInfo)localObject2).getMd5();
        if ((localObject2 != null) && (((String)localObject2).equals(((h)localObject1).mgK.getMd5()) == true))
        {
          if (i == 0) {
            break label136;
          }
          localObject1 = this.mlD;
          if ((((MMAnimateView)localObject1).getDrawable() == null) || (!(((MMAnimateView)localObject1).getDrawable() instanceof b))) {
            break label131;
          }
        }
      }
      label131:
      for (boolean bool = ((b)((MMAnimateView)localObject1).getDrawable()).isRunning();; bool = false)
      {
        if (!bool) {
          this.mlD.resume();
        }
        AppMethodBeat.o(242454);
        return;
        i = 0;
        break;
      }
      label136:
      this.mlD.setEmojiInfo(((h)localObject1).mgK);
    }
    AppMethodBeat.o(242454);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/emoji/panel/adapter/SimilarEmojiNormalViewHolder$onBind$1$1$1", "Lcom/tencent/mm/emoji/view/EmojiStatusView$StatusListener;", "onStatus", "", "status", "", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements EmojiStatusView.b
  {
    a(z paramz) {}
    
    public final void rJ(int paramInt)
    {
      AppMethodBeat.i(242487);
      d.uiThread((a)new a(paramInt, this.mlH));
      AppMethodBeat.o(242487);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements a<ah>
    {
      a(int paramInt, z paramz)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.z
 * JD-Core Version:    0.7.0.1
 */
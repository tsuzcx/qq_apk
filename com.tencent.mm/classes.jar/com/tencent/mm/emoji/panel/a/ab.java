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
import com.tencent.mm.emoji.b.b.ae;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.emoji.view.CoverEmojiStatusView;
import com.tencent.mm.emoji.view.CoverEmojiStatusView.b;
import com.tencent.mm.plugin.m.a.d;
import com.tencent.mm.plugin.m.a.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/panel/adapter/SimilarEmojiNormalViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "gifAutoPlay", "", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;ZLcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "getGifAutoPlay", "()Z", "setGifAutoPlay", "(Z)V", "icon", "Lcom/tencent/mm/emoji/view/CoverEmojiStatusView;", "getIcon", "()Lcom/tencent/mm/emoji/view/CoverEmojiStatusView;", "loadingView", "Landroid/widget/ProgressBar;", "getLoadingView", "()Landroid/widget/ProgressBar;", "payTip", "Landroid/widget/TextView;", "title", "getTitle", "()Landroid/widget/TextView;", "loadGif", "", "onBind", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "pauseGif", "plugin-emojisdk_release"})
public final class ab
  extends s<h>
{
  public final CoverEmojiStatusView jME;
  final ProgressBar jMF;
  private final TextView jMG;
  public boolean jMH;
  private final TextView jMg;
  
  public ab(View paramView, boolean paramBoolean, p paramp)
  {
    super(paramView, paramp);
    AppMethodBeat.i(105688);
    this.jMH = paramBoolean;
    paramp = paramView.findViewById(a.g.art_emoji_icon_iv);
    kotlin.g.b.p.j(paramp, "itemView.findViewById(R.id.art_emoji_icon_iv)");
    this.jME = ((CoverEmojiStatusView)paramp);
    this.jMF = ((ProgressBar)paramView.findViewById(a.g.dialog_loading));
    paramp = paramView.findViewById(a.g.art_emoji_icon_text);
    kotlin.g.b.p.j(paramp, "itemView.findViewById(R.id.art_emoji_icon_text)");
    this.jMg = ((TextView)paramp);
    paramView = paramView.findViewById(a.g.pay_tip);
    kotlin.g.b.p.j(paramView, "itemView.findViewById(R.id.pay_tip)");
    this.jMG = ((TextView)paramView);
    AppMethodBeat.o(105688);
  }
  
  public final void a(ae paramae)
  {
    AppMethodBeat.i(105687);
    kotlin.g.b.p.k(paramae, "item");
    super.a(paramae);
    h localh = (h)this.jMr;
    if (localh != null)
    {
      if (this.jMF != null)
      {
        this.jME.setStatusListener((CoverEmojiStatusView.b)new ab.a(this));
        this.jME.setImageDrawable(null);
        paramae = this.jME.getStatusListener();
        if (paramae != null) {
          paramae.rH(0);
        }
      }
      paramae = this.jMG;
      int i;
      if (localh.jHh.ZuO == 1)
      {
        i = 0;
        paramae.setVisibility(i);
        this.jME.stop();
        if (this.jMF == null)
        {
          paramae = this.jME.getEmojiInfo();
          if (paramae == null) {
            break label243;
          }
        }
      }
      label243:
      for (paramae = paramae.field_md5;; paramae = null)
      {
        if ((kotlin.g.b.p.h(paramae, localh.jHh.field_md5) ^ true))
        {
          paramae = this.jME;
          Context localContext = this.jME.getContext();
          kotlin.g.b.p.j(localContext, "icon.context");
          paramae.setImageDrawable((Drawable)new ColorDrawable(localContext.getResources().getColor(a.d.BG_3)));
        }
        if (!this.jMH) {
          break label248;
        }
        this.jME.setEmojiInfo(localh.jHh);
        this.jME.setContentDescription((CharSequence)localh.jHh.UaI);
        AppMethodBeat.o(105687);
        return;
        i = 8;
        break;
      }
      label248:
      paramae = e.jGI;
      e.a(localh.jHh, (ImageView)this.jME);
      AppMethodBeat.o(105687);
      return;
    }
    AppMethodBeat.o(105687);
  }
  
  public final void aCU()
  {
    AppMethodBeat.i(224353);
    Log.i("MicroMsg.SimilarEmoji", "loadGif");
    h localh = (h)this.jMr;
    if (localh != null)
    {
      Object localObject = this.jME.getEmojiInfo();
      if (localObject != null)
      {
        localObject = ((EmojiInfo)localObject).getMd5();
        if ((localObject != null) && (((String)localObject).equals(localh.jHh.getMd5()) == true))
        {
          if (!this.jME.isRunning()) {
            this.jME.resume();
          }
          AppMethodBeat.o(224353);
          return;
        }
      }
      this.jME.setEmojiInfo(localh.jHh);
      AppMethodBeat.o(224353);
      return;
    }
    AppMethodBeat.o(224353);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.ab
 * JD-Core Version:    0.7.0.1
 */
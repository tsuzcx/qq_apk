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
import com.tencent.mm.ad.c;
import com.tencent.mm.emoji.a.a.h;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.emoji.view.CoverEmojiStatusView;
import com.tencent.mm.emoji.view.CoverEmojiStatusView.b;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.a.a;
import d.g.b.k;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/panel/adapter/SimilarEmojiNormalViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "gifAutoPlay", "", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;ZLcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "getGifAutoPlay", "()Z", "setGifAutoPlay", "(Z)V", "icon", "Lcom/tencent/mm/emoji/view/CoverEmojiStatusView;", "getIcon", "()Lcom/tencent/mm/emoji/view/CoverEmojiStatusView;", "loadingView", "Landroid/widget/ProgressBar;", "getLoadingView", "()Landroid/widget/ProgressBar;", "payTip", "Landroid/widget/TextView;", "title", "getTitle", "()Landroid/widget/TextView;", "loadGif", "", "onBind", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "pauseGif", "plugin-emojisdk_release"})
public final class u
  extends q<h>
{
  public final CoverEmojiStatusView fQB;
  final ProgressBar fQC;
  private final TextView fQD;
  public boolean fQE;
  private final TextView fQp;
  
  public u(View paramView, boolean paramBoolean, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105688);
    this.fQE = paramBoolean;
    paramn = paramView.findViewById(2131296943);
    k.g(paramn, "itemView.findViewById(R.id.art_emoji_icon_iv)");
    this.fQB = ((CoverEmojiStatusView)paramn);
    this.fQC = ((ProgressBar)paramView.findViewById(2131299127));
    paramn = paramView.findViewById(2131296944);
    k.g(paramn, "itemView.findViewById(R.id.art_emoji_icon_text)");
    this.fQp = ((TextView)paramn);
    paramView = paramView.findViewById(2131303159);
    k.g(paramView, "itemView.findViewById(R.id.pay_tip)");
    this.fQD = ((TextView)paramView);
    AppMethodBeat.o(105688);
  }
  
  public final void a(com.tencent.mm.emoji.a.a.y paramy)
  {
    AppMethodBeat.i(105687);
    k.h(paramy, "item");
    super.a(paramy);
    h localh = (h)this.fQv;
    if (localh != null)
    {
      if (this.fQC != null)
      {
        this.fQB.setStatusListener((CoverEmojiStatusView.b)new a(this));
        this.fQB.setImageDrawable(null);
        paramy = this.fQB.getStatusListener();
        if (paramy != null) {
          paramy.lG(0);
        }
      }
      paramy = this.fQD;
      int i;
      if (localh.fLP.LCn == 1)
      {
        i = 0;
        paramy.setVisibility(i);
        this.fQB.stop();
        if (this.fQC == null)
        {
          paramy = this.fQB.getEmojiInfo();
          if (paramy == null) {
            break label225;
          }
        }
      }
      label225:
      for (paramy = paramy.field_md5;; paramy = null)
      {
        if ((k.g(paramy, localh.fLP.field_md5) ^ true))
        {
          paramy = this.fQB;
          Context localContext = this.fQB.getContext();
          k.g(localContext, "icon.context");
          paramy.setImageDrawable((Drawable)new ColorDrawable(localContext.getResources().getColor(2131099651)));
        }
        if (!this.fQE) {
          break label230;
        }
        this.fQB.setEmojiInfo(localh.fLP);
        AppMethodBeat.o(105687);
        return;
        i = 8;
        break;
      }
      label230:
      paramy = e.fLn;
      e.a(localh.fLP, (ImageView)this.fQB);
      AppMethodBeat.o(105687);
      return;
    }
    AppMethodBeat.o(105687);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/emoji/panel/adapter/SimilarEmojiNormalViewHolder$onBind$1$1$1", "Lcom/tencent/mm/emoji/view/CoverEmojiStatusView$StatusListener;", "onStatus", "", "status", "", "plugin-emojisdk_release", "com/tencent/mm/emoji/panel/adapter/SimilarEmojiNormalViewHolder$$special$$inlined$apply$lambda$1"})
  public static final class a
    implements CoverEmojiStatusView.b
  {
    a(u paramu) {}
    
    public final void lG(final int paramInt)
    {
      AppMethodBeat.i(105686);
      c.g((a)new d.g.b.l(paramInt) {});
      AppMethodBeat.o(105686);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.u
 * JD-Core Version:    0.7.0.1
 */
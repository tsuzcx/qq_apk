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
import com.tencent.mm.ac.c;
import com.tencent.mm.emoji.a.b.ac;
import com.tencent.mm.emoji.a.b.h;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.emoji.view.CoverEmojiStatusView;
import com.tencent.mm.emoji.view.CoverEmojiStatusView.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.a.a;
import d.g.b.p;
import d.l;
import d.z;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/panel/adapter/SimilarEmojiNormalViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "gifAutoPlay", "", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;ZLcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "getGifAutoPlay", "()Z", "setGifAutoPlay", "(Z)V", "icon", "Lcom/tencent/mm/emoji/view/CoverEmojiStatusView;", "getIcon", "()Lcom/tencent/mm/emoji/view/CoverEmojiStatusView;", "loadingView", "Landroid/widget/ProgressBar;", "getLoadingView", "()Landroid/widget/ProgressBar;", "payTip", "Landroid/widget/TextView;", "title", "getTitle", "()Landroid/widget/TextView;", "loadGif", "", "onBind", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "pauseGif", "plugin-emojisdk_release"})
public final class u
  extends q<h>
{
  private final TextView gqi;
  public final CoverEmojiStatusView gqu;
  final ProgressBar gqv;
  private final TextView gqw;
  public boolean gqx;
  
  public u(View paramView, boolean paramBoolean, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105688);
    this.gqx = paramBoolean;
    paramn = paramView.findViewById(2131296943);
    p.g(paramn, "itemView.findViewById(R.id.art_emoji_icon_iv)");
    this.gqu = ((CoverEmojiStatusView)paramn);
    this.gqv = ((ProgressBar)paramView.findViewById(2131299127));
    paramn = paramView.findViewById(2131296944);
    p.g(paramn, "itemView.findViewById(R.id.art_emoji_icon_text)");
    this.gqi = ((TextView)paramn);
    paramView = paramView.findViewById(2131303159);
    p.g(paramView, "itemView.findViewById(R.id.pay_tip)");
    this.gqw = ((TextView)paramView);
    AppMethodBeat.o(105688);
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(105687);
    p.h(paramac, "item");
    super.a(paramac);
    h localh = (h)this.gqo;
    if (localh != null)
    {
      if (this.gqv != null)
      {
        this.gqu.setStatusListener((CoverEmojiStatusView.b)new a(this));
        this.gqu.setImageDrawable(null);
        paramac = this.gqu.getStatusListener();
        if (paramac != null) {
          paramac.mg(0);
        }
      }
      paramac = this.gqw;
      int i;
      if (localh.glt.OAr == 1)
      {
        i = 0;
        paramac.setVisibility(i);
        this.gqu.stop();
        if (this.gqv == null)
        {
          paramac = this.gqu.getEmojiInfo();
          if (paramac == null) {
            break label225;
          }
        }
      }
      label225:
      for (paramac = paramac.field_md5;; paramac = null)
      {
        if ((p.i(paramac, localh.glt.field_md5) ^ true))
        {
          paramac = this.gqu;
          Context localContext = this.gqu.getContext();
          p.g(localContext, "icon.context");
          paramac.setImageDrawable((Drawable)new ColorDrawable(localContext.getResources().getColor(2131099651)));
        }
        if (!this.gqx) {
          break label230;
        }
        this.gqu.setEmojiInfo(localh.glt);
        AppMethodBeat.o(105687);
        return;
        i = 8;
        break;
      }
      label230:
      paramac = e.gkR;
      e.a(localh.glt, (ImageView)this.gqu);
      AppMethodBeat.o(105687);
      return;
    }
    AppMethodBeat.o(105687);
  }
  
  public final void agh()
  {
    AppMethodBeat.i(188604);
    ae.i("MicroMsg.SimilarEmoji", "loadGif");
    h localh = (h)this.gqo;
    if (localh != null)
    {
      Object localObject = this.gqu.getEmojiInfo();
      if (localObject != null)
      {
        localObject = ((EmojiInfo)localObject).Lj();
        if ((localObject != null) && (((String)localObject).equals(localh.glt.Lj()) == true))
        {
          if (!this.gqu.isRunning()) {
            this.gqu.resume();
          }
          AppMethodBeat.o(188604);
          return;
        }
      }
      this.gqu.setEmojiInfo(localh.glt);
      AppMethodBeat.o(188604);
      return;
    }
    AppMethodBeat.o(188604);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/emoji/panel/adapter/SimilarEmojiNormalViewHolder$onBind$1$1$1", "Lcom/tencent/mm/emoji/view/CoverEmojiStatusView$StatusListener;", "onStatus", "", "status", "", "plugin-emojisdk_release", "com/tencent/mm/emoji/panel/adapter/SimilarEmojiNormalViewHolder$$special$$inlined$apply$lambda$1"})
  public static final class a
    implements CoverEmojiStatusView.b
  {
    a(u paramu) {}
    
    public final void mg(final int paramInt)
    {
      AppMethodBeat.i(105686);
      c.h((a)new d.g.b.q(paramInt) {});
      AppMethodBeat.o(105686);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.u
 * JD-Core Version:    0.7.0.1
 */
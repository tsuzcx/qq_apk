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
import com.tencent.mm.emoji.a.a.ac;
import com.tencent.mm.emoji.a.a.h;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.emoji.view.CoverEmojiStatusView;
import com.tencent.mm.emoji.view.CoverEmojiStatusView.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.emotion.EmojiInfo;
import d.g.a.a;
import d.g.b.p;
import d.l;
import d.z;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/panel/adapter/SimilarEmojiNormalViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "gifAutoPlay", "", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;ZLcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "getGifAutoPlay", "()Z", "setGifAutoPlay", "(Z)V", "icon", "Lcom/tencent/mm/emoji/view/CoverEmojiStatusView;", "getIcon", "()Lcom/tencent/mm/emoji/view/CoverEmojiStatusView;", "loadingView", "Landroid/widget/ProgressBar;", "getLoadingView", "()Landroid/widget/ProgressBar;", "payTip", "Landroid/widget/TextView;", "title", "getTitle", "()Landroid/widget/TextView;", "loadGif", "", "onBind", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "pauseGif", "plugin-emojisdk_release"})
public final class u
  extends q<h>
{
  private final TextView gnM;
  public final CoverEmojiStatusView gnY;
  final ProgressBar gnZ;
  private final TextView goa;
  public boolean gob;
  
  public u(View paramView, boolean paramBoolean, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105688);
    this.gob = paramBoolean;
    paramn = paramView.findViewById(2131296943);
    p.g(paramn, "itemView.findViewById(R.id.art_emoji_icon_iv)");
    this.gnY = ((CoverEmojiStatusView)paramn);
    this.gnZ = ((ProgressBar)paramView.findViewById(2131299127));
    paramn = paramView.findViewById(2131296944);
    p.g(paramn, "itemView.findViewById(R.id.art_emoji_icon_text)");
    this.gnM = ((TextView)paramn);
    paramView = paramView.findViewById(2131303159);
    p.g(paramView, "itemView.findViewById(R.id.pay_tip)");
    this.goa = ((TextView)paramView);
    AppMethodBeat.o(105688);
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(105687);
    p.h(paramac, "item");
    super.a(paramac);
    h localh = (h)this.gnS;
    if (localh != null)
    {
      if (this.gnZ != null)
      {
        this.gnY.setStatusListener((CoverEmojiStatusView.b)new a(this));
        this.gnY.setImageDrawable(null);
        paramac = this.gnY.getStatusListener();
        if (paramac != null) {
          paramac.md(0);
        }
      }
      paramac = this.goa;
      int i;
      if (localh.gjb.Ofk == 1)
      {
        i = 0;
        paramac.setVisibility(i);
        this.gnY.stop();
        if (this.gnZ == null)
        {
          paramac = this.gnY.getEmojiInfo();
          if (paramac == null) {
            break label225;
          }
        }
      }
      label225:
      for (paramac = paramac.field_md5;; paramac = null)
      {
        if ((p.i(paramac, localh.gjb.field_md5) ^ true))
        {
          paramac = this.gnY;
          Context localContext = this.gnY.getContext();
          p.g(localContext, "icon.context");
          paramac.setImageDrawable((Drawable)new ColorDrawable(localContext.getResources().getColor(2131099651)));
        }
        if (!this.gob) {
          break label230;
        }
        this.gnY.setEmojiInfo(localh.gjb);
        AppMethodBeat.o(105687);
        return;
        i = 8;
        break;
      }
      label230:
      paramac = e.giz;
      e.a(localh.gjb, (ImageView)this.gnY);
      AppMethodBeat.o(105687);
      return;
    }
    AppMethodBeat.o(105687);
  }
  
  public final void afT()
  {
    AppMethodBeat.i(218990);
    ad.i("MicroMsg.SimilarEmoji", "loadGif");
    h localh = (h)this.gnS;
    if (localh != null)
    {
      Object localObject = this.gnY.getEmojiInfo();
      if (localObject != null)
      {
        localObject = ((EmojiInfo)localObject).Lb();
        if ((localObject != null) && (((String)localObject).equals(localh.gjb.Lb()) == true))
        {
          if (!this.gnY.isRunning()) {
            this.gnY.resume();
          }
          AppMethodBeat.o(218990);
          return;
        }
      }
      this.gnY.setEmojiInfo(localh.gjb);
      AppMethodBeat.o(218990);
      return;
    }
    AppMethodBeat.o(218990);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"com/tencent/mm/emoji/panel/adapter/SimilarEmojiNormalViewHolder$onBind$1$1$1", "Lcom/tencent/mm/emoji/view/CoverEmojiStatusView$StatusListener;", "onStatus", "", "status", "", "plugin-emojisdk_release", "com/tencent/mm/emoji/panel/adapter/SimilarEmojiNormalViewHolder$$special$$inlined$apply$lambda$1"})
  public static final class a
    implements CoverEmojiStatusView.b
  {
    a(u paramu) {}
    
    public final void md(final int paramInt)
    {
      AppMethodBeat.i(105686);
      c.g((a)new d.g.b.q(paramInt) {});
      AppMethodBeat.o(105686);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.u
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.ac.d;
import com.tencent.mm.emoji.b.b.ac;
import com.tencent.mm.emoji.b.b.h;
import com.tencent.mm.emoji.loader.e;
import com.tencent.mm.emoji.view.CoverEmojiStatusView;
import com.tencent.mm.emoji.view.CoverEmojiStatusView.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/panel/adapter/SimilarEmojiNormalViewHolder;", "Lcom/tencent/mm/emoji/panel/adapter/PanelViewHolder;", "Lcom/tencent/mm/emoji/model/panel/EmojiItem;", "itemView", "Landroid/view/View;", "gifAutoPlay", "", "onClick", "Lcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;", "(Landroid/view/View;ZLcom/tencent/mm/emoji/panel/adapter/IEmojiPanelClickListener;)V", "getGifAutoPlay", "()Z", "setGifAutoPlay", "(Z)V", "icon", "Lcom/tencent/mm/emoji/view/CoverEmojiStatusView;", "getIcon", "()Lcom/tencent/mm/emoji/view/CoverEmojiStatusView;", "loadingView", "Landroid/widget/ProgressBar;", "getLoadingView", "()Landroid/widget/ProgressBar;", "payTip", "Landroid/widget/TextView;", "title", "getTitle", "()Landroid/widget/TextView;", "loadGif", "", "onBind", "item", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "pauseGif", "plugin-emojisdk_release"})
public final class z
  extends q<h>
{
  private final TextView hbb;
  public final CoverEmojiStatusView hbu;
  final ProgressBar hbv;
  private final TextView hbw;
  public boolean hbx;
  
  public z(View paramView, boolean paramBoolean, n paramn)
  {
    super(paramView, paramn);
    AppMethodBeat.i(105688);
    this.hbx = paramBoolean;
    paramn = paramView.findViewById(2131297050);
    p.g(paramn, "itemView.findViewById(R.id.art_emoji_icon_iv)");
    this.hbu = ((CoverEmojiStatusView)paramn);
    this.hbv = ((ProgressBar)paramView.findViewById(2131299652));
    paramn = paramView.findViewById(2131297051);
    p.g(paramn, "itemView.findViewById(R.id.art_emoji_icon_text)");
    this.hbb = ((TextView)paramn);
    paramView = paramView.findViewById(2131305816);
    p.g(paramView, "itemView.findViewById(R.id.pay_tip)");
    this.hbw = ((TextView)paramView);
    AppMethodBeat.o(105688);
  }
  
  public final void a(ac paramac)
  {
    AppMethodBeat.i(105687);
    p.h(paramac, "item");
    super.a(paramac);
    h localh = (h)this.hbh;
    if (localh != null)
    {
      if (this.hbv != null)
      {
        this.hbu.setStatusListener((CoverEmojiStatusView.b)new a(this));
        this.hbu.setImageDrawable(null);
        paramac = this.hbu.getStatusListener();
        if (paramac != null) {
          paramac.po(0);
        }
      }
      paramac = this.hbw;
      int i;
      if (localh.gWm.UuM == 1)
      {
        i = 0;
        paramac.setVisibility(i);
        this.hbu.stop();
        if (this.hbv == null)
        {
          paramac = this.hbu.getEmojiInfo();
          if (paramac == null) {
            break label242;
          }
        }
      }
      label242:
      for (paramac = paramac.field_md5;; paramac = null)
      {
        if ((p.j(paramac, localh.gWm.field_md5) ^ true))
        {
          paramac = this.hbu;
          Context localContext = this.hbu.getContext();
          p.g(localContext, "icon.context");
          paramac.setImageDrawable((Drawable)new ColorDrawable(localContext.getResources().getColor(2131099651)));
        }
        if (!this.hbx) {
          break label247;
        }
        this.hbu.setEmojiInfo(localh.gWm);
        this.hbu.setContentDescription((CharSequence)localh.gWm.MOK);
        AppMethodBeat.o(105687);
        return;
        i = 8;
        break;
      }
      label247:
      paramac = e.gVM;
      e.a(localh.gWm, (ImageView)this.hbu);
      AppMethodBeat.o(105687);
      return;
    }
    AppMethodBeat.o(105687);
  }
  
  public final void avV()
  {
    AppMethodBeat.i(199980);
    Log.i("MicroMsg.SimilarEmoji", "loadGif");
    h localh = (h)this.hbh;
    if (localh != null)
    {
      Object localObject = this.hbu.getEmojiInfo();
      if (localObject != null)
      {
        localObject = ((EmojiInfo)localObject).getMd5();
        if ((localObject != null) && (((String)localObject).equals(localh.gWm.getMd5()) == true))
        {
          if (!this.hbu.isRunning()) {
            this.hbu.resume();
          }
          AppMethodBeat.o(199980);
          return;
        }
      }
      this.hbu.setEmojiInfo(localh.gWm);
      AppMethodBeat.o(199980);
      return;
    }
    AppMethodBeat.o(199980);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/emoji/panel/adapter/SimilarEmojiNormalViewHolder$onBind$1$1$1", "Lcom/tencent/mm/emoji/view/CoverEmojiStatusView$StatusListener;", "onStatus", "", "status", "", "plugin-emojisdk_release", "com/tencent/mm/emoji/panel/adapter/SimilarEmojiNormalViewHolder$$special$$inlined$apply$lambda$1"})
  public static final class a
    implements CoverEmojiStatusView.b
  {
    a(z paramz) {}
    
    public final void po(final int paramInt)
    {
      AppMethodBeat.i(105686);
      d.h((a)new kotlin.g.b.q(paramInt) {});
      AppMethodBeat.o(105686);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.panel.a.z
 * JD-Core Version:    0.7.0.1
 */
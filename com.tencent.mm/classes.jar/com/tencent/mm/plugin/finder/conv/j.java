package com.tencent.mm.plugin.finder.conv;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.forcenotify.c.e;
import com.tencent.mm.plugin.forcenotify.ui.b;
import com.tencent.mm.plugin.forcenotify.ui.b.a;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderLiveMsgItem;", "Lcom/tencent/mm/plugin/forcenotify/model/FinderBaseMsgItem;", "id", "", "title", "desc", "avatar", "Landroid/graphics/Bitmap;", "authIconType", "", "showTimeMs", "", "isNeedSound", "", "isNeedShake", "intent", "Landroid/content/Intent;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/graphics/Bitmap;IJZZLandroid/content/Intent;)V", "getIntent", "()Landroid/content/Intent;", "()Z", "getIconColor", "getIconDrawable", "Landroid/graphics/drawable/Drawable;", "getWindowTitle", "needSound", "needVibrate", "onBindView", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "position", "type", "isHotPatch", "payloads", "", "", "onItemClick", "view", "Landroid/view/View;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends e
{
  private final boolean AGT;
  private final boolean AGU;
  private final Intent intent;
  
  public j(String paramString1, String paramString2, String paramString3, Bitmap paramBitmap, int paramInt, long paramLong, boolean paramBoolean1, boolean paramBoolean2, Intent paramIntent)
  {
    super(paramString1, paramString2, paramString3, paramBitmap, paramInt, paramLong);
    AppMethodBeat.i(336007);
    this.AGT = paramBoolean1;
    this.AGU = paramBoolean2;
    this.intent = paramIntent;
    AppMethodBeat.o(336007);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.j paramj)
  {
    AppMethodBeat.i(336067);
    s.u(paramj, "holder");
    Object localObject = b.HoY;
    ImageView localImageView;
    if (b.a.fwZ().isDarkMode())
    {
      localObject = (TextView)paramj.UH(e.e.title_tv);
      if (localObject != null) {
        ((TextView)localObject).setTextColor(paramj.context.getResources().getColor(e.b.force_notify_text_white_90));
      }
      localObject = (TextView)paramj.UH(e.e.wording_tv);
      if (localObject != null) {
        ((TextView)localObject).setTextColor(paramj.context.getResources().getColor(e.b.force_notify_text_white_50));
      }
      localImageView = (ImageView)paramj.caK.findViewById(e.e.avatar_iv);
      localObject = (ImageView)paramj.caK.findViewById(e.e.auth_icon_iv);
      TextView localTextView = (TextView)paramj.caK.findViewById(e.e.title_tv);
      paramj = (TextView)paramj.caK.findViewById(e.e.wording_tv);
      localTextView.setText((CharSequence)p.b(localTextView.getContext(), (CharSequence)getTitle(), localTextView.getTextSize()));
      paramj.setText((CharSequence)getDesc());
      paramj.requestLayout();
      paramj = fwJ();
      if (paramj != null) {
        break label317;
      }
    }
    for (paramj = null;; paramj = ah.aiuX)
    {
      if (paramj == null) {
        localImageView.setVisibility(8);
      }
      if ((fwK() != 1) && (fwK() != 2)) {
        break label334;
      }
      paramj = av.GiL;
      s.s(localObject, "authIv");
      av.a((ImageView)localObject, fwK(), null);
      AppMethodBeat.o(336067);
      return;
      localObject = (TextView)paramj.UH(e.e.title_tv);
      if (localObject != null) {
        ((TextView)localObject).setTextColor(paramj.context.getResources().getColor(e.b.force_notify_text_dark_90));
      }
      localObject = (TextView)paramj.UH(e.e.wording_tv);
      if (localObject == null) {
        break;
      }
      ((TextView)localObject).setTextColor(paramj.context.getResources().getColor(e.b.force_notify_text_dark_50));
      break;
      label317:
      localImageView.setVisibility(0);
      localImageView.setImageBitmap(paramj);
    }
    label334:
    ((ImageView)localObject).setVisibility(8);
    AppMethodBeat.o(336067);
  }
  
  public final void a(com.tencent.mm.view.recyclerview.j paramj, View paramView)
  {
    AppMethodBeat.i(336016);
    s.u(paramj, "holder");
    s.u(paramView, "view");
    ((cn)h.az(cn.class)).set21084CommentScene("temp_34");
    paramj = MMApplicationContext.getContext();
    paramView = this.intent;
    paramView = new com.tencent.mm.hellhoundlib.b.a().cG(paramView);
    com.tencent.mm.hellhoundlib.a.a.b(paramj, paramView.aYi(), "com/tencent/mm/plugin/finder/conv/FinderLiveMsgItem", "onItemClick", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramj.startActivity((Intent)paramView.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramj, "com/tencent/mm/plugin/finder/conv/FinderLiveMsgItem", "onItemClick", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Landroid/view/View;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(336016);
  }
  
  public final boolean dWY()
  {
    return this.AGT;
  }
  
  public final boolean dWZ()
  {
    return this.AGU;
  }
  
  public final String dXa()
  {
    AppMethodBeat.i(336038);
    String str = MMApplicationContext.getContext().getString(e.h.finder_live_entry);
    s.s(str, "getContext().getString(R.string.finder_live_entry)");
    AppMethodBeat.o(336038);
    return str;
  }
  
  public final Drawable dXb()
  {
    AppMethodBeat.i(336046);
    Drawable localDrawable = com.tencent.mm.svg.a.a.i(MMApplicationContext.getResources(), e.g.icons_outlined_live);
    AppMethodBeat.o(336046);
    return localDrawable;
  }
  
  public final int getIconColor()
  {
    AppMethodBeat.i(336054);
    int i = MMApplicationContext.getColor(e.b.room_live_logo_color);
    AppMethodBeat.o(336054);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.j
 * JD-Core Version:    0.7.0.1
 */
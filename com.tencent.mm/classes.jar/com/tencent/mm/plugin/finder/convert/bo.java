package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.model.az;
import com.tencent.mm.plugin.finder.storage.ao;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.f;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderMsgFriendObjectRecommendLikeConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMsgFriendObjectRecommendLike;", "scene", "", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getScene", "()I", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "plugin-finder_release"})
public final class bo
  extends bh<az>
{
  private final String TAG;
  private final int scene;
  
  public bo(int paramInt)
  {
    super(2131494530, paramInt);
    this.scene = paramInt;
    this.TAG = "Finder.FinderMsgFriendObjectRecommendLikeConvert";
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(h paramh, TextView paramTextView1, String paramString, TextView paramTextView2, az paramaz) {}
    
    public final void run()
    {
      AppMethodBeat.i(243202);
      Object localObject = this.qhp.Mn(2131305214);
      p.g(localObject, "holder.getView<View>(R.id.name_container)");
      int i = ((View)localObject).getWidth();
      localObject = this.tEU;
      p.g(localObject, "nickTv");
      float f = ((TextView)localObject).getPaint().measureText(this.tEV);
      if (i > f)
      {
        localObject = this.tEW;
        p.g(localObject, "suffixTv");
        ((TextView)localObject).setVisibility(8);
        localObject = this.tEU;
        p.g(localObject, "nickTv");
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(this.qhp.getContext(), (CharSequence)this.tEV));
        AppMethodBeat.o(243202);
        return;
      }
      localObject = this.tEW;
      p.g(localObject, "suffixTv");
      ((TextView)localObject).setVisibility(0);
      localObject = this.tEW;
      p.g(localObject, "suffixTv");
      ((TextView)localObject).setText((CharSequence)this.qhp.getContext().getString(2131760306, new Object[] { k.Lw(this.tFd.uNF.field_aggregatedContacts.LII) }));
      localObject = this.tEU;
      p.g(localObject, "nickTv");
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(this.qhp.getContext(), (CharSequence)this.tEV));
      AppMethodBeat.o(243202);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  static final class b<T, R>
    implements e<o, Bitmap>
  {
    b(z.f paramf, h paramh) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bo
 * JD-Core Version:    0.7.0.1
 */
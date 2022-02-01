package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.plugin.finder.loader.o;
import com.tencent.mm.plugin.finder.model.ba;
import com.tencent.mm.plugin.finder.storage.ao;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.protocal.protobuf.aym;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.g.b.z.f;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderMsgLikeConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMsgLike;", "scene", "", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getScene", "()I", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "plugin-finder_release"})
public final class bq
  extends bh<ba>
{
  final String TAG;
  private final int scene;
  
  public bq(int paramInt)
  {
    super(2131494532, paramInt);
    this.scene = paramInt;
    this.TAG = "Finder.FinderMsgLikeConvert";
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(bq parambq, h paramh, TextView paramTextView1, String paramString, ba paramba, TextView paramTextView2) {}
    
    public final void run()
    {
      AppMethodBeat.i(243207);
      Object localObject = this.qhp.Mn(2131305214);
      p.g(localObject, "holder.getView<View>(R.id.name_container)");
      int i = ((View)localObject).getWidth();
      localObject = this.tEU;
      p.g(localObject, "nickTv");
      float f = ((TextView)localObject).getPaint().measureText(this.tEV);
      Log.d(this.tFh.TAG, "allWidth:" + i + " nicknameWidth:" + f + " count:" + this.tFi.uNF.dym());
      if (i > f)
      {
        localObject = this.tEW;
        p.g(localObject, "suffixTv");
        ((TextView)localObject).setVisibility(8);
        localObject = this.tEU;
        p.g(localObject, "nickTv");
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(this.qhp.getContext(), (CharSequence)this.tEV));
        AppMethodBeat.o(243207);
        return;
      }
      localObject = this.tEW;
      p.g(localObject, "suffixTv");
      ((TextView)localObject).setVisibility(0);
      localObject = this.tEW;
      p.g(localObject, "suffixTv");
      ((TextView)localObject).setText((CharSequence)this.qhp.getContext().getString(2131760306, new Object[] { k.Lw(this.tFi.uNF.field_aggregatedContacts.LII) }));
      localObject = this.tEU;
      p.g(localObject, "nickTv");
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(this.qhp.getContext(), (CharSequence)this.tEV));
      AppMethodBeat.o(243207);
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
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bq
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextPaint;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.f.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.loader.w;
import com.tencent.mm.plugin.finder.model.bd;
import com.tencent.mm.plugin.finder.storage.an;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.protocal.protobuf.beg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderMsgLikeConvert;", "Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderMsgLike;", "scene", "", "(I)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getScene", "()I", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "plugin-finder_release"})
public final class bs
  extends bj<bd>
{
  final String TAG;
  private final int scene;
  
  public bs(int paramInt)
  {
    super(b.g.finder_msg_item_of_like, paramInt);
    this.scene = paramInt;
    this.TAG = "Finder.FinderMsgLikeConvert";
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(bs parambs, i parami, TextView paramTextView1, String paramString, bd parambd, TextView paramTextView2) {}
    
    public final void run()
    {
      AppMethodBeat.i(291642);
      Object localObject = this.tDl.RD(b.f.name_container);
      p.j(localObject, "holder.getView<View>(R.id.name_container)");
      int i = ((View)localObject).getWidth();
      localObject = this.xkm;
      p.j(localObject, "nickTv");
      float f = ((TextView)localObject).getPaint().measureText(this.xnu);
      Log.d(this.xnG.TAG, "allWidth:" + i + " nicknameWidth:" + f + " count:" + this.xnH.zzT.dZk());
      if (i > f)
      {
        localObject = this.xnv;
        p.j(localObject, "suffixTv");
        ((TextView)localObject).setVisibility(8);
        localObject = this.xkm;
        p.j(localObject, "nickTv");
        ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(this.tDl.getContext(), (CharSequence)this.xnu));
        AppMethodBeat.o(291642);
        return;
      }
      localObject = this.xnv;
      p.j(localObject, "suffixTv");
      ((TextView)localObject).setVisibility(0);
      localObject = this.xnv;
      p.j(localObject, "suffixTv");
      ((TextView)localObject).setText((CharSequence)this.tDl.getContext().getString(b.j.finder_msg_suffix_desc, new Object[] { m.QG(this.xnH.zzT.field_aggregatedContacts.SPu) }));
      localObject = this.xkm;
      p.j(localObject, "nickTv");
      ((TextView)localObject).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c(this.tDl.getContext(), (CharSequence)this.xnu));
      AppMethodBeat.o(291642);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "url", "Lcom/tencent/mm/loader/model/data/DataItem;", "Lcom/tencent/mm/plugin/finder/loader/FinderLoaderData;", "kotlin.jvm.PlatformType", "view", "Lcom/tencent/mm/loader/impr/target/ViewWeakHolder;", "resource", "Landroid/graphics/Bitmap;", "onImageLoadComplete"})
  static final class b<T, R>
    implements e<w, Bitmap>
  {
    b(aa.f paramf, i parami) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bs
 * JD-Core Version:    0.7.0.1
 */
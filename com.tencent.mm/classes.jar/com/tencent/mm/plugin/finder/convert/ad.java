package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.loader.x;
import com.tencent.mm.plugin.finder.report.n;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.viewmodel.component.aj;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.bkn;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.i;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FeedHeaderMsgNotifyData;", "()V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "Companion", "plugin-finder_release"})
public final class ad
  extends e<com.tencent.mm.plugin.finder.model.h>
{
  public static final a xma;
  
  static
  {
    AppMethodBeat.i(165410);
    xma = new a((byte)0);
    AppMethodBeat.o(165410);
  }
  
  public static void a(i parami, com.tencent.mm.plugin.finder.model.h paramh)
  {
    AppMethodBeat.i(252096);
    p.k(parami, "holder");
    p.k(paramh, "item");
    Log.i("Finder.FeedMsgNotifyConvert", "item count = " + paramh.count + ",item avatar = " + paramh.avatar);
    if (paramh.count > 0)
    {
      Object localObject1 = parami.RD(b.f.msg_layout);
      p.j(localObject1, "holder.getView<View>(R.id.msg_layout)");
      ((View)localObject1).setVisibility(0);
      Object localObject2;
      int i;
      if (Util.isNullOrNil(paramh.avatar))
      {
        localObject1 = parami.RD(b.f.msg_avatar);
        p.j(localObject1, "holder.getView<View>(R.id.msg_avatar)");
        ((View)localObject1).setVisibility(8);
        localObject1 = parami.RD(b.f.message_count);
        p.j(localObject1, "holder.getView<TextView>(R.id.message_count)");
        localObject1 = (TextView)localObject1;
        parami = parami.getContext();
        p.j(parami, "holder.context");
        localObject2 = parami.getResources();
        i = b.j.finder_message_tip;
        if (paramh.count <= 99) {
          break label276;
        }
      }
      label276:
      for (parami = "99+";; parami = Integer.valueOf(paramh.count))
      {
        ((TextView)localObject1).setText((CharSequence)((Resources)localObject2).getString(i, new Object[] { parami }));
        AppMethodBeat.o(252096);
        return;
        localObject1 = parami.RD(b.f.msg_avatar);
        p.j(localObject1, "holder.getView<View>(R.id.msg_avatar)");
        ((View)localObject1).setVisibility(0);
        localObject1 = t.ztT;
        localObject1 = t.dJi();
        localObject2 = new x(paramh.avatar, u.Alz);
        Object localObject3 = parami.RD(b.f.msg_avatar);
        p.j(localObject3, "holder.getView<ImageView>(R.id.msg_avatar)");
        localObject3 = (ImageView)localObject3;
        t localt = t.ztT;
        ((com.tencent.mm.loader.d)localObject1).a(localObject2, (ImageView)localObject3, t.a(t.a.ztZ));
        break;
      }
    }
    parami = parami.RD(b.f.msg_layout);
    p.j(parami, "holder.getView<View>(R.id.msg_layout)");
    parami.setVisibility(8);
    AppMethodBeat.o(252096);
  }
  
  public final void a(RecyclerView paramRecyclerView, i parami, int paramInt)
  {
    AppMethodBeat.i(252090);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    paramRecyclerView = parami.amk;
    p.j(paramRecyclerView, "holder.itemView");
    paramRecyclerView = paramRecyclerView.getLayoutParams();
    if ((paramRecyclerView instanceof StaggeredGridLayoutManager.LayoutParams)) {
      ((StaggeredGridLayoutManager.LayoutParams)paramRecyclerView).aA(true);
    }
    parami.RD(b.f.msg_layout).setOnClickListener((View.OnClickListener)new b(parami));
    AppMethodBeat.o(252090);
  }
  
  public final int getLayoutId()
  {
    return b.g._feed_header_msg_notify_item;
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(i parami) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(165407);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      paramView = com.tencent.mm.kernel.h.aHG();
      p.j(paramView, "MMKernel.storage()");
      int m = paramView.aHp().getInt(ar.a.VAb, 0);
      paramView = com.tencent.mm.kernel.h.aHG();
      p.j(paramView, "MMKernel.storage()");
      int n = paramView.aHp().getInt(ar.a.VAc, 0);
      paramView = com.tencent.mm.kernel.h.aHG();
      p.j(paramView, "MMKernel.storage()");
      int i1 = paramView.aHp().getInt(ar.a.VAd, 0);
      paramView = com.tencent.mm.kernel.h.aHG();
      p.j(paramView, "MMKernel.storage()");
      int i2 = paramView.aHp().getInt(ar.a.VAe, 0);
      paramView = com.tencent.mm.plugin.finder.utils.a.ACH;
      paramView = this.tDl.getContext();
      p.j(paramView, "holder.context");
      com.tencent.mm.plugin.finder.utils.a.fG(paramView);
      paramView = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      localObject = ((PluginFinder)paramView).getRedDotManager().aBf("TLWxBubble");
      paramView = com.tencent.mm.kernel.h.ag(PluginFinder.class);
      p.j(paramView, "MMKernel.plugin(PluginFinder::class.java)");
      bkn localbkn = ((PluginFinder)paramView).getRedDotManager().aBe("TLWxBubble");
      int k;
      if (localObject != null)
      {
        paramView = com.tencent.mm.plugin.finder.storage.d.AjH;
        if (((Number)com.tencent.mm.plugin.finder.storage.d.dTQ().aSr()).intValue() != 1) {
          break label429;
        }
        k = 5;
        if (n <= 0) {
          break label451;
        }
      }
      label318:
      label451:
      for (int j = 1;; j = 0)
      {
        int i = j;
        if (m > 0) {
          i = j | 0x8;
        }
        j = i;
        if (i1 > 0) {
          j = i | 0x2;
        }
        if (i2 > 0) {}
        for (i = j | 0x4;; i = j)
        {
          j = i;
          i = k;
          paramView = n.zWF;
          String str = ((com.tencent.mm.plugin.finder.extension.reddot.l)localObject).field_tipsId;
          paramView = aj.Bnu;
          paramView = this.tDl.getContext();
          p.j(paramView, "holder.context");
          paramView = aj.a.fZ(paramView);
          if (paramView != null)
          {
            paramView = paramView.ekY();
            n.a("7", i, 2, 2, j, m + n + i1 + i2, str, null, 0L, paramView, 0, 0, 3456);
            if ((localObject != null) && (localbkn != null))
            {
              paramView = com.tencent.mm.plugin.finder.report.l.zWx;
              paramView = aj.Bnu;
              paramView = this.tDl.getContext();
              p.j(paramView, "holder.context");
              paramView = aj.a.fZ(paramView);
              if (paramView == null) {
                break label441;
              }
            }
          }
          for (paramView = paramView.ekY();; paramView = null)
          {
            com.tencent.mm.plugin.finder.report.l.a("7", (com.tencent.mm.plugin.finder.extension.reddot.l)localObject, localbkn, 2, paramView, 0, 0, null, 224);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/convert/FinderFeedMsgNotifyConvert$onCreateViewHolder$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(165407);
            return;
            i = 1;
            j = 1;
            break;
            paramView = null;
            break label318;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.ad
 * JD-Core Version:    0.7.0.1
 */
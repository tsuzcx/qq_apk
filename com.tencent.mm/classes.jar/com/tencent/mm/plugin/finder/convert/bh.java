package com.tencent.mm.plugin.finder.convert;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ac.d;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.storage.ao;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC;
import com.tencent.mm.plugin.finder.viewmodel.component.FinderDebugUIC.a;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import kotlin.g.b.p;
import kotlin.l;
import org.json.JSONObject;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "layoutResId", "", "scene", "(II)V", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;I)V", "getLayoutId", "onBindViewHolder", "type", "isHotPatch", "", "payloads", "", "", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;IIZLjava/util/List;)V", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "showFinderMentionDialog", "context", "Landroid/content/Context;", "finderMention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "plugin-finder_release"})
public abstract class bh<T extends com.tencent.mm.plugin.finder.model.a>
  extends e<T>
{
  private final int scene;
  private final int tDB;
  
  public bh(int paramInt1, int paramInt2)
  {
    this.tDB = paramInt1;
    this.scene = paramInt2;
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
  }
  
  public abstract void a(h paramh, T paramT);
  
  public final int getLayoutId()
  {
    return this.tDB;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"})
  static final class a
    implements View.OnLongClickListener
  {
    a(bh parambh, h paramh, com.tencent.mm.plugin.finder.model.a parama) {}
    
    public final boolean onLongClick(View paramView)
    {
      AppMethodBeat.i(243190);
      Object localObject1 = new b();
      ((b)localObject1).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/convert/FinderMsgConvert$onBindViewHolder$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, ((b)localObject1).axR());
      paramView = this.qhp.getContext();
      p.g(paramView, "holder.context");
      Object localObject2 = this.tET.uNF;
      localObject1 = new JSONObject();
      ((JSONObject)localObject1).put("feedId", d.zs(((ao)localObject2).field_objectId));
      ((JSONObject)localObject1).put("feedTime", Util.formatUnixTime(((ao)localObject2).field_createTime * 1000L));
      ((JSONObject)localObject1).put("username", ((ao)localObject2).field_username);
      ((JSONObject)localObject1).put("nickName", ((ao)localObject2).field_nickname);
      ((JSONObject)localObject1).put("id", d.zs(((ao)localObject2).field_id));
      localObject2 = FinderDebugUIC.wvw;
      localObject1 = ((JSONObject)localObject1).toString();
      p.g(localObject1, "json.toString()");
      FinderDebugUIC.a.aG(paramView, (String)localObject1);
      com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/finder/convert/FinderMsgConvert$onBindViewHolder$6", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
      AppMethodBeat.o(243190);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bh
 * JD-Core Version:    0.7.0.1
 */
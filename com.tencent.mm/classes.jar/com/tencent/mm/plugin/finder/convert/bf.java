package com.tencent.mm.plugin.finder.convert;

import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bx.b;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.storage.av;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.protocal.protobuf.bpg;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.f;
import kotlin.Metadata;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderMsgConvert;", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "layoutResId", "", "scene", "(II)V", "canJumpProfile", "", "getCanJumpProfile", "()Z", "canJumpProfile$delegate", "Lkotlin/Lazy;", "convertMsg", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;I)V", "getLayoutId", "getThumbUrl", "", "finderMention", "Lcom/tencent/mm/plugin/finder/storage/LocalFinderMention;", "onBindViewHolder", "type", "isHotPatch", "payloads", "", "", "(Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;IIZLjava/util/List;)V", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "setThumbView", "thumbView", "Landroid/widget/ImageView;", "contextView", "Landroid/widget/TextView;", "showFinderMentionDialog", "context", "Landroid/content/Context;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class bf<T extends com.tencent.mm.plugin.finder.model.a>
  extends f<T>
{
  private final int AKy;
  private final kotlin.j ALk;
  private final int scene;
  
  public bf(int paramInt1, int paramInt2)
  {
    this.AKy = paramInt1;
    this.scene = paramInt2;
    this.ALk = k.cm((kotlin.g.a.a)a.ALl);
  }
  
  protected static void a(av paramav, ImageView paramImageView, TextView paramTextView)
  {
    kotlin.g.b.s.u(paramav, "finderMention");
    kotlin.g.b.s.u(paramImageView, "thumbView");
    kotlin.g.b.s.u(paramTextView, "contextView");
    paramTextView.setVisibility(8);
    kotlin.g.b.s.u(paramav, "finderMention");
    Object localObject1 = paramav.field_extInfo;
    if (localObject1 == null)
    {
      localObject1 = "";
      if (!kotlin.g.b.s.p(localObject1, "music")) {
        break label218;
      }
      localObject1 = paramav.field_extInfo;
      if (localObject1 != null) {
        break label167;
      }
      localObject1 = "";
    }
    for (;;)
    {
      Object localObject2 = com.tencent.mm.plugin.finder.loader.p.ExI;
      localObject2 = com.tencent.mm.plugin.finder.loader.p.eCl();
      com.tencent.mm.plugin.finder.loader.s locals = new com.tencent.mm.plugin.finder.loader.s((String)localObject1, v.FKZ);
      com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
      ((d)localObject2).a(locals, paramImageView, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExQ));
      if ((Util.isNullOrNil((String)localObject1)) && (paramav.field_mediaType == 1))
      {
        paramTextView.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b(paramTextView.getContext(), (CharSequence)paramav.field_description));
        paramTextView.setVisibility(0);
      }
      return;
      localObject2 = ((bpg)localObject1).appName;
      localObject1 = localObject2;
      if (localObject2 != null) {
        break;
      }
      localObject1 = "";
      break;
      label167:
      localObject1 = ((bpg)localObject1).ZXS;
      if (localObject1 == null)
      {
        localObject1 = "";
      }
      else
      {
        localObject2 = com.tencent.mm.plugin.finder.uniComments.util.a.Gbq;
        localObject1 = ((b)localObject1).Op;
        kotlin.g.b.s.s(localObject1, "it.bytes");
        localObject2 = com.tencent.mm.plugin.finder.uniComments.util.a.bV((byte[])localObject1);
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = "";
          continue;
          label218:
          localObject2 = paramav.field_thumbUrl;
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
        }
      }
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.j paramj, int paramInt)
  {
    kotlin.g.b.s.u(paramRecyclerView, "recyclerView");
    kotlin.g.b.s.u(paramj, "holder");
  }
  
  public abstract void a(com.tencent.mm.view.recyclerview.j paramj, T paramT);
  
  public final int getLayoutId()
  {
    return this.AKy;
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/plugin/finder/model/BaseFinderMsg;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<Boolean>
  {
    public static final a ALl;
    
    static
    {
      AppMethodBeat.i(349713);
      ALl = new a();
      AppMethodBeat.o(349713);
    }
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.bf
 * JD-Core Version:    0.7.0.1
 */
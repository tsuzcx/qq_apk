package com.tencent.mm.plugin.finder.convert;

import android.content.Context;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.model.BaseFinderFeed;
import com.tencent.mm.plugin.finder.model.bt;
import com.tencent.mm.plugin.finder.profile.uic.e;
import com.tencent.mm.plugin.finder.storage.FinderItem;
import com.tencent.mm.plugin.finder.storage.aj;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.bqj;
import com.tencent.mm.protocal.protobuf.dtj;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.view.e.b;
import com.tencent.mm.view.recyclerview.j;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import kotlin.Metadata;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileQQMusicConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/FinderQQMusicInfoData;", "()V", "isSelfFlag", "", "()Ljava/lang/Boolean;", "setSelfFlag", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "getLayoutId", "", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "payloads", "", "", "onCreateViewHolder", "setImage", "thumbUrl", "", "imageView", "Landroid/widget/ImageView;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class cd
  extends com.tencent.mm.view.recyclerview.f<bt>
{
  public static final a AMe;
  public Boolean ALZ;
  private RecyclerView mkw;
  
  static
  {
    AppMethodBeat.i(349748);
    AMe = new a((byte)0);
    AppMethodBeat.o(349748);
  }
  
  private static final void a(bqj parambqj, bt parambt, j paramj, ah.f paramf, View paramView)
  {
    AppMethodBeat.i(349742);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(parambqj);
    localb.cH(parambt);
    localb.cH(paramj);
    localb.cH(paramf);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/convert/FinderProfileQQMusicConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(parambt, "$item");
    s.u(paramj, "$holder");
    s.u(paramf, "$coverUrl");
    if (parambqj != null)
    {
      paramView = d.hF(parambt.feedObject.getFinderObject().id);
      localObject = new dtj();
      ((dtj)localObject).YqN = paramView;
      ((dtj)localObject).YqO = parambt.feedObject.getFinderObject().objectNonceId;
      ((dtj)localObject).YqP = ((String)paramf.aqH);
      parambt = parambt.feedObject.getFinderObject().contact;
      if (parambt != null) {
        break label356;
      }
    }
    label356:
    for (parambt = null;; parambt = parambt.nickname)
    {
      ((dtj)localObject).YqQ = parambt;
      ((dtj)localObject).singerName = parambqj.artist;
      ((dtj)localObject).albumName = parambqj.albumName;
      ((dtj)localObject).LNC = parambqj.ZYs;
      ((dtj)localObject).songName = parambqj.name;
      ((dtj)localObject).RfH = parambqj.ZYo;
      ((dtj)localObject).oPc = ((String)paramf.aqH);
      paramf = parambqj.HsD;
      parambt = paramf;
      if (paramf == null) {
        parambt = "";
      }
      ((dtj)localObject).oOZ = parambt;
      parambt = k.aeZF;
      parambt = paramj.context;
      s.s(parambt, "holder.context");
      ((com.tencent.mm.plugin.finder.profile.uic.f)k.nq(parambt).q(com.tencent.mm.plugin.finder.profile.uic.f.class)).eJf();
      parambt = aj.FMk;
      aj.a(parambqj, paramView, (dtj)localObject);
      parambqj = k.aeZF;
      parambqj = paramj.context;
      s.s(parambqj, "holder.context");
      ((e)k.nq(parambqj).q(e.class)).O("music_play", 1, paramView);
      a.a(new Object(), "com/tencent/mm/plugin/finder/convert/FinderProfileQQMusicConvert", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(349742);
      return;
    }
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(349767);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    this.mkw = paramRecyclerView;
    AppMethodBeat.o(349767);
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_profile_qq_music_item;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/convert/FinderProfileQQMusicConvert$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/convert/FinderProfileQQMusicConvert$onBindViewHolder$5", "Lcom/tencent/mm/view/ExposeElves$OnViewExposedListener;", "getExposedId", "", "view", "Landroid/view/View;", "onViewExposed", "", "oldExposedId", "newExposedId", "isExposed", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends e.b
  {
    b(j paramj, String paramString, bt parambt) {}
    
    private static final void f(j paramj, String paramString)
    {
      AppMethodBeat.i(350397);
      s.u(paramj, "$holder");
      s.u(paramString, "$songId");
      Object localObject = k.aeZF;
      localObject = paramj.context;
      s.s(localObject, "holder.context");
      ((e)k.nq((Context)localObject).q(e.class)).O("music_card", 0, paramString);
      localObject = k.aeZF;
      paramj = paramj.context;
      s.s(paramj, "holder.context");
      ((e)k.nq(paramj).q(e.class)).O("music_play", 0, paramString);
      AppMethodBeat.o(350397);
    }
    
    public final void a(View paramView, long paramLong1, long paramLong2, boolean paramBoolean)
    {
      AppMethodBeat.i(350402);
      s.u(paramView, "view");
      if (paramBoolean) {
        h.ahAA.bm(new cd.b..ExternalSyntheticLambda0(this.wHm, this.AMf));
      }
      AppMethodBeat.o(350402);
    }
    
    public final long fq(View paramView)
    {
      AppMethodBeat.i(350406);
      s.u(paramView, "view");
      long l = this.AMg.feedObject.getFinderObject().id;
      AppMethodBeat.o(350406);
      return l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.convert.cd
 * JD-Core Version:    0.7.0.1
 */
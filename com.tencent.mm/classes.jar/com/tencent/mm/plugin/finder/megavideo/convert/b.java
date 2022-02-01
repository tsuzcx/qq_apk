package com.tencent.mm.plugin.finder.megavideo.convert;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.loader.n;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.model.ca;
import com.tencent.mm.plugin.finder.storage.data.i;
import com.tencent.mm.plugin.finder.storage.v;
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.dji;
import com.tencent.mm.protocal.protobuf.dne;
import com.tencent.mm.protocal.protobuf.dnh;
import com.tencent.mm.protocal.protobuf.dnv;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.f;
import com.tencent.mm.view.recyclerview.j;
import java.util.List;
import java.util.List<Ljava.lang.Object;>;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoListItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "()V", "getLayoutId", "", "makeTimeString", "", "d", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public class b
  extends f<ca>
{
  private static String Bf(int paramInt)
  {
    AppMethodBeat.i(342287);
    if (paramInt < 10)
    {
      String str = s.X("0", Integer.valueOf(paramInt));
      AppMethodBeat.o(342287);
      return str;
    }
    AppMethodBeat.o(342287);
    return String.valueOf(paramInt);
  }
  
  public final void a(RecyclerView paramRecyclerView, j paramj, int paramInt)
  {
    AppMethodBeat.i(342299);
    s.u(paramRecyclerView, "recyclerView");
    s.u(paramj, "holder");
    AppMethodBeat.o(342299);
  }
  
  public void a(j paramj, ca paramca, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(342316);
    s.u(paramj, "holder");
    s.u(paramca, "item");
    paramList = paramca.ABK;
    Object localObject1;
    Object localObject3;
    long l;
    if (paramList != null)
    {
      paramList = paramList.aaUt;
      if (paramList != null)
      {
        paramList = paramList.media;
        if (paramList != null)
        {
          paramList = (dnv)kotlin.a.p.oL((List)paramList);
          if (paramList != null)
          {
            paramList = i.a(paramList);
            if (paramList != null)
            {
              localObject1 = (ImageView)paramj.UH(e.e.thumb_iv);
              if (localObject1 != null)
              {
                localObject2 = new n(paramList, v.FKZ, null, null, 12);
                localObject3 = com.tencent.mm.plugin.finder.loader.p.ExI;
                localObject3 = com.tencent.mm.plugin.finder.loader.p.eCl();
                com.tencent.mm.plugin.finder.loader.p localp = com.tencent.mm.plugin.finder.loader.p.ExI;
                ((com.tencent.mm.loader.d)localObject3).a(localObject2, (ImageView)localObject1, com.tencent.mm.plugin.finder.loader.p.a(p.a.ExJ));
              }
              localObject1 = (TextView)paramj.UH(e.e.video_duration_tv);
              if (localObject1 != null)
              {
                paramInt2 = paramList.videoDuration;
                l = paramInt2;
                paramList = com.tencent.mm.plugin.finder.storage.d.FAy;
                paramInt1 = paramInt2;
                if (l >= com.tencent.mm.plugin.finder.storage.d.eRl() * 1000L) {
                  paramInt1 = paramInt2 / 1000;
                }
                ((TextView)localObject1).setText((CharSequence)(Bf(paramInt1 / 60) + ':' + Bf(paramInt1 % 60)));
              }
              Object localObject2 = (TextView)paramj.UH(e.e.video_desc_tv);
              if (localObject2 != null)
              {
                paramList = paramca.ABK;
                if (paramList != null) {
                  break label514;
                }
                paramList = null;
                if (!Util.isNullOrNil(paramList)) {
                  break label552;
                }
                localObject1 = ((TextView)localObject2).getResources();
                paramInt1 = e.h.mega_video_post_ui_desc_tv_hint;
                localObject3 = ((TextView)localObject2).getContext();
                paramList = paramca.contact;
                if (paramList != null) {
                  break label542;
                }
                paramList = null;
                label319:
                paramList = (CharSequence)((Resources)localObject1).getString(paramInt1, new Object[] { com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject3, (CharSequence)paramList) });
                ((TextView)localObject2).setText(paramList);
              }
              paramList = (TextView)paramj.UH(e.e.video_expose_times_tv);
              if (paramList != null)
              {
                localObject1 = r.TP(paramca.getFeedObject().likeCount);
                paramList.setText((CharSequence)paramj.context.getResources().getString(e.h.finder_mega_video_list_item_like_count_text, new Object[] { localObject1 }));
              }
              paramList = (TextView)paramj.UH(e.e.video_create_time_tv);
              if (paramList != null)
              {
                paramj = paramj.context;
                paramca = paramca.ABK;
                if (paramca != null) {
                  break label636;
                }
                l = 0L;
                label447:
                paramj = r.f(paramj, l * 1000L);
                if (TextUtils.isEmpty((CharSequence)paramj)) {
                  break label646;
                }
                paramInt1 = 1;
                label470:
                if (paramInt1 == 0) {
                  break label651;
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      paramca = new StringBuilder();
      paramca.append("·");
      paramca.append(paramj);
      paramList.setText((CharSequence)paramca.toString());
      AppMethodBeat.o(342316);
      return;
      label514:
      paramList = paramList.aaUt;
      if (paramList == null)
      {
        paramList = null;
        break;
      }
      paramList = paramList.description;
      break;
      label542:
      paramList = paramList.nickname;
      break label319;
      label552:
      localObject3 = paramj.context;
      paramList = paramca.ABK;
      if (paramList == null) {
        paramList = "";
      }
      for (;;)
      {
        paramList = (CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject3, (CharSequence)paramList);
        break;
        paramList = paramList.aaUt;
        if (paramList == null)
        {
          paramList = "";
        }
        else
        {
          localObject1 = paramList.description;
          paramList = (List<Object>)localObject1;
          if (localObject1 == null) {
            paramList = "";
          }
        }
      }
      label636:
      l = paramca.createTime;
      break label447;
      label646:
      paramInt1 = 0;
      break label470;
      label651:
      paramj = null;
    }
  }
  
  public int getLayoutId()
  {
    return e.f.finder_mega_video_list_item;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.convert.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.finder.megavideo.convert;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.loader.r;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.model.bs;
import com.tencent.mm.plugin.finder.storage.u;
import com.tencent.mm.plugin.finder.utils.m;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.csg;
import com.tencent.mm.protocal.protobuf.cvy;
import com.tencent.mm.protocal.protobuf.cwc;
import com.tencent.mm.protocal.protobuf.cwq;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.e;
import java.util.List;
import kotlin.a.j;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoListItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "()V", "getLayoutId", "", "makeTimeString", "", "d", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "plugin-finder_release"})
public class b
  extends e<bs>
{
  private static String AQ(int paramInt)
  {
    AppMethodBeat.i(289508);
    if (paramInt < 10)
    {
      str = "0".concat(String.valueOf(paramInt));
      AppMethodBeat.o(289508);
      return str;
    }
    String str = String.valueOf(paramInt);
    AppMethodBeat.o(289508);
    return str;
  }
  
  public final void a(RecyclerView paramRecyclerView, com.tencent.mm.view.recyclerview.i parami, int paramInt)
  {
    AppMethodBeat.i(289505);
    p.k(paramRecyclerView, "recyclerView");
    p.k(parami, "holder");
    AppMethodBeat.o(289505);
  }
  
  public void a(com.tencent.mm.view.recyclerview.i parami, bs parambs, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(289506);
    p.k(parami, "holder");
    p.k(parambs, "item");
    paramList = parambs.xcy;
    if (paramList != null)
    {
      paramList = paramList.TEM;
      if (paramList != null)
      {
        paramList = paramList.media;
        if (paramList != null)
        {
          paramList = (cwq)j.lp((List)paramList);
          if (paramList != null)
          {
            paramList = com.tencent.mm.plugin.finder.storage.data.i.a(paramList);
            Object localObject1 = (ImageView)parami.RD(b.f.thumb_iv);
            Object localObject2;
            Object localObject3;
            if (localObject1 != null)
            {
              localObject2 = new r(paramList, u.Alz, null, null, 12);
              localObject3 = t.ztT;
              localObject3 = t.dJe();
              t localt = t.ztT;
              ((com.tencent.mm.loader.d)localObject3).a(localObject2, (ImageView)localObject1, t.a(t.a.ztU));
            }
            localObject1 = (TextView)parami.RD(b.f.video_duration_tv);
            long l;
            if (localObject1 != null)
            {
              paramInt2 = paramList.videoDuration;
              l = paramInt2;
              paramList = com.tencent.mm.plugin.finder.storage.d.AjH;
              paramInt1 = paramInt2;
              if (l >= com.tencent.mm.plugin.finder.storage.d.dSX() * 1000L) {
                paramInt1 = paramInt2 / 1000;
              }
              ((TextView)localObject1).setText((CharSequence)(AQ(paramInt1 / 60) + ":" + AQ(paramInt1 % 60)));
            }
            localObject1 = (TextView)parami.RD(b.f.video_desc_tv);
            if (localObject1 != null)
            {
              paramList = parambs.xcy;
              if (paramList != null)
              {
                paramList = paramList.TEM;
                if (paramList != null)
                {
                  paramList = paramList.description;
                  if (!Util.isNullOrNil(paramList)) {
                    break label557;
                  }
                  localObject2 = ((TextView)localObject1).getResources();
                  paramInt1 = b.j.mega_video_post_ui_desc_tv_hint;
                  localObject3 = ((TextView)localObject1).getContext();
                  paramList = parambs.contact;
                  if (paramList == null) {
                    break label551;
                  }
                  paramList = paramList.nickname;
                  label334:
                  paramList = (CharSequence)((Resources)localObject2).getString(paramInt1, new Object[] { com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject3, (CharSequence)paramList) });
                  ((TextView)localObject1).setText(paramList);
                }
              }
            }
            else
            {
              paramList = (TextView)parami.RD(b.f.video_expose_times_tv);
              if (paramList != null)
              {
                localObject1 = m.QF(parambs.getFeedObject().likeCount);
                localObject2 = parami.getContext();
                p.j(localObject2, "holder.context");
                paramList.setText((CharSequence)((Context)localObject2).getResources().getString(b.j.finder_mega_video_list_item_like_count_text, new Object[] { localObject1 }));
              }
              paramList = (TextView)parami.RD(b.f.video_create_time_tv);
              if (paramList == null) {
                break label647;
              }
              parami = parami.getContext();
              parambs = parambs.xcy;
              if (parambs == null) {
                break label631;
              }
              l = parambs.createTime;
              label478:
              parami = m.f(parami, l * 1000L);
              if (TextUtils.isEmpty((CharSequence)parami)) {
                break label637;
              }
              paramInt1 = 1;
              label501:
              if (paramInt1 == 0) {
                break label642;
              }
            }
            for (;;)
            {
              parambs = new StringBuilder();
              parambs.append("·");
              parambs.append(parami);
              paramList.setText((CharSequence)parambs.toString());
              AppMethodBeat.o(289506);
              return;
              paramList = null;
              break;
              label551:
              paramList = null;
              break label334;
              label557:
              localObject2 = parami.getContext();
              paramList = parambs.xcy;
              if (paramList != null)
              {
                paramList = paramList.TEM;
                if (paramList != null)
                {
                  paramList = paramList.description;
                  if (paramList == null) {}
                }
              }
              for (paramList = (CharSequence)paramList;; paramList = (CharSequence)"")
              {
                paramList = (CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject2, paramList);
                break;
              }
              label631:
              l = 0L;
              break label478;
              label637:
              paramInt1 = 0;
              break label501;
              label642:
              parami = null;
            }
            label647:
            AppMethodBeat.o(289506);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(289506);
  }
  
  public int getLayoutId()
  {
    return b.g.finder_mega_video_list_item;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.convert.b
 * JD-Core Version:    0.7.0.1
 */
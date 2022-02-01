package com.tencent.mm.plugin.finder.megavideo.convert;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.d;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.model.bm;
import com.tencent.mm.plugin.finder.storage.c;
import com.tencent.mm.plugin.finder.storage.x;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.FinderObject;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.cnl;
import com.tencent.mm.protocal.protobuf.cod;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.view.recyclerview.e;
import com.tencent.mm.view.recyclerview.h;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/megavideo/convert/FinderMegaVideoListItemConvert;", "Lcom/tencent/mm/view/recyclerview/ItemConvert;", "Lcom/tencent/mm/plugin/finder/model/MegaVideoFeed;", "()V", "getLayoutId", "", "makeTimeString", "", "d", "onBindViewHolder", "", "holder", "Lcom/tencent/mm/view/recyclerview/SimpleViewHolder;", "item", "position", "type", "isHotPatch", "", "payloads", "", "", "onCreateViewHolder", "recyclerView", "Landroid/support/v7/widget/RecyclerView;", "plugin-finder_release"})
public class b
  extends e<bm>
{
  private static String xt(int paramInt)
  {
    AppMethodBeat.i(248344);
    if (paramInt < 10)
    {
      str = "0".concat(String.valueOf(paramInt));
      AppMethodBeat.o(248344);
      return str;
    }
    String str = String.valueOf(paramInt);
    AppMethodBeat.o(248344);
    return str;
  }
  
  public final void a(RecyclerView paramRecyclerView, h paramh, int paramInt)
  {
    AppMethodBeat.i(248341);
    p.h(paramRecyclerView, "recyclerView");
    p.h(paramh, "holder");
    AppMethodBeat.o(248341);
  }
  
  public void a(h paramh, bm parambm, int paramInt1, int paramInt2, boolean paramBoolean, List<Object> paramList)
  {
    AppMethodBeat.i(248342);
    p.h(paramh, "holder");
    p.h(parambm, "item");
    paramList = parambm.tuP;
    if (paramList != null)
    {
      paramList = paramList.MtG;
      if (paramList != null)
      {
        paramList = paramList.media;
        if (paramList != null)
        {
          paramList = (cod)kotlin.a.j.kt((List)paramList);
          if (paramList != null)
          {
            paramList = com.tencent.mm.plugin.finder.storage.data.j.a(paramList);
            Object localObject1 = (ImageView)paramh.Mn(2131309073);
            Object localObject2;
            Object localObject3;
            if (localObject1 != null)
            {
              localObject2 = new com.tencent.mm.plugin.finder.loader.k(paramList, x.vEo, null, null, 12);
              localObject3 = m.uJa;
              localObject3 = m.djY();
              m localm = m.uJa;
              ((d)localObject3).a(localObject2, (ImageView)localObject1, m.a(m.a.uJb));
            }
            localObject1 = (TextView)paramh.Mn(2131309756);
            long l;
            if (localObject1 != null)
            {
              paramInt2 = paramList.videoDuration;
              l = paramInt2;
              paramList = c.vCb;
              paramInt1 = paramInt2;
              if (l >= c.drG() * 1000L) {
                paramInt1 = paramInt2 / 1000;
              }
              ((TextView)localObject1).setText((CharSequence)(xt(paramInt1 / 60) + ":" + xt(paramInt1 % 60)));
            }
            localObject1 = (TextView)paramh.Mn(2131309748);
            if (localObject1 != null)
            {
              paramList = parambm.tuP;
              if (paramList != null)
              {
                paramList = paramList.MtG;
                if (paramList != null)
                {
                  paramList = paramList.description;
                  if (!Util.isNullOrNil(paramList)) {
                    break label549;
                  }
                  localObject2 = ((TextView)localObject1).getResources();
                  localObject3 = ((TextView)localObject1).getContext();
                  paramList = parambm.contact;
                  if (paramList == null) {
                    break label543;
                  }
                  paramList = paramList.nickname;
                  label327:
                  paramList = (CharSequence)((Resources)localObject2).getString(2131763020, new Object[] { com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject3, (CharSequence)paramList) });
                  ((TextView)localObject1).setText(paramList);
                }
              }
            }
            else
            {
              paramList = (TextView)paramh.Mn(2131309765);
              if (paramList != null)
              {
                localObject1 = com.tencent.mm.plugin.finder.utils.k.Lv(parambm.getFeedObject().likeCount);
                localObject2 = paramh.getContext();
                p.g(localObject2, "holder.context");
                paramList.setText((CharSequence)((Context)localObject2).getResources().getString(2131760247, new Object[] { localObject1 }));
              }
              paramList = (TextView)paramh.Mn(2131309742);
              if (paramList == null) {
                break label639;
              }
              paramh = paramh.getContext();
              parambm = parambm.tuP;
              if (parambm == null) {
                break label623;
              }
              l = parambm.iXu;
              label470:
              paramh = com.tencent.mm.plugin.finder.utils.k.f(paramh, l * 1000L);
              if (TextUtils.isEmpty((CharSequence)paramh)) {
                break label629;
              }
              paramInt1 = 1;
              label493:
              if (paramInt1 == 0) {
                break label634;
              }
            }
            for (;;)
            {
              parambm = new StringBuilder();
              parambm.append("·");
              parambm.append(paramh);
              paramList.setText((CharSequence)parambm.toString());
              AppMethodBeat.o(248342);
              return;
              paramList = null;
              break;
              label543:
              paramList = null;
              break label327;
              label549:
              localObject2 = paramh.getContext();
              paramList = parambm.tuP;
              if (paramList != null)
              {
                paramList = paramList.MtG;
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
              label623:
              l = 0L;
              break label470;
              label629:
              paramInt1 = 0;
              break label493;
              label634:
              paramh = null;
            }
            label639:
            AppMethodBeat.o(248342);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(248342);
  }
  
  public int getLayoutId()
  {
    return 2131494507;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.megavideo.convert.b
 * JD-Core Version:    0.7.0.1
 */
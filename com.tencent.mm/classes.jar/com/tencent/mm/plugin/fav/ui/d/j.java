package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.l.2;
import com.tencent.mm.plugin.fav.ui.n.c;
import com.tencent.mm.plugin.fav.ui.n.d;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.f;
import com.tencent.mm.plugin.fav.ui.n.h;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.protocal.c.yc;
import com.tencent.mm.protocal.c.yi;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yl;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends a
{
  private HashMap<String, SpannableString> kiT = new HashMap();
  private final int kiw;
  
  public j(l paraml)
  {
    super(paraml);
    this.kiw = com.tencent.mm.cb.a.aa(paraml.context, n.c.FavImageSize);
  }
  
  private static String C(Context paramContext, int paramInt)
  {
    return "[" + paramContext.getResources().getString(paramInt) + "]";
  }
  
  private static void a(TextView paramTextView1, TextView paramTextView2, xv paramxv)
  {
    if (!paramxv.sVD)
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.FavRecordListItem", "has no datasrcname");
      paramTextView1.setVisibility(8);
    }
    for (;;)
    {
      com.tencent.mm.sdk.platformtools.y.d("MicroMsg.FavRecordListItem", "field type %d", new Object[] { Integer.valueOf(paramxv.aYU) });
      switch (paramxv.aYU)
      {
      case 9: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 18: 
      default: 
        return;
        paramTextView1.setVisibility(0);
        paramTextView1.setText(com.tencent.mm.pluginsdk.ui.d.j.a(paramTextView1.getContext(), paramxv.sVC, paramTextView1.getTextSize()));
      }
    }
    paramTextView2.setText(com.tencent.mm.pluginsdk.ui.d.j.a(paramTextView2.getContext(), paramxv.desc, paramTextView2.getTextSize()));
    return;
    paramTextView2.setText(C(paramTextView2.getContext(), n.i.favorite_sub_title_voice));
    return;
    paramTextView2.setText(C(paramTextView2.getContext(), n.i.favorite_sub_title_url) + paramxv.title);
    return;
    paramTextView2.setText(C(paramTextView2.getContext(), n.i.favorite_sub_title_music) + paramxv.title);
    return;
    paramTextView1 = paramxv.sVA.sWf;
    paramxv = new StringBuilder().append(C(paramTextView2.getContext(), n.i.favorite_sub_title_location));
    if (bk.bl(paramTextView1.bVA)) {}
    for (paramTextView1 = paramTextView1.label;; paramTextView1 = paramTextView1.bVA)
    {
      paramTextView2.setText(paramTextView1);
      return;
    }
    paramTextView2.setText(C(paramTextView2.getContext(), n.i.favorite_sub_title_file) + paramxv.title);
    return;
    paramTextView2.setText(C(paramTextView2.getContext(), n.i.favorite_sight));
    return;
    paramTextView2.setText(C(paramTextView2.getContext(), n.i.favorite_sub_title_video));
    return;
    paramTextView2.setText(C(paramTextView2.getContext(), n.i.favorite_sub_title_image));
    return;
    paramTextView2.setText(C(paramTextView2.getContext(), n.i.favorite_mall_product) + paramxv.sVA.sWj.title);
    return;
    paramTextView2.setText(C(paramTextView2.getContext(), n.i.favorite_friend_card));
    return;
    paramTextView2.setText(C(paramTextView2.getContext(), n.i.favorite_sub_title_record));
    return;
    paramTextView2.setText(C(paramTextView2.getContext(), n.i.favorite_sub_app_brand) + paramxv.title);
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    Object localObject = paramViewGroup.getContext();
    int m;
    int i;
    boolean bool;
    LinkedList localLinkedList;
    int k;
    int j;
    label193:
    int n;
    if (paramView == null)
    {
      paramViewGroup = new j.a();
      localObject = a(View.inflate((Context)localObject, n.f.fav_listitem_record, null), paramViewGroup, paramg);
      paramViewGroup.gSx = ((ImageView)((View)localObject).findViewById(n.e.fav_icon));
      paramViewGroup.kiV = ((TextView)((View)localObject).findViewById(n.e.fav_title1));
      paramViewGroup.kiW = ((TextView)((View)localObject).findViewById(n.e.fav_desc1));
      paramViewGroup.kiX = ((TextView)((View)localObject).findViewById(n.e.fav_title2));
      paramViewGroup.kiY = ((TextView)((View)localObject).findViewById(n.e.fav_desc2));
      paramViewGroup.kiI = ((ImageView)((View)localObject).findViewById(n.e.fav_icon_video_mask));
      paramViewGroup.kiU = ((ImageView)((View)localObject).findViewById(n.e.fav_icon_shortvideo));
      paramViewGroup.kiZ = ((FrameLayout)((View)localObject).findViewById(n.e.fav_icon_fl));
      a(paramViewGroup, paramg);
      m = 0;
      i = 0;
      bool = false;
      localLinkedList = paramg.field_favProto.sXc;
      paramView = localLinkedList.iterator();
      k = 0;
      j = 0;
      if (!paramView.hasNext()) {
        break label389;
      }
      switch (((xv)paramView.next()).aYU)
      {
      case 9: 
      case 12: 
      case 13: 
      default: 
        label296:
        n = k;
        k = j;
        j = n;
      }
    }
    for (;;)
    {
      n = i + 1;
      i = j;
      j = k;
      k = i;
      i = n;
      break label193;
      paramViewGroup = (j.a)paramView.getTag();
      localObject = paramView;
      break;
      if (bool) {
        break label296;
      }
      bool = true;
      n = k;
      m = i;
      k = j;
      j = n;
      continue;
      if (k != 0) {
        break label296;
      }
      j = 1;
      k = i;
    }
    label389:
    com.tencent.mm.sdk.platformtools.y.d("MicroMsg.FavRecordListItem", "hasThumb %s, firstRemarkIndex %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j) });
    if (localLinkedList.size() <= 0)
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.FavRecordListItem", "dataList size is null");
      return localObject;
    }
    paramView = (xv)localLinkedList.get(j);
    a(paramViewGroup.kiV, paramViewGroup.kiW, paramView);
    ImageView localImageView;
    xv localxv;
    l locall;
    if (bool)
    {
      paramViewGroup.kiZ.setVisibility(0);
      paramViewGroup.gSx.setVisibility(0);
      localImageView = paramViewGroup.gSx;
      localxv = (xv)localLinkedList.get(m);
      switch (localxv.aYU)
      {
      default: 
      case 2: 
        for (;;)
        {
          if (j + 1 < localLinkedList.size())
          {
            paramViewGroup.kiX.setVisibility(0);
            paramViewGroup.kiY.setVisibility(0);
            a(paramViewGroup.kiX, paramViewGroup.kiY, (xv)localLinkedList.get(j + 1));
            return localObject;
            locall = this.kbg;
            i = n.h.record_nopicture_icon;
            k = this.kiw;
            m = this.kiw;
            if (localImageView != null) {
              if (!f.zF())
              {
                localImageView.setImageResource(n.d.nosdcard_chatting_bg);
              }
              else if ((localxv != null) && (paramg != null))
              {
                String str = localxv.kgC;
                if (str != null)
                {
                  paramView = null;
                  if (localxv.kgC != null)
                  {
                    paramView = (String[])locall.kdL.get(str);
                    if (paramView != null) {
                      break label851;
                    }
                    paramView = new String[2];
                    paramView[0] = b.b(localxv);
                    paramView[1] = b.c(localxv);
                    locall.kdL.put(str, paramView);
                  }
                }
              }
            }
          }
        }
      }
    }
    label851:
    for (;;)
    {
      locall.kdK.a(localImageView, paramView, null, i, k, m);
      if ((paramView == null) || (paramView.length <= 0)) {
        break;
      }
      paramView = paramView[0];
      com.tencent.mm.kernel.g.DS().O(new l.2(locall, paramView, paramg, localxv));
      break;
      this.kbg.b(localImageView, localxv, paramg, n.h.app_attach_file_icon_video, this.kiw, this.kiw);
      break;
      paramViewGroup.kiZ.setVisibility(8);
      paramViewGroup.gSx.setVisibility(8);
      break;
      paramViewGroup.kiX.setVisibility(8);
      paramViewGroup.kiY.setVisibility(8);
      return localObject;
    }
  }
  
  public final void a(View paramView, yl paramyl)
  {
    j.a locala = (j.a)paramView.getTag();
    paramView = paramView.getContext();
    ((com.tencent.mm.plugin.fav.a.y)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.fav.a.y.class)).a(paramView, locala.jZN, paramyl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.j
 * JD-Core Version:    0.7.0.1
 */
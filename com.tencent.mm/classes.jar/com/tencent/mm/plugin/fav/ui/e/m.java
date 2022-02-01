package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.fav.ui.s.c;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.fav.ui.s.f;
import com.tencent.mm.plugin.fav.ui.s.h;
import com.tencent.mm.plugin.fav.ui.s.i;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.ann;
import com.tencent.mm.protocal.protobuf.ant;
import com.tencent.mm.protocal.protobuf.aob;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class m
  extends b
{
  private final int wRA;
  private HashMap<String, SpannableString> wSl;
  
  public m(o paramo)
  {
    super(paramo);
    AppMethodBeat.i(107477);
    this.wSl = new HashMap();
    this.wRA = a.aY(paramo.context, s.c.FavImageSize);
    AppMethodBeat.o(107477);
  }
  
  private static void a(TextView paramTextView1, TextView paramTextView2, anm paramanm)
  {
    AppMethodBeat.i(107479);
    if (!paramanm.SyJ)
    {
      Log.d("MicroMsg.FavRecordListItem", "has no datasrcname");
      paramTextView1.setVisibility(8);
      Log.d("MicroMsg.FavRecordListItem", "field type %d", new Object[] { Integer.valueOf(paramanm.dataType) });
      switch (paramanm.dataType)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(107479);
      return;
      paramTextView1.setVisibility(0);
      paramTextView1.setText(l.b(paramTextView1.getContext(), paramanm.SyI, paramTextView1.getTextSize()));
      break;
      paramTextView2.setText(l.b(paramTextView2.getContext(), paramanm.desc, paramTextView2.getTextSize()));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(ac(paramTextView2.getContext(), s.i.favorite_sub_title_voice));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(ac(paramTextView2.getContext(), s.i.favorite_sub_title_url) + paramanm.title);
      AppMethodBeat.o(107479);
      return;
      if (com.tencent.mm.plugin.fav.a.b.djw())
      {
        paramTextView2.setText("");
        AppMethodBeat.o(107479);
        return;
      }
      paramTextView2.setText(ac(paramTextView2.getContext(), s.i.favorite_sub_title_url) + Util.nullAsNil(paramanm.title));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(ac(paramTextView2.getContext(), s.i.favorite_sub_title_music) + paramanm.title);
      AppMethodBeat.o(107479);
      return;
      paramTextView1 = paramanm.SyG.Szp;
      paramanm = new StringBuilder().append(ac(paramTextView2.getContext(), s.i.favorite_sub_title_location));
      if (Util.isNullOrNil(paramTextView1.fPN)) {}
      for (paramTextView1 = paramTextView1.label;; paramTextView1 = paramTextView1.fPN)
      {
        paramTextView2.setText(paramTextView1);
        AppMethodBeat.o(107479);
        return;
      }
      paramTextView2.setText(ac(paramTextView2.getContext(), s.i.favorite_sub_title_file) + paramanm.title);
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(ac(paramTextView2.getContext(), s.i.favorite_sight));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(ac(paramTextView2.getContext(), s.i.favorite_sub_title_video));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(ac(paramTextView2.getContext(), s.i.favorite_sub_title_image));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(ac(paramTextView2.getContext(), s.i.favorite_mall_product) + paramanm.SyG.Szt.title);
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(ac(paramTextView2.getContext(), s.i.favorite_friend_card));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(ac(paramTextView2.getContext(), s.i.favorite_sub_title_record));
      AppMethodBeat.o(107479);
      return;
      paramTextView2.setText(ac(paramTextView2.getContext(), s.i.favorite_sub_app_brand) + paramanm.title);
    }
  }
  
  private static String ac(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(107480);
    paramContext = "[" + paramContext.getResources().getString(paramInt) + "]";
    AppMethodBeat.o(107480);
    return paramContext;
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, g paramg)
  {
    AppMethodBeat.i(107478);
    Object localObject1 = paramViewGroup.getContext();
    int m;
    int i;
    boolean bool;
    int k;
    int j;
    label190:
    label344:
    int n;
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate((Context)localObject1, s.f.fav_listitem_record, null), paramViewGroup, paramg);
      paramViewGroup.qps = ((ImageView)paramView.findViewById(s.e.fav_icon));
      paramViewGroup.wSn = ((TextView)paramView.findViewById(s.e.fav_title1));
      paramViewGroup.wSo = ((TextView)paramView.findViewById(s.e.fav_desc1));
      paramViewGroup.wSp = ((TextView)paramView.findViewById(s.e.fav_title2));
      paramViewGroup.wSq = ((TextView)paramView.findViewById(s.e.fav_desc2));
      paramViewGroup.wSa = ((ImageView)paramView.findViewById(s.e.fav_icon_video_mask));
      paramViewGroup.wSm = ((ImageView)paramView.findViewById(s.e.fav_icon_shortvideo));
      paramViewGroup.wSr = ((FrameLayout)paramView.findViewById(s.e.fav_icon_fl));
      a(paramViewGroup, paramg);
      m = 0;
      i = 0;
      bool = false;
      localObject1 = paramg.field_favProto.syG;
      localObject2 = ((List)localObject1).iterator();
      k = 0;
      j = 0;
      if (!((Iterator)localObject2).hasNext()) {
        break label434;
      }
      switch (((anm)((Iterator)localObject2).next()).dataType)
      {
      case 9: 
      case 12: 
      case 13: 
      case 18: 
      case 19: 
      case 20: 
      case 21: 
      case 23: 
      case 24: 
      case 25: 
      case 26: 
      case 27: 
      case 28: 
      default: 
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
      break label190;
      paramViewGroup = (a)paramView.getTag();
      break;
      if (bool) {
        break label344;
      }
      bool = true;
      n = k;
      m = i;
      k = j;
      j = n;
      continue;
      if (k != 0) {
        break label344;
      }
      j = 1;
      k = i;
    }
    label434:
    Log.d("MicroMsg.FavRecordListItem", "hasThumb %s, firstRemarkIndex %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j) });
    if (((List)localObject1).size() <= 0)
    {
      Log.w("MicroMsg.FavRecordListItem", "dataList size is null");
      AppMethodBeat.o(107478);
      return paramView;
    }
    Object localObject2 = (anm)((List)localObject1).get(j);
    a(paramViewGroup.wSn, paramViewGroup.wSo, (anm)localObject2);
    anm localanm;
    if (bool)
    {
      paramViewGroup.wSr.setVisibility(0);
      paramViewGroup.qps.setVisibility(0);
      localObject2 = paramViewGroup.qps;
      localanm = (anm)((List)localObject1).get(m);
      switch (localanm.dataType)
      {
      default: 
        if (j + 1 < ((List)localObject1).size())
        {
          paramViewGroup.wSp.setVisibility(0);
          paramViewGroup.wSq.setVisibility(0);
          a(paramViewGroup.wSp, paramViewGroup.wSq, (anm)((List)localObject1).get(j + 1));
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(107478);
      return paramView;
      this.wJr.d((ImageView)localObject2, localanm, paramg, s.h.record_nopicture_icon, this.wRA, this.wRA);
      break;
      this.wJr.b((ImageView)localObject2, localanm, paramg, s.h.app_attach_file_icon_video, this.wRA, this.wRA);
      break;
      paramViewGroup.wSr.setVisibility(8);
      paramViewGroup.qps.setVisibility(8);
      break;
      paramViewGroup.wSp.setVisibility(8);
      paramViewGroup.wSq.setVisibility(8);
    }
  }
  
  public final void a(View paramView, aoe paramaoe)
  {
    AppMethodBeat.i(107481);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((z)h.ae(z.class)).a(paramView, locala.wHw, paramaoe);
    AppMethodBeat.o(107481);
  }
  
  public static final class a
    extends b.b
  {
    ImageView qps;
    ImageView wSa;
    ImageView wSm;
    TextView wSn;
    TextView wSo;
    TextView wSp;
    TextView wSq;
    FrameLayout wSr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.m
 * JD-Core Version:    0.7.0.1
 */
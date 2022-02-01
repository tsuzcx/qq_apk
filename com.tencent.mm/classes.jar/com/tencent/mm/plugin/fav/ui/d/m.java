package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.z;
import com.tencent.mm.plugin.fav.ui.FavoriteImageServer;
import com.tencent.mm.plugin.fav.ui.q.c;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.f;
import com.tencent.mm.plugin.fav.ui.q.h;
import com.tencent.mm.plugin.fav.ui.q.i;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arg;
import com.tencent.mm.protocal.protobuf.arm;
import com.tencent.mm.protocal.protobuf.aru;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class m
  extends b
{
  private HashMap<String, SpannableString> AoO;
  private final int Aod;
  
  public m(FavoriteImageServer paramFavoriteImageServer)
  {
    super(paramFavoriteImageServer);
    AppMethodBeat.i(107477);
    this.AoO = new HashMap();
    this.Aod = a.br(paramFavoriteImageServer.context, q.c.FavImageSize);
    AppMethodBeat.o(107477);
  }
  
  private static void a(TextView paramTextView1, TextView paramTextView2, boolean paramBoolean)
  {
    AppMethodBeat.i(274436);
    if (paramBoolean)
    {
      paramTextView1.setVisibility(0);
      paramTextView2.setVisibility(0);
      AppMethodBeat.o(274436);
      return;
    }
    paramTextView1.setVisibility(8);
    paramTextView2.setVisibility(8);
    AppMethodBeat.o(274436);
  }
  
  private static boolean a(TextView paramTextView1, TextView paramTextView2, arf paramarf)
  {
    AppMethodBeat.i(274439);
    if (!paramarf.ZzB)
    {
      Log.d("MicroMsg.FavRecordListItem", "has no datasrcname");
      paramTextView1.setVisibility(8);
    }
    for (;;)
    {
      Log.d("MicroMsg.FavRecordListItem", "field type %d", new Object[] { Integer.valueOf(paramarf.dataType) });
      switch (paramarf.dataType)
      {
      case 9: 
      case 11: 
      case 12: 
      case 13: 
      case 14: 
      case 18: 
      case 20: 
      case 21: 
      case 23: 
      case 24: 
      case 25: 
      case 26: 
      case 27: 
      case 28: 
      case 30: 
      default: 
        AppMethodBeat.o(274439);
        return false;
        paramTextView1.setVisibility(0);
        paramTextView1.setText(p.b(paramTextView1.getContext(), paramarf.ZzA, paramTextView1.getTextSize()));
      }
    }
    paramTextView2.setText(p.b(paramTextView2.getContext(), paramarf.desc, paramTextView2.getTextSize()));
    for (;;)
    {
      AppMethodBeat.o(274439);
      return true;
      paramTextView2.setText(ak(paramTextView2.getContext(), q.i.favorite_sub_title_voice));
      continue;
      paramTextView2.setText(ak(paramTextView2.getContext(), q.i.favorite_sub_title_url) + paramarf.title);
      continue;
      if (com.tencent.mm.plugin.fav.a.b.dQh())
      {
        paramTextView2.setText("");
      }
      else
      {
        paramTextView2.setText(ak(paramTextView2.getContext(), q.i.favorite_sub_title_url) + Util.nullAsNil(paramarf.title));
        continue;
        paramTextView2.setText(ak(paramTextView2.getContext(), q.i.favorite_sub_title_music) + paramarf.title);
        continue;
        paramTextView1 = paramarf.Zzy.ZAh;
        paramarf = new StringBuilder().append(ak(paramTextView2.getContext(), q.i.favorite_sub_title_location));
        if (Util.isNullOrNil(paramTextView1.hVI)) {}
        for (paramTextView1 = paramTextView1.label;; paramTextView1 = paramTextView1.hVI)
        {
          paramTextView2.setText(paramTextView1);
          break;
        }
        paramTextView2.setText(ak(paramTextView2.getContext(), q.i.favorite_sub_title_file) + paramarf.title);
        continue;
        paramTextView2.setText(ak(paramTextView2.getContext(), q.i.favorite_sight));
        continue;
        paramTextView2.setText(ak(paramTextView2.getContext(), q.i.favorite_sub_title_video));
        continue;
        paramTextView2.setText(ak(paramTextView2.getContext(), q.i.favorite_sub_title_image));
        continue;
        paramTextView2.setText(ak(paramTextView2.getContext(), q.i.favorite_mall_product) + paramarf.Zzy.ZAl.title);
        continue;
        paramTextView2.setText(ak(paramTextView2.getContext(), q.i.favorite_friend_card));
        continue;
        paramTextView2.setText(ak(paramTextView2.getContext(), q.i.favorite_kefu_card));
        continue;
        paramTextView2.setText(ak(paramTextView2.getContext(), q.i.favorite_sub_title_record));
        continue;
        paramTextView2.setText(ak(paramTextView2.getContext(), q.i.favorite_sub_app_brand) + paramarf.title);
      }
    }
  }
  
  private static String ak(Context paramContext, int paramInt)
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
    boolean bool1;
    int k;
    int j;
    label199:
    label360:
    int n;
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = a(View.inflate((Context)localObject1, q.f.fav_listitem_record, null), paramViewGroup, paramg);
      paramViewGroup.ttT = ((ImageView)paramView.findViewById(q.e.fav_icon));
      paramViewGroup.AoQ = ((TextView)paramView.findViewById(q.e.fav_title1));
      paramViewGroup.AoR = ((TextView)paramView.findViewById(q.e.fav_desc1));
      paramViewGroup.AoS = ((TextView)paramView.findViewById(q.e.fav_title2));
      paramViewGroup.AoT = ((TextView)paramView.findViewById(q.e.fav_desc2));
      paramViewGroup.AoD = ((ImageView)paramView.findViewById(q.e.fav_icon_video_mask));
      paramViewGroup.AoP = ((ImageView)paramView.findViewById(q.e.fav_icon_shortvideo));
      paramViewGroup.AoU = ((FrameLayout)paramView.findViewById(q.e.fav_icon_fl));
      b(paramViewGroup.ttT, paramg);
      a(paramViewGroup, paramg);
      m = 0;
      i = 0;
      bool1 = false;
      localObject1 = paramg.field_favProto.vEn;
      localObject2 = ((List)localObject1).iterator();
      k = 0;
      j = 0;
      if (!((Iterator)localObject2).hasNext()) {
        break label450;
      }
      switch (((arf)((Iterator)localObject2).next()).dataType)
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
      case 30: 
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
      break label199;
      paramViewGroup = (a)paramView.getTag();
      break;
      if (bool1) {
        break label360;
      }
      bool1 = true;
      n = k;
      m = i;
      k = j;
      j = n;
      continue;
      if (k != 0) {
        break label360;
      }
      j = 1;
      k = i;
    }
    label450:
    Log.d("MicroMsg.FavRecordListItem", "hasThumb %s, firstRemarkIndex %d", new Object[] { Boolean.valueOf(bool1), Integer.valueOf(j) });
    if (((List)localObject1).size() <= 0)
    {
      Log.w("MicroMsg.FavRecordListItem", "dataList size is null");
      AppMethodBeat.o(107478);
      return paramView;
    }
    Object localObject2 = (arf)((List)localObject1).get(j);
    boolean bool2 = a(paramViewGroup.AoQ, paramViewGroup.AoR, (arf)localObject2);
    a(paramViewGroup.AoQ, paramViewGroup.AoR, bool2);
    arf localarf;
    if (bool1)
    {
      paramViewGroup.AoU.setVisibility(0);
      paramViewGroup.ttT.setVisibility(0);
      localObject2 = paramViewGroup.ttT;
      localarf = (arf)((List)localObject1).get(m);
      switch (localarf.dataType)
      {
      default: 
        if (j + 1 < ((List)localObject1).size())
        {
          bool1 = a(paramViewGroup.AoS, paramViewGroup.AoT, (arf)((List)localObject1).get(j + 1));
          a(paramViewGroup.AoS, paramViewGroup.AoT, bool1);
        }
        break;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(107478);
      return paramView;
      this.AfM.d((ImageView)localObject2, localarf, paramg, q.h.record_nopicture_icon, this.Aod, this.Aod);
      break;
      this.AfM.b((ImageView)localObject2, localarf, paramg, q.h.app_attach_file_icon_video, this.Aod, this.Aod);
      break;
      paramViewGroup.AoU.setVisibility(8);
      paramViewGroup.ttT.setVisibility(8);
      break;
      a(paramViewGroup.AoS, paramViewGroup.AoT, false);
    }
  }
  
  public final void a(View paramView, arx paramarx)
  {
    AppMethodBeat.i(107481);
    a locala = (a)paramView.getTag();
    paramView = paramView.getContext();
    ((z)h.ax(z.class)).a(paramView, locala.AdF, paramarx);
    AppMethodBeat.o(107481);
  }
  
  public static final class a
    extends b.b
  {
    ImageView AoD;
    ImageView AoP;
    TextView AoQ;
    TextView AoR;
    TextView AoS;
    TextView AoT;
    FrameLayout AoU;
    ImageView ttT;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.m
 * JD-Core Version:    0.7.0.1
 */
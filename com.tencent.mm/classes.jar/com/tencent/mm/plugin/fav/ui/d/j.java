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
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.l.2;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.ach;
import com.tencent.mm.protocal.protobuf.acp;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class j
  extends a
{
  private final int mDa;
  private HashMap<String, SpannableString> mDy;
  
  public j(l paraml)
  {
    super(paraml);
    AppMethodBeat.i(74639);
    this.mDy = new HashMap();
    this.mDa = com.tencent.mm.cb.a.ao(paraml.context, 2131427653);
    AppMethodBeat.o(74639);
  }
  
  private static String M(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(74642);
    paramContext = "[" + paramContext.getResources().getString(paramInt) + "]";
    AppMethodBeat.o(74642);
    return paramContext;
  }
  
  private static void a(TextView paramTextView1, TextView paramTextView2, aca paramaca)
  {
    AppMethodBeat.i(74641);
    if (!paramaca.wTz)
    {
      ab.d("MicroMsg.FavRecordListItem", "has no datasrcname");
      paramTextView1.setVisibility(8);
      ab.d("MicroMsg.FavRecordListItem", "field type %d", new Object[] { Integer.valueOf(paramaca.dataType) });
      switch (paramaca.dataType)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(74641);
      return;
      paramTextView1.setVisibility(0);
      paramTextView1.setText(com.tencent.mm.pluginsdk.ui.d.j.b(paramTextView1.getContext(), paramaca.wTy, paramTextView1.getTextSize()));
      break;
      paramTextView2.setText(com.tencent.mm.pluginsdk.ui.d.j.b(paramTextView2.getContext(), paramaca.desc, paramTextView2.getTextSize()));
      AppMethodBeat.o(74641);
      return;
      paramTextView2.setText(M(paramTextView2.getContext(), 2131299840));
      AppMethodBeat.o(74641);
      return;
      paramTextView2.setText(M(paramTextView2.getContext(), 2131299838) + paramaca.title);
      AppMethodBeat.o(74641);
      return;
      paramTextView2.setText(M(paramTextView2.getContext(), 2131299835) + paramaca.title);
      AppMethodBeat.o(74641);
      return;
      paramTextView1 = paramaca.wTw.wUd;
      paramaca = new StringBuilder().append(M(paramTextView2.getContext(), 2131299834));
      if (bo.isNullOrNil(paramTextView1.cDl)) {}
      for (paramTextView1 = paramTextView1.label;; paramTextView1 = paramTextView1.cDl)
      {
        paramTextView2.setText(paramTextView1);
        AppMethodBeat.o(74641);
        return;
      }
      paramTextView2.setText(M(paramTextView2.getContext(), 2131299831) + paramaca.title);
      AppMethodBeat.o(74641);
      return;
      paramTextView2.setText(M(paramTextView2.getContext(), 2131299827));
      AppMethodBeat.o(74641);
      return;
      paramTextView2.setText(M(paramTextView2.getContext(), 2131299839));
      AppMethodBeat.o(74641);
      return;
      paramTextView2.setText(M(paramTextView2.getContext(), 2131299832));
      AppMethodBeat.o(74641);
      return;
      paramTextView2.setText(M(paramTextView2.getContext(), 2131299754) + paramaca.wTw.wUh.title);
      AppMethodBeat.o(74641);
      return;
      paramTextView2.setText(M(paramTextView2.getContext(), 2131299735));
      AppMethodBeat.o(74641);
      return;
      paramTextView2.setText(M(paramTextView2.getContext(), 2131299837));
      AppMethodBeat.o(74641);
      return;
      paramTextView2.setText(M(paramTextView2.getContext(), 2131299829) + paramaca.title);
    }
  }
  
  public final View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg)
  {
    AppMethodBeat.i(74640);
    Object localObject = paramViewGroup.getContext();
    int m;
    int i;
    boolean bool;
    LinkedList localLinkedList;
    int k;
    int j;
    label189:
    int n;
    if (paramView == null)
    {
      paramViewGroup = new j.a();
      localObject = a(View.inflate((Context)localObject, 2130969545, null), paramViewGroup, paramg);
      paramViewGroup.ivs = ((ImageView)((View)localObject).findViewById(2131821517));
      paramViewGroup.mDA = ((TextView)((View)localObject).findViewById(2131824037));
      paramViewGroup.mDC = ((TextView)((View)localObject).findViewById(2131824038));
      paramViewGroup.mDD = ((TextView)((View)localObject).findViewById(2131824039));
      paramViewGroup.mDE = ((TextView)((View)localObject).findViewById(2131824040));
      paramViewGroup.mDn = ((ImageView)((View)localObject).findViewById(2131824035));
      paramViewGroup.mDz = ((ImageView)((View)localObject).findViewById(2131824036));
      paramViewGroup.mDF = ((FrameLayout)((View)localObject).findViewById(2131824034));
      a(paramViewGroup, paramg);
      m = 0;
      i = 0;
      bool = false;
      localLinkedList = paramg.field_favProto.wVc;
      paramView = localLinkedList.iterator();
      k = 0;
      j = 0;
      if (!paramView.hasNext()) {
        break label385;
      }
      switch (((aca)paramView.next()).dataType)
      {
      case 9: 
      case 12: 
      case 13: 
      default: 
        label292:
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
      break label189;
      paramViewGroup = (j.a)paramView.getTag();
      localObject = paramView;
      break;
      if (bool) {
        break label292;
      }
      bool = true;
      n = k;
      m = i;
      k = j;
      j = n;
      continue;
      if (k != 0) {
        break label292;
      }
      j = 1;
      k = i;
    }
    label385:
    ab.d("MicroMsg.FavRecordListItem", "hasThumb %s, firstRemarkIndex %d", new Object[] { Boolean.valueOf(bool), Integer.valueOf(j) });
    if (localLinkedList.size() <= 0)
    {
      ab.w("MicroMsg.FavRecordListItem", "dataList size is null");
      AppMethodBeat.o(74640);
      return localObject;
    }
    paramView = (aca)localLinkedList.get(j);
    a(paramViewGroup.mDA, paramViewGroup.mDC, paramView);
    ImageView localImageView;
    aca localaca;
    label599:
    l locall;
    if (bool)
    {
      paramViewGroup.mDF.setVisibility(0);
      paramViewGroup.ivs.setVisibility(0);
      localImageView = paramViewGroup.ivs;
      localaca = (aca)localLinkedList.get(m);
      switch (localaca.dataType)
      {
      default: 
      case 2: 
        for (;;)
        {
          if (j + 1 < localLinkedList.size())
          {
            paramViewGroup.mDD.setVisibility(0);
            paramViewGroup.mDE.setVisibility(0);
            a(paramViewGroup.mDD, paramViewGroup.mDE, (aca)localLinkedList.get(j + 1));
            AppMethodBeat.o(74640);
            return localObject;
            locall = this.mvC;
            i = this.mDa;
            k = this.mDa;
            if (localImageView != null) {
              if (!f.Mi())
              {
                localImageView.setImageResource(2130839821);
              }
              else if ((localaca != null) && (paramg != null))
              {
                String str = localaca.mBq;
                if (str != null)
                {
                  paramView = null;
                  if (localaca.mBq != null)
                  {
                    paramView = (String[])locall.myv.get(str);
                    if (paramView != null) {
                      break label852;
                    }
                    paramView = new String[2];
                    paramView[0] = b.b(localaca);
                    paramView[1] = b.c(localaca);
                    locall.myv.put(str, paramView);
                  }
                }
              }
            }
          }
        }
      }
    }
    label852:
    for (;;)
    {
      locall.myu.a(localImageView, paramView, null, 2131231919, i, k);
      if ((paramView == null) || (paramView.length <= 0)) {
        break;
      }
      paramView = paramView[0];
      com.tencent.mm.kernel.g.RO().ac(new l.2(locall, paramView, paramg, localaca));
      break;
      this.mvC.b(localImageView, localaca, paramg, 2131230826, this.mDa, this.mDa);
      break;
      paramViewGroup.mDF.setVisibility(8);
      paramViewGroup.ivs.setVisibility(8);
      break;
      paramViewGroup.mDD.setVisibility(8);
      paramViewGroup.mDE.setVisibility(8);
      break label599;
    }
  }
  
  public final void a(View paramView, acs paramacs)
  {
    AppMethodBeat.i(74643);
    j.a locala = (j.a)paramView.getTag();
    paramView = paramView.getContext();
    ((y)com.tencent.mm.kernel.g.E(y.class)).a(paramView, locala.muk, paramacs);
    AppMethodBeat.o(74643);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.j
 * JD-Core Version:    0.7.0.1
 */
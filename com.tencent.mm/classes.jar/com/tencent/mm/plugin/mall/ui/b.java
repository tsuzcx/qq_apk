package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.mall.a.j;
import com.tencent.mm.plugin.wallet_core.model.mall.MallFunction;
import com.tencent.mm.plugin.wallet_core.model.mall.MallNews;
import com.tencent.mm.plugin.wallet_core.model.mall.d;
import com.tencent.mm.plugin.wallet_core.model.y;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
  extends BaseAdapter
{
  private Context mContext;
  private LayoutInflater mInflater;
  private SparseArray<String> oxN;
  private int oxO;
  private boolean oyA;
  private boolean oyB;
  private final int oys;
  private final int oyt;
  private final int oyu;
  List<ArrayList<b.c>> oyv;
  b.d oyw;
  private boolean oyx;
  private int oyy;
  private int oyz;
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(43137);
    this.oys = 3;
    this.oyt = 9;
    this.oyu = 3;
    this.oyv = new ArrayList();
    this.oxN = null;
    this.oyx = true;
    this.oyy = 0;
    this.oyz = 0;
    this.oyA = false;
    this.oyB = false;
    this.mContext = paramContext;
    this.oxO = paramInt;
    this.mInflater = LayoutInflater.from(this.mContext);
    AppMethodBeat.o(43137);
  }
  
  private void a(int paramInt1, b.b paramb, int paramInt2)
  {
    AppMethodBeat.i(43142);
    List localList = (List)this.oyv.get(paramInt1);
    localList.get(0);
    int m;
    Object localObject;
    int j;
    int k;
    int i;
    if (localList.size() > 0)
    {
      m = ((b.c)localList.get(0)).oyZ.type;
      localObject = yM(m);
      j = 0;
      k = 0;
      if (bo.isNullOrNil((String)localObject)) {
        break label680;
      }
      if (paramInt1 == 0)
      {
        i = 1;
        if (paramInt1 != this.oyv.size() - 1) {
          break label355;
        }
        paramInt1 = 1;
      }
    }
    for (;;)
    {
      label104:
      if (i != 0)
      {
        paramb.oyR.setText((CharSequence)localObject);
        paramb.oyR.setVisibility(0);
        paramb.oyS.setVisibility(8);
        paramb.oyT.setVisibility(0);
        paramb.oyR.setMinHeight(a.bOv());
        paramb.oyT.setBackgroundColor(c.bOP());
        localObject = paramb.oyQ;
        ((LinearLayout)localObject).setFocusable(true);
        i = 0;
        if (i >= 3) {
          break label674;
        }
        if ((i >= ((LinearLayout)localObject).getChildCount()) || (((LinearLayout)localObject).getChildAt(i) == null)) {
          break label523;
        }
        paramb = ((LinearLayout)localObject).getChildAt(i);
        paramb.setVisibility(0);
        if (i >= localList.size()) {
          break label459;
        }
        a(paramb, (b.c)localList.get(i), i, paramInt2);
        label249:
        if ((paramInt2 != 0) || (paramInt1 == 0)) {
          break label655;
        }
        if (i != 0) {
          break label630;
        }
        paramb.setBackground(this.mContext.getResources().getDrawable(2130839579));
      }
      label523:
      label655:
      for (;;)
      {
        label163:
        label178:
        i += 1;
        break label178;
        i = k;
        if (((ArrayList)this.oyv.get(paramInt1 - 1)).size() <= 0) {
          break;
        }
        i = k;
        if (m == ((b.c)((ArrayList)this.oyv.get(paramInt1 - 1)).get(0)).oyZ.type) {
          break;
        }
        i = 1;
        break;
        label355:
        j = i;
        if (m == ((b.c)((ArrayList)this.oyv.get(paramInt1 + 1)).get(0)).oyZ.type) {
          break label680;
        }
        paramInt1 = 1;
        break label104;
        paramb.oyR.setVisibility(8);
        paramb.oyS.setVisibility(8);
        paramb.oyT.setVisibility(8);
        break label163;
        paramb.oyR.setVisibility(8);
        paramb.oyS.setVisibility(8);
        paramb.oyT.setVisibility(8);
        paramInt1 = 0;
        break label163;
        label459:
        ((LinearLayout)localObject).getChildAt(i).setFocusable(true);
        ((LinearLayout)localObject).getChildAt(i).setOnClickListener(null);
        a locala = (a)((LinearLayout)localObject).getChildAt(i).getTag();
        locala.oyF.setVisibility(4);
        paramb.setEnabled(false);
        paramb.setClickable(false);
        a(locala);
        break label249;
        paramb = p((ViewGroup)localObject);
        if (i < localList.size()) {
          a(paramb, (b.c)localList.get(i), i, paramInt2);
        }
        for (;;)
        {
          ((LinearLayout)localObject).addView(paramb, new LinearLayout.LayoutParams(-2, a.bOt(), 1.0F));
          break;
          paramb.setFocusable(true);
          locala = (a)paramb.getTag();
          locala.oyF.setVisibility(4);
          paramb.setOnClickListener(null);
          paramb.setEnabled(false);
          paramb.setClickable(false);
          a(locala);
        }
        label630:
        if (i != 1) {
          paramb.setBackground(this.mContext.getResources().getDrawable(2130839580));
        } else {
          paramb.setBackground(this.mContext.getResources().getDrawable(2130839581));
        }
      }
      label674:
      AppMethodBeat.o(43142);
      return;
      label680:
      paramInt1 = 0;
      i = j;
    }
  }
  
  private void a(View paramView, b.c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(43148);
    if (paramView == null)
    {
      AppMethodBeat.o(43148);
      return;
    }
    a locala = (a)paramView.getTag();
    MallFunction localMallFunction = paramc.oyZ;
    int i = paramc.oza;
    locala.oyL = localMallFunction.oyL;
    locala.oyK = localMallFunction.oyK;
    com.tencent.mm.plugin.mall.b.a.d(locala.oyG, locala.oyK, 2131231615);
    locala.oyI.setText(localMallFunction.cJt);
    locala.oyH.setVisibility(8);
    if ((localMallFunction.umh != null) && (!bo.isNullOrNil(localMallFunction.umh.ump)) && (b(localMallFunction)))
    {
      if (d.cVb().aft(localMallFunction.pUM) != null)
      {
        ab.w("MicroMsg.FunctionListAdapter", "show the news : " + d.cVb().aft(localMallFunction.pUM).ump);
        locala.oyJ.setText(localMallFunction.umh.ump);
        locala.oyJ.setVisibility(0);
      }
      for (;;)
      {
        com.tencent.mm.plugin.mall.b.a.o(locala.oyH, locala.oyL);
        locala.oyH.setVisibility(0);
        paramView.setOnClickListener(new b.2(this, i, localMallFunction));
        locala.oyF.setVisibility(0);
        paramView.setEnabled(true);
        paramView.setClickable(true);
        a(locala, paramInt1, paramInt2);
        AppMethodBeat.o(43148);
        return;
        locala.oyJ.setVisibility(4);
      }
    }
    if ((localMallFunction.umh != null) && (localMallFunction.umh.umu == 1))
    {
      locala.oyJ.setText(localMallFunction.umh.ump);
      locala.oyJ.setVisibility(0);
    }
    for (;;)
    {
      locala.oyH.setImageBitmap(null);
      locala.oyH.setVisibility(8);
      break;
      locala.oyJ.setText("");
      locala.oyJ.setVisibility(4);
    }
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(43144);
    parama.oyM.setVisibility(0);
    parama.oyN.setVisibility(4);
    parama.oyO.setVisibility(4);
    parama.oyP.setVisibility(4);
    AppMethodBeat.o(43144);
  }
  
  private static void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(43145);
    parama.oyP.setVisibility(4);
    if (paramInt1 == 0) {
      parama.oyN.setVisibility(0);
    }
    while (paramInt2 == 0)
    {
      parama.oyM.setVisibility(0);
      parama.oyO.setVisibility(4);
      AppMethodBeat.o(43145);
      return;
      if (paramInt1 == 1) {
        parama.oyN.setVisibility(0);
      } else if (paramInt1 == 2) {
        parama.oyN.setVisibility(4);
      }
    }
    if (paramInt2 == 1)
    {
      parama.oyM.setVisibility(4);
      parama.oyO.setVisibility(0);
      AppMethodBeat.o(43145);
      return;
    }
    parama.oyM.setVisibility(0);
    parama.oyO.setVisibility(0);
    AppMethodBeat.o(43145);
  }
  
  public static boolean a(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(43147);
    if ((paramMallFunction.umh != null) && (!bo.isNullOrNil(paramMallFunction.umh.ump)) && (b(paramMallFunction)) && (d.cVb().aft(paramMallFunction.pUM) != null))
    {
      AppMethodBeat.o(43147);
      return true;
    }
    AppMethodBeat.o(43147);
    return false;
  }
  
  private static boolean b(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(43149);
    MallNews localMallNews = d.cVb().aft(paramMallFunction.pUM);
    if ((localMallNews == null) || (bo.isNullOrNil(localMallNews.sWB)) || (!localMallNews.sWB.equals(paramMallFunction.umh.sWB)))
    {
      ab.d("MicroMsg.FunctionListAdapter", "old news null or should be replaced %s %s", new Object[] { paramMallFunction.umh.sWB, paramMallFunction.cJt });
      d.cVb().b(paramMallFunction.umh);
      AppMethodBeat.o(43149);
      return true;
    }
    if (localMallNews != null)
    {
      if (!"0".equals(localMallNews.umn))
      {
        ab.d("MicroMsg.FunctionListAdapter", "still old news or clicked, then should not show");
        AppMethodBeat.o(43149);
        return false;
      }
      ab.d("MicroMsg.FunctionListAdapter", "still old news and should show");
      AppMethodBeat.o(43149);
      return true;
    }
    AppMethodBeat.o(43149);
    return false;
  }
  
  private boolean bOw()
  {
    AppMethodBeat.i(43146);
    if (this.oyv.size() > 3)
    {
      Object localObject = (ArrayList)this.oyv.get(3);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        int i = ((b.c)((ArrayList)localObject).get(0)).oyZ.type;
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          b.c localc = (b.c)((Iterator)localObject).next();
          if (localc.oyZ.type == i) {
            if (a(localc.oyZ))
            {
              AppMethodBeat.o(43146);
              return true;
            }
          }
        }
      }
    }
    AppMethodBeat.o(43146);
    return false;
  }
  
  private View p(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(43143);
    a locala = new a();
    paramViewGroup = this.mInflater.inflate(2130970079, paramViewGroup, false);
    locala.oyF = paramViewGroup.findViewById(2131825928);
    locala.oyG = ((ImageView)paramViewGroup.findViewById(2131825931));
    locala.oyI = ((TextView)paramViewGroup.findViewById(2131825932));
    locala.oyJ = ((TextView)paramViewGroup.findViewById(2131825933));
    locala.oyH = ((ImageView)paramViewGroup.findViewById(2131825929));
    locala.oyM = ((ImageView)paramViewGroup.findViewById(2131825218));
    locala.oyN = ((ImageView)paramViewGroup.findViewById(2131825935));
    locala.oyO = ((ImageView)paramViewGroup.findViewById(2131825264));
    locala.oyP = ((ImageView)paramViewGroup.findViewById(2131825934));
    paramViewGroup.setTag(locala);
    AppMethodBeat.o(43143);
    return paramViewGroup;
  }
  
  private boolean yL(int paramInt)
  {
    AppMethodBeat.i(43140);
    int j;
    boolean bool;
    if (this.oyy > 9)
    {
      j = 0;
      int i = 0;
      while (j <= paramInt)
      {
        i += ((ArrayList)this.oyv.get(j)).size();
        j += 1;
      }
      if (this.oyz > 3)
      {
        j = 3;
        if (i < 9) {
          break label119;
        }
        if ((!this.oyx) || (paramInt != j)) {
          break label98;
        }
        bool = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(43140);
      return bool;
      j = this.oyz;
      break;
      label98:
      if ((paramInt == this.oyz) && (!this.oyx)) {
        bool = true;
      } else {
        label119:
        bool = false;
      }
    }
  }
  
  private String yM(int paramInt)
  {
    AppMethodBeat.i(43150);
    if (this.oxN == null)
    {
      AppMethodBeat.o(43150);
      return null;
    }
    String str = (String)this.oxN.get(paramInt);
    AppMethodBeat.o(43150);
    return str;
  }
  
  public final void I(ArrayList<MallFunction> paramArrayList)
  {
    AppMethodBeat.i(43138);
    this.oyv.clear();
    if (paramArrayList != null)
    {
      int i = 0;
      ArrayList localArrayList;
      while (i < paramArrayList.size())
      {
        localArrayList = new ArrayList();
        int j = 0;
        while ((j < 3) && (i + j < paramArrayList.size()))
        {
          if (j > 0)
          {
            int k = i + j - 1;
            if ((k >= 0) && (((MallFunction)paramArrayList.get(k)).type != ((MallFunction)paramArrayList.get(i + j)).type)) {
              break;
            }
          }
          b.c localc = new b.c(this);
          localc.oza = (i + j);
          localc.oyZ = ((MallFunction)paramArrayList.get(i + j));
          localArrayList.add(localc);
          j += 1;
        }
        if (localArrayList.size() > 0) {
          this.oyv.add(localArrayList);
        }
        i += j;
      }
      this.oyy = 0;
      this.oyz = 0;
      paramArrayList = this.oyv.iterator();
      i = -1;
      if (paramArrayList.hasNext())
      {
        localArrayList = (ArrayList)paramArrayList.next();
        if (localArrayList.size() <= 0) {
          break label360;
        }
        if ((i == -1) || (i == ((b.c)localArrayList.get(0)).oyZ.type))
        {
          this.oyy += localArrayList.size();
          this.oyz += 1;
          i = ((b.c)localArrayList.get(0)).oyZ.type;
        }
      }
    }
    label360:
    for (;;)
    {
      break;
      this.oyz -= 1;
      this.oxN = j.bOs().yJ(this.oxO).oxN;
      this.oyA = bOw();
      ab.i("MicroMsg.FunctionListAdapter", "hasMoreNewAtFirstSectionBottom: %s", new Object[] { Boolean.valueOf(this.oyA) });
      notifyDataSetChanged();
      AppMethodBeat.o(43138);
      return;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(43139);
    int i = this.oyv.size();
    AppMethodBeat.o(43139);
    return i;
  }
  
  public final Object getItem(int paramInt)
  {
    return null;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = 3;
    AppMethodBeat.i(43141);
    boolean bool2 = yL(paramInt);
    if (this.oyy > 9) {
      if (this.oyz <= 3) {}
    }
    for (int j = i;; j = -1)
    {
      if ((!bool2) && (paramInt + 1 < this.oyv.size())) {}
      for (boolean bool1 = yL(paramInt + 1);; bool1 = false)
      {
        if (bool2) {
          i = 1;
        }
        for (;;)
        {
          label74:
          View localView;
          if (paramView == null)
          {
            paramView = new b.b(this);
            localView = this.mInflater.inflate(2130970073, paramViewGroup, false);
            paramView.oyQ = ((LinearLayout)localView.findViewById(2131825909));
            paramView.oyR = ((TextView)localView.findViewById(2131825908));
            paramView.oyS = localView.findViewById(2131821148);
            paramView.oyT = localView.findViewById(2131825907);
            paramView.oyU = localView.findViewById(2131825910);
            paramView.oyW = ((TextView)localView.findViewById(2131825911));
            paramView.oyV = ((ImageView)localView.findViewById(2131825912));
            paramView.oyX = localView.findViewById(2131825913);
            paramView.oyY = localView.findViewById(2131825914);
            paramView.oyU.setOnClickListener(new b.1(this));
            localView.setTag(paramView);
            paramViewGroup = paramView;
            label244:
            if (!bool2) {
              break label495;
            }
            paramViewGroup.oyR.setVisibility(8);
            paramViewGroup.oyS.setVisibility(8);
            paramViewGroup.oyT.setVisibility(8);
            paramViewGroup.oyU.setVisibility(0);
            paramViewGroup.oyV.setImageResource(2131232189);
            paramViewGroup.oyW.setText(this.mContext.getString(2131301443));
            if ((!this.oyA) || (this.oyB)) {
              break label437;
            }
            paramViewGroup.oyX.setVisibility(0);
            label333:
            if (!this.oyx) {
              break label449;
            }
            paramViewGroup.oyQ.setVisibility(8);
            paramViewGroup.oyW.setText(this.mContext.getString(2131301443));
            label366:
            if (paramInt != getCount() - 1) {
              break label615;
            }
            paramViewGroup.oyY.setBackgroundColor(c.bOP());
            paramViewGroup.oyY.setVisibility(0);
          }
          for (;;)
          {
            AppMethodBeat.o(43141);
            return localView;
            i = this.oyz;
            break;
            if (!bool1) {
              break label627;
            }
            i = 2;
            break label74;
            paramViewGroup = (b.b)paramView.getTag();
            localView = paramView;
            break label244;
            label437:
            paramViewGroup.oyX.setVisibility(8);
            break label333;
            label449:
            paramViewGroup.oyQ.setVisibility(0);
            a(paramInt, paramViewGroup, i);
            paramViewGroup.oyV.setImageResource(2131232190);
            paramViewGroup.oyW.setText(this.mContext.getString(2131301441));
            break label366;
            label495:
            if ((j > 0) && (this.oyx) && (paramInt >= j) && (paramInt <= this.oyz))
            {
              paramViewGroup.oyQ.setVisibility(8);
              paramViewGroup.oyU.setVisibility(8);
              paramViewGroup.oyX.setVisibility(8);
              paramViewGroup.oyR.setVisibility(8);
              paramViewGroup.oyS.setVisibility(8);
              paramViewGroup.oyT.setVisibility(8);
              break label366;
            }
            paramViewGroup.oyQ.setVisibility(0);
            a(paramInt, paramViewGroup, i);
            paramViewGroup.oyU.setVisibility(8);
            paramViewGroup.oyX.setVisibility(8);
            break label366;
            label615:
            paramViewGroup.oyY.setVisibility(8);
          }
          label627:
          i = 0;
        }
      }
    }
  }
  
  final class a
  {
    public View oyF = null;
    public ImageView oyG = null;
    public ImageView oyH = null;
    public TextView oyI = null;
    public TextView oyJ = null;
    public String oyK = null;
    public String oyL = null;
    public ImageView oyM = null;
    public ImageView oyN = null;
    public ImageView oyO = null;
    public ImageView oyP = null;
    
    a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
  extends BaseAdapter
{
  private Context mContext;
  private LayoutInflater mInflater;
  private SparseArray<String> uAG;
  private int uAH;
  private final int uBm;
  private final int uBn;
  private final int uBo;
  List<ArrayList<c>> uBp;
  d uBq;
  private boolean uBr;
  private int uBs;
  private int uBt;
  private boolean uBu;
  private boolean uBv;
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(66035);
    this.uBm = 3;
    this.uBn = 9;
    this.uBo = 3;
    this.uBp = new ArrayList();
    this.uAG = null;
    this.uBr = true;
    this.uBs = 0;
    this.uBt = 0;
    this.uBu = false;
    this.uBv = false;
    this.mContext = paramContext;
    this.uAH = paramInt;
    this.mInflater = LayoutInflater.from(this.mContext);
    AppMethodBeat.o(66035);
  }
  
  private boolean Ii(int paramInt)
  {
    AppMethodBeat.i(66038);
    int j;
    boolean bool;
    if (this.uBs > 9)
    {
      j = 0;
      int i = 0;
      while (j <= paramInt)
      {
        i += ((ArrayList)this.uBp.get(j)).size();
        j += 1;
      }
      if (this.uBt > 3)
      {
        j = 3;
        if (i < 9) {
          break label117;
        }
        if ((!this.uBr) || (paramInt != j)) {
          break label96;
        }
        bool = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66038);
      return bool;
      j = this.uBt;
      break;
      label96:
      if ((paramInt == this.uBt) && (!this.uBr)) {
        bool = true;
      } else {
        label117:
        bool = false;
      }
    }
  }
  
  private String Ij(int paramInt)
  {
    AppMethodBeat.i(66048);
    if (this.uAG == null)
    {
      AppMethodBeat.o(66048);
      return null;
    }
    String str = (String)this.uAG.get(paramInt);
    AppMethodBeat.o(66048);
    return str;
  }
  
  private void a(int paramInt1, b paramb, int paramInt2)
  {
    AppMethodBeat.i(66040);
    List localList = (List)this.uBp.get(paramInt1);
    localList.get(0);
    int m;
    Object localObject;
    int j;
    int k;
    int i;
    if (localList.size() > 0)
    {
      m = ((c)localList.get(0)).uBT.type;
      localObject = Ij(m);
      j = 0;
      k = 0;
      if (bs.isNullOrNil((String)localObject)) {
        break label680;
      }
      if (paramInt1 == 0)
      {
        i = 1;
        if (paramInt1 != this.uBp.size() - 1) {
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
        paramb.uBL.setText((CharSequence)localObject);
        paramb.uBL.setVisibility(0);
        paramb.uBM.setVisibility(8);
        paramb.uBN.setVisibility(0);
        paramb.uBL.setMinHeight(a.daQ());
        paramb.uBN.setBackgroundColor(c.dbn());
        localObject = paramb.uBK;
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
        a(paramb, (c)localList.get(i), i, paramInt2);
        label249:
        if ((paramInt2 != 0) || (paramInt1 == 0)) {
          break label655;
        }
        if (i != 0) {
          break label630;
        }
        paramb.setBackground(this.mContext.getResources().getDrawable(2131233198));
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
        if (((ArrayList)this.uBp.get(paramInt1 - 1)).size() <= 0) {
          break;
        }
        i = k;
        if (m == ((c)((ArrayList)this.uBp.get(paramInt1 - 1)).get(0)).uBT.type) {
          break;
        }
        i = 1;
        break;
        label355:
        j = i;
        if (m == ((c)((ArrayList)this.uBp.get(paramInt1 + 1)).get(0)).uBT.type) {
          break label680;
        }
        paramInt1 = 1;
        break label104;
        paramb.uBL.setVisibility(8);
        paramb.uBM.setVisibility(8);
        paramb.uBN.setVisibility(8);
        break label163;
        paramb.uBL.setVisibility(8);
        paramb.uBM.setVisibility(8);
        paramb.uBN.setVisibility(8);
        paramInt1 = 0;
        break label163;
        label459:
        ((LinearLayout)localObject).getChildAt(i).setFocusable(true);
        ((LinearLayout)localObject).getChildAt(i).setOnClickListener(null);
        a locala = (a)((LinearLayout)localObject).getChildAt(i).getTag();
        locala.uBz.setVisibility(4);
        paramb.setEnabled(false);
        paramb.setClickable(false);
        a(locala);
        break label249;
        paramb = t((ViewGroup)localObject);
        if (i < localList.size()) {
          a(paramb, (c)localList.get(i), i, paramInt2);
        }
        for (;;)
        {
          ((LinearLayout)localObject).addView(paramb, new LinearLayout.LayoutParams(-2, a.daO(), 1.0F));
          break;
          paramb.setFocusable(true);
          locala = (a)paramb.getTag();
          locala.uBz.setVisibility(4);
          paramb.setOnClickListener(null);
          paramb.setEnabled(false);
          paramb.setClickable(false);
          a(locala);
        }
        label630:
        if (i != 1) {
          paramb.setBackground(this.mContext.getResources().getDrawable(2131233199));
        } else {
          paramb.setBackground(this.mContext.getResources().getDrawable(2131233200));
        }
      }
      label674:
      AppMethodBeat.o(66040);
      return;
      label680:
      paramInt1 = 0;
      i = j;
    }
  }
  
  private void a(View paramView, c paramc, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66046);
    if (paramView == null)
    {
      AppMethodBeat.o(66046);
      return;
    }
    a locala = (a)paramView.getTag();
    final MallFunction localMallFunction = paramc.uBT;
    final int i = paramc.uBU;
    locala.uBF = localMallFunction.uBF;
    locala.uBE = localMallFunction.uBE;
    com.tencent.mm.plugin.mall.b.a.d(locala.uBA, locala.uBE, 2131690773);
    locala.uBC.setText(localMallFunction.dxZ);
    locala.uBB.setVisibility(8);
    if ((localMallFunction.BAX != null) && (!bs.isNullOrNil(localMallFunction.BAX.BBf)) && (b(localMallFunction)))
    {
      if (d.esR().azu(localMallFunction.wfu) != null)
      {
        ac.w("MicroMsg.FunctionListAdapter", "show the news : " + d.esR().azu(localMallFunction.wfu).BBf);
        locala.uBD.setText(localMallFunction.BAX.BBf);
        locala.uBD.setVisibility(0);
      }
      for (;;)
      {
        com.tencent.mm.plugin.mall.b.a.q(locala.uBB, locala.uBF);
        locala.uBB.setVisibility(0);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66034);
            ac.v("MicroMsg.FunctionListAdapter", "on Click");
            if (b.c(b.this) != null) {
              b.c(b.this).a(i, localMallFunction);
            }
            AppMethodBeat.o(66034);
          }
        });
        locala.uBz.setVisibility(0);
        paramView.setEnabled(true);
        paramView.setClickable(true);
        a(locala, paramInt1, paramInt2);
        AppMethodBeat.o(66046);
        return;
        locala.uBD.setVisibility(4);
      }
    }
    if ((localMallFunction.BAX != null) && (localMallFunction.BAX.BBk == 1))
    {
      locala.uBD.setText(localMallFunction.BAX.BBf);
      locala.uBD.setVisibility(0);
    }
    for (;;)
    {
      locala.uBB.setImageBitmap(null);
      locala.uBB.setVisibility(8);
      break;
      locala.uBD.setText("");
      locala.uBD.setVisibility(4);
    }
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(66042);
    parama.uBG.setVisibility(0);
    parama.uBH.setVisibility(4);
    parama.uBI.setVisibility(4);
    parama.uBJ.setVisibility(4);
    AppMethodBeat.o(66042);
  }
  
  private static void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66043);
    parama.uBJ.setVisibility(4);
    if (paramInt1 == 0) {
      parama.uBH.setVisibility(0);
    }
    while (paramInt2 == 0)
    {
      parama.uBG.setVisibility(0);
      parama.uBI.setVisibility(4);
      AppMethodBeat.o(66043);
      return;
      if (paramInt1 == 1) {
        parama.uBH.setVisibility(0);
      } else if (paramInt1 == 2) {
        parama.uBH.setVisibility(4);
      }
    }
    if (paramInt2 == 1)
    {
      parama.uBG.setVisibility(4);
      parama.uBI.setVisibility(0);
      AppMethodBeat.o(66043);
      return;
    }
    parama.uBG.setVisibility(0);
    parama.uBI.setVisibility(0);
    AppMethodBeat.o(66043);
  }
  
  public static boolean a(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(66045);
    if ((paramMallFunction.BAX != null) && (!bs.isNullOrNil(paramMallFunction.BAX.BBf)) && (b(paramMallFunction)) && (d.esR().azu(paramMallFunction.wfu) != null))
    {
      AppMethodBeat.o(66045);
      return true;
    }
    AppMethodBeat.o(66045);
    return false;
  }
  
  private static boolean b(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(66047);
    MallNews localMallNews = d.esR().azu(paramMallFunction.wfu);
    if ((localMallNews == null) || (bs.isNullOrNil(localMallNews.zPC)) || (!localMallNews.zPC.equals(paramMallFunction.BAX.zPC)))
    {
      ac.d("MicroMsg.FunctionListAdapter", "old news null or should be replaced %s %s", new Object[] { paramMallFunction.BAX.zPC, paramMallFunction.dxZ });
      d.esR().b(paramMallFunction.BAX);
      AppMethodBeat.o(66047);
      return true;
    }
    if (localMallNews != null)
    {
      if (!"0".equals(localMallNews.BBd))
      {
        ac.d("MicroMsg.FunctionListAdapter", "still old news or clicked, then should not show");
        AppMethodBeat.o(66047);
        return false;
      }
      ac.d("MicroMsg.FunctionListAdapter", "still old news and should show");
      AppMethodBeat.o(66047);
      return true;
    }
    AppMethodBeat.o(66047);
    return false;
  }
  
  private boolean daR()
  {
    AppMethodBeat.i(66044);
    if (this.uBp.size() > 3)
    {
      Object localObject = (ArrayList)this.uBp.get(3);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        int i = ((c)((ArrayList)localObject).get(0)).uBT.type;
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          c localc = (c)((Iterator)localObject).next();
          if (localc.uBT.type == i) {
            if (a(localc.uBT))
            {
              AppMethodBeat.o(66044);
              return true;
            }
          }
        }
      }
    }
    AppMethodBeat.o(66044);
    return false;
  }
  
  private View t(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(66041);
    a locala = new a();
    paramViewGroup = this.mInflater.inflate(2131494693, paramViewGroup, false);
    locala.uBz = paramViewGroup.findViewById(2131302017);
    locala.uBA = ((ImageView)paramViewGroup.findViewById(2131302014));
    locala.uBC = ((TextView)paramViewGroup.findViewById(2131302019));
    locala.uBD = ((TextView)paramViewGroup.findViewById(2131302013));
    locala.uBB = ((ImageView)paramViewGroup.findViewById(2131302795));
    locala.uBG = ((ImageView)paramViewGroup.findViewById(2131299169));
    locala.uBH = ((ImageView)paramViewGroup.findViewById(2131299167));
    locala.uBI = ((ImageView)paramViewGroup.findViewById(2131299159));
    locala.uBJ = ((ImageView)paramViewGroup.findViewById(2131299163));
    paramViewGroup.setTag(locala);
    AppMethodBeat.o(66041);
    return paramViewGroup;
  }
  
  public final void ak(ArrayList<MallFunction> paramArrayList)
  {
    AppMethodBeat.i(66036);
    this.uBp.clear();
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
          c localc = new c();
          localc.uBU = (i + j);
          localc.uBT = ((MallFunction)paramArrayList.get(i + j));
          localArrayList.add(localc);
          j += 1;
        }
        if (localArrayList.size() > 0) {
          this.uBp.add(localArrayList);
        }
        i += j;
      }
      this.uBs = 0;
      this.uBt = 0;
      paramArrayList = this.uBp.iterator();
      i = -1;
      if (paramArrayList.hasNext())
      {
        localArrayList = (ArrayList)paramArrayList.next();
        if (localArrayList.size() <= 0) {
          break label360;
        }
        if ((i == -1) || (i == ((c)localArrayList.get(0)).uBT.type))
        {
          this.uBs += localArrayList.size();
          this.uBt += 1;
          i = ((c)localArrayList.get(0)).uBT.type;
        }
      }
    }
    label360:
    for (;;)
    {
      break;
      this.uBt -= 1;
      this.uAG = j.daN().Ig(this.uAH).uAG;
      this.uBu = daR();
      ac.i("MicroMsg.FunctionListAdapter", "hasMoreNewAtFirstSectionBottom: %s", new Object[] { Boolean.valueOf(this.uBu) });
      notifyDataSetChanged();
      AppMethodBeat.o(66036);
      return;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(66037);
    int i = this.uBp.size();
    AppMethodBeat.o(66037);
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
    AppMethodBeat.i(66039);
    boolean bool2 = Ii(paramInt);
    if (this.uBs > 9) {
      if (this.uBt <= 3) {}
    }
    for (int j = i;; j = -1)
    {
      if ((!bool2) && (paramInt + 1 < this.uBp.size())) {}
      for (boolean bool1 = Ii(paramInt + 1);; bool1 = false)
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
            paramView = new b();
            localView = this.mInflater.inflate(2131494687, paramViewGroup, false);
            paramView.uBK = ((LinearLayout)localView.findViewById(2131302010));
            paramView.uBL = ((TextView)localView.findViewById(2131302009));
            paramView.uBM = localView.findViewById(2131299154);
            paramView.uBN = localView.findViewById(2131301426);
            paramView.uBO = localView.findViewById(2131302138);
            paramView.uBQ = ((TextView)localView.findViewById(2131302139));
            paramView.uBP = ((ImageView)localView.findViewById(2131302137));
            paramView.uBR = localView.findViewById(2131302469);
            paramView.uBS = localView.findViewById(2131297448);
            paramView.uBO.setOnClickListener(new View.OnClickListener()
            {
              public final void onClick(View paramAnonymousView)
              {
                AppMethodBeat.i(66033);
                paramAnonymousView = b.this;
                if (!b.a(b.this)) {}
                for (boolean bool = true;; bool = false)
                {
                  b.a(paramAnonymousView, bool);
                  b.b(b.this);
                  b.this.notifyDataSetChanged();
                  AppMethodBeat.o(66033);
                  return;
                }
              }
            });
            localView.setTag(paramView);
            paramViewGroup = paramView;
            label244:
            if (!bool2) {
              break label629;
            }
            paramViewGroup.uBL.setVisibility(8);
            paramViewGroup.uBM.setVisibility(8);
            paramViewGroup.uBN.setVisibility(8);
            paramViewGroup.uBO.setVisibility(0);
            paramViewGroup.uBP.setImageResource(2131690517);
            paramViewGroup.uBP.setColorFilter(this.mContext.getResources().getColor(2131100547), PorterDuff.Mode.SRC_ATOP);
            paramViewGroup.uBP.setPivotX(paramViewGroup.uBP.getWidth() / 2);
            paramViewGroup.uBP.setPivotY(paramViewGroup.uBP.getHeight() / 2);
            paramViewGroup.uBP.setRotation(90.0F);
            paramViewGroup.uBQ.setText(this.mContext.getString(2131761090));
            if ((!this.uBu) || (this.uBv)) {
              break label504;
            }
            paramViewGroup.uBR.setVisibility(0);
            label400:
            if (!this.uBr) {
              break label516;
            }
            paramViewGroup.uBK.setVisibility(8);
            paramViewGroup.uBQ.setText(this.mContext.getString(2131761090));
            label433:
            if (paramInt != getCount() - 1) {
              break label749;
            }
            paramViewGroup.uBS.setBackgroundColor(c.dbn());
            paramViewGroup.uBS.setVisibility(0);
          }
          for (;;)
          {
            AppMethodBeat.o(66039);
            return localView;
            i = this.uBt;
            break;
            if (!bool1) {
              break label761;
            }
            i = 2;
            break label74;
            paramViewGroup = (b)paramView.getTag();
            localView = paramView;
            break label244;
            label504:
            paramViewGroup.uBR.setVisibility(8);
            break label400;
            label516:
            paramViewGroup.uBK.setVisibility(0);
            a(paramInt, paramViewGroup, i);
            paramViewGroup.uBP.setImageResource(2131690517);
            paramViewGroup.uBP.setColorFilter(this.mContext.getResources().getColor(2131100547), PorterDuff.Mode.SRC_ATOP);
            paramViewGroup.uBP.setPivotX(paramViewGroup.uBP.getWidth() / 2);
            paramViewGroup.uBP.setPivotY(paramViewGroup.uBP.getHeight() / 2);
            paramViewGroup.uBP.setRotation(270.0F);
            paramViewGroup.uBQ.setText(this.mContext.getString(2131761088));
            break label433;
            label629:
            if ((j > 0) && (this.uBr) && (paramInt >= j) && (paramInt <= this.uBt))
            {
              paramViewGroup.uBK.setVisibility(8);
              paramViewGroup.uBO.setVisibility(8);
              paramViewGroup.uBR.setVisibility(8);
              paramViewGroup.uBL.setVisibility(8);
              paramViewGroup.uBM.setVisibility(8);
              paramViewGroup.uBN.setVisibility(8);
              break label433;
            }
            paramViewGroup.uBK.setVisibility(0);
            a(paramInt, paramViewGroup, i);
            paramViewGroup.uBO.setVisibility(8);
            paramViewGroup.uBR.setVisibility(8);
            break label433;
            label749:
            paramViewGroup.uBS.setVisibility(8);
          }
          label761:
          i = 0;
        }
      }
    }
  }
  
  final class a
  {
    public ImageView uBA = null;
    public ImageView uBB = null;
    public TextView uBC = null;
    public TextView uBD = null;
    public String uBE = null;
    public String uBF = null;
    public ImageView uBG = null;
    public ImageView uBH = null;
    public ImageView uBI = null;
    public ImageView uBJ = null;
    public View uBz = null;
    
    a() {}
  }
  
  final class b
  {
    LinearLayout uBK;
    TextView uBL;
    View uBM;
    View uBN;
    View uBO;
    ImageView uBP;
    TextView uBQ;
    View uBR = null;
    View uBS;
    
    b() {}
  }
  
  final class c
  {
    MallFunction uBT;
    int uBU;
    
    c() {}
  }
  
  public static abstract interface d
  {
    public abstract void a(int paramInt, MallFunction paramMallFunction);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.b
 * JD-Core Version:    0.7.0.1
 */
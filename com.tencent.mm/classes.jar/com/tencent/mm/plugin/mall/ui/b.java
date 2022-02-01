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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class b
  extends BaseAdapter
{
  private Context mContext;
  private LayoutInflater mInflater;
  private final int tsT;
  private final int tsU;
  private final int tsV;
  List<ArrayList<c>> tsW;
  d tsX;
  private boolean tsY;
  private int tsZ;
  private SparseArray<String> tsn;
  private int tso;
  private int tta;
  private boolean ttb;
  private boolean ttc;
  
  public b(Context paramContext, int paramInt)
  {
    AppMethodBeat.i(66035);
    this.tsT = 3;
    this.tsU = 9;
    this.tsV = 3;
    this.tsW = new ArrayList();
    this.tsn = null;
    this.tsY = true;
    this.tsZ = 0;
    this.tta = 0;
    this.ttb = false;
    this.ttc = false;
    this.mContext = paramContext;
    this.tso = paramInt;
    this.mInflater = LayoutInflater.from(this.mContext);
    AppMethodBeat.o(66035);
  }
  
  private boolean Gm(int paramInt)
  {
    AppMethodBeat.i(66038);
    int j;
    boolean bool;
    if (this.tsZ > 9)
    {
      j = 0;
      int i = 0;
      while (j <= paramInt)
      {
        i += ((ArrayList)this.tsW.get(j)).size();
        j += 1;
      }
      if (this.tta > 3)
      {
        j = 3;
        if (i < 9) {
          break label117;
        }
        if ((!this.tsY) || (paramInt != j)) {
          break label96;
        }
        bool = true;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(66038);
      return bool;
      j = this.tta;
      break;
      label96:
      if ((paramInt == this.tta) && (!this.tsY)) {
        bool = true;
      } else {
        label117:
        bool = false;
      }
    }
  }
  
  private String Gn(int paramInt)
  {
    AppMethodBeat.i(66048);
    if (this.tsn == null)
    {
      AppMethodBeat.o(66048);
      return null;
    }
    String str = (String)this.tsn.get(paramInt);
    AppMethodBeat.o(66048);
    return str;
  }
  
  private void a(int paramInt1, b paramb, int paramInt2)
  {
    AppMethodBeat.i(66040);
    List localList = (List)this.tsW.get(paramInt1);
    localList.get(0);
    int m;
    Object localObject;
    int j;
    int k;
    int i;
    if (localList.size() > 0)
    {
      m = ((c)localList.get(0)).ttA.type;
      localObject = Gn(m);
      j = 0;
      k = 0;
      if (bt.isNullOrNil((String)localObject)) {
        break label680;
      }
      if (paramInt1 == 0)
      {
        i = 1;
        if (paramInt1 != this.tsW.size() - 1) {
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
        paramb.tts.setText((CharSequence)localObject);
        paramb.tts.setVisibility(0);
        paramb.ttt.setVisibility(8);
        paramb.ttu.setVisibility(0);
        paramb.tts.setMinHeight(a.cNj());
        paramb.ttu.setBackgroundColor(c.cNG());
        localObject = paramb.ttr;
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
        if (((ArrayList)this.tsW.get(paramInt1 - 1)).size() <= 0) {
          break;
        }
        i = k;
        if (m == ((c)((ArrayList)this.tsW.get(paramInt1 - 1)).get(0)).ttA.type) {
          break;
        }
        i = 1;
        break;
        label355:
        j = i;
        if (m == ((c)((ArrayList)this.tsW.get(paramInt1 + 1)).get(0)).ttA.type) {
          break label680;
        }
        paramInt1 = 1;
        break label104;
        paramb.tts.setVisibility(8);
        paramb.ttt.setVisibility(8);
        paramb.ttu.setVisibility(8);
        break label163;
        paramb.tts.setVisibility(8);
        paramb.ttt.setVisibility(8);
        paramb.ttu.setVisibility(8);
        paramInt1 = 0;
        break label163;
        label459:
        ((LinearLayout)localObject).getChildAt(i).setFocusable(true);
        ((LinearLayout)localObject).getChildAt(i).setOnClickListener(null);
        a locala = (a)((LinearLayout)localObject).getChildAt(i).getTag();
        locala.ttg.setVisibility(4);
        paramb.setEnabled(false);
        paramb.setClickable(false);
        a(locala);
        break label249;
        paramb = s((ViewGroup)localObject);
        if (i < localList.size()) {
          a(paramb, (c)localList.get(i), i, paramInt2);
        }
        for (;;)
        {
          ((LinearLayout)localObject).addView(paramb, new LinearLayout.LayoutParams(-2, a.cNh(), 1.0F));
          break;
          paramb.setFocusable(true);
          locala = (a)paramb.getTag();
          locala.ttg.setVisibility(4);
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
    final MallFunction localMallFunction = paramc.ttA;
    final int i = paramc.ttB;
    locala.ttm = localMallFunction.ttm;
    locala.ttl = localMallFunction.ttl;
    com.tencent.mm.plugin.mall.b.a.d(locala.tth, locala.ttl, 2131690773);
    locala.ttj.setText(localMallFunction.dAn);
    locala.tti.setVisibility(8);
    if ((localMallFunction.AiC != null) && (!bt.isNullOrNil(localMallFunction.AiC.AiK)) && (b(localMallFunction)))
    {
      if (d.edw().auc(localMallFunction.uWF) != null)
      {
        ad.w("MicroMsg.FunctionListAdapter", "show the news : " + d.edw().auc(localMallFunction.uWF).AiK);
        locala.ttk.setText(localMallFunction.AiC.AiK);
        locala.ttk.setVisibility(0);
      }
      for (;;)
      {
        com.tencent.mm.plugin.mall.b.a.q(locala.tti, locala.ttm);
        locala.tti.setVisibility(0);
        paramView.setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66034);
            ad.v("MicroMsg.FunctionListAdapter", "on Click");
            if (b.c(b.this) != null) {
              b.c(b.this).a(i, localMallFunction);
            }
            AppMethodBeat.o(66034);
          }
        });
        locala.ttg.setVisibility(0);
        paramView.setEnabled(true);
        paramView.setClickable(true);
        a(locala, paramInt1, paramInt2);
        AppMethodBeat.o(66046);
        return;
        locala.ttk.setVisibility(4);
      }
    }
    if ((localMallFunction.AiC != null) && (localMallFunction.AiC.AiP == 1))
    {
      locala.ttk.setText(localMallFunction.AiC.AiK);
      locala.ttk.setVisibility(0);
    }
    for (;;)
    {
      locala.tti.setImageBitmap(null);
      locala.tti.setVisibility(8);
      break;
      locala.ttk.setText("");
      locala.ttk.setVisibility(4);
    }
  }
  
  private static void a(a parama)
  {
    AppMethodBeat.i(66042);
    parama.ttn.setVisibility(0);
    parama.tto.setVisibility(4);
    parama.ttp.setVisibility(4);
    parama.ttq.setVisibility(4);
    AppMethodBeat.o(66042);
  }
  
  private static void a(a parama, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(66043);
    parama.ttq.setVisibility(4);
    if (paramInt1 == 0) {
      parama.tto.setVisibility(0);
    }
    while (paramInt2 == 0)
    {
      parama.ttn.setVisibility(0);
      parama.ttp.setVisibility(4);
      AppMethodBeat.o(66043);
      return;
      if (paramInt1 == 1) {
        parama.tto.setVisibility(0);
      } else if (paramInt1 == 2) {
        parama.tto.setVisibility(4);
      }
    }
    if (paramInt2 == 1)
    {
      parama.ttn.setVisibility(4);
      parama.ttp.setVisibility(0);
      AppMethodBeat.o(66043);
      return;
    }
    parama.ttn.setVisibility(0);
    parama.ttp.setVisibility(0);
    AppMethodBeat.o(66043);
  }
  
  public static boolean a(MallFunction paramMallFunction)
  {
    AppMethodBeat.i(66045);
    if ((paramMallFunction.AiC != null) && (!bt.isNullOrNil(paramMallFunction.AiC.AiK)) && (b(paramMallFunction)) && (d.edw().auc(paramMallFunction.uWF) != null))
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
    MallNews localMallNews = d.edw().auc(paramMallFunction.uWF);
    if ((localMallNews == null) || (bt.isNullOrNil(localMallNews.yCo)) || (!localMallNews.yCo.equals(paramMallFunction.AiC.yCo)))
    {
      ad.d("MicroMsg.FunctionListAdapter", "old news null or should be replaced %s %s", new Object[] { paramMallFunction.AiC.yCo, paramMallFunction.dAn });
      d.edw().b(paramMallFunction.AiC);
      AppMethodBeat.o(66047);
      return true;
    }
    if (localMallNews != null)
    {
      if (!"0".equals(localMallNews.AiI))
      {
        ad.d("MicroMsg.FunctionListAdapter", "still old news or clicked, then should not show");
        AppMethodBeat.o(66047);
        return false;
      }
      ad.d("MicroMsg.FunctionListAdapter", "still old news and should show");
      AppMethodBeat.o(66047);
      return true;
    }
    AppMethodBeat.o(66047);
    return false;
  }
  
  private boolean cNk()
  {
    AppMethodBeat.i(66044);
    if (this.tsW.size() > 3)
    {
      Object localObject = (ArrayList)this.tsW.get(3);
      if ((localObject != null) && (((ArrayList)localObject).size() > 0))
      {
        int i = ((c)((ArrayList)localObject).get(0)).ttA.type;
        localObject = ((ArrayList)localObject).iterator();
        while (((Iterator)localObject).hasNext())
        {
          c localc = (c)((Iterator)localObject).next();
          if (localc.ttA.type == i) {
            if (a(localc.ttA))
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
  
  private View s(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(66041);
    a locala = new a();
    paramViewGroup = this.mInflater.inflate(2131494693, paramViewGroup, false);
    locala.ttg = paramViewGroup.findViewById(2131302017);
    locala.tth = ((ImageView)paramViewGroup.findViewById(2131302014));
    locala.ttj = ((TextView)paramViewGroup.findViewById(2131302019));
    locala.ttk = ((TextView)paramViewGroup.findViewById(2131302013));
    locala.tti = ((ImageView)paramViewGroup.findViewById(2131302795));
    locala.ttn = ((ImageView)paramViewGroup.findViewById(2131299169));
    locala.tto = ((ImageView)paramViewGroup.findViewById(2131299167));
    locala.ttp = ((ImageView)paramViewGroup.findViewById(2131299159));
    locala.ttq = ((ImageView)paramViewGroup.findViewById(2131299163));
    paramViewGroup.setTag(locala);
    AppMethodBeat.o(66041);
    return paramViewGroup;
  }
  
  public final void Z(ArrayList<MallFunction> paramArrayList)
  {
    AppMethodBeat.i(66036);
    this.tsW.clear();
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
          localc.ttB = (i + j);
          localc.ttA = ((MallFunction)paramArrayList.get(i + j));
          localArrayList.add(localc);
          j += 1;
        }
        if (localArrayList.size() > 0) {
          this.tsW.add(localArrayList);
        }
        i += j;
      }
      this.tsZ = 0;
      this.tta = 0;
      paramArrayList = this.tsW.iterator();
      i = -1;
      if (paramArrayList.hasNext())
      {
        localArrayList = (ArrayList)paramArrayList.next();
        if (localArrayList.size() <= 0) {
          break label360;
        }
        if ((i == -1) || (i == ((c)localArrayList.get(0)).ttA.type))
        {
          this.tsZ += localArrayList.size();
          this.tta += 1;
          i = ((c)localArrayList.get(0)).ttA.type;
        }
      }
    }
    label360:
    for (;;)
    {
      break;
      this.tta -= 1;
      this.tsn = j.cNg().Gk(this.tso).tsn;
      this.ttb = cNk();
      ad.i("MicroMsg.FunctionListAdapter", "hasMoreNewAtFirstSectionBottom: %s", new Object[] { Boolean.valueOf(this.ttb) });
      notifyDataSetChanged();
      AppMethodBeat.o(66036);
      return;
    }
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(66037);
    int i = this.tsW.size();
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
    boolean bool2 = Gm(paramInt);
    if (this.tsZ > 9) {
      if (this.tta <= 3) {}
    }
    for (int j = i;; j = -1)
    {
      if ((!bool2) && (paramInt + 1 < this.tsW.size())) {}
      for (boolean bool1 = Gm(paramInt + 1);; bool1 = false)
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
            paramView.ttr = ((LinearLayout)localView.findViewById(2131302010));
            paramView.tts = ((TextView)localView.findViewById(2131302009));
            paramView.ttt = localView.findViewById(2131299154);
            paramView.ttu = localView.findViewById(2131301426);
            paramView.ttv = localView.findViewById(2131302138);
            paramView.ttx = ((TextView)localView.findViewById(2131302139));
            paramView.ttw = ((ImageView)localView.findViewById(2131302137));
            paramView.tty = localView.findViewById(2131302469);
            paramView.ttz = localView.findViewById(2131297448);
            paramView.ttv.setOnClickListener(new View.OnClickListener()
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
            paramViewGroup.tts.setVisibility(8);
            paramViewGroup.ttt.setVisibility(8);
            paramViewGroup.ttu.setVisibility(8);
            paramViewGroup.ttv.setVisibility(0);
            paramViewGroup.ttw.setImageResource(2131690517);
            paramViewGroup.ttw.setColorFilter(this.mContext.getResources().getColor(2131100547), PorterDuff.Mode.SRC_ATOP);
            paramViewGroup.ttw.setPivotX(paramViewGroup.ttw.getWidth() / 2);
            paramViewGroup.ttw.setPivotY(paramViewGroup.ttw.getHeight() / 2);
            paramViewGroup.ttw.setRotation(90.0F);
            paramViewGroup.ttx.setText(this.mContext.getString(2131761090));
            if ((!this.ttb) || (this.ttc)) {
              break label504;
            }
            paramViewGroup.tty.setVisibility(0);
            label400:
            if (!this.tsY) {
              break label516;
            }
            paramViewGroup.ttr.setVisibility(8);
            paramViewGroup.ttx.setText(this.mContext.getString(2131761090));
            label433:
            if (paramInt != getCount() - 1) {
              break label749;
            }
            paramViewGroup.ttz.setBackgroundColor(c.cNG());
            paramViewGroup.ttz.setVisibility(0);
          }
          for (;;)
          {
            AppMethodBeat.o(66039);
            return localView;
            i = this.tta;
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
            paramViewGroup.tty.setVisibility(8);
            break label400;
            label516:
            paramViewGroup.ttr.setVisibility(0);
            a(paramInt, paramViewGroup, i);
            paramViewGroup.ttw.setImageResource(2131690517);
            paramViewGroup.ttw.setColorFilter(this.mContext.getResources().getColor(2131100547), PorterDuff.Mode.SRC_ATOP);
            paramViewGroup.ttw.setPivotX(paramViewGroup.ttw.getWidth() / 2);
            paramViewGroup.ttw.setPivotY(paramViewGroup.ttw.getHeight() / 2);
            paramViewGroup.ttw.setRotation(270.0F);
            paramViewGroup.ttx.setText(this.mContext.getString(2131761088));
            break label433;
            label629:
            if ((j > 0) && (this.tsY) && (paramInt >= j) && (paramInt <= this.tta))
            {
              paramViewGroup.ttr.setVisibility(8);
              paramViewGroup.ttv.setVisibility(8);
              paramViewGroup.tty.setVisibility(8);
              paramViewGroup.tts.setVisibility(8);
              paramViewGroup.ttt.setVisibility(8);
              paramViewGroup.ttu.setVisibility(8);
              break label433;
            }
            paramViewGroup.ttr.setVisibility(0);
            a(paramInt, paramViewGroup, i);
            paramViewGroup.ttv.setVisibility(8);
            paramViewGroup.tty.setVisibility(8);
            break label433;
            label749:
            paramViewGroup.ttz.setVisibility(8);
          }
          label761:
          i = 0;
        }
      }
    }
  }
  
  final class a
  {
    public View ttg = null;
    public ImageView tth = null;
    public ImageView tti = null;
    public TextView ttj = null;
    public TextView ttk = null;
    public String ttl = null;
    public String ttm = null;
    public ImageView ttn = null;
    public ImageView tto = null;
    public ImageView ttp = null;
    public ImageView ttq = null;
    
    a() {}
  }
  
  final class b
  {
    LinearLayout ttr;
    TextView tts;
    View ttt;
    View ttu;
    View ttv;
    ImageView ttw;
    TextView ttx;
    View tty = null;
    View ttz;
    
    b() {}
  }
  
  final class c
  {
    MallFunction ttA;
    int ttB;
    
    c() {}
  }
  
  public static abstract interface d
  {
    public abstract void a(int paramInt, MallFunction paramMallFunction);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.b
 * JD-Core Version:    0.7.0.1
 */
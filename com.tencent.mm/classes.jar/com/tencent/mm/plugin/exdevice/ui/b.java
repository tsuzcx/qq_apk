package com.tencent.mm.plugin.exdevice.ui;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.e;
import com.tencent.mm.R.f;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.component.k;
import com.tencent.mm.ui.component.k.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
  extends BaseAdapter
{
  private String appusername;
  private Context mContext;
  private String sWX;
  List<d> yBH;
  Map<String, String> yBI;
  String yBJ;
  c yBK;
  private boolean yBL;
  private d.a yBM;
  private View.OnClickListener yBN;
  private View.OnClickListener yBO;
  private View.OnClickListener yBP;
  
  public b(Context paramContext, String paramString)
  {
    AppMethodBeat.i(24168);
    this.yBL = false;
    this.yBM = new d.a();
    this.yBN = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24165);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        Log.i("MicroMsg.ExdeviceRankAdapter", "hy: user clicked on the content");
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        paramAnonymousView = b.this.Lp(i);
        b.a(b.this).apU(paramAnonymousView.yEC.field_username);
        a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(24165);
      }
    };
    this.yBO = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24166);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        b.a(b.this).apU(b.b(b.this));
        a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(24166);
      }
    };
    this.yBP = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24167);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        b.a(b.this).dHh();
        a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(24167);
      }
    };
    this.sWX = z.bAM();
    this.mContext = paramContext;
    this.appusername = paramString;
    AppMethodBeat.o(24168);
  }
  
  private List<d> a(ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.c> paramArrayList, ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> paramArrayList1, boolean paramBoolean)
  {
    AppMethodBeat.i(24171);
    Object localObject1 = new LinkedList(paramArrayList);
    paramArrayList = new ArrayList();
    Object localObject2 = h(this.sWX, paramArrayList1);
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = this.yBM;
      ((d.a)localObject3).yEC = ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2);
      ((d.a)localObject3).yED = 3;
      if (((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_score == 0) {
        ((com.tencent.mm.plugin.sport.a.b)h.ax(com.tencent.mm.plugin.sport.a.b.class)).o((Activity)this.mContext, this.sWX);
      }
      if (!paramBoolean) {
        break label357;
      }
    }
    Object localObject4;
    label357:
    for (this.yBM.yf = 2;; this.yBM.yf = 1)
    {
      paramArrayList.add(this.yBM.dHo());
      localObject2 = this.yBM;
      ((d.a)localObject2).yf = 0;
      paramArrayList.add(((d.a)localObject2).dHo());
      f((LinkedList)localObject1, this.sWX);
      localObject2 = new ArrayList();
      Log.d("MicroMsg.ExdeviceRankAdapter", "ap: follow size %s, %s", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()), ((LinkedList)localObject1).toString() });
      localObject3 = paramArrayList1.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (com.tencent.mm.plugin.exdevice.g.b.a.d)((Iterator)localObject3).next();
        d.a locala = this.yBM;
        locala.yEC = ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject4);
        locala.yf = 1;
        locala.yED = 4;
        ((ArrayList)localObject2).add(locala.dHo());
        if ((((LinkedList)localObject1).size() > 0) && (g((LinkedList)localObject1, ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject4).field_username)))
        {
          locala = this.yBM;
          locala.yEC = ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject4);
          locala.yf = 1;
          locala.yED = 2;
          paramArrayList.add(locala.dHo());
          f((LinkedList)localObject1, ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject4).field_username);
        }
      }
      localObject2 = this.yBM;
      ((d.a)localObject2).yEC = null;
      ((d.a)localObject2).appusername = this.appusername;
      ((d.a)localObject2).username = this.sWX;
      ((d.a)localObject2).yED = 7;
      break;
    }
    if (((LinkedList)localObject1).size() > 0)
    {
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.exdevice.g.b.a.c)((Iterator)localObject1).next();
        localObject4 = this.yBM;
        ((d.a)localObject4).username = ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject3).field_username;
        ((d.a)localObject4).appusername = this.appusername;
        ((d.a)localObject4).yEC = null;
        ((d.a)localObject4).yf = 1;
        ((d.a)localObject4).yED = 6;
        paramArrayList.add(((d.a)localObject4).dHo());
      }
    }
    if (paramArrayList.size() > 2)
    {
      ((d)paramArrayList.get(paramArrayList.size() - 1)).yED = (((d)paramArrayList.get(paramArrayList.size() - 1)).yED | 0x2 | 0x1);
      localObject1 = this.yBM;
      ((d.a)localObject1).yf = 0;
      ((d.a)localObject1).yEC = null;
      paramArrayList.add(((d.a)localObject1).dHo());
    }
    if (((ArrayList)localObject2).size() > 1) {
      ((d)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1)).yED = 5;
    }
    paramArrayList.addAll((Collection)localObject2);
    Log.d("MicroMsg.ExdeviceRankAdapter", "rank: %d %s", new Object[] { Integer.valueOf(paramArrayList1.size()), paramArrayList1.toString() });
    Log.d("MicroMsg.ExdeviceRankAdapter", "all: %s %s", new Object[] { Integer.valueOf(paramArrayList.size()), paramArrayList.toString() });
    AppMethodBeat.o(24171);
    return paramArrayList;
  }
  
  private static void f(LinkedList<com.tencent.mm.plugin.exdevice.g.b.a.c> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(24169);
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      com.tencent.mm.plugin.exdevice.g.b.a.c localc = (com.tencent.mm.plugin.exdevice.g.b.a.c)paramLinkedList.next();
      if (localc.field_username.equalsIgnoreCase(paramString))
      {
        Log.d("MicroMsg.ExdeviceRankAdapter", "username: %s remove", new Object[] { localc.toString() });
        paramLinkedList.remove();
      }
    }
    AppMethodBeat.o(24169);
  }
  
  public static void finish()
  {
    AppMethodBeat.i(24177);
    ((com.tencent.mm.plugin.sport.a.b)h.ax(com.tencent.mm.plugin.sport.a.b.class)).htU();
    AppMethodBeat.o(24177);
  }
  
  private static boolean g(LinkedList<com.tencent.mm.plugin.exdevice.g.b.a.c> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(24170);
    try
    {
      paramLinkedList = paramLinkedList.iterator();
      while (paramLinkedList.hasNext())
      {
        boolean bool = ((com.tencent.mm.plugin.exdevice.g.b.a.c)paramLinkedList.next()).field_username.equalsIgnoreCase(paramString);
        if (bool)
        {
          AppMethodBeat.o(24170);
          return true;
        }
      }
      AppMethodBeat.o(24170);
      return false;
    }
    catch (Exception paramLinkedList)
    {
      Log.d("MicroMsg.ExdeviceRankAdapter", paramLinkedList.toString());
      AppMethodBeat.o(24170);
    }
    return false;
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.a.d h(String paramString, ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> paramArrayList)
  {
    AppMethodBeat.i(24173);
    if (paramArrayList == null)
    {
      AppMethodBeat.o(24173);
      return null;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      com.tencent.mm.plugin.exdevice.g.b.a.d locald = (com.tencent.mm.plugin.exdevice.g.b.a.d)paramArrayList.next();
      if (paramString.equalsIgnoreCase(locald.field_username))
      {
        AppMethodBeat.o(24173);
        return locald;
      }
    }
    AppMethodBeat.o(24173);
    return null;
  }
  
  public final d Lp(int paramInt)
  {
    AppMethodBeat.i(24175);
    d locald = (d)this.yBH.get(paramInt);
    AppMethodBeat.o(24175);
    return locald;
  }
  
  public final List<d> b(ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.c> paramArrayList, ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> paramArrayList1, boolean paramBoolean)
  {
    AppMethodBeat.i(24172);
    Object localObject = paramArrayList;
    if (paramArrayList == null) {}
    try
    {
      localObject = new ArrayList();
      paramArrayList = paramArrayList1;
      if (paramArrayList1 == null) {
        paramArrayList = new ArrayList();
      }
      paramArrayList = a((ArrayList)localObject, paramArrayList, paramBoolean);
      AppMethodBeat.o(24172);
      return paramArrayList;
    }
    catch (Exception paramArrayList)
    {
      Log.w("MicroMsg.ExdeviceRankAdapter", "ap: rank exception,null info");
      paramArrayList = new ArrayList();
      AppMethodBeat.o(24172);
    }
    return paramArrayList;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(24174);
    if (this.yBH == null)
    {
      AppMethodBeat.o(24174);
      return 0;
    }
    int i = this.yBH.size();
    AppMethodBeat.o(24174);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(24176);
    paramInt = Lp(paramInt).yf;
    AppMethodBeat.o(24176);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(24178);
    final com.tencent.mm.plugin.exdevice.g.b.a.d locald = Lp(paramInt).yEC;
    Object localObject1 = Lp(paramInt);
    int i = getItemViewType(paramInt);
    int j = ((d)localObject1).yED;
    Object localObject2;
    if (paramView == null)
    {
      localObject1 = LayoutInflater.from(this.mContext);
      switch (i)
      {
      default: 
        localObject1 = null;
        paramViewGroup = paramView;
        paramView = (View)localObject1;
        localObject1 = paramView;
        localObject2 = paramViewGroup;
        if (paramView != null)
        {
          paramView.hDw = paramViewGroup.findViewById(R.h.container);
          paramView.yBS = paramViewGroup.findViewById(R.h.item_content);
          paramView.ysw = ((TextView)paramViewGroup.findViewById(R.h.fHl));
          paramView.yBT = ((ImageView)paramViewGroup.findViewById(R.h.fHo));
          paramView.yBU = ((NoMeasuredTextView)paramViewGroup.findViewById(R.h.fHp));
          paramView.yBV = ((TextView)paramViewGroup.findViewById(R.h.fGS));
          paramView.yBW = ((ExdeviceLikeView)paramViewGroup.findViewById(R.h.fHd));
          paramView.lNO = paramViewGroup.findViewById(R.h.fFS);
          paramView.yBY = paramViewGroup.findViewById(R.h.fHq);
          paramView.yBX = paramViewGroup.findViewById(R.h.fGW);
          paramView.yBZ = ((TextView)paramViewGroup.findViewById(R.h.fXA));
          paramView.yCa = paramViewGroup.findViewById(R.h.frB);
          paramView.yCb = ((ImageView)paramViewGroup.findViewById(R.h.frx));
          paramView.yCc = ((TextView)paramViewGroup.findViewById(R.h.frC));
          paramView.yCd = ((TextView)paramViewGroup.findViewById(R.h.fry));
          paramView.yCe = ((TextView)paramViewGroup.findViewById(R.h.frz));
          paramView.yCf = ((TextView)paramViewGroup.findViewById(R.h.frA));
          if (paramView.yBU != null)
          {
            paramView.yBU.setTextSize(0, this.mContext.getResources().getDimension(R.f.fll));
            paramView.yBU.setTextColor(this.mContext.getResources().getColor(R.e.fkz));
            paramView.yBU.setSingleLine(true);
            paramView.yBU.setShouldEllipsize(true);
          }
          paramViewGroup.setTag(paramView);
          localObject2 = paramViewGroup;
          localObject1 = paramView;
        }
        if ((locald != null) && (localObject1 != null)) {
          if (!this.sWX.equalsIgnoreCase(locald.field_username)) {
            break label640;
          }
        }
        break;
      }
    }
    label640:
    for (this.yBL = true;; this.yBL = false)
    {
      if (i != 2) {
        break label648;
      }
      ((b)localObject1).ysw.setText(String.valueOf(locald.field_ranknum));
      ((b)localObject1).yBV.setText(String.valueOf(locald.field_score));
      a.b.g(((b)localObject1).yBT, locald.field_username);
      ((b)localObject1).hDw.setOnClickListener(this.yBO);
      ((b)localObject1).yBZ.setOnClickListener(this.yBP);
      AppMethodBeat.o(24178);
      return localObject2;
      paramViewGroup = ((LayoutInflater)localObject1).inflate(R.i.gjL, paramViewGroup, false);
      paramView = new a();
      paramView.pKl = paramViewGroup.findViewById(R.h.fFS);
      paramViewGroup.setTag(paramView);
      paramView = null;
      break;
      paramViewGroup = ((LayoutInflater)localObject1).inflate(R.i.gjK, paramViewGroup, false);
      paramView = new b();
      break;
      paramViewGroup = ((LayoutInflater)localObject1).inflate(R.i.gjM, paramViewGroup, false);
      paramView = new b();
      break;
      switch (i)
      {
      default: 
        localObject1 = null;
        localObject2 = paramView;
        break;
      case 1: 
      case 2: 
        localObject1 = (b)paramView.getTag();
        localObject2 = paramView;
        break;
      }
    }
    label648:
    if (((j & 0x2) != 2) && (locald.field_username.equalsIgnoreCase(this.yBJ)) && (!this.sWX.equalsIgnoreCase(this.yBJ)))
    {
      ((b)localObject1).yBS.setBackgroundColor(this.mContext.getResources().getColor(R.e.fkw));
      label706:
      if ((j & 0x1) != 1) {
        break label1115;
      }
      ((b)localObject1).lNO.setVisibility(8);
      label724:
      if (locald.field_ranknum < 100) {
        break label1127;
      }
      ((b)localObject1).ysw.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.f.fln));
      label757:
      if (locald.field_ranknum != 0) {
        break label1153;
      }
      ((b)localObject1).ysw.setText("");
      label776:
      if (locald.field_score < 10000) {
        break label1182;
      }
      ((b)localObject1).yBV.setTextColor(this.mContext.getResources().getColor(R.e.fky));
      label808:
      ((b)localObject1).yBV.setText(String.valueOf(locald.field_score));
      a.b.g(((b)localObject1).yBT, locald.field_username);
      if (this.yBL) {
        break label1206;
      }
      bh.bCz();
      if ((com.tencent.mm.model.c.bzA().bxr(locald.field_username)) || (this.yBI == null) || (Util.isNullOrNil((String)this.yBI.get(locald.field_username)))) {
        break label1206;
      }
      ((b)localObject1).yBU.setText(p.b(this.mContext, (CharSequence)this.yBI.get(locald.field_username), ((b)localObject1).yBU.getTextSize()));
      label934:
      ((b)localObject1).yBW.setLikeNum(locald.field_likecount);
      if (!this.yBL) {
        break label1252;
      }
      if (locald.field_likecount == 0) {
        break label1240;
      }
      ((b)localObject1).yBW.setSelfLikeState(1);
      label971:
      if ((locald.field_score <= 0) && (!this.yBL)) {
        break label1268;
      }
      ((b)localObject1).yBW.setClickable(true);
      ((b)localObject1).yBW.setOnLikeViewClickListener(new ExdeviceLikeView.a()
      {
        public final boolean dGV()
        {
          AppMethodBeat.i(24164);
          if (b.a(b.this) != null)
          {
            boolean bool = b.a(b.this).apV(locald.field_username);
            AppMethodBeat.o(24164);
            return bool;
          }
          AppMethodBeat.o(24164);
          return true;
        }
        
        public final void qz(int paramAnonymousInt)
        {
          AppMethodBeat.i(24163);
          Log.i("MicroMsg.ExdeviceRankAdapter", "hy: like view clicked.after statae: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (b.a(b.this) != null) {
            b.a(b.this).eg(locald.field_username, paramAnonymousInt);
          }
          AppMethodBeat.o(24163);
        }
      });
    }
    for (;;)
    {
      paramView = k.aeZF;
      ((f)k.nq(this.mContext).q(f.class)).a(locald, (b)localObject1);
      ((b)localObject1).yBX.setTag(Integer.valueOf(paramInt));
      ((b)localObject1).yBX.setOnClickListener(this.yBN);
      ((b)localObject1).yBY.setTag(Integer.valueOf(paramInt));
      ((b)localObject1).yBY.setOnClickListener(this.yBN);
      break;
      ((b)localObject1).yBS.setBackgroundColor(this.mContext.getResources().getColor(R.e.fkv));
      break label706;
      label1115:
      ((b)localObject1).lNO.setVisibility(0);
      break label724;
      label1127:
      ((b)localObject1).ysw.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.f.flm));
      break label757;
      label1153:
      ((b)localObject1).ysw.setText(locald.field_ranknum);
      break label776;
      label1182:
      ((b)localObject1).yBV.setTextColor(this.mContext.getResources().getColor(R.e.fkx));
      break label808;
      label1206:
      ((b)localObject1).yBU.setText(p.b(this.mContext, aa.getDisplayName(locald.field_username), ((b)localObject1).yBU.getTextSize()));
      break label934;
      label1240:
      ((b)localObject1).yBW.setSelfLikeState(0);
      break label971;
      label1252:
      ((b)localObject1).yBW.setSelfLikeState(locald.field_selfLikeState);
      break label971;
      label1268:
      ((b)localObject1).yBW.setClickable(false);
    }
  }
  
  public final int getViewTypeCount()
  {
    return 3;
  }
  
  public final boolean isEnabled(int paramInt)
  {
    return false;
  }
  
  static final class a
  {
    public View pKl;
  }
  
  public static final class b
  {
    public View hDw;
    public View lNO;
    public View yBS;
    public ImageView yBT;
    public NoMeasuredTextView yBU;
    public TextView yBV;
    public ExdeviceLikeView yBW;
    public View yBX;
    public View yBY;
    public TextView yBZ;
    public View yCa;
    public ImageView yCb;
    public TextView yCc;
    public TextView yCd;
    public TextView yCe;
    public TextView yCf;
    public TextView ysw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.b
 * JD-Core Version:    0.7.0.1
 */
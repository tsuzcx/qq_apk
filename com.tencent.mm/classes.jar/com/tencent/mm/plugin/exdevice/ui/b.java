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
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public final class b
  extends BaseAdapter
{
  private String lEN;
  private Context mContext;
  List<e> qlX;
  Map<String, String> qlY;
  String qlZ;
  d qma;
  private String qmb;
  private boolean qmc;
  private e.a qmd;
  private View.OnClickListener qme;
  private View.OnClickListener qmf;
  private View.OnClickListener qmg;
  
  public b(Context paramContext, String paramString)
  {
    AppMethodBeat.i(24168);
    this.qmc = false;
    this.qmd = new e.a();
    this.qme = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24165);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.i("MicroMsg.ExdeviceRankAdapter", "hy: user clicked on the content");
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        paramAnonymousView = b.this.CL(i);
        b.a(b.this).acW(paramAnonymousView.qoQ.field_username);
        a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(24165);
      }
    };
    this.qmf = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24166);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        b.a(b.this).acW(b.b(b.this));
        a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(24166);
      }
    };
    this.qmg = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24167);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        b.a(b.this).cmz();
        a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(24167);
      }
    };
    this.lEN = u.aAm();
    this.mContext = paramContext;
    this.qmb = paramString;
    AppMethodBeat.o(24168);
  }
  
  private List<e> a(ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.c> paramArrayList, ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> paramArrayList1, boolean paramBoolean)
  {
    AppMethodBeat.i(24171);
    Object localObject1 = new LinkedList(paramArrayList);
    paramArrayList = new ArrayList();
    Object localObject2 = g(this.lEN, paramArrayList1);
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = this.qmd;
      ((e.a)localObject3).qoQ = ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2);
      ((e.a)localObject3).qoR = 3;
      if (((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_score == 0) {
        ((com.tencent.mm.plugin.sport.a.b)g.ab(com.tencent.mm.plugin.sport.a.b.class)).g((Activity)this.mContext, this.lEN);
      }
      if (!paramBoolean) {
        break label357;
      }
    }
    Object localObject4;
    label357:
    for (this.qmd.azj = 2;; this.qmd.azj = 1)
    {
      paramArrayList.add(this.qmd.cmF());
      localObject2 = this.qmd;
      ((e.a)localObject2).azj = 0;
      paramArrayList.add(((e.a)localObject2).cmF());
      e((LinkedList)localObject1, this.lEN);
      localObject2 = new ArrayList();
      ad.d("MicroMsg.ExdeviceRankAdapter", "ap: follow size %s, %s", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()), ((LinkedList)localObject1).toString() });
      localObject3 = paramArrayList1.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (com.tencent.mm.plugin.exdevice.g.b.a.d)((Iterator)localObject3).next();
        e.a locala = this.qmd;
        locala.qoQ = ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject4);
        locala.azj = 1;
        locala.qoR = 4;
        ((ArrayList)localObject2).add(locala.cmF());
        if ((((LinkedList)localObject1).size() > 0) && (f((LinkedList)localObject1, ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject4).field_username)))
        {
          locala = this.qmd;
          locala.qoQ = ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject4);
          locala.azj = 1;
          locala.qoR = 2;
          paramArrayList.add(locala.cmF());
          e((LinkedList)localObject1, ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject4).field_username);
        }
      }
      localObject2 = this.qmd;
      ((e.a)localObject2).qoQ = null;
      ((e.a)localObject2).qmb = this.qmb;
      ((e.a)localObject2).username = this.lEN;
      ((e.a)localObject2).qoR = 7;
      break;
    }
    if (((LinkedList)localObject1).size() > 0)
    {
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.exdevice.g.b.a.c)((Iterator)localObject1).next();
        localObject4 = this.qmd;
        ((e.a)localObject4).username = ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject3).field_username;
        ((e.a)localObject4).qmb = this.qmb;
        ((e.a)localObject4).qoQ = null;
        ((e.a)localObject4).azj = 1;
        ((e.a)localObject4).qoR = 6;
        paramArrayList.add(((e.a)localObject4).cmF());
      }
    }
    if (paramArrayList.size() > 2)
    {
      ((e)paramArrayList.get(paramArrayList.size() - 1)).qoR = (((e)paramArrayList.get(paramArrayList.size() - 1)).qoR | 0x2 | 0x1);
      localObject1 = this.qmd;
      ((e.a)localObject1).azj = 0;
      ((e.a)localObject1).qoQ = null;
      paramArrayList.add(((e.a)localObject1).cmF());
    }
    if (((ArrayList)localObject2).size() > 1) {
      ((e)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1)).qoR = 5;
    }
    paramArrayList.addAll((Collection)localObject2);
    ad.d("MicroMsg.ExdeviceRankAdapter", "rank: %d %s", new Object[] { Integer.valueOf(paramArrayList1.size()), paramArrayList1.toString() });
    ad.d("MicroMsg.ExdeviceRankAdapter", "all: %s %s", new Object[] { Integer.valueOf(paramArrayList.size()), paramArrayList.toString() });
    AppMethodBeat.o(24171);
    return paramArrayList;
  }
  
  private static void e(LinkedList<com.tencent.mm.plugin.exdevice.g.b.a.c> paramLinkedList, String paramString)
  {
    AppMethodBeat.i(24169);
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      com.tencent.mm.plugin.exdevice.g.b.a.c localc = (com.tencent.mm.plugin.exdevice.g.b.a.c)paramLinkedList.next();
      if (localc.field_username.equalsIgnoreCase(paramString))
      {
        ad.d("MicroMsg.ExdeviceRankAdapter", "username: %s remove", new Object[] { localc.toString() });
        paramLinkedList.remove();
      }
    }
    AppMethodBeat.o(24169);
  }
  
  private static boolean f(LinkedList<com.tencent.mm.plugin.exdevice.g.b.a.c> paramLinkedList, String paramString)
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
      ad.d("MicroMsg.ExdeviceRankAdapter", paramLinkedList.toString());
      AppMethodBeat.o(24170);
    }
    return false;
  }
  
  public static void finish()
  {
    AppMethodBeat.i(24177);
    ((com.tencent.mm.plugin.sport.a.b)g.ab(com.tencent.mm.plugin.sport.a.b.class)).ega();
    AppMethodBeat.o(24177);
  }
  
  public static com.tencent.mm.plugin.exdevice.g.b.a.d g(String paramString, ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> paramArrayList)
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
  
  public final e CL(int paramInt)
  {
    AppMethodBeat.i(24175);
    e locale = (e)this.qlX.get(paramInt);
    AppMethodBeat.o(24175);
    return locale;
  }
  
  public final List<e> b(ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.c> paramArrayList, ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> paramArrayList1, boolean paramBoolean)
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
      ad.w("MicroMsg.ExdeviceRankAdapter", "ap: rank exception,null info");
      paramArrayList = new ArrayList();
      AppMethodBeat.o(24172);
    }
    return paramArrayList;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(24174);
    if (this.qlX == null)
    {
      AppMethodBeat.o(24174);
      return 0;
    }
    int i = this.qlX.size();
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
    paramInt = CL(paramInt).azj;
    AppMethodBeat.o(24176);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(24178);
    final com.tencent.mm.plugin.exdevice.g.b.a.d locald = CL(paramInt).qoQ;
    Object localObject1 = CL(paramInt);
    int i = getItemViewType(paramInt);
    int j = ((e)localObject1).qoR;
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
          paramView.ize = paramViewGroup.findViewById(2131298736);
          paramView.oeQ = paramViewGroup.findViewById(2131301145);
          paramView.qdp = ((TextView)paramViewGroup.findViewById(2131299586));
          paramView.qmj = ((ImageView)paramViewGroup.findViewById(2131299590));
          paramView.qmk = ((NoMeasuredTextView)paramViewGroup.findViewById(2131299592));
          paramView.qmm = ((TextView)paramViewGroup.findViewById(2131299538));
          paramView.qmn = ((ExdeviceLikeView)paramViewGroup.findViewById(2131299553));
          paramView.qmo = paramViewGroup.findViewById(2131299155);
          paramView.qmq = paramViewGroup.findViewById(2131299594);
          paramView.qmp = paramViewGroup.findViewById(2131299544);
          paramView.qmr = ((TextView)paramViewGroup.findViewById(2131304752));
          if (paramView.qmk != null)
          {
            paramView.qmk.setTextSize(0, this.mContext.getResources().getDimension(2131165332));
            paramView.qmk.setTextColor(this.mContext.getResources().getColor(2131100308));
            paramView.qmk.setSingleLine(true);
            paramView.qmk.setShouldEllipsize(true);
          }
          paramViewGroup.setTag(paramView);
          localObject2 = paramViewGroup;
          localObject1 = paramView;
        }
        if ((locald != null) && (localObject1 != null)) {
          if (!this.lEN.equalsIgnoreCase(locald.field_username)) {
            break label572;
          }
        }
        break;
      }
    }
    label572:
    for (this.qmc = true;; this.qmc = false)
    {
      if (i != 2) {
        break label580;
      }
      ((b)localObject1).qdp.setText(String.valueOf(locald.field_ranknum));
      ((b)localObject1).qmm.setText(String.valueOf(locald.field_score));
      a.b.d(((b)localObject1).qmj, locald.field_username);
      ((b)localObject1).ize.setOnClickListener(this.qmf);
      ((b)localObject1).qmr.setOnClickListener(this.qmg);
      AppMethodBeat.o(24178);
      return localObject2;
      paramViewGroup = ((LayoutInflater)localObject1).inflate(2131493890, paramViewGroup, false);
      paramView = new a();
      paramView.iVT = paramViewGroup.findViewById(2131299155);
      paramViewGroup.setTag(paramView);
      paramView = null;
      break;
      paramViewGroup = ((LayoutInflater)localObject1).inflate(2131493889, paramViewGroup, false);
      paramView = new b();
      paramView.qml = ((TextView)paramViewGroup.findViewById(2131299593));
      break;
      paramViewGroup = ((LayoutInflater)localObject1).inflate(2131493891, paramViewGroup, false);
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
    label580:
    if (((b)localObject1).qml != null)
    {
      if ((j & 0x4) != 4)
      {
        ((b)localObject1).qml.setVisibility(0);
        ((b)localObject1).qml.setText(this.mContext.getResources().getString(2131758587, new Object[] { Integer.valueOf(locald.field_ranknum) }));
      }
    }
    else
    {
      if (((j & 0x2) == 2) || (!locald.field_username.equalsIgnoreCase(this.qlZ)) || (this.lEN.equalsIgnoreCase(this.qlZ))) {
        break label1070;
      }
      ((b)localObject1).oeQ.setBackgroundColor(this.mContext.getResources().getColor(2131100302));
      if ((j & 0x1) != 1) {
        break label1094;
      }
      ((b)localObject1).qmo.setVisibility(8);
      label717:
      if (locald.field_ranknum < 100) {
        break label1106;
      }
      ((b)localObject1).qdp.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(2131165334));
      label750:
      if ((j & 0x2) != 2) {
        break label1132;
      }
      ((b)localObject1).qdp.setText("");
      if (locald.field_score < 10000) {
        break label1161;
      }
      ((b)localObject1).qmm.setTextColor(this.mContext.getResources().getColor(2131100307));
      ((b)localObject1).qmm.setText(String.valueOf(locald.field_score));
      a.b.d(((b)localObject1).qmj, locald.field_username);
      if (this.qmc) {
        break label1185;
      }
      ba.aBQ();
      if ((com.tencent.mm.model.c.azp().aTg(locald.field_username)) || (this.qlY == null) || (bt.isNullOrNil((String)this.qlY.get(locald.field_username)))) {
        break label1185;
      }
      ((b)localObject1).qmk.setText(k.b(this.mContext, (CharSequence)this.qlY.get(locald.field_username), ((b)localObject1).qmk.getTextSize()));
      ((b)localObject1).qmn.setLikeNum(locald.field_likecount);
      if (!this.qmc) {
        break label1231;
      }
      if (locald.field_likecount == 0) {
        break label1219;
      }
      ((b)localObject1).qmn.setSelfLikeState(1);
      label964:
      if ((locald.field_score <= 0) && (!this.qmc)) {
        break label1247;
      }
      ((b)localObject1).qmn.setClickable(true);
      ((b)localObject1).qmn.setOnLikeViewClickListener(new ExdeviceLikeView.a()
      {
        public final boolean cmj()
        {
          AppMethodBeat.i(24164);
          if (b.a(b.this) != null)
          {
            boolean bool = b.a(b.this).acX(locald.field_username);
            AppMethodBeat.o(24164);
            return bool;
          }
          AppMethodBeat.o(24164);
          return true;
        }
        
        public final void lf(int paramAnonymousInt)
        {
          AppMethodBeat.i(24163);
          ad.i("MicroMsg.ExdeviceRankAdapter", "hy: like view clicked.after statae: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (b.a(b.this) != null) {
            b.a(b.this).cY(locald.field_username, paramAnonymousInt);
          }
          AppMethodBeat.o(24163);
        }
      });
    }
    for (;;)
    {
      label641:
      label699:
      ((b)localObject1).qmp.setTag(Integer.valueOf(paramInt));
      label769:
      label801:
      ((b)localObject1).qmp.setOnClickListener(this.qme);
      label927:
      ((b)localObject1).qmq.setTag(Integer.valueOf(paramInt));
      ((b)localObject1).qmq.setOnClickListener(this.qme);
      break;
      ((b)localObject1).qml.setVisibility(8);
      break label641;
      label1070:
      ((b)localObject1).oeQ.setBackgroundColor(this.mContext.getResources().getColor(2131100301));
      break label699;
      label1094:
      ((b)localObject1).qmo.setVisibility(0);
      break label717;
      label1106:
      ((b)localObject1).qdp.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(2131165333));
      break label750;
      label1132:
      ((b)localObject1).qdp.setText(locald.field_ranknum);
      break label769;
      label1161:
      ((b)localObject1).qmm.setTextColor(this.mContext.getResources().getColor(2131100306));
      break label801;
      label1185:
      ((b)localObject1).qmk.setText(k.b(this.mContext, v.zf(locald.field_username), ((b)localObject1).qmk.getTextSize()));
      break label927;
      label1219:
      ((b)localObject1).qmn.setSelfLikeState(0);
      break label964;
      label1231:
      ((b)localObject1).qmn.setSelfLikeState(locald.field_selfLikeState);
      break label964;
      label1247:
      ((b)localObject1).qmn.setClickable(false);
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
    public View iVT;
  }
  
  static final class b
  {
    public View ize;
    public View oeQ;
    public TextView qdp;
    public ImageView qmj;
    public NoMeasuredTextView qmk;
    public TextView qml;
    public TextView qmm;
    public ExdeviceLikeView qmn;
    public View qmo;
    public View qmp;
    public View qmq;
    public TextView qmr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.b
 * JD-Core Version:    0.7.0.1
 */
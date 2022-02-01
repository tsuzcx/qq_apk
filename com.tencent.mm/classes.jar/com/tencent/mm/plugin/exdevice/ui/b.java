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
import com.tencent.mm.model.bc;
import com.tencent.mm.model.v;
import com.tencent.mm.model.w;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
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
  private String lJm;
  private Context mContext;
  List<e> qsC;
  Map<String, String> qsD;
  String qsE;
  d qsF;
  private String qsG;
  private boolean qsH;
  private e.a qsI;
  private View.OnClickListener qsJ;
  private View.OnClickListener qsK;
  private View.OnClickListener qsL;
  
  public b(Context paramContext, String paramString)
  {
    AppMethodBeat.i(24168);
    this.qsH = false;
    this.qsI = new e.a();
    this.qsJ = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24165);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.ExdeviceRankAdapter", "hy: user clicked on the content");
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        paramAnonymousView = b.this.CX(i);
        b.a(b.this).adN(paramAnonymousView.qvw.field_username);
        a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(24165);
      }
    };
    this.qsK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24166);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        b.a(b.this).adN(b.b(b.this));
        a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(24166);
      }
    };
    this.qsL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24167);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        b.a(b.this).cnP();
        a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(24167);
      }
    };
    this.lJm = v.aAC();
    this.mContext = paramContext;
    this.qsG = paramString;
    AppMethodBeat.o(24168);
  }
  
  private List<e> a(ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.c> paramArrayList, ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> paramArrayList1, boolean paramBoolean)
  {
    AppMethodBeat.i(24171);
    Object localObject1 = new LinkedList(paramArrayList);
    paramArrayList = new ArrayList();
    Object localObject2 = g(this.lJm, paramArrayList1);
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = this.qsI;
      ((e.a)localObject3).qvw = ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2);
      ((e.a)localObject3).qvx = 3;
      if (((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_score == 0) {
        ((com.tencent.mm.plugin.sport.a.b)g.ab(com.tencent.mm.plugin.sport.a.b.class)).h((Activity)this.mContext, this.lJm);
      }
      if (!paramBoolean) {
        break label357;
      }
    }
    Object localObject4;
    label357:
    for (this.qsI.azj = 2;; this.qsI.azj = 1)
    {
      paramArrayList.add(this.qsI.cnV());
      localObject2 = this.qsI;
      ((e.a)localObject2).azj = 0;
      paramArrayList.add(((e.a)localObject2).cnV());
      e((LinkedList)localObject1, this.lJm);
      localObject2 = new ArrayList();
      ae.d("MicroMsg.ExdeviceRankAdapter", "ap: follow size %s, %s", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()), ((LinkedList)localObject1).toString() });
      localObject3 = paramArrayList1.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (com.tencent.mm.plugin.exdevice.g.b.a.d)((Iterator)localObject3).next();
        e.a locala = this.qsI;
        locala.qvw = ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject4);
        locala.azj = 1;
        locala.qvx = 4;
        ((ArrayList)localObject2).add(locala.cnV());
        if ((((LinkedList)localObject1).size() > 0) && (f((LinkedList)localObject1, ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject4).field_username)))
        {
          locala = this.qsI;
          locala.qvw = ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject4);
          locala.azj = 1;
          locala.qvx = 2;
          paramArrayList.add(locala.cnV());
          e((LinkedList)localObject1, ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject4).field_username);
        }
      }
      localObject2 = this.qsI;
      ((e.a)localObject2).qvw = null;
      ((e.a)localObject2).qsG = this.qsG;
      ((e.a)localObject2).username = this.lJm;
      ((e.a)localObject2).qvx = 7;
      break;
    }
    if (((LinkedList)localObject1).size() > 0)
    {
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.exdevice.g.b.a.c)((Iterator)localObject1).next();
        localObject4 = this.qsI;
        ((e.a)localObject4).username = ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject3).field_username;
        ((e.a)localObject4).qsG = this.qsG;
        ((e.a)localObject4).qvw = null;
        ((e.a)localObject4).azj = 1;
        ((e.a)localObject4).qvx = 6;
        paramArrayList.add(((e.a)localObject4).cnV());
      }
    }
    if (paramArrayList.size() > 2)
    {
      ((e)paramArrayList.get(paramArrayList.size() - 1)).qvx = (((e)paramArrayList.get(paramArrayList.size() - 1)).qvx | 0x2 | 0x1);
      localObject1 = this.qsI;
      ((e.a)localObject1).azj = 0;
      ((e.a)localObject1).qvw = null;
      paramArrayList.add(((e.a)localObject1).cnV());
    }
    if (((ArrayList)localObject2).size() > 1) {
      ((e)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1)).qvx = 5;
    }
    paramArrayList.addAll((Collection)localObject2);
    ae.d("MicroMsg.ExdeviceRankAdapter", "rank: %d %s", new Object[] { Integer.valueOf(paramArrayList1.size()), paramArrayList1.toString() });
    ae.d("MicroMsg.ExdeviceRankAdapter", "all: %s %s", new Object[] { Integer.valueOf(paramArrayList.size()), paramArrayList.toString() });
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
        ae.d("MicroMsg.ExdeviceRankAdapter", "username: %s remove", new Object[] { localc.toString() });
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
      ae.d("MicroMsg.ExdeviceRankAdapter", paramLinkedList.toString());
      AppMethodBeat.o(24170);
    }
    return false;
  }
  
  public static void finish()
  {
    AppMethodBeat.i(24177);
    ((com.tencent.mm.plugin.sport.a.b)g.ab(com.tencent.mm.plugin.sport.a.b.class)).ejI();
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
  
  public final e CX(int paramInt)
  {
    AppMethodBeat.i(24175);
    e locale = (e)this.qsC.get(paramInt);
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
      ae.w("MicroMsg.ExdeviceRankAdapter", "ap: rank exception,null info");
      paramArrayList = new ArrayList();
      AppMethodBeat.o(24172);
    }
    return paramArrayList;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(24174);
    if (this.qsC == null)
    {
      AppMethodBeat.o(24174);
      return 0;
    }
    int i = this.qsC.size();
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
    paramInt = CX(paramInt).azj;
    AppMethodBeat.o(24176);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(24178);
    final com.tencent.mm.plugin.exdevice.g.b.a.d locald = CX(paramInt).qvw;
    Object localObject1 = CX(paramInt);
    int i = getItemViewType(paramInt);
    int j = ((e)localObject1).qvx;
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
          paramView.iBX = paramViewGroup.findViewById(2131298736);
          paramView.okQ = paramViewGroup.findViewById(2131301145);
          paramView.qjU = ((TextView)paramViewGroup.findViewById(2131299586));
          paramView.qsO = ((ImageView)paramViewGroup.findViewById(2131299590));
          paramView.qsP = ((NoMeasuredTextView)paramViewGroup.findViewById(2131299592));
          paramView.qsR = ((TextView)paramViewGroup.findViewById(2131299538));
          paramView.qsS = ((ExdeviceLikeView)paramViewGroup.findViewById(2131299553));
          paramView.qsT = paramViewGroup.findViewById(2131299155);
          paramView.qsV = paramViewGroup.findViewById(2131299594);
          paramView.qsU = paramViewGroup.findViewById(2131299544);
          paramView.qsW = ((TextView)paramViewGroup.findViewById(2131304752));
          if (paramView.qsP != null)
          {
            paramView.qsP.setTextSize(0, this.mContext.getResources().getDimension(2131165332));
            paramView.qsP.setTextColor(this.mContext.getResources().getColor(2131100308));
            paramView.qsP.setSingleLine(true);
            paramView.qsP.setShouldEllipsize(true);
          }
          paramViewGroup.setTag(paramView);
          localObject2 = paramViewGroup;
          localObject1 = paramView;
        }
        if ((locald != null) && (localObject1 != null)) {
          if (!this.lJm.equalsIgnoreCase(locald.field_username)) {
            break label572;
          }
        }
        break;
      }
    }
    label572:
    for (this.qsH = true;; this.qsH = false)
    {
      if (i != 2) {
        break label580;
      }
      ((b)localObject1).qjU.setText(String.valueOf(locald.field_ranknum));
      ((b)localObject1).qsR.setText(String.valueOf(locald.field_score));
      a.b.d(((b)localObject1).qsO, locald.field_username);
      ((b)localObject1).iBX.setOnClickListener(this.qsK);
      ((b)localObject1).qsW.setOnClickListener(this.qsL);
      AppMethodBeat.o(24178);
      return localObject2;
      paramViewGroup = ((LayoutInflater)localObject1).inflate(2131493890, paramViewGroup, false);
      paramView = new a();
      paramView.iYM = paramViewGroup.findViewById(2131299155);
      paramViewGroup.setTag(paramView);
      paramView = null;
      break;
      paramViewGroup = ((LayoutInflater)localObject1).inflate(2131493889, paramViewGroup, false);
      paramView = new b();
      paramView.qsQ = ((TextView)paramViewGroup.findViewById(2131299593));
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
    if (((b)localObject1).qsQ != null)
    {
      if ((j & 0x4) != 4)
      {
        ((b)localObject1).qsQ.setVisibility(0);
        ((b)localObject1).qsQ.setText(this.mContext.getResources().getString(2131758587, new Object[] { Integer.valueOf(locald.field_ranknum) }));
      }
    }
    else
    {
      if (((j & 0x2) == 2) || (!locald.field_username.equalsIgnoreCase(this.qsE)) || (this.lJm.equalsIgnoreCase(this.qsE))) {
        break label1070;
      }
      ((b)localObject1).okQ.setBackgroundColor(this.mContext.getResources().getColor(2131100302));
      if ((j & 0x1) != 1) {
        break label1094;
      }
      ((b)localObject1).qsT.setVisibility(8);
      label717:
      if (locald.field_ranknum < 100) {
        break label1106;
      }
      ((b)localObject1).qjU.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(2131165334));
      label750:
      if ((j & 0x2) != 2) {
        break label1132;
      }
      ((b)localObject1).qjU.setText("");
      if (locald.field_score < 10000) {
        break label1161;
      }
      ((b)localObject1).qsR.setTextColor(this.mContext.getResources().getColor(2131100307));
      ((b)localObject1).qsR.setText(String.valueOf(locald.field_score));
      a.b.d(((b)localObject1).qsO, locald.field_username);
      if (this.qsH) {
        break label1185;
      }
      bc.aCg();
      if ((com.tencent.mm.model.c.azF().aUH(locald.field_username)) || (this.qsD == null) || (bu.isNullOrNil((String)this.qsD.get(locald.field_username)))) {
        break label1185;
      }
      ((b)localObject1).qsP.setText(k.b(this.mContext, (CharSequence)this.qsD.get(locald.field_username), ((b)localObject1).qsP.getTextSize()));
      ((b)localObject1).qsS.setLikeNum(locald.field_likecount);
      if (!this.qsH) {
        break label1231;
      }
      if (locald.field_likecount == 0) {
        break label1219;
      }
      ((b)localObject1).qsS.setSelfLikeState(1);
      label964:
      if ((locald.field_score <= 0) && (!this.qsH)) {
        break label1247;
      }
      ((b)localObject1).qsS.setClickable(true);
      ((b)localObject1).qsS.setOnLikeViewClickListener(new ExdeviceLikeView.a()
      {
        public final boolean cnz()
        {
          AppMethodBeat.i(24164);
          if (b.a(b.this) != null)
          {
            boolean bool = b.a(b.this).adO(locald.field_username);
            AppMethodBeat.o(24164);
            return bool;
          }
          AppMethodBeat.o(24164);
          return true;
        }
        
        public final void lh(int paramAnonymousInt)
        {
          AppMethodBeat.i(24163);
          ae.i("MicroMsg.ExdeviceRankAdapter", "hy: like view clicked.after statae: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (b.a(b.this) != null) {
            b.a(b.this).dc(locald.field_username, paramAnonymousInt);
          }
          AppMethodBeat.o(24163);
        }
      });
    }
    for (;;)
    {
      label641:
      label699:
      ((b)localObject1).qsU.setTag(Integer.valueOf(paramInt));
      label769:
      label801:
      ((b)localObject1).qsU.setOnClickListener(this.qsJ);
      label927:
      ((b)localObject1).qsV.setTag(Integer.valueOf(paramInt));
      ((b)localObject1).qsV.setOnClickListener(this.qsJ);
      break;
      ((b)localObject1).qsQ.setVisibility(8);
      break label641;
      label1070:
      ((b)localObject1).okQ.setBackgroundColor(this.mContext.getResources().getColor(2131100301));
      break label699;
      label1094:
      ((b)localObject1).qsT.setVisibility(0);
      break label717;
      label1106:
      ((b)localObject1).qjU.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(2131165333));
      break label750;
      label1132:
      ((b)localObject1).qjU.setText(locald.field_ranknum);
      break label769;
      label1161:
      ((b)localObject1).qsR.setTextColor(this.mContext.getResources().getColor(2131100306));
      break label801;
      label1185:
      ((b)localObject1).qsP.setText(k.b(this.mContext, w.zP(locald.field_username), ((b)localObject1).qsP.getTextSize()));
      break label927;
      label1219:
      ((b)localObject1).qsS.setSelfLikeState(0);
      break label964;
      label1231:
      ((b)localObject1).qsS.setSelfLikeState(locald.field_selfLikeState);
      break label964;
      label1247:
      ((b)localObject1).qsS.setClickable(false);
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
    public View iYM;
  }
  
  static final class b
  {
    public View iBX;
    public View okQ;
    public TextView qjU;
    public ImageView qsO;
    public NoMeasuredTextView qsP;
    public TextView qsQ;
    public TextView qsR;
    public ExdeviceLikeView qsS;
    public View qsT;
    public View qsU;
    public View qsV;
    public TextView qsW;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.b
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.az;
import com.tencent.mm.model.u;
import com.tencent.mm.model.v;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
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
  private String lhM;
  private Context mContext;
  private View.OnClickListener pIA;
  private View.OnClickListener pIB;
  List<e> pIs;
  Map<String, String> pIt;
  String pIu;
  d pIv;
  private String pIw;
  private boolean pIx;
  private e.a pIy;
  private View.OnClickListener pIz;
  
  public b(Context paramContext, String paramString)
  {
    AppMethodBeat.i(24168);
    this.pIx = false;
    this.pIy = new e.a();
    this.pIz = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24165);
        ac.i("MicroMsg.ExdeviceRankAdapter", "hy: user clicked on the content");
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        paramAnonymousView = b.this.Cc(i);
        b.a(b.this).Zq(paramAnonymousView.pLl.field_username);
        AppMethodBeat.o(24165);
      }
    };
    this.pIA = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24166);
        b.a(b.this).Zq(b.b(b.this));
        AppMethodBeat.o(24166);
      }
    };
    this.pIB = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24167);
        b.a(b.this).chV();
        AppMethodBeat.o(24167);
      }
    };
    this.lhM = u.axw();
    this.mContext = paramContext;
    this.pIw = paramString;
    AppMethodBeat.o(24168);
  }
  
  private List<e> a(ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.c> paramArrayList, ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> paramArrayList1, boolean paramBoolean)
  {
    AppMethodBeat.i(24171);
    Object localObject1 = new LinkedList(paramArrayList);
    paramArrayList = new ArrayList();
    Object localObject2 = g(this.lhM, paramArrayList1);
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = this.pIy;
      ((e.a)localObject3).pLl = ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2);
      ((e.a)localObject3).pLm = 3;
      if (((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_score == 0) {
        ((com.tencent.mm.plugin.sport.a.b)g.ab(com.tencent.mm.plugin.sport.a.b.class)).g((Activity)this.mContext, this.lhM);
      }
      if (!paramBoolean) {
        break label357;
      }
    }
    Object localObject4;
    label357:
    for (this.pIy.axs = 2;; this.pIy.axs = 1)
    {
      paramArrayList.add(this.pIy.cib());
      localObject2 = this.pIy;
      ((e.a)localObject2).axs = 0;
      paramArrayList.add(((e.a)localObject2).cib());
      e((LinkedList)localObject1, this.lhM);
      localObject2 = new ArrayList();
      ac.d("MicroMsg.ExdeviceRankAdapter", "ap: follow size %s, %s", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()), ((LinkedList)localObject1).toString() });
      localObject3 = paramArrayList1.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (com.tencent.mm.plugin.exdevice.g.b.a.d)((Iterator)localObject3).next();
        e.a locala = this.pIy;
        locala.pLl = ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject4);
        locala.axs = 1;
        locala.pLm = 4;
        ((ArrayList)localObject2).add(locala.cib());
        if ((((LinkedList)localObject1).size() > 0) && (f((LinkedList)localObject1, ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject4).field_username)))
        {
          locala = this.pIy;
          locala.pLl = ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject4);
          locala.axs = 1;
          locala.pLm = 2;
          paramArrayList.add(locala.cib());
          e((LinkedList)localObject1, ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject4).field_username);
        }
      }
      localObject2 = this.pIy;
      ((e.a)localObject2).pLl = null;
      ((e.a)localObject2).pIw = this.pIw;
      ((e.a)localObject2).username = this.lhM;
      ((e.a)localObject2).pLm = 7;
      break;
    }
    if (((LinkedList)localObject1).size() > 0)
    {
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.exdevice.g.b.a.c)((Iterator)localObject1).next();
        localObject4 = this.pIy;
        ((e.a)localObject4).username = ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject3).field_username;
        ((e.a)localObject4).pIw = this.pIw;
        ((e.a)localObject4).pLl = null;
        ((e.a)localObject4).axs = 1;
        ((e.a)localObject4).pLm = 6;
        paramArrayList.add(((e.a)localObject4).cib());
      }
    }
    if (paramArrayList.size() > 2)
    {
      ((e)paramArrayList.get(paramArrayList.size() - 1)).pLm = (((e)paramArrayList.get(paramArrayList.size() - 1)).pLm | 0x2 | 0x1);
      localObject1 = this.pIy;
      ((e.a)localObject1).axs = 0;
      ((e.a)localObject1).pLl = null;
      paramArrayList.add(((e.a)localObject1).cib());
    }
    if (((ArrayList)localObject2).size() > 1) {
      ((e)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1)).pLm = 5;
    }
    paramArrayList.addAll((Collection)localObject2);
    ac.d("MicroMsg.ExdeviceRankAdapter", "rank: %d %s", new Object[] { Integer.valueOf(paramArrayList1.size()), paramArrayList1.toString() });
    ac.d("MicroMsg.ExdeviceRankAdapter", "all: %s %s", new Object[] { Integer.valueOf(paramArrayList.size()), paramArrayList.toString() });
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
        ac.d("MicroMsg.ExdeviceRankAdapter", "username: %s remove", new Object[] { localc.toString() });
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
      ac.d("MicroMsg.ExdeviceRankAdapter", paramLinkedList.toString());
      AppMethodBeat.o(24170);
    }
    return false;
  }
  
  public static void finish()
  {
    AppMethodBeat.i(24177);
    ((com.tencent.mm.plugin.sport.a.b)g.ab(com.tencent.mm.plugin.sport.a.b.class)).dTM();
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
  
  public final e Cc(int paramInt)
  {
    AppMethodBeat.i(24175);
    e locale = (e)this.pIs.get(paramInt);
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
      ac.w("MicroMsg.ExdeviceRankAdapter", "ap: rank exception,null info");
      paramArrayList = new ArrayList();
      AppMethodBeat.o(24172);
    }
    return paramArrayList;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(24174);
    if (this.pIs == null)
    {
      AppMethodBeat.o(24174);
      return 0;
    }
    int i = this.pIs.size();
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
    paramInt = Cc(paramInt).axs;
    AppMethodBeat.o(24176);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(24178);
    final com.tencent.mm.plugin.exdevice.g.b.a.d locald = Cc(paramInt).pLl;
    Object localObject1 = Cc(paramInt);
    int i = getItemViewType(paramInt);
    int j = ((e)localObject1).pLm;
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
          paramView.ifK = paramViewGroup.findViewById(2131298736);
          paramView.nCh = paramViewGroup.findViewById(2131301145);
          paramView.pzK = ((TextView)paramViewGroup.findViewById(2131299586));
          paramView.pIE = ((ImageView)paramViewGroup.findViewById(2131299590));
          paramView.pIF = ((NoMeasuredTextView)paramViewGroup.findViewById(2131299592));
          paramView.pIH = ((TextView)paramViewGroup.findViewById(2131299538));
          paramView.pII = ((ExdeviceLikeView)paramViewGroup.findViewById(2131299553));
          paramView.pIJ = paramViewGroup.findViewById(2131299155);
          paramView.pIL = paramViewGroup.findViewById(2131299594);
          paramView.pIK = paramViewGroup.findViewById(2131299544);
          paramView.pIM = ((TextView)paramViewGroup.findViewById(2131304752));
          if (paramView.pIF != null)
          {
            paramView.pIF.setTextSize(0, this.mContext.getResources().getDimension(2131165332));
            paramView.pIF.setTextColor(this.mContext.getResources().getColor(2131100308));
            paramView.pIF.setSingleLine(true);
            paramView.pIF.setShouldEllipsize(true);
          }
          paramViewGroup.setTag(paramView);
          localObject2 = paramViewGroup;
          localObject1 = paramView;
        }
        if ((locald != null) && (localObject1 != null)) {
          if (!this.lhM.equalsIgnoreCase(locald.field_username)) {
            break label572;
          }
        }
        break;
      }
    }
    label572:
    for (this.pIx = true;; this.pIx = false)
    {
      if (i != 2) {
        break label580;
      }
      ((b)localObject1).pzK.setText(String.valueOf(locald.field_ranknum));
      ((b)localObject1).pIH.setText(String.valueOf(locald.field_score));
      a.b.d(((b)localObject1).pIE, locald.field_username);
      ((b)localObject1).ifK.setOnClickListener(this.pIA);
      ((b)localObject1).pIM.setOnClickListener(this.pIB);
      AppMethodBeat.o(24178);
      return localObject2;
      paramViewGroup = ((LayoutInflater)localObject1).inflate(2131493890, paramViewGroup, false);
      paramView = new a();
      paramView.iCJ = paramViewGroup.findViewById(2131299155);
      paramViewGroup.setTag(paramView);
      paramView = null;
      break;
      paramViewGroup = ((LayoutInflater)localObject1).inflate(2131493889, paramViewGroup, false);
      paramView = new b();
      paramView.pIG = ((TextView)paramViewGroup.findViewById(2131299593));
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
    if (((b)localObject1).pIG != null)
    {
      if ((j & 0x4) != 4)
      {
        ((b)localObject1).pIG.setVisibility(0);
        ((b)localObject1).pIG.setText(this.mContext.getResources().getString(2131758587, new Object[] { Integer.valueOf(locald.field_ranknum) }));
      }
    }
    else
    {
      if (((j & 0x2) == 2) || (!locald.field_username.equalsIgnoreCase(this.pIu)) || (this.lhM.equalsIgnoreCase(this.pIu))) {
        break label1070;
      }
      ((b)localObject1).nCh.setBackgroundColor(this.mContext.getResources().getColor(2131100302));
      if ((j & 0x1) != 1) {
        break label1094;
      }
      ((b)localObject1).pIJ.setVisibility(8);
      label717:
      if (locald.field_ranknum < 100) {
        break label1106;
      }
      ((b)localObject1).pzK.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(2131165334));
      label750:
      if ((j & 0x2) != 2) {
        break label1132;
      }
      ((b)localObject1).pzK.setText("");
      if (locald.field_score < 10000) {
        break label1161;
      }
      ((b)localObject1).pIH.setTextColor(this.mContext.getResources().getColor(2131100307));
      ((b)localObject1).pIH.setText(String.valueOf(locald.field_score));
      a.b.d(((b)localObject1).pIE, locald.field_username);
      if (this.pIx) {
        break label1185;
      }
      az.ayM();
      if ((com.tencent.mm.model.c.awB().aNo(locald.field_username)) || (this.pIt == null) || (bs.isNullOrNil((String)this.pIt.get(locald.field_username)))) {
        break label1185;
      }
      ((b)localObject1).pIF.setText(k.b(this.mContext, (CharSequence)this.pIt.get(locald.field_username), ((b)localObject1).pIF.getTextSize()));
      ((b)localObject1).pII.setLikeNum(locald.field_likecount);
      if (!this.pIx) {
        break label1231;
      }
      if (locald.field_likecount == 0) {
        break label1219;
      }
      ((b)localObject1).pII.setSelfLikeState(1);
      label964:
      if ((locald.field_score <= 0) && (!this.pIx)) {
        break label1247;
      }
      ((b)localObject1).pII.setClickable(true);
      ((b)localObject1).pII.setOnLikeViewClickListener(new ExdeviceLikeView.a()
      {
        public final boolean chF()
        {
          AppMethodBeat.i(24164);
          if (b.a(b.this) != null)
          {
            boolean bool = b.a(b.this).Zr(locald.field_username);
            AppMethodBeat.o(24164);
            return bool;
          }
          AppMethodBeat.o(24164);
          return true;
        }
        
        public final void kG(int paramAnonymousInt)
        {
          AppMethodBeat.i(24163);
          ac.i("MicroMsg.ExdeviceRankAdapter", "hy: like view clicked.after statae: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (b.a(b.this) != null) {
            b.a(b.this).cV(locald.field_username, paramAnonymousInt);
          }
          AppMethodBeat.o(24163);
        }
      });
    }
    for (;;)
    {
      label641:
      label699:
      ((b)localObject1).pIK.setTag(Integer.valueOf(paramInt));
      label769:
      label801:
      ((b)localObject1).pIK.setOnClickListener(this.pIz);
      label927:
      ((b)localObject1).pIL.setTag(Integer.valueOf(paramInt));
      ((b)localObject1).pIL.setOnClickListener(this.pIz);
      break;
      ((b)localObject1).pIG.setVisibility(8);
      break label641;
      label1070:
      ((b)localObject1).nCh.setBackgroundColor(this.mContext.getResources().getColor(2131100301));
      break label699;
      label1094:
      ((b)localObject1).pIJ.setVisibility(0);
      break label717;
      label1106:
      ((b)localObject1).pzK.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(2131165333));
      break label750;
      label1132:
      ((b)localObject1).pzK.setText(locald.field_ranknum);
      break label769;
      label1161:
      ((b)localObject1).pIH.setTextColor(this.mContext.getResources().getColor(2131100306));
      break label801;
      label1185:
      ((b)localObject1).pIF.setText(k.b(this.mContext, v.wk(locald.field_username), ((b)localObject1).pIF.getTextSize()));
      break label927;
      label1219:
      ((b)localObject1).pII.setSelfLikeState(0);
      break label964;
      label1231:
      ((b)localObject1).pII.setSelfLikeState(locald.field_selfLikeState);
      break label964;
      label1247:
      ((b)localObject1).pII.setClickable(false);
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
    public View iCJ;
  }
  
  static final class b
  {
    public View ifK;
    public View nCh;
    public ImageView pIE;
    public NoMeasuredTextView pIF;
    public TextView pIG;
    public TextView pIH;
    public ExdeviceLikeView pII;
    public View pIJ;
    public View pIK;
    public View pIL;
    public TextView pIM;
    public TextView pzK;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.b
 * JD-Core Version:    0.7.0.1
 */
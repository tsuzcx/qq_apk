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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
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
  private String kGt;
  private Context mContext;
  List<e> pfh;
  Map<String, String> pfi;
  String pfj;
  d pfk;
  private String pfl;
  private boolean pfm;
  private e.a pfn;
  private View.OnClickListener pfo;
  private View.OnClickListener pfp;
  private View.OnClickListener pfq;
  
  public b(Context paramContext, String paramString)
  {
    AppMethodBeat.i(24168);
    this.pfm = false;
    this.pfn = new e.a();
    this.pfo = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24165);
        ad.i("MicroMsg.ExdeviceRankAdapter", "hy: user clicked on the content");
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        paramAnonymousView = b.this.Bk(i);
        b.a(b.this).Ve(paramAnonymousView.pib.field_username);
        AppMethodBeat.o(24165);
      }
    };
    this.pfp = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24166);
        b.a(b.this).Ve(b.b(b.this));
        AppMethodBeat.o(24166);
      }
    };
    this.pfq = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24167);
        b.a(b.this).caM();
        AppMethodBeat.o(24167);
      }
    };
    this.kGt = u.aqG();
    this.mContext = paramContext;
    this.pfl = paramString;
    AppMethodBeat.o(24168);
  }
  
  private List<e> a(ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.c> paramArrayList, ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> paramArrayList1, boolean paramBoolean)
  {
    AppMethodBeat.i(24171);
    Object localObject1 = new LinkedList(paramArrayList);
    paramArrayList = new ArrayList();
    Object localObject2 = g(this.kGt, paramArrayList1);
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = this.pfn;
      ((e.a)localObject3).pib = ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2);
      ((e.a)localObject3).pic = 3;
      if (((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_score == 0) {
        ((com.tencent.mm.plugin.sport.a.b)g.ab(com.tencent.mm.plugin.sport.a.b.class)).g((Activity)this.mContext, this.kGt);
      }
      if (!paramBoolean) {
        break label357;
      }
    }
    Object localObject4;
    label357:
    for (this.pfn.awy = 2;; this.pfn.awy = 1)
    {
      paramArrayList.add(this.pfn.caS());
      localObject2 = this.pfn;
      ((e.a)localObject2).awy = 0;
      paramArrayList.add(((e.a)localObject2).caS());
      d((LinkedList)localObject1, this.kGt);
      localObject2 = new ArrayList();
      ad.d("MicroMsg.ExdeviceRankAdapter", "ap: follow size %s, %s", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()), ((LinkedList)localObject1).toString() });
      localObject3 = paramArrayList1.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (com.tencent.mm.plugin.exdevice.g.b.a.d)((Iterator)localObject3).next();
        e.a locala = this.pfn;
        locala.pib = ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject4);
        locala.awy = 1;
        locala.pic = 4;
        ((ArrayList)localObject2).add(locala.caS());
        if ((((LinkedList)localObject1).size() > 0) && (e((LinkedList)localObject1, ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject4).field_username)))
        {
          locala = this.pfn;
          locala.pib = ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject4);
          locala.awy = 1;
          locala.pic = 2;
          paramArrayList.add(locala.caS());
          d((LinkedList)localObject1, ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject4).field_username);
        }
      }
      localObject2 = this.pfn;
      ((e.a)localObject2).pib = null;
      ((e.a)localObject2).pfl = this.pfl;
      ((e.a)localObject2).username = this.kGt;
      ((e.a)localObject2).pic = 7;
      break;
    }
    if (((LinkedList)localObject1).size() > 0)
    {
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.exdevice.g.b.a.c)((Iterator)localObject1).next();
        localObject4 = this.pfn;
        ((e.a)localObject4).username = ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject3).field_username;
        ((e.a)localObject4).pfl = this.pfl;
        ((e.a)localObject4).pib = null;
        ((e.a)localObject4).awy = 1;
        ((e.a)localObject4).pic = 6;
        paramArrayList.add(((e.a)localObject4).caS());
      }
    }
    if (paramArrayList.size() > 2)
    {
      ((e)paramArrayList.get(paramArrayList.size() - 1)).pic = (((e)paramArrayList.get(paramArrayList.size() - 1)).pic | 0x2 | 0x1);
      localObject1 = this.pfn;
      ((e.a)localObject1).awy = 0;
      ((e.a)localObject1).pib = null;
      paramArrayList.add(((e.a)localObject1).caS());
    }
    if (((ArrayList)localObject2).size() > 1) {
      ((e)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1)).pic = 5;
    }
    paramArrayList.addAll((Collection)localObject2);
    ad.d("MicroMsg.ExdeviceRankAdapter", "rank: %d %s", new Object[] { Integer.valueOf(paramArrayList1.size()), paramArrayList1.toString() });
    ad.d("MicroMsg.ExdeviceRankAdapter", "all: %s %s", new Object[] { Integer.valueOf(paramArrayList.size()), paramArrayList.toString() });
    AppMethodBeat.o(24171);
    return paramArrayList;
  }
  
  private static void d(LinkedList<com.tencent.mm.plugin.exdevice.g.b.a.c> paramLinkedList, String paramString)
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
  
  private static boolean e(LinkedList<com.tencent.mm.plugin.exdevice.g.b.a.c> paramLinkedList, String paramString)
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
    ((com.tencent.mm.plugin.sport.a.b)g.ab(com.tencent.mm.plugin.sport.a.b.class)).dFl();
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
  
  public final e Bk(int paramInt)
  {
    AppMethodBeat.i(24175);
    e locale = (e)this.pfh.get(paramInt);
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
    if (this.pfh == null)
    {
      AppMethodBeat.o(24174);
      return 0;
    }
    int i = this.pfh.size();
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
    paramInt = Bk(paramInt).awy;
    AppMethodBeat.o(24176);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(24178);
    final com.tencent.mm.plugin.exdevice.g.b.a.d locald = Bk(paramInt).pib;
    Object localObject1 = Bk(paramInt);
    int i = getItemViewType(paramInt);
    int j = ((e)localObject1).pic;
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
          paramView.hFi = paramViewGroup.findViewById(2131298736);
          paramView.mZJ = paramViewGroup.findViewById(2131301145);
          paramView.oWz = ((TextView)paramViewGroup.findViewById(2131299586));
          paramView.pft = ((ImageView)paramViewGroup.findViewById(2131299590));
          paramView.pfu = ((NoMeasuredTextView)paramViewGroup.findViewById(2131299592));
          paramView.pfw = ((TextView)paramViewGroup.findViewById(2131299538));
          paramView.pfx = ((ExdeviceLikeView)paramViewGroup.findViewById(2131299553));
          paramView.pfy = paramViewGroup.findViewById(2131299155);
          paramView.pfA = paramViewGroup.findViewById(2131299594);
          paramView.pfz = paramViewGroup.findViewById(2131299544);
          paramView.pfB = ((TextView)paramViewGroup.findViewById(2131304752));
          if (paramView.pfu != null)
          {
            paramView.pfu.setTextSize(0, this.mContext.getResources().getDimension(2131165332));
            paramView.pfu.setTextColor(this.mContext.getResources().getColor(2131100308));
            paramView.pfu.setSingleLine(true);
            paramView.pfu.setShouldEllipsize(true);
          }
          paramViewGroup.setTag(paramView);
          localObject2 = paramViewGroup;
          localObject1 = paramView;
        }
        if ((locald != null) && (localObject1 != null)) {
          if (!this.kGt.equalsIgnoreCase(locald.field_username)) {
            break label572;
          }
        }
        break;
      }
    }
    label572:
    for (this.pfm = true;; this.pfm = false)
    {
      if (i != 2) {
        break label580;
      }
      ((b)localObject1).oWz.setText(String.valueOf(locald.field_ranknum));
      ((b)localObject1).pfw.setText(String.valueOf(locald.field_score));
      a.b.d(((b)localObject1).pft, locald.field_username);
      ((b)localObject1).hFi.setOnClickListener(this.pfp);
      ((b)localObject1).pfB.setOnClickListener(this.pfq);
      AppMethodBeat.o(24178);
      return localObject2;
      paramViewGroup = ((LayoutInflater)localObject1).inflate(2131493890, paramViewGroup, false);
      paramView = new a();
      paramView.icB = paramViewGroup.findViewById(2131299155);
      paramViewGroup.setTag(paramView);
      paramView = null;
      break;
      paramViewGroup = ((LayoutInflater)localObject1).inflate(2131493889, paramViewGroup, false);
      paramView = new b();
      paramView.pfv = ((TextView)paramViewGroup.findViewById(2131299593));
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
    if (((b)localObject1).pfv != null)
    {
      if ((j & 0x4) != 4)
      {
        ((b)localObject1).pfv.setVisibility(0);
        ((b)localObject1).pfv.setText(this.mContext.getResources().getString(2131758587, new Object[] { Integer.valueOf(locald.field_ranknum) }));
      }
    }
    else
    {
      if (((j & 0x2) == 2) || (!locald.field_username.equalsIgnoreCase(this.pfj)) || (this.kGt.equalsIgnoreCase(this.pfj))) {
        break label1070;
      }
      ((b)localObject1).mZJ.setBackgroundColor(this.mContext.getResources().getColor(2131100302));
      if ((j & 0x1) != 1) {
        break label1094;
      }
      ((b)localObject1).pfy.setVisibility(8);
      label717:
      if (locald.field_ranknum < 100) {
        break label1106;
      }
      ((b)localObject1).oWz.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(2131165334));
      label750:
      if ((j & 0x2) != 2) {
        break label1132;
      }
      ((b)localObject1).oWz.setText("");
      if (locald.field_score < 10000) {
        break label1161;
      }
      ((b)localObject1).pfw.setTextColor(this.mContext.getResources().getColor(2131100307));
      ((b)localObject1).pfw.setText(String.valueOf(locald.field_score));
      a.b.d(((b)localObject1).pft, locald.field_username);
      if (this.pfm) {
        break label1185;
      }
      az.arV();
      if ((com.tencent.mm.model.c.apM().aHT(locald.field_username)) || (this.pfi == null) || (bt.isNullOrNil((String)this.pfi.get(locald.field_username)))) {
        break label1185;
      }
      ((b)localObject1).pfu.setText(k.b(this.mContext, (CharSequence)this.pfi.get(locald.field_username), ((b)localObject1).pfu.getTextSize()));
      ((b)localObject1).pfx.setLikeNum(locald.field_likecount);
      if (!this.pfm) {
        break label1231;
      }
      if (locald.field_likecount == 0) {
        break label1219;
      }
      ((b)localObject1).pfx.setSelfLikeState(1);
      label964:
      if ((locald.field_score <= 0) && (!this.pfm)) {
        break label1247;
      }
      ((b)localObject1).pfx.setClickable(true);
      ((b)localObject1).pfx.setOnLikeViewClickListener(new ExdeviceLikeView.a()
      {
        public final boolean caw()
        {
          AppMethodBeat.i(24164);
          if (b.a(b.this) != null)
          {
            boolean bool = b.a(b.this).Vf(locald.field_username);
            AppMethodBeat.o(24164);
            return bool;
          }
          AppMethodBeat.o(24164);
          return true;
        }
        
        public final void kM(int paramAnonymousInt)
        {
          AppMethodBeat.i(24163);
          ad.i("MicroMsg.ExdeviceRankAdapter", "hy: like view clicked.after statae: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (b.a(b.this) != null) {
            b.a(b.this).cQ(locald.field_username, paramAnonymousInt);
          }
          AppMethodBeat.o(24163);
        }
      });
    }
    for (;;)
    {
      label641:
      label699:
      ((b)localObject1).pfz.setTag(Integer.valueOf(paramInt));
      label769:
      label801:
      ((b)localObject1).pfz.setOnClickListener(this.pfo);
      label927:
      ((b)localObject1).pfA.setTag(Integer.valueOf(paramInt));
      ((b)localObject1).pfA.setOnClickListener(this.pfo);
      break;
      ((b)localObject1).pfv.setVisibility(8);
      break label641;
      label1070:
      ((b)localObject1).mZJ.setBackgroundColor(this.mContext.getResources().getColor(2131100301));
      break label699;
      label1094:
      ((b)localObject1).pfy.setVisibility(0);
      break label717;
      label1106:
      ((b)localObject1).oWz.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(2131165333));
      break label750;
      label1132:
      ((b)localObject1).oWz.setText(locald.field_ranknum);
      break label769;
      label1161:
      ((b)localObject1).pfw.setTextColor(this.mContext.getResources().getColor(2131100306));
      break label801;
      label1185:
      ((b)localObject1).pfu.setText(k.b(this.mContext, v.sh(locald.field_username), ((b)localObject1).pfu.getTextSize()));
      break label927;
      label1219:
      ((b)localObject1).pfx.setSelfLikeState(0);
      break label964;
      label1231:
      ((b)localObject1).pfx.setSelfLikeState(locald.field_selfLikeState);
      break label964;
      label1247:
      ((b)localObject1).pfx.setClickable(false);
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
    public View icB;
  }
  
  static final class b
  {
    public View hFi;
    public View mZJ;
    public TextView oWz;
    public View pfA;
    public TextView pfB;
    public ImageView pft;
    public NoMeasuredTextView pfu;
    public TextView pfv;
    public TextView pfw;
    public ExdeviceLikeView pfx;
    public View pfy;
    public View pfz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.b
 * JD-Core Version:    0.7.0.1
 */
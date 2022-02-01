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
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.ecf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
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
  private Context mContext;
  private String mRa;
  List<d> rJD;
  Map<String, String> rJE;
  String rJF;
  c rJG;
  private String rJH;
  private boolean rJI;
  private d.a rJJ;
  private View.OnClickListener rJK;
  private View.OnClickListener rJL;
  private View.OnClickListener rJM;
  
  public b(Context paramContext, String paramString)
  {
    AppMethodBeat.i(24168);
    this.rJI = false;
    this.rJJ = new d.a();
    this.rJK = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24166);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        Log.i("MicroMsg.ExdeviceRankAdapter", "hy: user clicked on the content");
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        paramAnonymousView = b.this.GI(i);
        b.a(b.this).anW(paramAnonymousView.rMD.field_username);
        a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(24166);
      }
    };
    this.rJL = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24167);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        b.a(b.this).anW(b.b(b.this));
        a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(24167);
      }
    };
    this.rJM = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(231714);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        a.b("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        b.a(b.this).cMa();
        a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(231714);
      }
    };
    this.mRa = z.aTY();
    this.mContext = paramContext;
    this.rJH = paramString;
    AppMethodBeat.o(24168);
  }
  
  private List<d> a(ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.c> paramArrayList, ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> paramArrayList1, boolean paramBoolean)
  {
    AppMethodBeat.i(24171);
    Object localObject1 = new LinkedList(paramArrayList);
    paramArrayList = new ArrayList();
    Object localObject2 = h(this.mRa, paramArrayList1);
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = this.rJJ;
      ((d.a)localObject3).rMD = ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2);
      ((d.a)localObject3).rME = 3;
      if (((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_score == 0) {
        ((com.tencent.mm.plugin.sport.a.b)g.af(com.tencent.mm.plugin.sport.a.b.class)).l((Activity)this.mContext, this.mRa);
      }
      if (!paramBoolean) {
        break label357;
      }
    }
    Object localObject4;
    label357:
    for (this.rJJ.azh = 2;; this.rJJ.azh = 1)
    {
      paramArrayList.add(this.rJJ.cMh());
      localObject2 = this.rJJ;
      ((d.a)localObject2).azh = 0;
      paramArrayList.add(((d.a)localObject2).cMh());
      e((LinkedList)localObject1, this.mRa);
      localObject2 = new ArrayList();
      Log.d("MicroMsg.ExdeviceRankAdapter", "ap: follow size %s, %s", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()), ((LinkedList)localObject1).toString() });
      localObject3 = paramArrayList1.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (com.tencent.mm.plugin.exdevice.g.b.a.d)((Iterator)localObject3).next();
        d.a locala = this.rJJ;
        locala.rMD = ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject4);
        locala.azh = 1;
        locala.rME = 4;
        ((ArrayList)localObject2).add(locala.cMh());
        if ((((LinkedList)localObject1).size() > 0) && (f((LinkedList)localObject1, ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject4).field_username)))
        {
          locala = this.rJJ;
          locala.rMD = ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject4);
          locala.azh = 1;
          locala.rME = 2;
          paramArrayList.add(locala.cMh());
          e((LinkedList)localObject1, ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject4).field_username);
        }
      }
      localObject2 = this.rJJ;
      ((d.a)localObject2).rMD = null;
      ((d.a)localObject2).rJH = this.rJH;
      ((d.a)localObject2).username = this.mRa;
      ((d.a)localObject2).rME = 7;
      break;
    }
    if (((LinkedList)localObject1).size() > 0)
    {
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.exdevice.g.b.a.c)((Iterator)localObject1).next();
        localObject4 = this.rJJ;
        ((d.a)localObject4).username = ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject3).field_username;
        ((d.a)localObject4).rJH = this.rJH;
        ((d.a)localObject4).rMD = null;
        ((d.a)localObject4).azh = 1;
        ((d.a)localObject4).rME = 6;
        paramArrayList.add(((d.a)localObject4).cMh());
      }
    }
    if (paramArrayList.size() > 2)
    {
      ((d)paramArrayList.get(paramArrayList.size() - 1)).rME = (((d)paramArrayList.get(paramArrayList.size() - 1)).rME | 0x2 | 0x1);
      localObject1 = this.rJJ;
      ((d.a)localObject1).azh = 0;
      ((d.a)localObject1).rMD = null;
      paramArrayList.add(((d.a)localObject1).cMh());
    }
    if (((ArrayList)localObject2).size() > 1) {
      ((d)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1)).rME = 5;
    }
    paramArrayList.addAll((Collection)localObject2);
    Log.d("MicroMsg.ExdeviceRankAdapter", "rank: %d %s", new Object[] { Integer.valueOf(paramArrayList1.size()), paramArrayList1.toString() });
    Log.d("MicroMsg.ExdeviceRankAdapter", "all: %s %s", new Object[] { Integer.valueOf(paramArrayList.size()), paramArrayList.toString() });
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
        Log.d("MicroMsg.ExdeviceRankAdapter", "username: %s remove", new Object[] { localc.toString() });
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
      Log.d("MicroMsg.ExdeviceRankAdapter", paramLinkedList.toString());
      AppMethodBeat.o(24170);
    }
    return false;
  }
  
  public static void finish()
  {
    AppMethodBeat.i(24177);
    ((com.tencent.mm.plugin.sport.a.b)g.af(com.tencent.mm.plugin.sport.a.b.class)).fmi();
    AppMethodBeat.o(24177);
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
  
  public final d GI(int paramInt)
  {
    AppMethodBeat.i(24175);
    d locald = (d)this.rJD.get(paramInt);
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
    if (this.rJD == null)
    {
      AppMethodBeat.o(24174);
      return 0;
    }
    int i = this.rJD.size();
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
    paramInt = GI(paramInt).azh;
    AppMethodBeat.o(24176);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(24178);
    final com.tencent.mm.plugin.exdevice.g.b.a.d locald = GI(paramInt).rMD;
    Object localObject1 = GI(paramInt);
    int i = getItemViewType(paramInt);
    int j = ((d)localObject1).rME;
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
          paramView.jxm = paramViewGroup.findViewById(2131299174);
          paramView.pxo = paramViewGroup.findViewById(2131302799);
          paramView.rAP = ((TextView)paramViewGroup.findViewById(2131300217));
          paramView.rJS = ((ImageView)paramViewGroup.findViewById(2131300220));
          paramView.rJT = ((NoMeasuredTextView)paramViewGroup.findViewById(2131300221));
          paramView.rJU = ((TextView)paramViewGroup.findViewById(2131300181));
          paramView.rJV = ((ExdeviceLikeView)paramViewGroup.findViewById(2131300201));
          paramView.rJW = paramViewGroup.findViewById(2131299697);
          paramView.rJY = paramViewGroup.findViewById(2131300222);
          paramView.rJX = paramViewGroup.findViewById(2131300192);
          paramView.rJZ = ((TextView)paramViewGroup.findViewById(2131307822));
          paramView.rKa = paramViewGroup.findViewById(2131296990);
          paramView.rKb = ((ImageView)paramViewGroup.findViewById(2131296986));
          paramView.rKc = ((TextView)paramViewGroup.findViewById(2131296992));
          paramView.rKd = ((TextView)paramViewGroup.findViewById(2131296987));
          paramView.rKe = ((TextView)paramViewGroup.findViewById(2131296988));
          paramView.rKf = ((TextView)paramViewGroup.findViewById(2131296989));
          if (paramView.rJT != null)
          {
            paramView.rJT.setTextSize(0, this.mContext.getResources().getDimension(2131165343));
            paramView.rJT.setTextColor(this.mContext.getResources().getColor(2131100343));
            paramView.rJT.setSingleLine(true);
            paramView.rJT.setShouldEllipsize(true);
          }
          paramViewGroup.setTag(paramView);
          localObject2 = paramViewGroup;
          localObject1 = paramView;
        }
        if ((locald != null) && (localObject1 != null)) {
          if (!this.mRa.equalsIgnoreCase(locald.field_username)) {
            break label640;
          }
        }
        break;
      }
    }
    label640:
    for (this.rJI = true;; this.rJI = false)
    {
      if (i != 2) {
        break label648;
      }
      ((b)localObject1).rAP.setText(String.valueOf(locald.field_ranknum));
      ((b)localObject1).rJU.setText(String.valueOf(locald.field_score));
      a.b.c(((b)localObject1).rJS, locald.field_username);
      ((b)localObject1).jxm.setOnClickListener(this.rJL);
      ((b)localObject1).rJZ.setOnClickListener(this.rJM);
      AppMethodBeat.o(24178);
      return localObject2;
      paramViewGroup = ((LayoutInflater)localObject1).inflate(2131494046, paramViewGroup, false);
      paramView = new a();
      paramView.jWr = paramViewGroup.findViewById(2131299697);
      paramViewGroup.setTag(paramView);
      paramView = null;
      break;
      paramViewGroup = ((LayoutInflater)localObject1).inflate(2131494045, paramViewGroup, false);
      paramView = new b();
      break;
      paramViewGroup = ((LayoutInflater)localObject1).inflate(2131494047, paramViewGroup, false);
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
    if (((j & 0x2) != 2) && (locald.field_username.equalsIgnoreCase(this.rJF)) && (!this.mRa.equalsIgnoreCase(this.rJF)))
    {
      ((b)localObject1).pxo.setBackgroundColor(this.mContext.getResources().getColor(2131100337));
      label706:
      if ((j & 0x1) != 1) {
        break label1227;
      }
      ((b)localObject1).rJW.setVisibility(8);
      label724:
      if (locald.field_ranknum < 100) {
        break label1239;
      }
      ((b)localObject1).rAP.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(2131165345));
      label757:
      if (locald.field_ranknum != 0) {
        break label1265;
      }
      ((b)localObject1).rAP.setText("");
      label776:
      if (locald.field_score < 10000) {
        break label1294;
      }
      ((b)localObject1).rJU.setTextColor(this.mContext.getResources().getColor(2131100342));
      label808:
      ((b)localObject1).rJU.setText(String.valueOf(locald.field_score));
      a.b.c(((b)localObject1).rJS, locald.field_username);
      if (this.rJI) {
        break label1318;
      }
      bg.aVF();
      if ((com.tencent.mm.model.c.aSN().bjG(locald.field_username)) || (this.rJE == null) || (Util.isNullOrNil((String)this.rJE.get(locald.field_username)))) {
        break label1318;
      }
      ((b)localObject1).rJT.setText(l.b(this.mContext, (CharSequence)this.rJE.get(locald.field_username), ((b)localObject1).rJT.getTextSize()));
      label934:
      ((b)localObject1).rJV.setLikeNum(locald.field_likecount);
      if (!this.rJI) {
        break label1364;
      }
      if (locald.field_likecount == 0) {
        break label1352;
      }
      ((b)localObject1).rJV.setSelfLikeState(1);
      label971:
      if ((locald.field_score <= 0) && (!this.rJI)) {
        break label1380;
      }
      ((b)localObject1).rJV.setClickable(true);
      ((b)localObject1).rJV.setOnLikeViewClickListener(new ExdeviceLikeView.a()
      {
        public final boolean cLN()
        {
          AppMethodBeat.i(24164);
          if (b.a(b.this) != null)
          {
            boolean bool = b.a(b.this).anX(locald.field_username);
            AppMethodBeat.o(24164);
            return bool;
          }
          AppMethodBeat.o(24164);
          return true;
        }
        
        public final void oj(int paramAnonymousInt)
        {
          AppMethodBeat.i(24163);
          Log.i("MicroMsg.ExdeviceRankAdapter", "hy: like view clicked.after statae: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (b.a(b.this) != null) {
            b.a(b.this).di(locald.field_username, paramAnonymousInt);
          }
          AppMethodBeat.o(24163);
        }
      });
      label1013:
      if (locald.field_sportRecord == null) {
        break label1409;
      }
      ((b)localObject1).rKa.setVisibility(0);
      paramView = ((b)localObject1).rKc;
      ((b)localObject1).rKd.setText(locald.field_sportRecord.Ncs);
      ((b)localObject1).rKe.setText(locald.field_sportRecord.Nct);
      ((b)localObject1).rKf.setText(locald.field_sportRecord.Ncu);
      paramViewGroup = ((b)localObject1).rKb;
      if ("21f9d636b41b25be".equals(locald.field_sportRecord.appId)) {
        break label1392;
      }
      ((q)g.af(q.class)).b(locald.field_sportRecord.appId, new b.2(this, paramView, paramViewGroup));
    }
    for (;;)
    {
      ((b)localObject1).rJX.setTag(Integer.valueOf(paramInt));
      ((b)localObject1).rJX.setOnClickListener(this.rJK);
      ((b)localObject1).rJY.setTag(Integer.valueOf(paramInt));
      ((b)localObject1).rJY.setOnClickListener(this.rJK);
      break;
      ((b)localObject1).pxo.setBackgroundColor(this.mContext.getResources().getColor(2131100336));
      break label706;
      label1227:
      ((b)localObject1).rJW.setVisibility(0);
      break label724;
      label1239:
      ((b)localObject1).rAP.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(2131165344));
      break label757;
      label1265:
      ((b)localObject1).rAP.setText(locald.field_ranknum);
      break label776;
      label1294:
      ((b)localObject1).rJU.setTextColor(this.mContext.getResources().getColor(2131100341));
      break label808;
      label1318:
      ((b)localObject1).rJT.setText(l.b(this.mContext, aa.getDisplayName(locald.field_username), ((b)localObject1).rJT.getTextSize()));
      break label934;
      label1352:
      ((b)localObject1).rJV.setSelfLikeState(0);
      break label971;
      label1364:
      ((b)localObject1).rJV.setSelfLikeState(locald.field_selfLikeState);
      break label971;
      label1380:
      ((b)localObject1).rJV.setClickable(false);
      break label1013;
      label1392:
      paramView.setText(2131766360);
      paramViewGroup.setImageResource(2131690736);
      continue;
      label1409:
      ((b)localObject1).rKa.setVisibility(8);
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
    public View jWr;
  }
  
  static final class b
  {
    public View jxm;
    public View pxo;
    public TextView rAP;
    public ImageView rJS;
    public NoMeasuredTextView rJT;
    public TextView rJU;
    public ExdeviceLikeView rJV;
    public View rJW;
    public View rJX;
    public View rJY;
    public TextView rJZ;
    public View rKa;
    public ImageView rKb;
    public TextView rKc;
    public TextView rKd;
    public TextView rKe;
    public TextView rKf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.b
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.aa;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.emg;
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
  private String pRV;
  List<d> vpl;
  Map<String, String> vpm;
  String vpn;
  c vpo;
  private String vpp;
  private boolean vpq;
  private d.a vpr;
  private View.OnClickListener vps;
  private View.OnClickListener vpt;
  private View.OnClickListener vpu;
  
  public b(Context paramContext, String paramString)
  {
    AppMethodBeat.i(24168);
    this.vpq = false;
    this.vpr = new d.a();
    this.vps = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24166);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.i("MicroMsg.ExdeviceRankAdapter", "hy: user clicked on the content");
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        paramAnonymousView = b.this.Kq(i);
        b.a(b.this).avU(paramAnonymousView.vsn.field_username);
        a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(24166);
      }
    };
    this.vpt = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(24167);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        b.a(b.this).avU(b.b(b.this));
        a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(24167);
      }
    };
    this.vpu = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(286539);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        b.a(b.this).daN();
        a.a(this, "com/tencent/mm/plugin/exdevice/ui/ExdeviceRankAdapter$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(286539);
      }
    };
    this.pRV = z.bcZ();
    this.mContext = paramContext;
    this.vpp = paramString;
    AppMethodBeat.o(24168);
  }
  
  private List<d> a(ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.c> paramArrayList, ArrayList<com.tencent.mm.plugin.exdevice.g.b.a.d> paramArrayList1, boolean paramBoolean)
  {
    AppMethodBeat.i(24171);
    Object localObject1 = new LinkedList(paramArrayList);
    paramArrayList = new ArrayList();
    Object localObject2 = h(this.pRV, paramArrayList1);
    Object localObject3;
    if (localObject2 != null)
    {
      localObject3 = this.vpr;
      ((d.a)localObject3).vsn = ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2);
      ((d.a)localObject3).vso = 3;
      if (((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject2).field_score == 0) {
        ((com.tencent.mm.plugin.sport.a.b)h.ae(com.tencent.mm.plugin.sport.a.b.class)).l((Activity)this.mContext, this.pRV);
      }
      if (!paramBoolean) {
        break label357;
      }
    }
    Object localObject4;
    label357:
    for (this.vpr.xk = 2;; this.vpr.xk = 1)
    {
      paramArrayList.add(this.vpr.daU());
      localObject2 = this.vpr;
      ((d.a)localObject2).xk = 0;
      paramArrayList.add(((d.a)localObject2).daU());
      f((LinkedList)localObject1, this.pRV);
      localObject2 = new ArrayList();
      Log.d("MicroMsg.ExdeviceRankAdapter", "ap: follow size %s, %s", new Object[] { Integer.valueOf(((LinkedList)localObject1).size()), ((LinkedList)localObject1).toString() });
      localObject3 = paramArrayList1.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (com.tencent.mm.plugin.exdevice.g.b.a.d)((Iterator)localObject3).next();
        d.a locala = this.vpr;
        locala.vsn = ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject4);
        locala.xk = 1;
        locala.vso = 4;
        ((ArrayList)localObject2).add(locala.daU());
        if ((((LinkedList)localObject1).size() > 0) && (g((LinkedList)localObject1, ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject4).field_username)))
        {
          locala = this.vpr;
          locala.vsn = ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject4);
          locala.xk = 1;
          locala.vso = 2;
          paramArrayList.add(locala.daU());
          f((LinkedList)localObject1, ((com.tencent.mm.plugin.exdevice.g.b.a.d)localObject4).field_username);
        }
      }
      localObject2 = this.vpr;
      ((d.a)localObject2).vsn = null;
      ((d.a)localObject2).vpp = this.vpp;
      ((d.a)localObject2).username = this.pRV;
      ((d.a)localObject2).vso = 7;
      break;
    }
    if (((LinkedList)localObject1).size() > 0)
    {
      localObject1 = ((LinkedList)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject3 = (com.tencent.mm.plugin.exdevice.g.b.a.c)((Iterator)localObject1).next();
        localObject4 = this.vpr;
        ((d.a)localObject4).username = ((com.tencent.mm.plugin.exdevice.g.b.a.c)localObject3).field_username;
        ((d.a)localObject4).vpp = this.vpp;
        ((d.a)localObject4).vsn = null;
        ((d.a)localObject4).xk = 1;
        ((d.a)localObject4).vso = 6;
        paramArrayList.add(((d.a)localObject4).daU());
      }
    }
    if (paramArrayList.size() > 2)
    {
      ((d)paramArrayList.get(paramArrayList.size() - 1)).vso = (((d)paramArrayList.get(paramArrayList.size() - 1)).vso | 0x2 | 0x1);
      localObject1 = this.vpr;
      ((d.a)localObject1).xk = 0;
      ((d.a)localObject1).vsn = null;
      paramArrayList.add(((d.a)localObject1).daU());
    }
    if (((ArrayList)localObject2).size() > 1) {
      ((d)((ArrayList)localObject2).get(((ArrayList)localObject2).size() - 1)).vso = 5;
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
    ((com.tencent.mm.plugin.sport.a.b)h.ae(com.tencent.mm.plugin.sport.a.b.class)).gaD();
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
  
  public final d Kq(int paramInt)
  {
    AppMethodBeat.i(24175);
    d locald = (d)this.vpl.get(paramInt);
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
    if (this.vpl == null)
    {
      AppMethodBeat.o(24174);
      return 0;
    }
    int i = this.vpl.size();
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
    paramInt = Kq(paramInt).xk;
    AppMethodBeat.o(24176);
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(24178);
    final com.tencent.mm.plugin.exdevice.g.b.a.d locald = Kq(paramInt).vsn;
    Object localObject1 = Kq(paramInt);
    int i = getItemViewType(paramInt);
    int j = ((d)localObject1).vso;
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
          paramView.fyN = paramViewGroup.findViewById(R.h.container);
          paramView.vpA = paramViewGroup.findViewById(R.h.item_content);
          paramView.vgw = ((TextView)paramViewGroup.findViewById(R.h.dGf));
          paramView.vpB = ((ImageView)paramViewGroup.findViewById(R.h.dGi));
          paramView.vpC = ((NoMeasuredTextView)paramViewGroup.findViewById(R.h.dGj));
          paramView.vpD = ((TextView)paramViewGroup.findViewById(R.h.dFM));
          paramView.vpE = ((ExdeviceLikeView)paramViewGroup.findViewById(R.h.dFX));
          paramView.vpF = paramViewGroup.findViewById(R.h.dEO);
          paramView.vpH = paramViewGroup.findViewById(R.h.dGk);
          paramView.vpG = paramViewGroup.findViewById(R.h.dFQ);
          paramView.vpI = ((TextView)paramViewGroup.findViewById(R.h.dVe));
          paramView.vpJ = paramViewGroup.findViewById(R.h.drm);
          paramView.vpK = ((ImageView)paramViewGroup.findViewById(R.h.dri));
          paramView.vpL = ((TextView)paramViewGroup.findViewById(R.h.drn));
          paramView.vpM = ((TextView)paramViewGroup.findViewById(R.h.drj));
          paramView.vpN = ((TextView)paramViewGroup.findViewById(R.h.drk));
          paramView.vpO = ((TextView)paramViewGroup.findViewById(R.h.drl));
          if (paramView.vpC != null)
          {
            paramView.vpC.setTextSize(0, this.mContext.getResources().getDimension(R.f.dkV));
            paramView.vpC.setTextColor(this.mContext.getResources().getColor(R.e.dku));
            paramView.vpC.setSingleLine(true);
            paramView.vpC.setShouldEllipsize(true);
          }
          paramViewGroup.setTag(paramView);
          localObject2 = paramViewGroup;
          localObject1 = paramView;
        }
        if ((locald != null) && (localObject1 != null)) {
          if (!this.pRV.equalsIgnoreCase(locald.field_username)) {
            break label640;
          }
        }
        break;
      }
    }
    label640:
    for (this.vpq = true;; this.vpq = false)
    {
      if (i != 2) {
        break label648;
      }
      ((b)localObject1).vgw.setText(String.valueOf(locald.field_ranknum));
      ((b)localObject1).vpD.setText(String.valueOf(locald.field_score));
      a.b.c(((b)localObject1).vpB, locald.field_username);
      ((b)localObject1).fyN.setOnClickListener(this.vpt);
      ((b)localObject1).vpI.setOnClickListener(this.vpu);
      AppMethodBeat.o(24178);
      return localObject2;
      paramViewGroup = ((LayoutInflater)localObject1).inflate(R.i.egP, paramViewGroup, false);
      paramView = new a();
      paramView.mND = paramViewGroup.findViewById(R.h.dEO);
      paramViewGroup.setTag(paramView);
      paramView = null;
      break;
      paramViewGroup = ((LayoutInflater)localObject1).inflate(R.i.egO, paramViewGroup, false);
      paramView = new b();
      break;
      paramViewGroup = ((LayoutInflater)localObject1).inflate(R.i.egQ, paramViewGroup, false);
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
    if (((j & 0x2) != 2) && (locald.field_username.equalsIgnoreCase(this.vpn)) && (!this.pRV.equalsIgnoreCase(this.vpn)))
    {
      ((b)localObject1).vpA.setBackgroundColor(this.mContext.getResources().getColor(R.e.dkr));
      label706:
      if ((j & 0x1) != 1) {
        break label1227;
      }
      ((b)localObject1).vpF.setVisibility(8);
      label724:
      if (locald.field_ranknum < 100) {
        break label1239;
      }
      ((b)localObject1).vgw.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.f.dkX));
      label757:
      if (locald.field_ranknum != 0) {
        break label1265;
      }
      ((b)localObject1).vgw.setText("");
      label776:
      if (locald.field_score < 10000) {
        break label1294;
      }
      ((b)localObject1).vpD.setTextColor(this.mContext.getResources().getColor(R.e.dkt));
      label808:
      ((b)localObject1).vpD.setText(String.valueOf(locald.field_score));
      a.b.c(((b)localObject1).vpB, locald.field_username);
      if (this.vpq) {
        break label1318;
      }
      bh.beI();
      if ((com.tencent.mm.model.c.bbL().bwd(locald.field_username)) || (this.vpm == null) || (Util.isNullOrNil((String)this.vpm.get(locald.field_username)))) {
        break label1318;
      }
      ((b)localObject1).vpC.setText(l.b(this.mContext, (CharSequence)this.vpm.get(locald.field_username), ((b)localObject1).vpC.getTextSize()));
      label934:
      ((b)localObject1).vpE.setLikeNum(locald.field_likecount);
      if (!this.vpq) {
        break label1364;
      }
      if (locald.field_likecount == 0) {
        break label1352;
      }
      ((b)localObject1).vpE.setSelfLikeState(1);
      label971:
      if ((locald.field_score <= 0) && (!this.vpq)) {
        break label1380;
      }
      ((b)localObject1).vpE.setClickable(true);
      ((b)localObject1).vpE.setOnLikeViewClickListener(new ExdeviceLikeView.a()
      {
        public final boolean daA()
        {
          AppMethodBeat.i(24164);
          if (b.a(b.this) != null)
          {
            boolean bool = b.a(b.this).avV(locald.field_username);
            AppMethodBeat.o(24164);
            return bool;
          }
          AppMethodBeat.o(24164);
          return true;
        }
        
        public final void qy(int paramAnonymousInt)
        {
          AppMethodBeat.i(24163);
          Log.i("MicroMsg.ExdeviceRankAdapter", "hy: like view clicked.after statae: %d", new Object[] { Integer.valueOf(paramAnonymousInt) });
          if (b.a(b.this) != null) {
            b.a(b.this).dD(locald.field_username, paramAnonymousInt);
          }
          AppMethodBeat.o(24163);
        }
      });
      label1013:
      if (locald.field_sportRecord == null) {
        break label1409;
      }
      ((b)localObject1).vpJ.setVisibility(0);
      paramView = ((b)localObject1).vpL;
      ((b)localObject1).vpM.setText(locald.field_sportRecord.UoP);
      ((b)localObject1).vpN.setText(locald.field_sportRecord.UoQ);
      ((b)localObject1).vpO.setText(locald.field_sportRecord.UoR);
      paramViewGroup = ((b)localObject1).vpK;
      if ("21f9d636b41b25be".equals(locald.field_sportRecord.appId)) {
        break label1392;
      }
      ((q)h.ae(q.class)).b(locald.field_sportRecord.appId, new b.2(this, paramView, paramViewGroup));
    }
    for (;;)
    {
      ((b)localObject1).vpG.setTag(Integer.valueOf(paramInt));
      ((b)localObject1).vpG.setOnClickListener(this.vps);
      ((b)localObject1).vpH.setTag(Integer.valueOf(paramInt));
      ((b)localObject1).vpH.setOnClickListener(this.vps);
      break;
      ((b)localObject1).vpA.setBackgroundColor(this.mContext.getResources().getColor(R.e.dkq));
      break label706;
      label1227:
      ((b)localObject1).vpF.setVisibility(0);
      break label724;
      label1239:
      ((b)localObject1).vgw.setTextSize(0, this.mContext.getResources().getDimensionPixelSize(R.f.dkW));
      break label757;
      label1265:
      ((b)localObject1).vgw.setText(locald.field_ranknum);
      break label776;
      label1294:
      ((b)localObject1).vpD.setTextColor(this.mContext.getResources().getColor(R.e.dks));
      break label808;
      label1318:
      ((b)localObject1).vpC.setText(l.b(this.mContext, aa.PJ(locald.field_username), ((b)localObject1).vpC.getTextSize()));
      break label934;
      label1352:
      ((b)localObject1).vpE.setSelfLikeState(0);
      break label971;
      label1364:
      ((b)localObject1).vpE.setSelfLikeState(locald.field_selfLikeState);
      break label971;
      label1380:
      ((b)localObject1).vpE.setClickable(false);
      break label1013;
      label1392:
      paramView.setText(R.l.eTD);
      paramViewGroup.setImageResource(R.k.icons_outlined_apple_watch);
      continue;
      label1409:
      ((b)localObject1).vpJ.setVisibility(8);
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
    public View mND;
  }
  
  static final class b
  {
    public View fyN;
    public TextView vgw;
    public View vpA;
    public ImageView vpB;
    public NoMeasuredTextView vpC;
    public TextView vpD;
    public ExdeviceLikeView vpE;
    public View vpF;
    public View vpG;
    public View vpH;
    public TextView vpI;
    public View vpJ;
    public ImageView vpK;
    public TextView vpL;
    public TextView vpM;
    public TextView vpN;
    public TextView vpO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.b
 * JD-Core Version:    0.7.0.1
 */
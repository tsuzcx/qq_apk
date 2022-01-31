package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.z;
import com.tencent.mm.at.a.a.c.a;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.s;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.d.1;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.d.2;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.d.3;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.f.2;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.h.1;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.k;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.m;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.n;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.q.1;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.q.2;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.q.3;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.ckd;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.r;
import com.tencent.mm.storage.r.c;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.chatting.an;
import com.tencent.mm.ui.widget.MMNeat7extView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class a
  extends BaseAdapter
  implements View.OnCreateContextMenuListener
{
  public static int jVA;
  public static int jVB;
  public static int jVC;
  public static int jVD;
  public static int jVE;
  private static Long jVL = null;
  private static Long jVM = null;
  private static Long jVN = null;
  public static int jVt = 0;
  public static int jVu = 0;
  public static int jVv;
  public static int jVw = 0;
  public static int jVx = 0;
  public static int jVy = 0;
  public static int jVz = 0;
  boolean cvo;
  List<com.tencent.mm.storage.q> iQp;
  r.c jSD;
  private int jUm;
  private int jUn;
  public com.tencent.mm.storage.q jVF;
  public int jVG;
  public int jVH;
  public BizTimeLineHotView jVI;
  public com.tencent.mm.plugin.brandservice.ui.timeline.preload.c jVJ;
  private com.tencent.mm.plugin.brandservice.ui.timeline.a.g jVK;
  private long jVO;
  public g jVP;
  boolean jVQ;
  private b jVR;
  public f jVS;
  private Set<String> jVT;
  public View.OnTouchListener jVU;
  private View.OnLongClickListener jVV;
  private View.OnClickListener jVW;
  private i jVX;
  boolean jVY;
  private com.tencent.mm.ui.widget.c.a jVd;
  private BizTimeLineUI jVs;
  
  public a(BizTimeLineUI paramBizTimeLineUI, List<com.tencent.mm.storage.q> paramList, boolean paramBoolean, f paramf, BizTimeLineHotView paramBizTimeLineHotView)
  {
    AppMethodBeat.i(14108);
    this.iQp = new LinkedList();
    this.jVH = 0;
    this.jUm = 0;
    this.jUn = 0;
    this.cvo = false;
    this.jVO = -1L;
    this.jVQ = false;
    this.jVT = new HashSet();
    this.jSD = new a.1(this);
    this.jVU = new a.7(this);
    this.jVV = new a.8(this);
    this.jVW = new a.9(this);
    this.jVX = new a.10(this);
    this.jVY = false;
    this.jVs = paramBizTimeLineUI;
    this.jVI = paramBizTimeLineHotView;
    this.jVd = new com.tencent.mm.ui.widget.c.a(this.jVs);
    this.jVS = paramf;
    int i;
    int j;
    if (jVt == 0)
    {
      jVv = paramBizTimeLineUI.getResources().getDimensionPixelSize(2131428125);
      jVw = paramBizTimeLineUI.getResources().getDimensionPixelSize(2131428121);
      jVx = paramBizTimeLineUI.getResources().getDimensionPixelSize(2131427772);
      jVy = paramBizTimeLineUI.getResources().getDimensionPixelSize(2131427792);
      jVA = paramBizTimeLineUI.getResources().getDimensionPixelSize(2131428129);
      jVB = paramBizTimeLineUI.getResources().getDimensionPixelOffset(2131427772);
      jVz = paramBizTimeLineUI.getResources().getDimensionPixelOffset(2131427808);
      jVC = com.tencent.mm.cb.a.fromDPToPix(this.jVs, 2);
      jVE = com.tencent.mm.cb.a.fromDPToPix(this.jVs, 40);
      jVD = com.tencent.mm.cb.a.fromDPToPix(this.jVs, 8);
      i = com.tencent.mm.cb.a.gw(paramBizTimeLineUI);
      j = com.tencent.mm.cb.a.gx(paramBizTimeLineUI);
      if (i >= j) {
        break label424;
      }
    }
    for (;;)
    {
      jVt = (int)((i - (int)(com.tencent.mm.cb.a.getDensity(paramBizTimeLineUI) * 16.0F)) / 2.35F);
      jVu = (int)((i - (int)(com.tencent.mm.cb.a.getDensity(paramBizTimeLineUI) * 16.0F)) / 1.777778F);
      z.afo().a(this.jSD, Looper.getMainLooper());
      aT(paramList);
      this.jVP = new g(this);
      this.jVQ = paramBoolean;
      aWG();
      this.jVJ = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.c(paramBizTimeLineUI, jVt, jVv, this.iQp);
      this.jVK = new com.tencent.mm.plugin.brandservice.ui.timeline.a.g(this, paramBizTimeLineUI);
      AppMethodBeat.o(14108);
      return;
      label424:
      i = j;
    }
  }
  
  private void a(int paramInt, com.tencent.mm.storage.q paramq, View paramView1, View paramView2)
  {
    AppMethodBeat.i(14118);
    if (paramInt > 0)
    {
      paramView1.setVisibility(0);
      if (a(paramq, paramInt))
      {
        paramView2.setVisibility(0);
        ((TextView)paramView2.findViewById(2131821898)).setText(this.jVs.getString(2131297699));
      }
    }
    for (;;)
    {
      b(paramq);
      AppMethodBeat.o(14118);
      return;
      if (b(paramq, paramInt))
      {
        paramView2.setVisibility(0);
        ((TextView)paramView2.findViewById(2131821898)).setText(this.jVs.getString(2131297700));
      }
      else
      {
        paramView2.setVisibility(8);
        paramView1.setMinimumHeight(jVx);
        continue;
        paramView1.setMinimumHeight(this.jVs.getResources().getDimensionPixelSize(2131427496));
        paramView1.setVisibility(0);
        paramView2.setVisibility(8);
      }
    }
  }
  
  private void a(com.tencent.mm.plugin.brandservice.ui.timeline.a.e parame, com.tencent.mm.storage.q paramq)
  {
    AppMethodBeat.i(14120);
    a.b.s(parame.egq, paramq.field_talker);
    Object localObject1 = s.nE(paramq.field_talker);
    Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramq.field_talker);
    if ((localObject2 != null) && (((ad)localObject2).Oa()))
    {
      localObject2 = this.jVs.getResources().getDrawable(2130837986);
      int i = (int)parame.jXY.getTextSize();
      ((Drawable)localObject2).setBounds(0, 0, i, i);
      localObject2 = new com.tencent.mm.ui.widget.a((Drawable)localObject2);
      SpannableString localSpannableString = new SpannableString("@");
      localSpannableString.setSpan(localObject2, 0, 1, 33);
      parame.jXY.setText(TextUtils.concat(new CharSequence[] { com.tencent.mm.pluginsdk.ui.d.j.b(this.jVs, (CharSequence)localObject1, parame.jXY.getTextSize()) + "  ", localSpannableString }));
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.brandservice.ui.b.d.kiX;
      com.tencent.mm.plugin.brandservice.ui.b.d.g(parame.jXY);
      parame.ekh.setText(com.tencent.mm.plugin.brandservice.ui.b.b.e(this.jVs, paramq.field_createTime));
      parame.jXX.setOnTouchListener(this.jVU);
      parame.jXX.setTag(paramq);
      parame.jXX.setOnLongClickListener(this.jVV);
      parame.jXX.setOnClickListener(this.jVW);
      AppMethodBeat.o(14120);
      return;
      parame.jXY.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this.jVs, (CharSequence)localObject1, parame.jXY.getTextSize()));
    }
  }
  
  private static boolean a(com.tencent.mm.storage.q paramq)
  {
    return (paramq == null) || (paramq.field_type == 34) || (paramq.field_type == 3);
  }
  
  private boolean a(com.tencent.mm.storage.q paramq, int paramInt)
  {
    AppMethodBeat.i(14116);
    if (jVL != null)
    {
      if (jVL.longValue() == paramq.field_orderFlag)
      {
        AppMethodBeat.o(14116);
        return true;
      }
      AppMethodBeat.o(14116);
      return false;
    }
    long l2 = paramq.dvU();
    long l1 = 0L;
    com.tencent.mm.storage.q localq = se(paramInt - 1);
    if (localq != null) {
      l1 = localq.dvU();
    }
    if ((l2 != l1) && (jVN != null) && (l1 == jVN.longValue()))
    {
      jVL = Long.valueOf(paramq.field_orderFlag);
      AppMethodBeat.o(14116);
      return true;
    }
    AppMethodBeat.o(14116);
    return false;
  }
  
  private void aWG()
  {
    AppMethodBeat.i(14109);
    aWJ();
    if (this.jVQ)
    {
      Object localObject = aWI();
      if ((localObject != null) && (!((com.tencent.mm.storage.q)localObject).dvY()))
      {
        localObject = this.iQp.iterator();
        com.tencent.mm.storage.q localq;
        for (long l = -1L; ((Iterator)localObject).hasNext(); l = localq.dvU())
        {
          localq = (com.tencent.mm.storage.q)((Iterator)localObject).next();
          if ((l != -1L) && (l != localq.dvU()))
          {
            jVL = Long.valueOf(localq.field_orderFlag);
            AppMethodBeat.o(14109);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(14109);
  }
  
  private boolean aWK()
  {
    AppMethodBeat.i(14126);
    com.tencent.mm.storage.q localq = aWI();
    if (localq != null)
    {
      if (localq.dvY())
      {
        AppMethodBeat.o(14126);
        return true;
      }
      if (this.jVO < 0L) {
        aWL();
      }
      if (localq.dvU() == this.jVO)
      {
        AppMethodBeat.o(14126);
        return true;
      }
      AppMethodBeat.o(14126);
      return false;
    }
    AppMethodBeat.o(14126);
    return false;
  }
  
  private void aWL()
  {
    AppMethodBeat.i(14128);
    com.tencent.mm.storage.q localq = z.afo().dwd();
    if (localq != null) {
      this.jVO = localq.dvU();
    }
    AppMethodBeat.o(14128);
  }
  
  private boolean b(com.tencent.mm.storage.q paramq, int paramInt)
  {
    AppMethodBeat.i(14117);
    if (jVM != null)
    {
      if ((jVL != null) && (jVL.longValue() <= jVM.longValue()))
      {
        jVM = Long.valueOf(-1L);
        AppMethodBeat.o(14117);
        return false;
      }
      if (jVM.longValue() == paramq.field_orderFlag)
      {
        AppMethodBeat.o(14117);
        return true;
      }
      AppMethodBeat.o(14117);
      return false;
    }
    com.tencent.mm.storage.q localq = se(paramInt - 1);
    if (localq == null)
    {
      AppMethodBeat.o(14117);
      return false;
    }
    long l = System.currentTimeMillis();
    if ((l - paramq.field_createTime > 86400000L) && (l - localq.field_createTime <= 86400000L))
    {
      if ((!aWK()) && ((jVL == null) || (jVL.longValue() <= paramq.field_orderFlag)))
      {
        jVM = Long.valueOf(-1L);
        AppMethodBeat.o(14117);
        return false;
      }
      jVM = Long.valueOf(paramq.field_orderFlag);
      AppMethodBeat.o(14117);
      return true;
    }
    AppMethodBeat.o(14117);
    return false;
  }
  
  public final void GM(String paramString)
  {
    AppMethodBeat.i(14114);
    com.tencent.mm.kernel.g.RM();
    if ((com.tencent.mm.kernel.a.jM(com.tencent.mm.kernel.g.RJ().eHa)) && (!this.jVT.contains(paramString)))
    {
      aa.ab(paramString, 2);
      this.jVT.add(paramString);
    }
    AppMethodBeat.o(14114);
  }
  
  public final void a(com.tencent.mm.af.q paramq, com.tencent.mm.storage.q paramq1, int paramInt1, com.tencent.mm.af.p paramp, View paramView, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(14119);
    ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.a.class)).a(paramq, paramq1, paramInt1, paramp, paramView, paramBoolean, paramInt2, this.jVX);
    paramView.setOnTouchListener(this.jVU);
    paramView.setOnLongClickListener(new a.5(this, paramq1, paramInt2));
    if ((paramq.type == 5) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).aWm())) {
      paramView.setOnClickListener(new a.6(this, paramInt2, paramq1));
    }
    AppMethodBeat.o(14119);
  }
  
  final void aT(List<com.tencent.mm.storage.q> paramList)
  {
    AppMethodBeat.i(152628);
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      if (!a((com.tencent.mm.storage.q)paramList.get(i))) {
        localLinkedList.add(paramList.get(i));
      }
      i += 1;
    }
    this.iQp.addAll(localLinkedList);
    AppMethodBeat.o(152628);
  }
  
  public final com.tencent.mm.storage.q aWH()
  {
    AppMethodBeat.i(14123);
    if (this.iQp.size() > 0)
    {
      com.tencent.mm.storage.q localq = (com.tencent.mm.storage.q)this.iQp.get(this.iQp.size() - 1);
      AppMethodBeat.o(14123);
      return localq;
    }
    AppMethodBeat.o(14123);
    return null;
  }
  
  public final com.tencent.mm.storage.q aWI()
  {
    AppMethodBeat.i(14124);
    if (this.iQp.size() > 0)
    {
      com.tencent.mm.storage.q localq = (com.tencent.mm.storage.q)this.iQp.get(0);
      AppMethodBeat.o(14124);
      return localq;
    }
    AppMethodBeat.o(14124);
    return null;
  }
  
  public final void aWJ()
  {
    AppMethodBeat.i(14125);
    com.tencent.mm.storage.q localq = aWI();
    if (localq != null) {
      jVN = Long.valueOf(localq.dvU());
    }
    jVL = null;
    jVM = null;
    AppMethodBeat.o(14125);
  }
  
  public final void b(com.tencent.mm.storage.q paramq)
  {
    AppMethodBeat.i(14115);
    if (paramq == null)
    {
      ab.w("MicroMsg.BizTimeLineAdapter", "updateGroupId info is null");
      AppMethodBeat.o(14115);
      return;
    }
    long l1 = paramq.dvU();
    long l2 = z.afo().dwf();
    ab.d("MicroMsg.BizTimeLineAdapter", "updateGroupId keep %b, groupId %d, maxGroupId %d", new Object[] { Boolean.valueOf(this.jVQ), Long.valueOf(l1), Long.valueOf(l2) });
    if ((!this.jVQ) && (l1 == l2))
    {
      l1 = paramq.field_orderFlag;
      com.tencent.mm.cm.g.cT(Long.valueOf(l1)).h(new a.4(this, l1)).b(new a.3(this));
    }
    AppMethodBeat.o(14115);
  }
  
  public final void dI(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(14129);
    ArrayList localArrayList = new ArrayList();
    if (paramInt1 <= paramInt2)
    {
      Object localObject = se(paramInt1);
      long l;
      String str;
      if ((localObject != null) && (((com.tencent.mm.storage.q)localObject).field_type == 285212721))
      {
        ab.v("MicroMsg.BizTimeLineAdapter", "terry checkpreload:" + ((com.tencent.mm.storage.q)localObject).field_msgId);
        l = ((com.tencent.mm.storage.q)localObject).field_msgId;
        str = ((com.tencent.mm.storage.q)localObject).field_content;
        if (!((com.tencent.mm.storage.q)localObject).field_isExpand) {
          break label132;
        }
      }
      label132:
      for (localObject = "-1";; localObject = "2")
      {
        localArrayList.add(new String[] { String.valueOf(l), str, localObject });
        paramInt1 += 1;
        break;
      }
    }
    if (localArrayList.size() > 0) {
      ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.b.class)).j(localArrayList, 90);
    }
    AppMethodBeat.o(14129);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(14110);
    int i = this.iQp.size();
    AppMethodBeat.o(14110);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(14112);
    com.tencent.mm.storage.q localq = se(paramInt);
    if (localq == null)
    {
      ab.e("MicroMsg.BizTimeLineAdapter", "getItemViewType info is null");
      AppMethodBeat.o(14112);
      return 0;
    }
    switch (localq.field_type)
    {
    default: 
      AppMethodBeat.o(14112);
      return 0;
    case 285212721: 
      AppMethodBeat.o(14112);
      return 1;
    case 1: 
      AppMethodBeat.o(14112);
      return 2;
    case 34: 
      AppMethodBeat.o(14112);
      return 3;
    }
    AppMethodBeat.o(14112);
    return 4;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(14113);
    com.tencent.mm.storage.q localq = se(paramInt);
    if (localq == null)
    {
      ab.e("MicroMsg.BizTimeLineAdapter", "getView info is null");
      AppMethodBeat.o(14113);
      return paramView;
    }
    if ((paramInt == getCount() - 1) && (!this.jVY)) {
      al.p(new a.2(this, paramInt), 300L);
    }
    label150:
    label172:
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int k;
    com.tencent.mm.af.q localq1;
    boolean bool1;
    switch (localq.field_type)
    {
    default: 
      if (paramView == null)
      {
        paramViewGroup = new com.tencent.mm.plugin.brandservice.ui.timeline.a.p();
        paramView = this.jVs;
        if (paramViewGroup.jXr != null)
        {
          paramView = paramViewGroup.jXr;
          paramView.setTag(paramViewGroup);
          a(paramViewGroup, localq);
          a(paramInt, localq, paramViewGroup.jXq, paramViewGroup.jXp);
        }
      }
      break;
    case 285212721: 
      for (;;)
      {
        if ((!this.jVQ) && (!this.cvo))
        {
          this.jVS.c(localq, paramInt);
          GM(localq.field_talker);
        }
        AppMethodBeat.o(14113);
        return paramView;
        if (!this.jVQ) {
          com.tencent.mm.plugin.brandservice.ui.b.c.g(localq);
        }
        if (paramView == null)
        {
          localObject1 = new com.tencent.mm.plugin.brandservice.ui.timeline.a.f();
          paramViewGroup = View.inflate(this.jVs, 2130968874, null);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jYa = ((LinearLayout)paramViewGroup.findViewById(2131821877));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jYb = ((LinearLayout)paramViewGroup.findViewById(2131821885));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jYc = ((TextView)paramViewGroup.findViewById(2131821886));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jXp = ((LinearLayout)paramViewGroup.findViewById(2131821897));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jXq = ((LinearLayout)paramViewGroup.findViewById(2131821896));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jXr = paramViewGroup;
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).aWX();
          paramViewGroup.setTag(localObject1);
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).b(this.jVs, this);
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jYd.iterator();
          while (paramView.hasNext())
          {
            localObject2 = (com.tencent.mm.plugin.brandservice.ui.timeline.a.b)paramView.next();
            an.an(((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject2).jXr, 3);
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jYa.removeView(((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject2).jXr);
          }
          localObject1 = (com.tencent.mm.plugin.brandservice.ui.timeline.a.f)paramView.getTag();
          paramViewGroup = paramView;
        }
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jYd.clear();
        localObject2 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.biz.a.a.class)).b(localq.field_msgId, localq.field_content);
        localObject3 = ((com.tencent.mm.af.p)localObject2).fjy;
        k = ((List)localObject3).size();
        if (k != 0) {
          break;
        }
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jYa.setVisibility(8);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).a((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1, -1, 0);
        paramView = paramViewGroup;
      }
      ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jYa.setVisibility(0);
      localq1 = (com.tencent.mm.af.q)((List)localObject3).get(0);
      com.tencent.mm.plugin.brandservice.ui.timeline.a.f.c(localq1);
      bool1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.a(localq, localq1);
      if (bool1) {
        if ((bo.isNullOrNil(localq1.fjJ)) && (localq1.type != 7)) {
          bool1 = false;
        }
      }
      break;
    }
    label1057:
    label1065:
    label1708:
    label2476:
    label2490:
    label2624:
    for (;;)
    {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).a((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1, -1, k);
      label578:
      localq.ywA = bool1;
      Object localObject4 = ((Activity)((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).mContext).getLayoutInflater();
      int i = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jYd.size();
      label610:
      if (i < k)
      {
        paramView = an.Py(3);
        if (paramView != null) {
          break label3670;
        }
        paramView = ((LayoutInflater)localObject4).inflate(2130968875, null);
      }
      label1476:
      label3664:
      label3670:
      for (;;)
      {
        Object localObject6 = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jXV;
        Object localObject7 = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).mContext;
        Object localObject5 = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jYa;
        localObject6 = new com.tencent.mm.plugin.brandservice.ui.timeline.a.b((a)localObject6, (Context)localObject7);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject6).jXr = paramView;
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject6).jXs = paramView.findViewById(2131821887);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject6).jXt = paramView.findViewById(2131821888);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject6).jXu = ((MMNeat7extView)paramView.findViewById(2131821889));
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject6).jXv = ((TextView)paramView.findViewById(2131821890));
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject6).jXw = paramView.findViewById(2131821437);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject6).jXx = ((ImageView)paramView.findViewById(2131821891));
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject6).jXy = ((ImageView)paramView.findViewById(2131821895));
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject6).jXz = paramView.findViewById(2131821900);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject6).jXA = ((TextView)paramView.findViewById(2131821901));
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject6).jXB = paramView.findViewById(2131821892);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject6).jXC = paramView.findViewById(2131821893);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject6).jXD = ((TextView)paramView.findViewById(2131821894));
        ((ViewGroup)localObject5).addView(paramView, ((ViewGroup)localObject5).getChildCount());
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jYd.add(localObject6);
        i += 1;
        break label610;
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).a((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1, ((com.tencent.mm.af.q)((List)localObject3).get(0)).type, k);
        break label578;
        i = 0;
        while (i < ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jYd.size())
        {
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jYd.get(i)).jXr.setVisibility(8);
          i += 1;
        }
        int j;
        label1122:
        label1403:
        boolean bool2;
        if (bool1)
        {
          if (localq1.type == 5) {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jYf.a(k, localq1, localq, paramInt, (com.tencent.mm.af.p)localObject2);
          }
        }
        else
        {
          if ((k <= 2) || (localq.field_isExpand)) {
            break label1682;
          }
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jYb.setVisibility(0);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jYc.setText(((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).mContext.getString(2131297723, new Object[] { Integer.valueOf(k - 2) }));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jYb.setTag(localq);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jYb.setOnClickListener(((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jYl);
          if (!bool1) {
            break label1695;
          }
          i = 1;
          if ((i >= k) || ((!localq.field_isExpand) && (i > 1))) {
            break label2490;
          }
          localObject4 = (com.tencent.mm.af.q)((List)localObject3).get(i);
          com.tencent.mm.plugin.brandservice.ui.timeline.a.f.c((com.tencent.mm.af.q)localObject4);
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jYd;
          if (!bool1) {
            break label1701;
          }
          j = i - 1;
          localObject5 = (com.tencent.mm.plugin.brandservice.ui.timeline.a.b)paramView.get(j);
          j = localq1.type;
          if (i != 0) {
            break label1708;
          }
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXs.setVisibility(8);
          if (bool1) {
            break label2039;
          }
          if (i != 0) {
            break label1940;
          }
          if (k != 1) {
            break label1918;
          }
          com.tencent.mm.plugin.brandservice.ui.timeline.a.f.s(((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXt, jVz, jVw);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).a((com.tencent.mm.af.q)localObject4, localq, i, false);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).a((com.tencent.mm.af.q)localObject4, false);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).a(((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXz, ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXA, localq, (com.tencent.mm.af.q)localObject4);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXu.af(((com.tencent.mm.af.q)localObject4).title);
          if (bo.isNullOrNil(((com.tencent.mm.af.q)localObject4).title)) {
            localObject6 = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXu;
          }
          switch (((com.tencent.mm.af.q)localObject4).type)
          {
          case 6: 
          default: 
            paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).mContext.getResources().getString(2131297697);
            ((MMNeat7extView)localObject6).af(paramView);
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXu.setTextColor(((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).mContext.getResources().getColor(2131689756));
            if ((((com.tencent.mm.af.q)localObject4).fjM == 0) || (((com.tencent.mm.af.q)localObject4).fjM == 1))
            {
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXw.setVisibility(0);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXu.setTextColor(((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).mContext.getResources().getColor(2131689756));
              if (((com.tencent.mm.af.q)localObject4).type == 7)
              {
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXx.setVisibility(8);
                if ((bo.isNullOrNil(((com.tencent.mm.af.q)localObject4).fjL)) || (((com.tencent.mm.af.q)localObject4).type != 3)) {
                  break label2457;
                }
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXv.setText(((com.tencent.mm.af.q)localObject4).fjL);
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXv.setVisibility(0);
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXr.setVisibility(0);
                paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jXV;
                localObject6 = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXr;
                if (k <= 1) {
                  break label2470;
                }
                bool2 = true;
                paramView.a((com.tencent.mm.af.q)localObject4, localq, paramInt, (com.tencent.mm.af.p)localObject2, (View)localObject6, bool2, i);
                if ((i != k - 1) || (((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jYb.getVisibility() == 0)) {
                  break label2476;
                }
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXr.setBackgroundResource(2130837960);
              }
            }
            break;
          }
        }
        for (;;)
        {
          i += 1;
          break label1065;
          if (localq1.type == 8)
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jYh.a(k, localq1, localq, paramInt, (com.tencent.mm.af.p)localObject2);
            break;
          }
          if (localq1.type == 7)
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jYi.a(k, localq1, localq, paramInt, (com.tencent.mm.af.p)localObject2);
            break;
          }
          if (localq1.type == 6)
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jYj.a(k, (com.tencent.mm.af.q)((List)localObject3).get(0), localq, paramInt, (com.tencent.mm.af.p)localObject2);
            break;
          }
          if (localq1.type == 10)
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jYk.a(k, localq1, localq, paramInt, (com.tencent.mm.af.p)localObject2);
            break;
          }
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jYe.a(k, localq1, localq, paramInt, (com.tencent.mm.af.p)localObject2);
          break;
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jYb.setVisibility(8);
          break label1057;
          i = 0;
          break label1065;
          j = i;
          break label1122;
          if ((i == 1) && (bool1) && (j != 7) && (j != 5) && (j != 6)) {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXs.setVisibility(8);
          }
          for (;;)
          {
            if ((!bool1) || (i > 0))
            {
              paramView = (com.tencent.mm.af.q)((List)localObject3).get(i - 1);
              localObject6 = (com.tencent.mm.af.q)((List)localObject3).get(i);
              if (((paramView.type != 7) && (paramView.type != 5) && (paramView.type != 6) && (bo.isNullOrNil(paramView.fjJ))) || ((((com.tencent.mm.af.q)localObject6).type != 7) && (((com.tencent.mm.af.q)localObject6).type != 5) && (((com.tencent.mm.af.q)localObject6).type != 6) && (bo.isNullOrNil(((com.tencent.mm.af.q)localObject6).fjJ))))
              {
                com.tencent.mm.plugin.brandservice.ui.timeline.a.f.R(((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXs, jVB);
                break;
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXs.setVisibility(0);
                continue;
              }
              com.tencent.mm.plugin.brandservice.ui.timeline.a.f.R(((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXs, jVA);
              break;
            }
          }
          com.tencent.mm.plugin.brandservice.ui.timeline.a.f.R(((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXs, jVB);
          break label1157;
          label1918:
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXt;
          j = jVz;
          com.tencent.mm.plugin.brandservice.ui.timeline.a.f.s(paramView, j, j);
          break label1187;
          if (i == 1)
          {
            if (k == 2)
            {
              com.tencent.mm.plugin.brandservice.ui.timeline.a.f.s(((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXt, jVz, jVw);
              break label1187;
            }
            paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXt;
            j = jVz;
            com.tencent.mm.plugin.brandservice.ui.timeline.a.f.s(paramView, j, j);
            break label1187;
          }
          if (i == k - 1)
          {
            com.tencent.mm.plugin.brandservice.ui.timeline.a.f.s(((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXt, jVz, jVw);
            break label1187;
          }
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXt;
          j = jVz;
          com.tencent.mm.plugin.brandservice.ui.timeline.a.f.s(paramView, j, j);
          break label1187;
          label2039:
          if (i == 1)
          {
            if (i == k - 1)
            {
              paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXt;
              j = jVw;
              com.tencent.mm.plugin.brandservice.ui.timeline.a.f.s(paramView, j, j);
              break label1187;
            }
            com.tencent.mm.plugin.brandservice.ui.timeline.a.f.s(((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXt, jVw, jVz);
            break label1187;
          }
          if (i == k - 1)
          {
            com.tencent.mm.plugin.brandservice.ui.timeline.a.f.s(((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXt, jVz, jVw);
            break label1187;
          }
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXt;
          j = jVz;
          com.tencent.mm.plugin.brandservice.ui.timeline.a.f.s(paramView, j, j);
          break label1187;
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).mContext.getResources().getString(2131297707);
          break label1307;
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).mContext.getResources().getString(2131297708);
          break label1307;
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).mContext.getResources().getString(2131297698);
          break label1307;
          if (!bo.isNullOrNil(((com.tencent.mm.af.q)localObject4).fjJ))
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXx.setVisibility(0);
            paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jXV.jVJ;
            localObject6 = com.tencent.mm.af.l.a((com.tencent.mm.af.q)localObject4);
            localObject7 = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXx;
            j = jVv;
            paramView.a((String)localObject6, (ImageView)localObject7, j, j, new f.2((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1, (com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5, (com.tencent.mm.af.q)localObject4, localq, i));
            break label1403;
          }
          if ((((com.tencent.mm.af.q)localObject4).type == 5) || (((com.tencent.mm.af.q)localObject4).type == 6))
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXx.setVisibility(0);
            localObject6 = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jXV.jVJ;
            paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXx;
            j = jVv;
            paramView.setContentDescription(((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject6).jVs.getString(2131298197));
            localObject6 = com.tencent.mm.at.o.ahG();
            localObject7 = new c.a();
            ((c.a)localObject7).eNK = true;
            ((c.a)localObject7).eNY = 2131689878;
            localObject7 = ((c.a)localObject7).cx(j, j);
            ((c.a)localObject7).fHt = 4;
            ((com.tencent.mm.at.a.a)localObject6).a("2130841217", paramView, ((c.a)localObject7).ahY(), null, new com.tencent.mm.pluginsdk.ui.applet.e());
            break label1403;
          }
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXw.setVisibility(8);
          break label1403;
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXw.setVisibility(8);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXu.setTextColor(((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).mContext.getResources().getColor(2131690168));
          break label1403;
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXv.setVisibility(8);
          break label1445;
          bool2 = false;
          break label1476;
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.b)localObject5).jXr.setBackgroundResource(2130837966);
        }
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jXV.a(paramInt, localq, ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jXq, ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jXp);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.f)localObject1).jXV.a((com.tencent.mm.plugin.brandservice.ui.timeline.a.e)localObject1, localq);
        paramView = paramViewGroup;
        break label172;
        if (paramView == null)
        {
          paramViewGroup = new com.tencent.mm.plugin.brandservice.ui.timeline.a.h();
          paramView = paramViewGroup.a(this.jVs, this);
          paramView.setTag(paramViewGroup);
          label2555:
          localObject1 = com.tencent.mm.pluginsdk.ui.d.j.a(paramViewGroup.mContext, localq.field_content, (int)paramViewGroup.jXI.getTextSize(), 1, null, null);
          paramViewGroup.jXI.setMaxLines(2147483647);
          paramViewGroup.jXI.af((CharSequence)localObject1);
          if (!localq.field_isExpand) {
            break label2813;
          }
          paramViewGroup.jYv.setText(paramViewGroup.mContext.getString(2131297703));
          i = com.tencent.mm.cb.a.gw(paramViewGroup.mContext);
          j = com.tencent.mm.cb.a.fromDPToPix(paramViewGroup.mContext, 72);
          localObject1 = paramViewGroup.jXI.Sa(i - j);
          if (localObject1 == null) {
            break label3664;
          }
        }
        for (i = ((com.tencent.neattextview.textview.layout.a)localObject1).dTo();; i = 0)
        {
          if (i > 4)
          {
            if (!localq.field_isExpand) {
              paramViewGroup.jXI.setMaxLines(4);
            }
            paramViewGroup.jYv.setVisibility(0);
            if (localq.field_isExpand)
            {
              paramViewGroup.jYv.setText(2131297703);
              paramViewGroup.jYv.setOnClickListener(new h.1(paramViewGroup, localq));
              localObject1 = (LinearLayout.LayoutParams)paramViewGroup.jXI.getLayoutParams();
              if (i > 4) {
                break label2868;
              }
            }
          }
          for (((LinearLayout.LayoutParams)localObject1).gravity = 17;; ((LinearLayout.LayoutParams)localObject1).gravity = 19)
          {
            paramViewGroup.jXI.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            paramViewGroup.jXV.a(paramViewGroup, localq);
            paramViewGroup.jXV.a(paramInt, localq, paramViewGroup.jXq, paramViewGroup.jXp);
            break;
            paramViewGroup = (com.tencent.mm.plugin.brandservice.ui.timeline.a.h)paramView.getTag();
            break label2555;
            label2813:
            paramViewGroup.jYv.setText(paramViewGroup.mContext.getString(2131297704));
            break label2624;
            paramViewGroup.jYv.setText(2131297704);
            break label2720;
            paramViewGroup.jXI.setMaxLines(2147483647);
            paramViewGroup.jYv.setVisibility(8);
            break label2737;
          }
          if (paramView == null)
          {
            paramViewGroup = new com.tencent.mm.plugin.brandservice.ui.timeline.a.q();
            paramView = paramViewGroup.a(this.jVs, this);
            paramView.setTag(paramViewGroup);
            label2905:
            localq.ywA = com.tencent.mm.plugin.brandservice.ui.b.a.f(localq);
            if (!localq.ywA) {
              break label3246;
            }
            paramViewGroup.jXS.setVisibility(0);
            paramViewGroup.jXT.setVisibility(8);
            localObject2 = paramViewGroup.jXI;
            localObject1 = paramViewGroup.jXy;
            localObject3 = new com.tencent.mm.modelvoice.p(localq.field_content);
            ((MMNeat7extView)localObject2).af(com.tencent.mm.pluginsdk.f.h.formatTime("yyyy/MM/dd", System.currentTimeMillis() / 1000L));
            if (localq.ywA)
            {
              localObject2 = com.tencent.mm.af.l.kq((int)(((com.tencent.mm.modelvoice.p)localObject3).time / 1000L));
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                break label3319;
              }
              paramViewGroup.jYR.setVisibility(0);
              paramViewGroup.jYR.setText((CharSequence)localObject2);
              label3032:
              paramViewGroup.jYu.setOnClickListener(new q.2(paramViewGroup));
              paramViewGroup.jYu.setBackgroundResource(2130838334);
              localObject2 = paramViewGroup.jYu;
              i = jVx;
              j = jVw;
              k = jVx;
              ((View)localObject2).setPadding(i, j, k, k);
            }
            localObject2 = ((ImageView)localObject1).getDrawable();
            if (((localObject2 instanceof AnimationDrawable)) && (((AnimationDrawable)localObject2).isRunning())) {
              ((AnimationDrawable)localObject2).stop();
            }
            if ((!paramViewGroup.jXV.jVP.isPlaying()) || (localq.field_msgId != paramViewGroup.jXV.jVP.jXk)) {
              break label3331;
            }
            ((ImageView)localObject1).setImageResource(2130838318);
            if ((((ImageView)localObject1).getDrawable() instanceof AnimationDrawable)) {
              ((AnimationDrawable)((ImageView)localObject1).getDrawable()).start();
            }
          }
          for (;;)
          {
            ((ImageView)localObject1).setOnClickListener(new q.3(paramViewGroup, localq, (ImageView)localObject1));
            paramViewGroup.jXV.a(paramViewGroup, localq);
            paramViewGroup.jXV.a(paramInt, localq, paramViewGroup.jXq, paramViewGroup.jXp);
            break;
            paramViewGroup = (com.tencent.mm.plugin.brandservice.ui.timeline.a.q)paramView.getTag();
            break label2905;
            paramViewGroup.jXs.setVisibility(8);
            paramViewGroup.jXS.setVisibility(8);
            paramViewGroup.jXT.setVisibility(0);
            paramViewGroup.jYU.setVisibility(8);
            paramViewGroup.jYT.setVisibility(0);
            localObject2 = paramViewGroup.jYV;
            localObject1 = paramViewGroup.jYT;
            paramViewGroup.jXT.setOnClickListener(new q.1(paramViewGroup));
            break label2952;
            label3319:
            paramViewGroup.jYR.setVisibility(8);
            break label3032;
            ((ImageView)localObject1).setImageResource(2130838317);
          }
          if (paramView == null)
          {
            paramViewGroup = new com.tencent.mm.plugin.brandservice.ui.timeline.a.d();
            paramView = paramViewGroup.a(this.jVs, this);
            paramView.setTag(paramViewGroup);
          }
          for (;;)
          {
            if (this.jVR == null) {
              this.jVR = new b(this.jVs);
            }
            localObject1 = this.jVR;
            paramViewGroup.jXV.a(paramViewGroup, localq);
            paramViewGroup.jXV.a(paramInt, localq, paramViewGroup.jXq, paramViewGroup.jXp);
            localq.ywA = com.tencent.mm.plugin.brandservice.ui.b.a.f(localq);
            if (!localq.ywA) {
              break label3553;
            }
            paramViewGroup.jXT.setVisibility(8);
            paramViewGroup.jXS.setVisibility(0);
            paramViewGroup.dd(paramViewGroup.jXQ);
            paramViewGroup.dd(paramViewGroup.jXP);
            ((b)localObject1).a(localq, paramInt, paramViewGroup.jXP, jVt);
            paramViewGroup.jXQ.setOnClickListener(new d.1(paramViewGroup, localq));
            paramViewGroup.jXQ.setOnTouchListener(paramViewGroup.jXV.jVU);
            paramViewGroup.jXQ.setOnLongClickListener(new d.2(paramViewGroup, localq));
            break;
            paramViewGroup = (com.tencent.mm.plugin.brandservice.ui.timeline.a.d)paramView.getTag();
          }
          label3553:
          paramViewGroup.jXT.setVisibility(0);
          paramViewGroup.jXS.setVisibility(8);
          paramViewGroup.jXs.setVisibility(8);
          paramViewGroup.jXI.af(paramViewGroup.mContext.getText(2131297696));
          ((b)localObject1).a(localq, paramInt, paramViewGroup.jXR, 0);
          paramViewGroup.jXT.setOnClickListener(new d.3(paramViewGroup, localq));
          break label172;
          paramViewGroup.jXr = View.inflate(paramView, 2130968892, null);
          paramViewGroup.aWX();
          paramView = paramViewGroup.jXr;
          break;
          paramViewGroup = (com.tencent.mm.plugin.brandservice.ui.timeline.a.p)paramView.getTag();
          break label150;
        }
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 5;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(14127);
    if (super.isEmpty())
    {
      if (z.afp().bbZ() > 0)
      {
        AppMethodBeat.o(14127);
        return false;
      }
      ckd localckd = com.tencent.mm.plugin.brandservice.ui.timeline.offenread.d.aXb();
      if ((localckd != null) && (!bo.es(localckd.xUg))) {}
      for (int i = 0; i == 0; i = 1)
      {
        AppMethodBeat.o(14127);
        return false;
      }
    }
    boolean bool = super.isEmpty();
    AppMethodBeat.o(14127);
    return bool;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(14122);
    super.notifyDataSetChanged();
    AppMethodBeat.o(14122);
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(14121);
    if (this.jVF == null)
    {
      ab.w("MicroMsg.BizTimeLineAdapter", "onCreateContextMenu mInfo == null");
      AppMethodBeat.o(14121);
      return;
    }
    if (this.jVH == 0)
    {
      paramView = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(this.jVF.field_talker);
      if (paramView == null)
      {
        ab.e("MicroMsg.BizTimeLineAdapter", "onCreateContextMenu, contact is null, talker = " + this.jVF.field_talker);
        AppMethodBeat.o(14121);
        return;
      }
      paramContextMenuInfo = paramView.Of();
      paramContextMenu.setHeaderTitle(com.tencent.mm.pluginsdk.ui.d.j.b(this.jVs, paramContextMenuInfo));
      if (com.tencent.mm.n.a.je(paramView.field_type))
      {
        paramContextMenu.add(0, 10, 0, 2131297686);
        paramContextMenu.add(0, 2, 0, 2131301402);
      }
      AppMethodBeat.o(14121);
      return;
    }
    paramContextMenu.add(0, 11, 0, 2131297688);
    AppMethodBeat.o(14121);
  }
  
  public final com.tencent.mm.storage.q se(int paramInt)
  {
    AppMethodBeat.i(14111);
    if ((paramInt < this.iQp.size()) && (paramInt >= 0))
    {
      com.tencent.mm.storage.q localq = (com.tencent.mm.storage.q)this.iQp.get(paramInt);
      AppMethodBeat.o(14111);
      return localq;
    }
    AppMethodBeat.o(14111);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a
 * JD-Core Version:    0.7.0.1
 */
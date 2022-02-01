package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.y.b;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.i.1;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.i.2;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.i.3;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.m.1;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.m.2;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.n;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.o.2;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.q;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.q.1;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.r;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.w;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.x;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.z;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.z.1;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.z.2;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.z.3;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.ahj;
import com.tencent.mm.protocal.protobuf.dap;
import com.tencent.mm.protocal.protobuf.daq;
import com.tencent.mm.protocal.protobuf.dar;
import com.tencent.mm.protocal.protobuf.dat;
import com.tencent.mm.protocal.protobuf.dau;
import com.tencent.mm.protocal.protobuf.dbw;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.t.a;
import com.tencent.mm.storage.t.c;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class c
  extends BaseAdapter
  implements View.OnCreateContextMenuListener
{
  public static int mWA = 0;
  public static int mWB;
  public static int mWC = 0;
  public static int mWD = 0;
  public static int mWE = 0;
  public static int mWF = 0;
  public static int mWG;
  public static int mWH;
  public static int mWI;
  public static int mWJ;
  public static int mWK;
  private static Long mWQ = null;
  private static Long mWR = null;
  private static Long mWS = null;
  public static int mWz = 0;
  boolean dkt;
  public List<s> lEL;
  t.c mSg;
  public s mWL;
  public int mWM;
  public BizTimeLineHotView mWN;
  public com.tencent.mm.plugin.brandservice.ui.timeline.preload.c mWO;
  private com.tencent.mm.plugin.brandservice.ui.timeline.a.p mWP;
  private long mWT;
  public i mWU;
  boolean mWV;
  private d mWW;
  public h mWX;
  private Set<String> mWY;
  public Set<com.tencent.mm.ai.v> mWZ;
  private BizTimeLineUI mWy;
  private View.OnClickListener mXa;
  private k mXb;
  boolean mXc;
  
  public c(BizTimeLineUI paramBizTimeLineUI, List<s> paramList, boolean paramBoolean, h paramh, BizTimeLineHotView paramBizTimeLineHotView)
  {
    AppMethodBeat.i(5865);
    this.lEL = new LinkedList();
    this.dkt = false;
    this.mWT = -1L;
    this.mWV = false;
    this.mWY = new HashSet();
    this.mWZ = new HashSet();
    this.mSg = new t.c()
    {
      public final void a(final Object paramAnonymousObject, final t.a paramAnonymousa)
      {
        AppMethodBeat.i(5855);
        if ((paramAnonymousa != null) && (paramAnonymousa.FeH))
        {
          AppMethodBeat.o(5855);
          return;
        }
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler()
        {
          public final boolean queueIdle()
          {
            AppMethodBeat.i(5854);
            Looper.myQueue().removeIdleHandler(this);
            if ((c.a(c.this) == null) || (c.a(c.this).isFinishing()))
            {
              AppMethodBeat.o(5854);
              return false;
            }
            c.a(c.this, paramAnonymousa);
            AppMethodBeat.o(5854);
            return false;
          }
        });
        AppMethodBeat.o(5855);
      }
    };
    this.mXa = new c.10(this);
    this.mXb = new c.11(this);
    this.mXc = false;
    this.mWy = paramBizTimeLineUI;
    this.mWN = paramBizTimeLineHotView;
    this.mWX = paramh;
    int i;
    int j;
    if (mWz == 0)
    {
      mWB = paramBizTimeLineUI.getResources().getDimensionPixelSize(2131165905);
      mWC = paramBizTimeLineUI.getResources().getDimensionPixelSize(2131165900);
      mWD = paramBizTimeLineUI.getResources().getDimensionPixelSize(2131165480);
      mWE = paramBizTimeLineUI.getResources().getDimensionPixelSize(2131165500);
      mWG = paramBizTimeLineUI.getResources().getDimensionPixelSize(2131165909);
      mWH = paramBizTimeLineUI.getResources().getDimensionPixelOffset(2131165480);
      mWF = paramBizTimeLineUI.getResources().getDimensionPixelOffset(2131165516);
      mWI = com.tencent.mm.cd.a.fromDPToPix(this.mWy, 2);
      mWK = com.tencent.mm.cd.a.fromDPToPix(this.mWy, 40);
      mWJ = com.tencent.mm.cd.a.fromDPToPix(this.mWy, 8);
      i = com.tencent.mm.cd.a.hV(paramBizTimeLineUI);
      j = com.tencent.mm.cd.a.hW(paramBizTimeLineUI);
      if (i >= j) {
        break label388;
      }
    }
    for (;;)
    {
      mWz = (int)((i - (int)(com.tencent.mm.cd.a.getDensity(paramBizTimeLineUI) * 16.0F)) / 2.35F);
      mWA = (int)((i - (int)(com.tencent.mm.cd.a.getDensity(paramBizTimeLineUI) * 16.0F)) / 1.777778F);
      com.tencent.mm.am.af.awk().a(this.mSg, Looper.getMainLooper());
      ci(paramList);
      cj(paramList);
      this.mWU = new i(this);
      this.mWV = paramBoolean;
      bCH();
      this.mWO = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.c(paramBizTimeLineUI, mWz, mWB, this.lEL);
      this.mWP = new com.tencent.mm.plugin.brandservice.ui.timeline.a.p(this, paramBizTimeLineUI);
      com.tencent.mm.plugin.brandservice.ui.timeline.a.d.bCW();
      AppMethodBeat.o(5865);
      return;
      label388:
      i = j;
    }
  }
  
  private void a(int paramInt, s params, View paramView1, View paramView2)
  {
    AppMethodBeat.i(5875);
    if (paramInt > 0)
    {
      paramView1.setVisibility(0);
      if (a(params, paramInt))
      {
        paramView2.setVisibility(0);
        ((TextView)paramView2.findViewById(2131297357)).setText(this.mWy.getString(2131756615));
      }
    }
    for (;;)
    {
      b(params);
      AppMethodBeat.o(5875);
      return;
      paramView2.setVisibility(8);
      paramView1.setMinimumHeight(mWD);
      continue;
      paramView1.setMinimumHeight(this.mWy.getResources().getDimensionPixelSize(2131165187));
      paramView1.setVisibility(0);
      paramView2.setVisibility(8);
    }
  }
  
  private void a(n paramn, final s params)
  {
    AppMethodBeat.i(5877);
    a.b.d(paramn.frr, params.field_talker);
    Object localObject1 = com.tencent.mm.model.v.sh(params.field_talker);
    Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(params.field_talker);
    if ((localObject2 != null) && (((com.tencent.mm.storage.af)localObject2).ZS()))
    {
      localObject2 = this.mWy.getResources().getDrawable(2131231289);
      int i = (int)paramn.mZh.getTextSize();
      ((Drawable)localObject2).setBounds(0, 0, i, i);
      localObject2 = new com.tencent.mm.ui.widget.a((Drawable)localObject2);
      SpannableString localSpannableString = new SpannableString("@");
      localSpannableString.setSpan(localObject2, 0, 1, 33);
      paramn.mZh.setText(TextUtils.concat(new CharSequence[] { com.tencent.mm.pluginsdk.ui.span.k.b(this.mWy, (CharSequence)localObject1, paramn.mZh.getTextSize()) + "  ", localSpannableString }));
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.brandservice.ui.b.d.nmK;
      com.tencent.mm.plugin.brandservice.ui.b.d.i(paramn.mZh);
      paramn.naq.setTag(params);
      paramn.naq.setOnClickListener(this.mXa);
      if (!com.tencent.mm.storage.u.eKi()) {
        break;
      }
      paramn.fwS.setVisibility(0);
      paramn.nar.setVisibility(8);
      paramn.fwS.setText(com.tencent.mm.plugin.brandservice.ui.b.b.f(this.mWy, params.field_createTime));
      paramn.naq.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(175418);
          c.this.mWL = params;
          c.this.mWX.c(c.this.mWL, 20);
          c.c(c.this);
          AppMethodBeat.o(175418);
          return false;
        }
      });
      AppMethodBeat.o(5877);
      return;
      paramn.mZh.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.mWy, (CharSequence)localObject1, paramn.mZh.getTextSize()));
    }
    paramn.fwS.setVisibility(8);
    paramn.nar.setVisibility(0);
    paramn.naq.setOnLongClickListener(null);
    paramn.nar.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(175419);
        c.this.mWL = params;
        c.this.mWX.c(c.this.mWL, 19);
        c.c(c.this);
        AppMethodBeat.o(175419);
      }
    });
    com.tencent.mm.ui.tools.o.gp(paramn.nar);
    AppMethodBeat.o(5877);
  }
  
  private static boolean a(s params)
  {
    return (params == null) || (params.field_type == 34) || (params.field_type == 3);
  }
  
  private boolean a(s params, int paramInt)
  {
    AppMethodBeat.i(5874);
    if (mWQ != null)
    {
      if (mWQ.longValue() == params.field_orderFlag)
      {
        AppMethodBeat.o(5874);
        return true;
      }
      AppMethodBeat.o(5874);
      return false;
    }
    long l2 = params.eJJ();
    long l1 = 0L;
    s locals = xP(paramInt - 1);
    if (locals != null) {
      l1 = locals.eJJ();
    }
    if ((l2 != l1) && (mWS != null) && (l1 == mWS.longValue()))
    {
      mWQ = Long.valueOf(params.field_orderFlag);
      AppMethodBeat.o(5874);
      return true;
    }
    AppMethodBeat.o(5874);
    return false;
  }
  
  private void bCH()
  {
    AppMethodBeat.i(5866);
    bCK();
    if (this.mWV)
    {
      Object localObject = bCJ();
      if ((localObject != null) && (!((s)localObject).eJQ()))
      {
        localObject = this.lEL.iterator();
        s locals;
        for (long l = -1L; ((Iterator)localObject).hasNext(); l = locals.eJJ())
        {
          locals = (s)((Iterator)localObject).next();
          if ((l != -1L) && (l != locals.eJJ()))
          {
            mWQ = Long.valueOf(locals.field_orderFlag);
            AppMethodBeat.o(5866);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(5866);
  }
  
  private void bCL()
  {
    s locals = null;
    AppMethodBeat.i(5886);
    Cursor localCursor = com.tencent.mm.am.af.awk().gPa.a("SELECT * FROM BizTimeLineInfo order by orderFlag asc limit 1", null, 0);
    if (localCursor.moveToFirst())
    {
      locals = new s();
      locals.convertFrom(localCursor);
    }
    localCursor.close();
    if (locals != null) {
      this.mWT = locals.eJJ();
    }
    AppMethodBeat.o(5886);
  }
  
  private static void ch(List<s> paramList)
  {
    AppMethodBeat.i(5867);
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(5867);
      return;
    }
    ad.d("MicroMsg.BizTimeLineAdapter", "alvinluo doUpdateListCellPosition list: %d", new Object[] { Integer.valueOf(paramList.size()) });
    long l = System.currentTimeMillis();
    Object localObject = (s)paramList.get(0);
    ((s)localObject).nah = 1;
    int j = 1;
    int k = 1;
    if (j < paramList.size())
    {
      s locals = (s)paramList.get(j);
      int i;
      switch (((s)localObject).field_type)
      {
      default: 
        i = 1;
      }
      for (;;)
      {
        k += i;
        locals.nah = k;
        j += 1;
        localObject = locals;
        break;
        int m = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).b(((s)localObject).field_msgId, ((s)localObject).field_content);
        i = m;
        if (!((s)localObject).field_isExpand)
        {
          i = Math.min(m, 2);
          continue;
          i = 1;
        }
      }
    }
    ad.d("MicroMsg.BizTimeLineAdapter", "alvinluo doUpdateListCellPosition cost: %d, startCellPosition: %d, size: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(1), Integer.valueOf(paramList.size()) });
    AppMethodBeat.o(5867);
  }
  
  public static void cj(List<s> paramList)
  {
    AppMethodBeat.i(5883);
    com.tencent.mm.pluginsdk.ui.applet.g localg = com.tencent.mm.pluginsdk.ui.applet.g.BXQ;
    if (com.tencent.mm.pluginsdk.ui.applet.g.UJ(1)) {
      ch(paramList);
    }
    AppMethodBeat.o(5883);
  }
  
  public final void Pn(String paramString)
  {
    AppMethodBeat.i(5872);
    com.tencent.mm.kernel.g.afC();
    if ((com.tencent.mm.kernel.a.mp(com.tencent.mm.kernel.g.afz().gch)) && (!this.mWY.contains(paramString)))
    {
      aa.ak(paramString, 2);
      this.mWY.add(paramString);
    }
    AppMethodBeat.o(5872);
  }
  
  public final void a(com.tencent.mm.ai.v paramv, s params, int paramInt1, com.tencent.mm.ai.u paramu, View paramView, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(5876);
    ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a(paramv, params, paramInt1, paramu, paramView, paramBoolean, paramInt2, this.mXb);
    if ((paramv.type == 5) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bBR())) {
      paramView.setOnClickListener(new c.6(this, params, paramInt2));
    }
    AppMethodBeat.o(5876);
  }
  
  public final void b(s params)
  {
    AppMethodBeat.i(5873);
    if (params == null)
    {
      ad.w("MicroMsg.BizTimeLineAdapter", "updateGroupId info is null");
      AppMethodBeat.o(5873);
      return;
    }
    final long l1 = params.eJJ();
    long l2 = com.tencent.mm.am.af.awk().eJX();
    ad.d("MicroMsg.BizTimeLineAdapter", "updateGroupId keep %b, groupId %d, maxGroupId %d", new Object[] { Boolean.valueOf(this.mWV), Long.valueOf(l1), Long.valueOf(l2) });
    if ((!this.mWV) && (l1 == l2))
    {
      l1 = params.field_orderFlag;
      com.tencent.mm.co.g.en(Long.valueOf(l1)).h(new com.tencent.mm.vending.c.a() {}).b(new com.tencent.mm.vending.c.a() {});
    }
    AppMethodBeat.o(5873);
  }
  
  public final s bCI()
  {
    AppMethodBeat.i(5880);
    if (this.lEL.size() > 0)
    {
      s locals = (s)this.lEL.get(this.lEL.size() - 1);
      AppMethodBeat.o(5880);
      return locals;
    }
    AppMethodBeat.o(5880);
    return null;
  }
  
  public final s bCJ()
  {
    AppMethodBeat.i(5881);
    if (this.lEL.size() > 0)
    {
      s locals = (s)this.lEL.get(0);
      AppMethodBeat.o(5881);
      return locals;
    }
    AppMethodBeat.o(5881);
    return null;
  }
  
  public final void bCK()
  {
    AppMethodBeat.i(5884);
    s locals = bCJ();
    if (locals != null) {
      mWS = Long.valueOf(locals.eJJ());
    }
    mWQ = null;
    mWR = null;
    AppMethodBeat.o(5884);
  }
  
  final void ci(List<s> paramList)
  {
    AppMethodBeat.i(5882);
    ad.d("MicroMsg.BizTimeLineAdapter", "alvinluo filterAndAddList size: %d", new Object[] { Integer.valueOf(paramList.size()) });
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      if (!a((s)paramList.get(i))) {
        localLinkedList.add(paramList.get(i));
      }
      i += 1;
    }
    this.lEL.addAll(localLinkedList);
    AppMethodBeat.o(5882);
  }
  
  public final void eH(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5887);
    ArrayList localArrayList = new ArrayList();
    if (paramInt1 <= paramInt2)
    {
      Object localObject = xP(paramInt1);
      long l;
      String str;
      if ((localObject != null) && (((s)localObject).field_type == 285212721))
      {
        ad.v("MicroMsg.BizTimeLineAdapter", "terry checkpreload:" + ((s)localObject).field_msgId);
        l = ((s)localObject).field_msgId;
        str = ((s)localObject).field_content;
        if (!((s)localObject).field_isExpand) {
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
      ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).j(localArrayList, 90);
    }
    AppMethodBeat.o(5887);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(5868);
    int i = this.lEL.size();
    AppMethodBeat.o(5868);
    return i;
  }
  
  public final long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(5870);
    s locals = xP(paramInt);
    if (locals == null)
    {
      ad.e("MicroMsg.BizTimeLineAdapter", "getItemViewType info is null");
      AppMethodBeat.o(5870);
      return 0;
    }
    switch (locals.field_type)
    {
    default: 
      AppMethodBeat.o(5870);
      return 0;
    case 285212721: 
      AppMethodBeat.o(5870);
      return 1;
    case 1: 
      AppMethodBeat.o(5870);
      return 2;
    case 34: 
      AppMethodBeat.o(5870);
      return 3;
    case 3: 
      AppMethodBeat.o(5870);
      return 4;
    }
    AppMethodBeat.o(5870);
    return 5;
  }
  
  public final View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(5871);
    s locals = xP(paramInt);
    if (locals == null)
    {
      ad.e("MicroMsg.BizTimeLineAdapter", "getView info is null");
      AppMethodBeat.o(5871);
      return paramView;
    }
    if ((paramInt == getCount() - 1) && (!this.mXc)) {
      aq.n(new Runnable()
      {
        public final void run()
        {
          int j = 0;
          AppMethodBeat.i(5856);
          if ((paramInt == c.this.getCount() - 1) && (!c.this.mXc))
          {
            ad.i("MicroMsg.BizTimeLineAdapter", "loadMoreData %d/%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(c.this.getCount()) });
            c localc = c.this;
            Object localObject = localc.bCI();
            int i = j;
            if (localObject != null)
            {
              localObject = com.tencent.mm.am.af.awk().aF(10, ((s)localObject).field_orderFlag);
              localc.ci((List)localObject);
              com.tencent.mm.plugin.brandservice.ui.b.c.a((List)localObject, new c.3(localc));
              localc.notifyDataSetChanged();
              i = j;
              if (((List)localObject).size() > 0) {
                i = 1;
              }
            }
            if (i == 0)
            {
              c.this.mXc = true;
              c.a(c.this).bCO();
              AppMethodBeat.o(5856);
              return;
            }
            c.this.mWO.Wc();
          }
          AppMethodBeat.o(5856);
        }
      }, 300L);
    }
    label153:
    label158:
    label180:
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int k;
    Object localObject4;
    boolean bool1;
    switch (locals.field_type)
    {
    default: 
      if (paramView == null)
      {
        paramViewGroup = new com.tencent.mm.plugin.brandservice.ui.timeline.a.y();
        paramView = this.mWy;
        if (paramViewGroup.mYI != null)
        {
          paramView = paramViewGroup.mYI;
          paramView.setTag(paramViewGroup);
          a(paramViewGroup, locals);
          a(paramInt, locals, paramViewGroup.mZB, paramViewGroup.mZA);
        }
      }
      break;
    case 285212721: 
      for (;;)
      {
        if ((!this.mWV) && (!this.dkt))
        {
          this.mWX.b(locals, paramInt);
          Pn(locals.field_talker);
        }
        AppMethodBeat.o(5871);
        return paramView;
        if (!this.mWV) {
          com.tencent.mm.plugin.brandservice.ui.b.c.g(locals);
        }
        if (paramView == null)
        {
          localObject1 = new com.tencent.mm.plugin.brandservice.ui.timeline.a.o();
          paramViewGroup = View.inflate(this.mWy, 2131493210, null);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nat = ((LinearLayout)paramViewGroup.findViewById(2131297332));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nau = ((LinearLayout)paramViewGroup.findViewById(2131304785));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nav = ((TextView)paramViewGroup.findViewById(2131304786));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).mZA = ((LinearLayout)paramViewGroup.findViewById(2131297356));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).mZB = ((LinearLayout)paramViewGroup.findViewById(2131297346));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).mYI = paramViewGroup;
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).bDa();
          paramViewGroup.setTag(localObject1);
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).b(this.mWy, this);
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).naw.iterator();
          while (paramView.hasNext())
          {
            localObject2 = (com.tencent.mm.plugin.brandservice.ui.timeline.a.k)paramView.next();
            com.tencent.mm.ui.chatting.ao.ay(((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject2).mYI, 3);
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nat.removeView(((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject2).mYI);
          }
          localObject1 = (com.tencent.mm.plugin.brandservice.ui.timeline.a.o)paramView.getTag();
          paramViewGroup = paramView;
        }
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).naw.clear();
        localObject2 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(locals.field_msgId, locals.field_content);
        localObject3 = ((com.tencent.mm.ai.u)localObject2).gKs;
        k = ((List)localObject3).size();
        if (k != 0) {
          break;
        }
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nat.setVisibility(8);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).a((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1, -1, 0);
        paramView = paramViewGroup;
      }
      ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nat.setVisibility(0);
      localObject4 = (com.tencent.mm.ai.v)((List)localObject3).get(0);
      com.tencent.mm.plugin.brandservice.ui.timeline.a.o.c((com.tencent.mm.ai.v)localObject4);
      bool1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.a(locals, (com.tencent.mm.ai.v)localObject4);
      if (bool1) {
        if ((bt.isNullOrNil(((com.tencent.mm.ai.v)localObject4).gKD)) && (((com.tencent.mm.ai.v)localObject4).type != 7) && (((com.tencent.mm.ai.v)localObject4).type != 10)) {
          bool1 = false;
        }
      }
      break;
    }
    label1182:
    label1447:
    label2858:
    label5168:
    for (;;)
    {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).a((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1, -1, k);
      label596:
      locals.Fep = bool1;
      Object localObject5 = ((Activity)((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).mContext).getLayoutInflater();
      int i = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).naw.size();
      label628:
      if (i < k)
      {
        paramView = com.tencent.mm.ui.chatting.ao.YD(3);
        if (paramView != null) {
          break label5174;
        }
        paramView = ((LayoutInflater)localObject5).inflate(2131493211, null);
      }
      label4786:
      label5174:
      for (;;)
      {
        Object localObject7 = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nao;
        Object localObject8 = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).mContext;
        Object localObject6 = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nat;
        localObject7 = new com.tencent.mm.plugin.brandservice.ui.timeline.a.k((c)localObject7, (Context)localObject8);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).mYI = paramView;
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).hIU = paramView.findViewById(2131306012);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).mZJ = paramView.findViewById(2131298764);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).mZK = ((MMNeat7extView)paramView.findViewById(2131305938));
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).mZL = ((TextView)paramView.findViewById(2131305546));
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).mZM = paramView.findViewById(2131298814);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).mZN = ((ImageView)paramView.findViewById(2131298824));
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).mZQ = ((ImageView)paramView.findViewById(2131303284));
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).mZO = paramView.findViewById(2131297330);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).mZP = ((ImageView)paramView.findViewById(2131297370));
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).mZR = paramView.findViewById(2131305184);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).mZS = ((TextView)paramView.findViewById(2131300305));
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).mZT = paramView.findViewById(2131303255);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).mZU = paramView.findViewById(2131303254);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).mZV = ((TextView)paramView.findViewById(2131303263));
        ((ViewGroup)localObject6).addView(paramView, ((ViewGroup)localObject6).getChildCount());
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).naw.add(localObject7);
        i += 1;
        break label628;
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).a((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1, ((com.tencent.mm.ai.v)((List)localObject3).get(0)).type, k);
        break label596;
        i = 0;
        while (i < ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).naw.size())
        {
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).naw.get(i)).mYI.setVisibility(8);
          i += 1;
        }
        label1107:
        label1115:
        int m;
        int j;
        label1217:
        label1247:
        boolean bool2;
        if (bool1)
        {
          if (((com.tencent.mm.ai.v)localObject4).type == 5) {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nay.a(k, (com.tencent.mm.ai.v)localObject4, locals, paramInt, (com.tencent.mm.ai.u)localObject2, locals.nah);
          }
        }
        else
        {
          if ((k <= 2) || (locals.field_isExpand)) {
            break label1751;
          }
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nau.setVisibility(0);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nav.setText(((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).mContext.getString(2131756641, new Object[] { Integer.valueOf(k - 2) }));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nau.setTag(locals);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nau.setOnClickListener(((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).naE);
          if (!bool1) {
            break label1764;
          }
          i = 1;
          if ((i >= k) || ((!locals.field_isExpand) && (i > 1))) {
            break label2529;
          }
          localObject5 = (com.tencent.mm.ai.v)((List)localObject3).get(i);
          m = locals.nah + i;
          com.tencent.mm.plugin.brandservice.ui.timeline.a.o.c((com.tencent.mm.ai.v)localObject5);
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).naw;
          if (!bool1) {
            break label1770;
          }
          j = i - 1;
          localObject6 = (com.tencent.mm.plugin.brandservice.ui.timeline.a.k)paramView.get(j);
          j = ((com.tencent.mm.ai.v)localObject4).type;
          if (i != 0) {
            break label1777;
          }
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).hIU.setVisibility(8);
          if (bool1) {
            break label2108;
          }
          if (i != 0) {
            break label2009;
          }
          if (k != 1) {
            break label1987;
          }
          com.tencent.mm.plugin.brandservice.ui.timeline.a.o.t(((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mZJ, mWF, mWC);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).a((com.tencent.mm.ai.v)localObject5, locals, i, false);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).a((com.tencent.mm.ai.v)localObject5, false);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).a(((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mZR, ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mZS, locals, (com.tencent.mm.ai.v)localObject5);
          if (!bt.isNullOrNil(((com.tencent.mm.ai.v)localObject5).title)) {
            break label2264;
          }
          paramView = com.tencent.mm.plugin.brandservice.b.b.mSC;
          switch (((com.tencent.mm.ai.v)localObject5).type)
          {
          case 6: 
          default: 
            paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).mContext.getResources().getString(2131756613);
            label1351:
            com.tencent.mm.plugin.brandservice.b.b.a(paramView, ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mZK, (com.tencent.mm.ai.v)localObject5, 1);
            label1363:
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mZK.setTextColor(com.tencent.mm.ui.ao.aD(((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).mContext, 2130968584));
            if ((((com.tencent.mm.ai.v)localObject5).gKG == 0) || (((com.tencent.mm.ai.v)localObject5).gKG == 1))
            {
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mZM.setVisibility(0);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mZK.setTextColor(com.tencent.mm.ui.ao.aD(((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).mContext, 2130968584));
              if (((com.tencent.mm.ai.v)localObject5).type == 7)
              {
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mZN.setVisibility(8);
                if ((bt.isNullOrNil(((com.tencent.mm.ai.v)localObject5).gKF)) || (((com.tencent.mm.ai.v)localObject5).type != 3)) {
                  break label2496;
                }
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mZL.setText(((com.tencent.mm.ai.v)localObject5).gKF);
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mZL.setVisibility(0);
                label1489:
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mYI.setVisibility(0);
                paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nao;
                localObject7 = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mYI;
                if (k <= 1) {
                  break label2509;
                }
                bool2 = true;
                label1520:
                paramView.a((com.tencent.mm.ai.v)localObject5, locals, paramInt, (com.tencent.mm.ai.u)localObject2, (View)localObject7, bool2, i);
                if ((i != k - 1) || (((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nau.getVisibility() == 0)) {
                  break label2515;
                }
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mYI.setBackgroundResource(2131231256);
              }
            }
            break;
          }
        }
        for (;;)
        {
          i += 1;
          break label1115;
          if (((com.tencent.mm.ai.v)localObject4).type == 8)
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).naA.a(k, (com.tencent.mm.ai.v)localObject4, locals, paramInt, (com.tencent.mm.ai.u)localObject2, locals.nah);
            break;
          }
          if (((com.tencent.mm.ai.v)localObject4).type == 7)
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).naB.a(k, (com.tencent.mm.ai.v)localObject4, locals, paramInt, (com.tencent.mm.ai.u)localObject2, locals.nah);
            break;
          }
          if (((com.tencent.mm.ai.v)localObject4).type == 6)
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).naC.a(k, (com.tencent.mm.ai.v)((List)localObject3).get(0), locals, paramInt, (com.tencent.mm.ai.u)localObject2, locals.nah);
            break;
          }
          if (((com.tencent.mm.ai.v)localObject4).type == 10)
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).naD.a(k, (com.tencent.mm.ai.v)localObject4, locals, paramInt, (com.tencent.mm.ai.u)localObject2, locals.nah);
            break;
          }
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nax.a(k, (com.tencent.mm.ai.v)localObject4, locals, paramInt, (com.tencent.mm.ai.u)localObject2, locals.nah);
          break;
          label1751:
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nau.setVisibility(8);
          break label1107;
          label1764:
          i = 0;
          break label1115;
          label1770:
          j = i;
          break label1182;
          label1777:
          if ((i == 1) && (bool1) && (j != 7) && (j != 5) && (j != 6)) {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).hIU.setVisibility(8);
          }
          for (;;)
          {
            if ((!bool1) || (i > 0))
            {
              paramView = (com.tencent.mm.ai.v)((List)localObject3).get(i - 1);
              localObject7 = (com.tencent.mm.ai.v)((List)localObject3).get(i);
              if (((paramView.type != 7) && (paramView.type != 5) && (paramView.type != 6) && (bt.isNullOrNil(paramView.gKD))) || ((((com.tencent.mm.ai.v)localObject7).type != 7) && (((com.tencent.mm.ai.v)localObject7).type != 5) && (((com.tencent.mm.ai.v)localObject7).type != 6) && (bt.isNullOrNil(((com.tencent.mm.ai.v)localObject7).gKD))))
              {
                com.tencent.mm.plugin.brandservice.ui.timeline.a.o.W(((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).hIU, mWH);
                break;
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).hIU.setVisibility(0);
                continue;
              }
              com.tencent.mm.plugin.brandservice.ui.timeline.a.o.W(((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).hIU, mWG);
              break;
            }
          }
          com.tencent.mm.plugin.brandservice.ui.timeline.a.o.W(((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).hIU, mWH);
          break label1217;
          label1987:
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mZJ;
          j = mWF;
          com.tencent.mm.plugin.brandservice.ui.timeline.a.o.t(paramView, j, j);
          break label1247;
          label2009:
          if (i == 1)
          {
            if (k == 2)
            {
              com.tencent.mm.plugin.brandservice.ui.timeline.a.o.t(((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mZJ, mWF, mWC);
              break label1247;
            }
            paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mZJ;
            j = mWF;
            com.tencent.mm.plugin.brandservice.ui.timeline.a.o.t(paramView, j, j);
            break label1247;
          }
          if (i == k - 1)
          {
            com.tencent.mm.plugin.brandservice.ui.timeline.a.o.t(((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mZJ, mWF, mWC);
            break label1247;
          }
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mZJ;
          j = mWF;
          com.tencent.mm.plugin.brandservice.ui.timeline.a.o.t(paramView, j, j);
          break label1247;
          label2108:
          if (i == 1)
          {
            if (i == k - 1)
            {
              paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mZJ;
              j = mWC;
              com.tencent.mm.plugin.brandservice.ui.timeline.a.o.t(paramView, j, j);
              break label1247;
            }
            com.tencent.mm.plugin.brandservice.ui.timeline.a.o.t(((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mZJ, mWC, mWF);
            break label1247;
          }
          if (i == k - 1)
          {
            com.tencent.mm.plugin.brandservice.ui.timeline.a.o.t(((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mZJ, mWF, mWC);
            break label1247;
          }
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mZJ;
          j = mWF;
          com.tencent.mm.plugin.brandservice.ui.timeline.a.o.t(paramView, j, j);
          break label1247;
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).mContext.getResources().getString(2131756623);
          break label1351;
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).mContext.getResources().getString(2131756624);
          break label1351;
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).mContext.getResources().getString(2131756614);
          break label1351;
          label2264:
          paramView = com.tencent.mm.plugin.brandservice.b.b.mSC;
          com.tencent.mm.plugin.brandservice.b.b.a(((com.tencent.mm.ai.v)localObject5).title, ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mZK, (com.tencent.mm.ai.v)localObject5, 1);
          break label1363;
          if (!bt.isNullOrNil(((com.tencent.mm.ai.v)localObject5).gKD))
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mZN.setVisibility(0);
            paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nao.mWO;
            long l = locals.field_msgId;
            localObject7 = com.tencent.mm.ai.m.a((com.tencent.mm.ai.v)localObject5);
            localObject8 = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mZN;
            j = mWB;
            paramView.a(l, i, (com.tencent.mm.ai.v)localObject5, (String)localObject7, (ImageView)localObject8, j, j, false, new o.2((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1, (com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6, (com.tencent.mm.ai.v)localObject5, locals, i), m, 2.0F);
            break label1447;
          }
          if ((((com.tencent.mm.ai.v)localObject5).type == 5) || (((com.tencent.mm.ai.v)localObject5).type == 6))
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mZN.setVisibility(0);
            paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nao.mWO;
            localObject7 = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mZN;
            j = mWB;
            paramView.a("2131231674", (ImageView)localObject7, j, j, m);
            break label1447;
          }
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mZM.setVisibility(8);
          break label1447;
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mZM.setVisibility(8);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mZK.setTextColor(com.tencent.mm.ui.ao.aD(((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).mContext, 2130968586));
          break label1447;
          label2496:
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mZL.setVisibility(8);
          break label1489;
          label2509:
          bool2 = false;
          break label1520;
          label2515:
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).mYI.setBackgroundResource(2131231262);
        }
        label2529:
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nao.a(paramInt, locals, ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).mZB, ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).mZA);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nao.a((n)localObject1, locals);
        paramView = paramViewGroup;
        break label180;
        if (paramView == null)
        {
          paramViewGroup = new q();
          paramView = paramViewGroup.a(this.mWy, this);
          paramView.setTag(paramViewGroup);
          localObject2 = paramViewGroup.mContext;
          localObject3 = locals.field_content;
          i = (int)paramViewGroup.naa.getTextSize();
          if (locals == null) {
            break label2951;
          }
          localObject1 = com.tencent.mm.model.y.tD(locals.field_msgSvrId);
          localObject4 = com.tencent.mm.model.y.arz().E((String)localObject1, true);
          ((y.b)localObject4).m("prePublishId", "msg_" + locals.field_msgSvrId);
          ((y.b)localObject4).m("preUsername", locals.field_talker);
          localObject1 = com.tencent.mm.pluginsdk.ui.span.k.a((Context)localObject2, (CharSequence)localObject3, i, 1, null, (String)localObject1);
          paramViewGroup.naa.setMaxLines(2147483647);
          paramViewGroup.naa.aq((CharSequence)localObject1);
          if (!locals.field_isExpand) {
            break label2957;
          }
          paramViewGroup.naO.setText(paramViewGroup.mContext.getString(2131756619));
          label2759:
          i = com.tencent.mm.cd.a.hV(paramViewGroup.mContext);
          j = com.tencent.mm.cd.a.fromDPToPix(paramViewGroup.mContext, 72);
          localObject1 = paramViewGroup.naa.ki(i - j, 2147483647);
          if (localObject1 == null) {
            break label5168;
          }
        }
        for (i = ((com.tencent.neattextview.textview.layout.a)localObject1).fkV();; i = 0)
        {
          if (i > 4)
          {
            if (!locals.field_isExpand) {
              paramViewGroup.naa.setMaxLines(4);
            }
            paramViewGroup.naO.setVisibility(0);
            if (locals.field_isExpand)
            {
              paramViewGroup.naO.setText(2131756619);
              paramViewGroup.naO.setOnClickListener(new q.1(paramViewGroup, locals));
              label2875:
              localObject1 = (LinearLayout.LayoutParams)paramViewGroup.naa.getLayoutParams();
              if (i > 4) {
                break label3012;
              }
            }
          }
          label3012:
          for (((LinearLayout.LayoutParams)localObject1).gravity = 17;; ((LinearLayout.LayoutParams)localObject1).gravity = 19)
          {
            paramViewGroup.naa.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            paramViewGroup.nao.a(paramViewGroup, locals);
            paramViewGroup.nao.a(paramInt, locals, paramViewGroup.mZB, paramViewGroup.mZA);
            break;
            paramViewGroup = (q)paramView.getTag();
            break label2594;
            localObject1 = null;
            break label2700;
            paramViewGroup.naO.setText(paramViewGroup.mContext.getString(2131756620));
            break label2759;
            paramViewGroup.naO.setText(2131756620);
            break label2858;
            paramViewGroup.naa.setMaxLines(2147483647);
            paramViewGroup.naO.setVisibility(8);
            break label2875;
          }
          if (paramView == null)
          {
            paramViewGroup = new z();
            paramView = paramViewGroup.a(this.mWy, this);
            paramView.setTag(paramViewGroup);
            label3049:
            locals.Fep = com.tencent.mm.plugin.brandservice.ui.b.a.f(locals);
            if (!locals.Fep) {
              break label3390;
            }
            paramViewGroup.nal.setVisibility(0);
            paramViewGroup.nam.setVisibility(8);
            localObject2 = paramViewGroup.naa;
            localObject1 = paramViewGroup.mZQ;
            localObject3 = new com.tencent.mm.modelvoice.p(locals.field_content);
            ((MMNeat7extView)localObject2).aq(com.tencent.mm.pluginsdk.g.h.formatTime("yyyy/MM/dd", System.currentTimeMillis() / 1000L));
            if (locals.Fep)
            {
              localObject2 = com.tencent.mm.ai.m.mV((int)(((com.tencent.mm.modelvoice.p)localObject3).time / 1000L));
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                break label3463;
              }
              paramViewGroup.nbm.setVisibility(0);
              paramViewGroup.nbm.setText((CharSequence)localObject2);
              label3176:
              paramViewGroup.naN.setOnClickListener(new z.2(paramViewGroup));
              paramViewGroup.naN.setBackgroundResource(2131231692);
              localObject2 = paramViewGroup.naN;
              i = mWD;
              j = mWC;
              k = mWD;
              ((View)localObject2).setPadding(i, j, k, k);
            }
            localObject2 = ((ImageView)localObject1).getDrawable();
            if (((localObject2 instanceof AnimationDrawable)) && (((AnimationDrawable)localObject2).isRunning())) {
              ((AnimationDrawable)localObject2).stop();
            }
            if ((!paramViewGroup.nao.mWU.isPlaying()) || (locals.field_msgId != paramViewGroup.nao.mWU.mYw)) {
              break label3475;
            }
            ((ImageView)localObject1).setImageResource(2131231676);
            if ((((ImageView)localObject1).getDrawable() instanceof AnimationDrawable)) {
              ((AnimationDrawable)((ImageView)localObject1).getDrawable()).start();
            }
          }
          for (;;)
          {
            ((ImageView)localObject1).setOnClickListener(new z.3(paramViewGroup, locals, (ImageView)localObject1));
            paramViewGroup.nao.a(paramViewGroup, locals);
            paramViewGroup.nao.a(paramInt, locals, paramViewGroup.mZB, paramViewGroup.mZA);
            break;
            paramViewGroup = (z)paramView.getTag();
            break label3049;
            label3390:
            paramViewGroup.hIU.setVisibility(8);
            paramViewGroup.nal.setVisibility(8);
            paramViewGroup.nam.setVisibility(0);
            paramViewGroup.nbp.setVisibility(8);
            paramViewGroup.nbo.setVisibility(0);
            localObject2 = paramViewGroup.nbq;
            localObject1 = paramViewGroup.nbo;
            paramViewGroup.nam.setOnClickListener(new z.1(paramViewGroup));
            break label3096;
            paramViewGroup.nbm.setVisibility(8);
            break label3176;
            ((ImageView)localObject1).setImageResource(2131231675);
          }
          if (paramView == null)
          {
            paramViewGroup = new com.tencent.mm.plugin.brandservice.ui.timeline.a.m();
            paramView = paramViewGroup.a(this.mWy, this);
            paramView.setTag(paramViewGroup);
          }
          for (;;)
          {
            if (this.mWW == null) {
              this.mWW = new d(this.mWy);
            }
            localObject1 = this.mWW;
            paramViewGroup.nao.a(paramViewGroup, locals);
            paramViewGroup.nao.a(paramInt, locals, paramViewGroup.mZB, paramViewGroup.mZA);
            locals.Fep = com.tencent.mm.plugin.brandservice.ui.b.a.f(locals);
            if (!locals.Fep) {
              break label3666;
            }
            paramViewGroup.nam.setVisibility(8);
            paramViewGroup.nal.setVisibility(0);
            paramViewGroup.dA(paramViewGroup.naj);
            paramViewGroup.dA(paramViewGroup.nai);
            ((d)localObject1).a(locals, paramInt, paramViewGroup.nai, mWz);
            paramViewGroup.naj.setOnClickListener(new m.1(paramViewGroup, locals));
            break;
            paramViewGroup = (com.tencent.mm.plugin.brandservice.ui.timeline.a.m)paramView.getTag();
          }
          label3666:
          paramViewGroup.nam.setVisibility(0);
          paramViewGroup.nal.setVisibility(8);
          paramViewGroup.hIU.setVisibility(8);
          paramViewGroup.naa.aq(paramViewGroup.mContext.getText(2131756612));
          ((d)localObject1).a(locals, paramInt, paramViewGroup.nak, 0);
          paramViewGroup.nam.setOnClickListener(new m.2(paramViewGroup, locals));
          break label180;
          if (!this.mWV) {
            com.tencent.mm.plugin.brandservice.ui.b.c.i(locals);
          }
          if (paramView == null)
          {
            paramViewGroup = new com.tencent.mm.plugin.brandservice.ui.timeline.a.h(this.mWy, this);
            paramView = paramViewGroup.mZz;
            paramView.setTag(paramViewGroup);
          }
          for (;;)
          {
            d.g.b.k.h(locals, "info");
            d.g.b.k.h(paramView, "convertView");
            if (locals.eJS() != null) {
              break label3831;
            }
            paramViewGroup.bCZ();
            ad.i("MicroMsg.BizTLRecCardNew", "[TRACE_BIZRECCARD] info null");
            break;
            paramViewGroup = (com.tencent.mm.plugin.brandservice.ui.timeline.a.h)paramView.getTag();
          }
          label3831:
          if (!com.tencent.mm.plugin.brandservice.ui.timeline.a.d.xC(locals.Fes.style))
          {
            paramViewGroup.bCZ();
            ad.i("MicroMsg.BizTLRecCardNew", "[TRACE_BIZRECCARD] style = " + locals.Fes.style + " not support");
            break label180;
          }
          localObject1 = locals.Fes;
          d.g.b.k.g(localObject1, "info.wrapper");
          if (!com.tencent.mm.plugin.brandservice.ui.timeline.a.d.a((dau)localObject1))
          {
            paramViewGroup.bCZ();
            ad.i("MicroMsg.BizTLRecCardNew", "[TRACE_BIZRECCARD] wrapper illegal");
            break label180;
          }
          i = com.tencent.mm.plugin.brandservice.ui.timeline.a.h.xT(locals.Fes.style);
          ad.i("MicroMsg.BizTLRecCardNew", "[TRACE_BIZRECCARD] filling style = " + locals.Fes.style + ", clientShowType = " + i);
          paramViewGroup.mXW.a(paramInt, locals, (View)paramViewGroup.mZB, (View)paramViewGroup.mZA);
          switch (i)
          {
          default: 
            break;
          case 1: 
            localObject1 = paramViewGroup.mZy;
            localObject2 = paramViewGroup.mZz;
            com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1149L, 2L, 1L, false);
            localObject3 = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mContext;
            if (((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mYI == null)
            {
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mYI = ((ViewStub)((View)localObject2).findViewById(2131307258)).inflate();
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).bDa();
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mZi = ((TextView)((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mYI.findViewById(2131297298));
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mZj = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mYI.findViewById(2131298374);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mZk = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mYI.findViewById(2131298373);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mZl = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mYI.findViewById(2131297296);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mZm = ((TextView)((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mYI.findViewById(2131297297));
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mZn = ((MMNeat7extView)((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mYI.findViewById(2131297294));
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).hIU = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mYI.findViewById(2131297295);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mZE = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mYI.findViewById(2131297291);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mZF = ((TextView)((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mYI.findViewById(2131297292));
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mZG = ((MMNeat7extView)((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mYI.findViewById(2131297293));
              ((WeImageView)((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mYI.findViewById(2131302669)).setIconColor(((Context)localObject3).getResources().getColor(2131099664));
            }
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mYI.setVisibility(0);
            localObject2 = locals.eJR();
            if ((localObject2 == null) || (((dap)localObject2).Esm == null)) {
              paramView.setVisibility(8);
            }
            for (;;)
            {
              paramViewGroup.mZx.hide();
              paramViewGroup.mZw.hide();
              break;
              paramView.setVisibility(0);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mZi.setText(((dap)localObject2).Esl);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mZh.getPaint().setFakeBoldText(true);
              localObject3 = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).frr;
              localObject4 = ((dap)localObject2).Esm.Esv;
              localObject5 = new c.a();
              ((c.a)localObject5).hki = 2131231342;
              ((c.a)localObject5).hjT = true;
              ((c.a)localObject5).gkG = true;
              com.tencent.mm.aw.o.ayJ().a((String)localObject4, (ImageView)localObject3, ((c.a)localObject5).azc());
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mZh.setText(((dap)localObject2).Esm.mBV);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mZm.setText(((dap)localObject2).Esm.Esu);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mZn.aq(((dap)localObject2).Esm.ijP);
              localObject3 = ((dap)localObject2).Esm.mAQ;
              localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY((String)localObject3);
              if ((localObject4 == null) || ((int)((com.tencent.mm.n.b)localObject4).fId <= 0)) {
                ar.a.gMW.a((String)localObject3, "", null);
              }
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mZl.setOnClickListener(new i.1((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1, (String)localObject3, locals));
              if ((((dap)localObject2).Eso != null) && (((dap)localObject2).Eso.get(0) != null) && ((((daq)((dap)localObject2).Eso.get(0)).Cxm & 0x1) == 0))
              {
                localObject3 = (daq)((dap)localObject2).Eso.get(0);
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mZE.setVisibility(0);
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).hIU.setVisibility(0);
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mZF.setText(((dap)localObject2).Esn);
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mZG.aq(((daq)localObject3).Title);
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mZE.setOnClickListener(new i.2((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1, locals, (daq)localObject3));
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mZl.setBackgroundResource(2131231262);
                if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).xA(1)) && (!bt.isNullOrNil(((daq)localObject3).CHL)))
                {
                  ad.d("MicroMsg.BizTimeLineItem", "preload %s", new Object[] { ((daq)localObject3).CHL });
                  ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(((daq)localObject3).CHL, ((daq)localObject3).gKq, 90, new Object[0]);
                }
                com.tencent.mm.plugin.brandservice.ui.b.c.h(locals);
                localObject3 = locals.eJS();
                if (localObject3 == null) {
                  continue;
                }
                localObject4 = ((dap)localObject2).Esr;
                if (localObject4 != null) {
                  break label4928;
                }
                ad.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo = null");
                i = 0;
              }
              for (;;)
              {
                if ((i != 0) || (!bt.gL(((dau)localObject3).EsB))) {
                  break label5013;
                }
                ad.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] hideNegativeFeedback，BizNickName = %s", new Object[] { ((dap)localObject2).Esm.mBV });
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mZj.setVisibility(8);
                break;
                com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(1149L, 6L, 1L, false);
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).hIU.setVisibility(8);
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mZE.setVisibility(8);
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mZl.setBackgroundResource(2131231256);
                break label4786;
                if (((dat)localObject4).Esy == null)
                {
                  ad.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo = null");
                  i = 0;
                }
                else if (((dat)localObject4).Esy.Dka != 1)
                {
                  ad.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.ShowNegativeFeedbackReason != 1");
                  i = 0;
                }
                else if (bt.gL(((dat)localObject4).Esy.DjZ))
                {
                  ad.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.NegativeFeedbackReason null");
                  i = 0;
                }
                else
                {
                  i = 1;
                }
              }
              ad.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] showNegativeFeedback，BizNickName = %s", new Object[] { ((dap)localObject2).Esm.mBV });
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mZj.setVisibility(0);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mZj.setOnClickListener(new i.3((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1, locals, paramInt));
            }
          case 2: 
            paramViewGroup.mZw.a(locals, paramInt, paramView, paramViewGroup.mZz);
            paramViewGroup.mZx.hide();
            paramViewGroup.mZy.hide();
            break;
          case 3: 
            label4928:
            paramViewGroup.mZw.hide();
            paramViewGroup.mZx.a(locals, paramInt, paramView, paramViewGroup.mZz);
            paramViewGroup.mZy.hide();
            break;
            paramViewGroup.mYI = View.inflate(paramView, 2131493230, null);
            paramViewGroup.bDa();
            paramView = paramViewGroup.mYI;
            break label153;
            paramViewGroup = (com.tencent.mm.plugin.brandservice.ui.timeline.a.y)paramView.getTag();
            break label158;
          }
        }
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 6;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(5885);
    if (super.isEmpty())
    {
      if (com.tencent.mm.am.af.awl().bIR() > 0)
      {
        AppMethodBeat.o(5885);
        return false;
      }
      dbw localdbw = com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e.bDe();
      if ((localdbw != null) && (!bt.gL(localdbw.Etz))) {}
      for (int i = 0; i == 0; i = 1)
      {
        AppMethodBeat.o(5885);
        return false;
      }
    }
    boolean bool = super.isEmpty();
    AppMethodBeat.o(5885);
    return bool;
  }
  
  public final void notifyDataSetChanged()
  {
    AppMethodBeat.i(5879);
    super.notifyDataSetChanged();
    AppMethodBeat.o(5879);
  }
  
  public final void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(5878);
    AppMethodBeat.o(5878);
  }
  
  public final s xP(int paramInt)
  {
    AppMethodBeat.i(5869);
    if ((paramInt < this.lEL.size()) && (paramInt >= 0))
    {
      s locals = (s)this.lEL.get(paramInt);
      AppMethodBeat.o(5869);
      return locals;
    }
    AppMethodBeat.o(5869);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.c
 * JD-Core Version:    0.7.0.1
 */
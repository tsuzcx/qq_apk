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
import com.tencent.mm.ai.u;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCardCanvasView;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.aa.2;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.ab;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.ac;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.ac.1;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.af;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.ah;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.ai;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.aj;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.ak;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.al;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.al.1;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.al.2;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.al.3;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.k.a;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.m.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.m.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.m.f;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.n;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.r;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.s;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.t;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.t.1;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.t.2;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.t.3;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.y.1;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.y.2;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.aig;
import com.tencent.mm.protocal.protobuf.aky;
import com.tencent.mm.protocal.protobuf.crs;
import com.tencent.mm.protocal.protobuf.dlo;
import com.tencent.mm.protocal.protobuf.dlp;
import com.tencent.mm.protocal.protobuf.dlq;
import com.tencent.mm.protocal.protobuf.dls;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.protocal.protobuf.dmx;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.ok;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.x;
import com.tencent.mm.storage.x.a;
import com.tencent.mm.storage.x.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.ao;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public final class b
  extends BaseAdapter
  implements View.OnCreateContextMenuListener
{
  public static int oad = 0;
  public static int oae = 0;
  public static int oaf;
  public static int oag = 0;
  public static int oah = 0;
  public static int oai = 0;
  public static int oaj = 0;
  public static int oak;
  public static int oal;
  public static int oam;
  public static int oan;
  public static int oao;
  private static Long oau = null;
  private static Long oav = null;
  private static Long oaw = null;
  boolean dtm;
  public List<com.tencent.mm.storage.w> mHf;
  x.c nVS;
  private c oaA;
  public g oaB;
  private Set<String> oaC;
  public Set<com.tencent.mm.ai.v> oaD;
  private View.OnClickListener oaE;
  private j oaF;
  boolean oaG;
  private BizTimeLineUI oac;
  public com.tencent.mm.storage.w oap;
  public int oaq;
  public BizTimeLineHotView oar;
  public com.tencent.mm.plugin.brandservice.ui.timeline.preload.c oas;
  private ab oat;
  private long oax;
  public h oay;
  boolean oaz;
  
  public b(BizTimeLineUI paramBizTimeLineUI, List<com.tencent.mm.storage.w> paramList, boolean paramBoolean, g paramg, BizTimeLineHotView paramBizTimeLineHotView)
  {
    AppMethodBeat.i(5865);
    this.mHf = new LinkedList();
    this.dtm = false;
    this.oax = -1L;
    this.oaz = false;
    this.oaC = new HashSet();
    this.oaD = new HashSet();
    this.nVS = new x.c()
    {
      public final void a(final Object paramAnonymousObject, final x.a paramAnonymousa)
      {
        AppMethodBeat.i(5855);
        if ((paramAnonymousa != null) && (paramAnonymousa.IoH))
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
            if ((b.a(b.this) == null) || (b.a(b.this).isFinishing()))
            {
              AppMethodBeat.o(5854);
              return false;
            }
            b.a(b.this, paramAnonymousa);
            AppMethodBeat.o(5854);
            return false;
          }
        });
        AppMethodBeat.o(5855);
      }
    };
    this.oaE = new b.10(this);
    this.oaF = new j()
    {
      public final void a(com.tencent.mm.storage.w paramAnonymousw, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(175422);
        b.this.oaB.a(paramAnonymousw, paramAnonymousInt1, paramAnonymousInt2);
        b.this.oar.i(paramAnonymousw);
        AppMethodBeat.o(175422);
      }
    };
    this.oaG = false;
    this.oac = paramBizTimeLineUI;
    this.oar = paramBizTimeLineHotView;
    this.oaB = paramg;
    int i;
    int j;
    if (oad == 0)
    {
      oaf = paramBizTimeLineUI.getResources().getDimensionPixelSize(2131165905);
      oag = paramBizTimeLineUI.getResources().getDimensionPixelSize(2131165900);
      oah = paramBizTimeLineUI.getResources().getDimensionPixelSize(2131165480);
      oai = paramBizTimeLineUI.getResources().getDimensionPixelSize(2131165500);
      oak = paramBizTimeLineUI.getResources().getDimensionPixelSize(2131165909);
      oal = paramBizTimeLineUI.getResources().getDimensionPixelOffset(2131165480);
      oaj = paramBizTimeLineUI.getResources().getDimensionPixelOffset(2131165516);
      oam = com.tencent.mm.cc.a.fromDPToPix(this.oac, 2);
      oao = com.tencent.mm.cc.a.fromDPToPix(this.oac, 40);
      oan = com.tencent.mm.cc.a.fromDPToPix(this.oac, 8);
      i = com.tencent.mm.cc.a.ip(paramBizTimeLineUI);
      j = com.tencent.mm.cc.a.iq(paramBizTimeLineUI);
      if (i >= j) {
        break label388;
      }
    }
    for (;;)
    {
      oad = (int)((i - (int)(com.tencent.mm.cc.a.getDensity(paramBizTimeLineUI) * 16.0F)) / 2.35F);
      oae = (int)((i - (int)(com.tencent.mm.cc.a.getDensity(paramBizTimeLineUI) * 16.0F)) / 1.777778F);
      com.tencent.mm.am.ag.aGf().a(this.nVS, Looper.getMainLooper());
      ck(paramList);
      cl(paramList);
      this.oay = new h(this);
      this.oaz = paramBoolean;
      bOi();
      this.oas = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.c(paramBizTimeLineUI, oad, oaf, this.mHf);
      this.oat = new ab(this, paramBizTimeLineUI);
      com.tencent.mm.plugin.brandservice.ui.timeline.item.j.bOC();
      AppMethodBeat.o(5865);
      return;
      label388:
      i = j;
    }
  }
  
  private void a(int paramInt, com.tencent.mm.storage.w paramw, View paramView1, View paramView2)
  {
    AppMethodBeat.i(5875);
    if (paramInt > 0)
    {
      paramView1.setVisibility(0);
      if (a(paramw, paramInt))
      {
        paramView2.setVisibility(0);
        ((TextView)paramView2.findViewById(2131297357)).setText(this.oac.getString(2131756615));
      }
    }
    for (;;)
    {
      b(paramw);
      AppMethodBeat.o(5875);
      return;
      paramView2.setVisibility(8);
      paramView1.setMinimumHeight(oah);
      continue;
      paramView1.setMinimumHeight(this.oac.getResources().getDimensionPixelSize(2131165187));
      paramView1.setVisibility(0);
      paramView2.setVisibility(8);
    }
  }
  
  private void a(com.tencent.mm.plugin.brandservice.ui.timeline.item.z paramz, final com.tencent.mm.storage.w paramw)
  {
    AppMethodBeat.i(5877);
    a.b.d(paramz.fOf, paramw.field_talker);
    Object localObject1 = com.tencent.mm.model.v.zf(paramw.field_talker);
    Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(paramw.field_talker);
    if ((localObject2 != null) && (((am)localObject2).adq()))
    {
      localObject2 = this.oac.getResources().getDrawable(2131231289);
      int i = (int)paramz.odU.getTextSize();
      ((Drawable)localObject2).setBounds(0, 0, i, i);
      localObject2 = new com.tencent.mm.ui.widget.a((Drawable)localObject2);
      SpannableString localSpannableString = new SpannableString("@");
      localSpannableString.setSpan(localObject2, 0, 1, 33);
      paramz.odU.setText(TextUtils.concat(new CharSequence[] { com.tencent.mm.pluginsdk.ui.span.k.b(this.oac, (CharSequence)localObject1, paramz.odU.getTextSize()) + "  ", localSpannableString }));
    }
    for (;;)
    {
      localObject1 = d.osr;
      d.i(paramz.odU);
      paramz.ofn.setTag(paramw);
      paramz.ofn.setOnClickListener(this.oaE);
      if (!com.tencent.mm.storage.y.fpF()) {
        break;
      }
      paramz.fTP.setVisibility(0);
      paramz.ofo.setVisibility(8);
      paramz.fTP.setText(com.tencent.mm.plugin.brandservice.ui.b.b.f(this.oac, paramw.field_createTime));
      paramz.ofn.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(175418);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahq());
          b.this.oap = paramw;
          b.this.oaB.d(b.this.oap, 20);
          b.this.bOj();
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(175418);
          return false;
        }
      });
      AppMethodBeat.o(5877);
      return;
      paramz.odU.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.oac, (CharSequence)localObject1, paramz.odU.getTextSize()));
    }
    paramz.fTP.setVisibility(8);
    paramz.ofo.setVisibility(0);
    paramz.ofn.setOnLongClickListener(null);
    paramz.ofo.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(175419);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        b.this.oap = paramw;
        b.this.oaB.d(b.this.oap, 19);
        b.this.bOj();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(175419);
      }
    });
    com.tencent.mm.ui.tools.o.gU(paramz.ofo);
    AppMethodBeat.o(5877);
  }
  
  private static boolean a(com.tencent.mm.storage.w paramw)
  {
    return (paramw == null) || (paramw.field_type == 34) || (paramw.field_type == 3);
  }
  
  private boolean a(com.tencent.mm.storage.w paramw, int paramInt)
  {
    AppMethodBeat.i(5874);
    if (oau != null)
    {
      if (oau.longValue() == paramw.field_orderFlag)
      {
        AppMethodBeat.o(5874);
        return true;
      }
      AppMethodBeat.o(5874);
      return false;
    }
    long l2 = paramw.fpb();
    long l1 = 0L;
    com.tencent.mm.storage.w localw = zq(paramInt - 1);
    if (localw != null) {
      l1 = localw.fpb();
    }
    if ((l2 != l1) && (oaw != null) && (l1 == oaw.longValue()))
    {
      oau = Long.valueOf(paramw.field_orderFlag);
      AppMethodBeat.o(5874);
      return true;
    }
    AppMethodBeat.o(5874);
    return false;
  }
  
  private void bOi()
  {
    AppMethodBeat.i(5866);
    bOm();
    if (this.oaz)
    {
      Object localObject = bOl();
      if ((localObject != null) && (!((com.tencent.mm.storage.w)localObject).fpj()))
      {
        localObject = this.mHf.iterator();
        com.tencent.mm.storage.w localw;
        for (long l = -1L; ((Iterator)localObject).hasNext(); l = localw.fpb())
        {
          localw = (com.tencent.mm.storage.w)((Iterator)localObject).next();
          if ((l != -1L) && (l != localw.fpb()))
          {
            oau = Long.valueOf(localw.field_orderFlag);
            AppMethodBeat.o(5866);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(5866);
  }
  
  private void bOn()
  {
    com.tencent.mm.storage.w localw = null;
    AppMethodBeat.i(5886);
    Cursor localCursor = com.tencent.mm.am.ag.aGf().hHS.a("SELECT * FROM BizTimeLineInfo order by orderFlag asc limit 1", null, 0);
    if (localCursor.moveToFirst())
    {
      localw = new com.tencent.mm.storage.w();
      localw.convertFrom(localCursor);
    }
    localCursor.close();
    if (localw != null) {
      this.oax = localw.fpb();
    }
    AppMethodBeat.o(5886);
  }
  
  private static void cj(List<com.tencent.mm.storage.w> paramList)
  {
    AppMethodBeat.i(5867);
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(5867);
      return;
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.BizTimeLineAdapter", "alvinluo doUpdateListCellPosition list: %d", new Object[] { Integer.valueOf(paramList.size()) });
    long l = System.currentTimeMillis();
    Object localObject = (com.tencent.mm.storage.w)paramList.get(0);
    ((com.tencent.mm.storage.w)localObject).ofe = 1;
    int j = 1;
    int k = 1;
    if (j < paramList.size())
    {
      com.tencent.mm.storage.w localw = (com.tencent.mm.storage.w)paramList.get(j);
      int i;
      switch (((com.tencent.mm.storage.w)localObject).field_type)
      {
      default: 
        i = 1;
      }
      for (;;)
      {
        k += i;
        localw.ofe = k;
        j += 1;
        localObject = localw;
        break;
        int m = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).b(((com.tencent.mm.storage.w)localObject).field_msgId, ((com.tencent.mm.storage.w)localObject).field_content);
        i = m;
        if (!((com.tencent.mm.storage.w)localObject).field_isExpand)
        {
          i = Math.min(m, 2);
          continue;
          i = 1;
        }
      }
    }
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.BizTimeLineAdapter", "alvinluo doUpdateListCellPosition cost: %d, startCellPosition: %d, size: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(1), Integer.valueOf(paramList.size()) });
    AppMethodBeat.o(5867);
  }
  
  public static void cl(List<com.tencent.mm.storage.w> paramList)
  {
    AppMethodBeat.i(5883);
    com.tencent.mm.pluginsdk.ui.applet.g localg = com.tencent.mm.pluginsdk.ui.applet.g.EVk;
    if (com.tencent.mm.pluginsdk.ui.applet.g.YP(1)) {
      cj(paramList);
    }
    AppMethodBeat.o(5883);
  }
  
  public final void Xf(String paramString)
  {
    AppMethodBeat.i(5872);
    com.tencent.mm.kernel.g.ajD();
    if ((com.tencent.mm.kernel.a.mN(com.tencent.mm.kernel.g.ajA().gAx)) && (!this.oaC.contains(paramString)))
    {
      com.tencent.mm.modelsimple.aa.aq(paramString, 2);
      this.oaC.add(paramString);
    }
    AppMethodBeat.o(5872);
  }
  
  public final void a(com.tencent.mm.ai.v paramv, com.tencent.mm.storage.w paramw, int paramInt1, u paramu, View paramView, boolean paramBoolean, int paramInt2)
  {
    AppMethodBeat.i(5876);
    ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a(paramv, paramw, paramInt1, paramu, paramView, paramBoolean, paramInt2, this.oaF);
    if ((paramv.type == 5) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bNg())) {
      paramView.setOnClickListener(new b.6(this, paramw, paramInt2));
    }
    AppMethodBeat.o(5876);
  }
  
  public final void b(com.tencent.mm.storage.w paramw)
  {
    AppMethodBeat.i(5873);
    if (paramw == null)
    {
      com.tencent.mm.sdk.platformtools.ad.w("MicroMsg.BizTimeLineAdapter", "updateGroupId info is null");
      AppMethodBeat.o(5873);
      return;
    }
    final long l1 = paramw.fpb();
    long l2 = com.tencent.mm.am.ag.aGf().fpt();
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.BizTimeLineAdapter", "updateGroupId keep %b, groupId %d, maxGroupId %d", new Object[] { Boolean.valueOf(this.oaz), Long.valueOf(l1), Long.valueOf(l2) });
    if ((!this.oaz) && (l1 == l2))
    {
      l1 = paramw.field_orderFlag;
      com.tencent.mm.cn.g.er(Long.valueOf(l1)).h(new com.tencent.mm.vending.c.a() {}).b(new com.tencent.mm.vending.c.a() {});
    }
    AppMethodBeat.o(5873);
  }
  
  public final void b(com.tencent.mm.storage.w paramw, int paramInt)
  {
    AppMethodBeat.i(209496);
    this.oaB.a(paramw, paramInt, (int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(209496);
  }
  
  public final void bOj()
  {
    AppMethodBeat.i(209495);
    com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(this.oac, 1, false);
    locale.KJy = new n.d()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(175420);
        am localam = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf(b.this.oap.field_talker);
        paramAnonymousl.jI(10, 2131756602);
        if ((localam != null) && (com.tencent.mm.o.b.lM(localam.field_type))) {
          paramAnonymousl.a(2, b.a(b.this).getResources().getColor(2131099803), b.a(b.this).getString(2131761049));
        }
        AppMethodBeat.o(175420);
      }
    };
    locale.KJz = this.oat;
    locale.cMW();
    AppMethodBeat.o(209495);
  }
  
  public final com.tencent.mm.storage.w bOk()
  {
    AppMethodBeat.i(5880);
    if (this.mHf.size() > 0)
    {
      com.tencent.mm.storage.w localw = (com.tencent.mm.storage.w)this.mHf.get(this.mHf.size() - 1);
      AppMethodBeat.o(5880);
      return localw;
    }
    AppMethodBeat.o(5880);
    return null;
  }
  
  public final com.tencent.mm.storage.w bOl()
  {
    AppMethodBeat.i(5881);
    if (this.mHf.size() > 0)
    {
      com.tencent.mm.storage.w localw = (com.tencent.mm.storage.w)this.mHf.get(0);
      AppMethodBeat.o(5881);
      return localw;
    }
    AppMethodBeat.o(5881);
    return null;
  }
  
  public final void bOm()
  {
    AppMethodBeat.i(5884);
    com.tencent.mm.storage.w localw = bOl();
    if (localw != null) {
      oaw = Long.valueOf(localw.fpb());
    }
    oau = null;
    oav = null;
    AppMethodBeat.o(5884);
  }
  
  final void ck(List<com.tencent.mm.storage.w> paramList)
  {
    AppMethodBeat.i(5882);
    com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.BizTimeLineAdapter", "alvinluo filterAndAddList size: %d", new Object[] { Integer.valueOf(paramList.size()) });
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      if (!a((com.tencent.mm.storage.w)paramList.get(i))) {
        localLinkedList.add(paramList.get(i));
      }
      i += 1;
    }
    this.mHf.addAll(localLinkedList);
    AppMethodBeat.o(5882);
  }
  
  public final void eO(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5887);
    ArrayList localArrayList = new ArrayList();
    if (paramInt1 <= paramInt2)
    {
      Object localObject = zq(paramInt1);
      long l;
      String str;
      if ((localObject != null) && (((com.tencent.mm.storage.w)localObject).field_type == 285212721))
      {
        com.tencent.mm.sdk.platformtools.ad.v("MicroMsg.BizTimeLineAdapter", "terry checkpreload:" + ((com.tencent.mm.storage.w)localObject).field_msgId);
        l = ((com.tencent.mm.storage.w)localObject).field_msgId;
        str = ((com.tencent.mm.storage.w)localObject).field_content;
        if (!((com.tencent.mm.storage.w)localObject).field_isExpand) {
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
      ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).k(localArrayList, 90);
    }
    AppMethodBeat.o(5887);
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(5868);
    int i = this.mHf.size();
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
    com.tencent.mm.storage.w localw = zq(paramInt);
    if (localw == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.BizTimeLineAdapter", "getItemViewType info is null");
      AppMethodBeat.o(5870);
      return 0;
    }
    switch (localw.field_type)
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
    case 620757041: 
      AppMethodBeat.o(5870);
      return 5;
    }
    AppMethodBeat.o(5870);
    return 6;
  }
  
  public final View getView(final int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(5871);
    com.tencent.mm.storage.w localw = zq(paramInt);
    if (localw == null)
    {
      com.tencent.mm.sdk.platformtools.ad.e("MicroMsg.BizTimeLineAdapter", "getView info is null");
      AppMethodBeat.o(5871);
      return paramView;
    }
    if ((paramInt == getCount() - 1) && (!this.oaG)) {
      aq.o(new Runnable()
      {
        public final void run()
        {
          int j = 0;
          AppMethodBeat.i(5856);
          if ((paramInt == b.this.getCount() - 1) && (!b.this.oaG))
          {
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BizTimeLineAdapter", "loadMoreData %d/%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(b.this.getCount()) });
            b localb = b.this;
            Object localObject = localb.bOk();
            int i = j;
            if (localObject != null)
            {
              localObject = com.tencent.mm.am.ag.aGf().aP(10, ((com.tencent.mm.storage.w)localObject).field_orderFlag);
              localb.ck((List)localObject);
              com.tencent.mm.plugin.brandservice.ui.b.c.a((List)localObject, new b.3(localb));
              localb.notifyDataSetChanged();
              i = j;
              if (((List)localObject).size() > 0) {
                i = 1;
              }
            }
            if (i == 0)
            {
              b.this.oaG = true;
              b.a(b.this).bOq();
              AppMethodBeat.o(5856);
              return;
            }
            b.this.oas.Zt();
          }
          AppMethodBeat.o(5856);
        }
      }, 300L);
    }
    label161:
    label166:
    label188:
    Object localObject1;
    Object localObject2;
    Object localObject3;
    int k;
    Object localObject4;
    boolean bool1;
    switch (localw.field_type)
    {
    default: 
      if (paramView == null)
      {
        paramViewGroup = new ak();
        paramView = this.oac;
        if (paramViewGroup.odh != null)
        {
          paramView = paramViewGroup.odh;
          paramView.setTag(paramViewGroup);
          a(paramViewGroup, localw);
          a(paramInt, localw, paramViewGroup.oeI, paramViewGroup.oeH);
        }
      }
      break;
    case 285212721: 
      for (;;)
      {
        if ((!this.oaz) && (!this.dtm))
        {
          this.oaB.c(localw, paramInt);
          Xf(localw.field_talker);
        }
        AppMethodBeat.o(5871);
        return paramView;
        if (!this.oaz) {
          com.tencent.mm.plugin.brandservice.ui.b.c.k(localw);
        }
        if (paramView == null)
        {
          localObject1 = new com.tencent.mm.plugin.brandservice.ui.timeline.item.aa();
          paramViewGroup = View.inflate(this.oac, 2131493210, null);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).ofq = ((LinearLayout)paramViewGroup.findViewById(2131297332));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).ofr = ((LinearLayout)paramViewGroup.findViewById(2131304785));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).ofs = ((TextView)paramViewGroup.findViewById(2131304786));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).oeH = ((LinearLayout)paramViewGroup.findViewById(2131297356));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).oeI = ((LinearLayout)paramViewGroup.findViewById(2131297346));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).odh = paramViewGroup;
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).bOL();
          paramViewGroup.setTag(localObject1);
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).b(this.oac, this);
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).oft.iterator();
          while (paramView.hasNext())
          {
            localObject2 = (com.tencent.mm.plugin.brandservice.ui.timeline.item.w)paramView.next();
            ao.aC(((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject2).odh, 3);
            ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).ofq.removeView(((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject2).odh);
          }
          localObject1 = (com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)paramView.getTag();
          paramViewGroup = paramView;
        }
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).oft.clear();
        localObject2 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(localw.field_msgId, localw.field_content);
        localObject3 = ((u)localObject2).hDb;
        k = ((List)localObject3).size();
        if (k != 0) {
          break;
        }
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).ofq.setVisibility(8);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).a((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1, -1, 0);
        paramView = paramViewGroup;
      }
      ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).ofq.setVisibility(0);
      localObject4 = (com.tencent.mm.ai.v)((List)localObject3).get(0);
      com.tencent.mm.plugin.brandservice.ui.timeline.item.aa.c((com.tencent.mm.ai.v)localObject4);
      bool1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.a(localw, (com.tencent.mm.ai.v)localObject4);
      if (bool1) {
        if ((bt.isNullOrNil(((com.tencent.mm.ai.v)localObject4).hDm)) && (((com.tencent.mm.ai.v)localObject4).type != 7) && (((com.tencent.mm.ai.v)localObject4).type != 10)) {
          bool1 = false;
        }
      }
      break;
    }
    label1190:
    label1225:
    label2122:
    label6603:
    for (;;)
    {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).a((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1, -1, k);
      label604:
      localw.Ion = bool1;
      Object localObject5 = ((Activity)((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).mContext).getLayoutInflater();
      int i = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).oft.size();
      label636:
      if (i < k)
      {
        paramView = ao.acZ(3);
        if (paramView != null) {
          break label6609;
        }
        paramView = ((LayoutInflater)localObject5).inflate(2131493211, null);
      }
      label1359:
      label2895:
      label6609:
      for (;;)
      {
        Object localObject7 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).ofm;
        Object localObject8 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).mContext;
        Object localObject6 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).ofq;
        localObject7 = new com.tencent.mm.plugin.brandservice.ui.timeline.item.w((b)localObject7, (Context)localObject8);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject7).odh = paramView;
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject7).iCM = paramView.findViewById(2131306012);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject7).oeQ = paramView.findViewById(2131298764);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject7).oeR = ((MMNeat7extView)paramView.findViewById(2131305938));
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject7).oeS = ((TextView)paramView.findViewById(2131305546));
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject7).oeT = paramView.findViewById(2131298814);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject7).ocn = ((ImageView)paramView.findViewById(2131298824));
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject7).oeW = ((ImageView)paramView.findViewById(2131303284));
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject7).oeU = paramView.findViewById(2131297330);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject7).oeV = ((ImageView)paramView.findViewById(2131297370));
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject7).ocG = paramView.findViewById(2131305184);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject7).ocH = ((TextView)paramView.findViewById(2131300305));
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject7).oeX = paramView.findViewById(2131303255);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject7).oeY = paramView.findViewById(2131303254);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject7).oeZ = ((TextView)paramView.findViewById(2131303263));
        ((ViewGroup)localObject6).addView(paramView, ((ViewGroup)localObject6).getChildCount());
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).oft.add(localObject7);
        i += 1;
        break label636;
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).a((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1, ((com.tencent.mm.ai.v)((List)localObject3).get(0)).type, k);
        break label604;
        i = 0;
        while (i < ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).oft.size())
        {
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).oft.get(i)).odh.setVisibility(8);
          i += 1;
        }
        label1115:
        label1123:
        int m;
        int j;
        label1255:
        boolean bool2;
        if (bool1)
        {
          if (((com.tencent.mm.ai.v)localObject4).type == 5) {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).ofv.a(k, (com.tencent.mm.ai.v)localObject4, localw, paramInt, (u)localObject2, localw.ofe);
          }
        }
        else
        {
          if ((k <= 2) || (localw.field_isExpand)) {
            break label1765;
          }
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).ofr.setVisibility(0);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).ofs.setText(((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).mContext.getString(2131756641, new Object[] { Integer.valueOf(k - 2) }));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).ofr.setTag(localw);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).ofr.setOnClickListener(((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).ofB);
          if (!bool1) {
            break label1778;
          }
          i = 1;
          if ((i >= k) || ((!localw.field_isExpand) && (i > 1))) {
            break label2566;
          }
          localObject5 = (com.tencent.mm.ai.v)((List)localObject3).get(i);
          m = localw.ofe + i;
          com.tencent.mm.plugin.brandservice.ui.timeline.item.aa.c((com.tencent.mm.ai.v)localObject5);
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).oft;
          if (!bool1) {
            break label1784;
          }
          j = i - 1;
          localObject6 = (com.tencent.mm.plugin.brandservice.ui.timeline.item.w)paramView.get(j);
          j = ((com.tencent.mm.ai.v)localObject4).type;
          if (i != 0) {
            break label1791;
          }
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).iCM.setVisibility(8);
          if (bool1) {
            break label2122;
          }
          if (i != 0) {
            break label2023;
          }
          if (k != 1) {
            break label2001;
          }
          com.tencent.mm.plugin.brandservice.ui.timeline.item.aa.t(((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).oeQ, oaj, oag);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).a((com.tencent.mm.ai.v)localObject5, localw, i, false);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).a((com.tencent.mm.ai.v)localObject5, false);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).a(((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).ocG, ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).ocH, localw, (com.tencent.mm.ai.v)localObject5);
          if (!bt.isNullOrNil(((com.tencent.mm.ai.v)localObject5).title)) {
            break label2278;
          }
          paramView = com.tencent.mm.plugin.brandservice.b.a.nWn;
          switch (((com.tencent.mm.ai.v)localObject5).type)
          {
          case 6: 
          default: 
            paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).mContext.getResources().getString(2131756613);
            com.tencent.mm.plugin.brandservice.b.a.a(paramView, ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).oeR, (com.tencent.mm.ai.v)localObject5, 1);
            label1371:
            ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).oeR.setTextColor(((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).mContext.getResources().getColor(2131099732));
            if ((((com.tencent.mm.ai.v)localObject5).hDp == 0) || (((com.tencent.mm.ai.v)localObject5).hDp == 1))
            {
              ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).oeT.setVisibility(0);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).oeR.setTextColor(((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).mContext.getResources().getColor(2131099732));
              if (((com.tencent.mm.ai.v)localObject5).type == 7)
              {
                ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).ocn.setVisibility(8);
                if ((bt.isNullOrNil(((com.tencent.mm.ai.v)localObject5).hDo)) || (((com.tencent.mm.ai.v)localObject5).type != 3)) {
                  break label2533;
                }
                ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).oeS.setText(((com.tencent.mm.ai.v)localObject5).hDo);
                ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).oeS.setVisibility(0);
                label1503:
                ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).odh.setVisibility(0);
                paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).ofm;
                localObject7 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).odh;
                if (k <= 1) {
                  break label2546;
                }
                bool2 = true;
                label1534:
                paramView.a((com.tencent.mm.ai.v)localObject5, localw, paramInt, (u)localObject2, (View)localObject7, bool2, i);
                if ((i != k - 1) || (((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).ofr.getVisibility() == 0)) {
                  break label2552;
                }
                ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).odh.setBackgroundResource(2131231256);
              }
            }
            break;
          }
        }
        label1765:
        label1778:
        label1784:
        label1791:
        long l;
        for (;;)
        {
          i += 1;
          break label1123;
          if (((com.tencent.mm.ai.v)localObject4).type == 8)
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).ofx.a(k, (com.tencent.mm.ai.v)localObject4, localw, paramInt, (u)localObject2, localw.ofe);
            break;
          }
          if (((com.tencent.mm.ai.v)localObject4).type == 7)
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).ofy.a(k, (com.tencent.mm.ai.v)localObject4, localw, paramInt, (u)localObject2, localw.ofe);
            break;
          }
          if (((com.tencent.mm.ai.v)localObject4).type == 6)
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).ofz.a(k, (com.tencent.mm.ai.v)((List)localObject3).get(0), localw, paramInt, (u)localObject2, localw.ofe);
            break;
          }
          if (((com.tencent.mm.ai.v)localObject4).type == 10)
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).ofA.a(k, (com.tencent.mm.ai.v)localObject4, localw, paramInt, (u)localObject2, localw.ofe);
            break;
          }
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).ofu.a(k, (com.tencent.mm.ai.v)localObject4, localw, paramInt, (u)localObject2, localw.ofe);
          break;
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).ofr.setVisibility(8);
          break label1115;
          i = 0;
          break label1123;
          j = i;
          break label1190;
          if ((i == 1) && (bool1) && (j != 7) && (j != 5) && (j != 6)) {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).iCM.setVisibility(8);
          }
          for (;;)
          {
            if ((!bool1) || (i > 0))
            {
              paramView = (com.tencent.mm.ai.v)((List)localObject3).get(i - 1);
              localObject7 = (com.tencent.mm.ai.v)((List)localObject3).get(i);
              if (((paramView.type != 7) && (paramView.type != 5) && (paramView.type != 6) && (bt.isNullOrNil(paramView.hDm))) || ((((com.tencent.mm.ai.v)localObject7).type != 7) && (((com.tencent.mm.ai.v)localObject7).type != 5) && (((com.tencent.mm.ai.v)localObject7).type != 6) && (bt.isNullOrNil(((com.tencent.mm.ai.v)localObject7).hDm))))
              {
                com.tencent.mm.plugin.brandservice.ui.timeline.item.aa.Y(((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).iCM, oal);
                break;
                ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).iCM.setVisibility(0);
                continue;
              }
              com.tencent.mm.plugin.brandservice.ui.timeline.item.aa.Y(((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).iCM, oak);
              break;
            }
          }
          com.tencent.mm.plugin.brandservice.ui.timeline.item.aa.Y(((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).iCM, oal);
          break label1225;
          label2001:
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).oeQ;
          j = oaj;
          com.tencent.mm.plugin.brandservice.ui.timeline.item.aa.t(paramView, j, j);
          break label1255;
          label2023:
          if (i == 1)
          {
            if (k == 2)
            {
              com.tencent.mm.plugin.brandservice.ui.timeline.item.aa.t(((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).oeQ, oaj, oag);
              break label1255;
            }
            paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).oeQ;
            j = oaj;
            com.tencent.mm.plugin.brandservice.ui.timeline.item.aa.t(paramView, j, j);
            break label1255;
          }
          if (i == k - 1)
          {
            com.tencent.mm.plugin.brandservice.ui.timeline.item.aa.t(((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).oeQ, oaj, oag);
            break label1255;
          }
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).oeQ;
          j = oaj;
          com.tencent.mm.plugin.brandservice.ui.timeline.item.aa.t(paramView, j, j);
          break label1255;
          if (i == 1)
          {
            if (i == k - 1)
            {
              paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).oeQ;
              j = oag;
              com.tencent.mm.plugin.brandservice.ui.timeline.item.aa.t(paramView, j, j);
              break label1255;
            }
            com.tencent.mm.plugin.brandservice.ui.timeline.item.aa.t(((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).oeQ, oag, oaj);
            break label1255;
          }
          if (i == k - 1)
          {
            com.tencent.mm.plugin.brandservice.ui.timeline.item.aa.t(((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).oeQ, oaj, oag);
            break label1255;
          }
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).oeQ;
          j = oaj;
          com.tencent.mm.plugin.brandservice.ui.timeline.item.aa.t(paramView, j, j);
          break label1255;
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).mContext.getResources().getString(2131756623);
          break label1359;
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).mContext.getResources().getString(2131756624);
          break label1359;
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).mContext.getResources().getString(2131756614);
          break label1359;
          label2278:
          paramView = com.tencent.mm.plugin.brandservice.b.a.nWn;
          com.tencent.mm.plugin.brandservice.b.a.a(((com.tencent.mm.ai.v)localObject5).title, ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).oeR, (com.tencent.mm.ai.v)localObject5, 1);
          break label1371;
          if (!bt.isNullOrNil(((com.tencent.mm.ai.v)localObject5).hDm))
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).ocn.setVisibility(0);
            if (bt.isNullOrNil(((com.tencent.mm.ai.v)localObject5).hDD)) {}
            for (paramView = ((com.tencent.mm.ai.v)localObject5).hDm;; paramView = ((com.tencent.mm.ai.v)localObject5).hDD)
            {
              localObject7 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).ofm.oas;
              l = localw.field_msgId;
              localObject8 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).ocn;
              j = oaf;
              ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject7).a(l, i, (com.tencent.mm.ai.v)localObject5, paramView, (ImageView)localObject8, j, j, false, new aa.2((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1, (com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6, (com.tencent.mm.ai.v)localObject5, localw, i), m, 2.0F);
              break;
            }
          }
          if ((((com.tencent.mm.ai.v)localObject5).type == 5) || (((com.tencent.mm.ai.v)localObject5).type == 6))
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).ocn.setVisibility(0);
            paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).ofm.oas;
            localObject7 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).ocn;
            j = oaf;
            paramView.a("2131231674", (ImageView)localObject7, j, j, m);
            break label1461;
          }
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).oeT.setVisibility(8);
          break label1461;
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).oeT.setVisibility(8);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).oeR.setTextColor(((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).mContext.getResources().getColor(2131099735));
          break label1461;
          label2533:
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).oeS.setVisibility(8);
          break label1503;
          label2546:
          bool2 = false;
          break label1534;
          label2552:
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.w)localObject6).odh.setBackgroundResource(2131231262);
        }
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).ofm.a(paramInt, localw, ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).oeI, ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).oeH);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1).ofm.a((com.tencent.mm.plugin.brandservice.ui.timeline.item.z)localObject1, localw);
        paramView = paramViewGroup;
        break label188;
        if (paramView == null)
        {
          paramViewGroup = new ac();
          paramView = paramViewGroup.a(this.oac, this);
          paramView.setTag(paramViewGroup);
          localObject2 = paramViewGroup.mContext;
          localObject3 = localw.field_content;
          i = (int)paramViewGroup.ocA.getTextSize();
          if (localw == null) {
            break label2988;
          }
          localObject1 = com.tencent.mm.model.y.AH(localw.field_msgSvrId);
          localObject4 = com.tencent.mm.model.y.aBq().F((String)localObject1, true);
          ((y.b)localObject4).k("prePublishId", "msg_" + localw.field_msgSvrId);
          ((y.b)localObject4).k("preUsername", localw.field_talker);
          localObject1 = com.tencent.mm.pluginsdk.ui.span.k.a((Context)localObject2, (CharSequence)localObject3, i, 1, null, (String)localObject1);
          paramViewGroup.ocA.setMaxLines(2147483647);
          paramViewGroup.ocA.ar((CharSequence)localObject1);
          if (!localw.field_isExpand) {
            break label2994;
          }
          paramViewGroup.ofL.setText(paramViewGroup.mContext.getString(2131756619));
          label2796:
          i = com.tencent.mm.cc.a.ip(paramViewGroup.mContext);
          j = com.tencent.mm.cc.a.fromDPToPix(paramViewGroup.mContext, 72);
          localObject1 = paramViewGroup.ocA.kK(i - j, 2147483647);
          if (localObject1 == null) {
            break label6603;
          }
        }
        for (i = ((com.tencent.neattextview.textview.layout.a)localObject1).fSB();; i = 0)
        {
          if (i > 4)
          {
            if (!localw.field_isExpand) {
              paramViewGroup.ocA.setMaxLines(4);
            }
            paramViewGroup.ofL.setVisibility(0);
            if (localw.field_isExpand)
            {
              paramViewGroup.ofL.setText(2131756619);
              paramViewGroup.ofL.setOnClickListener(new ac.1(paramViewGroup, localw));
              label2912:
              localObject1 = (LinearLayout.LayoutParams)paramViewGroup.ocA.getLayoutParams();
              if (i > 4) {
                break label3049;
              }
            }
          }
          label3049:
          for (((LinearLayout.LayoutParams)localObject1).gravity = 17;; ((LinearLayout.LayoutParams)localObject1).gravity = 19)
          {
            paramViewGroup.ocA.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            paramViewGroup.ofm.a(paramViewGroup, localw);
            paramViewGroup.ofm.a(paramInt, localw, paramViewGroup.oeI, paramViewGroup.oeH);
            break;
            paramViewGroup = (ac)paramView.getTag();
            break label2631;
            localObject1 = null;
            break label2737;
            paramViewGroup.ofL.setText(paramViewGroup.mContext.getString(2131756620));
            break label2796;
            paramViewGroup.ofL.setText(2131756620);
            break label2895;
            paramViewGroup.ocA.setMaxLines(2147483647);
            paramViewGroup.ofL.setVisibility(8);
            break label2912;
          }
          if (paramView == null)
          {
            paramViewGroup = new al();
            paramView = paramViewGroup.a(this.oac, this);
            paramView.setTag(paramViewGroup);
            localw.Ion = com.tencent.mm.plugin.brandservice.ui.b.a.j(localw);
            if (!localw.Ion) {
              break label3427;
            }
            paramViewGroup.ofj.setVisibility(0);
            paramViewGroup.ofk.setVisibility(8);
            localObject2 = paramViewGroup.ocA;
            localObject1 = paramViewGroup.oeW;
            localObject3 = new com.tencent.mm.modelvoice.p(localw.field_content);
            ((MMNeat7extView)localObject2).ar(i.formatTime("yyyy/MM/dd", System.currentTimeMillis() / 1000L));
            if (localw.Ion)
            {
              localObject2 = com.tencent.mm.ai.m.oi((int)(((com.tencent.mm.modelvoice.p)localObject3).time / 1000L));
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                break label3500;
              }
              paramViewGroup.ogg.setVisibility(0);
              paramViewGroup.ogg.setText((CharSequence)localObject2);
              paramViewGroup.ofK.setOnClickListener(new al.2(paramViewGroup));
              paramViewGroup.ofK.setBackgroundResource(2131231692);
              localObject2 = paramViewGroup.ofK;
              i = oah;
              j = oag;
              k = oah;
              ((View)localObject2).setPadding(i, j, k, k);
            }
            localObject2 = ((ImageView)localObject1).getDrawable();
            if (((localObject2 instanceof AnimationDrawable)) && (((AnimationDrawable)localObject2).isRunning())) {
              ((AnimationDrawable)localObject2).stop();
            }
            if ((!paramViewGroup.ofm.oay.isPlaying()) || (localw.field_msgId != paramViewGroup.ofm.oay.oce)) {
              break label3512;
            }
            ((ImageView)localObject1).setImageResource(2131231676);
            if ((((ImageView)localObject1).getDrawable() instanceof AnimationDrawable)) {
              ((AnimationDrawable)((ImageView)localObject1).getDrawable()).start();
            }
          }
          for (;;)
          {
            ((ImageView)localObject1).setOnClickListener(new al.3(paramViewGroup, localw, (ImageView)localObject1));
            paramViewGroup.ofm.a(paramViewGroup, localw);
            paramViewGroup.ofm.a(paramInt, localw, paramViewGroup.oeI, paramViewGroup.oeH);
            break;
            paramViewGroup = (al)paramView.getTag();
            break label3086;
            label3427:
            paramViewGroup.iCM.setVisibility(8);
            paramViewGroup.ofj.setVisibility(8);
            paramViewGroup.ofk.setVisibility(0);
            paramViewGroup.ogj.setVisibility(8);
            paramViewGroup.ogi.setVisibility(0);
            localObject2 = paramViewGroup.ogk;
            localObject1 = paramViewGroup.ogi;
            paramViewGroup.ofk.setOnClickListener(new al.1(paramViewGroup));
            break label3133;
            paramViewGroup.ogg.setVisibility(8);
            break label3213;
            ((ImageView)localObject1).setImageResource(2131231675);
          }
          if (paramView == null)
          {
            paramViewGroup = new com.tencent.mm.plugin.brandservice.ui.timeline.item.y();
            paramView = paramViewGroup.a(this.oac, this);
            paramView.setTag(paramViewGroup);
          }
          for (;;)
          {
            if (this.oaA == null) {
              this.oaA = new c(this.oac);
            }
            localObject1 = this.oaA;
            paramViewGroup.ofm.a(paramViewGroup, localw);
            paramViewGroup.ofm.a(paramInt, localw, paramViewGroup.oeI, paramViewGroup.oeH);
            localw.Ion = com.tencent.mm.plugin.brandservice.ui.b.a.j(localw);
            if (!localw.Ion) {
              break label3703;
            }
            paramViewGroup.ofk.setVisibility(8);
            paramViewGroup.ofj.setVisibility(0);
            paramViewGroup.dF(paramViewGroup.ofh);
            paramViewGroup.dF(paramViewGroup.ofg);
            ((c)localObject1).a(localw, paramInt, paramViewGroup.ofg, oad);
            paramViewGroup.ofh.setOnClickListener(new y.1(paramViewGroup, localw));
            break;
            paramViewGroup = (com.tencent.mm.plugin.brandservice.ui.timeline.item.y)paramView.getTag();
          }
          label3703:
          paramViewGroup.ofk.setVisibility(0);
          paramViewGroup.ofj.setVisibility(8);
          paramViewGroup.iCM.setVisibility(8);
          paramViewGroup.ocA.ar(paramViewGroup.mContext.getText(2131756612));
          ((c)localObject1).a(localw, paramInt, paramViewGroup.ofi, 0);
          paramViewGroup.ofk.setOnClickListener(new y.2(paramViewGroup, localw));
          break label188;
          if (!this.oaz) {
            com.tencent.mm.plugin.brandservice.ui.b.c.m(localw);
          }
          if (paramView == null)
          {
            paramViewGroup = new s(this.oac, this);
            paramView = paramViewGroup.oeG;
            paramView.setTag(paramViewGroup);
          }
          for (;;)
          {
            d.g.b.p.h(localw, "info");
            d.g.b.p.h(paramView, "convertView");
            if (localw.fpm() != null) {
              break label3868;
            }
            paramViewGroup.bOK();
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BizTLRecCardNew", "[TRACE_BIZRECCARD] info null");
            break;
            paramViewGroup = (s)paramView.getTag();
          }
          if (!com.tencent.mm.plugin.brandservice.ui.timeline.item.j.ze(localw.Ioq.style))
          {
            paramViewGroup.bOK();
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BizTLRecCardNew", "[TRACE_BIZRECCARD] style = " + localw.Ioq.style + " not support");
            break label188;
          }
          localObject1 = localw.Ioq;
          d.g.b.p.g(localObject1, "info.wrapper");
          if (!com.tencent.mm.storage.aa.b((dlt)localObject1, localw))
          {
            paramViewGroup.bOK();
            com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BizTLRecCardNew", "[TRACE_BIZRECCARD] wrapper illegal");
            break label188;
          }
          i = s.zu(localw.Ioq.style);
          com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BizTLRecCardNew", "[TRACE_BIZRECCARD] filling style = " + localw.Ioq.style + ", clientShowType = " + i);
          paramViewGroup.obC.a(paramInt, localw, (View)paramViewGroup.oeI, (View)paramViewGroup.oeH);
          switch (i)
          {
          default: 
            break;
          case 1: 
            localObject1 = paramViewGroup.oeC;
            localObject2 = paramViewGroup.oeG;
            com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1149L, 2L, 1L, false);
            localObject3 = ((t)localObject1).mContext;
            if (((t)localObject1).odh == null)
            {
              ((t)localObject1).odh = ((ViewStub)((View)localObject2).findViewById(2131307258)).inflate();
              ((t)localObject1).bOL();
              ((t)localObject1).odV = ((TextView)((t)localObject1).odh.findViewById(2131297298));
              ((t)localObject1).odW = ((t)localObject1).odh.findViewById(2131298374);
              ((t)localObject1).odX = ((t)localObject1).odh.findViewById(2131298373);
              ((t)localObject1).odY = ((t)localObject1).odh.findViewById(2131297296);
              ((t)localObject1).odZ = ((TextView)((t)localObject1).odh.findViewById(2131297297));
              ((t)localObject1).oea = ((MMNeat7extView)((t)localObject1).odh.findViewById(2131297294));
              ((t)localObject1).iCM = ((t)localObject1).odh.findViewById(2131297295);
              ((t)localObject1).oeL = ((t)localObject1).odh.findViewById(2131297291);
              ((t)localObject1).oeM = ((TextView)((t)localObject1).odh.findViewById(2131297292));
              ((t)localObject1).oeN = ((MMNeat7extView)((t)localObject1).odh.findViewById(2131297293));
              ((WeImageView)((t)localObject1).odh.findViewById(2131302669)).setIconColor(((Context)localObject3).getResources().getColor(2131099664));
            }
            ((t)localObject1).odh.setVisibility(0);
            localObject2 = localw.fpl();
            if ((localObject2 == null) || (((dlo)localObject2).HzY == null)) {
              paramView.setVisibility(8);
            }
            for (;;)
            {
              paramViewGroup.oeB.hide();
              paramViewGroup.oeA.hide();
              paramViewGroup.oeD.hide();
              paramViewGroup.oeE.hide();
              paramViewGroup.oeF.hide();
              break;
              paramView.setVisibility(0);
              ((t)localObject1).odV.setText(((dlo)localObject2).GfK);
              ((t)localObject1).odU.getPaint().setFakeBoldText(true);
              localObject3 = ((t)localObject1).fOf;
              localObject4 = ((dlo)localObject2).HzY.FJT;
              localObject5 = new c.a();
              ((c.a)localObject5).idG = 2131231342;
              ((c.a)localObject5).idq = true;
              ((c.a)localObject5).hfi = true;
              com.tencent.mm.aw.q.aIJ().a((String)localObject4, (ImageView)localObject3, ((c.a)localObject5).aJc());
              ((t)localObject1).odU.setText(((dlo)localObject2).HzY.nEt);
              ((t)localObject1).odZ.setText(((dlo)localObject2).HzY.HAa);
              ((t)localObject1).oea.ar(((dlo)localObject2).HzY.jdf);
              localObject3 = ((dlo)localObject2).HzY.nDo;
              localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azp().Bf((String)localObject3);
              if ((localObject4 == null) || ((int)((com.tencent.mm.o.b)localObject4).gfj <= 0)) {
                as.a.hFO.a((String)localObject3, "", null);
              }
              ((t)localObject1).odY.setOnClickListener(new t.1((t)localObject1, (String)localObject3, localw));
              if ((((dlo)localObject2).FJV != null) && (((dlo)localObject2).FJV.get(0) != null) && ((((dlp)((dlo)localObject2).FJV.get(0)).FuX & 0x1) == 0))
              {
                localObject3 = (dlp)((dlo)localObject2).FJV.get(0);
                ((t)localObject1).oeL.setVisibility(0);
                ((t)localObject1).iCM.setVisibility(0);
                ((t)localObject1).oeM.setText(((dlo)localObject2).FJU);
                ((t)localObject1).oeN.ar(((dlp)localObject3).Title);
                ((t)localObject1).oeL.setOnClickListener(new t.2((t)localObject1, localw, (dlp)localObject3));
                ((t)localObject1).odY.setBackgroundResource(2131231262);
                if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zc(1)) && (!bt.isNullOrNil(((dlp)localObject3).FFW)))
                {
                  com.tencent.mm.sdk.platformtools.ad.d("MicroMsg.BizTimeLineItem", "preload %s", new Object[] { ((dlp)localObject3).FFW });
                  ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(((dlp)localObject3).FFW, ((dlp)localObject3).hCZ, 90, new Object[0]);
                }
                com.tencent.mm.plugin.brandservice.ui.b.c.l(localw);
                localObject3 = localw.fpm();
                if (localObject3 == null) {
                  continue;
                }
                localObject4 = ((dlo)localObject2).HzZ;
                if (localObject4 != null) {
                  break label5001;
                }
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo = null");
                i = 0;
              }
              for (;;)
              {
                if ((i != 0) || (!bt.hj(((dlt)localObject3).HAe))) {
                  break label5086;
                }
                com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] hideNegativeFeedback，BizNickName = %s", new Object[] { ((dlo)localObject2).HzY.nEt });
                ((t)localObject1).odW.setVisibility(8);
                break;
                com.tencent.mm.plugin.report.service.g.yhR.idkeyStat(1149L, 6L, 1L, false);
                ((t)localObject1).iCM.setVisibility(8);
                ((t)localObject1).oeL.setVisibility(8);
                ((t)localObject1).odY.setBackgroundResource(2131231256);
                break label4859;
                if (((dls)localObject4).HAc == null)
                {
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo = null");
                  i = 0;
                }
                else if (((dls)localObject4).HAc.FJO != 1)
                {
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.ShowNegativeFeedbackReason != 1");
                  i = 0;
                }
                else if (bt.hj(((dls)localObject4).HAc.FJN))
                {
                  com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.NegativeFeedbackReason null");
                  i = 0;
                }
                else
                {
                  i = 1;
                }
              }
              com.tencent.mm.sdk.platformtools.ad.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] showNegativeFeedback，BizNickName = %s", new Object[] { ((dlo)localObject2).HzY.nEt });
              ((t)localObject1).odW.setVisibility(0);
              ((t)localObject1).odW.setOnClickListener(new t.3((t)localObject1, localw, paramInt));
            }
          case 2: 
            paramViewGroup.oeA.a(localw, paramInt, paramView, paramViewGroup.oeG);
            paramViewGroup.oeB.hide();
            paramViewGroup.oeC.hide();
            paramViewGroup.oeD.hide();
            paramViewGroup.oeE.hide();
            paramViewGroup.oeF.hide();
            break;
          case 3: 
            paramViewGroup.oeA.hide();
            paramViewGroup.oeB.a(localw, paramInt, paramView, paramViewGroup.oeG);
            paramViewGroup.oeC.hide();
            paramViewGroup.oeD.hide();
            paramViewGroup.oeE.hide();
            paramViewGroup.oeF.hide();
            break;
          case 4: 
            localObject1 = paramViewGroup.oeD;
            localObject2 = paramViewGroup.oeG;
            d.g.b.p.h(localw, "info");
            d.g.b.p.h(paramView, "convertView");
            d.g.b.p.h(localObject2, "parent");
            d.g.b.p.h(localObject2, "parent");
            if (((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject1).odh == null)
            {
              localObject2 = ((ViewStub)((View)localObject2).findViewById(2131308226)).inflate();
              ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject1).odu = ((View)localObject2).findViewById(2131297276);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject1).odv = ((ImageView)((View)localObject2).findViewById(2131297008));
              ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject1).odw = ((TextView)((View)localObject2).findViewById(2131302860));
              ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject1).odx = ((View)localObject2).findViewById(2131298374);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject1).ody = ((WeImageView)((View)localObject2).findViewById(2131298373));
              ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject1).odi = ((LinearLayout)((View)localObject2).findViewById(2131307153));
              ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject1).odh = ((View)localObject2);
            }
            localObject2 = localw.fpm();
            d.g.b.p.g(localObject2, "info.tlRecCardWrapper");
            if (com.tencent.mm.plugin.brandservice.ui.timeline.item.m.a((dlt)localObject2))
            {
              paramView.setVisibility(0);
              localObject2 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject1).odh;
              if (localObject2 != null) {
                ((View)localObject2).setVisibility(0);
              }
              localObject2 = (ok)localw.fpm().HAf.FHP.get(0);
              d.g.b.p.g(localObject2, "bizInfo");
              a.b.d(((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject1).odv, ((ok)localObject2).nDo);
              localObject3 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject1).odw;
              if (localObject3 != null) {
                ((TextView)localObject3).setText((CharSequence)((ok)localObject2).nEt);
              }
              localObject3 = d.osr;
              d.i(((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject1).odw);
              localObject3 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject1).odu;
              if (localObject3 != null) {
                ((View)localObject3).setOnClickListener((View.OnClickListener)new m.e((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject1, localw));
              }
              localObject3 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject1).odu;
              if (localObject3 != null) {
                ((View)localObject3).setOnLongClickListener((View.OnLongClickListener)new m.f((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject1, localw, (ok)localObject2));
              }
              if ((bt.hj((List)((ok)localObject2).FJN)) || (((ok)localObject2).FJO != 1)) {
                break label5801;
              }
              localObject3 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject1).odx;
              if (localObject3 != null) {
                ((View)localObject3).setVisibility(0);
              }
              localObject3 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject1).odx;
              if (localObject3 != null) {
                ((View)localObject3).setOnClickListener((View.OnClickListener)new m.d((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject1, localw, (ok)localObject2, paramInt));
              }
              switch (((oj)((ok)localObject2).FJV.get(0)).hCZ)
              {
              default: 
                localObject3 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject1).odA;
                localObject4 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject1).odh;
                if (localObject4 == null) {
                  d.g.b.p.gfZ();
                }
                ((com.tencent.mm.plugin.brandservice.ui.timeline.item.c)localObject3).a((View)localObject4, localw, (ok)localObject2);
                ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject1).odz.hide();
              }
            }
            for (;;)
            {
              ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject1).a(localw, (ok)localObject2);
              com.tencent.mm.plugin.brandservice.ui.b.c.l(localw);
              paramViewGroup.oeA.hide();
              paramViewGroup.oeB.hide();
              paramViewGroup.oeC.hide();
              paramViewGroup.oeE.hide();
              paramViewGroup.oeF.hide();
              break;
              localObject3 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject1).odx;
              if (localObject3 == null) {
                break label5676;
              }
              ((View)localObject3).setVisibility(8);
              break label5676;
              localObject3 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject1).odz;
              localObject4 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject1).odh;
              if (localObject4 == null) {
                d.g.b.p.gfZ();
              }
              ((com.tencent.mm.plugin.brandservice.ui.timeline.item.f)localObject3).a((View)localObject4, localw, (ok)localObject2);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject1).odA.hide();
            }
          case 5: 
            paramViewGroup.oeD.hide();
            paramViewGroup.oeA.hide();
            paramViewGroup.oeB.hide();
            paramViewGroup.oeC.hide();
            localObject1 = paramViewGroup.oeE;
            localObject4 = paramViewGroup.oeG;
            d.g.b.p.h(localw, "info");
            d.g.b.p.h(paramView, "convertView");
            d.g.b.p.h(localObject4, "parent");
            localObject3 = "__rec_card_" + localw.field_msgId;
            localObject2 = com.tencent.mm.plugin.webcanvas.f.DyX;
            com.tencent.mm.plugin.webcanvas.f.Cj(71L);
            com.tencent.mm.sdk.platformtools.ad.i(((n)localObject1).TAG, "filling#".concat(String.valueOf(localObject3)));
            if (!((n)localObject1).odc)
            {
              localObject2 = com.tencent.mm.plugin.biz.b.b.nOV;
              if (!com.tencent.mm.plugin.biz.b.b.d((String)localObject3, paramView)) {}
            }
            else
            {
              ((n)localObject1).odc = true;
              d.g.b.p.h(localObject4, "parent");
              if (((n)localObject1).odh == null)
              {
                localObject2 = ((ViewStub)((View)localObject4).findViewById(2131308462)).inflate();
                ((n)localObject1).odK = ((BizTLRecCardCanvasView)((View)localObject2).findViewById(2131308380));
                ((n)localObject1).odh = ((View)localObject2);
              }
              localObject2 = ((n)localObject1).odh;
              if (localObject2 != null) {
                ((View)localObject2).setVisibility(0);
              }
              localObject5 = localw.fpm();
              localObject6 = ((n)localObject1).odK;
              if (localObject6 != null)
              {
                l = localw.field_msgId;
                localObject1 = com.tencent.mm.plugin.brandservice.ui.timeline.item.k.ode;
                localObject7 = k.a.bOF();
                localObject2 = ((dlt)localObject5).HAh.Hkk;
                localObject1 = localObject2;
                if (localObject2 == null) {
                  localObject1 = "re";
                }
                localObject2 = ((dlt)localObject5).HAh.data;
                d.g.b.p.g(localObject2, "wrapper.exptInfo.data");
                ((BizTLRecCardCanvasView)localObject6).a(l, (String)localObject3, (com.tencent.mm.plugin.brandservice.ui.timeline.item.q)localObject7, (String)localObject1, (String)localObject2, (View)localObject4);
              }
              localObject1 = com.tencent.mm.plugin.webcanvas.f.DyX;
              com.tencent.mm.plugin.webcanvas.f.Cj(72L);
              localObject1 = com.tencent.mm.plugin.biz.b.b.nOV;
              com.tencent.mm.plugin.biz.b.b.WB((String)localObject3);
            }
            paramViewGroup.oeF.hide();
            break;
          case 6: 
            label4859:
            paramViewGroup.oeD.hide();
            label5086:
            paramViewGroup.oeA.hide();
            paramViewGroup.oeB.hide();
            paramViewGroup.oeC.hide();
            paramViewGroup.oeE.hide();
            paramViewGroup.oeF.a(localw, paramInt, paramView, paramViewGroup.oeG);
            break;
            if (paramView == null)
            {
              localObject2 = new com.tencent.mm.plugin.brandservice.ui.timeline.item.k(this.oac, this);
              localObject1 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.k)localObject2).bOD();
              ((View)localObject1).setTag(localObject2);
            }
            for (;;)
            {
              d.g.b.p.h(localw, "info");
              d.g.b.p.h(localObject1, "convertView");
              d.g.b.p.h(paramViewGroup, "parent");
              localObject4 = "__ad_card_" + localw.fpo();
              com.tencent.mm.sdk.platformtools.ad.i(((com.tencent.mm.plugin.brandservice.ui.timeline.item.k)localObject2).TAG, "filling#".concat(String.valueOf(localObject4)));
              paramView = com.tencent.mm.plugin.webcanvas.f.DyX;
              com.tencent.mm.plugin.webcanvas.f.Cj(66L);
              if (!((com.tencent.mm.plugin.brandservice.ui.timeline.item.k)localObject2).odc)
              {
                paramView = com.tencent.mm.plugin.biz.b.b.nOV;
                paramView = (View)localObject1;
                if (!com.tencent.mm.plugin.biz.b.b.d((String)localObject4, (View)localObject1)) {
                  break;
                }
              }
              ((com.tencent.mm.plugin.brandservice.ui.timeline.item.k)localObject2).odc = true;
              localObject5 = (BizTLRecCardCanvasView)((com.tencent.mm.plugin.brandservice.ui.timeline.item.k)localObject2).ocZ.getValue();
              l = localw.field_msgId;
              localObject6 = k.a.bOF();
              localObject3 = localw.getPathType();
              paramView = (View)localObject3;
              if (localObject3 == null) {
                paramView = "ad";
              }
              localObject3 = localw.fpn();
              d.g.b.p.g(localObject3, "info.adData");
              ((BizTLRecCardCanvasView)localObject5).a(l, (String)localObject4, (com.tencent.mm.plugin.brandservice.ui.timeline.item.q)localObject6, paramView, (String)localObject3, (View)paramViewGroup);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.item.k)localObject2).obC.a(paramInt, localw, (View)((com.tencent.mm.plugin.brandservice.ui.timeline.item.k)localObject2).oda.getValue(), (View)((com.tencent.mm.plugin.brandservice.ui.timeline.item.k)localObject2).odb.getValue());
              com.tencent.mm.plugin.brandservice.ui.timeline.item.k.h(localw);
              paramView = com.tencent.mm.plugin.webcanvas.f.DyX;
              com.tencent.mm.plugin.webcanvas.f.Cj(67L);
              paramView = com.tencent.mm.plugin.biz.b.b.nOV;
              com.tencent.mm.plugin.biz.b.b.WB((String)localObject4);
              paramView = (View)localObject1;
              break;
              localObject2 = (com.tencent.mm.plugin.brandservice.ui.timeline.item.k)paramView.getTag();
              localObject1 = paramView;
            }
            paramViewGroup.odh = View.inflate(paramView, 2131493230, null);
            paramViewGroup.bOL();
            paramView = paramViewGroup.odh;
            break label161;
            paramViewGroup = (ak)paramView.getTag();
            break label166;
          }
        }
      }
    }
  }
  
  public final int getViewTypeCount()
  {
    return 7;
  }
  
  public final boolean isEmpty()
  {
    AppMethodBeat.i(5885);
    if (super.isEmpty())
    {
      if (com.tencent.mm.am.ag.aGg().bUJ() > 0)
      {
        AppMethodBeat.o(5885);
        return false;
      }
      dmx localdmx = com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e.bOS();
      if ((localdmx != null) && (!bt.hj(localdmx.HBg))) {}
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
  
  public final com.tencent.mm.storage.w zq(int paramInt)
  {
    AppMethodBeat.i(5869);
    if ((paramInt < this.mHf.size()) && (paramInt >= 0))
    {
      com.tencent.mm.storage.w localw = (com.tencent.mm.storage.w)this.mHf.get(paramInt);
      AppMethodBeat.o(5869);
      return localw;
    }
    AppMethodBeat.o(5869);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.b
 * JD-Core Version:    0.7.0.1
 */
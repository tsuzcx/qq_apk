package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.MessageQueue.IdleHandler;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.TextureView;
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
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.v;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoView;
import com.tencent.mm.plugin.appbrand.jsapi.video.AppBrandVideoWrapper;
import com.tencent.mm.plugin.brandservice.ui.b.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.BizTLRecCardCanvasView;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.ab.2;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.ac;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.ad;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.ad.1;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.ah;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.ai;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.aj;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.ak;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.al;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.am;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.am.1;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.am.2;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.am.3;
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
import com.tencent.mm.plugin.brandservice.ui.timeline.item.u.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.u.c;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.u.d;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.u.e;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.z.1;
import com.tencent.mm.plugin.brandservice.ui.timeline.item.z.2;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr;
import com.tencent.mm.plugin.brandservice.ui.timeline.video.MPVideoPreviewMgr.a;
import com.tencent.mm.pluginsdk.i.i;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.aiq;
import com.tencent.mm.protocal.protobuf.ali;
import com.tencent.mm.protocal.protobuf.csm;
import com.tencent.mm.protocal.protobuf.dml;
import com.tencent.mm.protocal.protobuf.dmm;
import com.tencent.mm.protocal.protobuf.dmn;
import com.tencent.mm.protocal.protobuf.dmp;
import com.tencent.mm.protocal.protobuf.dmq;
import com.tencent.mm.protocal.protobuf.dnu;
import com.tencent.mm.protocal.protobuf.ol;
import com.tencent.mm.protocal.protobuf.om;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.x.a;
import com.tencent.mm.storage.x.c;
import com.tencent.mm.storage.y;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.chatting.ap;
import com.tencent.mm.ui.e.b;
import com.tencent.mm.ui.widget.MMNeat7extView;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.lang.ref.WeakReference;
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
  public static int ofT = 0;
  public static int ofU = 0;
  public static int ofV;
  public static int ofW = 0;
  public static int ofX = 0;
  public static int ofY = 0;
  public static int ofZ = 0;
  public static int oga;
  public static int ogb;
  public static int ogc;
  public static int ogd;
  public static int oge;
  private static Long ogk = null;
  private static Long ogl = null;
  private static Long ogm = null;
  boolean dus;
  public List<com.tencent.mm.storage.w> mMj;
  x.c obB;
  private BizTimeLineUI ofS;
  public com.tencent.mm.storage.w ogf;
  public int ogg;
  public BizTimeLineHotView ogh;
  public com.tencent.mm.plugin.brandservice.ui.timeline.preload.c ogi;
  private ac ogj;
  private long ogn;
  public h ogo;
  boolean ogp;
  private c ogq;
  public g ogr;
  private Set<String> ogs;
  public Set<v> ogt;
  private View.OnClickListener ogu;
  private j ogv;
  boolean ogw;
  
  public b(BizTimeLineUI paramBizTimeLineUI, List<com.tencent.mm.storage.w> paramList, boolean paramBoolean, g paramg, BizTimeLineHotView paramBizTimeLineHotView)
  {
    AppMethodBeat.i(5865);
    this.mMj = new LinkedList();
    this.dus = false;
    this.ogn = -1L;
    this.ogp = false;
    this.ogs = new HashSet();
    this.ogt = new HashSet();
    this.obB = new x.c()
    {
      public final void a(final Object paramAnonymousObject, final x.a paramAnonymousa)
      {
        AppMethodBeat.i(5855);
        if ((paramAnonymousa != null) && (paramAnonymousa.IIX))
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
    this.ogu = new b.10(this);
    this.ogv = new j()
    {
      public final void a(com.tencent.mm.storage.w paramAnonymousw, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(175422);
        b.this.ogr.a(paramAnonymousw, paramAnonymousInt1, paramAnonymousInt2);
        b.this.ogh.j(paramAnonymousw);
        AppMethodBeat.o(175422);
      }
    };
    this.ogw = false;
    this.ofS = paramBizTimeLineUI;
    this.ogh = paramBizTimeLineHotView;
    this.ogr = paramg;
    int i;
    int j;
    if (ofT == 0)
    {
      ofV = paramBizTimeLineUI.getResources().getDimensionPixelSize(2131165905);
      ofW = paramBizTimeLineUI.getResources().getDimensionPixelSize(2131165900);
      ofX = paramBizTimeLineUI.getResources().getDimensionPixelSize(2131165480);
      ofY = paramBizTimeLineUI.getResources().getDimensionPixelSize(2131165500);
      oga = paramBizTimeLineUI.getResources().getDimensionPixelSize(2131165909);
      ogb = paramBizTimeLineUI.getResources().getDimensionPixelOffset(2131165480);
      ofZ = paramBizTimeLineUI.getResources().getDimensionPixelOffset(2131165516);
      ogc = com.tencent.mm.cb.a.fromDPToPix(this.ofS, 2);
      oge = com.tencent.mm.cb.a.fromDPToPix(this.ofS, 40);
      ogd = com.tencent.mm.cb.a.fromDPToPix(this.ofS, 8);
      i = com.tencent.mm.cb.a.iu(paramBizTimeLineUI);
      j = com.tencent.mm.cb.a.iv(paramBizTimeLineUI);
      if (i >= j) {
        break label388;
      }
    }
    for (;;)
    {
      ofT = (int)((i - (int)(com.tencent.mm.cb.a.getDensity(paramBizTimeLineUI) * 16.0F)) / 2.35F);
      ofU = (int)((i - (int)(com.tencent.mm.cb.a.getDensity(paramBizTimeLineUI) * 16.0F)) / 1.777778F);
      com.tencent.mm.al.ag.aGv().a(this.obB, Looper.getMainLooper());
      cm(paramList);
      cn(paramList);
      this.ogo = new h(this);
      this.ogp = paramBoolean;
      bPf();
      this.ogi = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.c(paramBizTimeLineUI, ofT, ofV, this.mMj);
      this.ogj = new ac(this, paramBizTimeLineUI);
      com.tencent.mm.plugin.brandservice.ui.timeline.item.j.bPA();
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
        ((TextView)paramView2.findViewById(2131297357)).setText(this.ofS.getString(2131756615));
      }
    }
    for (;;)
    {
      b(paramw);
      AppMethodBeat.o(5875);
      return;
      paramView2.setVisibility(8);
      paramView1.setMinimumHeight(ofX);
      continue;
      paramView1.setMinimumHeight(this.ofS.getResources().getDimensionPixelSize(2131165187));
      paramView1.setVisibility(0);
      paramView2.setVisibility(8);
    }
  }
  
  private void a(com.tencent.mm.plugin.brandservice.ui.timeline.item.aa paramaa, final com.tencent.mm.storage.w paramw)
  {
    AppMethodBeat.i(5877);
    a.b.d(paramaa.fQl, paramw.field_talker);
    Object localObject1 = com.tencent.mm.model.w.zP(paramw.field_talker);
    Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramw.field_talker);
    if ((localObject2 != null) && (((an)localObject2).adB()))
    {
      localObject2 = this.ofS.getResources().getDrawable(2131231289);
      int i = (int)paramaa.ojK.getTextSize();
      ((Drawable)localObject2).setBounds(0, 0, i, i);
      localObject2 = new com.tencent.mm.ui.widget.a((Drawable)localObject2);
      SpannableString localSpannableString = new SpannableString("@");
      localSpannableString.setSpan(localObject2, 0, 1, 33);
      paramaa.ojK.setText(TextUtils.concat(new CharSequence[] { com.tencent.mm.pluginsdk.ui.span.k.b(this.ofS, (CharSequence)localObject1, paramaa.ojK.getTextSize()) + "  ", localSpannableString }));
    }
    for (;;)
    {
      localObject1 = d.oyS;
      d.h(paramaa.ojK);
      paramaa.olm.setTag(paramw);
      paramaa.olm.setOnClickListener(this.ogu);
      if (!y.ftF()) {
        break;
      }
      paramaa.fVV.setVisibility(0);
      paramaa.oln.setVisibility(8);
      paramaa.fVV.setText(com.tencent.mm.plugin.brandservice.ui.b.b.f(this.ofS, paramw.field_createTime));
      paramaa.olm.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(175418);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
          b.this.ogf = paramw;
          b.this.ogr.d(b.this.ogf, 20);
          b.this.bPg();
          com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$5", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(175418);
          return false;
        }
      });
      AppMethodBeat.o(5877);
      return;
      paramaa.ojK.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.ofS, (CharSequence)localObject1, paramaa.ojK.getTextSize()));
    }
    paramaa.fVV.setVisibility(8);
    paramaa.oln.setVisibility(0);
    paramaa.olm.setOnLongClickListener(null);
    paramaa.oln.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(175419);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        b.this.ogf = paramw;
        b.this.ogr.d(b.this.ogf, 19);
        b.this.bPg();
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$6", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(175419);
      }
    });
    com.tencent.mm.ui.tools.o.gZ(paramaa.oln);
    AppMethodBeat.o(5877);
  }
  
  private static boolean a(com.tencent.mm.storage.w paramw)
  {
    return (paramw == null) || (paramw.field_type == 34) || (paramw.field_type == 3);
  }
  
  private boolean a(com.tencent.mm.storage.w paramw, int paramInt)
  {
    AppMethodBeat.i(5874);
    if (ogk != null)
    {
      if (ogk.longValue() == paramw.field_orderFlag)
      {
        AppMethodBeat.o(5874);
        return true;
      }
      AppMethodBeat.o(5874);
      return false;
    }
    long l2 = paramw.fsY();
    long l1 = 0L;
    com.tencent.mm.storage.w localw = zz(paramInt - 1);
    if (localw != null) {
      l1 = localw.fsY();
    }
    if ((l2 != l1) && (ogm != null) && (l1 == ogm.longValue()))
    {
      ogk = Long.valueOf(paramw.field_orderFlag);
      AppMethodBeat.o(5874);
      return true;
    }
    AppMethodBeat.o(5874);
    return false;
  }
  
  private void bPf()
  {
    AppMethodBeat.i(5866);
    bPj();
    if (this.ogp)
    {
      Object localObject = bPi();
      if ((localObject != null) && (!((com.tencent.mm.storage.w)localObject).fth()))
      {
        localObject = this.mMj.iterator();
        com.tencent.mm.storage.w localw;
        for (long l = -1L; ((Iterator)localObject).hasNext(); l = localw.fsY())
        {
          localw = (com.tencent.mm.storage.w)((Iterator)localObject).next();
          if ((l != -1L) && (l != localw.fsY()))
          {
            ogk = Long.valueOf(localw.field_orderFlag);
            AppMethodBeat.o(5866);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(5866);
  }
  
  private void bPk()
  {
    com.tencent.mm.storage.w localw = null;
    AppMethodBeat.i(5886);
    Cursor localCursor = com.tencent.mm.al.ag.aGv().hKK.a("SELECT * FROM BizTimeLineInfo order by orderFlag asc limit 1", null, 0);
    if (localCursor.moveToFirst())
    {
      localw = new com.tencent.mm.storage.w();
      localw.convertFrom(localCursor);
    }
    localCursor.close();
    if (localw != null) {
      this.ogn = localw.fsY();
    }
    AppMethodBeat.o(5886);
  }
  
  private static void cl(List<com.tencent.mm.storage.w> paramList)
  {
    AppMethodBeat.i(5867);
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(5867);
      return;
    }
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.BizTimeLineAdapter", "alvinluo doUpdateListCellPosition list: %d", new Object[] { Integer.valueOf(paramList.size()) });
    long l = System.currentTimeMillis();
    Object localObject = (com.tencent.mm.storage.w)paramList.get(0);
    ((com.tencent.mm.storage.w)localObject).ole = 1;
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
        localw.ole = k;
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
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.BizTimeLineAdapter", "alvinluo doUpdateListCellPosition cost: %d, startCellPosition: %d, size: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(1), Integer.valueOf(paramList.size()) });
    AppMethodBeat.o(5867);
  }
  
  public static void cn(List<com.tencent.mm.storage.w> paramList)
  {
    AppMethodBeat.i(5883);
    com.tencent.mm.pluginsdk.ui.applet.g localg = com.tencent.mm.pluginsdk.ui.applet.g.FnF;
    if (com.tencent.mm.pluginsdk.ui.applet.g.Zv(1)) {
      cl(paramList);
    }
    AppMethodBeat.o(5883);
  }
  
  public final void XR(String paramString)
  {
    AppMethodBeat.i(5872);
    com.tencent.mm.kernel.g.ajS();
    if ((com.tencent.mm.kernel.a.mQ(com.tencent.mm.kernel.g.ajP().gDe)) && (!this.ogs.contains(paramString)))
    {
      com.tencent.mm.modelsimple.ab.ar(paramString, 2);
      this.ogs.add(paramString);
    }
    AppMethodBeat.o(5872);
  }
  
  public final void a(final v paramv, final com.tencent.mm.storage.w paramw, int paramInt1, com.tencent.mm.ah.u paramu, View paramView, boolean paramBoolean, final int paramInt2)
  {
    AppMethodBeat.i(5876);
    ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a(paramv, paramw, paramInt1, paramu, paramView, paramBoolean, paramInt2, this.ogv);
    if ((paramv.type == 5) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bOe())) {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(5859);
          Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
          ((com.tencent.mm.hellhoundlib.b.b)localObject1).bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).ahF());
          if (paramInt2 == 0)
          {
            paramAnonymousView = MPVideoPreviewMgr.ovZ;
            localObject1 = paramv.hCa;
            if ((MPVideoPreviewMgr.bSZ()) && (!bu.isNullOrNil(MPVideoPreviewMgr.ovU)))
            {
              if (!d.g.b.p.i(MPVideoPreviewMgr.ovU, localObject1)) {
                break label360;
              }
              paramAnonymousView = MPVideoPreviewMgr.ovR;
              if (paramAnonymousView != null)
              {
                paramAnonymousView = (AppBrandVideoWrapper)paramAnonymousView.get();
                if (paramAnonymousView != null) {
                  break label295;
                }
              }
            }
          }
          int j = (int)(System.currentTimeMillis() / 1000L);
          paramAnonymousView = new Bundle();
          localObject1 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramw.field_talker);
          if ((localObject1 != null) && (!com.tencent.mm.contact.c.lO(((aw)localObject1).field_type))) {}
          for (int i = 157;; i = 90)
          {
            paramAnonymousView.putInt(e.b.JoV, i);
            i = b.a(b.this).getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
            paramAnonymousView.putInt(e.b.JoW, i);
            paramAnonymousView.putInt("geta8key_scene", 56);
            localObject1 = com.tencent.mm.plugin.webview.ui.tools.video.a.EHX;
            com.tencent.mm.plugin.webview.ui.tools.video.a.aKS(paramv.hCa);
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a(b.a(b.this), paramw.field_msgId, paramw.field_msgSvrId, paramInt2, paramAnonymousView);
            b.b(b.this).a(paramw, paramInt2, j);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/brandservice/ui/timeline/BizTimeLineAdapter$4", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(5859);
            return;
            label295:
            d.g.b.p.g(paramAnonymousView, "weakVideoWrapper?.get() ?: return");
            Object localObject2 = com.tencent.mm.plugin.webview.ui.tools.video.a.EHX;
            localObject2 = MPVideoPreviewMgr.ovU;
            i = paramAnonymousView.getCurrPosSec();
            j = (int)(System.currentTimeMillis() / 1000L + 600L);
            if (paramAnonymousView != null)
            {
              paramAnonymousView = paramAnonymousView.getTexture();
              if (paramAnonymousView != null)
              {
                paramAnonymousView = paramAnonymousView.getBitmap();
                label347:
                com.tencent.mm.plugin.webview.ui.tools.video.a.a((String)localObject2, i, j, paramAnonymousView);
                MPVideoPreviewMgr.aIJ((String)localObject1);
                label360:
                paramAnonymousView = MPVideoPreviewMgr.ovS;
                localObject1 = MPVideoPreviewMgr.ovQ;
                if (localObject1 == null) {
                  break label438;
                }
                localObject1 = (AppBrandVideoView)((WeakReference)localObject1).get();
                if (localObject1 == null) {
                  break label438;
                }
              }
            }
            label438:
            for (long l = ((AppBrandVideoView)localObject1).getCurrPosMs();; l = 0L)
            {
              paramAnonymousView.owe = l;
              MPVideoPreviewMgr.ovS.md(4);
              MPVideoPreviewMgr.ovS.md(3);
              MPVideoPreviewMgr.ovS.g(null);
              MPVideoPreviewMgr.ail("IDLE");
              break;
              paramAnonymousView = null;
              break label347;
            }
          }
        }
      });
    }
    AppMethodBeat.o(5876);
  }
  
  public final void b(com.tencent.mm.storage.w paramw)
  {
    AppMethodBeat.i(5873);
    if (paramw == null)
    {
      com.tencent.mm.sdk.platformtools.ae.w("MicroMsg.BizTimeLineAdapter", "updateGroupId info is null");
      AppMethodBeat.o(5873);
      return;
    }
    final long l1 = paramw.fsY();
    long l2 = com.tencent.mm.al.ag.aGv().fts();
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.BizTimeLineAdapter", "updateGroupId keep %b, groupId %d, maxGroupId %d", new Object[] { Boolean.valueOf(this.ogp), Long.valueOf(l1), Long.valueOf(l2) });
    if ((!this.ogp) && (l1 == l2))
    {
      l1 = paramw.field_orderFlag;
      com.tencent.mm.cm.g.eu(Long.valueOf(l1)).h(new com.tencent.mm.vending.c.a() {}).b(new com.tencent.mm.vending.c.a() {});
    }
    AppMethodBeat.o(5873);
  }
  
  public final void b(com.tencent.mm.storage.w paramw, int paramInt)
  {
    AppMethodBeat.i(208450);
    this.ogr.a(paramw, paramInt, (int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(208450);
  }
  
  public final void bPg()
  {
    AppMethodBeat.i(208449);
    com.tencent.mm.ui.widget.a.e locale = new com.tencent.mm.ui.widget.a.e(this.ofS, 1, false);
    locale.LfS = new n.d()
    {
      public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymousl)
      {
        AppMethodBeat.i(175420);
        an localan = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(b.this.ogf.field_talker);
        paramAnonymousl.jM(10, 2131756602);
        if ((localan != null) && (com.tencent.mm.contact.c.lO(localan.field_type))) {
          paramAnonymousl.a(2, b.a(b.this).getResources().getColor(2131099803), b.a(b.this).getString(2131761049));
        }
        AppMethodBeat.o(175420);
      }
    };
    locale.LfT = this.ogj;
    locale.cPF();
    AppMethodBeat.o(208449);
  }
  
  public final com.tencent.mm.storage.w bPh()
  {
    AppMethodBeat.i(5880);
    if (this.mMj.size() > 0)
    {
      com.tencent.mm.storage.w localw = (com.tencent.mm.storage.w)this.mMj.get(this.mMj.size() - 1);
      AppMethodBeat.o(5880);
      return localw;
    }
    AppMethodBeat.o(5880);
    return null;
  }
  
  public final com.tencent.mm.storage.w bPi()
  {
    AppMethodBeat.i(5881);
    if (this.mMj.size() > 0)
    {
      com.tencent.mm.storage.w localw = (com.tencent.mm.storage.w)this.mMj.get(0);
      AppMethodBeat.o(5881);
      return localw;
    }
    AppMethodBeat.o(5881);
    return null;
  }
  
  public final void bPj()
  {
    AppMethodBeat.i(5884);
    com.tencent.mm.storage.w localw = bPi();
    if (localw != null) {
      ogm = Long.valueOf(localw.fsY());
    }
    ogk = null;
    ogl = null;
    AppMethodBeat.o(5884);
  }
  
  final void cm(List<com.tencent.mm.storage.w> paramList)
  {
    AppMethodBeat.i(5882);
    com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.BizTimeLineAdapter", "alvinluo filterAndAddList size: %d", new Object[] { Integer.valueOf(paramList.size()) });
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      if (!a((com.tencent.mm.storage.w)paramList.get(i))) {
        localLinkedList.add(paramList.get(i));
      }
      i += 1;
    }
    this.mMj.addAll(localLinkedList);
    AppMethodBeat.o(5882);
  }
  
  public final void eP(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5887);
    ArrayList localArrayList = new ArrayList();
    if (paramInt1 <= paramInt2)
    {
      Object localObject = zz(paramInt1);
      long l;
      String str;
      if ((localObject != null) && (((com.tencent.mm.storage.w)localObject).field_type == 285212721))
      {
        com.tencent.mm.sdk.platformtools.ae.v("MicroMsg.BizTimeLineAdapter", "terry checkpreload:" + ((com.tencent.mm.storage.w)localObject).field_msgId);
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
    int i = this.mMj.size();
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
    com.tencent.mm.storage.w localw = zz(paramInt);
    if (localw == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.BizTimeLineAdapter", "getItemViewType info is null");
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
    com.tencent.mm.storage.w localw = zz(paramInt);
    if (localw == null)
    {
      com.tencent.mm.sdk.platformtools.ae.e("MicroMsg.BizTimeLineAdapter", "getView info is null");
      AppMethodBeat.o(5871);
      return paramView;
    }
    if ((paramInt == getCount() - 1) && (!this.ogw)) {
      ar.o(new Runnable()
      {
        public final void run()
        {
          int j = 0;
          AppMethodBeat.i(5856);
          if ((paramInt == b.this.getCount() - 1) && (!b.this.ogw))
          {
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BizTimeLineAdapter", "loadMoreData %d/%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(b.this.getCount()) });
            b localb = b.this;
            Object localObject = localb.bPh();
            int i = j;
            if (localObject != null)
            {
              localObject = com.tencent.mm.al.ag.aGv().aP(10, ((com.tencent.mm.storage.w)localObject).field_orderFlag);
              localb.cm((List)localObject);
              com.tencent.mm.plugin.brandservice.ui.b.c.a((List)localObject, new b.3(localb));
              localb.notifyDataSetChanged();
              i = j;
              if (((List)localObject).size() > 0) {
                i = 1;
              }
            }
            if (i == 0)
            {
              b.this.ogw = true;
              b.a(b.this).bPn();
              AppMethodBeat.o(5856);
              return;
            }
            b.this.ogi.ZC();
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
        paramViewGroup = new al();
        paramView = this.ofS;
        if (paramViewGroup.oiV != null)
        {
          paramView = paramViewGroup.oiV;
          paramView.setTag(paramViewGroup);
          a(paramViewGroup, localw);
          a(paramInt, localw, paramViewGroup.okB, paramViewGroup.okA);
        }
      }
      break;
    case 285212721: 
      for (;;)
      {
        if ((!this.ogp) && (!this.dus))
        {
          this.ogr.c(localw, paramInt);
          XR(localw.field_talker);
        }
        AppMethodBeat.o(5871);
        return paramView;
        if (!this.ogp) {
          com.tencent.mm.plugin.brandservice.ui.b.c.l(localw);
        }
        if (paramView == null)
        {
          localObject1 = new com.tencent.mm.plugin.brandservice.ui.timeline.item.ab();
          paramViewGroup = View.inflate(this.ofS, 2131493210, null);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).olp = ((LinearLayout)paramViewGroup.findViewById(2131297332));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).olq = ((LinearLayout)paramViewGroup.findViewById(2131304785));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).olr = ((TextView)paramViewGroup.findViewById(2131304786));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).okA = ((LinearLayout)paramViewGroup.findViewById(2131297356));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).okB = ((LinearLayout)paramViewGroup.findViewById(2131297346));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).oiV = paramViewGroup;
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).bPJ();
          paramViewGroup.setTag(localObject1);
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).b(this.ofS, this);
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).ols.iterator();
          while (paramView.hasNext())
          {
            localObject2 = (com.tencent.mm.plugin.brandservice.ui.timeline.item.x)paramView.next();
            ap.aC(((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject2).oiV, 3);
            ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).olp.removeView(((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject2).oiV);
          }
          localObject1 = (com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)paramView.getTag();
          paramViewGroup = paramView;
        }
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).ols.clear();
        localObject2 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(localw.field_msgId, localw.field_content);
        localObject3 = ((com.tencent.mm.ah.u)localObject2).hFT;
        k = ((List)localObject3).size();
        if (k != 0) {
          break;
        }
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).olp.setVisibility(8);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).a((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1, -1, 0);
        paramView = paramViewGroup;
      }
      ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).olp.setVisibility(0);
      localObject4 = (v)((List)localObject3).get(0);
      com.tencent.mm.plugin.brandservice.ui.timeline.item.ab.c((v)localObject4);
      bool1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.a(localw, (v)localObject4);
      if (bool1) {
        if ((bu.isNullOrNil(((v)localObject4).hGe)) && (((v)localObject4).type != 7) && (((v)localObject4).type != 10)) {
          bool1 = false;
        }
      }
      break;
    }
    label604:
    label1123:
    label1255:
    label3049:
    for (;;)
    {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).a((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1, -1, k);
      localw.IID = bool1;
      Object localObject5 = ((Activity)((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).mContext).getLayoutInflater();
      int i = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).ols.size();
      label636:
      if (i < k)
      {
        paramView = ap.adH(3);
        if (paramView != null) {
          break label7023;
        }
        paramView = ((LayoutInflater)localObject5).inflate(2131493211, null);
      }
      label2796:
      label7023:
      for (;;)
      {
        Object localObject7 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).oll;
        Object localObject8 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).mContext;
        Object localObject6 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).olp;
        localObject7 = new com.tencent.mm.plugin.brandservice.ui.timeline.item.x((b)localObject7, (Context)localObject8);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject7).oiV = paramView;
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject7).iFF = paramView.findViewById(2131306012);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject7).okQ = paramView.findViewById(2131298764);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject7).okR = ((MMNeat7extView)paramView.findViewById(2131305938));
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject7).okS = ((TextView)paramView.findViewById(2131305546));
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject7).okT = paramView.findViewById(2131298814);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject7).oic = ((ImageView)paramView.findViewById(2131298824));
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject7).okW = ((ImageView)paramView.findViewById(2131303284));
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject7).okU = paramView.findViewById(2131297330);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject7).okV = ((ImageView)paramView.findViewById(2131297370));
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject7).oiv = paramView.findViewById(2131305184);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject7).oiw = ((TextView)paramView.findViewById(2131300305));
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject7).okX = paramView.findViewById(2131303255);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject7).okY = paramView.findViewById(2131303254);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject7).okZ = ((TextView)paramView.findViewById(2131303263));
        ((ViewGroup)localObject6).addView(paramView, ((ViewGroup)localObject6).getChildCount());
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).ols.add(localObject7);
        i += 1;
        break label636;
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).a((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1, ((v)((List)localObject3).get(0)).type, k);
        break label604;
        i = 0;
        while (i < ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).ols.size())
        {
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).ols.get(i)).oiV.setVisibility(8);
          i += 1;
        }
        int m;
        int j;
        boolean bool2;
        if (bool1)
        {
          if (((v)localObject4).type == 5) {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).olu.a(k, (v)localObject4, localw, paramInt, (com.tencent.mm.ah.u)localObject2, localw.ole);
          }
        }
        else
        {
          if ((k <= 2) || (localw.field_isExpand)) {
            break label1765;
          }
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).olq.setVisibility(0);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).olr.setText(((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).mContext.getString(2131756641, new Object[] { Integer.valueOf(k - 2) }));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).olq.setTag(localw);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).olq.setOnClickListener(((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).olA);
          if (!bool1) {
            break label1778;
          }
          i = 1;
          if ((i >= k) || ((!localw.field_isExpand) && (i > 1))) {
            break label2566;
          }
          localObject5 = (v)((List)localObject3).get(i);
          m = localw.ole + i;
          com.tencent.mm.plugin.brandservice.ui.timeline.item.ab.c((v)localObject5);
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).ols;
          if (!bool1) {
            break label1784;
          }
          j = i - 1;
          localObject6 = (com.tencent.mm.plugin.brandservice.ui.timeline.item.x)paramView.get(j);
          j = ((v)localObject4).type;
          if (i != 0) {
            break label1791;
          }
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).iFF.setVisibility(8);
          if (bool1) {
            break label2122;
          }
          if (i != 0) {
            break label2023;
          }
          if (k != 1) {
            break label2001;
          }
          com.tencent.mm.plugin.brandservice.ui.timeline.item.ab.s(((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).okQ, ofZ, ofW);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).a((v)localObject5, localw, i, false);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).a((v)localObject5, false);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).a(((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).oiv, ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).oiw, localw, (v)localObject5);
          if (!bu.isNullOrNil(((v)localObject5).title)) {
            break label2278;
          }
          paramView = com.tencent.mm.plugin.brandservice.b.a.obW;
          switch (((v)localObject5).type)
          {
          case 6: 
          default: 
            paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).mContext.getResources().getString(2131756613);
            com.tencent.mm.plugin.brandservice.b.a.a(paramView, ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).okR, (v)localObject5, 1);
            ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).okR.setTextColor(((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).mContext.getResources().getColor(2131099732));
            if ((((v)localObject5).hGh == 0) || (((v)localObject5).hGh == 1))
            {
              ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).okT.setVisibility(0);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).okR.setTextColor(((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).mContext.getResources().getColor(2131099732));
              if (((v)localObject5).type == 7)
              {
                ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).oic.setVisibility(8);
                if ((bu.isNullOrNil(((v)localObject5).hGg)) || (((v)localObject5).type != 3)) {
                  break label2533;
                }
                ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).okS.setText(((v)localObject5).hGg);
                ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).okS.setVisibility(0);
                ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).oiV.setVisibility(0);
                paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).oll;
                localObject7 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).oiV;
                if (k <= 1) {
                  break label2546;
                }
                bool2 = true;
                label1534:
                paramView.a((v)localObject5, localw, paramInt, (com.tencent.mm.ah.u)localObject2, (View)localObject7, bool2, i);
                if ((i != k - 1) || (((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).olq.getVisibility() == 0)) {
                  break label2552;
                }
                ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).oiV.setBackgroundResource(2131231256);
              }
            }
            break;
          }
        }
        label1778:
        label1784:
        label1791:
        long l;
        for (;;)
        {
          i += 1;
          break label1123;
          if (((v)localObject4).type == 8)
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).olw.a(k, (v)localObject4, localw, paramInt, (com.tencent.mm.ah.u)localObject2, localw.ole);
            break;
          }
          if (((v)localObject4).type == 7)
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).olx.a(k, (v)localObject4, localw, paramInt, (com.tencent.mm.ah.u)localObject2, localw.ole);
            break;
          }
          if (((v)localObject4).type == 6)
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).oly.a(k, (v)((List)localObject3).get(0), localw, paramInt, (com.tencent.mm.ah.u)localObject2, localw.ole);
            break;
          }
          if (((v)localObject4).type == 10)
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).olz.a(k, (v)localObject4, localw, paramInt, (com.tencent.mm.ah.u)localObject2, localw.ole);
            break;
          }
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).olt.a(k, (v)localObject4, localw, paramInt, (com.tencent.mm.ah.u)localObject2, localw.ole);
          break;
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).olq.setVisibility(8);
          break label1115;
          i = 0;
          break label1123;
          j = i;
          break label1190;
          if ((i == 1) && (bool1) && (j != 7) && (j != 5) && (j != 6)) {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).iFF.setVisibility(8);
          }
          for (;;)
          {
            if ((!bool1) || (i > 0))
            {
              paramView = (v)((List)localObject3).get(i - 1);
              localObject7 = (v)((List)localObject3).get(i);
              if (((paramView.type != 7) && (paramView.type != 5) && (paramView.type != 6) && (bu.isNullOrNil(paramView.hGe))) || ((((v)localObject7).type != 7) && (((v)localObject7).type != 5) && (((v)localObject7).type != 6) && (bu.isNullOrNil(((v)localObject7).hGe))))
              {
                com.tencent.mm.plugin.brandservice.ui.timeline.item.ab.Y(((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).iFF, ogb);
                break;
                ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).iFF.setVisibility(0);
                continue;
              }
              com.tencent.mm.plugin.brandservice.ui.timeline.item.ab.Y(((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).iFF, oga);
              break;
            }
          }
          com.tencent.mm.plugin.brandservice.ui.timeline.item.ab.Y(((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).iFF, ogb);
          break label1225;
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).okQ;
          j = ofZ;
          com.tencent.mm.plugin.brandservice.ui.timeline.item.ab.s(paramView, j, j);
          break label1255;
          if (i == 1)
          {
            if (k == 2)
            {
              com.tencent.mm.plugin.brandservice.ui.timeline.item.ab.s(((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).okQ, ofZ, ofW);
              break label1255;
            }
            paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).okQ;
            j = ofZ;
            com.tencent.mm.plugin.brandservice.ui.timeline.item.ab.s(paramView, j, j);
            break label1255;
          }
          if (i == k - 1)
          {
            com.tencent.mm.plugin.brandservice.ui.timeline.item.ab.s(((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).okQ, ofZ, ofW);
            break label1255;
          }
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).okQ;
          j = ofZ;
          com.tencent.mm.plugin.brandservice.ui.timeline.item.ab.s(paramView, j, j);
          break label1255;
          if (i == 1)
          {
            if (i == k - 1)
            {
              paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).okQ;
              j = ofW;
              com.tencent.mm.plugin.brandservice.ui.timeline.item.ab.s(paramView, j, j);
              break label1255;
            }
            com.tencent.mm.plugin.brandservice.ui.timeline.item.ab.s(((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).okQ, ofW, ofZ);
            break label1255;
          }
          if (i == k - 1)
          {
            com.tencent.mm.plugin.brandservice.ui.timeline.item.ab.s(((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).okQ, ofZ, ofW);
            break label1255;
          }
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).okQ;
          j = ofZ;
          com.tencent.mm.plugin.brandservice.ui.timeline.item.ab.s(paramView, j, j);
          break label1255;
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).mContext.getResources().getString(2131756623);
          break label1359;
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).mContext.getResources().getString(2131756624);
          break label1359;
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).mContext.getResources().getString(2131756614);
          break label1359;
          paramView = com.tencent.mm.plugin.brandservice.b.a.obW;
          com.tencent.mm.plugin.brandservice.b.a.a(((v)localObject5).title, ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).okR, (v)localObject5, 1);
          break label1371;
          if (!bu.isNullOrNil(((v)localObject5).hGe))
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).oic.setVisibility(0);
            if (bu.isNullOrNil(((v)localObject5).hGv)) {}
            for (paramView = ((v)localObject5).hGe;; paramView = ((v)localObject5).hGv)
            {
              localObject7 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).oll.ogi;
              l = localw.field_msgId;
              localObject8 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).oic;
              j = ofV;
              ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject7).a(l, i, (v)localObject5, paramView, (ImageView)localObject8, j, j, false, new ab.2((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1, (com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6, (v)localObject5, localw, i), m, 2.0F);
              break;
            }
          }
          if ((((v)localObject5).type == 5) || (((v)localObject5).type == 6))
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).oic.setVisibility(0);
            paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).oll.ogi;
            localObject7 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).oic;
            j = ofV;
            paramView.a("2131231674", (ImageView)localObject7, j, j, m);
            break label1461;
          }
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).okT.setVisibility(8);
          break label1461;
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).okT.setVisibility(8);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).okR.setTextColor(((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).mContext.getResources().getColor(2131099735));
          break label1461;
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).okS.setVisibility(8);
          break label1503;
          label2546:
          bool2 = false;
          break label1534;
          label2552:
          ((com.tencent.mm.plugin.brandservice.ui.timeline.item.x)localObject6).oiV.setBackgroundResource(2131231262);
        }
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).oll.a(paramInt, localw, ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).okB, ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).okA);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.item.ab)localObject1).oll.a((com.tencent.mm.plugin.brandservice.ui.timeline.item.aa)localObject1, localw);
        paramView = paramViewGroup;
        break label188;
        if (paramView == null)
        {
          paramViewGroup = new ad();
          paramView = paramViewGroup.a(this.ofS, this);
          paramView.setTag(paramViewGroup);
          localObject2 = paramViewGroup.mContext;
          localObject3 = localw.field_content;
          i = (int)paramViewGroup.oip.getTextSize();
          if (localw == null) {
            break label2988;
          }
          localObject1 = com.tencent.mm.model.z.Br(localw.field_msgSvrId);
          localObject4 = com.tencent.mm.model.z.aBG().F((String)localObject1, true);
          ((z.b)localObject4).k("prePublishId", "msg_" + localw.field_msgSvrId);
          ((z.b)localObject4).k("preUsername", localw.field_talker);
          localObject1 = com.tencent.mm.pluginsdk.ui.span.k.a((Context)localObject2, (CharSequence)localObject3, i, 1, null, (String)localObject1);
          paramViewGroup.oip.setMaxLines(2147483647);
          paramViewGroup.oip.aq((CharSequence)localObject1);
          if (!localw.field_isExpand) {
            break label2994;
          }
          paramViewGroup.olJ.setText(paramViewGroup.mContext.getString(2131756619));
          i = com.tencent.mm.cb.a.iu(paramViewGroup.mContext);
          j = com.tencent.mm.cb.a.fromDPToPix(paramViewGroup.mContext, 72);
          localObject1 = paramViewGroup.oip.kR(i - j, 2147483647);
          if (localObject1 == null) {
            break label7017;
          }
        }
        for (i = ((com.tencent.neattextview.textview.layout.a)localObject1).fXb();; i = 0)
        {
          if (i > 4)
          {
            if (!localw.field_isExpand) {
              paramViewGroup.oip.setMaxLines(4);
            }
            paramViewGroup.olJ.setVisibility(0);
            if (localw.field_isExpand)
            {
              paramViewGroup.olJ.setText(2131756619);
              paramViewGroup.olJ.setOnClickListener(new ad.1(paramViewGroup, localw));
              localObject1 = (LinearLayout.LayoutParams)paramViewGroup.oip.getLayoutParams();
              if (i > 4) {
                break label3049;
              }
            }
          }
          for (((LinearLayout.LayoutParams)localObject1).gravity = 17;; ((LinearLayout.LayoutParams)localObject1).gravity = 19)
          {
            paramViewGroup.oip.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            paramViewGroup.oll.a(paramViewGroup, localw);
            paramViewGroup.oll.a(paramInt, localw, paramViewGroup.okB, paramViewGroup.okA);
            break;
            paramViewGroup = (ad)paramView.getTag();
            break label2631;
            localObject1 = null;
            break label2737;
            paramViewGroup.olJ.setText(paramViewGroup.mContext.getString(2131756620));
            break label2796;
            paramViewGroup.olJ.setText(2131756620);
            break label2895;
            paramViewGroup.oip.setMaxLines(2147483647);
            paramViewGroup.olJ.setVisibility(8);
            break label2912;
          }
          if (paramView == null)
          {
            paramViewGroup = new am();
            paramView = paramViewGroup.a(this.ofS, this);
            paramView.setTag(paramViewGroup);
            localw.IID = com.tencent.mm.plugin.brandservice.ui.b.a.k(localw);
            if (!localw.IID) {
              break label3427;
            }
            paramViewGroup.oli.setVisibility(0);
            paramViewGroup.olj.setVisibility(8);
            localObject2 = paramViewGroup.oip;
            localObject1 = paramViewGroup.okW;
            localObject3 = new com.tencent.mm.modelvoice.p(localw.field_content);
            ((MMNeat7extView)localObject2).aq(i.formatTime("yyyy/MM/dd", System.currentTimeMillis() / 1000L));
            if (localw.IID)
            {
              localObject2 = com.tencent.mm.ah.m.ol((int)(((com.tencent.mm.modelvoice.p)localObject3).getTime() / 1000L));
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                break label3500;
              }
              paramViewGroup.omf.setVisibility(0);
              paramViewGroup.omf.setText((CharSequence)localObject2);
              paramViewGroup.olI.setOnClickListener(new am.2(paramViewGroup));
              paramViewGroup.olI.setBackgroundResource(2131231692);
              localObject2 = paramViewGroup.olI;
              i = ofX;
              j = ofW;
              k = ofX;
              ((View)localObject2).setPadding(i, j, k, k);
            }
            localObject2 = ((ImageView)localObject1).getDrawable();
            if (((localObject2 instanceof AnimationDrawable)) && (((AnimationDrawable)localObject2).isRunning())) {
              ((AnimationDrawable)localObject2).stop();
            }
            if ((!paramViewGroup.oll.ogo.isPlaying()) || (localw.field_msgId != paramViewGroup.oll.ogo.bPt())) {
              break label3512;
            }
            ((ImageView)localObject1).setImageResource(2131231676);
            if ((((ImageView)localObject1).getDrawable() instanceof AnimationDrawable)) {
              ((AnimationDrawable)((ImageView)localObject1).getDrawable()).start();
            }
          }
          for (;;)
          {
            ((ImageView)localObject1).setOnClickListener(new am.3(paramViewGroup, localw, (ImageView)localObject1));
            paramViewGroup.oll.a(paramViewGroup, localw);
            paramViewGroup.oll.a(paramInt, localw, paramViewGroup.okB, paramViewGroup.okA);
            break;
            paramViewGroup = (am)paramView.getTag();
            break label3086;
            paramViewGroup.iFF.setVisibility(8);
            paramViewGroup.oli.setVisibility(8);
            paramViewGroup.olj.setVisibility(0);
            paramViewGroup.omi.setVisibility(8);
            paramViewGroup.omh.setVisibility(0);
            localObject2 = paramViewGroup.omj;
            localObject1 = paramViewGroup.omh;
            paramViewGroup.olj.setOnClickListener(new am.1(paramViewGroup));
            break label3133;
            paramViewGroup.omf.setVisibility(8);
            break label3213;
            ((ImageView)localObject1).setImageResource(2131231675);
          }
          if (paramView == null)
          {
            paramViewGroup = new com.tencent.mm.plugin.brandservice.ui.timeline.item.z();
            paramView = paramViewGroup.a(this.ofS, this);
            paramView.setTag(paramViewGroup);
          }
          for (;;)
          {
            if (this.ogq == null) {
              this.ogq = new c(this.ofS);
            }
            localObject1 = this.ogq;
            paramViewGroup.oll.a(paramViewGroup, localw);
            paramViewGroup.oll.a(paramInt, localw, paramViewGroup.okB, paramViewGroup.okA);
            localw.IID = com.tencent.mm.plugin.brandservice.ui.b.a.k(localw);
            if (!localw.IID) {
              break label3703;
            }
            paramViewGroup.olj.setVisibility(8);
            paramViewGroup.oli.setVisibility(0);
            paramViewGroup.dF(paramViewGroup.olg);
            paramViewGroup.dF(paramViewGroup.olf);
            ((c)localObject1).a(localw, paramInt, paramViewGroup.olf, ofT);
            paramViewGroup.olg.setOnClickListener(new z.1(paramViewGroup, localw));
            break;
            paramViewGroup = (com.tencent.mm.plugin.brandservice.ui.timeline.item.z)paramView.getTag();
          }
          label3703:
          paramViewGroup.olj.setVisibility(0);
          paramViewGroup.oli.setVisibility(8);
          paramViewGroup.iFF.setVisibility(8);
          paramViewGroup.oip.aq(paramViewGroup.mContext.getText(2131756612));
          ((c)localObject1).a(localw, paramInt, paramViewGroup.olh, 0);
          paramViewGroup.olj.setOnClickListener(new z.2(paramViewGroup, localw));
          break label188;
          if (!this.ogp) {
            com.tencent.mm.plugin.brandservice.ui.b.c.n(localw);
          }
          if (paramView == null)
          {
            localObject1 = new s(this.ofS, this);
            paramViewGroup = ((s)localObject1).okz;
            paramViewGroup.setTag(localObject1);
          }
          for (;;)
          {
            d.g.b.p.h(localw, "info");
            d.g.b.p.h(paramViewGroup, "convertView");
            if (localw.ftk() != null) {
              break label3877;
            }
            ((s)localObject1).bPI();
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BizTLRecCardNew", "[TRACE_BIZRECCARD] info null");
            paramView = paramViewGroup;
            break;
            localObject1 = (s)paramView.getTag();
            paramViewGroup = paramView;
          }
          if (!com.tencent.mm.plugin.brandservice.ui.timeline.item.j.zn(localw.IIG.style))
          {
            ((s)localObject1).bPI();
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BizTLRecCardNew", "[TRACE_BIZRECCARD] style = " + localw.IIG.style + " not support");
            paramView = paramViewGroup;
            break label188;
          }
          paramView = localw.IIG;
          d.g.b.p.g(paramView, "info.wrapper");
          if (!com.tencent.mm.storage.aa.b(paramView, localw))
          {
            ((s)localObject1).bPI();
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BizTLRecCardNew", "[TRACE_BIZRECCARD] wrapper illegal");
            paramView = paramViewGroup;
            break label188;
          }
          i = s.zD(localw.IIG.style);
          com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BizTLRecCardNew", "[TRACE_BIZRECCARD] filling style = " + localw.IIG.style + ", clientShowType = " + i);
          ((s)localObject1).ohs.a(paramInt, localw, (View)((s)localObject1).okB, (View)((s)localObject1).okA);
          ((s)localObject1).oku.hide();
          ((s)localObject1).okt.hide();
          ((s)localObject1).oks.hide();
          ((s)localObject1).okv.hide();
          ((s)localObject1).okw.hide();
          ((s)localObject1).okx.hide();
          ((s)localObject1).oky.hide();
          switch (i)
          {
          default: 
            paramView = paramViewGroup;
            break;
          case 1: 
            localObject2 = ((s)localObject1).oku;
            paramView = ((s)localObject1).okz;
            com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1149L, 2L, 1L, false);
            localObject1 = ((t)localObject2).mContext;
            if (((t)localObject2).oiV == null)
            {
              ((t)localObject2).oiV = ((ViewStub)paramView.findViewById(2131307258)).inflate();
              ((t)localObject2).bPJ();
              ((t)localObject2).ojL = ((TextView)((t)localObject2).oiV.findViewById(2131297298));
              ((t)localObject2).ojM = ((t)localObject2).oiV.findViewById(2131298374);
              ((t)localObject2).ojN = ((t)localObject2).oiV.findViewById(2131298373);
              ((t)localObject2).ojO = ((t)localObject2).oiV.findViewById(2131297296);
              ((t)localObject2).ojP = ((TextView)((t)localObject2).oiV.findViewById(2131297297));
              ((t)localObject2).ojQ = ((MMNeat7extView)((t)localObject2).oiV.findViewById(2131297294));
              ((t)localObject2).iFF = ((t)localObject2).oiV.findViewById(2131297295);
              ((t)localObject2).okE = ((t)localObject2).oiV.findViewById(2131297291);
              ((t)localObject2).okF = ((TextView)((t)localObject2).oiV.findViewById(2131297292));
              ((t)localObject2).okG = ((MMNeat7extView)((t)localObject2).oiV.findViewById(2131297293));
              ((WeImageView)((t)localObject2).oiV.findViewById(2131302669)).setIconColor(((Context)localObject1).getResources().getColor(2131099664));
            }
            ((t)localObject2).oiV.setVisibility(0);
            localObject1 = localw.ftj();
            if ((localObject1 == null) || (((dml)localObject1).HTL == null))
            {
              paramViewGroup.setVisibility(8);
              paramView = paramViewGroup;
              break;
            }
            paramViewGroup.setVisibility(0);
            ((t)localObject2).ojL.setText(((dml)localObject1).Gys);
            ((t)localObject2).ojK.getPaint().setFakeBoldText(true);
            paramView = ((t)localObject2).fQl;
            localObject3 = ((dml)localObject1).HTL.Gcs;
            localObject4 = new c.a();
            ((c.a)localObject4).pL(2131231342);
            ((c.a)localObject4).aJr();
            ((c.a)localObject4).aJs();
            q.aJb().a((String)localObject3, paramView, ((c.a)localObject4).aJu());
            ((t)localObject2).ojK.setText(((dml)localObject1).HTL.nJO);
            ((t)localObject2).ojP.setText(((dml)localObject1).HTL.HTN);
            ((t)localObject2).ojQ.aq(((dml)localObject1).HTL.jfY);
            paramView = ((dml)localObject1).HTL.nIJ;
            localObject3 = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.l.class)).azF().BH(paramView);
            if ((localObject3 == null) || (((an)localObject3).adE() <= 0)) {
              au.a.aBQ().a(paramView, "", null);
            }
            ((t)localObject2).ojO.setOnClickListener(new t.1((t)localObject2, paramView, localw));
            if ((((dml)localObject1).Gcu != null) && (((dml)localObject1).Gcu.get(0) != null) && ((((dmm)((dml)localObject1).Gcu.get(0)).FNv & 0x1) == 0))
            {
              paramView = (dmm)((dml)localObject1).Gcu.get(0);
              ((t)localObject2).okE.setVisibility(0);
              ((t)localObject2).iFF.setVisibility(0);
              ((t)localObject2).okF.setText(((dml)localObject1).Gct);
              ((t)localObject2).okG.aq(paramView.Title);
              ((t)localObject2).okE.setOnClickListener(new t.2((t)localObject2, localw, paramView));
              ((t)localObject2).ojO.setBackgroundResource(2131231262);
              if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).zl(1)) && (!bu.isNullOrNil(paramView.FYs)))
              {
                com.tencent.mm.sdk.platformtools.ae.d("MicroMsg.BizTimeLineItem", "preload %s", new Object[] { paramView.FYs });
                ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramView.FYs, paramView.hFR, 90, new Object[0]);
              }
              com.tencent.mm.plugin.brandservice.ui.b.c.m(localw);
              localObject3 = localw.ftk();
              paramView = paramViewGroup;
              if (localObject3 == null) {
                break;
              }
              paramView = ((dml)localObject1).HTM;
              if (paramView != null) {
                break label5035;
              }
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo = null");
              i = 0;
            }
            for (;;)
            {
              if ((i != 0) || (!bu.ht(((dmq)localObject3).HTR))) {
                break label5117;
              }
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] hideNegativeFeedback，BizNickName = %s", new Object[] { ((dml)localObject1).HTL.nJO });
              ((t)localObject2).ojM.setVisibility(8);
              paramView = paramViewGroup;
              break;
              com.tencent.mm.plugin.report.service.g.yxI.idkeyStat(1149L, 6L, 1L, false);
              ((t)localObject2).iFF.setVisibility(8);
              ((t)localObject2).okE.setVisibility(8);
              ((t)localObject2).ojO.setBackgroundResource(2131231256);
              break label4891;
              if (paramView.HTP == null)
              {
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo = null");
                i = 0;
              }
              else if (paramView.HTP.Gcn != 1)
              {
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.ShowNegativeFeedbackReason != 1");
                i = 0;
              }
              else if (bu.ht(paramView.HTP.Gcm))
              {
                com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.NegativeFeedbackReason null");
                i = 0;
              }
              else
              {
                i = 1;
              }
            }
            com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] showNegativeFeedback，BizNickName = %s", new Object[] { ((dml)localObject1).HTL.nJO });
            ((t)localObject2).ojM.setVisibility(0);
            ((t)localObject2).ojM.setOnClickListener(new t.3((t)localObject2, localw, paramInt));
            paramView = paramViewGroup;
            break;
          case 2: 
            ((s)localObject1).oks.a(localw, paramInt, paramViewGroup, ((s)localObject1).okz);
            paramView = paramViewGroup;
            break;
          case 3: 
            ((s)localObject1).okt.a(localw, paramInt, paramViewGroup, ((s)localObject1).okz);
            paramView = paramViewGroup;
            break;
          case 4: 
            localObject2 = ((s)localObject1).okv;
            paramView = ((s)localObject1).okz;
            d.g.b.p.h(localw, "info");
            d.g.b.p.h(paramViewGroup, "convertView");
            d.g.b.p.h(paramView, "parent");
            d.g.b.p.h(paramView, "parent");
            if (((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject2).oiV == null)
            {
              paramView = ((ViewStub)paramView.findViewById(2131308226)).inflate();
              ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject2).oji = paramView.findViewById(2131297276);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject2).ojj = ((ImageView)paramView.findViewById(2131297008));
              ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject2).ojk = ((TextView)paramView.findViewById(2131302860));
              ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject2).ojl = paramView.findViewById(2131298374);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject2).ojm = ((WeImageView)paramView.findViewById(2131298373));
              ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject2).oiW = ((LinearLayout)paramView.findViewById(2131307153));
              ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject2).oiV = paramView;
            }
            localObject1 = localw.ftk();
            d.g.b.p.g(localObject1, "info.tlRecCardWrapper");
            paramView = paramViewGroup;
            if (!com.tencent.mm.plugin.brandservice.ui.timeline.item.m.a((dmq)localObject1)) {
              break;
            }
            paramViewGroup.setVisibility(0);
            paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject2).oiV;
            if (paramView != null) {
              paramView.setVisibility(0);
            }
            paramView = (om)localw.ftk().HTS.Gal.get(0);
            d.g.b.p.g(paramView, "bizInfo");
            a.b.d(((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject2).ojj, paramView.nIJ);
            localObject1 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject2).ojk;
            if (localObject1 != null) {
              ((TextView)localObject1).setText((CharSequence)paramView.nJO);
            }
            localObject1 = d.oyS;
            d.h(((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject2).ojk);
            localObject1 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject2).oji;
            if (localObject1 != null) {
              ((View)localObject1).setOnClickListener((View.OnClickListener)new m.e((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject2, localw));
            }
            localObject1 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject2).oji;
            if (localObject1 != null) {
              ((View)localObject1).setOnLongClickListener((View.OnLongClickListener)new m.f((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject2, localw, paramView));
            }
            if ((!bu.ht((List)paramView.Gcm)) && (paramView.Gcn == 1))
            {
              localObject1 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject2).ojl;
              if (localObject1 != null) {
                ((View)localObject1).setVisibility(0);
              }
              localObject1 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject2).ojl;
              if (localObject1 != null) {
                ((View)localObject1).setOnClickListener((View.OnClickListener)new m.d((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject2, localw, paramView, paramInt));
              }
              switch (((ol)paramView.Gcu.get(0)).hFR)
              {
              default: 
                localObject1 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject2).ojo;
                localObject3 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject2).oiV;
                if (localObject3 == null) {
                  d.g.b.p.gkB();
                }
                ((com.tencent.mm.plugin.brandservice.ui.timeline.item.c)localObject1).a((View)localObject3, localw, paramView);
                ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject2).ojn.hide();
              }
            }
            for (;;)
            {
              ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject2).a(localw, paramView);
              com.tencent.mm.plugin.brandservice.ui.b.c.m(localw);
              paramView = paramViewGroup;
              break;
              localObject1 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject2).ojl;
              if (localObject1 == null) {
                break label5628;
              }
              ((View)localObject1).setVisibility(8);
              break label5628;
              localObject1 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject2).ojn;
              localObject3 = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject2).oiV;
              if (localObject3 == null) {
                d.g.b.p.gkB();
              }
              ((com.tencent.mm.plugin.brandservice.ui.timeline.item.f)localObject1).a((View)localObject3, localw, paramView);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.item.m)localObject2).ojo.hide();
            }
          case 5: 
            paramView = ((s)localObject1).okw;
            localObject3 = ((s)localObject1).okz;
            d.g.b.p.h(localw, "info");
            d.g.b.p.h(paramViewGroup, "convertView");
            d.g.b.p.h(localObject3, "parent");
            localObject2 = "__rec_card_" + localw.field_msgId;
            localObject1 = com.tencent.mm.plugin.webcanvas.g.DQG;
            com.tencent.mm.plugin.webcanvas.g.CH(71L);
            com.tencent.mm.sdk.platformtools.ae.i(paramView.TAG, "filling#".concat(String.valueOf(localObject2)));
            localObject1 = com.tencent.mm.storage.p.IIi;
            if (!com.tencent.mm.storage.p.fsH())
            {
              paramViewGroup.setVisibility(8);
              paramView = paramViewGroup;
              break;
            }
            if (!paramView.ojz)
            {
              localObject1 = com.tencent.mm.plugin.biz.b.b.nUB;
              if (!com.tencent.mm.plugin.biz.b.b.d((String)localObject2, paramViewGroup))
              {
                paramView = com.tencent.mm.plugin.webcanvas.g.DQG;
                com.tencent.mm.plugin.webcanvas.g.CH(73L);
                paramView = paramViewGroup;
                break;
              }
            }
            paramView.ojz = true;
            d.g.b.p.h(localObject3, "parent");
            if (paramView.oiV == null)
            {
              localObject1 = ((ViewStub)((View)localObject3).findViewById(2131308462)).inflate();
              paramView.ojy = ((BizTLRecCardCanvasView)((View)localObject1).findViewById(2131308380));
              paramView.oiV = ((View)localObject1);
            }
            localObject1 = paramView.oiV;
            if (localObject1 != null) {
              ((View)localObject1).setVisibility(0);
            }
            localObject4 = localw.ftk();
            localObject5 = paramView.ojy;
            if (localObject5 != null)
            {
              l = localw.field_msgId;
              localObject1 = ((dmq)localObject4).HTU.HDK;
              paramView = (View)localObject1;
              if (localObject1 == null) {
                paramView = "re";
              }
              localObject1 = ((dmq)localObject4).HTU.data;
              d.g.b.p.g(localObject1, "wrapper.exptInfo.data");
              ((BizTLRecCardCanvasView)localObject5).a(l, (String)localObject2, paramView, (String)localObject1, (View)localObject3);
            }
            paramView = com.tencent.mm.plugin.webcanvas.g.DQG;
            com.tencent.mm.plugin.webcanvas.g.CH(72L);
            paramView = com.tencent.mm.plugin.biz.b.b.nUB;
            com.tencent.mm.plugin.biz.b.b.Xn((String)localObject2);
            paramView = paramViewGroup;
            break;
          case 6: 
            ((s)localObject1).okx.a(localw, paramInt, paramViewGroup, ((s)localObject1).okz);
            paramView = paramViewGroup;
            break;
          case 7: 
            label5117:
            paramView = ((s)localObject1).oky;
            label5628:
            localObject1 = ((s)localObject1).okz;
            d.g.b.p.h(localw, "info");
            d.g.b.p.h(paramViewGroup, "convertView");
            d.g.b.p.h(localObject1, "parent");
            d.g.b.p.h(localObject1, "parent");
            if (paramView.oiV == null)
            {
              localObject1 = ((ViewStub)((View)localObject1).findViewById(2131308525)).inflate();
              paramView.oiW = ((LinearLayout)((View)localObject1).findViewById(2131307153));
              paramView.oki = ((TextView)((View)localObject1).findViewById(2131308342));
              paramView.okJ = ((RelativeLayout)((View)localObject1).findViewById(2131308500));
              paramView.okK = ((RelativeLayout)((View)localObject1).findViewById(2131302452));
              paramView.okL = ((TextView)((View)localObject1).findViewById(2131305811));
              paramView.oiV = ((View)localObject1);
            }
            paramViewGroup.setVisibility(0);
            localObject1 = paramView.oiV;
            if (localObject1 != null) {
              ((View)localObject1).setVisibility(0);
            }
            localObject1 = paramView.okJ;
            if (localObject1 != null) {
              ((RelativeLayout)localObject1).setOnLongClickListener((View.OnLongClickListener)new u.b(paramView, localw));
            }
            localObject1 = paramView.okL;
            if (localObject1 != null) {
              ((TextView)localObject1).setText((CharSequence)com.tencent.mm.plugin.brandservice.ui.b.b.f(paramView.context, localw.field_createTime));
            }
            localObject1 = localw.ftk();
            d.g.b.p.g(localObject1, "info.tlRecCardWrapper");
            localObject2 = ((dmq)localObject1).HTS;
            if (bu.isNullOrNil(((aiq)localObject2).Gyw))
            {
              localObject1 = paramView.oki;
              if (localObject1 != null) {
                ((TextView)localObject1).setVisibility(8);
              }
            }
            for (;;)
            {
              paramView.i(localw);
              paramView = paramViewGroup;
              break;
              localObject3 = paramView.oki;
              if (localObject3 != null) {
                ((TextView)localObject3).setVisibility(0);
              }
              localObject3 = paramView.oki;
              if (localObject3 != null) {
                ((TextView)localObject3).setText((CharSequence)((aiq)localObject2).Gyw);
              }
              localObject3 = d.oyS;
              d.h(paramView.oki);
              if (bu.isNullOrNil(((aiq)localObject2).Gyv))
              {
                localObject1 = paramView.oki;
                if (localObject1 != null) {
                  ((TextView)localObject1).setOnClickListener(null);
                }
                localObject1 = paramView.okK;
                if (localObject1 != null) {
                  ((RelativeLayout)localObject1).setOnClickListener(null);
                }
              }
              else
              {
                localObject1 = (d.g.a.b)new u.e(paramView, (aiq)localObject2, (dmq)localObject1);
                localObject2 = paramView.okJ;
                if (localObject2 != null) {
                  ((RelativeLayout)localObject2).setOnClickListener((View.OnClickListener)new u.c((d.g.a.b)localObject1));
                }
                localObject2 = paramView.okK;
                if (localObject2 != null) {
                  ((RelativeLayout)localObject2).setOnClickListener((View.OnClickListener)new u.d((d.g.a.b)localObject1));
                }
              }
            }
            localObject1 = com.tencent.mm.plugin.webcanvas.g.DQG;
            com.tencent.mm.plugin.webcanvas.g.CH(66L);
            localObject1 = com.tencent.mm.storage.p.IIi;
            if (!com.tencent.mm.storage.p.fsG())
            {
              paramView = new View(this.ofS);
              paramView.setVisibility(8);
              break;
            }
            localObject4 = localw.field_msgId + "_" + localw.ftm();
            if (!localw.ojz)
            {
              localObject1 = com.tencent.mm.plugin.biz.b.b.nUB;
              if (!com.tencent.mm.plugin.biz.b.b.d((String)localObject4, paramView))
              {
                paramView = com.tencent.mm.plugin.webcanvas.g.DQG;
                com.tencent.mm.plugin.webcanvas.g.CH(68L);
                paramView = new View(this.ofS);
                paramView.setVisibility(8);
                break;
              }
            }
            localw.ojz = true;
            if (paramView == null)
            {
              localObject1 = new com.tencent.mm.plugin.brandservice.ui.timeline.item.k(this.ofS, this);
              paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.item.k)localObject1).bPB();
              paramView.setTag(localObject1);
            }
            for (;;)
            {
              d.g.b.p.h(localw, "info");
              d.g.b.p.h(paramView, "convertView");
              d.g.b.p.h(paramViewGroup, "parent");
              localObject5 = "__ad_card_" + localw.ftm();
              com.tencent.mm.sdk.platformtools.ae.i("MicroMsg.BizTLRecCanvas", "filling#".concat(String.valueOf(localObject5)));
              localObject6 = (BizTLRecCardCanvasView)((com.tencent.mm.plugin.brandservice.ui.timeline.item.k)localObject1).oiO.getValue();
              l = localw.field_msgId;
              localObject3 = localw.getPathType();
              localObject2 = localObject3;
              if (localObject3 == null) {
                localObject2 = "ad";
              }
              localObject3 = localw.ftl();
              d.g.b.p.g(localObject3, "info.adData");
              ((BizTLRecCardCanvasView)localObject6).a(l, (String)localObject5, (String)localObject2, (String)localObject3, (View)paramViewGroup);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.item.k)localObject1).ohs.a(paramInt, localw, (View)((com.tencent.mm.plugin.brandservice.ui.timeline.item.k)localObject1).oiP.getValue(), (View)((com.tencent.mm.plugin.brandservice.ui.timeline.item.k)localObject1).oiQ.getValue());
              com.tencent.mm.plugin.brandservice.ui.timeline.item.k.h(localw);
              paramViewGroup = com.tencent.mm.plugin.webcanvas.g.DQG;
              com.tencent.mm.plugin.webcanvas.g.CH(67L);
              paramViewGroup = com.tencent.mm.plugin.biz.b.b.nUB;
              com.tencent.mm.plugin.biz.b.b.Xn((String)localObject4);
              break;
              localObject1 = (com.tencent.mm.plugin.brandservice.ui.timeline.item.k)paramView.getTag();
            }
            paramViewGroup.oiV = View.inflate(paramView, 2131493230, null);
            paramViewGroup.bPJ();
            paramView = paramViewGroup.oiV;
            break label161;
            paramViewGroup = (al)paramView.getTag();
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
      if (com.tencent.mm.al.ag.aGw().bVY() > 0)
      {
        AppMethodBeat.o(5885);
        return false;
      }
      dnu localdnu = com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e.bPQ();
      if ((localdnu != null) && (!bu.ht(localdnu.HUT))) {}
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
  
  public final com.tencent.mm.storage.w zz(int paramInt)
  {
    AppMethodBeat.i(5869);
    if ((paramInt < this.mMj.size()) && (paramInt >= 0))
    {
      com.tencent.mm.storage.w localw = (com.tencent.mm.storage.w)this.mMj.get(paramInt);
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
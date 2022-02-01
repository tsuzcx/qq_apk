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
import com.tencent.mm.al.af;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.g.c.av;
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
import com.tencent.mm.plugin.brandservice.ui.timeline.a.x;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.z;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.z.1;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.z.2;
import com.tencent.mm.plugin.brandservice.ui.timeline.a.z.3;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.aii;
import com.tencent.mm.protocal.protobuf.dgb;
import com.tencent.mm.protocal.protobuf.dgc;
import com.tencent.mm.protocal.protobuf.dgd;
import com.tencent.mm.protocal.protobuf.dgf;
import com.tencent.mm.protocal.protobuf.dgg;
import com.tencent.mm.protocal.protobuf.dhi;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.u.a;
import com.tencent.mm.storage.u.c;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.e.b;
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
  public static int nyY = 0;
  public static int nyZ = 0;
  public static int nza;
  public static int nzb = 0;
  public static int nzc = 0;
  public static int nzd = 0;
  public static int nze = 0;
  public static int nzf;
  public static int nzg;
  public static int nzh;
  public static int nzi;
  public static int nzj;
  private static Long nzp = null;
  private static Long nzq = null;
  private static Long nzr = null;
  boolean dhO;
  public List<com.tencent.mm.storage.t> mgF;
  u.c nuw;
  private BizTimeLineUI nyX;
  private k nzA;
  boolean nzB;
  public com.tencent.mm.storage.t nzk;
  public int nzl;
  public BizTimeLineHotView nzm;
  public com.tencent.mm.plugin.brandservice.ui.timeline.preload.c nzn;
  private com.tencent.mm.plugin.brandservice.ui.timeline.a.p nzo;
  private long nzs;
  public i nzt;
  boolean nzu;
  private d nzv;
  public h nzw;
  private Set<String> nzx;
  public Set<com.tencent.mm.ah.v> nzy;
  private View.OnClickListener nzz;
  
  public c(BizTimeLineUI paramBizTimeLineUI, List<com.tencent.mm.storage.t> paramList, boolean paramBoolean, h paramh, BizTimeLineHotView paramBizTimeLineHotView)
  {
    AppMethodBeat.i(5865);
    this.mgF = new LinkedList();
    this.dhO = false;
    this.nzs = -1L;
    this.nzu = false;
    this.nzx = new HashSet();
    this.nzy = new HashSet();
    this.nuw = new u.c()
    {
      public final void a(final Object paramAnonymousObject, final u.a paramAnonymousa)
      {
        AppMethodBeat.i(5855);
        if ((paramAnonymousa != null) && (paramAnonymousa.GCr))
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
    this.nzz = new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(175421);
        Object localObject1 = (com.tencent.mm.storage.t)paramAnonymousView.getTag();
        paramAnonymousView = ((com.tencent.mm.storage.t)localObject1).field_talker;
        Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(((com.tencent.mm.storage.t)localObject1).field_talker);
        if ((!((com.tencent.mm.storage.t)localObject1).eZk()) && (localObject2 != null) && (!com.tencent.mm.n.b.ln(((av)localObject2).field_type)))
        {
          localObject2 = new Intent();
          ((Intent)localObject2).putExtra("Contact_User", paramAnonymousView);
          ((Intent)localObject2).putExtra("Contact_Scene", 174);
          ((Intent)localObject2).putExtra("force_get_contact", true);
          ((Intent)localObject2).putExtra("key_use_new_contact_profile", true);
          com.tencent.mm.br.d.b(c.a(c.this), "profile", ".ui.ContactInfoUI", (Intent)localObject2);
          c.this.nzw.d((com.tencent.mm.storage.t)localObject1, 1);
          AppMethodBeat.o(175421);
          return;
        }
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Chat_User", paramAnonymousView);
        ((Intent)localObject2).putExtra("finish_direct", true);
        ((Intent)localObject2).putExtra("KOpenArticleSceneFromScene", 90);
        ((Intent)localObject2).putExtra("specific_chat_from_scene", 2);
        ((Intent)localObject2).putExtra("preChatTYPE", 11);
        com.tencent.mm.br.d.e(c.a(c.this), ".ui.chatting.ChattingUI", (Intent)localObject2);
        c.this.nzw.d((com.tencent.mm.storage.t)localObject1, 9);
        localObject1 = com.tencent.mm.plugin.brandservice.b.c.nva;
        com.tencent.mm.plugin.brandservice.b.c.s(3, paramAnonymousView, "");
        AppMethodBeat.o(175421);
      }
    };
    this.nzA = new k()
    {
      public final void a(com.tencent.mm.storage.t paramAnonymoust, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(175422);
        c.this.nzw.a(paramAnonymoust, paramAnonymousInt1, paramAnonymousInt2);
        c.this.nzm.e(paramAnonymoust);
        AppMethodBeat.o(175422);
      }
    };
    this.nzB = false;
    this.nyX = paramBizTimeLineUI;
    this.nzm = paramBizTimeLineHotView;
    this.nzw = paramh;
    int i;
    int j;
    if (nyY == 0)
    {
      nza = paramBizTimeLineUI.getResources().getDimensionPixelSize(2131165905);
      nzb = paramBizTimeLineUI.getResources().getDimensionPixelSize(2131165900);
      nzc = paramBizTimeLineUI.getResources().getDimensionPixelSize(2131165480);
      nzd = paramBizTimeLineUI.getResources().getDimensionPixelSize(2131165500);
      nzf = paramBizTimeLineUI.getResources().getDimensionPixelSize(2131165909);
      nzg = paramBizTimeLineUI.getResources().getDimensionPixelOffset(2131165480);
      nze = paramBizTimeLineUI.getResources().getDimensionPixelOffset(2131165516);
      nzh = com.tencent.mm.cc.a.fromDPToPix(this.nyX, 2);
      nzj = com.tencent.mm.cc.a.fromDPToPix(this.nyX, 40);
      nzi = com.tencent.mm.cc.a.fromDPToPix(this.nyX, 8);
      i = com.tencent.mm.cc.a.ig(paramBizTimeLineUI);
      j = com.tencent.mm.cc.a.ih(paramBizTimeLineUI);
      if (i >= j) {
        break label388;
      }
    }
    for (;;)
    {
      nyY = (int)((i - (int)(com.tencent.mm.cc.a.getDensity(paramBizTimeLineUI) * 16.0F)) / 2.35F);
      nyZ = (int)((i - (int)(com.tencent.mm.cc.a.getDensity(paramBizTimeLineUI) * 16.0F)) / 1.777778F);
      af.aDc().a(this.nuw, Looper.getMainLooper());
      ck(paramList);
      cl(paramList);
      this.nzt = new i(this);
      this.nzu = paramBoolean;
      bJP();
      this.nzn = new com.tencent.mm.plugin.brandservice.ui.timeline.preload.c(paramBizTimeLineUI, nyY, nza, this.mgF);
      this.nzo = new com.tencent.mm.plugin.brandservice.ui.timeline.a.p(this, paramBizTimeLineUI);
      com.tencent.mm.plugin.brandservice.ui.timeline.a.d.bKe();
      AppMethodBeat.o(5865);
      return;
      label388:
      i = j;
    }
  }
  
  private void a(int paramInt, com.tencent.mm.storage.t paramt, View paramView1, View paramView2)
  {
    AppMethodBeat.i(5875);
    if (paramInt > 0)
    {
      paramView1.setVisibility(0);
      if (a(paramt, paramInt))
      {
        paramView2.setVisibility(0);
        ((TextView)paramView2.findViewById(2131297357)).setText(this.nyX.getString(2131756615));
      }
    }
    for (;;)
    {
      b(paramt);
      AppMethodBeat.o(5875);
      return;
      paramView2.setVisibility(8);
      paramView1.setMinimumHeight(nzc);
      continue;
      paramView1.setMinimumHeight(this.nyX.getResources().getDimensionPixelSize(2131165187));
      paramView1.setVisibility(0);
      paramView2.setVisibility(8);
    }
  }
  
  private void a(n paramn, final com.tencent.mm.storage.t paramt)
  {
    AppMethodBeat.i(5877);
    a.b.d(paramn.fuY, paramt.field_talker);
    Object localObject1 = com.tencent.mm.model.v.wk(paramt.field_talker);
    Object localObject2 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramt.field_talker);
    if ((localObject2 != null) && (((ai)localObject2).aaN()))
    {
      localObject2 = this.nyX.getResources().getDrawable(2131231289);
      int i = (int)paramn.nBF.getTextSize();
      ((Drawable)localObject2).setBounds(0, 0, i, i);
      localObject2 = new com.tencent.mm.ui.widget.a((Drawable)localObject2);
      SpannableString localSpannableString = new SpannableString("@");
      localSpannableString.setSpan(localObject2, 0, 1, 33);
      paramn.nBF.setText(TextUtils.concat(new CharSequence[] { com.tencent.mm.pluginsdk.ui.span.k.b(this.nyX, (CharSequence)localObject1, paramn.nBF.getTextSize()) + "  ", localSpannableString }));
    }
    for (;;)
    {
      localObject1 = com.tencent.mm.plugin.brandservice.ui.b.d.nPK;
      com.tencent.mm.plugin.brandservice.ui.b.d.i(paramn.nBF);
      paramn.nCO.setTag(paramt);
      paramn.nCO.setOnClickListener(this.nzz);
      if (!com.tencent.mm.storage.v.eZF()) {
        break;
      }
      paramn.fAz.setVisibility(0);
      paramn.nCP.setVisibility(8);
      paramn.fAz.setText(com.tencent.mm.plugin.brandservice.ui.b.b.f(this.nyX, paramt.field_createTime));
      paramn.nCO.setOnLongClickListener(new View.OnLongClickListener()
      {
        public final boolean onLongClick(View paramAnonymousView)
        {
          AppMethodBeat.i(175418);
          c.this.nzk = paramt;
          c.this.nzw.d(c.this.nzk, 20);
          c.c(c.this);
          AppMethodBeat.o(175418);
          return false;
        }
      });
      AppMethodBeat.o(5877);
      return;
      paramn.nBF.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this.nyX, (CharSequence)localObject1, paramn.nBF.getTextSize()));
    }
    paramn.fAz.setVisibility(8);
    paramn.nCP.setVisibility(0);
    paramn.nCO.setOnLongClickListener(null);
    paramn.nCP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(175419);
        c.this.nzk = paramt;
        c.this.nzw.d(c.this.nzk, 19);
        c.c(c.this);
        AppMethodBeat.o(175419);
      }
    });
    com.tencent.mm.ui.tools.o.gD(paramn.nCP);
    AppMethodBeat.o(5877);
  }
  
  private static boolean a(com.tencent.mm.storage.t paramt)
  {
    return (paramt == null) || (paramt.field_type == 34) || (paramt.field_type == 3);
  }
  
  private boolean a(com.tencent.mm.storage.t paramt, int paramInt)
  {
    AppMethodBeat.i(5874);
    if (nzp != null)
    {
      if (nzp.longValue() == paramt.field_orderFlag)
      {
        AppMethodBeat.o(5874);
        return true;
      }
      AppMethodBeat.o(5874);
      return false;
    }
    long l2 = paramt.eZh();
    long l1 = 0L;
    com.tencent.mm.storage.t localt = yG(paramInt - 1);
    if (localt != null) {
      l1 = localt.eZh();
    }
    if ((l2 != l1) && (nzr != null) && (l1 == nzr.longValue()))
    {
      nzp = Long.valueOf(paramt.field_orderFlag);
      AppMethodBeat.o(5874);
      return true;
    }
    AppMethodBeat.o(5874);
    return false;
  }
  
  private void bJP()
  {
    AppMethodBeat.i(5866);
    bJS();
    if (this.nzu)
    {
      Object localObject = bJR();
      if ((localObject != null) && (!((com.tencent.mm.storage.t)localObject).eZo()))
      {
        localObject = this.mgF.iterator();
        com.tencent.mm.storage.t localt;
        for (long l = -1L; ((Iterator)localObject).hasNext(); l = localt.eZh())
        {
          localt = (com.tencent.mm.storage.t)((Iterator)localObject).next();
          if ((l != -1L) && (l != localt.eZh()))
          {
            nzp = Long.valueOf(localt.field_orderFlag);
            AppMethodBeat.o(5866);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(5866);
  }
  
  private void bJT()
  {
    com.tencent.mm.storage.t localt = null;
    AppMethodBeat.i(5886);
    Cursor localCursor = af.aDc().hpA.a("SELECT * FROM BizTimeLineInfo order by orderFlag asc limit 1", null, 0);
    if (localCursor.moveToFirst())
    {
      localt = new com.tencent.mm.storage.t();
      localt.convertFrom(localCursor);
    }
    localCursor.close();
    if (localt != null) {
      this.nzs = localt.eZh();
    }
    AppMethodBeat.o(5886);
  }
  
  private static void cj(List<com.tencent.mm.storage.t> paramList)
  {
    AppMethodBeat.i(5867);
    if (paramList.isEmpty())
    {
      AppMethodBeat.o(5867);
      return;
    }
    ac.d("MicroMsg.BizTimeLineAdapter", "alvinluo doUpdateListCellPosition list: %d", new Object[] { Integer.valueOf(paramList.size()) });
    long l = System.currentTimeMillis();
    Object localObject = (com.tencent.mm.storage.t)paramList.get(0);
    ((com.tencent.mm.storage.t)localObject).nCF = 1;
    int j = 1;
    int k = 1;
    if (j < paramList.size())
    {
      com.tencent.mm.storage.t localt = (com.tencent.mm.storage.t)paramList.get(j);
      int i;
      switch (((com.tencent.mm.storage.t)localObject).field_type)
      {
      default: 
        i = 1;
      }
      for (;;)
      {
        k += i;
        localt.nCF = k;
        j += 1;
        localObject = localt;
        break;
        int m = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).b(((com.tencent.mm.storage.t)localObject).field_msgId, ((com.tencent.mm.storage.t)localObject).field_content);
        i = m;
        if (!((com.tencent.mm.storage.t)localObject).field_isExpand)
        {
          i = Math.min(m, 2);
          continue;
          i = 1;
        }
      }
    }
    ac.d("MicroMsg.BizTimeLineAdapter", "alvinluo doUpdateListCellPosition cost: %d, startCellPosition: %d, size: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l), Integer.valueOf(1), Integer.valueOf(paramList.size()) });
    AppMethodBeat.o(5867);
  }
  
  public static void cl(List<com.tencent.mm.storage.t> paramList)
  {
    AppMethodBeat.i(5883);
    com.tencent.mm.pluginsdk.ui.applet.g localg = com.tencent.mm.pluginsdk.ui.applet.g.Dqh;
    if (com.tencent.mm.pluginsdk.ui.applet.g.WT(1)) {
      cj(paramList);
    }
    AppMethodBeat.o(5883);
  }
  
  public final void Ty(String paramString)
  {
    AppMethodBeat.i(5872);
    com.tencent.mm.kernel.g.agS();
    if ((com.tencent.mm.kernel.a.mo(com.tencent.mm.kernel.g.agP().ggN)) && (!this.nzx.contains(paramString)))
    {
      aa.ao(paramString, 2);
      this.nzx.add(paramString);
    }
    AppMethodBeat.o(5872);
  }
  
  public final void a(com.tencent.mm.ah.v paramv, final com.tencent.mm.storage.t paramt, int paramInt1, com.tencent.mm.ah.u paramu, View paramView, boolean paramBoolean, final int paramInt2)
  {
    AppMethodBeat.i(5876);
    ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a(paramv, paramt, paramInt1, paramu, paramView, paramBoolean, paramInt2, this.nzA);
    if ((paramv.type == 5) && (((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).bIP())) {
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(5859);
          int j = (int)(System.currentTimeMillis() / 1000L);
          paramAnonymousView = new Bundle();
          ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramt.field_talker);
          if ((localai != null) && (!com.tencent.mm.n.b.ln(localai.field_type))) {}
          for (int i = 157;; i = 90)
          {
            paramAnonymousView.putInt(e.b.HgX, i);
            i = c.a(c.this).getIntent().getIntExtra("KOpenArticleSceneFromScene", 10000);
            paramAnonymousView.putInt(e.b.HgY, i);
            paramAnonymousView.putInt("geta8key_scene", 56);
            com.tencent.mm.plugin.brandservice.ui.timeline.video.util.l.a(c.a(c.this), paramt.field_msgId, paramt.field_msgSvrId, paramInt2, paramAnonymousView);
            c.b(c.this).a(paramt, paramInt2, j);
            AppMethodBeat.o(5859);
            return;
          }
        }
      });
    }
    AppMethodBeat.o(5876);
  }
  
  public final void b(com.tencent.mm.storage.t paramt)
  {
    AppMethodBeat.i(5873);
    if (paramt == null)
    {
      ac.w("MicroMsg.BizTimeLineAdapter", "updateGroupId info is null");
      AppMethodBeat.o(5873);
      return;
    }
    final long l1 = paramt.eZh();
    long l2 = af.aDc().eZu();
    ac.d("MicroMsg.BizTimeLineAdapter", "updateGroupId keep %b, groupId %d, maxGroupId %d", new Object[] { Boolean.valueOf(this.nzu), Long.valueOf(l1), Long.valueOf(l2) });
    if ((!this.nzu) && (l1 == l2))
    {
      l1 = paramt.field_orderFlag;
      com.tencent.mm.cn.g.eo(Long.valueOf(l1)).h(new com.tencent.mm.vending.c.a() {}).b(new com.tencent.mm.vending.c.a() {});
    }
    AppMethodBeat.o(5873);
  }
  
  public final void b(com.tencent.mm.storage.t paramt, int paramInt)
  {
    AppMethodBeat.i(198689);
    this.nzw.a(paramt, paramInt, (int)(System.currentTimeMillis() / 1000L));
    AppMethodBeat.o(198689);
  }
  
  public final com.tencent.mm.storage.t bJQ()
  {
    AppMethodBeat.i(5880);
    if (this.mgF.size() > 0)
    {
      com.tencent.mm.storage.t localt = (com.tencent.mm.storage.t)this.mgF.get(this.mgF.size() - 1);
      AppMethodBeat.o(5880);
      return localt;
    }
    AppMethodBeat.o(5880);
    return null;
  }
  
  public final com.tencent.mm.storage.t bJR()
  {
    AppMethodBeat.i(5881);
    if (this.mgF.size() > 0)
    {
      com.tencent.mm.storage.t localt = (com.tencent.mm.storage.t)this.mgF.get(0);
      AppMethodBeat.o(5881);
      return localt;
    }
    AppMethodBeat.o(5881);
    return null;
  }
  
  public final void bJS()
  {
    AppMethodBeat.i(5884);
    com.tencent.mm.storage.t localt = bJR();
    if (localt != null) {
      nzr = Long.valueOf(localt.eZh());
    }
    nzp = null;
    nzq = null;
    AppMethodBeat.o(5884);
  }
  
  final void ck(List<com.tencent.mm.storage.t> paramList)
  {
    AppMethodBeat.i(5882);
    ac.d("MicroMsg.BizTimeLineAdapter", "alvinluo filterAndAddList size: %d", new Object[] { Integer.valueOf(paramList.size()) });
    LinkedList localLinkedList = new LinkedList();
    int i = 0;
    while (i < paramList.size())
    {
      if (!a((com.tencent.mm.storage.t)paramList.get(i))) {
        localLinkedList.add(paramList.get(i));
      }
      i += 1;
    }
    this.mgF.addAll(localLinkedList);
    AppMethodBeat.o(5882);
  }
  
  public final void eK(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(5887);
    ArrayList localArrayList = new ArrayList();
    if (paramInt1 <= paramInt2)
    {
      Object localObject = yG(paramInt1);
      long l;
      String str;
      if ((localObject != null) && (((com.tencent.mm.storage.t)localObject).field_type == 285212721))
      {
        ac.v("MicroMsg.BizTimeLineAdapter", "terry checkpreload:" + ((com.tencent.mm.storage.t)localObject).field_msgId);
        l = ((com.tencent.mm.storage.t)localObject).field_msgId;
        str = ((com.tencent.mm.storage.t)localObject).field_content;
        if (!((com.tencent.mm.storage.t)localObject).field_isExpand) {
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
    int i = this.mgF.size();
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
    com.tencent.mm.storage.t localt = yG(paramInt);
    if (localt == null)
    {
      ac.e("MicroMsg.BizTimeLineAdapter", "getItemViewType info is null");
      AppMethodBeat.o(5870);
      return 0;
    }
    switch (localt.field_type)
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
    com.tencent.mm.storage.t localt = yG(paramInt);
    if (localt == null)
    {
      ac.e("MicroMsg.BizTimeLineAdapter", "getView info is null");
      AppMethodBeat.o(5871);
      return paramView;
    }
    if ((paramInt == getCount() - 1) && (!this.nzB)) {
      ap.n(new Runnable()
      {
        public final void run()
        {
          int j = 0;
          AppMethodBeat.i(5856);
          if ((paramInt == c.this.getCount() - 1) && (!c.this.nzB))
          {
            ac.i("MicroMsg.BizTimeLineAdapter", "loadMoreData %d/%d", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(c.this.getCount()) });
            c localc = c.this;
            Object localObject = localc.bJQ();
            int i = j;
            if (localObject != null)
            {
              localObject = af.aDc().aF(10, ((com.tencent.mm.storage.t)localObject).field_orderFlag);
              localc.ck((List)localObject);
              com.tencent.mm.plugin.brandservice.ui.b.c.a((List)localObject, new c.3(localc));
              localc.notifyDataSetChanged();
              i = j;
              if (((List)localObject).size() > 0) {
                i = 1;
              }
            }
            if (i == 0)
            {
              c.this.nzB = true;
              c.a(c.this).bJW();
              AppMethodBeat.o(5856);
              return;
            }
            c.this.nzn.Xa();
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
    switch (localt.field_type)
    {
    default: 
      if (paramView == null)
      {
        paramViewGroup = new com.tencent.mm.plugin.brandservice.ui.timeline.a.y();
        paramView = this.nyX;
        if (paramViewGroup.nBh != null)
        {
          paramView = paramViewGroup.nBh;
          paramView.setTag(paramViewGroup);
          a(paramViewGroup, localt);
          a(paramInt, localt, paramViewGroup.nBZ, paramViewGroup.nBY);
        }
      }
      break;
    case 285212721: 
      for (;;)
      {
        if ((!this.nzu) && (!this.dhO))
        {
          this.nzw.c(localt, paramInt);
          Ty(localt.field_talker);
        }
        AppMethodBeat.o(5871);
        return paramView;
        if (!this.nzu) {
          com.tencent.mm.plugin.brandservice.ui.b.c.g(localt);
        }
        if (paramView == null)
        {
          localObject1 = new com.tencent.mm.plugin.brandservice.ui.timeline.a.o();
          paramViewGroup = View.inflate(this.nyX, 2131493210, null);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCR = ((LinearLayout)paramViewGroup.findViewById(2131297332));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCS = ((LinearLayout)paramViewGroup.findViewById(2131304785));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCT = ((TextView)paramViewGroup.findViewById(2131304786));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nBY = ((LinearLayout)paramViewGroup.findViewById(2131297356));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nBZ = ((LinearLayout)paramViewGroup.findViewById(2131297346));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nBh = paramViewGroup;
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).bKj();
          paramViewGroup.setTag(localObject1);
        }
        for (;;)
        {
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).b(this.nyX, this);
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCU.iterator();
          while (paramView.hasNext())
          {
            localObject2 = (com.tencent.mm.plugin.brandservice.ui.timeline.a.k)paramView.next();
            com.tencent.mm.ui.chatting.ao.aA(((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject2).nBh, 3);
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCR.removeView(((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject2).nBh);
          }
          localObject1 = (com.tencent.mm.plugin.brandservice.ui.timeline.a.o)paramView.getTag();
          paramViewGroup = paramView;
        }
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCU.clear();
        localObject2 = ((com.tencent.mm.plugin.biz.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.biz.a.a.class)).a(localt.field_msgId, localt.field_content);
        localObject3 = ((com.tencent.mm.ah.u)localObject2).hkS;
        k = ((List)localObject3).size();
        if (k != 0) {
          break;
        }
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCR.setVisibility(8);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).a((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1, -1, 0);
        paramView = paramViewGroup;
      }
      ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCR.setVisibility(0);
      localObject4 = (com.tencent.mm.ah.v)((List)localObject3).get(0);
      com.tencent.mm.plugin.brandservice.ui.timeline.a.o.c((com.tencent.mm.ah.v)localObject4);
      bool1 = com.tencent.mm.plugin.brandservice.ui.timeline.preload.c.a(localt, (com.tencent.mm.ah.v)localObject4);
      if (bool1) {
        if ((bs.isNullOrNil(((com.tencent.mm.ah.v)localObject4).hld)) && (((com.tencent.mm.ah.v)localObject4).type != 7) && (((com.tencent.mm.ah.v)localObject4).type != 10)) {
          bool1 = false;
        }
      }
      break;
    }
    label1182:
    label1217:
    label1987:
    label4806:
    for (;;)
    {
      ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).a((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1, -1, k);
      label596:
      localt.GBZ = bool1;
      Object localObject5 = ((Activity)((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).mContext).getLayoutInflater();
      int i = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCU.size();
      label628:
      if (i < k)
      {
        paramView = com.tencent.mm.ui.chatting.ao.aaO(3);
        if (paramView != null) {
          break label5194;
        }
        paramView = ((LayoutInflater)localObject5).inflate(2131493211, null);
      }
      label1351:
      label5194:
      for (;;)
      {
        Object localObject7 = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCM;
        Object localObject8 = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).mContext;
        Object localObject6 = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCR;
        localObject7 = new com.tencent.mm.plugin.brandservice.ui.timeline.a.k((c)localObject7, (Context)localObject8);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).nBh = paramView;
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).ijv = paramView.findViewById(2131306012);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).nCh = paramView.findViewById(2131298764);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).nCi = ((MMNeat7extView)paramView.findViewById(2131305938));
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).nCj = ((TextView)paramView.findViewById(2131305546));
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).nCk = paramView.findViewById(2131298814);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).nCl = ((ImageView)paramView.findViewById(2131298824));
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).nCo = ((ImageView)paramView.findViewById(2131303284));
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).nCm = paramView.findViewById(2131297330);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).nCn = ((ImageView)paramView.findViewById(2131297370));
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).nCp = paramView.findViewById(2131305184);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).nCq = ((TextView)paramView.findViewById(2131300305));
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).nCr = paramView.findViewById(2131303255);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).nCs = paramView.findViewById(2131303254);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject7).nCt = ((TextView)paramView.findViewById(2131303263));
        ((ViewGroup)localObject6).addView(paramView, ((ViewGroup)localObject6).getChildCount());
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCU.add(localObject7);
        i += 1;
        break label628;
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).a((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1, ((com.tencent.mm.ah.v)((List)localObject3).get(0)).type, k);
        break label596;
        i = 0;
        while (i < ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCU.size())
        {
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCU.get(i)).nBh.setVisibility(8);
          i += 1;
        }
        label1107:
        label1115:
        int m;
        int j;
        label1247:
        boolean bool2;
        if (bool1)
        {
          if (((com.tencent.mm.ah.v)localObject4).type == 5) {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCW.a(k, (com.tencent.mm.ah.v)localObject4, localt, paramInt, (com.tencent.mm.ah.u)localObject2, localt.nCF);
          }
        }
        else
        {
          if ((k <= 2) || (localt.field_isExpand)) {
            break label1751;
          }
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCS.setVisibility(0);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCT.setText(((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).mContext.getString(2131756641, new Object[] { Integer.valueOf(k - 2) }));
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCS.setTag(localt);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCS.setOnClickListener(((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nDc);
          if (!bool1) {
            break label1764;
          }
          i = 1;
          if ((i >= k) || ((!localt.field_isExpand) && (i > 1))) {
            break label2549;
          }
          localObject5 = (com.tencent.mm.ah.v)((List)localObject3).get(i);
          m = localt.nCF + i;
          com.tencent.mm.plugin.brandservice.ui.timeline.a.o.c((com.tencent.mm.ah.v)localObject5);
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCU;
          if (!bool1) {
            break label1770;
          }
          j = i - 1;
          localObject6 = (com.tencent.mm.plugin.brandservice.ui.timeline.a.k)paramView.get(j);
          j = ((com.tencent.mm.ah.v)localObject4).type;
          if (i != 0) {
            break label1777;
          }
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).ijv.setVisibility(8);
          if (bool1) {
            break label2108;
          }
          if (i != 0) {
            break label2009;
          }
          if (k != 1) {
            break label1987;
          }
          com.tencent.mm.plugin.brandservice.ui.timeline.a.o.t(((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nCh, nze, nzb);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).a((com.tencent.mm.ah.v)localObject5, localt, i, false);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).a((com.tencent.mm.ah.v)localObject5, false);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).a(((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nCp, ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nCq, localt, (com.tencent.mm.ah.v)localObject5);
          if (!bs.isNullOrNil(((com.tencent.mm.ah.v)localObject5).title)) {
            break label2264;
          }
          paramView = com.tencent.mm.plugin.brandservice.b.a.nuP;
          switch (((com.tencent.mm.ah.v)localObject5).type)
          {
          case 6: 
          default: 
            paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).mContext.getResources().getString(2131756613);
            com.tencent.mm.plugin.brandservice.b.a.a(paramView, ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nCi, (com.tencent.mm.ah.v)localObject5, 1);
            label1363:
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nCi.setTextColor(com.tencent.mm.ui.ao.aJ(((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).mContext, 2130968584));
            if ((((com.tencent.mm.ah.v)localObject5).hlg == 0) || (((com.tencent.mm.ah.v)localObject5).hlg == 1))
            {
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nCk.setVisibility(0);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nCi.setTextColor(com.tencent.mm.ui.ao.aJ(((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).mContext, 2130968584));
              if (((com.tencent.mm.ah.v)localObject5).type == 7)
              {
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nCl.setVisibility(8);
                if ((bs.isNullOrNil(((com.tencent.mm.ah.v)localObject5).hlf)) || (((com.tencent.mm.ah.v)localObject5).type != 3)) {
                  break label2516;
                }
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nCj.setText(((com.tencent.mm.ah.v)localObject5).hlf);
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nCj.setVisibility(0);
                label1489:
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nBh.setVisibility(0);
                paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCM;
                localObject7 = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nBh;
                if (k <= 1) {
                  break label2529;
                }
                bool2 = true;
                label1520:
                paramView.a((com.tencent.mm.ah.v)localObject5, localt, paramInt, (com.tencent.mm.ah.u)localObject2, (View)localObject7, bool2, i);
                if ((i != k - 1) || (((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCS.getVisibility() == 0)) {
                  break label2535;
                }
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nBh.setBackgroundResource(2131231256);
              }
            }
            break;
          }
        }
        for (;;)
        {
          i += 1;
          break label1115;
          if (((com.tencent.mm.ah.v)localObject4).type == 8)
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCY.a(k, (com.tencent.mm.ah.v)localObject4, localt, paramInt, (com.tencent.mm.ah.u)localObject2, localt.nCF);
            break;
          }
          if (((com.tencent.mm.ah.v)localObject4).type == 7)
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCZ.a(k, (com.tencent.mm.ah.v)localObject4, localt, paramInt, (com.tencent.mm.ah.u)localObject2, localt.nCF);
            break;
          }
          if (((com.tencent.mm.ah.v)localObject4).type == 6)
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nDa.a(k, (com.tencent.mm.ah.v)((List)localObject3).get(0), localt, paramInt, (com.tencent.mm.ah.u)localObject2, localt.nCF);
            break;
          }
          if (((com.tencent.mm.ah.v)localObject4).type == 10)
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nDb.a(k, (com.tencent.mm.ah.v)localObject4, localt, paramInt, (com.tencent.mm.ah.u)localObject2, localt.nCF);
            break;
          }
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCV.a(k, (com.tencent.mm.ah.v)localObject4, localt, paramInt, (com.tencent.mm.ah.u)localObject2, localt.nCF);
          break;
          label1751:
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCS.setVisibility(8);
          break label1107;
          label1764:
          i = 0;
          break label1115;
          label1770:
          j = i;
          break label1182;
          label1777:
          if ((i == 1) && (bool1) && (j != 7) && (j != 5) && (j != 6)) {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).ijv.setVisibility(8);
          }
          for (;;)
          {
            if ((!bool1) || (i > 0))
            {
              paramView = (com.tencent.mm.ah.v)((List)localObject3).get(i - 1);
              localObject7 = (com.tencent.mm.ah.v)((List)localObject3).get(i);
              if (((paramView.type != 7) && (paramView.type != 5) && (paramView.type != 6) && (bs.isNullOrNil(paramView.hld))) || ((((com.tencent.mm.ah.v)localObject7).type != 7) && (((com.tencent.mm.ah.v)localObject7).type != 5) && (((com.tencent.mm.ah.v)localObject7).type != 6) && (bs.isNullOrNil(((com.tencent.mm.ah.v)localObject7).hld))))
              {
                com.tencent.mm.plugin.brandservice.ui.timeline.a.o.X(((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).ijv, nzg);
                break;
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).ijv.setVisibility(0);
                continue;
              }
              com.tencent.mm.plugin.brandservice.ui.timeline.a.o.X(((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).ijv, nzf);
              break;
            }
          }
          com.tencent.mm.plugin.brandservice.ui.timeline.a.o.X(((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).ijv, nzg);
          break label1217;
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nCh;
          j = nze;
          com.tencent.mm.plugin.brandservice.ui.timeline.a.o.t(paramView, j, j);
          break label1247;
          label2009:
          if (i == 1)
          {
            if (k == 2)
            {
              com.tencent.mm.plugin.brandservice.ui.timeline.a.o.t(((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nCh, nze, nzb);
              break label1247;
            }
            paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nCh;
            j = nze;
            com.tencent.mm.plugin.brandservice.ui.timeline.a.o.t(paramView, j, j);
            break label1247;
          }
          if (i == k - 1)
          {
            com.tencent.mm.plugin.brandservice.ui.timeline.a.o.t(((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nCh, nze, nzb);
            break label1247;
          }
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nCh;
          j = nze;
          com.tencent.mm.plugin.brandservice.ui.timeline.a.o.t(paramView, j, j);
          break label1247;
          if (i == 1)
          {
            if (i == k - 1)
            {
              paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nCh;
              j = nzb;
              com.tencent.mm.plugin.brandservice.ui.timeline.a.o.t(paramView, j, j);
              break label1247;
            }
            com.tencent.mm.plugin.brandservice.ui.timeline.a.o.t(((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nCh, nzb, nze);
            break label1247;
          }
          if (i == k - 1)
          {
            com.tencent.mm.plugin.brandservice.ui.timeline.a.o.t(((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nCh, nze, nzb);
            break label1247;
          }
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nCh;
          j = nze;
          com.tencent.mm.plugin.brandservice.ui.timeline.a.o.t(paramView, j, j);
          break label1247;
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).mContext.getResources().getString(2131756623);
          break label1351;
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).mContext.getResources().getString(2131756624);
          break label1351;
          paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).mContext.getResources().getString(2131756614);
          break label1351;
          label2264:
          paramView = com.tencent.mm.plugin.brandservice.b.a.nuP;
          com.tencent.mm.plugin.brandservice.b.a.a(((com.tencent.mm.ah.v)localObject5).title, ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nCi, (com.tencent.mm.ah.v)localObject5, 1);
          break label1363;
          if (!bs.isNullOrNil(((com.tencent.mm.ah.v)localObject5).hld))
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nCl.setVisibility(0);
            if (bs.isNullOrNil(((com.tencent.mm.ah.v)localObject5).hlu)) {}
            for (paramView = ((com.tencent.mm.ah.v)localObject5).hld;; paramView = ((com.tencent.mm.ah.v)localObject5).hlu)
            {
              localObject7 = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCM.nzn;
              long l = localt.field_msgId;
              localObject8 = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nCl;
              j = nza;
              ((com.tencent.mm.plugin.brandservice.ui.timeline.preload.c)localObject7).a(l, i, (com.tencent.mm.ah.v)localObject5, paramView, (ImageView)localObject8, j, j, false, new o.2((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1, (com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6, (com.tencent.mm.ah.v)localObject5, localt, i), m, 2.0F);
              break;
            }
          }
          if ((((com.tencent.mm.ah.v)localObject5).type == 5) || (((com.tencent.mm.ah.v)localObject5).type == 6))
          {
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nCl.setVisibility(0);
            paramView = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCM.nzn;
            localObject7 = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nCl;
            j = nza;
            paramView.a("2131231674", (ImageView)localObject7, j, j, m);
            break label1447;
          }
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nCk.setVisibility(8);
          break label1447;
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nCk.setVisibility(8);
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nCi.setTextColor(com.tencent.mm.ui.ao.aJ(((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).mContext, 2130968586));
          break label1447;
          label2516:
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nCj.setVisibility(8);
          break label1489;
          label2529:
          bool2 = false;
          break label1520;
          label2535:
          ((com.tencent.mm.plugin.brandservice.ui.timeline.a.k)localObject6).nBh.setBackgroundResource(2131231262);
        }
        label2549:
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCM.a(paramInt, localt, ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nBZ, ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nBY);
        ((com.tencent.mm.plugin.brandservice.ui.timeline.a.o)localObject1).nCM.a((n)localObject1, localt);
        paramView = paramViewGroup;
        break label180;
        if (paramView == null)
        {
          paramViewGroup = new q();
          paramView = paramViewGroup.a(this.nyX, this);
          paramView.setTag(paramViewGroup);
          localObject2 = paramViewGroup.mContext;
          localObject3 = localt.field_content;
          i = (int)paramViewGroup.nCy.getTextSize();
          if (localt == null) {
            break label2971;
          }
          localObject1 = com.tencent.mm.model.y.xJ(localt.field_msgSvrId);
          localObject4 = com.tencent.mm.model.y.ayq().F((String)localObject1, true);
          ((y.b)localObject4).l("prePublishId", "msg_" + localt.field_msgSvrId);
          ((y.b)localObject4).l("preUsername", localt.field_talker);
          localObject1 = com.tencent.mm.pluginsdk.ui.span.k.a((Context)localObject2, (CharSequence)localObject3, i, 1, null, (String)localObject1);
          paramViewGroup.nCy.setMaxLines(2147483647);
          paramViewGroup.nCy.ar((CharSequence)localObject1);
          if (!localt.field_isExpand) {
            break label2977;
          }
          paramViewGroup.nDm.setText(paramViewGroup.mContext.getString(2131756619));
          label2779:
          i = com.tencent.mm.cc.a.ig(paramViewGroup.mContext);
          j = com.tencent.mm.cc.a.fromDPToPix(paramViewGroup.mContext, 72);
          localObject1 = paramViewGroup.nCy.kv(i - j, 2147483647);
          if (localObject1 == null) {
            break label5188;
          }
        }
        for (i = ((com.tencent.neattextview.textview.layout.a)localObject1).fBm();; i = 0)
        {
          if (i > 4)
          {
            if (!localt.field_isExpand) {
              paramViewGroup.nCy.setMaxLines(4);
            }
            paramViewGroup.nDm.setVisibility(0);
            if (localt.field_isExpand)
            {
              paramViewGroup.nDm.setText(2131756619);
              paramViewGroup.nDm.setOnClickListener(new q.1(paramViewGroup, localt));
              label2895:
              localObject1 = (LinearLayout.LayoutParams)paramViewGroup.nCy.getLayoutParams();
              if (i > 4) {
                break label3032;
              }
            }
          }
          label3032:
          for (((LinearLayout.LayoutParams)localObject1).gravity = 17;; ((LinearLayout.LayoutParams)localObject1).gravity = 19)
          {
            paramViewGroup.nCy.setLayoutParams((ViewGroup.LayoutParams)localObject1);
            paramViewGroup.nCM.a(paramViewGroup, localt);
            paramViewGroup.nCM.a(paramInt, localt, paramViewGroup.nBZ, paramViewGroup.nBY);
            break;
            paramViewGroup = (q)paramView.getTag();
            break label2614;
            localObject1 = null;
            break label2720;
            paramViewGroup.nDm.setText(paramViewGroup.mContext.getString(2131756620));
            break label2779;
            paramViewGroup.nDm.setText(2131756620);
            break label2878;
            paramViewGroup.nCy.setMaxLines(2147483647);
            paramViewGroup.nDm.setVisibility(8);
            break label2895;
          }
          if (paramView == null)
          {
            paramViewGroup = new z();
            paramView = paramViewGroup.a(this.nyX, this);
            paramView.setTag(paramViewGroup);
            label3069:
            localt.GBZ = com.tencent.mm.plugin.brandservice.ui.b.a.f(localt);
            if (!localt.GBZ) {
              break label3410;
            }
            paramViewGroup.nCJ.setVisibility(0);
            paramViewGroup.nCK.setVisibility(8);
            localObject2 = paramViewGroup.nCy;
            localObject1 = paramViewGroup.nCo;
            localObject3 = new com.tencent.mm.modelvoice.p(localt.field_content);
            ((MMNeat7extView)localObject2).ar(com.tencent.mm.pluginsdk.g.h.formatTime("yyyy/MM/dd", System.currentTimeMillis() / 1000L));
            if (localt.GBZ)
            {
              localObject2 = com.tencent.mm.ah.m.nJ((int)(((com.tencent.mm.modelvoice.p)localObject3).time / 1000L));
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                break label3483;
              }
              paramViewGroup.nDK.setVisibility(0);
              paramViewGroup.nDK.setText((CharSequence)localObject2);
              label3196:
              paramViewGroup.nDl.setOnClickListener(new z.2(paramViewGroup));
              paramViewGroup.nDl.setBackgroundResource(2131231692);
              localObject2 = paramViewGroup.nDl;
              i = nzc;
              j = nzb;
              k = nzc;
              ((View)localObject2).setPadding(i, j, k, k);
            }
            localObject2 = ((ImageView)localObject1).getDrawable();
            if (((localObject2 instanceof AnimationDrawable)) && (((AnimationDrawable)localObject2).isRunning())) {
              ((AnimationDrawable)localObject2).stop();
            }
            if ((!paramViewGroup.nCM.nzt.isPlaying()) || (localt.field_msgId != paramViewGroup.nCM.nzt.nAV)) {
              break label3495;
            }
            ((ImageView)localObject1).setImageResource(2131231676);
            if ((((ImageView)localObject1).getDrawable() instanceof AnimationDrawable)) {
              ((AnimationDrawable)((ImageView)localObject1).getDrawable()).start();
            }
          }
          for (;;)
          {
            ((ImageView)localObject1).setOnClickListener(new z.3(paramViewGroup, localt, (ImageView)localObject1));
            paramViewGroup.nCM.a(paramViewGroup, localt);
            paramViewGroup.nCM.a(paramInt, localt, paramViewGroup.nBZ, paramViewGroup.nBY);
            break;
            paramViewGroup = (z)paramView.getTag();
            break label3069;
            label3410:
            paramViewGroup.ijv.setVisibility(8);
            paramViewGroup.nCJ.setVisibility(8);
            paramViewGroup.nCK.setVisibility(0);
            paramViewGroup.nDN.setVisibility(8);
            paramViewGroup.nDM.setVisibility(0);
            localObject2 = paramViewGroup.nDO;
            localObject1 = paramViewGroup.nDM;
            paramViewGroup.nCK.setOnClickListener(new z.1(paramViewGroup));
            break label3116;
            paramViewGroup.nDK.setVisibility(8);
            break label3196;
            ((ImageView)localObject1).setImageResource(2131231675);
          }
          if (paramView == null)
          {
            paramViewGroup = new com.tencent.mm.plugin.brandservice.ui.timeline.a.m();
            paramView = paramViewGroup.a(this.nyX, this);
            paramView.setTag(paramViewGroup);
          }
          for (;;)
          {
            if (this.nzv == null) {
              this.nzv = new d(this.nyX);
            }
            localObject1 = this.nzv;
            paramViewGroup.nCM.a(paramViewGroup, localt);
            paramViewGroup.nCM.a(paramInt, localt, paramViewGroup.nBZ, paramViewGroup.nBY);
            localt.GBZ = com.tencent.mm.plugin.brandservice.ui.b.a.f(localt);
            if (!localt.GBZ) {
              break label3686;
            }
            paramViewGroup.nCK.setVisibility(8);
            paramViewGroup.nCJ.setVisibility(0);
            paramViewGroup.dC(paramViewGroup.nCH);
            paramViewGroup.dC(paramViewGroup.nCG);
            ((d)localObject1).a(localt, paramInt, paramViewGroup.nCG, nyY);
            paramViewGroup.nCH.setOnClickListener(new m.1(paramViewGroup, localt));
            break;
            paramViewGroup = (com.tencent.mm.plugin.brandservice.ui.timeline.a.m)paramView.getTag();
          }
          label3686:
          paramViewGroup.nCK.setVisibility(0);
          paramViewGroup.nCJ.setVisibility(8);
          paramViewGroup.ijv.setVisibility(8);
          paramViewGroup.nCy.ar(paramViewGroup.mContext.getText(2131756612));
          ((d)localObject1).a(localt, paramInt, paramViewGroup.nCI, 0);
          paramViewGroup.nCK.setOnClickListener(new m.2(paramViewGroup, localt));
          break label180;
          if (!this.nzu) {
            com.tencent.mm.plugin.brandservice.ui.b.c.i(localt);
          }
          if (paramView == null)
          {
            paramViewGroup = new com.tencent.mm.plugin.brandservice.ui.timeline.a.h(this.nyX, this);
            paramView = paramViewGroup.nBX;
            paramView.setTag(paramViewGroup);
          }
          for (;;)
          {
            d.g.b.k.h(localt, "info");
            d.g.b.k.h(paramView, "convertView");
            if (localt.eZq() != null) {
              break label3851;
            }
            paramViewGroup.bKi();
            ac.i("MicroMsg.BizTLRecCardNew", "[TRACE_BIZRECCARD] info null");
            break;
            paramViewGroup = (com.tencent.mm.plugin.brandservice.ui.timeline.a.h)paramView.getTag();
          }
          if (!com.tencent.mm.plugin.brandservice.ui.timeline.a.d.yu(localt.GCc.style))
          {
            paramViewGroup.bKi();
            ac.i("MicroMsg.BizTLRecCardNew", "[TRACE_BIZRECCARD] style = " + localt.GCc.style + " not support");
            break label180;
          }
          localObject1 = localt.GCc;
          d.g.b.k.g(localObject1, "info.wrapper");
          if (!com.tencent.mm.plugin.brandservice.ui.timeline.a.d.a((dgg)localObject1))
          {
            paramViewGroup.bKi();
            ac.i("MicroMsg.BizTLRecCardNew", "[TRACE_BIZRECCARD] wrapper illegal");
            break label180;
          }
          i = com.tencent.mm.plugin.brandservice.ui.timeline.a.h.yK(localt.GCc.style);
          ac.i("MicroMsg.BizTLRecCardNew", "[TRACE_BIZRECCARD] filling style = " + localt.GCc.style + ", clientShowType = " + i);
          paramViewGroup.nAv.a(paramInt, localt, (View)paramViewGroup.nBZ, (View)paramViewGroup.nBY);
          switch (i)
          {
          default: 
            break;
          case 1: 
            localObject1 = paramViewGroup.nBW;
            localObject2 = paramViewGroup.nBX;
            com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1149L, 2L, 1L, false);
            localObject3 = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).mContext;
            if (((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBh == null)
            {
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBh = ((ViewStub)((View)localObject2).findViewById(2131307258)).inflate();
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).bKj();
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBG = ((TextView)((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBh.findViewById(2131297298));
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBH = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBh.findViewById(2131298374);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBI = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBh.findViewById(2131298373);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBJ = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBh.findViewById(2131297296);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBK = ((TextView)((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBh.findViewById(2131297297));
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBL = ((MMNeat7extView)((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBh.findViewById(2131297294));
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).ijv = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBh.findViewById(2131297295);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nCc = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBh.findViewById(2131297291);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nCd = ((TextView)((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBh.findViewById(2131297292));
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nCe = ((MMNeat7extView)((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBh.findViewById(2131297293));
              ((WeImageView)((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBh.findViewById(2131302669)).setIconColor(((Context)localObject3).getResources().getColor(2131099664));
            }
            ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBh.setVisibility(0);
            localObject2 = localt.eZp();
            if ((localObject2 == null) || (((dgb)localObject2).FPo == null)) {
              paramView.setVisibility(8);
            }
            for (;;)
            {
              paramViewGroup.nBV.hide();
              paramViewGroup.nBU.hide();
              break;
              paramView.setVisibility(0);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBG.setText(((dgb)localObject2).FPn);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBF.getPaint().setFakeBoldText(true);
              localObject3 = ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).fuY;
              localObject4 = ((dgb)localObject2).FPo.FPx;
              localObject5 = new c.a();
              ((c.a)localObject5).hKL = 2131231342;
              ((c.a)localObject5).hKw = true;
              ((c.a)localObject5).gLt = true;
              com.tencent.mm.av.o.aFB().a((String)localObject4, (ImageView)localObject3, ((c.a)localObject5).aFT());
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBF.setText(((dgb)localObject2).FPo.ndW);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBK.setText(((dgb)localObject2).FPo.FPw);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBL.ar(((dgb)localObject2).FPo.iJW);
              localObject3 = ((dgb)localObject2).FPo.ncR;
              localObject4 = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt((String)localObject3);
              if ((localObject4 == null) || ((int)((com.tencent.mm.n.b)localObject4).fLJ <= 0)) {
                ar.a.hnw.a((String)localObject3, "", null);
              }
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBJ.setOnClickListener(new i.1((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1, (String)localObject3, localt));
              if ((((dgb)localObject2).FPq != null) && (((dgb)localObject2).FPq.get(0) != null) && ((((dgc)((dgb)localObject2).FPq.get(0)).DPI & 0x1) == 0))
              {
                localObject3 = (dgc)((dgb)localObject2).FPq.get(0);
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nCc.setVisibility(0);
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).ijv.setVisibility(0);
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nCd.setText(((dgb)localObject2).FPp);
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nCe.ar(((dgc)localObject3).Title);
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nCc.setOnClickListener(new i.2((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1, localt, (dgc)localObject3));
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBJ.setBackgroundResource(2131231262);
                if ((((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).ys(1)) && (!bs.isNullOrNil(((dgc)localObject3).Ean)))
                {
                  ac.d("MicroMsg.BizTimeLineItem", "preload %s", new Object[] { ((dgc)localObject3).Ean });
                  ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.b.class)).a(((dgc)localObject3).Ean, ((dgc)localObject3).hkQ, 90, new Object[0]);
                }
                com.tencent.mm.plugin.brandservice.ui.b.c.h(localt);
                localObject3 = localt.eZq();
                if (localObject3 == null) {
                  continue;
                }
                localObject4 = ((dgb)localObject2).FPt;
                if (localObject4 != null) {
                  break label4948;
                }
                ac.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo = null");
                i = 0;
              }
              for (;;)
              {
                if ((i != 0) || (!bs.gY(((dgg)localObject3).FPD))) {
                  break label5033;
                }
                ac.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] hideNegativeFeedback，BizNickName = %s", new Object[] { ((dgb)localObject2).FPo.ndW });
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBH.setVisibility(8);
                break;
                com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(1149L, 6L, 1L, false);
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).ijv.setVisibility(8);
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nCc.setVisibility(8);
                ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBJ.setBackgroundResource(2131231256);
                break label4806;
                if (((dgf)localObject4).FPA == null)
                {
                  ac.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo = null");
                  i = 0;
                }
                else if (((dgf)localObject4).FPA.EDg != 1)
                {
                  ac.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.ShowNegativeFeedbackReason != 1");
                  i = 0;
                }
                else if (bs.gY(((dgf)localObject4).FPA.EDf))
                {
                  ac.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] shouldShowNegativeFeedback recCardUserInfo.FeedbackInfo.NegativeFeedbackReason null");
                  i = 0;
                }
                else
                {
                  i = 1;
                }
              }
              ac.i("MicroMsg.BizTimeLineItem", "[TRACE_BIZRECCARD] showNegativeFeedback，BizNickName = %s", new Object[] { ((dgb)localObject2).FPo.ndW });
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBH.setVisibility(0);
              ((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1).nBH.setOnClickListener(new i.3((com.tencent.mm.plugin.brandservice.ui.timeline.a.i)localObject1, localt, paramInt));
            }
          case 2: 
            paramViewGroup.nBU.a(localt, paramInt, paramView, paramViewGroup.nBX);
            paramViewGroup.nBV.hide();
            paramViewGroup.nBW.hide();
            break;
          case 3: 
            label4948:
            paramViewGroup.nBU.hide();
            paramViewGroup.nBV.a(localt, paramInt, paramView, paramViewGroup.nBX);
            paramViewGroup.nBW.hide();
            break;
            paramViewGroup.nBh = View.inflate(paramView, 2131493230, null);
            paramViewGroup.bKj();
            paramView = paramViewGroup.nBh;
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
      if (af.aDd().bQe() > 0)
      {
        AppMethodBeat.o(5885);
        return false;
      }
      dhi localdhi = com.tencent.mm.plugin.brandservice.ui.timeline.offenread.e.bKr();
      if ((localdhi != null) && (!bs.gY(localdhi.FQB))) {}
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
  
  public final com.tencent.mm.storage.t yG(int paramInt)
  {
    AppMethodBeat.i(5869);
    if ((paramInt < this.mgF.size()) && (paramInt >= 0))
    {
      com.tencent.mm.storage.t localt = (com.tencent.mm.storage.t)this.mgF.get(paramInt);
      AppMethodBeat.o(5869);
      return localt;
    }
    AppMethodBeat.o(5869);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.c
 * JD-Core Version:    0.7.0.1
 */
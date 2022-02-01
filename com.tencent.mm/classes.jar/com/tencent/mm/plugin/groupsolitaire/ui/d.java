package com.tencent.mm.plugin.groupsolitaire.ui;

import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Message;
import android.util.Pair;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.messenger.foundation.a.i;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.o;
import java.util.HashMap;

public final class d
  implements c
{
  public String content;
  boolean isNew;
  TextView kEu;
  private int lastType;
  private View mContentView;
  Context mContext;
  ap mHandler;
  ValueAnimator qT;
  public String srH;
  com.tencent.mm.bs.d.b ssb;
  public o ssc;
  public View ssd;
  d sse;
  boolean ssf;
  public String ssg;
  com.tencent.mm.plugin.groupsolitaire.c.a ssh;
  String ssi;
  int ssj;
  int ssk;
  int ssl;
  int[] ssm;
  public com.tencent.mm.plugin.groupsolitaire.c.a ssn;
  private String sso;
  public a ssp;
  public b ssq;
  public c ssr;
  public View sss;
  
  public d(Context paramContext, com.tencent.mm.bs.d.b paramb, d paramd)
  {
    AppMethodBeat.i(110504);
    this.qT = null;
    this.ssf = false;
    this.ssg = "";
    this.srH = "";
    this.ssh = null;
    this.ssi = "";
    this.ssn = null;
    this.sso = "";
    this.ssr = null;
    this.mHandler = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(110497);
        switch (paramAnonymousMessage.what)
        {
        }
        for (;;)
        {
          AppMethodBeat.o(110497);
          return;
          d locald = d.this;
          String str = (String)paramAnonymousMessage.obj;
          int i = paramAnonymousMessage.arg1;
          ad.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "showTips()");
          if ((!((i)g.ab(i.class)).adh(locald.srH)) || (bt.isNullOrNil(locald.content)) || (locald.sss == null))
          {
            ad.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "showTips() show close");
            AppMethodBeat.o(110497);
            return;
          }
          locald.mHandler.removeMessages(20001);
          locald.isNew = false;
          if (i == 1)
          {
            locald.kEu.setText(2131760114);
            locald.isNew = true;
          }
          while (locald.ssc.isShowing())
          {
            ad.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "showTips() mBubbleState isShowing");
            AppMethodBeat.o(110497);
            return;
            locald.isNew = com.tencent.mm.plugin.groupsolitaire.b.b.P(locald.srH, str, locald.ssh.sra.size());
            if (locald.isNew)
            {
              locald.kEu.setText(2131760114);
              if (com.tencent.mm.plugin.groupsolitaire.b.b.adk(locald.ssh.header))
              {
                if (locald.ssc.isShowing()) {
                  locald.cFn();
                }
                AppMethodBeat.o(110497);
              }
            }
            else
            {
              locald.kEu.setText(2131760113);
            }
          }
          if (locald.isNew) {
            if (i == 1)
            {
              ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
              com.tencent.mm.plugin.groupsolitaire.b.d.dv(locald.srH, 3);
            }
          }
          for (;;)
          {
            if (locald.ssd != null)
            {
              locald.ssm = new int[2];
              locald.ssd.getLocationInWindow(locald.ssm);
              locald.ssl = 0;
              locald.ssj = (locald.ssd.getWidth() - locald.ssc.getWidth() - com.tencent.mm.cd.a.fromDPToPix(locald.mContext, 8));
              locald.ssk = (locald.ssm[1] - locald.ssc.getHeight() - com.tencent.mm.cd.a.fromDPToPix(locald.mContext, 8));
              if ((locald.ssr != null) && (!locald.ssr.cFp())) {
                locald.ssk += locald.ssr.cFo();
              }
              locald.ssc.showAtLocation(locald.ssd, 0, locald.ssj, locald.ssk);
              locald.ssd.getViewTreeObserver().addOnGlobalLayoutListener(new d.3(locald));
            }
            AppMethodBeat.o(110497);
            return;
            ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            com.tencent.mm.plugin.groupsolitaire.b.d.dv(locald.srH, 2);
            continue;
            ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            com.tencent.mm.plugin.groupsolitaire.b.d.dv(locald.srH, 1);
          }
          d.this.cFn();
        }
      }
    };
    this.isNew = false;
    ad.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "SuggestSolitatireTips()");
    this.mContext = paramContext;
    this.ssb = paramb;
    this.sse = paramd;
    this.ssp = new a(this.mContext, this.mHandler, this);
    this.ssq = new b(this.mContext, this.mHandler, this);
    this.ssi = this.mContext.getString(2131760093);
    this.mContentView = View.inflate(this.mContext, 2131495733, null);
    this.mContentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110499);
        ad.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "click Tips");
        if ((d.this.ssh == null) && (!com.tencent.mm.plugin.groupsolitaire.b.b.az(d.this.mContext, d.this.content)))
        {
          ad.e("MicroMsg.groupsolitaire.SuggestSolitatireTips", "why here???");
          AppMethodBeat.o(110499);
          return;
        }
        paramAnonymousView = new Intent();
        if (d.this.ssh == null)
        {
          d.this.ssh = new com.tencent.mm.plugin.groupsolitaire.c.a();
          d.this.ssh.header = (d.this.ssi + "\n");
          d.this.ssh.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.ssh);
          d.this.ssh.separator = ".";
          d.this.ssh.srd = 1;
          paramAnonymousView.putExtra("key_group_solitatire_create", true);
          paramAnonymousView.putExtra("key_group_solitatire_scene", 4);
          paramAnonymousView.putExtra("key_group_solitatire_key", d.this.ssh.field_key);
          paramAnonymousView.putExtra("key_group_solitatire_chatroom_username", d.this.srH);
          com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.srH, d.this.ssh);
          ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().c(d.this.srH, d.this.ssh);
          com.tencent.mm.bs.d.a(d.this.ssb, "groupsolitaire", ".ui.GroupSolitatireEditUI", paramAnonymousView, 3001, new com.tencent.mm.bs.d.a()
          {
            public final void onActivityResult(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
            {
              AppMethodBeat.i(110498);
              if (paramAnonymous2Int1 == 3001)
              {
                ad.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "dealWithRequestCode() REQUEST_CODE_VIEW_GROUP_SOLITATIRE resultCode:%s", new Object[] { Integer.valueOf(paramAnonymous2Int2) });
                if ((-1 == paramAnonymous2Int2) && (d.this.sse != null))
                {
                  d.this.sse.cFq();
                  d.this.reset();
                  if (paramAnonymous2Intent != null) {
                    d.this.sse.adu(paramAnonymous2Intent.getStringExtra("key_group_solitatire_content"));
                  }
                  d.this.ssf = true;
                }
              }
              AppMethodBeat.o(110498);
            }
          });
          d.this.cFn();
          AppMethodBeat.o(110499);
          return;
        }
        d.this.ssh.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.ssh);
        Pair localPair = com.tencent.mm.plugin.groupsolitaire.b.b.gF(d.this.srH, d.this.ssh.field_key);
        if (((Boolean)localPair.first).booleanValue()) {
          if (d.this.isNew)
          {
            paramAnonymousView.putExtra("key_group_solitatire_create", true);
            if (!com.tencent.mm.plugin.groupsolitaire.b.b.aA(d.this.mContext, d.this.content))
            {
              d.this.ssh.header = (d.this.mContext.getString(2131760093) + "\n" + d.this.ssh.header);
              d.this.ssh.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.ssh);
            }
          }
        }
        for (;;)
        {
          paramAnonymousView.putExtra("key_group_solitatire_scene", 3);
          break;
          paramAnonymousView.putExtra("key_group_solitatire_create", false);
          d.this.ssh = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.ssh, d.this.ssn, (com.tencent.mm.plugin.groupsolitaire.c.a)localPair.second);
          continue;
          if (!com.tencent.mm.plugin.groupsolitaire.b.b.aA(d.this.mContext, d.this.content))
          {
            d.this.ssh.header = (d.this.mContext.getString(2131760093) + "\n" + d.this.ssh.header);
            d.this.ssh.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.ssh);
          }
          paramAnonymousView.putExtra("key_group_solitatire_create", true);
        }
      }
    });
    this.ssc = new o(this.mContentView, com.tencent.mm.cd.a.ap(this.mContext, 2131166919), com.tencent.mm.cd.a.ap(this.mContext, 2131166918), true);
    this.ssc.setBackgroundDrawable(new ColorDrawable(0));
    this.ssc.setOutsideTouchable(false);
    this.ssc.setFocusable(false);
    this.ssc.setAnimationStyle(2131821219);
    this.kEu = ((TextView)this.mContentView.findViewById(2131305112));
    this.kEu.setTextSize(0, com.tencent.mm.cd.a.ap(this.mContext, 2131165466));
    ((TextView)this.mContentView.findViewById(2131305109)).setTextSize(0, com.tencent.mm.cd.a.ap(this.mContext, 2131165192));
    this.lastType = 1;
    AppMethodBeat.o(110504);
  }
  
  public final void ads(String paramString)
  {
    this.ssi = paramString;
  }
  
  public final void c(com.tencent.mm.plugin.groupsolitaire.c.a parama, String paramString)
  {
    AppMethodBeat.i(178797);
    if (this.ssn == null)
    {
      this.ssn = parama;
      this.sso = paramString;
      AppMethodBeat.o(178797);
      return;
    }
    if ((this.ssn != null) && (parama == null))
    {
      this.ssn = null;
      this.sso = "";
      AppMethodBeat.o(178797);
      return;
    }
    ad.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "setCopyGroupSolitaire repeat");
    AppMethodBeat.o(178797);
  }
  
  public final boolean cFm()
  {
    boolean bool = this.ssf;
    this.ssf = false;
    return bool;
  }
  
  public final void cFn()
  {
    AppMethodBeat.i(110505);
    ad.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "hideTips()");
    if (this.ssc.isShowing()) {
      this.ssc.dismiss();
    }
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandler.removeMessages(20002);
    AppMethodBeat.o(110505);
  }
  
  public final void j(com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    this.ssh = parama;
  }
  
  public final void reset()
  {
    this.ssg = "";
    this.ssn = null;
    this.ssh = null;
  }
  
  public static class a
    implements Runnable
  {
    protected String content;
    protected ap handler;
    protected Context mContext;
    protected String srH;
    protected c ssx;
    
    public a(Context paramContext, ap paramap, c paramc)
    {
      this.mContext = paramContext;
      this.handler = paramap;
      this.ssx = paramc;
    }
    
    public final void adt(String paramString)
    {
      this.srH = paramString;
    }
    
    public void run()
    {
      AppMethodBeat.i(110503);
      try
      {
        Pair localPair = ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().gJ(this.content, this.srH);
        if (((Integer)localPair.first).intValue() > com.tencent.mm.plugin.groupsolitaire.b.b.cEW())
        {
          this.handler.sendEmptyMessage(20002);
          AppMethodBeat.o(110503);
          return;
        }
        if ((((Integer)localPair.first).intValue() <= 0) && ((localPair.second == null) || (((com.tencent.mm.plugin.groupsolitaire.c.a)localPair.second).srd <= 0))) {
          break label219;
        }
        this.ssx.j((com.tencent.mm.plugin.groupsolitaire.c.a)localPair.second);
        if (com.tencent.mm.plugin.groupsolitaire.b.b.d((com.tencent.mm.plugin.groupsolitaire.c.a)localPair.second))
        {
          Message localMessage2 = new Message();
          localMessage2.what = 20001;
          localMessage2.obj = com.tencent.mm.plugin.groupsolitaire.b.b.a((com.tencent.mm.plugin.groupsolitaire.c.a)localPair.second);
          this.handler.sendMessage(localMessage2);
          AppMethodBeat.o(110503);
          return;
        }
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.groupsolitaire.SuggestSolitatireTips", "CheckRunnable run() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        AppMethodBeat.o(110503);
        return;
      }
      this.handler.sendEmptyMessage(20002);
      AppMethodBeat.o(110503);
      return;
      label219:
      if (com.tencent.mm.plugin.groupsolitaire.b.b.az(this.mContext, this.content))
      {
        this.ssx.j(null);
        Message localMessage1 = new Message();
        localMessage1.what = 20001;
        localMessage1.arg1 = 1;
        this.ssx.ads(this.content.trim());
        this.handler.sendMessage(localMessage1);
        AppMethodBeat.o(110503);
        return;
      }
      this.handler.sendEmptyMessage(20002);
      AppMethodBeat.o(110503);
    }
    
    public final void setContent(String paramString)
    {
      this.content = paramString;
    }
  }
  
  public final class b
    extends d.a
  {
    public b(Context paramContext, ap paramap, c paramc)
    {
      super(paramap, paramc);
    }
    
    public final void run()
    {
      AppMethodBeat.i(178796);
      try
      {
        Pair localPair = ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().gJ(this.content, this.srH);
        int i = ((Integer)localPair.first).intValue();
        int j = com.tencent.mm.plugin.groupsolitaire.b.b.cEW();
        if (i > j)
        {
          AppMethodBeat.o(178796);
          return;
        }
        if (((Integer)localPair.first).intValue() > 0) {
          this.ssx.c((com.tencent.mm.plugin.groupsolitaire.c.a)localPair.second, this.content);
        }
        AppMethodBeat.o(178796);
        return;
      }
      catch (Exception localException)
      {
        ad.e("MicroMsg.groupsolitaire.SuggestSolitatireTips", "CheckRunnable run() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        AppMethodBeat.o(178796);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract int cFo();
    
    public abstract boolean cFp();
  }
  
  public static abstract interface d
  {
    public abstract void adu(String paramString);
    
    public abstract void cFq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.d
 * JD-Core Version:    0.7.0.1
 */
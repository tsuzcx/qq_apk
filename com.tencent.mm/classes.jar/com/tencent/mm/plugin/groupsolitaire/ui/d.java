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
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.o;
import java.util.HashMap;

public final class d
  implements c
{
  ValueAnimator animator;
  public String content;
  boolean isNew;
  TextView lCL;
  private int lastType;
  private View mContentView;
  Context mContext;
  ap mHandler;
  com.tencent.mm.bs.d.b uCA;
  public o uCB;
  public View uCC;
  d uCD;
  boolean uCE;
  public String uCF;
  com.tencent.mm.plugin.groupsolitaire.c.a uCG;
  String uCH;
  int uCI;
  int uCJ;
  int uCK;
  int[] uCL;
  public com.tencent.mm.plugin.groupsolitaire.c.a uCM;
  private String uCN;
  public a uCO;
  public b uCP;
  public c uCQ;
  public View uCR;
  public String uCh;
  
  public d(Context paramContext, com.tencent.mm.bs.d.b paramb, d paramd)
  {
    AppMethodBeat.i(110504);
    this.animator = null;
    this.uCE = false;
    this.uCF = "";
    this.uCh = "";
    this.uCG = null;
    this.uCH = "";
    this.uCM = null;
    this.uCN = "";
    this.uCQ = null;
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
          if ((!((j)g.ab(j.class)).amM(locald.uCh)) || (bt.isNullOrNil(locald.content)) || (locald.uCR == null))
          {
            ad.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "showTips() show close");
            AppMethodBeat.o(110497);
            return;
          }
          locald.mHandler.removeMessages(20001);
          locald.isNew = false;
          if (i == 1)
          {
            locald.lCL.setText(2131760114);
            locald.isNew = true;
          }
          while (locald.uCB.isShowing())
          {
            ad.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "showTips() mBubbleState isShowing");
            AppMethodBeat.o(110497);
            return;
            locald.isNew = com.tencent.mm.plugin.groupsolitaire.b.b.T(locald.uCh, str, locald.uCG.uBB.size());
            if (locald.isNew)
            {
              locald.lCL.setText(2131760114);
              if (com.tencent.mm.plugin.groupsolitaire.b.b.amP(locald.uCG.header))
              {
                if (locald.uCB.isShowing()) {
                  locald.dbE();
                }
                AppMethodBeat.o(110497);
              }
            }
            else
            {
              locald.lCL.setText(2131760113);
            }
          }
          if (locald.isNew) {
            if (i == 1)
            {
              ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
              com.tencent.mm.plugin.groupsolitaire.b.d.dS(locald.uCh, 3);
            }
          }
          for (;;)
          {
            if (locald.uCC != null)
            {
              locald.uCL = new int[2];
              locald.uCC.getLocationInWindow(locald.uCL);
              locald.uCK = 0;
              locald.uCI = (locald.uCC.getWidth() - locald.uCB.getWidth() - com.tencent.mm.cc.a.fromDPToPix(locald.mContext, 8));
              locald.uCJ = (locald.uCL[1] - locald.uCB.getHeight() - com.tencent.mm.cc.a.fromDPToPix(locald.mContext, 8));
              if ((locald.uCQ != null) && (!locald.uCQ.dbG())) {
                locald.uCJ += locald.uCQ.dbF();
              }
              locald.uCB.showAtLocation(locald.uCC, 0, locald.uCI, locald.uCJ);
              locald.uCC.getViewTreeObserver().addOnGlobalLayoutListener(new d.3(locald));
            }
            AppMethodBeat.o(110497);
            return;
            ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            com.tencent.mm.plugin.groupsolitaire.b.d.dS(locald.uCh, 2);
            continue;
            ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            com.tencent.mm.plugin.groupsolitaire.b.d.dS(locald.uCh, 1);
          }
          d.this.dbE();
        }
      }
    };
    this.isNew = false;
    ad.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "SuggestSolitatireTips()");
    this.mContext = paramContext;
    this.uCA = paramb;
    this.uCD = paramd;
    this.uCO = new a(this.mContext, this.mHandler, this);
    this.uCP = new b(this.mContext, this.mHandler, this);
    this.uCH = this.mContext.getString(2131760093);
    this.mContentView = View.inflate(this.mContext, 2131495733, null);
    this.mContentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110499);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/SuggestSolitatireTips$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahq());
        ad.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "click Tips");
        if ((d.this.uCG == null) && (!com.tencent.mm.plugin.groupsolitaire.b.b.aD(d.this.mContext, d.this.content)))
        {
          ad.e("MicroMsg.groupsolitaire.SuggestSolitatireTips", "why here???");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/SuggestSolitatireTips$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(110499);
          return;
        }
        paramAnonymousView = new Intent();
        if (d.this.uCG == null)
        {
          d.this.uCG = new com.tencent.mm.plugin.groupsolitaire.c.a();
          d.this.uCG.header = (d.this.uCH + "\n");
          d.this.uCG.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.uCG);
          d.this.uCG.separator = ".";
          d.this.uCG.uBD = 1;
          paramAnonymousView.putExtra("key_group_solitatire_create", true);
          paramAnonymousView.putExtra("key_group_solitatire_scene", 4);
          paramAnonymousView.putExtra("key_group_solitatire_key", d.this.uCG.field_key);
          paramAnonymousView.putExtra("key_group_solitatire_chatroom_username", d.this.uCh);
          com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.uCh, d.this.uCG);
          ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().c(d.this.uCh, d.this.uCG);
          com.tencent.mm.bs.d.a(d.this.uCA, "groupsolitaire", ".ui.GroupSolitatireEditUI", paramAnonymousView, 3001, new com.tencent.mm.bs.d.a()
          {
            public final void onActivityResult(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
            {
              AppMethodBeat.i(110498);
              if (paramAnonymous2Int1 == 3001)
              {
                ad.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "dealWithRequestCode() REQUEST_CODE_VIEW_GROUP_SOLITATIRE resultCode:%s", new Object[] { Integer.valueOf(paramAnonymous2Int2) });
                if ((-1 == paramAnonymous2Int2) && (d.this.uCD != null))
                {
                  d.this.uCD.dbH();
                  d.this.reset();
                  if (paramAnonymous2Intent != null) {
                    d.this.uCD.amZ(paramAnonymous2Intent.getStringExtra("key_group_solitatire_content"));
                  }
                  d.this.uCE = true;
                }
              }
              AppMethodBeat.o(110498);
            }
          });
          d.this.dbE();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/SuggestSolitatireTips$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(110499);
          return;
        }
        d.this.uCG.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.uCG);
        localObject = com.tencent.mm.plugin.groupsolitaire.b.b.hi(d.this.uCh, d.this.uCG.field_key);
        if (((Boolean)((Pair)localObject).first).booleanValue()) {
          if (d.this.isNew)
          {
            paramAnonymousView.putExtra("key_group_solitatire_create", true);
            if (!com.tencent.mm.plugin.groupsolitaire.b.b.aE(d.this.mContext, d.this.content))
            {
              d.this.uCG.header = (d.this.mContext.getString(2131760093) + "\n" + d.this.uCG.header);
              d.this.uCG.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.uCG);
            }
          }
        }
        for (;;)
        {
          paramAnonymousView.putExtra("key_group_solitatire_scene", 3);
          break;
          paramAnonymousView.putExtra("key_group_solitatire_create", false);
          d.this.uCG = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.uCG, d.this.uCM, (com.tencent.mm.plugin.groupsolitaire.c.a)((Pair)localObject).second);
          continue;
          if (!com.tencent.mm.plugin.groupsolitaire.b.b.aE(d.this.mContext, d.this.content))
          {
            d.this.uCG.header = (d.this.mContext.getString(2131760093) + "\n" + d.this.uCG.header);
            d.this.uCG.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.uCG);
          }
          paramAnonymousView.putExtra("key_group_solitatire_create", true);
        }
      }
    });
    this.uCB = new o(this.mContentView, com.tencent.mm.cc.a.ay(this.mContext, 2131166919), com.tencent.mm.cc.a.ay(this.mContext, 2131166918), true);
    this.uCB.setBackgroundDrawable(new ColorDrawable(0));
    this.uCB.setOutsideTouchable(false);
    this.uCB.setFocusable(false);
    this.uCB.setAnimationStyle(2131821219);
    this.lCL = ((TextView)this.mContentView.findViewById(2131305112));
    this.lCL.setTextSize(0, com.tencent.mm.cc.a.ay(this.mContext, 2131165466));
    ((TextView)this.mContentView.findViewById(2131305109)).setTextSize(0, com.tencent.mm.cc.a.ay(this.mContext, 2131165192));
    this.lastType = 1;
    AppMethodBeat.o(110504);
  }
  
  public final void amX(String paramString)
  {
    this.uCH = paramString;
  }
  
  public final void c(com.tencent.mm.plugin.groupsolitaire.c.a parama, String paramString)
  {
    AppMethodBeat.i(178797);
    if (this.uCM == null)
    {
      this.uCM = parama;
      this.uCN = paramString;
      AppMethodBeat.o(178797);
      return;
    }
    if ((this.uCM != null) && (parama == null))
    {
      this.uCM = null;
      this.uCN = "";
      AppMethodBeat.o(178797);
      return;
    }
    ad.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "setCopyGroupSolitaire repeat");
    AppMethodBeat.o(178797);
  }
  
  public final boolean dbD()
  {
    boolean bool = this.uCE;
    this.uCE = false;
    return bool;
  }
  
  public final void dbE()
  {
    AppMethodBeat.i(110505);
    ad.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "hideTips()");
    if (this.uCB.isShowing()) {
      this.uCB.dismiss();
    }
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandler.removeMessages(20002);
    AppMethodBeat.o(110505);
  }
  
  public final void j(com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    this.uCG = parama;
  }
  
  public final void reset()
  {
    this.uCF = "";
    this.uCM = null;
    this.uCG = null;
  }
  
  public static class a
    implements Runnable
  {
    protected String content;
    protected ap handler;
    protected Context mContext;
    protected c uCW;
    protected String uCh;
    
    public a(Context paramContext, ap paramap, c paramc)
    {
      this.mContext = paramContext;
      this.handler = paramap;
      this.uCW = paramc;
    }
    
    public final void amY(String paramString)
    {
      this.uCh = paramString;
    }
    
    public void run()
    {
      AppMethodBeat.i(110503);
      try
      {
        Pair localPair = ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().hm(this.content, this.uCh);
        if (((Integer)localPair.first).intValue() > com.tencent.mm.plugin.groupsolitaire.b.b.dbm())
        {
          this.handler.sendEmptyMessage(20002);
          AppMethodBeat.o(110503);
          return;
        }
        if ((((Integer)localPair.first).intValue() <= 0) && ((localPair.second == null) || (((com.tencent.mm.plugin.groupsolitaire.c.a)localPair.second).uBD <= 0))) {
          break label219;
        }
        this.uCW.j((com.tencent.mm.plugin.groupsolitaire.c.a)localPair.second);
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
      if (com.tencent.mm.plugin.groupsolitaire.b.b.aD(this.mContext, this.content))
      {
        this.uCW.j(null);
        Message localMessage1 = new Message();
        localMessage1.what = 20001;
        localMessage1.arg1 = 1;
        this.uCW.amX(this.content.trim());
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
        Pair localPair = ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().hm(this.content, this.uCh);
        int i = ((Integer)localPair.first).intValue();
        int j = com.tencent.mm.plugin.groupsolitaire.b.b.dbm();
        if (i > j)
        {
          AppMethodBeat.o(178796);
          return;
        }
        if (((Integer)localPair.first).intValue() > 0) {
          this.uCW.c((com.tencent.mm.plugin.groupsolitaire.c.a)localPair.second, this.content);
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
    public abstract int dbF();
    
    public abstract boolean dbG();
  }
  
  public static abstract interface d
  {
    public abstract void amZ(String paramString);
    
    public abstract void dbH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.d
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.o;
import java.util.HashMap;

public final class d
  implements c
{
  public String content;
  boolean isNew;
  private int lastType;
  TextView lfN;
  private View mContentView;
  Context mContext;
  ao mHandler;
  ValueAnimator rT;
  int tAa;
  int tAb;
  int[] tAc;
  public com.tencent.mm.plugin.groupsolitaire.c.a tAd;
  private String tAe;
  public a tAf;
  public b tAg;
  public c tAh;
  public View tAi;
  com.tencent.mm.br.d.b tzR;
  public o tzS;
  public View tzT;
  d tzU;
  boolean tzV;
  public String tzW;
  com.tencent.mm.plugin.groupsolitaire.c.a tzX;
  String tzY;
  int tzZ;
  public String tzy;
  
  public d(Context paramContext, com.tencent.mm.br.d.b paramb, d paramd)
  {
    AppMethodBeat.i(110504);
    this.rT = null;
    this.tzV = false;
    this.tzW = "";
    this.tzy = "";
    this.tzX = null;
    this.tzY = "";
    this.tAd = null;
    this.tAe = "";
    this.tAh = null;
    this.mHandler = new ao()
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
          ac.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "showTips()");
          if ((!((i)g.ab(i.class)).ahZ(locald.tzy)) || (bs.isNullOrNil(locald.content)) || (locald.tAi == null))
          {
            ac.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "showTips() show close");
            AppMethodBeat.o(110497);
            return;
          }
          locald.mHandler.removeMessages(20001);
          locald.isNew = false;
          if (i == 1)
          {
            locald.lfN.setText(2131760114);
            locald.isNew = true;
          }
          while (locald.tzS.isShowing())
          {
            ac.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "showTips() mBubbleState isShowing");
            AppMethodBeat.o(110497);
            return;
            locald.isNew = com.tencent.mm.plugin.groupsolitaire.b.b.Q(locald.tzy, str, locald.tzX.tyS.size());
            if (locald.isNew)
            {
              locald.lfN.setText(2131760114);
              if (com.tencent.mm.plugin.groupsolitaire.b.b.aic(locald.tzX.header))
              {
                if (locald.tzS.isShowing()) {
                  locald.cSx();
                }
                AppMethodBeat.o(110497);
              }
            }
            else
            {
              locald.lfN.setText(2131760113);
            }
          }
          if (locald.isNew) {
            if (i == 1)
            {
              ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
              com.tencent.mm.plugin.groupsolitaire.b.d.dB(locald.tzy, 3);
            }
          }
          for (;;)
          {
            if (locald.tzT != null)
            {
              locald.tAc = new int[2];
              locald.tzT.getLocationInWindow(locald.tAc);
              locald.tAb = 0;
              locald.tzZ = (locald.tzT.getWidth() - locald.tzS.getWidth() - com.tencent.mm.cc.a.fromDPToPix(locald.mContext, 8));
              locald.tAa = (locald.tAc[1] - locald.tzS.getHeight() - com.tencent.mm.cc.a.fromDPToPix(locald.mContext, 8));
              if ((locald.tAh != null) && (!locald.tAh.cSz())) {
                locald.tAa += locald.tAh.cSy();
              }
              locald.tzS.showAtLocation(locald.tzT, 0, locald.tzZ, locald.tAa);
              locald.tzT.getViewTreeObserver().addOnGlobalLayoutListener(new d.3(locald));
            }
            AppMethodBeat.o(110497);
            return;
            ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            com.tencent.mm.plugin.groupsolitaire.b.d.dB(locald.tzy, 2);
            continue;
            ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            com.tencent.mm.plugin.groupsolitaire.b.d.dB(locald.tzy, 1);
          }
          d.this.cSx();
        }
      }
    };
    this.isNew = false;
    ac.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "SuggestSolitatireTips()");
    this.mContext = paramContext;
    this.tzR = paramb;
    this.tzU = paramd;
    this.tAf = new a(this.mContext, this.mHandler, this);
    this.tAg = new b(this.mContext, this.mHandler, this);
    this.tzY = this.mContext.getString(2131760093);
    this.mContentView = View.inflate(this.mContext, 2131495733, null);
    this.mContentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110499);
        ac.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "click Tips");
        if ((d.this.tzX == null) && (!com.tencent.mm.plugin.groupsolitaire.b.b.aA(d.this.mContext, d.this.content)))
        {
          ac.e("MicroMsg.groupsolitaire.SuggestSolitatireTips", "why here???");
          AppMethodBeat.o(110499);
          return;
        }
        paramAnonymousView = new Intent();
        if (d.this.tzX == null)
        {
          d.this.tzX = new com.tencent.mm.plugin.groupsolitaire.c.a();
          d.this.tzX.header = (d.this.tzY + "\n");
          d.this.tzX.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.tzX);
          d.this.tzX.separator = ".";
          d.this.tzX.tyU = 1;
          paramAnonymousView.putExtra("key_group_solitatire_create", true);
          paramAnonymousView.putExtra("key_group_solitatire_scene", 4);
          paramAnonymousView.putExtra("key_group_solitatire_key", d.this.tzX.field_key);
          paramAnonymousView.putExtra("key_group_solitatire_chatroom_username", d.this.tzy);
          com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.tzy, d.this.tzX);
          ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().c(d.this.tzy, d.this.tzX);
          com.tencent.mm.br.d.a(d.this.tzR, "groupsolitaire", ".ui.GroupSolitatireEditUI", paramAnonymousView, 3001, new com.tencent.mm.br.d.a()
          {
            public final void onActivityResult(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
            {
              AppMethodBeat.i(110498);
              if (paramAnonymous2Int1 == 3001)
              {
                ac.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "dealWithRequestCode() REQUEST_CODE_VIEW_GROUP_SOLITATIRE resultCode:%s", new Object[] { Integer.valueOf(paramAnonymous2Int2) });
                if ((-1 == paramAnonymous2Int2) && (d.this.tzU != null))
                {
                  d.this.tzU.cSA();
                  d.this.reset();
                  if (paramAnonymous2Intent != null) {
                    d.this.tzU.aim(paramAnonymous2Intent.getStringExtra("key_group_solitatire_content"));
                  }
                  d.this.tzV = true;
                }
              }
              AppMethodBeat.o(110498);
            }
          });
          d.this.cSx();
          AppMethodBeat.o(110499);
          return;
        }
        d.this.tzX.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.tzX);
        Pair localPair = com.tencent.mm.plugin.groupsolitaire.b.b.gW(d.this.tzy, d.this.tzX.field_key);
        if (((Boolean)localPair.first).booleanValue()) {
          if (d.this.isNew)
          {
            paramAnonymousView.putExtra("key_group_solitatire_create", true);
            if (!com.tencent.mm.plugin.groupsolitaire.b.b.aB(d.this.mContext, d.this.content))
            {
              d.this.tzX.header = (d.this.mContext.getString(2131760093) + "\n" + d.this.tzX.header);
              d.this.tzX.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.tzX);
            }
          }
        }
        for (;;)
        {
          paramAnonymousView.putExtra("key_group_solitatire_scene", 3);
          break;
          paramAnonymousView.putExtra("key_group_solitatire_create", false);
          d.this.tzX = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.tzX, d.this.tAd, (com.tencent.mm.plugin.groupsolitaire.c.a)localPair.second);
          continue;
          if (!com.tencent.mm.plugin.groupsolitaire.b.b.aB(d.this.mContext, d.this.content))
          {
            d.this.tzX.header = (d.this.mContext.getString(2131760093) + "\n" + d.this.tzX.header);
            d.this.tzX.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.tzX);
          }
          paramAnonymousView.putExtra("key_group_solitatire_create", true);
        }
      }
    });
    this.tzS = new o(this.mContentView, com.tencent.mm.cc.a.av(this.mContext, 2131166919), com.tencent.mm.cc.a.av(this.mContext, 2131166918), true);
    this.tzS.setBackgroundDrawable(new ColorDrawable(0));
    this.tzS.setOutsideTouchable(false);
    this.tzS.setFocusable(false);
    this.tzS.setAnimationStyle(2131821219);
    this.lfN = ((TextView)this.mContentView.findViewById(2131305112));
    this.lfN.setTextSize(0, com.tencent.mm.cc.a.av(this.mContext, 2131165466));
    ((TextView)this.mContentView.findViewById(2131305109)).setTextSize(0, com.tencent.mm.cc.a.av(this.mContext, 2131165192));
    this.lastType = 1;
    AppMethodBeat.o(110504);
  }
  
  public final void aik(String paramString)
  {
    this.tzY = paramString;
  }
  
  public final void c(com.tencent.mm.plugin.groupsolitaire.c.a parama, String paramString)
  {
    AppMethodBeat.i(178797);
    if (this.tAd == null)
    {
      this.tAd = parama;
      this.tAe = paramString;
      AppMethodBeat.o(178797);
      return;
    }
    if ((this.tAd != null) && (parama == null))
    {
      this.tAd = null;
      this.tAe = "";
      AppMethodBeat.o(178797);
      return;
    }
    ac.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "setCopyGroupSolitaire repeat");
    AppMethodBeat.o(178797);
  }
  
  public final boolean cSw()
  {
    boolean bool = this.tzV;
    this.tzV = false;
    return bool;
  }
  
  public final void cSx()
  {
    AppMethodBeat.i(110505);
    ac.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "hideTips()");
    if (this.tzS.isShowing()) {
      this.tzS.dismiss();
    }
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandler.removeMessages(20002);
    AppMethodBeat.o(110505);
  }
  
  public final void j(com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    this.tzX = parama;
  }
  
  public final void reset()
  {
    this.tzW = "";
    this.tAd = null;
    this.tzX = null;
  }
  
  public static class a
    implements Runnable
  {
    protected String content;
    protected ao handler;
    protected Context mContext;
    protected c tAn;
    protected String tzy;
    
    public a(Context paramContext, ao paramao, c paramc)
    {
      this.mContext = paramContext;
      this.handler = paramao;
      this.tAn = paramc;
    }
    
    public final void ail(String paramString)
    {
      this.tzy = paramString;
    }
    
    public void run()
    {
      AppMethodBeat.i(110503);
      try
      {
        Pair localPair = ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().ha(this.content, this.tzy);
        if (((Integer)localPair.first).intValue() > com.tencent.mm.plugin.groupsolitaire.b.b.cSg())
        {
          this.handler.sendEmptyMessage(20002);
          AppMethodBeat.o(110503);
          return;
        }
        if ((((Integer)localPair.first).intValue() <= 0) && ((localPair.second == null) || (((com.tencent.mm.plugin.groupsolitaire.c.a)localPair.second).tyU <= 0))) {
          break label219;
        }
        this.tAn.j((com.tencent.mm.plugin.groupsolitaire.c.a)localPair.second);
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
        ac.e("MicroMsg.groupsolitaire.SuggestSolitatireTips", "CheckRunnable run() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        AppMethodBeat.o(110503);
        return;
      }
      this.handler.sendEmptyMessage(20002);
      AppMethodBeat.o(110503);
      return;
      label219:
      if (com.tencent.mm.plugin.groupsolitaire.b.b.aA(this.mContext, this.content))
      {
        this.tAn.j(null);
        Message localMessage1 = new Message();
        localMessage1.what = 20001;
        localMessage1.arg1 = 1;
        this.tAn.aik(this.content.trim());
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
    public b(Context paramContext, ao paramao, c paramc)
    {
      super(paramao, paramc);
    }
    
    public final void run()
    {
      AppMethodBeat.i(178796);
      try
      {
        Pair localPair = ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().ha(this.content, this.tzy);
        int i = ((Integer)localPair.first).intValue();
        int j = com.tencent.mm.plugin.groupsolitaire.b.b.cSg();
        if (i > j)
        {
          AppMethodBeat.o(178796);
          return;
        }
        if (((Integer)localPair.first).intValue() > 0) {
          this.tAn.c((com.tencent.mm.plugin.groupsolitaire.c.a)localPair.second, this.content);
        }
        AppMethodBeat.o(178796);
        return;
      }
      catch (Exception localException)
      {
        ac.e("MicroMsg.groupsolitaire.SuggestSolitatireTips", "CheckRunnable run() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        AppMethodBeat.o(178796);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract int cSy();
    
    public abstract boolean cSz();
  }
  
  public static abstract interface d
  {
    public abstract void aim(String paramString);
    
    public abstract void cSA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.d
 * JD-Core Version:    0.7.0.1
 */
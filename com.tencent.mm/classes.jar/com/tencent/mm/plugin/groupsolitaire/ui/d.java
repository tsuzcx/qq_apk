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
import com.tencent.mm.br.c.a;
import com.tencent.mm.br.c.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.p;
import java.util.HashMap;

public final class d
  implements c
{
  ValueAnimator animator;
  public String content;
  boolean isNew;
  private int lastType;
  private View mContentView;
  Context mContext;
  MMHandler mHandler;
  TextView mPa;
  int[] wrA;
  c.b ygC;
  public p ygD;
  public View ygE;
  d ygF;
  boolean ygG;
  public String ygH;
  com.tencent.mm.plugin.groupsolitaire.c.a ygI;
  String ygJ;
  int ygK;
  int ygL;
  int ygM;
  public com.tencent.mm.plugin.groupsolitaire.c.a ygN;
  private String ygO;
  public a ygP;
  public b ygQ;
  public c ygR;
  public View ygS;
  public String ygk;
  
  public d(Context paramContext, c.b paramb, d paramd)
  {
    AppMethodBeat.i(110504);
    this.animator = null;
    this.ygG = false;
    this.ygH = "";
    this.ygk = "";
    this.ygI = null;
    this.ygJ = "";
    this.ygN = null;
    this.ygO = "";
    this.ygR = null;
    this.mHandler = new MMHandler()
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
          Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "showTips()");
          if ((!((j)g.af(j.class)).aBg(locald.ygk)) || (Util.isNullOrNil(locald.content)) || (locald.ygS == null))
          {
            Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "showTips() show close");
            AppMethodBeat.o(110497);
            return;
          }
          locald.mHandler.removeMessages(20001);
          locald.isNew = false;
          if (i == 1)
          {
            locald.mPa.setText(2131761495);
            locald.isNew = true;
          }
          while (locald.ygD.isShowing())
          {
            Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "showTips() mBubbleState isShowing");
            AppMethodBeat.o(110497);
            return;
            locald.isNew = com.tencent.mm.plugin.groupsolitaire.b.b.U(locald.ygk, str, locald.ygI.yfE.size());
            if (locald.isNew)
            {
              locald.mPa.setText(2131761495);
              if (com.tencent.mm.plugin.groupsolitaire.b.b.aBj(locald.ygI.header))
              {
                if (locald.ygD.isShowing()) {
                  locald.dYf();
                }
                AppMethodBeat.o(110497);
              }
            }
            else
            {
              locald.mPa.setText(2131761494);
            }
          }
          if (locald.isNew) {
            if (i == 1)
            {
              ((PluginGroupSolitaire)g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
              com.tencent.mm.plugin.groupsolitaire.b.d.en(locald.ygk, 3);
            }
          }
          for (;;)
          {
            if (locald.ygE != null)
            {
              locald.wrA = new int[2];
              locald.ygE.getLocationInWindow(locald.wrA);
              locald.ygM = 0;
              locald.ygK = (locald.ygE.getWidth() - locald.ygD.getWidth() - com.tencent.mm.cb.a.fromDPToPix(locald.mContext, 8));
              locald.ygL = (locald.wrA[1] - locald.ygD.getHeight() - com.tencent.mm.cb.a.fromDPToPix(locald.mContext, 8));
              if ((locald.ygR != null) && (!locald.ygR.dYh())) {
                locald.ygL += locald.ygR.dYg();
              }
              locald.ygD.showAtLocation(locald.ygE, 0, locald.ygK, locald.ygL);
              locald.ygE.getViewTreeObserver().addOnGlobalLayoutListener(new d.3(locald));
            }
            AppMethodBeat.o(110497);
            return;
            ((PluginGroupSolitaire)g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            com.tencent.mm.plugin.groupsolitaire.b.d.en(locald.ygk, 2);
            continue;
            ((PluginGroupSolitaire)g.ah(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            com.tencent.mm.plugin.groupsolitaire.b.d.en(locald.ygk, 1);
          }
          d.this.dYf();
        }
      }
    };
    this.isNew = false;
    Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "SuggestSolitatireTips()");
    this.mContext = paramContext;
    this.ygC = paramb;
    this.ygF = paramd;
    this.ygP = new a(this.mContext, this.mHandler, this);
    this.ygQ = new b(this.mContext, this.mHandler, this);
    this.ygJ = this.mContext.getString(2131761473);
    this.mContentView = View.inflate(this.mContext, 2131496638, null);
    this.mContentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110499);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/SuggestSolitatireTips$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
        Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "click Tips");
        if ((d.this.ygI == null) && (!com.tencent.mm.plugin.groupsolitaire.b.b.aS(d.this.mContext, d.this.content)))
        {
          Log.e("MicroMsg.groupsolitaire.SuggestSolitatireTips", "why here???");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/SuggestSolitatireTips$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(110499);
          return;
        }
        paramAnonymousView = new Intent();
        if (d.this.ygI == null)
        {
          d.this.ygI = new com.tencent.mm.plugin.groupsolitaire.c.a();
          d.this.ygI.header = (d.this.ygJ + "\n");
          d.this.ygI.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.ygI);
          d.this.ygI.separator = ".";
          d.this.ygI.yfG = 1;
          paramAnonymousView.putExtra("key_group_solitatire_create", true);
          paramAnonymousView.putExtra("key_group_solitatire_scene", 4);
          paramAnonymousView.putExtra("key_group_solitatire_key", d.this.ygI.field_key);
          paramAnonymousView.putExtra("key_group_solitatire_chatroom_username", d.this.ygk);
          com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.ygk, d.this.ygI);
          ((PluginGroupSolitaire)g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().c(d.this.ygk, d.this.ygI);
          com.tencent.mm.br.c.a(d.this.ygC, "groupsolitaire", ".ui.GroupSolitatireEditUI", paramAnonymousView, 3001, new c.a()
          {
            public final void onActivityResult(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
            {
              AppMethodBeat.i(110498);
              if (paramAnonymous2Int1 == 3001)
              {
                Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "dealWithRequestCode() REQUEST_CODE_VIEW_GROUP_SOLITATIRE resultCode:%s", new Object[] { Integer.valueOf(paramAnonymous2Int2) });
                if ((-1 == paramAnonymous2Int2) && (d.this.ygF != null))
                {
                  d.this.ygF.dYi();
                  d.this.reset();
                  if (paramAnonymous2Intent != null) {
                    d.this.ygF.aBt(paramAnonymous2Intent.getStringExtra("key_group_solitatire_content"));
                  }
                  d.this.ygG = true;
                }
              }
              AppMethodBeat.o(110498);
            }
          });
          d.this.dYf();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/SuggestSolitatireTips$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(110499);
          return;
        }
        d.this.ygI.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.ygI);
        localObject = com.tencent.mm.plugin.groupsolitaire.b.b.hW(d.this.ygk, d.this.ygI.field_key);
        if (((Boolean)((Pair)localObject).first).booleanValue()) {
          if (d.this.isNew)
          {
            paramAnonymousView.putExtra("key_group_solitatire_create", true);
            if (!com.tencent.mm.plugin.groupsolitaire.b.b.aT(d.this.mContext, d.this.content))
            {
              d.this.ygI.header = (d.this.mContext.getString(2131761473) + "\n" + d.this.ygI.header);
              d.this.ygI.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.ygI);
            }
          }
        }
        for (;;)
        {
          paramAnonymousView.putExtra("key_group_solitatire_scene", 3);
          break;
          paramAnonymousView.putExtra("key_group_solitatire_create", false);
          d.this.ygI = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.ygI, d.this.ygN, (com.tencent.mm.plugin.groupsolitaire.c.a)((Pair)localObject).second);
          continue;
          if (!com.tencent.mm.plugin.groupsolitaire.b.b.aT(d.this.mContext, d.this.content))
          {
            d.this.ygI.header = (d.this.mContext.getString(2131761473) + "\n" + d.this.ygI.header);
            d.this.ygI.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.ygI);
          }
          paramAnonymousView.putExtra("key_group_solitatire_create", true);
        }
      }
    });
    this.ygD = new p(this.mContentView, com.tencent.mm.cb.a.aH(this.mContext, 2131167054), com.tencent.mm.cb.a.aH(this.mContext, 2131167053), true);
    this.ygD.setBackgroundDrawable(new ColorDrawable(0));
    this.ygD.setOutsideTouchable(false);
    this.ygD.setFocusable(false);
    this.ygD.setAnimationStyle(2131821257);
    this.mPa = ((TextView)this.mContentView.findViewById(2131308279));
    this.mPa.setTextSize(0, com.tencent.mm.cb.a.aH(this.mContext, 2131165482));
    ((TextView)this.mContentView.findViewById(2131308276)).setTextSize(0, com.tencent.mm.cb.a.aH(this.mContext, 2131165195));
    this.lastType = 1;
    AppMethodBeat.o(110504);
  }
  
  public final void aBr(String paramString)
  {
    this.ygJ = paramString;
  }
  
  public final void c(com.tencent.mm.plugin.groupsolitaire.c.a parama, String paramString)
  {
    AppMethodBeat.i(178797);
    if (this.ygN == null)
    {
      this.ygN = parama;
      this.ygO = paramString;
      AppMethodBeat.o(178797);
      return;
    }
    if ((this.ygN != null) && (parama == null))
    {
      this.ygN = null;
      this.ygO = "";
      AppMethodBeat.o(178797);
      return;
    }
    Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "setCopyGroupSolitaire repeat");
    AppMethodBeat.o(178797);
  }
  
  public final boolean dYe()
  {
    boolean bool = this.ygG;
    this.ygG = false;
    return bool;
  }
  
  public final void dYf()
  {
    AppMethodBeat.i(110505);
    Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "hideTips()");
    if (this.ygD.isShowing()) {
      this.ygD.dismiss();
    }
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandler.removeMessages(20002);
    AppMethodBeat.o(110505);
  }
  
  public final void j(com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    this.ygI = parama;
  }
  
  public final void reset()
  {
    this.ygH = "";
    this.ygN = null;
    this.ygI = null;
  }
  
  public static class a
    implements Runnable
  {
    protected String content;
    protected MMHandler handler;
    protected Context mContext;
    protected c ygX;
    protected String ygk;
    
    public a(Context paramContext, MMHandler paramMMHandler, c paramc)
    {
      this.mContext = paramContext;
      this.handler = paramMMHandler;
      this.ygX = paramc;
    }
    
    public final void aBs(String paramString)
    {
      this.ygk = paramString;
    }
    
    public void run()
    {
      AppMethodBeat.i(110503);
      try
      {
        Pair localPair = ((PluginGroupSolitaire)g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().ia(this.content, this.ygk);
        if (((Integer)localPair.first).intValue() > com.tencent.mm.plugin.groupsolitaire.b.b.dXN())
        {
          this.handler.sendEmptyMessage(20002);
          AppMethodBeat.o(110503);
          return;
        }
        if ((((Integer)localPair.first).intValue() <= 0) && ((localPair.second == null) || (((com.tencent.mm.plugin.groupsolitaire.c.a)localPair.second).yfG <= 0))) {
          break label219;
        }
        this.ygX.j((com.tencent.mm.plugin.groupsolitaire.c.a)localPair.second);
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
        Log.e("MicroMsg.groupsolitaire.SuggestSolitatireTips", "CheckRunnable run() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        AppMethodBeat.o(110503);
        return;
      }
      this.handler.sendEmptyMessage(20002);
      AppMethodBeat.o(110503);
      return;
      label219:
      if (com.tencent.mm.plugin.groupsolitaire.b.b.aS(this.mContext, this.content))
      {
        this.ygX.j(null);
        Message localMessage1 = new Message();
        localMessage1.what = 20001;
        localMessage1.arg1 = 1;
        this.ygX.aBr(this.content.trim());
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
    public b(Context paramContext, MMHandler paramMMHandler, c paramc)
    {
      super(paramMMHandler, paramc);
    }
    
    public final void run()
    {
      AppMethodBeat.i(178796);
      try
      {
        Pair localPair = ((PluginGroupSolitaire)g.ah(PluginGroupSolitaire.class)).getGroupSolitatireManager().ia(this.content, this.ygk);
        int i = ((Integer)localPair.first).intValue();
        int j = com.tencent.mm.plugin.groupsolitaire.b.b.dXN();
        if (i > j)
        {
          AppMethodBeat.o(178796);
          return;
        }
        if (((Integer)localPair.first).intValue() > 0) {
          this.ygX.c((com.tencent.mm.plugin.groupsolitaire.c.a)localPair.second, this.content);
        }
        AppMethodBeat.o(178796);
        return;
      }
      catch (Exception localException)
      {
        Log.e("MicroMsg.groupsolitaire.SuggestSolitatireTips", "CheckRunnable run() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        AppMethodBeat.o(178796);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract int dYg();
    
    public abstract boolean dYh();
  }
  
  public static abstract interface d
  {
    public abstract void aBt(String paramString);
    
    public abstract void dYi();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.d
 * JD-Core Version:    0.7.0.1
 */
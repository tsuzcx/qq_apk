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
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.groupsolitaire.PluginGroupSolitaire;
import com.tencent.mm.plugin.groupsolitaire.b.c;
import com.tencent.mm.plugin.groupsolitaire.b.e;
import com.tencent.mm.plugin.groupsolitaire.b.f;
import com.tencent.mm.plugin.groupsolitaire.b.g;
import com.tencent.mm.plugin.groupsolitaire.b.h;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.v;
import java.util.HashMap;

public final class d
  implements c
{
  public String JjU;
  public b JkA;
  public c JkB;
  public View JkC;
  c.b Jkm;
  public v Jkn;
  public View Jko;
  d Jkp;
  boolean Jkq;
  public String Jkr;
  com.tencent.mm.plugin.groupsolitaire.c.a Jks;
  String Jkt;
  int Jku;
  int Jkv;
  int Jkw;
  public com.tencent.mm.plugin.groupsolitaire.c.a Jkx;
  private String Jky;
  public a Jkz;
  ValueAnimator animator;
  int[] bfh;
  public String content;
  boolean isNew;
  private int lastType;
  private View mContentView;
  Context mContext;
  MMHandler mHandler;
  TextView sUt;
  
  public d(Context paramContext, c.b paramb, d paramd)
  {
    AppMethodBeat.i(110504);
    this.animator = null;
    this.Jkq = false;
    this.Jkr = "";
    this.JjU = "";
    this.Jks = null;
    this.Jkt = "";
    this.Jkx = null;
    this.Jky = "";
    this.JkB = null;
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
          if ((!((l)h.ax(l.class)).aHL(locald.JjU)) || (Util.isNullOrNil(locald.content)) || (locald.JkC == null))
          {
            Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "showTips() show close");
            AppMethodBeat.o(110497);
            return;
          }
          locald.mHandler.removeMessages(20001);
          locald.isNew = false;
          if (i == 1)
          {
            locald.sUt.setText(b.g.JiG);
            locald.isNew = true;
          }
          while (locald.Jkn.isShowing())
          {
            Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "showTips() mBubbleState isShowing");
            AppMethodBeat.o(110497);
            return;
            locald.isNew = com.tencent.mm.plugin.groupsolitaire.b.b.af(locald.JjU, str, locald.Jks.Jjo.size());
            if (locald.isNew)
            {
              locald.sUt.setText(b.g.JiG);
              if (com.tencent.mm.plugin.groupsolitaire.b.b.aHO(locald.Jks.header))
              {
                if (locald.Jkn.isShowing()) {
                  locald.fJF();
                }
                AppMethodBeat.o(110497);
              }
            }
            else
            {
              locald.sUt.setText(b.g.JiF);
            }
          }
          if (locald.isNew) {
            if (i == 1)
            {
              ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
              com.tencent.mm.plugin.groupsolitaire.b.d.fE(locald.JjU, 3);
            }
          }
          for (;;)
          {
            if (locald.Jko != null)
            {
              locald.bfh = new int[2];
              locald.Jko.getLocationInWindow(locald.bfh);
              locald.Jkw = 0;
              locald.Jku = (locald.Jko.getWidth() - locald.Jkn.getWidth() - com.tencent.mm.cd.a.fromDPToPix(locald.mContext, 8));
              locald.Jkv = (locald.bfh[1] - locald.Jkn.getHeight() - com.tencent.mm.cd.a.fromDPToPix(locald.mContext, 8));
              if ((locald.JkB != null) && (!locald.JkB.fJH())) {
                locald.Jkv += locald.JkB.fJG();
              }
              locald.Jkn.showAtLocation(locald.Jko, 0, locald.Jku, locald.Jkv);
              locald.Jko.getViewTreeObserver().addOnGlobalLayoutListener(new d.3(locald));
            }
            AppMethodBeat.o(110497);
            return;
            ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            com.tencent.mm.plugin.groupsolitaire.b.d.fE(locald.JjU, 2);
            continue;
            ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            com.tencent.mm.plugin.groupsolitaire.b.d.fE(locald.JjU, 1);
          }
          d.this.fJF();
        }
      }
    };
    this.isNew = false;
    Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "SuggestSolitatireTips()");
    this.mContext = paramContext;
    this.Jkm = paramb;
    this.Jkp = paramd;
    this.Jkz = new a(this.mContext, this.mHandler, this);
    this.JkA = new b(this.mContext, this.mHandler, this);
    this.Jkt = this.mContext.getString(b.g.gJg);
    this.mContentView = View.inflate(this.mContext, b.f.Jip, null);
    this.mContentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110499);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/groupsolitaire/ui/SuggestSolitatireTips$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
        Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "click Tips");
        if ((d.this.Jks == null) && (!com.tencent.mm.plugin.groupsolitaire.b.b.bc(d.this.mContext, d.this.content)))
        {
          Log.e("MicroMsg.groupsolitaire.SuggestSolitatireTips", "why here???");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/SuggestSolitatireTips$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(110499);
          return;
        }
        paramAnonymousView = new Intent();
        if (d.this.Jks == null)
        {
          d.this.Jks = new com.tencent.mm.plugin.groupsolitaire.c.a();
          d.this.Jks.header = (d.this.Jkt + "\n");
          d.this.Jks.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.Jks);
          d.this.Jks.dIC = ".";
          d.this.Jks.Jjq = 1;
          paramAnonymousView.putExtra("key_group_solitatire_create", true);
          paramAnonymousView.putExtra("key_group_solitatire_scene", 4);
          paramAnonymousView.putExtra("key_group_solitatire_key", d.this.Jks.field_key);
          paramAnonymousView.putExtra("key_group_solitatire_chatroom_username", d.this.JjU);
          com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.JjU, d.this.Jks);
          ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireManager().c(d.this.JjU, d.this.Jks);
          com.tencent.mm.br.c.a(d.this.Jkm, "groupsolitaire", ".ui.GroupSolitatireEditUI", paramAnonymousView, 3001, new c.a()
          {
            public final void onActivityResult(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
            {
              AppMethodBeat.i(110498);
              if (paramAnonymous2Int1 == 3001)
              {
                Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "dealWithRequestCode() REQUEST_CODE_VIEW_GROUP_SOLITATIRE resultCode:%s", new Object[] { Integer.valueOf(paramAnonymous2Int2) });
                if ((-1 == paramAnonymous2Int2) && (d.this.Jkp != null))
                {
                  d.this.Jkp.fJI();
                  d.this.reset();
                  if (paramAnonymous2Intent != null) {
                    d.this.Jkp.aHY(paramAnonymous2Intent.getStringExtra("key_group_solitatire_content"));
                  }
                  d.this.Jkq = true;
                }
              }
              AppMethodBeat.o(110498);
            }
          });
          d.this.fJF();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/SuggestSolitatireTips$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(110499);
          return;
        }
        d.this.Jks.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.Jks);
        localObject = com.tencent.mm.plugin.groupsolitaire.b.b.jm(d.this.JjU, d.this.Jks.field_key);
        if (((Boolean)((Pair)localObject).first).booleanValue()) {
          if (d.this.isNew)
          {
            paramAnonymousView.putExtra("key_group_solitatire_create", true);
            if (!com.tencent.mm.plugin.groupsolitaire.b.b.bd(d.this.mContext, d.this.content))
            {
              d.this.Jks.header = (d.this.mContext.getString(b.g.gJg) + "\n" + d.this.Jks.header);
              d.this.Jks.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.Jks);
            }
          }
        }
        for (;;)
        {
          paramAnonymousView.putExtra("key_group_solitatire_scene", 3);
          break;
          paramAnonymousView.putExtra("key_group_solitatire_create", false);
          d.this.Jks = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.Jks, d.this.Jkx, (com.tencent.mm.plugin.groupsolitaire.c.a)((Pair)localObject).second);
          continue;
          if (!com.tencent.mm.plugin.groupsolitaire.b.b.bd(d.this.mContext, d.this.content))
          {
            d.this.Jks.header = (d.this.mContext.getString(b.g.gJg) + "\n" + d.this.Jks.header);
            d.this.Jks.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.Jks);
          }
          paramAnonymousView.putExtra("key_group_solitatire_create", true);
        }
      }
    });
    this.Jkn = new v(this.mContentView, com.tencent.mm.cd.a.bs(this.mContext, b.c.JhQ), com.tencent.mm.cd.a.bs(this.mContext, b.c.JhP), true);
    this.Jkn.setBackgroundDrawable(new ColorDrawable(0));
    this.Jkn.setOutsideTouchable(false);
    this.Jkn.setFocusable(false);
    this.Jkn.setAnimationStyle(b.h.PopRightBottomAnimation);
    this.sUt = ((TextView)this.mContentView.findViewById(b.e.Jik));
    this.sUt.setTextSize(0, com.tencent.mm.cd.a.bs(this.mContext, b.c.HintTextSize));
    ((TextView)this.mContentView.findViewById(b.e.Jij)).setTextSize(0, com.tencent.mm.cd.a.bs(this.mContext, b.c.BigTextSize));
    this.lastType = 1;
    AppMethodBeat.o(110504);
  }
  
  public final void aHW(String paramString)
  {
    this.Jkt = paramString;
  }
  
  public final void c(com.tencent.mm.plugin.groupsolitaire.c.a parama, String paramString)
  {
    AppMethodBeat.i(178797);
    if (this.Jkx == null)
    {
      this.Jkx = parama;
      this.Jky = paramString;
      AppMethodBeat.o(178797);
      return;
    }
    if ((this.Jkx != null) && (parama == null))
    {
      this.Jkx = null;
      this.Jky = "";
      AppMethodBeat.o(178797);
      return;
    }
    Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "setCopyGroupSolitaire repeat");
    AppMethodBeat.o(178797);
  }
  
  public final boolean fJE()
  {
    boolean bool = this.Jkq;
    this.Jkq = false;
    return bool;
  }
  
  public final void fJF()
  {
    AppMethodBeat.i(110505);
    Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "hideTips()");
    if (this.Jkn.isShowing()) {
      this.Jkn.dismiss();
    }
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandler.removeMessages(20002);
    AppMethodBeat.o(110505);
  }
  
  public final void j(com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    this.Jks = parama;
  }
  
  public final void reset()
  {
    this.Jkr = "";
    this.Jkx = null;
    this.Jks = null;
  }
  
  public static class a
    implements Runnable
  {
    protected String JjU;
    protected c JkH;
    protected String content;
    protected MMHandler handler;
    protected Context mContext;
    
    public a(Context paramContext, MMHandler paramMMHandler, c paramc)
    {
      this.mContext = paramContext;
      this.handler = paramMMHandler;
      this.JkH = paramc;
    }
    
    public final void aHX(String paramString)
    {
      this.JjU = paramString;
    }
    
    public void run()
    {
      AppMethodBeat.i(110503);
      try
      {
        Pair localPair = ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireManager().jq(this.content, this.JjU);
        if (((Integer)localPair.first).intValue() > com.tencent.mm.plugin.groupsolitaire.b.b.fJn())
        {
          this.handler.sendEmptyMessage(20002);
          AppMethodBeat.o(110503);
          return;
        }
        if ((((Integer)localPair.first).intValue() <= 0) && ((localPair.second == null) || (((com.tencent.mm.plugin.groupsolitaire.c.a)localPair.second).Jjq <= 0))) {
          break label219;
        }
        this.JkH.j((com.tencent.mm.plugin.groupsolitaire.c.a)localPair.second);
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
      if (com.tencent.mm.plugin.groupsolitaire.b.b.bc(this.mContext, this.content))
      {
        this.JkH.j(null);
        Message localMessage1 = new Message();
        localMessage1.what = 20001;
        localMessage1.arg1 = 1;
        this.JkH.aHW(this.content.trim());
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
        Pair localPair = ((PluginGroupSolitaire)h.az(PluginGroupSolitaire.class)).getGroupSolitatireManager().jq(this.content, this.JjU);
        int i = ((Integer)localPair.first).intValue();
        int j = com.tencent.mm.plugin.groupsolitaire.b.b.fJn();
        if (i > j)
        {
          AppMethodBeat.o(178796);
          return;
        }
        if (((Integer)localPair.first).intValue() > 0) {
          this.JkH.c((com.tencent.mm.plugin.groupsolitaire.c.a)localPair.second, this.content);
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
    public abstract int fJG();
    
    public abstract boolean fJH();
  }
  
  public static abstract interface d
  {
    public abstract void aHY(String paramString);
    
    public abstract void fJI();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.d
 * JD-Core Version:    0.7.0.1
 */
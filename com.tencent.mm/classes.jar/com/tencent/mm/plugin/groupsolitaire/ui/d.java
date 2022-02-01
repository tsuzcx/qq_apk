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
import com.tencent.mm.by.c.a;
import com.tencent.mm.by.c.b;
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
import com.tencent.mm.ui.base.r;
import java.util.HashMap;

public final class d
  implements c
{
  int[] BdE;
  c.b DqE;
  public r DqF;
  public View DqG;
  d DqH;
  boolean DqI;
  public String DqJ;
  com.tencent.mm.plugin.groupsolitaire.c.a DqK;
  String DqL;
  int DqM;
  int DqN;
  int DqO;
  public com.tencent.mm.plugin.groupsolitaire.c.a DqP;
  private String DqQ;
  public a DqR;
  public b DqS;
  public c DqT;
  public View DqU;
  public String Dqm;
  ValueAnimator animator;
  public String content;
  boolean isNew;
  private int lastType;
  private View mContentView;
  Context mContext;
  MMHandler mHandler;
  TextView pPT;
  
  public d(Context paramContext, c.b paramb, d paramd)
  {
    AppMethodBeat.i(110504);
    this.animator = null;
    this.DqI = false;
    this.DqJ = "";
    this.Dqm = "";
    this.DqK = null;
    this.DqL = "";
    this.DqP = null;
    this.DqQ = "";
    this.DqT = null;
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
          if ((!((l)h.ae(l.class)).aKU(locald.Dqm)) || (Util.isNullOrNil(locald.content)) || (locald.DqU == null))
          {
            Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "showTips() show close");
            AppMethodBeat.o(110497);
            return;
          }
          locald.mHandler.removeMessages(20001);
          locald.isNew = false;
          if (i == 1)
          {
            locald.pPT.setText(b.g.DoX);
            locald.isNew = true;
          }
          while (locald.DqF.isShowing())
          {
            Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "showTips() mBubbleState isShowing");
            AppMethodBeat.o(110497);
            return;
            locald.isNew = com.tencent.mm.plugin.groupsolitaire.b.b.Y(locald.Dqm, str, locald.DqK.DpG.size());
            if (locald.isNew)
            {
              locald.pPT.setText(b.g.DoX);
              if (com.tencent.mm.plugin.groupsolitaire.b.b.aKX(locald.DqK.header))
              {
                if (locald.DqF.isShowing()) {
                  locald.eBD();
                }
                AppMethodBeat.o(110497);
              }
            }
            else
            {
              locald.pPT.setText(b.g.DoW);
            }
          }
          if (locald.isNew) {
            if (i == 1)
            {
              ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
              com.tencent.mm.plugin.groupsolitaire.b.d.eM(locald.Dqm, 3);
            }
          }
          for (;;)
          {
            if (locald.DqG != null)
            {
              locald.BdE = new int[2];
              locald.DqG.getLocationInWindow(locald.BdE);
              locald.DqO = 0;
              locald.DqM = (locald.DqG.getWidth() - locald.DqF.getWidth() - com.tencent.mm.ci.a.fromDPToPix(locald.mContext, 8));
              locald.DqN = (locald.BdE[1] - locald.DqF.getHeight() - com.tencent.mm.ci.a.fromDPToPix(locald.mContext, 8));
              if ((locald.DqT != null) && (!locald.DqT.eBF())) {
                locald.DqN += locald.DqT.eBE();
              }
              locald.DqF.showAtLocation(locald.DqG, 0, locald.DqM, locald.DqN);
              locald.DqG.getViewTreeObserver().addOnGlobalLayoutListener(new d.3(locald));
            }
            AppMethodBeat.o(110497);
            return;
            ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            com.tencent.mm.plugin.groupsolitaire.b.d.eM(locald.Dqm, 2);
            continue;
            ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            com.tencent.mm.plugin.groupsolitaire.b.d.eM(locald.Dqm, 1);
          }
          d.this.eBD();
        }
      }
    };
    this.isNew = false;
    Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "SuggestSolitatireTips()");
    this.mContext = paramContext;
    this.DqE = paramb;
    this.DqH = paramd;
    this.DqR = new a(this.mContext, this.mHandler, this);
    this.DqS = new b(this.mContext, this.mHandler, this);
    this.DqL = this.mContext.getString(b.g.eGl);
    this.mContentView = View.inflate(this.mContext, b.f.DoG, null);
    this.mContentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110499);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/groupsolitaire/ui/SuggestSolitatireTips$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
        Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "click Tips");
        if ((d.this.DqK == null) && (!com.tencent.mm.plugin.groupsolitaire.b.b.ba(d.this.mContext, d.this.content)))
        {
          Log.e("MicroMsg.groupsolitaire.SuggestSolitatireTips", "why here???");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/SuggestSolitatireTips$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(110499);
          return;
        }
        paramAnonymousView = new Intent();
        if (d.this.DqK == null)
        {
          d.this.DqK = new com.tencent.mm.plugin.groupsolitaire.c.a();
          d.this.DqK.header = (d.this.DqL + "\n");
          d.this.DqK.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.DqK);
          d.this.DqK.bOX = ".";
          d.this.DqK.DpI = 1;
          paramAnonymousView.putExtra("key_group_solitatire_create", true);
          paramAnonymousView.putExtra("key_group_solitatire_scene", 4);
          paramAnonymousView.putExtra("key_group_solitatire_key", d.this.DqK.field_key);
          paramAnonymousView.putExtra("key_group_solitatire_chatroom_username", d.this.Dqm);
          com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.Dqm, d.this.DqK);
          ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireManager().c(d.this.Dqm, d.this.DqK);
          com.tencent.mm.by.c.a(d.this.DqE, "groupsolitaire", ".ui.GroupSolitatireEditUI", paramAnonymousView, 3001, new c.a()
          {
            public final void onActivityResult(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
            {
              AppMethodBeat.i(110498);
              if (paramAnonymous2Int1 == 3001)
              {
                Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "dealWithRequestCode() REQUEST_CODE_VIEW_GROUP_SOLITATIRE resultCode:%s", new Object[] { Integer.valueOf(paramAnonymous2Int2) });
                if ((-1 == paramAnonymous2Int2) && (d.this.DqH != null))
                {
                  d.this.DqH.eBG();
                  d.this.reset();
                  if (paramAnonymous2Intent != null) {
                    d.this.DqH.aLh(paramAnonymous2Intent.getStringExtra("key_group_solitatire_content"));
                  }
                  d.this.DqI = true;
                }
              }
              AppMethodBeat.o(110498);
            }
          });
          d.this.eBD();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/SuggestSolitatireTips$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(110499);
          return;
        }
        d.this.DqK.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.DqK);
        localObject = com.tencent.mm.plugin.groupsolitaire.b.b.jdMethod_if(d.this.Dqm, d.this.DqK.field_key);
        if (((Boolean)((Pair)localObject).first).booleanValue()) {
          if (d.this.isNew)
          {
            paramAnonymousView.putExtra("key_group_solitatire_create", true);
            if (!com.tencent.mm.plugin.groupsolitaire.b.b.bb(d.this.mContext, d.this.content))
            {
              d.this.DqK.header = (d.this.mContext.getString(b.g.eGl) + "\n" + d.this.DqK.header);
              d.this.DqK.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.DqK);
            }
          }
        }
        for (;;)
        {
          paramAnonymousView.putExtra("key_group_solitatire_scene", 3);
          break;
          paramAnonymousView.putExtra("key_group_solitatire_create", false);
          d.this.DqK = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.DqK, d.this.DqP, (com.tencent.mm.plugin.groupsolitaire.c.a)((Pair)localObject).second);
          continue;
          if (!com.tencent.mm.plugin.groupsolitaire.b.b.bb(d.this.mContext, d.this.content))
          {
            d.this.DqK.header = (d.this.mContext.getString(b.g.eGl) + "\n" + d.this.DqK.header);
            d.this.DqK.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.DqK);
          }
          paramAnonymousView.putExtra("key_group_solitatire_create", true);
        }
      }
    });
    this.DqF = new r(this.mContentView, com.tencent.mm.ci.a.aZ(this.mContext, b.c.Doh), com.tencent.mm.ci.a.aZ(this.mContext, b.c.Dog), true);
    this.DqF.setBackgroundDrawable(new ColorDrawable(0));
    this.DqF.setOutsideTouchable(false);
    this.DqF.setFocusable(false);
    this.DqF.setAnimationStyle(b.h.PopRightBottomAnimation);
    this.pPT = ((TextView)this.mContentView.findViewById(b.e.DoB));
    this.pPT.setTextSize(0, com.tencent.mm.ci.a.aZ(this.mContext, b.c.HintTextSize));
    ((TextView)this.mContentView.findViewById(b.e.DoA)).setTextSize(0, com.tencent.mm.ci.a.aZ(this.mContext, b.c.BigTextSize));
    this.lastType = 1;
    AppMethodBeat.o(110504);
  }
  
  public final void aLf(String paramString)
  {
    this.DqL = paramString;
  }
  
  public final void c(com.tencent.mm.plugin.groupsolitaire.c.a parama, String paramString)
  {
    AppMethodBeat.i(178797);
    if (this.DqP == null)
    {
      this.DqP = parama;
      this.DqQ = paramString;
      AppMethodBeat.o(178797);
      return;
    }
    if ((this.DqP != null) && (parama == null))
    {
      this.DqP = null;
      this.DqQ = "";
      AppMethodBeat.o(178797);
      return;
    }
    Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "setCopyGroupSolitaire repeat");
    AppMethodBeat.o(178797);
  }
  
  public final boolean eBC()
  {
    boolean bool = this.DqI;
    this.DqI = false;
    return bool;
  }
  
  public final void eBD()
  {
    AppMethodBeat.i(110505);
    Log.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "hideTips()");
    if (this.DqF.isShowing()) {
      this.DqF.dismiss();
    }
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandler.removeMessages(20002);
    AppMethodBeat.o(110505);
  }
  
  public final void j(com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    this.DqK = parama;
  }
  
  public final void reset()
  {
    this.DqJ = "";
    this.DqP = null;
    this.DqK = null;
  }
  
  public static class a
    implements Runnable
  {
    protected c DqZ;
    protected String Dqm;
    protected String content;
    protected MMHandler handler;
    protected Context mContext;
    
    public a(Context paramContext, MMHandler paramMMHandler, c paramc)
    {
      this.mContext = paramContext;
      this.handler = paramMMHandler;
      this.DqZ = paramc;
    }
    
    public final void aLg(String paramString)
    {
      this.Dqm = paramString;
    }
    
    public void run()
    {
      AppMethodBeat.i(110503);
      try
      {
        Pair localPair = ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireManager().ij(this.content, this.Dqm);
        if (((Integer)localPair.first).intValue() > com.tencent.mm.plugin.groupsolitaire.b.b.eBl())
        {
          this.handler.sendEmptyMessage(20002);
          AppMethodBeat.o(110503);
          return;
        }
        if ((((Integer)localPair.first).intValue() <= 0) && ((localPair.second == null) || (((com.tencent.mm.plugin.groupsolitaire.c.a)localPair.second).DpI <= 0))) {
          break label219;
        }
        this.DqZ.j((com.tencent.mm.plugin.groupsolitaire.c.a)localPair.second);
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
      if (com.tencent.mm.plugin.groupsolitaire.b.b.ba(this.mContext, this.content))
      {
        this.DqZ.j(null);
        Message localMessage1 = new Message();
        localMessage1.what = 20001;
        localMessage1.arg1 = 1;
        this.DqZ.aLf(this.content.trim());
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
        Pair localPair = ((PluginGroupSolitaire)h.ag(PluginGroupSolitaire.class)).getGroupSolitatireManager().ij(this.content, this.Dqm);
        int i = ((Integer)localPair.first).intValue();
        int j = com.tencent.mm.plugin.groupsolitaire.b.b.eBl();
        if (i > j)
        {
          AppMethodBeat.o(178796);
          return;
        }
        if (((Integer)localPair.first).intValue() > 0) {
          this.DqZ.c((com.tencent.mm.plugin.groupsolitaire.c.a)localPair.second, this.content);
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
    public abstract int eBE();
    
    public abstract boolean eBF();
  }
  
  public static abstract interface d
  {
    public abstract void aLh(String paramString);
    
    public abstract void eBG();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.d
 * JD-Core Version:    0.7.0.1
 */
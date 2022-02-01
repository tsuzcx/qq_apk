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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.o;
import java.util.HashMap;

public final class d
  implements c
{
  ValueAnimator animator;
  public String content;
  boolean isNew;
  TextView lHk;
  private int lastType;
  private View mContentView;
  Context mContext;
  aq mHandler;
  public String uNM;
  com.tencent.mm.br.d.b uOf;
  public o uOg;
  public View uOh;
  d uOi;
  boolean uOj;
  public String uOk;
  com.tencent.mm.plugin.groupsolitaire.c.a uOl;
  String uOm;
  int uOn;
  int uOo;
  int uOp;
  int[] uOq;
  public com.tencent.mm.plugin.groupsolitaire.c.a uOr;
  private String uOs;
  public a uOt;
  public b uOu;
  public c uOv;
  public View uOw;
  
  public d(Context paramContext, com.tencent.mm.br.d.b paramb, d paramd)
  {
    AppMethodBeat.i(110504);
    this.animator = null;
    this.uOj = false;
    this.uOk = "";
    this.uNM = "";
    this.uOl = null;
    this.uOm = "";
    this.uOr = null;
    this.uOs = "";
    this.uOv = null;
    this.mHandler = new aq()
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
          ae.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "showTips()");
          if ((!((j)g.ab(j.class)).anN(locald.uNM)) || (bu.isNullOrNil(locald.content)) || (locald.uOw == null))
          {
            ae.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "showTips() show close");
            AppMethodBeat.o(110497);
            return;
          }
          locald.mHandler.removeMessages(20001);
          locald.isNew = false;
          if (i == 1)
          {
            locald.lHk.setText(2131760114);
            locald.isNew = true;
          }
          while (locald.uOg.isShowing())
          {
            ae.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "showTips() mBubbleState isShowing");
            AppMethodBeat.o(110497);
            return;
            locald.isNew = com.tencent.mm.plugin.groupsolitaire.b.b.T(locald.uNM, str, locald.uOl.uNg.size());
            if (locald.isNew)
            {
              locald.lHk.setText(2131760114);
              if (com.tencent.mm.plugin.groupsolitaire.b.b.anQ(locald.uOl.header))
              {
                if (locald.uOg.isShowing()) {
                  locald.dev();
                }
                AppMethodBeat.o(110497);
              }
            }
            else
            {
              locald.lHk.setText(2131760113);
            }
          }
          if (locald.isNew) {
            if (i == 1)
            {
              ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
              com.tencent.mm.plugin.groupsolitaire.b.d.dY(locald.uNM, 3);
            }
          }
          for (;;)
          {
            if (locald.uOh != null)
            {
              locald.uOq = new int[2];
              locald.uOh.getLocationInWindow(locald.uOq);
              locald.uOp = 0;
              locald.uOn = (locald.uOh.getWidth() - locald.uOg.getWidth() - com.tencent.mm.cb.a.fromDPToPix(locald.mContext, 8));
              locald.uOo = (locald.uOq[1] - locald.uOg.getHeight() - com.tencent.mm.cb.a.fromDPToPix(locald.mContext, 8));
              if ((locald.uOv != null) && (!locald.uOv.dex())) {
                locald.uOo += locald.uOv.dew();
              }
              locald.uOg.showAtLocation(locald.uOh, 0, locald.uOn, locald.uOo);
              locald.uOh.getViewTreeObserver().addOnGlobalLayoutListener(new d.3(locald));
            }
            AppMethodBeat.o(110497);
            return;
            ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            com.tencent.mm.plugin.groupsolitaire.b.d.dY(locald.uNM, 2);
            continue;
            ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireReportManager();
            com.tencent.mm.plugin.groupsolitaire.b.d.dY(locald.uNM, 1);
          }
          d.this.dev();
        }
      }
    };
    this.isNew = false;
    ae.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "SuggestSolitatireTips()");
    this.mContext = paramContext;
    this.uOf = paramb;
    this.uOi = paramd;
    this.uOt = new a(this.mContext, this.mHandler, this);
    this.uOu = new b(this.mContext, this.mHandler, this);
    this.uOm = this.mContext.getString(2131760093);
    this.mContentView = View.inflate(this.mContext, 2131495733, null);
    this.mContentView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110499);
        Object localObject = new com.tencent.mm.hellhoundlib.b.b();
        ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/groupsolitaire/ui/SuggestSolitatireTips$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
        ae.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "click Tips");
        if ((d.this.uOl == null) && (!com.tencent.mm.plugin.groupsolitaire.b.b.aF(d.this.mContext, d.this.content)))
        {
          ae.e("MicroMsg.groupsolitaire.SuggestSolitatireTips", "why here???");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/SuggestSolitatireTips$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(110499);
          return;
        }
        paramAnonymousView = new Intent();
        if (d.this.uOl == null)
        {
          d.this.uOl = new com.tencent.mm.plugin.groupsolitaire.c.a();
          d.this.uOl.header = (d.this.uOm + "\n");
          d.this.uOl.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.uOl);
          d.this.uOl.separator = ".";
          d.this.uOl.uNi = 1;
          paramAnonymousView.putExtra("key_group_solitatire_create", true);
          paramAnonymousView.putExtra("key_group_solitatire_scene", 4);
          paramAnonymousView.putExtra("key_group_solitatire_key", d.this.uOl.field_key);
          paramAnonymousView.putExtra("key_group_solitatire_chatroom_username", d.this.uNM);
          com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.uNM, d.this.uOl);
          ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().c(d.this.uNM, d.this.uOl);
          com.tencent.mm.br.d.a(d.this.uOf, "groupsolitaire", ".ui.GroupSolitatireEditUI", paramAnonymousView, 3001, new com.tencent.mm.br.d.a()
          {
            public final void onActivityResult(int paramAnonymous2Int1, int paramAnonymous2Int2, Intent paramAnonymous2Intent)
            {
              AppMethodBeat.i(110498);
              if (paramAnonymous2Int1 == 3001)
              {
                ae.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "dealWithRequestCode() REQUEST_CODE_VIEW_GROUP_SOLITATIRE resultCode:%s", new Object[] { Integer.valueOf(paramAnonymous2Int2) });
                if ((-1 == paramAnonymous2Int2) && (d.this.uOi != null))
                {
                  d.this.uOi.dey();
                  d.this.reset();
                  if (paramAnonymous2Intent != null) {
                    d.this.uOi.aoa(paramAnonymous2Intent.getStringExtra("key_group_solitatire_content"));
                  }
                  d.this.uOj = true;
                }
              }
              AppMethodBeat.o(110498);
            }
          });
          d.this.dev();
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/groupsolitaire/ui/SuggestSolitatireTips$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(110499);
          return;
        }
        d.this.uOl.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.uOl);
        localObject = com.tencent.mm.plugin.groupsolitaire.b.b.hp(d.this.uNM, d.this.uOl.field_key);
        if (((Boolean)((Pair)localObject).first).booleanValue()) {
          if (d.this.isNew)
          {
            paramAnonymousView.putExtra("key_group_solitatire_create", true);
            if (!com.tencent.mm.plugin.groupsolitaire.b.b.aG(d.this.mContext, d.this.content))
            {
              d.this.uOl.header = (d.this.mContext.getString(2131760093) + "\n" + d.this.uOl.header);
              d.this.uOl.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.uOl);
            }
          }
        }
        for (;;)
        {
          paramAnonymousView.putExtra("key_group_solitatire_scene", 3);
          break;
          paramAnonymousView.putExtra("key_group_solitatire_create", false);
          d.this.uOl = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.uOl, d.this.uOr, (com.tencent.mm.plugin.groupsolitaire.c.a)((Pair)localObject).second);
          continue;
          if (!com.tencent.mm.plugin.groupsolitaire.b.b.aG(d.this.mContext, d.this.content))
          {
            d.this.uOl.header = (d.this.mContext.getString(2131760093) + "\n" + d.this.uOl.header);
            d.this.uOl.field_key = com.tencent.mm.plugin.groupsolitaire.b.b.a(d.this.uOl);
          }
          paramAnonymousView.putExtra("key_group_solitatire_create", true);
        }
      }
    });
    this.uOg = new o(this.mContentView, com.tencent.mm.cb.a.ay(this.mContext, 2131166919), com.tencent.mm.cb.a.ay(this.mContext, 2131166918), true);
    this.uOg.setBackgroundDrawable(new ColorDrawable(0));
    this.uOg.setOutsideTouchable(false);
    this.uOg.setFocusable(false);
    this.uOg.setAnimationStyle(2131821219);
    this.lHk = ((TextView)this.mContentView.findViewById(2131305112));
    this.lHk.setTextSize(0, com.tencent.mm.cb.a.ay(this.mContext, 2131165466));
    ((TextView)this.mContentView.findViewById(2131305109)).setTextSize(0, com.tencent.mm.cb.a.ay(this.mContext, 2131165192));
    this.lastType = 1;
    AppMethodBeat.o(110504);
  }
  
  public final void anY(String paramString)
  {
    this.uOm = paramString;
  }
  
  public final void c(com.tencent.mm.plugin.groupsolitaire.c.a parama, String paramString)
  {
    AppMethodBeat.i(178797);
    if (this.uOr == null)
    {
      this.uOr = parama;
      this.uOs = paramString;
      AppMethodBeat.o(178797);
      return;
    }
    if ((this.uOr != null) && (parama == null))
    {
      this.uOr = null;
      this.uOs = "";
      AppMethodBeat.o(178797);
      return;
    }
    ae.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "setCopyGroupSolitaire repeat");
    AppMethodBeat.o(178797);
  }
  
  public final boolean deu()
  {
    boolean bool = this.uOj;
    this.uOj = false;
    return bool;
  }
  
  public final void dev()
  {
    AppMethodBeat.i(110505);
    ae.i("MicroMsg.groupsolitaire.SuggestSolitatireTips", "hideTips()");
    if (this.uOg.isShowing()) {
      this.uOg.dismiss();
    }
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandler.removeMessages(20002);
    AppMethodBeat.o(110505);
  }
  
  public final void j(com.tencent.mm.plugin.groupsolitaire.c.a parama)
  {
    this.uOl = parama;
  }
  
  public final void reset()
  {
    this.uOk = "";
    this.uOr = null;
    this.uOl = null;
  }
  
  public static class a
    implements Runnable
  {
    protected String content;
    protected aq handler;
    protected Context mContext;
    protected String uNM;
    protected c uOB;
    
    public a(Context paramContext, aq paramaq, c paramc)
    {
      this.mContext = paramContext;
      this.handler = paramaq;
      this.uOB = paramc;
    }
    
    public final void anZ(String paramString)
    {
      this.uNM = paramString;
    }
    
    public void run()
    {
      AppMethodBeat.i(110503);
      try
      {
        Pair localPair = ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().ht(this.content, this.uNM);
        if (((Integer)localPair.first).intValue() > com.tencent.mm.plugin.groupsolitaire.b.b.ded())
        {
          this.handler.sendEmptyMessage(20002);
          AppMethodBeat.o(110503);
          return;
        }
        if ((((Integer)localPair.first).intValue() <= 0) && ((localPair.second == null) || (((com.tencent.mm.plugin.groupsolitaire.c.a)localPair.second).uNi <= 0))) {
          break label219;
        }
        this.uOB.j((com.tencent.mm.plugin.groupsolitaire.c.a)localPair.second);
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
        ae.e("MicroMsg.groupsolitaire.SuggestSolitatireTips", "CheckRunnable run() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        AppMethodBeat.o(110503);
        return;
      }
      this.handler.sendEmptyMessage(20002);
      AppMethodBeat.o(110503);
      return;
      label219:
      if (com.tencent.mm.plugin.groupsolitaire.b.b.aF(this.mContext, this.content))
      {
        this.uOB.j(null);
        Message localMessage1 = new Message();
        localMessage1.what = 20001;
        localMessage1.arg1 = 1;
        this.uOB.anY(this.content.trim());
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
    public b(Context paramContext, aq paramaq, c paramc)
    {
      super(paramaq, paramc);
    }
    
    public final void run()
    {
      AppMethodBeat.i(178796);
      try
      {
        Pair localPair = ((PluginGroupSolitaire)g.ad(PluginGroupSolitaire.class)).getGroupSolitatireManager().ht(this.content, this.uNM);
        int i = ((Integer)localPair.first).intValue();
        int j = com.tencent.mm.plugin.groupsolitaire.b.b.ded();
        if (i > j)
        {
          AppMethodBeat.o(178796);
          return;
        }
        if (((Integer)localPair.first).intValue() > 0) {
          this.uOB.c((com.tencent.mm.plugin.groupsolitaire.c.a)localPair.second, this.content);
        }
        AppMethodBeat.o(178796);
        return;
      }
      catch (Exception localException)
      {
        ae.e("MicroMsg.groupsolitaire.SuggestSolitatireTips", "CheckRunnable run() Exception:%s %s", new Object[] { localException.getClass().getSimpleName(), localException.getMessage() });
        AppMethodBeat.o(178796);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract int dew();
    
    public abstract boolean dex();
  }
  
  public static abstract interface d
  {
    public abstract void aoa(String paramString);
    
    public abstract void dey();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.groupsolitaire.ui.d
 * JD-Core Version:    0.7.0.1
 */
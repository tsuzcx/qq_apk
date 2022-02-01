package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.f.a.my;
import com.tencent.mm.f.a.qc;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
  implements e.d
{
  private static String TAG = "MicroMsg.BakChatBanner";
  private View bvK;
  private MMHandler handler;
  private int percent;
  private int rTR;
  private IListener rUv;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(21960);
    this.rTR = -1;
    this.percent = 0;
    this.bvK = null;
    this.handler = new MMHandler(Looper.getMainLooper());
    if (this.view != null)
    {
      this.bvK = this.view.findViewById(R.h.dsX);
      this.bvK.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21957);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bn(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakChatBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
          a.a(a.this, com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cuk().cul().rTR);
          if ((2 == a.b(a.this)) || (3 == a.b(a.this)) || (5 == a.b(a.this)) || (6 == a.b(a.this)))
          {
            Log.d(a.TAG, "OnClickListener goToBakOperatingUI PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cuk().cul().rTR), Integer.valueOf(a.c(a.this)) });
            a.d(a.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakChatBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21957);
            return;
          }
          if (4 == a.b(a.this))
          {
            Log.d(a.TAG, "OnClickListener goToBakFinishUI PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cuk().cul().rTR), Integer.valueOf(a.c(a.this)) });
            a.e(a.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakChatBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21957);
            return;
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakChatBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(21957);
        }
      });
    }
    ckL();
    this.rUv = new IListener() {};
    EventCenter.instance.addListener(this.rUv);
    AppMethodBeat.o(21960);
  }
  
  private boolean kT(boolean paramBoolean)
  {
    AppMethodBeat.i(21961);
    this.rTR = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cuk().cul().rTR;
    Log.d(TAG, "dealwithPCBakBanner PCBannerStatus:%d, setStrategyCaller:%b", new Object[] { Integer.valueOf(this.rTR), Boolean.valueOf(paramBoolean) });
    if ((this.rTR >= 2) && (this.rTR <= 6))
    {
      this.bvK.setVisibility(0);
      if ((paramBoolean) && (!com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cuk().cul().cus())) {
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cuk().cul().a(this);
      }
      if (2 == this.rTR)
      {
        ((ImageView)this.view.findViewById(R.h.dsY)).setImageResource(R.k.chatting_backup_computer);
        ((TextView)this.view.findViewById(R.h.dsZ)).setText(MMApplicationContext.getContext().getString(R.l.esc, new Object[] { Integer.valueOf(this.percent) }));
      }
      for (;;)
      {
        AppMethodBeat.o(21961);
        return true;
        if (3 == this.rTR)
        {
          ((ImageView)this.view.findViewById(R.h.dsY)).setImageResource(R.k.chatting_backup_computer);
          ((TextView)this.view.findViewById(R.h.dsZ)).setText(MMApplicationContext.getContext().getString(R.l.esf, new Object[] { Integer.valueOf(this.percent) }));
        }
        else if (4 == this.rTR)
        {
          ((TextView)this.view.findViewById(R.h.dsZ)).setText(MMApplicationContext.getContext().getString(R.l.ese));
          ((ImageView)this.view.findViewById(R.h.dsY)).setImageResource(R.k.chatting_backup_comfirm);
        }
        else if (5 == this.rTR)
        {
          ((ImageView)this.view.findViewById(R.h.dsY)).setImageResource(R.k.chatting_backup_computer);
          ((TextView)this.view.findViewById(R.h.dsZ)).setText(MMApplicationContext.getContext().getString(R.l.esb, new Object[] { Integer.valueOf(this.percent) }));
        }
        else if (6 == this.rTR)
        {
          ((TextView)this.view.findViewById(R.h.dsZ)).setText(MMApplicationContext.getContext().getString(R.l.esd));
          ((ImageView)this.view.findViewById(R.h.dsY)).setImageResource(R.k.chatting_backup_comfirm);
        }
      }
    }
    this.bvK.setVisibility(8);
    AppMethodBeat.o(21961);
    return false;
  }
  
  public final void EZ(int paramInt)
  {
    AppMethodBeat.i(21964);
    Log.d(TAG, "onNetProgress PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cuk().cul().rTR), Integer.valueOf(paramInt) });
    this.percent = paramInt;
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21958);
        a.this.ckL();
        AppMethodBeat.o(21958);
      }
    });
    AppMethodBeat.o(21964);
  }
  
  public final void Fa(int paramInt)
  {
    AppMethodBeat.i(21965);
    Log.d(TAG, "onMergeProgress PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cuk().cul().rTR), Integer.valueOf(paramInt) });
    AppMethodBeat.o(21965);
  }
  
  public final boolean ckL()
  {
    AppMethodBeat.i(21962);
    this.percent = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cuk().cul().cuv();
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cuk().cul().a(this);
    boolean bool = kT(true);
    AppMethodBeat.o(21962);
    return bool;
  }
  
  public final void crY() {}
  
  public final void cuy()
  {
    AppMethodBeat.i(21966);
    Log.d(TAG, "onNetFinish PCBannerStatus:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cuk().cul().rTR) });
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cuk().cul();
    e.EW(17);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21959);
        a.this.ckL();
        AppMethodBeat.o(21959);
      }
    });
    AppMethodBeat.o(21966);
  }
  
  public final void cuz() {}
  
  public final void destroy()
  {
    AppMethodBeat.i(21967);
    Log.i(TAG, "destroy");
    release();
    EventCenter.instance.removeListener(this.rUv);
    AppMethodBeat.o(21967);
  }
  
  public final int getLayoutId()
  {
    return R.i.dsX;
  }
  
  public final int getOrder()
  {
    return 3;
  }
  
  public final void kv(int paramInt) {}
  
  public final void release()
  {
    AppMethodBeat.i(21963);
    this.rTR = -1;
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cuk().cul().cut();
    AppMethodBeat.o(21963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a
 * JD-Core Version:    0.7.0.1
 */
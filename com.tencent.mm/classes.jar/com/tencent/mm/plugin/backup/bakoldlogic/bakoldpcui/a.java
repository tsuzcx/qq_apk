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
import com.tencent.mm.app.f;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class a
  extends com.tencent.mm.pluginsdk.ui.a.b
  implements e.d
{
  private static String TAG = "MicroMsg.BakChatBanner";
  private View doN;
  private MMHandler handler;
  private int percent;
  private IListener vfK;
  private int vfh;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(21960);
    this.vfh = -1;
    this.percent = 0;
    this.doN = null;
    this.handler = new MMHandler(Looper.getMainLooper());
    if (this.view != null)
    {
      this.doN = this.view.findViewById(R.h.fto);
      this.doN.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21957);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakChatBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
          a.a(a.this, com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWV().vfh);
          if ((2 == a.b(a.this)) || (3 == a.b(a.this)) || (5 == a.b(a.this)) || (6 == a.b(a.this)))
          {
            Log.d(a.TAG, "OnClickListener goToBakOperatingUI PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWV().vfh), Integer.valueOf(a.c(a.this)) });
            a.d(a.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakChatBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21957);
            return;
          }
          if (4 == a.b(a.this))
          {
            Log.d(a.TAG, "OnClickListener goToBakFinishUI PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWV().vfh), Integer.valueOf(a.c(a.this)) });
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
    cMa();
    this.vfK = new BakChatBanner.1(this, f.hfK);
    this.vfK.alive();
    AppMethodBeat.o(21960);
  }
  
  private boolean mg(boolean paramBoolean)
  {
    AppMethodBeat.i(21961);
    this.vfh = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWV().vfh;
    Log.d(TAG, "dealwithPCBakBanner PCBannerStatus:%d, setStrategyCaller:%b", new Object[] { Integer.valueOf(this.vfh), Boolean.valueOf(paramBoolean) });
    if ((this.vfh >= 2) && (this.vfh <= 6))
    {
      this.doN.setVisibility(0);
      if ((paramBoolean) && (!com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWV().cXc())) {
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWV().a(this);
      }
      if (2 == this.vfh)
      {
        ((ImageView)this.view.findViewById(R.h.ftp)).setImageResource(R.k.chatting_backup_computer);
        ((TextView)this.view.findViewById(R.h.ftq)).setText(MMApplicationContext.getContext().getString(R.l.gvd, new Object[] { Integer.valueOf(this.percent) }));
      }
      for (;;)
      {
        AppMethodBeat.o(21961);
        return true;
        if (3 == this.vfh)
        {
          ((ImageView)this.view.findViewById(R.h.ftp)).setImageResource(R.k.chatting_backup_computer);
          ((TextView)this.view.findViewById(R.h.ftq)).setText(MMApplicationContext.getContext().getString(R.l.gvg, new Object[] { Integer.valueOf(this.percent) }));
        }
        else if (4 == this.vfh)
        {
          ((TextView)this.view.findViewById(R.h.ftq)).setText(MMApplicationContext.getContext().getString(R.l.gvf));
          ((ImageView)this.view.findViewById(R.h.ftp)).setImageResource(R.k.chatting_backup_comfirm);
        }
        else if (5 == this.vfh)
        {
          ((ImageView)this.view.findViewById(R.h.ftp)).setImageResource(R.k.chatting_backup_computer);
          ((TextView)this.view.findViewById(R.h.ftq)).setText(MMApplicationContext.getContext().getString(R.l.gvc, new Object[] { Integer.valueOf(this.percent) }));
        }
        else if (6 == this.vfh)
        {
          ((TextView)this.view.findViewById(R.h.ftq)).setText(MMApplicationContext.getContext().getString(R.l.gve));
          ((ImageView)this.view.findViewById(R.h.ftp)).setImageResource(R.k.chatting_backup_comfirm);
        }
      }
    }
    this.doN.setVisibility(8);
    AppMethodBeat.o(21961);
    return false;
  }
  
  public final void FA(int paramInt)
  {
    AppMethodBeat.i(21964);
    Log.d(TAG, "onNetProgress PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWV().vfh), Integer.valueOf(paramInt) });
    this.percent = paramInt;
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21958);
        a.this.cMa();
        AppMethodBeat.o(21958);
      }
    });
    AppMethodBeat.o(21964);
  }
  
  public final void FB(int paramInt)
  {
    AppMethodBeat.i(21965);
    Log.d(TAG, "onMergeProgress PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWV().vfh), Integer.valueOf(paramInt) });
    AppMethodBeat.o(21965);
  }
  
  public final boolean cMa()
  {
    AppMethodBeat.i(21962);
    this.percent = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWV().cXf();
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWV().a(this);
    boolean bool = mg(true);
    AppMethodBeat.o(21962);
    return bool;
  }
  
  public final void cUI() {}
  
  public final void cXi()
  {
    AppMethodBeat.i(21966);
    Log.d(TAG, "onNetFinish PCBannerStatus:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWV().vfh) });
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWV();
    e.Fx(17);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21959);
        a.this.cMa();
        AppMethodBeat.o(21959);
      }
    });
    AppMethodBeat.o(21966);
  }
  
  public final void cXj() {}
  
  public final void destroy()
  {
    AppMethodBeat.i(21967);
    Log.i(TAG, "destroy");
    release();
    this.vfK.dead();
    AppMethodBeat.o(21967);
  }
  
  public final int getLayoutId()
  {
    return R.i.fto;
  }
  
  public final int getOrder()
  {
    return 3;
  }
  
  public final void oc(int paramInt) {}
  
  public final void release()
  {
    AppMethodBeat.i(21963);
    this.vfh = -1;
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cWU().cWV().cXd();
    AppMethodBeat.o(21963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a
 * JD-Core Version:    0.7.0.1
 */
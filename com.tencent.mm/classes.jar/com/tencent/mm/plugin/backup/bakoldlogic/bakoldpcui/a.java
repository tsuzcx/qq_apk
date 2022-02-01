package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;

public final class a
  extends com.tencent.mm.pluginsdk.ui.b.b
  implements e.d
{
  private static String TAG = "MicroMsg.BakChatBanner";
  private ap handler;
  private int nBA;
  private c nCe;
  private int percent;
  private View rY;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(21960);
    this.nBA = -1;
    this.percent = 0;
    this.rY = null;
    this.handler = new ap(Looper.getMainLooper());
    if (this.view != null)
    {
      this.rY = this.view.findViewById(2131297082);
      this.rY.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21957);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakChatBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
          a.a(a.this, com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bJi().bJj().nBA);
          if ((2 == a.b(a.this)) || (3 == a.b(a.this)) || (5 == a.b(a.this)) || (6 == a.b(a.this)))
          {
            ad.d(a.TAG, "OnClickListener goToBakOperatingUI PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bJi().bJj().nBA), Integer.valueOf(a.c(a.this)) });
            a.d(a.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakChatBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21957);
            return;
          }
          if (4 == a.b(a.this))
          {
            ad.d(a.TAG, "OnClickListener goToBakFinishUI PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bJi().bJj().nBA), Integer.valueOf(a.c(a.this)) });
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
    bAa();
    this.nCe = new a.1(this);
    com.tencent.mm.sdk.b.a.IbL.c(this.nCe);
    AppMethodBeat.o(21960);
  }
  
  private boolean iJ(boolean paramBoolean)
  {
    AppMethodBeat.i(21961);
    this.nBA = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bJi().bJj().nBA;
    ad.d(TAG, "dealwithPCBakBanner PCBannerStatus:%d, setStrategyCaller:%b", new Object[] { Integer.valueOf(this.nBA), Boolean.valueOf(paramBoolean) });
    if ((this.nBA >= 2) && (this.nBA <= 6))
    {
      this.rY.setVisibility(0);
      if ((paramBoolean) && (!com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bJi().bJj().bJq())) {
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bJi().bJj().a(this);
      }
      if (2 == this.nBA)
      {
        ((ImageView)this.view.findViewById(2131297083)).setImageResource(2131689900);
        ((TextView)this.view.findViewById(2131297084)).setText(aj.getContext().getString(2131756277, new Object[] { Integer.valueOf(this.percent) }));
      }
      for (;;)
      {
        AppMethodBeat.o(21961);
        return true;
        if (3 == this.nBA)
        {
          ((ImageView)this.view.findViewById(2131297083)).setImageResource(2131689900);
          ((TextView)this.view.findViewById(2131297084)).setText(aj.getContext().getString(2131756280, new Object[] { Integer.valueOf(this.percent) }));
        }
        else if (4 == this.nBA)
        {
          ((TextView)this.view.findViewById(2131297084)).setText(aj.getContext().getString(2131756279));
          ((ImageView)this.view.findViewById(2131297083)).setImageResource(2131689899);
        }
        else if (5 == this.nBA)
        {
          ((ImageView)this.view.findViewById(2131297083)).setImageResource(2131689900);
          ((TextView)this.view.findViewById(2131297084)).setText(aj.getContext().getString(2131756276, new Object[] { Integer.valueOf(this.percent) }));
        }
        else if (6 == this.nBA)
        {
          ((TextView)this.view.findViewById(2131297084)).setText(aj.getContext().getString(2131756278));
          ((ImageView)this.view.findViewById(2131297083)).setImageResource(2131689899);
        }
      }
    }
    this.rY.setVisibility(8);
    AppMethodBeat.o(21961);
    return false;
  }
  
  public final boolean bAa()
  {
    AppMethodBeat.i(21962);
    this.percent = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bJi().bJj().bJt();
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bJi().bJj().a(this);
    boolean bool = iJ(true);
    AppMethodBeat.o(21962);
    return bool;
  }
  
  public final void bGW() {}
  
  public final void bJw()
  {
    AppMethodBeat.i(21966);
    ad.d(TAG, "onNetFinish PCBannerStatus:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bJi().bJj().nBA) });
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bJi().bJj();
    e.xL(17);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21959);
        a.this.bAa();
        AppMethodBeat.o(21959);
      }
    });
    AppMethodBeat.o(21966);
  }
  
  public final void bJx() {}
  
  public final void destroy()
  {
    AppMethodBeat.i(21967);
    ad.i(TAG, "destroy");
    release();
    com.tencent.mm.sdk.b.a.IbL.d(this.nCe);
    AppMethodBeat.o(21967);
  }
  
  public final int getLayoutId()
  {
    return 2131493145;
  }
  
  public final int getOrder()
  {
    return 3;
  }
  
  public final void onError(int paramInt) {}
  
  public final void release()
  {
    AppMethodBeat.i(21963);
    this.nBA = -1;
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bJi().bJj().bJr();
    AppMethodBeat.o(21963);
  }
  
  public final void xO(int paramInt)
  {
    AppMethodBeat.i(21964);
    ad.d(TAG, "onNetProgress PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bJi().bJj().nBA), Integer.valueOf(paramInt) });
    this.percent = paramInt;
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21958);
        a.this.bAa();
        AppMethodBeat.o(21958);
      }
    });
    AppMethodBeat.o(21964);
  }
  
  public final void xP(int paramInt)
  {
    AppMethodBeat.i(21965);
    ad.d(TAG, "onMergeProgress PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bJi().bJj().nBA), Integer.valueOf(paramInt) });
    AppMethodBeat.o(21965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a
 * JD-Core Version:    0.7.0.1
 */
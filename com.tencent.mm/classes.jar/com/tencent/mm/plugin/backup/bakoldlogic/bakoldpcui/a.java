package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.lg;
import com.tencent.mm.g.a.od;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ao;

public final class a
  extends b
  implements e.d
{
  private static String TAG = "MicroMsg.BakChatBanner";
  private ao handler;
  private c nbH;
  private int nbd;
  private int percent;
  private View qe;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(21960);
    this.nbd = -1;
    this.percent = 0;
    this.qe = null;
    this.handler = new ao(Looper.getMainLooper());
    if (this.view != null)
    {
      this.qe = this.view.findViewById(2131297082);
      this.qe.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21957);
          a.a(a.this, com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bEZ().bFa().nbd);
          if ((2 == a.b(a.this)) || (3 == a.b(a.this)) || (5 == a.b(a.this)) || (6 == a.b(a.this)))
          {
            ac.d(a.TAG, "OnClickListener goToBakOperatingUI PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bEZ().bFa().nbd), Integer.valueOf(a.c(a.this)) });
            a.d(a.this);
            AppMethodBeat.o(21957);
            return;
          }
          if (4 == a.b(a.this))
          {
            ac.d(a.TAG, "OnClickListener goToBakFinishUI PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bEZ().bFa().nbd), Integer.valueOf(a.c(a.this)) });
            a.e(a.this);
            AppMethodBeat.o(21957);
            return;
          }
          AppMethodBeat.o(21957);
        }
      });
    }
    bvU();
    this.nbH = new c() {};
    com.tencent.mm.sdk.b.a.GpY.c(this.nbH);
    AppMethodBeat.o(21960);
  }
  
  private boolean iA(boolean paramBoolean)
  {
    AppMethodBeat.i(21961);
    this.nbd = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bEZ().bFa().nbd;
    ac.d(TAG, "dealwithPCBakBanner PCBannerStatus:%d, setStrategyCaller:%b", new Object[] { Integer.valueOf(this.nbd), Boolean.valueOf(paramBoolean) });
    if ((this.nbd >= 2) && (this.nbd <= 6))
    {
      this.qe.setVisibility(0);
      if ((paramBoolean) && (!com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bEZ().bFa().bFh())) {
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bEZ().bFa().a(this);
      }
      if (2 == this.nbd)
      {
        ((ImageView)this.view.findViewById(2131297083)).setImageResource(2131689900);
        ((TextView)this.view.findViewById(2131297084)).setText(ai.getContext().getString(2131756277, new Object[] { Integer.valueOf(this.percent) }));
      }
      for (;;)
      {
        AppMethodBeat.o(21961);
        return true;
        if (3 == this.nbd)
        {
          ((ImageView)this.view.findViewById(2131297083)).setImageResource(2131689900);
          ((TextView)this.view.findViewById(2131297084)).setText(ai.getContext().getString(2131756280, new Object[] { Integer.valueOf(this.percent) }));
        }
        else if (4 == this.nbd)
        {
          ((TextView)this.view.findViewById(2131297084)).setText(ai.getContext().getString(2131756279));
          ((ImageView)this.view.findViewById(2131297083)).setImageResource(2131689899);
        }
        else if (5 == this.nbd)
        {
          ((ImageView)this.view.findViewById(2131297083)).setImageResource(2131689900);
          ((TextView)this.view.findViewById(2131297084)).setText(ai.getContext().getString(2131756276, new Object[] { Integer.valueOf(this.percent) }));
        }
        else if (6 == this.nbd)
        {
          ((TextView)this.view.findViewById(2131297084)).setText(ai.getContext().getString(2131756278));
          ((ImageView)this.view.findViewById(2131297083)).setImageResource(2131689899);
        }
      }
    }
    this.qe.setVisibility(8);
    AppMethodBeat.o(21961);
    return false;
  }
  
  public final void bCO() {}
  
  public final void bFn()
  {
    AppMethodBeat.i(21966);
    ac.d(TAG, "onNetFinish PCBannerStatus:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bEZ().bFa().nbd) });
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bEZ().bFa();
    e.xf(17);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21959);
        a.this.bvU();
        AppMethodBeat.o(21959);
      }
    });
    AppMethodBeat.o(21966);
  }
  
  public final void bFo() {}
  
  public final boolean bvU()
  {
    AppMethodBeat.i(21962);
    this.percent = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bEZ().bFa().bFk();
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bEZ().bFa().a(this);
    boolean bool = iA(true);
    AppMethodBeat.o(21962);
    return bool;
  }
  
  public final void destroy()
  {
    AppMethodBeat.i(21967);
    ac.i(TAG, "destroy");
    release();
    com.tencent.mm.sdk.b.a.GpY.d(this.nbH);
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
    this.nbd = -1;
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bEZ().bFa().bFi();
    AppMethodBeat.o(21963);
  }
  
  public final void xi(int paramInt)
  {
    AppMethodBeat.i(21964);
    ac.d(TAG, "onNetProgress PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bEZ().bFa().nbd), Integer.valueOf(paramInt) });
    this.percent = paramInt;
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21958);
        a.this.bvU();
        AppMethodBeat.o(21958);
      }
    });
    AppMethodBeat.o(21964);
  }
  
  public final void xj(int paramInt)
  {
    AppMethodBeat.i(21965);
    ac.d(TAG, "onMergeProgress PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.bEZ().bFa().nbd), Integer.valueOf(paramInt) });
    AppMethodBeat.o(21965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a
 * JD-Core Version:    0.7.0.1
 */
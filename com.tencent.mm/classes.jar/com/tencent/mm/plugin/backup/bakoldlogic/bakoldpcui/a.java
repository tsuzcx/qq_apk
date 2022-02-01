package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.kx;
import com.tencent.mm.g.a.nu;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;

public final class a
  extends b
  implements e.d
{
  private static String TAG = "MicroMsg.BakChatBanner";
  private ap handler;
  private c mzG;
  private int mzc;
  private int percent;
  private View pf;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(21960);
    this.mzc = -1;
    this.percent = 0;
    this.pf = null;
    this.handler = new ap(Looper.getMainLooper());
    if (this.view != null)
    {
      this.pf = this.view.findViewById(2131297082);
      this.pf.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21957);
          a.a(a.this, com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.byd().bye().mzc);
          if ((2 == a.b(a.this)) || (3 == a.b(a.this)) || (5 == a.b(a.this)) || (6 == a.b(a.this)))
          {
            ad.d(a.TAG, "OnClickListener goToBakOperatingUI PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.byd().bye().mzc), Integer.valueOf(a.c(a.this)) });
            a.d(a.this);
            AppMethodBeat.o(21957);
            return;
          }
          if (4 == a.b(a.this))
          {
            ad.d(a.TAG, "OnClickListener goToBakFinishUI PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.byd().bye().mzc), Integer.valueOf(a.c(a.this)) });
            a.e(a.this);
            AppMethodBeat.o(21957);
            return;
          }
          AppMethodBeat.o(21957);
        }
      });
    }
    boZ();
    this.mzG = new c() {};
    com.tencent.mm.sdk.b.a.ESL.c(this.mzG);
    AppMethodBeat.o(21960);
  }
  
  private boolean ia(boolean paramBoolean)
  {
    AppMethodBeat.i(21961);
    this.mzc = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.byd().bye().mzc;
    ad.d(TAG, "dealwithPCBakBanner PCBannerStatus:%d, setStrategyCaller:%b", new Object[] { Integer.valueOf(this.mzc), Boolean.valueOf(paramBoolean) });
    if ((this.mzc >= 2) && (this.mzc <= 6))
    {
      this.pf.setVisibility(0);
      if ((paramBoolean) && (!com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.byd().bye().byl())) {
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.byd().bye().a(this);
      }
      if (2 == this.mzc)
      {
        ((ImageView)this.view.findViewById(2131297083)).setImageResource(2131689900);
        ((TextView)this.view.findViewById(2131297084)).setText(aj.getContext().getString(2131756277, new Object[] { Integer.valueOf(this.percent) }));
      }
      for (;;)
      {
        AppMethodBeat.o(21961);
        return true;
        if (3 == this.mzc)
        {
          ((ImageView)this.view.findViewById(2131297083)).setImageResource(2131689900);
          ((TextView)this.view.findViewById(2131297084)).setText(aj.getContext().getString(2131756280, new Object[] { Integer.valueOf(this.percent) }));
        }
        else if (4 == this.mzc)
        {
          ((TextView)this.view.findViewById(2131297084)).setText(aj.getContext().getString(2131756279));
          ((ImageView)this.view.findViewById(2131297083)).setImageResource(2131689899);
        }
        else if (5 == this.mzc)
        {
          ((ImageView)this.view.findViewById(2131297083)).setImageResource(2131689900);
          ((TextView)this.view.findViewById(2131297084)).setText(aj.getContext().getString(2131756276, new Object[] { Integer.valueOf(this.percent) }));
        }
        else if (6 == this.mzc)
        {
          ((TextView)this.view.findViewById(2131297084)).setText(aj.getContext().getString(2131756278));
          ((ImageView)this.view.findViewById(2131297083)).setImageResource(2131689899);
        }
      }
    }
    this.pf.setVisibility(8);
    AppMethodBeat.o(21961);
    return false;
  }
  
  public final boolean boZ()
  {
    AppMethodBeat.i(21962);
    this.percent = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.byd().bye().byo();
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.byd().bye().a(this);
    boolean bool = ia(true);
    AppMethodBeat.o(21962);
    return bool;
  }
  
  public final void bvS() {}
  
  public final void byr()
  {
    AppMethodBeat.i(21966);
    ad.d(TAG, "onNetFinish PCBannerStatus:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.byd().bye().mzc) });
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.byd().bye();
    e.wo(17);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21959);
        a.this.boZ();
        AppMethodBeat.o(21959);
      }
    });
    AppMethodBeat.o(21966);
  }
  
  public final void bys() {}
  
  public final void destroy()
  {
    AppMethodBeat.i(21967);
    ad.i(TAG, "destroy");
    release();
    com.tencent.mm.sdk.b.a.ESL.d(this.mzG);
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
    this.mzc = -1;
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.byd().bye().bym();
    AppMethodBeat.o(21963);
  }
  
  public final void wr(int paramInt)
  {
    AppMethodBeat.i(21964);
    ad.d(TAG, "onNetProgress PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.byd().bye().mzc), Integer.valueOf(paramInt) });
    this.percent = paramInt;
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21958);
        a.this.boZ();
        AppMethodBeat.o(21958);
      }
    });
    AppMethodBeat.o(21964);
  }
  
  public final void ws(int paramInt)
  {
    AppMethodBeat.i(21965);
    ad.d(TAG, "onMergeProgress PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.byd().bye().mzc), Integer.valueOf(paramInt) });
    AppMethodBeat.o(21965);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a
 * JD-Core Version:    0.7.0.1
 */
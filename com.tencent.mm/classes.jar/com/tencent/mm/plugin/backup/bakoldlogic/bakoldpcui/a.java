package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.mg;
import com.tencent.mm.g.a.pe;
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
  private MMHandler handler;
  private int oRS;
  private IListener oSw;
  private int percent;
  private View sc;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(21960);
    this.oRS = -1;
    this.percent = 0;
    this.sc = null;
    this.handler = new MMHandler(Looper.getMainLooper());
    if (this.view != null)
    {
      this.sc = this.view.findViewById(2131297227);
      this.sc.setOnClickListener(new View.OnClickListener()
      {
        public final void onClick(View paramAnonymousView)
        {
          AppMethodBeat.i(21957);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousView);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakChatBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
          a.a(a.this, com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().oRS);
          if ((2 == a.b(a.this)) || (3 == a.b(a.this)) || (5 == a.b(a.this)) || (6 == a.b(a.this)))
          {
            Log.d(a.TAG, "OnClickListener goToBakOperatingUI PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().oRS), Integer.valueOf(a.c(a.this)) });
            a.d(a.this);
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/backup/bakoldlogic/bakoldpcui/BakChatBanner$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(21957);
            return;
          }
          if (4 == a.b(a.this))
          {
            Log.d(a.TAG, "OnClickListener goToBakFinishUI PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().oRS), Integer.valueOf(a.c(a.this)) });
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
    bYa();
    this.oSw = new IListener() {};
    EventCenter.instance.addListener(this.oSw);
    AppMethodBeat.o(21960);
  }
  
  private boolean jI(boolean paramBoolean)
  {
    AppMethodBeat.i(21961);
    this.oRS = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().oRS;
    Log.d(TAG, "dealwithPCBakBanner PCBannerStatus:%d, setStrategyCaller:%b", new Object[] { Integer.valueOf(this.oRS), Boolean.valueOf(paramBoolean) });
    if ((this.oRS >= 2) && (this.oRS <= 6))
    {
      this.sc.setVisibility(0);
      if ((paramBoolean) && (!com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().chh())) {
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().a(this);
      }
      if (2 == this.oRS)
      {
        ((ImageView)this.view.findViewById(2131297228)).setImageResource(2131689915);
        ((TextView)this.view.findViewById(2131297229)).setText(MMApplicationContext.getContext().getString(2131756412, new Object[] { Integer.valueOf(this.percent) }));
      }
      for (;;)
      {
        AppMethodBeat.o(21961);
        return true;
        if (3 == this.oRS)
        {
          ((ImageView)this.view.findViewById(2131297228)).setImageResource(2131689915);
          ((TextView)this.view.findViewById(2131297229)).setText(MMApplicationContext.getContext().getString(2131756415, new Object[] { Integer.valueOf(this.percent) }));
        }
        else if (4 == this.oRS)
        {
          ((TextView)this.view.findViewById(2131297229)).setText(MMApplicationContext.getContext().getString(2131756414));
          ((ImageView)this.view.findViewById(2131297228)).setImageResource(2131689914);
        }
        else if (5 == this.oRS)
        {
          ((ImageView)this.view.findViewById(2131297228)).setImageResource(2131689915);
          ((TextView)this.view.findViewById(2131297229)).setText(MMApplicationContext.getContext().getString(2131756410, new Object[] { Integer.valueOf(this.percent) }));
        }
        else if (6 == this.oRS)
        {
          ((TextView)this.view.findViewById(2131297229)).setText(MMApplicationContext.getContext().getString(2131756413));
          ((ImageView)this.view.findViewById(2131297228)).setImageResource(2131689914);
        }
      }
    }
    this.sc.setVisibility(8);
    AppMethodBeat.o(21961);
    return false;
  }
  
  public final void By(int paramInt)
  {
    AppMethodBeat.i(21964);
    Log.d(TAG, "onNetProgress PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().oRS), Integer.valueOf(paramInt) });
    this.percent = paramInt;
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21958);
        a.this.bYa();
        AppMethodBeat.o(21958);
      }
    });
    AppMethodBeat.o(21964);
  }
  
  public final void Bz(int paramInt)
  {
    AppMethodBeat.i(21965);
    Log.d(TAG, "onMergeProgress PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().oRS), Integer.valueOf(paramInt) });
    AppMethodBeat.o(21965);
  }
  
  public final boolean bYa()
  {
    AppMethodBeat.i(21962);
    this.percent = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().chk();
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().a(this);
    boolean bool = jI(true);
    AppMethodBeat.o(21962);
    return bool;
  }
  
  public final void ceL() {}
  
  public final void chn()
  {
    AppMethodBeat.i(21966);
    Log.d(TAG, "onNetFinish PCBannerStatus:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().oRS) });
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha();
    e.Bv(17);
    this.handler.post(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(21959);
        a.this.bYa();
        AppMethodBeat.o(21959);
      }
    });
    AppMethodBeat.o(21966);
  }
  
  public final void cho() {}
  
  public final void destroy()
  {
    AppMethodBeat.i(21967);
    Log.i(TAG, "destroy");
    release();
    EventCenter.instance.removeListener(this.oSw);
    AppMethodBeat.o(21967);
  }
  
  public final int getLayoutId()
  {
    return 2131493188;
  }
  
  public final int getOrder()
  {
    return 3;
  }
  
  public final void onError(int paramInt) {}
  
  public final void release()
  {
    AppMethodBeat.i(21963);
    this.oRS = -1;
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.cgZ().cha().chi();
    AppMethodBeat.o(21963);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;

public final class a
  extends b
  implements e.d
{
  private static String TAG = "MicroMsg.BakChatBanner";
  private ak handler;
  private int jHK;
  private View jIo;
  private c jIp;
  private int percent;
  
  public a(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(17904);
    this.jHK = -1;
    this.percent = 0;
    this.jIo = null;
    this.handler = new ak(Looper.getMainLooper());
    if (this.view != null)
    {
      this.jIo = this.view.findViewById(2131821668);
      this.jIo.setOnClickListener(new a.2(this));
    }
    aMK();
    this.jIp = new a.1(this);
    com.tencent.mm.sdk.b.a.ymk.c(this.jIp);
    AppMethodBeat.o(17904);
  }
  
  private boolean fG(boolean paramBoolean)
  {
    AppMethodBeat.i(17905);
    this.jHK = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUU().aUV().jHK;
    ab.d(TAG, "dealwithPCBakBanner PCBannerStatus:%d, setCallBack:%b", new Object[] { Integer.valueOf(this.jHK), Boolean.valueOf(paramBoolean) });
    if ((this.jHK >= 2) && (this.jHK <= 6))
    {
      this.jIo.setVisibility(0);
      if ((paramBoolean) && (!com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUU().aUV().aVc())) {
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUU().aUV().a(this);
      }
      if (2 == this.jHK)
      {
        ((ImageView)this.view.findViewById(2131821669)).setImageResource(2131231106);
        ((TextView)this.view.findViewById(2131821670)).setText(ah.getContext().getString(2131297401, new Object[] { Integer.valueOf(this.percent) }));
      }
      for (;;)
      {
        AppMethodBeat.o(17905);
        return true;
        if (3 == this.jHK)
        {
          ((ImageView)this.view.findViewById(2131821669)).setImageResource(2131231106);
          ((TextView)this.view.findViewById(2131821670)).setText(ah.getContext().getString(2131297404, new Object[] { Integer.valueOf(this.percent) }));
        }
        else if (4 == this.jHK)
        {
          ((TextView)this.view.findViewById(2131821670)).setText(ah.getContext().getString(2131297403));
          ((ImageView)this.view.findViewById(2131821669)).setImageResource(2131231105);
        }
        else if (5 == this.jHK)
        {
          ((ImageView)this.view.findViewById(2131821669)).setImageResource(2131231106);
          ((TextView)this.view.findViewById(2131821670)).setText(ah.getContext().getString(2131297400, new Object[] { Integer.valueOf(this.percent) }));
        }
        else if (6 == this.jHK)
        {
          ((TextView)this.view.findViewById(2131821670)).setText(ah.getContext().getString(2131297402));
          ((ImageView)this.view.findViewById(2131821669)).setImageResource(2131231105);
        }
      }
    }
    this.jIo.setVisibility(8);
    AppMethodBeat.o(17905);
    return false;
  }
  
  public final boolean aMK()
  {
    AppMethodBeat.i(17906);
    this.percent = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUU().aUV().aVf();
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUU().aUV().a(this);
    boolean bool = fG(true);
    AppMethodBeat.o(17906);
    return bool;
  }
  
  public final void aSK() {}
  
  public final void aVi()
  {
    AppMethodBeat.i(17910);
    ab.d(TAG, "onNetFinish PCBannerStatus:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUU().aUV().jHK) });
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUU().aUV();
    e.rC(17);
    this.handler.post(new a.4(this));
    AppMethodBeat.o(17910);
  }
  
  public final void aVj() {}
  
  public final void destroy()
  {
    AppMethodBeat.i(17911);
    com.tencent.mm.sdk.b.a.ymk.d(this.jIp);
    AppMethodBeat.o(17911);
  }
  
  public final int getLayoutId()
  {
    return 2130968816;
  }
  
  public final int getOrder()
  {
    return 3;
  }
  
  public final void onError(int paramInt) {}
  
  public final void rF(int paramInt)
  {
    AppMethodBeat.i(17908);
    ab.d(TAG, "onNetProgress PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUU().aUV().jHK), Integer.valueOf(paramInt) });
    this.percent = paramInt;
    this.handler.post(new a.3(this));
    AppMethodBeat.o(17908);
  }
  
  public final void rG(int paramInt)
  {
    AppMethodBeat.i(17909);
    ab.d(TAG, "onMergeProgress PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUU().aUV().jHK), Integer.valueOf(paramInt) });
    AppMethodBeat.o(17909);
  }
  
  public final void release()
  {
    AppMethodBeat.i(17907);
    this.jHK = -1;
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.aUU().aUV().aVd();
    AppMethodBeat.o(17907);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a
 * JD-Core Version:    0.7.0.1
 */
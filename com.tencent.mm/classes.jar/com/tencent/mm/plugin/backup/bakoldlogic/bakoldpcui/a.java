package com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui;

import android.content.Context;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.k;
import com.tencent.mm.R.l;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e;
import com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.e.d;
import com.tencent.mm.pluginsdk.ui.b.b;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.y;

public final class a
  extends b
  implements e.d
{
  private static String TAG = "MicroMsg.BakChatBanner";
  private View hNa = null;
  private int hOM = 0;
  private c hON;
  private int hOi = -1;
  private ah handler = new ah(Looper.getMainLooper());
  
  public a(Context paramContext)
  {
    super(paramContext);
    if (this.view != null)
    {
      this.hNa = this.view.findViewById(R.h.bakchat_banner_view);
      this.hNa.setOnClickListener(new a.2(this));
    }
    apu();
    this.hON = new a.1(this);
    com.tencent.mm.sdk.b.a.udP.c(this.hON);
  }
  
  private boolean ek(boolean paramBoolean)
  {
    this.hOi = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.avr().avs().hOi;
    y.d(TAG, "dealwithPCBakBanner PCBannerStatus:%d, setCallBack:%b", new Object[] { Integer.valueOf(this.hOi), Boolean.valueOf(paramBoolean) });
    if ((this.hOi >= 2) && (this.hOi <= 6))
    {
      this.hNa.setVisibility(0);
      if ((paramBoolean) && (!com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.avr().avs().avz())) {
        com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.avr().avs().a(this);
      }
      if (2 == this.hOi)
      {
        ((ImageView)this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.chatting_backup_computer);
        ((TextView)this.view.findViewById(R.h.bakchat_info)).setText(ae.getContext().getString(R.l.bak_chat_banner_preparing, new Object[] { Integer.valueOf(this.hOM) }));
      }
      for (;;)
      {
        return true;
        if (3 == this.hOi)
        {
          ((ImageView)this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.chatting_backup_computer);
          ((TextView)this.view.findViewById(R.h.bakchat_info)).setText(ae.getContext().getString(R.l.bak_chat_banner_uploading, new Object[] { Integer.valueOf(this.hOM) }));
        }
        else if (4 == this.hOi)
        {
          ((TextView)this.view.findViewById(R.h.bakchat_info)).setText(ae.getContext().getString(R.l.bak_chat_banner_upload_success));
          ((ImageView)this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.chatting_backup_comfirm);
        }
        else if (5 == this.hOi)
        {
          ((ImageView)this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.chatting_backup_computer);
          ((TextView)this.view.findViewById(R.h.bakchat_info)).setText(ae.getContext().getString(R.l.bak_chat_banner_downloading, new Object[] { Integer.valueOf(this.hOM) }));
        }
        else if (6 == this.hOi)
        {
          ((TextView)this.view.findViewById(R.h.bakchat_info)).setText(ae.getContext().getString(R.l.bak_chat_banner_recover_wait));
          ((ImageView)this.view.findViewById(R.h.bakchat_icon)).setImageResource(R.k.chatting_backup_comfirm);
        }
      }
    }
    this.hNa.setVisibility(8);
    return false;
  }
  
  public final boolean apu()
  {
    this.hOM = com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.avr().avs().avC();
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.avr().avs().a(this);
    return ek(true);
  }
  
  public final void atm() {}
  
  public final void avF()
  {
    y.d(TAG, "onNetFinish PCBannerStatus:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.avr().avs().hOi) });
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.avr().avs();
    e.nO(17);
    this.handler.post(new a.4(this));
  }
  
  public final void avG() {}
  
  public final void destroy()
  {
    com.tencent.mm.sdk.b.a.udP.d(this.hON);
  }
  
  public final int getLayoutId()
  {
    return R.i.bakchat_banner_view;
  }
  
  public final int getOrder()
  {
    return 3;
  }
  
  public final void nS(int paramInt)
  {
    y.d(TAG, "onNetProgress PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.avr().avs().hOi), Integer.valueOf(paramInt) });
    this.hOM = paramInt;
    this.handler.post(new a.3(this));
  }
  
  public final void nT(int paramInt)
  {
    y.d(TAG, "onMergeProgress PCBannerStatus:%d, percent:%d", new Object[] { Integer.valueOf(com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.avr().avs().hOi), Integer.valueOf(paramInt) });
  }
  
  public final void onError(int paramInt) {}
  
  public final void release()
  {
    this.hOi = -1;
    com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcmodel.a.avr().avs().avA();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.backup.bakoldlogic.bakoldpcui.a
 * JD-Core Version:    0.7.0.1
 */
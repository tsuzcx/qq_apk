package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.xo;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.ccy;
import com.tencent.mm.protocal.protobuf.cyf;
import com.tencent.mm.protocal.protobuf.dlp;
import com.tencent.mm.protocal.protobuf.dqd;
import com.tencent.mm.protocal.protobuf.dqe;
import com.tencent.mm.protocal.protobuf.egf;
import com.tencent.mm.protocal.protobuf.ehf;
import com.tencent.mm.protocal.protobuf.ehu;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.LinkedList;
import org.json.JSONObject;

public class MallWalletSectionCellView
  extends LinearLayout
{
  private static final int qfn;
  public View lJI;
  public View pYY;
  public CdnImageView zmI;
  public TextView zmJ;
  public TextView zmK;
  public CdnImageView zmL;
  public TextView zmM;
  public ImageView zmN;
  public ImageView zmO;
  public TextView zmP;
  public TextView zmQ;
  public ViewGroup zmR;
  public TextView zmS;
  public WcPayMoneyLoadingView zmT;
  public ProgressBar zmU;
  private dlp zmV;
  
  static
  {
    AppMethodBeat.i(66156);
    qfn = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 16);
    AppMethodBeat.o(66156);
  }
  
  public MallWalletSectionCellView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(66148);
    init(paramContext);
    AppMethodBeat.o(66148);
  }
  
  public MallWalletSectionCellView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(66149);
    init(paramContext);
    AppMethodBeat.o(66149);
  }
  
  public MallWalletSectionCellView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(66150);
    init(paramContext);
    AppMethodBeat.o(66150);
  }
  
  private int bu(float paramFloat)
  {
    AppMethodBeat.i(66153);
    int i = com.tencent.mm.cb.a.fromDPToPix(getContext(), (int)paramFloat);
    AppMethodBeat.o(66153);
    return i;
  }
  
  private void ehu()
  {
    AppMethodBeat.i(66154);
    this.zmP.setVisibility(8);
    this.zmN.setVisibility(8);
    this.zmO.setVisibility(8);
    this.zmQ.setVisibility(8);
    if ((this.zmV != null) && (this.zmV.type == 4)) {
      this.zmK.setText("");
    }
    AppMethodBeat.o(66154);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(66151);
    this.lJI = LayoutInflater.from(paramContext).inflate(2131495456, this, true);
    this.zmI = ((CdnImageView)this.lJI.findViewById(2131305177));
    this.zmJ = ((TextView)this.lJI.findViewById(2131305185));
    this.zmK = ((TextView)this.lJI.findViewById(2131305174));
    this.zmL = ((CdnImageView)this.lJI.findViewById(2131305183));
    this.zmM = ((TextView)this.lJI.findViewById(2131305184));
    this.zmN = ((ImageView)this.lJI.findViewById(2131305181));
    this.zmO = ((ImageView)this.lJI.findViewById(2131305182));
    this.zmP = ((TextView)this.lJI.findViewById(2131305179));
    this.zmQ = ((TextView)this.lJI.findViewById(2131305180));
    this.pYY = this.lJI.findViewById(2131305175);
    this.zmR = ((ViewGroup)this.lJI.findViewById(2131305178));
    this.zmS = ((TextView)this.lJI.findViewById(2131305176));
    this.zmT = ((WcPayMoneyLoadingView)this.lJI.findViewById(2131305173));
    this.zmU = ((ProgressBar)this.lJI.findViewById(2131310218));
    this.zmT.setLoadingPb(this.zmU);
    setOrientation(1);
    setBackgroundResource(2131233333);
    AppMethodBeat.o(66151);
  }
  
  public final void a(final egf paramegf, final JSONObject paramJSONObject, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    AppMethodBeat.i(66152);
    com.tencent.mm.plugin.wallet_core.utils.g.a(this.zmI, paramegf.Nge);
    label86:
    Object localObject;
    dqd localdqd;
    label115:
    label123:
    int i;
    if ((paramegf.Ngh != null) && (!Util.isNullOrNil(paramegf.Ngh.url)))
    {
      com.tencent.mm.plugin.wallet_core.utils.g.a(this.zmL, paramegf.Ngh, 2131235568, true);
      if ((paramegf.Ngf == null) || (paramegf.Ngf.size() <= 0)) {
        break label604;
      }
      com.tencent.mm.plugin.wallet_core.utils.g.a(this.zmJ, (ehf)paramegf.Ngf.get(0), null);
      if (paramegf.Ngj == null) {
        break label733;
      }
      localObject = this.zmS;
      localdqd = paramegf.Ngj;
      if ((localdqd != null) && (localObject != null)) {
        break label616;
      }
      this.zmS.setVisibility(0);
      if ((paramegf.Ngg == null) || (paramegf.Ngg.size() <= 0)) {
        break label790;
      }
      if (Util.isNullOrNil(paramString)) {
        break label751;
      }
      localObject = this.zmT;
      if (paramBoolean2) {
        break label745;
      }
      paramBoolean2 = true;
      label162:
      ((WcPayMoneyLoadingView)localObject).cH(paramString, paramBoolean2);
      this.zmT.setVisibility(0);
      this.zmK.setVisibility(8);
      label188:
      if ((paramegf.Ngg == null) || (paramegf.Ngg.size() <= 1)) {
        break label876;
      }
      com.tencent.mm.plugin.wallet_core.utils.g.a(this.zmM, (ehf)paramegf.Ngg.get(1), null);
      label225:
      if ((paramegf.Ngi == null) || (paramJSONObject == null)) {
        break label1063;
      }
      this.zmV = paramegf.Ngi;
      if (paramJSONObject.optInt(paramegf.Ngi.LXh, 0) != 1) {
        break label888;
      }
      i = 1;
      label263:
      long l = paramJSONObject.optLong(String.format("%s_expiretime", new Object[] { paramegf.Ngi.LXh }), 0L);
      int j = i;
      if (l > 0L)
      {
        j = i;
        if (System.currentTimeMillis() > l)
        {
          Log.i("MicroMsg.MallWalletSectionCellView", "red dot expired: %s, %s", new Object[] { paramegf.Ngi.LXh, Long.valueOf(l) });
          j = 0;
        }
      }
      ehu();
      if (j == 0) {
        break label1056;
      }
      if (paramegf.Ngi.type != 1) {
        break label905;
      }
      if (Util.isNullOrNil(this.zmK.getText())) {
        break label894;
      }
      this.zmO.setVisibility(0);
      label389:
      i = qfn;
      int k = qfn;
      j = qfn;
      int m = qfn;
      if (paramegf.MTe != null)
      {
        paramString = paramegf.MTe;
        if (paramString.left > 0.0F) {
          i = bu(paramString.left);
        }
        if (paramString.right > 0.0F) {
          j = bu(paramString.right);
        }
        if (paramString.top > 0.0F) {
          k = bu(paramString.top);
        }
        if (paramString.bottom > 0.0F) {
          m = bu(paramString.bottom);
        }
        this.zmR.setPadding(i, k, j, m);
      }
      if (!paramBoolean1) {
        break label1070;
      }
      this.zmJ.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(66146);
          Log.d("MicroMsg.MallWalletSectionCellView", "x: %s, left: %s", new Object[] { Float.valueOf(MallWalletSectionCellView.this.zmJ.getX()), Integer.valueOf(MallWalletSectionCellView.this.zmJ.getLeft()) });
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 1);
          localLayoutParams.leftMargin = MallWalletSectionCellView.this.zmJ.getLeft();
          MallWalletSectionCellView.this.pYY.setLayoutParams(localLayoutParams);
          MallWalletSectionCellView.this.pYY.setVisibility(0);
          AppMethodBeat.o(66146);
        }
      });
    }
    for (;;)
    {
      if (paramegf.KEP != null) {
        setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66147);
            b localb = new b();
            localb.bm(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallWalletSectionCellView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
            paramAnonymousView = new Bundle();
            paramAnonymousView.putInt("key_tiny_app_scene", 1019);
            com.tencent.mm.plugin.wallet_core.utils.g.a(MallWalletSectionCellView.this.getContext(), paramegf.KEP, paramAnonymousView);
            paramAnonymousView = new xo();
            paramAnonymousView.edO.viewId = paramegf.KNW;
            EventCenter.instance.publish(paramAnonymousView);
            MallWalletSectionCellView.a(MallWalletSectionCellView.this);
            if ((paramJSONObject != null) && (paramegf.Ngi != null))
            {
              paramJSONObject.remove(paramegf.Ngi.LXh);
              paramJSONObject.remove(String.format("%s_expiretime", new Object[] { paramegf.Ngi.LXh }));
              com.tencent.mm.kernel.g.aAh().azQ().set(ar.a.Ofd, paramJSONObject.toString());
            }
            paramAnonymousView = "";
            int i;
            if (paramegf.KEP.type == 1)
            {
              paramAnonymousView = paramegf.KEP.url;
              i = 1;
            }
            for (;;)
            {
              h.CyF.a(16502, new Object[] { Integer.valueOf(2), paramAnonymousView, Integer.valueOf(i) });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallWalletSectionCellView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(66147);
              return;
              if (paramegf.KEP.type == 2)
              {
                if (paramegf.KEP.MTh != null) {
                  paramAnonymousView = paramegf.KEP.MTh.username;
                }
                i = 2;
              }
              else if (paramegf.KEP.type == 4)
              {
                paramAnonymousView = paramegf.KEP.url;
                i = 3;
              }
              else
              {
                i = 0;
              }
            }
          }
        });
      }
      AppMethodBeat.o(66152);
      return;
      this.zmL.setImageResource(2131690737);
      this.zmL.setColorFilter(getContext().getResources().getColor(2131100006), PorterDuff.Mode.SRC_ATOP);
      break;
      label604:
      this.zmJ.setText("");
      break label86;
      label616:
      com.tencent.mm.plugin.wallet_core.utils.g.a((TextView)localObject, localdqd.Lov, null);
      com.tencent.mm.plugin.wallet_core.utils.g.a((View)localObject, localdqd.MTe);
      i = (int)localdqd.MTg;
      if ((localdqd.MTg & 0xFF000000) == 0L) {
        i = (int)(localdqd.MTg | 0xFF000000);
      }
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setShape(0);
      if (localdqd.MTf > 0.0F) {
        localGradientDrawable.setCornerRadius(com.tencent.mm.cb.a.fromDPToPix(((TextView)localObject).getContext(), (int)localdqd.MTf));
      }
      localGradientDrawable.setColor(i);
      ((TextView)localObject).setBackground(localGradientDrawable);
      break label115;
      label733:
      this.zmS.setVisibility(8);
      break label123;
      label745:
      paramBoolean2 = false;
      break label162;
      label751:
      com.tencent.mm.plugin.wallet_core.utils.g.a(this.zmK, (ehf)paramegf.Ngg.get(0), null);
      this.zmT.setVisibility(8);
      this.zmK.setVisibility(0);
      break label188;
      label790:
      if (!Util.isNullOrNil(paramString))
      {
        paramString = this.zmT;
        if (!paramBoolean2) {}
        for (paramBoolean2 = true;; paramBoolean2 = false)
        {
          paramString.cH("", paramBoolean2);
          this.zmT.setVisibility(0);
          this.zmK.setVisibility(8);
          break;
        }
      }
      this.zmK.setText("");
      this.zmT.setVisibility(8);
      this.zmK.setVisibility(0);
      break label188;
      label876:
      this.zmM.setVisibility(8);
      break label225;
      label888:
      i = 0;
      break label263;
      label894:
      this.zmN.setVisibility(0);
      break label389;
      label905:
      if (paramegf.Ngi.type == 2)
      {
        this.zmP.setVisibility(0);
        break label389;
      }
      if (paramegf.Ngi.type == 3)
      {
        this.zmQ.setText(com.tencent.mm.plugin.wallet_core.utils.g.a(getContext(), paramegf.Ngi.Lov));
        this.zmQ.setVisibility(0);
        break label389;
      }
      if (paramegf.Ngi.type == 4)
      {
        this.zmO.setVisibility(0);
        com.tencent.mm.plugin.wallet_core.utils.g.a(this.zmK, paramegf.Ngi.Lov, null);
        paramString = this.zmT;
        paramString.setVisibility(8);
        if (paramString.kdb != null) {
          paramString.kdb.setVisibility(8);
        }
        paramString.removeCallbacks(paramString.Ios);
        break label389;
      }
      ehu();
      break label389;
      label1056:
      ehu();
      break label389;
      label1063:
      ehu();
      break label389;
      label1070:
      this.pYY.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallWalletSectionCellView
 * JD-Core Version:    0.7.0.1
 */
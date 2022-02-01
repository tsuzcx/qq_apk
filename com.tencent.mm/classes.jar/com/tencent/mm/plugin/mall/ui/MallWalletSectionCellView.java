package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.GradientDrawable;
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
import com.tencent.mm.g.a.wo;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bqg;
import com.tencent.mm.protocal.protobuf.chy;
import com.tencent.mm.protocal.protobuf.csz;
import com.tencent.mm.protocal.protobuf.cxj;
import com.tencent.mm.protocal.protobuf.cxk;
import com.tencent.mm.protocal.protobuf.dmr;
import com.tencent.mm.protocal.protobuf.dnl;
import com.tencent.mm.protocal.protobuf.dny;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import java.util.LinkedList;
import org.json.JSONObject;

public class MallWalletSectionCellView
  extends LinearLayout
{
  private static final int oRz;
  public View kFh;
  public View oLk;
  public CdnImageView vSC;
  public TextView vSD;
  public TextView vSE;
  public CdnImageView vSF;
  public TextView vSG;
  public ImageView vSH;
  public ImageView vSI;
  public TextView vSJ;
  public TextView vSK;
  public ViewGroup vSL;
  public TextView vSM;
  public WcPayMoneyLoadingView vSN;
  public ProgressBar vSO;
  private csz vSP;
  
  static
  {
    AppMethodBeat.i(66156);
    oRz = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 16);
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
  
  private int bk(float paramFloat)
  {
    AppMethodBeat.i(66153);
    int i = com.tencent.mm.cb.a.fromDPToPix(getContext(), (int)paramFloat);
    AppMethodBeat.o(66153);
    return i;
  }
  
  private void dnI()
  {
    AppMethodBeat.i(66154);
    this.vSJ.setVisibility(8);
    this.vSH.setVisibility(8);
    this.vSI.setVisibility(8);
    this.vSK.setVisibility(8);
    if ((this.vSP != null) && (this.vSP.type == 4)) {
      this.vSE.setText("");
    }
    AppMethodBeat.o(66154);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(66151);
    this.kFh = LayoutInflater.from(paramContext).inflate(2131494727, this, true);
    this.vSC = ((CdnImageView)this.kFh.findViewById(2131302633));
    this.vSD = ((TextView)this.kFh.findViewById(2131302641));
    this.vSE = ((TextView)this.kFh.findViewById(2131302630));
    this.vSF = ((CdnImageView)this.kFh.findViewById(2131302639));
    this.vSG = ((TextView)this.kFh.findViewById(2131302640));
    this.vSH = ((ImageView)this.kFh.findViewById(2131302637));
    this.vSI = ((ImageView)this.kFh.findViewById(2131302638));
    this.vSJ = ((TextView)this.kFh.findViewById(2131302635));
    this.vSK = ((TextView)this.kFh.findViewById(2131302636));
    this.oLk = this.kFh.findViewById(2131302631);
    this.vSL = ((ViewGroup)this.kFh.findViewById(2131302634));
    this.vSM = ((TextView)this.kFh.findViewById(2131302632));
    this.vSN = ((WcPayMoneyLoadingView)this.kFh.findViewById(2131302629));
    this.vSO = ((ProgressBar)this.kFh.findViewById(2131306757));
    this.vSN.setLoadingPb(this.vSO);
    setOrientation(1);
    setBackgroundResource(2131232873);
    AppMethodBeat.o(66151);
  }
  
  public final void a(final dmr paramdmr, final JSONObject paramJSONObject, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    AppMethodBeat.i(66152);
    com.tencent.mm.plugin.wallet_core.utils.g.a(this.vSC, paramdmr.HTW);
    label86:
    Object localObject;
    cxj localcxj;
    label115:
    label123:
    int i;
    if ((paramdmr.HTZ != null) && (!bu.isNullOrNil(paramdmr.HTZ.url)))
    {
      com.tencent.mm.plugin.wallet_core.utils.g.a(this.vSF, paramdmr.HTZ, 2131234606, true);
      if ((paramdmr.HTX == null) || (paramdmr.HTX.size() <= 0)) {
        break label604;
      }
      com.tencent.mm.plugin.wallet_core.utils.g.a(this.vSD, (dnl)paramdmr.HTX.get(0), null);
      if (paramdmr.HUb == null) {
        break label733;
      }
      localObject = this.vSM;
      localcxj = paramdmr.HUb;
      if ((localcxj != null) && (localObject != null)) {
        break label616;
      }
      this.vSM.setVisibility(0);
      if ((paramdmr.HTY == null) || (paramdmr.HTY.size() <= 0)) {
        break label790;
      }
      if (bu.isNullOrNil(paramString)) {
        break label751;
      }
      localObject = this.vSN;
      if (paramBoolean2) {
        break label745;
      }
      paramBoolean2 = true;
      label162:
      ((WcPayMoneyLoadingView)localObject).co(paramString, paramBoolean2);
      this.vSN.setVisibility(0);
      this.vSE.setVisibility(8);
      label188:
      if ((paramdmr.HTY == null) || (paramdmr.HTY.size() <= 1)) {
        break label876;
      }
      com.tencent.mm.plugin.wallet_core.utils.g.a(this.vSG, (dnl)paramdmr.HTY.get(1), null);
      label225:
      if ((paramdmr.HUa == null) || (paramJSONObject == null)) {
        break label1063;
      }
      this.vSP = paramdmr.HUa;
      if (paramJSONObject.optInt(paramdmr.HUa.GSV, 0) != 1) {
        break label888;
      }
      i = 1;
      label263:
      long l = paramJSONObject.optLong(String.format("%s_expiretime", new Object[] { paramdmr.HUa.GSV }), 0L);
      int j = i;
      if (l > 0L)
      {
        j = i;
        if (System.currentTimeMillis() > l)
        {
          ae.i("MicroMsg.MallWalletSectionCellView", "red dot expired: %s, %s", new Object[] { paramdmr.HUa.GSV, Long.valueOf(l) });
          j = 0;
        }
      }
      dnI();
      if (j == 0) {
        break label1056;
      }
      if (paramdmr.HUa.type != 1) {
        break label905;
      }
      if (bu.ah(this.vSE.getText())) {
        break label894;
      }
      this.vSI.setVisibility(0);
      label389:
      i = oRz;
      int k = oRz;
      j = oRz;
      int m = oRz;
      if (paramdmr.HHT != null)
      {
        paramString = paramdmr.HHT;
        if (paramString.left > 0.0F) {
          i = bk(paramString.left);
        }
        if (paramString.right > 0.0F) {
          j = bk(paramString.right);
        }
        if (paramString.top > 0.0F) {
          k = bk(paramString.top);
        }
        if (paramString.bottom > 0.0F) {
          m = bk(paramString.bottom);
        }
        this.vSL.setPadding(i, k, j, m);
      }
      if (!paramBoolean1) {
        break label1070;
      }
      this.vSD.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(66146);
          ae.d("MicroMsg.MallWalletSectionCellView", "x: %s, left: %s", new Object[] { Float.valueOf(MallWalletSectionCellView.this.vSD.getX()), Integer.valueOf(MallWalletSectionCellView.this.vSD.getLeft()) });
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 1);
          localLayoutParams.leftMargin = MallWalletSectionCellView.this.vSD.getLeft();
          MallWalletSectionCellView.this.oLk.setLayoutParams(localLayoutParams);
          MallWalletSectionCellView.this.oLk.setVisibility(0);
          AppMethodBeat.o(66146);
        }
      });
    }
    for (;;)
    {
      if (paramdmr.FLp != null) {
        setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66147);
            b localb = new b();
            localb.bd(paramAnonymousView);
            com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallWalletSectionCellView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
            com.tencent.mm.plugin.wallet_core.utils.g.a(MallWalletSectionCellView.this.getContext(), paramdmr.FLp, null);
            paramAnonymousView = new wo();
            paramAnonymousView.dLZ.aQj = paramdmr.FUn;
            com.tencent.mm.sdk.b.a.IvT.l(paramAnonymousView);
            MallWalletSectionCellView.a(MallWalletSectionCellView.this);
            if ((paramJSONObject != null) && (paramdmr.HUa != null))
            {
              paramJSONObject.remove(paramdmr.HUa.GSV);
              paramJSONObject.remove(String.format("%s_expiretime", new Object[] { paramdmr.HUa.GSV }));
              com.tencent.mm.kernel.g.ajR().ajA().set(am.a.IWL, paramJSONObject.toString());
            }
            paramAnonymousView = "";
            int i;
            if (paramdmr.FLp.type == 1)
            {
              paramAnonymousView = paramdmr.FLp.url;
              i = 1;
            }
            for (;;)
            {
              com.tencent.mm.plugin.report.service.g.yxI.f(16502, new Object[] { Integer.valueOf(2), paramAnonymousView, Integer.valueOf(i) });
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallWalletSectionCellView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(66147);
              return;
              if (paramdmr.FLp.type == 2)
              {
                if (paramdmr.FLp.HHW != null) {
                  paramAnonymousView = paramdmr.FLp.HHW.username;
                }
                i = 2;
              }
              else if (paramdmr.FLp.type == 4)
              {
                paramAnonymousView = paramdmr.FLp.url;
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
      this.vSF.setImageResource(2131690517);
      this.vSF.setColorFilter(getContext().getResources().getColor(2131099982), PorterDuff.Mode.SRC_ATOP);
      break;
      label604:
      this.vSD.setText("");
      break label86;
      label616:
      com.tencent.mm.plugin.wallet_core.utils.g.a((TextView)localObject, localcxj.Gtc, null);
      com.tencent.mm.plugin.wallet_core.utils.g.a((View)localObject, localcxj.HHT);
      i = (int)localcxj.HHV;
      if ((localcxj.HHV & 0xFF000000) == 0L) {
        i = (int)(localcxj.HHV | 0xFF000000);
      }
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setShape(0);
      if (localcxj.HHU > 0.0F) {
        localGradientDrawable.setCornerRadius(com.tencent.mm.cb.a.fromDPToPix(((TextView)localObject).getContext(), (int)localcxj.HHU));
      }
      localGradientDrawable.setColor(i);
      ((TextView)localObject).setBackground(localGradientDrawable);
      break label115;
      label733:
      this.vSM.setVisibility(8);
      break label123;
      label745:
      paramBoolean2 = false;
      break label162;
      label751:
      com.tencent.mm.plugin.wallet_core.utils.g.a(this.vSE, (dnl)paramdmr.HTY.get(0), null);
      this.vSN.setVisibility(8);
      this.vSE.setVisibility(0);
      break label188;
      label790:
      if (!bu.isNullOrNil(paramString))
      {
        paramString = this.vSN;
        if (!paramBoolean2) {}
        for (paramBoolean2 = true;; paramBoolean2 = false)
        {
          paramString.co("", paramBoolean2);
          this.vSN.setVisibility(0);
          this.vSE.setVisibility(8);
          break;
        }
      }
      this.vSE.setText("");
      this.vSN.setVisibility(8);
      this.vSE.setVisibility(0);
      break label188;
      label876:
      this.vSG.setVisibility(8);
      break label225;
      label888:
      i = 0;
      break label263;
      label894:
      this.vSH.setVisibility(0);
      break label389;
      label905:
      if (paramdmr.HUa.type == 2)
      {
        this.vSJ.setVisibility(0);
        break label389;
      }
      if (paramdmr.HUa.type == 3)
      {
        this.vSK.setText(com.tencent.mm.plugin.wallet_core.utils.g.a(getContext(), paramdmr.HUa.Gtc));
        this.vSK.setVisibility(0);
        break label389;
      }
      if (paramdmr.HUa.type == 4)
      {
        this.vSI.setVisibility(0);
        com.tencent.mm.plugin.wallet_core.utils.g.a(this.vSE, paramdmr.HUa.Gtc, null);
        paramString = this.vSN;
        paramString.setVisibility(8);
        if (paramString.jeY != null) {
          paramString.jeY.setVisibility(8);
        }
        paramString.removeCallbacks(paramString.DFh);
        break label389;
      }
      dnI();
      break label389;
      label1056:
      dnI();
      break label389;
      label1063:
      dnI();
      break label389;
      label1070:
      this.oLk.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallWalletSectionCellView
 * JD-Core Version:    0.7.0.1
 */
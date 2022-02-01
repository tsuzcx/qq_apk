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
import com.tencent.mm.g.a.vr;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bld;
import com.tencent.mm.protocal.protobuf.ccn;
import com.tencent.mm.protocal.protobuf.cnc;
import com.tencent.mm.protocal.protobuf.cri;
import com.tencent.mm.protocal.protobuf.crj;
import com.tencent.mm.protocal.protobuf.dgh;
import com.tencent.mm.protocal.protobuf.dhb;
import com.tencent.mm.protocal.protobuf.dhm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import java.util.LinkedList;
import org.json.JSONObject;

public class MallWalletSectionCellView
  extends LinearLayout
{
  private static final int ohD;
  public View khe;
  public View obp;
  public TextView uDA;
  public CdnImageView uDB;
  public TextView uDC;
  public ImageView uDD;
  public ImageView uDE;
  public TextView uDF;
  public TextView uDG;
  public ViewGroup uDH;
  public TextView uDI;
  public WcPayMoneyLoadingView uDJ;
  public ProgressBar uDK;
  private cnc uDL;
  public CdnImageView uDy;
  public TextView uDz;
  
  static
  {
    AppMethodBeat.i(66156);
    ohD = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 16);
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
  
  private int bh(float paramFloat)
  {
    AppMethodBeat.i(66153);
    int i = com.tencent.mm.cc.a.fromDPToPix(getContext(), (int)paramFloat);
    AppMethodBeat.o(66153);
    return i;
  }
  
  private void dbo()
  {
    AppMethodBeat.i(66154);
    this.uDF.setVisibility(8);
    this.uDD.setVisibility(8);
    this.uDE.setVisibility(8);
    this.uDG.setVisibility(8);
    if ((this.uDL != null) && (this.uDL.type == 4)) {
      this.uDA.setText("");
    }
    AppMethodBeat.o(66154);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(66151);
    this.khe = LayoutInflater.from(paramContext).inflate(2131494727, this, true);
    this.uDy = ((CdnImageView)this.khe.findViewById(2131302633));
    this.uDz = ((TextView)this.khe.findViewById(2131302641));
    this.uDA = ((TextView)this.khe.findViewById(2131302630));
    this.uDB = ((CdnImageView)this.khe.findViewById(2131302639));
    this.uDC = ((TextView)this.khe.findViewById(2131302640));
    this.uDD = ((ImageView)this.khe.findViewById(2131302637));
    this.uDE = ((ImageView)this.khe.findViewById(2131302638));
    this.uDF = ((TextView)this.khe.findViewById(2131302635));
    this.uDG = ((TextView)this.khe.findViewById(2131302636));
    this.obp = this.khe.findViewById(2131302631);
    this.uDH = ((ViewGroup)this.khe.findViewById(2131302634));
    this.uDI = ((TextView)this.khe.findViewById(2131302632));
    this.uDJ = ((WcPayMoneyLoadingView)this.khe.findViewById(2131302629));
    this.uDK = ((ProgressBar)this.khe.findViewById(2131306757));
    this.uDJ.setLoadingPb(this.uDK);
    setOrientation(1);
    setBackgroundResource(2131232873);
    AppMethodBeat.o(66151);
  }
  
  public final void a(final dgh paramdgh, final JSONObject paramJSONObject, boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    AppMethodBeat.i(66152);
    com.tencent.mm.plugin.wallet_core.utils.g.a(this.uDy, paramdgh.FPE);
    label86:
    Object localObject;
    cri localcri;
    label115:
    label123:
    int i;
    if ((paramdgh.FPH != null) && (!bs.isNullOrNil(paramdgh.FPH.url)))
    {
      com.tencent.mm.plugin.wallet_core.utils.g.a(this.uDB, paramdgh.FPH, 2131234606, true);
      if ((paramdgh.FPF == null) || (paramdgh.FPF.size() <= 0)) {
        break label604;
      }
      com.tencent.mm.plugin.wallet_core.utils.g.a(this.uDz, (dhb)paramdgh.FPF.get(0), null);
      if (paramdgh.FPJ == null) {
        break label733;
      }
      localObject = this.uDI;
      localcri = paramdgh.FPJ;
      if ((localcri != null) && (localObject != null)) {
        break label616;
      }
      this.uDI.setVisibility(0);
      if ((paramdgh.FPG == null) || (paramdgh.FPG.size() <= 0)) {
        break label790;
      }
      if (bs.isNullOrNil(paramString)) {
        break label751;
      }
      localObject = this.uDJ;
      if (paramBoolean2) {
        break label745;
      }
      paramBoolean2 = true;
      label162:
      ((WcPayMoneyLoadingView)localObject).cc(paramString, paramBoolean2);
      this.uDJ.setVisibility(0);
      this.uDA.setVisibility(8);
      label188:
      if ((paramdgh.FPG == null) || (paramdgh.FPG.size() <= 1)) {
        break label876;
      }
      com.tencent.mm.plugin.wallet_core.utils.g.a(this.uDC, (dhb)paramdgh.FPG.get(1), null);
      label225:
      if ((paramdgh.FPI == null) || (paramJSONObject == null)) {
        break label1063;
      }
      this.uDL = paramdgh.FPI;
      if (paramJSONObject.optInt(paramdgh.FPI.EQe, 0) != 1) {
        break label888;
      }
      i = 1;
      label263:
      long l = paramJSONObject.optLong(String.format("%s_expiretime", new Object[] { paramdgh.FPI.EQe }), 0L);
      int j = i;
      if (l > 0L)
      {
        j = i;
        if (System.currentTimeMillis() > l)
        {
          ac.i("MicroMsg.MallWalletSectionCellView", "red dot expired: %s, %s", new Object[] { paramdgh.FPI.EQe, Long.valueOf(l) });
          j = 0;
        }
      }
      dbo();
      if (j == 0) {
        break label1056;
      }
      if (paramdgh.FPI.type != 1) {
        break label905;
      }
      if (bs.aj(this.uDA.getText())) {
        break label894;
      }
      this.uDE.setVisibility(0);
      label389:
      i = ohD;
      int k = ohD;
      j = ohD;
      int m = ohD;
      if (paramdgh.FEc != null)
      {
        paramString = paramdgh.FEc;
        if (paramString.left > 0.0F) {
          i = bh(paramString.left);
        }
        if (paramString.right > 0.0F) {
          j = bh(paramString.right);
        }
        if (paramString.top > 0.0F) {
          k = bh(paramString.top);
        }
        if (paramString.bottom > 0.0F) {
          m = bh(paramString.bottom);
        }
        this.uDH.setPadding(i, k, j, m);
      }
      if (!paramBoolean1) {
        break label1070;
      }
      this.uDz.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(66146);
          ac.d("MicroMsg.MallWalletSectionCellView", "x: %s, left: %s", new Object[] { Float.valueOf(MallWalletSectionCellView.this.uDz.getX()), Integer.valueOf(MallWalletSectionCellView.this.uDz.getLeft()) });
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 1);
          localLayoutParams.leftMargin = MallWalletSectionCellView.this.uDz.getLeft();
          MallWalletSectionCellView.this.obp.setLayoutParams(localLayoutParams);
          MallWalletSectionCellView.this.obp.setVisibility(0);
          AppMethodBeat.o(66146);
        }
      });
    }
    for (;;)
    {
      if (paramdgh.DNL != null) {
        setOnClickListener(new View.OnClickListener()
        {
          public final void onClick(View paramAnonymousView)
          {
            AppMethodBeat.i(66147);
            com.tencent.mm.plugin.wallet_core.utils.g.a(MallWalletSectionCellView.this.getContext(), paramdgh.DNL, null);
            paramAnonymousView = new vr();
            paramAnonymousView.dyx.dyy = paramdgh.DWw;
            com.tencent.mm.sdk.b.a.GpY.l(paramAnonymousView);
            MallWalletSectionCellView.a(MallWalletSectionCellView.this);
            if ((paramJSONObject != null) && (paramdgh.FPI != null))
            {
              paramJSONObject.remove(paramdgh.FPI.EQe);
              paramJSONObject.remove(String.format("%s_expiretime", new Object[] { paramdgh.FPI.EQe }));
              com.tencent.mm.kernel.g.agR().agA().set(ah.a.GPR, paramJSONObject.toString());
            }
            paramAnonymousView = "";
            int i;
            if (paramdgh.DNL.type == 1)
            {
              paramAnonymousView = paramdgh.DNL.url;
              i = 1;
            }
            for (;;)
            {
              h.wUl.f(16502, new Object[] { Integer.valueOf(2), paramAnonymousView, Integer.valueOf(i) });
              AppMethodBeat.o(66147);
              return;
              if (paramdgh.DNL.type == 2)
              {
                if (paramdgh.DNL.FEf != null) {
                  paramAnonymousView = paramdgh.DNL.FEf.username;
                }
                i = 2;
              }
              else if (paramdgh.DNL.type == 4)
              {
                paramAnonymousView = paramdgh.DNL.url;
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
      this.uDB.setImageResource(2131690517);
      this.uDB.setColorFilter(getContext().getResources().getColor(2131099982), PorterDuff.Mode.SRC_ATOP);
      break;
      label604:
      this.uDz.setText("");
      break label86;
      label616:
      com.tencent.mm.plugin.wallet_core.utils.g.a((TextView)localObject, localcri.Ete, null);
      com.tencent.mm.plugin.wallet_core.utils.g.a((View)localObject, localcri.FEc);
      i = (int)localcri.FEe;
      if ((localcri.FEe & 0xFF000000) == 0L) {
        i = (int)(localcri.FEe | 0xFF000000);
      }
      GradientDrawable localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setShape(0);
      if (localcri.FEd > 0.0F) {
        localGradientDrawable.setCornerRadius(com.tencent.mm.cc.a.fromDPToPix(((TextView)localObject).getContext(), (int)localcri.FEd));
      }
      localGradientDrawable.setColor(i);
      ((TextView)localObject).setBackground(localGradientDrawable);
      break label115;
      label733:
      this.uDI.setVisibility(8);
      break label123;
      label745:
      paramBoolean2 = false;
      break label162;
      label751:
      com.tencent.mm.plugin.wallet_core.utils.g.a(this.uDA, (dhb)paramdgh.FPG.get(0), null);
      this.uDJ.setVisibility(8);
      this.uDA.setVisibility(0);
      break label188;
      label790:
      if (!bs.isNullOrNil(paramString))
      {
        paramString = this.uDJ;
        if (!paramBoolean2) {}
        for (paramBoolean2 = true;; paramBoolean2 = false)
        {
          paramString.cc("", paramBoolean2);
          this.uDJ.setVisibility(0);
          this.uDA.setVisibility(8);
          break;
        }
      }
      this.uDA.setText("");
      this.uDJ.setVisibility(8);
      this.uDA.setVisibility(0);
      break label188;
      label876:
      this.uDC.setVisibility(8);
      break label225;
      label888:
      i = 0;
      break label263;
      label894:
      this.uDD.setVisibility(0);
      break label389;
      label905:
      if (paramdgh.FPI.type == 2)
      {
        this.uDF.setVisibility(0);
        break label389;
      }
      if (paramdgh.FPI.type == 3)
      {
        this.uDG.setText(com.tencent.mm.plugin.wallet_core.utils.g.a(getContext(), paramdgh.FPI.Ete));
        this.uDG.setVisibility(0);
        break label389;
      }
      if (paramdgh.FPI.type == 4)
      {
        this.uDE.setVisibility(0);
        com.tencent.mm.plugin.wallet_core.utils.g.a(this.uDA, paramdgh.FPI.Ete, null);
        paramString = this.uDJ;
        paramString.setVisibility(8);
        if (paramString.iIW != null) {
          paramString.iIW.setVisibility(8);
        }
        paramString.removeCallbacks(paramString.BNk);
        break label389;
      }
      dbo();
      break label389;
      label1056:
      dbo();
      break label389;
      label1063:
      dbo();
      break label389;
      label1070:
      this.obp.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallWalletSectionCellView
 * JD-Core Version:    0.7.0.1
 */
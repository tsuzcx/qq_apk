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
import com.tencent.mm.an.c.a;
import com.tencent.mm.f.a.yv;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.api.i;
import com.tencent.mm.plugin.wallet.balance.model.lqt.q;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.plugin.wallet_core.utils.k;
import com.tencent.mm.plugin.wallet_core.utils.k.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.clc;
import com.tencent.mm.protocal.protobuf.def;
import com.tencent.mm.protocal.protobuf.dhr;
import com.tencent.mm.protocal.protobuf.dvh;
import com.tencent.mm.protocal.protobuf.dzz;
import com.tencent.mm.protocal.protobuf.eaa;
import com.tencent.mm.protocal.protobuf.eqh;
import com.tencent.mm.protocal.protobuf.erh;
import com.tencent.mm.protocal.protobuf.erw;
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
  private static final int tBk;
  public CdnImageView ERY;
  public TextView ERZ;
  public TextView ESa;
  public CdnImageView ESb;
  public TextView ESc;
  public ImageView ESd;
  public ImageView ESe;
  public TextView ESf;
  public TextView ESg;
  public ViewGroup ESh;
  public TextView ESi;
  public WcPayMoneyLoadingView ESj;
  public ProgressBar ESk;
  private dvh ESl;
  public View oFW;
  public View tuU;
  
  static
  {
    AppMethodBeat.i(66156);
    tBk = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 16);
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
  
  private int bw(float paramFloat)
  {
    AppMethodBeat.i(66153);
    int i = com.tencent.mm.ci.a.fromDPToPix(getContext(), (int)paramFloat);
    AppMethodBeat.o(66153);
    return i;
  }
  
  private void eRb()
  {
    AppMethodBeat.i(66154);
    this.ESf.setVisibility(8);
    this.ESd.setVisibility(8);
    this.ESe.setVisibility(8);
    this.ESg.setVisibility(8);
    if ((this.ESl != null) && (this.ESl.type == 4)) {
      this.ESa.setText("");
    }
    AppMethodBeat.o(66154);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(66151);
    this.oFW = LayoutInflater.from(paramContext).inflate(a.g.mall_wallet_section_cell_layout, this, true);
    this.ERY = ((CdnImageView)this.oFW.findViewById(a.f.mwsc_logo_iv));
    this.ERZ = ((TextView)this.oFW.findViewById(a.f.mwsc_title_tv));
    this.ESa = ((TextView)this.oFW.findViewById(a.f.mwsc_desc_tv));
    this.ESb = ((CdnImageView)this.oFW.findViewById(a.f.mwsc_right_iv));
    this.ESc = ((TextView)this.oFW.findViewById(a.f.mwsc_tips_tv));
    this.ESd = ((ImageView)this.oFW.findViewById(a.f.mwsc_reddot1_iv));
    this.ESe = ((ImageView)this.oFW.findViewById(a.f.mwsc_reddot2_iv));
    this.ESf = ((TextView)this.oFW.findViewById(a.f.mwsc_newdot_tv));
    this.ESg = ((TextView)this.oFW.findViewById(a.f.mwsc_numdot_tv));
    this.tuU = this.oFW.findViewById(a.f.mwsc_divider_view);
    this.ESh = ((ViewGroup)this.oFW.findViewById(a.f.mwsc_main_layout));
    this.ESi = ((TextView)this.oFW.findViewById(a.f.mwsc_label_tv));
    this.ESj = ((WcPayMoneyLoadingView)this.oFW.findViewById(a.f.mwsc_desc_layout));
    this.ESk = ((ProgressBar)this.oFW.findViewById(a.f.wallet_money_load_pb));
    this.ESj.setLoadingPb(this.ESk);
    setOrientation(1);
    setBackgroundResource(a.e.list_item_white_selector_bg);
    AppMethodBeat.o(66151);
  }
  
  public final void a(final eqh parameqh, final JSONObject paramJSONObject, boolean paramBoolean1, String paramString, boolean paramBoolean2, final i parami, final k.b paramb)
  {
    AppMethodBeat.i(293133);
    k.a(this.ERY, parameqh.UsJ);
    label87:
    Object localObject;
    dzz localdzz;
    label116:
    label124:
    long l;
    if ((parameqh.UsM != null) && (!Util.isNullOrNil(parameqh.UsM.url)))
    {
      k.a(this.ESb, parameqh.UsM, a.e.wallet_arrow, true);
      if ((parameqh.UsK == null) || (parameqh.UsK.size() <= 0)) {
        break label715;
      }
      k.a(this.ERZ, (erh)parameqh.UsK.get(0), null);
      if (parameqh.UsN == null) {
        break label844;
      }
      localObject = this.ESi;
      localdzz = parameqh.UsN;
      if ((localdzz != null) && (localObject != null)) {
        break label727;
      }
      this.ESi.setVisibility(0);
      if ((parameqh.UsL == null) || (parameqh.UsL.size() <= 0)) {
        break label901;
      }
      if (Util.isNullOrNil(paramString)) {
        break label862;
      }
      localObject = this.ESj;
      if (paramBoolean2) {
        break label856;
      }
      paramBoolean2 = true;
      label163:
      ((WcPayMoneyLoadingView)localObject).cV(paramString, paramBoolean2);
      this.ESj.setVisibility(0);
      this.ESa.setVisibility(8);
      label189:
      if ((parameqh.UsL == null) || (parameqh.UsL.size() <= 1)) {
        break label987;
      }
      k.a(this.ESc, (erh)parameqh.UsL.get(1), null);
      label226:
      eRb();
      if ((parameqh.TJH != null) && (paramJSONObject != null))
      {
        this.ESl = parameqh.TJH;
        if (paramJSONObject.optInt(parameqh.TJH.Ubm, 0) != 1) {
          break label999;
        }
        paramBoolean2 = true;
        label268:
        l = paramJSONObject.optLong(String.format("%s_expiretime", new Object[] { parameqh.TJH.Ubm }), 0L);
        if ((l <= 0L) || (System.currentTimeMillis() <= l)) {
          break label1225;
        }
      }
    }
    label456:
    label1225:
    for (boolean bool = false;; bool = paramBoolean2)
    {
      Log.i("MicroMsg.MallWalletSectionCellView", "red dot expired: %s, %s, %s, %s, %s", new Object[] { parameqh.TJH.Ubm, Long.valueOf(l), Boolean.valueOf(paramBoolean2), Boolean.valueOf(bool), Integer.valueOf(parameqh.TJH.type) });
      if ((paramBoolean2) && (!bool)) {
        com.tencent.mm.plugin.report.service.h.IzE.a(22735, new Object[] { parameqh.TJH.Ubm, Integer.valueOf(2), "" });
      }
      label496:
      int i;
      if (bool)
      {
        if (parameqh.TJH.type != 1) {
          break label1016;
        }
        if (!Util.isNullOrNil(this.ESa.getText()))
        {
          this.ESe.setVisibility(0);
          if (!bool) {
            break label1174;
          }
          com.tencent.mm.plugin.report.service.h.IzE.a(22735, new Object[] { parameqh.TJH.Ubm, Integer.valueOf(1), "" });
        }
      }
      else
      {
        i = tBk;
        int k = tBk;
        int j = tBk;
        int m = tBk;
        if (parameqh.Ufm != null)
        {
          paramString = parameqh.Ufm;
          if (paramString.left > 0.0F) {
            i = bw(paramString.left);
          }
          if (paramString.right > 0.0F) {
            j = bw(paramString.right);
          }
          if (paramString.top > 0.0F) {
            k = bw(paramString.top);
          }
          if (paramString.bottom > 0.0F) {
            m = bw(paramString.bottom);
          }
          this.ESh.setPadding(i, k, j, m);
        }
        if (!paramBoolean1) {
          break label1213;
        }
        this.ERZ.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66146);
            Log.d("MicroMsg.MallWalletSectionCellView", "x: %s, left: %s", new Object[] { Float.valueOf(MallWalletSectionCellView.this.ERZ.getX()), Integer.valueOf(MallWalletSectionCellView.this.ERZ.getLeft()) });
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 1);
            localLayoutParams.leftMargin = MallWalletSectionCellView.this.ERZ.getLeft();
            MallWalletSectionCellView.this.tuU.setLayoutParams(localLayoutParams);
            MallWalletSectionCellView.this.tuU.setVisibility(0);
            AppMethodBeat.o(66146);
          }
        });
      }
      for (;;)
      {
        if (parameqh.RGh != null) {
          setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(66147);
              Object localObject = new b();
              ((b)localObject).bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mall/ui/MallWalletSectionCellView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
              paramAnonymousView = new Bundle();
              paramAnonymousView.putInt("key_tiny_app_scene", 1019);
              k.a(MallWalletSectionCellView.this.getContext(), parameqh.RGh, paramAnonymousView, parami, paramb);
              paramAnonymousView = new yv();
              paramAnonymousView.fYd.viewId = parameqh.ROQ;
              EventCenter.instance.publish(paramAnonymousView);
              MallWalletSectionCellView.a(MallWalletSectionCellView.this);
              if ((paramJSONObject != null) && (parameqh.TJH != null) && (!Util.isNullOrNil(parameqh.TJH.Ubm)))
              {
                paramJSONObject.remove(parameqh.TJH.Ubm);
                paramJSONObject.remove(String.format("%s_expiretime", new Object[] { parameqh.TJH.Ubm }));
                com.tencent.mm.kernel.h.aHG().aHp().set(ar.a.Vtp, paramJSONObject.toString());
                com.tencent.mm.plugin.report.service.h.IzE.a(22735, new Object[] { parameqh.TJH.Ubm, Integer.valueOf(3), "" });
                if ("Lqt".equals(parameqh.TJH.Ubm))
                {
                  paramAnonymousView = MallWalletSectionCellView.this;
                  localObject = parameqh.TJH.Ubm;
                  Log.i("MicroMsg.MallWalletSectionCellView", "lqtOnClickRedDotReq, redDotID: %s", new Object[] { localObject });
                  new q((String)localObject).bhW().h(new MallWalletSectionCellView.3(paramAnonymousView));
                }
              }
              paramAnonymousView = "";
              int i;
              if (parameqh.RGh.type == 1)
              {
                paramAnonymousView = parameqh.RGh.url;
                i = 1;
              }
              for (;;)
              {
                com.tencent.mm.plugin.report.service.h.IzE.a(16502, new Object[] { Integer.valueOf(2), paramAnonymousView, Integer.valueOf(i) });
                com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallWalletSectionCellView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                AppMethodBeat.o(66147);
                return;
                if (parameqh.RGh.type == 2)
                {
                  if (parameqh.RGh.Ufp != null) {
                    paramAnonymousView = parameqh.RGh.Ufp.username;
                  }
                  i = 2;
                }
                else if (parameqh.RGh.type == 4)
                {
                  paramAnonymousView = parameqh.RGh.url;
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
        AppMethodBeat.o(293133);
        return;
        this.ESb.setImageResource(a.h.icons_outlined_arrow);
        this.ESb.setColorFilter(getContext().getResources().getColor(a.c.arrow_color), PorterDuff.Mode.SRC_ATOP);
        break;
        label715:
        this.ERZ.setText("");
        break label87;
        label727:
        k.a((TextView)localObject, localdzz.SpR, null);
        k.a((View)localObject, localdzz.Ufm);
        i = (int)localdzz.Ufo;
        if ((localdzz.Ufo & 0xFF000000) == 0L) {
          i = (int)(localdzz.Ufo | 0xFF000000);
        }
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setShape(0);
        if (localdzz.Ufn > 0.0F) {
          localGradientDrawable.setCornerRadius(com.tencent.mm.ci.a.fromDPToPix(((TextView)localObject).getContext(), (int)localdzz.Ufn));
        }
        localGradientDrawable.setColor(i);
        ((TextView)localObject).setBackground(localGradientDrawable);
        break label116;
        label844:
        this.ESi.setVisibility(8);
        break label124;
        label856:
        paramBoolean2 = false;
        break label163;
        label862:
        k.a(this.ESa, (erh)parameqh.UsL.get(0), null);
        this.ESj.setVisibility(8);
        this.ESa.setVisibility(0);
        break label189;
        if (!Util.isNullOrNil(paramString))
        {
          paramString = this.ESj;
          if (!paramBoolean2) {}
          for (paramBoolean2 = true;; paramBoolean2 = false)
          {
            paramString.cV("", paramBoolean2);
            this.ESj.setVisibility(0);
            this.ESa.setVisibility(8);
            break;
          }
        }
        this.ESa.setText("");
        this.ESj.setVisibility(8);
        this.ESa.setVisibility(0);
        break label189;
        label987:
        this.ESc.setVisibility(8);
        break label226;
        label999:
        paramBoolean2 = false;
        break label268;
        this.ESd.setVisibility(0);
        break label456;
        label1016:
        if (parameqh.TJH.type == 2)
        {
          this.ESf.setVisibility(0);
          break label456;
        }
        if (parameqh.TJH.type == 3)
        {
          this.ESg.setText(k.a(getContext(), parameqh.TJH.SpR));
          this.ESg.setVisibility(0);
          break label456;
        }
        if (parameqh.TJH.type == 4)
        {
          this.ESe.setVisibility(0);
          this.ESa.setVisibility(0);
          k.a(this.ESa, parameqh.TJH.SpR, null);
          paramString = this.ESj;
          paramString.setVisibility(8);
          if (paramString.mUB != null) {
            paramString.mUB.setVisibility(8);
          }
          paramString.removeCallbacks(paramString.PgK);
          break label456;
        }
        bool = false;
        break label456;
        com.tencent.mm.plugin.report.service.h.IzE.a(22735, new Object[] { parameqh.TJH.Ubm, Integer.valueOf(0), "Red Dot Type returned by server is invalid." });
        break label496;
        this.tuU.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallWalletSectionCellView
 * JD-Core Version:    0.7.0.1
 */
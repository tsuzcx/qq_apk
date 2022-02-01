package com.tencent.mm.plugin.mall.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.autogen.a.aao;
import com.tencent.mm.ce.b;
import com.tencent.mm.plugin.appbrand.api.i;
import com.tencent.mm.plugin.wallet.balance.model.lqt.r;
import com.tencent.mm.plugin.wallet_core.ui.view.WcPayMoneyLoadingView;
import com.tencent.mm.plugin.wallet_core.utils.n;
import com.tencent.mm.plugin.wallet_core.utils.n.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.h;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.dbk;
import com.tencent.mm.protocal.protobuf.dwe;
import com.tencent.mm.protocal.protobuf.eab;
import com.tencent.mm.protocal.protobuf.eod;
import com.tencent.mm.protocal.protobuf.etf;
import com.tencent.mm.protocal.protobuf.etg;
import com.tencent.mm.protocal.protobuf.fll;
import com.tencent.mm.protocal.protobuf.fml;
import com.tencent.mm.protocal.protobuf.fmp;
import com.tencent.mm.protocal.protobuf.fnf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.wallet_core.ui.k;
import java.util.LinkedList;
import org.json.JSONObject;

public class MallWalletSectionCellView
  extends LinearLayout
{
  private static final int wFJ;
  public TextView KMA;
  public TextView KMB;
  public CdnImageView KMC;
  public TextView KMD;
  public ImageView KME;
  public ImageView KMF;
  public TextView KMG;
  public TextView KMH;
  public ViewGroup KMI;
  public TextView KMJ;
  public WcPayMoneyLoadingView KMK;
  public ProgressBar KML;
  private eod KMM;
  public CdnImageView KMz;
  public View rootView;
  public View wzr;
  
  static
  {
    AppMethodBeat.i(66156);
    wFJ = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 16);
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
  
  private int cA(float paramFloat)
  {
    AppMethodBeat.i(66153);
    int i = com.tencent.mm.cd.a.fromDPToPix(getContext(), (int)paramFloat);
    AppMethodBeat.o(66153);
    return i;
  }
  
  private void fZJ()
  {
    AppMethodBeat.i(66154);
    this.KMG.setVisibility(8);
    this.KME.setVisibility(8);
    this.KMF.setVisibility(8);
    this.KMH.setVisibility(8);
    if ((this.KMM != null) && (this.KMM.type == 4)) {
      this.KMB.setText("");
    }
    AppMethodBeat.o(66154);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(66151);
    this.rootView = LayoutInflater.from(paramContext).inflate(a.g.mall_wallet_section_cell_layout, this, true);
    this.KMz = ((CdnImageView)this.rootView.findViewById(a.f.mwsc_logo_iv));
    this.KMA = ((TextView)this.rootView.findViewById(a.f.mwsc_title_tv));
    this.KMB = ((TextView)this.rootView.findViewById(a.f.mwsc_desc_tv));
    this.KMC = ((CdnImageView)this.rootView.findViewById(a.f.mwsc_right_iv));
    this.KMD = ((TextView)this.rootView.findViewById(a.f.mwsc_tips_tv));
    this.KME = ((ImageView)this.rootView.findViewById(a.f.mwsc_reddot1_iv));
    this.KME.setContentDescription(paramContext.getString(a.i.accessibility_wallet_new_function_text));
    this.KMF = ((ImageView)this.rootView.findViewById(a.f.mwsc_reddot2_iv));
    this.KMG = ((TextView)this.rootView.findViewById(a.f.mwsc_newdot_tv));
    this.KMG.setContentDescription(paramContext.getString(a.i.accessibility_wallet_new_function_text));
    this.KMH = ((TextView)this.rootView.findViewById(a.f.mwsc_numdot_tv));
    this.wzr = this.rootView.findViewById(a.f.mwsc_divider_view);
    this.KMI = ((ViewGroup)this.rootView.findViewById(a.f.mwsc_main_layout));
    this.KMJ = ((TextView)this.rootView.findViewById(a.f.mwsc_label_tv));
    this.KMK = ((WcPayMoneyLoadingView)this.rootView.findViewById(a.f.mwsc_desc_layout));
    this.KML = ((ProgressBar)this.rootView.findViewById(a.f.wallet_money_load_pb));
    this.KMK.setLoadingPb(this.KML);
    setOrientation(1);
    setBackgroundResource(a.e.list_item_white_selector_bg);
    AppMethodBeat.o(66151);
  }
  
  public final void a(final fll paramfll, final JSONObject paramJSONObject, boolean paramBoolean1, String paramString, boolean paramBoolean2, final i parami, final n.b paramb)
  {
    AppMethodBeat.i(262459);
    n.a(this.KMz, paramfll.abLR);
    label87:
    Object localObject;
    etf localetf;
    label207:
    label215:
    label254:
    long l;
    if ((paramfll.abLU != null) && (!Util.isNullOrNil(paramfll.abLU.url)))
    {
      n.a(this.KMC, paramfll.abLU, a.e.wallet_arrow, true);
      if ((paramfll.abLS == null) || (paramfll.abLS.size() <= 0)) {
        break label793;
      }
      n.a(this.KMA, (fmp)paramfll.abLS.get(0), null);
      if (paramfll.abLV == null) {
        break label922;
      }
      if ((b.iRp()) && (paramfll.abLV.ZoM != null) && (paramfll.abLV.ZoM.abMT != null) && (paramfll.abLV.ZoM.abMT.size() > 0))
      {
        localObject = (fml)paramfll.abLV.ZoM.abMT.get(0);
        if (((fml)localObject).abMI != null)
        {
          ((fml)localObject).abMI.Zss = 4292966169L;
          ((fml)localObject).ayn = 4292966169L;
        }
      }
      localObject = this.KMJ;
      localetf = paramfll.abLV;
      if ((localetf != null) && (localObject != null)) {
        break label805;
      }
      this.KMJ.setVisibility(0);
      if ((paramfll.abLT == null) || (paramfll.abLT.size() <= 0)) {
        break label979;
      }
      if (Util.isNullOrNil(paramString)) {
        break label940;
      }
      localObject = this.KMK;
      if (paramBoolean2) {
        break label934;
      }
      paramBoolean2 = true;
      ((WcPayMoneyLoadingView)localObject).dD(paramString, paramBoolean2);
      this.KMK.setVisibility(0);
      this.KMB.setVisibility(8);
      label280:
      if ((paramfll.abLT == null) || (paramfll.abLT.size() <= 1)) {
        break label1065;
      }
      n.a(this.KMD, (fmp)paramfll.abLT.get(1), null);
      label317:
      fZJ();
      if ((paramfll.aaZw != null) && (paramJSONObject != null))
      {
        this.KMM = paramfll.aaZw;
        if (paramJSONObject.optInt(paramfll.aaZw.abst, 0) != 1) {
          break label1077;
        }
        paramBoolean2 = true;
        label359:
        l = paramJSONObject.optLong(String.format("%s_expiretime", new Object[] { paramfll.aaZw.abst }), 0L);
        if ((l <= 0L) || (System.currentTimeMillis() <= l)) {
          break label1323;
        }
      }
    }
    label534:
    label793:
    label805:
    label934:
    label1065:
    label1323:
    for (boolean bool = false;; bool = paramBoolean2)
    {
      Log.i("MicroMsg.MallWalletSectionCellView", "red dot expired: %s, %s, %s, %s, %s", new Object[] { paramfll.aaZw.abst, Long.valueOf(l), Boolean.valueOf(paramBoolean2), Boolean.valueOf(bool), Integer.valueOf(paramfll.aaZw.type) });
      if ((paramBoolean2) && (!bool)) {
        com.tencent.mm.plugin.report.service.h.OAn.b(22735, new Object[] { paramfll.aaZw.abst, Integer.valueOf(2), "" });
      }
      label574:
      int i;
      if (bool)
      {
        if (paramfll.aaZw.type == 1)
        {
          this.KME.setVisibility(0);
          if (!bool) {
            break label1272;
          }
          com.tencent.mm.plugin.report.service.h.OAn.b(22735, new Object[] { paramfll.aaZw.abst, Integer.valueOf(1), "" });
        }
      }
      else
      {
        i = wFJ;
        int k = wFJ;
        int j = wFJ;
        int m = wFJ;
        if (paramfll.abwz != null)
        {
          paramString = paramfll.abwz;
          if (paramString.left > 0.0F) {
            i = cA(paramString.left);
          }
          if (paramString.right > 0.0F) {
            j = cA(paramString.right);
          }
          if (paramString.top > 0.0F) {
            k = cA(paramString.top);
          }
          if (paramString.bottom > 0.0F) {
            m = cA(paramString.bottom);
          }
          this.KMI.setPadding(i, k, j, m);
        }
        if (!paramBoolean1) {
          break label1311;
        }
        this.KMA.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(66146);
            Log.d("MicroMsg.MallWalletSectionCellView", "x: %s, left: %s", new Object[] { Float.valueOf(MallWalletSectionCellView.this.KMA.getX()), Integer.valueOf(MallWalletSectionCellView.this.KMA.getLeft()) });
            LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, 1);
            localLayoutParams.leftMargin = MallWalletSectionCellView.this.KMA.getLeft();
            MallWalletSectionCellView.this.wzr.setLayoutParams(localLayoutParams);
            MallWalletSectionCellView.this.wzr.setVisibility(0);
            AppMethodBeat.o(66146);
          }
        });
      }
      for (;;)
      {
        if (paramfll.YCV != null) {
          setOnClickListener(new k()
          {
            public final void dr(View paramAnonymousView)
            {
              AppMethodBeat.i(262444);
              paramAnonymousView = new Bundle();
              paramAnonymousView.putInt("key_tiny_app_scene", 1019);
              paramAnonymousView.putString("realname_verify_process_jump_plugin", "mall");
              paramAnonymousView.putString("realname_verify_process_jump_activity", ".ui.MallWalletUI");
              n.a(MallWalletSectionCellView.this.getContext(), paramfll.YCV, paramAnonymousView, parami, paramb);
              paramAnonymousView = new aao();
              paramAnonymousView.ied.viewId = paramfll.YMe;
              paramAnonymousView.publish();
              MallWalletSectionCellView.a(MallWalletSectionCellView.this);
              if ((paramJSONObject != null) && (paramfll.aaZw != null) && (!Util.isNullOrNil(paramfll.aaZw.abst)))
              {
                paramJSONObject.remove(paramfll.aaZw.abst);
                paramJSONObject.remove(String.format("%s_expiretime", new Object[] { paramfll.aaZw.abst }));
                com.tencent.mm.kernel.h.baE().ban().set(at.a.acUU, paramJSONObject.toString());
                com.tencent.mm.plugin.report.service.h.OAn.b(22735, new Object[] { paramfll.aaZw.abst, Integer.valueOf(3), "" });
                if ("Lqt".equals(paramfll.aaZw.abst))
                {
                  paramAnonymousView = MallWalletSectionCellView.this;
                  String str = paramfll.aaZw.abst;
                  Log.i("MicroMsg.MallWalletSectionCellView", "lqtOnClickRedDotReq, redDotID: %s", new Object[] { str });
                  new r(str).bFJ().h(new MallWalletSectionCellView.3(paramAnonymousView));
                }
              }
              paramAnonymousView = "";
              int i;
              if (paramfll.YCV.type == 1)
              {
                paramAnonymousView = paramfll.YCV.url;
                i = 1;
              }
              for (;;)
              {
                com.tencent.mm.plugin.report.service.h.OAn.b(16502, new Object[] { Integer.valueOf(2), paramAnonymousView, Integer.valueOf(i) });
                AppMethodBeat.o(262444);
                return;
                if (paramfll.YCV.type == 2)
                {
                  if (paramfll.YCV.abwC != null) {
                    paramAnonymousView = paramfll.YCV.abwC.username;
                  }
                  i = 2;
                }
                else if (paramfll.YCV.type == 4)
                {
                  paramAnonymousView = paramfll.YCV.url;
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
        AppMethodBeat.o(262459);
        return;
        this.KMC.setImageResource(a.h.icons_outlined_arrow);
        this.KMC.setColorFilter(getContext().getResources().getColor(a.c.arrow_color), PorterDuff.Mode.SRC_ATOP);
        break;
        this.KMA.setText("");
        break label87;
        n.a((TextView)localObject, localetf.ZoM, null);
        n.a((View)localObject, localetf.abwz);
        i = (int)localetf.abwB;
        if ((localetf.abwB & 0xFF000000) == 0L) {
          i = (int)(localetf.abwB | 0xFF000000);
        }
        GradientDrawable localGradientDrawable = new GradientDrawable();
        localGradientDrawable.setShape(0);
        if (localetf.abwA > 0.0F) {
          localGradientDrawable.setCornerRadius(com.tencent.mm.cd.a.fromDPToPix(((TextView)localObject).getContext(), (int)localetf.abwA));
        }
        localGradientDrawable.setColor(i);
        ((TextView)localObject).setBackground(localGradientDrawable);
        break label207;
        this.KMJ.setVisibility(8);
        break label215;
        paramBoolean2 = false;
        break label254;
        label940:
        n.a(this.KMB, (fmp)paramfll.abLT.get(0), null);
        this.KMK.setVisibility(8);
        this.KMB.setVisibility(0);
        break label280;
        label979:
        if (!Util.isNullOrNil(paramString))
        {
          paramString = this.KMK;
          if (!paramBoolean2) {}
          for (paramBoolean2 = true;; paramBoolean2 = false)
          {
            paramString.dD("", paramBoolean2);
            this.KMK.setVisibility(0);
            this.KMB.setVisibility(8);
            break;
          }
        }
        this.KMB.setText("");
        this.KMK.setVisibility(8);
        this.KMB.setVisibility(0);
        break label280;
        this.KMD.setVisibility(8);
        break label317;
        label1077:
        paramBoolean2 = false;
        break label359;
        if (paramfll.aaZw.type == 2)
        {
          this.KMG.setVisibility(0);
          break label534;
        }
        if (paramfll.aaZw.type == 3)
        {
          this.KMH.setText(n.a(getContext(), paramfll.aaZw.ZoM));
          this.KMH.setContentDescription(getContext().getString(a.i.accessibility_wallet_unread_function_text, new Object[] { this.KMH.getText() }));
          this.KMH.setVisibility(0);
          break label534;
        }
        if (paramfll.aaZw.type == 4)
        {
          this.KMF.setVisibility(0);
          this.KMB.setVisibility(0);
          n.a(this.KMB, paramfll.aaZw.ZoM, null);
          paramString = this.KMK;
          paramString.setVisibility(8);
          if (paramString.pRi != null) {
            paramString.pRi.setVisibility(8);
          }
          paramString.removeCallbacks(paramString.VXx);
          break label534;
        }
        bool = false;
        break label534;
        label1272:
        com.tencent.mm.plugin.report.service.h.OAn.b(22735, new Object[] { paramfll.aaZw.abst, Integer.valueOf(0), "Red Dot Type returned by server is invalid." });
        break label574;
        this.wzr.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallWalletSectionCellView
 * JD-Core Version:    0.7.0.1
 */
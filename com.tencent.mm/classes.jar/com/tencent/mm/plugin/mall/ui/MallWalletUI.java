package com.tencent.mm.plugin.mall.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.app.f;
import com.tencent.mm.autogen.a.aao;
import com.tencent.mm.autogen.a.acx;
import com.tencent.mm.autogen.a.acx.b;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.service.t;
import com.tencent.mm.plugin.mall.a.j;
import com.tencent.mm.plugin.mall.a.j.a;
import com.tencent.mm.plugin.wallet_core.utils.n;
import com.tencent.mm.plugin.wallet_core.utils.n.4;
import com.tencent.mm.plugin.wallet_core.utils.n.5;
import com.tencent.mm.plugin.wallet_core.utils.n.6;
import com.tencent.mm.plugin.wallet_core.utils.n.7;
import com.tencent.mm.plugin.wallet_core.utils.n.8;
import com.tencent.mm.plugin.wallet_core.utils.n.9;
import com.tencent.mm.plugin.wallet_core.utils.n.a;
import com.tencent.mm.plugin.wallet_core.utils.n.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.afw;
import com.tencent.mm.protocal.protobuf.ahk;
import com.tencent.mm.protocal.protobuf.ddc;
import com.tencent.mm.protocal.protobuf.dmj;
import com.tencent.mm.protocal.protobuf.dtm;
import com.tencent.mm.protocal.protobuf.dtn;
import com.tencent.mm.protocal.protobuf.eky;
import com.tencent.mm.protocal.protobuf.etg;
import com.tencent.mm.protocal.protobuf.fkv;
import com.tencent.mm.protocal.protobuf.flm;
import com.tencent.mm.protocal.protobuf.fmp;
import com.tencent.mm.protocal.protobuf.fnf;
import com.tencent.mm.protocal.protobuf.fxx;
import com.tencent.mm.protocal.protobuf.fyc;
import com.tencent.mm.protocal.protobuf.tm;
import com.tencent.mm.protocal.protobuf.tn;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.wallet_core.model.ab;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.WcPayBannerView;
import com.tencent.mm.wallet_core.ui.l;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MallWalletUI
  extends WalletBaseUI
  implements MStorageEx.IOnStorageChange
{
  private static final int KMS;
  private boolean KIa;
  private TextView KLa;
  private LinearLayout KMT;
  private LinearLayout KMU;
  private flm KMV;
  private Dialog KMW;
  private j.a KMX;
  private boolean KMY;
  private IListener<aao> KMZ;
  private Dialog mProgressDialog;
  private WcPayBannerView pLM;
  
  static
  {
    AppMethodBeat.i(66181);
    KMS = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 8);
    AppMethodBeat.o(66181);
  }
  
  public MallWalletUI()
  {
    AppMethodBeat.i(162275);
    this.KIa = false;
    this.KMY = false;
    this.KMZ = new IListener(f.hfK) {};
    AppMethodBeat.o(162275);
  }
  
  private void aA(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(66176);
    Log.i("MicroMsg.MallWalletUI", "do query wechat wallet");
    if (paramBoolean2) {
      this.mProgressDialog = l.c(this, false, null);
    }
    j.a(this.KMX, true, paramBoolean1);
    AppMethodBeat.o(66176);
  }
  
  private void iU(List<fmp> paramList)
  {
    AppMethodBeat.i(66178);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(66178);
      return;
    }
    this.KMU.removeAllViews();
    paramList.size();
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = (fmp)paramList.next();
      TextView localTextView = new TextView(this);
      n.a(localTextView, (fmp)localObject, new n.a()
      {
        public final void a(etg paramAnonymousVarArgs)
        {
          AppMethodBeat.i(262451);
          String str = "";
          int i;
          if (paramAnonymousVarArgs.type == 1)
          {
            paramAnonymousVarArgs = paramAnonymousVarArgs.url;
            i = 1;
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.h.OAn.b(16502, new Object[] { Integer.valueOf(2), paramAnonymousVarArgs, Integer.valueOf(i) });
            AppMethodBeat.o(262451);
            return;
            if ((paramAnonymousVarArgs.type == 2) && (paramAnonymousVarArgs.abwC != null))
            {
              paramAnonymousVarArgs = paramAnonymousVarArgs.abwC.username;
              i = 2;
            }
            else if ((paramAnonymousVarArgs.type == 4) || (paramAnonymousVarArgs.type == 5))
            {
              paramAnonymousVarArgs = paramAnonymousVarArgs.url;
              i = 3;
            }
            else
            {
              i = 0;
              paramAnonymousVarArgs = str;
            }
          }
        }
        
        public final boolean fZK()
        {
          return false;
        }
      });
      localObject = new LinearLayout.LayoutParams(-2, -2);
      if (i != 0) {
        ((LinearLayout.LayoutParams)localObject).topMargin = com.tencent.mm.cd.a.fromDPToPix(this, 8);
      }
      this.KMU.addView(localTextView, (ViewGroup.LayoutParams)localObject);
      i += 1;
    }
    AppMethodBeat.o(66178);
  }
  
  private void kD(boolean paramBoolean)
  {
    AppMethodBeat.i(66177);
    if (this.KMV != null)
    {
      Object localObject1 = this.KMV.abLW;
      if (localObject1 != null)
      {
        setMMTitle(n.a(this, ((dtm)localObject1).YCT, null));
        localObject1 = ((dtm)localObject1).aaZj;
        localObject2 = new n.a()
        {
          public final void a(etg paramAnonymousVarArgs)
          {
            AppMethodBeat.i(262448);
            com.tencent.mm.plugin.report.service.h.OAn.b(16502, new Object[] { Integer.valueOf(1) });
            AppMethodBeat.o(262448);
          }
          
          public final boolean fZK()
          {
            return false;
          }
        };
        if ((localObject1 != null) && (((dtn)localObject1).type == 2) && (((dtn)localObject1).ZoM != null)) {
          addTextOptionMenu(0, n.a(this, ((dtn)localObject1).ZoM), new n.9((dtn)localObject1, (n.a)localObject2, this));
        }
      }
      Log.i("MicroMsg.MallWalletUI", "section size: %s", new Object[] { this.KMV.aaxw });
      int j = this.KMT.getChildCount();
      int k = this.KMV.aaxw.size();
      localObject1 = new com.tencent.mm.plugin.appbrand.api.i()
      {
        public final void UP(String paramAnonymousString)
        {
          AppMethodBeat.i(262461);
          Log.i("MicroMsg.MallWalletUI", "onTriggerHalfScreenShare");
          AppMethodBeat.o(262461);
        }
        
        public final void ceq()
        {
          AppMethodBeat.i(262458);
          Log.i("MicroMsg.MallWalletUI", "onAppBrandPreconditionError");
          ((t)com.tencent.mm.kernel.h.ax(t.class)).a(this);
          AppMethodBeat.o(262458);
        }
        
        public final void cer()
        {
          AppMethodBeat.i(262447);
          Log.i("MicroMsg.MallWalletUI", "onAppBrandUIEnter");
          AppMethodBeat.o(262447);
        }
        
        public final void ces()
        {
          AppMethodBeat.i(262453);
          Log.i("MicroMsg.MallWalletUI", "onAppBrandProcessDied");
          if (MallWalletUI.f(MallWalletUI.this))
          {
            Log.i("MicroMsg.MallWalletUI", "fenfu refresh");
            MallWalletUI.a(MallWalletUI.this, false);
            MallWalletUI.c(MallWalletUI.this, false);
          }
          ((t)com.tencent.mm.kernel.h.ax(t.class)).a(this);
          AppMethodBeat.o(262453);
        }
        
        public final void ie(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(262450);
          Log.i("MicroMsg.MallWalletUI", "onAppBrandUIExit：%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (MallWalletUI.f(MallWalletUI.this))
          {
            Log.i("MicroMsg.MallWalletUI", "fenfu refresh");
            MallWalletUI.a(MallWalletUI.this, false);
            MallWalletUI.c(MallWalletUI.this, false);
          }
          ((t)com.tencent.mm.kernel.h.ax(t.class)).a(this);
          AppMethodBeat.o(262450);
        }
      };
      Object localObject2 = new n.b()
      {
        public final void aG(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(262449);
          switch (paramAnonymousBundle.getInt("callbackEventType"))
          {
          }
          for (;;)
          {
            AppMethodBeat.o(262449);
            return;
            Log.i("MicroMsg.MallWalletUI", "refresh wallet data from pay settings");
            MallWalletUI.c(MallWalletUI.this, true);
            AppMethodBeat.o(262449);
            return;
            Log.i("MicroMsg.MallWalletUI", "refresh wallet data from realname end");
            MallWalletUI.c(MallWalletUI.this, true);
          }
        }
      };
      int i = 0;
      if (i < k)
      {
        Object localObject3 = (ddc)this.KMV.aaxw.get(i);
        if (i < j)
        {
          Log.d("MicroMsg.MallWalletUI", "update layout");
          ((MallWalletSectionView)this.KMT.getChildAt(i)).a((ddc)localObject3, paramBoolean, (com.tencent.mm.plugin.appbrand.api.i)localObject1, (n.b)localObject2);
        }
        for (;;)
        {
          i += 1;
          break;
          Log.d("MicroMsg.MallWalletUI", "insert layout");
          MallWalletSectionView localMallWalletSectionView = new MallWalletSectionView(getContext());
          localMallWalletSectionView.a((ddc)localObject3, paramBoolean, (com.tencent.mm.plugin.appbrand.api.i)localObject1, (n.b)localObject2);
          localObject3 = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject3).topMargin = KMS;
          localMallWalletSectionView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          this.KMT.addView(localMallWalletSectionView, (ViewGroup.LayoutParams)localObject3);
        }
      }
      if (j > k)
      {
        Log.d("MicroMsg.MallWalletUI", "remove layout");
        this.KMT.removeViews(k, j - k);
      }
      iU(this.KMV.abLX);
    }
    AppMethodBeat.o(66177);
  }
  
  public int getLayoutId()
  {
    return a.g.mall_wallet_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(66171);
    this.KMT = ((LinearLayout)findViewById(a.f.mwui_root_layout));
    this.KMU = ((LinearLayout)findViewById(a.f.mwui_bottom_layout));
    this.KLa = ((TextView)findViewById(a.f.banner_tips));
    this.pLM = ((WcPayBannerView)findViewById(a.f.wc_pay_banner_layout));
    this.pLM.jPz();
    AppMethodBeat.o(66171);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(66175);
    Log.i("MicroMsg.MallWalletUI", "requestCode: %s, resultCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 65281) || (paramInt1 == 65286))
    {
      aA(false, false);
      AppMethodBeat.o(66175);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(66175);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(66170);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(a.c.default_background_color));
    hideActionbarLine();
    setMMTitle("");
    initView();
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().add(this);
    this.KMX = new j.a()
    {
      public final void b(eky paramAnonymouseky)
      {
        AppMethodBeat.i(162272);
        Log.i("MicroMsg.MallWalletUI", "cache callback");
        if (MallWalletUI.a(MallWalletUI.this) != null)
        {
          MallWalletUI.a(MallWalletUI.this).dismiss();
          MallWalletUI.b(MallWalletUI.this);
        }
        MallWalletUI.a(MallWalletUI.this, paramAnonymouseky.abpO);
        MallWalletUI.b(MallWalletUI.this, true);
        AppMethodBeat.o(162272);
      }
      
      public final void c(final eky paramAnonymouseky)
      {
        AppMethodBeat.i(162273);
        Log.i("MicroMsg.MallWalletUI", "net callback: %s", new Object[] { paramAnonymouseky });
        if (MallWalletUI.a(MallWalletUI.this) != null)
        {
          MallWalletUI.a(MallWalletUI.this).dismiss();
          MallWalletUI.b(MallWalletUI.this);
        }
        if (paramAnonymouseky != null)
        {
          if (paramAnonymouseky.abpO != null)
          {
            MallWalletUI.a(MallWalletUI.this, paramAnonymouseky.abpO);
            MallWalletUI.b(MallWalletUI.this, false);
          }
          if ((paramAnonymouseky.YCV != null) && (paramAnonymouseky.YCV.type == 13)) {
            MallWalletUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(162271);
                MallWalletUI localMallWalletUI;
                Object localObject2;
                View.OnClickListener local1;
                if (((MallWalletUI.c(MallWalletUI.this) == null) || (!MallWalletUI.c(MallWalletUI.this).isShowing())) && (!MallWalletUI.this.isFinishing()) && (!MallWalletUI.d(MallWalletUI.this)))
                {
                  localMallWalletUI = MallWalletUI.this;
                  localObject2 = MallWalletUI.this;
                  localObject1 = paramAnonymouseky.YCV.abwG;
                  local1 = new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymous3View)
                    {
                      AppMethodBeat.i(162270);
                      b localb = new b();
                      localb.cH(paramAnonymous3View);
                      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mall/ui/MallWalletUI$2$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
                      MallWalletUI.c(MallWalletUI.this).dismiss();
                      com.tencent.mm.plugin.report.service.h.OAn.b(16500, new Object[] { Integer.valueOf(5) });
                      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/mall/ui/MallWalletUI$2$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
                      AppMethodBeat.o(162270);
                    }
                  };
                  if (localObject1 != null) {
                    break label161;
                  }
                }
                label161:
                com.tencent.mm.plugin.crashfix.b.a locala;
                for (Object localObject1 = null;; localObject1 = locala)
                {
                  MallWalletUI.a(localMallWalletUI, (Dialog)localObject1);
                  MallWalletUI.this.addDialog(MallWalletUI.c(MallWalletUI.this));
                  MallWalletUI.c(MallWalletUI.this).show();
                  MallWalletUI.e(MallWalletUI.this);
                  AppMethodBeat.o(162271);
                  return;
                  locala = new com.tencent.mm.plugin.crashfix.b.a((Context)localObject2, a.j.mmalertdialog);
                  ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from((Context)localObject2).inflate(a.g.wallet_custom_dialog_layout, null, false);
                  Object localObject3;
                  int i;
                  if ((((ahk)localObject1).Zqu != null) && (((ahk)localObject1).Zqu.aaZk != null))
                  {
                    localObject3 = (CdnImageView)localViewGroup.findViewById(a.f.wcdl_header_left_iv);
                    localObject4 = ((ahk)localObject1).Zqu.aaZk;
                    if (((dtn)localObject4).type == 1)
                    {
                      n.a((CdnImageView)localObject3, ((dtn)localObject4).YZa, a.e.idcard_cancelicon, true);
                      i = BackwardSupportUtil.BitmapFactory.fromDPToPix((Context)localObject2, 50.0F);
                      Util.expandViewTouchArea((View)localObject3, i, i, i, i);
                      ((CdnImageView)localObject3).setOnClickListener(new n.4(locala));
                    }
                  }
                  Object localObject4 = (LinearLayout)localViewGroup.findViewById(a.f.wcdl_content_layout);
                  if ((((ahk)localObject1).Zqw != null) && (!((ahk)localObject1).Zqw.isEmpty()))
                  {
                    Iterator localIterator = ((ahk)localObject1).Zqw.iterator();
                    while (localIterator.hasNext())
                    {
                      localObject1 = (fxx)localIterator.next();
                      localObject2 = new LinearLayout.LayoutParams(-2, -2);
                      if (((fxx)localObject1).type == 1)
                      {
                        localObject3 = new TextView(((LinearLayout)localObject4).getContext());
                        n.a((TextView)localObject3, ((fxx)localObject1).ZoM, null);
                        n.a((View)localObject3, (ViewGroup.MarginLayoutParams)localObject2, ((fxx)localObject1).abVQ);
                        ((LinearLayout)localObject4).addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
                      }
                      else if (((fxx)localObject1).type == 11)
                      {
                        localObject3 = new CdnImageView(((LinearLayout)localObject4).getContext());
                        i = com.tencent.mm.cd.a.fromDPToPix(((LinearLayout)localObject4).getContext(), 64);
                        n.a((CdnImageView)localObject3, ((fxx)localObject1).YZa, -1, false);
                        ((CdnImageView)localObject3).setMinimumWidth(i);
                        ((CdnImageView)localObject3).setMinimumHeight(i);
                        n.a((View)localObject3, (ViewGroup.MarginLayoutParams)localObject2, ((fxx)localObject1).abVQ);
                        ((LinearLayout)localObject4).addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
                      }
                      else if (((fxx)localObject1).type == 20)
                      {
                        localObject2 = ((fxx)localObject1).abVP;
                        fyc localfyc = ((fxx)localObject1).abVQ;
                        if (localObject2 != null)
                        {
                          ((LinearLayout)localObject4).setGravity(1);
                          if (((tn)localObject2).YZc != null)
                          {
                            LinearLayout localLinearLayout = new LinearLayout(((LinearLayout)localObject4).getContext());
                            localLinearLayout.setGravity(48);
                            localLinearLayout.setOrientation(0);
                            localObject1 = ((LinearLayout)localObject4).getContext();
                            localObject3 = ((tn)localObject2).YZc.ZoL;
                            label600:
                            TextView localTextView;
                            Context localContext;
                            tm localtm;
                            if (localObject3 != null) {
                              if (((fkv)localObject3).abLv == 0)
                              {
                                localObject1 = new MMSwitchBtn((Context)localObject1);
                                if (((fkv)localObject3).abpG == 0)
                                {
                                  ((MMSwitchBtn)localObject1).setCheck(false);
                                  localTextView = new TextView(((LinearLayout)localObject4).getContext());
                                  n.a(localTextView, ((tn)localObject2).YZc.ZoM, null);
                                  localContext = ((LinearLayout)localObject4).getContext();
                                  localtm = ((tn)localObject2).YZd;
                                  if (localtm == null) {
                                    break label1179;
                                  }
                                  if (localtm.mdS != 1) {
                                    break label1090;
                                  }
                                  localObject3 = new Button(localContext);
                                  ((Button)localObject3).setTextSize(0, com.tencent.mm.cd.a.br(localContext, a.d.LargeBtnTextSize));
                                  ((Button)localObject3).setTextColor(com.tencent.mm.cd.a.l(localContext, a.c.color_btn_text_selector));
                                  ((Button)localObject3).setBackgroundResource(a.e.btn_solid_green);
                                  ((Button)localObject3).setGravity(17);
                                  ((Button)localObject3).setAllCaps(true);
                                  ((Button)localObject3).setPadding(com.tencent.mm.cd.a.br(localContext, a.d.SmallBtnPadding), 0, com.tencent.mm.cd.a.br(localContext, a.d.SmallBtnPadding), 0);
                                  ((Button)localObject3).setWidth(com.tencent.mm.cd.a.fromDPToPix(localContext, 184));
                                  ((Button)localObject3).setHeight(com.tencent.mm.cd.a.fromDPToPix(localContext, 40));
                                  if (localtm.state != 1) {
                                    break label1081;
                                  }
                                  ((Button)localObject3).setEnabled(true);
                                  label777:
                                  ((Button)localObject3).setText(localtm.text);
                                  localObject2 = localObject3;
                                  if (localtm.wuj == 1)
                                  {
                                    ((Button)localObject3).setOnClickListener(new n.7(localContext, localtm, local1));
                                    localObject2 = localObject3;
                                  }
                                  label820:
                                  localObject3 = new LinearLayout.LayoutParams(-2, -2);
                                  if ((localfyc != null) && (localfyc.abVX != null)) {
                                    ((LinearLayout.LayoutParams)localObject3).topMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), (int)localfyc.abVX.top);
                                  }
                                  ((LinearLayout.LayoutParams)localObject3).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 32);
                                  ((LinearLayout)localObject4).addView(localLinearLayout, (ViewGroup.LayoutParams)localObject3);
                                  if (localObject1 != null)
                                  {
                                    localLinearLayout.addView((View)localObject1);
                                    if (!(localObject1 instanceof MMSwitchBtn)) {
                                      break label1184;
                                    }
                                    ((MMSwitchBtn)localObject1).setSwitchListener(new n.5((View)localObject2));
                                  }
                                }
                              }
                            }
                            for (;;)
                            {
                              localLinearLayout.addView(localTextView);
                              if (localObject2 == null) {
                                break;
                              }
                              localObject1 = new LinearLayout.LayoutParams(-2, -2);
                              if ((localfyc != null) && (localfyc.abVX != null)) {
                                ((LinearLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), (int)localfyc.abVX.bottom);
                              }
                              ((LinearLayout)localObject4).addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
                              break;
                              if (((fkv)localObject3).abpG == 1)
                              {
                                ((MMSwitchBtn)localObject1).setCheck(true);
                                break label600;
                              }
                              ((MMSwitchBtn)localObject1).setEnabled(false);
                              break label600;
                              if (((fkv)localObject3).abLv == 1)
                              {
                                localObject1 = new CheckBox((Context)localObject1);
                                ((CheckBox)localObject1).setBackgroundResource(a.e.mm_checkbox_btn);
                                if (((fkv)localObject3).abpG == 0)
                                {
                                  ((CheckBox)localObject1).setChecked(false);
                                  break label600;
                                }
                                if (((fkv)localObject3).abpG == 1)
                                {
                                  ((CheckBox)localObject1).setChecked(true);
                                  break label600;
                                }
                                ((CheckBox)localObject1).setEnabled(false);
                                break label600;
                              }
                              localObject1 = null;
                              break label600;
                              label1081:
                              ((Button)localObject3).setEnabled(false);
                              break label777;
                              label1090:
                              if (localtm.mdS == 0)
                              {
                                localObject3 = new CdnImageView(localContext);
                                n.a((CdnImageView)localObject3, localtm.YZa);
                                if (localtm.state == 1) {
                                  ((CdnImageView)localObject3).setEnabled(true);
                                }
                                for (;;)
                                {
                                  localObject2 = localObject3;
                                  if (localtm.wuj != 1) {
                                    break;
                                  }
                                  ((CdnImageView)localObject3).setOnClickListener(new n.8(localContext, localtm, local1));
                                  localObject2 = localObject3;
                                  break;
                                  ((CdnImageView)localObject3).setEnabled(false);
                                }
                              }
                              label1179:
                              localObject2 = null;
                              break label820;
                              label1184:
                              if ((localObject1 instanceof CheckBox)) {
                                ((CheckBox)localObject1).setOnCheckedChangeListener(new n.6((View)localObject2));
                              }
                            }
                          }
                        }
                      }
                    }
                  }
                  locala.setContentView(localViewGroup);
                  locala.setCancelable(true);
                  locala.setCanceledOnTouchOutside(false);
                }
              }
            });
          }
        }
        AppMethodBeat.o(162273);
      }
    };
    aA(true, true);
    paramBundle = new acx();
    paramBundle.igk.scene = "1";
    paramBundle.igk.callback = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(262443);
        if ((paramBundle.igl.type == 2) && (paramBundle.igl.ign != null))
        {
          MallWalletUI.g(MallWalletUI.this).setBannerData(paramBundle.igl.ign);
          AppMethodBeat.o(262443);
          return;
        }
        if (!Util.isNullOrNil(paramBundle.igl.igm)) {
          com.tencent.mm.wallet_core.ui.i.a(null, MallWalletUI.h(MallWalletUI.this), paramBundle.igl.igm, paramBundle.igl.content, paramBundle.igl.url);
        }
        AppMethodBeat.o(262443);
      }
    };
    paramBundle.publish();
    this.KMZ.alive();
    AppMethodBeat.o(66170);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66174);
    super.onDestroy();
    this.KMZ.dead();
    j.a(this.KMX);
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().remove(this);
    AppMethodBeat.o(66174);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(66179);
    if ((paramMStorageEx == ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg()) && (paramInt == 4))
    {
      Log.i("MicroMsg.MallWalletUI", "on cache update: %s", new Object[] { paramObject });
      if ((paramObject.equals("USERINFO_NEW_BALANCE_LONG")) || (paramObject.equals("USERINFO_NEW_LQT_LONG"))) {
        kD(false);
      }
    }
    AppMethodBeat.o(66179);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(66173);
    super.onPause();
    AppMethodBeat.o(66173);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(66172);
    super.onResume();
    AppMethodBeat.o(66172);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(262452);
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(MallWalletUI.a.class);
    AppMethodBeat.o(262452);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallWalletUI
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.mall.ui;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.f.a.yv;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.appbrand.service.r;
import com.tencent.mm.plugin.mall.a.j;
import com.tencent.mm.plugin.mall.a.j.a;
import com.tencent.mm.plugin.wallet_core.utils.k;
import com.tencent.mm.plugin.wallet_core.utils.k.3;
import com.tencent.mm.plugin.wallet_core.utils.k.4;
import com.tencent.mm.plugin.wallet_core.utils.k.5;
import com.tencent.mm.plugin.wallet_core.utils.k.6;
import com.tencent.mm.plugin.wallet_core.utils.k.7;
import com.tencent.mm.plugin.wallet_core.utils.k.8;
import com.tencent.mm.plugin.wallet_core.utils.k.a;
import com.tencent.mm.plugin.wallet_core.utils.k.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.d;
import com.tencent.mm.plugin.wxpay.a.e;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.ado;
import com.tencent.mm.protocal.protobuf.aey;
import com.tencent.mm.protocal.protobuf.cmp;
import com.tencent.mm.protocal.protobuf.cvd;
import com.tencent.mm.protocal.protobuf.dbu;
import com.tencent.mm.protocal.protobuf.dbv;
import com.tencent.mm.protocal.protobuf.dsd;
import com.tencent.mm.protocal.protobuf.eaa;
import com.tencent.mm.protocal.protobuf.epw;
import com.tencent.mm.protocal.protobuf.eqi;
import com.tencent.mm.protocal.protobuf.erh;
import com.tencent.mm.protocal.protobuf.fbm;
import com.tencent.mm.protocal.protobuf.fbr;
import com.tencent.mm.protocal.protobuf.sb;
import com.tencent.mm.protocal.protobuf.sc;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MallWalletUI
  extends WalletBaseUI
  implements MStorageEx.IOnStorageChange
{
  private static final int ESq;
  private boolean ENE;
  private LinearLayout ESr;
  private LinearLayout ESs;
  private eqi ESt;
  private Dialog ESu;
  private j.a ESv;
  private boolean ESw;
  private IListener<yv> ESx;
  private Dialog mProgressDialog;
  
  static
  {
    AppMethodBeat.i(66181);
    ESq = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 8);
    AppMethodBeat.o(66181);
  }
  
  public MallWalletUI()
  {
    AppMethodBeat.i(162275);
    this.ENE = false;
    this.ESw = false;
    this.ESx = new IListener() {};
    AppMethodBeat.o(162275);
  }
  
  private void ai(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(66176);
    Log.i("MicroMsg.MallWalletUI", "do query wechat wallet");
    if (paramBoolean2) {
      this.mProgressDialog = com.tencent.mm.wallet_core.ui.i.c(this, false, null);
    }
    j.a(this.ESv, true, paramBoolean1);
    AppMethodBeat.o(66176);
  }
  
  private void fX(List<erh> paramList)
  {
    AppMethodBeat.i(66178);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(66178);
      return;
    }
    this.ESs.removeAllViews();
    paramList.size();
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = (erh)paramList.next();
      TextView localTextView = new TextView(this);
      k.a(localTextView, (erh)localObject, new MallWalletUI.6(this));
      localObject = new LinearLayout.LayoutParams(-2, -2);
      if (i != 0) {
        ((LinearLayout.LayoutParams)localObject).topMargin = com.tencent.mm.ci.a.fromDPToPix(this, 8);
      }
      this.ESs.addView(localTextView, (ViewGroup.LayoutParams)localObject);
      i += 1;
    }
    AppMethodBeat.o(66178);
  }
  
  private void jq(boolean paramBoolean)
  {
    AppMethodBeat.i(66177);
    if (this.ESt != null)
    {
      Object localObject1 = this.ESt.UsO;
      if (localObject1 != null)
      {
        setMMTitle(k.a(this, ((dbu)localObject1).RGf, null));
        localObject1 = ((dbu)localObject1).TJt;
        localObject2 = new k.a()
        {
          public final void a(eaa paramAnonymousVarArgs)
          {
            AppMethodBeat.i(193796);
            com.tencent.mm.plugin.report.service.h.IzE.a(16502, new Object[] { Integer.valueOf(1) });
            AppMethodBeat.o(193796);
          }
        };
        if ((localObject1 != null) && (((dbv)localObject1).type == 2) && (((dbv)localObject1).SpR != null)) {
          addTextOptionMenu(0, k.a(this, ((dbv)localObject1).SpR), new k.8((dbv)localObject1, (k.a)localObject2, this));
        }
      }
      Log.i("MicroMsg.MallWalletUI", "section size: %s", new Object[] { this.ESt.TjT });
      int j = this.ESr.getChildCount();
      int k = this.ESt.TjT.size();
      localObject1 = new com.tencent.mm.plugin.appbrand.api.i()
      {
        public final void bFd()
        {
          AppMethodBeat.i(269440);
          Log.i("MicroMsg.MallWalletUI", "onAppBrandPreconditionError");
          ((r)com.tencent.mm.kernel.h.ae(r.class)).a(this);
          AppMethodBeat.o(269440);
        }
        
        public final void bFe()
        {
          AppMethodBeat.i(269437);
          Log.i("MicroMsg.MallWalletUI", "onAppBrandUIEnter");
          AppMethodBeat.o(269437);
        }
        
        public final void bFf()
        {
          AppMethodBeat.i(269439);
          Log.i("MicroMsg.MallWalletUI", "onAppBrandProcessDied");
          if (MallWalletUI.f(MallWalletUI.this))
          {
            Log.i("MicroMsg.MallWalletUI", "fenfu refresh");
            MallWalletUI.a(MallWalletUI.this, false);
            MallWalletUI.g(MallWalletUI.this);
          }
          ((r)com.tencent.mm.kernel.h.ae(r.class)).a(this);
          AppMethodBeat.o(269439);
        }
        
        public final void hn(boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(269438);
          Log.i("MicroMsg.MallWalletUI", "onAppBrandUIExit：%s", new Object[] { Boolean.valueOf(paramAnonymousBoolean) });
          if (MallWalletUI.f(MallWalletUI.this))
          {
            Log.i("MicroMsg.MallWalletUI", "fenfu refresh");
            MallWalletUI.a(MallWalletUI.this, false);
            MallWalletUI.g(MallWalletUI.this);
          }
          ((r)com.tencent.mm.kernel.h.ae(r.class)).a(this);
          AppMethodBeat.o(269438);
        }
      };
      Object localObject2 = new k.b()
      {
        public final void bu(Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(293299);
          switch (paramAnonymousBundle.getInt("callbackEventType"))
          {
          }
          for (;;)
          {
            AppMethodBeat.o(293299);
            return;
            Log.i("MicroMsg.MallWalletUI", "refresh wallet data from pay settings");
            MallWalletUI.g(MallWalletUI.this);
          }
        }
      };
      int i = 0;
      if (i < k)
      {
        Object localObject3 = (cmp)this.ESt.TjT.get(i);
        if (i < j)
        {
          Log.d("MicroMsg.MallWalletUI", "update layout");
          ((MallWalletSectionView)this.ESr.getChildAt(i)).a((cmp)localObject3, paramBoolean, (com.tencent.mm.plugin.appbrand.api.i)localObject1, (k.b)localObject2);
        }
        for (;;)
        {
          i += 1;
          break;
          Log.d("MicroMsg.MallWalletUI", "insert layout");
          MallWalletSectionView localMallWalletSectionView = new MallWalletSectionView(getContext());
          localMallWalletSectionView.a((cmp)localObject3, paramBoolean, (com.tencent.mm.plugin.appbrand.api.i)localObject1, (k.b)localObject2);
          localObject3 = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject3).topMargin = ESq;
          localMallWalletSectionView.setLayoutParams((ViewGroup.LayoutParams)localObject3);
          this.ESr.addView(localMallWalletSectionView, (ViewGroup.LayoutParams)localObject3);
        }
      }
      if (j > k)
      {
        Log.d("MicroMsg.MallWalletUI", "remove layout");
        this.ESr.removeViews(k, j - k);
      }
      fX(this.ESt.UsP);
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
    this.ESr = ((LinearLayout)findViewById(a.f.mwui_root_layout));
    this.ESs = ((LinearLayout)findViewById(a.f.mwui_bottom_layout));
    AppMethodBeat.o(66171);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(66175);
    Log.i("MicroMsg.MallWalletUI", "requestCode: %s, resultCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 65281) || (paramInt1 == 65286))
    {
      ai(false, false);
      AppMethodBeat.o(66175);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(66175);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66170);
    fixStatusbar(true);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(a.c.default_background_color));
    hideActionbarLine();
    setMMTitle("");
    initView();
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().add(this);
    this.ESv = new j.a()
    {
      public final void b(dsd paramAnonymousdsd)
      {
        AppMethodBeat.i(162272);
        Log.i("MicroMsg.MallWalletUI", "cache callback");
        if (MallWalletUI.a(MallWalletUI.this) != null)
        {
          MallWalletUI.a(MallWalletUI.this).dismiss();
          MallWalletUI.b(MallWalletUI.this);
        }
        MallWalletUI.a(MallWalletUI.this, paramAnonymousdsd.TYR);
        MallWalletUI.b(MallWalletUI.this, true);
        AppMethodBeat.o(162272);
      }
      
      public final void c(final dsd paramAnonymousdsd)
      {
        AppMethodBeat.i(162273);
        Log.i("MicroMsg.MallWalletUI", "net callback: %s", new Object[] { paramAnonymousdsd });
        if (MallWalletUI.a(MallWalletUI.this) != null)
        {
          MallWalletUI.a(MallWalletUI.this).dismiss();
          MallWalletUI.b(MallWalletUI.this);
        }
        if (paramAnonymousdsd != null)
        {
          if (paramAnonymousdsd.TYR != null)
          {
            MallWalletUI.a(MallWalletUI.this, paramAnonymousdsd.TYR);
            MallWalletUI.b(MallWalletUI.this, false);
          }
          if ((paramAnonymousdsd.RGh != null) && (paramAnonymousdsd.RGh.type == 13)) {
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
                  localObject1 = paramAnonymousdsd.RGh.Uft;
                  local1 = new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymous3View)
                    {
                      AppMethodBeat.i(162270);
                      b localb = new b();
                      localb.bn(paramAnonymous3View);
                      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/mall/ui/MallWalletUI$2$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
                      MallWalletUI.c(MallWalletUI.this).dismiss();
                      com.tencent.mm.plugin.report.service.h.IzE.a(16500, new Object[] { Integer.valueOf(5) });
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
                  if ((((aey)localObject1).Srs != null) && (((aey)localObject1).Srs.TJu != null))
                  {
                    localObject3 = (CdnImageView)localViewGroup.findViewById(a.f.wcdl_header_left_iv);
                    localObject4 = ((aey)localObject1).Srs.TJu;
                    if (((dbv)localObject4).type == 1)
                    {
                      k.a((CdnImageView)localObject3, ((dbv)localObject4).Sbb, a.e.idcard_cancelicon, true);
                      i = BackwardSupportUtil.BitmapFactory.fromDPToPix((Context)localObject2, 50.0F);
                      Util.expandViewTouchArea((View)localObject3, i, i, i, i);
                      ((CdnImageView)localObject3).setOnClickListener(new k.3(locala));
                    }
                  }
                  Object localObject4 = (LinearLayout)localViewGroup.findViewById(a.f.wcdl_content_layout);
                  if ((((aey)localObject1).Sru != null) && (!((aey)localObject1).Sru.isEmpty()))
                  {
                    Iterator localIterator = ((aey)localObject1).Sru.iterator();
                    while (localIterator.hasNext())
                    {
                      localObject1 = (fbm)localIterator.next();
                      localObject2 = new LinearLayout.LayoutParams(-2, -2);
                      if (((fbm)localObject1).type == 1)
                      {
                        localObject3 = new TextView(((LinearLayout)localObject4).getContext());
                        k.a((TextView)localObject3, ((fbm)localObject1).SpR, null);
                        k.a((View)localObject3, (ViewGroup.MarginLayoutParams)localObject2, ((fbm)localObject1).UBH);
                        ((LinearLayout)localObject4).addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
                      }
                      else if (((fbm)localObject1).type == 11)
                      {
                        localObject3 = new CdnImageView(((LinearLayout)localObject4).getContext());
                        i = com.tencent.mm.ci.a.fromDPToPix(((LinearLayout)localObject4).getContext(), 64);
                        k.a((CdnImageView)localObject3, ((fbm)localObject1).Sbb, -1, false);
                        ((CdnImageView)localObject3).setMinimumWidth(i);
                        ((CdnImageView)localObject3).setMinimumHeight(i);
                        k.a((View)localObject3, (ViewGroup.MarginLayoutParams)localObject2, ((fbm)localObject1).UBH);
                        ((LinearLayout)localObject4).addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
                      }
                      else if (((fbm)localObject1).type == 20)
                      {
                        localObject2 = ((fbm)localObject1).UBG;
                        fbr localfbr = ((fbm)localObject1).UBH;
                        if (localObject2 != null)
                        {
                          ((LinearLayout)localObject4).setGravity(1);
                          if (((sc)localObject2).Sbd != null)
                          {
                            LinearLayout localLinearLayout = new LinearLayout(((LinearLayout)localObject4).getContext());
                            localLinearLayout.setGravity(48);
                            localLinearLayout.setOrientation(0);
                            localObject1 = ((LinearLayout)localObject4).getContext();
                            localObject3 = ((sc)localObject2).Sbd.SpQ;
                            label600:
                            TextView localTextView;
                            Context localContext;
                            sb localsb;
                            if (localObject3 != null) {
                              if (((epw)localObject3).Uss == 0)
                              {
                                localObject1 = new MMSwitchBtn((Context)localObject1);
                                if (((epw)localObject3).TYJ == 0)
                                {
                                  ((MMSwitchBtn)localObject1).setCheck(false);
                                  localTextView = new TextView(((LinearLayout)localObject4).getContext());
                                  k.a(localTextView, ((sc)localObject2).Sbd.SpR, null);
                                  localContext = ((LinearLayout)localObject4).getContext();
                                  localsb = ((sc)localObject2).Sbe;
                                  if (localsb == null) {
                                    break label1179;
                                  }
                                  if (localsb.jDW != 1) {
                                    break label1090;
                                  }
                                  localObject3 = new Button(localContext);
                                  ((Button)localObject3).setTextSize(0, com.tencent.mm.ci.a.aY(localContext, a.d.LargeBtnTextSize));
                                  ((Button)localObject3).setTextColor(com.tencent.mm.ci.a.l(localContext, a.c.color_btn_text_selector));
                                  ((Button)localObject3).setBackgroundResource(a.e.btn_solid_green);
                                  ((Button)localObject3).setGravity(17);
                                  ((Button)localObject3).setAllCaps(true);
                                  ((Button)localObject3).setPadding(com.tencent.mm.ci.a.aY(localContext, a.d.SmallBtnPadding), 0, com.tencent.mm.ci.a.aY(localContext, a.d.SmallBtnPadding), 0);
                                  ((Button)localObject3).setWidth(com.tencent.mm.ci.a.fromDPToPix(localContext, 184));
                                  ((Button)localObject3).setHeight(com.tencent.mm.ci.a.fromDPToPix(localContext, 40));
                                  if (localsb.state != 1) {
                                    break label1081;
                                  }
                                  ((Button)localObject3).setEnabled(true);
                                  label777:
                                  ((Button)localObject3).setText(localsb.text);
                                  localObject2 = localObject3;
                                  if (localsb.tpK == 1)
                                  {
                                    ((Button)localObject3).setOnClickListener(new k.6(localContext, localsb, local1));
                                    localObject2 = localObject3;
                                  }
                                  label820:
                                  localObject3 = new LinearLayout.LayoutParams(-2, -2);
                                  if ((localfbr != null) && (localfbr.UBO != null)) {
                                    ((LinearLayout.LayoutParams)localObject3).topMargin = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), (int)localfbr.UBO.top);
                                  }
                                  ((LinearLayout.LayoutParams)localObject3).bottomMargin = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 32);
                                  ((LinearLayout)localObject4).addView(localLinearLayout, (ViewGroup.LayoutParams)localObject3);
                                  if (localObject1 != null)
                                  {
                                    localLinearLayout.addView((View)localObject1);
                                    if (!(localObject1 instanceof MMSwitchBtn)) {
                                      break label1184;
                                    }
                                    ((MMSwitchBtn)localObject1).setSwitchListener(new k.4((View)localObject2));
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
                              if ((localfbr != null) && (localfbr.UBO != null)) {
                                ((LinearLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), (int)localfbr.UBO.bottom);
                              }
                              ((LinearLayout)localObject4).addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
                              break;
                              if (((epw)localObject3).TYJ == 1)
                              {
                                ((MMSwitchBtn)localObject1).setCheck(true);
                                break label600;
                              }
                              ((MMSwitchBtn)localObject1).setEnabled(false);
                              break label600;
                              if (((epw)localObject3).Uss == 1)
                              {
                                localObject1 = new CheckBox((Context)localObject1);
                                ((CheckBox)localObject1).setBackgroundResource(a.e.mm_checkbox_btn);
                                if (((epw)localObject3).TYJ == 0)
                                {
                                  ((CheckBox)localObject1).setChecked(false);
                                  break label600;
                                }
                                if (((epw)localObject3).TYJ == 1)
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
                              if (localsb.jDW == 0)
                              {
                                localObject3 = new CdnImageView(localContext);
                                k.a((CdnImageView)localObject3, localsb.Sbb);
                                if (localsb.state == 1) {
                                  ((CdnImageView)localObject3).setEnabled(true);
                                }
                                for (;;)
                                {
                                  localObject2 = localObject3;
                                  if (localsb.tpK != 1) {
                                    break;
                                  }
                                  ((CdnImageView)localObject3).setOnClickListener(new k.7(localContext, localsb, local1));
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
                                ((CheckBox)localObject1).setOnCheckedChangeListener(new k.5((View)localObject2));
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
    ai(true, true);
    this.ESx.alive();
    AppMethodBeat.o(66170);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66174);
    super.onDestroy();
    this.ESx.dead();
    j.a(this.ESv);
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().remove(this);
    AppMethodBeat.o(66174);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(66179);
    if ((paramMStorageEx == ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg()) && (paramInt == 4))
    {
      Log.i("MicroMsg.MallWalletUI", "on cache update: %s", new Object[] { paramObject });
      if ((paramObject.equals("USERINFO_NEW_BALANCE_LONG")) || (paramObject.equals("USERINFO_NEW_LQT_LONG"))) {
        jq(false);
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
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallWalletUI
 * JD-Core Version:    0.7.0.1
 */
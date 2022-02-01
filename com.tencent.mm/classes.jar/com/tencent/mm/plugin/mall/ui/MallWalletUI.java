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
import com.tencent.mm.g.a.wo;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.mall.a.j;
import com.tencent.mm.plugin.mall.a.j.a;
import com.tencent.mm.plugin.wallet_core.utils.g.2;
import com.tencent.mm.plugin.wallet_core.utils.g.3;
import com.tencent.mm.plugin.wallet_core.utils.g.4;
import com.tencent.mm.plugin.wallet_core.utils.g.5;
import com.tencent.mm.plugin.wallet_core.utils.g.6;
import com.tencent.mm.plugin.wallet_core.utils.g.7;
import com.tencent.mm.plugin.wallet_core.utils.g.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.abi;
import com.tencent.mm.protocal.protobuf.acn;
import com.tencent.mm.protocal.protobuf.brb;
import com.tencent.mm.protocal.protobuf.byt;
import com.tencent.mm.protocal.protobuf.ccq;
import com.tencent.mm.protocal.protobuf.ccr;
import com.tencent.mm.protocal.protobuf.cqm;
import com.tencent.mm.protocal.protobuf.cxk;
import com.tencent.mm.protocal.protobuf.dmg;
import com.tencent.mm.protocal.protobuf.dms;
import com.tencent.mm.protocal.protobuf.dnl;
import com.tencent.mm.protocal.protobuf.dny;
import com.tencent.mm.protocal.protobuf.dwv;
import com.tencent.mm.protocal.protobuf.dxa;
import com.tencent.mm.protocal.protobuf.rg;
import com.tencent.mm.protocal.protobuf.rh;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.h;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MallWalletUI
  extends WalletBaseUI
  implements n.b
{
  private static final int vST;
  private Dialog mProgressDialog;
  private boolean vMQ;
  private LinearLayout vSU;
  private LinearLayout vSV;
  private dms vSW;
  private Dialog vSX;
  private j.a vSY;
  private boolean vSZ;
  private c<wo> vTa;
  
  static
  {
    AppMethodBeat.i(66181);
    vST = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 8);
    AppMethodBeat.o(66181);
  }
  
  public MallWalletUI()
  {
    AppMethodBeat.i(162275);
    this.vMQ = false;
    this.vSZ = false;
    this.vTa = new c() {};
    AppMethodBeat.o(162275);
  }
  
  private void V(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(66176);
    ae.i("MicroMsg.MallWalletUI", "do query wechat wallet");
    if (paramBoolean2) {
      this.mProgressDialog = h.c(this, false, null);
    }
    j.a(this.vSY, true, paramBoolean1);
    AppMethodBeat.o(66176);
  }
  
  private void eA(List<dnl> paramList)
  {
    AppMethodBeat.i(66178);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(66178);
      return;
    }
    this.vSV.removeAllViews();
    paramList.size();
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = (dnl)paramList.next();
      TextView localTextView = new TextView(this);
      com.tencent.mm.plugin.wallet_core.utils.g.a(localTextView, (dnl)localObject, new g.a()
      {
        public final void a(cxk paramAnonymousVarArgs)
        {
          AppMethodBeat.i(162274);
          String str = "";
          int i;
          if (paramAnonymousVarArgs.type == 1)
          {
            paramAnonymousVarArgs = paramAnonymousVarArgs.url;
            i = 1;
          }
          for (;;)
          {
            com.tencent.mm.plugin.report.service.g.yxI.f(16502, new Object[] { Integer.valueOf(2), paramAnonymousVarArgs, Integer.valueOf(i) });
            AppMethodBeat.o(162274);
            return;
            if ((paramAnonymousVarArgs.type == 2) && (paramAnonymousVarArgs.HHW != null))
            {
              paramAnonymousVarArgs = paramAnonymousVarArgs.HHW.username;
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
      });
      localObject = new LinearLayout.LayoutParams(-2, -2);
      if (i != 0) {
        ((LinearLayout.LayoutParams)localObject).topMargin = com.tencent.mm.cb.a.fromDPToPix(this, 8);
      }
      this.vSV.addView(localTextView, (ViewGroup.LayoutParams)localObject);
      i += 1;
    }
    AppMethodBeat.o(66178);
  }
  
  private void hr(boolean paramBoolean)
  {
    AppMethodBeat.i(66177);
    if (this.vSW != null)
    {
      Object localObject1 = this.vSW.HUc;
      Object localObject2;
      if (localObject1 != null)
      {
        setMMTitle(com.tencent.mm.plugin.wallet_core.utils.g.a(this, ((ccq)localObject1).FLn, null));
        localObject1 = ((ccq)localObject1).Hpn;
        localObject2 = new g.a()
        {
          public final void a(cxk paramAnonymousVarArgs)
          {
            AppMethodBeat.i(66169);
            com.tencent.mm.plugin.report.service.g.yxI.f(16502, new Object[] { Integer.valueOf(1) });
            AppMethodBeat.o(66169);
          }
        };
        if ((localObject1 != null) && (((ccr)localObject1).type == 2) && (((ccr)localObject1).Gtc != null)) {
          addTextOptionMenu(0, com.tencent.mm.plugin.wallet_core.utils.g.a(this, ((ccr)localObject1).Gtc), new g.7((ccr)localObject1, (g.a)localObject2, this));
        }
      }
      ae.i("MicroMsg.MallWalletUI", "section size: %s", new Object[] { this.vSW.GWf });
      int j = this.vSU.getChildCount();
      int k = this.vSW.GWf.size();
      int i = 0;
      if (i < k)
      {
        localObject2 = (brb)this.vSW.GWf.get(i);
        if (i < j)
        {
          ae.d("MicroMsg.MallWalletUI", "update layout");
          ((MallWalletSectionView)this.vSU.getChildAt(i)).a((brb)localObject2, paramBoolean);
        }
        for (;;)
        {
          i += 1;
          break;
          ae.d("MicroMsg.MallWalletUI", "insert layout");
          localObject1 = new MallWalletSectionView(getContext());
          ((MallWalletSectionView)localObject1).a((brb)localObject2, paramBoolean);
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject2).topMargin = vST;
          ((MallWalletSectionView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.vSU.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        }
      }
      if (j > k)
      {
        ae.d("MicroMsg.MallWalletUI", "remove layout");
        this.vSU.removeViews(k, j - k);
      }
      eA(this.vSW.HUd);
    }
    AppMethodBeat.o(66177);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(66179);
    if ((paramn == ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg()) && (paramInt == 4))
    {
      ae.i("MicroMsg.MallWalletUI", "on cache update: %s", new Object[] { paramObject });
      if ((paramObject.equals("USERINFO_NEW_BALANCE_LONG")) || (paramObject.equals("USERINFO_NEW_LQT_LONG"))) {
        hr(false);
      }
    }
    AppMethodBeat.o(66179);
  }
  
  public int getLayoutId()
  {
    return 2131494729;
  }
  
  public void initView()
  {
    AppMethodBeat.i(66171);
    this.vSU = ((LinearLayout)findViewById(2131302643));
    this.vSV = ((LinearLayout)findViewById(2131302642));
    AppMethodBeat.o(66171);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(66175);
    ae.i("MicroMsg.MallWalletUI", "requestCode: %s, resultCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 65281) || (paramInt1 == 65286))
    {
      V(false, false);
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
    setActionbarColor(getResources().getColor(2131100207));
    hideActionbarLine();
    setMMTitle("");
    initView();
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().a(this);
    this.vSY = new j.a()
    {
      public final void b(cqm paramAnonymouscqm)
      {
        AppMethodBeat.i(162272);
        ae.i("MicroMsg.MallWalletUI", "cache callback");
        if (MallWalletUI.b(MallWalletUI.this) != null)
        {
          MallWalletUI.b(MallWalletUI.this).dismiss();
          MallWalletUI.c(MallWalletUI.this);
        }
        MallWalletUI.a(MallWalletUI.this, paramAnonymouscqm.HCj);
        MallWalletUI.a(MallWalletUI.this, true);
        AppMethodBeat.o(162272);
      }
      
      public final void c(final cqm paramAnonymouscqm)
      {
        AppMethodBeat.i(162273);
        ae.i("MicroMsg.MallWalletUI", "net callback: %s", new Object[] { paramAnonymouscqm });
        if (MallWalletUI.b(MallWalletUI.this) != null)
        {
          MallWalletUI.b(MallWalletUI.this).dismiss();
          MallWalletUI.c(MallWalletUI.this);
        }
        if (paramAnonymouscqm != null)
        {
          if (paramAnonymouscqm.HCj != null)
          {
            MallWalletUI.a(MallWalletUI.this, paramAnonymouscqm.HCj);
            MallWalletUI.a(MallWalletUI.this, false);
          }
          if ((paramAnonymouscqm.FLp != null) && (paramAnonymouscqm.FLp.type == 13)) {
            MallWalletUI.this.runOnUiThread(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(162271);
                MallWalletUI localMallWalletUI;
                Object localObject2;
                View.OnClickListener local1;
                if (((MallWalletUI.d(MallWalletUI.this) == null) || (!MallWalletUI.d(MallWalletUI.this).isShowing())) && (!MallWalletUI.this.isFinishing()) && (!MallWalletUI.e(MallWalletUI.this)))
                {
                  localMallWalletUI = MallWalletUI.this;
                  localObject2 = MallWalletUI.this;
                  localObject1 = paramAnonymouscqm.FLp.HIa;
                  local1 = new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymous3View)
                    {
                      AppMethodBeat.i(162270);
                      b localb = new b();
                      localb.bd(paramAnonymous3View);
                      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallWalletUI$2$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
                      MallWalletUI.d(MallWalletUI.this).dismiss();
                      com.tencent.mm.plugin.report.service.g.yxI.f(16500, new Object[] { Integer.valueOf(5) });
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
                  MallWalletUI.this.addDialog(MallWalletUI.d(MallWalletUI.this));
                  MallWalletUI.d(MallWalletUI.this).show();
                  MallWalletUI.f(MallWalletUI.this);
                  AppMethodBeat.o(162271);
                  return;
                  locala = new com.tencent.mm.plugin.crashfix.b.a((Context)localObject2, 2131821723);
                  ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from((Context)localObject2).inflate(2131495940, null, false);
                  Object localObject3;
                  int i;
                  if ((((acn)localObject1).Gut != null) && (((acn)localObject1).Gut.Hpo != null))
                  {
                    localObject3 = (CdnImageView)localViewGroup.findViewById(2131306878);
                    localObject4 = ((acn)localObject1).Gut.Hpo;
                    if (((ccr)localObject4).type == 1)
                    {
                      com.tencent.mm.plugin.wallet_core.utils.g.a((CdnImageView)localObject3, ((ccr)localObject4).GfD, 2131232705, true);
                      i = BackwardSupportUtil.b.h((Context)localObject2, 50.0F);
                      bu.n((View)localObject3, i, i, i, i);
                      ((CdnImageView)localObject3).setOnClickListener(new g.2(locala));
                    }
                  }
                  Object localObject4 = (LinearLayout)localViewGroup.findViewById(2131306876);
                  if ((((acn)localObject1).Guv != null) && (!((acn)localObject1).Guv.isEmpty()))
                  {
                    Iterator localIterator = ((acn)localObject1).Guv.iterator();
                    while (localIterator.hasNext())
                    {
                      localObject1 = (dwv)localIterator.next();
                      localObject2 = new LinearLayout.LayoutParams(-2, -2);
                      if (((dwv)localObject1).type == 1)
                      {
                        localObject3 = new TextView(((LinearLayout)localObject4).getContext());
                        com.tencent.mm.plugin.wallet_core.utils.g.a((TextView)localObject3, ((dwv)localObject1).Gtc, null);
                        com.tencent.mm.plugin.wallet_core.utils.g.a((View)localObject3, (ViewGroup.MarginLayoutParams)localObject2, ((dwv)localObject1).Icm);
                        ((LinearLayout)localObject4).addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
                      }
                      else if (((dwv)localObject1).type == 11)
                      {
                        localObject3 = new CdnImageView(((LinearLayout)localObject4).getContext());
                        i = com.tencent.mm.cb.a.fromDPToPix(((LinearLayout)localObject4).getContext(), 64);
                        com.tencent.mm.plugin.wallet_core.utils.g.a((CdnImageView)localObject3, ((dwv)localObject1).GfD, -1, false);
                        ((CdnImageView)localObject3).setMinimumWidth(i);
                        ((CdnImageView)localObject3).setMinimumHeight(i);
                        com.tencent.mm.plugin.wallet_core.utils.g.a((View)localObject3, (ViewGroup.MarginLayoutParams)localObject2, ((dwv)localObject1).Icm);
                        ((LinearLayout)localObject4).addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
                      }
                      else if (((dwv)localObject1).type == 20)
                      {
                        localObject2 = ((dwv)localObject1).Icl;
                        dxa localdxa = ((dwv)localObject1).Icm;
                        if (localObject2 != null)
                        {
                          ((LinearLayout)localObject4).setGravity(1);
                          if (((rh)localObject2).GfF != null)
                          {
                            LinearLayout localLinearLayout = new LinearLayout(((LinearLayout)localObject4).getContext());
                            localLinearLayout.setGravity(48);
                            localLinearLayout.setOrientation(0);
                            localObject1 = ((LinearLayout)localObject4).getContext();
                            localObject3 = ((rh)localObject2).GfF.Gtb;
                            label595:
                            TextView localTextView;
                            Context localContext;
                            rg localrg;
                            if (localObject3 != null) {
                              if (((dmg)localObject3).HTF == 0)
                              {
                                localObject1 = new MMSwitchBtn((Context)localObject1);
                                if (((dmg)localObject3).HCb == 0)
                                {
                                  ((MMSwitchBtn)localObject1).setCheck(false);
                                  localTextView = new TextView(((LinearLayout)localObject4).getContext());
                                  com.tencent.mm.plugin.wallet_core.utils.g.a(localTextView, ((rh)localObject2).GfF.Gtc, null);
                                  localContext = ((LinearLayout)localObject4).getContext();
                                  localrg = ((rh)localObject2).GfG;
                                  if (localrg == null) {
                                    break label1174;
                                  }
                                  if (localrg.GfC != 1) {
                                    break label1085;
                                  }
                                  localObject3 = new Button(localContext);
                                  ((Button)localObject3).setTextSize(0, com.tencent.mm.cb.a.ax(localContext, 2131165477));
                                  ((Button)localObject3).setTextColor(com.tencent.mm.cb.a.m(localContext, 2131100161));
                                  ((Button)localObject3).setBackgroundResource(2131231365);
                                  ((Button)localObject3).setGravity(17);
                                  ((Button)localObject3).setAllCaps(true);
                                  ((Button)localObject3).setPadding(com.tencent.mm.cb.a.ax(localContext, 2131165562), 0, com.tencent.mm.cb.a.ax(localContext, 2131165562), 0);
                                  ((Button)localObject3).setWidth(com.tencent.mm.cb.a.fromDPToPix(localContext, 184));
                                  ((Button)localObject3).setHeight(com.tencent.mm.cb.a.fromDPToPix(localContext, 40));
                                  if (localrg.state != 1) {
                                    break label1076;
                                  }
                                  ((Button)localObject3).setEnabled(true);
                                  label772:
                                  ((Button)localObject3).setText(localrg.text);
                                  localObject2 = localObject3;
                                  if (localrg.oGc == 1)
                                  {
                                    ((Button)localObject3).setOnClickListener(new g.5(localContext, localrg, local1));
                                    localObject2 = localObject3;
                                  }
                                  label815:
                                  localObject3 = new LinearLayout.LayoutParams(-2, -2);
                                  if ((localdxa != null) && (localdxa.Icu != null)) {
                                    ((LinearLayout.LayoutParams)localObject3).topMargin = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), (int)localdxa.Icu.top);
                                  }
                                  ((LinearLayout.LayoutParams)localObject3).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 32);
                                  ((LinearLayout)localObject4).addView(localLinearLayout, (ViewGroup.LayoutParams)localObject3);
                                  if (localObject1 != null)
                                  {
                                    localLinearLayout.addView((View)localObject1);
                                    if (!(localObject1 instanceof MMSwitchBtn)) {
                                      break label1179;
                                    }
                                    ((MMSwitchBtn)localObject1).setSwitchListener(new g.3((View)localObject2));
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
                              if ((localdxa != null) && (localdxa.Icu != null)) {
                                ((LinearLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), (int)localdxa.Icu.bottom);
                              }
                              ((LinearLayout)localObject4).addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
                              break;
                              if (((dmg)localObject3).HCb == 1)
                              {
                                ((MMSwitchBtn)localObject1).setCheck(true);
                                break label595;
                              }
                              ((MMSwitchBtn)localObject1).setEnabled(false);
                              break label595;
                              if (((dmg)localObject3).HTF == 1)
                              {
                                localObject1 = new CheckBox((Context)localObject1);
                                ((CheckBox)localObject1).setBackgroundResource(2131233261);
                                if (((dmg)localObject3).HCb == 0)
                                {
                                  ((CheckBox)localObject1).setChecked(false);
                                  break label595;
                                }
                                if (((dmg)localObject3).HCb == 1)
                                {
                                  ((CheckBox)localObject1).setChecked(true);
                                  break label595;
                                }
                                ((CheckBox)localObject1).setEnabled(false);
                                break label595;
                              }
                              localObject1 = null;
                              break label595;
                              label1076:
                              ((Button)localObject3).setEnabled(false);
                              break label772;
                              label1085:
                              if (localrg.GfC == 0)
                              {
                                localObject3 = new CdnImageView(localContext);
                                com.tencent.mm.plugin.wallet_core.utils.g.a((CdnImageView)localObject3, localrg.GfD);
                                if (localrg.state == 1) {
                                  ((CdnImageView)localObject3).setEnabled(true);
                                }
                                for (;;)
                                {
                                  localObject2 = localObject3;
                                  if (localrg.oGc != 1) {
                                    break;
                                  }
                                  ((CdnImageView)localObject3).setOnClickListener(new g.6(localContext, localrg, local1));
                                  localObject2 = localObject3;
                                  break;
                                  ((CdnImageView)localObject3).setEnabled(false);
                                }
                              }
                              label1174:
                              localObject2 = null;
                              break label815;
                              label1179:
                              if ((localObject1 instanceof CheckBox)) {
                                ((CheckBox)localObject1).setOnCheckedChangeListener(new g.4((View)localObject2));
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
    V(true, true);
    this.vTa.alive();
    AppMethodBeat.o(66170);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66174);
    super.onDestroy();
    this.vTa.dead();
    j.a(this.vSY);
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().b(this);
    AppMethodBeat.o(66174);
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
    if (this.vSZ)
    {
      ae.i("MicroMsg.MallWalletUI", "fenfu refresh");
      this.vSZ = false;
      V(false, false);
    }
    AppMethodBeat.o(66172);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallWalletUI
 * JD-Core Version:    0.7.0.1
 */
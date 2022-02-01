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
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.xo;
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
import com.tencent.mm.protocal.protobuf.adh;
import com.tencent.mm.protocal.protobuf.aep;
import com.tencent.mm.protocal.protobuf.cdv;
import com.tencent.mm.protocal.protobuf.cml;
import com.tencent.mm.protocal.protobuf.csv;
import com.tencent.mm.protocal.protobuf.csw;
import com.tencent.mm.protocal.protobuf.dil;
import com.tencent.mm.protocal.protobuf.dqe;
import com.tencent.mm.protocal.protobuf.efu;
import com.tencent.mm.protocal.protobuf.egg;
import com.tencent.mm.protocal.protobuf.ehf;
import com.tencent.mm.protocal.protobuf.ehu;
import com.tencent.mm.protocal.protobuf.erb;
import com.tencent.mm.protocal.protobuf.erg;
import com.tencent.mm.protocal.protobuf.si;
import com.tencent.mm.protocal.protobuf.sj;
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
  private static final int zmZ;
  private Dialog mProgressDialog;
  private boolean zio;
  private LinearLayout zna;
  private LinearLayout znb;
  private egg znc;
  private Dialog znd;
  private j.a zne;
  private boolean znf;
  private IListener<xo> zng;
  
  static
  {
    AppMethodBeat.i(66181);
    zmZ = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 8);
    AppMethodBeat.o(66181);
  }
  
  public MallWalletUI()
  {
    AppMethodBeat.i(162275);
    this.zio = false;
    this.znf = false;
    this.zng = new IListener() {};
    AppMethodBeat.o(162275);
  }
  
  private void Y(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(66176);
    Log.i("MicroMsg.MallWalletUI", "do query wechat wallet");
    if (paramBoolean2) {
      this.mProgressDialog = com.tencent.mm.wallet_core.ui.h.c(this, false, null);
    }
    j.a(this.zne, true, paramBoolean1);
    AppMethodBeat.o(66176);
  }
  
  private void fv(List<ehf> paramList)
  {
    AppMethodBeat.i(66178);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(66178);
      return;
    }
    this.znb.removeAllViews();
    paramList.size();
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = (ehf)paramList.next();
      TextView localTextView = new TextView(this);
      com.tencent.mm.plugin.wallet_core.utils.g.a(localTextView, (ehf)localObject, new g.a()
      {
        public final void a(dqe paramAnonymousVarArgs)
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
            com.tencent.mm.plugin.report.service.h.CyF.a(16502, new Object[] { Integer.valueOf(2), paramAnonymousVarArgs, Integer.valueOf(i) });
            AppMethodBeat.o(162274);
            return;
            if ((paramAnonymousVarArgs.type == 2) && (paramAnonymousVarArgs.MTh != null))
            {
              paramAnonymousVarArgs = paramAnonymousVarArgs.MTh.username;
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
      this.znb.addView(localTextView, (ViewGroup.LayoutParams)localObject);
      i += 1;
    }
    AppMethodBeat.o(66178);
  }
  
  private void is(boolean paramBoolean)
  {
    AppMethodBeat.i(66177);
    if (this.znc != null)
    {
      Object localObject1 = this.znc.Ngk;
      Object localObject2;
      if (localObject1 != null)
      {
        setMMTitle(com.tencent.mm.plugin.wallet_core.utils.g.a(this, ((csv)localObject1).KEN, null));
        localObject1 = ((csv)localObject1).MxU;
        localObject2 = new g.a()
        {
          public final void a(dqe paramAnonymousVarArgs)
          {
            AppMethodBeat.i(66169);
            com.tencent.mm.plugin.report.service.h.CyF.a(16502, new Object[] { Integer.valueOf(1) });
            AppMethodBeat.o(66169);
          }
        };
        if ((localObject1 != null) && (((csw)localObject1).type == 2) && (((csw)localObject1).Lov != null)) {
          addTextOptionMenu(0, com.tencent.mm.plugin.wallet_core.utils.g.a(this, ((csw)localObject1).Lov), new g.7((csw)localObject1, (g.a)localObject2, this));
        }
      }
      Log.i("MicroMsg.MallWalletUI", "section size: %s", new Object[] { this.znc.MaA });
      int j = this.zna.getChildCount();
      int k = this.znc.MaA.size();
      int i = 0;
      if (i < k)
      {
        localObject2 = (cdv)this.znc.MaA.get(i);
        if (i < j)
        {
          Log.d("MicroMsg.MallWalletUI", "update layout");
          ((MallWalletSectionView)this.zna.getChildAt(i)).a((cdv)localObject2, paramBoolean);
        }
        for (;;)
        {
          i += 1;
          break;
          Log.d("MicroMsg.MallWalletUI", "insert layout");
          localObject1 = new MallWalletSectionView(getContext());
          ((MallWalletSectionView)localObject1).a((cdv)localObject2, paramBoolean);
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject2).topMargin = zmZ;
          ((MallWalletSectionView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.zna.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        }
      }
      if (j > k)
      {
        Log.d("MicroMsg.MallWalletUI", "remove layout");
        this.zna.removeViews(k, j - k);
      }
      fv(this.znc.Ngl);
    }
    AppMethodBeat.o(66177);
  }
  
  public int getLayoutId()
  {
    return 2131495458;
  }
  
  public void initView()
  {
    AppMethodBeat.i(66171);
    this.zna = ((LinearLayout)findViewById(2131305187));
    this.znb = ((LinearLayout)findViewById(2131305186));
    AppMethodBeat.o(66171);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(66175);
    Log.i("MicroMsg.MallWalletUI", "requestCode: %s, resultCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 65281) || (paramInt1 == 65286))
    {
      Y(false, false);
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
    setActionbarColor(getResources().getColor(2131100240));
    hideActionbarLine();
    setMMTitle("");
    initView();
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().add(this);
    this.zne = new j.a()
    {
      public final void b(dil paramAnonymousdil)
      {
        AppMethodBeat.i(162272);
        Log.i("MicroMsg.MallWalletUI", "cache callback");
        if (MallWalletUI.b(MallWalletUI.this) != null)
        {
          MallWalletUI.b(MallWalletUI.this).dismiss();
          MallWalletUI.c(MallWalletUI.this);
        }
        MallWalletUI.a(MallWalletUI.this, paramAnonymousdil.MMX);
        MallWalletUI.a(MallWalletUI.this, true);
        AppMethodBeat.o(162272);
      }
      
      public final void c(final dil paramAnonymousdil)
      {
        AppMethodBeat.i(162273);
        Log.i("MicroMsg.MallWalletUI", "net callback: %s", new Object[] { paramAnonymousdil });
        if (MallWalletUI.b(MallWalletUI.this) != null)
        {
          MallWalletUI.b(MallWalletUI.this).dismiss();
          MallWalletUI.c(MallWalletUI.this);
        }
        if (paramAnonymousdil != null)
        {
          if (paramAnonymousdil.MMX != null)
          {
            MallWalletUI.a(MallWalletUI.this, paramAnonymousdil.MMX);
            MallWalletUI.a(MallWalletUI.this, false);
          }
          if ((paramAnonymousdil.KEP != null) && (paramAnonymousdil.KEP.type == 13)) {
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
                  localObject1 = paramAnonymousdil.KEP.MTl;
                  local1 = new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymous3View)
                    {
                      AppMethodBeat.i(162270);
                      b localb = new b();
                      localb.bm(paramAnonymous3View);
                      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/mall/ui/MallWalletUI$2$1$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
                      MallWalletUI.d(MallWalletUI.this).dismiss();
                      com.tencent.mm.plugin.report.service.h.CyF.a(16500, new Object[] { Integer.valueOf(5) });
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
                  locala = new com.tencent.mm.plugin.crashfix.b.a((Context)localObject2, 2131821772);
                  ViewGroup localViewGroup = (ViewGroup)LayoutInflater.from((Context)localObject2).inflate(2131496920, null, false);
                  Object localObject3;
                  int i;
                  if ((((aep)localObject1).LpV != null) && (((aep)localObject1).LpV.MxV != null))
                  {
                    localObject3 = (CdnImageView)localViewGroup.findViewById(2131310346);
                    localObject4 = ((aep)localObject1).LpV.MxV;
                    if (((csw)localObject4).type == 1)
                    {
                      com.tencent.mm.plugin.wallet_core.utils.g.a((CdnImageView)localObject3, ((csw)localObject4).KZS, 2131233137, true);
                      i = BackwardSupportUtil.BitmapFactory.fromDPToPix((Context)localObject2, 50.0F);
                      Util.expandViewTouchArea((View)localObject3, i, i, i, i);
                      ((CdnImageView)localObject3).setOnClickListener(new g.2(locala));
                    }
                  }
                  Object localObject4 = (LinearLayout)localViewGroup.findViewById(2131310344);
                  if ((((aep)localObject1).LpX != null) && (!((aep)localObject1).LpX.isEmpty()))
                  {
                    Iterator localIterator = ((aep)localObject1).LpX.iterator();
                    while (localIterator.hasNext())
                    {
                      localObject1 = (erb)localIterator.next();
                      localObject2 = new LinearLayout.LayoutParams(-2, -2);
                      if (((erb)localObject1).type == 1)
                      {
                        localObject3 = new TextView(((LinearLayout)localObject4).getContext());
                        com.tencent.mm.plugin.wallet_core.utils.g.a((TextView)localObject3, ((erb)localObject1).Lov, null);
                        com.tencent.mm.plugin.wallet_core.utils.g.a((View)localObject3, (ViewGroup.MarginLayoutParams)localObject2, ((erb)localObject1).NoK);
                        ((LinearLayout)localObject4).addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
                      }
                      else if (((erb)localObject1).type == 11)
                      {
                        localObject3 = new CdnImageView(((LinearLayout)localObject4).getContext());
                        i = com.tencent.mm.cb.a.fromDPToPix(((LinearLayout)localObject4).getContext(), 64);
                        com.tencent.mm.plugin.wallet_core.utils.g.a((CdnImageView)localObject3, ((erb)localObject1).KZS, -1, false);
                        ((CdnImageView)localObject3).setMinimumWidth(i);
                        ((CdnImageView)localObject3).setMinimumHeight(i);
                        com.tencent.mm.plugin.wallet_core.utils.g.a((View)localObject3, (ViewGroup.MarginLayoutParams)localObject2, ((erb)localObject1).NoK);
                        ((LinearLayout)localObject4).addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
                      }
                      else if (((erb)localObject1).type == 20)
                      {
                        localObject2 = ((erb)localObject1).NoJ;
                        erg localerg = ((erb)localObject1).NoK;
                        if (localObject2 != null)
                        {
                          ((LinearLayout)localObject4).setGravity(1);
                          if (((sj)localObject2).KZU != null)
                          {
                            LinearLayout localLinearLayout = new LinearLayout(((LinearLayout)localObject4).getContext());
                            localLinearLayout.setGravity(48);
                            localLinearLayout.setOrientation(0);
                            localObject1 = ((LinearLayout)localObject4).getContext();
                            localObject3 = ((sj)localObject2).KZU.Lou;
                            label595:
                            TextView localTextView;
                            Context localContext;
                            si localsi;
                            if (localObject3 != null) {
                              if (((efu)localObject3).NfN == 0)
                              {
                                localObject1 = new MMSwitchBtn((Context)localObject1);
                                if (((efu)localObject3).MMP == 0)
                                {
                                  ((MMSwitchBtn)localObject1).setCheck(false);
                                  localTextView = new TextView(((LinearLayout)localObject4).getContext());
                                  com.tencent.mm.plugin.wallet_core.utils.g.a(localTextView, ((sj)localObject2).KZU.Lov, null);
                                  localContext = ((LinearLayout)localObject4).getContext();
                                  localsi = ((sj)localObject2).KZV;
                                  if (localsi == null) {
                                    break label1174;
                                  }
                                  if (localsi.gTu != 1) {
                                    break label1085;
                                  }
                                  localObject3 = new Button(localContext);
                                  ((Button)localObject3).setTextSize(0, com.tencent.mm.cb.a.aG(localContext, 2131165495));
                                  ((Button)localObject3).setTextColor(com.tencent.mm.cb.a.m(localContext, 2131100194));
                                  ((Button)localObject3).setBackgroundResource(2131231429);
                                  ((Button)localObject3).setGravity(17);
                                  ((Button)localObject3).setAllCaps(true);
                                  ((Button)localObject3).setPadding(com.tencent.mm.cb.a.aG(localContext, 2131165580), 0, com.tencent.mm.cb.a.aG(localContext, 2131165580), 0);
                                  ((Button)localObject3).setWidth(com.tencent.mm.cb.a.fromDPToPix(localContext, 184));
                                  ((Button)localObject3).setHeight(com.tencent.mm.cb.a.fromDPToPix(localContext, 40));
                                  if (localsi.state != 1) {
                                    break label1076;
                                  }
                                  ((Button)localObject3).setEnabled(true);
                                  label772:
                                  ((Button)localObject3).setText(localsi.text);
                                  localObject2 = localObject3;
                                  if (localsi.pTI == 1)
                                  {
                                    ((Button)localObject3).setOnClickListener(new g.5(localContext, localsi, local1));
                                    localObject2 = localObject3;
                                  }
                                  label815:
                                  localObject3 = new LinearLayout.LayoutParams(-2, -2);
                                  if ((localerg != null) && (localerg.NoS != null)) {
                                    ((LinearLayout.LayoutParams)localObject3).topMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int)localerg.NoS.top);
                                  }
                                  ((LinearLayout.LayoutParams)localObject3).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 32);
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
                              if ((localerg != null) && (localerg.NoS != null)) {
                                ((LinearLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), (int)localerg.NoS.bottom);
                              }
                              ((LinearLayout)localObject4).addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
                              break;
                              if (((efu)localObject3).MMP == 1)
                              {
                                ((MMSwitchBtn)localObject1).setCheck(true);
                                break label595;
                              }
                              ((MMSwitchBtn)localObject1).setEnabled(false);
                              break label595;
                              if (((efu)localObject3).NfN == 1)
                              {
                                localObject1 = new CheckBox((Context)localObject1);
                                ((CheckBox)localObject1).setBackgroundResource(2131233932);
                                if (((efu)localObject3).MMP == 0)
                                {
                                  ((CheckBox)localObject1).setChecked(false);
                                  break label595;
                                }
                                if (((efu)localObject3).MMP == 1)
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
                              if (localsi.gTu == 0)
                              {
                                localObject3 = new CdnImageView(localContext);
                                com.tencent.mm.plugin.wallet_core.utils.g.a((CdnImageView)localObject3, localsi.KZS);
                                if (localsi.state == 1) {
                                  ((CdnImageView)localObject3).setEnabled(true);
                                }
                                for (;;)
                                {
                                  localObject2 = localObject3;
                                  if (localsi.pTI != 1) {
                                    break;
                                  }
                                  ((CdnImageView)localObject3).setOnClickListener(new g.6(localContext, localsi, local1));
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
    Y(true, true);
    this.zng.alive();
    AppMethodBeat.o(66170);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66174);
    super.onDestroy();
    this.zng.dead();
    j.a(this.zne);
    ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg().remove(this);
    AppMethodBeat.o(66174);
  }
  
  public void onNotifyChange(int paramInt, MStorageEx paramMStorageEx, Object paramObject)
  {
    AppMethodBeat.i(66179);
    if ((paramMStorageEx == ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ah(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg()) && (paramInt == 4))
    {
      Log.i("MicroMsg.MallWalletUI", "on cache update: %s", new Object[] { paramObject });
      if ((paramObject.equals("USERINFO_NEW_BALANCE_LONG")) || (paramObject.equals("USERINFO_NEW_LQT_LONG"))) {
        is(false);
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
    if (this.znf)
    {
      Log.i("MicroMsg.MallWalletUI", "fenfu refresh");
      this.znf = false;
      Y(false, false);
    }
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallWalletUI
 * JD-Core Version:    0.7.0.1
 */
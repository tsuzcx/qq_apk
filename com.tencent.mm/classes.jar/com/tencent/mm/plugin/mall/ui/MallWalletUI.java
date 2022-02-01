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
import com.tencent.mm.g.a.vh;
import com.tencent.mm.plugin.mall.a.i;
import com.tencent.mm.plugin.mall.a.i.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.wallet_core.utils.g.2;
import com.tencent.mm.plugin.wallet_core.utils.g.3;
import com.tencent.mm.plugin.wallet_core.utils.g.4;
import com.tencent.mm.plugin.wallet_core.utils.g.5;
import com.tencent.mm.plugin.wallet_core.utils.g.6;
import com.tencent.mm.plugin.wallet_core.utils.g.7;
import com.tencent.mm.plugin.wallet_core.utils.g.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bif;
import com.tencent.mm.protocal.protobuf.bov;
import com.tencent.mm.protocal.protobuf.bsp;
import com.tencent.mm.protocal.protobuf.bsq;
import com.tencent.mm.protocal.protobuf.cfp;
import com.tencent.mm.protocal.protobuf.cmc;
import com.tencent.mm.protocal.protobuf.dak;
import com.tencent.mm.protocal.protobuf.daw;
import com.tencent.mm.protocal.protobuf.dbp;
import com.tencent.mm.protocal.protobuf.dca;
import com.tencent.mm.protocal.protobuf.dkr;
import com.tencent.mm.protocal.protobuf.dku;
import com.tencent.mm.protocal.protobuf.ps;
import com.tencent.mm.protocal.protobuf.pt;
import com.tencent.mm.protocal.protobuf.ye;
import com.tencent.mm.protocal.protobuf.zg;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.wallet_core.c.aa;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MallWalletUI
  extends WalletBaseUI
  implements n.b
{
  private static final int tvw;
  private Dialog mProgressDialog;
  private boolean tpR;
  private Dialog tvA;
  private i.a tvB;
  private boolean tvC;
  private c<vh> tvD;
  private LinearLayout tvx;
  private LinearLayout tvy;
  private daw tvz;
  
  static
  {
    AppMethodBeat.i(66181);
    tvw = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 8);
    AppMethodBeat.o(66181);
  }
  
  public MallWalletUI()
  {
    AppMethodBeat.i(162275);
    this.tpR = false;
    this.tvC = false;
    this.tvD = new c() {};
    AppMethodBeat.o(162275);
  }
  
  private void Q(boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(66176);
    ad.i("MicroMsg.MallWalletUI", "do query wechat wallet");
    if (paramBoolean2) {
      this.mProgressDialog = com.tencent.mm.wallet_core.ui.g.c(this, false, null);
    }
    i.a(this.tvB, true, paramBoolean1);
    AppMethodBeat.o(66176);
  }
  
  private void ef(List<dbp> paramList)
  {
    AppMethodBeat.i(66178);
    if ((paramList == null) || (paramList.isEmpty()))
    {
      AppMethodBeat.o(66178);
      return;
    }
    this.tvy.removeAllViews();
    paramList.size();
    paramList = paramList.iterator();
    int i = 0;
    while (paramList.hasNext())
    {
      Object localObject = (dbp)paramList.next();
      TextView localTextView = new TextView(this);
      com.tencent.mm.plugin.wallet_core.utils.g.a(localTextView, (dbp)localObject, new g.a()
      {
        public final void a(cmc paramAnonymousVarArgs)
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
            h.vKh.f(16502, new Object[] { Integer.valueOf(2), paramAnonymousVarArgs, Integer.valueOf(i) });
            AppMethodBeat.o(162274);
            return;
            if ((paramAnonymousVarArgs.type == 2) && (paramAnonymousVarArgs.Ehg != null))
            {
              paramAnonymousVarArgs = paramAnonymousVarArgs.Ehg.username;
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
        ((LinearLayout.LayoutParams)localObject).topMargin = com.tencent.mm.cd.a.fromDPToPix(this, 8);
      }
      this.tvy.addView(localTextView, (ViewGroup.LayoutParams)localObject);
      i += 1;
    }
    AppMethodBeat.o(66178);
  }
  
  private void gP(boolean paramBoolean)
  {
    AppMethodBeat.i(66177);
    if (this.tvz != null)
    {
      Object localObject1 = this.tvz.EsI;
      Object localObject2;
      if (localObject1 != null)
      {
        setMMTitle(com.tencent.mm.plugin.wallet_core.utils.g.a(this, ((bsp)localObject1).Cvo, null));
        localObject1 = ((bsp)localObject1).DPN;
        localObject2 = new g.a()
        {
          public final void a(cmc paramAnonymousVarArgs)
          {
            AppMethodBeat.i(66169);
            h.vKh.f(16502, new Object[] { Integer.valueOf(1) });
            AppMethodBeat.o(66169);
          }
        };
        if ((localObject1 != null) && (((bsq)localObject1).type == 2) && (((bsq)localObject1).Dah != null)) {
          addTextOptionMenu(0, com.tencent.mm.plugin.wallet_core.utils.g.a(this, ((bsq)localObject1).Dah), new g.7((bsq)localObject1, (g.a)localObject2, this));
        }
      }
      ad.i("MicroMsg.MallWalletUI", "section size: %s", new Object[] { this.tvz.DxQ });
      int j = this.tvx.getChildCount();
      int k = this.tvz.DxQ.size();
      int i = 0;
      if (i < k)
      {
        localObject2 = (bif)this.tvz.DxQ.get(i);
        if (i < j)
        {
          ad.d("MicroMsg.MallWalletUI", "update layout");
          ((MallWalletSectionView)this.tvx.getChildAt(i)).a((bif)localObject2, paramBoolean);
        }
        for (;;)
        {
          i += 1;
          break;
          ad.d("MicroMsg.MallWalletUI", "insert layout");
          localObject1 = new MallWalletSectionView(getContext());
          ((MallWalletSectionView)localObject1).a((bif)localObject2, paramBoolean);
          localObject2 = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject2).topMargin = tvw;
          ((MallWalletSectionView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.tvx.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        }
      }
      if (j > k)
      {
        ad.d("MicroMsg.MallWalletUI", "remove layout");
        this.tvx.removeViews(k, j - k);
      }
      ef(this.tvz.EsJ);
    }
    AppMethodBeat.o(66177);
  }
  
  public final void a(int paramInt, com.tencent.mm.sdk.e.n paramn, Object paramObject)
  {
    AppMethodBeat.i(66179);
    if ((paramn == ((com.tencent.mm.plugin.wxpay.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.wxpay.a.a.class)).getWalletCacheStg()) && (paramInt == 4))
    {
      ad.i("MicroMsg.MallWalletUI", "on cache update: %s", new Object[] { paramObject });
      if ((paramObject.equals("USERINFO_NEW_BALANCE_LONG")) || (paramObject.equals("USERINFO_NEW_LQT_LONG"))) {
        gP(false);
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
    this.tvx = ((LinearLayout)findViewById(2131302643));
    this.tvy = ((LinearLayout)findViewById(2131302642));
    AppMethodBeat.o(66171);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(66175);
    ad.i("MicroMsg.MallWalletUI", "requestCode: %s, resultCode: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((paramInt1 == 65281) || (paramInt1 == 65286))
    {
      Q(false, false);
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
    this.tvB = new i.a()
    {
      public final void b(cfp paramAnonymouscfp)
      {
        AppMethodBeat.i(162272);
        ad.i("MicroMsg.MallWalletUI", "cache callback");
        if (MallWalletUI.b(MallWalletUI.this) != null)
        {
          MallWalletUI.b(MallWalletUI.this).dismiss();
          MallWalletUI.c(MallWalletUI.this);
        }
        MallWalletUI.a(MallWalletUI.this, paramAnonymouscfp.EbJ);
        MallWalletUI.a(MallWalletUI.this, true);
        AppMethodBeat.o(162272);
      }
      
      public final void c(final cfp paramAnonymouscfp)
      {
        AppMethodBeat.i(162273);
        ad.i("MicroMsg.MallWalletUI", "net callback: %s", new Object[] { paramAnonymouscfp });
        if (MallWalletUI.b(MallWalletUI.this) != null)
        {
          MallWalletUI.b(MallWalletUI.this).dismiss();
          MallWalletUI.c(MallWalletUI.this);
        }
        if (paramAnonymouscfp != null)
        {
          if (paramAnonymouscfp.EbJ != null)
          {
            MallWalletUI.a(MallWalletUI.this, paramAnonymouscfp.EbJ);
            MallWalletUI.a(MallWalletUI.this, false);
          }
          if ((paramAnonymouscfp.Cvq != null) && (paramAnonymouscfp.Cvq.type == 13)) {
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
                  localObject1 = paramAnonymouscfp.Cvq.Ehk;
                  local1 = new View.OnClickListener()
                  {
                    public final void onClick(View paramAnonymous3View)
                    {
                      AppMethodBeat.i(162270);
                      MallWalletUI.d(MallWalletUI.this).dismiss();
                      h.vKh.f(16500, new Object[] { Integer.valueOf(5) });
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
                  if ((((zg)localObject1).Dbp != null) && (((zg)localObject1).Dbp.DPO != null))
                  {
                    localObject3 = (CdnImageView)localViewGroup.findViewById(2131306878);
                    localObject4 = ((zg)localObject1).Dbp.DPO;
                    if (((bsq)localObject4).type == 1)
                    {
                      com.tencent.mm.plugin.wallet_core.utils.g.a((CdnImageView)localObject3, ((bsq)localObject4).COd, 2131232705, true);
                      i = BackwardSupportUtil.b.g((Context)localObject2, 50.0F);
                      bt.n((View)localObject3, i, i, i, i);
                      ((CdnImageView)localObject3).setOnClickListener(new g.2(locala));
                    }
                  }
                  Object localObject4 = (LinearLayout)localViewGroup.findViewById(2131306876);
                  if ((((zg)localObject1).Dbr != null) && (!((zg)localObject1).Dbr.isEmpty()))
                  {
                    Iterator localIterator = ((zg)localObject1).Dbr.iterator();
                    while (localIterator.hasNext())
                    {
                      localObject1 = (dkr)localIterator.next();
                      localObject2 = new LinearLayout.LayoutParams(-2, -2);
                      if (((dkr)localObject1).type == 1)
                      {
                        localObject3 = new TextView(((LinearLayout)localObject4).getContext());
                        com.tencent.mm.plugin.wallet_core.utils.g.a((TextView)localObject3, ((dkr)localObject1).Dah, null);
                        com.tencent.mm.plugin.wallet_core.utils.g.a((View)localObject3, (ViewGroup.MarginLayoutParams)localObject2, ((dkr)localObject1).EAx);
                        ((LinearLayout)localObject4).addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
                      }
                      else if (((dkr)localObject1).type == 11)
                      {
                        localObject3 = new CdnImageView(((LinearLayout)localObject4).getContext());
                        i = com.tencent.mm.cd.a.fromDPToPix(((LinearLayout)localObject4).getContext(), 64);
                        com.tencent.mm.plugin.wallet_core.utils.g.a((CdnImageView)localObject3, ((dkr)localObject1).COd, -1, false);
                        ((CdnImageView)localObject3).setMinimumWidth(i);
                        ((CdnImageView)localObject3).setMinimumHeight(i);
                        com.tencent.mm.plugin.wallet_core.utils.g.a((View)localObject3, (ViewGroup.MarginLayoutParams)localObject2, ((dkr)localObject1).EAx);
                        ((LinearLayout)localObject4).addView((View)localObject3, (ViewGroup.LayoutParams)localObject2);
                      }
                      else if (((dkr)localObject1).type == 20)
                      {
                        localObject2 = ((dkr)localObject1).EAw;
                        dku localdku = ((dkr)localObject1).EAx;
                        if (localObject2 != null)
                        {
                          ((LinearLayout)localObject4).setGravity(1);
                          if (((pt)localObject2).COf != null)
                          {
                            LinearLayout localLinearLayout = new LinearLayout(((LinearLayout)localObject4).getContext());
                            localLinearLayout.setGravity(48);
                            localLinearLayout.setOrientation(0);
                            localObject1 = ((LinearLayout)localObject4).getContext();
                            localObject3 = ((pt)localObject2).COf.Dag;
                            label595:
                            TextView localTextView;
                            Context localContext;
                            ps localps;
                            if (localObject3 != null) {
                              if (((dak)localObject3).Esf == 0)
                              {
                                localObject1 = new MMSwitchBtn((Context)localObject1);
                                if (((dak)localObject3).EbB == 0)
                                {
                                  ((MMSwitchBtn)localObject1).setCheck(false);
                                  localTextView = new TextView(((LinearLayout)localObject4).getContext());
                                  com.tencent.mm.plugin.wallet_core.utils.g.a(localTextView, ((pt)localObject2).COf.Dah, null);
                                  localContext = ((LinearLayout)localObject4).getContext();
                                  localps = ((pt)localObject2).COg;
                                  if (localps == null) {
                                    break label1174;
                                  }
                                  if (localps.COc != 1) {
                                    break label1085;
                                  }
                                  localObject3 = new Button(localContext);
                                  ((Button)localObject3).setTextSize(0, com.tencent.mm.cd.a.ao(localContext, 2131165477));
                                  ((Button)localObject3).setTextColor(com.tencent.mm.cd.a.m(localContext, 2131100161));
                                  ((Button)localObject3).setBackgroundResource(2131231365);
                                  ((Button)localObject3).setGravity(17);
                                  ((Button)localObject3).setAllCaps(true);
                                  ((Button)localObject3).setPadding(com.tencent.mm.cd.a.ao(localContext, 2131165562), 0, com.tencent.mm.cd.a.ao(localContext, 2131165562), 0);
                                  ((Button)localObject3).setWidth(com.tencent.mm.cd.a.fromDPToPix(localContext, 184));
                                  ((Button)localObject3).setHeight(com.tencent.mm.cd.a.fromDPToPix(localContext, 40));
                                  if (localps.state != 1) {
                                    break label1076;
                                  }
                                  ((Button)localObject3).setEnabled(true);
                                  label772:
                                  ((Button)localObject3).setText(localps.text);
                                  localObject2 = localObject3;
                                  if (localps.ntg == 1)
                                  {
                                    ((Button)localObject3).setOnClickListener(new g.5(localContext, localps, local1));
                                    localObject2 = localObject3;
                                  }
                                  label815:
                                  localObject3 = new LinearLayout.LayoutParams(-2, -2);
                                  if ((localdku != null) && (localdku.EAy != null)) {
                                    ((LinearLayout.LayoutParams)localObject3).topMargin = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), (int)localdku.EAy.top);
                                  }
                                  ((LinearLayout.LayoutParams)localObject3).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 32);
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
                              if ((localdku != null) && (localdku.EAy != null)) {
                                ((LinearLayout.LayoutParams)localObject1).bottomMargin = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), (int)localdku.EAy.bottom);
                              }
                              ((LinearLayout)localObject4).addView((View)localObject2, (ViewGroup.LayoutParams)localObject1);
                              break;
                              if (((dak)localObject3).EbB == 1)
                              {
                                ((MMSwitchBtn)localObject1).setCheck(true);
                                break label595;
                              }
                              ((MMSwitchBtn)localObject1).setEnabled(false);
                              break label595;
                              if (((dak)localObject3).Esf == 1)
                              {
                                localObject1 = new CheckBox((Context)localObject1);
                                ((CheckBox)localObject1).setBackgroundResource(2131233261);
                                if (((dak)localObject3).EbB == 0)
                                {
                                  ((CheckBox)localObject1).setChecked(false);
                                  break label595;
                                }
                                if (((dak)localObject3).EbB == 1)
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
                              if (localps.COc == 0)
                              {
                                localObject3 = new CdnImageView(localContext);
                                com.tencent.mm.plugin.wallet_core.utils.g.a((CdnImageView)localObject3, localps.COd);
                                if (localps.state == 1) {
                                  ((CdnImageView)localObject3).setEnabled(true);
                                }
                                for (;;)
                                {
                                  localObject2 = localObject3;
                                  if (localps.ntg != 1) {
                                    break;
                                  }
                                  ((CdnImageView)localObject3).setOnClickListener(new g.6(localContext, localps, local1));
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
    Q(true, true);
    this.tvD.alive();
    AppMethodBeat.o(66170);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66174);
    super.onDestroy();
    this.tvD.dead();
    i.a(this.tvB);
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
    if (this.tvC)
    {
      ad.i("MicroMsg.MallWalletUI", "fenfu refresh");
      this.tvC = false;
      Q(false, false);
    }
    AppMethodBeat.o(66172);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.al.n paramn)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallWalletUI
 * JD-Core Version:    0.7.0.1
 */
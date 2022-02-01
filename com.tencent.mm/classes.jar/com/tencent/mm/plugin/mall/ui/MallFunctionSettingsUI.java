package com.tencent.mm.plugin.mall.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.c.a;
import com.tencent.mm.ak.q;
import com.tencent.mm.co.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bsh;
import com.tencent.mm.protocal.protobuf.czt;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MallFunctionSettingsUI
  extends WalletBaseUI
{
  int efI;
  private ListView zkQ;
  private final int zkR;
  private TextView zkS;
  private TextView zkT;
  private a zkU;
  private List<b> zkV;
  private com.tencent.mm.plugin.mall.a.b zkW;
  
  public MallFunctionSettingsUI()
  {
    AppMethodBeat.i(66057);
    this.zkR = com.tencent.mm.cb.a.fromDPToPix(MMApplicationContext.getContext(), 40);
    this.zkV = new ArrayList();
    AppMethodBeat.o(66057);
  }
  
  public int getLayoutId()
  {
    return 2131495418;
  }
  
  public void initView()
  {
    AppMethodBeat.i(66059);
    this.zkQ = ((ListView)findViewById(2131304655));
    this.zkU = new a((byte)0);
    ViewGroup localViewGroup = (ViewGroup)View.inflate(this, 2131495415, null);
    this.zkQ.addHeaderView(localViewGroup, null, false);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setMinimumHeight(com.tencent.mm.cb.a.fromDPToPix(getContext(), 80));
    this.zkQ.addFooterView(localLinearLayout, null, false);
    this.zkQ.setAdapter(this.zkU);
    this.zkS = ((TextView)localViewGroup.findViewById(2131304647));
    this.zkT = ((TextView)localViewGroup.findViewById(2131304646));
    AppMethodBeat.o(66059);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66058);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131101424));
    hideActionbarLine();
    this.efI = ((Integer)g.aAh().azQ().get(ar.a.NXG, Integer.valueOf(0))).intValue();
    Log.i("MicroMsg.MallFunctionSettingsUI", "wallet region: %s", new Object[] { Integer.valueOf(this.efI) });
    initView();
    setMMTitle("");
    Log.i("MicroMsg.MallFunctionSettingsUI", "do get function list");
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)g.af(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.sad, true);
    Log.i("MicroMsg.MallFunctionSettingsUI", " walletMallV2 is ：%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      this.zkW = new com.tencent.mm.plugin.mall.a.b(this.efI, i);
      this.zkW.aYI().b(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(66058);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66060);
    super.onDestroy();
    this.zkW.cancel();
    AppMethodBeat.o(66060);
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
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    private MallFunctionSettingsUI.b Qh(int paramInt)
    {
      AppMethodBeat.i(66052);
      MallFunctionSettingsUI.b localb = (MallFunctionSettingsUI.b)MallFunctionSettingsUI.b(MallFunctionSettingsUI.this).get(paramInt);
      AppMethodBeat.o(66052);
      return localb;
    }
    
    public final int getCount()
    {
      AppMethodBeat.i(66051);
      int i = MallFunctionSettingsUI.b(MallFunctionSettingsUI.this).size();
      AppMethodBeat.o(66051);
      return i;
    }
    
    public final long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public final int getItemViewType(int paramInt)
    {
      AppMethodBeat.i(66053);
      paramInt = ((MallFunctionSettingsUI.b)MallFunctionSettingsUI.b(MallFunctionSettingsUI.this).get(paramInt)).type;
      AppMethodBeat.o(66053);
      return paramInt;
    }
    
    public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      AppMethodBeat.i(66054);
      Object localObject1 = paramView;
      Object localObject2;
      if (paramView == null)
      {
        int i = getItemViewType(paramInt);
        localObject1 = new MallFunctionSettingsUI.c(MallFunctionSettingsUI.this, (byte)0);
        if (i == 1)
        {
          paramView = LayoutInflater.from(MallFunctionSettingsUI.this.getContext()).inflate(2131495416, paramViewGroup, false);
          ((MallFunctionSettingsUI.c)localObject1).ymf = ((CdnImageView)paramView.findViewById(2131304651));
          ((MallFunctionSettingsUI.c)localObject1).mPa = ((TextView)paramView.findViewById(2131304653));
          ((MallFunctionSettingsUI.c)localObject1).jVn = ((TextView)paramView.findViewById(2131304649));
          ((MallFunctionSettingsUI.c)localObject1).jBx = ((MMSwitchBtn)paramView.findViewById(2131304652));
          ((MallFunctionSettingsUI.c)localObject1).zlb = paramView.findViewById(2131304650);
          ((MallFunctionSettingsUI.c)localObject1).zlc = paramView.findViewById(2131304648);
          ((MallFunctionSettingsUI.c)localObject1).oby = ((ViewGroup)paramView);
          ((MallFunctionSettingsUI.c)localObject1).ymf.setUseSdcardCache(true);
          paramView.setTag(localObject1);
          localObject1 = paramView;
        }
      }
      else
      {
        paramView = Qh(paramInt);
        paramViewGroup = (MallFunctionSettingsUI.c)((View)localObject1).getTag();
        if (paramView.type != 1) {
          break label602;
        }
        localObject2 = paramView.zkZ;
        if (!com.tencent.mm.ui.ao.isDarkMode()) {
          break label457;
        }
        if (((czt)localObject2).MFb == null) {
          break label434;
        }
        paramViewGroup.ymf.setUrl(((czt)localObject2).MFb);
        label217:
        if (((czt)localObject2).MEX != null) {
          paramViewGroup.mPa.setText(((czt)localObject2).MEX);
        }
        if ((((czt)localObject2).MEZ == null) || (Util.isNullOrNil(((czt)localObject2).MEZ))) {
          break label480;
        }
        paramViewGroup.jVn.setText(((czt)localObject2).MEZ);
        paramViewGroup.jVn.setVisibility(0);
        label276:
        if (((czt)localObject2).oTW != 0) {
          break label492;
        }
        paramViewGroup.jBx.setCheck(true);
        paramViewGroup.jBx.setEnabled(true);
        paramViewGroup.mPa.setTextColor(paramViewGroup.zkX.getContext().getResources().getColor(2131100046));
        paramViewGroup.zlc.setVisibility(8);
        label331:
        paramViewGroup.jBx.setSwitchListener(new MallFunctionSettingsUI.c.1(paramViewGroup, (czt)localObject2));
        localObject2 = (LinearLayout.LayoutParams)paramViewGroup.zlb.getLayoutParams();
        if (!paramView.zla) {
          break label587;
        }
        ((LinearLayout.LayoutParams)localObject2).leftMargin = 0;
        label373:
        paramViewGroup.zlb.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      for (;;)
      {
        AppMethodBeat.o(66054);
        return localObject1;
        paramView = LayoutInflater.from(MallFunctionSettingsUI.this.getContext()).inflate(2131495417, paramViewGroup, false);
        ((MallFunctionSettingsUI.c)localObject1).mPa = ((TextView)paramView.findViewById(2131304654));
        ((MallFunctionSettingsUI.c)localObject1).oby = ((ViewGroup)paramView);
        break;
        label434:
        if (((czt)localObject2).MEY == null) {
          break label217;
        }
        paramViewGroup.ymf.setUrl(((czt)localObject2).MEY);
        break label217;
        label457:
        if (((czt)localObject2).MEY == null) {
          break label217;
        }
        paramViewGroup.ymf.setUrl(((czt)localObject2).MEY);
        break label217;
        label480:
        paramViewGroup.jVn.setVisibility(8);
        break label276;
        label492:
        if (((czt)localObject2).oTW == 1)
        {
          paramViewGroup.jBx.setCheck(false);
          paramViewGroup.jBx.setEnabled(true);
          paramViewGroup.mPa.setTextColor(paramViewGroup.zkX.getContext().getResources().getColor(2131100046));
          paramViewGroup.zlc.setVisibility(8);
          break label331;
        }
        if (((czt)localObject2).oTW != 2) {
          break label331;
        }
        paramViewGroup.jBx.setCheck(false);
        paramViewGroup.jBx.setEnabled(false);
        paramViewGroup.zlc.setVisibility(0);
        break label331;
        label587:
        ((LinearLayout.LayoutParams)localObject2).leftMargin = MallFunctionSettingsUI.c(paramViewGroup.zkX);
        break label373;
        label602:
        if (paramView.type == 0) {
          paramViewGroup.mPa.setText(paramView.title);
        }
      }
    }
    
    public final int getViewTypeCount()
    {
      return 2;
    }
  }
  
  static final class b
  {
    String title;
    int type;
    czt zkZ;
    boolean zla = false;
  }
  
  final class c
  {
    MMSwitchBtn jBx;
    TextView jVn;
    TextView mPa;
    ViewGroup oby;
    CdnImageView ymf;
    View zlb;
    View zlc;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallFunctionSettingsUI
 * JD-Core Version:    0.7.0.1
 */
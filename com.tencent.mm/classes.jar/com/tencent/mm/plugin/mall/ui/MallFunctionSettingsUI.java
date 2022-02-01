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
import com.tencent.mm.al.a.a;
import com.tencent.mm.al.n;
import com.tencent.mm.cn.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bfv;
import com.tencent.mm.protocal.protobuf.cir;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MallFunctionSettingsUI
  extends WalletBaseUI
{
  int dMx;
  private ListView vEI;
  private final int vEJ;
  private TextView vEK;
  private TextView vEL;
  private a vEM;
  private List<b> vEN;
  private com.tencent.mm.plugin.mall.a.b vEO;
  
  public MallFunctionSettingsUI()
  {
    AppMethodBeat.i(66057);
    this.vEJ = com.tencent.mm.cc.a.fromDPToPix(aj.getContext(), 40);
    this.vEN = new ArrayList();
    AppMethodBeat.o(66057);
  }
  
  public int getLayoutId()
  {
    return 2131494691;
  }
  
  public void initView()
  {
    AppMethodBeat.i(66059);
    this.vEI = ((ListView)findViewById(2131302268));
    this.vEM = new a((byte)0);
    ViewGroup localViewGroup = (ViewGroup)View.inflate(this, 2131494688, null);
    this.vEI.addHeaderView(localViewGroup, null, false);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setMinimumHeight(com.tencent.mm.cc.a.fromDPToPix(getContext(), 80));
    this.vEI.addFooterView(localLinearLayout, null, false);
    this.vEI.setAdapter(this.vEM);
    this.vEK = ((TextView)localViewGroup.findViewById(2131302260));
    this.vEL = ((TextView)localViewGroup.findViewById(2131302259));
    AppMethodBeat.o(66059);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66058);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131101179));
    hideActionbarLine();
    this.dMx = ((Integer)g.ajC().ajl().get(al.a.Ivh, Integer.valueOf(0))).intValue();
    ad.i("MicroMsg.MallFunctionSettingsUI", "wallet region: %s", new Object[] { Integer.valueOf(this.dMx) });
    initView();
    setMMTitle("");
    ad.i("MicroMsg.MallFunctionSettingsUI", "do get function list");
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qzF, false);
    ad.i("MicroMsg.MallFunctionSettingsUI", " walletMallV2 is ：%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      this.vEO = new com.tencent.mm.plugin.mall.a.b(this.dMx, i);
      this.vEO.aED().b(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(66058);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66060);
    super.onDestroy();
    this.vEO.cancel();
    AppMethodBeat.o(66060);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
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
    
    private MallFunctionSettingsUI.b JG(int paramInt)
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
          paramView = LayoutInflater.from(MallFunctionSettingsUI.this.getContext()).inflate(2131494689, paramViewGroup, false);
          ((MallFunctionSettingsUI.c)localObject1).uHR = ((CdnImageView)paramView.findViewById(2131302264));
          ((MallFunctionSettingsUI.c)localObject1).lCL = ((TextView)paramView.findViewById(2131302266));
          ((MallFunctionSettingsUI.c)localObject1).lDu = ((TextView)paramView.findViewById(2131302262));
          ((MallFunctionSettingsUI.c)localObject1).iCB = ((MMSwitchBtn)paramView.findViewById(2131302265));
          ((MallFunctionSettingsUI.c)localObject1).qkV = paramView.findViewById(2131302263);
          ((MallFunctionSettingsUI.c)localObject1).vET = paramView.findViewById(2131302261);
          ((MallFunctionSettingsUI.c)localObject1).mJu = ((ViewGroup)paramView);
          ((MallFunctionSettingsUI.c)localObject1).uHR.setUseSdcardCache(true);
          paramView.setTag(localObject1);
          localObject1 = paramView;
        }
      }
      else
      {
        paramView = JG(paramInt);
        paramViewGroup = (MallFunctionSettingsUI.c)((View)localObject1).getTag();
        if (paramView.type != 1) {
          break label602;
        }
        localObject2 = paramView.vER;
        if (!al.isDarkMode()) {
          break label457;
        }
        if (((cir)localObject2).HcC == null) {
          break label434;
        }
        paramViewGroup.uHR.setUrl(((cir)localObject2).HcC);
        label217:
        if (((cir)localObject2).Hcy != null) {
          paramViewGroup.lCL.setText(((cir)localObject2).Hcy);
        }
        if ((((cir)localObject2).HcA == null) || (bt.isNullOrNil(((cir)localObject2).HcA))) {
          break label480;
        }
        paramViewGroup.lDu.setText(((cir)localObject2).HcA);
        paramViewGroup.lDu.setVisibility(0);
        label276:
        if (((cir)localObject2).nDG != 0) {
          break label492;
        }
        paramViewGroup.iCB.setCheck(true);
        paramViewGroup.iCB.setEnabled(true);
        paramViewGroup.lCL.setTextColor(paramViewGroup.vEP.getContext().getResources().getColor(2131100020));
        paramViewGroup.vET.setVisibility(8);
        label331:
        paramViewGroup.iCB.setSwitchListener(new MallFunctionSettingsUI.c.1(paramViewGroup, (cir)localObject2));
        localObject2 = (LinearLayout.LayoutParams)paramViewGroup.qkV.getLayoutParams();
        if (!paramView.vES) {
          break label587;
        }
        ((LinearLayout.LayoutParams)localObject2).leftMargin = 0;
        label373:
        paramViewGroup.qkV.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      for (;;)
      {
        AppMethodBeat.o(66054);
        return localObject1;
        paramView = LayoutInflater.from(MallFunctionSettingsUI.this.getContext()).inflate(2131494690, paramViewGroup, false);
        ((MallFunctionSettingsUI.c)localObject1).lCL = ((TextView)paramView.findViewById(2131302267));
        ((MallFunctionSettingsUI.c)localObject1).mJu = ((ViewGroup)paramView);
        break;
        label434:
        if (((cir)localObject2).Hcz == null) {
          break label217;
        }
        paramViewGroup.uHR.setUrl(((cir)localObject2).Hcz);
        break label217;
        label457:
        if (((cir)localObject2).Hcz == null) {
          break label217;
        }
        paramViewGroup.uHR.setUrl(((cir)localObject2).Hcz);
        break label217;
        label480:
        paramViewGroup.lDu.setVisibility(8);
        break label276;
        label492:
        if (((cir)localObject2).nDG == 1)
        {
          paramViewGroup.iCB.setCheck(false);
          paramViewGroup.iCB.setEnabled(true);
          paramViewGroup.lCL.setTextColor(paramViewGroup.vEP.getContext().getResources().getColor(2131100020));
          paramViewGroup.vET.setVisibility(8);
          break label331;
        }
        if (((cir)localObject2).nDG != 2) {
          break label331;
        }
        paramViewGroup.iCB.setCheck(false);
        paramViewGroup.iCB.setEnabled(false);
        paramViewGroup.vET.setVisibility(0);
        break label331;
        label587:
        ((LinearLayout.LayoutParams)localObject2).leftMargin = MallFunctionSettingsUI.c(paramViewGroup.vEP);
        break label373;
        label602:
        if (paramView.type == 0) {
          paramViewGroup.lCL.setText(paramView.title);
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
    cir vER;
    boolean vES = false;
  }
  
  final class c
  {
    MMSwitchBtn iCB;
    TextView lCL;
    TextView lDu;
    ViewGroup mJu;
    View qkV;
    CdnImageView uHR;
    View vET;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallFunctionSettingsUI
 * JD-Core Version:    0.7.0.1
 */
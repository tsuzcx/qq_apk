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
import com.tencent.mm.ak.a.a;
import com.tencent.mm.ak.n;
import com.tencent.mm.cm.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bgl;
import com.tencent.mm.protocal.protobuf.cjl;
import com.tencent.mm.protocal.protobuf.jo;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
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
  int dNN;
  private ListView vQM;
  private final int vQN;
  private TextView vQO;
  private TextView vQP;
  private a vQQ;
  private List<b> vQR;
  private com.tencent.mm.plugin.mall.a.b vQS;
  
  public MallFunctionSettingsUI()
  {
    AppMethodBeat.i(66057);
    this.vQN = com.tencent.mm.cb.a.fromDPToPix(ak.getContext(), 40);
    this.vQR = new ArrayList();
    AppMethodBeat.o(66057);
  }
  
  public int getLayoutId()
  {
    return 2131494691;
  }
  
  public void initView()
  {
    AppMethodBeat.i(66059);
    this.vQM = ((ListView)findViewById(2131302268));
    this.vQQ = new a((byte)0);
    ViewGroup localViewGroup = (ViewGroup)View.inflate(this, 2131494688, null);
    this.vQM.addHeaderView(localViewGroup, null, false);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setMinimumHeight(com.tencent.mm.cb.a.fromDPToPix(getContext(), 80));
    this.vQM.addFooterView(localLinearLayout, null, false);
    this.vQM.setAdapter(this.vQQ);
    this.vQO = ((TextView)localViewGroup.findViewById(2131302260));
    this.vQP = ((TextView)localViewGroup.findViewById(2131302259));
    AppMethodBeat.o(66059);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66058);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131101179));
    hideActionbarLine();
    this.dNN = ((Integer)g.ajR().ajA().get(am.a.IPF, Integer.valueOf(0))).intValue();
    ae.i("MicroMsg.MallFunctionSettingsUI", "wallet region: %s", new Object[] { Integer.valueOf(this.dNN) });
    initView();
    setMMTitle("");
    ae.i("MicroMsg.MallFunctionSettingsUI", "do get function list");
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)g.ab(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.qGM, false);
    ae.i("MicroMsg.MallFunctionSettingsUI", " walletMallV2 is ：%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      this.vQS = new com.tencent.mm.plugin.mall.a.b(this.dNN, i);
      this.vQS.aET().b(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(66058);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66060);
    super.onDestroy();
    this.vQS.cancel();
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
    
    private MallFunctionSettingsUI.b Kf(int paramInt)
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
          ((MallFunctionSettingsUI.c)localObject1).uTE = ((CdnImageView)paramView.findViewById(2131302264));
          ((MallFunctionSettingsUI.c)localObject1).lHk = ((TextView)paramView.findViewById(2131302266));
          ((MallFunctionSettingsUI.c)localObject1).lHT = ((TextView)paramView.findViewById(2131302262));
          ((MallFunctionSettingsUI.c)localObject1).iFu = ((MMSwitchBtn)paramView.findViewById(2131302265));
          ((MallFunctionSettingsUI.c)localObject1).qrA = paramView.findViewById(2131302263);
          ((MallFunctionSettingsUI.c)localObject1).vQX = paramView.findViewById(2131302261);
          ((MallFunctionSettingsUI.c)localObject1).mOw = ((ViewGroup)paramView);
          ((MallFunctionSettingsUI.c)localObject1).uTE.setUseSdcardCache(true);
          paramView.setTag(localObject1);
          localObject1 = paramView;
        }
      }
      else
      {
        paramView = Kf(paramInt);
        paramViewGroup = (MallFunctionSettingsUI.c)((View)localObject1).getTag();
        if (paramView.type != 1) {
          break label602;
        }
        localObject2 = paramView.vQV;
        if (!al.isDarkMode()) {
          break label457;
        }
        if (((cjl)localObject2).Hwc == null) {
          break label434;
        }
        paramViewGroup.uTE.setUrl(((cjl)localObject2).Hwc);
        label217:
        if (((cjl)localObject2).HvY != null) {
          paramViewGroup.lHk.setText(((cjl)localObject2).HvY);
        }
        if ((((cjl)localObject2).Hwa == null) || (bu.isNullOrNil(((cjl)localObject2).Hwa))) {
          break label480;
        }
        paramViewGroup.lHT.setText(((cjl)localObject2).Hwa);
        paramViewGroup.lHT.setVisibility(0);
        label276:
        if (((cjl)localObject2).nJb != 0) {
          break label492;
        }
        paramViewGroup.iFu.setCheck(true);
        paramViewGroup.iFu.setEnabled(true);
        paramViewGroup.lHk.setTextColor(paramViewGroup.vQT.getContext().getResources().getColor(2131100020));
        paramViewGroup.vQX.setVisibility(8);
        label331:
        paramViewGroup.iFu.setSwitchListener(new MallFunctionSettingsUI.c.1(paramViewGroup, (cjl)localObject2));
        localObject2 = (LinearLayout.LayoutParams)paramViewGroup.qrA.getLayoutParams();
        if (!paramView.vQW) {
          break label587;
        }
        ((LinearLayout.LayoutParams)localObject2).leftMargin = 0;
        label373:
        paramViewGroup.qrA.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      for (;;)
      {
        AppMethodBeat.o(66054);
        return localObject1;
        paramView = LayoutInflater.from(MallFunctionSettingsUI.this.getContext()).inflate(2131494690, paramViewGroup, false);
        ((MallFunctionSettingsUI.c)localObject1).lHk = ((TextView)paramView.findViewById(2131302267));
        ((MallFunctionSettingsUI.c)localObject1).mOw = ((ViewGroup)paramView);
        break;
        label434:
        if (((cjl)localObject2).HvZ == null) {
          break label217;
        }
        paramViewGroup.uTE.setUrl(((cjl)localObject2).HvZ);
        break label217;
        label457:
        if (((cjl)localObject2).HvZ == null) {
          break label217;
        }
        paramViewGroup.uTE.setUrl(((cjl)localObject2).HvZ);
        break label217;
        label480:
        paramViewGroup.lHT.setVisibility(8);
        break label276;
        label492:
        if (((cjl)localObject2).nJb == 1)
        {
          paramViewGroup.iFu.setCheck(false);
          paramViewGroup.iFu.setEnabled(true);
          paramViewGroup.lHk.setTextColor(paramViewGroup.vQT.getContext().getResources().getColor(2131100020));
          paramViewGroup.vQX.setVisibility(8);
          break label331;
        }
        if (((cjl)localObject2).nJb != 2) {
          break label331;
        }
        paramViewGroup.iFu.setCheck(false);
        paramViewGroup.iFu.setEnabled(false);
        paramViewGroup.vQX.setVisibility(0);
        break label331;
        label587:
        ((LinearLayout.LayoutParams)localObject2).leftMargin = MallFunctionSettingsUI.c(paramViewGroup.vQT);
        break label373;
        label602:
        if (paramView.type == 0) {
          paramViewGroup.lHk.setText(paramView.title);
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
    cjl vQV;
    boolean vQW = false;
  }
  
  final class c
  {
    MMSwitchBtn iFu;
    TextView lHT;
    TextView lHk;
    ViewGroup mOw;
    View qrA;
    CdnImageView uTE;
    View vQX;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallFunctionSettingsUI
 * JD-Core Version:    0.7.0.1
 */
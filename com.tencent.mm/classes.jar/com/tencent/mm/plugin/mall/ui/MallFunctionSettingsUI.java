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
import com.tencent.mm.ak.n;
import com.tencent.mm.cn.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.bbr;
import com.tencent.mm.protocal.protobuf.cds;
import com.tencent.mm.protocal.protobuf.jf;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.ah.a;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MallFunctionSettingsUI
  extends WalletBaseUI
{
  int dAk;
  private ListView uBV;
  private final int uBW;
  private TextView uBX;
  private TextView uBY;
  private a uBZ;
  private List<b> uCa;
  private com.tencent.mm.plugin.mall.a.b uCb;
  
  public MallFunctionSettingsUI()
  {
    AppMethodBeat.i(66057);
    this.uBW = com.tencent.mm.cc.a.fromDPToPix(ai.getContext(), 40);
    this.uCa = new ArrayList();
    AppMethodBeat.o(66057);
  }
  
  public int getLayoutId()
  {
    return 2131494691;
  }
  
  public void initView()
  {
    AppMethodBeat.i(66059);
    this.uBV = ((ListView)findViewById(2131302268));
    this.uBZ = new a((byte)0);
    ViewGroup localViewGroup = (ViewGroup)View.inflate(this, 2131494688, null);
    this.uBV.addHeaderView(localViewGroup, null, false);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setMinimumHeight(com.tencent.mm.cc.a.fromDPToPix(getContext(), 80));
    this.uBV.addFooterView(localLinearLayout, null, false);
    this.uBV.setAdapter(this.uBZ);
    this.uBX = ((TextView)localViewGroup.findViewById(2131302260));
    this.uBY = ((TextView)localViewGroup.findViewById(2131302259));
    AppMethodBeat.o(66059);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66058);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131101179));
    hideActionbarLine();
    this.dAk = ((Integer)g.agR().agA().get(ah.a.GIP, Integer.valueOf(0))).intValue();
    ac.i("MicroMsg.MallFunctionSettingsUI", "wallet region: %s", new Object[] { Integer.valueOf(this.dAk) });
    initView();
    setMMTitle("");
    ac.i("MicroMsg.MallFunctionSettingsUI", "do get function list");
    this.uCb = new com.tencent.mm.plugin.mall.a.b(this.dAk);
    this.uCb.aBB().b(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(66058);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66060);
    super.onDestroy();
    this.uCb.cancel();
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
    
    private MallFunctionSettingsUI.b Ik(int paramInt)
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
          ((MallFunctionSettingsUI.c)localObject1).tFi = ((CdnImageView)paramView.findViewById(2131302264));
          ((MallFunctionSettingsUI.c)localObject1).lfN = ((TextView)paramView.findViewById(2131302266));
          ((MallFunctionSettingsUI.c)localObject1).lgw = ((TextView)paramView.findViewById(2131302262));
          ((MallFunctionSettingsUI.c)localObject1).ijk = ((MMSwitchBtn)paramView.findViewById(2131302265));
          ((MallFunctionSettingsUI.c)localObject1).pHq = paramView.findViewById(2131302263);
          ((MallFunctionSettingsUI.c)localObject1).uCg = paramView.findViewById(2131302261);
          ((MallFunctionSettingsUI.c)localObject1).miT = ((ViewGroup)paramView);
          ((MallFunctionSettingsUI.c)localObject1).tFi.setUseSdcardCache(true);
          paramView.setTag(localObject1);
          localObject1 = paramView;
        }
      }
      else
      {
        paramView = Ik(paramInt);
        paramViewGroup = (MallFunctionSettingsUI.c)((View)localObject1).getTag();
        if (paramView.type != 1) {
          break label562;
        }
        localObject2 = paramView.uCe;
        if (((cds)localObject2).Fst != null) {
          paramViewGroup.tFi.setUrl(((cds)localObject2).Fst.eQU());
        }
        if (((cds)localObject2).Fss != null) {
          paramViewGroup.lfN.setText(((cds)localObject2).Fss.eQU());
        }
        if ((((cds)localObject2).Fsu == null) || (bs.isNullOrNil(((cds)localObject2).Fsu.eQU()))) {
          break label440;
        }
        paramViewGroup.lgw.setText(((cds)localObject2).Fsu.eQU());
        paramViewGroup.lgw.setVisibility(0);
        label282:
        if (((cds)localObject2).ndj != 0) {
          break label452;
        }
        paramViewGroup.ijk.setCheck(true);
        paramViewGroup.ijk.setEnabled(true);
        paramViewGroup.lfN.setTextColor(paramViewGroup.uCc.getContext().getResources().getColor(2131100020));
        paramViewGroup.uCg.setVisibility(8);
        label337:
        paramViewGroup.ijk.setSwitchListener(new MallFunctionSettingsUI.c.1(paramViewGroup, (cds)localObject2));
        localObject2 = (LinearLayout.LayoutParams)paramViewGroup.pHq.getLayoutParams();
        if (!paramView.uCf) {
          break label547;
        }
        ((LinearLayout.LayoutParams)localObject2).leftMargin = 0;
        label379:
        paramViewGroup.pHq.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      for (;;)
      {
        AppMethodBeat.o(66054);
        return localObject1;
        paramView = LayoutInflater.from(MallFunctionSettingsUI.this.getContext()).inflate(2131494690, paramViewGroup, false);
        ((MallFunctionSettingsUI.c)localObject1).lfN = ((TextView)paramView.findViewById(2131302267));
        ((MallFunctionSettingsUI.c)localObject1).miT = ((ViewGroup)paramView);
        break;
        label440:
        paramViewGroup.lgw.setVisibility(8);
        break label282;
        label452:
        if (((cds)localObject2).ndj == 1)
        {
          paramViewGroup.ijk.setCheck(false);
          paramViewGroup.ijk.setEnabled(true);
          paramViewGroup.lfN.setTextColor(paramViewGroup.uCc.getContext().getResources().getColor(2131100020));
          paramViewGroup.uCg.setVisibility(8);
          break label337;
        }
        if (((cds)localObject2).ndj != 2) {
          break label337;
        }
        paramViewGroup.ijk.setCheck(false);
        paramViewGroup.ijk.setEnabled(false);
        paramViewGroup.uCg.setVisibility(0);
        break label337;
        label547:
        ((LinearLayout.LayoutParams)localObject2).leftMargin = MallFunctionSettingsUI.c(paramViewGroup.uCc);
        break label379;
        label562:
        if (paramView.type == 0) {
          paramViewGroup.lfN.setText(paramView.title);
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
    cds uCe;
    boolean uCf = false;
  }
  
  final class c
  {
    MMSwitchBtn ijk;
    TextView lfN;
    TextView lgw;
    ViewGroup miT;
    View pHq;
    CdnImageView tFi;
    View uCg;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallFunctionSettingsUI
 * JD-Core Version:    0.7.0.1
 */
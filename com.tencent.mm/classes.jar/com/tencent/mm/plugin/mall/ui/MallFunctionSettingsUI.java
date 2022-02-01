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
import com.tencent.mm.al.c.a;
import com.tencent.mm.al.n;
import com.tencent.mm.co.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.axz;
import com.tencent.mm.protocal.protobuf.byw;
import com.tencent.mm.protocal.protobuf.iz;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MallFunctionSettingsUI
  extends WalletBaseUI
{
  int dCy;
  private ListView ttC;
  private final int ttD;
  private TextView ttE;
  private TextView ttF;
  private a ttG;
  private List<b> ttH;
  private com.tencent.mm.plugin.mall.a.b ttI;
  
  public MallFunctionSettingsUI()
  {
    AppMethodBeat.i(66057);
    this.ttD = com.tencent.mm.cd.a.fromDPToPix(aj.getContext(), 40);
    this.ttH = new ArrayList();
    AppMethodBeat.o(66057);
  }
  
  public int getLayoutId()
  {
    return 2131494691;
  }
  
  public void initView()
  {
    AppMethodBeat.i(66059);
    this.ttC = ((ListView)findViewById(2131302268));
    this.ttG = new a((byte)0);
    ViewGroup localViewGroup = (ViewGroup)View.inflate(this, 2131494688, null);
    this.ttC.addHeaderView(localViewGroup, null, false);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setMinimumHeight(com.tencent.mm.cd.a.fromDPToPix(getContext(), 80));
    this.ttC.addFooterView(localLinearLayout, null, false);
    this.ttC.setAdapter(this.ttG);
    this.ttE = ((TextView)localViewGroup.findViewById(2131302260));
    this.ttF = ((TextView)localViewGroup.findViewById(2131302259));
    AppMethodBeat.o(66059);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66058);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131101179));
    hideActionbarLine();
    this.dCy = ((Integer)g.afB().afk().get(ae.a.Fla, Integer.valueOf(0))).intValue();
    ad.i("MicroMsg.MallFunctionSettingsUI", "wallet region: %s", new Object[] { Integer.valueOf(this.dCy) });
    initView();
    setMMTitle("");
    ad.i("MicroMsg.MallFunctionSettingsUI", "do get function list");
    this.ttI = new com.tencent.mm.plugin.mall.a.b(this.dCy);
    this.ttI.auK().b(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(66058);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66060);
    super.onDestroy();
    this.ttI.cancel();
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
    
    private MallFunctionSettingsUI.b Go(int paramInt)
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
          ((MallFunctionSettingsUI.c)localObject1).sxt = ((CdnImageView)paramView.findViewById(2131302264));
          ((MallFunctionSettingsUI.c)localObject1).kEu = ((TextView)paramView.findViewById(2131302266));
          ((MallFunctionSettingsUI.c)localObject1).kFd = ((TextView)paramView.findViewById(2131302262));
          ((MallFunctionSettingsUI.c)localObject1).hII = ((MMSwitchBtn)paramView.findViewById(2131302265));
          ((MallFunctionSettingsUI.c)localObject1).pef = paramView.findViewById(2131302263);
          ((MallFunctionSettingsUI.c)localObject1).ttN = paramView.findViewById(2131302261);
          ((MallFunctionSettingsUI.c)localObject1).lGY = ((ViewGroup)paramView);
          ((MallFunctionSettingsUI.c)localObject1).sxt.setUseSdcardCache(true);
          paramView.setTag(localObject1);
          localObject1 = paramView;
        }
      }
      else
      {
        paramView = Go(paramInt);
        paramViewGroup = (MallFunctionSettingsUI.c)((View)localObject1).getTag();
        if (paramView.type != 1) {
          break label562;
        }
        localObject2 = paramView.ttL;
        if (((byw)localObject2).DVF != null) {
          paramViewGroup.sxt.setUrl(((byw)localObject2).DVF.eBA());
        }
        if (((byw)localObject2).DVE != null) {
          paramViewGroup.kEu.setText(((byw)localObject2).DVE.eBA());
        }
        if ((((byw)localObject2).DVG == null) || (bt.isNullOrNil(((byw)localObject2).DVG.eBA()))) {
          break label440;
        }
        paramViewGroup.kFd.setText(((byw)localObject2).DVG.eBA());
        paramViewGroup.kFd.setVisibility(0);
        label282:
        if (((byw)localObject2).mBi != 0) {
          break label452;
        }
        paramViewGroup.hII.setCheck(true);
        paramViewGroup.hII.setEnabled(true);
        paramViewGroup.kEu.setTextColor(paramViewGroup.ttJ.getContext().getResources().getColor(2131100020));
        paramViewGroup.ttN.setVisibility(8);
        label337:
        paramViewGroup.hII.setSwitchListener(new MallFunctionSettingsUI.c.1(paramViewGroup, (byw)localObject2));
        localObject2 = (LinearLayout.LayoutParams)paramViewGroup.pef.getLayoutParams();
        if (!paramView.ttM) {
          break label547;
        }
        ((LinearLayout.LayoutParams)localObject2).leftMargin = 0;
        label379:
        paramViewGroup.pef.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      for (;;)
      {
        AppMethodBeat.o(66054);
        return localObject1;
        paramView = LayoutInflater.from(MallFunctionSettingsUI.this.getContext()).inflate(2131494690, paramViewGroup, false);
        ((MallFunctionSettingsUI.c)localObject1).kEu = ((TextView)paramView.findViewById(2131302267));
        ((MallFunctionSettingsUI.c)localObject1).lGY = ((ViewGroup)paramView);
        break;
        label440:
        paramViewGroup.kFd.setVisibility(8);
        break label282;
        label452:
        if (((byw)localObject2).mBi == 1)
        {
          paramViewGroup.hII.setCheck(false);
          paramViewGroup.hII.setEnabled(true);
          paramViewGroup.kEu.setTextColor(paramViewGroup.ttJ.getContext().getResources().getColor(2131100020));
          paramViewGroup.ttN.setVisibility(8);
          break label337;
        }
        if (((byw)localObject2).mBi != 2) {
          break label337;
        }
        paramViewGroup.hII.setCheck(false);
        paramViewGroup.hII.setEnabled(false);
        paramViewGroup.ttN.setVisibility(0);
        break label337;
        label547:
        ((LinearLayout.LayoutParams)localObject2).leftMargin = MallFunctionSettingsUI.c(paramViewGroup.ttJ);
        break label379;
        label562:
        if (paramView.type == 0) {
          paramViewGroup.kEu.setText(paramView.title);
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
    byw ttL;
    boolean ttM = false;
    int type;
  }
  
  final class c
  {
    MMSwitchBtn hII;
    TextView kEu;
    TextView kFd;
    ViewGroup lGY;
    View pef;
    CdnImageView sxt;
    View ttN;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallFunctionSettingsUI
 * JD-Core Version:    0.7.0.1
 */
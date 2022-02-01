package com.tencent.mm.plugin.mall.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.p;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.plugin.mall.a.b;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cpm;
import com.tencent.mm.protocal.protobuf.ebr;
import com.tencent.mm.protocal.protobuf.kp;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MallFunctionSettingsUI
  extends WalletBaseUI
{
  private ListView KKD;
  private final int KKE;
  private TextView KKF;
  private TextView KKG;
  private a KKH;
  private List<b> KKI;
  private b KKJ;
  int igf;
  
  public MallFunctionSettingsUI()
  {
    AppMethodBeat.i(66057);
    this.KKE = com.tencent.mm.cd.a.fromDPToPix(MMApplicationContext.getContext(), 40);
    this.KKI = new ArrayList();
    AppMethodBeat.o(66057);
  }
  
  public int getLayoutId()
  {
    return a.g.mall_function_settings_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(66059);
    this.KKD = ((ListView)findViewById(a.f.mfsu_lv));
    this.KKH = new a((byte)0);
    ViewGroup localViewGroup = (ViewGroup)View.inflate(this, a.g.mall_function_settings_header_view, null);
    this.KKD.addHeaderView(localViewGroup, null, false);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setMinimumHeight(com.tencent.mm.cd.a.fromDPToPix(getContext(), 80));
    this.KKD.addFooterView(localLinearLayout, null, false);
    this.KKD.setAdapter(this.KKH);
    this.KKF = ((TextView)localViewGroup.findViewById(a.f.mfsh_title_tv));
    this.KKG = ((TextView)localViewGroup.findViewById(a.f.mfsh_desc_tv));
    AppMethodBeat.o(66059);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66058);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(a.c.white));
    hideActionbarLine();
    this.igf = ((Integer)h.baE().ban().get(at.a.acNa, Integer.valueOf(0))).intValue();
    Log.i("MicroMsg.MallFunctionSettingsUI", "wallet region: %s", new Object[] { Integer.valueOf(this.igf) });
    initView();
    setMMTitle("");
    Log.i("MicroMsg.MallFunctionSettingsUI", "do get function list");
    boolean bool = ((c)h.ax(c.class)).a(c.a.yXg, true);
    Log.i("MicroMsg.MallFunctionSettingsUI", " walletMallV2 is ：%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      this.KKJ = new b(this.igf, i);
      this.KKJ.bFJ().b(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(66058);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66060);
    super.onDestroy();
    this.KKJ.cancel();
    AppMethodBeat.o(66060);
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
  
  final class a
    extends BaseAdapter
  {
    private a() {}
    
    private MallFunctionSettingsUI.b aap(int paramInt)
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
          paramView = LayoutInflater.from(MallFunctionSettingsUI.this.getContext()).inflate(a.g.mall_function_settings_normal_item_view, paramViewGroup, false);
          ((MallFunctionSettingsUI.c)localObject1).KKO = ((CdnImageView)paramView.findViewById(a.f.mfsn_icon_iv));
          ((MallFunctionSettingsUI.c)localObject1).sUt = ((TextView)paramView.findViewById(a.f.mfsn_title_tv));
          ((MallFunctionSettingsUI.c)localObject1).pJi = ((TextView)paramView.findViewById(a.f.mfsn_desc_tv));
          ((MallFunctionSettingsUI.c)localObject1).pkU = ((MMSwitchBtn)paramView.findViewById(a.f.mfsn_switch_btn));
          ((MallFunctionSettingsUI.c)localObject1).KKP = paramView.findViewById(a.f.mfsn_divider_view);
          ((MallFunctionSettingsUI.c)localObject1).KKQ = paramView.findViewById(a.f.mfsn_cover_view);
          ((MallFunctionSettingsUI.c)localObject1).ulm = ((ViewGroup)paramView);
          ((MallFunctionSettingsUI.c)localObject1).KKO.setUseSdcardCache(true);
          paramView.setTag(localObject1);
          localObject1 = paramView;
        }
      }
      else
      {
        paramView = aap(paramInt);
        paramViewGroup = (MallFunctionSettingsUI.c)((View)localObject1).getTag();
        if (paramView.type != 1) {
          break label613;
        }
        localObject2 = paramView.KKM;
        if (!aw.isDarkMode()) {
          break label467;
        }
        if (((ebr)localObject2).abhm == null) {
          break label444;
        }
        paramViewGroup.KKO.setUrl(((ebr)localObject2).abhm);
        label224:
        if (((ebr)localObject2).abhi != null) {
          paramViewGroup.sUt.setText(((ebr)localObject2).abhi);
        }
        if ((((ebr)localObject2).abhk == null) || (Util.isNullOrNil(((ebr)localObject2).abhk))) {
          break label490;
        }
        paramViewGroup.pJi.setText(((ebr)localObject2).abhk);
        paramViewGroup.pJi.setVisibility(0);
        label283:
        if (((ebr)localObject2).vhk != 0) {
          break label502;
        }
        paramViewGroup.pkU.setCheck(true);
        paramViewGroup.pkU.setEnabled(true);
        paramViewGroup.sUt.setTextColor(paramViewGroup.KKK.getContext().getResources().getColor(a.c.black_per90));
        paramViewGroup.KKQ.setVisibility(8);
        label339:
        paramViewGroup.pkU.setSwitchListener(new MallFunctionSettingsUI.c.1(paramViewGroup, (ebr)localObject2));
        localObject2 = (LinearLayout.LayoutParams)paramViewGroup.KKP.getLayoutParams();
        if (!paramView.KKN) {
          break label598;
        }
        ((LinearLayout.LayoutParams)localObject2).leftMargin = 0;
        label381:
        paramViewGroup.KKP.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      for (;;)
      {
        AppMethodBeat.o(66054);
        return localObject1;
        paramView = LayoutInflater.from(MallFunctionSettingsUI.this.getContext()).inflate(a.g.mall_function_settings_title_item_view, paramViewGroup, false);
        ((MallFunctionSettingsUI.c)localObject1).sUt = ((TextView)paramView.findViewById(a.f.mfst_title_tv));
        ((MallFunctionSettingsUI.c)localObject1).ulm = ((ViewGroup)paramView);
        break;
        label444:
        if (((ebr)localObject2).abhj == null) {
          break label224;
        }
        paramViewGroup.KKO.setUrl(((ebr)localObject2).abhj);
        break label224;
        label467:
        if (((ebr)localObject2).abhj == null) {
          break label224;
        }
        paramViewGroup.KKO.setUrl(((ebr)localObject2).abhj);
        break label224;
        label490:
        paramViewGroup.pJi.setVisibility(8);
        break label283;
        label502:
        if (((ebr)localObject2).vhk == 1)
        {
          paramViewGroup.pkU.setCheck(false);
          paramViewGroup.pkU.setEnabled(true);
          paramViewGroup.sUt.setTextColor(paramViewGroup.KKK.getContext().getResources().getColor(a.c.black_per90));
          paramViewGroup.KKQ.setVisibility(8);
          break label339;
        }
        if (((ebr)localObject2).vhk != 2) {
          break label339;
        }
        paramViewGroup.pkU.setCheck(false);
        paramViewGroup.pkU.setEnabled(false);
        paramViewGroup.KKQ.setVisibility(0);
        break label339;
        label598:
        ((LinearLayout.LayoutParams)localObject2).leftMargin = MallFunctionSettingsUI.c(paramViewGroup.KKK);
        break label381;
        label613:
        if (paramView.type == 0) {
          paramViewGroup.sUt.setText(paramView.title);
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
    ebr KKM;
    boolean KKN = false;
    String title;
    int type;
  }
  
  final class c
  {
    CdnImageView KKO;
    View KKP;
    View KKQ;
    TextView pJi;
    MMSwitchBtn pkU;
    TextView sUt;
    ViewGroup ulm;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallFunctionSettingsUI
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.mall.ui;

import android.app.Activity;
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
import com.tencent.mm.an.c.a;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.pluginsdk.ui.applet.CdnImageView;
import com.tencent.mm.protocal.protobuf.cad;
import com.tencent.mm.protocal.protobuf.djh;
import com.tencent.mm.protocal.protobuf.jt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import com.tencent.mm.ui.widget.MMSwitchBtn.a;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MallFunctionSettingsUI
  extends WalletBaseUI
{
  private ListView EQg;
  private final int EQh;
  private TextView EQi;
  private TextView EQj;
  private a EQk;
  private List<b> EQl;
  private com.tencent.mm.plugin.mall.a.b EQm;
  int fZX;
  
  public MallFunctionSettingsUI()
  {
    AppMethodBeat.i(66057);
    this.EQh = com.tencent.mm.ci.a.fromDPToPix(MMApplicationContext.getContext(), 40);
    this.EQl = new ArrayList();
    AppMethodBeat.o(66057);
  }
  
  public int getLayoutId()
  {
    return a.g.mall_function_settings_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(66059);
    this.EQg = ((ListView)findViewById(a.f.mfsu_lv));
    this.EQk = new a((byte)0);
    ViewGroup localViewGroup = (ViewGroup)View.inflate(this, a.g.mall_function_settings_header_view, null);
    this.EQg.addHeaderView(localViewGroup, null, false);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setMinimumHeight(com.tencent.mm.ci.a.fromDPToPix(getContext(), 80));
    this.EQg.addFooterView(localLinearLayout, null, false);
    this.EQg.setAdapter(this.EQk);
    this.EQi = ((TextView)localViewGroup.findViewById(a.f.mfsh_title_tv));
    this.EQj = ((TextView)localViewGroup.findViewById(a.f.mfsh_desc_tv));
    AppMethodBeat.o(66059);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(66058);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(a.c.white));
    hideActionbarLine();
    this.fZX = ((Integer)h.aHG().aHp().get(ar.a.VlG, Integer.valueOf(0))).intValue();
    Log.i("MicroMsg.MallFunctionSettingsUI", "wallet region: %s", new Object[] { Integer.valueOf(this.fZX) });
    initView();
    setMMTitle("");
    Log.i("MicroMsg.MallFunctionSettingsUI", "do get function list");
    boolean bool = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vHh, true);
    Log.i("MicroMsg.MallFunctionSettingsUI", " walletMallV2 is ：%s", new Object[] { Boolean.valueOf(bool) });
    if (bool) {}
    for (int i = 1;; i = 0)
    {
      this.EQm = new com.tencent.mm.plugin.mall.a.b(this.fZX, i);
      this.EQm.bhW().b(new com.tencent.mm.vending.c.a() {});
      AppMethodBeat.o(66058);
      return;
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(66060);
    super.onDestroy();
    this.EQm.cancel();
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
    
    private MallFunctionSettingsUI.b Wt(int paramInt)
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
          ((MallFunctionSettingsUI.c)localObject1).DMh = ((CdnImageView)paramView.findViewById(a.f.mfsn_icon_iv));
          ((MallFunctionSettingsUI.c)localObject1).pPT = ((TextView)paramView.findViewById(a.f.mfsn_title_tv));
          ((MallFunctionSettingsUI.c)localObject1).mMA = ((TextView)paramView.findViewById(a.f.mfsn_desc_tv));
          ((MallFunctionSettingsUI.c)localObject1).mru = ((MMSwitchBtn)paramView.findViewById(a.f.mfsn_switch_btn));
          ((MallFunctionSettingsUI.c)localObject1).EQr = paramView.findViewById(a.f.mfsn_divider_view);
          ((MallFunctionSettingsUI.c)localObject1).EQs = paramView.findViewById(a.f.mfsn_cover_view);
          ((MallFunctionSettingsUI.c)localObject1).rdg = ((ViewGroup)paramView);
          ((MallFunctionSettingsUI.c)localObject1).DMh.setUseSdcardCache(true);
          paramView.setTag(localObject1);
          localObject1 = paramView;
        }
      }
      else
      {
        paramView = Wt(paramInt);
        paramViewGroup = (MallFunctionSettingsUI.c)((View)localObject1).getTag();
        if (paramView.type != 1) {
          break label613;
        }
        localObject2 = paramView.EQp;
        if (!ar.isDarkMode()) {
          break label467;
        }
        if (((djh)localObject2).TQN == null) {
          break label444;
        }
        paramViewGroup.DMh.setUrl(((djh)localObject2).TQN);
        label224:
        if (((djh)localObject2).TQJ != null) {
          paramViewGroup.pPT.setText(((djh)localObject2).TQJ);
        }
        if ((((djh)localObject2).TQL == null) || (Util.isNullOrNil(((djh)localObject2).TQL))) {
          break label490;
        }
        paramViewGroup.mMA.setText(((djh)localObject2).TQL);
        paramViewGroup.mMA.setVisibility(0);
        label283:
        if (((djh)localObject2).rVU != 0) {
          break label502;
        }
        paramViewGroup.mru.setCheck(true);
        paramViewGroup.mru.setEnabled(true);
        paramViewGroup.pPT.setTextColor(paramViewGroup.EQn.getContext().getResources().getColor(a.c.black_per90));
        paramViewGroup.EQs.setVisibility(8);
        label339:
        paramViewGroup.mru.setSwitchListener(new MallFunctionSettingsUI.c.1(paramViewGroup, (djh)localObject2));
        localObject2 = (LinearLayout.LayoutParams)paramViewGroup.EQr.getLayoutParams();
        if (!paramView.EQq) {
          break label598;
        }
        ((LinearLayout.LayoutParams)localObject2).leftMargin = 0;
        label381:
        paramViewGroup.EQr.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      }
      for (;;)
      {
        AppMethodBeat.o(66054);
        return localObject1;
        paramView = LayoutInflater.from(MallFunctionSettingsUI.this.getContext()).inflate(a.g.mall_function_settings_title_item_view, paramViewGroup, false);
        ((MallFunctionSettingsUI.c)localObject1).pPT = ((TextView)paramView.findViewById(a.f.mfst_title_tv));
        ((MallFunctionSettingsUI.c)localObject1).rdg = ((ViewGroup)paramView);
        break;
        label444:
        if (((djh)localObject2).TQK == null) {
          break label224;
        }
        paramViewGroup.DMh.setUrl(((djh)localObject2).TQK);
        break label224;
        label467:
        if (((djh)localObject2).TQK == null) {
          break label224;
        }
        paramViewGroup.DMh.setUrl(((djh)localObject2).TQK);
        break label224;
        label490:
        paramViewGroup.mMA.setVisibility(8);
        break label283;
        label502:
        if (((djh)localObject2).rVU == 1)
        {
          paramViewGroup.mru.setCheck(false);
          paramViewGroup.mru.setEnabled(true);
          paramViewGroup.pPT.setTextColor(paramViewGroup.EQn.getContext().getResources().getColor(a.c.black_per90));
          paramViewGroup.EQs.setVisibility(8);
          break label339;
        }
        if (((djh)localObject2).rVU != 2) {
          break label339;
        }
        paramViewGroup.mru.setCheck(false);
        paramViewGroup.mru.setEnabled(false);
        paramViewGroup.EQs.setVisibility(0);
        break label339;
        label598:
        ((LinearLayout.LayoutParams)localObject2).leftMargin = MallFunctionSettingsUI.c(paramViewGroup.EQn);
        break label381;
        label613:
        if (paramView.type == 0) {
          paramViewGroup.pPT.setText(paramView.title);
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
    djh EQp;
    boolean EQq = false;
    String title;
    int type;
  }
  
  final class c
  {
    CdnImageView DMh;
    View EQr;
    View EQs;
    TextView mMA;
    MMSwitchBtn mru;
    TextView pPT;
    ViewGroup rdg;
    
    private c() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallFunctionSettingsUI
 * JD-Core Version:    0.7.0.1
 */
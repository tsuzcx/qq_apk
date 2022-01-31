package com.tencent.mm.plugin.mall.ui;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.a.a;
import com.tencent.mm.ai.m;
import com.tencent.mm.cm.f;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.mall.a.b;
import com.tencent.mm.protocal.protobuf.anu;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import java.util.ArrayList;
import java.util.List;

public class MallFunctionSettingsUI
  extends WalletBaseUI
{
  int cLB;
  private ListView ozb;
  private final int ozc;
  private TextView ozd;
  private TextView oze;
  private MallFunctionSettingsUI.a ozf;
  private List<MallFunctionSettingsUI.b> ozg;
  
  public MallFunctionSettingsUI()
  {
    AppMethodBeat.i(43159);
    this.ozc = com.tencent.mm.cb.a.fromDPToPix(ah.getContext(), 40);
    this.ozg = new ArrayList();
    AppMethodBeat.o(43159);
  }
  
  public int getLayoutId()
  {
    return 2130970077;
  }
  
  public void initView()
  {
    AppMethodBeat.i(43161);
    this.ozb = ((ListView)findViewById(2131825925));
    this.ozf = new MallFunctionSettingsUI.a(this, (byte)0);
    ViewGroup localViewGroup = (ViewGroup)View.inflate(this, 2130970074, null);
    this.ozb.addHeaderView(localViewGroup, null, false);
    LinearLayout localLinearLayout = new LinearLayout(getContext());
    localLinearLayout.setMinimumHeight(com.tencent.mm.cb.a.fromDPToPix(getContext(), 80));
    this.ozb.addFooterView(localLinearLayout, null, false);
    this.ozb.setAdapter(this.ozf);
    this.ozd = ((TextView)localViewGroup.findViewById(2131825915));
    this.oze = ((TextView)localViewGroup.findViewById(2131825916));
    AppMethodBeat.o(43161);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(43160);
    super.onCreate(paramBundle);
    setActionbarColor(getResources().getColor(2131690709));
    hideActionbarLine();
    this.cLB = ((Integer)g.RL().Ru().get(ac.a.yCE, Integer.valueOf(0))).intValue();
    ab.i("MicroMsg.MallFunctionSettingsUI", "wallet region: %s", new Object[] { Integer.valueOf(this.cLB) });
    initView();
    setMMTitle("");
    ab.i("MicroMsg.MallFunctionSettingsUI", "do get function list");
    new b(this.cLB).adl().b(new com.tencent.mm.vending.c.a() {});
    AppMethodBeat.o(43160);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(43162);
    super.onDestroy();
    AppMethodBeat.o(43162);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.mall.ui.MallFunctionSettingsUI
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.collect.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.collect.model.s;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.ae;
import com.tencent.mm.wallet_core.ui.WalletBaseUI;
import com.tencent.mm.wallet_core.ui.formview.WalletFormView;
import com.tencent.mm.wallet_core.ui.formview.a;

public class CollectCreateQRCodeUI
  extends WalletBaseUI
{
  private WalletFormView kRl;
  private TextView kRm;
  private String mDesc = "";
  
  public int getLayoutId()
  {
    return 2130969177;
  }
  
  public void initView()
  {
    AppMethodBeat.i(41240);
    setMMTitle(2131298440);
    setBackBtn(new CollectCreateQRCodeUI.1(this));
    this.kRl = ((WalletFormView)findViewById(2131822910));
    a.f(this.kRl);
    String str = getIntent().getStringExtra("key_currency_unit");
    if (!bo.isNullOrNil(str)) {
      this.kRl.getTitleTv().setText(str);
    }
    for (;;)
    {
      this.kRl.a(new CollectCreateQRCodeUI.2(this));
      setEditFocusListener(this.kRl, 2, false);
      ((Button)findViewById(2131822914)).setOnClickListener(new CollectCreateQRCodeUI.3(this));
      this.kRm = ((TextView)findViewById(2131822913));
      this.kRm.setOnClickListener(new CollectCreateQRCodeUI.4(this));
      AppMethodBeat.o(41240);
      return;
      this.kRl.getTitleTv().setText(ae.dSz());
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41238);
    super.onCreate(paramBundle);
    addSceneEndListener(1335);
    initView();
    AppMethodBeat.o(41238);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41239);
    super.onDestroy();
    removeSceneEndListener(1335);
    AppMethodBeat.o(41239);
  }
  
  public boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(41241);
    if ((paramm instanceof s))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (s)paramm;
        paramm = new Intent();
        paramm.putExtra("ftf_pay_url", paramString.kNR);
        paramm.putExtra("key_error_level", paramString.kNT);
        paramm.putExtra("ftf_fixed_fee", paramString.kNS);
        paramm.putExtra("ftf_fixed_fee_type", paramString.cpp);
        paramm.putExtra("ftf_fixed_desc", paramString.desc);
        setResult(-1, paramm);
        finish();
        AppMethodBeat.o(41241);
        return true;
      }
    }
    else if ((paramm instanceof com.tencent.mm.plugin.collect.model.m))
    {
      paramString = (com.tencent.mm.plugin.collect.model.m)paramm;
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        if (paramString.cnK == 0)
        {
          paramm = new Intent();
          paramm.putExtra("ftf_pay_url", paramString.kNw);
          paramm.putExtra("ftf_fixed_fee", paramString.cNd / 100.0D);
          paramm.putExtra("ftf_fixed_desc", paramString.desc);
          paramm.putExtra("key_currency_unit", paramString.kNF);
          setResult(-1, paramm);
          finish();
          AppMethodBeat.o(41241);
          return true;
        }
        if (paramString.kNx == 0)
        {
          h.b(getContext(), paramString.kNv, paramString.kNy, false);
          AppMethodBeat.o(41241);
          return true;
        }
        if (paramString.kNx == 1)
        {
          if ((!bo.isNullOrNil(paramString.kNz)) && (!bo.isNullOrNil(paramString.kNA))) {
            h.d(getContext(), paramString.kNv, paramString.kNy, paramString.kNA, paramString.kNz, new CollectCreateQRCodeUI.5(this, paramString), new CollectCreateQRCodeUI.6(this));
          }
          AppMethodBeat.o(41241);
          return true;
        }
      }
      else
      {
        ab.e("MicroMsg.CollectCreateQRCodeUI", "net error: %s", new Object[] { paramString });
      }
    }
    AppMethodBeat.o(41241);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.collect.ui.CollectCreateQRCodeUI
 * JD-Core Version:    0.7.0.1
 */
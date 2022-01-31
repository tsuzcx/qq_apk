package com.tencent.mm.plugin.ipcall.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.model.au;
import com.tencent.mm.plugin.ipcall.a.d.d;
import com.tencent.mm.protocal.c.amm;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.s;
import java.util.LinkedList;

public class IPCallMyGiftCardUI
  extends MMActivity
  implements f
{
  private ListView Nn;
  private ProgressDialog faz;
  private View hrf;
  private IPCallMyGiftCardUI.a lwM;
  private d lwN;
  
  protected final int getForceOrientation()
  {
    return 1;
  }
  
  protected final int getLayoutId()
  {
    return R.i.ipcall_my_gift_card_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    au.Dk().a(288, this);
    setMMTitle(R.l.ipcall_my_coupon_card_title);
    setBackBtn(new IPCallMyGiftCardUI.1(this));
    addTextOptionMenu(0, this.mController.uMN.getString(R.l.ipcall_my_coupon_card_exchange), new IPCallMyGiftCardUI.2(this));
    this.hrf = findViewById(R.h.ipcall_my_gift_card_empty_view);
    this.Nn = ((ListView)findViewById(R.h.ipcall_my_gift_card_list));
    this.lwM = new IPCallMyGiftCardUI.a(this);
    this.Nn.setAdapter(this.lwM);
    paramBundle = this.mController.uMN;
    getString(R.l.app_tip);
    this.faz = h.b(paramBundle, getString(R.l.ip_call_loading_tip), true, new IPCallMyGiftCardUI.3(this));
    this.lwN = new d();
    au.Dk().a(this.lwN, 0);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    au.Dk().b(288, this);
  }
  
  protected void onResume()
  {
    super.onResume();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.IPCallMyGiftCardUI", "onSceneEnd>errCode:%d,onSceneEnd>errMsg:%s", new Object[] { Integer.valueOf(paramInt2), paramString });
    if ((paramm instanceof d))
    {
      if ((paramInt1 != 0) || (paramInt2 != 0)) {
        break label116;
      }
      paramString = ((d)paramm).lrv;
      if ((this.faz != null) && (this.faz.isShowing())) {
        this.faz.dismiss();
      }
      this.lwM.kZk = paramString.tit;
      this.lwM.lwQ = paramString;
      this.lwM.notifyDataSetChanged();
      if (paramString.tit.size() == 0) {
        this.hrf.setVisibility(0);
      }
    }
    return;
    label116:
    if ((this.faz != null) && (this.faz.isShowing())) {
      this.faz.dismiss();
    }
    this.hrf.setVisibility(0);
    Toast.makeText(this.mController.uMN, getString(R.l.ip_call_load_error_desc), 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallMyGiftCardUI
 * JD-Core Version:    0.7.0.1
 */
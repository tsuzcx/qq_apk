package com.tencent.mm.plugin.fingerprint.ui;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.wxpay.a.f;
import com.tencent.mm.plugin.wxpay.a.g;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;

public class SoterPayTestUI
  extends MMActivity
  implements f
{
  protected final int getLayoutId()
  {
    return a.g.fingerprint_soter_cgi_test;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    findViewById(a.f.soter_cgi_test_get_challenge).setOnClickListener(new SoterPayTestUI.1(this));
    findViewById(a.f.regen_upload_ask).setOnClickListener(new SoterPayTestUI.2(this));
    findViewById(a.f.regen_upload_pay_auth_key).setOnClickListener(new SoterPayTestUI.3(this));
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.i("MicroMsg.SoterPayTestUI", "hy: on scene end: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    s.makeText(this, String.format("on scene end: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }), 1).show();
    g.DQ();
    g.DO().dJT.b(paramm.getType(), this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.SoterPayTestUI
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.facedetect.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.h.a.nx;
import com.tencent.mm.h.a.nx.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class FaceTransparentStubUI
  extends MMActivity
{
  protected final int getLayoutId()
  {
    return -1;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    y.i("MicroMsg.FaceTransparentStubUI", "hy: on activity result in FaceTransparentStubUI");
    setResult(paramInt2, paramIntent);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    int i = getIntent().getIntExtra("KEY_REQUEST_CODE", 1000);
    Object localObject = getIntent().getBundleExtra("KEY_EXTRAS");
    if (!((Bundle)localObject).containsKey("k_user_name"))
    {
      g.DN();
      if (com.tencent.mm.kernel.a.Db()) {
        ((Bundle)localObject).putString("k_user_name", q.Gm());
      }
    }
    paramBundle = new nx();
    paramBundle.bXH.context = this;
    paramBundle.bXH.bXJ = i;
    paramBundle.bXH.extras = ((Bundle)localObject);
    com.tencent.mm.sdk.b.a.udP.m(paramBundle);
    y.i("MicroMsg.FaceTransparentStubUI", "hy: start face detect event result: %b", new Object[] { Boolean.valueOf(paramBundle.bXI.bXC) });
    if (!paramBundle.bXI.bXC)
    {
      if (paramBundle.bXI.extras == null) {
        break label171;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtras(paramBundle.bXI.extras);
      setResult(1, (Intent)localObject);
    }
    for (;;)
    {
      finish();
      return;
      label171:
      setResult(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceTransparentStubUI
 * JD-Core Version:    0.7.0.1
 */
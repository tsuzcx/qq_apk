package com.tencent.mm.plugin.facedetect.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.rk;
import com.tencent.mm.g.a.rk.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class FaceTransparentStubUI
  extends MMActivity
{
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(104034);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ad.i("MicroMsg.FaceTransparentStubUI", "hy: on activity result in FaceTransparentStubUI");
    setResult(paramInt2, paramIntent);
    finish();
    AppMethodBeat.o(104034);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104033);
    super.onCreate(paramBundle);
    int i = getIntent().getIntExtra("KEY_REQUEST_CODE", 1000);
    Object localObject = getIntent().getBundleExtra("KEY_EXTRAS");
    if (!((Bundle)localObject).containsKey("k_user_name"))
    {
      g.ajA();
      if (com.tencent.mm.kernel.a.aiJ()) {
        ((Bundle)localObject).putString("k_user_name", u.aAp());
      }
    }
    paramBundle = new rk();
    paramBundle.dGe.context = this;
    paramBundle.dGe.dFY = i;
    paramBundle.dGe.extras = ((Bundle)localObject);
    com.tencent.mm.sdk.b.a.IbL.l(paramBundle);
    ad.i("MicroMsg.FaceTransparentStubUI", "hy: start face detect event result: %b", new Object[] { Boolean.valueOf(paramBundle.dGf.dFV) });
    if (!paramBundle.dGf.dFV)
    {
      if (paramBundle.dGf.extras == null) {
        break label181;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtras(paramBundle.dGf.extras);
      setResult(1, (Intent)localObject);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(104033);
      return;
      label181:
      setResult(1);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceTransparentStubUI
 * JD-Core Version:    0.7.0.1
 */
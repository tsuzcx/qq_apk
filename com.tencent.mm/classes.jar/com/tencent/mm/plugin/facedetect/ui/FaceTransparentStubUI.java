package com.tencent.mm.plugin.facedetect.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.oy;
import com.tencent.mm.g.a.oy.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.sdk.platformtools.ab;
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
    AppMethodBeat.i(515);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ab.i("MicroMsg.FaceTransparentStubUI", "hy: on activity result in FaceTransparentStubUI");
    setResult(paramInt2, paramIntent);
    finish();
    AppMethodBeat.o(515);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(514);
    super.onCreate(paramBundle);
    int i = getIntent().getIntExtra("KEY_REQUEST_CODE", 1000);
    Object localObject = getIntent().getBundleExtra("KEY_EXTRAS");
    if (!((Bundle)localObject).containsKey("k_user_name"))
    {
      g.RJ();
      if (com.tencent.mm.kernel.a.QT()) {
        ((Bundle)localObject).putString("k_user_name", r.Zq());
      }
    }
    paramBundle = new oy();
    paramBundle.cFG.context = this;
    paramBundle.cFG.cFB = i;
    paramBundle.cFG.extras = ((Bundle)localObject);
    com.tencent.mm.sdk.b.a.ymk.l(paramBundle);
    ab.i("MicroMsg.FaceTransparentStubUI", "hy: start face detect event result: %b", new Object[] { Boolean.valueOf(paramBundle.cFH.cFy) });
    if (!paramBundle.cFH.cFy)
    {
      if (paramBundle.cFH.extras == null) {
        break label183;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtras(paramBundle.cFH.extras);
      setResult(1, (Intent)localObject);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(514);
      return;
      label183:
      setResult(1);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.FaceTransparentStubUI
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.facedetect.ui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.ux;
import com.tencent.mm.autogen.a.ux.b;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
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
    Log.i("MicroMsg.FaceTransparentStubUI", "hy: on activity result in FaceTransparentStubUI");
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
      h.baC();
      if (b.aZM()) {
        ((Bundle)localObject).putString("k_user_name", z.bAP());
      }
    }
    paramBundle = new ux();
    paramBundle.hYM.context = this;
    paramBundle.hYM.hYH = i;
    paramBundle.hYM.extras = ((Bundle)localObject);
    paramBundle.publish();
    Log.i("MicroMsg.FaceTransparentStubUI", "hy: start face detect event result: %b", new Object[] { Boolean.valueOf(paramBundle.hYN.hYE) });
    if (!paramBundle.hYN.hYE)
    {
      if (paramBundle.hYN.extras == null) {
        break label178;
      }
      localObject = new Intent();
      ((Intent)localObject).putExtras(paramBundle.hYN.extras);
      setResult(1, (Intent)localObject);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(104033);
      return;
      label178:
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
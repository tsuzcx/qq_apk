package com.tencent.mm.plugin.facedetectaction.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ri;
import com.tencent.mm.g.a.ri.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class FaceTransStubUI
  extends MMActivity
{
  private Context context;
  
  public FaceTransStubUI()
  {
    AppMethodBeat.i(104268);
    this.context = this;
    AppMethodBeat.o(104268);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(104270);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ae.i("MicroMsg.FaceTransStubUI", "carson : on activity result in FaceTransStubUI");
    setResult(paramInt2, paramIntent);
    finish();
    AppMethodBeat.o(104270);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104269);
    super.onCreate(paramBundle);
    ae.i("MicroMsg.FaceTransStubUI", "carson: start FaceTransStubUI ");
    paramBundle = new ri();
    paramBundle.dGW.scene = getIntent().getIntExtra("scene", 0);
    paramBundle.dGW.packageName = getIntent().getStringExtra("package");
    paramBundle.dGW.dGY = getIntent().getStringExtra("packageSign");
    paramBundle.dGW.dGZ = getIntent().getStringExtra("otherVerifyTitle");
    paramBundle.dGW.dHa = getIntent().getStringExtra("needFrontPage");
    paramBundle.dGW.requestCode = 63;
    if ((this.context instanceof Activity)) {
      paramBundle.dGW.dtg = ((Activity)this.context);
    }
    com.tencent.mm.sdk.b.a.IvT.l(paramBundle);
    ae.i("MicroMsg.FaceTransStubUI", "carson: start face detect event result: %b", new Object[] { Boolean.valueOf(paramBundle.dGX.dHb) });
    if (!paramBundle.dGX.dHb)
    {
      if (paramBundle.dGX.extras == null) {
        break label227;
      }
      Intent localIntent = new Intent();
      localIntent.putExtras(paramBundle.dGX.extras);
      setResult(1, localIntent);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(104269);
      return;
      label227:
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
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceTransStubUI
 * JD-Core Version:    0.7.0.1
 */
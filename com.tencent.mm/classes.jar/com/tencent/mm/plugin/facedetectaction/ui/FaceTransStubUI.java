package com.tencent.mm.plugin.facedetectaction.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.uu;
import com.tencent.mm.autogen.a.uu.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;

@a(3)
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
    Log.i("MicroMsg.FaceTransStubUI", "carson : on activity result in FaceTransStubUI");
    setResult(paramInt2, paramIntent);
    finish();
    AppMethodBeat.o(104270);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104269);
    super.onCreate(paramBundle);
    Log.i("MicroMsg.FaceTransStubUI", "carson: start FaceTransStubUI ");
    paramBundle = new uu();
    paramBundle.hYx.scene = getIntent().getIntExtra("scene", 0);
    paramBundle.hYx.packageName = getIntent().getStringExtra("package");
    paramBundle.hYx.hYz = getIntent().getStringExtra("packageSign");
    paramBundle.hYx.hYA = getIntent().getStringExtra("otherVerifyTitle");
    paramBundle.hYx.hYB = getIntent().getStringExtra("otherVerifyTitleFront");
    paramBundle.hYx.hYC = getIntent().getStringExtra("needFrontPage");
    paramBundle.hYx.hYD = getIntent().getStringExtra("faceVerifyTitle");
    paramBundle.hYx.hPm = 63;
    if ((this.context instanceof Activity)) {
      paramBundle.hYx.hHU = ((Activity)this.context);
    }
    paramBundle.publish();
    Log.i("MicroMsg.FaceTransStubUI", "carson: start face detect event result: %b", new Object[] { Boolean.valueOf(paramBundle.hYy.hYE) });
    if (!paramBundle.hYy.hYE)
    {
      if (paramBundle.hYy.extras == null) {
        break label256;
      }
      Intent localIntent = new Intent();
      localIntent.putExtras(paramBundle.hYy.extras);
      setResult(1, localIntent);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(104269);
      return;
      label256:
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
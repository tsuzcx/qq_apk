package com.tencent.mm.plugin.facedetectaction.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ov;
import com.tencent.mm.g.a.ov.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class FaceTransStubUI
  extends MMActivity
{
  private Context context;
  
  public FaceTransStubUI()
  {
    AppMethodBeat.i(746);
    this.context = this;
    AppMethodBeat.o(746);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(748);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ab.i("MicroMsg.FaceTransStubUI", "carson : on activity result in FaceTransStubUI");
    setResult(paramInt2, paramIntent);
    finish();
    AppMethodBeat.o(748);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(747);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.FaceTransStubUI", "carson: start FaceTransStubUI ");
    paramBundle = new ov();
    paramBundle.cFu.scene = getIntent().getIntExtra("scene", 0);
    paramBundle.cFu.packageName = getIntent().getStringExtra("package");
    paramBundle.cFu.cFw = getIntent().getStringExtra("packageSign");
    paramBundle.cFu.cFx = getIntent().getStringExtra("otherVerifyTitle");
    paramBundle.cFu.requestCode = 63;
    if ((this.context instanceof Activity)) {
      paramBundle.cFu.cup = ((Activity)this.context);
    }
    com.tencent.mm.sdk.b.a.ymk.l(paramBundle);
    ab.i("MicroMsg.FaceTransStubUI", "carson: start face detect event result: %b", new Object[] { Boolean.valueOf(paramBundle.cFv.cFy) });
    if (!paramBundle.cFv.cFy)
    {
      if (paramBundle.cFv.extras == null) {
        break label213;
      }
      Intent localIntent = new Intent();
      localIntent.putExtras(paramBundle.cFv.extras);
      setResult(1, localIntent);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(747);
      return;
      label213:
      setResult(1);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceTransStubUI
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.facedetectaction.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.qn;
import com.tencent.mm.g.a.qn.b;
import com.tencent.mm.sdk.platformtools.ad;
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
    ad.i("MicroMsg.FaceTransStubUI", "carson : on activity result in FaceTransStubUI");
    setResult(paramInt2, paramIntent);
    finish();
    AppMethodBeat.o(104270);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104269);
    super.onCreate(paramBundle);
    ad.i("MicroMsg.FaceTransStubUI", "carson: start FaceTransStubUI ");
    paramBundle = new qn();
    paramBundle.dwe.scene = getIntent().getIntExtra("scene", 0);
    paramBundle.dwe.packageName = getIntent().getStringExtra("package");
    paramBundle.dwe.dwg = getIntent().getStringExtra("packageSign");
    paramBundle.dwe.dwh = getIntent().getStringExtra("otherVerifyTitle");
    paramBundle.dwe.requestCode = 63;
    if ((this.context instanceof Activity)) {
      paramBundle.dwe.djj = ((Activity)this.context);
    }
    com.tencent.mm.sdk.b.a.ESL.l(paramBundle);
    ad.i("MicroMsg.FaceTransStubUI", "carson: start face detect event result: %b", new Object[] { Boolean.valueOf(paramBundle.dwf.dwi) });
    if (!paramBundle.dwf.dwi)
    {
      if (paramBundle.dwf.extras == null) {
        break label211;
      }
      Intent localIntent = new Intent();
      localIntent.putExtras(paramBundle.dwf.extras);
      setResult(1, localIntent);
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(104269);
      return;
      label211:
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
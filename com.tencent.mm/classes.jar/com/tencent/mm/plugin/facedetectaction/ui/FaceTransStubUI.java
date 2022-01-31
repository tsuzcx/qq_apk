package com.tencent.mm.plugin.facedetectaction.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.h.a.nv;
import com.tencent.mm.h.a.nv.b;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;

@com.tencent.mm.ui.base.a(3)
public class FaceTransStubUI
  extends MMActivity
{
  private Context context = this;
  
  protected final int getLayoutId()
  {
    return -1;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    y.i("MicroMsg.FaceTransStubUI", "carson : on activity result in FaceTransStubUI");
    setResult(paramInt2, paramIntent);
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.FaceTransStubUI", "carson: start FaceTransStubUI ");
    paramBundle = new nv();
    paramBundle.bXy.scene = getIntent().getIntExtra("scene", 0);
    paramBundle.bXy.packageName = getIntent().getStringExtra("package");
    paramBundle.bXy.bXA = getIntent().getStringExtra("packageSign");
    paramBundle.bXy.bXB = getIntent().getStringExtra("otherVerifyTitle");
    paramBundle.bXy.bQU = 63;
    if ((this.context instanceof Activity)) {
      paramBundle.bXy.bMV = ((Activity)this.context);
    }
    com.tencent.mm.sdk.b.a.udP.m(paramBundle);
    y.i("MicroMsg.FaceTransStubUI", "carson: start face detect event result: %b", new Object[] { Boolean.valueOf(paramBundle.bXz.bXC) });
    if (!paramBundle.bXz.bXC)
    {
      if (paramBundle.bXz.extras == null) {
        break label201;
      }
      Intent localIntent = new Intent();
      localIntent.putExtras(paramBundle.bXz.extras);
      setResult(1, localIntent);
    }
    for (;;)
    {
      finish();
      return;
      label201:
      setResult(1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectaction.ui.FaceTransStubUI
 * JD-Core Version:    0.7.0.1
 */
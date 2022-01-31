package com.tencent.mm.plugin.ext.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cg;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;

public class RedirectToQrCodeStubUI
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(20439);
    super.onCreate(paramBundle);
    ab.i("MicroMsg.RedirectToQrCodeStubUI", "hy: start to handle qrcode string");
    paramBundle = getIntent().getStringExtra("K_STR");
    int i = getIntent().getIntExtra("K_TYPE", -1);
    int j = getIntent().getIntExtra("K_VERSION", -1);
    cg localcg = new cg();
    localcg.cpD.activity = this;
    localcg.cpD.cnR = paramBundle;
    localcg.cpD.cpE = i;
    localcg.cpD.cpF = j;
    localcg.cpD.scene = 47;
    a.ymk.l(localcg);
    finish();
    AppMethodBeat.o(20439);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.ui.RedirectToQrCodeStubUI
 * JD-Core Version:    0.7.0.1
 */
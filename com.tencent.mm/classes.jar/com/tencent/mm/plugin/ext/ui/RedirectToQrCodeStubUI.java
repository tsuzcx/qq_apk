package com.tencent.mm.plugin.ext.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.co;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ae;

public class RedirectToQrCodeStubUI
  extends HellActivity
{
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(24516);
    super.onCreate(paramBundle);
    ae.i("MicroMsg.RedirectToQrCodeStubUI", "hy: start to handle qrcode string");
    paramBundle = getIntent().getStringExtra("K_STR");
    int i = getIntent().getIntExtra("K_TYPE", -1);
    int j = getIntent().getIntExtra("K_VERSION", -1);
    co localco = new co();
    localco.dou.activity = this;
    localco.dou.dmI = paramBundle;
    localco.dou.dov = i;
    localco.dou.dow = j;
    localco.dou.scene = 47;
    a.IvT.l(localco);
    finish();
    AppMethodBeat.o(24516);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.ui.RedirectToQrCodeStubUI
 * JD-Core Version:    0.7.0.1
 */
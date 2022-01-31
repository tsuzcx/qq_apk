package com.tencent.mm.plugin.ext.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.h.a.cd;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.y;

public class RedirectToQrCodeStubUI
  extends Activity
{
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.i("MicroMsg.RedirectToQrCodeStubUI", "hy: start to handle qrcode string");
    paramBundle = getIntent().getStringExtra("K_STR");
    int i = getIntent().getIntExtra("K_TYPE", -1);
    int j = getIntent().getIntExtra("K_VERSION", -1);
    cd localcd = new cd();
    localcd.bIi.activity = this;
    localcd.bIi.bGE = paramBundle;
    localcd.bIi.bIj = i;
    localcd.bIi.bIk = j;
    localcd.bIi.scene = 47;
    a.udP.m(localcd);
    finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.ui.RedirectToQrCodeStubUI
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.performance.wxperformancetool;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.ch.b;
import com.tencent.mm.performance.a.a;
import com.tencent.mm.sdk.platformtools.ah;
import java.util.HashMap;

@TargetApi(17)
public class MemoryLeakActivity
  extends Activity
{
  private AlertDialog eQH;
  private ah mHandler = new MemoryLeakActivity.1(this);
  private String mKey;
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(a.a.background_transparent);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle("memory leak");
    this.mKey = getIntent().getStringExtra("key");
    String str2 = getIntent().getStringExtra("tag");
    String str1 = getIntent().getStringExtra("class");
    paramBundle = str1;
    if (str1.contains(" ")) {
      paramBundle = str1.substring(str1.indexOf(" "));
    }
    str1 = paramBundle.replace(".", "_");
    localBuilder.setMessage(str2 + paramBundle + "\n\npath:" + b.uFQ + str1 + ".zip");
    localBuilder.setCancelable(true);
    localBuilder.setPositiveButton("dumphprof", new MemoryLeakActivity.2(this, str1));
    localBuilder.setNegativeButton("cancel", new MemoryLeakActivity.3(this));
    localBuilder.setOnDismissListener(new MemoryLeakActivity.4(this));
    this.eQH = localBuilder.create();
    b.cxx();
    this.mHandler.sendEmptyMessageDelayed(0, 200L);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    a.eQK.remove(this.mKey);
    this.mHandler.removeCallbacksAndMessages(null);
    if ((this.eQH != null) && (this.eQH.isShowing()))
    {
      this.eQH.dismiss();
      this.eQH = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.performance.wxperformancetool.MemoryLeakActivity
 * JD-Core Version:    0.7.0.1
 */
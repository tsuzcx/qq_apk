package com.tencent.mm.performance.wxperformancetool;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.b;
import com.tencent.mm.sdk.platformtools.ak;
import java.util.HashMap;

@TargetApi(17)
public class MemoryLeakActivity
  extends Activity
{
  private AlertDialog giC;
  private ak mHandler;
  private String mKey;
  
  public MemoryLeakActivity()
  {
    AppMethodBeat.i(76886);
    this.mHandler = new MemoryLeakActivity.1(this);
    AppMethodBeat.o(76886);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(76887);
    super.onCreate(paramBundle);
    setContentView(2130968799);
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
    localBuilder.setMessage(str2 + paramBundle + "\n\npath:" + b.ySI + str1 + ".zip");
    localBuilder.setCancelable(true);
    localBuilder.setPositiveButton("dumphprof", new MemoryLeakActivity.2(this, str1));
    localBuilder.setNegativeButton("cancel", new MemoryLeakActivity.3(this));
    localBuilder.setOnDismissListener(new MemoryLeakActivity.4(this));
    this.giC = localBuilder.create();
    b.dAq();
    this.mHandler.sendEmptyMessageDelayed(0, 200L);
    AppMethodBeat.o(76887);
  }
  
  protected void onDestroy()
  {
    AppMethodBeat.i(76888);
    super.onDestroy();
    a.giF.remove(this.mKey);
    this.mHandler.removeCallbacksAndMessages(null);
    if ((this.giC != null) && (this.giC.isShowing()))
    {
      this.giC.dismiss();
      this.giC = null;
    }
    AppMethodBeat.o(76888);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.performance.wxperformancetool.MemoryLeakActivity
 * JD-Core Version:    0.7.0.1
 */
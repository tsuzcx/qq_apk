package com.tencent.mm.performance.wxperformancetool;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ci.b;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.sdk.platformtools.aq;
import java.lang.ref.WeakReference;
import java.util.HashMap;

@TargetApi(17)
public class MemoryLeakActivity
  extends HellActivity
{
  private AlertDialog iMR;
  private aq mHandler;
  private String mKey;
  
  public MemoryLeakActivity()
  {
    AppMethodBeat.i(145579);
    this.mHandler = new aq()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(145575);
        if (((WeakReference)a.iMU.get(MemoryLeakActivity.a(MemoryLeakActivity.this))).get() == null)
        {
          MemoryLeakActivity.this.finish();
          AppMethodBeat.o(145575);
          return;
        }
        MemoryLeakActivity.b(MemoryLeakActivity.this).show();
        AppMethodBeat.o(145575);
      }
    };
    AppMethodBeat.o(145579);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(145580);
    super.onCreate(paramBundle);
    setContentView(2131493128);
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(this);
    localBuilder.setTitle("memory leak");
    this.mKey = getIntent().getStringExtra("key");
    String str2 = getIntent().getStringExtra("tag");
    final String str1 = getIntent().getStringExtra("class");
    paramBundle = str1;
    if (str1.contains(" ")) {
      paramBundle = str1.substring(str1.indexOf(" "));
    }
    str1 = paramBundle.replace(".", "_");
    localBuilder.setMessage(str2 + paramBundle + "\n\npath:" + b.Jmc + str1 + ".zip");
    localBuilder.setCancelable(true);
    localBuilder.setPositiveButton("dumphprof", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(145576);
        b.aWF(str1);
        if ((MemoryLeakActivity.b(MemoryLeakActivity.this) != null) && (MemoryLeakActivity.b(MemoryLeakActivity.this).isShowing())) {
          MemoryLeakActivity.b(MemoryLeakActivity.this).dismiss();
        }
        MemoryLeakActivity.this.finish();
        AppMethodBeat.o(145576);
      }
    });
    localBuilder.setNegativeButton("cancel", new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(145577);
        if ((MemoryLeakActivity.b(MemoryLeakActivity.this) != null) && (MemoryLeakActivity.b(MemoryLeakActivity.this).isShowing())) {
          MemoryLeakActivity.b(MemoryLeakActivity.this).dismiss();
        }
        MemoryLeakActivity.this.finish();
        AppMethodBeat.o(145577);
      }
    });
    localBuilder.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(145578);
        MemoryLeakActivity.this.finish();
        AppMethodBeat.o(145578);
      }
    });
    this.iMR = localBuilder.create();
    b.fyw();
    this.mHandler.sendEmptyMessageDelayed(0, 200L);
    AppMethodBeat.o(145580);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(145581);
    super.onDestroy();
    a.iMU.remove(this.mKey);
    this.mHandler.removeCallbacksAndMessages(null);
    if ((this.iMR != null) && (this.iMR.isShowing()))
    {
      this.iMR.dismiss();
      this.iMR = null;
    }
    AppMethodBeat.o(145581);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.performance.wxperformancetool.MemoryLeakActivity
 * JD-Core Version:    0.7.0.1
 */
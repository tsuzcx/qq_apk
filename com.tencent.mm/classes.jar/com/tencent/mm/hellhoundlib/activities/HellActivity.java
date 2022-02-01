package com.tencent.mm.hellhoundlib.activities;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a;
import com.tencent.mm.hellhoundlib.b;
import com.tencent.mm.hellhoundlib.d;

public class HellActivity
  extends Activity
{
  public void finish()
  {
    AppMethodBeat.i(55526);
    a.aYh().cy(this);
    super.finish();
    AppMethodBeat.o(55526);
  }
  
  public void finishActivity(int paramInt)
  {
    AppMethodBeat.i(55527);
    a.aYh().cy(this);
    super.finishActivity(paramInt);
    AppMethodBeat.o(55527);
  }
  
  public void finishActivityFromChild(Activity paramActivity, int paramInt)
  {
    AppMethodBeat.i(55529);
    a.aYh().cy(paramActivity);
    super.finishActivityFromChild(paramActivity, paramInt);
    AppMethodBeat.o(55529);
  }
  
  public void finishAffinity()
  {
    AppMethodBeat.i(55528);
    a.aYh().cy(this);
    super.finishAffinity();
    AppMethodBeat.o(55528);
  }
  
  public void finishAndRemoveTask()
  {
    AppMethodBeat.i(55530);
    a.aYh().cy(this);
    super.finishAndRemoveTask();
    AppMethodBeat.o(55530);
  }
  
  public boolean moveTaskToBack(boolean paramBoolean)
  {
    AppMethodBeat.i(55531);
    a locala = a.aYh();
    if (locala.mxj != null) {
      locala.mxj.e(this, paramBoolean);
    }
    paramBoolean = super.moveTaskToBack(paramBoolean);
    AppMethodBeat.o(55531);
    return paramBoolean;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(55515);
    super.onCreate(paramBundle);
    a.aYh().i(this, 0);
    AppMethodBeat.o(55515);
  }
  
  protected void onDestroy()
  {
    AppMethodBeat.i(55520);
    a.aYh().i(this, 5);
    super.onDestroy();
    AppMethodBeat.o(55520);
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(55516);
    super.onNewIntent(paramIntent);
    a locala = a.aYh();
    if ((b.cz(this)) && (locala.mxj != null)) {
      locala.mxj.c(this, paramIntent);
    }
    AppMethodBeat.o(55516);
  }
  
  protected void onPause()
  {
    AppMethodBeat.i(55518);
    super.onPause();
    a.aYh().i(this, 3);
    AppMethodBeat.o(55518);
  }
  
  protected void onPostResume()
  {
    AppMethodBeat.i(55521);
    super.onPostResume();
    a.aYh().i(this, 6);
    AppMethodBeat.o(55521);
  }
  
  protected void onResume()
  {
    AppMethodBeat.i(55517);
    super.onResume();
    a.aYh().i(this, 2);
    AppMethodBeat.o(55517);
  }
  
  protected void onStop()
  {
    AppMethodBeat.i(55519);
    super.onStop();
    a.aYh().i(this, 4);
    AppMethodBeat.o(55519);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public void startActivities(Intent[] paramArrayOfIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(55524);
    a locala = a.aYh();
    if ((b.cz(this)) && (locala.mxj != null)) {
      locala.mxj.a(this, paramArrayOfIntent);
    }
    super.startActivities(paramArrayOfIntent, paramBundle);
    AppMethodBeat.o(55524);
  }
  
  public void startActivityForResult(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(55522);
    a.aYh().a(this, paramIntent);
    super.startActivityForResult(paramIntent, paramInt, paramBundle);
    AppMethodBeat.o(55522);
  }
  
  public void startActivityFromFragment(Fragment paramFragment, Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(55525);
    a.aYh().a(this, paramIntent);
    super.startActivityFromFragment(paramFragment, paramIntent, paramInt, paramBundle);
    AppMethodBeat.o(55525);
  }
  
  public boolean startActivityIfNeeded(Intent paramIntent, int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(55523);
    a.aYh().a(this, paramIntent);
    boolean bool = super.startActivityIfNeeded(paramIntent, paramInt, paramBundle);
    AppMethodBeat.o(55523);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.hellhoundlib.activities.HellActivity
 * JD-Core Version:    0.7.0.1
 */
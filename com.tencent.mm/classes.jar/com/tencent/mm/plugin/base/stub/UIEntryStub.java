package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.bk;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.a;

@a(7)
public class UIEntryStub
  extends Activity
{
  private String Ca;
  private Intent cyJ;
  private int jLB;
  private boolean jLC;
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(18131);
    super.onCreate(paramBundle);
    NotifyReceiver.In();
    this.jLC = false;
    AppMethodBeat.o(18131);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(18132);
    super.onNewIntent(paramIntent);
    this.cyJ = paramIntent;
    ab.i("MicroMsg.UIEntryStub", "onNewIntent mHasHandled: %b", new Object[] { Boolean.valueOf(this.jLC) });
    this.jLC = false;
    AppMethodBeat.o(18132);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(18133);
    super.onResume();
    if (this.cyJ == null) {
      this.cyJ = getIntent();
    }
    aw.Rc().a(new bk(new UIEntryStub.1(this)), 0);
    AppMethodBeat.o(18133);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.UIEntryStub
 * JD-Core Version:    0.7.0.1
 */
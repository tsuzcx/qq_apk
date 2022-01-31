package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;

public class SoterPayTestUI
  extends MMActivity
  implements f
{
  public int getLayoutId()
  {
    return 2130969597;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41664);
    super.onCreate(paramBundle);
    findViewById(2131824166).setOnClickListener(new SoterPayTestUI.1(this));
    findViewById(2131824167).setOnClickListener(new SoterPayTestUI.2(this));
    findViewById(2131824168).setOnClickListener(new SoterPayTestUI.3(this));
    AppMethodBeat.o(41664);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(41665);
    ab.i("MicroMsg.SoterPayTestUI", "hy: on scene end: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    t.makeText(this, String.format("on scene end: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }), 1).show();
    g.RM();
    g.RK().eHt.b(paramm.getType(), this);
    AppMethodBeat.o(41665);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.SoterPayTestUI
 * JD-Core Version:    0.7.0.1
 */
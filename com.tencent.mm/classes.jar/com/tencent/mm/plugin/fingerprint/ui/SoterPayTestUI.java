package com.tencent.mm.plugin.fingerprint.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import com.tencent.soter.a.b.c;

public class SoterPayTestUI
  extends MMActivity
  implements f
{
  public int getLayoutId()
  {
    return 2131494138;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(64560);
    super.onCreate(paramBundle);
    findViewById(2131305117).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64557);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fingerprint/ui/SoterPayTestUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.SoterPayTestUI", "hy: start get challenge");
        g.ajS();
        g.ajQ().gDv.a(1586, SoterPayTestUI.this);
        g.ajS();
        g.ajQ().gDv.a(new com.tencent.mm.plugin.fingerprint.c.a(0), 0);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fingerprint/ui/SoterPayTestUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64557);
      }
    });
    findViewById(2131303959).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64558);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fingerprint/ui/SoterPayTestUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.i("MicroMsg.SoterPayTestUI", "hy: regen and upload ask");
        com.tencent.soter.a.a.a(new com.tencent.soter.a.b.b() {}, false, null);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fingerprint/ui/SoterPayTestUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64558);
      }
    });
    findViewById(2131303960).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(64559);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fingerprint/ui/SoterPayTestUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fingerprint/ui/SoterPayTestUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(64559);
      }
    });
    AppMethodBeat.o(64560);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(64561);
    ae.i("MicroMsg.SoterPayTestUI", "hy: on scene end: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    t.makeText(this, String.format("on scene end: errType: %d, errCode: %d, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString }), 1).show();
    g.ajS();
    g.ajQ().gDv.b(paramn.getType(), this);
    AppMethodBeat.o(64561);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.fingerprint.ui.SoterPayTestUI
 * JD-Core Version:    0.7.0.1
 */
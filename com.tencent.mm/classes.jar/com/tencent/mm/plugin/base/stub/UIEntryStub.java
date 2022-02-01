package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.model.az;
import com.tencent.mm.model.bn;
import com.tencent.mm.model.bn.a;
import com.tencent.mm.network.e;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;

@com.tencent.mm.ui.base.a(7)
public class UIEntryStub
  extends HellActivity
{
  private String IK;
  private Intent doO;
  private int mKl;
  private boolean mKm;
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22185);
    super.onCreate(paramBundle);
    NotifyReceiver.Ty();
    this.mKm = false;
    AppMethodBeat.o(22185);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(22186);
    super.onNewIntent(paramIntent);
    this.doO = paramIntent;
    ad.i("MicroMsg.UIEntryStub", "onNewIntent mHasHandled: %b", new Object[] { Boolean.valueOf(this.mKm) });
    this.mKm = false;
    AppMethodBeat.o(22186);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22187);
    super.onResume();
    if (this.doO == null) {
      this.doO = getIntent();
    }
    az.aeS().a(new bn(new bn.a()
    {
      public final void a(e paramAnonymouse)
      {
        AppMethodBeat.i(22180);
        if (paramAnonymouse == null)
        {
          UIEntryStub.this.finish();
          AppMethodBeat.o(22180);
          return;
        }
        ad.i("MicroMsg.UIEntryStub", "onResume mHasHandled: %b", new Object[] { Boolean.valueOf(UIEntryStub.a(UIEntryStub.this)) });
        if (!UIEntryStub.a(UIEntryStub.this))
        {
          UIEntryStub.b(UIEntryStub.this);
          UIEntryStub.a(UIEntryStub.this, UIEntryStub.c(UIEntryStub.this).getExtras());
        }
        AppMethodBeat.o(22180);
      }
    }), 0);
    AppMethodBeat.o(22187);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.UIEntryStub
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.base.stub;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.booter.NotifyReceiver;
import com.tencent.mm.hellhoundlib.activities.HellActivity;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.bw;
import com.tencent.mm.model.bw.a;
import com.tencent.mm.network.g;
import com.tencent.mm.opensdk.modelmsg.SendMessageToWX.Req;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.pluginsdk.model.app.ReportUtil;
import com.tencent.mm.pluginsdk.model.app.ReportUtil.ReportArgs;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.chatting.ChattingUI;
import com.tencent.mm.ui.transmit.SendAppMessageWrapperUI;

@com.tencent.mm.ui.base.a(7)
public class UIEntryStub
  extends HellActivity
{
  private String bJH;
  private Intent hPY;
  private int sdkVersion;
  private boolean vrl;
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22185);
    Log.i("MicroMsg.UIEntryStub", "onCreate");
    super.onCreate(paramBundle);
    NotifyReceiver.aKz();
    this.vrl = false;
    AppMethodBeat.o(22185);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(269059);
    super.onDestroy();
    Log.i("MicroMsg.UIEntryStub", "onDestroy");
    AppMethodBeat.o(269059);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(22186);
    super.onNewIntent(paramIntent);
    this.hPY = paramIntent;
    Log.i("MicroMsg.UIEntryStub", "onNewIntent mHasHandled: %b", new Object[] { Boolean.valueOf(this.vrl) });
    this.vrl = false;
    AppMethodBeat.o(22186);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(269057);
    super.onPause();
    Log.i("MicroMsg.UIEntryStub", "onPause");
    AppMethodBeat.o(269057);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22187);
    super.onResume();
    Log.i("MicroMsg.UIEntryStub", "onResume");
    if (this.hPY == null) {
      this.hPY = getIntent();
    }
    bh.aZW().a(new bw(new bw.a()
    {
      public final void b(g paramAnonymousg)
      {
        AppMethodBeat.i(22180);
        if (paramAnonymousg == null)
        {
          UIEntryStub.this.finish();
          AppMethodBeat.o(22180);
          return;
        }
        Log.i("MicroMsg.UIEntryStub", "onResume mHasHandled: %b", new Object[] { Boolean.valueOf(UIEntryStub.a(UIEntryStub.this)) });
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.UIEntryStub
 * JD-Core Version:    0.7.0.1
 */
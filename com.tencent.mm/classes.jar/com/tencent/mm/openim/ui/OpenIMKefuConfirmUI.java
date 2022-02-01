package com.tencent.mm.openim.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.openim.api.OpenIMKefuStartConversationRequest;
import com.tencent.mm.openim.model.w;
import com.tencent.mm.plugin.comm.c.b;
import com.tencent.mm.plugin.comm.c.e;
import com.tencent.mm.plugin.comm.c.f;
import com.tencent.mm.protocal.protobuf.du;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.pulldown.c;
import com.tencent.mm.ui.y;
import kotlin.Metadata;
import kotlin.g.b.s;

@a(3)
@c(0)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/openim/ui/OpenIMKefuConfirmUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "confirmController", "Lcom/tencent/mm/openim/model/OpenIMKefuConfirmController;", "hasStart", "", "getLayoutId", "", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OpenIMKefuConfirmUI
  extends MMActivity
{
  public static final OpenIMKefuConfirmUI.a pup;
  private boolean mvL;
  private final w puq;
  
  static
  {
    AppMethodBeat.i(235908);
    pup = new OpenIMKefuConfirmUI.a((byte)0);
    AppMethodBeat.o(235908);
  }
  
  public OpenIMKefuConfirmUI()
  {
    AppMethodBeat.i(235904);
    this.puq = new w((Activity)this);
    AppMethodBeat.o(235904);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return c.f.layout_open_im_kefu_confirm_full_ui;
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(235932);
    this.puq.cancel();
    super.onBackPressed();
    AppMethodBeat.o(235932);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    e.a locala = null;
    AppMethodBeat.i(235921);
    super.onCreate(paramBundle);
    getController().setStatusBarColor(bb.gy(getContext().getResources().getColor(c.b.white), 0));
    ((RelativeLayout)findViewById(c.e.confirm_container)).setVisibility(8);
    w localw = this.puq;
    paramBundle = getIntent();
    localw.intent = paramBundle;
    if (paramBundle == null)
    {
      paramBundle = null;
      localw.psJ = paramBundle;
      paramBundle = localw.psJ;
      if (paramBundle != null) {
        break label159;
      }
      paramBundle = locala;
    }
    for (;;)
    {
      Log.i("MicroMsg.OpenIMKefuConfirmController", "alvinluo onCreate url: %s, confirmPageType: %s", new Object[] { paramBundle, Integer.valueOf(localw.bSi()) });
      paramBundle = this.puq;
      locala = (e.a)new OpenIMKefuConfirmUI.b();
      s.u(locala, "listener");
      paramBundle.psI = locala;
      AppMethodBeat.o(235921);
      return;
      paramBundle = (OpenIMKefuStartConversationRequest)paramBundle.getParcelableExtra("key_start_conversation_request");
      break;
      label159:
      du localdu = paramBundle.pry;
      paramBundle = locala;
      if (localdu != null) {
        paramBundle = localdu.url;
      }
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(235926);
    super.onResume();
    if (!this.mvL)
    {
      this.mvL = true;
      this.puq.start();
    }
    AppMethodBeat.o(235926);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.openim.ui.OpenIMKefuConfirmUI
 * JD-Core Version:    0.7.0.1
 */
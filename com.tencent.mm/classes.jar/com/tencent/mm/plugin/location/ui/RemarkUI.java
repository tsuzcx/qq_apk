package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cm;
import com.tencent.mm.g.a.cm.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.tools.MMTextInputUI;

public class RemarkUI
  extends MMTextInputUI
{
  public final void G(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(113484);
    long l = getIntent().getLongExtra("kFavInfoLocalId", -1L);
    if (l > 0L) {
      if (paramCharSequence != null) {
        break label150;
      }
    }
    label150:
    for (paramCharSequence = "";; paramCharSequence = paramCharSequence.toString())
    {
      ab.i("MicroMsg.MMTextInputUI", "same remark[%s]", new Object[] { paramCharSequence });
      if (!paramCharSequence.equals(getIntent().getStringExtra("kRemark")))
      {
        cm localcm = new cm();
        localcm.cpR.type = -2;
        localcm.cpR.cpH = Long.toString(l);
        localcm.cpR.desc = paramCharSequence;
        ab.d("MicroMsg.MMTextInputUI", "update location remark, favlocalid is %s, remark is %s", new Object[] { localcm.cpR.cpH, localcm.cpR.desc });
        a.ymk.l(localcm);
      }
      AppMethodBeat.o(113484);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2130970562;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(113483);
    super.onCreate(paramBundle);
    setMMTitle(2131301102);
    paramBundle = getIntent().getStringExtra("Kwebmap_locaion");
    if (bo.isNullOrNil(paramBundle))
    {
      findViewById(2131825431).setVisibility(8);
      AppMethodBeat.o(113483);
      return;
    }
    ((TextView)findViewById(2131825432)).setText(paramBundle);
    AppMethodBeat.o(113483);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.RemarkUI
 * JD-Core Version:    0.7.0.1
 */
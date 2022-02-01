package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cs;
import com.tencent.mm.g.a.cs.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.tools.MMTextInputUI;

public class RemarkUI
  extends MMTextInputUI
{
  public final void L(CharSequence paramCharSequence)
  {
    AppMethodBeat.i(55884);
    long l = getIntent().getLongExtra("kFavInfoLocalId", -1L);
    if (l > 0L) {
      if (paramCharSequence != null) {
        break label150;
      }
    }
    label150:
    for (paramCharSequence = "";; paramCharSequence = paramCharSequence.toString())
    {
      ac.i("MicroMsg.MMTextInputUI", "same remark[%s]", new Object[] { paramCharSequence });
      if (!paramCharSequence.equals(getIntent().getStringExtra("kRemark")))
      {
        cs localcs = new cs();
        localcs.dck.type = -2;
        localcs.dck.dbZ = Long.toString(l);
        localcs.dck.desc = paramCharSequence;
        ac.d("MicroMsg.MMTextInputUI", "update location remark, favlocalid is %s, remark is %s", new Object[] { localcs.dck.dbZ, localcs.dck.desc });
        a.GpY.l(localcs);
      }
      AppMethodBeat.o(55884);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return 2131495245;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(55883);
    super.onCreate(paramBundle);
    setMMTitle(2131760726);
    paramBundle = getIntent().getStringExtra("Kwebmap_locaion");
    if (bs.isNullOrNil(paramBundle))
    {
      findViewById(2131301528).setVisibility(8);
      AppMethodBeat.o(55883);
      return;
    }
    ((TextView)findViewById(2131301544)).setText(paramBundle);
    AppMethodBeat.o(55883);
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
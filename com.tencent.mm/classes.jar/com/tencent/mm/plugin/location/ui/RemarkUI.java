package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cv;
import com.tencent.mm.g.a.cv.a;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
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
      ad.i("MicroMsg.MMTextInputUI", "same remark[%s]", new Object[] { paramCharSequence });
      if (!paramCharSequence.equals(getIntent().getStringExtra("kRemark")))
      {
        cv localcv = new cv();
        localcv.dnG.type = -2;
        localcv.dnG.dnv = Long.toString(l);
        localcv.dnG.desc = paramCharSequence;
        ad.d("MicroMsg.MMTextInputUI", "update location remark, favlocalid is %s, remark is %s", new Object[] { localcv.dnG.dnv, localcv.dnG.desc });
        a.IbL.l(localcv);
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
    if (bt.isNullOrNil(paramBundle))
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.RemarkUI
 * JD-Core Version:    0.7.0.1
 */
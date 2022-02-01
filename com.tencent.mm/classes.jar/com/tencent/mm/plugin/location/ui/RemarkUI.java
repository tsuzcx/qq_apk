package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.dd;
import com.tencent.mm.f.a.dd.a;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.tools.MMTextInputUI;

public class RemarkUI
  extends MMTextInputUI
{
  public final void X(CharSequence paramCharSequence)
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
      Log.i("MicroMsg.MMTextInputUI", "same remark[%s]", new Object[] { paramCharSequence });
      if (!paramCharSequence.equals(getIntent().getStringExtra("kRemark")))
      {
        dd localdd = new dd();
        localdd.fyI.type = -2;
        localdd.fyI.fyu = Long.toString(l);
        localdd.fyI.desc = paramCharSequence;
        Log.d("MicroMsg.MMTextInputUI", "update location remark, favlocalid is %s, remark is %s", new Object[] { localdd.fyI.fyu, localdd.fyI.desc });
        EventCenter.instance.publish(localdd);
      }
      AppMethodBeat.o(55884);
      return;
    }
  }
  
  public int getLayoutId()
  {
    return a.f.remark_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(55883);
    super.onCreate(paramBundle);
    setMMTitle(a.i.location_remark_hint);
    paramBundle = getIntent().getStringExtra("Kwebmap_locaion");
    if (Util.isNullOrNil(paramBundle))
    {
      findViewById(a.e.location_info_ll).setVisibility(8);
      AppMethodBeat.o(55883);
      return;
    }
    ((TextView)findViewById(a.e.location_text_tv)).setText(paramBundle);
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
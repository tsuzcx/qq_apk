package com.tencent.mm.plugin.location.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.h.a.cj;
import com.tencent.mm.h.a.cj.a;
import com.tencent.mm.plugin.map.a.e;
import com.tencent.mm.plugin.map.a.f;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.tools.MMTextInputUI;

public class RemarkUI
  extends MMTextInputUI
{
  protected final int getLayoutId()
  {
    return a.f.remark_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setMMTitle(a.h.location_remark_hint);
    paramBundle = getIntent().getStringExtra("Kwebmap_locaion");
    if (bk.bl(paramBundle))
    {
      findViewById(a.e.location_info_ll).setVisibility(8);
      return;
    }
    ((TextView)findViewById(a.e.location_text_tv)).setText(paramBundle);
  }
  
  protected final void x(CharSequence paramCharSequence)
  {
    long l = getIntent().getLongExtra("kFavInfoLocalId", -1L);
    if (l > 0L) {
      if (paramCharSequence != null) {
        break label140;
      }
    }
    label140:
    for (paramCharSequence = "";; paramCharSequence = paramCharSequence.toString())
    {
      y.i("MicroMsg.MMTextInputUI", "same remark[%s]", new Object[] { paramCharSequence });
      if (!paramCharSequence.equals(getIntent().getStringExtra("kRemark")))
      {
        cj localcj = new cj();
        localcj.bIw.type = -2;
        localcj.bIw.bIm = Long.toString(l);
        localcj.bIw.desc = paramCharSequence;
        y.d("MicroMsg.MMTextInputUI", "update location remark, favlocalid is %s, remark is %s", new Object[] { localcj.bIw.bIm, localcj.bIw.desc });
        a.udP.m(localcj);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.RemarkUI
 * JD-Core Version:    0.7.0.1
 */
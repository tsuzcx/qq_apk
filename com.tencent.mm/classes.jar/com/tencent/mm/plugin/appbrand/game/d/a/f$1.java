package com.tencent.mm.plugin.appbrand.game.d.a;

import android.text.Editable;
import com.tencent.mm.plugin.appbrand.game.widget.input.WAGamePanelInputEditText;
import com.tencent.mm.plugin.appbrand.game.widget.input.a;
import com.tencent.mm.plugin.appbrand.jsapi.i;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.page.q;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class f$1
  implements Runnable
{
  f$1(f paramf, o paramo, String paramString, int paramInt) {}
  
  public final void run()
  {
    if (this.gcp.isRunning())
    {
      localObject = this.gcp.E(q.class);
      if (localObject != null) {}
    }
    else
    {
      return;
    }
    Object localObject = a.bQ(((q)localObject).getContentView());
    if (localObject != null)
    {
      WAGamePanelInputEditText localWAGamePanelInputEditText = ((a)localObject).getAttachedEditText();
      int i = localWAGamePanelInputEditText.getMaxLength();
      y.v("MicroMsg.WAGameJsApiUpdateKeyboard", "maxLength(%d).", new Object[] { Integer.valueOf(i) });
      if (!bk.bl(this.eOB)) {
        if (i > 0) {
          if (this.eOB.length() > i)
          {
            localObject = this.eOB.substring(0, i);
            localWAGamePanelInputEditText.setText((CharSequence)localObject);
            label105:
            localWAGamePanelInputEditText.setSelection(localWAGamePanelInputEditText.getText().length());
          }
        }
      }
      for (;;)
      {
        this.gcp.C(this.dIS, this.gcq.h("ok", null));
        return;
        localObject = this.eOB;
        break;
        localWAGamePanelInputEditText.setText(this.eOB);
        break label105;
        localWAGamePanelInputEditText.setText("");
      }
    }
    this.gcp.C(this.dIS, this.gcq.h("fail", null));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.game.d.a.f.1
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.account.ui;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.platformtools.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al.a;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.d;

final class RegSetInfoUI$23
  implements al.a
{
  String gJX;
  Bitmap mBitmap;
  
  RegSetInfoUI$23(RegSetInfoUI paramRegSetInfoUI) {}
  
  public final boolean acS()
  {
    AppMethodBeat.i(125529);
    try
    {
      this.gJX = i.cp(this.gJQ);
      this.mBitmap = i.cq(this.gJQ);
      if ((this.mBitmap == null) || (this.mBitmap.isRecycled())) {}
    }
    catch (Exception localException1)
    {
      try
      {
        d.a(this.mBitmap, 100, Bitmap.CompressFormat.PNG, e.esy + "temp.avatar", false);
        AppMethodBeat.o(125529);
        return true;
        localException1 = localException1;
        ab.e("MiroMsg.RegSetInfoUI", "getName or getBitmap err : " + localException1.getMessage());
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          ab.e("MiroMsg.RegSetInfoUI", "save avatar fail." + localException2.getMessage());
          ab.printErrStackTrace("MiroMsg.RegSetInfoUI", localException2, "", new Object[0]);
        }
      }
    }
  }
  
  public final boolean acT()
  {
    AppMethodBeat.i(125528);
    if ((!bo.isNullOrNil(this.gJX)) && (bo.isNullOrNil(RegSetInfoUI.b(this.gJQ).getText().trim()))) {
      RegSetInfoUI.b(this.gJQ).setText(this.gJX);
    }
    if (!f.Mi())
    {
      ab.e("MiroMsg.RegSetInfoUI", "SDcard is not available");
      AppMethodBeat.o(125528);
      return false;
    }
    if ((this.mBitmap != null) && (!this.mBitmap.isRecycled()) && (!RegSetInfoUI.j(this.gJQ)))
    {
      RegSetInfoUI.i(this.gJQ).setImageBitmap(this.mBitmap);
      RegSetInfoUI.k(this.gJQ);
      RegSetInfoUI.l(this.gJQ).setVisibility(0);
    }
    AppMethodBeat.o(125528);
    return true;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(125530);
    String str = super.toString() + "|initView";
    AppMethodBeat.o(125530);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.RegSetInfoUI.23
 * JD-Core Version:    0.7.0.1
 */
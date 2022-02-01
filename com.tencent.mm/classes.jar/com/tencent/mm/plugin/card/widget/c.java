package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.protobuf.aaf;
import com.tencent.mm.protocal.protobuf.ts;
import java.util.LinkedList;

public final class c
  extends a
{
  protected TextView oQf;
  protected TextView oQg;
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void I(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected final void bYI()
  {
    AppMethodBeat.i(113902);
    this.oQg = ((TextView)bYH().findViewById(2131297733));
    this.oQf = ((TextView)bYH().findViewById(2131297902));
    AppMethodBeat.o(113902);
  }
  
  protected final void bYJ()
  {
    AppMethodBeat.i(113903);
    if ((this.owK.bTN().FRz != null) && (this.owK.bTN().FRz.size() > 0))
    {
      aaf localaaf = (aaf)this.owK.bTN().FRz.get(0);
      if (this.mMD != null) {
        this.mMD.setText(localaaf.title);
      }
      if (this.oQf != null)
      {
        if (TextUtils.isEmpty(localaaf.oxN)) {
          break label138;
        }
        this.oQf.setText(localaaf.oxN);
      }
      while (this.oQg != null) {
        if (!TextUtils.isEmpty(localaaf.oxO))
        {
          this.oQg.setText(localaaf.oxO);
          AppMethodBeat.o(113903);
          return;
          label138:
          this.oQf.setVisibility(8);
        }
        else
        {
          this.oQg.setVisibility(8);
        }
      }
    }
    AppMethodBeat.o(113903);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.c
 * JD-Core Version:    0.7.0.1
 */
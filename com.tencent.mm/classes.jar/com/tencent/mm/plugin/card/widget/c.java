package com.tencent.mm.plugin.card.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.card.a.d;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.protocal.protobuf.aek;
import com.tencent.mm.protocal.protobuf.ws;
import java.util.LinkedList;

public final class c
  extends a
{
  protected TextView wLg;
  protected TextView wLh;
  
  public c(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void P(boolean paramBoolean1, boolean paramBoolean2) {}
  
  protected final void doX()
  {
    AppMethodBeat.i(113902);
    this.wLh = ((TextView)doW().findViewById(a.d.wfr));
    this.wLg = ((TextView)doW().findViewById(a.d.fvw));
    AppMethodBeat.o(113902);
  }
  
  protected final void doY()
  {
    AppMethodBeat.i(113903);
    if ((this.wru.djK().ZdK != null) && (this.wru.djK().ZdK.size() > 0))
    {
      aek localaek = (aek)this.wru.djK().ZdK.get(0);
      if (this.uov != null) {
        this.uov.setText(localaek.title);
      }
      if (this.wLg != null)
      {
        if (TextUtils.isEmpty(localaek.wsz)) {
          break label138;
        }
        this.wLg.setText(localaek.wsz);
      }
      while (this.wLh != null) {
        if (!TextUtils.isEmpty(localaek.wsA))
        {
          this.wLh.setText(localaek.wsA);
          AppMethodBeat.o(113903);
          return;
          label138:
          this.wLg.setVisibility(8);
        }
        else
        {
          this.wLh.setVisibility(8);
        }
      }
    }
    AppMethodBeat.o(113903);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.widget.c
 * JD-Core Version:    0.7.0.1
 */
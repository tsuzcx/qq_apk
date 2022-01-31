package com.tencent.mm.plugin.brandservice.ui;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class BizSearchResultItemContainer$a
{
  View jTP;
  View jTQ;
  View jTR;
  
  private void w(boolean paramBoolean1, boolean paramBoolean2)
  {
    int j = 0;
    AppMethodBeat.i(13901);
    View localView = this.jTP;
    if (paramBoolean1)
    {
      i = 0;
      localView.setVisibility(i);
      this.jTQ.setVisibility(8);
      localView = this.jTR;
      if (!paramBoolean2) {
        break label68;
      }
    }
    label68:
    for (int i = j;; i = 8)
    {
      localView.setVisibility(i);
      AppMethodBeat.o(13901);
      return;
      i = 8;
      break;
    }
  }
  
  public final void sb(int paramInt)
  {
    AppMethodBeat.i(13900);
    switch (paramInt)
    {
    default: 
      w(false, false);
      AppMethodBeat.o(13900);
      return;
    case 1: 
      w(true, false);
      AppMethodBeat.o(13900);
      return;
    case 2: 
      w(false, true);
      AppMethodBeat.o(13900);
      return;
    }
    w(false, false);
    AppMethodBeat.o(13900);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.BizSearchResultItemContainer.a
 * JD-Core Version:    0.7.0.1
 */
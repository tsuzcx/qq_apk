package com.facebook.internal;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;

class WebDialog$2
  implements View.OnClickListener
{
  WebDialog$2(WebDialog paramWebDialog) {}
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(96656);
    this.this$0.cancel();
    AppMethodBeat.o(96656);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.internal.WebDialog.2
 * JD-Core Version:    0.7.0.1
 */
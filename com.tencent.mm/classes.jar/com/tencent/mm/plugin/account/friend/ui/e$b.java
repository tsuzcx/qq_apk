package com.tencent.mm.plugin.account.friend.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class e$b
{
  ImageView ehv;
  TextView gpr;
  int gvH;
  TextView gvI;
  View gvJ;
  ProgressBar gvK;
  String gzN;
  int status;
  
  public e$b(final e parame, View paramView)
  {
    AppMethodBeat.i(108594);
    this.ehv = ((ImageView)paramView.findViewById(2131823956));
    this.gvI = ((TextView)paramView.findViewById(2131823957));
    this.gvJ = paramView.findViewById(2131826873);
    this.gpr = ((TextView)paramView.findViewById(2131826874));
    this.gvK = ((ProgressBar)paramView.findViewById(2131826875));
    this.gvJ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(108593);
        if (e.b(e.b.this.gzL) != null) {
          e.b(e.b.this.gzL).d(e.b.this.gvH, e.b.this.gzN, e.b.this.status);
        }
        AppMethodBeat.o(108593);
      }
    });
    AppMethodBeat.o(108594);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.e.b
 * JD-Core Version:    0.7.0.1
 */
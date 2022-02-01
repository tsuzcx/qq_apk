package com.tencent.mm.plugin.choosemsgfile.b.c;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.choosemsgfile.b.b.l;
import com.tencent.mm.plugin.choosemsgfile.b.b.n;
import com.tencent.mm.plugin.choosemsgfile.ui.e;
import java.util.List;

public final class d
  extends a
{
  public d(e parame, List<com.tencent.mm.plugin.choosemsgfile.b.b.a> paramList)
  {
    super(parame, paramList);
  }
  
  public final RecyclerView.v b(ViewGroup paramViewGroup, int paramInt)
  {
    AppMethodBeat.i(243480);
    switch (paramInt)
    {
    default: 
      paramViewGroup = n.p(paramViewGroup);
      AppMethodBeat.o(243480);
      return paramViewGroup;
    }
    paramViewGroup = l.p(paramViewGroup);
    AppMethodBeat.o(243480);
    return paramViewGroup;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.choosemsgfile.b.c.d
 * JD-Core Version:    0.7.0.1
 */
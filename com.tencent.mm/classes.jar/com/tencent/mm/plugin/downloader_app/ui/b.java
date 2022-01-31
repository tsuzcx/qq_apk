package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.l;
import com.tencent.mm.plugin.downloader_app.b.h;
import com.tencent.mm.plugin.downloader_app.b.i;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.LinkedList;

public final class b
  extends RecyclerView.a<b.a>
{
  h<i> lcP;
  private boolean lcQ;
  private boolean lcR;
  private boolean lcS;
  private boolean lcT;
  boolean lcU;
  boolean lcV;
  private Context mContext;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(136285);
    this.lcP = new h();
    this.lcQ = true;
    this.lcR = false;
    this.lcS = false;
    this.lcT = false;
    this.lcU = false;
    this.lcV = true;
    this.mContext = paramContext;
    AppMethodBeat.o(136285);
  }
  
  public final void P(LinkedList<i> paramLinkedList)
  {
    AppMethodBeat.i(136288);
    if (bo.es(paramLinkedList))
    {
      AppMethodBeat.o(136288);
      return;
    }
    if (paramLinkedList.size() == 1)
    {
      int i = this.lcP.indexOf(paramLinkedList.get(0));
      this.lcP.remove(i);
      l.q(new b.2(this, i));
      AppMethodBeat.o(136288);
      return;
    }
    this.lcP.removeAll(paramLinkedList);
    l.q(new b.3(this));
    AppMethodBeat.o(136288);
  }
  
  public final boolean bjQ()
  {
    AppMethodBeat.i(136289);
    if (this.lcP.size() <= 5)
    {
      AppMethodBeat.o(136289);
      return true;
    }
    AppMethodBeat.o(136289);
    return false;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(136287);
    int i = this.lcP.size();
    AppMethodBeat.o(136287);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(136286);
    paramInt = ((i)this.lcP.get(paramInt)).type;
    AppMethodBeat.o(136286);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.b
 * JD-Core Version:    0.7.0.1
 */
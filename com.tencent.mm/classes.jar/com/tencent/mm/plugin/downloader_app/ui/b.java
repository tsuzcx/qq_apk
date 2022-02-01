package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.plugin.downloader_app.a.i;
import com.tencent.mm.plugin.game.commlib.c.c;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class b
  extends RecyclerView.a<b.a>
{
  private Context mContext;
  c<i> qMX;
  private boolean qMY;
  private boolean qMZ;
  private boolean qNa;
  private boolean qNb;
  boolean qNc;
  boolean qNd;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(9055);
    this.qMX = new c();
    this.qMY = true;
    this.qMZ = false;
    this.qNa = false;
    this.qNb = false;
    this.qNc = false;
    this.qNd = true;
    this.mContext = paramContext;
    AppMethodBeat.o(9055);
  }
  
  public final void Y(LinkedList<i> paramLinkedList)
  {
    AppMethodBeat.i(9058);
    if (Util.isNullOrNil(paramLinkedList))
    {
      AppMethodBeat.o(9058);
      return;
    }
    if (paramLinkedList.size() == 1)
    {
      final int i = this.qMX.indexOf(paramLinkedList.get(0));
      this.qMX.remove(i);
      p.y(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(9052);
          b.this.ck(i);
          AppMethodBeat.o(9052);
        }
      });
      AppMethodBeat.o(9058);
      return;
    }
    this.qMX.removeAll(paramLinkedList);
    p.y(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9053);
        b.this.atj.notifyChanged();
        AppMethodBeat.o(9053);
      }
    });
    AppMethodBeat.o(9058);
  }
  
  public final boolean cCb()
  {
    AppMethodBeat.i(9059);
    if (this.qMX.size() <= 5)
    {
      AppMethodBeat.o(9059);
      return true;
    }
    AppMethodBeat.o(9059);
    return false;
  }
  
  public final int getItemCount()
  {
    AppMethodBeat.i(9057);
    int i = this.qMX.size();
    AppMethodBeat.o(9057);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(9056);
    paramInt = ((i)this.qMX.get(paramInt)).type;
    AppMethodBeat.o(9056);
    return paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.v;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.p;
import com.tencent.mm.plugin.downloader_app.a.i;
import com.tencent.mm.plugin.game.commlib.c.c;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;

public final class b
  extends RecyclerView.a<a>
{
  private Context mContext;
  c<i> ojS;
  private boolean ojT;
  private boolean ojU;
  private boolean ojV;
  private boolean ojW;
  boolean ojX;
  boolean ojY;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(9055);
    this.ojS = new c();
    this.ojT = true;
    this.ojU = false;
    this.ojV = false;
    this.ojW = false;
    this.ojX = false;
    this.ojY = true;
    this.mContext = paramContext;
    AppMethodBeat.o(9055);
  }
  
  public final void V(LinkedList<i> paramLinkedList)
  {
    AppMethodBeat.i(9058);
    if (bt.gL(paramLinkedList))
    {
      AppMethodBeat.o(9058);
      return;
    }
    if (paramLinkedList.size() == 1)
    {
      final int i = this.ojS.indexOf(paramLinkedList.get(0));
      this.ojS.remove(i);
      p.y(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(9052);
          b.this.cm(i);
          AppMethodBeat.o(9052);
        }
      });
      AppMethodBeat.o(9058);
      return;
    }
    this.ojS.removeAll(paramLinkedList);
    p.y(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9053);
        b.this.aql.notifyChanged();
        AppMethodBeat.o(9053);
      }
    });
    AppMethodBeat.o(9058);
  }
  
  public final boolean bRd()
  {
    AppMethodBeat.i(9059);
    if (this.ojS.size() <= 5)
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
    int i = this.ojS.size();
    AppMethodBeat.o(9057);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(9056);
    paramInt = ((i)this.ojS.get(paramInt)).type;
    AppMethodBeat.o(9056);
    return paramInt;
  }
  
  public static final class a
    extends RecyclerView.v
  {
    public View contentView;
    
    public a(View paramView)
    {
      super();
      AppMethodBeat.i(9054);
      this.contentView = ((ViewGroup)paramView).getChildAt(0);
      AppMethodBeat.o(9054);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.s;
import com.tencent.mm.plugin.downloader_app.a.i;
import com.tencent.mm.plugin.game.commlib.c.c;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;

public final class b
  extends RecyclerView.a<a>
{
  private Context mContext;
  TaskItemView.a xuE;
  c<i> xuH;
  private boolean xuI;
  private boolean xuJ;
  private boolean xuK;
  private boolean xuL;
  boolean xuM;
  boolean xuN;
  
  public b(Context paramContext)
  {
    AppMethodBeat.i(9055);
    this.xuH = new c();
    this.xuI = true;
    this.xuJ = false;
    this.xuK = false;
    this.xuL = false;
    this.xuM = false;
    this.xuN = true;
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
      final int i = this.xuH.indexOf(paramLinkedList.get(0));
      this.xuH.remove(i);
      s.D(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(9052);
          b.this.fX(i);
          AppMethodBeat.o(9052);
        }
      });
      AppMethodBeat.o(9058);
      return;
    }
    this.xuH.removeAll(paramLinkedList);
    s.D(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(9053);
        b.this.bZE.notifyChanged();
        AppMethodBeat.o(9053);
      }
    });
    AppMethodBeat.o(9058);
  }
  
  public final boolean duY()
  {
    AppMethodBeat.i(9059);
    if (this.xuH.size() <= 5)
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
    int i = this.xuH.size();
    AppMethodBeat.o(9057);
    return i;
  }
  
  public final int getItemViewType(int paramInt)
  {
    AppMethodBeat.i(9056);
    paramInt = ((i)this.xuH.get(paramInt)).type;
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
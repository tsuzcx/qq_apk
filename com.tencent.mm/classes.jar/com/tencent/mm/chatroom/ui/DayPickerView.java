package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.l;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.a.b.a;
import java.util.Collection;

public class DayPickerView
  extends RecyclerView
{
  private TypedArray grn;
  private com.tencent.mm.chatroom.a.a gro;
  protected com.tencent.mm.chatroom.a.b guT;
  protected int guU;
  protected long guV;
  protected int guW;
  private RecyclerView.l guX;
  private Collection<com.tencent.mm.chatroom.d.a> guY;
  private long guZ;
  protected Context mContext;
  
  public DayPickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DayPickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(12625);
    this.guU = 0;
    this.guW = 0;
    this.guZ = -1L;
    if (!isInEditMode())
    {
      this.grn = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.DayPickerView);
      setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
      setLayoutManager(new LinearLayoutManager());
      this.mContext = paramContext;
      setVerticalScrollBarEnabled(false);
      setOnScrollListener(this.guX);
      setFadingEdgeLength(0);
      this.guX = new RecyclerView.l()
      {
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(194116);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousRecyclerView);
          localb.pH(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/DayPickerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.axR());
          super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/DayPickerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(194116);
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(12624);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bm(paramAnonymousRecyclerView);
          localb.pH(paramAnonymousInt1);
          localb.pH(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/DayPickerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.axR());
          super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          if ((c)paramAnonymousRecyclerView.getChildAt(0) == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/DayPickerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(12624);
            return;
          }
          DayPickerView.this.guV = paramAnonymousInt2;
          DayPickerView.this.guW = DayPickerView.this.guU;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/DayPickerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(12624);
        }
      };
    }
    AppMethodBeat.o(12625);
  }
  
  public final void a(com.tencent.mm.chatroom.a.a parama, Collection<com.tencent.mm.chatroom.d.a> paramCollection)
  {
    AppMethodBeat.i(12626);
    this.guY = paramCollection;
    this.gro = parama;
    setUpAdapter(paramCollection);
    setAdapter(this.guT);
    parama = com.tencent.mm.hellhoundlib.b.c.a(this.guT.getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(this, parama.axQ(), "com/tencent/mm/chatroom/ui/DayPickerView", "setController", "(Lcom/tencent/mm/chatroom/adapter/DatePickerController;Ljava/util/Collection;)V", "Undefined", "scrollToPosition", "(I)V");
    scrollToPosition(((Integer)parama.pG(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/DayPickerView", "setController", "(Lcom/tencent/mm/chatroom/adapter/DatePickerController;Ljava/util/Collection;)V", "Undefined", "scrollToPosition", "(I)V");
    this.guT.atj.notifyChanged();
    AppMethodBeat.o(12626);
  }
  
  protected com.tencent.mm.chatroom.a.a getController()
  {
    return this.gro;
  }
  
  public b.a<com.tencent.mm.chatroom.d.a> getSelectedDays()
  {
    return this.guT.grp;
  }
  
  protected TypedArray getTypedArray()
  {
    return this.grn;
  }
  
  public void setBeginDate(long paramLong)
  {
    this.guZ = paramLong;
  }
  
  protected void setUpAdapter(Collection<com.tencent.mm.chatroom.d.a> paramCollection)
  {
    AppMethodBeat.i(12627);
    if (this.guT == null) {
      this.guT = new com.tencent.mm.chatroom.a.b(getContext(), this.gro, this.grn, this.guZ, paramCollection);
    }
    AppMethodBeat.o(12627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.DayPickerView
 * JD-Core Version:    0.7.0.1
 */
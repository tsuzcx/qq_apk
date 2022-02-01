package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.b;
import android.support.v7.widget.RecyclerView.m;
import android.util.AttributeSet;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.a.b.a;
import java.util.Collection;

public class DayPickerView
  extends RecyclerView
{
  private TypedArray fJW;
  private com.tencent.mm.chatroom.a.a fJX;
  protected com.tencent.mm.chatroom.a.b fNC;
  protected int fND;
  protected long fNE;
  protected int fNF;
  private RecyclerView.m fNG;
  private Collection<com.tencent.mm.chatroom.d.a> fNH;
  private long fNI;
  protected Context mContext;
  
  public DayPickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DayPickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(12625);
    this.fND = 0;
    this.fNF = 0;
    this.fNI = -1L;
    if (!isInEditMode())
    {
      this.fJW = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.DayPickerView);
      setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
      setLayoutManager(new LinearLayoutManager());
      this.mContext = paramContext;
      setVerticalScrollBarEnabled(false);
      setOnScrollListener(this.fNG);
      setFadingEdgeLength(0);
      this.fNG = new RecyclerView.m()
      {
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(12624);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousRecyclerView);
          localb.mr(paramAnonymousInt1);
          localb.mr(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/DayPickerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahq());
          super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          if ((c)paramAnonymousRecyclerView.getChildAt(0) == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/DayPickerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(12624);
            return;
          }
          DayPickerView.this.fNE = paramAnonymousInt2;
          DayPickerView.this.fNF = DayPickerView.this.fND;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/DayPickerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(12624);
        }
        
        public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(213485);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousRecyclerView);
          localb.mr(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/DayPickerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahq());
          super.b(paramAnonymousRecyclerView, paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/DayPickerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(213485);
        }
      };
    }
    AppMethodBeat.o(12625);
  }
  
  public final void a(com.tencent.mm.chatroom.a.a parama, Collection<com.tencent.mm.chatroom.d.a> paramCollection)
  {
    AppMethodBeat.i(12626);
    this.fNH = paramCollection;
    this.fJX = parama;
    setUpAdapter(paramCollection);
    setAdapter(this.fNC);
    parama = com.tencent.mm.hellhoundlib.b.c.a(this.fNC.getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(this, parama.ahp(), "com/tencent/mm/chatroom/ui/DayPickerView", "setController", "(Lcom/tencent/mm/chatroom/adapter/DatePickerController;Ljava/util/Collection;)V", "Undefined", "scrollToPosition", "(I)V");
    ca(((Integer)parama.mq(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/DayPickerView", "setController", "(Lcom/tencent/mm/chatroom/adapter/DatePickerController;Ljava/util/Collection;)V", "Undefined", "scrollToPosition", "(I)V");
    this.fNC.asY.notifyChanged();
    AppMethodBeat.o(12626);
  }
  
  protected com.tencent.mm.chatroom.a.a getController()
  {
    return this.fJX;
  }
  
  public b.a<com.tencent.mm.chatroom.d.a> getSelectedDays()
  {
    return this.fNC.fJY;
  }
  
  protected TypedArray getTypedArray()
  {
    return this.fJW;
  }
  
  public void setBeginDate(long paramLong)
  {
    this.fNI = paramLong;
  }
  
  protected void setUpAdapter(Collection<com.tencent.mm.chatroom.d.a> paramCollection)
  {
    AppMethodBeat.i(12627);
    if (this.fNC == null) {
      this.fNC = new com.tencent.mm.chatroom.a.b(getContext(), this.fJX, this.fJW, this.fNI, paramCollection);
    }
    AppMethodBeat.o(12627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.DayPickerView
 * JD-Core Version:    0.7.0.1
 */
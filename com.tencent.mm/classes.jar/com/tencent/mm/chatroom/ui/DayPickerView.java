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
  private TypedArray fLZ;
  private com.tencent.mm.chatroom.a.a fMa;
  protected com.tencent.mm.chatroom.a.b fPJ;
  protected int fPK;
  protected long fPL;
  protected int fPM;
  private RecyclerView.m fPN;
  private Collection<com.tencent.mm.chatroom.d.a> fPO;
  private long fPP;
  protected Context mContext;
  
  public DayPickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DayPickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(12625);
    this.fPK = 0;
    this.fPM = 0;
    this.fPP = -1L;
    if (!isInEditMode())
    {
      this.fLZ = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.DayPickerView);
      setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
      setLayoutManager(new LinearLayoutManager());
      this.mContext = paramContext;
      setVerticalScrollBarEnabled(false);
      setOnScrollListener(this.fPN);
      setFadingEdgeLength(0);
      this.fPN = new RecyclerView.m()
      {
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(12624);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousRecyclerView);
          localb.mu(paramAnonymousInt1);
          localb.mu(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/DayPickerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V", this, localb.ahF());
          super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          if ((c)paramAnonymousRecyclerView.getChildAt(0) == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/DayPickerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
            AppMethodBeat.o(12624);
            return;
          }
          DayPickerView.this.fPL = paramAnonymousInt2;
          DayPickerView.this.fPM = DayPickerView.this.fPK;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/DayPickerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroid/support/v7/widget/RecyclerView;II)V");
          AppMethodBeat.o(12624);
        }
        
        public final void b(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(217202);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.bd(paramAnonymousRecyclerView);
          localb.mu(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/DayPickerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V", this, localb.ahF());
          super.b(paramAnonymousRecyclerView, paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/DayPickerView$1", "android/support/v7/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroid/support/v7/widget/RecyclerView;I)V");
          AppMethodBeat.o(217202);
        }
      };
    }
    AppMethodBeat.o(12625);
  }
  
  public final void a(com.tencent.mm.chatroom.a.a parama, Collection<com.tencent.mm.chatroom.d.a> paramCollection)
  {
    AppMethodBeat.i(12626);
    this.fPO = paramCollection;
    this.fMa = parama;
    setUpAdapter(paramCollection);
    setAdapter(this.fPJ);
    parama = com.tencent.mm.hellhoundlib.b.c.a(this.fPJ.getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.a(this, parama.ahE(), "com/tencent/mm/chatroom/ui/DayPickerView", "setController", "(Lcom/tencent/mm/chatroom/adapter/DatePickerController;Ljava/util/Collection;)V", "Undefined", "scrollToPosition", "(I)V");
    ca(((Integer)parama.mt(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/DayPickerView", "setController", "(Lcom/tencent/mm/chatroom/adapter/DatePickerController;Ljava/util/Collection;)V", "Undefined", "scrollToPosition", "(I)V");
    this.fPJ.asY.notifyChanged();
    AppMethodBeat.o(12626);
  }
  
  protected com.tencent.mm.chatroom.a.a getController()
  {
    return this.fMa;
  }
  
  public b.a<com.tencent.mm.chatroom.d.a> getSelectedDays()
  {
    return this.fPJ.fMb;
  }
  
  protected TypedArray getTypedArray()
  {
    return this.fLZ;
  }
  
  public void setBeginDate(long paramLong)
  {
    this.fPP = paramLong;
  }
  
  protected void setUpAdapter(Collection<com.tencent.mm.chatroom.d.a> paramCollection)
  {
    AppMethodBeat.i(12627);
    if (this.fPJ == null) {
      this.fPJ = new com.tencent.mm.chatroom.a.b(getContext(), this.fMa, this.fLZ, this.fPP, paramCollection);
    }
    AppMethodBeat.o(12627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.DayPickerView
 * JD-Core Version:    0.7.0.1
 */
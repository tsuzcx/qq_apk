package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.LayoutParams;
import androidx.recyclerview.widget.RecyclerView.a;
import androidx.recyclerview.widget.RecyclerView.b;
import androidx.recyclerview.widget.RecyclerView.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.chatroom.a.b.a;
import com.tencent.mm.hellhoundlib.b.c;
import java.util.Collection;

public class DayPickerView
  extends RecyclerView
{
  protected com.tencent.mm.chatroom.a.b lBa;
  protected int lBb;
  protected long lBc;
  protected int lBd;
  private RecyclerView.l lBe;
  private Collection<com.tencent.mm.chatroom.d.a> lBf;
  private long lBg;
  private TypedArray lxB;
  private com.tencent.mm.chatroom.a.a lxC;
  protected Context mContext;
  
  public DayPickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DayPickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(12625);
    this.lBb = 0;
    this.lBd = 0;
    this.lBg = -1L;
    if (!isInEditMode())
    {
      this.lxB = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.haa);
      setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
      setLayoutManager(new LinearLayoutManager());
      this.mContext = paramContext;
      setVerticalScrollBarEnabled(false);
      setOnScrollListener(this.lBe);
      setFadingEdgeLength(0);
      this.lBe = new RecyclerView.l()
      {
        public final void onScrollStateChanged(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt)
        {
          AppMethodBeat.i(241782);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousRecyclerView);
          localb.sc(paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/DayPickerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", this, localb.aYj());
          super.onScrollStateChanged(paramAnonymousRecyclerView, paramAnonymousInt);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/DayPickerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V");
          AppMethodBeat.o(241782);
        }
        
        public final void onScrolled(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(241778);
          com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
          localb.cH(paramAnonymousRecyclerView);
          localb.sc(paramAnonymousInt1);
          localb.sc(paramAnonymousInt2);
          com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/DayPickerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", this, localb.aYj());
          super.onScrolled(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          if ((e)paramAnonymousRecyclerView.getChildAt(0) == null)
          {
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/DayPickerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
            AppMethodBeat.o(241778);
            return;
          }
          DayPickerView.this.lBc = paramAnonymousInt2;
          DayPickerView.this.lBd = DayPickerView.this.lBb;
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/DayPickerView$1", "androidx/recyclerview/widget/RecyclerView$OnScrollListener", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V");
          AppMethodBeat.o(241778);
        }
      };
    }
    AppMethodBeat.o(12625);
  }
  
  public final void a(com.tencent.mm.chatroom.a.a parama, Collection<com.tencent.mm.chatroom.d.a> paramCollection)
  {
    AppMethodBeat.i(12626);
    this.lBf = paramCollection;
    this.lxC = parama;
    setUpAdapter(paramCollection);
    setAdapter(this.lBa);
    parama = c.a(this.lBa.getItemCount() - 1, new com.tencent.mm.hellhoundlib.b.a());
    com.tencent.mm.hellhoundlib.a.a.b(this, parama.aYi(), "com/tencent/mm/chatroom/ui/DayPickerView", "setController", "(Lcom/tencent/mm/chatroom/adapter/DatePickerController;Ljava/util/Collection;)V", "Undefined", "scrollToPosition", "(I)V");
    scrollToPosition(((Integer)parama.sb(0)).intValue());
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/chatroom/ui/DayPickerView", "setController", "(Lcom/tencent/mm/chatroom/adapter/DatePickerController;Ljava/util/Collection;)V", "Undefined", "scrollToPosition", "(I)V");
    this.lBa.bZE.notifyChanged();
    AppMethodBeat.o(12626);
  }
  
  protected com.tencent.mm.chatroom.a.a getController()
  {
    return this.lxC;
  }
  
  public b.a<com.tencent.mm.chatroom.d.a> getSelectedDays()
  {
    return this.lBa.lxE;
  }
  
  protected TypedArray getTypedArray()
  {
    return this.lxB;
  }
  
  public void setBeginDate(long paramLong)
  {
    this.lBg = paramLong;
  }
  
  protected void setUpAdapter(Collection<com.tencent.mm.chatroom.d.a> paramCollection)
  {
    AppMethodBeat.i(12627);
    if (this.lBa == null) {
      this.lBa = new com.tencent.mm.chatroom.a.b(getContext(), this.lxC, this.lxB, this.lBg, paramCollection);
    }
    AppMethodBeat.o(12627);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.DayPickerView
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.chatroom.a.b;
import com.tencent.mm.chatroom.a.b.a;
import java.util.Collection;

public class DayPickerView
  extends RecyclerView
{
  private TypedArray dmw;
  private com.tencent.mm.chatroom.a.a dmx;
  protected b doD;
  protected int doE = 0;
  protected long doF;
  private RecyclerView.m doG;
  private Collection<com.tencent.mm.chatroom.c.a> doH;
  private long doI = -1L;
  protected int le = 0;
  protected Context mContext;
  
  public DayPickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DayPickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    if (!isInEditMode())
    {
      this.dmw = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.DayPickerView);
      setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
      setLayoutManager(new LinearLayoutManager());
      this.mContext = paramContext;
      setVerticalScrollBarEnabled(false);
      setOnScrollListener(this.doG);
      setFadingEdgeLength(0);
      this.doG = new RecyclerView.m()
      {
        public final void a(RecyclerView paramAnonymousRecyclerView, int paramAnonymousInt1, int paramAnonymousInt2)
        {
          super.a(paramAnonymousRecyclerView, paramAnonymousInt1, paramAnonymousInt2);
          if ((c)paramAnonymousRecyclerView.getChildAt(0) == null) {
            return;
          }
          DayPickerView.this.doF = paramAnonymousInt2;
          DayPickerView.this.le = DayPickerView.this.doE;
        }
      };
    }
  }
  
  public final void a(com.tencent.mm.chatroom.a.a parama, Collection<com.tencent.mm.chatroom.c.a> paramCollection)
  {
    this.doH = paramCollection;
    this.dmx = parama;
    setUpAdapter(paramCollection);
    setAdapter(this.doD);
    bE(this.doD.getItemCount() - 1);
    this.doD.agL.notifyChanged();
  }
  
  protected com.tencent.mm.chatroom.a.a getController()
  {
    return this.dmx;
  }
  
  public b.a<com.tencent.mm.chatroom.c.a> getSelectedDays()
  {
    return this.doD.dmy;
  }
  
  protected TypedArray getTypedArray()
  {
    return this.dmw;
  }
  
  public void setBeginDate(long paramLong)
  {
    this.doI = paramLong;
  }
  
  protected void setUpAdapter(Collection<com.tencent.mm.chatroom.c.a> paramCollection)
  {
    if (this.doD == null) {
      this.doD = new b(getContext(), this.dmx, this.dmw, this.doI, paramCollection);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.DayPickerView
 * JD-Core Version:    0.7.0.1
 */
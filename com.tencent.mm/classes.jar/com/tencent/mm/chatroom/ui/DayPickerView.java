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
import com.tencent.mm.chatroom.a.b;
import com.tencent.mm.chatroom.a.b.a;
import java.util.Collection;

public class DayPickerView
  extends RecyclerView
{
  private TypedArray edZ;
  private com.tencent.mm.chatroom.a.a eea;
  protected b efZ;
  protected int ega;
  protected long egb;
  private RecyclerView.m egc;
  private Collection<com.tencent.mm.chatroom.c.a> egd;
  private long ege;
  protected Context mContext;
  protected int mb;
  
  public DayPickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public DayPickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104080);
    this.ega = 0;
    this.mb = 0;
    this.ege = -1L;
    if (!isInEditMode())
    {
      this.edZ = paramContext.obtainStyledAttributes(paramAttributeSet, a.a.DayPickerView);
      setLayoutParams(new RecyclerView.LayoutParams(-1, -1));
      setLayoutManager(new LinearLayoutManager());
      this.mContext = paramContext;
      setVerticalScrollBarEnabled(false);
      setOnScrollListener(this.egc);
      setFadingEdgeLength(0);
      this.egc = new DayPickerView.1(this);
    }
    AppMethodBeat.o(104080);
  }
  
  public final void a(com.tencent.mm.chatroom.a.a parama, Collection<com.tencent.mm.chatroom.c.a> paramCollection)
  {
    AppMethodBeat.i(104081);
    this.egd = paramCollection;
    this.eea = parama;
    setUpAdapter(paramCollection);
    setAdapter(this.efZ);
    bJ(this.efZ.getItemCount() - 1);
    this.efZ.ajb.notifyChanged();
    AppMethodBeat.o(104081);
  }
  
  protected com.tencent.mm.chatroom.a.a getController()
  {
    return this.eea;
  }
  
  public b.a<com.tencent.mm.chatroom.c.a> getSelectedDays()
  {
    return this.efZ.eeb;
  }
  
  protected TypedArray getTypedArray()
  {
    return this.edZ;
  }
  
  public void setBeginDate(long paramLong)
  {
    this.ege = paramLong;
  }
  
  protected void setUpAdapter(Collection<com.tencent.mm.chatroom.c.a> paramCollection)
  {
    AppMethodBeat.i(104082);
    if (this.efZ == null) {
      this.efZ = new b(getContext(), this.eea, this.edZ, this.ege, paramCollection);
    }
    AppMethodBeat.o(104082);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.DayPickerView
 * JD-Core Version:    0.7.0.1
 */
package android.support.v7.widget;

import android.support.v4.view.q;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class RecyclerView$v
{
  private static final List<Object> aim = Collections.EMPTY_LIST;
  public final View aie;
  WeakReference<RecyclerView> aif;
  int aig = -1;
  public long aih = -1L;
  public int aii = -1;
  int aij = -1;
  v aik = null;
  v ail = null;
  List<Object> ain = null;
  List<Object> aio = null;
  private int aip = 0;
  private RecyclerView.o aiq = null;
  private boolean air = false;
  private int ais = 0;
  int ait = -1;
  RecyclerView aiu;
  int mPosition = -1;
  private int wg;
  
  public RecyclerView$v(View paramView)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("itemView may not be null");
    }
    this.aie = paramView;
  }
  
  final void M(Object paramObject)
  {
    if (paramObject == null) {
      addFlags(1024);
    }
    while ((this.wg & 0x400) != 0) {
      return;
    }
    if (this.ain == null)
    {
      this.ain = new ArrayList();
      this.aio = Collections.unmodifiableList(this.ain);
    }
    this.ain.add(paramObject);
  }
  
  final void a(RecyclerView.o paramo, boolean paramBoolean)
  {
    this.aiq = paramo;
    this.air = paramBoolean;
  }
  
  final void addFlags(int paramInt)
  {
    this.wg |= paramInt;
  }
  
  public final void ag(boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      i = this.aip - 1;
      this.aip = i;
      if (this.aip >= 0) {
        break label53;
      }
      this.aip = 0;
      new StringBuilder("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ").append(this);
    }
    label53:
    do
    {
      return;
      i = this.aip + 1;
      break;
      if ((!paramBoolean) && (this.aip == 1))
      {
        this.wg |= 0x10;
        return;
      }
    } while ((!paramBoolean) || (this.aip != 0));
    this.wg &= 0xFFFFFFEF;
  }
  
  final boolean ca(int paramInt)
  {
    return (this.wg & paramInt) != 0;
  }
  
  @Deprecated
  public final int getPosition()
  {
    if (this.aij == -1) {
      return this.mPosition;
    }
    return this.aij;
  }
  
  final void ia()
  {
    this.aig = -1;
    this.aij = -1;
  }
  
  final boolean ib()
  {
    return (this.wg & 0x80) != 0;
  }
  
  public final int ic()
  {
    if (this.aij == -1) {
      return this.mPosition;
    }
    return this.aij;
  }
  
  public final int id()
  {
    if (this.aiu == null) {
      return -1;
    }
    return this.aiu.i(this);
  }
  
  final boolean ie()
  {
    return this.aiq != null;
  }
  
  final void jdMethod_if()
  {
    this.aiq.p(this);
  }
  
  final boolean ig()
  {
    return (this.wg & 0x20) != 0;
  }
  
  final void ih()
  {
    this.wg &= 0xFFFFFFDF;
  }
  
  final void ii()
  {
    this.wg &= 0xFFFFFEFF;
  }
  
  final boolean ij()
  {
    return (this.wg & 0x4) != 0;
  }
  
  final boolean ik()
  {
    return (this.wg & 0x2) != 0;
  }
  
  final boolean il()
  {
    return (this.wg & 0x100) != 0;
  }
  
  final void im()
  {
    if (this.ain != null) {
      this.ain.clear();
    }
    this.wg &= 0xFFFFFBFF;
  }
  
  final List<Object> in()
  {
    if ((this.wg & 0x400) == 0)
    {
      if ((this.ain == null) || (this.ain.size() == 0)) {
        return aim;
      }
      return this.aio;
    }
    return aim;
  }
  
  public final boolean io()
  {
    return ((this.wg & 0x10) == 0) && (!q.N(this.aie));
  }
  
  final boolean ip()
  {
    return (this.wg & 0x2) != 0;
  }
  
  final boolean isBound()
  {
    return (this.wg & 0x1) != 0;
  }
  
  final boolean isRemoved()
  {
    return (this.wg & 0x8) != 0;
  }
  
  final void p(int paramInt, boolean paramBoolean)
  {
    if (this.aig == -1) {
      this.aig = this.mPosition;
    }
    if (this.aij == -1) {
      this.aij = this.mPosition;
    }
    if (paramBoolean) {
      this.aij += paramInt;
    }
    this.mPosition += paramInt;
    if (this.aie.getLayoutParams() != null) {
      ((RecyclerView.LayoutParams)this.aie.getLayoutParams()).ahj = true;
    }
  }
  
  final void resetInternal()
  {
    this.wg = 0;
    this.mPosition = -1;
    this.aig = -1;
    this.aih = -1L;
    this.aij = -1;
    this.aip = 0;
    this.aik = null;
    this.ail = null;
    im();
    this.ais = 0;
    this.ait = -1;
    RecyclerView.h(this);
  }
  
  final void setFlags(int paramInt1, int paramInt2)
  {
    this.wg = (this.wg & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.aih + ", oldPos=" + this.aig + ", pLpos:" + this.aij);
    String str;
    if (ie())
    {
      StringBuilder localStringBuilder2 = localStringBuilder1.append(" scrap ");
      if (this.air)
      {
        str = "[changeScrap]";
        localStringBuilder2.append(str);
      }
    }
    else
    {
      if (ij()) {
        localStringBuilder1.append(" invalid");
      }
      if (!isBound()) {
        localStringBuilder1.append(" unbound");
      }
      if (ik()) {
        localStringBuilder1.append(" update");
      }
      if (isRemoved()) {
        localStringBuilder1.append(" removed");
      }
      if (ib()) {
        localStringBuilder1.append(" ignored");
      }
      if (il()) {
        localStringBuilder1.append(" tmpDetached");
      }
      if (!io()) {
        localStringBuilder1.append(" not recyclable(" + this.aip + ")");
      }
      if (((this.wg & 0x200) == 0) && (!ij())) {
        break label307;
      }
    }
    label307:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localStringBuilder1.append(" undefined adapter position");
      }
      if (this.aie.getParent() == null) {
        localStringBuilder1.append(" no parent");
      }
      localStringBuilder1.append("}");
      return localStringBuilder1.toString();
      str = "[attachedScrap]";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     android.support.v7.widget.RecyclerView.v
 * JD-Core Version:    0.7.0.1
 */
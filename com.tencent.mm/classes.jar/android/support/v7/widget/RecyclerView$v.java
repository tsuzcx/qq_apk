package android.support.v7.widget;

import android.support.v4.view.t;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class RecyclerView$v
{
  private static final List<Object> akC = Collections.EMPTY_LIST;
  v akA = null;
  v akB = null;
  List<Object> akD = null;
  List<Object> akE = null;
  private int akF = 0;
  private RecyclerView.o akG = null;
  private boolean akH = false;
  private int akI = 0;
  int akJ = -1;
  RecyclerView akK;
  public final View aku;
  WeakReference<RecyclerView> akv;
  int akw = -1;
  public long akx = -1L;
  public int aky = -1;
  int akz = -1;
  int mPosition = -1;
  private int wy;
  
  public RecyclerView$v(View paramView)
  {
    if (paramView == null) {
      throw new IllegalArgumentException("itemView may not be null");
    }
    this.aku = paramView;
  }
  
  private void jX()
  {
    if (this.akD == null)
    {
      this.akD = new ArrayList();
      this.akE = Collections.unmodifiableList(this.akD);
    }
  }
  
  final void M(Object paramObject)
  {
    if (paramObject == null) {
      addFlags(1024);
    }
    while ((this.wy & 0x400) != 0) {
      return;
    }
    jX();
    this.akD.add(paramObject);
  }
  
  final void a(RecyclerView.o paramo, boolean paramBoolean)
  {
    this.akG = paramo;
    this.akH = paramBoolean;
  }
  
  final void addFlags(int paramInt)
  {
    this.wy |= paramInt;
  }
  
  public final void ap(boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      i = this.akF - 1;
      this.akF = i;
      if (this.akF >= 0) {
        break label53;
      }
      this.akF = 0;
      new StringBuilder("isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for ").append(this);
    }
    label53:
    do
    {
      return;
      i = this.akF + 1;
      break;
      if ((!paramBoolean) && (this.akF == 1))
      {
        this.wy |= 0x10;
        return;
      }
    } while ((!paramBoolean) || (this.akF != 0));
    this.wy &= 0xFFFFFFEF;
  }
  
  final boolean ci(int paramInt)
  {
    return (this.wy & paramInt) != 0;
  }
  
  @Deprecated
  public final int getPosition()
  {
    if (this.akz == -1) {
      return this.mPosition;
    }
    return this.akz;
  }
  
  final boolean isBound()
  {
    return (this.wy & 0x1) != 0;
  }
  
  public final boolean isRemoved()
  {
    return (this.wy & 0x8) != 0;
  }
  
  final void jJ()
  {
    this.akw = -1;
    this.akz = -1;
  }
  
  final void jK()
  {
    if (this.akw == -1) {
      this.akw = this.mPosition;
    }
  }
  
  final boolean jL()
  {
    return (this.wy & 0x80) != 0;
  }
  
  public final int jM()
  {
    if (this.akz == -1) {
      return this.mPosition;
    }
    return this.akz;
  }
  
  public final int jN()
  {
    if (this.akK == null) {
      return -1;
    }
    return this.akK.i(this);
  }
  
  public final int jO()
  {
    return this.aky;
  }
  
  final boolean jP()
  {
    return this.akG != null;
  }
  
  final void jQ()
  {
    this.akG.t(this);
  }
  
  final boolean jR()
  {
    return (this.wy & 0x20) != 0;
  }
  
  final void jS()
  {
    this.wy &= 0xFFFFFFDF;
  }
  
  final void jT()
  {
    this.wy &= 0xFFFFFEFF;
  }
  
  final boolean jU()
  {
    return (this.wy & 0x4) != 0;
  }
  
  final boolean jV()
  {
    return (this.wy & 0x2) != 0;
  }
  
  final boolean jW()
  {
    return (this.wy & 0x100) != 0;
  }
  
  final void jY()
  {
    if (this.akD != null) {
      this.akD.clear();
    }
    this.wy &= 0xFFFFFBFF;
  }
  
  final List<Object> jZ()
  {
    if ((this.wy & 0x400) == 0)
    {
      if ((this.akD == null) || (this.akD.size() == 0)) {
        return akC;
      }
      return this.akE;
    }
    return akC;
  }
  
  public final boolean ka()
  {
    return ((this.wy & 0x10) == 0) && (!t.Q(this.aku));
  }
  
  final boolean kb()
  {
    return (this.wy & 0x2) != 0;
  }
  
  final void l(int paramInt, boolean paramBoolean)
  {
    if (this.akw == -1) {
      this.akw = this.mPosition;
    }
    if (this.akz == -1) {
      this.akz = this.mPosition;
    }
    if (paramBoolean) {
      this.akz += paramInt;
    }
    this.mPosition += paramInt;
    if (this.aku.getLayoutParams() != null) {
      ((RecyclerView.LayoutParams)this.aku.getLayoutParams()).ajz = true;
    }
  }
  
  final void resetInternal()
  {
    this.wy = 0;
    this.mPosition = -1;
    this.akw = -1;
    this.akx = -1L;
    this.akz = -1;
    this.akF = 0;
    this.akA = null;
    this.akB = null;
    jY();
    this.akI = 0;
    this.akJ = -1;
    RecyclerView.h(this);
  }
  
  final void setFlags(int paramInt1, int paramInt2)
  {
    this.wy = (this.wy & (paramInt2 ^ 0xFFFFFFFF) | paramInt1 & paramInt2);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder1 = new StringBuilder("ViewHolder{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.akx + ", oldPos=" + this.akw + ", pLpos:" + this.akz);
    String str;
    if (jP())
    {
      StringBuilder localStringBuilder2 = localStringBuilder1.append(" scrap ");
      if (this.akH)
      {
        str = "[changeScrap]";
        localStringBuilder2.append(str);
      }
    }
    else
    {
      if (jU()) {
        localStringBuilder1.append(" invalid");
      }
      if (!isBound()) {
        localStringBuilder1.append(" unbound");
      }
      if (jV()) {
        localStringBuilder1.append(" update");
      }
      if (isRemoved()) {
        localStringBuilder1.append(" removed");
      }
      if (jL()) {
        localStringBuilder1.append(" ignored");
      }
      if (jW()) {
        localStringBuilder1.append(" tmpDetached");
      }
      if (!ka()) {
        localStringBuilder1.append(" not recyclable(" + this.akF + ")");
      }
      if (((this.wy & 0x200) == 0) && (!jU())) {
        break label309;
      }
    }
    label309:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        localStringBuilder1.append(" undefined adapter position");
      }
      if (this.aku.getParent() == null) {
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
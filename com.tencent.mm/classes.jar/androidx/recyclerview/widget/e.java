package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

class e
{
  final a bUA;
  final List<View> bUB;
  final b bUz;
  
  e(b paramb)
  {
    AppMethodBeat.i(194717);
    this.bUz = paramb;
    this.bUA = new a();
    this.bUB = new ArrayList();
    AppMethodBeat.o(194717);
  }
  
  private int fC(int paramInt)
  {
    AppMethodBeat.i(194731);
    if (paramInt < 0)
    {
      AppMethodBeat.o(194731);
      return -1;
    }
    int j = this.bUz.getChildCount();
    int i = paramInt;
    while (i < j)
    {
      int k = paramInt - (i - this.bUA.fE(i));
      if (k == 0)
      {
        while (this.bUA.cr(i)) {
          i += 1;
        }
        AppMethodBeat.o(194731);
        return i;
      }
      i += k;
    }
    AppMethodBeat.o(194731);
    return -1;
  }
  
  final int IU()
  {
    AppMethodBeat.i(194794);
    int i = this.bUz.getChildCount();
    AppMethodBeat.o(194794);
    return i;
  }
  
  final void a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    AppMethodBeat.i(194779);
    if (paramInt < 0) {}
    for (paramInt = this.bUz.getChildCount();; paramInt = fC(paramInt))
    {
      this.bUA.v(paramInt, paramBoolean);
      if (paramBoolean) {
        bf(paramView);
      }
      this.bUz.attachViewToParent(paramView, paramInt, paramLayoutParams);
      AppMethodBeat.o(194779);
      return;
    }
  }
  
  final void bf(View paramView)
  {
    AppMethodBeat.i(194739);
    this.bUB.add(paramView);
    this.bUz.bk(paramView);
    AppMethodBeat.o(194739);
  }
  
  final boolean bg(View paramView)
  {
    AppMethodBeat.i(194749);
    if (this.bUB.remove(paramView))
    {
      this.bUz.bl(paramView);
      AppMethodBeat.o(194749);
      return true;
    }
    AppMethodBeat.o(194749);
    return false;
  }
  
  final int bh(View paramView)
  {
    AppMethodBeat.i(194821);
    int i = this.bUz.bh(paramView);
    if (i == -1)
    {
      AppMethodBeat.o(194821);
      return -1;
    }
    if (this.bUA.cr(i))
    {
      AppMethodBeat.o(194821);
      return -1;
    }
    int j = this.bUA.fE(i);
    AppMethodBeat.o(194821);
    return i - j;
  }
  
  final boolean bi(View paramView)
  {
    AppMethodBeat.i(194831);
    boolean bool = this.bUB.contains(paramView);
    AppMethodBeat.o(194831);
    return bool;
  }
  
  final void c(View paramView, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(194759);
    if (paramInt < 0) {}
    for (paramInt = this.bUz.getChildCount();; paramInt = fC(paramInt))
    {
      this.bUA.v(paramInt, paramBoolean);
      if (paramBoolean) {
        bf(paramView);
      }
      this.bUz.addView(paramView, paramInt);
      AppMethodBeat.o(194759);
      return;
    }
  }
  
  final void detachViewFromParent(int paramInt)
  {
    AppMethodBeat.i(194811);
    paramInt = fC(paramInt);
    this.bUA.remove(paramInt);
    this.bUz.detachViewFromParent(paramInt);
    AppMethodBeat.o(194811);
  }
  
  final View fD(int paramInt)
  {
    AppMethodBeat.i(194802);
    View localView = this.bUz.getChildAt(paramInt);
    AppMethodBeat.o(194802);
    return localView;
  }
  
  final View getChildAt(int paramInt)
  {
    AppMethodBeat.i(194770);
    paramInt = fC(paramInt);
    View localView = this.bUz.getChildAt(paramInt);
    AppMethodBeat.o(194770);
    return localView;
  }
  
  final int getChildCount()
  {
    AppMethodBeat.i(194785);
    int i = this.bUz.getChildCount();
    int j = this.bUB.size();
    AppMethodBeat.o(194785);
    return i - j;
  }
  
  final void removeViewAt(int paramInt)
  {
    AppMethodBeat.i(194765);
    paramInt = fC(paramInt);
    View localView = this.bUz.getChildAt(paramInt);
    if (localView == null)
    {
      AppMethodBeat.o(194765);
      return;
    }
    if (this.bUA.remove(paramInt)) {
      bg(localView);
    }
    this.bUz.removeViewAt(paramInt);
    AppMethodBeat.o(194765);
  }
  
  public String toString()
  {
    AppMethodBeat.i(194838);
    String str = this.bUA.toString() + ", hidden list:" + this.bUB.size();
    AppMethodBeat.o(194838);
    return str;
  }
  
  static final class a
  {
    long bUC = 0L;
    a bUD;
    
    private void IV()
    {
      AppMethodBeat.i(194935);
      if (this.bUD == null) {
        this.bUD = new a();
      }
      AppMethodBeat.o(194935);
    }
    
    final void clear(int paramInt)
    {
      a locala = this;
      while (paramInt >= 64)
      {
        if (locala.bUD == null) {
          return;
        }
        locala = locala.bUD;
        paramInt -= 64;
      }
      locala.bUC &= (1L << paramInt ^ 0xFFFFFFFF);
    }
    
    final boolean cr(int paramInt)
    {
      AppMethodBeat.i(194958);
      a locala = this;
      while (paramInt >= 64)
      {
        locala.IV();
        locala = locala.bUD;
        paramInt -= 64;
      }
      if ((locala.bUC & 1L << paramInt) != 0L)
      {
        AppMethodBeat.o(194958);
        return true;
      }
      AppMethodBeat.o(194958);
      return false;
    }
    
    final int fE(int paramInt)
    {
      AppMethodBeat.i(194982);
      if (this.bUD == null)
      {
        if (paramInt >= 64)
        {
          paramInt = Long.bitCount(this.bUC);
          AppMethodBeat.o(194982);
          return paramInt;
        }
        paramInt = Long.bitCount(this.bUC & (1L << paramInt) - 1L);
        AppMethodBeat.o(194982);
        return paramInt;
      }
      if (paramInt < 64)
      {
        paramInt = Long.bitCount(this.bUC & (1L << paramInt) - 1L);
        AppMethodBeat.o(194982);
        return paramInt;
      }
      paramInt = this.bUD.fE(paramInt - 64);
      int i = Long.bitCount(this.bUC);
      AppMethodBeat.o(194982);
      return paramInt + i;
    }
    
    final boolean remove(int paramInt)
    {
      AppMethodBeat.i(194974);
      a locala = this;
      while (paramInt >= 64)
      {
        locala.IV();
        locala = locala.bUD;
        paramInt -= 64;
      }
      long l1 = 1L << paramInt;
      if ((locala.bUC & l1) != 0L) {}
      for (boolean bool = true;; bool = false)
      {
        locala.bUC &= (l1 ^ 0xFFFFFFFF);
        l1 -= 1L;
        long l2 = locala.bUC;
        locala.bUC = (Long.rotateRight((l1 ^ 0xFFFFFFFF) & locala.bUC, 1) | l2 & l1);
        if (locala.bUD != null)
        {
          if (locala.bUD.cr(0)) {
            locala.set(63);
          }
          locala.bUD.remove(0);
        }
        AppMethodBeat.o(194974);
        return bool;
      }
    }
    
    final void set(int paramInt)
    {
      AppMethodBeat.i(194945);
      a locala = this;
      while (paramInt >= 64)
      {
        locala.IV();
        locala = locala.bUD;
        paramInt -= 64;
      }
      locala.bUC |= 1L << paramInt;
      AppMethodBeat.o(194945);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(194989);
      if (this.bUD == null)
      {
        str = Long.toBinaryString(this.bUC);
        AppMethodBeat.o(194989);
        return str;
      }
      String str = this.bUD.toString() + "xx" + Long.toBinaryString(this.bUC);
      AppMethodBeat.o(194989);
      return str;
    }
    
    final void v(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(194966);
      boolean bool = paramBoolean;
      a locala = this;
      while (paramInt >= 64)
      {
        locala.IV();
        locala = locala.bUD;
        paramInt -= 64;
      }
      if ((locala.bUC & 0x0) != 0L)
      {
        paramBoolean = true;
        label52:
        long l1 = (1L << paramInt) - 1L;
        long l2 = locala.bUC;
        locala.bUC = (((l1 ^ 0xFFFFFFFF) & locala.bUC) << 1 | l2 & l1);
        if (!bool) {
          break label137;
        }
        locala.set(paramInt);
      }
      for (;;)
      {
        if ((!paramBoolean) && (locala.bUD == null)) {
          break label146;
        }
        locala.IV();
        locala = locala.bUD;
        paramInt = 0;
        bool = paramBoolean;
        break;
        paramBoolean = false;
        break label52;
        label137:
        locala.clear(paramInt);
      }
      label146:
      AppMethodBeat.o(194966);
    }
  }
  
  static abstract interface b
  {
    public abstract void addView(View paramView, int paramInt);
    
    public abstract void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams);
    
    public abstract int bh(View paramView);
    
    public abstract RecyclerView.v bj(View paramView);
    
    public abstract void bk(View paramView);
    
    public abstract void bl(View paramView);
    
    public abstract void detachViewFromParent(int paramInt);
    
    public abstract View getChildAt(int paramInt);
    
    public abstract int getChildCount();
    
    public abstract void removeAllViews();
    
    public abstract void removeViewAt(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.recyclerview.widget.e
 * JD-Core Version:    0.7.0.1
 */
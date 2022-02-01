package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

class f
{
  final b afT;
  final a afU;
  final List<View> afV;
  
  f(b paramb)
  {
    AppMethodBeat.i(260825);
    this.afT = paramb;
    this.afU = new a();
    this.afV = new ArrayList();
    AppMethodBeat.o(260825);
  }
  
  private int cp(int paramInt)
  {
    AppMethodBeat.i(260832);
    if (paramInt < 0)
    {
      AppMethodBeat.o(260832);
      return -1;
    }
    int j = this.afT.getChildCount();
    int i = paramInt;
    while (i < j)
    {
      int k = paramInt - (i - this.afU.cs(i));
      if (k == 0)
      {
        while (this.afU.cr(i)) {
          i += 1;
        }
        AppMethodBeat.o(260832);
        return i;
      }
      i += k;
    }
    AppMethodBeat.o(260832);
    return -1;
  }
  
  final void a(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams, boolean paramBoolean)
  {
    AppMethodBeat.i(260839);
    if (paramInt < 0) {}
    for (paramInt = this.afT.getChildCount();; paramInt = cp(paramInt))
    {
      this.afU.h(paramInt, paramBoolean);
      if (paramBoolean) {
        aM(paramView);
      }
      this.afT.attachViewToParent(paramView, paramInt, paramLayoutParams);
      AppMethodBeat.o(260839);
      return;
    }
  }
  
  final void aM(View paramView)
  {
    AppMethodBeat.i(260826);
    this.afV.add(paramView);
    this.afT.aR(paramView);
    AppMethodBeat.o(260826);
  }
  
  final boolean aN(View paramView)
  {
    AppMethodBeat.i(260827);
    if (this.afV.remove(paramView))
    {
      this.afT.aS(paramView);
      AppMethodBeat.o(260827);
      return true;
    }
    AppMethodBeat.o(260827);
    return false;
  }
  
  final int aO(View paramView)
  {
    AppMethodBeat.i(260849);
    int i = this.afT.aO(paramView);
    if (i == -1)
    {
      AppMethodBeat.o(260849);
      return -1;
    }
    if (this.afU.cr(i))
    {
      AppMethodBeat.o(260849);
      return -1;
    }
    int j = this.afU.cs(i);
    AppMethodBeat.o(260849);
    return i - j;
  }
  
  final boolean aP(View paramView)
  {
    AppMethodBeat.i(260852);
    boolean bool = this.afV.contains(paramView);
    AppMethodBeat.o(260852);
    return bool;
  }
  
  final void b(View paramView, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(260830);
    if (paramInt < 0) {}
    for (paramInt = this.afT.getChildCount();; paramInt = cp(paramInt))
    {
      this.afU.h(paramInt, paramBoolean);
      if (paramBoolean) {
        aM(paramView);
      }
      this.afT.addView(paramView, paramInt);
      AppMethodBeat.o(260830);
      return;
    }
  }
  
  final View cq(int paramInt)
  {
    AppMethodBeat.i(260844);
    View localView = this.afT.getChildAt(paramInt);
    AppMethodBeat.o(260844);
    return localView;
  }
  
  final void detachViewFromParent(int paramInt)
  {
    AppMethodBeat.i(260847);
    paramInt = cp(paramInt);
    this.afU.remove(paramInt);
    this.afT.detachViewFromParent(paramInt);
    AppMethodBeat.o(260847);
  }
  
  final View getChildAt(int paramInt)
  {
    AppMethodBeat.i(260836);
    paramInt = cp(paramInt);
    View localView = this.afT.getChildAt(paramInt);
    AppMethodBeat.o(260836);
    return localView;
  }
  
  final int getChildCount()
  {
    AppMethodBeat.i(260841);
    int i = this.afT.getChildCount();
    int j = this.afV.size();
    AppMethodBeat.o(260841);
    return i - j;
  }
  
  final int kj()
  {
    AppMethodBeat.i(260843);
    int i = this.afT.getChildCount();
    AppMethodBeat.o(260843);
    return i;
  }
  
  final void removeViewAt(int paramInt)
  {
    AppMethodBeat.i(260834);
    paramInt = cp(paramInt);
    View localView = this.afT.getChildAt(paramInt);
    if (localView == null)
    {
      AppMethodBeat.o(260834);
      return;
    }
    if (this.afU.remove(paramInt)) {
      aN(localView);
    }
    this.afT.removeViewAt(paramInt);
    AppMethodBeat.o(260834);
  }
  
  public String toString()
  {
    AppMethodBeat.i(260856);
    String str = this.afU.toString() + ", hidden list:" + this.afV.size();
    AppMethodBeat.o(260856);
    return str;
  }
  
  static final class a
  {
    long afW = 0L;
    a afX;
    
    private void kk()
    {
      AppMethodBeat.i(260801);
      if (this.afX == null) {
        this.afX = new a();
      }
      AppMethodBeat.o(260801);
    }
    
    final void clear(int paramInt)
    {
      a locala = this;
      while (paramInt >= 64)
      {
        if (locala.afX == null) {
          return;
        }
        locala = locala.afX;
        paramInt -= 64;
      }
      locala.afW &= (1L << paramInt ^ 0xFFFFFFFF);
    }
    
    final boolean cr(int paramInt)
    {
      AppMethodBeat.i(260806);
      a locala = this;
      while (paramInt >= 64)
      {
        locala.kk();
        locala = locala.afX;
        paramInt -= 64;
      }
      if ((locala.afW & 1L << paramInt) != 0L)
      {
        AppMethodBeat.o(260806);
        return true;
      }
      AppMethodBeat.o(260806);
      return false;
    }
    
    final int cs(int paramInt)
    {
      AppMethodBeat.i(260812);
      if (this.afX == null)
      {
        if (paramInt >= 64)
        {
          paramInt = Long.bitCount(this.afW);
          AppMethodBeat.o(260812);
          return paramInt;
        }
        paramInt = Long.bitCount(this.afW & (1L << paramInt) - 1L);
        AppMethodBeat.o(260812);
        return paramInt;
      }
      if (paramInt < 64)
      {
        paramInt = Long.bitCount(this.afW & (1L << paramInt) - 1L);
        AppMethodBeat.o(260812);
        return paramInt;
      }
      paramInt = this.afX.cs(paramInt - 64);
      int i = Long.bitCount(this.afW);
      AppMethodBeat.o(260812);
      return paramInt + i;
    }
    
    final void h(int paramInt, boolean paramBoolean)
    {
      AppMethodBeat.i(260808);
      boolean bool = paramBoolean;
      a locala = this;
      while (paramInt >= 64)
      {
        locala.kk();
        locala = locala.afX;
        paramInt -= 64;
      }
      if ((locala.afW & 0x0) != 0L)
      {
        paramBoolean = true;
        label52:
        long l1 = (1L << paramInt) - 1L;
        long l2 = locala.afW;
        locala.afW = (((l1 ^ 0xFFFFFFFF) & locala.afW) << 1 | l2 & l1);
        if (!bool) {
          break label137;
        }
        locala.set(paramInt);
      }
      for (;;)
      {
        if ((!paramBoolean) && (locala.afX == null)) {
          break label146;
        }
        locala.kk();
        locala = locala.afX;
        paramInt = 0;
        bool = paramBoolean;
        break;
        paramBoolean = false;
        break label52;
        label137:
        locala.clear(paramInt);
      }
      label146:
      AppMethodBeat.o(260808);
    }
    
    final boolean remove(int paramInt)
    {
      AppMethodBeat.i(260810);
      a locala = this;
      while (paramInt >= 64)
      {
        locala.kk();
        locala = locala.afX;
        paramInt -= 64;
      }
      long l1 = 1L << paramInt;
      if ((locala.afW & l1) != 0L) {}
      for (boolean bool = true;; bool = false)
      {
        locala.afW &= (l1 ^ 0xFFFFFFFF);
        l1 -= 1L;
        long l2 = locala.afW;
        locala.afW = (Long.rotateRight((l1 ^ 0xFFFFFFFF) & locala.afW, 1) | l2 & l1);
        if (locala.afX != null)
        {
          if (locala.afX.cr(0)) {
            locala.set(63);
          }
          locala.afX.remove(0);
        }
        AppMethodBeat.o(260810);
        return bool;
      }
    }
    
    final void set(int paramInt)
    {
      AppMethodBeat.i(260799);
      a locala = this;
      while (paramInt >= 64)
      {
        locala.kk();
        locala = locala.afX;
        paramInt -= 64;
      }
      locala.afW |= 1L << paramInt;
      AppMethodBeat.o(260799);
    }
    
    public final String toString()
    {
      AppMethodBeat.i(260815);
      if (this.afX == null)
      {
        str = Long.toBinaryString(this.afW);
        AppMethodBeat.o(260815);
        return str;
      }
      String str = this.afX.toString() + "xx" + Long.toBinaryString(this.afW);
      AppMethodBeat.o(260815);
      return str;
    }
  }
  
  static abstract interface b
  {
    public abstract int aO(View paramView);
    
    public abstract RecyclerView.v aQ(View paramView);
    
    public abstract void aR(View paramView);
    
    public abstract void aS(View paramView);
    
    public abstract void addView(View paramView, int paramInt);
    
    public abstract void attachViewToParent(View paramView, int paramInt, ViewGroup.LayoutParams paramLayoutParams);
    
    public abstract void detachViewFromParent(int paramInt);
    
    public abstract View getChildAt(int paramInt);
    
    public abstract int getChildCount();
    
    public abstract void removeAllViews();
    
    public abstract void removeViewAt(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.recyclerview.widget.f
 * JD-Core Version:    0.7.0.1
 */
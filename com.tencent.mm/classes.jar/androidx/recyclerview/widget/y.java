package androidx.recyclerview.widget;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

class y
{
  final b cbQ;
  a cbR;
  
  y(b paramb)
  {
    AppMethodBeat.i(194898);
    this.cbQ = paramb;
    this.cbR = new a();
    AppMethodBeat.o(194898);
  }
  
  final boolean bO(View paramView)
  {
    AppMethodBeat.i(194922);
    this.cbR.setBounds(this.cbQ.Ky(), this.cbQ.Kz(), this.cbQ.bF(paramView), this.cbQ.bG(paramView));
    this.cbR.cbS = 0;
    this.cbR.gh(24579);
    boolean bool = this.cbR.Lr();
    AppMethodBeat.o(194922);
    return bool;
  }
  
  final View s(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(194911);
    int j = this.cbQ.Ky();
    int k = this.cbQ.Kz();
    if (paramInt2 > paramInt1) {}
    Object localObject;
    View localView;
    for (int i = 1;; i = -1)
    {
      localObject = null;
      if (paramInt1 == paramInt2) {
        break label184;
      }
      localView = this.cbQ.getChildAt(paramInt1);
      int m = this.cbQ.bF(localView);
      int n = this.cbQ.bG(localView);
      this.cbR.setBounds(j, k, m, n);
      if (paramInt3 == 0) {
        break;
      }
      this.cbR.cbS = 0;
      this.cbR.gh(paramInt3);
      if (!this.cbR.Lr()) {
        break;
      }
      AppMethodBeat.o(194911);
      return localView;
    }
    if (paramInt4 != 0)
    {
      this.cbR.cbS = 0;
      this.cbR.gh(paramInt4);
      if (this.cbR.Lr()) {
        localObject = localView;
      }
    }
    for (;;)
    {
      paramInt1 += i;
      break;
      label184:
      AppMethodBeat.o(194911);
      return localObject;
    }
  }
  
  static final class a
  {
    int cbS = 0;
    int cbT;
    int cbU;
    int cbV;
    int cbW;
    
    private static int compare(int paramInt1, int paramInt2)
    {
      if (paramInt1 > paramInt2) {
        return 1;
      }
      if (paramInt1 == paramInt2) {
        return 2;
      }
      return 4;
    }
    
    final boolean Lr()
    {
      AppMethodBeat.i(195241);
      if (((this.cbS & 0x7) != 0) && ((this.cbS & compare(this.cbV, this.cbT) << 0) == 0))
      {
        AppMethodBeat.o(195241);
        return false;
      }
      if (((this.cbS & 0x70) != 0) && ((this.cbS & compare(this.cbV, this.cbU) << 4) == 0))
      {
        AppMethodBeat.o(195241);
        return false;
      }
      if (((this.cbS & 0x700) != 0) && ((this.cbS & compare(this.cbW, this.cbT) << 8) == 0))
      {
        AppMethodBeat.o(195241);
        return false;
      }
      if (((this.cbS & 0x7000) != 0) && ((this.cbS & compare(this.cbW, this.cbU) << 12) == 0))
      {
        AppMethodBeat.o(195241);
        return false;
      }
      AppMethodBeat.o(195241);
      return true;
    }
    
    final void gh(int paramInt)
    {
      this.cbS |= paramInt;
    }
    
    final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.cbT = paramInt1;
      this.cbU = paramInt2;
      this.cbV = paramInt3;
      this.cbW = paramInt4;
    }
  }
  
  static abstract interface b
  {
    public abstract int Ky();
    
    public abstract int Kz();
    
    public abstract int bF(View paramView);
    
    public abstract int bG(View paramView);
    
    public abstract View getChildAt(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     androidx.recyclerview.widget.y
 * JD-Core Version:    0.7.0.1
 */
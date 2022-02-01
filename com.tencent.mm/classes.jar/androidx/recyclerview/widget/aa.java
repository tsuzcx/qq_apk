package androidx.recyclerview.widget;

import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;

class aa
{
  final b anr;
  a ans;
  
  aa(b paramb)
  {
    AppMethodBeat.i(263005);
    this.anr = paramb;
    this.ans = new a();
    AppMethodBeat.o(263005);
  }
  
  final boolean bv(View paramView)
  {
    AppMethodBeat.i(263007);
    this.ans.setBounds(this.anr.lP(), this.anr.lQ(), this.anr.bm(paramView), this.anr.bn(paramView));
    this.ans.ant = 0;
    this.ans.cY(24579);
    boolean bool = this.ans.mP();
    AppMethodBeat.o(263007);
    return bool;
  }
  
  final View j(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(263006);
    int j = this.anr.lP();
    int k = this.anr.lQ();
    if (paramInt2 > paramInt1) {}
    Object localObject;
    View localView;
    for (int i = 1;; i = -1)
    {
      localObject = null;
      if (paramInt1 == paramInt2) {
        break label184;
      }
      localView = this.anr.getChildAt(paramInt1);
      int m = this.anr.bm(localView);
      int n = this.anr.bn(localView);
      this.ans.setBounds(j, k, m, n);
      if (paramInt3 == 0) {
        break;
      }
      this.ans.ant = 0;
      this.ans.cY(paramInt3);
      if (!this.ans.mP()) {
        break;
      }
      AppMethodBeat.o(263006);
      return localView;
    }
    if (paramInt4 != 0)
    {
      this.ans.ant = 0;
      this.ans.cY(paramInt4);
      if (this.ans.mP()) {
        localObject = localView;
      }
    }
    for (;;)
    {
      paramInt1 += i;
      break;
      label184:
      AppMethodBeat.o(263006);
      return localObject;
    }
  }
  
  static final class a
  {
    int ant = 0;
    int anu;
    int anv;
    int anw;
    int anx;
    
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
    
    final void cY(int paramInt)
    {
      this.ant |= paramInt;
    }
    
    final boolean mP()
    {
      AppMethodBeat.i(263004);
      if (((this.ant & 0x7) != 0) && ((this.ant & compare(this.anw, this.anu) << 0) == 0))
      {
        AppMethodBeat.o(263004);
        return false;
      }
      if (((this.ant & 0x70) != 0) && ((this.ant & compare(this.anw, this.anv) << 4) == 0))
      {
        AppMethodBeat.o(263004);
        return false;
      }
      if (((this.ant & 0x700) != 0) && ((this.ant & compare(this.anx, this.anu) << 8) == 0))
      {
        AppMethodBeat.o(263004);
        return false;
      }
      if (((this.ant & 0x7000) != 0) && ((this.ant & compare(this.anx, this.anv) << 12) == 0))
      {
        AppMethodBeat.o(263004);
        return false;
      }
      AppMethodBeat.o(263004);
      return true;
    }
    
    final void setBounds(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      this.anu = paramInt1;
      this.anv = paramInt2;
      this.anw = paramInt3;
      this.anx = paramInt4;
    }
  }
  
  static abstract interface b
  {
    public abstract int bm(View paramView);
    
    public abstract int bn(View paramView);
    
    public abstract View getChildAt(int paramInt);
    
    public abstract int lP();
    
    public abstract int lQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.recyclerview.widget.aa
 * JD-Core Version:    0.7.0.1
 */
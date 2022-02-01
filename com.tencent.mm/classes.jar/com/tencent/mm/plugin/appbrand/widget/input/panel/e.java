package com.tencent.mm.plugin.appbrand.widget.input.panel;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.ac;

public abstract interface e
  extends ac
{
  public abstract boolean bEA();
  
  public abstract void bFc();
  
  public abstract void bFd();
  
  public abstract View getPanelView();
  
  public abstract void onDestroy();
  
  public abstract void setOnTextOperationListener(f paramf);
  
  public abstract boolean ws(int paramInt);
  
  public static final class a
    implements e
  {
    int lYB;
    boolean mInLayout;
    private View mView;
    
    public a(Context paramContext)
    {
      AppMethodBeat.i(136691);
      this.mView = new View(paramContext)
      {
        protected final void onLayout(boolean paramAnonymousBoolean, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
        {
          AppMethodBeat.i(136688);
          e.a.this.mInLayout = true;
          super.onLayout(paramAnonymousBoolean, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
          e.a.this.mInLayout = false;
          AppMethodBeat.o(136688);
        }
        
        protected final void onMeasure(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(136689);
          if (e.a.this.lYB > 0) {
            paramAnonymousInt2 = View.MeasureSpec.makeMeasureSpec(e.a.this.lYB, 1073741824);
          }
          super.onMeasure(paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(136689);
        }
      };
      AppMethodBeat.o(136691);
    }
    
    public final boolean bEA()
    {
      AppMethodBeat.i(136694);
      if (Build.VERSION.SDK_INT >= 18)
      {
        bool = this.mView.isInLayout();
        AppMethodBeat.o(136694);
        return bool;
      }
      boolean bool = this.mInLayout;
      AppMethodBeat.o(136694);
      return bool;
    }
    
    public final boolean bEw()
    {
      return true;
    }
    
    public final void bFc()
    {
      AppMethodBeat.i(136692);
      this.mView.setVisibility(0);
      AppMethodBeat.o(136692);
    }
    
    public final void bFd()
    {
      AppMethodBeat.i(136693);
      this.mView.setVisibility(4);
      AppMethodBeat.o(136693);
    }
    
    public final View getPanelView()
    {
      return this.mView;
    }
    
    public final void onDestroy() {}
    
    public final void setOnTextOperationListener(f paramf) {}
    
    public final boolean ws(int paramInt)
    {
      if ((paramInt > 0) && (this.lYB != paramInt))
      {
        this.lYB = paramInt;
        return true;
      }
      return false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.panel.e
 * JD-Core Version:    0.7.0.1
 */
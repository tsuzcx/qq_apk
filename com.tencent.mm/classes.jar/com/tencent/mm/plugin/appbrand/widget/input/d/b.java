package com.tencent.mm.plugin.appbrand.widget.input.d;

import android.content.Context;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.widget.input.ag;

public abstract interface b
  extends ag
{
  public abstract boolean DW(int paramInt);
  
  public abstract void ce(boolean paramBoolean);
  
  public abstract boolean cpA();
  
  public abstract boolean cpB();
  
  public abstract void cpz();
  
  public abstract View getPanelView();
  
  public abstract void ku(boolean paramBoolean);
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void setOnEmoticonOperationListener(d paramd);
  
  public abstract void setOnTextOperationListener(e parame);
  
  public static final class a
    implements b
  {
    int cpO;
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
          b.a.this.mInLayout = true;
          super.onLayout(paramAnonymousBoolean, paramAnonymousInt1, paramAnonymousInt2, paramAnonymousInt3, paramAnonymousInt4);
          b.a.this.mInLayout = false;
          AppMethodBeat.o(136688);
        }
        
        protected final void onMeasure(int paramAnonymousInt1, int paramAnonymousInt2)
        {
          AppMethodBeat.i(136689);
          if (b.a.this.cpO > 0) {
            paramAnonymousInt2 = View.MeasureSpec.makeMeasureSpec(b.a.this.cpO, 1073741824);
          }
          super.onMeasure(paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(136689);
        }
      };
      AppMethodBeat.o(136691);
    }
    
    public final boolean DW(int paramInt)
    {
      if ((paramInt > 0) && (this.cpO != paramInt))
      {
        this.cpO = paramInt;
        return true;
      }
      return false;
    }
    
    public final void ce(boolean paramBoolean) {}
    
    public final boolean coN()
    {
      return true;
    }
    
    public final boolean cpA()
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
    
    public final boolean cpB()
    {
      return false;
    }
    
    public final void cpz()
    {
      AppMethodBeat.i(136692);
      this.mView.setVisibility(0);
      AppMethodBeat.o(136692);
    }
    
    public final View getPanelView()
    {
      return this.mView;
    }
    
    public final void ku(boolean paramBoolean)
    {
      AppMethodBeat.i(215183);
      this.mView.setVisibility(4);
      AppMethodBeat.o(215183);
    }
    
    public final void onDestroy() {}
    
    public final void onPause() {}
    
    public final void onResume() {}
    
    public final void setOnEmoticonOperationListener(d paramd) {}
    
    public final void setOnTextOperationListener(e parame) {}
  }
  
  public static abstract interface b
    extends com.tencent.luggage.a.b
  {
    public abstract b eD(Context paramContext);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.d.b
 * JD-Core Version:    0.7.0.1
 */
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
  public abstract boolean Ew(int paramInt);
  
  public abstract void cL(boolean paramBoolean);
  
  public abstract void cSc();
  
  public abstract boolean cSd();
  
  public abstract boolean cSe();
  
  public abstract View getPanelView();
  
  public abstract void lG(boolean paramBoolean);
  
  public abstract void onDestroy();
  
  public abstract void onPause();
  
  public abstract void onResume();
  
  public abstract void setOnEmoticonOperationListener(e parame);
  
  public abstract void setOnTextOperationListener(f paramf);
  
  public static final class a
    implements b
  {
    int ehF;
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
          if (b.a.this.ehF > 0) {
            paramAnonymousInt2 = View.MeasureSpec.makeMeasureSpec(b.a.this.ehF, 1073741824);
          }
          super.onMeasure(paramAnonymousInt1, paramAnonymousInt2);
          AppMethodBeat.o(136689);
        }
      };
      AppMethodBeat.o(136691);
    }
    
    public final boolean Ew(int paramInt)
    {
      if ((paramInt > 0) && (this.ehF != paramInt))
      {
        this.ehF = paramInt;
        return true;
      }
      return false;
    }
    
    public final void cL(boolean paramBoolean) {}
    
    public final boolean cRp()
    {
      return true;
    }
    
    public final void cSc()
    {
      AppMethodBeat.i(136692);
      this.mView.setVisibility(0);
      AppMethodBeat.o(136692);
    }
    
    public final boolean cSd()
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
    
    public final boolean cSe()
    {
      return false;
    }
    
    public final View getPanelView()
    {
      return this.mView;
    }
    
    public final void lG(boolean paramBoolean)
    {
      AppMethodBeat.i(324618);
      this.mView.setVisibility(4);
      AppMethodBeat.o(324618);
    }
    
    public final void onDestroy() {}
    
    public final void onPause() {}
    
    public final void onResume() {}
    
    public final void setOnEmoticonOperationListener(e parame) {}
    
    public final void setOnTextOperationListener(f paramf) {}
  }
  
  public static abstract interface b
    extends com.tencent.luggage.a.b
  {
    public abstract b F(Context paramContext, boolean paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.widget.input.d.b
 * JD-Core Version:    0.7.0.1
 */
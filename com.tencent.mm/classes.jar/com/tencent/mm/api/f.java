package com.tencent.mm.api;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class f
  extends FrameLayout
{
  aa hdL = new aa()
  {
    public final void a(i paramAnonymousi)
    {
      AppMethodBeat.i(149423);
      Log.i("MicroMsg.DrawingView", "Default [onSelectedFeature] features:%s", new Object[] { paramAnonymousi.name() });
      AppMethodBeat.o(149423);
    }
    
    public final void a(i paramAnonymousi, int paramAnonymousInt, Object paramAnonymousObject)
    {
      AppMethodBeat.i(169116);
      Log.i("MicroMsg.DrawingView", "Default [onSelectedDetailFeature] features:%s index:%s", new Object[] { paramAnonymousi.name(), Integer.valueOf(paramAnonymousInt) });
      AppMethodBeat.o(169116);
    }
    
    public final void dP(boolean paramAnonymousBoolean) {}
  };
  
  public f(Context paramContext)
  {
    super(paramContext);
  }
  
  public aa getSelectedFeatureListener()
  {
    return this.hdL;
  }
  
  public abstract void setActionBarCallback(k paramk);
  
  public abstract void setActionBarVisible(boolean paramBoolean);
  
  public abstract void setAutoShowFooterAndBar(boolean paramBoolean);
  
  public abstract void setFooterVisible(boolean paramBoolean);
  
  public void setSelectedFeatureListener(aa paramaa)
  {
    this.hdL = paramaa;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.api.f
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.api;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public abstract class e
  extends FrameLayout
{
  w cGw = new w()
  {
    public final void a(g paramAnonymousg)
    {
      AppMethodBeat.i(149423);
      ac.i("MicroMsg.DrawingView", "Default [onSelectedFeature] features:%s", new Object[] { paramAnonymousg.name() });
      AppMethodBeat.o(149423);
    }
    
    public final void a(g paramAnonymousg, int paramAnonymousInt, Object paramAnonymousObject)
    {
      AppMethodBeat.i(169116);
      ac.i("MicroMsg.DrawingView", "Default [onSelectedDetailFeature] features:%s index:%s", new Object[] { paramAnonymousg.name(), Integer.valueOf(paramAnonymousInt) });
      AppMethodBeat.o(169116);
    }
    
    public final void bW(boolean paramAnonymousBoolean) {}
  };
  
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  public w getSelectedFeatureListener()
  {
    return this.cGw;
  }
  
  public abstract void setActionBarCallback(i parami);
  
  public abstract void setActionBarVisible(boolean paramBoolean);
  
  public abstract void setAutoShowFooterAndBar(boolean paramBoolean);
  
  public abstract void setFooterVisible(boolean paramBoolean);
  
  public void setSelectedFeatureListener(w paramw)
  {
    this.cGw = paramw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.api.e
 * JD-Core Version:    0.7.0.1
 */
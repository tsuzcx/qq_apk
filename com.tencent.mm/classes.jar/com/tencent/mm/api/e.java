package com.tencent.mm.api;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public abstract class e
  extends FrameLayout
{
  w cRA = new w()
  {
    public final void a(g paramAnonymousg)
    {
      AppMethodBeat.i(149423);
      ad.i("MicroMsg.DrawingView", "Default [onSelectedFeature] features:%s", new Object[] { paramAnonymousg.name() });
      AppMethodBeat.o(149423);
    }
    
    public final void a(g paramAnonymousg, int paramAnonymousInt, Object paramAnonymousObject)
    {
      AppMethodBeat.i(169116);
      ad.i("MicroMsg.DrawingView", "Default [onSelectedDetailFeature] features:%s index:%s", new Object[] { paramAnonymousg.name(), Integer.valueOf(paramAnonymousInt) });
      AppMethodBeat.o(169116);
    }
    
    public final void bY(boolean paramAnonymousBoolean) {}
  };
  
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  public w getSelectedFeatureListener()
  {
    return this.cRA;
  }
  
  public abstract void setActionBarCallback(i parami);
  
  public abstract void setActionBarVisible(boolean paramBoolean);
  
  public abstract void setAutoShowFooterAndBar(boolean paramBoolean);
  
  public abstract void setFooterVisible(boolean paramBoolean);
  
  public void setSelectedFeatureListener(w paramw)
  {
    this.cRA = paramw;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.api.e
 * JD-Core Version:    0.7.0.1
 */
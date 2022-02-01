package com.tencent.mm.api;

import android.content.Context;
import android.widget.FrameLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public abstract class e
  extends FrameLayout
{
  z fak = new z()
  {
    public final void a(h paramAnonymoush)
    {
      AppMethodBeat.i(149423);
      Log.i("MicroMsg.DrawingView", "Default [onSelectedFeature] features:%s", new Object[] { paramAnonymoush.name() });
      AppMethodBeat.o(149423);
    }
    
    public final void a(h paramAnonymoush, int paramAnonymousInt, Object paramAnonymousObject)
    {
      AppMethodBeat.i(169116);
      Log.i("MicroMsg.DrawingView", "Default [onSelectedDetailFeature] features:%s index:%s", new Object[] { paramAnonymoush.name(), Integer.valueOf(paramAnonymousInt) });
      AppMethodBeat.o(169116);
    }
    
    public final void dd(boolean paramAnonymousBoolean) {}
  };
  
  public e(Context paramContext)
  {
    super(paramContext);
  }
  
  public z getSelectedFeatureListener()
  {
    return this.fak;
  }
  
  public abstract void setActionBarCallback(j paramj);
  
  public abstract void setActionBarVisible(boolean paramBoolean);
  
  public abstract void setAutoShowFooterAndBar(boolean paramBoolean);
  
  public abstract void setFooterVisible(boolean paramBoolean);
  
  public void setSelectedFeatureListener(z paramz)
  {
    this.fak = paramz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.api.e
 * JD-Core Version:    0.7.0.1
 */
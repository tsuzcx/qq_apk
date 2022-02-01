package com.tencent.mm.plugin.appbrand.ab;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.page.ad.a;
import com.tencent.mm.plugin.appbrand.page.af;
import com.tencent.mm.plugin.appbrand.page.ah;
import com.tencent.mm.plugin.appbrand.page.cb;
import com.tencent.skyline.IRouteDoneCallback;
import com.tencent.skyline.SkylineLogic;
import java.util.concurrent.atomic.AtomicBoolean;
import junit.framework.Assert;
import org.json.JSONObject;

public abstract class a
  extends ah
{
  public a(Class<? extends af> paramClass)
  {
    super(paramClass);
  }
  
  private IRouteDoneCallback a(IRouteDoneCallback paramIRouteDoneCallback)
  {
    return new a(paramIRouteDoneCallback);
  }
  
  public final boolean a(String paramString, cb paramcb, JSONObject paramJSONObject, boolean paramBoolean)
  {
    Assert.assertTrue(cEI());
    super.a(paramString, paramcb, paramJSONObject, paramBoolean);
    switch (1.enn[paramcb.ordinal()])
    {
    default: 
      throw new UnsupportedOperationException();
    case 1: 
      SkylineLogic.INSTANCE.appLaunch(getComponentId(), cEH());
    }
    for (;;)
    {
      return true;
      SkylineLogic.INSTANCE.switchTab(getComponentId(), cEH());
      continue;
      SkylineLogic.INSTANCE.navigateTo(getComponentId(), cEH(), a(new a..ExternalSyntheticLambda2(this, paramBoolean, paramcb, paramJSONObject)));
      continue;
      SkylineLogic.INSTANCE.redirectTo(getComponentId(), cEH(), a(new a..ExternalSyntheticLambda1(this, paramBoolean, paramcb, paramJSONObject)));
      continue;
      SkylineLogic.INSTANCE.reLaunch(getComponentId(), cEH(), a(new a..ExternalSyntheticLambda3(this, paramBoolean, paramcb, paramJSONObject)));
    }
  }
  
  public final int ag(int paramInt, boolean paramBoolean)
  {
    paramInt = super.ag(paramInt, paramBoolean);
    SkylineLogic.INSTANCE.navigateBack(getComponentId(), cEH(), paramInt, paramBoolean, a(new a..ExternalSyntheticLambda0(this, paramBoolean)));
    return paramInt;
  }
  
  final class a
    implements ad.a, IRouteDoneCallback
  {
    private final IRouteDoneCallback tVk;
    private final AtomicBoolean tVl;
    
    public a(IRouteDoneCallback paramIRouteDoneCallback)
    {
      AppMethodBeat.i(316905);
      a.a(a.this, this);
      this.tVl = new AtomicBoolean(false);
      this.tVk = paramIRouteDoneCallback;
      AppMethodBeat.o(316905);
    }
    
    public final void ko(boolean paramBoolean) {}
    
    public final void onDone()
    {
      AppMethodBeat.i(316923);
      if (!this.tVl.getAndSet(true)) {
        this.tVk.onDone();
      }
      AppMethodBeat.o(316923);
    }
    
    public final void run()
    {
      AppMethodBeat.i(316930);
      onDone();
      AppMethodBeat.o(316930);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.ab.a
 * JD-Core Version:    0.7.0.1
 */
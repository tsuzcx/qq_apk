package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import com.tencent.kinda.gen.IUIPagePlatformDelegate;
import com.tencent.kinda.gen.Platform;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class UIPagePlatformDelegateImpl
  implements IUIPagePlatformDelegate
{
  private WeakReference<Context> context;
  private ArrayList<Integer> secureViews;
  
  public UIPagePlatformDelegateImpl(Context paramContext)
  {
    AppMethodBeat.i(226549);
    this.secureViews = new ArrayList();
    this.context = new WeakReference(paramContext);
    AppMethodBeat.o(226549);
  }
  
  public boolean addSecureView(int paramInt)
  {
    AppMethodBeat.i(226558);
    boolean bool = this.secureViews.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(226558);
    return bool;
  }
  
  public Platform currentPlatform()
  {
    return Platform.ANDROID;
  }
  
  public Context getContext()
  {
    AppMethodBeat.i(226556);
    if (this.context != null)
    {
      Context localContext = (Context)this.context.get();
      AppMethodBeat.o(226556);
      return localContext;
    }
    AppMethodBeat.o(226556);
    return null;
  }
  
  public ArrayList<Integer> getSecureViews()
  {
    return this.secureViews;
  }
  
  public boolean removeSecureView(Integer paramInteger)
  {
    AppMethodBeat.i(226561);
    if ((paramInteger != null) && (this.secureViews.size() > 0))
    {
      boolean bool = this.secureViews.remove(paramInteger);
      AppMethodBeat.o(226561);
      return bool;
    }
    AppMethodBeat.o(226561);
    return false;
  }
  
  public void setContext(Context paramContext)
  {
    AppMethodBeat.i(226553);
    this.context = new WeakReference(paramContext);
    AppMethodBeat.o(226553);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.UIPagePlatformDelegateImpl
 * JD-Core Version:    0.7.0.1
 */
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
    AppMethodBeat.i(264012);
    this.secureViews = new ArrayList();
    this.context = new WeakReference(paramContext);
    AppMethodBeat.o(264012);
  }
  
  public boolean addSecureView(int paramInt)
  {
    AppMethodBeat.i(264015);
    boolean bool = this.secureViews.add(Integer.valueOf(paramInt));
    AppMethodBeat.o(264015);
    return bool;
  }
  
  public Platform currentPlatform()
  {
    return Platform.ANDROID;
  }
  
  public Context getContext()
  {
    AppMethodBeat.i(264014);
    if (this.context != null)
    {
      Context localContext = (Context)this.context.get();
      AppMethodBeat.o(264014);
      return localContext;
    }
    AppMethodBeat.o(264014);
    return null;
  }
  
  public ArrayList<Integer> getSecureViews()
  {
    return this.secureViews;
  }
  
  public boolean removeSecureView(Integer paramInteger)
  {
    AppMethodBeat.i(264016);
    if ((paramInteger != null) && (this.secureViews.size() > 0))
    {
      boolean bool = this.secureViews.remove(paramInteger);
      AppMethodBeat.o(264016);
      return bool;
    }
    AppMethodBeat.o(264016);
    return false;
  }
  
  public void setContext(Context paramContext)
  {
    AppMethodBeat.i(264013);
    this.context = new WeakReference(paramContext);
    AppMethodBeat.o(264013);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.UIPagePlatformDelegateImpl
 * JD-Core Version:    0.7.0.1
 */
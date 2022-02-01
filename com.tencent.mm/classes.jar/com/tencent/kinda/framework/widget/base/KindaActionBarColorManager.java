package com.tencent.kinda.framework.widget.base;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import java.util.Iterator;
import java.util.Stack;

public class KindaActionBarColorManager
{
  static final int NO_RESTORE = -1;
  private static final String TAG = "KindaActionBarColorManager";
  private Stack<ActionBarColorItem> mColorItemStack;
  
  private KindaActionBarColorManager()
  {
    AppMethodBeat.i(18823);
    this.mColorItemStack = new Stack();
    AppMethodBeat.o(18823);
  }
  
  public static KindaActionBarColorManager getInstance()
  {
    AppMethodBeat.i(18824);
    KindaActionBarColorManager localKindaActionBarColorManager = Holder.sInstance;
    AppMethodBeat.o(18824);
    return localKindaActionBarColorManager;
  }
  
  private int popTopRestoreColor()
  {
    AppMethodBeat.i(18828);
    ActionBarColorItem localActionBarColorItem;
    do
    {
      if (this.mColorItemStack.size() <= 1)
      {
        AppMethodBeat.o(18828);
        return -1;
      }
      this.mColorItemStack.pop();
      localActionBarColorItem = (ActionBarColorItem)this.mColorItemStack.peek();
    } while (!localActionBarColorItem.enable);
    int i = localActionBarColorItem.color;
    AppMethodBeat.o(18828);
    return i;
  }
  
  private void pushUniqueStack(ActionBarColorItem paramActionBarColorItem)
  {
    AppMethodBeat.i(18829);
    if ((paramActionBarColorItem == null) || (paramActionBarColorItem.baseFragment == null))
    {
      AppMethodBeat.o(18829);
      return;
    }
    Object localObject = null;
    Iterator localIterator = this.mColorItemStack.iterator();
    if (localIterator.hasNext())
    {
      ActionBarColorItem localActionBarColorItem = (ActionBarColorItem)localIterator.next();
      if (!paramActionBarColorItem.baseFragment.equals(localActionBarColorItem.baseFragment)) {
        break label104;
      }
      localObject = localActionBarColorItem;
    }
    label104:
    for (;;)
    {
      break;
      if (localObject != null) {
        this.mColorItemStack.remove(localObject);
      }
      this.mColorItemStack.push(paramActionBarColorItem);
      AppMethodBeat.o(18829);
      return;
    }
  }
  
  int onRestoreActionBarColor(BaseFragment paramBaseFragment)
  {
    AppMethodBeat.i(18826);
    if (paramBaseFragment == null)
    {
      ad.w("KindaActionBarColorManager", "onRestoreActionBarColor return NO_RESTORE(-1), because baseFragment null.");
      AppMethodBeat.o(18826);
      return -1;
    }
    Object localObject = null;
    if (!this.mColorItemStack.empty()) {
      localObject = (ActionBarColorItem)this.mColorItemStack.peek();
    }
    if (localObject == null)
    {
      ad.w("KindaActionBarColorManager", "onRestoreActionBarColor return NO_RESTORE(-1), because mColorItemStack empty.");
      AppMethodBeat.o(18826);
      return -1;
    }
    if (paramBaseFragment.equals(((ActionBarColorItem)localObject).baseFragment))
    {
      int i = popTopRestoreColor();
      ad.i("KindaActionBarColorManager", "onRestoreActionBarColor return " + i + " while the baseFragment at the top of stack.");
      AppMethodBeat.o(18826);
      return i;
    }
    localObject = this.mColorItemStack.iterator();
    while (((Iterator)localObject).hasNext())
    {
      ActionBarColorItem localActionBarColorItem = (ActionBarColorItem)((Iterator)localObject).next();
      if (localActionBarColorItem.baseFragment.equals(paramBaseFragment)) {
        localActionBarColorItem.enable = false;
      }
    }
    ad.i("KindaActionBarColorManager", "onRestoreActionBarColor return NO_RESTORE(-1), Because it's not at the top of stack.");
    AppMethodBeat.o(18826);
    return -1;
  }
  
  void pushActionBarColorItem(BaseFragment paramBaseFragment, int paramInt)
  {
    AppMethodBeat.i(18825);
    ActionBarColorItem localActionBarColorItem = new ActionBarColorItem();
    localActionBarColorItem.color = paramInt;
    localActionBarColorItem.enable = true;
    localActionBarColorItem.baseFragment = paramBaseFragment;
    pushUniqueStack(localActionBarColorItem);
    AppMethodBeat.o(18825);
  }
  
  public void reset()
  {
    AppMethodBeat.i(18827);
    this.mColorItemStack.clear();
    AppMethodBeat.o(18827);
  }
  
  public static final class Holder
  {
    private static final KindaActionBarColorManager sInstance;
    
    static
    {
      AppMethodBeat.i(18822);
      sInstance = new KindaActionBarColorManager(null);
      AppMethodBeat.o(18822);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.KindaActionBarColorManager
 * JD-Core Version:    0.7.0.1
 */
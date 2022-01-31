package com.tencent.kinda.framework.widget.base;

import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.g;
import android.support.v4.app.k;
import com.tencent.kinda.framework.app.MainFragment;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.widget.SwipeBackLayout;
import java.util.List;
import java.util.Stack;

public class FrLifeController
{
  public static final String TAG = "MicroMsg.FragmentController";
  BaseFrActivity activity;
  private int fragmentCount;
  private Stack<BaseFragment> mFragmentBackStack;
  
  public FrLifeController(BaseFrActivity paramBaseFrActivity)
  {
    AppMethodBeat.i(144665);
    this.fragmentCount = 0;
    this.activity = paramBaseFrActivity;
    g.enableDebugLogging(true);
    this.mFragmentBackStack = new Stack();
    AppMethodBeat.o(144665);
  }
  
  private void checkSwipeBackLayout()
  {
    AppMethodBeat.i(144667);
    if (!this.activity.isSupportNavigationSwipeBack())
    {
      AppMethodBeat.o(144667);
      return;
    }
    int i = this.mFragmentBackStack.size();
    ab.i("MicroMsg.FragmentController", "checkSwipeBackLayout %s %s", new Object[] { Integer.valueOf(i), Integer.valueOf(this.activity.getFragmentManager().getBackStackEntryCount()) });
    if (i > 1)
    {
      this.activity.getSwipeBackLayout().setEnableGesture(false);
      AppMethodBeat.o(144667);
      return;
    }
    this.activity.getSwipeBackLayout().setEnableGesture(true);
    AppMethodBeat.o(144667);
  }
  
  private BaseFragment getFragMent(int paramInt)
  {
    AppMethodBeat.i(144672);
    if ((this.mFragmentBackStack == null) || (this.mFragmentBackStack.size() == 0))
    {
      AppMethodBeat.o(144672);
      return null;
    }
    BaseFragment localBaseFragment;
    if (paramInt < 0)
    {
      int i = this.mFragmentBackStack.size() + paramInt;
      if ((i >= 0) && (i < this.mFragmentBackStack.size()))
      {
        localBaseFragment = (BaseFragment)this.mFragmentBackStack.get(this.mFragmentBackStack.size() + paramInt);
        AppMethodBeat.o(144672);
        return localBaseFragment;
      }
      AppMethodBeat.o(144672);
      return null;
    }
    if (paramInt < this.mFragmentBackStack.size())
    {
      localBaseFragment = (BaseFragment)this.mFragmentBackStack.get(paramInt);
      AppMethodBeat.o(144672);
      return localBaseFragment;
    }
    AppMethodBeat.o(144672);
    return null;
  }
  
  private void watchLife(BaseFragment paramBaseFragment)
  {
    AppMethodBeat.i(144666);
    paramBaseFragment.watchLife(new FrLifeController.1(this, paramBaseFragment));
    AppMethodBeat.o(144666);
  }
  
  public boolean addFragment(BaseFragment paramBaseFragment)
  {
    AppMethodBeat.i(144668);
    this.fragmentCount += 1;
    k localk2 = this.activity.getSupportFragmentManager().beginTransaction();
    k localk1 = localk2;
    if ((paramBaseFragment instanceof MainFragment)) {
      localk1 = localk2.m(2131034266, 2131034263);
    }
    localk1.a(2131825888, paramBaseFragment);
    watchLife(paramBaseFragment);
    localk1.F(String.valueOf(paramBaseFragment.hashCode()));
    this.mFragmentBackStack.add(paramBaseFragment);
    localk1.commitAllowingStateLoss();
    AppMethodBeat.o(144668);
    return true;
  }
  
  public BaseFragment getCurrent()
  {
    AppMethodBeat.i(144671);
    Object localObject = this.activity.getSupportFragmentManager().getFragments();
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (Fragment)((List)localObject).get(((List)localObject).size() - 1);
      if ((localObject instanceof BaseFragment))
      {
        localObject = (BaseFragment)localObject;
        AppMethodBeat.o(144671);
        return localObject;
      }
      AppMethodBeat.o(144671);
      return null;
    }
    AppMethodBeat.o(144671);
    return null;
  }
  
  public int getFragmentListSize()
  {
    return this.fragmentCount;
  }
  
  public boolean popFragment()
  {
    AppMethodBeat.i(144669);
    if ((this.fragmentCount > 1) && (this.activity.getSupportFragmentManager().getBackStackEntryCount() > 1) && (!this.activity.getSupportFragmentManager().isStateSaved()))
    {
      this.mFragmentBackStack.pop();
      this.activity.getSupportFragmentManager().popBackStack();
      this.fragmentCount -= 1;
      if (this.fragmentCount > 0)
      {
        AppMethodBeat.o(144669);
        return true;
      }
      AppMethodBeat.o(144669);
      return false;
    }
    AppMethodBeat.o(144669);
    return false;
  }
  
  public boolean removeModal(BaseFragment paramBaseFragment)
  {
    AppMethodBeat.i(144670);
    if (this.fragmentCount > 0)
    {
      this.fragmentCount -= 1;
      paramBaseFragment.setWillBeRemoved(true);
      k localk = this.activity.getSupportFragmentManager().beginTransaction();
      localk.b(paramBaseFragment);
      localk.commitAllowingStateLoss();
      this.mFragmentBackStack.remove(paramBaseFragment);
    }
    if (this.fragmentCount > 0)
    {
      AppMethodBeat.o(144670);
      return true;
    }
    AppMethodBeat.o(144670);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.FrLifeController
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.kinda.framework.widget.base;

import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMFragment;
import java.util.List;

abstract class LifecycleFragment
  extends MMFragment
  implements FragmentLifecycle
{
  private static final String TAG = "MicroMsg.LifecycleFragment";
  protected State mState = State.INITIAL;
  
  private void _callFragmentOnCreate()
  {
    Log.d("MicroMsg.LifecycleFragment", "_callFragmentOnCreate: %s", new Object[] { this.mState });
    if (this.mState == State.INITIAL)
    {
      this.mState = State.CREATED;
      onFragmentOnCreate();
    }
  }
  
  private void _callFragmentOnDestroy()
  {
    Log.d("MicroMsg.LifecycleFragment", "_callFragmentOnDestroy: %s", new Object[] { this.mState });
    if (this.mState == State.STOPPED)
    {
      this.mState = State.DESTROYED;
      onFragmentOnDestroy();
    }
  }
  
  private void _callFragmentOnPause()
  {
    Log.d("MicroMsg.LifecycleFragment", "_callFragmentOnPause: %s", new Object[] { this.mState });
    if ((this.mState == State.RESUMED) || (this.mState == State.STARTED))
    {
      this.mState = State.PAUSED;
      onFragmentOnPause();
    }
  }
  
  private void _callFragmentOnResume()
  {
    Log.d("MicroMsg.LifecycleFragment", "_callFragmentOnResume: %s", new Object[] { this.mState });
    if ((this.mState == State.STARTED) || (this.mState == State.PAUSED))
    {
      this.mState = State.RESUMED;
      onFragmentOnResume();
    }
  }
  
  private void _callFragmentOnStart()
  {
    Log.d("MicroMsg.LifecycleFragment", "_callFragmentOnStart: %s", new Object[] { this.mState });
    if ((this.mState == State.CREATED) || (this.mState == State.STOPPED))
    {
      this.mState = State.STARTED;
      onFragmentOnStart();
    }
  }
  
  private void _callFragmentOnStop()
  {
    Log.d("MicroMsg.LifecycleFragment", "_callFragmentOnStop: %s", new Object[] { this.mState });
    if (this.mState == State.PAUSED)
    {
      this.mState = State.STOPPED;
      onFragmentOnStop();
    }
  }
  
  private void _fixCallOnResumeOrOnPause()
  {
    if (getActivity() == null)
    {
      Log.w("MicroMsg.LifecycleFragment", "null activity when call");
      return;
    }
    List localList = getActivity().getSupportFragmentManager().getFragments();
    Log.d("MicroMsg.LifecycleFragment", "call on resume or puase: %s", new Object[] { localList });
    if ((localList.size() > 0) && (localList.get(localList.size() - 1) == this))
    {
      _callFragmentOnResume();
      return;
    }
    _callFragmentOnPause();
  }
  
  private void _fixOnPauseNotCallingProblem()
  {
    if (getActivity() == null) {
      Log.w("MicroMsg.LifecycleFragment", "null activity when call");
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = getActivity().getSupportFragmentManager().getFragments();
        Log.d("MicroMsg.LifecycleFragment", "current fragments: %s", new Object[] { localObject });
      } while (((List)localObject).size() < 2);
      localObject = (Fragment)((List)localObject).get(((List)localObject).size() - 2);
    } while (!(localObject instanceof LifecycleFragment));
    ((LifecycleFragment)localObject)._callFragmentOnPause();
  }
  
  private void _fixOnResumeNotCallingProblem()
  {
    if (getActivity() == null) {
      Log.w("MicroMsg.LifecycleFragment", "null activity when call");
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = getActivity().getSupportFragmentManager().getFragments();
        Log.d("MicroMsg.LifecycleFragment", "current fragments: %s", new Object[] { localObject });
      } while (((List)localObject).size() <= 0);
      localObject = (Fragment)((List)localObject).get(((List)localObject).size() - 1);
    } while (!(localObject instanceof LifecycleFragment));
    ((LifecycleFragment)localObject)._callFragmentOnResume();
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    super.onActivityCreated(paramBundle);
    _callFragmentOnCreate();
    _fixOnPauseNotCallingProblem();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    _callFragmentOnDestroy();
    _fixOnResumeNotCallingProblem();
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    _callFragmentOnDestroy();
    _fixOnResumeNotCallingProblem();
  }
  
  public void onFragmentOnCreate()
  {
    Log.d("MicroMsg.LifecycleFragment", "lifecycle: onFragmentOnCreate, class: %s", new Object[] { toString() });
  }
  
  public void onFragmentOnDestroy()
  {
    Log.d("MicroMsg.LifecycleFragment", "lifecycle: onFragmentOnDestroy, class: %s", new Object[] { toString() });
  }
  
  public void onFragmentOnPause()
  {
    Log.d("MicroMsg.LifecycleFragment", "lifecycle: onFragmentOnPause, class: %s", new Object[] { toString() });
  }
  
  public void onFragmentOnResume()
  {
    Log.d("MicroMsg.LifecycleFragment", "lifecycle: onFragmentOnResume, class: %s", new Object[] { toString() });
  }
  
  public void onFragmentOnStart()
  {
    Log.d("MicroMsg.LifecycleFragment", "lifecycle: onFragmentOnStart, class: %s", new Object[] { toString() });
  }
  
  public void onFragmentOnStop()
  {
    Log.d("MicroMsg.LifecycleFragment", "lifecycle: onFragmentOnStop, class: %s", new Object[] { toString() });
  }
  
  public void onPause()
  {
    super.onPause();
    _callFragmentOnPause();
  }
  
  public void onResume()
  {
    super.onResume();
    _fixCallOnResumeOrOnPause();
  }
  
  public void onStart()
  {
    super.onStart();
    _callFragmentOnStart();
  }
  
  public void onStop()
  {
    super.onStop();
    _callFragmentOnStop();
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    _callFragmentOnCreate();
    _fixOnPauseNotCallingProblem();
  }
  
  static enum State
  {
    private int value = 0;
    
    static
    {
      AppMethodBeat.i(178774);
      INITIAL = new State("INITIAL", 0, 0);
      CREATED = new State("CREATED", 1, 1);
      STARTED = new State("STARTED", 2, 2);
      RESUMED = new State("RESUMED", 3, 3);
      PAUSED = new State("PAUSED", 4, 4);
      STOPPED = new State("STOPPED", 5, 5);
      DESTROYED = new State("DESTROYED", 6, 6);
      $VALUES = new State[] { INITIAL, CREATED, STARTED, RESUMED, PAUSED, STOPPED, DESTROYED };
      AppMethodBeat.o(178774);
    }
    
    private State(int paramInt)
    {
      this.value = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.LifecycleFragment
 * JD-Core Version:    0.7.0.1
 */
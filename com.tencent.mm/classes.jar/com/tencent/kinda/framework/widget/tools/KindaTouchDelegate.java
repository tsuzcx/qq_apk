package com.tencent.kinda.framework.widget.tools;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Iterator;

public class KindaTouchDelegate
  extends TouchDelegate
{
  private boolean delegateTargeted;
  private ArrayList<DelegateInfo> delegates;
  private int slop;
  private DelegateInfo targetInfo;
  
  public KindaTouchDelegate(Rect paramRect, View paramView)
  {
    super(paramRect, paramView);
    AppMethodBeat.i(226437);
    this.delegates = new ArrayList();
    this.targetInfo = null;
    this.delegates.clear();
    this.slop = ViewConfiguration.get(paramView.getContext()).getScaledTouchSlop();
    addDelegate(paramRect, paramView);
    AppMethodBeat.o(226437);
  }
  
  public void addDelegate(Rect paramRect, View paramView)
  {
    AppMethodBeat.i(226440);
    DelegateInfo localDelegateInfo = new DelegateInfo();
    localDelegateInfo.view = paramView;
    localDelegateInfo.bounds = paramRect;
    localDelegateInfo.slopBounds = new Rect(paramRect);
    localDelegateInfo.slopBounds.inset(-this.slop, -this.slop);
    int i = 0;
    while (i < this.delegates.size())
    {
      if (((DelegateInfo)this.delegates.get(i)).view == localDelegateInfo.view)
      {
        this.delegates.set(i, localDelegateInfo);
        AppMethodBeat.o(226440);
        return;
      }
      i += 1;
    }
    this.delegates.add(0, localDelegateInfo);
    AppMethodBeat.o(226440);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 1;
    boolean bool2 = false;
    AppMethodBeat.i(226448);
    int j = (int)paramMotionEvent.getX();
    int k = (int)paramMotionEvent.getY();
    boolean bool1;
    boolean bool3;
    switch (paramMotionEvent.getActionMasked())
    {
    case 4: 
    default: 
      bool1 = false;
    case 0: 
    case 1: 
    case 2: 
    case 5: 
    case 6: 
      for (;;)
      {
        if (bool1) {
          if (this.targetInfo == null)
          {
            AppMethodBeat.o(226448);
            return false;
            this.delegateTargeted = false;
            this.targetInfo = null;
            Iterator localIterator = this.delegates.iterator();
            while (localIterator.hasNext())
            {
              DelegateInfo localDelegateInfo = (DelegateInfo)localIterator.next();
              if (localDelegateInfo.bounds.contains(j, k))
              {
                this.targetInfo = localDelegateInfo;
                this.delegateTargeted = true;
              }
            }
            bool1 = this.delegateTargeted;
            continue;
            bool3 = this.delegateTargeted;
            bool1 = bool3;
            if (!bool3) {
              continue;
            }
            if (this.targetInfo == null)
            {
              AppMethodBeat.o(226448);
              return false;
            }
            if (this.targetInfo.slopBounds.contains(j, k)) {
              break label316;
            }
          }
        }
      }
    }
    label316:
    for (i = 0;; i = 1)
    {
      bool1 = bool3;
      break;
      bool1 = this.delegateTargeted;
      this.delegateTargeted = false;
      this.targetInfo = null;
      break;
      if (i != 0) {
        paramMotionEvent.setLocation(this.targetInfo.view.getWidth() / 2, this.targetInfo.view.getHeight() / 2);
      }
      for (;;)
      {
        bool2 = this.targetInfo.view.dispatchTouchEvent(paramMotionEvent);
        AppMethodBeat.o(226448);
        return bool2;
        paramMotionEvent.setLocation(-(this.slop * 2), -(this.slop * 2));
      }
    }
  }
  
  class DelegateInfo
  {
    Rect bounds;
    Rect slopBounds;
    View view;
    
    DelegateInfo() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.tools.KindaTouchDelegate
 * JD-Core Version:    0.7.0.1
 */
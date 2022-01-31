package android.support.v7.app;

import android.app.UiModeManager;
import android.content.Context;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Window;
import android.view.Window.Callback;

class h
  extends g
{
  private final UiModeManager Pj;
  
  h(Context paramContext, Window paramWindow, c paramc)
  {
    super(paramContext, paramWindow, paramc);
    this.Pj = ((UiModeManager)paramContext.getSystemService("uimode"));
  }
  
  Window.Callback a(Window.Callback paramCallback)
  {
    return new a(paramCallback);
  }
  
  final int aU(int paramInt)
  {
    if ((paramInt == 0) && (this.Pj.getNightMode() == 0)) {
      return -1;
    }
    return super.aU(paramInt);
  }
  
  class a
    extends g.a
  {
    a(Window.Callback paramCallback)
    {
      super(paramCallback);
    }
    
    public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback)
    {
      return null;
    }
    
    public ActionMode onWindowStartingActionMode(ActionMode.Callback paramCallback, int paramInt)
    {
      if (h.this.Pb) {}
      switch (paramInt)
      {
      default: 
        return super.onWindowStartingActionMode(paramCallback, paramInt);
      }
      return a(paramCallback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.v7.app.h
 * JD-Core Version:    0.7.0.1
 */
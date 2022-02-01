package com.tencent.mm.plugin.finder.video.sticker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.KeyEvent.DispatcherState;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.widget.InsectFrameLayout;
import d.g.a.b;
import d.g.b.k;
import d.l;
import d.y;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/video/sticker/EditorPanelHolder;", "Lcom/tencent/mm/ui/widget/InsectFrameLayout;", "Lcom/tencent/mm/media/editor/panel/IEditorPanel;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "(Landroid/content/Context;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "panelView", "Landroid/view/View;", "visibleCallback", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "visible", "", "dispatchKeyEvent", "event", "Landroid/view/KeyEvent;", "insectBottom", "bottom", "isShow", "setOnVisibleChangeCallback", "callback", "setPanelView", "view", "params", "Landroid/view/ViewGroup$LayoutParams;", "setShow", "show", "plugin-finder_release"})
public final class EditorPanelHolder
  extends InsectFrameLayout
{
  private b<? super Boolean, y> gPX;
  View rUv;
  
  public EditorPanelHolder(Context paramContext)
  {
    this(paramContext, null);
    AppMethodBeat.i(204023);
    AppMethodBeat.o(204023);
  }
  
  public EditorPanelHolder(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
    AppMethodBeat.i(204022);
    AppMethodBeat.o(204022);
  }
  
  public EditorPanelHolder(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(204021);
    setOnClickListener((View.OnClickListener)new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(204016);
        this.rUw.setShow(false);
        AppMethodBeat.o(204016);
      }
    });
    AppMethodBeat.o(204021);
  }
  
  public final boolean cEv()
  {
    return true;
  }
  
  public final boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(204020);
    k.h(paramKeyEvent, "event");
    if (paramKeyEvent.getKeyCode() == 4)
    {
      if (getKeyDispatcherState() == null)
      {
        bool = super.dispatchKeyEvent(paramKeyEvent);
        AppMethodBeat.o(204020);
        return bool;
      }
      KeyEvent.DispatcherState localDispatcherState;
      if ((paramKeyEvent.getAction() == 0) && (paramKeyEvent.getRepeatCount() == 0))
      {
        localDispatcherState = getKeyDispatcherState();
        if (localDispatcherState != null) {
          localDispatcherState.startTracking(paramKeyEvent, this);
        }
        AppMethodBeat.o(204020);
        return true;
      }
      if (paramKeyEvent.getAction() == 1)
      {
        localDispatcherState = getKeyDispatcherState();
        if ((localDispatcherState != null) && (localDispatcherState.isTracking(paramKeyEvent)) && (!paramKeyEvent.isCanceled()))
        {
          setShow(false);
          AppMethodBeat.o(204020);
          return true;
        }
      }
      bool = super.dispatchKeyEvent(paramKeyEvent);
      AppMethodBeat.o(204020);
      return bool;
    }
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(204020);
    return bool;
  }
  
  public final void setOnVisibleChangeCallback(b<? super Boolean, y> paramb)
  {
    this.gPX = paramb;
  }
  
  public final void setShow(boolean paramBoolean)
  {
    AppMethodBeat.i(204019);
    if (paramBoolean)
    {
      setVisibility(0);
      localObject = this.gPX;
      if (localObject != null) {
        ((b)localObject).ay(Boolean.TRUE);
      }
      localObject = this.rUv;
      if (localObject != null)
      {
        ((View)localObject).animate().cancel();
        if (((View)localObject).getHeight() == 0)
        {
          ((View)localObject).setVisibility(4);
          ((View)localObject).post((Runnable)new b((View)localObject));
          AppMethodBeat.o(204019);
          return;
        }
        ((View)localObject).animate().translationY(0.0F).start();
        AppMethodBeat.o(204019);
        return;
      }
      AppMethodBeat.o(204019);
      return;
    }
    Object localObject = this.gPX;
    if (localObject != null) {
      ((b)localObject).ay(Boolean.FALSE);
    }
    localObject = this.rUv;
    if (localObject != null)
    {
      ((View)localObject).animate().cancel();
      ((View)localObject).animate().translationY(((View)localObject).getHeight()).withEndAction((Runnable)new a(this)).start();
      AppMethodBeat.o(204019);
      return;
    }
    AppMethodBeat.o(204019);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run", "com/tencent/mm/plugin/finder/video/sticker/EditorPanelHolder$setShow$2$1"})
  static final class a
    implements Runnable
  {
    a(EditorPanelHolder paramEditorPanelHolder) {}
    
    public final void run()
    {
      AppMethodBeat.i(204017);
      this.rUw.setVisibility(8);
      AppMethodBeat.o(204017);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(View paramView) {}
    
    public final void run()
    {
      AppMethodBeat.i(204018);
      this.rUx.setVisibility(0);
      this.rUx.setTranslationY(this.rUx.getHeight());
      this.rUx.animate().translationY(0.0F).start();
      AppMethodBeat.o(204018);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.sticker.EditorPanelHolder
 * JD-Core Version:    0.7.0.1
 */
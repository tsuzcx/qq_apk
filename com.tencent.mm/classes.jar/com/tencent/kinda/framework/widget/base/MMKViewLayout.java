package com.tencent.kinda.framework.widget.base;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.android.YogaLayout;
import com.tencent.kinda.framework.animate.KindaAnimatorViewProxy;
import com.tencent.kinda.framework.widget.tools.FlexBoxAttr;
import com.tencent.kinda.gen.Align;
import com.tencent.kinda.gen.FlexDirection;
import com.tencent.kinda.gen.Justify;
import com.tencent.kinda.gen.KView;
import com.tencent.kinda.gen.KViewLayout;
import com.tencent.kinda.gen.Wrap;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;

public class MMKViewLayout<Layout extends ViewGroup>
  extends MMKView<Layout>
  implements KViewLayout
{
  protected static final String TAG = "MMKViewLayout";
  public ArrayList<MMKView> childList;
  
  public MMKViewLayout()
  {
    AppMethodBeat.i(19265);
    this.childList = new ArrayList();
    AppMethodBeat.o(19265);
  }
  
  public void addView(KView paramKView)
  {
    AppMethodBeat.i(19267);
    addView(paramKView, node().getChildCount());
    AppMethodBeat.o(19267);
  }
  
  public void addView(KView paramKView, int paramInt)
  {
    AppMethodBeat.i(19268);
    if (getView() != null)
    {
      paramKView = KindaAnimatorViewProxy.unWrapRealObj(paramKView);
      if ((paramKView instanceof MMKView))
      {
        Log.printDebugStack("MMKViewLayout", "%s addview this %s | child %s | childparent %s | childCount: %s", new Object[] { this, getView(), ((MMKView)paramKView).getView(), ((MMKView)paramKView).getView().getParent(), Integer.valueOf(this.childList.size()) });
        if ((getView() instanceof YogaLayout)) {
          ((YogaLayout)getView()).addView(((MMKView)paramKView).getView(), ((MMKView)paramKView).node());
        }
        for (;;)
        {
          this.childList.add((MMKView)paramKView);
          AppMethodBeat.o(19268);
          return;
          ((ViewGroup)getView()).addView(((MMKView)paramKView).getView());
        }
      }
      Log.e("MMKViewLayout", "error error %s child %s %s", new Object[] { getView(), paramKView, Boolean.valueOf(paramKView instanceof MMKView) });
    }
    AppMethodBeat.o(19268);
  }
  
  public Layout createView(Context paramContext)
  {
    AppMethodBeat.i(19266);
    paramContext = new YogaLayout(paramContext);
    this.flexAttr.setYogaNode(((YogaLayout)paramContext).getYogaNode());
    AppMethodBeat.o(19266);
    return paramContext;
  }
  
  public Align getAlignContent()
  {
    AppMethodBeat.i(19280);
    Align localAlign = this.flexAttr.getAlignContent();
    AppMethodBeat.o(19280);
    return localAlign;
  }
  
  public Align getAlignItems()
  {
    AppMethodBeat.i(19278);
    Align localAlign = this.flexAttr.getAlignItems();
    AppMethodBeat.o(19278);
    return localAlign;
  }
  
  public FlexDirection getFlexDirection()
  {
    AppMethodBeat.i(19272);
    FlexDirection localFlexDirection = this.flexAttr.getFlexDirection();
    AppMethodBeat.o(19272);
    return localFlexDirection;
  }
  
  public Wrap getFlexWrap()
  {
    AppMethodBeat.i(19276);
    Wrap localWrap = this.flexAttr.getFlexWrap();
    AppMethodBeat.o(19276);
    return localWrap;
  }
  
  public Justify getJustifyContent()
  {
    AppMethodBeat.i(19274);
    Justify localJustify = this.flexAttr.getJustifyContent();
    AppMethodBeat.o(19274);
    return localJustify;
  }
  
  public void removeAllViews()
  {
    AppMethodBeat.i(19270);
    ((ViewGroup)getView()).removeAllViews();
    AppMethodBeat.o(19270);
  }
  
  public void removeView(KView paramKView)
  {
    AppMethodBeat.i(19269);
    if ((getView() != null) && ((paramKView instanceof MMKView)))
    {
      ((ViewGroup)getView()).removeView(((MMKView)paramKView).getView());
      this.childList.remove(paramKView);
    }
    AppMethodBeat.o(19269);
  }
  
  public void setAlignContent(Align paramAlign)
  {
    AppMethodBeat.i(19279);
    this.flexAttr.setAlignContent(paramAlign);
    AppMethodBeat.o(19279);
  }
  
  public void setAlignItems(Align paramAlign)
  {
    AppMethodBeat.i(19277);
    this.flexAttr.setAlignItems(paramAlign);
    AppMethodBeat.o(19277);
  }
  
  public void setFlexDirection(FlexDirection paramFlexDirection)
  {
    AppMethodBeat.i(19271);
    this.flexAttr.setFlexDirection(paramFlexDirection);
    AppMethodBeat.o(19271);
  }
  
  public void setFlexWrap(Wrap paramWrap)
  {
    AppMethodBeat.i(19275);
    this.flexAttr.setFlexWrap(paramWrap);
    AppMethodBeat.o(19275);
  }
  
  public void setFocusableInTouchMode(boolean paramBoolean)
  {
    AppMethodBeat.i(214568);
    ((ViewGroup)getView()).setFocusable(true);
    ((ViewGroup)getView()).setFocusableInTouchMode(true);
    AppMethodBeat.o(214568);
  }
  
  public void setJustifyContent(Justify paramJustify)
  {
    AppMethodBeat.i(19273);
    this.flexAttr.setJustifyContent(paramJustify);
    AppMethodBeat.o(19273);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKViewLayout
 * JD-Core Version:    0.7.0.1
 */
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
import com.tencent.mm.sdk.platformtools.ab;
import java.util.ArrayList;

public class MMKViewLayout<Layout extends ViewGroup>
  extends MMKView<Layout>
  implements KViewLayout
{
  protected static final String TAG = "MMKViewLayout";
  protected ArrayList<MMKView> childList;
  
  public MMKViewLayout()
  {
    AppMethodBeat.i(145101);
    this.childList = new ArrayList();
    AppMethodBeat.o(145101);
  }
  
  public void addView(KView paramKView)
  {
    AppMethodBeat.i(145103);
    addView(paramKView, node().getChildCount());
    AppMethodBeat.o(145103);
  }
  
  public void addView(KView paramKView, int paramInt)
  {
    AppMethodBeat.i(145104);
    if (getView() != null)
    {
      paramKView = KindaAnimatorViewProxy.unWrapRealObj(paramKView);
      if ((paramKView instanceof MMKView))
      {
        ab.a("MMKViewLayout", "%s addview this %s | child %s | childparent %s | childCount: %s", new Object[] { this, getView(), ((MMKView)paramKView).getView(), ((MMKView)paramKView).getView().getParent(), Integer.valueOf(this.childList.size()) });
        if ((getView() instanceof YogaLayout)) {
          ((YogaLayout)getView()).addView(((MMKView)paramKView).getView(), ((MMKView)paramKView).node());
        }
        for (;;)
        {
          this.childList.add((MMKView)paramKView);
          AppMethodBeat.o(145104);
          return;
          ((ViewGroup)getView()).addView(((MMKView)paramKView).getView());
        }
      }
      ab.e("MMKViewLayout", "error error %s child %s %s", new Object[] { getView(), paramKView, Boolean.valueOf(paramKView instanceof MMKView) });
    }
    AppMethodBeat.o(145104);
  }
  
  public Layout createView(Context paramContext)
  {
    AppMethodBeat.i(145102);
    paramContext = new YogaLayout(paramContext);
    this.flexAttr.setYogaNode(((YogaLayout)paramContext).getYogaNode());
    AppMethodBeat.o(145102);
    return paramContext;
  }
  
  public Align getAlignContent()
  {
    AppMethodBeat.i(145116);
    Align localAlign = this.flexAttr.getAlignContent();
    AppMethodBeat.o(145116);
    return localAlign;
  }
  
  public Align getAlignItems()
  {
    AppMethodBeat.i(145114);
    Align localAlign = this.flexAttr.getAlignItems();
    AppMethodBeat.o(145114);
    return localAlign;
  }
  
  public FlexDirection getFlexDirection()
  {
    AppMethodBeat.i(145108);
    FlexDirection localFlexDirection = this.flexAttr.getFlexDirection();
    AppMethodBeat.o(145108);
    return localFlexDirection;
  }
  
  public Wrap getFlexWrap()
  {
    AppMethodBeat.i(145112);
    Wrap localWrap = this.flexAttr.getFlexWrap();
    AppMethodBeat.o(145112);
    return localWrap;
  }
  
  public Justify getJustifyContent()
  {
    AppMethodBeat.i(145110);
    Justify localJustify = this.flexAttr.getJustifyContent();
    AppMethodBeat.o(145110);
    return localJustify;
  }
  
  public void removeAllViews()
  {
    AppMethodBeat.i(145106);
    ((ViewGroup)getView()).removeAllViews();
    AppMethodBeat.o(145106);
  }
  
  public void removeView(KView paramKView)
  {
    AppMethodBeat.i(145105);
    if ((getView() != null) && ((paramKView instanceof MMKView)))
    {
      ((ViewGroup)getView()).removeView(((MMKView)paramKView).getView());
      this.childList.remove(paramKView);
    }
    AppMethodBeat.o(145105);
  }
  
  public void setAlignContent(Align paramAlign)
  {
    AppMethodBeat.i(145115);
    this.flexAttr.setAlignContent(paramAlign);
    AppMethodBeat.o(145115);
  }
  
  public void setAlignItems(Align paramAlign)
  {
    AppMethodBeat.i(145113);
    this.flexAttr.setAlignItems(paramAlign);
    AppMethodBeat.o(145113);
  }
  
  public void setFlexDirection(FlexDirection paramFlexDirection)
  {
    AppMethodBeat.i(145107);
    this.flexAttr.setFlexDirection(paramFlexDirection);
    AppMethodBeat.o(145107);
  }
  
  public void setFlexWrap(Wrap paramWrap)
  {
    AppMethodBeat.i(145111);
    this.flexAttr.setFlexWrap(paramWrap);
    AppMethodBeat.o(145111);
  }
  
  public void setJustifyContent(Justify paramJustify)
  {
    AppMethodBeat.i(145109);
    this.flexAttr.setJustifyContent(paramJustify);
    AppMethodBeat.o(145109);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.MMKViewLayout
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.kinda.framework.widget.tools;

import com.facebook.yoga.YogaEdge;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.YogaNodeFactory;
import com.tencent.kinda.framework.widget.base.ViewStyleMapper;
import com.tencent.kinda.gen.Align;
import com.tencent.kinda.gen.FlexDirection;
import com.tencent.kinda.gen.Justify;
import com.tencent.kinda.gen.PositionType;
import com.tencent.kinda.gen.Wrap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FlexBoxAttr
{
  public static final String TAG = "MicroMsg.FlexBoxAttr";
  public static final float UNDEFINED = 1.0E+021F;
  protected Align alignContent;
  protected Align alignItems;
  protected Align alignSelf;
  protected float aspectRatio;
  protected float bottom;
  protected float bottomPercent;
  protected float flexBasis;
  protected FlexDirection flexDirection;
  protected float flexGrow;
  protected float flexShrink;
  protected Wrap flexWrap;
  protected float height;
  protected float heightPercent;
  private IFlexBoxChange iFlexBoxChange;
  protected Justify justifyContent;
  protected float left;
  protected float leftPercent;
  protected float marginBottom;
  protected float marginBottomPercent;
  protected float marginLeft;
  protected float marginLeftPercent;
  protected float marginRight;
  protected float marginRightPercent;
  protected float marginTop;
  protected float marginTopPercent;
  protected float maxHeight;
  protected float maxWidth;
  protected float minHeight;
  protected float minWidth;
  protected float paddingBottom;
  protected float paddingBottomPercent;
  protected float paddingLeft;
  protected float paddingLeftPercent;
  protected float paddingRight;
  protected float paddingRightPercent;
  protected float paddingTop;
  protected float paddingTopPercent;
  protected PositionType positionType;
  protected float right;
  protected float rightPercent;
  protected String testId;
  protected float top;
  protected float topPercent;
  protected int visibility;
  protected float width;
  protected float widthPercent;
  YogaNode yogaNode;
  
  public FlexBoxAttr()
  {
    AppMethodBeat.i(19330);
    this.yogaNode = YogaNodeFactory.create();
    this.width = 1.0E+021F;
    this.height = 1.0E+021F;
    applyNodeDefaultParam();
    AppMethodBeat.o(19330);
  }
  
  public FlexBoxAttr(IFlexBoxChange paramIFlexBoxChange)
  {
    AppMethodBeat.i(19331);
    this.yogaNode = YogaNodeFactory.create();
    this.width = 1.0E+021F;
    this.height = 1.0E+021F;
    this.iFlexBoxChange = paramIFlexBoxChange;
    applyNodeDefaultParam();
    AppMethodBeat.o(19331);
  }
  
  private void applyNodeDefaultParam()
  {
    AppMethodBeat.i(19332);
    this.yogaNode = YogaNodeFactory.create();
    this.yogaNode.reset();
    AppMethodBeat.o(19332);
  }
  
  public static boolean isUndefined(float paramFloat)
  {
    AppMethodBeat.i(19329);
    if ((Float.compare(paramFloat, 1.0E+009F) >= 0) || (Float.compare(paramFloat, -1.0E+009F) <= 0))
    {
      AppMethodBeat.o(19329);
      return true;
    }
    AppMethodBeat.o(19329);
    return false;
  }
  
  public Align getAlignContent()
  {
    return this.alignContent;
  }
  
  public Align getAlignItems()
  {
    return this.alignItems;
  }
  
  public Align getAlignSelf()
  {
    return this.alignSelf;
  }
  
  public float getAspectRatio()
  {
    return this.aspectRatio;
  }
  
  public float getBottom()
  {
    return this.bottom;
  }
  
  public float getBottomPercent()
  {
    return this.bottomPercent;
  }
  
  public float getFlexBasis()
  {
    return this.flexBasis;
  }
  
  public FlexDirection getFlexDirection()
  {
    return this.flexDirection;
  }
  
  public float getFlexGrow()
  {
    return this.flexGrow;
  }
  
  public float getFlexShrink()
  {
    return this.flexShrink;
  }
  
  public Wrap getFlexWrap()
  {
    return this.flexWrap;
  }
  
  public float getHeight()
  {
    AppMethodBeat.i(19336);
    if (isUndefined(this.height))
    {
      f = MMKViewUtil.pxToDp(KindaContext.get(), this.yogaNode.getLayoutHeight());
      AppMethodBeat.o(19336);
      return f;
    }
    float f = this.height;
    AppMethodBeat.o(19336);
    return f;
  }
  
  public float getHeightPercent()
  {
    return this.heightPercent;
  }
  
  public Justify getJustifyContent()
  {
    return this.justifyContent;
  }
  
  public float getLeft()
  {
    return this.left;
  }
  
  public float getLeftPercent()
  {
    return this.leftPercent;
  }
  
  public float getMarginBottom()
  {
    return this.marginBottom;
  }
  
  public float getMarginBottomPercent()
  {
    return this.marginBottomPercent;
  }
  
  public float getMarginLeft()
  {
    return this.marginLeft;
  }
  
  public float getMarginLeftPercent()
  {
    return this.marginLeftPercent;
  }
  
  public float getMarginRight()
  {
    return this.marginRight;
  }
  
  public float getMarginRightPercent()
  {
    return this.marginRightPercent;
  }
  
  public float getMarginTop()
  {
    return this.marginTop;
  }
  
  public float getMarginTopPercent()
  {
    return this.marginTopPercent;
  }
  
  public float getMaxHeight()
  {
    return this.maxHeight;
  }
  
  public float getMaxWidth()
  {
    return this.maxWidth;
  }
  
  public float getMinHeight()
  {
    return this.minHeight;
  }
  
  public float getMinWidth()
  {
    return this.minWidth;
  }
  
  public float getPaddingBottom()
  {
    return this.paddingBottom;
  }
  
  public float getPaddingBottomPercent()
  {
    return this.paddingBottomPercent;
  }
  
  public float getPaddingLeft()
  {
    return this.paddingLeft;
  }
  
  public float getPaddingLeftPercent()
  {
    return this.paddingLeftPercent;
  }
  
  public float getPaddingRight()
  {
    return this.paddingRight;
  }
  
  public float getPaddingRightPercent()
  {
    return this.paddingRightPercent;
  }
  
  public float getPaddingTop()
  {
    return this.paddingTop;
  }
  
  public float getPaddingTopPercent()
  {
    return this.paddingTopPercent;
  }
  
  public PositionType getPositionType()
  {
    return this.positionType;
  }
  
  public float getRight()
  {
    return this.right;
  }
  
  public float getRightPercent()
  {
    return this.rightPercent;
  }
  
  public String getTestId()
  {
    return this.testId;
  }
  
  public float getTop()
  {
    return this.top;
  }
  
  public float getTopPercent()
  {
    return this.topPercent;
  }
  
  public int getVisibility()
  {
    return this.visibility;
  }
  
  public float getWidth()
  {
    AppMethodBeat.i(19334);
    if (isUndefined(this.width))
    {
      f = MMKViewUtil.pxToDp(KindaContext.get(), this.yogaNode.getLayoutWidth());
      AppMethodBeat.o(19334);
      return f;
    }
    float f = this.width;
    AppMethodBeat.o(19334);
    return f;
  }
  
  public float getWidthPercent()
  {
    return this.widthPercent;
  }
  
  public YogaNode node()
  {
    return this.yogaNode;
  }
  
  public void setAlignContent(Align paramAlign)
  {
    AppMethodBeat.i(19357);
    this.alignContent = paramAlign;
    node().setAlignContent(ViewStyleMapper.mapYGAlign(paramAlign));
    if (this.iFlexBoxChange != null) {
      this.iFlexBoxChange.onChange();
    }
    AppMethodBeat.o(19357);
  }
  
  public void setAlignItems(Align paramAlign)
  {
    AppMethodBeat.i(19356);
    this.alignItems = paramAlign;
    node().setAlignItems(ViewStyleMapper.mapYGAlign(paramAlign));
    if (this.iFlexBoxChange != null) {
      this.iFlexBoxChange.onChange();
    }
    AppMethodBeat.o(19356);
  }
  
  public void setAlignSelf(Align paramAlign)
  {
    AppMethodBeat.i(19339);
    this.alignSelf = paramAlign;
    node().setAlignSelf(ViewStyleMapper.mapYGAlign(paramAlign));
    if (this.iFlexBoxChange != null) {
      this.iFlexBoxChange.onChange();
    }
    AppMethodBeat.o(19339);
  }
  
  public void setAspectRatio(float paramFloat)
  {
    AppMethodBeat.i(19350);
    this.aspectRatio = paramFloat;
    if (this.aspectRatio > 0.0F)
    {
      node().setAspectRatio(this.aspectRatio);
      if (this.iFlexBoxChange != null) {
        this.iFlexBoxChange.onChange();
      }
    }
    AppMethodBeat.o(19350);
  }
  
  public void setBottom(float paramFloat)
  {
    AppMethodBeat.i(19345);
    this.bottom = paramFloat;
    paramFloat = MMKViewUtil.dpToPx(KindaContext.get(), paramFloat);
    node().setPosition(YogaEdge.BOTTOM, paramFloat);
    if (this.iFlexBoxChange != null) {
      this.iFlexBoxChange.onChange();
    }
    AppMethodBeat.o(19345);
  }
  
  public void setBottomPercent(float paramFloat)
  {
    AppMethodBeat.i(19369);
    this.bottomPercent = paramFloat;
    node().setPositionPercent(YogaEdge.BOTTOM, paramFloat);
    if (this.iFlexBoxChange != null) {
      this.iFlexBoxChange.onChange();
    }
    AppMethodBeat.o(19369);
  }
  
  public void setFlexBasis(float paramFloat)
  {
    AppMethodBeat.i(19340);
    this.flexBasis = paramFloat;
    if (this.flexBasis > 0.0F)
    {
      paramFloat = MMKViewUtil.dpToPx(KindaContext.get(), paramFloat);
      node().setWidth(paramFloat);
      if (this.iFlexBoxChange != null) {
        this.iFlexBoxChange.onChange();
      }
    }
    AppMethodBeat.o(19340);
  }
  
  public void setFlexDirection(FlexDirection paramFlexDirection)
  {
    AppMethodBeat.i(19353);
    this.flexDirection = paramFlexDirection;
    node().setFlexDirection(ViewStyleMapper.mapFlexDirection(paramFlexDirection));
    if (this.iFlexBoxChange != null) {
      this.iFlexBoxChange.onChange();
    }
    AppMethodBeat.o(19353);
  }
  
  public void setFlexGrow(float paramFloat)
  {
    AppMethodBeat.i(19351);
    this.flexGrow = paramFloat;
    if (this.flexGrow > 0.0F)
    {
      node().setFlexGrow(this.flexGrow);
      if (this.iFlexBoxChange != null) {
        this.iFlexBoxChange.onChange();
      }
    }
    AppMethodBeat.o(19351);
  }
  
  public void setFlexShrink(float paramFloat)
  {
    AppMethodBeat.i(19352);
    this.flexShrink = paramFloat;
    if (this.flexShrink > 0.0F)
    {
      node().setFlexShrink(this.flexShrink);
      if (this.iFlexBoxChange != null) {
        this.iFlexBoxChange.onChange();
      }
    }
    AppMethodBeat.o(19352);
  }
  
  public void setFlexWrap(Wrap paramWrap)
  {
    AppMethodBeat.i(19355);
    this.flexWrap = paramWrap;
    node().setWrap(ViewStyleMapper.mapYGWrap(paramWrap));
    if (this.iFlexBoxChange != null) {
      this.iFlexBoxChange.onChange();
    }
    AppMethodBeat.o(19355);
  }
  
  public void setHeight(float paramFloat)
  {
    AppMethodBeat.i(19335);
    this.height = paramFloat;
    if (paramFloat > 0.0F)
    {
      paramFloat = MMKViewUtil.dpToPx(KindaContext.get(), paramFloat);
      node().setHeight(paramFloat);
      if (this.iFlexBoxChange != null) {
        this.iFlexBoxChange.onChange();
      }
    }
    AppMethodBeat.o(19335);
  }
  
  public void setHeightPercent(float paramFloat)
  {
    AppMethodBeat.i(19338);
    this.heightPercent = paramFloat;
    if (paramFloat > 0.0F)
    {
      node().setHeightPercent(paramFloat);
      if (this.iFlexBoxChange != null) {
        this.iFlexBoxChange.onChange();
      }
    }
    AppMethodBeat.o(19338);
  }
  
  public void setJustifyContent(Justify paramJustify)
  {
    AppMethodBeat.i(19354);
    this.justifyContent = paramJustify;
    node().setJustifyContent(ViewStyleMapper.mapJustifyContent(paramJustify));
    if (this.iFlexBoxChange != null) {
      this.iFlexBoxChange.onChange();
    }
    AppMethodBeat.o(19354);
  }
  
  public void setLeft(float paramFloat)
  {
    AppMethodBeat.i(19342);
    this.left = paramFloat;
    paramFloat = MMKViewUtil.dpToPx(KindaContext.get(), paramFloat);
    node().setPosition(YogaEdge.LEFT, paramFloat);
    if (this.iFlexBoxChange != null) {
      this.iFlexBoxChange.onChange();
    }
    AppMethodBeat.o(19342);
  }
  
  public void setLeftPercent(float paramFloat)
  {
    AppMethodBeat.i(19366);
    this.leftPercent = paramFloat;
    node().setPositionPercent(YogaEdge.LEFT, paramFloat);
    if (this.iFlexBoxChange != null) {
      this.iFlexBoxChange.onChange();
    }
    AppMethodBeat.o(19366);
  }
  
  public void setMarginBottom(float paramFloat)
  {
    AppMethodBeat.i(19361);
    this.marginBottom = paramFloat;
    paramFloat = MMKViewUtil.dpToPx(KindaContext.get(), paramFloat);
    node().setMargin(YogaEdge.BOTTOM, paramFloat);
    if (this.iFlexBoxChange != null) {
      this.iFlexBoxChange.onChange();
    }
    AppMethodBeat.o(19361);
  }
  
  public void setMarginBottomPercent(float paramFloat)
  {
    AppMethodBeat.i(19373);
    this.marginBottomPercent = paramFloat;
    node().setMarginPercent(YogaEdge.BOTTOM, paramFloat);
    if (this.iFlexBoxChange != null) {
      this.iFlexBoxChange.onChange();
    }
    AppMethodBeat.o(19373);
  }
  
  public void setMarginLeft(float paramFloat)
  {
    AppMethodBeat.i(19358);
    this.marginLeft = paramFloat;
    paramFloat = MMKViewUtil.dpToPx(KindaContext.get(), paramFloat);
    node().setMargin(YogaEdge.LEFT, paramFloat);
    if (this.iFlexBoxChange != null) {
      this.iFlexBoxChange.onChange();
    }
    AppMethodBeat.o(19358);
  }
  
  public void setMarginLeftPercent(float paramFloat)
  {
    AppMethodBeat.i(19370);
    this.marginLeftPercent = paramFloat;
    node().setMarginPercent(YogaEdge.LEFT, paramFloat);
    if (this.iFlexBoxChange != null) {
      this.iFlexBoxChange.onChange();
    }
    AppMethodBeat.o(19370);
  }
  
  public void setMarginRight(float paramFloat)
  {
    AppMethodBeat.i(19360);
    this.marginRight = paramFloat;
    paramFloat = MMKViewUtil.dpToPx(KindaContext.get(), paramFloat);
    node().setMargin(YogaEdge.RIGHT, paramFloat);
    if (this.iFlexBoxChange != null) {
      this.iFlexBoxChange.onChange();
    }
    AppMethodBeat.o(19360);
  }
  
  public void setMarginRightPercent(float paramFloat)
  {
    AppMethodBeat.i(19372);
    this.marginRightPercent = paramFloat;
    node().setMarginPercent(YogaEdge.RIGHT, paramFloat);
    if (this.iFlexBoxChange != null) {
      this.iFlexBoxChange.onChange();
    }
    AppMethodBeat.o(19372);
  }
  
  public void setMarginTop(float paramFloat)
  {
    AppMethodBeat.i(19359);
    this.marginTop = paramFloat;
    paramFloat = MMKViewUtil.dpToPx(KindaContext.get(), paramFloat);
    node().setMargin(YogaEdge.TOP, paramFloat);
    if (this.iFlexBoxChange != null) {
      this.iFlexBoxChange.onChange();
    }
    AppMethodBeat.o(19359);
  }
  
  public void setMarginTopPercent(float paramFloat)
  {
    AppMethodBeat.i(19371);
    this.marginTopPercent = paramFloat;
    node().setMarginPercent(YogaEdge.TOP, paramFloat);
    if (this.iFlexBoxChange != null) {
      this.iFlexBoxChange.onChange();
    }
    AppMethodBeat.o(19371);
  }
  
  public void setMaxHeight(float paramFloat)
  {
    AppMethodBeat.i(19349);
    this.maxHeight = paramFloat;
    if (this.maxHeight > 0.0F)
    {
      paramFloat = MMKViewUtil.dpToPx(KindaContext.get(), paramFloat);
      node().setMaxHeight(paramFloat);
      if (this.iFlexBoxChange != null) {
        this.iFlexBoxChange.onChange();
      }
    }
    AppMethodBeat.o(19349);
  }
  
  public void setMaxWidth(float paramFloat)
  {
    AppMethodBeat.i(19347);
    this.maxWidth = paramFloat;
    if (this.maxWidth > 0.0F)
    {
      paramFloat = MMKViewUtil.dpToPx(KindaContext.get(), paramFloat);
      node().setMaxWidth(paramFloat);
      if (this.iFlexBoxChange != null) {
        this.iFlexBoxChange.onChange();
      }
    }
    AppMethodBeat.o(19347);
  }
  
  public void setMinHeight(float paramFloat)
  {
    AppMethodBeat.i(19348);
    this.minHeight = paramFloat;
    if (this.minHeight > 0.0F)
    {
      paramFloat = MMKViewUtil.dpToPx(KindaContext.get(), paramFloat);
      node().setMinHeight(paramFloat);
      if (this.iFlexBoxChange != null) {
        this.iFlexBoxChange.onChange();
      }
    }
    AppMethodBeat.o(19348);
  }
  
  public void setMinWidth(float paramFloat)
  {
    AppMethodBeat.i(19346);
    this.minWidth = paramFloat;
    if (this.minWidth > 0.0F)
    {
      paramFloat = MMKViewUtil.dpToPx(KindaContext.get(), paramFloat);
      node().setMinWidth(paramFloat);
      if (this.iFlexBoxChange != null) {
        this.iFlexBoxChange.onChange();
      }
    }
    AppMethodBeat.o(19346);
  }
  
  public void setPaddingBottom(float paramFloat)
  {
    AppMethodBeat.i(19365);
    this.paddingBottom = paramFloat;
    if (this.paddingBottom > 0.0F)
    {
      paramFloat = MMKViewUtil.dpToPx(KindaContext.get(), paramFloat);
      node().setPadding(YogaEdge.BOTTOM, paramFloat);
      if (this.iFlexBoxChange != null) {
        this.iFlexBoxChange.onChange();
      }
    }
    AppMethodBeat.o(19365);
  }
  
  public void setPaddingBottomPercent(float paramFloat)
  {
    AppMethodBeat.i(19377);
    this.paddingBottomPercent = paramFloat;
    if (this.paddingBottom > 0.0F)
    {
      node().setPadding(YogaEdge.BOTTOM, paramFloat);
      if (this.iFlexBoxChange != null) {
        this.iFlexBoxChange.onChange();
      }
    }
    AppMethodBeat.o(19377);
  }
  
  public void setPaddingLeft(float paramFloat)
  {
    AppMethodBeat.i(19362);
    this.paddingLeft = paramFloat;
    if (this.paddingLeft > 0.0F)
    {
      paramFloat = MMKViewUtil.dpToPx(KindaContext.get(), paramFloat);
      node().setPadding(YogaEdge.LEFT, paramFloat);
      if (this.iFlexBoxChange != null) {
        this.iFlexBoxChange.onChange();
      }
    }
    AppMethodBeat.o(19362);
  }
  
  public void setPaddingLeftPercent(float paramFloat)
  {
    AppMethodBeat.i(19374);
    this.paddingLeftPercent = paramFloat;
    if (this.paddingLeft > 0.0F)
    {
      node().setPaddingPercent(YogaEdge.LEFT, paramFloat);
      if (this.iFlexBoxChange != null) {
        this.iFlexBoxChange.onChange();
      }
    }
    AppMethodBeat.o(19374);
  }
  
  public void setPaddingRight(float paramFloat)
  {
    AppMethodBeat.i(19364);
    this.paddingRight = paramFloat;
    if (this.paddingRight > 0.0F)
    {
      paramFloat = MMKViewUtil.dpToPx(KindaContext.get(), paramFloat);
      node().setPadding(YogaEdge.RIGHT, paramFloat);
      if (this.iFlexBoxChange != null) {
        this.iFlexBoxChange.onChange();
      }
    }
    AppMethodBeat.o(19364);
  }
  
  public void setPaddingRightPercent(float paramFloat)
  {
    AppMethodBeat.i(19376);
    this.paddingRightPercent = paramFloat;
    if (this.paddingRight > 0.0F)
    {
      node().setPadding(YogaEdge.RIGHT, paramFloat);
      if (this.iFlexBoxChange != null) {
        this.iFlexBoxChange.onChange();
      }
    }
    AppMethodBeat.o(19376);
  }
  
  public void setPaddingTop(float paramFloat)
  {
    AppMethodBeat.i(19363);
    this.paddingTop = paramFloat;
    if (this.paddingTop > 0.0F)
    {
      paramFloat = MMKViewUtil.dpToPx(KindaContext.get(), paramFloat);
      node().setPadding(YogaEdge.TOP, paramFloat);
      if (this.iFlexBoxChange != null) {
        this.iFlexBoxChange.onChange();
      }
    }
    AppMethodBeat.o(19363);
  }
  
  public void setPaddingTopPercent(float paramFloat)
  {
    AppMethodBeat.i(19375);
    this.paddingTopPercent = paramFloat;
    if (this.paddingTop > 0.0F)
    {
      node().setPaddingPercent(YogaEdge.TOP, paramFloat);
      if (this.iFlexBoxChange != null) {
        this.iFlexBoxChange.onChange();
      }
    }
    AppMethodBeat.o(19375);
  }
  
  public void setPositionType(PositionType paramPositionType)
  {
    AppMethodBeat.i(19341);
    this.positionType = paramPositionType;
    node().setPositionType(ViewStyleMapper.mapPositionType(paramPositionType));
    if (this.iFlexBoxChange != null) {
      this.iFlexBoxChange.onChange();
    }
    AppMethodBeat.o(19341);
  }
  
  public void setRight(float paramFloat)
  {
    AppMethodBeat.i(19344);
    this.right = paramFloat;
    paramFloat = MMKViewUtil.dpToPx(KindaContext.get(), paramFloat);
    node().setPosition(YogaEdge.RIGHT, paramFloat);
    if (this.iFlexBoxChange != null) {
      this.iFlexBoxChange.onChange();
    }
    AppMethodBeat.o(19344);
  }
  
  public void setRightPercent(float paramFloat)
  {
    AppMethodBeat.i(19368);
    this.rightPercent = paramFloat;
    node().setPositionPercent(YogaEdge.RIGHT, paramFloat);
    if (this.iFlexBoxChange != null) {
      this.iFlexBoxChange.onChange();
    }
    AppMethodBeat.o(19368);
  }
  
  public void setTestId(String paramString)
  {
    this.testId = paramString;
  }
  
  public void setTop(float paramFloat)
  {
    AppMethodBeat.i(19343);
    this.top = paramFloat;
    paramFloat = MMKViewUtil.dpToPx(KindaContext.get(), paramFloat);
    node().setPosition(YogaEdge.TOP, paramFloat);
    if (this.iFlexBoxChange != null) {
      this.iFlexBoxChange.onChange();
    }
    AppMethodBeat.o(19343);
  }
  
  public void setTopPercent(float paramFloat)
  {
    AppMethodBeat.i(19367);
    this.topPercent = paramFloat;
    node().setPositionPercent(YogaEdge.TOP, paramFloat);
    if (this.iFlexBoxChange != null) {
      this.iFlexBoxChange.onChange();
    }
    AppMethodBeat.o(19367);
  }
  
  public void setVisibility(int paramInt)
  {
    this.visibility = paramInt;
  }
  
  public void setWidth(float paramFloat)
  {
    AppMethodBeat.i(19333);
    this.width = paramFloat;
    if (paramFloat > 0.0F)
    {
      paramFloat = MMKViewUtil.dpToPx(KindaContext.get(), paramFloat);
      node().setWidth(paramFloat);
      if (this.iFlexBoxChange != null) {
        this.iFlexBoxChange.onChange();
      }
    }
    AppMethodBeat.o(19333);
  }
  
  public void setWidthPercent(float paramFloat)
  {
    AppMethodBeat.i(19337);
    this.widthPercent = paramFloat;
    if (paramFloat > 0.0F)
    {
      node().setWidthPercent(paramFloat);
      if (this.iFlexBoxChange != null) {
        this.iFlexBoxChange.onChange();
      }
    }
    AppMethodBeat.o(19337);
  }
  
  public void setYogaNode(YogaNode paramYogaNode)
  {
    this.yogaNode = paramYogaNode;
  }
  
  public static abstract interface IFlexBoxChange
  {
    public abstract void onChange();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.tools.FlexBoxAttr
 * JD-Core Version:    0.7.0.1
 */
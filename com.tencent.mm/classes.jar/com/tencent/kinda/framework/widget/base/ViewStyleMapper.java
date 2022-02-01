package com.tencent.kinda.framework.widget.base;

import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaFlexDirection;
import com.facebook.yoga.YogaJustify;
import com.facebook.yoga.YogaPositionType;
import com.facebook.yoga.YogaWrap;
import com.tencent.kinda.gen.Align;
import com.tencent.kinda.gen.FlexDirection;
import com.tencent.kinda.gen.Justify;
import com.tencent.kinda.gen.PositionType;
import com.tencent.kinda.gen.Wrap;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ViewStyleMapper
{
  public static YogaFlexDirection mapFlexDirection(FlexDirection paramFlexDirection)
  {
    AppMethodBeat.i(19303);
    switch (1.$SwitchMap$com$tencent$kinda$gen$FlexDirection[paramFlexDirection.ordinal()])
    {
    default: 
      paramFlexDirection = YogaFlexDirection.COLUMN;
      AppMethodBeat.o(19303);
      return paramFlexDirection;
    case 1: 
      paramFlexDirection = YogaFlexDirection.COLUMN;
      AppMethodBeat.o(19303);
      return paramFlexDirection;
    case 2: 
      paramFlexDirection = YogaFlexDirection.COLUMN_REVERSE;
      AppMethodBeat.o(19303);
      return paramFlexDirection;
    case 3: 
      paramFlexDirection = YogaFlexDirection.ROW;
      AppMethodBeat.o(19303);
      return paramFlexDirection;
    }
    paramFlexDirection = YogaFlexDirection.ROW_REVERSE;
    AppMethodBeat.o(19303);
    return paramFlexDirection;
  }
  
  public static YogaJustify mapJustifyContent(Justify paramJustify)
  {
    AppMethodBeat.i(19304);
    switch (1.$SwitchMap$com$tencent$kinda$gen$Justify[paramJustify.ordinal()])
    {
    default: 
      paramJustify = YogaJustify.FLEX_START;
      AppMethodBeat.o(19304);
      return paramJustify;
    case 1: 
      paramJustify = YogaJustify.CENTER;
      AppMethodBeat.o(19304);
      return paramJustify;
    case 2: 
      paramJustify = YogaJustify.FLEX_END;
      AppMethodBeat.o(19304);
      return paramJustify;
    case 3: 
      paramJustify = YogaJustify.FLEX_START;
      AppMethodBeat.o(19304);
      return paramJustify;
    case 4: 
      paramJustify = YogaJustify.SPACE_AROUND;
      AppMethodBeat.o(19304);
      return paramJustify;
    }
    paramJustify = YogaJustify.SPACE_BETWEEN;
    AppMethodBeat.o(19304);
    return paramJustify;
  }
  
  public static YogaPositionType mapPositionType(PositionType paramPositionType)
  {
    AppMethodBeat.i(19302);
    switch (1.$SwitchMap$com$tencent$kinda$gen$PositionType[paramPositionType.ordinal()])
    {
    default: 
      paramPositionType = YogaPositionType.RELATIVE;
      AppMethodBeat.o(19302);
      return paramPositionType;
    case 1: 
      paramPositionType = YogaPositionType.ABSOLUTE;
      AppMethodBeat.o(19302);
      return paramPositionType;
    }
    paramPositionType = YogaPositionType.RELATIVE;
    AppMethodBeat.o(19302);
    return paramPositionType;
  }
  
  public static YogaAlign mapYGAlign(Align paramAlign)
  {
    AppMethodBeat.i(19300);
    switch (1.$SwitchMap$com$tencent$kinda$gen$Align[paramAlign.ordinal()])
    {
    default: 
      paramAlign = YogaAlign.STRETCH;
      AppMethodBeat.o(19300);
      return paramAlign;
    case 1: 
      paramAlign = YogaAlign.AUTO;
      AppMethodBeat.o(19300);
      return paramAlign;
    case 2: 
      paramAlign = YogaAlign.BASELINE;
      AppMethodBeat.o(19300);
      return paramAlign;
    case 3: 
      paramAlign = YogaAlign.CENTER;
      AppMethodBeat.o(19300);
      return paramAlign;
    case 4: 
      paramAlign = YogaAlign.FLEX_END;
      AppMethodBeat.o(19300);
      return paramAlign;
    case 5: 
      paramAlign = YogaAlign.FLEX_START;
      AppMethodBeat.o(19300);
      return paramAlign;
    case 6: 
      paramAlign = YogaAlign.SPACE_AROUND;
      AppMethodBeat.o(19300);
      return paramAlign;
    case 7: 
      paramAlign = YogaAlign.SPACE_BETWEEN;
      AppMethodBeat.o(19300);
      return paramAlign;
    }
    paramAlign = YogaAlign.STRETCH;
    AppMethodBeat.o(19300);
    return paramAlign;
  }
  
  public static YogaWrap mapYGWrap(Wrap paramWrap)
  {
    AppMethodBeat.i(19301);
    switch (1.$SwitchMap$com$tencent$kinda$gen$Wrap[paramWrap.ordinal()])
    {
    default: 
      paramWrap = YogaWrap.NO_WRAP;
      AppMethodBeat.o(19301);
      return paramWrap;
    case 1: 
      paramWrap = YogaWrap.NO_WRAP;
      AppMethodBeat.o(19301);
      return paramWrap;
    case 2: 
      paramWrap = YogaWrap.WRAP;
      AppMethodBeat.o(19301);
      return paramWrap;
    }
    paramWrap = YogaWrap.WRAP_REVERSE;
    AppMethodBeat.o(19301);
    return paramWrap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.ViewStyleMapper
 * JD-Core Version:    0.7.0.1
 */
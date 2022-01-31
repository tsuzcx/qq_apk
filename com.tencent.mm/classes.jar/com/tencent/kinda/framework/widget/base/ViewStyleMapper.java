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
    AppMethodBeat.i(145139);
    switch (ViewStyleMapper.1.$SwitchMap$com$tencent$kinda$gen$FlexDirection[paramFlexDirection.ordinal()])
    {
    default: 
      paramFlexDirection = YogaFlexDirection.COLUMN;
      AppMethodBeat.o(145139);
      return paramFlexDirection;
    case 1: 
      paramFlexDirection = YogaFlexDirection.COLUMN;
      AppMethodBeat.o(145139);
      return paramFlexDirection;
    case 2: 
      paramFlexDirection = YogaFlexDirection.COLUMN_REVERSE;
      AppMethodBeat.o(145139);
      return paramFlexDirection;
    case 3: 
      paramFlexDirection = YogaFlexDirection.ROW;
      AppMethodBeat.o(145139);
      return paramFlexDirection;
    }
    paramFlexDirection = YogaFlexDirection.ROW_REVERSE;
    AppMethodBeat.o(145139);
    return paramFlexDirection;
  }
  
  public static YogaJustify mapJustifyContent(Justify paramJustify)
  {
    AppMethodBeat.i(145140);
    switch (ViewStyleMapper.1.$SwitchMap$com$tencent$kinda$gen$Justify[paramJustify.ordinal()])
    {
    default: 
      paramJustify = YogaJustify.FLEX_START;
      AppMethodBeat.o(145140);
      return paramJustify;
    case 1: 
      paramJustify = YogaJustify.CENTER;
      AppMethodBeat.o(145140);
      return paramJustify;
    case 2: 
      paramJustify = YogaJustify.FLEX_END;
      AppMethodBeat.o(145140);
      return paramJustify;
    case 3: 
      paramJustify = YogaJustify.FLEX_START;
      AppMethodBeat.o(145140);
      return paramJustify;
    case 4: 
      paramJustify = YogaJustify.SPACE_AROUND;
      AppMethodBeat.o(145140);
      return paramJustify;
    }
    paramJustify = YogaJustify.SPACE_BETWEEN;
    AppMethodBeat.o(145140);
    return paramJustify;
  }
  
  public static YogaPositionType mapPositionType(PositionType paramPositionType)
  {
    AppMethodBeat.i(145138);
    switch (ViewStyleMapper.1.$SwitchMap$com$tencent$kinda$gen$PositionType[paramPositionType.ordinal()])
    {
    default: 
      paramPositionType = YogaPositionType.RELATIVE;
      AppMethodBeat.o(145138);
      return paramPositionType;
    case 1: 
      paramPositionType = YogaPositionType.ABSOLUTE;
      AppMethodBeat.o(145138);
      return paramPositionType;
    }
    paramPositionType = YogaPositionType.RELATIVE;
    AppMethodBeat.o(145138);
    return paramPositionType;
  }
  
  public static YogaAlign mapYGAlign(Align paramAlign)
  {
    AppMethodBeat.i(145136);
    switch (ViewStyleMapper.1.$SwitchMap$com$tencent$kinda$gen$Align[paramAlign.ordinal()])
    {
    default: 
      paramAlign = YogaAlign.STRETCH;
      AppMethodBeat.o(145136);
      return paramAlign;
    case 1: 
      paramAlign = YogaAlign.AUTO;
      AppMethodBeat.o(145136);
      return paramAlign;
    case 2: 
      paramAlign = YogaAlign.BASELINE;
      AppMethodBeat.o(145136);
      return paramAlign;
    case 3: 
      paramAlign = YogaAlign.CENTER;
      AppMethodBeat.o(145136);
      return paramAlign;
    case 4: 
      paramAlign = YogaAlign.FLEX_END;
      AppMethodBeat.o(145136);
      return paramAlign;
    case 5: 
      paramAlign = YogaAlign.FLEX_START;
      AppMethodBeat.o(145136);
      return paramAlign;
    case 6: 
      paramAlign = YogaAlign.SPACE_AROUND;
      AppMethodBeat.o(145136);
      return paramAlign;
    case 7: 
      paramAlign = YogaAlign.SPACE_BETWEEN;
      AppMethodBeat.o(145136);
      return paramAlign;
    }
    paramAlign = YogaAlign.STRETCH;
    AppMethodBeat.o(145136);
    return paramAlign;
  }
  
  public static YogaWrap mapYGWrap(Wrap paramWrap)
  {
    AppMethodBeat.i(145137);
    switch (ViewStyleMapper.1.$SwitchMap$com$tencent$kinda$gen$Wrap[paramWrap.ordinal()])
    {
    default: 
      paramWrap = YogaWrap.NO_WRAP;
      AppMethodBeat.o(145137);
      return paramWrap;
    case 1: 
      paramWrap = YogaWrap.NO_WRAP;
      AppMethodBeat.o(145137);
      return paramWrap;
    case 2: 
      paramWrap = YogaWrap.WRAP;
      AppMethodBeat.o(145137);
      return paramWrap;
    }
    paramWrap = YogaWrap.WRAP_REVERSE;
    AppMethodBeat.o(145137);
    return paramWrap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.base.ViewStyleMapper
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.kinda.framework.widget.tools;

import android.util.Pair;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ColorCompatUtil
{
  public static long getDarkModeColor(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(162115);
    if (paramLong1 == Long.parseLong("ff000000", 16)) {
      paramLong2 = Long.parseLong("ffffffff", 16);
    }
    for (;;)
    {
      AppMethodBeat.o(162115);
      return paramLong2;
      if ((paramLong1 == Long.parseLong("ff868686", 16)) || (paramLong1 == Long.parseLong("868686", 16))) {
        paramLong2 = Long.parseLong("ff000000", 16);
      } else if ((paramLong1 == Long.parseLong("FF576B95", 16)) || (paramLong1 == Long.parseLong("576B95", 16))) {
        paramLong2 = Long.parseLong("ff7D90A9", 16);
      } else if ((paramLong1 == Long.parseLong("ff1aad19", 16)) || (paramLong1 == Long.parseLong("1aad19", 16))) {
        paramLong2 = Long.parseLong("ff1aad19", 16);
      } else if ((paramLong1 == Long.parseLong("ff353535", 16)) || (paramLong1 == Long.parseLong("353535", 16))) {
        paramLong2 = Long.parseLong("CCFFFFFF", 16);
      } else if ((paramLong1 == Long.parseLong("ff888888", 16)) || (paramLong1 == Long.parseLong("888888", 16))) {
        paramLong2 = Long.parseLong("80FFFFFF", 16);
      } else if ((paramLong1 == Long.parseLong("fffa962a", 16)) || (paramLong1 == Long.parseLong("fa962a", 16))) {
        paramLong2 = Long.parseLong("fffa962a", 16);
      } else if ((paramLong1 == Long.parseLong("ff1abb09", 16)) || (paramLong1 == Long.parseLong("1abb09", 16))) {
        paramLong2 = Long.parseLong("ff1aad19", 16);
      } else if ((paramLong1 == Long.parseLong("ff6e726e", 16)) || (paramLong1 == Long.parseLong("6e726e", 16))) {
        paramLong2 = Long.parseLong("80FFFFFF", 16);
      } else if ((paramLong1 == Long.parseLong("FFFA9D3B", 16)) || (paramLong1 == Long.parseLong("FA9D3B", 16))) {
        paramLong2 = Long.parseLong("ffFF972A", 16);
      } else if ((paramLong1 == Long.parseLong("ffb2b2b2", 16)) || (paramLong1 == Long.parseLong("b2b2b2", 16))) {
        paramLong2 = Long.parseLong("ff6B6B6B", 16);
      } else if ((paramLong1 == Long.parseLong("fff5a623", 16)) || (paramLong1 == Long.parseLong("f5a623", 16))) {
        paramLong2 = Long.parseLong("fff5a623", 16);
      } else if ((paramLong1 == Long.parseLong("ff808080", 16)) || (paramLong1 == Long.parseLong("808080", 16))) {
        paramLong2 = Long.parseLong("80FFFFFF", 16);
      } else if ((paramLong1 == Long.parseLong("ff7b7b7b", 16)) || (paramLong1 == Long.parseLong("7b7b7b", 16))) {
        paramLong2 = Long.parseLong("80FFFFFF", 16);
      } else if ((paramLong1 == Long.parseLong("ff8e8e8e", 16)) || (paramLong1 == Long.parseLong("8e8e8e", 16))) {
        paramLong2 = Long.parseLong("80FFFFFF", 16);
      } else if ((paramLong1 == Long.parseLong("ff05b502", 16)) || (paramLong1 == Long.parseLong("05b502", 16))) {
        paramLong2 = Long.parseLong("ff05b502", 16);
      } else if (paramLong1 == Long.parseLong("E6F2F2F2", 16)) {
        paramLong2 = Long.parseLong("E6F2F2F2", 16);
      } else if ((paramLong1 == Long.parseLong("ff07C160", 16)) || (paramLong1 == Long.parseLong("07C160", 16))) {
        paramLong2 = Long.parseLong("ff07C160", 16);
      } else if ((paramLong1 == Long.parseLong("ffFFFFFF", 16)) || (paramLong1 == Long.parseLong("FFFFFF", 16))) {
        paramLong2 = Long.parseLong("ff232323", 16);
      } else if ((paramLong1 == Long.parseLong("ff949494", 16)) || (paramLong1 == Long.parseLong("949494", 16))) {
        paramLong2 = Long.parseLong("80FFFFFF", 16);
      } else if ((paramLong1 == Long.parseLong("ffF7F7F7", 16)) || (paramLong1 == Long.parseLong("F7F7F7", 16))) {
        paramLong2 = Long.parseLong("ff2F2F2F", 16);
      } else if ((paramLong1 == Long.parseLong("ffEDEDED", 16)) || (paramLong1 == Long.parseLong("EDEDED", 16))) {
        paramLong2 = Long.parseLong("ff191919", 16);
      } else if ((paramLong1 == Long.parseLong("ff4C4C4C", 16)) || (paramLong1 == Long.parseLong("4C4C4C", 16))) {
        paramLong2 = Long.parseLong("ff606060", 16);
      } else if (paramLong1 == Long.parseLong("4C000000", 16)) {
        paramLong2 = Long.parseLong("4DFFFFFF", 16);
      } else if (paramLong1 == -1L) {
        paramLong2 = Long.parseLong("ffFFFFFF", 16);
      }
    }
  }
  
  public static Pair<Boolean, Long> getDarkModeColorMMKButtonText(long paramLong)
  {
    AppMethodBeat.i(19313);
    if ((paramLong == Long.parseLong("ffFFFFFF", 16)) || (paramLong == Long.parseLong("FFFFFF", 16))) {}
    for (Pair localPair = new Pair(Boolean.TRUE, Long.valueOf(Long.parseLong("CCFFFFFF", 16)));; localPair = new Pair(Boolean.FALSE, Long.valueOf(0L)))
    {
      AppMethodBeat.o(19313);
      return localPair;
    }
  }
  
  public static Pair<Boolean, Long> getDarkModeColorMMKLabelViewText(long paramLong)
  {
    AppMethodBeat.i(19315);
    Pair localPair;
    if (paramLong == Long.parseLong("ff000000", 16)) {
      localPair = new Pair(Boolean.TRUE, Long.valueOf(Long.parseLong("CCFFFFFF", 16)));
    }
    for (;;)
    {
      AppMethodBeat.o(19315);
      return localPair;
      if ((paramLong == Long.parseLong("ffB2B2B2", 16)) || (paramLong == Long.parseLong("B2B2B2", 16))) {
        localPair = new Pair(Boolean.TRUE, Long.valueOf(Long.parseLong("80000000", 16)));
      } else {
        localPair = new Pair(Boolean.FALSE, Long.valueOf(0L));
      }
    }
  }
  
  public static Pair<Boolean, Long> getDarkModeColorMMKRichLabelView(long paramLong)
  {
    AppMethodBeat.i(19314);
    Pair localPair;
    if (paramLong == Long.parseLong("ff000000", 16)) {
      localPair = new Pair(Boolean.TRUE, Long.valueOf(Long.parseLong("CCFFFFFF", 16)));
    }
    for (;;)
    {
      AppMethodBeat.o(19314);
      return localPair;
      if ((paramLong == Long.parseLong("ff868686", 16)) || (paramLong == Long.parseLong("868686", 16))) {
        localPair = new Pair(Boolean.TRUE, Long.valueOf(Long.parseLong("80FFFFFF", 16)));
      } else if ((paramLong == Long.parseLong("ffB2B2B2", 16)) || (paramLong == Long.parseLong("B2B2B2", 16))) {
        localPair = new Pair(Boolean.TRUE, Long.valueOf(Long.parseLong("80FFFFFF", 16)));
      } else if (paramLong == Long.parseLong("4C000000", 16)) {
        localPair = new Pair(Boolean.TRUE, Long.valueOf(Long.parseLong("4DFFFFFF", 16)));
      } else if (paramLong == Long.parseLong("7f000000", 16)) {
        localPair = new Pair(Boolean.TRUE, Long.valueOf(Long.parseLong("80FFFFFF", 16)));
      } else {
        localPair = new Pair(Boolean.FALSE, Long.valueOf(0L));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.framework.widget.tools.ColorCompatUtil
 * JD-Core Version:    0.7.0.1
 */
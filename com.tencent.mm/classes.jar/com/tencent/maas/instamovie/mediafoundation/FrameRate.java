package com.tencent.maas.instamovie.mediafoundation;

import com.tencent.maas.model.time.MJTime;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class FrameRate
{
  public static final FrameRate FrameRate120;
  public static final FrameRate FrameRate15;
  public static final FrameRate FrameRate23_976;
  public static final FrameRate FrameRate24;
  public static final FrameRate FrameRate240;
  public static final FrameRate FrameRate25;
  public static final FrameRate FrameRate29_97;
  public static final FrameRate FrameRate30;
  public static final FrameRate FrameRate48;
  public static final FrameRate FrameRate50;
  public static final FrameRate FrameRate60;
  private MJTime frameDuration;
  private float numericValue;
  private FrameRateType type;
  
  static
  {
    AppMethodBeat.i(216902);
    FrameRate15 = fromType(FrameRateType.FRAMERATE_15);
    FrameRate23_976 = fromType(FrameRateType.FRAMERATE_23_976);
    FrameRate24 = fromType(FrameRateType.FRMAERATE_24);
    FrameRate25 = fromType(FrameRateType.FRMAERATE_25);
    FrameRate29_97 = fromType(FrameRateType.FRAMERATE_29_97);
    FrameRate30 = fromType(FrameRateType.FRAMERATE_30);
    FrameRate48 = fromType(FrameRateType.FRAMERATE_48);
    FrameRate50 = fromType(FrameRateType.FRAMERATE_50);
    FrameRate60 = fromType(FrameRateType.FRAMERATE_60);
    FrameRate120 = fromType(FrameRateType.FRMAERATE_120);
    FrameRate240 = fromType(FrameRateType.FRAMERATE_240);
    AppMethodBeat.o(216902);
  }
  
  private FrameRate(FrameRateType paramFrameRateType)
  {
    this.type = paramFrameRateType;
    this.numericValue = (0.0F / 0.0F);
  }
  
  public static FrameRate fromType(FrameRateType paramFrameRateType)
  {
    AppMethodBeat.i(216885);
    paramFrameRateType = new FrameRate(paramFrameRateType);
    AppMethodBeat.o(216885);
    return paramFrameRateType;
  }
  
  private float getNumericValue()
  {
    return this.numericValue;
  }
  
  private int getTypeId()
  {
    AppMethodBeat.i(216893);
    int i = this.type.getTypeId();
    AppMethodBeat.o(216893);
    return i;
  }
  
  public FrameRateType getType()
  {
    return this.type;
  }
  
  public static enum FrameRateType
  {
    private int typeId;
    
    static
    {
      AppMethodBeat.i(216898);
      FRAMERATE_15 = new FrameRateType("FRAMERATE_15", 0, 0);
      FRAMERATE_23_976 = new FrameRateType("FRAMERATE_23_976", 1, 1);
      FRMAERATE_24 = new FrameRateType("FRMAERATE_24", 2, 2);
      FRMAERATE_25 = new FrameRateType("FRMAERATE_25", 3, 3);
      FRAMERATE_29_97 = new FrameRateType("FRAMERATE_29_97", 4, 4);
      FRAMERATE_30 = new FrameRateType("FRAMERATE_30", 5, 5);
      FRAMERATE_48 = new FrameRateType("FRAMERATE_48", 6, 6);
      FRAMERATE_50 = new FrameRateType("FRAMERATE_50", 7, 7);
      FRAMERATE_60 = new FrameRateType("FRAMERATE_60", 8, 8);
      FRMAERATE_120 = new FrameRateType("FRMAERATE_120", 9, 9);
      FRAMERATE_240 = new FrameRateType("FRAMERATE_240", 10, 10);
      $VALUES = new FrameRateType[] { FRAMERATE_15, FRAMERATE_23_976, FRMAERATE_24, FRMAERATE_25, FRAMERATE_29_97, FRAMERATE_30, FRAMERATE_48, FRAMERATE_50, FRAMERATE_60, FRMAERATE_120, FRAMERATE_240 };
      AppMethodBeat.o(216898);
    }
    
    private FrameRateType(int paramInt)
    {
      this.typeId = paramInt;
    }
    
    public final int getTypeId()
    {
      return this.typeId;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.instamovie.mediafoundation.FrameRate
 * JD-Core Version:    0.7.0.1
 */
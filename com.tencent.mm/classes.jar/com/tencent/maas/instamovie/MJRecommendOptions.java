package com.tencent.maas.instamovie;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class MJRecommendOptions
{
  public static final String SCENE_FINDER = "TemplateRecommendv2";
  public static final String SCENE_MOMENT = "MomentsTemplateRecommendv2";
  private Mode mode;
  private String scene;
  
  public MJRecommendOptions(Mode paramMode, String paramString)
  {
    this.mode = paramMode;
    this.scene = paramString;
  }
  
  public int getMode()
  {
    AppMethodBeat.i(216909);
    int i = this.mode.getValue();
    AppMethodBeat.o(216909);
    return i;
  }
  
  public String getScene()
  {
    return this.scene;
  }
  
  public static enum Mode
  {
    private final int value;
    
    static
    {
      AppMethodBeat.i(216918);
      None = new Mode("None", 0, 0);
      Foreground = new Mode("Foreground", 1, 1);
      Background = new Mode("Background", 2, 2);
      $VALUES = new Mode[] { None, Foreground, Background };
      AppMethodBeat.o(216918);
    }
    
    private Mode(int paramInt)
    {
      this.value = paramInt;
    }
    
    public final int getValue()
    {
      return this.value;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.instamovie.MJRecommendOptions
 * JD-Core Version:    0.7.0.1
 */
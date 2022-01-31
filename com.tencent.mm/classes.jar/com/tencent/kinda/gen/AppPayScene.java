package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public enum AppPayScene
{
  static
  {
    AppMethodBeat.i(141157);
    APP = new AppPayScene("APP", 0);
    WAP = new AppPayScene("WAP", 1);
    $VALUES = new AppPayScene[] { APP, WAP };
    AppMethodBeat.o(141157);
  }
  
  private AppPayScene() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.gen.AppPayScene
 * JD-Core Version:    0.7.0.1
 */
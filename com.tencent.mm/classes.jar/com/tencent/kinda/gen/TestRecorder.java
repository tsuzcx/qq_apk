package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;

public final class TestRecorder
{
  public ArrayList<TouchEvent> mValues;
  public float mX;
  
  public TestRecorder() {}
  
  public TestRecorder(float paramFloat, ArrayList<TouchEvent> paramArrayList)
  {
    this.mX = paramFloat;
    this.mValues = paramArrayList;
  }
  
  public final ArrayList<TouchEvent> getValues()
  {
    return this.mValues;
  }
  
  public final float getX()
  {
    return this.mX;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(141469);
    String str = "TestRecorder{mX=" + this.mX + ",mValues=" + this.mValues + "}";
    AppMethodBeat.o(141469);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.kinda.gen.TestRecorder
 * JD-Core Version:    0.7.0.1
 */
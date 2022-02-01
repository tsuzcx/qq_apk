package com.tencent.kinda.gen;

import com.tencent.matrix.trace.core.AppMethodBeat;

public final class TouchEvent
{
  public TouchAction mEvent;
  public float mX;
  public float mY;
  
  public TouchEvent() {}
  
  public TouchEvent(float paramFloat1, float paramFloat2, TouchAction paramTouchAction)
  {
    this.mX = paramFloat1;
    this.mY = paramFloat2;
    this.mEvent = paramTouchAction;
  }
  
  public final TouchAction getEvent()
  {
    return this.mEvent;
  }
  
  public final float getX()
  {
    return this.mX;
  }
  
  public final float getY()
  {
    return this.mY;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(135996);
    String str = "TouchEvent{mX=" + this.mX + ",mY=" + this.mY + ",mEvent=" + this.mEvent + "}";
    AppMethodBeat.o(135996);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.gen.TouchEvent
 * JD-Core Version:    0.7.0.1
 */
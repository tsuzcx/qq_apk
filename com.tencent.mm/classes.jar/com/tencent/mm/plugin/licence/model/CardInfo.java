package com.tencent.mm.plugin.licence.model;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class CardInfo
{
  public byte[] bitmapData;
  public int bitmapLen;
  public int height;
  public int width;
  
  public CardInfo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40585);
    this.width = 0;
    this.height = 0;
    this.bitmapLen = 0;
    this.bitmapData = new byte[(int)(0.8D * paramInt1) * (int)(0.52D * paramInt1) * 3 + 54];
    AppMethodBeat.o(40585);
  }
  
  public byte[] getData()
  {
    return this.bitmapData;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getSize()
  {
    return this.bitmapLen;
  }
  
  public int getWidth()
  {
    return this.width;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.licence.model.CardInfo
 * JD-Core Version:    0.7.0.1
 */
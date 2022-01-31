package com.tencent.mm.plugin.licence.model;

public class CardInfo
{
  public byte[] bitmapData;
  public int bitmapLen = 0;
  public int height = 0;
  public int width = 0;
  
  public CardInfo(int paramInt1, int paramInt2)
  {
    this.bitmapData = new byte[(int)(0.8D * paramInt1) * (int)(0.52D * paramInt1) * 3 + 54];
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.licence.model.CardInfo
 * JD-Core Version:    0.7.0.1
 */
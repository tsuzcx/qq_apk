package com.tencent.bankcardrecog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tenpay.ndk.Encrypt;

public class BankCardInfo
{
  public byte[] bitmapData;
  public int bitmapLen;
  private String cardNum;
  private int cardNumLen;
  public int height;
  private int[] rectX;
  private int[] rectY;
  public int width;
  
  public BankCardInfo(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(63285);
    this.cardNumLen = 0;
    this.cardNum = "";
    this.rectY = new int[20];
    this.rectX = new int[20];
    this.width = 0;
    this.height = 0;
    this.bitmapLen = 0;
    this.bitmapData = new byte[(int)(0.8D * paramInt1) * (int)(0.52D * paramInt1) * 3 + 54];
    AppMethodBeat.o(63285);
  }
  
  public String getCardNum()
  {
    AppMethodBeat.i(63286);
    Object localObject = new Encrypt();
    localObject = ((Encrypt)localObject).desedeEncode(this.cardNum, ((Encrypt)localObject).getRandomKey());
    AppMethodBeat.o(63286);
    return localObject;
  }
  
  public int getCardNumLen()
  {
    return this.cardNumLen;
  }
  
  public int[] getRectX()
  {
    return this.rectX;
  }
  
  public int[] getRectY()
  {
    return this.rectY;
  }
  
  public void setCardNum(String paramString)
  {
    this.cardNum = paramString;
  }
  
  public void setCardNumLen(int paramInt)
  {
    this.cardNumLen = paramInt;
  }
  
  public void setRectX(int[] paramArrayOfInt)
  {
    this.rectX = paramArrayOfInt;
  }
  
  public void setRectY(int[] paramArrayOfInt)
  {
    this.rectY = paramArrayOfInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.bankcardrecog.BankCardInfo
 * JD-Core Version:    0.7.0.1
 */
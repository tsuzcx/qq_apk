package com.tencent.mm.plugin.facedetect.d;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;

public abstract interface b
{
  public abstract void a(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2);
  
  public abstract boolean a(FaceCharacteristicsResult paramFaceCharacteristicsResult);
  
  public abstract boolean b(FaceCharacteristicsResult paramFaceCharacteristicsResult);
  
  public abstract boolean cuU();
  
  public abstract boolean cuV();
  
  public abstract void cuW();
  
  public abstract b cuX();
  
  public abstract a cuY();
  
  public abstract void setBusinessTip(String paramString);
  
  public static final class a
  {
    public String errMsg;
    public int rqA;
    public int rqB;
    
    a()
    {
      this.rqA = 1;
    }
    
    a(String paramString)
    {
      this.rqB = 7;
      this.errMsg = paramString;
    }
  }
  
  public static final class b
  {
    public int errCode;
    public String errMsg;
    
    public b(int paramInt, String paramString)
    {
      this.errCode = paramInt;
      this.errMsg = paramString;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.b
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mobileqq.facetoface;

public abstract class Face2FaceUserData
{
  public int a = 1;
  public String e;
  
  public Face2FaceUserData(int paramInt, String paramString)
  {
    this.a = paramInt;
    this.e = paramString;
  }
  
  public boolean equals(Object paramObject)
  {
    if ((paramObject instanceof Face2FaceUserData))
    {
      paramObject = (Face2FaceUserData)paramObject;
      if (this.e == null) {
        if ((this.a != paramObject.a) || (paramObject.e != null)) {}
      }
      while ((this.a == paramObject.a) && (this.e.equals(paramObject.e)))
      {
        return true;
        return false;
      }
      return false;
    }
    return false;
  }
  
  public String toString()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceUserData
 * JD-Core Version:    0.7.0.1
 */
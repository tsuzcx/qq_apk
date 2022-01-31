package com.tencent.liteav.basic.module;

public class a
{
  private String mID = "";
  
  public void clearID()
  {
    try
    {
      if (this.mID.length() != 0)
      {
        TXCStatus.b(this.mID);
        this.mID = "";
      }
      return;
    }
    finally {}
  }
  
  public void finalize()
  {
    clearID();
    super.finalize();
  }
  
  public String getID()
  {
    return this.mID;
  }
  
  public Object getStatusValue(int paramInt)
  {
    return TXCStatus.a(this.mID, paramInt);
  }
  
  public void setID(String paramString)
  {
    clearID();
    try
    {
      if (paramString.length() != 0)
      {
        this.mID = paramString;
        TXCStatus.a(this.mID);
      }
      return;
    }
    finally {}
  }
  
  public boolean setStatusValue(int paramInt, Object paramObject)
  {
    return TXCStatus.a(this.mID, paramInt, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.liteav.basic.module.a
 * JD-Core Version:    0.7.0.1
 */
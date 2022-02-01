package com.tencent.matrix.mrs.core;

import com.tencent.mm.sdk.platformtools.Util;

public class MatrixUploadIssue
{
  public static final int DATA_TYPE_BYTE = 0;
  public static final int DATA_TYPE_FILE = 1;
  private byte[] byteData = null;
  private boolean canSplitSlice = false;
  private int dataType = 0;
  private String desKey = "";
  private String filePath = "";
  private long id = Util.nowMilliSecond();
  private boolean needDeleteFileAfterSucc = false;
  private String tag = "";
  private int type = 0;
  
  public byte[] getByteData()
  {
    return this.byteData;
  }
  
  public boolean getCanSplitSlice()
  {
    return this.canSplitSlice;
  }
  
  public int getDataType()
  {
    return this.dataType;
  }
  
  public String getDesKey()
  {
    return this.desKey;
  }
  
  public String getFilePath()
  {
    return this.filePath;
  }
  
  public long getId()
  {
    return this.id;
  }
  
  public String getTag()
  {
    return this.tag;
  }
  
  public int getType()
  {
    return this.type;
  }
  
  public boolean isNeedDeleteFileAfterSucc()
  {
    return this.needDeleteFileAfterSucc;
  }
  
  public void setByteData(byte[] paramArrayOfByte)
  {
    this.byteData = paramArrayOfByte;
  }
  
  public void setCanSplitSlice(boolean paramBoolean)
  {
    this.canSplitSlice = paramBoolean;
  }
  
  public void setDataType(int paramInt)
  {
    this.dataType = paramInt;
  }
  
  public void setDesKey(String paramString)
  {
    this.desKey = paramString;
  }
  
  public void setFilePath(String paramString)
  {
    this.filePath = paramString;
  }
  
  public void setNeedDeleteFileAfterSucc(boolean paramBoolean)
  {
    this.needDeleteFileAfterSucc = paramBoolean;
  }
  
  public void setTag(String paramString)
  {
    this.tag = paramString;
  }
  
  public void setType(int paramInt)
  {
    this.type = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.mrs.core.MatrixUploadIssue
 * JD-Core Version:    0.7.0.1
 */
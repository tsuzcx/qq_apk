package com.tencent.matrix.iocanary.core;

public final class IOIssue
{
  public final long bufferSize;
  public final long fileSize;
  public final int opCnt;
  public final long opCostTime;
  public final long opSize;
  public final int opType;
  public final String path;
  public final int repeatReadCnt;
  public final String stack;
  public final String threadName;
  public final int type;
  
  public IOIssue(int paramInt1, String paramString1, long paramLong1, int paramInt2, long paramLong2, long paramLong3, int paramInt3, long paramLong4, String paramString2, String paramString3, int paramInt4)
  {
    this.type = paramInt1;
    this.path = paramString1;
    this.fileSize = paramLong1;
    this.opCnt = paramInt2;
    this.bufferSize = paramLong2;
    this.opCostTime = paramLong3;
    this.opType = paramInt3;
    this.opSize = paramLong4;
    this.threadName = paramString2;
    this.stack = paramString3;
    this.repeatReadCnt = paramInt4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.matrix.iocanary.core.IOIssue
 * JD-Core Version:    0.7.0.1
 */
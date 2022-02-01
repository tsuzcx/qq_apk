package com.tencent.maas.instamovie;

import com.tencent.maas.instamovie.base.MJError;

public class MJAsyncTaskInfo
{
  public MJError error;
  public long executionID;
  public String taskTag;
  
  public MJAsyncTaskInfo(MJError paramMJError, long paramLong, String paramString)
  {
    this.error = paramMJError;
    this.executionID = paramLong;
    this.taskTag = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.maas.instamovie.MJAsyncTaskInfo
 * JD-Core Version:    0.7.0.1
 */
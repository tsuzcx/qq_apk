package com.tencent.mobileqq.app;

import com.tencent.mobileqq.richstatus.RichStatus;
import java.io.Serializable;

public class SignatureManager$SigCommentInfo
  implements Serializable, Comparable
{
  public String feedsid;
  public RichStatus rs;
  public long time;
  public int type;
  public long uin;
  
  public int compareTo(SigCommentInfo paramSigCommentInfo)
  {
    return (int)(paramSigCommentInfo.time - this.time);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.SignatureManager.SigCommentInfo
 * JD-Core Version:    0.7.0.1
 */
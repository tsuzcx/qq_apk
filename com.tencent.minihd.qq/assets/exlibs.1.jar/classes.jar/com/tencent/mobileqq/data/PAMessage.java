package com.tencent.mobileqq.data;

import java.io.Serializable;
import java.util.ArrayList;

public class PAMessage
  implements Serializable
{
  private static final long serialVersionUID = 243242567575L;
  public ArrayList items;
  public long mMsgId;
  public String moreText;
  public long sendTime;
  public int type;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.data.PAMessage
 * JD-Core Version:    0.7.0.1
 */
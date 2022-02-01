package com.tencent.av.video.jce.QQService;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class strupbuff
  extends JceStruct
{
  static Map<String, ArrayList<byte[]>> cache_logstring;
  public Map<String, ArrayList<byte[]>> logstring = null;
  
  static
  {
    if (!strupbuff.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public strupbuff()
  {
    setLogstring(this.logstring);
  }
  
  public strupbuff(Map<String, ArrayList<byte[]>> paramMap)
  {
    setLogstring(paramMap);
  }
  
  public String className()
  {
    return "com.tencent.qq.video.jce.QQService.strupbuff";
  }
  
  public Object clone()
  {
    Object localObject1 = null;
    try
    {
      Object localObject2 = super.clone();
      localObject1 = localObject2;
    }
    catch (CloneNotSupportedException localCloneNotSupportedException)
    {
      while ($assertionsDisabled) {}
      throw new AssertionError();
    }
    return localObject1;
  }
  
  public void display(StringBuilder paramStringBuilder, int paramInt)
  {
    new JceDisplayer(paramStringBuilder, paramInt).display(this.logstring, "logstring");
  }
  
  public boolean equals(Object paramObject)
  {
    paramObject = (strupbuff)paramObject;
    return JceUtil.equals(this.logstring, paramObject.logstring);
  }
  
  public Map<String, ArrayList<byte[]>> getLogstring()
  {
    return this.logstring;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    if (cache_logstring == null)
    {
      cache_logstring = new HashMap();
      ArrayList localArrayList = new ArrayList();
      byte[] arrayOfByte = (byte[])new byte[1];
      ((byte[])arrayOfByte)[0] = 0;
      localArrayList.add(arrayOfByte);
      cache_logstring.put("", localArrayList);
    }
    setLogstring((Map)paramJceInputStream.read(cache_logstring, 0, true));
  }
  
  public void setLogstring(Map<String, ArrayList<byte[]>> paramMap)
  {
    this.logstring = paramMap;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.logstring, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.av.video.jce.QQService.strupbuff
 * JD-Core Version:    0.7.0.1
 */
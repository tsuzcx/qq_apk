package KQQ;

import com.qq.taf.jce.JceDisplayer;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;

public final class UserBitFlagReq
  extends JceStruct
  implements Cloneable
{
  public byte cAccout2Dis = -1;
  public byte cEmotionMall = -1;
  public byte cMyWallet = -1;
  public byte cPtt2Text = -1;
  
  static
  {
    if (!UserBitFlagReq.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public UserBitFlagReq() {}
  
  public UserBitFlagReq(byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4)
  {
    this.cEmotionMall = paramByte1;
    this.cMyWallet = paramByte2;
    this.cPtt2Text = paramByte3;
    this.cAccout2Dis = paramByte4;
  }
  
  public String className()
  {
    return "KQQ.UserBitFlagReq";
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
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.display(this.cEmotionMall, "cEmotionMall");
    paramStringBuilder.display(this.cMyWallet, "cMyWallet");
    paramStringBuilder.display(this.cPtt2Text, "cPtt2Text");
    paramStringBuilder.display(this.cAccout2Dis, "cAccout2Dis");
  }
  
  public void displaySimple(StringBuilder paramStringBuilder, int paramInt)
  {
    paramStringBuilder = new JceDisplayer(paramStringBuilder, paramInt);
    paramStringBuilder.displaySimple(this.cEmotionMall, true);
    paramStringBuilder.displaySimple(this.cMyWallet, true);
    paramStringBuilder.displaySimple(this.cPtt2Text, true);
    paramStringBuilder.displaySimple(this.cAccout2Dis, false);
  }
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (UserBitFlagReq)paramObject;
    } while ((!JceUtil.equals(this.cEmotionMall, paramObject.cEmotionMall)) || (!JceUtil.equals(this.cMyWallet, paramObject.cMyWallet)) || (!JceUtil.equals(this.cPtt2Text, paramObject.cPtt2Text)) || (!JceUtil.equals(this.cAccout2Dis, paramObject.cAccout2Dis)));
    return true;
  }
  
  public String fullClassName()
  {
    return "KQQ.UserBitFlagReq";
  }
  
  public byte getCAccout2Dis()
  {
    return this.cAccout2Dis;
  }
  
  public byte getCEmotionMall()
  {
    return this.cEmotionMall;
  }
  
  public byte getCMyWallet()
  {
    return this.cMyWallet;
  }
  
  public byte getCPtt2Text()
  {
    return this.cPtt2Text;
  }
  
  public int hashCode()
  {
    try
    {
      throw new Exception("Need define key first!");
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return 0;
  }
  
  public void readFrom(JceInputStream paramJceInputStream)
  {
    this.cEmotionMall = paramJceInputStream.read(this.cEmotionMall, 0, false);
    this.cMyWallet = paramJceInputStream.read(this.cMyWallet, 1, false);
    this.cPtt2Text = paramJceInputStream.read(this.cPtt2Text, 2, false);
    this.cAccout2Dis = paramJceInputStream.read(this.cAccout2Dis, 3, false);
  }
  
  public void setCAccout2Dis(byte paramByte)
  {
    this.cAccout2Dis = paramByte;
  }
  
  public void setCEmotionMall(byte paramByte)
  {
    this.cEmotionMall = paramByte;
  }
  
  public void setCMyWallet(byte paramByte)
  {
    this.cMyWallet = paramByte;
  }
  
  public void setCPtt2Text(byte paramByte)
  {
    this.cPtt2Text = paramByte;
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.cEmotionMall, 0);
    paramJceOutputStream.write(this.cMyWallet, 1);
    paramJceOutputStream.write(this.cPtt2Text, 2);
    paramJceOutputStream.write(this.cAccout2Dis, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     KQQ.UserBitFlagReq
 * JD-Core Version:    0.7.0.1
 */
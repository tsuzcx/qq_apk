package Wallet;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import com.qq.taf.jce.JceUtil;
import java.util.ArrayList;

public final class RspPayApplication
  extends JceStruct
  implements Cloneable
{
  static CreditInfo cache_credit;
  static PopWndInfo cache_popupWindow;
  static TextActionParam cache_textActionParam;
  static ArrayList cache_vecADBanner;
  static ArrayList cache_vecAcountChannel;
  static ArrayList cache_vecAppChannel;
  static ArrayList cache_vecWnd;
  public String backInfo = "";
  public CreditInfo credit = null;
  public boolean firstUse = true;
  public int isDisAddress = 0;
  public int isDisRecords = 0;
  public String msg = "";
  public int pollInterval = 0;
  public PopWndInfo popupWindow = null;
  public int refreshPeriod = 0;
  public int ret = 0;
  public TextActionParam textActionParam = null;
  public ArrayList vecADBanner = null;
  public ArrayList vecAcountChannel = null;
  public ArrayList vecAppChannel = null;
  public ArrayList vecWnd = null;
  public int vipGuaranteeFlag = 0;
  
  static
  {
    if (!RspPayApplication.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      return;
    }
  }
  
  public String className()
  {
    return "Wallet.RspPayApplication";
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
  
  public boolean equals(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return false;
      paramObject = (RspPayApplication)paramObject;
    } while ((!JceUtil.equals(this.ret, paramObject.ret)) || (!JceUtil.equals(this.msg, paramObject.msg)) || (!JceUtil.equals(this.refreshPeriod, paramObject.refreshPeriod)) || (!JceUtil.equals(this.isDisRecords, paramObject.isDisRecords)) || (!JceUtil.equals(this.pollInterval, paramObject.pollInterval)) || (!JceUtil.equals(this.vecAppChannel, paramObject.vecAppChannel)) || (!JceUtil.equals(this.vecADBanner, paramObject.vecADBanner)) || (!JceUtil.equals(this.backInfo, paramObject.backInfo)) || (!JceUtil.equals(this.isDisAddress, paramObject.isDisAddress)) || (!JceUtil.equals(this.popupWindow, paramObject.popupWindow)) || (!JceUtil.equals(this.textActionParam, paramObject.textActionParam)) || (!JceUtil.equals(this.credit, paramObject.credit)) || (!JceUtil.equals(this.vecAcountChannel, paramObject.vecAcountChannel)) || (!JceUtil.equals(this.firstUse, paramObject.firstUse)) || (!JceUtil.equals(this.vipGuaranteeFlag, paramObject.vipGuaranteeFlag)) || (!JceUtil.equals(this.vecWnd, paramObject.vecWnd)));
    return true;
  }
  
  public String fullClassName()
  {
    return "Wallet.RspPayApplication";
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
    this.ret = paramJceInputStream.read(this.ret, 0, true);
    this.msg = paramJceInputStream.readString(1, true);
    this.refreshPeriod = paramJceInputStream.read(this.refreshPeriod, 2, true);
    this.isDisRecords = paramJceInputStream.read(this.isDisRecords, 3, true);
    this.pollInterval = paramJceInputStream.read(this.pollInterval, 4, true);
    Object localObject;
    if (cache_vecAppChannel == null)
    {
      cache_vecAppChannel = new ArrayList();
      localObject = new AppChannel();
      cache_vecAppChannel.add(localObject);
    }
    this.vecAppChannel = ((ArrayList)paramJceInputStream.read(cache_vecAppChannel, 5, true));
    if (cache_vecADBanner == null)
    {
      cache_vecADBanner = new ArrayList();
      localObject = new AppChannel();
      cache_vecADBanner.add(localObject);
    }
    this.vecADBanner = ((ArrayList)paramJceInputStream.read(cache_vecADBanner, 6, true));
    this.backInfo = paramJceInputStream.readString(7, true);
    this.isDisAddress = paramJceInputStream.read(this.isDisAddress, 8, false);
    if (cache_popupWindow == null) {
      cache_popupWindow = new PopWndInfo();
    }
    this.popupWindow = ((PopWndInfo)paramJceInputStream.read(cache_popupWindow, 9, false));
    if (cache_textActionParam == null) {
      cache_textActionParam = new TextActionParam();
    }
    this.textActionParam = ((TextActionParam)paramJceInputStream.read(cache_textActionParam, 10, false));
    if (cache_credit == null) {
      cache_credit = new CreditInfo();
    }
    this.credit = ((CreditInfo)paramJceInputStream.read(cache_credit, 11, false));
    if (cache_vecAcountChannel == null)
    {
      cache_vecAcountChannel = new ArrayList();
      localObject = new AppChannel();
      cache_vecAcountChannel.add(localObject);
    }
    this.vecAcountChannel = ((ArrayList)paramJceInputStream.read(cache_vecAcountChannel, 12, false));
    this.firstUse = paramJceInputStream.read(this.firstUse, 13, false);
    this.vipGuaranteeFlag = paramJceInputStream.read(this.vipGuaranteeFlag, 14, false);
    if (cache_vecWnd == null)
    {
      cache_vecWnd = new ArrayList();
      localObject = new PopWndInfo();
      cache_vecWnd.add(localObject);
    }
    this.vecWnd = ((ArrayList)paramJceInputStream.read(cache_vecWnd, 15, false));
  }
  
  public void writeTo(JceOutputStream paramJceOutputStream)
  {
    paramJceOutputStream.write(this.ret, 0);
    paramJceOutputStream.write(this.msg, 1);
    paramJceOutputStream.write(this.refreshPeriod, 2);
    paramJceOutputStream.write(this.isDisRecords, 3);
    paramJceOutputStream.write(this.pollInterval, 4);
    paramJceOutputStream.write(this.vecAppChannel, 5);
    paramJceOutputStream.write(this.vecADBanner, 6);
    paramJceOutputStream.write(this.backInfo, 7);
    paramJceOutputStream.write(this.isDisAddress, 8);
    if (this.popupWindow != null) {
      paramJceOutputStream.write(this.popupWindow, 9);
    }
    if (this.textActionParam != null) {
      paramJceOutputStream.write(this.textActionParam, 10);
    }
    if (this.credit != null) {
      paramJceOutputStream.write(this.credit, 11);
    }
    if (this.vecAcountChannel != null) {
      paramJceOutputStream.write(this.vecAcountChannel, 12);
    }
    paramJceOutputStream.write(this.firstUse, 13);
    paramJceOutputStream.write(this.vipGuaranteeFlag, 14);
    if (this.vecWnd != null) {
      paramJceOutputStream.write(this.vecWnd, 15);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     Wallet.RspPayApplication
 * JD-Core Version:    0.7.0.1
 */
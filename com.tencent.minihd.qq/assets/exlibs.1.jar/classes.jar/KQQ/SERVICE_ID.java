package KQQ;

import java.io.Serializable;

public final class SERVICE_ID
  implements Serializable
{
  public static final SERVICE_ID ST_ACCOUNT_REC_LIST;
  public static final SERVICE_ID ST_BNREPORT_CONFIG;
  public static final SERVICE_ID ST_CHATAVATAR;
  public static final SERVICE_ID ST_CIRCLE;
  public static final SERVICE_ID ST_CONFSVC_CLIREQ;
  public static final SERVICE_ID ST_CONF_GET_PLUGIN;
  public static final SERVICE_ID ST_CONF_GET_RESOURCE;
  public static final SERVICE_ID ST_EMOTION_MALL;
  public static final SERVICE_ID ST_EMOTION_MALL_BIT;
  public static final SERVICE_ID ST_EMOTION_MALL_OP;
  public static final SERVICE_ID ST_GETWEBVIEWCONFIG;
  public static final SERVICE_ID ST_GET_BLACKLIST;
  public static final SERVICE_ID ST_GET_RICH_SIG;
  public static final SERVICE_ID ST_GET_SETTINGS;
  public static final SERVICE_ID ST_GET_SUMMARY_BATCH_UPDATE;
  public static final SERVICE_ID ST_GET_SUMMARY_PRELOAD;
  public static final SERVICE_ID ST_GET_SUMMARY_UPDATE;
  public static final SERVICE_ID ST_OFFLINE_H5_CHECK;
  public static final SERVICE_ID ST_PUBLIC_ACCOUNT;
  public static final SERVICE_ID ST_QQCLUBCOMM_NEWFLAG;
  public static final SERVICE_ID ST_QQPROFILE;
  public static final SERVICE_ID ST_SIMPLEINFO;
  public static final SERVICE_ID ST_SYSTEMMSG_NEW;
  public static final SERVICE_ID ST_TERMINAL_CONFIG;
  public static final SERVICE_ID ST_UPSVR_QUERYRUL;
  public static final SERVICE_ID ST_USERBITFLAG;
  public static final int _ST_ACCOUNT_REC_LIST = 112;
  public static final int _ST_BNREPORT_CONFIG = 118;
  public static final int _ST_CHATAVATAR = 105;
  public static final int _ST_CIRCLE = 104;
  public static final int _ST_CONFSVC_CLIREQ = 117;
  public static final int _ST_CONF_GET_PLUGIN = 121;
  public static final int _ST_CONF_GET_RESOURCE = 120;
  public static final int _ST_EMOTION_MALL = 103;
  public static final int _ST_EMOTION_MALL_BIT = 108;
  public static final int _ST_EMOTION_MALL_OP = 107;
  public static final int _ST_GETWEBVIEWCONFIG = 126;
  public static final int _ST_GET_BLACKLIST = 116;
  public static final int _ST_GET_RICH_SIG = 119;
  public static final int _ST_GET_SETTINGS = 115;
  public static final int _ST_GET_SUMMARY_BATCH_UPDATE = 122;
  public static final int _ST_GET_SUMMARY_PRELOAD = 123;
  public static final int _ST_GET_SUMMARY_UPDATE = 111;
  public static final int _ST_OFFLINE_H5_CHECK = 124;
  public static final int _ST_PUBLIC_ACCOUNT = 102;
  public static final int _ST_QQCLUBCOMM_NEWFLAG = 110;
  public static final int _ST_QQPROFILE = 101;
  public static final int _ST_SIMPLEINFO = 113;
  public static final int _ST_SYSTEMMSG_NEW = 114;
  public static final int _ST_TERMINAL_CONFIG = 109;
  public static final int _ST_UPSVR_QUERYRUL = 125;
  public static final int _ST_USERBITFLAG = 106;
  private static SERVICE_ID[] a;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!SERVICE_ID.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new SERVICE_ID[26];
      ST_QQPROFILE = new SERVICE_ID(0, 101, "ST_QQPROFILE");
      ST_PUBLIC_ACCOUNT = new SERVICE_ID(1, 102, "ST_PUBLIC_ACCOUNT");
      ST_EMOTION_MALL = new SERVICE_ID(2, 103, "ST_EMOTION_MALL");
      ST_CIRCLE = new SERVICE_ID(3, 104, "ST_CIRCLE");
      ST_CHATAVATAR = new SERVICE_ID(4, 105, "ST_CHATAVATAR");
      ST_USERBITFLAG = new SERVICE_ID(5, 106, "ST_USERBITFLAG");
      ST_EMOTION_MALL_OP = new SERVICE_ID(6, 107, "ST_EMOTION_MALL_OP");
      ST_EMOTION_MALL_BIT = new SERVICE_ID(7, 108, "ST_EMOTION_MALL_BIT");
      ST_TERMINAL_CONFIG = new SERVICE_ID(8, 109, "ST_TERMINAL_CONFIG");
      ST_QQCLUBCOMM_NEWFLAG = new SERVICE_ID(9, 110, "ST_QQCLUBCOMM_NEWFLAG");
      ST_GET_SUMMARY_UPDATE = new SERVICE_ID(10, 111, "ST_GET_SUMMARY_UPDATE");
      ST_ACCOUNT_REC_LIST = new SERVICE_ID(11, 112, "ST_ACCOUNT_REC_LIST");
      ST_SIMPLEINFO = new SERVICE_ID(12, 113, "ST_SIMPLEINFO");
      ST_SYSTEMMSG_NEW = new SERVICE_ID(13, 114, "ST_SYSTEMMSG_NEW");
      ST_GET_SETTINGS = new SERVICE_ID(14, 115, "ST_GET_SETTINGS");
      ST_GET_BLACKLIST = new SERVICE_ID(15, 116, "ST_GET_BLACKLIST");
      ST_CONFSVC_CLIREQ = new SERVICE_ID(16, 117, "ST_CONFSVC_CLIREQ");
      ST_BNREPORT_CONFIG = new SERVICE_ID(17, 118, "ST_BNREPORT_CONFIG");
      ST_GET_RICH_SIG = new SERVICE_ID(18, 119, "ST_GET_RICH_SIG");
      ST_CONF_GET_RESOURCE = new SERVICE_ID(19, 120, "ST_CONF_GET_RESOURCE");
      ST_CONF_GET_PLUGIN = new SERVICE_ID(20, 121, "ST_CONF_GET_PLUGIN");
      ST_GET_SUMMARY_BATCH_UPDATE = new SERVICE_ID(21, 122, "ST_GET_SUMMARY_BATCH_UPDATE");
      ST_GET_SUMMARY_PRELOAD = new SERVICE_ID(22, 123, "ST_GET_SUMMARY_PRELOAD");
      ST_OFFLINE_H5_CHECK = new SERVICE_ID(23, 124, "ST_OFFLINE_H5_CHECK");
      ST_UPSVR_QUERYRUL = new SERVICE_ID(24, 125, "ST_UPSVR_QUERYRUL");
      ST_GETWEBVIEWCONFIG = new SERVICE_ID(25, 126, "ST_GETWEBVIEWCONFIG");
      return;
    }
  }
  
  private SERVICE_ID(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static SERVICE_ID convert(int paramInt)
  {
    int i = 0;
    while (i < a.length)
    {
      if (a[i].value() == paramInt) {
        return a[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public static SERVICE_ID convert(String paramString)
  {
    int i = 0;
    while (i < a.length)
    {
      if (a[i].toString().equals(paramString)) {
        return a[i];
      }
      i += 1;
    }
    if (!$assertionsDisabled) {
      throw new AssertionError();
    }
    return null;
  }
  
  public String toString()
  {
    return this.__T;
  }
  
  public int value()
  {
    return this.__value;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     KQQ.SERVICE_ID
 * JD-Core Version:    0.7.0.1
 */
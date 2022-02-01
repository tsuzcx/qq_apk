package NS_MOBILE_FEEDS;

import java.io.Serializable;

public final class e_originaltype
  implements Serializable
{
  public static final int _enum_ALBUM = 2;
  public static final int _enum_APP_URL = 21;
  public static final int _enum_BBS = 14;
  public static final int _enum_BLOG = 1;
  public static final int _enum_DOUBAN = 16;
  public static final int _enum_DOUDING = 11;
  public static final int _enum_MUSIC = 18;
  public static final int _enum_MUSIC_ALBUM = 27;
  public static final int _enum_MUSIC_C = 23;
  public static final int _enum_MUSIC_FOLLOWDIR = 32;
  public static final int _enum_MUSIC_LIST = 24;
  public static final int _enum_MUSIC_LISTEN_SONG = 28;
  public static final int _enum_MUSIC_LOVEMV = 34;
  public static final int _enum_MUSIC_LOVESONG = 29;
  public static final int _enum_MUSIC_MV = 25;
  public static final int _enum_MUSIC_ORDERALBUM = 35;
  public static final int _enum_MUSIC_ORDERDIR = 31;
  public static final int _enum_MUSIC_ORDERSONG = 30;
  public static final int _enum_MUSIC_SONG_LIST = 26;
  public static final int _enum_MUSIC_TYPE_END = 49;
  public static final int _enum_MUSIC_TYPE_NEWDIR = 37;
  public static final int _enum_MUSIC_TYPE_ORDERSONG2 = 36;
  public static final int _enum_MUSIC_UPDATEDIR = 33;
  public static final int _enum_NEWS = 13;
  public static final int _enum_PAIPAI = 10;
  public static final int _enum_PICTURE = 3;
  public static final int _enum_PICTURE_EXT = 22;
  public static final int _enum_SHOW = 12;
  public static final int _enum_SOSO_TUANGOU = 20;
  public static final int _enum_SPACE_DRESS = 50;
  public static final int _enum_URL = 4;
  public static final int _enum_URLSIF = 15;
  public static final int _enum_VIDEO = 5;
  public static final int _enum_WEIBO = 17;
  private static e_originaltype[] a;
  public static final e_originaltype enum_ALBUM;
  public static final e_originaltype enum_APP_URL;
  public static final e_originaltype enum_BBS;
  public static final e_originaltype enum_BLOG;
  public static final e_originaltype enum_DOUBAN;
  public static final e_originaltype enum_DOUDING;
  public static final e_originaltype enum_MUSIC;
  public static final e_originaltype enum_MUSIC_ALBUM;
  public static final e_originaltype enum_MUSIC_C;
  public static final e_originaltype enum_MUSIC_FOLLOWDIR;
  public static final e_originaltype enum_MUSIC_LIST;
  public static final e_originaltype enum_MUSIC_LISTEN_SONG;
  public static final e_originaltype enum_MUSIC_LOVEMV;
  public static final e_originaltype enum_MUSIC_LOVESONG;
  public static final e_originaltype enum_MUSIC_MV;
  public static final e_originaltype enum_MUSIC_ORDERALBUM;
  public static final e_originaltype enum_MUSIC_ORDERDIR;
  public static final e_originaltype enum_MUSIC_ORDERSONG;
  public static final e_originaltype enum_MUSIC_SONG_LIST;
  public static final e_originaltype enum_MUSIC_TYPE_END;
  public static final e_originaltype enum_MUSIC_TYPE_NEWDIR;
  public static final e_originaltype enum_MUSIC_TYPE_ORDERSONG2;
  public static final e_originaltype enum_MUSIC_UPDATEDIR;
  public static final e_originaltype enum_NEWS;
  public static final e_originaltype enum_PAIPAI;
  public static final e_originaltype enum_PICTURE;
  public static final e_originaltype enum_PICTURE_EXT;
  public static final e_originaltype enum_SHOW;
  public static final e_originaltype enum_SOSO_TUANGOU;
  public static final e_originaltype enum_SPACE_DRESS;
  public static final e_originaltype enum_URL;
  public static final e_originaltype enum_URLSIF;
  public static final e_originaltype enum_VIDEO;
  public static final e_originaltype enum_WEIBO;
  private String __T = new String();
  private int __value;
  
  static
  {
    if (!e_originaltype.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      $assertionsDisabled = bool;
      a = new e_originaltype[34];
      enum_BLOG = new e_originaltype(0, 1, "enum_BLOG");
      enum_ALBUM = new e_originaltype(1, 2, "enum_ALBUM");
      enum_PICTURE = new e_originaltype(2, 3, "enum_PICTURE");
      enum_URL = new e_originaltype(3, 4, "enum_URL");
      enum_VIDEO = new e_originaltype(4, 5, "enum_VIDEO");
      enum_PAIPAI = new e_originaltype(5, 10, "enum_PAIPAI");
      enum_DOUDING = new e_originaltype(6, 11, "enum_DOUDING");
      enum_SHOW = new e_originaltype(7, 12, "enum_SHOW");
      enum_NEWS = new e_originaltype(8, 13, "enum_NEWS");
      enum_BBS = new e_originaltype(9, 14, "enum_BBS");
      enum_URLSIF = new e_originaltype(10, 15, "enum_URLSIF");
      enum_DOUBAN = new e_originaltype(11, 16, "enum_DOUBAN");
      enum_WEIBO = new e_originaltype(12, 17, "enum_WEIBO");
      enum_MUSIC = new e_originaltype(13, 18, "enum_MUSIC");
      enum_SOSO_TUANGOU = new e_originaltype(14, 20, "enum_SOSO_TUANGOU");
      enum_APP_URL = new e_originaltype(15, 21, "enum_APP_URL");
      enum_PICTURE_EXT = new e_originaltype(16, 22, "enum_PICTURE_EXT");
      enum_MUSIC_C = new e_originaltype(17, 23, "enum_MUSIC_C");
      enum_MUSIC_LIST = new e_originaltype(18, 24, "enum_MUSIC_LIST");
      enum_MUSIC_MV = new e_originaltype(19, 25, "enum_MUSIC_MV");
      enum_MUSIC_SONG_LIST = new e_originaltype(20, 26, "enum_MUSIC_SONG_LIST");
      enum_MUSIC_ALBUM = new e_originaltype(21, 27, "enum_MUSIC_ALBUM");
      enum_MUSIC_LISTEN_SONG = new e_originaltype(22, 28, "enum_MUSIC_LISTEN_SONG");
      enum_MUSIC_LOVESONG = new e_originaltype(23, 29, "enum_MUSIC_LOVESONG");
      enum_MUSIC_ORDERSONG = new e_originaltype(24, 30, "enum_MUSIC_ORDERSONG");
      enum_MUSIC_ORDERDIR = new e_originaltype(25, 31, "enum_MUSIC_ORDERDIR");
      enum_MUSIC_FOLLOWDIR = new e_originaltype(26, 32, "enum_MUSIC_FOLLOWDIR");
      enum_MUSIC_UPDATEDIR = new e_originaltype(27, 33, "enum_MUSIC_UPDATEDIR");
      enum_MUSIC_LOVEMV = new e_originaltype(28, 34, "enum_MUSIC_LOVEMV");
      enum_MUSIC_ORDERALBUM = new e_originaltype(29, 35, "enum_MUSIC_ORDERALBUM");
      enum_MUSIC_TYPE_ORDERSONG2 = new e_originaltype(30, 36, "enum_MUSIC_TYPE_ORDERSONG2");
      enum_MUSIC_TYPE_NEWDIR = new e_originaltype(31, 37, "enum_MUSIC_TYPE_NEWDIR");
      enum_MUSIC_TYPE_END = new e_originaltype(32, 49, "enum_MUSIC_TYPE_END");
      enum_SPACE_DRESS = new e_originaltype(33, 50, "enum_SPACE_DRESS");
      return;
    }
  }
  
  private e_originaltype(int paramInt1, int paramInt2, String paramString)
  {
    this.__T = paramString;
    this.__value = paramInt2;
    a[paramInt1] = this;
  }
  
  public static e_originaltype convert(int paramInt)
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
  
  public static e_originaltype convert(String paramString)
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
 * Qualified Name:     NS_MOBILE_FEEDS.e_originaltype
 * JD-Core Version:    0.7.0.1
 */
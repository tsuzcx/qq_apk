package com.qq.wx.voice.embed.recognizer;

import android.content.Context;
import android.os.Build.VERSION;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Grammar
{
  public static String mData = null;
  public static String mDataPath = null;
  public static String mSo = null;
  private f a = null;
  private a b = new a();
  private boolean c = false;
  private boolean d = false;
  private ArrayList e = null;
  
  private String a()
  {
    int j = 0;
    int i = 0;
    StringBuffer localStringBuffer;
    if (i >= this.e.size())
    {
      localStringBuffer = new StringBuffer("");
      i = j;
    }
    for (;;)
    {
      if (i >= this.e.size())
      {
        return localStringBuffer.toString();
        ((d)this.e.get(i)).aVt = a(((d)this.e.get(i)).userName);
        ((d)this.e.get(i)).aVu = a(((d)this.e.get(i)).aVr);
        ((d)this.e.get(i)).aVv = a(((d)this.e.get(i)).aVs);
        i += 1;
        break;
      }
      String str = ((d)this.e.get(i)).aVt;
      if (!str.isEmpty())
      {
        if (localStringBuffer.length() > 0) {
          localStringBuffer.append("\n");
        }
        localStringBuffer.append(str);
      }
      str = ((d)this.e.get(i)).aVu;
      if (!str.isEmpty())
      {
        if (localStringBuffer.length() > 0) {
          localStringBuffer.append("\n");
        }
        localStringBuffer.append(str);
      }
      str = ((d)this.e.get(i)).aVv;
      if (!str.isEmpty())
      {
        if (localStringBuffer.length() > 0) {
          localStringBuffer.append("\n");
        }
        localStringBuffer.append(str);
      }
      i += 1;
    }
  }
  
  private static String a(String paramString)
  {
    return new String(paramString).replaceAll("[^(a-zA-Z0-9\\u4e00-\\u9fa5)]", "").replaceAll("0", "零").replaceAll("1", "一").replaceAll("2", "二").replaceAll("3", "三").replaceAll("4", "四").replaceAll("5", "五").replaceAll("6", "六").replaceAll("7", "七").replaceAll("8", "八").replaceAll("9", "九");
  }
  
  public int begin()
  {
    return GrammarNative.begin();
  }
  
  public int checkFiles(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    if (this.c) {
      return 0;
    }
    if ((paramContext == null) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null)) {
      return -303;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      int j = this.a.c("/vendor/lib/", paramString2, paramString3);
      i = j;
      if (j >= 0) {}
    }
    for (int i = this.a.c(paramContext, paramString1, paramString2, paramString3);; i = this.a.c(paramString1, paramString2, paramString3))
    {
      if (i >= 0) {
        break label117;
      }
      return i;
      if ((paramString1.compareTo("/system/lib") != 0) && (paramString1.compareTo("/system/lib/") != 0)) {
        break;
      }
    }
    label117:
    mDataPath = this.a.b;
    mData = "libwxvoiceembed.bin";
    mSo = "libwxvoiceembed.so";
    this.c = true;
    return 0;
  }
  
  public int end()
  {
    return GrammarNative.end();
  }
  
  public int getResult(a parama)
  {
    int k = 0;
    int i = GrammarNative.getResult(this);
    if (i < 0) {
      return i;
    }
    parama.text = this.b.text;
    if (this.b.name == null)
    {
      parama.name = null;
      return 0;
    }
    int j = 0;
    for (;;)
    {
      i = k;
      if (j >= this.e.size()) {
        break;
      }
      if (((d)this.e.get(j)).aVt.compareTo(this.b.name) == 0)
      {
        parama.name = ((d)this.e.get(j)).userName;
        return 0;
      }
      if (((d)this.e.get(j)).aVu.compareTo(this.b.name) == 0)
      {
        parama.name = ((d)this.e.get(j)).userName;
        return 0;
      }
      if (((d)this.e.get(j)).aVv.compareTo(this.b.name) == 0)
      {
        parama.name = ((d)this.e.get(j)).userName;
        return 0;
      }
      j += 1;
    }
  }
  
  public int init(ArrayList paramArrayList)
  {
    if (this.d) {
      return 0;
    }
    if (paramArrayList == null) {
      return -303;
    }
    try
    {
      System.load(mDataPath + "/" + mSo);
      this.e = paramArrayList;
      paramArrayList = a();
      this.d = true;
    }
    catch (Exception paramArrayList)
    {
      try
      {
        if (GrammarNative.init(mDataPath.getBytes(), mData.getBytes(), paramArrayList.toString().getBytes("GBK")) >= 0) {
          break label164;
        }
        new StringBuilder(String.valueOf(mDataPath)).append(" ").append(mData).append(" ").append(paramArrayList);
        return -101;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        new StringBuilder(String.valueOf(mDataPath)).append(" ").append(mData).append(" ").append(paramArrayList);
        return -101;
      }
      paramArrayList = paramArrayList;
      return -205;
    }
    label164:
    return 0;
  }
  
  public void onGetResult(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    if (paramArrayOfByte1 != null) {}
    try
    {
      for (this.b.text = new String(paramArrayOfByte1, "GBK"); paramArrayOfByte3 != null; this.b.text = null)
      {
        this.b.name = new String(paramArrayOfByte3, "GBK");
        return;
      }
      this.b.name = null;
      return;
    }
    catch (UnsupportedEncodingException paramArrayOfByte1) {}
  }
  
  public int recognize(byte[] paramArrayOfByte, int paramInt)
  {
    return GrammarNative.recognize(paramArrayOfByte, paramInt);
  }
  
  public int update(ArrayList paramArrayList)
  {
    int i = -106;
    if (paramArrayList == null) {
      i = -303;
    }
    for (;;)
    {
      return i;
      this.e = paramArrayList;
      paramArrayList = a();
      try
      {
        int j = GrammarNative.update(paramArrayList.getBytes("GBK"));
        if (j >= 0) {
          return 0;
        }
      }
      catch (UnsupportedEncodingException paramArrayList) {}
    }
    return -106;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.qq.wx.voice.embed.recognizer.Grammar
 * JD-Core Version:    0.7.0.1
 */
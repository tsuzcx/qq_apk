package com.qq.wx.voice.embed.recognizer;

import android.content.Context;
import android.os.Build.VERSION;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class Grammar
{
  public static String mData = null;
  public static String mDataPath = null;
  public static String mSo = null;
  private f a;
  private a b;
  private boolean c;
  private boolean d;
  private ArrayList e;
  
  public Grammar()
  {
    AppMethodBeat.i(123213);
    this.a = null;
    this.b = new a();
    this.c = false;
    this.d = false;
    this.e = null;
    this.a = new f();
    AppMethodBeat.o(123213);
  }
  
  private String a()
  {
    int j = 0;
    AppMethodBeat.i(123217);
    int i = 0;
    Object localObject;
    if (i >= this.e.size())
    {
      localObject = new StringBuffer("");
      i = j;
    }
    for (;;)
    {
      if (i >= this.e.size())
      {
        localObject = ((StringBuffer)localObject).toString();
        AppMethodBeat.o(123217);
        return localObject;
        ((d)this.e.get(i)).bmb = a(((d)this.e.get(i)).userName);
        ((d)this.e.get(i)).bmc = a(((d)this.e.get(i)).blZ);
        ((d)this.e.get(i)).bmd = a(((d)this.e.get(i)).bma);
        i += 1;
        break;
      }
      String str = ((d)this.e.get(i)).bmb;
      if (!str.isEmpty())
      {
        if (((StringBuffer)localObject).length() > 0) {
          ((StringBuffer)localObject).append("\n");
        }
        ((StringBuffer)localObject).append(str);
      }
      str = ((d)this.e.get(i)).bmc;
      if (!str.isEmpty())
      {
        if (((StringBuffer)localObject).length() > 0) {
          ((StringBuffer)localObject).append("\n");
        }
        ((StringBuffer)localObject).append(str);
      }
      str = ((d)this.e.get(i)).bmd;
      if (!str.isEmpty())
      {
        if (((StringBuffer)localObject).length() > 0) {
          ((StringBuffer)localObject).append("\n");
        }
        ((StringBuffer)localObject).append(str);
      }
      i += 1;
    }
  }
  
  private static String a(String paramString)
  {
    AppMethodBeat.i(123218);
    paramString = new String(paramString).replaceAll("[^(a-zA-Z0-9\\u4e00-\\u9fa5)]", "").replaceAll("0", "零").replaceAll("1", "一").replaceAll("2", "二").replaceAll("3", "三").replaceAll("4", "四").replaceAll("5", "五").replaceAll("6", "六").replaceAll("7", "七").replaceAll("8", "八").replaceAll("9", "九");
    AppMethodBeat.o(123218);
    return paramString;
  }
  
  public int begin()
  {
    AppMethodBeat.i(123219);
    int i = GrammarNative.begin();
    AppMethodBeat.o(123219);
    return i;
  }
  
  public int checkFiles(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(123214);
    if (this.c)
    {
      AppMethodBeat.o(123214);
      return 0;
    }
    if ((paramContext == null) || (paramString1 == null) || (paramString2 == null) || (paramString3 == null))
    {
      AppMethodBeat.o(123214);
      return -303;
    }
    if (Build.VERSION.SDK_INT >= 24)
    {
      int j = this.a.e("/vendor/lib/", paramString2, paramString3);
      i = j;
      if (j >= 0) {}
    }
    for (int i = this.a.c(paramContext, paramString1, paramString2, paramString3);; i = this.a.e(paramString1, paramString2, paramString3))
    {
      if (i >= 0) {
        break label137;
      }
      AppMethodBeat.o(123214);
      return i;
      if ((paramString1.compareTo("/system/lib") != 0) && (paramString1.compareTo("/system/lib/") != 0)) {
        break;
      }
    }
    label137:
    mDataPath = this.a.b;
    mData = "libwxvoiceembed.bin";
    mSo = "libwxvoiceembed.so";
    this.c = true;
    AppMethodBeat.o(123214);
    return 0;
  }
  
  public int end()
  {
    AppMethodBeat.i(123221);
    int i = GrammarNative.end();
    AppMethodBeat.o(123221);
    return i;
  }
  
  public int getResult(a parama)
  {
    AppMethodBeat.i(123222);
    int i = GrammarNative.getResult(this);
    if (i < 0)
    {
      AppMethodBeat.o(123222);
      return i;
    }
    parama.text = this.b.text;
    if (this.b.name == null)
    {
      parama.name = null;
      AppMethodBeat.o(123222);
      return 0;
    }
    i = 0;
    for (;;)
    {
      if (i >= this.e.size()) {}
      for (;;)
      {
        AppMethodBeat.o(123222);
        return 0;
        if (((d)this.e.get(i)).bmb.compareTo(this.b.name) == 0)
        {
          parama.name = ((d)this.e.get(i)).userName;
        }
        else if (((d)this.e.get(i)).bmc.compareTo(this.b.name) == 0)
        {
          parama.name = ((d)this.e.get(i)).userName;
        }
        else
        {
          if (((d)this.e.get(i)).bmd.compareTo(this.b.name) != 0) {
            break;
          }
          parama.name = ((d)this.e.get(i)).userName;
        }
      }
      i += 1;
    }
  }
  
  public int init(ArrayList paramArrayList)
  {
    AppMethodBeat.i(123215);
    if (this.d)
    {
      AppMethodBeat.o(123215);
      return 0;
    }
    if (paramArrayList == null)
    {
      AppMethodBeat.o(123215);
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
          break label198;
        }
        new StringBuilder(String.valueOf(mDataPath)).append(" ").append(mData).append(" ").append(paramArrayList);
        AppMethodBeat.o(123215);
        return -101;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        new StringBuilder(String.valueOf(mDataPath)).append(" ").append(mData).append(" ").append(paramArrayList);
        AppMethodBeat.o(123215);
        return -101;
      }
      paramArrayList = paramArrayList;
      AppMethodBeat.o(123215);
      return -205;
    }
    label198:
    AppMethodBeat.o(123215);
    return 0;
  }
  
  public void onGetResult(int paramInt, byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3)
  {
    AppMethodBeat.i(123223);
    if (paramArrayOfByte1 != null) {}
    for (;;)
    {
      try
      {
        this.b.text = new String(paramArrayOfByte1, "GBK");
        if (paramArrayOfByte3 == null) {
          break;
        }
        this.b.name = new String(paramArrayOfByte3, "GBK");
        AppMethodBeat.o(123223);
        return;
      }
      catch (UnsupportedEncodingException paramArrayOfByte1)
      {
        AppMethodBeat.o(123223);
        return;
      }
      this.b.text = null;
    }
    this.b.name = null;
    AppMethodBeat.o(123223);
  }
  
  public int recognize(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(123220);
    paramInt = GrammarNative.recognize(paramArrayOfByte, paramInt);
    AppMethodBeat.o(123220);
    return paramInt;
  }
  
  public int update(ArrayList paramArrayList)
  {
    AppMethodBeat.i(123216);
    if (paramArrayList == null)
    {
      AppMethodBeat.o(123216);
      return -303;
    }
    this.e = paramArrayList;
    paramArrayList = a();
    try
    {
      int i = GrammarNative.update(paramArrayList.getBytes("GBK"));
      if (i < 0)
      {
        AppMethodBeat.o(123216);
        return -106;
      }
    }
    catch (UnsupportedEncodingException paramArrayList)
    {
      AppMethodBeat.o(123216);
      return -106;
    }
    AppMethodBeat.o(123216);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.qq.wx.voice.embed.recognizer.Grammar
 * JD-Core Version:    0.7.0.1
 */
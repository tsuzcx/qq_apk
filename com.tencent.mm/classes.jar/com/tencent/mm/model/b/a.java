package com.tencent.mm.model.b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;

public abstract class a
  implements e
{
  protected e.a lwH;
  protected String lwI = bgc();
  protected String[] lwJ = bgb();
  
  public final boolean Sq(String paramString)
  {
    boolean bool2 = false;
    bh.beI();
    SharedPreferences localSharedPreferences = c.MQ("banner");
    boolean bool1 = bool2;
    if (localSharedPreferences != null)
    {
      bool1 = bool2;
      if (localSharedPreferences.getBoolean(this.lwI + paramString, false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final void Sr(String paramString)
  {
    bh.beI();
    SharedPreferences localSharedPreferences = c.MQ("banner");
    if (localSharedPreferences == null) {}
    do
    {
      return;
      localSharedPreferences.edit().remove(this.lwI + paramString).commit();
      if (this.lwJ != null)
      {
        String[] arrayOfString = this.lwJ;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if (str != null) {
            localSharedPreferences.edit().remove(this.lwI + str + paramString).commit();
          }
          i += 1;
        }
      }
    } while (this.lwH == null);
    this.lwH.bgp();
  }
  
  public final void a(e.a parama)
  {
    this.lwH = parama;
  }
  
  public final void a(String paramString, boolean paramBoolean, String[] paramArrayOfString)
  {
    bh.beI();
    SharedPreferences localSharedPreferences = c.MQ("banner");
    if (localSharedPreferences == null) {}
    label188:
    do
    {
      return;
      localSharedPreferences.edit().putBoolean(this.lwI + paramString, paramBoolean).commit();
      if ((this.lwJ != null) && (paramArrayOfString != null) && (this.lwJ.length == paramArrayOfString.length))
      {
        String[] arrayOfString = this.lwJ;
        int k = arrayOfString.length;
        int i = 0;
        int j = 0;
        if (i < k)
        {
          String str2 = arrayOfString[i];
          if (str2 != null) {
            if (paramArrayOfString[j] == null) {
              break label188;
            }
          }
          for (String str1 = paramArrayOfString[j];; str1 = "")
          {
            localSharedPreferences.edit().putString(this.lwI + str2 + paramString, str1).commit();
            j += 1;
            i += 1;
            break;
          }
        }
      }
    } while (this.lwH == null);
    this.lwH.bgo();
  }
  
  public final String aY(String paramString1, String paramString2)
  {
    bh.beI();
    SharedPreferences localSharedPreferences = c.MQ("banner");
    if (localSharedPreferences == null) {
      return null;
    }
    return localSharedPreferences.getString(this.lwI + paramString2 + paramString1, null);
  }
  
  protected String[] bgb()
  {
    return null;
  }
  
  public abstract String bgc();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.b.a
 * JD-Core Version:    0.7.0.1
 */
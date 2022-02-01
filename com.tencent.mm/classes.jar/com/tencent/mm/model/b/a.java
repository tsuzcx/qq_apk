package com.tencent.mm.model.b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;

public abstract class a
  implements e
{
  protected e.a hqs;
  protected String hqt = azQ();
  protected String[] hqu = azP();
  
  public final void a(e.a parama)
  {
    this.hqs = parama;
  }
  
  public final void a(String paramString, boolean paramBoolean, String[] paramArrayOfString)
  {
    az.ayM();
    SharedPreferences localSharedPreferences = c.ug("banner");
    if (localSharedPreferences == null) {}
    label188:
    do
    {
      return;
      localSharedPreferences.edit().putBoolean(this.hqt + paramString, paramBoolean).commit();
      if ((this.hqu != null) && (paramArrayOfString != null) && (this.hqu.length == paramArrayOfString.length))
      {
        String[] arrayOfString = this.hqu;
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
            localSharedPreferences.edit().putString(this.hqt + str2 + paramString, str1).commit();
            j += 1;
            i += 1;
            break;
          }
        }
      }
    } while (this.hqs == null);
    this.hqs.aAc();
  }
  
  public final String aP(String paramString1, String paramString2)
  {
    az.ayM();
    SharedPreferences localSharedPreferences = c.ug("banner");
    if (localSharedPreferences == null) {
      return null;
    }
    return localSharedPreferences.getString(this.hqt + paramString2 + paramString1, null);
  }
  
  protected String[] azP()
  {
    return null;
  }
  
  public abstract String azQ();
  
  public final boolean yL(String paramString)
  {
    boolean bool2 = false;
    az.ayM();
    SharedPreferences localSharedPreferences = c.ug("banner");
    boolean bool1 = bool2;
    if (localSharedPreferences != null)
    {
      bool1 = bool2;
      if (localSharedPreferences.getBoolean(this.hqt + paramString, false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final void yM(String paramString)
  {
    az.ayM();
    SharedPreferences localSharedPreferences = c.ug("banner");
    if (localSharedPreferences == null) {}
    do
    {
      return;
      localSharedPreferences.edit().remove(this.hqt + paramString).commit();
      if (this.hqu != null)
      {
        String[] arrayOfString = this.hqu;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if (str != null) {
            localSharedPreferences.edit().remove(this.hqt + str + paramString).commit();
          }
          i += 1;
        }
      }
    } while (this.hqs == null);
    this.hqs.aAd();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.b.a
 * JD-Core Version:    0.7.0.1
 */
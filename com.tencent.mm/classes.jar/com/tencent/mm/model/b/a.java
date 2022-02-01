package com.tencent.mm.model.b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;

public abstract class a
  implements e
{
  protected e.a hLD;
  protected String hLE = aDj();
  protected String[] hLF = aDi();
  
  public final boolean Cm(String paramString)
  {
    boolean bool2 = false;
    bc.aCg();
    SharedPreferences localSharedPreferences = c.xF("banner");
    boolean bool1 = bool2;
    if (localSharedPreferences != null)
    {
      bool1 = bool2;
      if (localSharedPreferences.getBoolean(this.hLE + paramString, false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final void Cn(String paramString)
  {
    bc.aCg();
    SharedPreferences localSharedPreferences = c.xF("banner");
    if (localSharedPreferences == null) {}
    do
    {
      return;
      localSharedPreferences.edit().remove(this.hLE + paramString).commit();
      if (this.hLF != null)
      {
        String[] arrayOfString = this.hLF;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if (str != null) {
            localSharedPreferences.edit().remove(this.hLE + str + paramString).commit();
          }
          i += 1;
        }
      }
    } while (this.hLD == null);
    this.hLD.aDw();
  }
  
  public final void a(e.a parama)
  {
    this.hLD = parama;
  }
  
  public final void a(String paramString, boolean paramBoolean, String[] paramArrayOfString)
  {
    bc.aCg();
    SharedPreferences localSharedPreferences = c.xF("banner");
    if (localSharedPreferences == null) {}
    label188:
    do
    {
      return;
      localSharedPreferences.edit().putBoolean(this.hLE + paramString, paramBoolean).commit();
      if ((this.hLF != null) && (paramArrayOfString != null) && (this.hLF.length == paramArrayOfString.length))
      {
        String[] arrayOfString = this.hLF;
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
            localSharedPreferences.edit().putString(this.hLE + str2 + paramString, str1).commit();
            j += 1;
            i += 1;
            break;
          }
        }
      }
    } while (this.hLD == null);
    this.hLD.aDv();
  }
  
  protected String[] aDi()
  {
    return null;
  }
  
  public abstract String aDj();
  
  public final String aQ(String paramString1, String paramString2)
  {
    bc.aCg();
    SharedPreferences localSharedPreferences = c.xF("banner");
    if (localSharedPreferences == null) {
      return null;
    }
    return localSharedPreferences.getString(this.hLE + paramString2 + paramString1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.b.a
 * JD-Core Version:    0.7.0.1
 */
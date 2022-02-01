package com.tencent.mm.model.b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;

public abstract class a
  implements e
{
  protected e.a oog;
  protected String ooh = bDT();
  protected String[] ooi = bDS();
  
  public final boolean Ks(String paramString)
  {
    boolean bool2 = false;
    bh.bCz();
    SharedPreferences localSharedPreferences = c.Fz("banner");
    boolean bool1 = bool2;
    if (localSharedPreferences != null)
    {
      bool1 = bool2;
      if (localSharedPreferences.getBoolean(this.ooh + paramString, false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final void Kt(String paramString)
  {
    bh.bCz();
    SharedPreferences localSharedPreferences = c.Fz("banner");
    if (localSharedPreferences == null) {}
    do
    {
      return;
      localSharedPreferences.edit().remove(this.ooh + paramString).commit();
      if (this.ooi != null)
      {
        String[] arrayOfString = this.ooi;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if (str != null) {
            localSharedPreferences.edit().remove(this.ooh + str + paramString).commit();
          }
          i += 1;
        }
      }
    } while (this.oog == null);
    this.oog.bEg();
  }
  
  public final void a(e.a parama)
  {
    this.oog = parama;
  }
  
  public final void a(String paramString, boolean paramBoolean, String[] paramArrayOfString)
  {
    bh.bCz();
    SharedPreferences localSharedPreferences = c.Fz("banner");
    if (localSharedPreferences == null) {}
    label188:
    do
    {
      return;
      localSharedPreferences.edit().putBoolean(this.ooh + paramString, paramBoolean).commit();
      if ((this.ooi != null) && (paramArrayOfString != null) && (this.ooi.length == paramArrayOfString.length))
      {
        String[] arrayOfString = this.ooi;
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
            localSharedPreferences.edit().putString(this.ooh + str2 + paramString, str1).commit();
            j += 1;
            i += 1;
            break;
          }
        }
      }
    } while (this.oog == null);
    this.oog.bEf();
  }
  
  protected String[] bDS()
  {
    return null;
  }
  
  public abstract String bDT();
  
  public final String bi(String paramString1, String paramString2)
  {
    bh.bCz();
    SharedPreferences localSharedPreferences = c.Fz("banner");
    if (localSharedPreferences == null) {
      return null;
    }
    return localSharedPreferences.getString(this.ooh + paramString2 + paramString1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.b.a
 * JD-Core Version:    0.7.0.1
 */
package com.tencent.mm.model.b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;

public abstract class a
  implements e
{
  protected e.a dYm;
  protected String dYn = IA();
  protected String[] dYo = Iz();
  
  public abstract String IA();
  
  protected String[] Iz()
  {
    return null;
  }
  
  public final void a(e.a parama)
  {
    this.dYm = parama;
  }
  
  public final void a(String paramString, boolean paramBoolean, String[] paramArrayOfString)
  {
    au.Hx();
    SharedPreferences localSharedPreferences = c.gh("banner");
    if (localSharedPreferences == null) {}
    label188:
    do
    {
      return;
      localSharedPreferences.edit().putBoolean(this.dYn + paramString, paramBoolean).commit();
      if ((this.dYo != null) && (paramArrayOfString != null) && (this.dYo.length == paramArrayOfString.length))
      {
        String[] arrayOfString = this.dYo;
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
            localSharedPreferences.edit().putString(this.dYn + str2 + paramString, str1).commit();
            j += 1;
            i += 1;
            break;
          }
        }
      }
    } while (this.dYm == null);
    this.dYm.IM();
  }
  
  public final String ac(String paramString1, String paramString2)
  {
    au.Hx();
    SharedPreferences localSharedPreferences = c.gh("banner");
    if (localSharedPreferences == null) {
      return null;
    }
    return localSharedPreferences.getString(this.dYn + paramString2 + paramString1, null);
  }
  
  public final boolean jd(String paramString)
  {
    boolean bool2 = false;
    au.Hx();
    SharedPreferences localSharedPreferences = c.gh("banner");
    boolean bool1 = bool2;
    if (localSharedPreferences != null)
    {
      bool1 = bool2;
      if (localSharedPreferences.getBoolean(this.dYn + paramString, false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final void je(String paramString)
  {
    au.Hx();
    SharedPreferences localSharedPreferences = c.gh("banner");
    if (localSharedPreferences == null) {}
    do
    {
      return;
      localSharedPreferences.edit().remove(this.dYn + paramString).commit();
      if (this.dYo != null)
      {
        String[] arrayOfString = this.dYo;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if (str != null) {
            localSharedPreferences.edit().remove(this.dYn + str + paramString).commit();
          }
          i += 1;
        }
      }
    } while (this.dYm == null);
    this.dYm.IN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.model.b.a
 * JD-Core Version:    0.7.0.1
 */
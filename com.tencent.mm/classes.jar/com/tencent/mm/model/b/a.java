package com.tencent.mm.model.b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;

public abstract class a
  implements e
{
  protected e.a iGF;
  protected String iGG = aWV();
  protected String[] iGH = aWU();
  
  public final boolean KX(String paramString)
  {
    boolean bool2 = false;
    bg.aVF();
    SharedPreferences localSharedPreferences = c.FQ("banner");
    boolean bool1 = bool2;
    if (localSharedPreferences != null)
    {
      bool1 = bool2;
      if (localSharedPreferences.getBoolean(this.iGG + paramString, false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final void KY(String paramString)
  {
    bg.aVF();
    SharedPreferences localSharedPreferences = c.FQ("banner");
    if (localSharedPreferences == null) {}
    do
    {
      return;
      localSharedPreferences.edit().remove(this.iGG + paramString).commit();
      if (this.iGH != null)
      {
        String[] arrayOfString = this.iGH;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if (str != null) {
            localSharedPreferences.edit().remove(this.iGG + str + paramString).commit();
          }
          i += 1;
        }
      }
    } while (this.iGF == null);
    this.iGF.aXi();
  }
  
  public final void a(e.a parama)
  {
    this.iGF = parama;
  }
  
  public final void a(String paramString, boolean paramBoolean, String[] paramArrayOfString)
  {
    bg.aVF();
    SharedPreferences localSharedPreferences = c.FQ("banner");
    if (localSharedPreferences == null) {}
    label188:
    do
    {
      return;
      localSharedPreferences.edit().putBoolean(this.iGG + paramString, paramBoolean).commit();
      if ((this.iGH != null) && (paramArrayOfString != null) && (this.iGH.length == paramArrayOfString.length))
      {
        String[] arrayOfString = this.iGH;
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
            localSharedPreferences.edit().putString(this.iGG + str2 + paramString, str1).commit();
            j += 1;
            i += 1;
            break;
          }
        }
      }
    } while (this.iGF == null);
    this.iGF.aXh();
  }
  
  public final String aU(String paramString1, String paramString2)
  {
    bg.aVF();
    SharedPreferences localSharedPreferences = c.FQ("banner");
    if (localSharedPreferences == null) {
      return null;
    }
    return localSharedPreferences.getString(this.iGG + paramString2 + paramString1, null);
  }
  
  protected String[] aWU()
  {
    return null;
  }
  
  public abstract String aWV();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.model.b.a
 * JD-Core Version:    0.7.0.1
 */
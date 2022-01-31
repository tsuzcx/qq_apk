package com.tencent.mm.model.b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;

public abstract class a
  implements e
{
  protected e.a foq;
  protected String jdField_for = aby();
  protected String[] fos = abx();
  
  public final void a(e.a parama)
  {
    this.foq = parama;
  }
  
  public final void a(String paramString, boolean paramBoolean, String[] paramArrayOfString)
  {
    aw.aaz();
    SharedPreferences localSharedPreferences = c.mC("banner");
    if (localSharedPreferences == null) {}
    label188:
    do
    {
      return;
      localSharedPreferences.edit().putBoolean(this.jdField_for + paramString, paramBoolean).commit();
      if ((this.fos != null) && (paramArrayOfString != null) && (this.fos.length == paramArrayOfString.length))
      {
        String[] arrayOfString = this.fos;
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
            localSharedPreferences.edit().putString(this.jdField_for + str2 + paramString, str1).commit();
            j += 1;
            i += 1;
            break;
          }
        }
      }
    } while (this.foq == null);
    this.foq.abJ();
  }
  
  protected String[] abx()
  {
    return null;
  }
  
  public abstract String aby();
  
  public final String as(String paramString1, String paramString2)
  {
    aw.aaz();
    SharedPreferences localSharedPreferences = c.mC("banner");
    if (localSharedPreferences == null) {
      return null;
    }
    return localSharedPreferences.getString(this.jdField_for + paramString2 + paramString1, null);
  }
  
  public final boolean pR(String paramString)
  {
    boolean bool2 = false;
    aw.aaz();
    SharedPreferences localSharedPreferences = c.mC("banner");
    boolean bool1 = bool2;
    if (localSharedPreferences != null)
    {
      bool1 = bool2;
      if (localSharedPreferences.getBoolean(this.jdField_for + paramString, false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final void pS(String paramString)
  {
    aw.aaz();
    SharedPreferences localSharedPreferences = c.mC("banner");
    if (localSharedPreferences == null) {}
    do
    {
      return;
      localSharedPreferences.edit().remove(this.jdField_for + paramString).commit();
      if (this.fos != null)
      {
        String[] arrayOfString = this.fos;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if (str != null) {
            localSharedPreferences.edit().remove(this.jdField_for + str + paramString).commit();
          }
          i += 1;
        }
      }
    } while (this.foq == null);
    this.foq.abK();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.model.b.a
 * JD-Core Version:    0.7.0.1
 */
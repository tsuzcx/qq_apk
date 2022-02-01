package com.tencent.mm.model.b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;

public abstract class a
  implements e
{
  protected e.a gPS;
  protected String gPT = asZ();
  protected String[] gPU = asY();
  
  public final void a(e.a parama)
  {
    this.gPS = parama;
  }
  
  public final void a(String paramString, boolean paramBoolean, String[] paramArrayOfString)
  {
    az.arV();
    SharedPreferences localSharedPreferences = c.qR("banner");
    if (localSharedPreferences == null) {}
    label188:
    do
    {
      return;
      localSharedPreferences.edit().putBoolean(this.gPT + paramString, paramBoolean).commit();
      if ((this.gPU != null) && (paramArrayOfString != null) && (this.gPU.length == paramArrayOfString.length))
      {
        String[] arrayOfString = this.gPU;
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
            localSharedPreferences.edit().putString(this.gPT + str2 + paramString, str1).commit();
            j += 1;
            i += 1;
            break;
          }
        }
      }
    } while (this.gPS == null);
    this.gPS.atl();
  }
  
  public final String aH(String paramString1, String paramString2)
  {
    az.arV();
    SharedPreferences localSharedPreferences = c.qR("banner");
    if (localSharedPreferences == null) {
      return null;
    }
    return localSharedPreferences.getString(this.gPT + paramString2 + paramString1, null);
  }
  
  protected String[] asY()
  {
    return null;
  }
  
  public abstract String asZ();
  
  public final boolean uF(String paramString)
  {
    boolean bool2 = false;
    az.arV();
    SharedPreferences localSharedPreferences = c.qR("banner");
    boolean bool1 = bool2;
    if (localSharedPreferences != null)
    {
      bool1 = bool2;
      if (localSharedPreferences.getBoolean(this.gPT + paramString, false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final void uG(String paramString)
  {
    az.arV();
    SharedPreferences localSharedPreferences = c.qR("banner");
    if (localSharedPreferences == null) {}
    do
    {
      return;
      localSharedPreferences.edit().remove(this.gPT + paramString).commit();
      if (this.gPU != null)
      {
        String[] arrayOfString = this.gPU;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if (str != null) {
            localSharedPreferences.edit().remove(this.gPT + str + paramString).commit();
          }
          i += 1;
        }
      }
    } while (this.gPS == null);
    this.gPS.atm();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.model.b.a
 * JD-Core Version:    0.7.0.1
 */
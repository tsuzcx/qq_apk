package com.tencent.mm.model.b;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;

public abstract class a
  implements e
{
  protected e.a hIK;
  protected String hIL = aCT();
  protected String[] hIM = aCS();
  
  public final boolean BK(String paramString)
  {
    boolean bool2 = false;
    ba.aBQ();
    SharedPreferences localSharedPreferences = c.wW("banner");
    boolean bool1 = bool2;
    if (localSharedPreferences != null)
    {
      bool1 = bool2;
      if (localSharedPreferences.getBoolean(this.hIL + paramString, false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public final void BL(String paramString)
  {
    ba.aBQ();
    SharedPreferences localSharedPreferences = c.wW("banner");
    if (localSharedPreferences == null) {}
    do
    {
      return;
      localSharedPreferences.edit().remove(this.hIL + paramString).commit();
      if (this.hIM != null)
      {
        String[] arrayOfString = this.hIM;
        int j = arrayOfString.length;
        int i = 0;
        while (i < j)
        {
          String str = arrayOfString[i];
          if (str != null) {
            localSharedPreferences.edit().remove(this.hIL + str + paramString).commit();
          }
          i += 1;
        }
      }
    } while (this.hIK == null);
    this.hIK.aDg();
  }
  
  public final void a(e.a parama)
  {
    this.hIK = parama;
  }
  
  public final void a(String paramString, boolean paramBoolean, String[] paramArrayOfString)
  {
    ba.aBQ();
    SharedPreferences localSharedPreferences = c.wW("banner");
    if (localSharedPreferences == null) {}
    label188:
    do
    {
      return;
      localSharedPreferences.edit().putBoolean(this.hIL + paramString, paramBoolean).commit();
      if ((this.hIM != null) && (paramArrayOfString != null) && (this.hIM.length == paramArrayOfString.length))
      {
        String[] arrayOfString = this.hIM;
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
            localSharedPreferences.edit().putString(this.hIL + str2 + paramString, str1).commit();
            j += 1;
            i += 1;
            break;
          }
        }
      }
    } while (this.hIK == null);
    this.hIK.aDf();
  }
  
  protected String[] aCS()
  {
    return null;
  }
  
  public abstract String aCT();
  
  public final String aQ(String paramString1, String paramString2)
  {
    ba.aBQ();
    SharedPreferences localSharedPreferences = c.wW("banner");
    if (localSharedPreferences == null) {
      return null;
    }
    return localSharedPreferences.getString(this.hIL + paramString2 + paramString1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.model.b.a
 * JD-Core Version:    0.7.0.1
 */
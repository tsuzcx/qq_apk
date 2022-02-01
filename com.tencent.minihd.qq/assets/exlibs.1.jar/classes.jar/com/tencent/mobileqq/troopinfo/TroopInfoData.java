package com.tencent.mobileqq.troopinfo;

import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.util.Utils;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class TroopInfoData
{
  public static final String a = "TroopInfoData";
  private static final int s = 1;
  private static final int t = 2;
  private static final int u = 4;
  private static final int v = 8;
  public byte a;
  public int a;
  public long a;
  public List a;
  public short a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public List b;
  public short b;
  public boolean b;
  public int c;
  public long c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public boolean d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public int h;
  public String h;
  public int i;
  public String i;
  public int j;
  public String j;
  public int k;
  public String k;
  public int l;
  public String l;
  public int m;
  public String m;
  public int n;
  public String n;
  public int o;
  public String o;
  public int p;
  public String p;
  public int q;
  public String q;
  public int r;
  public String r;
  public String s;
  public String t;
  public String u;
  public String v = "";
  private int w;
  
  public TroopInfoData()
  {
    this.jdField_a_of_type_Long = -1L;
    this.jdField_a_of_type_Byte = 0;
    this.jdField_d_of_type_Int = 0;
    this.jdField_e_of_type_Int = 0;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_c_of_type_Long = 0L;
    this.jdField_h_of_type_Int = 0;
    this.jdField_i_of_type_Int = 0;
    this.jdField_j_of_type_Int = 0;
    this.jdField_k_of_type_Int = 0;
    this.jdField_l_of_type_Int = 0;
    this.jdField_m_of_type_Int = 0;
    this.jdField_q_of_type_Int = -1;
    this.jdField_r_of_type_Int = -1;
    this.w |= 0x4;
    this.w |= 0x2;
  }
  
  public int a()
  {
    if (this.jdField_b_of_type_Int == 0) {
      switch (this.jdField_a_of_type_Int)
      {
      }
    }
    for (;;)
    {
      return this.jdField_b_of_type_Int;
      this.jdField_b_of_type_Int = 10;
      continue;
      this.jdField_b_of_type_Int = 11;
      continue;
      this.jdField_b_of_type_Int = 12;
      continue;
      this.jdField_b_of_type_Int = 26;
      continue;
      this.jdField_b_of_type_Int = 14;
      continue;
      this.jdField_b_of_type_Int = 19;
      continue;
      this.jdField_b_of_type_Int = 21;
      continue;
      this.jdField_b_of_type_Int = 31;
      continue;
      this.jdField_b_of_type_Int = 3;
      continue;
      this.jdField_b_of_type_Int = 24;
      continue;
      this.jdField_b_of_type_Int = 18;
      continue;
      this.jdField_b_of_type_Int = 13;
      continue;
      this.jdField_b_of_type_Int = 15;
      continue;
      this.jdField_b_of_type_Int = 30;
    }
  }
  
  public String a()
  {
    if (!TextUtils.isEmpty(this.jdField_q_of_type_JavaLangString)) {}
    for (String str1 = this.jdField_q_of_type_JavaLangString;; str1 = this.jdField_p_of_type_JavaLangString)
    {
      String str2 = str1;
      if (TextUtils.isEmpty(str1)) {
        str2 = "";
      }
      return str2;
    }
  }
  
  public void a(TroopInfo paramTroopInfo, Resources paramResources, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopInfoData", 2, "updateTroopInfoData(), troopinfo = " + paramTroopInfo);
    }
    long l1 = System.currentTimeMillis();
    if (paramTroopInfo != null)
    {
      this.jdField_d_of_type_JavaLangString = paramTroopInfo.troopcode;
      this.jdField_b_of_type_Short = paramTroopInfo.troopface;
      this.f = paramTroopInfo.troopname;
      this.jdField_a_of_type_Short = paramTroopInfo.cGroupOption;
      this.jdField_e_of_type_JavaLangString = paramTroopInfo.troopmemo;
      this.jdField_l_of_type_JavaLangString = paramTroopInfo.fingertroopmemo;
      this.jdField_m_of_type_JavaLangString = paramTroopInfo.mRichFingerMemo;
      this.jdField_a_of_type_Long = paramTroopInfo.dwGroupClassExt;
      this.jdField_c_of_type_Int = paramTroopInfo.wMemberNum;
      this.jdField_h_of_type_JavaLangString = String.format(paramResources.getString(2131367724), new Object[] { Integer.valueOf(paramTroopInfo.wMemberNum) });
      this.u = String.format(paramResources.getString(2131367724), new Object[] { Integer.valueOf(paramTroopInfo.wMemberMax) });
      this.jdField_r_of_type_JavaLangString = paramTroopInfo.joinTroopQuestion;
      this.s = paramTroopInfo.joinTroopAnswer;
      switch (paramTroopInfo.cGroupOption)
      {
      default: 
        if (!Utils.a(this.jdField_p_of_type_JavaLangString, paramTroopInfo.troopowneruin))
        {
          this.jdField_p_of_type_JavaLangString = paramTroopInfo.troopowneruin;
          this.jdField_q_of_type_JavaLangString = null;
          a(paramString);
        }
        if (!Utils.a(this.o, paramTroopInfo.Administrator))
        {
          this.o = paramTroopInfo.Administrator;
          b(paramString);
        }
        this.jdField_d_of_type_Boolean = paramTroopInfo.mMemberInvitingFlag;
        this.jdField_b_of_type_Short = paramTroopInfo.troopface;
        this.jdField_a_of_type_Byte = paramTroopInfo.cGroupRankSysFlag;
        if (paramTroopInfo.cAlbumResult != 33) {
          break;
        }
      }
    }
    for (this.w &= 0xFFFFFFFB;; this.w |= 0x4)
    {
      this.jdField_b_of_type_JavaUtilList = paramTroopInfo.getQZonePhotoUrls();
      this.jdField_b_of_type_Long = paramTroopInfo.dwGroupFlagExt;
      this.t = paramTroopInfo.troopAuthenticateInfo;
      this.jdField_c_of_type_Long = paramTroopInfo.dwAuthGroupType;
      this.jdField_n_of_type_Int = paramTroopInfo.nTroopGrade;
      this.jdField_k_of_type_JavaLangString = paramTroopInfo.strLocation;
      if ((paramTroopInfo.troopLat != 0) && (paramTroopInfo.troopLon != 0))
      {
        this.jdField_d_of_type_Int = paramTroopInfo.troopLat;
        this.jdField_e_of_type_Int = paramTroopInfo.troopLon;
      }
      this.jdField_q_of_type_Int = paramTroopInfo.isShowInNearbyTroops;
      if (QLog.isColorLevel()) {
        QLog.i("TroopInfoData", 2, "updateTroopInfoData: time = " + (System.currentTimeMillis() - l1));
      }
      return;
      this.jdField_n_of_type_JavaLangString = paramResources.getString(2131366343);
      break;
      this.jdField_n_of_type_JavaLangString = paramResources.getString(2131366344);
      break;
      this.jdField_n_of_type_JavaLangString = paramResources.getString(2131366345);
      break;
    }
  }
  
  public void a(TroopInfo paramTroopInfo, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("TroopInfoData", 2, "updateTroopInfoData(), troopinfo = " + paramTroopInfo);
    }
    long l1 = System.currentTimeMillis();
    if (paramTroopInfo != null)
    {
      this.jdField_d_of_type_JavaLangString = paramTroopInfo.troopcode;
      this.jdField_b_of_type_Short = paramTroopInfo.troopface;
      this.f = paramTroopInfo.troopname;
      this.jdField_a_of_type_Short = paramTroopInfo.cGroupOption;
      this.jdField_r_of_type_JavaLangString = paramTroopInfo.joinTroopQuestion;
      this.s = paramTroopInfo.joinTroopAnswer;
      this.jdField_e_of_type_JavaLangString = paramTroopInfo.troopmemo;
      this.jdField_l_of_type_JavaLangString = paramTroopInfo.fingertroopmemo;
      this.jdField_m_of_type_JavaLangString = paramTroopInfo.mRichFingerMemo;
      if ((this.jdField_i_of_type_JavaLangString == null) || (this.jdField_a_of_type_Long != paramTroopInfo.dwGroupClassExt))
      {
        this.jdField_a_of_type_Long = paramTroopInfo.dwGroupClassExt;
        this.jdField_i_of_type_JavaLangString = null;
      }
      if (this.jdField_j_of_type_JavaLangString == null) {
        this.jdField_j_of_type_JavaLangString = paramTroopInfo.mGroupClassExtText;
      }
      if (!Utils.a(this.jdField_p_of_type_JavaLangString, paramTroopInfo.troopowneruin))
      {
        this.jdField_p_of_type_JavaLangString = paramTroopInfo.troopowneruin;
        this.jdField_q_of_type_JavaLangString = null;
        a(paramString);
      }
      if (!Utils.a(this.o, paramTroopInfo.Administrator))
      {
        this.o = paramTroopInfo.Administrator;
        b(paramString);
      }
      if ((!this.jdField_b_of_type_Boolean) && ((paramTroopInfo.dwAdditionalFlag & 1L) == 1L)) {
        this.jdField_b_of_type_Boolean = true;
      }
      if ((!this.jdField_c_of_type_Boolean) && ((paramTroopInfo.dwCmdUinUinFlag & 1L) == 1L)) {
        this.jdField_c_of_type_Boolean = true;
      }
      this.jdField_k_of_type_JavaLangString = paramTroopInfo.strLocation;
      if ((paramTroopInfo.troopLat != 0) && (paramTroopInfo.troopLon != 0))
      {
        this.jdField_d_of_type_Int = paramTroopInfo.troopLat;
        this.jdField_e_of_type_Int = paramTroopInfo.troopLon;
      }
      this.jdField_b_of_type_Long = paramTroopInfo.dwGroupFlagExt;
      this.t = paramTroopInfo.troopAuthenticateInfo;
      this.jdField_c_of_type_Long = paramTroopInfo.dwAuthGroupType;
      this.jdField_a_of_type_JavaUtilList = TroopInfo.getTags(paramTroopInfo.mTags);
      this.jdField_q_of_type_Int = paramTroopInfo.isShowInNearbyTroops;
      this.jdField_r_of_type_Int = paramTroopInfo.troopTypeExt;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopInfoData", 2, "updateTroopInfoData: time = " + (System.currentTimeMillis() - l1));
    }
  }
  
  public void a(String paramString)
  {
    this.jdField_b_of_type_Boolean = Utils.a(paramString, this.jdField_p_of_type_JavaLangString);
    if (this.jdField_b_of_type_Boolean) {
      this.jdField_c_of_type_Boolean = true;
    }
  }
  
  public void a(String paramString1, int paramInt, String paramString2, Resources paramResources)
  {
    this.o = paramString1;
    b(paramString2);
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_h_of_type_JavaLangString = String.format(paramResources.getString(2131367724), new Object[] { Integer.valueOf(paramInt) });
  }
  
  public void a(String paramString1, String paramString2)
  {
    this.jdField_p_of_type_JavaLangString = paramString1;
    this.jdField_q_of_type_JavaLangString = null;
    b(paramString2);
    a(paramString2);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.w |= 0x1;
      return;
    }
    this.w &= 0xFFFFFFFE;
  }
  
  public boolean a()
  {
    return (this.w & 0x1) == 1;
  }
  
  public void b(String paramString)
  {
    if (paramString.equals(this.jdField_p_of_type_JavaLangString)) {
      this.jdField_c_of_type_Boolean = true;
    }
    for (;;)
    {
      return;
      if ((!this.jdField_c_of_type_Boolean) && (!TextUtils.isEmpty(this.o)))
      {
        String[] arrayOfString = this.o.split("\\|");
        if (arrayOfString == null) {
          break;
        }
        int i2 = arrayOfString.length;
        int i1 = 0;
        while (i1 < i2)
        {
          if (arrayOfString[i1].equalsIgnoreCase(paramString))
          {
            this.jdField_c_of_type_Boolean = true;
            return;
          }
          i1 += 1;
        }
      }
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.w |= 0x8;
      return;
    }
    this.w &= 0xFFFFFFF7;
  }
  
  public boolean b()
  {
    return (this.w & 0x8) == 8;
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.w |= 0x2;
      return;
    }
    this.w &= 0xFFFFFFFD;
  }
  
  public boolean c()
  {
    return (this.w & 0x2) == 2;
  }
  
  public boolean d()
  {
    return (this.w & 0x4) == 4;
  }
  
  public boolean e()
  {
    return (this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean);
  }
  
  public boolean f()
  {
    return (this.jdField_b_of_type_Boolean) || (this.jdField_c_of_type_Boolean) || (this.jdField_d_of_type_Boolean);
  }
  
  public boolean g()
  {
    return !TextUtils.isEmpty(this.jdField_p_of_type_JavaLangString);
  }
  
  public boolean h()
  {
    return ((this.jdField_p_of_type_Int & 0x80000) != 0) || ((this.jdField_p_of_type_Int & 0x4000) != 0);
  }
  
  public boolean i()
  {
    return (this.jdField_b_of_type_Long & 0x800000) == 8388608L;
  }
  
  public boolean j()
  {
    return (this.jdField_b_of_type_Long & 0x10000000) == 268435456L;
  }
  
  public boolean k()
  {
    if (this.jdField_q_of_type_Int == -1) {
      if ((this.jdField_b_of_type_Long & 0x8000000) == 134217728L) {}
    }
    while (this.jdField_q_of_type_Int == 0)
    {
      return true;
      return false;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troopinfo.TroopInfoData
 * JD-Core Version:    0.7.0.1
 */
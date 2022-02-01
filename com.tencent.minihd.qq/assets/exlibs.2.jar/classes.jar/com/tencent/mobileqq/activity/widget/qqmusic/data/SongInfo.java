package com.tencent.mobileqq.activity.widget.qqmusic.data;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.widget.qqmusic.business.player.SongSwitch;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.ColorSet;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MusicUtil;
import com.tencent.qqmusic.urlmanager.SongUrlFactory;
import org.json.JSONObject;

public class SongInfo
{
  public static final int a = 0;
  public static final int b = 2;
  public static final int c = 4;
  public static final int d = 6;
  public static final int e = 8;
  public static final int f = 21;
  public static final int g = 11;
  public static final int h = 10;
  public static final int i = 1;
  public static final int j = 2;
  public static final int k = 1;
  public static final int l = 2;
  public static final int m = 3;
  public static final int n = 24;
  public static final int o = 48;
  public static final int p = 96;
  public static final int q = 128;
  public static final int r = 192;
  public static final int s = 320;
  public static final int t = 700;
  public static final int u = 800;
  private int A = 0;
  private int B = 0;
  private int C = 0;
  private int D = 0;
  private int E;
  private long jdField_a_of_type_Long = 0L;
  private SongSwitch jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessPlayerSongSwitch = null;
  private ID3 jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicDataID3 = new ID3();
  private String jdField_a_of_type_JavaLangString = "";
  private long jdField_b_of_type_Long = 0L;
  private String jdField_b_of_type_JavaLangString = "";
  private long jdField_c_of_type_Long = 0L;
  private String jdField_c_of_type_JavaLangString;
  private String d;
  private int v;
  private int w = 0;
  private int x = 0;
  private int y = 0;
  private int z = 0;
  
  public static int a(int paramInt)
  {
    return 1;
  }
  
  private String h()
  {
    return MusicUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicDataID3.a()).jdField_a_of_type_JavaLangString;
  }
  
  private String i()
  {
    return MusicUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicDataID3.b()).jdField_a_of_type_JavaLangString;
  }
  
  private String j()
  {
    if (!"未知专辑".equals(this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicDataID3.c())) {
      return MusicUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicDataID3.c()).jdField_a_of_type_JavaLangString;
    }
    return "";
  }
  
  public int a()
  {
    return this.A;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 1) {
      if ((c()) && (!e())) {}
    }
    while ((paramInt1 != 2) || ((d()) && (paramInt2 == 1) && (i())) || (!d()))
    {
      do
      {
        return 0;
      } while (((c()) && (paramInt2 == 1) && (h())) || (!c()));
      return 1;
    }
    return 1;
  }
  
  public long a()
  {
    return this.jdField_c_of_type_Long;
  }
  
  public SongSwitch a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessPlayerSongSwitch == null) {
      return new SongSwitch(this.A);
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessPlayerSongSwitch;
  }
  
  public String a()
  {
    return this.jdField_b_of_type_JavaLangString;
  }
  
  public String a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Long >= 0L) && (j())) {
      return SongUrlFactory.a(this, 2, paramBoolean);
    }
    return "";
  }
  
  public void a(int paramInt)
  {
    int i1 = 4;
    if (paramInt == 5) {
      paramInt = 21;
    }
    for (;;)
    {
      this.E = paramInt;
      if (this.E == 6) {
        this.E = 2;
      }
      return;
      if (paramInt > 0) {
        if (paramInt == 1) {
          i1 = 2;
        }
      }
      for (;;)
      {
        paramInt = i1;
        if (this.x != 1) {
          break;
        }
        paramInt = i1;
        if (i1 != 2) {
          break;
        }
        if (this.y <= 0) {
          break label85;
        }
        paramInt = 6;
        break;
        if (this.jdField_a_of_type_Long >= 0L) {
          i1 = 2;
        }
      }
      label85:
      paramInt = 8;
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      this.jdField_c_of_type_JavaLangString = "";
      return;
    }
    this.jdField_c_of_type_JavaLangString = paramString.trim();
  }
  
  public void a(String paramString1, String paramString2, String paramString3)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicDataID3.c(paramString1);
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicDataID3.a(paramString2);
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicDataID3.b(paramString3);
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    this.jdField_a_of_type_Long = paramJSONObject.optLong("songid");
    this.jdField_a_of_type_JavaLangString = MusicUtil.b(paramJSONObject.optString("songname"));
    this.v = paramJSONObject.optInt("songtype");
    this.jdField_b_of_type_JavaLangString = MusicUtil.b(paramJSONObject.optString("singername"));
    this.jdField_b_of_type_Long = paramJSONObject.optLong("albumid");
    this.w = paramJSONObject.optInt("playtime");
    this.x = paramJSONObject.optInt("nGoSoso");
    this.y = paramJSONObject.optInt("n128Size");
    this.A = paramJSONObject.optInt("switch");
    this.B = paramJSONObject.optInt("payDownload");
    this.C = paramJSONObject.optInt("tryBegin");
    this.D = paramJSONObject.optInt("tryEnd");
    this.jdField_c_of_type_JavaLangString = paramJSONObject.optString("songmid");
    this.jdField_c_of_type_Long = paramJSONObject.optLong("singerid");
    this.d = MusicUtil.b(paramJSONObject.optString("albumname"));
    a(this.jdField_c_of_type_JavaLangString);
    a(this.v);
    a(this.d, this.jdField_a_of_type_JavaLangString, this.jdField_b_of_type_JavaLangString);
  }
  
  public boolean a()
  {
    return (this.E == 2) || (this.E == 6) || (this.E == 8);
  }
  
  public int b()
  {
    if (this.E == 6) {
      this.E = 2;
    }
    return this.E;
  }
  
  public long b()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String b()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void b(int paramInt)
  {
    this.A = paramInt;
    this.jdField_a_of_type_ComTencentMobileqqActivityWidgetQqmusicBusinessPlayerSongSwitch = new SongSwitch(this.A);
  }
  
  public boolean b()
  {
    return this.E == 4;
  }
  
  public String c()
  {
    return this.d;
  }
  
  public boolean c()
  {
    return this.z == 1;
  }
  
  public String d()
  {
    return this.jdField_c_of_type_JavaLangString;
  }
  
  public boolean d()
  {
    return this.B == 1;
  }
  
  public String e()
  {
    return h();
  }
  
  public boolean e()
  {
    return (!g()) && (f());
  }
  
  public String f()
  {
    return i();
  }
  
  public boolean f()
  {
    return (a().o()) && (this.D - this.C > 0);
  }
  
  public String g()
  {
    return j();
  }
  
  public boolean g()
  {
    return h();
  }
  
  public boolean h()
  {
    return a().b();
  }
  
  public boolean i()
  {
    return a().e();
  }
  
  public boolean j()
  {
    return (this.E == 2) || (this.E == 6);
  }
  
  public boolean k()
  {
    if (a().a()) {
      return a().i();
    }
    return false;
  }
  
  public String toString()
  {
    return "SongInfo{id=" + this.jdField_a_of_type_Long + ", songname=" + this.jdField_a_of_type_JavaLangString + ", singername=" + this.jdField_b_of_type_JavaLangString + ", songtype=" + this.v + ", albumid=" + this.jdField_b_of_type_Long + ", playtime" + this.w + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.data.SongInfo
 * JD-Core Version:    0.7.0.1
 */
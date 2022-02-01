package sm;

import java.io.Serializable;

public final class i
  implements Serializable
{
  public static final i A;
  public static final i B;
  public static final i C;
  public static final i D;
  public static final i E;
  public static final i F;
  public static final i G;
  public static final i H;
  public static final i I;
  public static final i J;
  public static final i K;
  private static i[] M;
  public static final i a;
  public static final i b;
  public static final i c;
  public static final i d;
  public static final i e;
  public static final i f;
  public static final i g;
  public static final i h;
  public static final i i;
  public static final i j;
  public static final i k;
  public static final i l;
  public static final i m;
  public static final i n;
  public static final i o;
  public static final i p;
  public static final i q;
  public static final i r;
  public static final i s;
  public static final i t;
  public static final i u;
  public static final i v;
  public static final i w;
  public static final i x;
  public static final i y;
  public static final i z;
  private int N;
  private String O = new String();
  
  static
  {
    if (!i.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      L = bool;
      M = new i[37];
      a = new i(0, 0, "EP_None");
      b = new i(1, 1, "EP_Secure");
      c = new i(2, 2, "EP_Phonebook");
      d = new i(3, 3, "EP_Pim");
      e = new i(4, 4, "EP_QQPhonebook");
      f = new i(5, 5, "EP_QZone");
      g = new i(6, 6, "EP_MobileQQ_Secure");
      h = new i(7, 7, "EP_QQBrowse_Secure");
      i = new i(8, 8, "EP_XiaoYou");
      j = new i(9, 9, "EP_Secure_Eng");
      k = new i(10, 10, "EP_WBlog");
      l = new i(11, 11, "EP_Phonebook_Eng");
      m = new i(12, 12, "EP_AppAssistant");
      n = new i(13, 13, "EP_Secure_SDK");
      o = new i(14, 14, "EP_KingRoot");
      p = new i(15, 15, "EP_Secure_SDK_Pay");
      q = new i(16, 16, "EP_Secure_Jailbreak");
      r = new i(17, 17, "EP_KingUser");
      s = new i(18, 18, "EP_Pim_Pro");
      t = new i(19, 19, "EP_Pim_Jailbreak");
      u = new i(20, 20, "EP_PhonebookPro");
      v = new i(21, 21, "EP_PowerManager");
      w = new i(22, 22, "EP_BenchMark");
      x = new i(23, 23, "EP_SecurePro_Enhance");
      y = new i(24, 24, "EP_Pim_Eng");
      z = new i(25, 25, "EP_SMS_Fraud_Killer");
      A = new i(26, 26, "EP_King_SuperUser");
      B = new i(27, 27, "EP_Secure_SDK_Ign");
      C = new i(28, 28, "EP_Tracker");
      D = new i(29, 29, "EP_TencentUser");
      E = new i(30, 30, "EP_Album");
      F = new i(31, 31, "EP_WeShare");
      G = new i(32, 32, "EP_Tencent_Cleaner");
      H = new i(33, 35, "EP_Secure_Mini");
      I = new i(34, 40, "EP_GameAssistant_SDK");
      J = new i(35, 41, "EP_QQDownloader_SDK");
      K = new i(36, 42, "EP_END");
      return;
    }
  }
  
  private i(int paramInt1, int paramInt2, String paramString)
  {
    this.O = paramString;
    this.N = paramInt2;
    M[paramInt1] = this;
  }
  
  public static i a(int paramInt)
  {
    int i1 = 0;
    while (i1 < M.length)
    {
      if (M[i1].a() == paramInt) {
        return M[i1];
      }
      i1 += 1;
    }
    if (!L) {
      throw new AssertionError();
    }
    return null;
  }
  
  public int a()
  {
    return this.N;
  }
  
  public String toString()
  {
    return this.O;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     sm.i
 * JD-Core Version:    0.7.0.1
 */
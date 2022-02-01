package com.tencent.mobileqq.activity.widget.qqmusic.utils.parser;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.widget.qqmusic.utils.MLog;
import java.util.ArrayList;
import java.util.Vector;

public class SessionResponse
  extends XmlResponse
{
  private static final String jdField_a_of_type_JavaLangString = "SessionResponse";
  private int A = this.a.a("root.body.shareToplst");
  private int B = this.a.a("root.body.shareTaoge");
  private int C = this.a.a("root.body.shareSong");
  private int D = this.a.a("root.body.shareSongNew");
  private int E = this.a.a("root.body.buluoUrl");
  private int F = this.a.a("root.body.copyright.DtsVersion");
  private int G = this.a.a("root.body.copyright.DtsUrl");
  private int H = this.a.a("root.body.copyright.DtsMd5");
  private int I = this.a.a("root.body.copyright.DtsSize");
  private int J = this.a.a("root.body.copyright.forbiddownload");
  private int K = this.a.a("root.body.copyright.softdecode");
  private int L = this.a.a("root.body.copyright.cachesongnum");
  private int M = this.a.a("root.body.copyright.smallremainspacebuf");
  private int N = this.a.a("root.body.copyright.normalremainspacebuf");
  private int O = this.a.a("root.body.copyright.largeremainspacebuf");
  private int P = this.a.a("root.body.session.wifi_listen_rate");
  private int Q = this.a.a("root.body.copyright.latestplaysecond");
  private int R = this.a.a("root.body.copyright.AdvertFlag");
  private int S = this.a.a("root.body.copyright.fingerprint_match");
  private int T = this.a.a("root.body.copyright.rescan_time");
  private int U = this.a.a("root.body.copyright.rewrite_songinfo");
  private int V = this.a.a("root.body.racingconf.firstpieceCoefficient");
  private int W = this.a.a("root.body.racingconf.disableLinkflag");
  private int X = this.a.a("root.body.racingconf.disableRacingflag");
  private int Y = this.a.a("root.body.mygreen");
  private int Z = this.a.a("root.body.domainwhitelist.domain");
  private int[] jdField_a_of_type_ArrayOfInt;
  private int aa = this.a.a("root.body.copyright.scannerpath");
  private int ab = this.a.a("root.body.cmax");
  private int ac = this.a.a("root.body.gmax");
  private int ad = this.a.a("root.body.smax");
  private int ae = this.a.a("root.body.pneed");
  private int af = this.a.a("root.body.rec_app.title");
  private int ag = this.a.a("root.body.rec_app.url");
  private int ah = this.a.a("root.body.timeSlice");
  private int ai = this.a.a("root.body.secondSliceTime");
  private int aj = this.a.a("root.body.MobileStuck.stuck_monitor");
  private int ak = this.a.a("root.body.MobileStuck.stuck_stack");
  private int al = this.a.a("root.body.MobileStuck.stuck_threshold");
  private int am = this.a.a("root.body.copyright.mvtab_timeout");
  private int an = this.a.a("root.body.copyright.AppLinkSdkMd5");
  private int c = this.a.a("root.body.session.uid");
  private int d = this.a.a("root.body.session.sid");
  private int e = this.a.a("root.body.session.pds");
  private int f = this.a.a("root.body.session.mds");
  private int g = this.a.a("root.body.session.utyp");
  private int h = this.a.a("root.body.session.utxt");
  private int i = this.a.a("root.body.session.uurl");
  private int j = this.a.a("root.body.session.pf");
  private int k = this.a.a("root.body.splash");
  private int l = this.a.a("root.body.searchkey.item.info1");
  private int m = this.a.a("root.body.session.rn");
  private int n = this.a.a("root.body.session.pvip");
  private int o = this.a.a("root.body.session.tips_session");
  private int p = this.a.a("root.body.copyright.down128");
  private int q = this.a.a("root.body.copyright.down320");
  private int r = this.a.a("root.body.copyright.latestplaynum");
  private int s = this.a.a("root.body.copyright.viplatestplaynum");
  private int t = this.a.a("root.body.copyright.autodown");
  private int u = this.a.a("root.body.copyright.sosodown");
  private int v = this.a.a("root.body.copyright.limitmsg");
  private int w = this.a.a("root.body.shareAlbum");
  private int x = this.a.a("root.body.shareSinger");
  private int y = this.a.a("root.body.shareTheme");
  private int z = this.a.a("root.body.shareMV");
  
  public float a()
  {
    return a(this.a.a(this.V), 1.0F);
  }
  
  public int a(String paramString)
  {
    int i1 = 0;
    if (paramString != null) {}
    try
    {
      i1 = Integer.parseInt(paramString);
      return i1;
    }
    catch (NumberFormatException paramString) {}
    return 0;
  }
  
  public long a()
  {
    return a(this.a.a(this.I));
  }
  
  public long a(String paramString)
  {
    long l1 = 0L;
    if (paramString != null) {}
    try
    {
      l1 = Long.parseLong(paramString);
      return l1;
    }
    catch (NumberFormatException paramString) {}
    return 0L;
  }
  
  public Long a()
  {
    return Long.valueOf(a(this.a.a(this.o), 0));
  }
  
  public String a()
  {
    return this.a.a(this.w);
  }
  
  public ArrayList a()
  {
    localArrayList = new ArrayList();
    Object localObject = this.a.a(this.J);
    try
    {
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = ((String)localObject).split(",");
        if (localObject != null)
        {
          int i2 = localObject.length;
          int i1 = 0;
          while (i1 < i2)
          {
            localArrayList.add(Long.valueOf(localObject[i1]));
            i1 += 1;
          }
        }
      }
      return localArrayList;
    }
    catch (Exception localException)
    {
      MLog.d("SessionResponse", localException.toString());
    }
  }
  
  public Vector a()
  {
    return this.a.a(this.k);
  }
  
  public boolean a()
  {
    return a(this.a.a(this.aj), 0) == 1;
  }
  
  public int b()
  {
    return a(this.a.a(this.p));
  }
  
  public long b()
  {
    return a(this.a.a(this.T), 0);
  }
  
  public String b()
  {
    return this.a.a(this.x);
  }
  
  public Vector b()
  {
    Vector localVector = this.a.a(this.l);
    if (localVector != null)
    {
      int i1 = 0;
      while (i1 < localVector.size())
      {
        localVector.setElementAt(a((String)localVector.elementAt(i1)), i1);
        i1 += 1;
      }
    }
    return localVector;
  }
  
  public boolean b()
  {
    return a(this.a.a(this.ak), 0) == 1;
  }
  
  public int c()
  {
    return a(this.a.a(this.q));
  }
  
  public String c()
  {
    return this.a.a(this.y);
  }
  
  public Vector c()
  {
    return this.a.a(this.Z);
  }
  
  public int d()
  {
    return a(this.a.a(this.r));
  }
  
  public String d()
  {
    return this.a.a(this.z);
  }
  
  public int e()
  {
    return a(this.a.a(this.s));
  }
  
  public String e()
  {
    return this.a.a(this.A);
  }
  
  public int f()
  {
    return a(this.a.a(this.t));
  }
  
  public String f()
  {
    return this.a.a(this.B);
  }
  
  public int g()
  {
    return a(this.a.a(this.u));
  }
  
  public String g()
  {
    return this.a.a(this.C);
  }
  
  public int h()
  {
    return a(this.a.a(this.j), 0);
  }
  
  public String h()
  {
    return this.a.a(this.D);
  }
  
  public int i()
  {
    return a(this.a.a(this.m), 0);
  }
  
  public String i()
  {
    return this.a.a(this.E);
  }
  
  public int j()
  {
    return a(this.a.a(this.n), 600);
  }
  
  public String j()
  {
    return this.a.a(this.G);
  }
  
  public int k()
  {
    return a(this.a.a(this.W), 1);
  }
  
  public String k()
  {
    return this.a.a(this.H);
  }
  
  public int l()
  {
    return a(this.a.a(this.X), 1);
  }
  
  public String l()
  {
    return this.a.a(this.F);
  }
  
  public int m()
  {
    return a(this.a.a(this.Q), 10);
  }
  
  public String m()
  {
    return XmlResponse.a(this.a.a(this.v));
  }
  
  public int n()
  {
    return a(this.a.a(this.S), 1);
  }
  
  public String n()
  {
    return this.a.a(this.c);
  }
  
  public int o()
  {
    return a(this.a.a(this.U), 1);
  }
  
  public String o()
  {
    return this.a.a(this.d);
  }
  
  public int p()
  {
    return a(this.a.a(this.ab), 0);
  }
  
  public String p()
  {
    return this.a.a(this.e);
  }
  
  public int q()
  {
    return a(this.a.a(this.ac), 300);
  }
  
  public String q()
  {
    return this.a.a(this.f);
  }
  
  public int r()
  {
    return a(this.a.a(this.ad), 500);
  }
  
  public String r()
  {
    return this.a.a(this.g);
  }
  
  public int s()
  {
    return a(this.a.a(this.ae), 0);
  }
  
  public String s()
  {
    return a(this.a.a(this.h));
  }
  
  public int t()
  {
    return a(this.a.a(this.R), 1);
  }
  
  public String t()
  {
    return this.a.a(this.i);
  }
  
  public int u()
  {
    return a(this.a.a(this.ah), 0);
  }
  
  public String u()
  {
    return this.a.a(this.P);
  }
  
  public int v()
  {
    return a(this.a.a(this.ai), 0);
  }
  
  public String v()
  {
    return a(this.a.a(this.Y));
  }
  
  public int w()
  {
    return (int)(1000.0F * a(this.a.a(this.al), 0.5F));
  }
  
  public String w()
  {
    return XmlResponse.a(this.a.a(this.aa));
  }
  
  public int x()
  {
    return a(this.a.a(this.am), 0);
  }
  
  public String x()
  {
    return a(this.a.a(this.af));
  }
  
  public String y()
  {
    return this.a.a(this.ag);
  }
  
  public String z()
  {
    return this.a.a(this.an);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.widget.qqmusic.utils.parser.SessionResponse
 * JD-Core Version:    0.7.0.1
 */
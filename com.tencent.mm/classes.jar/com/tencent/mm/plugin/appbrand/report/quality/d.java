package com.tencent.mm.plugin.appbrand.report.quality;

import a.a.e;
import android.os.Parcel;
import com.tencent.mm.a.o;
import com.tencent.mm.h.b.a.am;
import com.tencent.mm.h.b.a.am.a;
import com.tencent.mm.h.b.a.am.b;
import com.tencent.mm.h.b.a.ao;
import com.tencent.mm.h.b.a.ao.a;
import com.tencent.mm.h.b.a.ao.b;
import com.tencent.mm.plugin.appbrand.report.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;

public final class d
{
  public static final d had = new d();
  
  public static final am a(QualitySession paramQualitySession)
  {
    a.d.b.g.k(paramQualitySession, "session");
    am localam = new am();
    localam.cI(paramQualitySession.appId);
    localam.cH(paramQualitySession.gKi);
    localam.a(am.a.eO(paramQualitySession.ham));
    localam.a(am.b.eP(paramQualitySession.apptype));
    localam.aE(paramQualitySession.scene);
    localam.aC(paramQualitySession.han);
    return localam;
  }
  
  public static final String aox()
  {
    Object localObject1 = new String[2];
    a.d.b.g.j(com.tencent.mm.kernel.g.DN(), "MMKernel.account()");
    Object localObject2 = o.getString(com.tencent.mm.kernel.a.CK());
    a.d.b.g.j(localObject2, "UIN.getString(MMKernel.account().uin)");
    localObject1[0] = localObject2;
    localObject1[1] = String.valueOf(bk.UY());
    a.d.b.g.k(localObject1, "elements");
    localObject1 = (Iterable)a.a.a.asList((Object[])localObject1);
    localObject2 = (CharSequence)"_";
    CharSequence localCharSequence1 = (CharSequence)"";
    CharSequence localCharSequence2 = (CharSequence)"";
    CharSequence localCharSequence3 = (CharSequence)"...";
    a.d.b.g.k(localObject1, "$receiver");
    a.d.b.g.k(localObject2, "separator");
    a.d.b.g.k(localCharSequence1, "prefix");
    a.d.b.g.k(localCharSequence2, "postfix");
    a.d.b.g.k(localCharSequence3, "truncated");
    localObject1 = ((StringBuilder)e.a((Iterable)localObject1, (Appendable)new StringBuilder(), (CharSequence)localObject2, localCharSequence1, localCharSequence2, localCharSequence3)).toString();
    a.d.b.g.j(localObject1, "joinTo(StringBuilder(), …ed, transform).toString()");
    return localObject1;
  }
  
  public static final ao b(QualitySession paramQualitySession)
  {
    a.d.b.g.k(paramQualitySession, "session");
    ao localao = new ao();
    localao.cK(paramQualitySession.appId);
    localao.cJ(paramQualitySession.gKi);
    localao.a(ao.a.eT(paramQualitySession.ham));
    localao.a(ao.b.eU(paramQualitySession.apptype));
    localao.aM(paramQualitySession.scene);
    localao.aK(paramQualitySession.han);
    return localao;
  }
  
  public static final QualitySessionRuntime c(QualitySession paramQualitySession)
  {
    a.d.b.g.k(paramQualitySession, "session");
    Parcel localParcel = Parcel.obtain();
    localParcel.setDataPosition(0);
    paramQualitySession.writeToParcel(localParcel, 0);
    localParcel.setDataPosition(0);
    paramQualitySession = new QualitySessionRuntime(localParcel);
    localParcel.recycle();
    return paramQualitySession;
  }
  
  public static final int getNetworkType()
  {
    String str = c.cv(ae.getContext());
    switch (str.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return 10000;
              } while (!str.equals("offline"));
              return 5;
            } while (!str.equals("wifi"));
            return 1;
          } while (!str.equals("4g"));
          return 4;
        } while (!str.equals("3g"));
        return 3;
      } while (!str.equals("2g"));
      return 2;
    } while (!str.equals("unknown"));
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.quality.d
 * JD-Core Version:    0.7.0.1
 */
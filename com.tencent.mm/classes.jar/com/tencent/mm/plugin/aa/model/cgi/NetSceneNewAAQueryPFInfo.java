package com.tencent.mm.plugin.aa.model.cgi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cfd;
import com.tencent.mm.protocal.protobuf.cfe;
import com.tencent.mm.protocal.protobuf.cqo;
import com.tencent.mm.protocal.protobuf.j;
import com.tencent.mm.protocal.protobuf.l;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.wallet_core.c.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class NetSceneNewAAQueryPFInfo
  extends r
{
  private g callback;
  private b iaa;
  private cfd ian;
  public cfe iao;
  
  public NetSceneNewAAQueryPFInfo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63416);
    b.a locala = new b.a();
    locala.gUU = new cfd();
    locala.gUV = new cfe();
    locala.funcId = 1809;
    locala.uri = "/cgi-bin/mmpay-bin/newaaquerypfinfo";
    this.iaa = locala.atI();
    this.ian = ((cfd)this.iaa.gUS.gUX);
    this.ian.Css = paramString1;
    this.ian.dlB = paramString2;
    ad.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "do scene NetSceneNewAAQueryPFInfo pf_order_no:%s appid:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(63416);
  }
  
  public static PfInfoParcel a(cfe paramcfe)
  {
    AppMethodBeat.i(63419);
    if (paramcfe == null)
    {
      AppMethodBeat.o(63419);
      return null;
    }
    PfInfoParcel localPfInfoParcel = new PfInfoParcel();
    localPfInfoParcel.dEb = paramcfe.dEb;
    localPfInfoParcel.iaw = paramcfe.iaw;
    Iterator localIterator = paramcfe.Csn.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (j)localIterator.next();
      AALaunchItemParcel localAALaunchItemParcel = new AALaunchItemParcel();
      localAALaunchItemParcel.username = ((j)localObject).username;
      localAALaunchItemParcel.dEb = ((j)localObject).dEb;
      localPfInfoParcel.iax.add(localAALaunchItemParcel);
    }
    localPfInfoParcel.iay = paramcfe.iay;
    localPfInfoParcel.iaz = paramcfe.iaz;
    if (paramcfe.Ebt != null)
    {
      localPfInfoParcel.iaA = new SessionIdListParcel();
      localIterator = paramcfe.Ebt.CAN.iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localPfInfoParcel.iaA.iaD.add(localObject);
      }
      localIterator = paramcfe.Ebt.Ejz.iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localPfInfoParcel.iaA.iaE.add(localObject);
      }
    }
    localPfInfoParcel.iaB = paramcfe.iaB;
    localPfInfoParcel.iaC = new AAOperationInfoParcel();
    localPfInfoParcel.iaC.iap = paramcfe.Ebu.iap;
    localPfInfoParcel.iaC.iaq = paramcfe.Ebu.iaq;
    localPfInfoParcel.iaC.iar = paramcfe.Ebu.iar;
    localPfInfoParcel.iaC.ias = paramcfe.Ebu.ias;
    localPfInfoParcel.iaC.iat = paramcfe.Ebu.iat;
    localPfInfoParcel.iaC.iau = paramcfe.Ebu.iau;
    localPfInfoParcel.iaC.iav = paramcfe.Ebu.iav;
    AppMethodBeat.o(63419);
    return localPfInfoParcel;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63418);
    ad.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.iao = ((cfe)((b)paramq).gUT.gUX);
    ad.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.iao.dcG), this.iao.nTK });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63418);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(63417);
    ad.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, this.iaa, this);
    AppMethodBeat.o(63417);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (cfe)((b)paramq).gUT.gUX;
    this.IdO = paramq.dcG;
    this.IdP = paramq.nTK;
  }
  
  public final int getType()
  {
    return 1809;
  }
  
  public static class AALaunchItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<AALaunchItemParcel> CREATOR;
    public long dEb;
    public String username;
    
    static
    {
      AppMethodBeat.i(63398);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(63398);
    }
    
    public AALaunchItemParcel() {}
    
    protected AALaunchItemParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(63397);
      this.username = paramParcel.readString();
      this.dEb = paramParcel.readLong();
      AppMethodBeat.o(63397);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(63395);
      String str = "AALaunchItemParcel{username='" + this.username + '\'' + ", amount=" + this.dEb + '}';
      AppMethodBeat.o(63395);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(63396);
      paramParcel.writeString(this.username);
      paramParcel.writeLong(this.dEb);
      AppMethodBeat.o(63396);
    }
  }
  
  public static class AAOperationInfoParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<AAOperationInfoParcel> CREATOR;
    public int iap;
    public int iaq;
    public int iar;
    public long ias;
    public long iat;
    public String iau;
    public String iav;
    
    static
    {
      AppMethodBeat.i(63403);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(63403);
    }
    
    public AAOperationInfoParcel() {}
    
    protected AAOperationInfoParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(63402);
      this.iap = paramParcel.readInt();
      this.iaq = paramParcel.readInt();
      this.iar = paramParcel.readInt();
      this.ias = paramParcel.readLong();
      this.iat = paramParcel.readLong();
      this.iau = paramParcel.readString();
      this.iav = paramParcel.readString();
      AppMethodBeat.o(63402);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(63400);
      String str = "AAOperationInfoParcel{max_payer_num=" + this.iap + ", max_receiver_num=" + this.iaq + ", max_total_num=" + this.iar + ", max_total_amount=" + this.ias + ", max_per_amount=" + this.iat + ", notice='" + this.iau + '\'' + ", notice_url='" + this.iav + '\'' + '}';
      AppMethodBeat.o(63400);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(63401);
      paramParcel.writeInt(this.iap);
      paramParcel.writeInt(this.iaq);
      paramParcel.writeInt(this.iar);
      paramParcel.writeLong(this.ias);
      paramParcel.writeLong(this.iat);
      paramParcel.writeString(this.iau);
      paramParcel.writeString(this.iav);
      AppMethodBeat.o(63401);
    }
  }
  
  public static class PfInfoParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<PfInfoParcel> CREATOR;
    public long dEb;
    public NetSceneNewAAQueryPFInfo.SessionIdListParcel iaA;
    public String iaB;
    public NetSceneNewAAQueryPFInfo.AAOperationInfoParcel iaC;
    public String iaw;
    public ArrayList<NetSceneNewAAQueryPFInfo.AALaunchItemParcel> iax;
    public String iay;
    public String iaz;
    
    static
    {
      AppMethodBeat.i(63409);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(63409);
    }
    
    public PfInfoParcel()
    {
      AppMethodBeat.i(63407);
      this.iax = new ArrayList();
      AppMethodBeat.o(63407);
    }
    
    protected PfInfoParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(63408);
      this.iax = new ArrayList();
      this.dEb = paramParcel.readLong();
      this.iaw = paramParcel.readString();
      this.iax = paramParcel.createTypedArrayList(NetSceneNewAAQueryPFInfo.AALaunchItemParcel.CREATOR);
      this.iay = paramParcel.readString();
      this.iaz = paramParcel.readString();
      this.iaA = ((NetSceneNewAAQueryPFInfo.SessionIdListParcel)paramParcel.readParcelable(NetSceneNewAAQueryPFInfo.SessionIdListParcel.class.getClassLoader()));
      this.iaB = paramParcel.readString();
      this.iaC = ((NetSceneNewAAQueryPFInfo.AAOperationInfoParcel)paramParcel.readParcelable(NetSceneNewAAQueryPFInfo.AAOperationInfoParcel.class.getClassLoader()));
      AppMethodBeat.o(63408);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(63405);
      String str = "PfInfoParcel{amount=" + this.dEb + ", receiver_username='" + this.iaw + '\'' + ", payer_list=" + this.iax + ", pic_url='" + this.iay + '\'' + ", remark='" + this.iaz + '\'' + ", sessionid_list=" + this.iaA + ", pic_sign='" + this.iaB + '\'' + ", operation_info=" + this.iaC + '}';
      AppMethodBeat.o(63405);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(63406);
      paramParcel.writeLong(this.dEb);
      paramParcel.writeString(this.iaw);
      paramParcel.writeTypedList(this.iax);
      paramParcel.writeString(this.iay);
      paramParcel.writeString(this.iaz);
      paramParcel.writeParcelable(this.iaA, paramInt);
      paramParcel.writeString(this.iaB);
      paramParcel.writeParcelable(this.iaC, paramInt);
      AppMethodBeat.o(63406);
    }
  }
  
  public static class SessionIdListParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<SessionIdListParcel> CREATOR;
    public ArrayList<String> iaD;
    public ArrayList<String> iaE;
    
    static
    {
      AppMethodBeat.i(63415);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(63415);
    }
    
    public SessionIdListParcel()
    {
      AppMethodBeat.i(63413);
      this.iaD = new ArrayList();
      this.iaE = new ArrayList();
      AppMethodBeat.o(63413);
    }
    
    protected SessionIdListParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(63414);
      this.iaD = new ArrayList();
      this.iaE = new ArrayList();
      this.iaD = paramParcel.createStringArrayList();
      this.iaE = paramParcel.createStringArrayList();
      AppMethodBeat.o(63414);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(63411);
      String str = "SessionIdListParcel{username=" + this.iaD + ", groupid=" + this.iaE + '}';
      AppMethodBeat.o(63411);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(63412);
      paramParcel.writeStringList(this.iaD);
      paramParcel.writeStringList(this.iaE);
      AppMethodBeat.o(63412);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo
 * JD-Core Version:    0.7.0.1
 */
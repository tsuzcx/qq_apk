package com.tencent.mm.plugin.aa.model.cgi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.an.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.drr;
import com.tencent.mm.protocal.protobuf.drs;
import com.tencent.mm.protocal.protobuf.efh;
import com.tencent.mm.protocal.protobuf.m;
import com.tencent.mm.protocal.protobuf.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class NetSceneNewAAQueryPFInfo
  extends r
{
  private i callback;
  private d kwO;
  private drr mKE;
  public drs mKF;
  
  public NetSceneNewAAQueryPFInfo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63416);
    d.a locala = new d.a();
    locala.lBU = new drr();
    locala.lBV = new drs();
    locala.funcId = 1809;
    locala.uri = "/cgi-bin/mmpay-bin/newaaquerypfinfo";
    this.kwO = locala.bgN();
    this.mKE = ((drr)d.b.b(this.kwO.lBR));
    this.mKE.RDs = paramString1;
    this.mKE.appid = paramString2;
    Log.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "do scene NetSceneNewAAQueryPFInfo pf_order_no:%s appid:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(63416);
  }
  
  public static PfInfoParcel a(drs paramdrs)
  {
    AppMethodBeat.i(63419);
    if (paramdrs == null)
    {
      AppMethodBeat.o(63419);
      return null;
    }
    PfInfoParcel localPfInfoParcel = new PfInfoParcel();
    localPfInfoParcel.gbJ = paramdrs.gbJ;
    localPfInfoParcel.llO = paramdrs.llO;
    Iterator localIterator = paramdrs.RDn.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (m)localIterator.next();
      AALaunchItemParcel localAALaunchItemParcel = new AALaunchItemParcel();
      localAALaunchItemParcel.username = ((m)localObject).username;
      localAALaunchItemParcel.gbJ = ((m)localObject).gbJ;
      localPfInfoParcel.mKN.add(localAALaunchItemParcel);
    }
    localPfInfoParcel.mKO = paramdrs.mKO;
    localPfInfoParcel.remark = paramdrs.remark;
    if (paramdrs.TYB != null)
    {
      localPfInfoParcel.mKP = new SessionIdListParcel();
      localIterator = paramdrs.TYB.RLB.iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localPfInfoParcel.mKP.mKS.add(localObject);
      }
      localIterator = paramdrs.TYB.UiF.iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localPfInfoParcel.mKP.mKT.add(localObject);
      }
    }
    localPfInfoParcel.mKQ = paramdrs.mKQ;
    localPfInfoParcel.mKR = new AAOperationInfoParcel();
    localPfInfoParcel.mKR.mKG = paramdrs.TYC.mKG;
    localPfInfoParcel.mKR.mKH = paramdrs.TYC.mKH;
    localPfInfoParcel.mKR.mKI = paramdrs.TYC.mKI;
    localPfInfoParcel.mKR.mKJ = paramdrs.TYC.mKJ;
    localPfInfoParcel.mKR.mKK = paramdrs.TYC.mKK;
    localPfInfoParcel.mKR.mKL = paramdrs.TYC.mKL;
    localPfInfoParcel.mKR.mKM = paramdrs.TYC.mKM;
    AppMethodBeat.o(63419);
    return localPfInfoParcel;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(63418);
    Log.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.mKF = ((drs)d.c.b(((d)params).lBS));
    Log.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.mKF.fwx), this.mKF.tVo });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63418);
  }
  
  public final int doScene(g paramg, i parami)
  {
    AppMethodBeat.i(63417);
    Log.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "doScene");
    this.callback = parami;
    int i = dispatch(paramg, this.kwO, this);
    AppMethodBeat.o(63417);
    return i;
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(209523);
    params = (drs)d.c.b(((d)params).lBS);
    this.YVy = params.fwx;
    this.YVz = params.tVo;
    AppMethodBeat.o(209523);
  }
  
  public final int getType()
  {
    return 1809;
  }
  
  public static class AALaunchItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<AALaunchItemParcel> CREATOR;
    public long gbJ;
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
      this.gbJ = paramParcel.readLong();
      AppMethodBeat.o(63397);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(63395);
      String str = "AALaunchItemParcel{username='" + this.username + '\'' + ", amount=" + this.gbJ + '}';
      AppMethodBeat.o(63395);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(63396);
      paramParcel.writeString(this.username);
      paramParcel.writeLong(this.gbJ);
      AppMethodBeat.o(63396);
    }
  }
  
  public static class AAOperationInfoParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<AAOperationInfoParcel> CREATOR;
    public int mKG;
    public int mKH;
    public int mKI;
    public long mKJ;
    public long mKK;
    public String mKL;
    public String mKM;
    
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
      this.mKG = paramParcel.readInt();
      this.mKH = paramParcel.readInt();
      this.mKI = paramParcel.readInt();
      this.mKJ = paramParcel.readLong();
      this.mKK = paramParcel.readLong();
      this.mKL = paramParcel.readString();
      this.mKM = paramParcel.readString();
      AppMethodBeat.o(63402);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(63400);
      String str = "AAOperationInfoParcel{max_payer_num=" + this.mKG + ", max_receiver_num=" + this.mKH + ", max_total_num=" + this.mKI + ", max_total_amount=" + this.mKJ + ", max_per_amount=" + this.mKK + ", notice='" + this.mKL + '\'' + ", notice_url='" + this.mKM + '\'' + '}';
      AppMethodBeat.o(63400);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(63401);
      paramParcel.writeInt(this.mKG);
      paramParcel.writeInt(this.mKH);
      paramParcel.writeInt(this.mKI);
      paramParcel.writeLong(this.mKJ);
      paramParcel.writeLong(this.mKK);
      paramParcel.writeString(this.mKL);
      paramParcel.writeString(this.mKM);
      AppMethodBeat.o(63401);
    }
  }
  
  public static class PfInfoParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<PfInfoParcel> CREATOR;
    public long gbJ;
    public String llO;
    public ArrayList<NetSceneNewAAQueryPFInfo.AALaunchItemParcel> mKN;
    public String mKO;
    public NetSceneNewAAQueryPFInfo.SessionIdListParcel mKP;
    public String mKQ;
    public NetSceneNewAAQueryPFInfo.AAOperationInfoParcel mKR;
    public String remark;
    
    static
    {
      AppMethodBeat.i(63409);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(63409);
    }
    
    public PfInfoParcel()
    {
      AppMethodBeat.i(63407);
      this.mKN = new ArrayList();
      AppMethodBeat.o(63407);
    }
    
    protected PfInfoParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(63408);
      this.mKN = new ArrayList();
      this.gbJ = paramParcel.readLong();
      this.llO = paramParcel.readString();
      this.mKN = paramParcel.createTypedArrayList(NetSceneNewAAQueryPFInfo.AALaunchItemParcel.CREATOR);
      this.mKO = paramParcel.readString();
      this.remark = paramParcel.readString();
      this.mKP = ((NetSceneNewAAQueryPFInfo.SessionIdListParcel)paramParcel.readParcelable(NetSceneNewAAQueryPFInfo.SessionIdListParcel.class.getClassLoader()));
      this.mKQ = paramParcel.readString();
      this.mKR = ((NetSceneNewAAQueryPFInfo.AAOperationInfoParcel)paramParcel.readParcelable(NetSceneNewAAQueryPFInfo.AAOperationInfoParcel.class.getClassLoader()));
      AppMethodBeat.o(63408);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(63405);
      String str = "PfInfoParcel{amount=" + this.gbJ + ", receiver_username='" + this.llO + '\'' + ", payer_list=" + this.mKN + ", pic_url='" + this.mKO + '\'' + ", remark='" + this.remark + '\'' + ", sessionid_list=" + this.mKP + ", pic_sign='" + this.mKQ + '\'' + ", operation_info=" + this.mKR + '}';
      AppMethodBeat.o(63405);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(63406);
      paramParcel.writeLong(this.gbJ);
      paramParcel.writeString(this.llO);
      paramParcel.writeTypedList(this.mKN);
      paramParcel.writeString(this.mKO);
      paramParcel.writeString(this.remark);
      paramParcel.writeParcelable(this.mKP, paramInt);
      paramParcel.writeString(this.mKQ);
      paramParcel.writeParcelable(this.mKR, paramInt);
      AppMethodBeat.o(63406);
    }
  }
  
  public static class SessionIdListParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<SessionIdListParcel> CREATOR;
    public ArrayList<String> mKS;
    public ArrayList<String> mKT;
    
    static
    {
      AppMethodBeat.i(63415);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(63415);
    }
    
    public SessionIdListParcel()
    {
      AppMethodBeat.i(63413);
      this.mKS = new ArrayList();
      this.mKT = new ArrayList();
      AppMethodBeat.o(63413);
    }
    
    protected SessionIdListParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(63414);
      this.mKS = new ArrayList();
      this.mKT = new ArrayList();
      this.mKS = paramParcel.createStringArrayList();
      this.mKT = paramParcel.createStringArrayList();
      AppMethodBeat.o(63414);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(63411);
      String str = "SessionIdListParcel{username=" + this.mKS + ", groupid=" + this.mKT + '}';
      AppMethodBeat.o(63411);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(63412);
      paramParcel.writeStringList(this.mKS);
      paramParcel.writeStringList(this.mKT);
      AppMethodBeat.o(63412);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo
 * JD-Core Version:    0.7.0.1
 */
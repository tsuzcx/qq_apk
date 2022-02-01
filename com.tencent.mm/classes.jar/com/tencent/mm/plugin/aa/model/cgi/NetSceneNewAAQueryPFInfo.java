package com.tencent.mm.plugin.aa.model.cgi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cqa;
import com.tencent.mm.protocal.protobuf.cqb;
import com.tencent.mm.protocal.protobuf.dcb;
import com.tencent.mm.protocal.protobuf.j;
import com.tencent.mm.protocal.protobuf.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.wallet_core.c.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class NetSceneNewAAQueryPFInfo
  extends r
{
  private f callback;
  private b gRX;
  private cqa iWt;
  public cqb iWu;
  
  public NetSceneNewAAQueryPFInfo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63416);
    b.a locala = new b.a();
    locala.hQF = new cqa();
    locala.hQG = new cqb();
    locala.funcId = 1809;
    locala.uri = "/cgi-bin/mmpay-bin/newaaquerypfinfo";
    this.gRX = locala.aDS();
    this.iWt = ((cqa)this.gRX.hQD.hQJ);
    this.iWt.FIo = paramString1;
    this.iWt.dwb = paramString2;
    ae.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "do scene NetSceneNewAAQueryPFInfo pf_order_no:%s appid:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(63416);
  }
  
  public static PfInfoParcel a(cqb paramcqb)
  {
    AppMethodBeat.i(63419);
    if (paramcqb == null)
    {
      AppMethodBeat.o(63419);
      return null;
    }
    PfInfoParcel localPfInfoParcel = new PfInfoParcel();
    localPfInfoParcel.dPq = paramcqb.dPq;
    localPfInfoParcel.iWC = paramcqb.iWC;
    Iterator localIterator = paramcqb.FIj.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (j)localIterator.next();
      AALaunchItemParcel localAALaunchItemParcel = new AALaunchItemParcel();
      localAALaunchItemParcel.username = ((j)localObject).username;
      localAALaunchItemParcel.dPq = ((j)localObject).dPq;
      localPfInfoParcel.iWD.add(localAALaunchItemParcel);
    }
    localPfInfoParcel.iWE = paramcqb.iWE;
    localPfInfoParcel.iWF = paramcqb.iWF;
    if (paramcqb.HBT != null)
    {
      localPfInfoParcel.iWG = new SessionIdListParcel();
      localIterator = paramcqb.HBT.FRc.iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localPfInfoParcel.iWG.iWJ.add(localObject);
      }
      localIterator = paramcqb.HBT.HKB.iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localPfInfoParcel.iWG.iWK.add(localObject);
      }
    }
    localPfInfoParcel.iWH = paramcqb.iWH;
    localPfInfoParcel.iWI = new AAOperationInfoParcel();
    localPfInfoParcel.iWI.iWv = paramcqb.HBU.iWv;
    localPfInfoParcel.iWI.iWw = paramcqb.HBU.iWw;
    localPfInfoParcel.iWI.iWx = paramcqb.HBU.iWx;
    localPfInfoParcel.iWI.iWy = paramcqb.HBU.iWy;
    localPfInfoParcel.iWI.iWz = paramcqb.HBU.iWz;
    localPfInfoParcel.iWI.iWA = paramcqb.HBU.iWA;
    localPfInfoParcel.iWI.iWB = paramcqb.HBU.iWB;
    AppMethodBeat.o(63419);
    return localPfInfoParcel;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63418);
    ae.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.iWu = ((cqb)((b)paramq).hQE.hQJ);
    ae.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.iWu.dmy), this.iWu.phe });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63418);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(63417);
    ae.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.gRX, this);
    AppMethodBeat.o(63417);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (cqb)((b)paramq).hQE.hQJ;
    this.LVj = paramq.dmy;
    this.LVk = paramq.phe;
  }
  
  public final int getType()
  {
    return 1809;
  }
  
  public static class AALaunchItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<AALaunchItemParcel> CREATOR;
    public long dPq;
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
      this.dPq = paramParcel.readLong();
      AppMethodBeat.o(63397);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(63395);
      String str = "AALaunchItemParcel{username='" + this.username + '\'' + ", amount=" + this.dPq + '}';
      AppMethodBeat.o(63395);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(63396);
      paramParcel.writeString(this.username);
      paramParcel.writeLong(this.dPq);
      AppMethodBeat.o(63396);
    }
  }
  
  public static class AAOperationInfoParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<AAOperationInfoParcel> CREATOR;
    public String iWA;
    public String iWB;
    public int iWv;
    public int iWw;
    public int iWx;
    public long iWy;
    public long iWz;
    
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
      this.iWv = paramParcel.readInt();
      this.iWw = paramParcel.readInt();
      this.iWx = paramParcel.readInt();
      this.iWy = paramParcel.readLong();
      this.iWz = paramParcel.readLong();
      this.iWA = paramParcel.readString();
      this.iWB = paramParcel.readString();
      AppMethodBeat.o(63402);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(63400);
      String str = "AAOperationInfoParcel{max_payer_num=" + this.iWv + ", max_receiver_num=" + this.iWw + ", max_total_num=" + this.iWx + ", max_total_amount=" + this.iWy + ", max_per_amount=" + this.iWz + ", notice='" + this.iWA + '\'' + ", notice_url='" + this.iWB + '\'' + '}';
      AppMethodBeat.o(63400);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(63401);
      paramParcel.writeInt(this.iWv);
      paramParcel.writeInt(this.iWw);
      paramParcel.writeInt(this.iWx);
      paramParcel.writeLong(this.iWy);
      paramParcel.writeLong(this.iWz);
      paramParcel.writeString(this.iWA);
      paramParcel.writeString(this.iWB);
      AppMethodBeat.o(63401);
    }
  }
  
  public static class PfInfoParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<PfInfoParcel> CREATOR;
    public long dPq;
    public String iWC;
    public ArrayList<NetSceneNewAAQueryPFInfo.AALaunchItemParcel> iWD;
    public String iWE;
    public String iWF;
    public NetSceneNewAAQueryPFInfo.SessionIdListParcel iWG;
    public String iWH;
    public NetSceneNewAAQueryPFInfo.AAOperationInfoParcel iWI;
    
    static
    {
      AppMethodBeat.i(63409);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(63409);
    }
    
    public PfInfoParcel()
    {
      AppMethodBeat.i(63407);
      this.iWD = new ArrayList();
      AppMethodBeat.o(63407);
    }
    
    protected PfInfoParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(63408);
      this.iWD = new ArrayList();
      this.dPq = paramParcel.readLong();
      this.iWC = paramParcel.readString();
      this.iWD = paramParcel.createTypedArrayList(NetSceneNewAAQueryPFInfo.AALaunchItemParcel.CREATOR);
      this.iWE = paramParcel.readString();
      this.iWF = paramParcel.readString();
      this.iWG = ((NetSceneNewAAQueryPFInfo.SessionIdListParcel)paramParcel.readParcelable(NetSceneNewAAQueryPFInfo.SessionIdListParcel.class.getClassLoader()));
      this.iWH = paramParcel.readString();
      this.iWI = ((NetSceneNewAAQueryPFInfo.AAOperationInfoParcel)paramParcel.readParcelable(NetSceneNewAAQueryPFInfo.AAOperationInfoParcel.class.getClassLoader()));
      AppMethodBeat.o(63408);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(63405);
      String str = "PfInfoParcel{amount=" + this.dPq + ", receiver_username='" + this.iWC + '\'' + ", payer_list=" + this.iWD + ", pic_url='" + this.iWE + '\'' + ", remark='" + this.iWF + '\'' + ", sessionid_list=" + this.iWG + ", pic_sign='" + this.iWH + '\'' + ", operation_info=" + this.iWI + '}';
      AppMethodBeat.o(63405);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(63406);
      paramParcel.writeLong(this.dPq);
      paramParcel.writeString(this.iWC);
      paramParcel.writeTypedList(this.iWD);
      paramParcel.writeString(this.iWE);
      paramParcel.writeString(this.iWF);
      paramParcel.writeParcelable(this.iWG, paramInt);
      paramParcel.writeString(this.iWH);
      paramParcel.writeParcelable(this.iWI, paramInt);
      AppMethodBeat.o(63406);
    }
  }
  
  public static class SessionIdListParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<SessionIdListParcel> CREATOR;
    public ArrayList<String> iWJ;
    public ArrayList<String> iWK;
    
    static
    {
      AppMethodBeat.i(63415);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(63415);
    }
    
    public SessionIdListParcel()
    {
      AppMethodBeat.i(63413);
      this.iWJ = new ArrayList();
      this.iWK = new ArrayList();
      AppMethodBeat.o(63413);
    }
    
    protected SessionIdListParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(63414);
      this.iWJ = new ArrayList();
      this.iWK = new ArrayList();
      this.iWJ = paramParcel.createStringArrayList();
      this.iWK = paramParcel.createStringArrayList();
      AppMethodBeat.o(63414);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(63411);
      String str = "SessionIdListParcel{username=" + this.iWJ + ", groupid=" + this.iWK + '}';
      AppMethodBeat.o(63411);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(63412);
      paramParcel.writeStringList(this.iWJ);
      paramParcel.writeStringList(this.iWK);
      AppMethodBeat.o(63412);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo
 * JD-Core Version:    0.7.0.1
 */
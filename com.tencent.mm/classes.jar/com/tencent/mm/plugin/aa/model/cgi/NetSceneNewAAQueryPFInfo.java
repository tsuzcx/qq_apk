package com.tencent.mm.plugin.aa.model.cgi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b;
import com.tencent.mm.ak.b.a;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ak.g;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.ckg;
import com.tencent.mm.protocal.protobuf.ckh;
import com.tencent.mm.protocal.protobuf.cvv;
import com.tencent.mm.protocal.protobuf.j;
import com.tencent.mm.protocal.protobuf.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.wallet_core.c.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class NetSceneNewAAQueryPFInfo
  extends r
{
  private g callback;
  private b gvE;
  private ckg iAq;
  public ckh iAr;
  
  public NetSceneNewAAQueryPFInfo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63416);
    b.a locala = new b.a();
    locala.hvt = new ckg();
    locala.hvu = new ckh();
    locala.funcId = 1809;
    locala.uri = "/cgi-bin/mmpay-bin/newaaquerypfinfo";
    this.gvE = locala.aAz();
    this.iAq = ((ckg)this.gvE.hvr.hvw);
    this.iAq.DKK = paramString1;
    this.iAq.djj = paramString2;
    ac.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "do scene NetSceneNewAAQueryPFInfo pf_order_no:%s appid:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(63416);
  }
  
  public static PfInfoParcel a(ckh paramckh)
  {
    AppMethodBeat.i(63419);
    if (paramckh == null)
    {
      AppMethodBeat.o(63419);
      return null;
    }
    PfInfoParcel localPfInfoParcel = new PfInfoParcel();
    localPfInfoParcel.dBN = paramckh.dBN;
    localPfInfoParcel.iAz = paramckh.iAz;
    Iterator localIterator = paramckh.DKF.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (j)localIterator.next();
      AALaunchItemParcel localAALaunchItemParcel = new AALaunchItemParcel();
      localAALaunchItemParcel.username = ((j)localObject).username;
      localAALaunchItemParcel.dBN = ((j)localObject).dBN;
      localPfInfoParcel.iAA.add(localAALaunchItemParcel);
    }
    localPfInfoParcel.iAB = paramckh.iAB;
    localPfInfoParcel.iAC = paramckh.iAC;
    if (paramckh.Fyo != null)
    {
      localPfInfoParcel.iAD = new NetSceneNewAAQueryPFInfo.SessionIdListParcel();
      localIterator = paramckh.Fyo.DTl.iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localPfInfoParcel.iAD.iAG.add(localObject);
      }
      localIterator = paramckh.Fyo.FGx.iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localPfInfoParcel.iAD.iAH.add(localObject);
      }
    }
    localPfInfoParcel.iAE = paramckh.iAE;
    localPfInfoParcel.iAF = new AAOperationInfoParcel();
    localPfInfoParcel.iAF.iAs = paramckh.Fyp.iAs;
    localPfInfoParcel.iAF.iAt = paramckh.Fyp.iAt;
    localPfInfoParcel.iAF.iAu = paramckh.Fyp.iAu;
    localPfInfoParcel.iAF.iAv = paramckh.Fyp.iAv;
    localPfInfoParcel.iAF.iAw = paramckh.Fyp.iAw;
    localPfInfoParcel.iAF.iAx = paramckh.Fyp.iAx;
    localPfInfoParcel.iAF.iAy = paramckh.Fyp.iAy;
    AppMethodBeat.o(63419);
    return localPfInfoParcel;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63418);
    ac.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.iAr = ((ckh)((b)paramq).hvs.hvw);
    ac.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.iAr.dae), this.iAr.oxf });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63418);
  }
  
  public final int doScene(e parame, g paramg)
  {
    AppMethodBeat.i(63417);
    ac.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "doScene");
    this.callback = paramg;
    int i = dispatch(parame, this.gvE, this);
    AppMethodBeat.o(63417);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (ckh)((b)paramq).hvs.hvw;
    this.JFq = paramq.dae;
    this.JFr = paramq.oxf;
  }
  
  public final int getType()
  {
    return 1809;
  }
  
  public static class AALaunchItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<AALaunchItemParcel> CREATOR;
    public long dBN;
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
      this.dBN = paramParcel.readLong();
      AppMethodBeat.o(63397);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(63395);
      String str = "AALaunchItemParcel{username='" + this.username + '\'' + ", amount=" + this.dBN + '}';
      AppMethodBeat.o(63395);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(63396);
      paramParcel.writeString(this.username);
      paramParcel.writeLong(this.dBN);
      AppMethodBeat.o(63396);
    }
  }
  
  public static class AAOperationInfoParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<AAOperationInfoParcel> CREATOR;
    public int iAs;
    public int iAt;
    public int iAu;
    public long iAv;
    public long iAw;
    public String iAx;
    public String iAy;
    
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
      this.iAs = paramParcel.readInt();
      this.iAt = paramParcel.readInt();
      this.iAu = paramParcel.readInt();
      this.iAv = paramParcel.readLong();
      this.iAw = paramParcel.readLong();
      this.iAx = paramParcel.readString();
      this.iAy = paramParcel.readString();
      AppMethodBeat.o(63402);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(63400);
      String str = "AAOperationInfoParcel{max_payer_num=" + this.iAs + ", max_receiver_num=" + this.iAt + ", max_total_num=" + this.iAu + ", max_total_amount=" + this.iAv + ", max_per_amount=" + this.iAw + ", notice='" + this.iAx + '\'' + ", notice_url='" + this.iAy + '\'' + '}';
      AppMethodBeat.o(63400);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(63401);
      paramParcel.writeInt(this.iAs);
      paramParcel.writeInt(this.iAt);
      paramParcel.writeInt(this.iAu);
      paramParcel.writeLong(this.iAv);
      paramParcel.writeLong(this.iAw);
      paramParcel.writeString(this.iAx);
      paramParcel.writeString(this.iAy);
      AppMethodBeat.o(63401);
    }
  }
  
  public static class PfInfoParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<PfInfoParcel> CREATOR;
    public long dBN;
    public ArrayList<NetSceneNewAAQueryPFInfo.AALaunchItemParcel> iAA;
    public String iAB;
    public String iAC;
    public NetSceneNewAAQueryPFInfo.SessionIdListParcel iAD;
    public String iAE;
    public NetSceneNewAAQueryPFInfo.AAOperationInfoParcel iAF;
    public String iAz;
    
    static
    {
      AppMethodBeat.i(63409);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(63409);
    }
    
    public PfInfoParcel()
    {
      AppMethodBeat.i(63407);
      this.iAA = new ArrayList();
      AppMethodBeat.o(63407);
    }
    
    protected PfInfoParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(63408);
      this.iAA = new ArrayList();
      this.dBN = paramParcel.readLong();
      this.iAz = paramParcel.readString();
      this.iAA = paramParcel.createTypedArrayList(NetSceneNewAAQueryPFInfo.AALaunchItemParcel.CREATOR);
      this.iAB = paramParcel.readString();
      this.iAC = paramParcel.readString();
      this.iAD = ((NetSceneNewAAQueryPFInfo.SessionIdListParcel)paramParcel.readParcelable(NetSceneNewAAQueryPFInfo.SessionIdListParcel.class.getClassLoader()));
      this.iAE = paramParcel.readString();
      this.iAF = ((NetSceneNewAAQueryPFInfo.AAOperationInfoParcel)paramParcel.readParcelable(NetSceneNewAAQueryPFInfo.AAOperationInfoParcel.class.getClassLoader()));
      AppMethodBeat.o(63408);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(63405);
      String str = "PfInfoParcel{amount=" + this.dBN + ", receiver_username='" + this.iAz + '\'' + ", payer_list=" + this.iAA + ", pic_url='" + this.iAB + '\'' + ", remark='" + this.iAC + '\'' + ", sessionid_list=" + this.iAD + ", pic_sign='" + this.iAE + '\'' + ", operation_info=" + this.iAF + '}';
      AppMethodBeat.o(63405);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(63406);
      paramParcel.writeLong(this.dBN);
      paramParcel.writeString(this.iAz);
      paramParcel.writeTypedList(this.iAA);
      paramParcel.writeString(this.iAB);
      paramParcel.writeString(this.iAC);
      paramParcel.writeParcelable(this.iAD, paramInt);
      paramParcel.writeString(this.iAE);
      paramParcel.writeParcelable(this.iAF, paramInt);
      AppMethodBeat.o(63406);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo
 * JD-Core Version:    0.7.0.1
 */
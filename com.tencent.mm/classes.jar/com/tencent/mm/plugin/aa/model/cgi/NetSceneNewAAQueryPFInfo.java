package com.tencent.mm.plugin.aa.model.cgi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.b;
import com.tencent.mm.al.b.a;
import com.tencent.mm.al.b.b;
import com.tencent.mm.al.b.c;
import com.tencent.mm.al.f;
import com.tencent.mm.network.e;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.protobuf.cpg;
import com.tencent.mm.protocal.protobuf.cph;
import com.tencent.mm.protocal.protobuf.dbh;
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
  private f callback;
  private b gPp;
  private cpg iTA;
  public cph iTB;
  
  public NetSceneNewAAQueryPFInfo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63416);
    b.a locala = new b.a();
    locala.hNM = new cpg();
    locala.hNN = new cph();
    locala.funcId = 1809;
    locala.uri = "/cgi-bin/mmpay-bin/newaaquerypfinfo";
    this.gPp = locala.aDC();
    this.iTA = ((cpg)this.gPp.hNK.hNQ);
    this.iTA.FpQ = paramString1;
    this.iTA.duW = paramString2;
    ad.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "do scene NetSceneNewAAQueryPFInfo pf_order_no:%s appid:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(63416);
  }
  
  public static PfInfoParcel a(cph paramcph)
  {
    AppMethodBeat.i(63419);
    if (paramcph == null)
    {
      AppMethodBeat.o(63419);
      return null;
    }
    PfInfoParcel localPfInfoParcel = new PfInfoParcel();
    localPfInfoParcel.dOa = paramcph.dOa;
    localPfInfoParcel.iTJ = paramcph.iTJ;
    Iterator localIterator = paramcph.FpL.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (j)localIterator.next();
      AALaunchItemParcel localAALaunchItemParcel = new AALaunchItemParcel();
      localAALaunchItemParcel.username = ((j)localObject).username;
      localAALaunchItemParcel.dOa = ((j)localObject).dOa;
      localPfInfoParcel.iTK.add(localAALaunchItemParcel);
    }
    localPfInfoParcel.iTL = paramcph.iTL;
    localPfInfoParcel.iTM = paramcph.iTM;
    if (paramcph.Hit != null)
    {
      localPfInfoParcel.iTN = new SessionIdListParcel();
      localIterator = paramcph.Hit.FyE.iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localPfInfoParcel.iTN.iTQ.add(localObject);
      }
      localIterator = paramcph.Hit.HqZ.iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localPfInfoParcel.iTN.iTR.add(localObject);
      }
    }
    localPfInfoParcel.iTO = paramcph.iTO;
    localPfInfoParcel.iTP = new AAOperationInfoParcel();
    localPfInfoParcel.iTP.iTC = paramcph.Hiu.iTC;
    localPfInfoParcel.iTP.iTD = paramcph.Hiu.iTD;
    localPfInfoParcel.iTP.iTE = paramcph.Hiu.iTE;
    localPfInfoParcel.iTP.iTF = paramcph.Hiu.iTF;
    localPfInfoParcel.iTP.iTG = paramcph.Hiu.iTG;
    localPfInfoParcel.iTP.iTH = paramcph.Hiu.iTH;
    localPfInfoParcel.iTP.iTI = paramcph.Hiu.iTI;
    AppMethodBeat.o(63419);
    return localPfInfoParcel;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(63418);
    ad.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.iTB = ((cph)((b)paramq).hNL.hNQ);
    ad.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.iTB.dlw), this.iTB.paA });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63418);
  }
  
  public final int doScene(e parame, f paramf)
  {
    AppMethodBeat.i(63417);
    ad.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "doScene");
    this.callback = paramf;
    int i = dispatch(parame, this.gPp, this);
    AppMethodBeat.o(63417);
    return i;
  }
  
  public final void e(q paramq)
  {
    paramq = (cph)((b)paramq).hNL.hNQ;
    this.Lyu = paramq.dlw;
    this.Lyv = paramq.paA;
  }
  
  public final int getType()
  {
    return 1809;
  }
  
  public static class AALaunchItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<AALaunchItemParcel> CREATOR;
    public long dOa;
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
      this.dOa = paramParcel.readLong();
      AppMethodBeat.o(63397);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(63395);
      String str = "AALaunchItemParcel{username='" + this.username + '\'' + ", amount=" + this.dOa + '}';
      AppMethodBeat.o(63395);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(63396);
      paramParcel.writeString(this.username);
      paramParcel.writeLong(this.dOa);
      AppMethodBeat.o(63396);
    }
  }
  
  public static class AAOperationInfoParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<AAOperationInfoParcel> CREATOR;
    public int iTC;
    public int iTD;
    public int iTE;
    public long iTF;
    public long iTG;
    public String iTH;
    public String iTI;
    
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
      this.iTC = paramParcel.readInt();
      this.iTD = paramParcel.readInt();
      this.iTE = paramParcel.readInt();
      this.iTF = paramParcel.readLong();
      this.iTG = paramParcel.readLong();
      this.iTH = paramParcel.readString();
      this.iTI = paramParcel.readString();
      AppMethodBeat.o(63402);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(63400);
      String str = "AAOperationInfoParcel{max_payer_num=" + this.iTC + ", max_receiver_num=" + this.iTD + ", max_total_num=" + this.iTE + ", max_total_amount=" + this.iTF + ", max_per_amount=" + this.iTG + ", notice='" + this.iTH + '\'' + ", notice_url='" + this.iTI + '\'' + '}';
      AppMethodBeat.o(63400);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(63401);
      paramParcel.writeInt(this.iTC);
      paramParcel.writeInt(this.iTD);
      paramParcel.writeInt(this.iTE);
      paramParcel.writeLong(this.iTF);
      paramParcel.writeLong(this.iTG);
      paramParcel.writeString(this.iTH);
      paramParcel.writeString(this.iTI);
      AppMethodBeat.o(63401);
    }
  }
  
  public static class PfInfoParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<PfInfoParcel> CREATOR;
    public long dOa;
    public String iTJ;
    public ArrayList<NetSceneNewAAQueryPFInfo.AALaunchItemParcel> iTK;
    public String iTL;
    public String iTM;
    public NetSceneNewAAQueryPFInfo.SessionIdListParcel iTN;
    public String iTO;
    public NetSceneNewAAQueryPFInfo.AAOperationInfoParcel iTP;
    
    static
    {
      AppMethodBeat.i(63409);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(63409);
    }
    
    public PfInfoParcel()
    {
      AppMethodBeat.i(63407);
      this.iTK = new ArrayList();
      AppMethodBeat.o(63407);
    }
    
    protected PfInfoParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(63408);
      this.iTK = new ArrayList();
      this.dOa = paramParcel.readLong();
      this.iTJ = paramParcel.readString();
      this.iTK = paramParcel.createTypedArrayList(NetSceneNewAAQueryPFInfo.AALaunchItemParcel.CREATOR);
      this.iTL = paramParcel.readString();
      this.iTM = paramParcel.readString();
      this.iTN = ((NetSceneNewAAQueryPFInfo.SessionIdListParcel)paramParcel.readParcelable(NetSceneNewAAQueryPFInfo.SessionIdListParcel.class.getClassLoader()));
      this.iTO = paramParcel.readString();
      this.iTP = ((NetSceneNewAAQueryPFInfo.AAOperationInfoParcel)paramParcel.readParcelable(NetSceneNewAAQueryPFInfo.AAOperationInfoParcel.class.getClassLoader()));
      AppMethodBeat.o(63408);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(63405);
      String str = "PfInfoParcel{amount=" + this.dOa + ", receiver_username='" + this.iTJ + '\'' + ", payer_list=" + this.iTK + ", pic_url='" + this.iTL + '\'' + ", remark='" + this.iTM + '\'' + ", sessionid_list=" + this.iTN + ", pic_sign='" + this.iTO + '\'' + ", operation_info=" + this.iTP + '}';
      AppMethodBeat.o(63405);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(63406);
      paramParcel.writeLong(this.dOa);
      paramParcel.writeString(this.iTJ);
      paramParcel.writeTypedList(this.iTK);
      paramParcel.writeString(this.iTL);
      paramParcel.writeString(this.iTM);
      paramParcel.writeParcelable(this.iTN, paramInt);
      paramParcel.writeString(this.iTO);
      paramParcel.writeParcelable(this.iTP, paramInt);
      AppMethodBeat.o(63406);
    }
  }
  
  public static class SessionIdListParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<SessionIdListParcel> CREATOR;
    public ArrayList<String> iTQ;
    public ArrayList<String> iTR;
    
    static
    {
      AppMethodBeat.i(63415);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(63415);
    }
    
    public SessionIdListParcel()
    {
      AppMethodBeat.i(63413);
      this.iTQ = new ArrayList();
      this.iTR = new ArrayList();
      AppMethodBeat.o(63413);
    }
    
    protected SessionIdListParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(63414);
      this.iTQ = new ArrayList();
      this.iTR = new ArrayList();
      this.iTQ = paramParcel.createStringArrayList();
      this.iTR = paramParcel.createStringArrayList();
      AppMethodBeat.o(63414);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(63411);
      String str = "SessionIdListParcel{username=" + this.iTQ + ", groupid=" + this.iTR + '}';
      AppMethodBeat.o(63411);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(63412);
      paramParcel.writeStringList(this.iTQ);
      paramParcel.writeStringList(this.iTR);
      AppMethodBeat.o(63412);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo
 * JD-Core Version:    0.7.0.1
 */
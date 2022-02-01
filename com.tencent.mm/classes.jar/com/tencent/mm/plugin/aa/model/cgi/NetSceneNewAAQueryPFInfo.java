package com.tencent.mm.plugin.aa.model.cgi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.d;
import com.tencent.mm.ak.d.a;
import com.tencent.mm.ak.d.b;
import com.tencent.mm.ak.d.c;
import com.tencent.mm.ak.i;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dhz;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.protocal.protobuf.dvf;
import com.tencent.mm.protocal.protobuf.l;
import com.tencent.mm.protocal.protobuf.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.c.r;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class NetSceneNewAAQueryPFInfo
  extends r
{
  private i callback;
  private d hJu;
  private dhz jTq;
  public dia jTr;
  
  public NetSceneNewAAQueryPFInfo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63416);
    d.a locala = new d.a();
    locala.iLN = new dhz();
    locala.iLO = new dia();
    locala.funcId = 1809;
    locala.uri = "/cgi-bin/mmpay-bin/newaaquerypfinfo";
    this.hJu = locala.aXF();
    this.jTq = ((dhz)this.hJu.iLK.iLR);
    this.jTq.KBC = paramString1;
    this.jTq.dNI = paramString2;
    Log.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "do scene NetSceneNewAAQueryPFInfo pf_order_no:%s appid:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(63416);
  }
  
  public static PfInfoParcel a(dia paramdia)
  {
    AppMethodBeat.i(63419);
    if (paramdia == null)
    {
      AppMethodBeat.o(63419);
      return null;
    }
    PfInfoParcel localPfInfoParcel = new PfInfoParcel();
    localPfInfoParcel.eht = paramdia.eht;
    localPfInfoParcel.jTz = paramdia.jTz;
    Iterator localIterator = paramdia.KBx.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (l)localIterator.next();
      AALaunchItemParcel localAALaunchItemParcel = new AALaunchItemParcel();
      localAALaunchItemParcel.username = ((l)localObject).username;
      localAALaunchItemParcel.eht = ((l)localObject).eht;
      localPfInfoParcel.jTA.add(localAALaunchItemParcel);
    }
    localPfInfoParcel.jTB = paramdia.jTB;
    localPfInfoParcel.remark = paramdia.remark;
    if (paramdia.MMH != null)
    {
      localPfInfoParcel.jTC = new SessionIdListParcel();
      localIterator = paramdia.MMH.KKJ.iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localPfInfoParcel.jTC.jTF.add(localObject);
      }
      localIterator = paramdia.MMH.MWk.iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localPfInfoParcel.jTC.jTG.add(localObject);
      }
    }
    localPfInfoParcel.jTD = paramdia.jTD;
    localPfInfoParcel.jTE = new AAOperationInfoParcel();
    localPfInfoParcel.jTE.jTs = paramdia.MMI.jTs;
    localPfInfoParcel.jTE.jTt = paramdia.MMI.jTt;
    localPfInfoParcel.jTE.jTu = paramdia.MMI.jTu;
    localPfInfoParcel.jTE.jTv = paramdia.MMI.jTv;
    localPfInfoParcel.jTE.jTw = paramdia.MMI.jTw;
    localPfInfoParcel.jTE.jTx = paramdia.MMI.jTx;
    localPfInfoParcel.jTE.jTy = paramdia.MMI.jTy;
    AppMethodBeat.o(63419);
    return localPfInfoParcel;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(63418);
    Log.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.jTr = ((dia)((d)params).iLL.iLR);
    Log.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.jTr.dDN), this.jTr.qwn });
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
    int i = dispatch(paramg, this.hJu, this);
    AppMethodBeat.o(63417);
    return i;
  }
  
  public final void e(s params)
  {
    params = (dia)((d)params).iLL.iLR;
    this.RtZ = params.dDN;
    this.Rua = params.qwn;
  }
  
  public final int getType()
  {
    return 1809;
  }
  
  public static class AALaunchItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<AALaunchItemParcel> CREATOR;
    public long eht;
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
      this.eht = paramParcel.readLong();
      AppMethodBeat.o(63397);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(63395);
      String str = "AALaunchItemParcel{username='" + this.username + '\'' + ", amount=" + this.eht + '}';
      AppMethodBeat.o(63395);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(63396);
      paramParcel.writeString(this.username);
      paramParcel.writeLong(this.eht);
      AppMethodBeat.o(63396);
    }
  }
  
  public static class AAOperationInfoParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<AAOperationInfoParcel> CREATOR;
    public int jTs;
    public int jTt;
    public int jTu;
    public long jTv;
    public long jTw;
    public String jTx;
    public String jTy;
    
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
      this.jTs = paramParcel.readInt();
      this.jTt = paramParcel.readInt();
      this.jTu = paramParcel.readInt();
      this.jTv = paramParcel.readLong();
      this.jTw = paramParcel.readLong();
      this.jTx = paramParcel.readString();
      this.jTy = paramParcel.readString();
      AppMethodBeat.o(63402);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(63400);
      String str = "AAOperationInfoParcel{max_payer_num=" + this.jTs + ", max_receiver_num=" + this.jTt + ", max_total_num=" + this.jTu + ", max_total_amount=" + this.jTv + ", max_per_amount=" + this.jTw + ", notice='" + this.jTx + '\'' + ", notice_url='" + this.jTy + '\'' + '}';
      AppMethodBeat.o(63400);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(63401);
      paramParcel.writeInt(this.jTs);
      paramParcel.writeInt(this.jTt);
      paramParcel.writeInt(this.jTu);
      paramParcel.writeLong(this.jTv);
      paramParcel.writeLong(this.jTw);
      paramParcel.writeString(this.jTx);
      paramParcel.writeString(this.jTy);
      AppMethodBeat.o(63401);
    }
  }
  
  public static class PfInfoParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<PfInfoParcel> CREATOR;
    public long eht;
    public ArrayList<NetSceneNewAAQueryPFInfo.AALaunchItemParcel> jTA;
    public String jTB;
    public NetSceneNewAAQueryPFInfo.SessionIdListParcel jTC;
    public String jTD;
    public NetSceneNewAAQueryPFInfo.AAOperationInfoParcel jTE;
    public String jTz;
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
      this.jTA = new ArrayList();
      AppMethodBeat.o(63407);
    }
    
    protected PfInfoParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(63408);
      this.jTA = new ArrayList();
      this.eht = paramParcel.readLong();
      this.jTz = paramParcel.readString();
      this.jTA = paramParcel.createTypedArrayList(NetSceneNewAAQueryPFInfo.AALaunchItemParcel.CREATOR);
      this.jTB = paramParcel.readString();
      this.remark = paramParcel.readString();
      this.jTC = ((NetSceneNewAAQueryPFInfo.SessionIdListParcel)paramParcel.readParcelable(NetSceneNewAAQueryPFInfo.SessionIdListParcel.class.getClassLoader()));
      this.jTD = paramParcel.readString();
      this.jTE = ((NetSceneNewAAQueryPFInfo.AAOperationInfoParcel)paramParcel.readParcelable(NetSceneNewAAQueryPFInfo.AAOperationInfoParcel.class.getClassLoader()));
      AppMethodBeat.o(63408);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(63405);
      String str = "PfInfoParcel{amount=" + this.eht + ", receiver_username='" + this.jTz + '\'' + ", payer_list=" + this.jTA + ", pic_url='" + this.jTB + '\'' + ", remark='" + this.remark + '\'' + ", sessionid_list=" + this.jTC + ", pic_sign='" + this.jTD + '\'' + ", operation_info=" + this.jTE + '}';
      AppMethodBeat.o(63405);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(63406);
      paramParcel.writeLong(this.eht);
      paramParcel.writeString(this.jTz);
      paramParcel.writeTypedList(this.jTA);
      paramParcel.writeString(this.jTB);
      paramParcel.writeString(this.remark);
      paramParcel.writeParcelable(this.jTC, paramInt);
      paramParcel.writeString(this.jTD);
      paramParcel.writeParcelable(this.jTE, paramInt);
      AppMethodBeat.o(63406);
    }
  }
  
  public static class SessionIdListParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<SessionIdListParcel> CREATOR;
    public ArrayList<String> jTF;
    public ArrayList<String> jTG;
    
    static
    {
      AppMethodBeat.i(63415);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(63415);
    }
    
    public SessionIdListParcel()
    {
      AppMethodBeat.i(63413);
      this.jTF = new ArrayList();
      this.jTG = new ArrayList();
      AppMethodBeat.o(63413);
    }
    
    protected SessionIdListParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(63414);
      this.jTF = new ArrayList();
      this.jTG = new ArrayList();
      this.jTF = paramParcel.createStringArrayList();
      this.jTG = paramParcel.createStringArrayList();
      AppMethodBeat.o(63414);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(63411);
      String str = "SessionIdListParcel{username=" + this.jTF + ", groupid=" + this.jTG + '}';
      AppMethodBeat.o(63411);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(63412);
      paramParcel.writeStringList(this.jTF);
      paramParcel.writeStringList(this.jTG);
      AppMethodBeat.o(63412);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo
 * JD-Core Version:    0.7.0.1
 */
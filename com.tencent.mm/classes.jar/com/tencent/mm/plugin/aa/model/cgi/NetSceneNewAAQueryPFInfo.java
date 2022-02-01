package com.tencent.mm.plugin.aa.model.cgi;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.am.h;
import com.tencent.mm.network.g;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.protobuf.dus;
import com.tencent.mm.protocal.protobuf.ekm;
import com.tencent.mm.protocal.protobuf.ekn;
import com.tencent.mm.protocal.protobuf.eza;
import com.tencent.mm.protocal.protobuf.m;
import com.tencent.mm.protocal.protobuf.o;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.wallet_core.model.r;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public final class NetSceneNewAAQueryPFInfo
  extends r
{
  private h callback;
  private c nao;
  private ekm pHm;
  public ekn pHn;
  
  public NetSceneNewAAQueryPFInfo(String paramString1, String paramString2)
  {
    AppMethodBeat.i(63416);
    c.a locala = new c.a();
    locala.otE = new ekm();
    locala.otF = new ekn();
    locala.funcId = 1809;
    locala.uri = "/cgi-bin/mmpay-bin/newaaquerypfinfo";
    this.nao = locala.bEF();
    this.pHm = ((ekm)c.b.b(this.nao.otB));
    this.pHm.YzV = paramString1;
    this.pHm.appid = paramString2;
    Log.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "do scene NetSceneNewAAQueryPFInfo pf_order_no:%s appid:%s", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(63416);
  }
  
  public static PfInfoParcel a(ekn paramekn)
  {
    AppMethodBeat.i(63419);
    if (paramekn == null)
    {
      AppMethodBeat.o(63419);
      return null;
    }
    PfInfoParcel localPfInfoParcel = new PfInfoParcel();
    localPfInfoParcel.ihV = paramekn.ihV;
    localPfInfoParcel.nQU = paramekn.nQU;
    Iterator localIterator = paramekn.YzQ.iterator();
    Object localObject;
    while (localIterator.hasNext())
    {
      localObject = (m)localIterator.next();
      AALaunchItemParcel localAALaunchItemParcel = new AALaunchItemParcel();
      localAALaunchItemParcel.username = ((m)localObject).username;
      localAALaunchItemParcel.ihV = ((m)localObject).ihV;
      localPfInfoParcel.pHv.add(localAALaunchItemParcel);
    }
    localPfInfoParcel.pic_url = paramekn.pic_url;
    localPfInfoParcel.remark = paramekn.remark;
    if (paramekn.abpy != null)
    {
      localPfInfoParcel.pHw = new SessionIdListParcel();
      localIterator = paramekn.abpy.msk.iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localPfInfoParcel.pHw.pHz.add(localObject);
      }
      localIterator = paramekn.abpy.abAe.iterator();
      while (localIterator.hasNext())
      {
        localObject = (String)localIterator.next();
        localPfInfoParcel.pHw.pHA.add(localObject);
      }
    }
    localPfInfoParcel.pHx = paramekn.pHx;
    localPfInfoParcel.pHy = new AAOperationInfoParcel();
    localPfInfoParcel.pHy.pHo = paramekn.abpz.pHo;
    localPfInfoParcel.pHy.pHp = paramekn.abpz.pHp;
    localPfInfoParcel.pHy.pHq = paramekn.abpz.pHq;
    localPfInfoParcel.pHy.pHr = paramekn.abpz.pHr;
    localPfInfoParcel.pHy.pHs = paramekn.abpz.pHs;
    localPfInfoParcel.pHy.pHt = paramekn.abpz.pHt;
    localPfInfoParcel.pHy.pHu = paramekn.abpz.pHu;
    localPfInfoParcel.pGr = paramekn.ign;
    AppMethodBeat.o(63419);
    return localPfInfoParcel;
  }
  
  public final void b(int paramInt1, int paramInt2, String paramString, s params)
  {
    AppMethodBeat.i(63418);
    Log.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "errType: %s, errCode: %s, errMsg: %s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString });
    this.pHn = ((ekn)c.c.b(((c)params).otC));
    Log.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "ret_code: %s, ret_msg: %s", new Object[] { Integer.valueOf(this.pHn.hAV), this.pHn.wYI });
    if (this.callback != null) {
      this.callback.onSceneEnd(paramInt1, paramInt2, paramString, this);
    }
    AppMethodBeat.o(63418);
  }
  
  public final int doScene(g paramg, h paramh)
  {
    AppMethodBeat.i(63417);
    Log.i("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", "doScene");
    this.callback = paramh;
    int i = dispatch(paramg, this.nao, this);
    AppMethodBeat.o(63417);
    return i;
  }
  
  public final void f(s params)
  {
    AppMethodBeat.i(268418);
    params = (ekn)c.c.b(((c)params).otC);
    this.agTs = params.hAV;
    this.agTt = params.wYI;
    AppMethodBeat.o(268418);
  }
  
  public final int getType()
  {
    return 1809;
  }
  
  public static class AALaunchItemParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<AALaunchItemParcel> CREATOR;
    public long ihV;
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
      this.ihV = paramParcel.readLong();
      AppMethodBeat.o(63397);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(63395);
      String str = "AALaunchItemParcel{username='" + this.username + '\'' + ", amount=" + this.ihV + '}';
      AppMethodBeat.o(63395);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(63396);
      paramParcel.writeString(this.username);
      paramParcel.writeLong(this.ihV);
      AppMethodBeat.o(63396);
    }
  }
  
  public static class AAOperationInfoParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<AAOperationInfoParcel> CREATOR;
    public int pHo;
    public int pHp;
    public int pHq;
    public long pHr;
    public long pHs;
    public String pHt;
    public String pHu;
    
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
      this.pHo = paramParcel.readInt();
      this.pHp = paramParcel.readInt();
      this.pHq = paramParcel.readInt();
      this.pHr = paramParcel.readLong();
      this.pHs = paramParcel.readLong();
      this.pHt = paramParcel.readString();
      this.pHu = paramParcel.readString();
      AppMethodBeat.o(63402);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(63400);
      String str = "AAOperationInfoParcel{max_payer_num=" + this.pHo + ", max_receiver_num=" + this.pHp + ", max_total_num=" + this.pHq + ", max_total_amount=" + this.pHr + ", max_per_amount=" + this.pHs + ", notice='" + this.pHt + '\'' + ", notice_url='" + this.pHu + '\'' + '}';
      AppMethodBeat.o(63400);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(63401);
      paramParcel.writeInt(this.pHo);
      paramParcel.writeInt(this.pHp);
      paramParcel.writeInt(this.pHq);
      paramParcel.writeLong(this.pHr);
      paramParcel.writeLong(this.pHs);
      paramParcel.writeString(this.pHt);
      paramParcel.writeString(this.pHu);
      AppMethodBeat.o(63401);
    }
  }
  
  public static class PfInfoParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<PfInfoParcel> CREATOR;
    public long ihV;
    public String nQU;
    public dus pGr;
    public ArrayList<NetSceneNewAAQueryPFInfo.AALaunchItemParcel> pHv;
    public NetSceneNewAAQueryPFInfo.SessionIdListParcel pHw;
    public String pHx;
    public NetSceneNewAAQueryPFInfo.AAOperationInfoParcel pHy;
    public String pic_url;
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
      this.pHv = new ArrayList();
      AppMethodBeat.o(63407);
    }
    
    protected PfInfoParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(63408);
      this.pHv = new ArrayList();
      this.ihV = paramParcel.readLong();
      this.nQU = paramParcel.readString();
      this.pHv = paramParcel.createTypedArrayList(NetSceneNewAAQueryPFInfo.AALaunchItemParcel.CREATOR);
      this.pic_url = paramParcel.readString();
      this.remark = paramParcel.readString();
      this.pHw = ((NetSceneNewAAQueryPFInfo.SessionIdListParcel)paramParcel.readParcelable(NetSceneNewAAQueryPFInfo.SessionIdListParcel.class.getClassLoader()));
      this.pHx = paramParcel.readString();
      this.pHy = ((NetSceneNewAAQueryPFInfo.AAOperationInfoParcel)paramParcel.readParcelable(NetSceneNewAAQueryPFInfo.AAOperationInfoParcel.class.getClassLoader()));
      int i = paramParcel.readInt();
      if (i >= 0)
      {
        byte[] arrayOfByte = new byte[i];
        paramParcel.readByteArray(arrayOfByte);
        paramParcel = new dus();
        try
        {
          paramParcel.parseFrom(arrayOfByte);
          this.pGr = paramParcel;
          AppMethodBeat.o(63408);
          return;
        }
        catch (IOException paramParcel)
        {
          Log.printErrStackTrace("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", paramParcel, "", new Object[0]);
        }
      }
      AppMethodBeat.o(63408);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(63405);
      String str = "PfInfoParcel{amount=" + this.ihV + ", receiver_username='" + this.nQU + '\'' + ", payer_list=" + this.pHv + ", pic_url='" + this.pic_url + '\'' + ", remark='" + this.remark + '\'' + ", sessionid_list=" + this.pHw + ", pic_sign='" + this.pHx + '\'' + ", operation_info=" + this.pHy + '}';
      AppMethodBeat.o(63405);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(63406);
      paramParcel.writeLong(this.ihV);
      paramParcel.writeString(this.nQU);
      paramParcel.writeTypedList(this.pHv);
      paramParcel.writeString(this.pic_url);
      paramParcel.writeString(this.remark);
      paramParcel.writeParcelable(this.pHw, paramInt);
      paramParcel.writeString(this.pHx);
      paramParcel.writeParcelable(this.pHy, paramInt);
      if (this.pGr != null) {
        try
        {
          byte[] arrayOfByte = this.pGr.toByteArray();
          paramParcel.writeInt(arrayOfByte.length);
          paramParcel.writeByteArray(arrayOfByte, 0, arrayOfByte.length);
          AppMethodBeat.o(63406);
          return;
        }
        catch (IOException paramParcel)
        {
          Log.printErrStackTrace("MicroMsg.Aa.NetSceneNewAAQueryPFInfo", paramParcel, "", new Object[0]);
          AppMethodBeat.o(63406);
          return;
        }
      }
      paramParcel.writeInt(0);
      AppMethodBeat.o(63406);
    }
  }
  
  public static class SessionIdListParcel
    implements Parcelable
  {
    public static final Parcelable.Creator<SessionIdListParcel> CREATOR;
    public ArrayList<String> pHA;
    public ArrayList<String> pHz;
    
    static
    {
      AppMethodBeat.i(63415);
      CREATOR = new Parcelable.Creator() {};
      AppMethodBeat.o(63415);
    }
    
    public SessionIdListParcel()
    {
      AppMethodBeat.i(63413);
      this.pHz = new ArrayList();
      this.pHA = new ArrayList();
      AppMethodBeat.o(63413);
    }
    
    protected SessionIdListParcel(Parcel paramParcel)
    {
      AppMethodBeat.i(63414);
      this.pHz = new ArrayList();
      this.pHA = new ArrayList();
      this.pHz = paramParcel.createStringArrayList();
      this.pHA = paramParcel.createStringArrayList();
      AppMethodBeat.o(63414);
    }
    
    public int describeContents()
    {
      return 0;
    }
    
    public String toString()
    {
      AppMethodBeat.i(63411);
      String str = "SessionIdListParcel{username=" + this.pHz + ", groupid=" + this.pHA + '}';
      AppMethodBeat.o(63411);
      return str;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      AppMethodBeat.i(63412);
      paramParcel.writeStringList(this.pHz);
      paramParcel.writeStringList(this.pHA);
      AppMethodBeat.o(63412);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo
 * JD-Core Version:    0.7.0.1
 */
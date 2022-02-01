package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.ia;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.c.l;
import com.tencent.mm.protocal.protobuf.fbs;
import com.tencent.mm.protocal.protobuf.vr;
import com.tencent.mm.protocal.protobuf.wh;
import com.tencent.mm.protocal.protobuf.wl;
import com.tencent.mm.protocal.protobuf.ws;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;

public class CardInfo
  extends ia
  implements Parcelable, b
{
  public static final Parcelable.Creator<CardInfo> CREATOR;
  protected static IAutoDBItem.MAutoDBInfo info;
  public String wsB;
  public ws wtH;
  public vr wtI;
  public fbs wtJ;
  public wl wtK;
  public boolean wtL;
  
  static
  {
    AppMethodBeat.i(112765);
    info = ia.aJm();
    CREATOR = new CardInfo.1();
    AppMethodBeat.o(112765);
  }
  
  public CardInfo()
  {
    this.wtL = true;
    this.wsB = "";
    this.field_card_type = -1;
  }
  
  public CardInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(112759);
    this.wtL = true;
    this.wsB = "";
    this.field_card_id = paramParcel.readString();
    this.field_card_tp_id = paramParcel.readString();
    this.field_from_username = paramParcel.readString();
    this.field_status = paramParcel.readInt();
    this.field_delete_state_flag = paramParcel.readInt();
    this.field_local_updateTime = paramParcel.readLong();
    this.field_updateTime = paramParcel.readLong();
    this.field_updateSeq = paramParcel.readLong();
    this.field_create_time = paramParcel.readLong();
    this.field_begin_time = paramParcel.readLong();
    this.field_end_time = paramParcel.readLong();
    this.field_block_mask = paramParcel.readString();
    this.field_stickyIndex = paramParcel.readInt();
    this.field_stickyEndTime = paramParcel.readInt();
    this.field_stickyAnnouncement = paramParcel.readString();
    this.field_card_type = paramParcel.readInt();
    this.field_label_wording = paramParcel.readString();
    int k = paramParcel.readInt();
    int i;
    if (k > 0)
    {
      this.field_dataInfoData = new byte[k];
      i = 0;
      while (i < k)
      {
        this.field_dataInfoData[i] = paramParcel.readByte();
        i += 1;
      }
    }
    k = paramParcel.readInt();
    if (k > 0)
    {
      this.field_cardTpInfoData = new byte[k];
      i = 0;
      while (i < k)
      {
        this.field_cardTpInfoData[i] = paramParcel.readByte();
        i += 1;
      }
    }
    k = paramParcel.readInt();
    if (k > 0)
    {
      this.field_shareInfoData = new byte[k];
      i = 0;
      while (i < k)
      {
        this.field_shareInfoData[i] = paramParcel.readByte();
        i += 1;
      }
    }
    k = paramParcel.readInt();
    if (k > 0)
    {
      this.field_shopInfoData = new byte[k];
      i = j;
      while (i < k)
      {
        this.field_shopInfoData[i] = paramParcel.readByte();
        i += 1;
      }
    }
    AppMethodBeat.o(112759);
  }
  
  public final String Ig(int paramInt)
  {
    return null;
  }
  
  public final void a(fbs paramfbs)
  {
    AppMethodBeat.i(112756);
    this.wtJ = paramfbs;
    if (paramfbs != null) {}
    try
    {
      this.field_shareInfoData = paramfbs.toByteArray();
      AppMethodBeat.o(112756);
      return;
    }
    catch (Exception paramfbs)
    {
      Log.e("MicroMsg.CardInfo", "setShareInfo fail, ex = %s", new Object[] { paramfbs.getMessage() });
      Log.printErrStackTrace("MicroMsg.CardInfo", paramfbs, "", new Object[0]);
      AppMethodBeat.o(112756);
    }
  }
  
  public final void a(vr paramvr)
  {
    AppMethodBeat.i(112754);
    this.wtI = paramvr;
    if (this.wtI != null)
    {
      this.field_status = this.wtI.status;
      if (paramvr != null) {}
      try
      {
        this.field_dataInfoData = paramvr.toByteArray();
        AppMethodBeat.o(112754);
        return;
      }
      catch (Exception paramvr)
      {
        Log.e("MicroMsg.CardInfo", "setDataInfo fail, ex = %s", new Object[] { paramvr.getMessage() });
        Log.printErrStackTrace("MicroMsg.CardInfo", paramvr, "", new Object[0]);
      }
    }
    AppMethodBeat.o(112754);
  }
  
  public final void a(wl paramwl)
  {
    AppMethodBeat.i(112758);
    this.wtK = paramwl;
    if (paramwl != null) {}
    try
    {
      this.field_shopInfoData = paramwl.toByteArray();
      AppMethodBeat.o(112758);
      return;
    }
    catch (Exception paramwl)
    {
      Log.e("MicroMsg.CardInfo", "setShopInfo fail, ex = %s", new Object[] { paramwl.getMessage() });
      Log.printErrStackTrace("MicroMsg.CardInfo", paramwl, "", new Object[0]);
      AppMethodBeat.o(112758);
    }
  }
  
  public final void a(ws paramws)
  {
    AppMethodBeat.i(112752);
    this.wtH = paramws;
    if (paramws != null) {}
    try
    {
      this.field_cardTpInfoData = paramws.toByteArray();
      AppMethodBeat.o(112752);
      return;
    }
    catch (Exception paramws)
    {
      Log.e("MicroMsg.CardInfo", "setCardTpInfo fail, ex = %s", new Object[] { paramws.getMessage() });
      AppMethodBeat.o(112752);
    }
  }
  
  public final void akq(String paramString)
  {
    this.field_from_username = paramString;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public final boolean djA()
  {
    AppMethodBeat.i(112744);
    if ((djK().ZdT & 0x2) > 0L)
    {
      AppMethodBeat.o(112744);
      return true;
    }
    AppMethodBeat.o(112744);
    return false;
  }
  
  public final boolean djB()
  {
    AppMethodBeat.i(112745);
    if ((djK().ZdT & 0x20) > 0L)
    {
      AppMethodBeat.o(112745);
      return true;
    }
    AppMethodBeat.o(112745);
    return false;
  }
  
  public final boolean djC()
  {
    AppMethodBeat.i(112746);
    if ((djK().ZdT & 0x4) > 0L)
    {
      AppMethodBeat.o(112746);
      return true;
    }
    AppMethodBeat.o(112746);
    return false;
  }
  
  public final boolean djD()
  {
    AppMethodBeat.i(112747);
    if ((djK().ZdT & 0x8) > 0L)
    {
      AppMethodBeat.o(112747);
      return true;
    }
    AppMethodBeat.o(112747);
    return false;
  }
  
  public final boolean djE()
  {
    AppMethodBeat.i(112764);
    if ((djK() != null) && (djK().Zef == 1))
    {
      AppMethodBeat.o(112764);
      return true;
    }
    AppMethodBeat.o(112764);
    return false;
  }
  
  public final boolean djF()
  {
    return (this.wtI != null) && (this.wtI.status == 0);
  }
  
  public final boolean djG()
  {
    AppMethodBeat.i(112748);
    if (!djF())
    {
      AppMethodBeat.o(112748);
      return false;
    }
    if (this.wtH != null) {
      Log.i("MicroMsg.CardInfo", "is_acceptable:" + this.wtH.Zeg);
    }
    Log.i("MicroMsg.CardInfo", "stock_num:" + this.wtI.ZbA + " limit_num:" + this.wtI.ZbB);
    if ((this.wtH != null) && (this.wtH.Zeg == 1))
    {
      AppMethodBeat.o(112748);
      return true;
    }
    if ((this.wtH != null) && (this.wtH.Zeg == 0))
    {
      AppMethodBeat.o(112748);
      return false;
    }
    if ((this.wtI.ZbA == 0L) || (this.wtI.ZbB == 0))
    {
      AppMethodBeat.o(112748);
      return false;
    }
    AppMethodBeat.o(112748);
    return false;
  }
  
  public final boolean djH()
  {
    AppMethodBeat.i(112749);
    if (!djF())
    {
      AppMethodBeat.o(112749);
      return false;
    }
    if (this.wtH != null) {
      Log.i("MicroMsg.CardInfo", "is_acceptable:" + this.wtH.Zeg);
    }
    Log.i("MicroMsg.CardInfo", "avail_num:" + this.wtI.Zbx);
    if ((this.wtH != null) && (this.wtH.Zeg == 1))
    {
      AppMethodBeat.o(112749);
      return true;
    }
    if (this.wtI.Zbx > 0)
    {
      AppMethodBeat.o(112749);
      return true;
    }
    if ((this.wtH != null) && (this.wtH.Zeg == 0))
    {
      AppMethodBeat.o(112749);
      return false;
    }
    if (this.wtI.Zbx == 0)
    {
      AppMethodBeat.o(112749);
      return false;
    }
    AppMethodBeat.o(112749);
    return false;
  }
  
  public final boolean djI()
  {
    AppMethodBeat.i(112750);
    if ((this.wtH == null) || (this.wtH.ZdX == null) || (TextUtils.isEmpty(this.wtH.ZdX.text)))
    {
      AppMethodBeat.o(112750);
      return false;
    }
    wh localwh = this.wtH.ZdX;
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = localwh.PzZ;
    if ((localwh.PzZ > 0) && (j - i > 0))
    {
      AppMethodBeat.o(112750);
      return true;
    }
    AppMethodBeat.o(112750);
    return false;
  }
  
  public final boolean djJ()
  {
    return (this.wtH != null) && (this.wtH.Zek == 1);
  }
  
  public final ws djK()
  {
    AppMethodBeat.i(112751);
    ws localws1;
    if (this.wtH != null)
    {
      localws1 = this.wtH;
      AppMethodBeat.o(112751);
      return localws1;
    }
    try
    {
      if (this.field_cardTpInfoData != null)
      {
        this.wtH = ((ws)new ws().parseFrom(this.field_cardTpInfoData));
        localws1 = this.wtH;
        AppMethodBeat.o(112751);
        return localws1;
      }
      localws1 = new ws();
      AppMethodBeat.o(112751);
      return localws1;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.CardInfo", "getCardTpInfo fail, ex = %s", new Object[] { localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      ws localws2 = new ws();
      AppMethodBeat.o(112751);
      return localws2;
    }
  }
  
  public final vr djL()
  {
    AppMethodBeat.i(112753);
    vr localvr1;
    if (this.wtI != null)
    {
      localvr1 = this.wtI;
      AppMethodBeat.o(112753);
      return localvr1;
    }
    try
    {
      if (this.field_dataInfoData != null)
      {
        this.wtI = ((vr)new vr().parseFrom(this.field_dataInfoData));
        localvr1 = this.wtI;
        AppMethodBeat.o(112753);
        return localvr1;
      }
      localvr1 = new vr();
      AppMethodBeat.o(112753);
      return localvr1;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.CardInfo", "getDataInfo fail, ex = %s", new Object[] { localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      vr localvr2 = new vr();
      AppMethodBeat.o(112753);
      return localvr2;
    }
  }
  
  public final fbs djM()
  {
    AppMethodBeat.i(112755);
    fbs localfbs1;
    if (this.wtJ != null)
    {
      localfbs1 = this.wtJ;
      AppMethodBeat.o(112755);
      return localfbs1;
    }
    try
    {
      if (this.field_shareInfoData != null)
      {
        this.wtJ = ((fbs)new fbs().parseFrom(this.field_shareInfoData));
        localfbs1 = this.wtJ;
        AppMethodBeat.o(112755);
        return localfbs1;
      }
      localfbs1 = new fbs();
      AppMethodBeat.o(112755);
      return localfbs1;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.CardInfo", "getShareInfo fail, ex = %s", new Object[] { localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      fbs localfbs2 = new fbs();
      AppMethodBeat.o(112755);
      return localfbs2;
    }
  }
  
  public final wl djN()
  {
    AppMethodBeat.i(112757);
    wl localwl;
    if (this.wtK != null)
    {
      localwl = this.wtK;
      AppMethodBeat.o(112757);
      return localwl;
    }
    try
    {
      if (this.field_shopInfoData != null)
      {
        this.wtK = ((wl)new wl().parseFrom(this.field_shopInfoData));
        localwl = this.wtK;
        AppMethodBeat.o(112757);
        return localwl;
      }
      AppMethodBeat.o(112757);
      return null;
    }
    catch (Exception localException)
    {
      Log.e("MicroMsg.CardInfo", "getShopInfo fail ex = %s", new Object[] { localException.getMessage() });
      Log.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      AppMethodBeat.o(112757);
    }
    return null;
  }
  
  public final String djO()
  {
    return this.field_card_id;
  }
  
  public final String djP()
  {
    return this.field_card_tp_id;
  }
  
  public final String djQ()
  {
    return this.field_from_username;
  }
  
  public final long djR()
  {
    return this.field_local_updateTime;
  }
  
  public final String djS()
  {
    return null;
  }
  
  public final String djT()
  {
    AppMethodBeat.i(112763);
    Log.d("MicroMsg.CardInfo", "encrypt_code:" + this.wsB);
    String str = this.wsB;
    AppMethodBeat.o(112763);
    return str;
  }
  
  public final boolean djo()
  {
    AppMethodBeat.i(112761);
    if ((djK() != null) && (djK().Zea == 0))
    {
      AppMethodBeat.o(112761);
      return true;
    }
    AppMethodBeat.o(112761);
    return false;
  }
  
  public final boolean djp()
  {
    AppMethodBeat.i(112762);
    if ((djK() != null) && (djK().Zea == 1))
    {
      AppMethodBeat.o(112762);
      return true;
    }
    AppMethodBeat.o(112762);
    return false;
  }
  
  public final boolean djq()
  {
    AppMethodBeat.i(112734);
    if ((djK() != null) && (djK().tNW == 10))
    {
      AppMethodBeat.o(112734);
      return true;
    }
    AppMethodBeat.o(112734);
    return false;
  }
  
  public final boolean djr()
  {
    AppMethodBeat.i(112735);
    if ((djK() != null) && (djK().tNW == 0))
    {
      AppMethodBeat.o(112735);
      return true;
    }
    AppMethodBeat.o(112735);
    return false;
  }
  
  public final boolean djs()
  {
    AppMethodBeat.i(112736);
    if ((djK() != null) && (djK().tNW == 20))
    {
      AppMethodBeat.o(112736);
      return true;
    }
    AppMethodBeat.o(112736);
    return false;
  }
  
  public final boolean djt()
  {
    AppMethodBeat.i(112737);
    if ((djK() != null) && (djK().tNW == 11))
    {
      AppMethodBeat.o(112737);
      return true;
    }
    AppMethodBeat.o(112737);
    return false;
  }
  
  public final boolean dju()
  {
    AppMethodBeat.i(112738);
    if ((djK() != null) && (djK().tNW == 30))
    {
      AppMethodBeat.o(112738);
      return true;
    }
    AppMethodBeat.o(112738);
    return false;
  }
  
  public final boolean djv()
  {
    AppMethodBeat.i(112739);
    boolean bool = l.Ii(djK().tNW);
    AppMethodBeat.o(112739);
    return bool;
  }
  
  public final boolean djw()
  {
    AppMethodBeat.i(112740);
    if ((djK().ZdQ & 0x2) == 0)
    {
      AppMethodBeat.o(112740);
      return true;
    }
    AppMethodBeat.o(112740);
    return false;
  }
  
  public final boolean djx()
  {
    AppMethodBeat.i(112741);
    if ((djK().ZdQ & 0x1) == 0)
    {
      AppMethodBeat.o(112741);
      return true;
    }
    AppMethodBeat.o(112741);
    return false;
  }
  
  public final boolean djy()
  {
    AppMethodBeat.i(112742);
    if ((djK().ZdT & 1L) == 0L)
    {
      AppMethodBeat.o(112742);
      return true;
    }
    AppMethodBeat.o(112742);
    return false;
  }
  
  public final boolean djz()
  {
    AppMethodBeat.i(112743);
    if ((djK().ZdT & 0x10) == 0L)
    {
      AppMethodBeat.o(112743);
      return true;
    }
    AppMethodBeat.o(112743);
    return false;
  }
  
  public final int getCategoryType()
  {
    return 0;
  }
  
  public IAutoDBItem.MAutoDBInfo getDBInfo()
  {
    return info;
  }
  
  public final long getEndTime()
  {
    return this.field_end_time;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(112760);
    paramParcel.writeString(this.field_card_id);
    paramParcel.writeString(this.field_card_tp_id);
    paramParcel.writeString(this.field_from_username);
    paramParcel.writeInt(this.field_status);
    paramParcel.writeInt(this.field_delete_state_flag);
    paramParcel.writeLong(this.field_local_updateTime);
    paramParcel.writeLong(this.field_updateTime);
    paramParcel.writeLong(this.field_updateSeq);
    paramParcel.writeLong(this.field_create_time);
    paramParcel.writeLong(this.field_begin_time);
    paramParcel.writeLong(this.field_end_time);
    paramParcel.writeString(this.field_block_mask);
    paramParcel.writeInt(this.field_stickyIndex);
    paramParcel.writeInt(this.field_stickyEndTime);
    paramParcel.writeString(this.field_stickyAnnouncement);
    paramParcel.writeInt(this.field_card_type);
    paramParcel.writeString(this.field_label_wording);
    if (this.field_dataInfoData != null)
    {
      paramParcel.writeInt(this.field_dataInfoData.length);
      paramInt = 0;
      while (paramInt < this.field_dataInfoData.length)
      {
        paramParcel.writeByte(this.field_dataInfoData[paramInt]);
        paramInt += 1;
      }
    }
    paramParcel.writeInt(0);
    if (this.field_cardTpInfoData != null)
    {
      paramParcel.writeInt(this.field_cardTpInfoData.length);
      paramInt = 0;
      while (paramInt < this.field_cardTpInfoData.length)
      {
        paramParcel.writeByte(this.field_cardTpInfoData[paramInt]);
        paramInt += 1;
      }
    }
    paramParcel.writeInt(0);
    if (this.field_shareInfoData != null)
    {
      paramParcel.writeInt(this.field_shareInfoData.length);
      paramInt = 0;
      while (paramInt < this.field_shareInfoData.length)
      {
        paramParcel.writeByte(this.field_shareInfoData[paramInt]);
        paramInt += 1;
      }
    }
    paramParcel.writeInt(0);
    if (this.field_shopInfoData != null)
    {
      paramParcel.writeInt(this.field_shopInfoData.length);
      paramInt = i;
      while (paramInt < this.field_shopInfoData.length)
      {
        paramParcel.writeByte(this.field_shopInfoData[paramInt]);
        paramInt += 1;
      }
      AppMethodBeat.o(112760);
      return;
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(112760);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.CardInfo
 * JD-Core Version:    0.7.0.1
 */
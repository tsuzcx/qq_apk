package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.gl;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.ddt;
import com.tencent.mm.protocal.protobuf.sr;
import com.tencent.mm.protocal.protobuf.th;
import com.tencent.mm.protocal.protobuf.tl;
import com.tencent.mm.protocal.protobuf.ts;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Field;
import java.util.Map;

public class CardInfo
  extends gl
  implements Parcelable, b
{
  public static final Parcelable.Creator<CardInfo> CREATOR;
  protected static c.a info;
  public String oxP;
  public ts oyX;
  public sr oyY;
  public ddt oyZ;
  public tl oza;
  public boolean ozb;
  
  static
  {
    AppMethodBeat.i(112765);
    c.a locala = new c.a();
    locala.IhA = new Field[22];
    locala.columns = new String[23];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "card_id";
    locala.IhC.put("card_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" card_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.IhB = "card_id";
    locala.columns[1] = "card_tp_id";
    locala.IhC.put("card_tp_id", "TEXT");
    localStringBuilder.append(" card_tp_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "from_username";
    locala.IhC.put("from_username", "TEXT");
    localStringBuilder.append(" from_username TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "status";
    locala.IhC.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "delete_state_flag";
    locala.IhC.put("delete_state_flag", "INTEGER");
    localStringBuilder.append(" delete_state_flag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "local_updateTime";
    locala.IhC.put("local_updateTime", "LONG");
    localStringBuilder.append(" local_updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "updateTime";
    locala.IhC.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "updateSeq";
    locala.IhC.put("updateSeq", "LONG");
    localStringBuilder.append(" updateSeq LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "create_time";
    locala.IhC.put("create_time", "LONG");
    localStringBuilder.append(" create_time LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "begin_time";
    locala.IhC.put("begin_time", "LONG");
    localStringBuilder.append(" begin_time LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "end_time";
    locala.IhC.put("end_time", "LONG");
    localStringBuilder.append(" end_time LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "block_mask";
    locala.IhC.put("block_mask", "TEXT");
    localStringBuilder.append(" block_mask TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "dataInfoData";
    locala.IhC.put("dataInfoData", "BLOB");
    localStringBuilder.append(" dataInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "cardTpInfoData";
    locala.IhC.put("cardTpInfoData", "BLOB");
    localStringBuilder.append(" cardTpInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "shareInfoData";
    locala.IhC.put("shareInfoData", "BLOB");
    localStringBuilder.append(" shareInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "shopInfoData";
    locala.IhC.put("shopInfoData", "BLOB");
    localStringBuilder.append(" shopInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[16] = "stickyIndex";
    locala.IhC.put("stickyIndex", "INTEGER");
    localStringBuilder.append(" stickyIndex INTEGER");
    localStringBuilder.append(", ");
    locala.columns[17] = "stickyEndTime";
    locala.IhC.put("stickyEndTime", "INTEGER");
    localStringBuilder.append(" stickyEndTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[18] = "stickyAnnouncement";
    locala.IhC.put("stickyAnnouncement", "TEXT");
    localStringBuilder.append(" stickyAnnouncement TEXT");
    localStringBuilder.append(", ");
    locala.columns[19] = "card_type";
    locala.IhC.put("card_type", "INTEGER default '-1' ");
    localStringBuilder.append(" card_type INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "label_wording";
    locala.IhC.put("label_wording", "TEXT");
    localStringBuilder.append(" label_wording TEXT");
    localStringBuilder.append(", ");
    locala.columns[21] = "is_dynamic";
    locala.IhC.put("is_dynamic", "INTEGER");
    localStringBuilder.append(" is_dynamic INTEGER");
    locala.columns[22] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(112765);
  }
  
  public CardInfo()
  {
    this.ozb = true;
    this.oxP = "";
    this.field_card_type = -1;
  }
  
  public CardInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(112759);
    this.ozb = true;
    this.oxP = "";
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
  
  public final String An(int paramInt)
  {
    return null;
  }
  
  public final void Yc(String paramString)
  {
    this.field_from_username = paramString;
  }
  
  public final void a(ddt paramddt)
  {
    AppMethodBeat.i(112756);
    this.oyZ = paramddt;
    if (paramddt != null) {}
    try
    {
      this.field_shareInfoData = paramddt.toByteArray();
      AppMethodBeat.o(112756);
      return;
    }
    catch (Exception paramddt)
    {
      ad.e("MicroMsg.CardInfo", "setShareInfo fail, ex = %s", new Object[] { paramddt.getMessage() });
      ad.printErrStackTrace("MicroMsg.CardInfo", paramddt, "", new Object[0]);
      AppMethodBeat.o(112756);
    }
  }
  
  public final void a(sr paramsr)
  {
    AppMethodBeat.i(112754);
    this.oyY = paramsr;
    if (this.oyY != null)
    {
      this.field_status = this.oyY.status;
      if (paramsr != null) {}
      try
      {
        this.field_dataInfoData = paramsr.toByteArray();
        AppMethodBeat.o(112754);
        return;
      }
      catch (Exception paramsr)
      {
        ad.e("MicroMsg.CardInfo", "setDataInfo fail, ex = %s", new Object[] { paramsr.getMessage() });
        ad.printErrStackTrace("MicroMsg.CardInfo", paramsr, "", new Object[0]);
      }
    }
    AppMethodBeat.o(112754);
  }
  
  public final void a(tl paramtl)
  {
    AppMethodBeat.i(112758);
    this.oza = paramtl;
    if (paramtl != null) {}
    try
    {
      this.field_shopInfoData = paramtl.toByteArray();
      AppMethodBeat.o(112758);
      return;
    }
    catch (Exception paramtl)
    {
      ad.e("MicroMsg.CardInfo", "setShopInfo fail, ex = %s", new Object[] { paramtl.getMessage() });
      ad.printErrStackTrace("MicroMsg.CardInfo", paramtl, "", new Object[0]);
      AppMethodBeat.o(112758);
    }
  }
  
  public final void a(ts paramts)
  {
    AppMethodBeat.i(112752);
    this.oyX = paramts;
    if (paramts != null) {}
    try
    {
      this.field_cardTpInfoData = paramts.toByteArray();
      AppMethodBeat.o(112752);
      return;
    }
    catch (Exception paramts)
    {
      ad.e("MicroMsg.CardInfo", "setCardTpInfo fail, ex = %s", new Object[] { paramts.getMessage() });
      AppMethodBeat.o(112752);
    }
  }
  
  public final boolean bTA()
  {
    AppMethodBeat.i(112740);
    if ((bTN().FRF & 0x2) == 0)
    {
      AppMethodBeat.o(112740);
      return true;
    }
    AppMethodBeat.o(112740);
    return false;
  }
  
  public final boolean bTB()
  {
    AppMethodBeat.i(112741);
    if ((bTN().FRF & 0x1) == 0)
    {
      AppMethodBeat.o(112741);
      return true;
    }
    AppMethodBeat.o(112741);
    return false;
  }
  
  public final boolean bTC()
  {
    AppMethodBeat.i(112742);
    if ((bTN().FRI & 1L) == 0L)
    {
      AppMethodBeat.o(112742);
      return true;
    }
    AppMethodBeat.o(112742);
    return false;
  }
  
  public final boolean bTD()
  {
    AppMethodBeat.i(112743);
    if ((bTN().FRI & 0x10) == 0L)
    {
      AppMethodBeat.o(112743);
      return true;
    }
    AppMethodBeat.o(112743);
    return false;
  }
  
  public final boolean bTE()
  {
    AppMethodBeat.i(112744);
    if ((bTN().FRI & 0x2) > 0L)
    {
      AppMethodBeat.o(112744);
      return true;
    }
    AppMethodBeat.o(112744);
    return false;
  }
  
  public final boolean bTF()
  {
    AppMethodBeat.i(112745);
    if ((bTN().FRI & 0x20) > 0L)
    {
      AppMethodBeat.o(112745);
      return true;
    }
    AppMethodBeat.o(112745);
    return false;
  }
  
  public final boolean bTG()
  {
    AppMethodBeat.i(112746);
    if ((bTN().FRI & 0x4) > 0L)
    {
      AppMethodBeat.o(112746);
      return true;
    }
    AppMethodBeat.o(112746);
    return false;
  }
  
  public final boolean bTH()
  {
    AppMethodBeat.i(112747);
    if ((bTN().FRI & 0x8) > 0L)
    {
      AppMethodBeat.o(112747);
      return true;
    }
    AppMethodBeat.o(112747);
    return false;
  }
  
  public final boolean bTI()
  {
    AppMethodBeat.i(112764);
    if ((bTN() != null) && (bTN().FRU == 1))
    {
      AppMethodBeat.o(112764);
      return true;
    }
    AppMethodBeat.o(112764);
    return false;
  }
  
  public final boolean bTJ()
  {
    return (this.oyY != null) && (this.oyY.status == 0);
  }
  
  public final boolean bTK()
  {
    AppMethodBeat.i(112749);
    if (!bTJ())
    {
      AppMethodBeat.o(112749);
      return false;
    }
    if (this.oyX != null) {
      ad.i("MicroMsg.CardInfo", "is_acceptable:" + this.oyX.FRV);
    }
    ad.i("MicroMsg.CardInfo", "avail_num:" + this.oyY.FPo);
    if ((this.oyX != null) && (this.oyX.FRV == 1))
    {
      AppMethodBeat.o(112749);
      return true;
    }
    if (this.oyY.FPo > 0)
    {
      AppMethodBeat.o(112749);
      return true;
    }
    if ((this.oyX != null) && (this.oyX.FRV == 0))
    {
      AppMethodBeat.o(112749);
      return false;
    }
    if (this.oyY.FPo == 0)
    {
      AppMethodBeat.o(112749);
      return false;
    }
    AppMethodBeat.o(112749);
    return false;
  }
  
  public final boolean bTL()
  {
    AppMethodBeat.i(112750);
    if ((this.oyX == null) || (this.oyX.FRM == null) || (TextUtils.isEmpty(this.oyX.FRM.text)))
    {
      AppMethodBeat.o(112750);
      return false;
    }
    th localth = this.oyX.FRM;
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = localth.yMB;
    if ((localth.yMB > 0) && (j - i > 0))
    {
      AppMethodBeat.o(112750);
      return true;
    }
    AppMethodBeat.o(112750);
    return false;
  }
  
  public final boolean bTM()
  {
    return (this.oyX != null) && (this.oyX.FRZ == 1);
  }
  
  public final ts bTN()
  {
    AppMethodBeat.i(112751);
    ts localts1;
    if (this.oyX != null)
    {
      localts1 = this.oyX;
      AppMethodBeat.o(112751);
      return localts1;
    }
    try
    {
      if (this.field_cardTpInfoData != null)
      {
        this.oyX = ((ts)new ts().parseFrom(this.field_cardTpInfoData));
        localts1 = this.oyX;
        AppMethodBeat.o(112751);
        return localts1;
      }
      localts1 = new ts();
      AppMethodBeat.o(112751);
      return localts1;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.CardInfo", "getCardTpInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ad.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      ts localts2 = new ts();
      AppMethodBeat.o(112751);
      return localts2;
    }
  }
  
  public final sr bTO()
  {
    AppMethodBeat.i(112753);
    sr localsr1;
    if (this.oyY != null)
    {
      localsr1 = this.oyY;
      AppMethodBeat.o(112753);
      return localsr1;
    }
    try
    {
      if (this.field_dataInfoData != null)
      {
        this.oyY = ((sr)new sr().parseFrom(this.field_dataInfoData));
        localsr1 = this.oyY;
        AppMethodBeat.o(112753);
        return localsr1;
      }
      localsr1 = new sr();
      AppMethodBeat.o(112753);
      return localsr1;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.CardInfo", "getDataInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ad.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      sr localsr2 = new sr();
      AppMethodBeat.o(112753);
      return localsr2;
    }
  }
  
  public final ddt bTP()
  {
    AppMethodBeat.i(112755);
    ddt localddt1;
    if (this.oyZ != null)
    {
      localddt1 = this.oyZ;
      AppMethodBeat.o(112755);
      return localddt1;
    }
    try
    {
      if (this.field_shareInfoData != null)
      {
        this.oyZ = ((ddt)new ddt().parseFrom(this.field_shareInfoData));
        localddt1 = this.oyZ;
        AppMethodBeat.o(112755);
        return localddt1;
      }
      localddt1 = new ddt();
      AppMethodBeat.o(112755);
      return localddt1;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.CardInfo", "getShareInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ad.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      ddt localddt2 = new ddt();
      AppMethodBeat.o(112755);
      return localddt2;
    }
  }
  
  public final tl bTQ()
  {
    AppMethodBeat.i(112757);
    tl localtl;
    if (this.oza != null)
    {
      localtl = this.oza;
      AppMethodBeat.o(112757);
      return localtl;
    }
    try
    {
      if (this.field_shopInfoData != null)
      {
        this.oza = ((tl)new tl().parseFrom(this.field_shopInfoData));
        localtl = this.oza;
        AppMethodBeat.o(112757);
        return localtl;
      }
      AppMethodBeat.o(112757);
      return null;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.CardInfo", "getShopInfo fail ex = %s", new Object[] { localException.getMessage() });
      ad.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      AppMethodBeat.o(112757);
    }
    return null;
  }
  
  public final String bTR()
  {
    return this.field_card_id;
  }
  
  public final String bTS()
  {
    return this.field_card_tp_id;
  }
  
  public final String bTT()
  {
    return this.field_from_username;
  }
  
  public final long bTU()
  {
    return this.field_local_updateTime;
  }
  
  public final String bTV()
  {
    return null;
  }
  
  public final int bTW()
  {
    return 0;
  }
  
  public final String bTX()
  {
    AppMethodBeat.i(112763);
    ad.d("MicroMsg.CardInfo", "encrypt_code:" + this.oxP);
    String str = this.oxP;
    AppMethodBeat.o(112763);
    return str;
  }
  
  public final boolean bTs()
  {
    AppMethodBeat.i(112761);
    if ((bTN() != null) && (bTN().FRP == 0))
    {
      AppMethodBeat.o(112761);
      return true;
    }
    AppMethodBeat.o(112761);
    return false;
  }
  
  public final boolean bTt()
  {
    AppMethodBeat.i(112762);
    if ((bTN() != null) && (bTN().FRP == 1))
    {
      AppMethodBeat.o(112762);
      return true;
    }
    AppMethodBeat.o(112762);
    return false;
  }
  
  public final boolean bTu()
  {
    AppMethodBeat.i(112734);
    if ((bTN() != null) && (bTN().mrl == 10))
    {
      AppMethodBeat.o(112734);
      return true;
    }
    AppMethodBeat.o(112734);
    return false;
  }
  
  public final boolean bTv()
  {
    AppMethodBeat.i(112735);
    if ((bTN() != null) && (bTN().mrl == 0))
    {
      AppMethodBeat.o(112735);
      return true;
    }
    AppMethodBeat.o(112735);
    return false;
  }
  
  public final boolean bTw()
  {
    AppMethodBeat.i(112736);
    if ((bTN() != null) && (bTN().mrl == 20))
    {
      AppMethodBeat.o(112736);
      return true;
    }
    AppMethodBeat.o(112736);
    return false;
  }
  
  public final boolean bTx()
  {
    AppMethodBeat.i(112737);
    if ((bTN() != null) && (bTN().mrl == 11))
    {
      AppMethodBeat.o(112737);
      return true;
    }
    AppMethodBeat.o(112737);
    return false;
  }
  
  public final boolean bTy()
  {
    AppMethodBeat.i(112738);
    if ((bTN() != null) && (bTN().mrl == 30))
    {
      AppMethodBeat.o(112738);
      return true;
    }
    AppMethodBeat.o(112738);
    return false;
  }
  
  public final boolean bTz()
  {
    AppMethodBeat.i(112739);
    boolean bool = l.Ap(bTN().mrl);
    AppMethodBeat.o(112739);
    return bool;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public c.a getDBInfo()
  {
    return info;
  }
  
  public final long getEndTime()
  {
    return this.field_end_time;
  }
  
  public final boolean isAcceptable()
  {
    AppMethodBeat.i(112748);
    if (!bTJ())
    {
      AppMethodBeat.o(112748);
      return false;
    }
    if (this.oyX != null) {
      ad.i("MicroMsg.CardInfo", "is_acceptable:" + this.oyX.FRV);
    }
    ad.i("MicroMsg.CardInfo", "stock_num:" + this.oyY.FPr + " limit_num:" + this.oyY.FPs);
    if ((this.oyX != null) && (this.oyX.FRV == 1))
    {
      AppMethodBeat.o(112748);
      return true;
    }
    if ((this.oyX != null) && (this.oyX.FRV == 0))
    {
      AppMethodBeat.o(112748);
      return false;
    }
    if ((this.oyY.FPr == 0L) || (this.oyY.FPs == 0))
    {
      AppMethodBeat.o(112748);
      return false;
    }
    AppMethodBeat.o(112748);
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.CardInfo
 * JD-Core Version:    0.7.0.1
 */
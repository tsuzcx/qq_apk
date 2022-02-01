package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fx;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.csx;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.protocal.protobuf.rd;
import com.tencent.mm.protocal.protobuf.rh;
import com.tencent.mm.protocal.protobuf.ro;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ad;
import java.lang.reflect.Field;
import java.util.Map;

public class CardInfo
  extends fx
  implements Parcelable, b
{
  public static final Parcelable.Creator<CardInfo> CREATOR;
  protected static c.a info;
  public String nru;
  public ro nsC;
  public qo nsD;
  public csx nsE;
  public rh nsF;
  public boolean nsG;
  
  static
  {
    AppMethodBeat.i(112765);
    c.a locala = new c.a();
    locala.EYt = new Field[22];
    locala.columns = new String[23];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "card_id";
    locala.EYv.put("card_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" card_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.EYu = "card_id";
    locala.columns[1] = "card_tp_id";
    locala.EYv.put("card_tp_id", "TEXT");
    localStringBuilder.append(" card_tp_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "from_username";
    locala.EYv.put("from_username", "TEXT");
    localStringBuilder.append(" from_username TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "status";
    locala.EYv.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "delete_state_flag";
    locala.EYv.put("delete_state_flag", "INTEGER");
    localStringBuilder.append(" delete_state_flag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "local_updateTime";
    locala.EYv.put("local_updateTime", "LONG");
    localStringBuilder.append(" local_updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "updateTime";
    locala.EYv.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "updateSeq";
    locala.EYv.put("updateSeq", "LONG");
    localStringBuilder.append(" updateSeq LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "create_time";
    locala.EYv.put("create_time", "LONG");
    localStringBuilder.append(" create_time LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "begin_time";
    locala.EYv.put("begin_time", "LONG");
    localStringBuilder.append(" begin_time LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "end_time";
    locala.EYv.put("end_time", "LONG");
    localStringBuilder.append(" end_time LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "block_mask";
    locala.EYv.put("block_mask", "TEXT");
    localStringBuilder.append(" block_mask TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "dataInfoData";
    locala.EYv.put("dataInfoData", "BLOB");
    localStringBuilder.append(" dataInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "cardTpInfoData";
    locala.EYv.put("cardTpInfoData", "BLOB");
    localStringBuilder.append(" cardTpInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "shareInfoData";
    locala.EYv.put("shareInfoData", "BLOB");
    localStringBuilder.append(" shareInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "shopInfoData";
    locala.EYv.put("shopInfoData", "BLOB");
    localStringBuilder.append(" shopInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[16] = "stickyIndex";
    locala.EYv.put("stickyIndex", "INTEGER");
    localStringBuilder.append(" stickyIndex INTEGER");
    localStringBuilder.append(", ");
    locala.columns[17] = "stickyEndTime";
    locala.EYv.put("stickyEndTime", "INTEGER");
    localStringBuilder.append(" stickyEndTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[18] = "stickyAnnouncement";
    locala.EYv.put("stickyAnnouncement", "TEXT");
    localStringBuilder.append(" stickyAnnouncement TEXT");
    localStringBuilder.append(", ");
    locala.columns[19] = "card_type";
    locala.EYv.put("card_type", "INTEGER default '-1' ");
    localStringBuilder.append(" card_type INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "label_wording";
    locala.EYv.put("label_wording", "TEXT");
    localStringBuilder.append(" label_wording TEXT");
    localStringBuilder.append(", ");
    locala.columns[21] = "is_dynamic";
    locala.EYv.put("is_dynamic", "INTEGER");
    localStringBuilder.append(" is_dynamic INTEGER");
    locala.columns[22] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(112765);
  }
  
  public CardInfo()
  {
    this.nsG = true;
    this.nru = "";
    this.field_card_type = -1;
  }
  
  public CardInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(112759);
    this.nsG = true;
    this.nru = "";
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
  
  public final void Qh(String paramString)
  {
    this.field_from_username = paramString;
  }
  
  public final void a(csx paramcsx)
  {
    AppMethodBeat.i(112756);
    this.nsE = paramcsx;
    if (paramcsx != null) {}
    try
    {
      this.field_shareInfoData = paramcsx.toByteArray();
      AppMethodBeat.o(112756);
      return;
    }
    catch (Exception paramcsx)
    {
      ad.e("MicroMsg.CardInfo", "setShareInfo fail, ex = %s", new Object[] { paramcsx.getMessage() });
      ad.printErrStackTrace("MicroMsg.CardInfo", paramcsx, "", new Object[0]);
      AppMethodBeat.o(112756);
    }
  }
  
  public final void a(qo paramqo)
  {
    AppMethodBeat.i(112754);
    this.nsD = paramqo;
    if (this.nsD != null)
    {
      this.field_status = this.nsD.status;
      if (paramqo != null) {}
      try
      {
        this.field_dataInfoData = paramqo.toByteArray();
        AppMethodBeat.o(112754);
        return;
      }
      catch (Exception paramqo)
      {
        ad.e("MicroMsg.CardInfo", "setDataInfo fail, ex = %s", new Object[] { paramqo.getMessage() });
        ad.printErrStackTrace("MicroMsg.CardInfo", paramqo, "", new Object[0]);
      }
    }
    AppMethodBeat.o(112754);
  }
  
  public final void a(rh paramrh)
  {
    AppMethodBeat.i(112758);
    this.nsF = paramrh;
    if (paramrh != null) {}
    try
    {
      this.field_shopInfoData = paramrh.toByteArray();
      AppMethodBeat.o(112758);
      return;
    }
    catch (Exception paramrh)
    {
      ad.e("MicroMsg.CardInfo", "setShopInfo fail, ex = %s", new Object[] { paramrh.getMessage() });
      ad.printErrStackTrace("MicroMsg.CardInfo", paramrh, "", new Object[0]);
      AppMethodBeat.o(112758);
    }
  }
  
  public final void a(ro paramro)
  {
    AppMethodBeat.i(112752);
    this.nsC = paramro;
    if (paramro != null) {}
    try
    {
      this.field_cardTpInfoData = paramro.toByteArray();
      AppMethodBeat.o(112752);
      return;
    }
    catch (Exception paramro)
    {
      ad.e("MicroMsg.CardInfo", "setCardTpInfo fail, ex = %s", new Object[] { paramro.getMessage() });
      AppMethodBeat.o(112752);
    }
  }
  
  public final boolean bHA()
  {
    AppMethodBeat.i(112761);
    if ((bHV() != null) && (bHV().CRV == 0))
    {
      AppMethodBeat.o(112761);
      return true;
    }
    AppMethodBeat.o(112761);
    return false;
  }
  
  public final boolean bHB()
  {
    AppMethodBeat.i(112762);
    if ((bHV() != null) && (bHV().CRV == 1))
    {
      AppMethodBeat.o(112762);
      return true;
    }
    AppMethodBeat.o(112762);
    return false;
  }
  
  public final boolean bHC()
  {
    AppMethodBeat.i(112734);
    if ((bHV() != null) && (bHV().lpz == 10))
    {
      AppMethodBeat.o(112734);
      return true;
    }
    AppMethodBeat.o(112734);
    return false;
  }
  
  public final boolean bHD()
  {
    AppMethodBeat.i(112735);
    if ((bHV() != null) && (bHV().lpz == 0))
    {
      AppMethodBeat.o(112735);
      return true;
    }
    AppMethodBeat.o(112735);
    return false;
  }
  
  public final boolean bHE()
  {
    AppMethodBeat.i(112736);
    if ((bHV() != null) && (bHV().lpz == 20))
    {
      AppMethodBeat.o(112736);
      return true;
    }
    AppMethodBeat.o(112736);
    return false;
  }
  
  public final boolean bHF()
  {
    AppMethodBeat.i(112737);
    if ((bHV() != null) && (bHV().lpz == 11))
    {
      AppMethodBeat.o(112737);
      return true;
    }
    AppMethodBeat.o(112737);
    return false;
  }
  
  public final boolean bHG()
  {
    AppMethodBeat.i(112738);
    if ((bHV() != null) && (bHV().lpz == 30))
    {
      AppMethodBeat.o(112738);
      return true;
    }
    AppMethodBeat.o(112738);
    return false;
  }
  
  public final boolean bHH()
  {
    AppMethodBeat.i(112739);
    boolean bool = l.yQ(bHV().lpz);
    AppMethodBeat.o(112739);
    return bool;
  }
  
  public final boolean bHI()
  {
    AppMethodBeat.i(112740);
    if ((bHV().CRL & 0x2) == 0)
    {
      AppMethodBeat.o(112740);
      return true;
    }
    AppMethodBeat.o(112740);
    return false;
  }
  
  public final boolean bHJ()
  {
    AppMethodBeat.i(112741);
    if ((bHV().CRL & 0x1) == 0)
    {
      AppMethodBeat.o(112741);
      return true;
    }
    AppMethodBeat.o(112741);
    return false;
  }
  
  public final boolean bHK()
  {
    AppMethodBeat.i(112742);
    if ((bHV().CRO & 1L) == 0L)
    {
      AppMethodBeat.o(112742);
      return true;
    }
    AppMethodBeat.o(112742);
    return false;
  }
  
  public final boolean bHL()
  {
    AppMethodBeat.i(112743);
    if ((bHV().CRO & 0x10) == 0L)
    {
      AppMethodBeat.o(112743);
      return true;
    }
    AppMethodBeat.o(112743);
    return false;
  }
  
  public final boolean bHM()
  {
    AppMethodBeat.i(112744);
    if ((bHV().CRO & 0x2) > 0L)
    {
      AppMethodBeat.o(112744);
      return true;
    }
    AppMethodBeat.o(112744);
    return false;
  }
  
  public final boolean bHN()
  {
    AppMethodBeat.i(112745);
    if ((bHV().CRO & 0x20) > 0L)
    {
      AppMethodBeat.o(112745);
      return true;
    }
    AppMethodBeat.o(112745);
    return false;
  }
  
  public final boolean bHO()
  {
    AppMethodBeat.i(112746);
    if ((bHV().CRO & 0x4) > 0L)
    {
      AppMethodBeat.o(112746);
      return true;
    }
    AppMethodBeat.o(112746);
    return false;
  }
  
  public final boolean bHP()
  {
    AppMethodBeat.i(112747);
    if ((bHV().CRO & 0x8) > 0L)
    {
      AppMethodBeat.o(112747);
      return true;
    }
    AppMethodBeat.o(112747);
    return false;
  }
  
  public final boolean bHQ()
  {
    AppMethodBeat.i(112764);
    if ((bHV() != null) && (bHV().CSa == 1))
    {
      AppMethodBeat.o(112764);
      return true;
    }
    AppMethodBeat.o(112764);
    return false;
  }
  
  public final boolean bHR()
  {
    return (this.nsD != null) && (this.nsD.status == 0);
  }
  
  public final boolean bHS()
  {
    AppMethodBeat.i(112749);
    if (!bHR())
    {
      AppMethodBeat.o(112749);
      return false;
    }
    if (this.nsC != null) {
      ad.i("MicroMsg.CardInfo", "is_acceptable:" + this.nsC.CSb);
    }
    ad.i("MicroMsg.CardInfo", "avail_num:" + this.nsD.CPt);
    if ((this.nsC != null) && (this.nsC.CSb == 1))
    {
      AppMethodBeat.o(112749);
      return true;
    }
    if (this.nsD.CPt > 0)
    {
      AppMethodBeat.o(112749);
      return true;
    }
    if ((this.nsC != null) && (this.nsC.CSb == 0))
    {
      AppMethodBeat.o(112749);
      return false;
    }
    if (this.nsD.CPt == 0)
    {
      AppMethodBeat.o(112749);
      return false;
    }
    AppMethodBeat.o(112749);
    return false;
  }
  
  public final boolean bHT()
  {
    AppMethodBeat.i(112750);
    if ((this.nsC == null) || (this.nsC.CRS == null) || (TextUtils.isEmpty(this.nsC.CRS.text)))
    {
      AppMethodBeat.o(112750);
      return false;
    }
    rd localrd = this.nsC.CRS;
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = localrd.wmA;
    if ((localrd.wmA > 0) && (j - i > 0))
    {
      AppMethodBeat.o(112750);
      return true;
    }
    AppMethodBeat.o(112750);
    return false;
  }
  
  public final boolean bHU()
  {
    return (this.nsC != null) && (this.nsC.CSf == 1);
  }
  
  public final ro bHV()
  {
    AppMethodBeat.i(112751);
    ro localro1;
    if (this.nsC != null)
    {
      localro1 = this.nsC;
      AppMethodBeat.o(112751);
      return localro1;
    }
    try
    {
      if (this.field_cardTpInfoData != null)
      {
        this.nsC = ((ro)new ro().parseFrom(this.field_cardTpInfoData));
        localro1 = this.nsC;
        AppMethodBeat.o(112751);
        return localro1;
      }
      localro1 = new ro();
      AppMethodBeat.o(112751);
      return localro1;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.CardInfo", "getCardTpInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ad.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      ro localro2 = new ro();
      AppMethodBeat.o(112751);
      return localro2;
    }
  }
  
  public final qo bHW()
  {
    AppMethodBeat.i(112753);
    qo localqo1;
    if (this.nsD != null)
    {
      localqo1 = this.nsD;
      AppMethodBeat.o(112753);
      return localqo1;
    }
    try
    {
      if (this.field_dataInfoData != null)
      {
        this.nsD = ((qo)new qo().parseFrom(this.field_dataInfoData));
        localqo1 = this.nsD;
        AppMethodBeat.o(112753);
        return localqo1;
      }
      localqo1 = new qo();
      AppMethodBeat.o(112753);
      return localqo1;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.CardInfo", "getDataInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ad.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      qo localqo2 = new qo();
      AppMethodBeat.o(112753);
      return localqo2;
    }
  }
  
  public final csx bHX()
  {
    AppMethodBeat.i(112755);
    csx localcsx1;
    if (this.nsE != null)
    {
      localcsx1 = this.nsE;
      AppMethodBeat.o(112755);
      return localcsx1;
    }
    try
    {
      if (this.field_shareInfoData != null)
      {
        this.nsE = ((csx)new csx().parseFrom(this.field_shareInfoData));
        localcsx1 = this.nsE;
        AppMethodBeat.o(112755);
        return localcsx1;
      }
      localcsx1 = new csx();
      AppMethodBeat.o(112755);
      return localcsx1;
    }
    catch (Exception localException)
    {
      ad.e("MicroMsg.CardInfo", "getShareInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ad.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      csx localcsx2 = new csx();
      AppMethodBeat.o(112755);
      return localcsx2;
    }
  }
  
  public final rh bHY()
  {
    AppMethodBeat.i(112757);
    rh localrh;
    if (this.nsF != null)
    {
      localrh = this.nsF;
      AppMethodBeat.o(112757);
      return localrh;
    }
    try
    {
      if (this.field_shopInfoData != null)
      {
        this.nsF = ((rh)new rh().parseFrom(this.field_shopInfoData));
        localrh = this.nsF;
        AppMethodBeat.o(112757);
        return localrh;
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
  
  public final String bHZ()
  {
    return this.field_card_id;
  }
  
  public final String bIa()
  {
    return this.field_card_tp_id;
  }
  
  public final String bIb()
  {
    return this.field_from_username;
  }
  
  public final long bIc()
  {
    return this.field_local_updateTime;
  }
  
  public final String bId()
  {
    return null;
  }
  
  public final int bIe()
  {
    return 0;
  }
  
  public final String bIf()
  {
    AppMethodBeat.i(112763);
    ad.d("MicroMsg.CardInfo", "encrypt_code:" + this.nru);
    String str = this.nru;
    AppMethodBeat.o(112763);
    return str;
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
    if (!bHR())
    {
      AppMethodBeat.o(112748);
      return false;
    }
    if (this.nsC != null) {
      ad.i("MicroMsg.CardInfo", "is_acceptable:" + this.nsC.CSb);
    }
    ad.i("MicroMsg.CardInfo", "stock_num:" + this.nsD.CPw + " limit_num:" + this.nsD.CPx);
    if ((this.nsC != null) && (this.nsC.CSb == 1))
    {
      AppMethodBeat.o(112748);
      return true;
    }
    if ((this.nsC != null) && (this.nsC.CSb == 0))
    {
      AppMethodBeat.o(112748);
      return false;
    }
    if ((this.nsD.CPw == 0L) || (this.nsD.CPx == 0))
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
  
  public final String yO(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.CardInfo
 * JD-Core Version:    0.7.0.1
 */
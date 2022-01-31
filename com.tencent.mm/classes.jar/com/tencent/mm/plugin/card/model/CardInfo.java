package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.fb;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.protocal.protobuf.ccf;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.protocal.protobuf.oz;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import java.lang.reflect.Field;
import java.util.Map;

public class CardInfo
  extends fb
  implements Parcelable, b
{
  public static final Parcelable.Creator<CardInfo> CREATOR;
  protected static c.a info;
  public String kmp;
  public pg kno;
  public oj knp;
  public ccf knq;
  public oz knr;
  public boolean kns;
  
  static
  {
    AppMethodBeat.i(87823);
    c.a locala = new c.a();
    locala.yrK = new Field[22];
    locala.columns = new String[23];
    StringBuilder localStringBuilder = new StringBuilder();
    locala.columns[0] = "card_id";
    locala.yrM.put("card_id", "TEXT PRIMARY KEY ");
    localStringBuilder.append(" card_id TEXT PRIMARY KEY ");
    localStringBuilder.append(", ");
    locala.yrL = "card_id";
    locala.columns[1] = "card_tp_id";
    locala.yrM.put("card_tp_id", "TEXT");
    localStringBuilder.append(" card_tp_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[2] = "from_username";
    locala.yrM.put("from_username", "TEXT");
    localStringBuilder.append(" from_username TEXT");
    localStringBuilder.append(", ");
    locala.columns[3] = "status";
    locala.yrM.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[4] = "delete_state_flag";
    locala.yrM.put("delete_state_flag", "INTEGER");
    localStringBuilder.append(" delete_state_flag INTEGER");
    localStringBuilder.append(", ");
    locala.columns[5] = "local_updateTime";
    locala.yrM.put("local_updateTime", "LONG");
    localStringBuilder.append(" local_updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[6] = "updateTime";
    locala.yrM.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "updateSeq";
    locala.yrM.put("updateSeq", "LONG");
    localStringBuilder.append(" updateSeq LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "create_time";
    locala.yrM.put("create_time", "LONG");
    localStringBuilder.append(" create_time LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "begin_time";
    locala.yrM.put("begin_time", "LONG");
    localStringBuilder.append(" begin_time LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "end_time";
    locala.yrM.put("end_time", "LONG");
    localStringBuilder.append(" end_time LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "block_mask";
    locala.yrM.put("block_mask", "TEXT");
    localStringBuilder.append(" block_mask TEXT");
    localStringBuilder.append(", ");
    locala.columns[12] = "dataInfoData";
    locala.yrM.put("dataInfoData", "BLOB");
    localStringBuilder.append(" dataInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[13] = "cardTpInfoData";
    locala.yrM.put("cardTpInfoData", "BLOB");
    localStringBuilder.append(" cardTpInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "shareInfoData";
    locala.yrM.put("shareInfoData", "BLOB");
    localStringBuilder.append(" shareInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "shopInfoData";
    locala.yrM.put("shopInfoData", "BLOB");
    localStringBuilder.append(" shopInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[16] = "stickyIndex";
    locala.yrM.put("stickyIndex", "INTEGER");
    localStringBuilder.append(" stickyIndex INTEGER");
    localStringBuilder.append(", ");
    locala.columns[17] = "stickyEndTime";
    locala.yrM.put("stickyEndTime", "INTEGER");
    localStringBuilder.append(" stickyEndTime INTEGER");
    localStringBuilder.append(", ");
    locala.columns[18] = "stickyAnnouncement";
    locala.yrM.put("stickyAnnouncement", "TEXT");
    localStringBuilder.append(" stickyAnnouncement TEXT");
    localStringBuilder.append(", ");
    locala.columns[19] = "card_type";
    locala.yrM.put("card_type", "INTEGER default '-1' ");
    localStringBuilder.append(" card_type INTEGER default '-1' ");
    localStringBuilder.append(", ");
    locala.columns[20] = "label_wording";
    locala.yrM.put("label_wording", "TEXT");
    localStringBuilder.append(" label_wording TEXT");
    localStringBuilder.append(", ");
    locala.columns[21] = "is_dynamic";
    locala.yrM.put("is_dynamic", "INTEGER");
    localStringBuilder.append(" is_dynamic INTEGER");
    locala.columns[22] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    CREATOR = new CardInfo.1();
    AppMethodBeat.o(87823);
  }
  
  public CardInfo()
  {
    this.kns = true;
    this.kmp = "";
    this.field_card_type = -1;
  }
  
  public CardInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(87817);
    this.kns = true;
    this.kmp = "";
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
    AppMethodBeat.o(87817);
  }
  
  public final void Hx(String paramString)
  {
    this.field_from_username = paramString;
  }
  
  public final void a(ccf paramccf)
  {
    AppMethodBeat.i(87814);
    this.knq = paramccf;
    if (paramccf != null) {}
    try
    {
      this.field_shareInfoData = paramccf.toByteArray();
      AppMethodBeat.o(87814);
      return;
    }
    catch (Exception paramccf)
    {
      ab.e("MicroMsg.CardInfo", "setShareInfo fail, ex = %s", new Object[] { paramccf.getMessage() });
      ab.printErrStackTrace("MicroMsg.CardInfo", paramccf, "", new Object[0]);
      AppMethodBeat.o(87814);
    }
  }
  
  public final void a(oj paramoj)
  {
    AppMethodBeat.i(87812);
    this.knp = paramoj;
    if (this.knp != null)
    {
      this.field_status = this.knp.status;
      if (paramoj != null) {}
      try
      {
        this.field_dataInfoData = paramoj.toByteArray();
        AppMethodBeat.o(87812);
        return;
      }
      catch (Exception paramoj)
      {
        ab.e("MicroMsg.CardInfo", "setDataInfo fail, ex = %s", new Object[] { paramoj.getMessage() });
        ab.printErrStackTrace("MicroMsg.CardInfo", paramoj, "", new Object[0]);
      }
    }
    AppMethodBeat.o(87812);
  }
  
  public final void a(oz paramoz)
  {
    AppMethodBeat.i(87816);
    this.knr = paramoz;
    if (paramoz != null) {}
    try
    {
      this.field_shopInfoData = paramoz.toByteArray();
      AppMethodBeat.o(87816);
      return;
    }
    catch (Exception paramoz)
    {
      ab.e("MicroMsg.CardInfo", "setShopInfo fail, ex = %s", new Object[] { paramoz.getMessage() });
      ab.printErrStackTrace("MicroMsg.CardInfo", paramoz, "", new Object[0]);
      AppMethodBeat.o(87816);
    }
  }
  
  public final void a(pg parampg)
  {
    AppMethodBeat.i(87810);
    this.kno = parampg;
    if (parampg != null) {}
    try
    {
      this.field_cardTpInfoData = parampg.toByteArray();
      AppMethodBeat.o(87810);
      return;
    }
    catch (Exception parampg)
    {
      ab.e("MicroMsg.CardInfo", "setCardTpInfo fail, ex = %s", new Object[] { parampg.getMessage() });
      AppMethodBeat.o(87810);
    }
  }
  
  public final boolean baJ()
  {
    AppMethodBeat.i(87819);
    if ((bbd() != null) && (bbd().wGq == 0))
    {
      AppMethodBeat.o(87819);
      return true;
    }
    AppMethodBeat.o(87819);
    return false;
  }
  
  public final boolean baK()
  {
    AppMethodBeat.i(87820);
    if ((bbd() != null) && (bbd().wGq == 1))
    {
      AppMethodBeat.o(87820);
      return true;
    }
    AppMethodBeat.o(87820);
    return false;
  }
  
  public final boolean baL()
  {
    AppMethodBeat.i(87792);
    if ((bbd() != null) && (bbd().iFL == 10))
    {
      AppMethodBeat.o(87792);
      return true;
    }
    AppMethodBeat.o(87792);
    return false;
  }
  
  public final boolean baM()
  {
    AppMethodBeat.i(87793);
    if ((bbd() != null) && (bbd().iFL == 0))
    {
      AppMethodBeat.o(87793);
      return true;
    }
    AppMethodBeat.o(87793);
    return false;
  }
  
  public final boolean baN()
  {
    AppMethodBeat.i(87794);
    if ((bbd() != null) && (bbd().iFL == 20))
    {
      AppMethodBeat.o(87794);
      return true;
    }
    AppMethodBeat.o(87794);
    return false;
  }
  
  public final boolean baO()
  {
    AppMethodBeat.i(87795);
    if ((bbd() != null) && (bbd().iFL == 11))
    {
      AppMethodBeat.o(87795);
      return true;
    }
    AppMethodBeat.o(87795);
    return false;
  }
  
  public final boolean baP()
  {
    AppMethodBeat.i(87796);
    if ((bbd() != null) && (bbd().iFL == 30))
    {
      AppMethodBeat.o(87796);
      return true;
    }
    AppMethodBeat.o(87796);
    return false;
  }
  
  public final boolean baQ()
  {
    AppMethodBeat.i(87797);
    boolean bool = l.sX(bbd().iFL);
    AppMethodBeat.o(87797);
    return bool;
  }
  
  public final boolean baR()
  {
    AppMethodBeat.i(87798);
    if ((bbd().wGg & 0x2) == 0)
    {
      AppMethodBeat.o(87798);
      return true;
    }
    AppMethodBeat.o(87798);
    return false;
  }
  
  public final boolean baS()
  {
    AppMethodBeat.i(87799);
    if ((bbd().wGg & 0x1) == 0)
    {
      AppMethodBeat.o(87799);
      return true;
    }
    AppMethodBeat.o(87799);
    return false;
  }
  
  public final boolean baT()
  {
    AppMethodBeat.i(87800);
    if ((bbd().wGj & 1L) == 0L)
    {
      AppMethodBeat.o(87800);
      return true;
    }
    AppMethodBeat.o(87800);
    return false;
  }
  
  public final boolean baU()
  {
    AppMethodBeat.i(87801);
    if ((bbd().wGj & 0x10) == 0L)
    {
      AppMethodBeat.o(87801);
      return true;
    }
    AppMethodBeat.o(87801);
    return false;
  }
  
  public final boolean baV()
  {
    AppMethodBeat.i(87802);
    if ((bbd().wGj & 0x2) > 0L)
    {
      AppMethodBeat.o(87802);
      return true;
    }
    AppMethodBeat.o(87802);
    return false;
  }
  
  public final boolean baW()
  {
    AppMethodBeat.i(87803);
    if ((bbd().wGj & 0x20) > 0L)
    {
      AppMethodBeat.o(87803);
      return true;
    }
    AppMethodBeat.o(87803);
    return false;
  }
  
  public final boolean baX()
  {
    AppMethodBeat.i(87804);
    if ((bbd().wGj & 0x4) > 0L)
    {
      AppMethodBeat.o(87804);
      return true;
    }
    AppMethodBeat.o(87804);
    return false;
  }
  
  public final boolean baY()
  {
    AppMethodBeat.i(87805);
    if ((bbd().wGj & 0x8) > 0L)
    {
      AppMethodBeat.o(87805);
      return true;
    }
    AppMethodBeat.o(87805);
    return false;
  }
  
  public final boolean baZ()
  {
    AppMethodBeat.i(87822);
    if ((bbd() != null) && (bbd().wGv == 1))
    {
      AppMethodBeat.o(87822);
      return true;
    }
    AppMethodBeat.o(87822);
    return false;
  }
  
  public final boolean bba()
  {
    AppMethodBeat.i(87807);
    if (!isNormal())
    {
      AppMethodBeat.o(87807);
      return false;
    }
    if (this.kno != null) {
      ab.i("MicroMsg.CardInfo", "is_acceptable:" + this.kno.wGw);
    }
    ab.i("MicroMsg.CardInfo", "avail_num:" + this.knp.wDS);
    if ((this.kno != null) && (this.kno.wGw == 1))
    {
      AppMethodBeat.o(87807);
      return true;
    }
    if (this.knp.wDS > 0)
    {
      AppMethodBeat.o(87807);
      return true;
    }
    if ((this.kno != null) && (this.kno.wGw == 0))
    {
      AppMethodBeat.o(87807);
      return false;
    }
    if (this.knp.wDS == 0)
    {
      AppMethodBeat.o(87807);
      return false;
    }
    AppMethodBeat.o(87807);
    return false;
  }
  
  public final boolean bbb()
  {
    AppMethodBeat.i(87808);
    if ((this.kno == null) || (this.kno.wGn == null) || (TextUtils.isEmpty(this.kno.wGn.text)))
    {
      AppMethodBeat.o(87808);
      return false;
    }
    ov localov = this.kno.wGn;
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = localov.qNK;
    if ((localov.qNK > 0) && (j - i > 0))
    {
      AppMethodBeat.o(87808);
      return true;
    }
    AppMethodBeat.o(87808);
    return false;
  }
  
  public final boolean bbc()
  {
    return (this.kno != null) && (this.kno.wGA == 1);
  }
  
  public final pg bbd()
  {
    AppMethodBeat.i(87809);
    pg localpg1;
    if (this.kno != null)
    {
      localpg1 = this.kno;
      AppMethodBeat.o(87809);
      return localpg1;
    }
    try
    {
      if (this.field_cardTpInfoData != null)
      {
        this.kno = ((pg)new pg().parseFrom(this.field_cardTpInfoData));
        localpg1 = this.kno;
        AppMethodBeat.o(87809);
        return localpg1;
      }
      localpg1 = new pg();
      AppMethodBeat.o(87809);
      return localpg1;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.CardInfo", "getCardTpInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ab.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      pg localpg2 = new pg();
      AppMethodBeat.o(87809);
      return localpg2;
    }
  }
  
  public final oj bbe()
  {
    AppMethodBeat.i(87811);
    oj localoj1;
    if (this.knp != null)
    {
      localoj1 = this.knp;
      AppMethodBeat.o(87811);
      return localoj1;
    }
    try
    {
      if (this.field_dataInfoData != null)
      {
        this.knp = ((oj)new oj().parseFrom(this.field_dataInfoData));
        localoj1 = this.knp;
        AppMethodBeat.o(87811);
        return localoj1;
      }
      localoj1 = new oj();
      AppMethodBeat.o(87811);
      return localoj1;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.CardInfo", "getDataInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ab.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      oj localoj2 = new oj();
      AppMethodBeat.o(87811);
      return localoj2;
    }
  }
  
  public final ccf bbf()
  {
    AppMethodBeat.i(87813);
    ccf localccf1;
    if (this.knq != null)
    {
      localccf1 = this.knq;
      AppMethodBeat.o(87813);
      return localccf1;
    }
    try
    {
      if (this.field_shareInfoData != null)
      {
        this.knq = ((ccf)new ccf().parseFrom(this.field_shareInfoData));
        localccf1 = this.knq;
        AppMethodBeat.o(87813);
        return localccf1;
      }
      localccf1 = new ccf();
      AppMethodBeat.o(87813);
      return localccf1;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.CardInfo", "getShareInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ab.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      ccf localccf2 = new ccf();
      AppMethodBeat.o(87813);
      return localccf2;
    }
  }
  
  public final oz bbg()
  {
    AppMethodBeat.i(87815);
    oz localoz;
    if (this.knr != null)
    {
      localoz = this.knr;
      AppMethodBeat.o(87815);
      return localoz;
    }
    try
    {
      if (this.field_shopInfoData != null)
      {
        this.knr = ((oz)new oz().parseFrom(this.field_shopInfoData));
        localoz = this.knr;
        AppMethodBeat.o(87815);
        return localoz;
      }
      AppMethodBeat.o(87815);
      return null;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.CardInfo", "getShopInfo fail ex = %s", new Object[] { localException.getMessage() });
      ab.printErrStackTrace("MicroMsg.CardInfo", localException, "", new Object[0]);
      AppMethodBeat.o(87815);
    }
    return null;
  }
  
  public final String bbh()
  {
    return this.field_card_id;
  }
  
  public final String bbi()
  {
    return this.field_card_tp_id;
  }
  
  public final String bbj()
  {
    return this.field_from_username;
  }
  
  public final long bbk()
  {
    return this.field_local_updateTime;
  }
  
  public final String bbl()
  {
    return null;
  }
  
  public final int bbm()
  {
    return 0;
  }
  
  public final String bbn()
  {
    AppMethodBeat.i(87821);
    ab.d("MicroMsg.CardInfo", "encrypt_code:" + this.kmp);
    String str = this.kmp;
    AppMethodBeat.o(87821);
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
    AppMethodBeat.i(87806);
    if (!isNormal())
    {
      AppMethodBeat.o(87806);
      return false;
    }
    if (this.kno != null) {
      ab.i("MicroMsg.CardInfo", "is_acceptable:" + this.kno.wGw);
    }
    ab.i("MicroMsg.CardInfo", "stock_num:" + this.knp.wDV + " limit_num:" + this.knp.wDW);
    if ((this.kno != null) && (this.kno.wGw == 1))
    {
      AppMethodBeat.o(87806);
      return true;
    }
    if ((this.kno != null) && (this.kno.wGw == 0))
    {
      AppMethodBeat.o(87806);
      return false;
    }
    if ((this.knp.wDV == 0L) || (this.knp.wDW == 0))
    {
      AppMethodBeat.o(87806);
      return false;
    }
    AppMethodBeat.o(87806);
    return false;
  }
  
  public final boolean isNormal()
  {
    return (this.knp != null) && (this.knp.status == 0);
  }
  
  public final String sV(int paramInt)
  {
    return null;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(87818);
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
      AppMethodBeat.o(87818);
      return;
    }
    paramParcel.writeInt(0);
    AppMethodBeat.o(87818);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.card.model.CardInfo
 * JD-Core Version:    0.7.0.1
 */
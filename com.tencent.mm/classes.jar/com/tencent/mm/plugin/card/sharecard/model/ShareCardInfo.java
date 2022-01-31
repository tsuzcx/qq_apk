package com.tencent.mm.plugin.card.sharecard.model;

import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ej;
import com.tencent.mm.plugin.card.b.e;
import com.tencent.mm.plugin.card.d.l;
import com.tencent.mm.plugin.card.model.am;
import com.tencent.mm.protocal.protobuf.ccf;
import com.tencent.mm.protocal.protobuf.oj;
import com.tencent.mm.protocal.protobuf.ov;
import com.tencent.mm.protocal.protobuf.oz;
import com.tencent.mm.protocal.protobuf.pg;
import com.tencent.mm.sdk.e.c.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import java.lang.reflect.Field;
import java.util.Map;

public class ShareCardInfo
  extends ej
  implements Parcelable, com.tencent.mm.plugin.card.base.b
{
  public static final Parcelable.Creator<ShareCardInfo> CREATOR;
  protected static c.a info;
  public String kmp;
  public pg kno;
  public oj knp;
  public ccf knq;
  public oz knr;
  public boolean kns;
  
  static
  {
    AppMethodBeat.i(88072);
    c.a locala = new c.a();
    locala.yrK = new Field[19];
    locala.columns = new String[20];
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
    locala.columns[3] = "consumer";
    locala.yrM.put("consumer", "TEXT");
    localStringBuilder.append(" consumer TEXT");
    localStringBuilder.append(", ");
    locala.columns[4] = "app_id";
    locala.yrM.put("app_id", "TEXT");
    localStringBuilder.append(" app_id TEXT");
    localStringBuilder.append(", ");
    locala.columns[5] = "status";
    locala.yrM.put("status", "INTEGER");
    localStringBuilder.append(" status INTEGER");
    localStringBuilder.append(", ");
    locala.columns[6] = "share_time";
    locala.yrM.put("share_time", "LONG");
    localStringBuilder.append(" share_time LONG");
    localStringBuilder.append(", ");
    locala.columns[7] = "local_updateTime";
    locala.yrM.put("local_updateTime", "LONG");
    localStringBuilder.append(" local_updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[8] = "updateTime";
    locala.yrM.put("updateTime", "LONG");
    localStringBuilder.append(" updateTime LONG");
    localStringBuilder.append(", ");
    locala.columns[9] = "begin_time";
    locala.yrM.put("begin_time", "LONG");
    localStringBuilder.append(" begin_time LONG");
    localStringBuilder.append(", ");
    locala.columns[10] = "end_time";
    locala.yrM.put("end_time", "LONG");
    localStringBuilder.append(" end_time LONG");
    localStringBuilder.append(", ");
    locala.columns[11] = "updateSeq";
    locala.yrM.put("updateSeq", "LONG");
    localStringBuilder.append(" updateSeq LONG");
    localStringBuilder.append(", ");
    locala.columns[12] = "block_mask";
    locala.yrM.put("block_mask", "LONG");
    localStringBuilder.append(" block_mask LONG");
    localStringBuilder.append(", ");
    locala.columns[13] = "dataInfoData";
    locala.yrM.put("dataInfoData", "BLOB");
    localStringBuilder.append(" dataInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[14] = "cardTpInfoData";
    locala.yrM.put("cardTpInfoData", "BLOB");
    localStringBuilder.append(" cardTpInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[15] = "shareInfoData";
    locala.yrM.put("shareInfoData", "BLOB");
    localStringBuilder.append(" shareInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[16] = "shopInfoData";
    locala.yrM.put("shopInfoData", "BLOB");
    localStringBuilder.append(" shopInfoData BLOB");
    localStringBuilder.append(", ");
    locala.columns[17] = "categoryType";
    locala.yrM.put("categoryType", "INTEGER default '0' ");
    localStringBuilder.append(" categoryType INTEGER default '0' ");
    localStringBuilder.append(", ");
    locala.columns[18] = "itemIndex";
    locala.yrM.put("itemIndex", "INTEGER default '0' ");
    localStringBuilder.append(" itemIndex INTEGER default '0' ");
    locala.columns[19] = "rowid";
    locala.sql = localStringBuilder.toString();
    info = locala;
    CREATOR = new Parcelable.Creator() {};
    AppMethodBeat.o(88072);
  }
  
  public ShareCardInfo()
  {
    this.kns = true;
    this.kmp = "";
  }
  
  public ShareCardInfo(Parcel paramParcel)
  {
    AppMethodBeat.i(88065);
    this.kns = true;
    this.kmp = "";
    this.field_card_id = paramParcel.readString();
    this.field_card_tp_id = paramParcel.readString();
    this.field_from_username = paramParcel.readString();
    this.field_status = paramParcel.readInt();
    this.field_share_time = paramParcel.readLong();
    this.field_local_updateTime = paramParcel.readLong();
    this.field_updateTime = paramParcel.readLong();
    this.field_updateSeq = paramParcel.readLong();
    this.field_block_mask = paramParcel.readLong();
    this.field_end_time = paramParcel.readLong();
    this.field_categoryType = paramParcel.readInt();
    this.field_itemIndex = paramParcel.readInt();
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
    AppMethodBeat.o(88065);
  }
  
  public final void Hx(String paramString)
  {
    this.field_from_username = paramString;
  }
  
  public final void a(ccf paramccf)
  {
    AppMethodBeat.i(88062);
    this.knq = paramccf;
    try
    {
      this.field_shareInfoData = paramccf.toByteArray();
      AppMethodBeat.o(88062);
      return;
    }
    catch (Exception paramccf)
    {
      ab.e("MicroMsg.ShareCardInfo", "setShareInfo fail, ex = %s", new Object[] { paramccf.getMessage() });
      ab.printErrStackTrace("MicroMsg.ShareCardInfo", paramccf, "", new Object[0]);
      AppMethodBeat.o(88062);
    }
  }
  
  public final void a(oj paramoj)
  {
    AppMethodBeat.i(88060);
    this.knp = paramoj;
    if (this.knp != null) {
      try
      {
        this.field_dataInfoData = paramoj.toByteArray();
        AppMethodBeat.o(88060);
        return;
      }
      catch (Exception paramoj)
      {
        ab.e("MicroMsg.ShareCardInfo", "setDataInfo fail, ex = %s", new Object[] { paramoj.getMessage() });
        ab.printErrStackTrace("MicroMsg.ShareCardInfo", paramoj, "", new Object[0]);
      }
    }
    AppMethodBeat.o(88060);
  }
  
  public final void a(oz paramoz)
  {
    AppMethodBeat.i(88064);
    this.knr = paramoz;
    try
    {
      this.field_shopInfoData = paramoz.toByteArray();
      AppMethodBeat.o(88064);
      return;
    }
    catch (Exception paramoz)
    {
      ab.e("MicroMsg.ShareCardInfo", "setShopInfo fail, ex = %s", new Object[] { paramoz.getMessage() });
      ab.printErrStackTrace("MicroMsg.ShareCardInfo", paramoz, "", new Object[0]);
      AppMethodBeat.o(88064);
    }
  }
  
  public final void a(pg parampg)
  {
    AppMethodBeat.i(88058);
    this.kno = parampg;
    try
    {
      this.field_cardTpInfoData = parampg.toByteArray();
      AppMethodBeat.o(88058);
      return;
    }
    catch (Exception parampg)
    {
      ab.e("MicroMsg.ShareCardInfo", "setCardTpInfo fail, ex = %s", new Object[] { parampg.getMessage() });
      AppMethodBeat.o(88058);
    }
  }
  
  public final boolean baJ()
  {
    AppMethodBeat.i(88067);
    if ((bbd() != null) && (bbd().wGq == 0))
    {
      AppMethodBeat.o(88067);
      return true;
    }
    AppMethodBeat.o(88067);
    return false;
  }
  
  public final boolean baK()
  {
    AppMethodBeat.i(88068);
    if ((bbd() != null) && (bbd().wGq == 1))
    {
      AppMethodBeat.o(88068);
      return true;
    }
    AppMethodBeat.o(88068);
    return false;
  }
  
  public final boolean baL()
  {
    AppMethodBeat.i(88041);
    if ((bbd() != null) && (bbd().iFL == 10))
    {
      AppMethodBeat.o(88041);
      return true;
    }
    AppMethodBeat.o(88041);
    return false;
  }
  
  public final boolean baM()
  {
    AppMethodBeat.i(88042);
    if ((bbd() != null) && (bbd().iFL == 0))
    {
      AppMethodBeat.o(88042);
      return true;
    }
    AppMethodBeat.o(88042);
    return false;
  }
  
  public final boolean baN()
  {
    AppMethodBeat.i(88043);
    if ((bbd() != null) && (bbd().iFL == 20))
    {
      AppMethodBeat.o(88043);
      return true;
    }
    AppMethodBeat.o(88043);
    return false;
  }
  
  public final boolean baO()
  {
    AppMethodBeat.i(88044);
    if ((bbd() != null) && (bbd().iFL == 11))
    {
      AppMethodBeat.o(88044);
      return true;
    }
    AppMethodBeat.o(88044);
    return false;
  }
  
  public final boolean baP()
  {
    AppMethodBeat.i(88045);
    if ((bbd() != null) && (bbd().iFL == 30))
    {
      AppMethodBeat.o(88045);
      return true;
    }
    AppMethodBeat.o(88045);
    return false;
  }
  
  public final boolean baQ()
  {
    AppMethodBeat.i(88046);
    boolean bool = l.sX(bbd().iFL);
    AppMethodBeat.o(88046);
    return bool;
  }
  
  public final boolean baR()
  {
    AppMethodBeat.i(88047);
    if ((bbd().wGg & 0x2) == 0)
    {
      AppMethodBeat.o(88047);
      return true;
    }
    AppMethodBeat.o(88047);
    return false;
  }
  
  public final boolean baS()
  {
    AppMethodBeat.i(88048);
    if ((bbd().wGg & 0x1) == 0)
    {
      AppMethodBeat.o(88048);
      return true;
    }
    AppMethodBeat.o(88048);
    return false;
  }
  
  public final boolean baT()
  {
    AppMethodBeat.i(88049);
    if ((bbd().wGj & 1L) == 0L)
    {
      AppMethodBeat.o(88049);
      return true;
    }
    AppMethodBeat.o(88049);
    return false;
  }
  
  public final boolean baU()
  {
    AppMethodBeat.i(88050);
    if ((bbd().wGj & 0x10) == 0L)
    {
      AppMethodBeat.o(88050);
      return true;
    }
    AppMethodBeat.o(88050);
    return false;
  }
  
  public final boolean baV()
  {
    AppMethodBeat.i(88051);
    if ((bbd().wGj & 0x2) > 0L)
    {
      AppMethodBeat.o(88051);
      return true;
    }
    AppMethodBeat.o(88051);
    return false;
  }
  
  public final boolean baW()
  {
    return false;
  }
  
  public final boolean baX()
  {
    AppMethodBeat.i(88052);
    if ((bbd().wGj & 0x4) > 0L)
    {
      AppMethodBeat.o(88052);
      return true;
    }
    AppMethodBeat.o(88052);
    return false;
  }
  
  public final boolean baY()
  {
    AppMethodBeat.i(88053);
    if ((bbd().wGj & 0x8) > 0L)
    {
      AppMethodBeat.o(88053);
      return true;
    }
    AppMethodBeat.o(88053);
    return false;
  }
  
  public final boolean baZ()
  {
    AppMethodBeat.i(88071);
    if ((bbd() != null) && (bbd().wGv == 1))
    {
      AppMethodBeat.o(88071);
      return true;
    }
    AppMethodBeat.o(88071);
    return false;
  }
  
  public final boolean bba()
  {
    AppMethodBeat.i(88055);
    if (!isNormal())
    {
      AppMethodBeat.o(88055);
      return false;
    }
    if (this.kno != null) {
      ab.i("MicroMsg.ShareCardInfo", "is_acceptable:" + this.kno.wGw);
    }
    ab.i("MicroMsg.ShareCardInfo", "avail_num:" + this.knp.wDS);
    if ((this.kno != null) && (this.kno.wGw == 1))
    {
      AppMethodBeat.o(88055);
      return true;
    }
    if (this.knp.wDS > 0)
    {
      AppMethodBeat.o(88055);
      return true;
    }
    if ((this.kno != null) && (this.kno.wGw == 0))
    {
      AppMethodBeat.o(88055);
      return false;
    }
    if (this.knp.wDS == 0)
    {
      AppMethodBeat.o(88055);
      return false;
    }
    AppMethodBeat.o(88055);
    return false;
  }
  
  public final boolean bbb()
  {
    AppMethodBeat.i(88056);
    if ((this.kno == null) || (this.kno.wGn == null) || (TextUtils.isEmpty(this.kno.wGn.text)))
    {
      AppMethodBeat.o(88056);
      return false;
    }
    ov localov = this.kno.wGn;
    int i = (int)(System.currentTimeMillis() / 1000L);
    int j = localov.qNK;
    if ((localov.qNK > 0) && (j - i > 0))
    {
      AppMethodBeat.o(88056);
      return true;
    }
    AppMethodBeat.o(88056);
    return false;
  }
  
  public final boolean bbc()
  {
    return (this.kno != null) && (this.kno.wGA == 1);
  }
  
  public final pg bbd()
  {
    AppMethodBeat.i(88057);
    pg localpg1;
    if (this.kno != null)
    {
      localpg1 = this.kno;
      AppMethodBeat.o(88057);
      return localpg1;
    }
    try
    {
      this.kno = ((pg)new pg().parseFrom(this.field_cardTpInfoData));
      localpg1 = this.kno;
      AppMethodBeat.o(88057);
      return localpg1;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.ShareCardInfo", "getCardTpInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ab.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      pg localpg2 = new pg();
      AppMethodBeat.o(88057);
      return localpg2;
    }
  }
  
  public final oj bbe()
  {
    AppMethodBeat.i(88059);
    oj localoj1;
    if (this.knp != null)
    {
      localoj1 = this.knp;
      AppMethodBeat.o(88059);
      return localoj1;
    }
    try
    {
      this.knp = ((oj)new oj().parseFrom(this.field_dataInfoData));
      localoj1 = this.knp;
      AppMethodBeat.o(88059);
      return localoj1;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.ShareCardInfo", "getDataInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ab.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      oj localoj2 = new oj();
      AppMethodBeat.o(88059);
      return localoj2;
    }
  }
  
  public final ccf bbf()
  {
    AppMethodBeat.i(88061);
    ccf localccf1;
    if (this.knq != null)
    {
      localccf1 = this.knq;
      AppMethodBeat.o(88061);
      return localccf1;
    }
    try
    {
      this.knq = ((ccf)new ccf().parseFrom(this.field_shareInfoData));
      localccf1 = this.knq;
      AppMethodBeat.o(88061);
      return localccf1;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.ShareCardInfo", "getShareInfo fail, ex = %s", new Object[] { localException.getMessage() });
      ab.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      ccf localccf2 = new ccf();
      AppMethodBeat.o(88061);
      return localccf2;
    }
  }
  
  public final oz bbg()
  {
    AppMethodBeat.i(88063);
    oz localoz;
    if (this.knr != null)
    {
      localoz = this.knr;
      AppMethodBeat.o(88063);
      return localoz;
    }
    try
    {
      this.knr = ((oz)new oz().parseFrom(this.field_shopInfoData));
      localoz = this.knr;
      AppMethodBeat.o(88063);
      return localoz;
    }
    catch (Exception localException)
    {
      ab.e("MicroMsg.ShareCardInfo", "getShopInfo fail ex = %s", new Object[] { localException.getMessage() });
      ab.printErrStackTrace("MicroMsg.ShareCardInfo", localException, "", new Object[0]);
      AppMethodBeat.o(88063);
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
    return "";
  }
  
  public final int bbm()
  {
    return this.field_categoryType;
  }
  
  public final String bbn()
  {
    AppMethodBeat.i(88070);
    ab.d("MicroMsg.ShareCardInfo", "encrypt_code:" + this.kmp);
    String str = this.kmp;
    AppMethodBeat.o(88070);
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
    AppMethodBeat.i(88054);
    if (!isNormal())
    {
      AppMethodBeat.o(88054);
      return false;
    }
    if (this.kno != null) {
      ab.i("MicroMsg.ShareCardInfo", "is_acceptable:" + this.kno.wGw);
    }
    ab.i("MicroMsg.ShareCardInfo", "stock_num:" + this.knp.wDV + " limit_num:" + this.knp.wDW);
    if ((this.kno != null) && (this.kno.wGw == 1))
    {
      AppMethodBeat.o(88054);
      return true;
    }
    if ((this.kno != null) && (this.kno.wGw == 0))
    {
      AppMethodBeat.o(88054);
      return false;
    }
    if ((this.knp.wDV == 0L) || (this.knp.wDW == 0))
    {
      AppMethodBeat.o(88054);
      return false;
    }
    AppMethodBeat.o(88054);
    return false;
  }
  
  public final boolean isNormal()
  {
    return (this.knp != null) && (this.knp.status == 0);
  }
  
  public final String sV(int paramInt)
  {
    AppMethodBeat.i(88069);
    String str;
    if (paramInt == 10)
    {
      str = (String)am.bci().getValue("key_share_card_local_city");
      AppMethodBeat.o(88069);
      return str;
    }
    if (paramInt == 0)
    {
      if (com.tencent.mm.plugin.card.sharecard.a.b.bcC())
      {
        str = ah.getResources().getString(2131298023);
        AppMethodBeat.o(88069);
        return str;
      }
      AppMethodBeat.o(88069);
      return "";
    }
    AppMethodBeat.o(88069);
    return "";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int i = 0;
    AppMethodBeat.i(88066);
    paramParcel.writeString(this.field_card_id);
    paramParcel.writeString(this.field_card_tp_id);
    paramParcel.writeString(this.field_from_username);
    paramParcel.writeInt(this.field_status);
    paramParcel.writeLong(this.field_share_time);
    paramParcel.writeLong(this.field_local_updateTime);
    paramParcel.writeLong(this.field_updateTime);
    paramParcel.writeLong(this.field_updateSeq);
    paramParcel.writeLong(this.field_block_mask);
    paramParcel.writeLong(this.field_end_time);
    paramParcel.writeInt(this.field_categoryType);
    paramParcel.writeInt(this.field_itemIndex);
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
    if (this.field_shopInfoData != null)
    {
      paramParcel.writeInt(this.field_shopInfoData.length);
      paramInt = i;
      while (paramInt < this.field_shopInfoData.length)
      {
        paramParcel.writeByte(this.field_shopInfoData[paramInt]);
        paramInt += 1;
      }
    }
    AppMethodBeat.o(88066);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.card.sharecard.model.ShareCardInfo
 * JD-Core Version:    0.7.0.1
 */